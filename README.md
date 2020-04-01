<div align="center">
  
![eKheti]()

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)


</div>

# eKheti

A mobile and web platform for farmers to get the most suitable crops prediction for their land based on soil and climatic
factors using Deep Neural Networks


## Installation
Installing NodeJs
```
$ sudo apt-get install nodejs npm
```
Installing [Android Studio](https://developer.android.com/studio/)

Cloning the repo
```
$ git clone https://github.com/theallknowng/eKheti.git
```
Installing the dependencies
```
$ cd eKheti
$ npm install
```
Find the <a target='_blank' href="https://github.com/theallknowng/eKheti/blob/master/config/database-connection.js" >database-connection.js</a> and update the details of the database connection

Installing database

```
$ mysql -u root -p

```
Enter your password for MySQL

```
mysql> CREATE DATABASE ekheti;
mysql> USE ekheti;
mysql> source ekheti.sql;
.
.
mysql> \q;
```
Running the server
```
$ nodemon start
```
Open the browser and type http://localhost:3000

## Technology stack
1.  Bootstrap
2.  HTML
3.  CSS
4.  NodeJS
5.  Python
6.  Android

## Contributers
1.  <a href="https://github.com/alok217" >Alok Pandey</a>
2.  <a href="https://github.com/M1th1lesh">Mithilesh Chaudhari</a>
3.  <a href="https://github.com/adish29" >Adish Pathare</a>
