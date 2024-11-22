INSERT INTO degrees (id, name, type, college)
VALUES
('CS-ST', 'Computer Science, Major in Software Technology', 'BS', 'College of Computer Studies'),
('CS-IS', 'Computer Science, Major in Information Systems', 'BS', 'College of Computer Studies'),
('CS-CSE', 'Computer Science, Major in Computer Systems Engineering', 'BS', 'College of Computer Studies'),
('BSA', 'Accountancy', 'BS', 'Ramon V. del Rosario College of Business'),
('CVE', 'Civil Engineering', 'BS', 'Gokongwei College of Engineering'),
('ME', 'Mechanical Engineering', 'BS', 'Gokongwei College of Engineering'),
('CE', 'Computer Engineering', 'BS', 'Gokongwei College of Engineering'),
('EE', 'Electrical Engineering', 'BS', 'Gokongwei College of Engineering'),
('ENT', 'Entrepreneurship', 'BS', 'Ramon V. del Rosario College of Business'),
('MKT', 'Marketing', 'BS', 'Ramon V. del Rosario College of Business'),
('JD', 'Juris Doctor', 'JD', 'Tanada-Diokno School of Law'),
('LSSD', 'Legal Studies and Sustainable Development', 'AB', 'Tanada-Diokno School of Law'),
('PE', 'Physical Education', 'BS', 'Brother Andrew Gonzalez FSC College of Education'),
('SE', 'Science Education', 'BS', 'Brother Andrew Gonzalez FSC College of Education'),
('EAL', 'English and Applied Linguistics', 'BS', 'Brother Andrew Gonzalez FSC College of Education');

INSERT INTO departments (name, college)
VALUES
('Software Technology', 'College of Computer Studies'),
('Information Technology', 'College of Computer Studies'),
('Computer Technology', 'College of Computer Studies'),
('Accountancy', 'Ramon V. del Rosario College of Business'),
('Civil Engineering', 'Gokongwei College of Engineering'),
('Mechanical Engineering', 'Gokongwei College of Engineering'),
('Computer Engineering', 'Gokongwei College of Engineering'),
('Electrical Engineering', 'Gokongwei College of Engineering'),
('Entrepreneurship', 'Ramon V. del Rosario College of Business'),
('Marketing', 'Ramon V. del Rosario College of Business'),
('Law', 'Tanada-Diokno School of Law'),
('Education', 'Brother Andrew Gonzalez FSC College of Education');

INSERT INTO faculty (id, firstName, lastName, department)
VALUES 
(99912345, 'John', 'Doe', 'Software Technology'),
(99923456, 'Jane', 'Smith', 'Information Technology'),
(99934567, 'Alice', 'Johnson', 'Computer Technology'),
(99945678, 'Bob', 'Brown', 'Software Technology'),
(99956789, 'Charlie', 'Davis', 'Accountancy'),
(99967890, 'Emily', 'Clark', 'Civil Engineering'),
(99978901, 'Frank', 'Evans', 'Mechanical Engineering'),
(99989012, 'Grace', 'Harris', 'Computer Engineering'),
(99990123, 'Hank', 'Jackson', 'Electrical Engineering'),
(99901234, 'Ivy', 'King', 'Entrepreneurship'),
(99912346, 'Jack', 'Lee', 'Marketing'),
(99923457, 'Karen', 'Martinez', 'Law'),
(99934568, 'Leo', 'Nelson', 'Education'),
(99945679, 'Mia', 'Owen', 'Software Technology'),
(99956780, 'Nina', 'Perez', 'Information Technology'),
(99967891, 'Oscar', 'Quinn', 'Computer Technology'),
(99978902, 'Paul', 'Roberts', 'Accountancy'),
(99989013, 'Quinn', 'Scott', 'Civil Engineering'),
(99990124, 'Rita', 'Taylor', 'Mechanical Engineering'),
(99901235, 'Sam', 'Upton', 'Computer Engineering'),
(99912347, 'Tina', 'Vasquez', 'Electrical Engineering'),
(99923458, 'Uma', 'White', 'Entrepreneurship'),
(99934569, 'Victor', 'Xavier', 'Marketing'),
(99945680, 'Wendy', 'Young', 'Law'),
(99956781, 'Xander', 'Zimmerman', 'Education'),
(99967892, 'Yara', 'Adams', 'Software Technology'),
(99978903, 'Zane', 'Baker', 'Information Technology'),
(99989014, 'Amy', 'Carter', 'Computer Technology'),
(99990125, 'Brian', 'Diaz', 'Accountancy'),
(99901236, 'Cathy', 'Edwards', 'Civil Engineering'),
(99912348, 'David', 'Foster', 'Mechanical Engineering'),
(99923459, 'Eva', 'Garcia', 'Computer Engineering'),
(99934570, 'Fred', 'Hill', 'Electrical Engineering'),
(99945681, 'Gina', 'Ingram', 'Entrepreneurship'),
(99956782, 'Holly', 'Johnson', 'Marketing'),
(99967893, 'Ian', 'Keller', 'Law'),
(99978904, 'Jill', 'Lewis', 'Education'),
(99989015, 'Kyle', 'Morris', 'Software Technology'),
(99990126, 'Liam', 'Nelson', 'Information Technology'),
(99901237, 'Mona', 'Owens', 'Computer Technology'),
(99912349, 'Nate', 'Parker', 'Accountancy'),
(99923460, 'Olivia', 'Quinn', 'Civil Engineering'),
(99934571, 'Pete', 'Reed', 'Mechanical Engineering');

