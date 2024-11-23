UPDATE sections
SET status = 'C'
WHERE courseCode = ? 
    AND sectionCode = ? 
    AND termId = (SELECT id 
                  FROM terms 
                  WHERE termStart <= NOW() 
                    AND termEnd >= NOW()
                  LIMIT 1);