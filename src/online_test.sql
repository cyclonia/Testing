-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 08, 2013 at 06:24 AM
-- Server version: 5.5.24-log
-- PHP Version: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `online_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_login`
--

CREATE TABLE IF NOT EXISTS `admin_login` (
  `user_name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin_login`
--

INSERT INTO `admin_login` (`user_name`, `password`) VALUES
('deepak', 'deepak'),
('sunil', 'sunil');

-- --------------------------------------------------------

--
-- Table structure for table `student_registration_table`
--

CREATE TABLE IF NOT EXISTS `student_registration_table` (
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `branch` varchar(20) NOT NULL,
  `semester` varchar(10) NOT NULL,
  `date_of_birth` date NOT NULL,
  `gender` char(6) NOT NULL,
  `address` varchar(100) NOT NULL,
  `password` varchar(15) NOT NULL,
  `student_id` varchar(15) NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `student_id` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_registration_table`
--

INSERT INTO `student_registration_table` (`first_name`, `last_name`, `email`, `branch`, `semester`, `date_of_birth`, `gender`, `address`, `password`, `student_id`) VALUES
('nitesh', 'kumar', 'nitesh@gmail.com', 'ECE', '05', '1990-01-16', 'm', 'dhanbad', 'nitesh', 'nk16051990ECE'),
('sunil', 'sharma', 'sunil@gmail.com', 'CSE', '07', '1992-01-07', 'm', 'dhanbad', 'sunil', 'ss07011992CSE'),
('Vanil', 'Sharma', 'vanil@yahoo.com', 'CSE', '03', '2000-01-03', 'm', '', 'vanil', 'VS03032000CSE');

-- --------------------------------------------------------

--
-- Table structure for table `student_result_table`
--

CREATE TABLE IF NOT EXISTS `student_result_table` (
  `email_id` varchar(30) NOT NULL,
  `test_subject` varchar(20) NOT NULL,
  `marks_obtained` tinyint(4) NOT NULL,
  KEY `email_id` (`email_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student_result_table`
--

INSERT INTO `student_result_table` (`email_id`, `test_subject`, `marks_obtained`) VALUES
('sunil@gmail.com', 'java', 5),
('nitesh@gmail.com', 'c', 2),
('vanil@yahoo.com', 'cpp', 3);

-- --------------------------------------------------------

--
-- Table structure for table `subject_question_table`
--

CREATE TABLE IF NOT EXISTS `subject_question_table` (
  `subject_name` varchar(20) NOT NULL,
  `question_id` varchar(10) NOT NULL,
  `question` varchar(200) NOT NULL,
  `choice_a` varchar(50) NOT NULL,
  `choice_b` varchar(50) NOT NULL,
  `choice_c` varchar(50) NOT NULL,
  `choice_d` varchar(50) NOT NULL,
  `correct_answer` varchar(1) NOT NULL,
  PRIMARY KEY (`question_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subject_question_table`
--

INSERT INTO `subject_question_table` (`subject_name`, `question_id`, `question`, `choice_a`, `choice_b`, `choice_c`, `choice_d`, `correct_answer`) VALUES
('c', 'c1', 'What are the types of linkages?', 'Internal and External', 'External, Internal and None', 'External and None', 'Internal', 'b'),
('c', 'c10', 'Who is writer of  Let Us C?', 'Yashwant Kanetkar', 'Balaji', 'Rajanikant', 'Gajodhar', 'a'),
('c', 'c2', 'Which of the following special symbol allowed in a variable name?', '* (asterisk)', '| (pipeline)', '- (hyphen)', '_ (underscore)', 'd'),
('c', 'c3', 'How would you round off a value from 1.66 to 2.0?', 'ceil(1.66)', 'floor(1.66)', 'roundup(1.66)', 'roundto(1.66)', 'a'),
('c', 'c4', 'By default a real number is treated as a', 'float', 'double', 'long double', 'far double', 'b'),
('c', 'c5', 'Is the following statement a declaration or definition? extern int i;', 'Declaration', 'Definition', 'Function	', 'Error', 'a'),
('c', 'c6', 'When we mention the prototype of a function?', 'Defining	', 'Declaring', 'Prototyping', 'Calling', 'b'),
('c', 'c7', 'What does the following declaration mean? int (*ptr)[10];', 'ptr is array of pointers to 10 integers', 'ptr is a pointer to an array of 10 integers', 'ptr is an array of 10 integers', 'ptr is an pointer to array', 'b'),
('c', 'c8', 'In C, if you pass an array as an argument to a function, what actually gets passed?', 'Value of elements in array', 'First element of the array', 'Base address of the array', 'Address of the last element of array', 'c'),
('c', 'c9', 'What is (void*)0?', 'Representation of NULL pointer', 'Representation of void pointer', 'Error', 'None of above', 'a'),
('cpp', 'cpp1', 'C++ was originally developed by:', 'Nicolas Wirth', 'Donald Knuth', 'Bjarne Stroustrup', 'Ken Thompson', 'c'),
('cpp', 'cpp10', 'The isolation of data from direct access by a C++ program is called as :', 'Data Hiding', 'Data Isolation', 'Data Encapsulation', 'None of the Above', 'a'),
('cpp', 'cpp2', 'The standard C++ comment :', ' /', '//', '/* and */', 'None of these', 'b'),
('cpp', 'cpp3', 'The preprocessor directive #include is required if', 'Console output is used', ' Console input is used', 'Both a and b', 'None of these', 'c'),
('cpp', 'cpp4', 'State the object oriented languages:', 'C++', 'Java', 'Eiffel', ' All the above', 'd'),
('cpp', 'cpp5', '  The value of EOF is :', ' 1', '0', 'Infinity', '-1', 'd'),
('cpp', 'cpp6', 'The first fully Object-oriented language is :', 'Java', 'C++', 'Simula', 'None of the above', 'c'),
('cpp', 'cpp7', 'An instance of a user-defined type is called :', 'Class', 'Object', 'Method', 'None of these', 'b'),
('cpp', 'cpp8', 'The isolation of data from direct access by a C++ program is called as :', 'Data Hiding', 'Data Isolation', ' Data Encapsulation', 'None of the Above', 'a'),
('cpp', 'cpp9', 'What is the notation used to place block of statements in a looping structure in C++', '% %', '( )', '{ }', ' None of the Above', 'c'),
('java', 'j1', 'Which is a valid keyword in java?', 'interface', 'string', 'Float', 'unsigned', 'a'),
('java', 'j10', 'Which of the following declarations is correct?', 'boolean b = TRUE;', 'byte b = 255;', 'String s = ?null?;', 'int i = new Integer(?56?);', 'c'),
('java', 'j2', 'Which one of these lists contains only Java programming language keywords?', 'class, if, void, long, Int, continue', 'goto, instanceof, native, finally, default, throws', 'try, virtual, throw, final, volatile, transient', 'strictfp, constant, super, implements, do', 'b'),
('java', 'j3', 'Which is a reserved word in the Java programming language?', 'method', 'subclasses', 'array', 'native', 'd'),
('java', 'j4', 'Which one of the following will declare an array and initialize it with five numbers?', 'Array a = new Array(5);', 'int [] a = {23,22,21,20,19};', 'int a [] = new int[5];', 'int [5] array;', 'b'),
('java', 'j5', 'Which is the valid declarations within an interface definition?', 'public double methoda();', 'public final double methoda();', 'static void methoda(double d1);', 'protected void methoda(double d1);', 'a'),
('java', 'j6', 'What is the numerical range of a char?', '-128 to 127', '-(215) to (215) - 1', '0 to 32767', '0 to 65535', 'd'),
('java', 'j7', 'Which of the following would compile without error?', 'int a = Math.abs(-5);', 'int b = Math.abs(5.0);', 'int c = Math.abs(5.5F);', 'int d = Math.abs(5L);', 'a'),
('java', 'j8', 'Which is the most restrictive access that accomplishes this objective?', 'public', 'private', 'protected', 'transient', 'c'),
('java', 'j9', 'Which of the following statements about arrays is syntactically wrong?', 'Person[] p = new Person[5];', 'Person p[5];', 'Person[] p [];', 'Person p[][] = new Person[2][];', 'b');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `student_result_table`
--
ALTER TABLE `student_result_table`
  ADD CONSTRAINT `student_result_table_ibfk_1` FOREIGN KEY (`email_id`) REFERENCES `student_registration_table` (`email`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