INSERT INTO courses (code, name, units, academic, department)
VALUES
-- Software Technology
('CCPROG1', 'Introduction to Software Technology', 3, 1, 'Software Technology'),
('CCPROG2', 'Advanced Software Development', 3, 1, 'Software Technology'),
('CCPROG3', 'Software Project Management', 3, 1, 'Software Technology'),
('CCTESTS', 'Software Testing and Quality Assurance', 3, 1, 'Software Technology'),
('CCSWENG', 'Software Engineering', 3, 1, 'Software Technology'),

-- Information Technology
('CCICOMP', 'Introduction to Information Technology', 3, 1, 'Information Technology'),
('CCINFOM', 'Database Management Systems', 3, 1, 'Information Technology'),
('ITNETWK', 'Network and Security', 3, 1, 'Information Technology'),
('ITWBDEV', 'Web Development', 3, 1, 'Information Technology'),
('ITPROJM', 'IT Project Management', 3, 1, 'Information Technology'),

-- Computer Technology
('CTTECH1', 'Introduction to Computer Technology', 3, 1, 'Computer Technology'),
('CTTECH2', 'Computer Hardware Fundamentals', 3, 1, 'Computer Technology'),
('CTTECH3', 'Computer Architecture', 3, 1, 'Computer Technology'),
('CTTECH4', 'Operating Systems', 3, 1, 'Computer Technology'),
('CTCMSEC', 'Computer Security', 3, 1, 'Computer Technology'),

-- Accountancy
('FNDACCT', 'Introduction to Accountancy', 3, 1, 'Accountancy'),
('FINACCT', 'Financial Accounting', 3, 1, 'Accountancy'),
('MGMACCT', 'Managerial Accounting', 3, 1, 'Accountancy'),
('TAXACCT', 'Taxation', 3, 1, 'Accountancy'),
('AUDACCT', 'Auditing', 3, 1, 'Accountancy'),

-- Civil Engineering
('CIVL101', 'Introduction to Civil Engineering', 3, 1, 'Civil Engineering'),
('STRUCTA', 'Structural Analysis', 3, 1, 'Civil Engineering'),
('GEOENGR', 'Geotechnical Engineering', 3, 1, 'Civil Engineering'),
('HYDROLS', 'Hydraulics', 3, 1, 'Civil Engineering'),
('TRANENG', 'Transportation Engineering', 3, 1, 'Civil Engineering'),

-- Mechanical Engineering
('MECH101', 'Introduction to Mechanical Engineering', 3, 1, 'Mechanical Engineering'),
('THERMO1', 'Thermodynamics', 3, 1, 'Mechanical Engineering'),
('FLUIDSM', 'Fluid Mechanics', 3, 1, 'Mechanical Engineering'),
('THERMO2', 'Heat Transfer', 3, 1, 'Mechanical Engineering'),
('MACHDES', 'Machine Design', 3, 1, 'Mechanical Engineering'),

-- Computer Engineering
('CMPENG1', 'Introduction to Computer Engineering', 3, 1, 'Computer Engineering'),
('CMPENG2', 'Digital Logic Design', 3, 1, 'Computer Engineering'),
('CMPENG3', 'Microprocessors', 3, 1, 'Computer Engineering'),
('CENETWK', 'Computer Networks', 3, 1, 'Computer Engineering'),
('VLSIDES', 'VLSI Design', 3, 1, 'Computer Engineering'),

