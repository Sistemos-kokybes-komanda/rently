FROM mysql:latest

ENV MYSQL_DATABASE=rently
ENV MYSQL_ALLOW_EMPTY_PASSWORD=yes
COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 3306