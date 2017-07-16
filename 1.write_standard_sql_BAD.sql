SELECT
  u.name AS name,
  DECODE(u.sex, 0, 'male', 1, 'female') AS sex
FROM
  user as u
WHERE
  u.id = 1