-- Electrical Engineering
('INTROEE', 'Introduction to Electrical Engineering', 3, 1, 'Electrical Engineering'),
('CIRCSEE', 'Circuit Analysis', 3, 1, 'Electrical Engineering'),
('MAGNTEE', 'Electromagnetics', 3, 1, 'Electrical Engineering'),
('POWEREE', 'Power Systems', 3, 1, 'Electrical Engineering'),
('CTRLSEE', 'Control Systems', 3, 1, 'Electrical Engineering'),

-- Entrepreneurship
('ENTREP1', 'Introduction to Entrepreneurship', 3, 1, 'Entrepreneurship'),
('ENTREP2', 'Business Planning', 3, 1, 'Entrepreneurship'),
('ENTCRE8', 'Innovation and Creativity', 3, 1, 'Entrepreneurship'),
('FINAENT', 'Entrepreneurial Finance', 3, 1, 'Entrepreneurship'),
('MRKTENT', 'Marketing for Entrepreneurs', 3, 1, 'Entrepreneurship'),

-- Marketing
('FNDMRKT', 'Introduction to Marketing', 3, 1, 'Marketing'),
('CONSUME', 'Consumer Behavior', 3, 1, 'Marketing'),
('MARKETS', 'Marketing Research', 3, 1, 'Marketing'),
('DIGITAL', 'Digital Marketing', 3, 1, 'Marketing'),
('BRNDING', 'Brand Management', 3, 1, 'Marketing'),

-- Law
('INTRO2L', 'Introduction to Law', 3, 1, 'Law'),
('CONSTIL', 'Constitutional Law', 3, 1, 'Law'),
('CRIMINL', 'Criminal Law', 3, 1, 'Law'),
('CIVLPRO', 'Civil Law', 3, 1, 'Law'),
('COMMERL', 'Commercial Law', 3, 1, 'Law'),

-- Education
('WELEDUC', 'Introduction to Education', 3, 1, 'Education'),
('EDUPSYC', 'Educational Psychology', 3, 1, 'Education'),
('CURRICD', 'Curriculum Development', 3, 1, 'Education'),
('INSTRCT', 'Instructional Strategies', 3, 1, 'Education'),
('CLASSRM', 'Classroom Management', 3, 1, 'Education'),

-- Lab Courses
('LBSCRUM', 'Software SCRUMing', 2, 1, 'Software Technology'),
('LBDEPLY', 'Software Deployment', 2, 1, 'Software Technology'),
('LBYLOGI', 'Logic Gates', 2, 1, 'Computer Technology'),
('LBOPSYS', 'Operating Systems', 2, 1, 'Computer Technology'),
('LBYDLDL', 'Digital Logic Design Lab', 2, 1, 'Computer Engineering'),
('LBMICRO', 'Microprocessor Systems Lab', 2, 1, 'Computer Engineering'),
('LBCIRCT', 'Circuit Analysis Lab', 2, 1, 'Electrical Engineering'),
('LBPOSYS', 'Power Systems Lab', 2, 1, 'Electrical Engineering');

INSERT INTO students (id, firstName, lastName, degreeProgram)
VALUES
(12345678, 'Michael', 'Jordan', 'CS-ST'),
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

INSERT INTO terms (id, termStart, termEnd)
VALUES
("124A", "2024-09-02", "2024-12-09");

INSERT INTO sections (courseCode, sectionCode, termId, assignedFacultyId, status)
VALUES
-- Software Technology
('CCPROG1', 'S11', '124A', 99912345, 'O'),
('CCPROG1', 'S12', '124A', 99945678, 'O'),
('CCPROG1', 'S13', '124A', 99945679, 'O'),
('CCPROG1', 'S14', '124A', 99989015, 'O'),
('CCPROG1', 'S15', '124A', 99967892, 'O'),
('CCPROG2', 'S11', '124A', 99912345, 'O'),
('CCPROG2', 'S12', '124A', 99945678, 'O'),
('CCPROG2', 'S13', '124A', 99945679, 'O'),
('CCPROG2', 'S14', '124A', 99989015, 'O'),
('CCPROG2', 'S15', '124A', 99967892, 'O'),
-- ...repeat for other courses in Software Technology...

