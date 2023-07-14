# Introduction
The goal of the RDBMS and SQL project was to assist a company in understanding how they can extract information from their database regarding usage of facilities by their clientele. The technologies used to develop this project are PSQL queries to extract information, a PostgreSQL database that maintained all details in relation to the company and Docker to manage the deployment of the PostgreSQL database. Git and GitHub were used for version control.

# SQL Queries

###### Table Setup (DDL)

```sql
CREATE TABLE IF NOT EXISTS members (
                                       memid INTEGER NOT NULL,
                                       surname VARCHAR(200) NOT NULL,
                                       firstname VARCHAR(200) NOT NULL,
                                       address VARCHAR(300) NOT NULL,
                                       zipcode INTEGER NOT NULL,
                                       telephone VARCHAR(20) NOT NULL,
                                       recommendedby INTEGER,
                                       joindate TIMESTAMP NOT NULL,
                                       CONSTRAINT members_pk PRIMARY KEY (memid),
                                       CONSTRAINT fk_members_recommendedby FOREIGN KEY (recommendedby) REFERENCES members(memid) ON DELETE
                                           SET
                                           NULL
);

CREATE TABLE IF NOT EXISTS bookings (
                                        bookingid INTEGER NOT NULL,
                                        facid INTEGER NOT NULL,
                                        memid INTEGER NOT NULL,
                                        starttime TIMESTAMP NOT NULL,
                                        slots INTEGER NOT NULL,
                                        CONSTRAINT bookings_pk PRIMARY KEY (bookingid),
                                        CONSTRAINT fk_bookings_facid FOREIGN KEY (facid) REFERENCES facilities(facid),
                                        CONSTRAINT fk_bookings_memid FOREIGN KEY (memid) REFERENCES members(memid)
);

CREATE TABLE IF NOT EXISTS facilities (
                                          facid int NOT NULL,
                                          name varchar(100),
                                          membercost numeric,
                                          guestcost numeric,
                                          initialoutlay numeric,
                                          monthlymaintenance numeric,
                                          CONSTRAINT facilities_pk PRIMARY KEY (facid)
);
  
```


###### Question 1: Insert data into a table
```sql
INSERT INTO facilities
VALUES
    (9, 'Spa', 20, 30, 100000, 800);
```

###### Question 2: Insert calculated data into a table
```sql
INSERT INTO facilities (
    facid, name, membercost, guestcost,
    initialoutlay, monthlymaintenance
)
SELECT
        (
            SELECT
                MAX(facid)
            FROM
                facilities
        ) + 1,
        'Spa',
        20,
        30,
        100000,
        800;
```

###### Question 3: Update some existing data
```sql
UPDATE
    facilities
SET
    initialoutlay = 10000
WHERE
        name = 'Tennis Court 2';
```

###### Question 4: Update a row based on the contents of another row
```sql
UPDATE
    facilities
SET
    membercost = (
                     SELECT
                         membercost
                     FROM
                         facilities
                     where
                             name = 'Tennis Court 1'
                 ) * 1.1,
    guestcost = (
                    SELECT
                        guestcost
                    FROM
                        facilities
                    where
                            name = 'Tennis Court 1'
                ) * 1.1
WHERE
        name = 'Tennis Court 2';
```

###### Question 5: Delete all bookings
```sql
DELETE FROM
    bookings;
```

###### Question 6: Delete a member from the members table
```sql
DELETE FROM
    members
WHERE
        memid = 37;
```

###### Question 7: Control which rows are retrieved - part 2
```sql
SELECT
    FACID,
    NAME,
    MEMBERCOST,
    MONTHLYMAINTENANCE
FROM
    FACILITIES
WHERE
        MEMBERCOST > 0
  AND MEMBERCOST < MONTHLYMAINTENANCE / 50;


SELECT
    *
FROM
    FACILITIES
WHERE
        NAME LIKE '%Tennis%';
```

###### Question 8: Basic string searches
```sql
SELECT
    *
FROM
    FACILITIES
WHERE
        NAME LIKE '%Tennis%';
```

###### Question 9: Matching against multiple possible values
```sql
SELECT
    *
FROM
    facilities
WHERE
    facid IN (1, 5);
```

###### Question 10: Working with dates
```sql
SELECT
    MEMID,
    SURNAME,
    FIRSTNAME,
    JOINDATE
FROM
    MEMBERS
WHERE
        JOINDATE >= '2012-09-01';
```

