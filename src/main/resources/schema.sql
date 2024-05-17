-- 各種テーブル削除
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS posts;


-- users（ユーザー）
CREATE TABLE users (
id SERIAL PRIMARY KEY,
name VARCHAR(20),
email VARCHAR(255),
password VARCHAR(20)
);
-- posts
CREATE TABLE posts (
id SERIAL PRIMARY KEY,
user_id INTEGER,
message VARCHAR(140)
);
