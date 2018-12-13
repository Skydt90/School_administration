USE KEA_ADMIN_DB;

INSERT INTO userTypes VALUES 
('admin'), ('student'), ('teacher');

INSERT INTO users VALUES 
('Paul69', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'student'),
('Jarlen', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'admin'),
('MuskelMartin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'teacher'),
('BobMARLEY', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'student'),
('Weedlova420', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'teacher'), 
('tyndmave12', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'admin');

INSERT INTO students VALUES 
(1, 'John Hansen', 'BobMARLEY'), 
(2, 'Paul PopOff', 'Paul69');

INSERT INTO teachers VALUES 
(1, 'Martin Mcoursesartensen', 'MuskelMartin'), 
(2, 'Jakob Wulff', 'Weedlova420');

SELECT * FROM COURSES;

UPDATE courses 
SET content = 'Java in IDE', exam_form = 'Internal oral exam based on hand in product. Graded based on the 7-scale.', 
	expected_students = 35, learning_activities = 'Individual work and exam. Communication takes place via our Ryver channel WD-2018-F-NODEJS',
    learning_outcome = 'Students will be able to code a full stack web based application, set-up a NODEJS server in the cloud and decide the best possible use of MongoDB',
    maximum_students = 50, minimum_students = 15, prerequisites = 'None. Students will learn from the ground up.'
WHERE id = 1;

UPDATE courses
SET content = 'Java in IDE', exam_form = 'Internal oral exam based on hand in product. Graded based on the 7-scale.', 
	expected_students = 35, learning_activities = 'Individual work and exam. Communication takes place via our Ryver channel WD-2018-F-NODEJS',
    learning_outcome = 'Students will be able to code a full stack web based application, set-up a NODEJS server in the cloud and decide the best possible use of MongoDB',
    maximum_students = 50, minimum_students = 15, prerequisites = 'None. Students will learn from the ground up.'
WHERE id = 2;

INSERT INTO teacher_course VALUES
(1, 1), (2,1);

INSERT INTO student_course VALUES
(1, 1), (2,1);

INSERT INTO applications VALUES
(1, 1, current_timestamp()), 
(2, 1, current_timestamp());

SELECT * FROM APPLICATIONS;