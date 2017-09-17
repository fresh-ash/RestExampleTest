# RestExampleTest
REST
[![CircleCI](https://circleci.com/gh/fresh-ash/RestExampleTest.svg?style=svg)](https://circleci.com/gh/fresh-ash/RestExampleTest)

Решение:

Использовал Spring Boot.
База данных PostgreSQL.
Подключил библиотеку JINQ. При работе с репозиторием возвращает поток, к которому сразу можно применить фильтр.
Мне показалось это разумным решением, учитывая миллионы записей в таблице.

Объяснение, как поднять приложение с помощь Vagrant:
https://dzone.com/articles/vagrant

Единственно, в bash-файле прописываем еще команду для установки PostgreSQL:
sudo apt-get install postgresql-9.4 postgresql-contrib-9.4
И, конечно, устанавливаем java 8, а не 7.
Еще для доступа к базе данных нужно отредактировать строку #listen_addresses = 'localhost' на 
listen_addresses = '*'
В файле pg_hba.conf выставил для всех доступ по паролю.
