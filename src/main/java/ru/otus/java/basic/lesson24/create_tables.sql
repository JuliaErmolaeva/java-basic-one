CREATE TABLE public.test(
    id INT,
    name VARCHAR(100) NOT NULL UNIQUE,
    CONSTRAINT test_pk PRIMARY KEY (id)
);

CREATE TABLE public.question(
    id INT,
    name VARCHAR(500) NOT NULL UNIQUE,
    CONSTRAINT question_pk PRIMARY KEY (id)
);

CREATE TABLE public.answer(
    id INT,
    name VARCHAR(100) NOT NULL UNIQUE,
    CONSTRAINT answer_pk PRIMARY KEY (id)
);

CREATE TABLE public.test_question(
    test_id INT,
    question_id INT,
    FOREIGN KEY (test_id) REFERENCES test (id),
    FOREIGN KEY (question_id) REFERENCES question (id),
    CONSTRAINT test_question_pk PRIMARY KEY (test_id, question_id)
);

CREATE TABLE public.question_answer(
    question_id INT,
    answer_id INT,
    correct INT CHECK (correct = 0 OR correct = 1),
    FOREIGN KEY (question_id) REFERENCES question (id),
    FOREIGN KEY (answer_id) REFERENCES answer (id),
    CONSTRAINT question_answer_pk PRIMARY KEY (question_id, answer_id)
);

INSERT INTO public.test (id, name) VALUES
(1, 'Мифы городов России'),
(2, 'Мифы городов мира');

INSERT INTO public.question (id, name) VALUES
(1, 'Где обитал Леший?'),
(2, 'Где обитал Тор?');

INSERT INTO public.answer (id, name) VALUES
(1, 'В горах'),
(2, 'В городе'),
(3, 'В лесу');

INSERT INTO public.test_question(test_id, question_id) VALUES
(1, 1),
(2, 1),
(2, 2);

INSERT INTO public.question_answer(question_id, answer_id, correct) VALUES
(1, 1, 0),
(1, 2, 0),
(1, 3, 1),
(2, 1, 1),
(2, 2, 0),
(2, 3, 0);

SELECT t.name test_name, q.name question_name, ans.name answer_name, qa.correct
FROM public.test t
JOIN public.test_question tq on t.id = tq.test_id
JOIN public.question q on tq.question_id = q.id
JOIN public.question_answer qa on q.id = qa.question_id
JOIN public.answer ans on qa.answer_id = ans.id