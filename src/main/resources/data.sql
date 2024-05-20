-- users テーブルにデータを挿入
INSERT INTO users (name,email, password) VALUES ( '田中太郎', 'tanaka@mail', 'password123');
INSERT INTO users (name,email, password) VALUES ( '鈴木一郎', 'suzuki@mail', 'password456');

-- posts テーブルにデータを挿入
INSERT INTO posts (user_id, message) VALUES ( '1', '初めまして');
INSERT INTO posts (user_id, message) VALUES ( '1', 'こんにちは');
INSERT INTO posts (user_id, message) VALUES ( '1', 'Welcome to underground');
INSERT INTO posts (user_id, message) VALUES ( '2', '初めまして');
INSERT INTO posts (user_id, message) VALUES ( '2', 'ここは、地下ってことですか');
INSERT INTO posts (user_id, message) VALUES ( '1', 'ここはインタネットの墓場です。ある意味地下なのかもしれません。');
INSERT INTO posts (user_id, message) VALUES ( '2', 'そうですか');
INSERT INTO posts (user_id, message) VALUES ( '1', '嘘を嘘と見抜けない人でないと掲示板を使うのは難しいですよ');
INSERT INTO posts (user_id, message) VALUES ( '1', 'あなたはインターネット向いてないです');
INSERT INTO posts (user_id, message) VALUES ( '2', 'えぇ...');
INSERT INTO posts (user_id, message) VALUES ( '2', 'さようなら');
INSERT INTO posts (user_id, message) VALUES ( '1', '勝った');