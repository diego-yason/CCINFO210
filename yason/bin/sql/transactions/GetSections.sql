SELECT      courseCode, sectionCode
FROM        sections
WHERE       termId = (SELECT id 
                      FROM terms 
                      WHERE termStart <= NOW() 
                        AND termEnd >= NOW()
                      LIMIT 1)
  AND       courseCode = ?
  AND       status = ?
ORDER BY sectionCode;