###### Question 11: Combining results from multiple queries
```sql
SELECT
    SURNAME
FROM
    MEMBERS
UNION
SELECT
    NAME
FROM
    FACILITIES;
```

###### Question 12: Retrieve the start times of members' bookings
```sql
select
    starttime
from
    bookings
        inner join members on bookings.memid = members.memid
where
        members.firstname = 'David'
  and members.surname = 'Farrell';
```

###### Question 13: Work out the start times of bookings for tennis courts
```sql
select
    starttime,
    name
from
    bookings
        inner join facilities on bookings.facid = facilities.facid
where
        facilities.name like 'Tennis Court%'
  and bookings.starttime between '2012-09-21'
    and '2012-09-22'
order by
    bookings.starttime;
```

###### Question 14: Produce a list of all members, along with their recommender
```sql
select
    mems.firstname as memfname,
    mems.surname as memsname,
    recs.firstname as recfname,
    recs.surname as recsname
from
    members mems
        left outer join members recs on recs.memid = mems.recommendedby
order by
    memsname,
    memfname;
```

###### Question 15: Produce a list of all members who have recommended another member
```sql
select
    distinct rec.firstname as fname,
             rec.surname as sname
from
    members rec
        left join members mem on rec.memid = mem.recommendedby
where
    mem.recommendedby is not null
order by
    sname,
    fname;
```

###### Question 16: Produce a list of all members, along with their recommender, using no joins.
```sql
select
    distinct a.firstname || ' ' || a.surname as member,
             (
                 select
                             b.firstname || ' ' || b.surname as recommender
                 from
                     members as b
                 where
                         b.memid = a.recommendedby
             )
from
    members as a
order by
    member;
```

###### Question 17: Count the number of recommendations each member makes.
```sql
select
    recommendedby,
    COUNT(recommendedby)
from
    members
where
    recommendedby is not null
group by
    recommendedby
order by
    recommendedby;
```

###### Question 18: List the total slots booked per facility
```sql
select
    facid,
    sum(slots) as "Total Slots"
from
    bookings
group by
    facid
order by
    facid;
```

###### Question 19: List the total slots booked per facility in a given month
```sql
select
    FACID,
    SUM(SLOTS) as "Total Slots"
from
    bookings
where
    STARTTIME between '2012-09-01'
        and '2012-10-01'
group by
    FACID
order by
    "Total Slots";
```

###### Question 20: List the total slots booked per facility per month
```sql
select
    FACID,
    extract(
            month
            from
            STARTTIME
        ) as month,
    SUM(SLOTS) as "TOTAL SLOTS"
from
    bookings
where
        extract(
                year
                from
                STARTTIME
            ) = 2012
group by
    FACID,
    month
order by
    FACID,
    month;
```

###### Question 21: Find the count of members who have made at least one booking
```sql
select
    COUNT(distinct memid)
from
    bookings;
```

###### Question 22: List each member's first booking after September 1st 2012
```sql
select
    surname,
    firstname,
    mem.memid,
    min(bk.starttime) as starttime
from
    members as mem
        inner join bookings as bk on mem.memid = bk.memid
where
        starttime >= '2012-09-01'
group by
    surname,
    firstname,
    mem.memid
order by
    mem.memid;
```

###### Question 23: Produce a list of member names, with each row containing the total member count
```sql
select
            count(*) over(),
            firstname,
            surname
from
    members
order by
    joindate;
```

###### Question 24: Produce a numbered list of members
```sql
select
            row_number() over(
        order by
            JOINDATE
        ),
            firstname,
            surname
from
    members;
```

###### Question 25: Output the facility id that has the highest number of slots booked, again
```sql
select
    facid,
    total
from
    (
        select
            facid,
            sum(slots) total,
            rank() over(
                order by
                    sum(slots) desc
                ) rank
        from
            bookings
        group by
            facid
    ) as ranked
where
        rank = 1;
```

###### Question 26: Format the names of members
```sql
select
            surname || ', ' || firstname
from
    members;
```

###### Question 27: Find telephone numbers with parentheses
```sql
select
    memid,
    telephone
from
    members
where
        telephone ~ '[()]';
```

###### Question 28: Count the number of members whose surname starts with each letter of the alphabet
```sql
select
    SUBSTRING(surname, 1, 1) as letter,
    count(*)
from
    members
group by
    letter
order by
    letter;
```