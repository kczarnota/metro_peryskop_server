# metro peryskop server
This is server side of application helping people get out of the subway using correct exit. It was created during Wawcode hackathon 
and awarded with second prize.

## Requirements
```bash
sudo add-apt-repository "deb https://apt.postgresql.org/pub/repos/apt/ trusty-pgdg main"
sudo apt-get update
sudo apt-get install postgresql-9.6
```
## Setup
Default postgres super user and postgres database is created. You need to set a password for the postgres super user.
sudo passwd postgres and set password.
```bash
sudo passwd postgres
```
If service is not started, you can start the PostgreSQL service.
```bash
sudo service postgresql start
```

Create user
```bash
sudo -u postgres createuser <username>
```
Set password
```bash
$ sudo -u postgres psql
psql=# alter user <username> with encrypted password '<password>';
```
Let him create databases
```bash
ALTER USER username CREATEDB;
```
Put his username and password in resources/config/application-dev.yml

On Android side you have to be connected to the same network and provide server ip address
