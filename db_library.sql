-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Мар 17 2023 г., 02:30
-- Версия сервера: 5.7.39
-- Версия PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `db_library`
--

-- --------------------------------------------------------

--
-- Структура таблицы `authors`
--

CREATE TABLE `authors` (
                           `uid` bigint(20) NOT NULL,
                           `surname` varchar(255) DEFAULT NULL,
                           `Name` varchar(255) DEFAULT NULL,
                           `MiddleName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `authors`
--

INSERT INTO `authors` (`uid`, `surname`, `Name`, `MiddleName`) VALUES
                                                                   (44, 'Браун', 'Дэн', '-'),
                                                                   (110, 'qwerty', 'qwert', '');

-- --------------------------------------------------------

--
-- Структура таблицы `authors_seq`
--

CREATE TABLE `authors_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `authors_seq`
--

INSERT INTO `authors_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Структура таблицы `books`
--

CREATE TABLE `books` (
                         `uid` bigint(20) NOT NULL,
                         `name` varchar(255) NOT NULL,
                         `year` varchar(4) NOT NULL,
                         `author_uid` bigint(20) DEFAULT NULL,
                         `genre_uid` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `books`
--

INSERT INTO `books` (`uid`, `name`, `year`, `author_uid`, `genre_uid`) VALUES
    (115, 'qwertyuiop[', '2000', 110, 26);

-- --------------------------------------------------------

--
-- Структура таблицы `books_library`
--

CREATE TABLE `books_library` (
                                 `uid` bigint(20) NOT NULL,
                                 `numberrack` int(11) NOT NULL,
                                 `numbershelf` int(11) NOT NULL,
                                 `count` int(11) NOT NULL,
                                 `books_uid` bigint(20) DEFAULT NULL,
                                 `sections_uid` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `books_library_seq`
--

CREATE TABLE `books_library_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `books_library_seq`
--

INSERT INTO `books_library_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Структура таблицы `books_seq`
--

CREATE TABLE `books_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `books_seq`
--

INSERT INTO `books_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Структура таблицы `divisions`
--

CREATE TABLE `divisions` (
                             `uid` bigint(20) NOT NULL,
                             `name` varchar(255) DEFAULT NULL,
                             `address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `divisions`
--

INSERT INTO `divisions` (`uid`, `name`, `address`) VALUES
                                                       (2, 'Бухгалтерия', 'г.Москва, ул. Серпуховская, д.10, офис 17'),
                                                       (4, 'Библиотека №109, корпус 4', 'г.Москва, ул. Никольская, д.17'),
                                                       (5, 'Бухгалтерия', 'г.Москва, ул. Серпуховская, д.90, офис 17');

-- --------------------------------------------------------

--
-- Структура таблицы `divisions_seq`
--

CREATE TABLE `divisions_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `divisions_seq`
--

INSERT INTO `divisions_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Структура таблицы `employees`
--

CREATE TABLE `employees` (
                             `uid` bigint(20) NOT NULL,
                             `surname` varchar(255) NOT NULL,
                             `name` varchar(255) NOT NULL,
                             `middlename` varchar(255) NOT NULL,
                             `passport` varchar(11) NOT NULL,
                             `telefon` varchar(16) NOT NULL,
                             `datebirthday` date DEFAULT NULL,
                             `divisions_uid` bigint(20) DEFAULT NULL,
                             `positions_uid` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `employees`
--

INSERT INTO `employees` (`uid`, `surname`, `name`, `middlename`, `passport`, `telefon`, `datebirthday`, `divisions_uid`, `positions_uid`) VALUES
                                                                                                                                              (39, 'Щербакова', 'татьянна', 'александровна', '231354', '+79771864766', '1995-08-06', 2, 33),
                                                                                                                                              (97, 'Сергеев', 'Сергей', 'Сергеевич', '4518895689', '+79177736715', '2000-09-08', 2, 33),
                                                                                                                                              (98, 'Щербакова', 'ertw', 'Александровна', '45188994323', '+79151384971', '1989-09-06', 4, 34),
                                                                                                                                              (100, 'ewf', 'few', 'fwe', '32436547658', '+79135673833', '1999-09-09', 2, 33),
                                                                                                                                              (109, 'ewf', 'fe', 'fwe', '23456789354', '+79135673833', '2000-09-09', 4, 34);

-- --------------------------------------------------------

--
-- Структура таблицы `employees_seq`
--

CREATE TABLE `employees_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `employees_seq`
--

INSERT INTO `employees_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Структура таблицы `extradition_books`
--

CREATE TABLE `extradition_books` (
                                     `uid` bigint(20) NOT NULL,
                                     `dateextradition` date NOT NULL,
                                     `datereturn` date NOT NULL,
                                     `books_uid` bigint(20) DEFAULT NULL,
                                     `employees_uid` bigint(20) DEFAULT NULL,
                                     `library_cards_uid` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `extradition_books_seq`
--

CREATE TABLE `extradition_books_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `extradition_books_seq`
--

INSERT INTO `extradition_books_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Структура таблицы `genres`
--

CREATE TABLE `genres` (
                          `uid` bigint(20) NOT NULL,
                          `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `genres`
--

INSERT INTO `genres` (`uid`, `name`) VALUES
                                         (26, 'мелодрама'),
                                         (111, 'qwertyuuuuuuuuu');

-- --------------------------------------------------------

--
-- Структура таблицы `genres_seq`
--

CREATE TABLE `genres_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `genres_seq`
--

INSERT INTO `genres_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
    (118);

-- --------------------------------------------------------

--
-- Структура таблицы `library_cards`
--

CREATE TABLE `library_cards` (
                                 `uid` bigint(20) NOT NULL,
                                 `Date_Open` date NOT NULL,
                                 `Date_Close` date NOT NULL,
                                 `readers_uid` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `library_cards`
--

INSERT INTO `library_cards` (`uid`, `Date_Open`, `Date_Close`, `readers_uid`) VALUES
    (104, '2022-08-09', '2022-09-03', 42);

-- --------------------------------------------------------

--
-- Структура таблицы `library_cards_seq`
--

CREATE TABLE `library_cards_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `library_cards_seq`
--

INSERT INTO `library_cards_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Структура таблицы `positions`
--

CREATE TABLE `positions` (
                             `uid` bigint(20) NOT NULL,
                             `name` varchar(255) DEFAULT NULL,
                             `salary` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `positions`
--

INSERT INTO `positions` (`uid`, `name`, `salary`) VALUES
                                                      (33, 'Менеджер', 38000),
                                                      (34, 'Библиотекарь', 56000),
                                                      (108, 'qwertyu', 14000);

-- --------------------------------------------------------

--
-- Структура таблицы `positions_seq`
--

CREATE TABLE `positions_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `positions_seq`
--

INSERT INTO `positions_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Структура таблицы `publish_houses`
--

CREATE TABLE `publish_houses` (
                                  `uid` bigint(20) NOT NULL,
                                  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `publish_houses`
--

INSERT INTO `publish_houses` (`uid`, `name`) VALUES
    (30, 'Махаон');

-- --------------------------------------------------------

--
-- Структура таблицы `publish_houses_seq`
--

CREATE TABLE `publish_houses_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `publish_houses_seq`
--

INSERT INTO `publish_houses_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Структура таблицы `readers`
--

CREATE TABLE `readers` (
                           `uid` bigint(20) NOT NULL,
                           `surname` varchar(255) NOT NULL,
                           `name` varchar(255) NOT NULL,
                           `middlename` varchar(255) NOT NULL,
                           `datebirthday` date NOT NULL,
                           `passport` varchar(11) NOT NULL,
                           `telefon` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `readers`
--

INSERT INTO `readers` (`uid`, `surname`, `name`, `middlename`, `datebirthday`, `passport`, `telefon`) VALUES
                                                                                                          (42, 'Смирнов', 'Илья', '', '2004-09-07', '34532434399', '+79135673833'),
                                                                                                          (80, 'Щербакова', 'Мария', 'Александровна', '2003-09-09', '23456789013', '+79151384971');

-- --------------------------------------------------------

--
-- Структура таблицы `readers_seq`
--

CREATE TABLE `readers_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `readers_seq`
--

INSERT INTO `readers_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Структура таблицы `sections`
--

CREATE TABLE `sections` (
                            `uid` bigint(20) NOT NULL,
                            `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `sections`
--

INSERT INTO `sections` (`uid`, `name`) VALUES
    (71, 'Зарубежная литература');

-- --------------------------------------------------------

--
-- Структура таблицы `sections_seq`
--

CREATE TABLE `sections_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `sections_seq`
--

INSERT INTO `sections_seq` (`next_val`) VALUES
    (1);

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
                        `id` bigint(20) NOT NULL,
                        `active` bit(1) NOT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `active`, `password`, `username`) VALUES
                                                                (1, b'1', '$2a$08$5Xj3wtsmLg8CeAb28wiTYeZClddLvwUhS7BwvU/dirItQmB8L/4tG', 'admin'),
                                                                (2, b'1', '$2a$08$yIjxJFsE10CBSShB5WAUw.8738pmSfW4VS0ReVX6sDxG8Oi2gL9ni', 'librarian'),
                                                                (3, b'1', '$2a$08$W.xTXd/cZq/PsyCRa4c6GumKqqVAhBFQfLwPVz5AxIItCDFSsFmte', 'manager'),
                                                                (4, b'1', '$2a$08$7gE6rn8JrZbCG043fLeZB.K3PTXRqJH/q7NQbiDoJPqkmLSSm2/FO', 'lib'),
                                                                (5, b'1', '$2a$08$pAci7BArUluuX5WcNYuQkeWLt1maMt1CFPNFSr76OBG1d7lZA8xs6', '123'),
                                                                (6, b'1', '$2a$08$0/CFZ5bBQjbKI9SiZDp6K.znC1x0GBWEBpUOABIc3k69cyQaP53U2', 'libb');

-- --------------------------------------------------------

--
-- Структура таблицы `user_role`
--

CREATE TABLE `user_role` (
                             `user_id` bigint(20) NOT NULL,
                             `roles` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user_role`
--

INSERT INTO `user_role` (`user_id`, `roles`) VALUES
                                                 (1, 'ADMIN'),
                                                 (2, 'LIBRARIAN'),
                                                 (3, 'MANAGER'),
                                                 (1, 'LIBRARIAN'),
                                                 (1, 'MANAGER'),
                                                 (4, 'LIBRARIAN'),
                                                 (5, 'LIBRARIAN'),
                                                 (5, 'MANAGER'),
                                                 (6, 'MANAGER');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `authors`
--
ALTER TABLE `authors`
    ADD PRIMARY KEY (`uid`);

--
-- Индексы таблицы `books`
--
ALTER TABLE `books`
    ADD PRIMARY KEY (`uid`),
  ADD KEY `books_ibfk_1` (`genre_uid`),
  ADD KEY `books_ibfk_2` (`author_uid`);

--
-- Индексы таблицы `books_library`
--
ALTER TABLE `books_library`
    ADD PRIMARY KEY (`uid`),
  ADD KEY `books_uid` (`books_uid`),
  ADD KEY `sections_uid` (`sections_uid`);

--
-- Индексы таблицы `divisions`
--
ALTER TABLE `divisions`
    ADD PRIMARY KEY (`uid`);

--
-- Индексы таблицы `employees`
--
ALTER TABLE `employees`
    ADD PRIMARY KEY (`uid`),
  ADD KEY `divisions_uid` (`divisions_uid`),
  ADD KEY `positions_uid` (`positions_uid`);

--
-- Индексы таблицы `extradition_books`
--
ALTER TABLE `extradition_books`
    ADD PRIMARY KEY (`uid`),
  ADD KEY `books_uid` (`books_uid`),
  ADD KEY `employees_uid` (`employees_uid`),
  ADD KEY `library_cards_uid` (`library_cards_uid`);

--
-- Индексы таблицы `genres`
--
ALTER TABLE `genres`
    ADD PRIMARY KEY (`uid`);

--
-- Индексы таблицы `library_cards`
--
ALTER TABLE `library_cards`
    ADD PRIMARY KEY (`uid`),
  ADD KEY `readers_uid` (`readers_uid`);

--
-- Индексы таблицы `positions`
--
ALTER TABLE `positions`
    ADD PRIMARY KEY (`uid`);

--
-- Индексы таблицы `readers`
--
ALTER TABLE `readers`
    ADD PRIMARY KEY (`uid`);

--
-- Индексы таблицы `sections`
--
ALTER TABLE `sections`
    ADD PRIMARY KEY (`uid`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
    ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user_role`
--
ALTER TABLE `user_role`
    ADD KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `books`
--
ALTER TABLE `books`
    ADD CONSTRAINT `books_ibfk_1` FOREIGN KEY (`genre_uid`) REFERENCES `genres` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `books_ibfk_2` FOREIGN KEY (`author_uid`) REFERENCES `authors` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `books_library`
--
ALTER TABLE `books_library`
    ADD CONSTRAINT `books_library_ibfk_1` FOREIGN KEY (`books_uid`) REFERENCES `books` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `books_library_ibfk_2` FOREIGN KEY (`sections_uid`) REFERENCES `sections` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `employees`
--
ALTER TABLE `employees`
    ADD CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`divisions_uid`) REFERENCES `divisions` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `employees_ibfk_2` FOREIGN KEY (`positions_uid`) REFERENCES `positions` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `extradition_books`
--
ALTER TABLE `extradition_books`
    ADD CONSTRAINT `extradition_books_ibfk_1` FOREIGN KEY (`books_uid`) REFERENCES `books` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `extradition_books_ibfk_2` FOREIGN KEY (`employees_uid`) REFERENCES `employees` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `extradition_books_ibfk_3` FOREIGN KEY (`library_cards_uid`) REFERENCES `library_cards` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `library_cards`
--
ALTER TABLE `library_cards`
    ADD CONSTRAINT `library_cards_ibfk_1` FOREIGN KEY (`readers_uid`) REFERENCES `readers` (`uid`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `user_role`
--
ALTER TABLE `user_role`
    ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
