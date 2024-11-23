INSERT INTO ref_grades(grade)
VALUES (0),
(1.0),
(1.5),
(2.0),
(2.5),
(3.0),
(3.5),
(4.0);
INSERT INTO ref_degree_type(type)
VALUES ("BS"),
    ("BA"),
    ("BFA"),
    ("MS"),
    ("MA"),
    ("MBA"),
    ("PhD"),
    ("DBA"),
("JD");
INSERT INTO ref_colleges(name)
VALUES ("College of Computer Studies"),
    ("College of Science"),
    ("Gokongwei College of Engineering"),
    ("School of Economics"),
    ("Ramon V. del Rosario College of Business"),
    ("Tanada-Diokno School of Law"),
    (
        "Brother Andrew Gonzalez FSC College of Education"
    ),
    ("College of Liberal Arts");
INSERT INTO terms(id, termStart, termEnd)
VALUES ("124A", "2024-08-31", "2024-12-14"),
    ("124B", "2024-01-04", "2024-05-02"),
    ("123A", "2023-09-04", "2023-12-11"),
    ("123B", "2024-01-08", "2024-04-16"),
    ("123C", "2024-05-02", "2024-08-09"),
    ("122A", "2022-09-05", "2022-12-17"),
    ("122B", "2023-01-16", "2023-04-22"),
    ("122C", "2023-05-08", "2023-08-12");
INSERT INTO departments (name, college)
VALUES (
        'Software Technology',
        'College of Computer Studies'
    ),
    (
        'Information Technology',
        'College of Computer Studies'
    ),
    (
        'Computer Technology',
        'College of Computer Studies'
    ),
    (
        'Accountancy',
        'Ramon V. del Rosario College of Business'
    ),
    (
        'Civil Engineering',
        'Gokongwei College of Engineering'
    ),
    (
        'Mechanical Engineering',
        'Gokongwei College of Engineering'
    ),
    (
        'Computer Engineering',
        'Gokongwei College of Engineering'
    ),
    (
        'Electrical Engineering',
        'Gokongwei College of Engineering'
    ),
    (
        'Entrepreneurship',
        'Ramon V. del Rosario College of Business'
    ),
    (
        'Marketing',
        'Ramon V. del Rosario College of Business'
    ),
    ('Law', 'Tanada-Diokno School of Law'),
    (
        'Education',
        'Brother Andrew Gonzalez FSC College of Education'
    ),
    ('History', 'College of Liberal Arts'),
    ('Literature', 'College of Liberal Arts'),
    ('Behavioral Sciences', 'College of Liberal Arts');
INSERT INTO degrees (id, name, type, college)
VALUES (
        'CS-ST',
        'Computer Science, Major in Software Technology',
        'BS',
        'College of Computer Studies'
    ),
    (
        'CS-IS',
        'Computer Science, Major in Information Systems',
        'BS',
        'College of Computer Studies'
    ),
    (
        'CS-CSE',
        'Computer Science, Major in Computer Systems Engineering',
        'BS',
        'College of Computer Studies'
    ),
    (
        'BSA',
        'Accountancy',
        'BS',
        'Ramon V. del Rosario College of Business'
    ),
    (
        'CVE',
        'Civil Engineering',
        'BS',
        'Gokongwei College of Engineering'
    ),
    (
        'ME',
        'Mechanical Engineering',
        'BS',
        'Gokongwei College of Engineering'
    ),
    (
        'CE',
        'Computer Engineering',
        'BS',
        'Gokongwei College of Engineering'
    ),
    (
        'EE',
        'Electrical Engineering',
        'BS',
        'Gokongwei College of Engineering'
    ),
    (
        'ENT',
        'Entrepreneurship',
        'BS',
        'Ramon V. del Rosario College of Business'
    ),
    (
        'MKT',
        'Marketing',
        'BS',
        'Ramon V. del Rosario College of Business'
    ),
    (
        'JD',
        'Juris Doctor',
        'JD',
        'Tanada-Diokno School of Law'
    ),
    (
        'LSSD',
        'Legal Studies and Sustainable Development',
        'BA',
        'Tanada-Diokno School of Law'
    ),
    (
        'PE',
        'Physical Education',
        'BS',
        'Brother Andrew Gonzalez FSC College of Education'
    ),
    (
        'SE',
        'Science Education',
        'BS',
        'Brother Andrew Gonzalez FSC College of Education'
    ),
    (
        'EAL',
        'English and Applied Linguistics',
        'BS',
        'Brother Andrew Gonzalez FSC College of Education'
    );
