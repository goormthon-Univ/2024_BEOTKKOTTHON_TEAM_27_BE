show databases ;
use sodong ;
show tables ;

select * from users;
select * from store;
select * from posting ;

INSERT INTO users (login_id, password, created_date, modified_date)
VALUES
    ('user1', 'password1', NOW(), NOW()),
    ('user2', 'password2', NOW(), NOW()),
    ('user3', 'password3', NOW(), NOW()),
    ('user4', 'password4', NOW(), NOW()),
    ('user5', 'password5', NOW(), NOW()),
    ('user6', 'password6', NOW(), NOW()),
    ('user7', 'password7', NOW(), NOW()),
    ('user8', 'password8', NOW(), NOW()),
    ('user9', 'password9', NOW(), NOW()),
    ('user10', 'password10', NOW(), NOW());

ALTER TABLE posting MODIFY COLUMN posting_text VARCHAR(2000);
