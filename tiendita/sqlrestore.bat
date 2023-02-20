echo off
SET /P Nombre=Copia el nombre de tu archivo de respaldo
C:\xampp\mysql\bin\mysql.exe -h localhost -u root -p poa poa < Nombre