INSERT INTO faculty (id, firstName, lastName, department)
VALUES (99912345, 'John', 'Doe', 'Software Technology'),
    (
        99923456,
        'Jane',
        'Smith',
        'Information Technology'
    ),
    (
        99934567,
        'Alice',
        'Johnson',
        'Computer Technology'
    ),
    (99945678, 'Bob', 'Brown', 'Software Technology'),
    (99956789, 'Charlie', 'Davis', 'Accountancy'),
    (99967890, 'Emily', 'Clark', 'Civil Engineering'),
    (
        99978901,
        'Frank',
        'Evans',
        'Mechanical Engineering'
    ),
    (
        99989012,
        'Grace',
        'Harris',
        'Computer Engineering'
    ),
    (
        99990123,
        'Hank',
        'Jackson',
        'Electrical Engineering'
    ),
    (99901234, 'Ivy', 'King', 'Entrepreneurship'),
    (99912346, 'Jack', 'Lee', 'Marketing'),
    (99923457, 'Karen', 'Martinez', 'Law'),
    (99934568, 'Leo', 'Nelson', 'Education'),
    (99945679, 'Mia', 'Owen', 'Software Technology'),
    (
        99956780,
        'Nina',
        'Perez',
        'Information Technology'
    ),
    (
        99967891,
        'Oscar',
        'Quinn',
        'Computer Technology'
    ),
    (99978902, 'Paul', 'Roberts', 'Accountancy'),
    (99989013, 'Quinn', 'Scott', 'Civil Engineering'),
    (
        99990124,
        'Rita',
        'Taylor',
        'Mechanical Engineering'
    ),
    (99901235, 'Sam', 'Upton', 'Computer Engineering'),
    (
        99912347,
        'Tina',
        'Vasquez',
        'Electrical Engineering'
    ),
    (99923458, 'Uma', 'White', 'Entrepreneurship'),
    (99934569, 'Victor', 'Xavier', 'Marketing'),
    (99945680, 'Wendy', 'Young', 'Law'),
    (99956781, 'Xander', 'Zimmerman', 'Education'),
    (99967892, 'Yara', 'Adams', 'Software Technology'),
    (
        99978903,
        'Zane',
        'Baker',
        'Information Technology'
    ),
    (99989014, 'Amy', 'Carter', 'Computer Technology'),
    (99990125, 'Brian', 'Diaz', 'Accountancy'),
    (
        99901236,
        'Cathy',
        'Edwards',
        'Civil Engineering'
    ),
    (
        99912348,
        'David',
        'Foster',
        'Mechanical Engineering'
    ),
    (
        99923459,
        'Eva',
        'Garcia',
        'Computer Engineering'
    ),
    (
        99934570,
        'Fred',
        'Hill',
        'Electrical Engineering'
    ),
    (99945681, 'Gina', 'Ingram', 'Entrepreneurship'),
    (99956782, 'Holly', 'Johnson', 'Marketing'),
    (99967893, 'Ian', 'Keller', 'Law'),
    (99978904, 'Jill', 'Lewis', 'Education'),
    (
        99989015,
        'Kyle',
        'Morris',
        'Software Technology'
    ),
    (
        99990126,
        'Liam',
        'Nelson',
        'Information Technology'
    ),
    (99901237, 'Mona', 'Owens', 'Computer Technology'),
    (99912349, 'Nate', 'Parker', 'Accountancy'),
    (99923460, 'Olivia', 'Quinn', 'Civil Engineering'),
    (
        99934571,
        'Pete',
        'Reed',
        'Mechanical Engineering'
    );
