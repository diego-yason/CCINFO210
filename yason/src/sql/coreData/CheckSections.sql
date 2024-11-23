SELECT      COUNT(s.sectionCode) AS classCount
FROM        faculty f JOIN sections s ON f.id = s.assignedFacultyId
WHERE       f.id = ? AND NOT s.status = 'D'
GROUP BY    f.id;