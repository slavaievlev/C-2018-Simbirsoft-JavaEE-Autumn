INSERT INTO Summary(id, fio, dob, email, skype, avatar, phone) VALUES(1, 'Иевлев Ярослав Михайлович',
  '1999-08-07', 'slavaievlev9@gmail.com', 'slavaievlev9@gmail.com',
  'https://pp.userapi.com/c630724/v630724797/8a0e/UXOSOg7A5JI.jpg',
  'моб. 8(903)337-19-02)');
INSERT INTO Summary(id, fio) VALUES(2, 'test2');
INSERT INTO Summary(id, fio) VALUES(3, 'test3');

INSERT INTO Targets(id, SUMMARY_ID, target) VALUES(1, 1, 'Получение работы на должности java-стажер.');
INSERT INTO Targets(id, SUMMARY_ID, target) VALUES(2, 2, 'Цель1');
INSERT INTO Targets(id, SUMMARY_ID, target) VALUES(3, 2, 'Цель2');
INSERT INTO Targets(id, SUMMARY_ID, target) VALUES(4, 3, 'Цель1');

INSERT INTO Experiences(id, SUMMARY_ID, experience) VALUES(1, 2, 'Опыт1');
INSERT INTO Experiences(id, SUMMARY_ID, experience) VALUES(2, 2, 'Опыт2');
INSERT INTO Experiences(id, SUMMARY_ID, experience) VALUES(3, 2, 'Опыт3');

INSERT INTO Educations(id, SUMMARY_ID, education) VALUES(1, 1, 'Ульяновский государственный технический университет. ' ||
  'Факультет информационных систем и технологий. Специальность Прикладная информатика. Студент 2 курса.');
INSERT INTO Educations(id, SUMMARY_ID, education) VALUES(2, 2, 'Образование1');
INSERT INTO Educations(id, SUMMARY_ID, education) VALUES(3, 2, 'Образование2');
INSERT INTO Educations(id, SUMMARY_ID, education) VALUES(4, 2, 'Образование1');

INSERT INTO Addition_educations(id, SUMMARY_ID, additioneducations) VALUES(1, 1, 'Сертификат о прохождении курса ' ||
  '"Летний интенсив 2018": Разработка приложения "Автоматизация врачебного кабинета"');
INSERT INTO Addition_educations(id, SUMMARY_ID, additioneducations) VALUES(2, 1, 'Диплом 2 степени за успехи в научно-' ||
  'исследовательской работе и в выставке информационных продуктов НТТС-2018: Сайт на тему "Культура интернета в России и мире"');
INSERT INTO Addition_educations(id, SUMMARY_ID, additioneducations) VALUES(3, 2, 'Дополнительное образование 1');
INSERT INTO Addition_educations(id, SUMMARY_ID, additioneducations) VALUES(4, 2, 'Дополнительное образование 2');
INSERT INTO Addition_educations(id, SUMMARY_ID, additioneducations) VALUES(5, 2, 'Дополнительное образование 3');

INSERT INTO Skills(id, SUMMARY_ID, skill, experience) VALUES(1, 1, 'Windows', 144);
INSERT INTO Skills(id, SUMMARY_ID, skill, experience) VALUES(2, 1, 'HTML, CSS', 3);
INSERT INTO Skills(id, SUMMARY_ID, skill, experience) VALUES(3, 1, 'Java, C# (desktop)', 10);
INSERT INTO Skills(id, SUMMARY_ID, skill, experience) VALUES(4, 1, 'git, trello', 4);

INSERT INTO Examples_code(id, SUMMARY_ID, link, nameresource) VALUES(1, 1, 'https://github.com/slavaievlev/Java15', 'GitHub');
INSERT INTO Examples_code(id, SUMMARY_ID, link, nameresource) VALUES(2, 2, 'https://github.com/slavaievlev/Java15', 'GitHub');
INSERT INTO Examples_code(id, SUMMARY_ID, link, nameresource) VALUES(3, 2, 'https://github.com/slavaievlev/Java15', 'GitHub');