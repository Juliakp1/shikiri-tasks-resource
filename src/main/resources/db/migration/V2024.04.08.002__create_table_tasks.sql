CREATE TABLE tasks
(
    id_task character varying(36) NOT NULL,
    ts_name character varying(256) NOT NULL,
    ts_description character varying(256) NOT NULL,
    ts_done character varying(2) NOT NULL,
    ts_toolId character varying(36),
    ts_boardId character varying(36) NOT NULL,
    CONSTRAINT tasks_pkey PRIMARY KEY (id_task)
);
