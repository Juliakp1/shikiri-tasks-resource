CREATE TABLE tasks
(
    id_task character varying(36) NOT NULL,
    ts_name character varying(256) NOT NULL,
    ts_description character varying(256) NOT NULL,
    ts_done character varying(2) NOT NULL,
    ts_tool character varying(36) NOT NULL,
    ts_board character varying(36) NOT NULL,
    CONSTRAINT task_pkey PRIMARY KEY (id_task)
);
