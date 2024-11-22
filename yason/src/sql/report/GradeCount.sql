SELECT      COUNT(g.grade)
FROM        faculty f   JOIN sections s    ON f.id = s.assignedFacultyId
                        JOIN grades g      ON (s.sectionCode = g.sectionCode AND
                                               s.courseCode = g.courseCode AND
                                               s.termId = g.termId)
GROUP BY    f.id
WHERE       g.grade = ?;