CREATE TABLE account
(
    id_task character varying(36) NOT NULL,
    ts_name character varying(256) NOT NULL,
    ts_description character varying(256) NOT NULL,
    ts_done character varying(2) NOT NULL,
    id_user character varying(36) NOT NULL,
    CONSTRAINT account_pkey PRIMARY KEY (id_account)
);
