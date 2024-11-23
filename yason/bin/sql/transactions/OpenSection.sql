INSERT INTO sections (courseCode, sectionCode, assignedFacultyId, termId, status)
VALUES (?, ?, ?, (
    SELECT id
    FROM terms
    WHERE termStart <= NOW() AND termEnd >= NOW()
    LIMIT 1
), 'O');