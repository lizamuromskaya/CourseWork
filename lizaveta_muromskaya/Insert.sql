--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12.1


SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2864 (class 0 OID 34317)
-- Dependencies: 203
-- Data for Name: abstract_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.abstract_user (abstract_user_id, first_name, last_name, patronymic_name, user_username, user_password, user_role) VALUES (1, 'Лиза', 'Муромская', 'Валерьевна', 'admin', 'admin', 'ROLE_ADMIN');
INSERT INTO public.abstract_user (abstract_user_id, first_name, last_name, patronymic_name, user_username, user_password, user_role) VALUES (2, 'Вера', 'Нехвядович', 'Васильевна', 'seller', 'seller', 'ROLE_SELLER');
INSERT INTO public.abstract_user (abstract_user_id, first_name, last_name, patronymic_name, user_username, user_password, user_role) VALUES (3, 'Покупатель', 'Покупатель', 'Покупатель', 'buyer', 'buyer', 'ROLE_BUYER');
INSERT INTO public.abstract_user (abstract_user_id, first_name, last_name, patronymic_name, user_username, user_password, user_role) VALUES (4, 'Максим', 'Тананыкин', 'Сергеевич', 'qwert123', 'qwert12345', 'ROLE_BUYER');
INSERT INTO public.abstract_user (abstract_user_id, first_name, last_name, patronymic_name, user_username, user_password, user_role) VALUES (5, 'Влад', 'Филатов', 'Сергеевич', 'qwert1', 'qwert12345', 'ROLE_BUYER');
INSERT INTO public.abstract_user (abstract_user_id, first_name, last_name, patronymic_name, user_username, user_password, user_role) VALUES (6, 'Продавец', 'Продавец', 'Продавец', 'sell', 'qwert12345', 'ROLE_SELLER');
INSERT INTO public.abstract_user (abstract_user_id, first_name, last_name, patronymic_name, user_username, user_password, user_role) VALUES (7, 'Марина', 'Морозова', 'Евгеньевна', 'qwert12', 'qwert12345', 'ROLE_SELLER');
INSERT INTO public.abstract_user (abstract_user_id, first_name, last_name, patronymic_name, user_username, user_password, user_role) VALUES (8, 'Маша', 'Епихова', 'Сергеевна', 'qwert1234', 'qwert12345', 'ROLE_BUYER');
INSERT INTO public.abstract_user (abstract_user_id, first_name, last_name, patronymic_name, user_username, user_password, user_role) VALUES (9, 'Хакер', 'Взломщик', 'Заблокирован', 'qwert12345', 'qwert12345', 'ROLE_BLOCKED');
INSERT INTO public.abstract_user (abstract_user_id, first_name, last_name, patronymic_name, user_username, user_password, user_role) VALUES (10, 'Олег', 'Олег', 'Заблокирован', 'liza', 'qwert12345', 'ROLE_BLOCKED');
INSERT INTO public.abstract_user (abstract_user_id, first_name, last_name, patronymic_name, user_username, user_password, user_role) VALUES (11, 'Вадим', 'Олег', 'ЗАблокирован', 'kate', 'qwert12345', 'ROLE_BLOCKED');
INSERT INTO public.abstract_user (abstract_user_id, first_name, last_name, patronymic_name, user_username, user_password, user_role) VALUES (12, 'Миша', 'Мишкин', 'Михаилович', 'misha', 'qwert12345', 'ROLE_BUYER');


--
-- TOC entry 2867 (class 0 OID 34334)
-- Dependencies: 206
-- Data for Name: buyer; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.buyer (buyer_email, buyer_phone, abstract_user_id) VALUES ('qwert12345@mail.ru', '80441111111', 3);
INSERT INTO public.buyer (buyer_email, buyer_phone, abstract_user_id) VALUES ('qwert1234@mail.ru', '80331111111', 4);
INSERT INTO public.buyer (buyer_email, buyer_phone, abstract_user_id) VALUES ('qwert123@mail.ru', '8033222222222', 5);
INSERT INTO public.buyer (buyer_email, buyer_phone, abstract_user_id) VALUES ('qwert12@mail.ru', '80442345678', 8);


--
-- TOC entry 2869 (class 0 OID 34344)
-- Dependencies: 208
-- Data for Name: position; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."position" (position_id, position_name, position_salary) VALUES (1, 'Продавец-консультант', 1000);
INSERT INTO public."position" (position_id, position_name, position_salary) VALUES (2, 'Продавец зала', 800);
INSERT INTO public."position" (position_id, position_name, position_salary) VALUES (3, 'Директор', 2100);
INSERT INTO public."position" (position_id, position_name, position_salary) VALUES (4, 'Менеджер', 1300);
INSERT INTO public."position" (position_id, position_name, position_salary) VALUES (5, 'Экономист', 1500);
INSERT INTO public."position" (position_id, position_name, position_salary) VALUES (6, 'Промоутер', 400);


--
-- TOC entry 2871 (class 0 OID 34352)
-- Dependencies: 210
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.product (product_id, product_cost, product_name) VALUES (1, 10, 'Мышка');
INSERT INTO public.product (product_id, product_cost, product_name) VALUES (2, 15, 'Монитор');
INSERT INTO public.product (product_id, product_cost, product_name) VALUES (3, 150, 'Ноутбук');


--
-- TOC entry 2872 (class 0 OID 34358)
-- Dependencies: 211
-- Data for Name: seller; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.seller (abstract_user_id, position_id) VALUES (2, 2);
INSERT INTO public.seller (abstract_user_id, position_id) VALUES (6, 1);
INSERT INTO public.seller (abstract_user_id, position_id) VALUES (7, 2);


--
-- TOC entry 2866 (class 0 OID 34328)
-- Dependencies: 205
-- Data for Name: act; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.act (act_id, act_product_count, act_date, buyer_id, product_id, seller_id) VALUES (1, 10, '2020-08-08 08:12:00', 3, 2, 2);
INSERT INTO public.act (act_id, act_product_count, act_date, buyer_id, product_id, seller_id) VALUES (2, 100, '2019-12-26 09:00:00', 4, 2, 6);
INSERT INTO public.act (act_id, act_product_count, act_date, buyer_id, product_id, seller_id) VALUES (3, 500, '2021-06-15 11:30:00', 4, 2, 6);
INSERT INTO public.act (act_id, act_product_count, act_date, buyer_id, product_id, seller_id) VALUES (4, 600, '2021-08-10 15:08:00', 5, 2, 7);


--
-- TOC entry 2878 (class 0 OID 0)
-- Dependencies: 202
-- Name: abstract_user_abstract_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.abstract_user_abstract_user_id_seq', 17, true);


--
-- TOC entry 2879 (class 0 OID 0)
-- Dependencies: 204
-- Name: act_act_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.act_act_id_seq', 22, true);


--
-- TOC entry 2880 (class 0 OID 0)
-- Dependencies: 207
-- Name: position_position_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.position_position_id_seq', 6, true);


--
-- TOC entry 2881 (class 0 OID 0)
-- Dependencies: 209
-- Name: product_product_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.product_product_id_seq', 7, true);



--
-- PostgreSQL database dump complete
--

