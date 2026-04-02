CREATE DATABASE "Dev"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LOCALE_PROVIDER = 'libc'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

CREATE TABLE public.student
(
    sid integer NOT NULL,
    sname text,
    marks integer,
    PRIMARY KEY (side)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.student
    OWNER to postgres;

INSERT INTO public.student (sid, sname, marks) VALUES (1, 'Balaji', 33);

SELECT * FROM public.student ORDER BY sid ASC;


