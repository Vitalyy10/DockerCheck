# Используем официальный образ Maven с JDK 17
FROM eclipse-temurin:17-jdk-jammy as base

# Устанавливаем git, wget и unzip
RUN apt-get update && apt-get install -y git wget unzip
# Устанавливаем образ Maven
RUN apt-get update && apt-get install -y maven


# Создаем рабочую директорию
WORKDIR /app
# Клонируем репозиторий (замените на ваш репозиторий)
RUN git clone https://github.com/Vitalyy10/DockerCheck.git .
WORKDIR /app
# COPY pom.xml .
# Скачиваем зависимости из .pom


RUN mvn dependency:resolve
# COPY src ./src


# Устанавливаем Allure

RUN apt-get update && apt-get install -y unzip \
    && curl -sSL https://github.com/allure-framework/allure2/releases/download/2.13.8/allure-2.13.8.zip -o allure.zip \
    && unzip allure.zip -d /opt/ \
    && ln -s /opt/allure-2.13.8/bin/allure /usr/bin/allure


# Скачиваем зависимости из .pom файла

ENTRYPOINT []
# Запускаем тесты и генерируем отчет
CMD ["/bin/sh", "-c", "mvn test && allure generate target/allure-results --clean -o target/allure-report"]

