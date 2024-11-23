SELECT f.id as facultyId,
    CONCAT(f.lastName, ", ", f.firstName) as facultyName,
    AVG(g.grade * c.units) / SUM(c.units) as averageGrade,
    SUM(IF(g.grade = 0.0, 1, 0)) as "00",
    SUM(IF(g.grade = 1.0, 1, 0)) as "10",
    SUM(IF(g.grade = 1.5, 1, 0)) as "15",
    SUM(IF(g.grade = 2.0, 1, 0)) as "20",
    SUM(IF(g.grade = 2.5, 1, 0)) as "25",
    SUM(IF(g.grade = 3.0, 1, 0)) as "30",
    SUM(IF(g.grade = 3.5, 1, 0)) as "35",
    SUM(IF(g.grade = 4.0, 1, 0)) as "40"
FROM faculty f
    JOIN sections s ON f.id = s.assignedFacultyId
    JOIN courses c ON s.courseCode = c.code
    JOIN grades g ON (
        s.sectionCode = g.sectionCode
        AND s.courseCode = g.courseCode
        AND s.termId = g.termId
    )
WHERE g.termId = ?
GROUP BY f.id;