SELECT
  u.name AS name,
  CASE u.sex
  WHEN 0
    THEN 'male'
  WHEN 1
    THEN 'female'
  END AS sex
FROM
  user as u
WHERE
  u.id = 1
