UPDATE sections
SET status = ?, assignedFacultyId = ?
WHERE courseCode = ? AND sectionCode = ? AND termsId = ?;