INSERT INTO courses (code, name, units, academic, department)
VALUES -- Software Technology
    (
        'CCPROG1',
        'Introduction to Software Technology',
        3,
        "T",
        'Software Technology'
    ),
    (
        'CCPROG2',
        'Advanced Software Development',
        3,
        "T",
        'Software Technology'
    ),
    (
        'CCPROG3',
        'Software Project Management',
        3,
        "T",
        'Software Technology'
    ),
    (
        'CCTESTS',
        'Software Testing and Quality Assurance',
        3,
        "T",
        'Software Technology'
    ),
    (
        'CCSWENG',
        'Software Engineering',
        3,
        "T",
        'Software Technology'
    ),
    -- Information Technology
    (
        'CCICOMP',
        'Introduction to Information Technology',
        3,
        "T",
        'Information Technology'
    ),
    (
        'CCINFOM',
        'Database Management Systems',
        3,
        "T",
        'Information Technology'
    ),
    (
        'ITNETWK',
        'Network and Security',
        3,
        "T",
        'Information Technology'
    ),
    (
        'ITWBDEV',
        'Web Development',
        3,
        "T",
        'Information Technology'
    ),
    (
        'ITPROJM',
        'IT Project Management',
        3,
        "T",
        'Information Technology'
    ),
    -- Computer Technology
    (
        'CTTECH1',
        'Introduction to Computer Technology',
        3,
        "T",
        'Computer Technology'
    ),
    (
        'CTTECH2',
        'Computer Hardware Fundamentals',
        3,
        "T",
        'Computer Technology'
    ),
    (
        'CTTECH3',
        'Computer Architecture',
        3,
        "T",
        'Computer Technology'
    ),
    (
        'CTTECH4',
        'Operating Systems',
        3,
        "T",
        'Computer Technology'
    ),
    (
        'CTCMSEC',
        'Computer Security',
        3,
        "T",
        'Computer Technology'
    ),
    -- Accountancy
    (
        'FNDACCT',
        'Introduction to Accountancy',
        3,
        "T",
        'Accountancy'
    ),
    (
        'FINACCT',
        'Financial Accounting',
        3,
        "T",
        'Accountancy'
    ),
    (
        'MGMACCT',
        'Managerial Accounting',
        3,
        "T",
        'Accountancy'
    ),
    ('TAXACCT', 'Taxation', 3, "T", 'Accountancy'),
    ('AUDACCT', 'Auditing', 3, "T", 'Accountancy'),
    -- Civil Engineering
    (
        'CIVL101',
        'Introduction to Civil Engineering',
        3,
        "T",
        'Civil Engineering'
    ),
    (
        'STRUCTA',
        'Structural Analysis',
        3,
        "T",
        'Civil Engineering'
    ),
    (
        'GEOENGR',
        'Geotechnical Engineering',
        3,
        "T",
        'Civil Engineering'
    ),
    (
        'HYDROLS',
        'Hydraulics',
        3,
        "T",
        'Civil Engineering'
    ),
    (
        'TRANENG',
        'Transportation Engineering',
        3,
        "T",
        'Civil Engineering'
    ),
    -- Mechanical Engineering
    (
        'MECH101',
        'Introduction to Mechanical Engineering',
        3,
        "T",
        'Mechanical Engineering'
    ),
    (
        'THERMO1',
        'Thermodynamics',
        3,
        "T",
        'Mechanical Engineering'
    ),
    (
        'FLUIDSM',
        'Fluid Mechanics',
        3,
        "T",
        'Mechanical Engineering'
    ),
    (
        'THERMO2',
        'Heat Transfer',
        3,
        "T",
        'Mechanical Engineering'
    ),
    (
        'MACHDES',
        'Machine Design',
        3,
        "T",
        'Mechanical Engineering'
    ),
    -- Computer Engineering
    (
        'CMPENG1',
        'Introduction to Computer Engineering',
        3,
        "T",
        'Computer Engineering'
    ),
    (
        'CMPENG2',
        'Digital Logic Design',
        3,
        "T",
        'Computer Engineering'
    ),
    (
        'CMPENG3',
        'Microprocessors',
        3,
        "T",
        'Computer Engineering'
    ),
    (
        'CENETWK',
        'Computer Networks',
        3,
        "T",
        'Computer Engineering'
    ),
    (
        'VLSIDES',
        'VLSI Design',
        3,
        "T",
        'Computer Engineering'
    ),
    -- Electrical Engineering
    (
        'INTROEE',
        'Introduction to Electrical Engineering',
        3,
        "T",
        'Electrical Engineering'
    ),
    (
        'CIRCSEE',
        'Circuit Analysis',
        3,
        "T",
        'Electrical Engineering'
    ),
    (
        'MAGNTEE',
        'Electromagnetics',
        3,
        "T",
        'Electrical Engineering'
    ),
    (
        'POWEREE',
        'Power Systems',
        3,
        "T",
        'Electrical Engineering'
    ),
    (
        'CTRLSEE',
        'Control Systems',
        3,
        "T",
        'Electrical Engineering'
    ),
    -- Entrepreneurship
    (
        'ENTREP1',
        'Introduction to Entrepreneurship',
        3,
        "T",
        'Entrepreneurship'
    ),
    (
        'ENTREP2',
        'Business Planning',
        3,
        "T",
        'Entrepreneurship'
    ),
    (
        'ENTCRE8',
        'Innovation and Creativity',
        3,
        "T",
        'Entrepreneurship'
    ),
    (
        'FINAENT',
        'Entrepreneurial Finance',
        3,
        "T",
        'Entrepreneurship'
    ),
    (
        'MRKTENT',
        'Marketing for Entrepreneurs',
        3,
        "T",
        'Entrepreneurship'
    ),
    -- Marketing
    (
        'FNDMRKT',
        'Introduction to Marketing',
        3,
        "T",
        'Marketing'
    ),
    (
        'CONSUME',
        'Consumer Behavior',
        3,
        "T",
        'Marketing'
    ),
    (
        'MARKETS',
        'Marketing Research',
        3,
        "T",
        'Marketing'
    ),
    (
        'DIGITAL',
        'Digital Marketing',
        3,
        "T",
        'Marketing'
    ),
    (
        'BRNDING',
        'Brand Management',
        3,
        "T",
        'Marketing'
    ),
    -- Law
    ('INTRO2L', 'Introduction to Law', 3, "T", 'Law'),
    ('CONSTIL', 'Constitutional Law', 3, "T", 'Law'),
    ('CRIMINL', 'Criminal Law', 3, "T", 'Law'),
    ('CIVLPRO', 'Civil Law', 3, "T", 'Law'),
    ('COMMERL', 'Commercial Law', 3, "T", 'Law'),
    -- Education
    (
        'WELEDUC',
        'Introduction to Education',
        3,
        "T",
        'Education'
    ),
    (
        'EDUPSYC',
        'Educational Psychology',
        3,
        "T",
        'Education'
    ),
    (
        'CURRICD',
        'Curriculum Development',
        3,
        "T",
        'Education'
    ),
    (
        'INSTRCT',
        'Instructional Strategies',
        3,
        "T",
        'Education'
    ),
    (
        'CLASSRM',
        'Classroom Management',
        3,
        "T",
        'Education'
    ),
    -- Lab Courses
    (
        'LBSCRUM',
        'Software SCRUMing',
        2,
        "T",
        'Software Technology'
    ),
    (
        'LBDEPLY',
        'Software Deployment',
        2,
        "T",
        'Software Technology'
    ),
    (
        'LBYLOGI',
        'Logic Gates',
        2,
        "T",
        'Computer Technology'
    ),
    (
        'LBOPSYS',
        'Operating Systems',
        2,
        "T",
        'Computer Technology'
    ),
    (
        'LBYDLDL',
        'Digital Logic Design Lab',
        2,
        "T",
        'Computer Engineering'
    ),
    (
        'LBMICRO',
        'Microprocessor Systems Lab',
        2,
        "T",
        'Computer Engineering'
    ),
    (
        'LBCIRCT',
        'Circuit Analysis Lab',
        2,
        "T",
        'Electrical Engineering'
    ),
    (
        'LBPOSYS',
        'Power Systems Lab',
        2,
        "T",
        'Electrical Engineering'
    ),
    -- General Education
    (
        "GERIZAL",
        "Ang Buhay at Ang Mga Akda ni Rizal",
        3.0,
        "T",
        "History"
    ),
    (
        "GESTSOC",
        "Science Technology and The Society",
        3.0,
        "T",
        "Behavioral Sciences"
    ),
    (
        "GEARTAP",
        "Art Appreciation",
        3.0,
        "T",
        "Literature"
    ),
    (
        'KASPIL',
        'Buhay, mga sinulat at nagawa ni Dr. Jose P. Rizal ',
        3.0,
        'T',
        'Literature'
    ),
    (
        'HUMAART',
        'Introduction to the Elements and Principles of Art',
        3.0,
        'T',
        'Literature'
    ),
    (
        'HUMALIT',
        'Human Literature',
        3.0,
        'T',
        'Literature'
    ),
    (
        'GELITPH',
        'Literature of the Philippines',
        3.0,
        'T',
        'Literature'
    ),
    (
        'GELECAH',
        'Introduction to the Elements and Principles of Art',
        3.0,
        'T',
        'Literature'
    ),
    (
        'GELECSP',
        'Social Science/Philosophy Elective',
        3.0,
        'T',
        'Literature'
    ),
    (
        'LCFILIA',
        'Filipinolohiya and Philippine Studies',
        3.0,
        'T',
        'Literature'
    ),
    (
        'GELECST',
        'General Education Science and Technology Elective',
        3.0,
        'T',
        'Literature'
    ),
    (
        'LCFILIB',
        'Komunikasyon ng Pananaliksik',
        3.0,
        'T',
        'Literature'
    );
