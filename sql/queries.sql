INSERT INTO facilities VALUES
    (9, 'Spa', 20, 30, 100000, 800);


INSERT INTO facilities (facid, name, membercost, guestcost, initialoutlay, monthlymaintenance)
    SELECT (SELECT MAX(facid) FROM cd.facilities) +1, 'Spa', 20, 30, 100000, 800;


UPDATE facilities
SET  initialoutlay  = 10000
WHERE name = 'Tennis Court 2';


UPDATE facilities
SET
    membercost = (SELECT membercost FROM cd.facilities where name = 'Tennis Court 1') * 1.1,
    guestcost = (SELECT guestcost FROM cd.facilities where name = 'Tennis Court 1') * 1.1
WHERE name = 'Tennis Court 2';


DELETE FROM bookings;


DELETE FROM members
WHERE memid = 37;


SELECT
    FACID ,
    NAME ,
    MEMBERCOST ,
    MONTHLYMAINTENANCE
FROM
    FACILITIES
WHERE
        MEMBERCOST > 0
  AND
        MEMBERCOST < MONTHLYMAINTENANCE / 50;



SELECT
    *
FROM
    FACILITIES
WHERE
    NAME LIKE '%Tennis%';



SELECT
    *
FROM
    FACILITIES
WHERE
    FACID BETWEEN 1 AND 5;



SELECT
    MEMID,
    SURNAME,
    FIRSTNAME,
    JOINDATE
FROM
    MEMBERS
WHERE
    JOINDATE >= '2012-09-01';



SELECT
    SURNAME
FROM
    MEMBERS
UNION
SELECT
    NAME
FROM
    FACILITIES;



select
    starttime
from
    bookings
        inner join members
                   on
                           bookings.memid = members.memid
where
        members.firstname = 'David'
  and
        members.surname = 'Farrell';



select
    starttime,
    name
from
    bookings
        inner join
    facilities
    on
            bookings.facid = facilities.facid
where
        facilities.name like 'Tennis Court%'
  and
    bookings.starttime between '2012-09-21' and '2012-09-22'
order by
    bookings.starttime;



select
    mems.firstname as memfname,
    mems.surname as memsname,
    recs.firstname as recfname,
    recs.surname as recsname
from
    cd.members mems
left outer join
    cd.members recs
        on
            recs.memid = mems.recommendedby
order by
    memsname,
    memfname;


select
    distinct
    rec.firstname as fname,
    rec.surname as sname
from
    cd.members rec
        left join
    cd.members mem
    on
            rec.memid = mem.recommendedby
where
    mem.recommendedby is not null
order by
    sname,
    fname;



select
    distinct
        a.firstname || ' ' || a.surname as member,
        (
            select
                    b.firstname || ' ' || b.surname as recommender
            from
                cd.members as b
            where
                    b.memid = a.recommendedby
        )
from
    cd.members as a
order by
    member;



select
    recommendedby,
    COUNT(recommendedby)
from
    cd.members
where
    recommendedby is not null
group by
    recommendedby
order by
    recommendedby;



select
    facid,
    sum(slots) as "Total Slots"
from
    cd.bookings
group by
    facid
order by
    facid;



select
    FACID,
    SUM(SLOTS) as "Total Slots"
from
    cd.bookings
where
    STARTTIME between '2012-09-01' and '2012-10-01'
group by
    FACID
order by
    "Total Slots";



select
    FACID,
    extract(month
            from
            STARTTIME) as month,
			SUM(SLOTS) as "TOTAL SLOTS"
from
    cd.bookings
where
    extract(year
    from
    STARTTIME) = 2012
group by
    FACID,
    month
order by
    FACID,
    month;



select
    COUNT(distinct memid)
from
    cd.bookings;


select
    surname,
    firstname,
    mem.memid,
    min(bk.starttime) as starttime
from
    cd.members as mem
        inner join
    cd.bookings as bk
    on
            mem.memid = bk.memid
where
        starttime >= '2012-09-01'
group by
    surname,
    firstname,
    mem.memid
order by
    mem.memid



select
    count(*) over(),
        firstname,
    surname
from
    cd.members
order by
    joindate;



select
    row_number() over(
	order by JOINDATE),
        firstname,
    surname
from
    cd.members


select
    facid,
    total
from
    (
        select
            facid,
            sum(slots) total,
            rank() over(
		order by sum(slots) desc) rank
        from
            cd.bookings
        group by
            facid
    ) as ranked
where
        rank = 1;