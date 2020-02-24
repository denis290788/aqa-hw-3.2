# Для запуска

1. Запустить Docker
2. Установить MySQL (команда docker pull mysql)
3. Запустить Docker-compose up -d
4. Открыть DBeaver, выполнить запросы из schema.sql
5. Запустить jar-файл командой

java -jar app-deadline.jar -P:jdbc.url=jdbc:mysql://192.168.99.100:3306/app -P:jdbc.user=app -P:jdbc.password=pass
