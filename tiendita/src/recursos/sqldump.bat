echo off
C:\xampp\mysql\bin\mysqldump.exe -h localhost -u root -p pvdb > Backup_Database_pvdb_%date:~-4,4%-%date:~-7,2%-%date:~-10,2%_%time:~0,2%-%time:~3,2%-%time:~6,2%.sql
exit