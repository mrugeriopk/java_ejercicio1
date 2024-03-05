-- Table: public.usuarios

--DROP TABLE IF EXISTS public.usuarios;

CREATE TABLE IF NOT EXISTS public.usuarios
(
    idusuario integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 100000 CACHE 1 ),
    nombre character varying(255) COLLATE pg_catalog."default" NOT NULL,
    apellidop character varying(250) COLLATE pg_catalog."default" NOT NULL,
    apellidom character varying(250) COLLATE pg_catalog."default" NOT NULL,
    anionacimiento integer,
    direccion character varying(250) COLLATE pg_catalog."default",
    telefono character varying(10) COLLATE pg_catalog."default",
    correo character varying(250) COLLATE pg_catalog."default" NOT NULL,
    edad integer NOT NULL,
    idhijo bigint,
    CONSTRAINT usuarios_pkey PRIMARY KEY (idusuario),
    CONSTRAINT nombre_unique UNIQUE (nombre)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usuarios
    OWNER to postgres;