# studentDB
Full (front end &amp; back end) student database using RESTful web service with Spring Boot in Java and PostgreSQL

PostgreSQL Database Setup Commands:
psql
CREATE USER general WITH PASSWORD 'password' SUPERUSER CREATEDB CREATEROLE;
CREATE DATABASE student;
GRANT ALL PRIVILEGES ON DATABASE "student" TO general;
GRANT ALL PRIVILEGES ON DATABASE "student" TO postgres;