INSERT INTO course_equivalences (courseCode1, courseCode2)
VALUES ('KASPIL', 'GERIZAL'),
    ('HUMAART', 'GEARTAP'),
    ('HUMALIT', 'GELITPH'),
    ('GELITPH', 'GELECAH'),
    ('GELECSP', 'LCFILIA'),
    ('GELECST', 'LCFILIB');
INSERT INTO students (id, firstName, lastName, degreeProgram)
VALUES (12345678, 'Michael', 'Jordan', 'CS-ST'),
    (12345679, 'LeBron', 'James', 'CS-IS'),
    (12345680, 'Kobe', 'Bryant', 'CS-CSE'),
    (12345681, 'Shaquille', 'ONeal', 'BSA'),
    (12345682, 'Tim', 'Duncan', 'CVE'),
    (12345683, 'Kevin', 'Garnett', 'ME'),
    (12345684, 'Dirk', 'Nowitzki', 'CE'),
    (12345685, 'Paul', 'Pierce', 'EE'),
    (12345686, 'Allen', 'Iverson', 'ENT'),
    (12345687, 'Dwyane', 'Wade', 'MKT'),
    (12345688, 'Stephen', 'Curry', 'JD'),
    (12345689, 'James', 'Harden', 'LSSD'),
    (12345690, 'Russell', 'Westbrook', 'PE'),
    (12345691, 'Kawhi', 'Leonard', 'SE'),
    (12345692, 'Anthony', 'Davis', 'EAL'),
    (12345693, 'Damian', 'Lillard', 'CS-ST'),
    (12345694, 'Giannis', 'Antetokounmpo', 'CS-IS'),
    (12345695, 'Joel', 'Embiid', 'CS-CSE');
