echo off
C:\xampp\mysql\bin\mysqldump.exe -hlocalhost -uroot -p poabd  poa poabd > backup_%Date:~6,4%%Date:~3,2%%Date:~0,2%_.sql
exit