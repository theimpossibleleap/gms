DROP DATABASE IF EXISTS wedding_database_test;
DROP USER IF EXISTS wedding_admin_test;
FLUSH PRIVILEGES;

CREATE DATABASE wedding_database_test;
CREATE USER 'wedding_admin_test'@'%' IDENTIFIED BY 'TestPass1234!';
GRANT ALL PRIVILEGES ON wedding_database_test.* TO 'wedding_admin_test'@'%';
FLUSH PRIVILEGES;