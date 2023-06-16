\c host_agent;
CREATE TABLE IF NOT EXISTS host_info
(
    id               SERIAL    NOT NULL,
    hostname         VARCHAR   NOT NULL,
    cpu_number       INT2      NOT NULL,
    cpu_architecture VARCHAR   NOT NULL,
    cpu_model        VARCHAR   NOT NULL,
    cpu_mhz          FLOAT8    NOT NULL,
    l2_cache         INT4      NOT NULL,
    "timestamp"      TIMESTAMP NULL,
    total_mem        INT4      NULL,
    CONSTRAINT host_info_pk PRIMARY KEY (id),
    CONSTRAINT host_info_un UNIQUE (hostname)
);
CREATE TABLE IF NOT EXISTS host_usage
(
    id               SERIAL    NOT NULL,
    hostname         VARCHAR   NOT NULL,
    cpu_number       INT2      NOT NULL,
    cpu_architecture VARCHAR   NOT NULL,
    cpu_model        VARCHAR   NOT NULL,
    cpu_mhz          FLOAT8    NOT NULL,
    l2_cache         INT4      NOT NULL,
    "timestamp"      TIMESTAMP NULL,
    total_mem        INT4      NULL,
    CONSTRAINT host_info_pk PRIMARY KEY (id),
    CONSTRAINT host_info_un UNIQUE (hostname)
);