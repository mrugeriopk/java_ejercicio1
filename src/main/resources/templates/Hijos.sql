-- Table: public.hijos

-- DROP TABLE IF EXISTS public.hijos;

CREATE TABLE IF NOT EXISTS public.hijos
(
    idrelacion integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    idusuario integer NOT NULL,
    idhijo integer NOT NULL,
    CONSTRAINT hijos_pkey PRIMARY KEY (idrelacion),
    CONSTRAINT fk FOREIGN KEY (idusuario)
        REFERENCES public.usuarios (idusuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.hijos
    OWNER to postgres;