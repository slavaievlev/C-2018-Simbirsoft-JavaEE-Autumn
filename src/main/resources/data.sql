INSERT INTO Summary(id, fio, email) VALUES(1, 'test', 'slavaievlev9@gmail.com');
INSERT INTO Summary(id, fio) VALUES(2, 'test2');
INSERT INTO Summary(id, fio) VALUES(3, 'test3');

INSERT INTO Targets(id, summaryid, target) VALUES(1, 1, 'Цель1');
INSERT INTO Targets(id, summaryid, target) VALUES(2, 1, 'Цель2');
INSERT INTO Targets(id, summaryid, target) VALUES(3, 2, 'Цель1');
INSERT INTO Targets(id, summaryid, target) VALUES(4, 3, 'Цель1');

INSERT INTO Experiences(id, summaryid, experience) VALUES(1, 1, 'Опыт1');
INSERT INTO Experiences(id, summaryid, experience) VALUES(2, 2, 'Опыт1');
INSERT INTO Experiences(id, summaryid, experience) VALUES(3, 1, 'Опыт2');

INSERT INTO Educations(id, summaryid, education) VALUES(1, 1, 'Образование1');
INSERT INTO Educations(id, summaryid, education) VALUES(2, 1, 'Образование2');
INSERT INTO Educations(id, summaryid, education) VALUES(3, 1, 'Образование3');
INSERT INTO Educations(id, summaryid, education) VALUES(4, 2, 'Образование1');

INSERT INTO Additioneducations(id, summaryid, additioneducations) VALUES(1, 1, 'Дополнительное образование 1');
INSERT INTO Additioneducations(id, summaryid, additioneducations) VALUES(2, 1, 'Дополнительное образование 2');
INSERT INTO Additioneducations(id, summaryid, additioneducations) VALUES(3, 1, 'Дополнительное образование 3');
INSERT INTO Additioneducations(id, summaryid, additioneducations) VALUES(4, 1, 'Дополнительное образование 4');
INSERT INTO Additioneducations(id, summaryid, additioneducations) VALUES(5, 2, 'Дополнительное образование 1');

INSERT INTO Skills(id, summaryid, skill, experience) VALUES(1, 1, 'Навык1', 4);
INSERT INTO Skills(id, summaryid, skill, experience) VALUES(2, 2, 'Навык1', 2);

INSERT INTO Examplescode(id, summaryid, link, nameresource) VALUES(1, 1, 'https://github.com/slavaievlev/Java15', 'GitHub');
INSERT INTO Examplescode(id, summaryid, link, nameresource) VALUES(2, 1, 'https://github.com/slavaievlev/Java15', 'GitHub');
INSERT INTO Examplescode(id, summaryid, link, nameresource) VALUES(3, 1, 'https://github.com/slavaievlev/Java15', 'GitHub');