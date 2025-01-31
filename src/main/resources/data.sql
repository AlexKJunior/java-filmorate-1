INSERT INTO genre (name)
SELECT * FROM (SELECT 'Комедия')
WHERE NOT EXISTS (
    SELECT name FROM genre WHERE name='Комедия'
) LIMIT 1;

INSERT INTO genre (name)
SELECT * FROM (SELECT 'Драма')
WHERE NOT EXISTS (
    SELECT name FROM genre WHERE name='Драма'
) LIMIT 1;

INSERT INTO genre (name)
SELECT * FROM (SELECT 'Мультфильм')
WHERE NOT EXISTS (
    SELECT name FROM genre WHERE name='Мультфильм'
) LIMIT 1;

INSERT INTO genre (name)
SELECT * FROM (SELECT 'Триллер')
WHERE NOT EXISTS (
    SELECT name FROM genre WHERE name='Триллер'
) LIMIT 1;

INSERT INTO genre (name)
SELECT * FROM (SELECT 'Документальный')
WHERE NOT EXISTS (
    SELECT name FROM genre WHERE name='Документальный'
) LIMIT 1;

INSERT INTO genre (name)
SELECT * FROM (SELECT 'Боевик')
WHERE NOT EXISTS (
    SELECT name FROM genre WHERE name='Боевик'
) LIMIT 1;

INSERT INTO MPA (name)
SELECT * FROM (SELECT 'G')
WHERE NOT EXISTS (
    SELECT name FROM MPA WHERE name='G'
) LIMIT 1;

INSERT INTO MPA (name)
SELECT * FROM (SELECT 'PG')
WHERE NOT EXISTS (
    SELECT name FROM MPA WHERE name='PG'
) LIMIT 1;

INSERT INTO MPA (name)
SELECT * FROM (SELECT 'PG-13')
WHERE NOT EXISTS (
    SELECT name FROM MPA WHERE name='PG-13'
) LIMIT 1;

INSERT INTO MPA (name)
SELECT * FROM (SELECT 'R')
WHERE NOT EXISTS (
    SELECT name FROM MPA WHERE name='R'
) LIMIT 1;

INSERT INTO MPA (name)
SELECT * FROM (SELECT 'NC-17')
WHERE NOT EXISTS (
    SELECT name FROM MPA WHERE name='NC-17'
) LIMIT 1;