INSERT INTO sections (
        courseCode,
        sectionCode,
        termId,
        assignedFacultyId,
        status
    )
VALUES -- Software Technology
    ('CCPROG1', 'S11', "124A", 99912345, 'O'),
    ('CCPROG1', 'S12', "124A", 99945678, 'O'),
    ('CCPROG1', 'S13', "124A", 99945679, 'O'),
    ('CCPROG1', 'S14', "124A", 99989015, 'O'),
    ('CCPROG1', 'S15', "124A", 99967892, 'O'),
    ('CCPROG2', 'S11', "124B", 99912345, 'O'),
    ('CCPROG2', 'S12', "124B", 99945678, 'O'),
    ('CCPROG2', 'S13', "124B", 99945679, 'O'),
    ('CCPROG2', 'S14', "124B", 99989015, 'O'),
    ('CCPROG2', 'S15', "124B", 99967892, 'O'),
    -- ...repeat for other courses in Software Technology...
    -- Information Technology
    ('CCICOMP', 'S11', "124A", 99923456, 'O'),
    ('CCICOMP', 'S12', "124A", 99956780, 'O'),
    ('CCICOMP', 'S13', "124A", 99978903, 'O'),
    ('CCICOMP', 'S14', "124A", 99990126, 'O'),
    ('CCICOMP', 'S15', "124A", 99923456, 'O'),
    ('CCINFOM', 'S11', "124B", 99923456, 'O'),
    ('CCINFOM', 'S12', "124B", 99956780, 'O'),
    ('CCINFOM', 'S13', "124B", 99978903, 'O'),
    ('CCINFOM', 'S14', "124B", 99990126, 'O'),
    ('CCINFOM', 'S15', "124B", 99923456, 'O');
-- ...repeat for other courses in Information Technology...
SELECT *
FROM grades;
SET SQL_SAFE_UPDATES = 0;
DELETE FROM grades
WHERE courseCode = "CCPROG2";
INSERT INTO holidays (name, date)
VALUES ('New Years Day', '2024-01-01'),
    ('Independence Day', '2024-06-12'),
    ('Christmas Day', '2024-12-25'),
    ('Labor Day', '2024-05-01'),
    ('All Saints Day', '2024-11-01'),
    ('All Souls Day', '2024-11-02');
select *
from holidays;