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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 34317)
-- Name: abstract_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.abstract_user (
    abstract_user_id bigint NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    patronymic_name character varying(255),
    user_username character varying(255),
    user_password character varying(255),
    user_role character varying(255)
);


ALTER TABLE public.abstract_user OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 34315)
-- Name: abstract_user_abstract_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.abstract_user_abstract_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.abstract_user_abstract_user_id_seq OWNER TO postgres;

--
-- TOC entry 2868 (class 0 OID 0)
-- Dependencies: 202
-- Name: abstract_user_abstract_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.abstract_user_abstract_user_id_seq OWNED BY public.abstract_user.abstract_user_id;


--
-- TOC entry 205 (class 1259 OID 34328)
-- Name: act; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.act (
    act_id bigint NOT NULL,
    act_product_count bigint,
    act_date timestamp without time zone,
    buyer_id bigint,
    product_id bigint,
    seller_id bigint
);


ALTER TABLE public.act OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 34326)
-- Name: act_act_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.act_act_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.act_act_id_seq OWNER TO postgres;

--
-- TOC entry 2869 (class 0 OID 0)
-- Dependencies: 204
-- Name: act_act_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.act_act_id_seq OWNED BY public.act.act_id;


--
-- TOC entry 206 (class 1259 OID 34334)
-- Name: buyer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.buyer (
    buyer_email character varying(255),
    buyer_phone character varying(255),
    abstract_user_id bigint NOT NULL
);


ALTER TABLE public.buyer OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 34344)
-- Name: position; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."position" (
    position_id bigint NOT NULL,
    position_name character varying(255),
    position_salary bigint
);


ALTER TABLE public."position" OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 34342)
-- Name: position_position_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.position_position_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.position_position_id_seq OWNER TO postgres;

--
-- TOC entry 2870 (class 0 OID 0)
-- Dependencies: 207
-- Name: position_position_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.position_position_id_seq OWNED BY public."position".position_id;


--
-- TOC entry 210 (class 1259 OID 34352)
-- Name: product; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.product (
    product_id bigint NOT NULL,
    product_cost bigint,
    product_name character varying(255)
);


ALTER TABLE public.product OWNER TO postgres;

--
-- TOC entry 209 (class 1259 OID 34350)
-- Name: product_product_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.product_product_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.product_product_id_seq OWNER TO postgres;

--
-- TOC entry 2871 (class 0 OID 0)
-- Dependencies: 209
-- Name: product_product_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.product_product_id_seq OWNED BY public.product.product_id;


--
-- TOC entry 211 (class 1259 OID 34358)
-- Name: seller; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.seller (
    abstract_user_id bigint NOT NULL,
    position_id bigint
);


ALTER TABLE public.seller OWNER TO postgres;

--
-- TOC entry 2715 (class 2604 OID 34320)
-- Name: abstract_user abstract_user_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.abstract_user ALTER COLUMN abstract_user_id SET DEFAULT nextval('public.abstract_user_abstract_user_id_seq'::regclass);


--
-- TOC entry 2716 (class 2604 OID 34331)
-- Name: act act_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act ALTER COLUMN act_id SET DEFAULT nextval('public.act_act_id_seq'::regclass);


--
-- TOC entry 2717 (class 2604 OID 34347)
-- Name: position position_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."position" ALTER COLUMN position_id SET DEFAULT nextval('public.position_position_id_seq'::regclass);


--
-- TOC entry 2718 (class 2604 OID 34355)
-- Name: product product_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product ALTER COLUMN product_id SET DEFAULT nextval('public.product_product_id_seq'::regclass);


--
-- TOC entry 2720 (class 2606 OID 34325)
-- Name: abstract_user abstract_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.abstract_user
    ADD CONSTRAINT abstract_user_pkey PRIMARY KEY (abstract_user_id);


--
-- TOC entry 2722 (class 2606 OID 34333)
-- Name: act act_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act
    ADD CONSTRAINT act_pkey PRIMARY KEY (act_id);


--
-- TOC entry 2724 (class 2606 OID 34341)
-- Name: buyer buyer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buyer
    ADD CONSTRAINT buyer_pkey PRIMARY KEY (abstract_user_id);


--
-- TOC entry 2726 (class 2606 OID 34349)
-- Name: position position_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."position"
    ADD CONSTRAINT position_pkey PRIMARY KEY (position_id);


--
-- TOC entry 2728 (class 2606 OID 34357)
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (product_id);


--
-- TOC entry 2730 (class 2606 OID 34362)
-- Name: seller seller_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seller
    ADD CONSTRAINT seller_pkey PRIMARY KEY (abstract_user_id);


--
-- TOC entry 2735 (class 2606 OID 34383)
-- Name: seller fk1xcpux5cqj8pltgk3u6gsiafy; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seller
    ADD CONSTRAINT fk1xcpux5cqj8pltgk3u6gsiafy FOREIGN KEY (position_id) REFERENCES public."position"(position_id);


--
-- TOC entry 2732 (class 2606 OID 34368)
-- Name: act fk622q9u1aguk7xtdnxi0mwtsyh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act
    ADD CONSTRAINT fk622q9u1aguk7xtdnxi0mwtsyh FOREIGN KEY (product_id) REFERENCES public.product(product_id);


--
-- TOC entry 2734 (class 2606 OID 34378)
-- Name: buyer fk6nribau7itjuujd6rfvsjst2o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.buyer
    ADD CONSTRAINT fk6nribau7itjuujd6rfvsjst2o FOREIGN KEY (abstract_user_id) REFERENCES public.abstract_user(abstract_user_id);


--
-- TOC entry 2736 (class 2606 OID 34388)
-- Name: seller fk9e0wpv1ujyc87uic17m910w88; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seller
    ADD CONSTRAINT fk9e0wpv1ujyc87uic17m910w88 FOREIGN KEY (abstract_user_id) REFERENCES public.abstract_user(abstract_user_id);


--
-- TOC entry 2731 (class 2606 OID 34363)
-- Name: act fki8f6wywiuvisyow9q0jmu31ig; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act
    ADD CONSTRAINT fki8f6wywiuvisyow9q0jmu31ig FOREIGN KEY (buyer_id) REFERENCES public.buyer(abstract_user_id);


--
-- TOC entry 2733 (class 2606 OID 34373)
-- Name: act fkrc5n5helaa8vinbeu3ee16tg6; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.act
    ADD CONSTRAINT fkrc5n5helaa8vinbeu3ee16tg6 FOREIGN KEY (seller_id) REFERENCES public.seller(abstract_user_id);


--
-- PostgreSQL database dump complete
--