-- Information Technology
('CCICOMP', 'S11', '124A', 99923456, 'O'),
('CCICOMP', 'S12', '124A', 99956780, 'O'),
('CCICOMP', 'S13', '124A', 99978903, 'O'),
('CCICOMP', 'S14', '124A', 99990126, 'O'),
('CCICOMP', 'S15', '124A', 99923456, 'O'),
('CCINFOM', 'S11', '124A', 99923456, 'O'),
('CCINFOM', 'S12', '124A', 99956780, 'O'),
('CCINFOM', 'S13', '124A', 99978903, 'O'),
('CCINFOM', 'S14', '124A', 99990126, 'O'),
('CCINFOM', 'S15', '124A', 99923456, 'O'),
-- ...repeat for other courses in Information Technology...

-- Computer Technology
('CTTECH1', 'S11', '124A', 99934567, 'O'),
('CTTECH1', 'S12', '124A', 99967891, 'O'),
('CTTECH1', 'S13', '124A', 99901237, 'O'),
('CTTECH1', 'S14', '124A', 99978903, 'O'),
('CTTECH1', 'S15', '124A', 99934567, 'O'),
('CTTECH2', 'S11', '124A', 99934567, 'O'),
('CTTECH2', 'S12', '124A', 99967891, 'O'),
('CTTECH2', 'S13', '124A', 99901237, 'O'),
('CTTECH2', 'S14', '124A', 99978903, 'O'),
('CTTECH2', 'S15', '124A', 99934567, 'O'),
-- ...repeat for other courses in Computer Technology...

-- Accountancy
('FNDACCT', 'S11', '124A', 99956789, 'O'),
('FNDACCT', 'S12', '124A', 99990125, 'O'),
('FNDACCT', 'S13', '124A', 99934568, 'O'),
('FNDACCT', 'S14', '124A', 99956789, 'O'),
('FNDACCT', 'S15', '124A', 99990125, 'O'),
('FINACCT', 'S11', '124A', 99956789, 'O'),
('FINACCT', 'S12', '124A', 99990125, 'O'),
('FINACCT', 'S13', '124A', 99934568, 'O'),
('FINACCT', 'S14', '124A', 99956789, 'O'),
('FINACCT', 'S15', '124A', 99990125, 'O'),
-- ...repeat for other courses in Accountancy...

-- Civil Engineering
('CIVL101', 'S11', '124A', 99967890, 'O'),
('CIVL101', 'S12', '124A', 99923460, 'O'),
('CIVL101', 'S13', '124A', 99967890, 'O'),
('CIVL101', 'S14', '124A', 99923460, 'O'),
('CIVL101', 'S15', '124A', 99967890, 'O'),
('STRUCTA', 'S11', '124A', 99967890, 'O'),
('STRUCTA', 'S12', '124A', 99923460, 'O'),
('STRUCTA', 'S13', '124A', 99967890, 'O'),
('STRUCTA', 'S14', '124A', 99923460, 'O'),
('STRUCTA', 'S15', '124A', 99967890, 'O'),
-- ...repeat for other courses in Civil Engineering...

-- Mechanical Engineering
('MECH101', 'S11', '124A', 99978901, 'O'),
('MECH101', 'S12', '124A', 99989013, 'O'),
('MECH101', 'S13', '124A', 99912348, 'O'),
('MECH101', 'S14', '124A', 99978901, 'O'),
('MECH101', 'S15', '124A', 99989013, 'O'),
('THERMO1', 'S11', '124A', 99978901, 'O'),
('THERMO1', 'S12', '124A', 99989013, 'O'),
('THERMO1', 'S13', '124A', 99912348, 'O'),
('THERMO1', 'S14', '124A', 99978901, 'O'),
('THERMO1', 'S15', '124A', 99989013, 'O'),
-- ...repeat for other courses in Mechanical Engineering...

-- Computer Engineering
('CMPENG1', 'S11', '124A', 99989012, 'O'),
('CMPENG1', 'S12', '124A', 99901235, 'O'),
('CMPENG1', 'S13', '124A', 99989012, 'O'),
('CMPENG1', 'S14', '124A', 99901235, 'O'),
('CMPENG1', 'S15', '124A', 99989012, 'O'),
('CMPENG2', 'S11', '124A', 99989012, 'O'),
('CMPENG2', 'S12', '124A', 99901235, 'O'),
('CMPENG2', 'S13', '124A', 99989012, 'O'),
('CMPENG2', 'S14', '124A', 99901235, 'O'),
('CMPENG2', 'S15', '124A', 99989012, 'O'),
-- ...repeat for other courses in Computer Engineering...

