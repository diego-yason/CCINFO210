SELECT      f.id, f.firstName, f.lastName, f.department
FROM        courses c   JOIN departments d ON c.department = d.name
                        JOIN faculty f ON d.name = f.department
WHERE       c.code = ?
ORDER BY    f.id;