-- Electrical Engineering
('INTROEE', 'S11', '124A', 99990123, 'O'),
('INTROEE', 'S12', '124A', 99912347, 'O'),
('INTROEE', 'S13', '124A', 99990123, 'O'),
('INTROEE', 'S14', '124A', 99912347, 'O'),
('INTROEE', 'S15', '124A', 99990123, 'O'),
('CIRCSEE', 'S11', '124A', 99990123, 'O'),
('CIRCSEE', 'S12', '124A', 99912347, 'O'),
('CIRCSEE', 'S13', '124A', 99990123, 'O'),
('CIRCSEE', 'S14', '124A', 99912347, 'O'),
('CIRCSEE', 'S15', '124A', 99990123, 'O'),
-- ...repeat for other courses in Electrical Engineering...

-- Entrepreneurship
('ENTREP1', 'S11', '124A', 99901234, 'O'),
('ENTREP1', 'S12', '124A', 99923458, 'O'),
('ENTREP1', 'S13', '124A', 99901234, 'O'),
('ENTREP1', 'S14', '124A', 99923458, 'O'),
('ENTREP1', 'S15', '124A', 99901234, 'O'),
('ENTREP2', 'S11', '124A', 99901234, 'O'),
('ENTREP2', 'S12', '124A', 99923458, 'O'),
('ENTREP2', 'S13', '124A', 99901234, 'O'),
('ENTREP2', 'S14', '124A', 99923458, 'O'),
('ENTREP2', 'S15', '124A', 99901234, 'O'),
-- ...repeat for other courses in Entrepreneurship...

-- Marketing
('FNDMRKT', 'S11', '124A', 99912346, 'O'),
('FNDMRKT', 'S12', '124A', 99934569, 'O'),
('FNDMRKT', 'S13', '124A', 99912346, 'O'),
('FNDMRKT', 'S14', '124A', 99934569, 'O'),
('FNDMRKT', 'S15', '124A', 99912346, 'O'),
('CONSUME', 'S11', '124A', 99912346, 'O'),
('CONSUME', 'S12', '124A', 99934569, 'O'),
('CONSUME', 'S13', '124A', 99912346, 'O'),
('CONSUME', 'S14', '124A', 99934569, 'O'),
('CONSUME', 'S15', '124A', 99912346, 'O'),
-- ...repeat for other courses in Marketing...

-- Law
('INTRO2L', 'S11', '124A', 99923457, 'O'),
('INTRO2L', 'S12', '124A', 99945680, 'O'),
('INTRO2L', 'S13', '124A', 99923457, 'O'),
('INTRO2L', 'S14', '124A', 99945680, 'O'),
('INTRO2L', 'S15', '124A', 99923457, 'O'),
('CONSTIL', 'S11', '124A', 99923457, 'O'),
('CONSTIL', 'S12', '124A', 99945680, 'O'),
('CONSTIL', 'S13', '124A', 99923457, 'O'),
('CONSTIL', 'S14', '124A', 99945680, 'O'),
('CONSTIL', 'S15', '124A', 99923457, 'O'),
-- ...repeat for other courses in Law...

-- Education
('WELEDUC', 'S11', '124A', 99934568, 'O'),
('WELEDUC', 'S12', '124A', 99945681, 'O'),
('WELEDUC', 'S13', '124A', 99934568, 'O'),
('WELEDUC', 'S14', '124A', 99945681, 'O'),
('WELEDUC', 'S15', '124A', 99934568, 'O'),
('EDUPSYC', 'S11', '124A', 99934568, 'O'),
('EDUPSYC', 'S12', '124A', 99945681, 'O'),
('EDUPSYC', 'S13', '124A', 99934568, 'O'),
('EDUPSYC', 'S14', '124A', 99945681, 'O'),
('EDUPSYC', 'S15', '124A', 99934568, 'O'),
-- ...repeat for other courses in Education...

-- Lab Courses
('LBSCRUM', 'S11', '124A', 99912345, 'O'),
('LBSCRUM', 'S12', '124A', 99945678, 'O'),
('LBSCRUM', 'S13', '124A', 99945679, 'O'),
('LBSCRUM', 'S14', '124A', 99989015, 'O'),
('LBSCRUM', 'S15', '124A', 99967892, 'O'),
('LBDEPLY', 'S11', '124A', 99912345, 'O'),
('LBDEPLY', 'S12', '124A', 99945678, 'O'),
('LBDEPLY', 'S13', '124A', 99945679, 'O'),
('LBDEPLY', 'S14', '124A', 99989015, 'O'),
('LBDEPLY', 'S15', '124A', 99967892, 'O');
-- ...repeat for other lab courses...