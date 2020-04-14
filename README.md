<div align="center">
  
![eKheti](https://i.imgur.com/wxpB6ru.png)

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)


</div>

# eKheti

A mobile and web platform for farmers to get the most suitable crops prediction for their land based on soil and climatic
factors using Deep Neural Networks


# Index
+ [Installation](#installation)
+ [Getting Started with the Application](#gstart)
+ [Deploying the Android Application](#dtaa)
+ [How to use the Application](#htuta)
+ [How it Works](#howitworks)
+ [Technology Stack](#techstack)
+ [Contributors](#contrib)


## Installation<a name="installation"></a>
Installing NodeJs
```
$ sudo apt-get install nodejs npm
```
Installing [Android Studio](https://developer.android.com/studio/)
s
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
Running the server<a name="gstart"></a>
```
$ nodemon start
```
Open the browser and type http://localhost:3000

### Deploying the Android Application<a name="dtaa"></a>
1. Install and get started with Android Studio using https://developer.android.com/studio/index.html
2. Open the application source code in Android Studio.
3. Change the IP address the application will connect to, to the IP address your server will run on.
4. Connect a phone with debugging mode enabled to your system and install the app in the phone using Android Studio.
5. Register/Login to the app.

### How to use the application<a name="htuta"></a>
1. Login with your credentials.
2. Explore the various features of the application like searching nearby market place, weather and crop suggestion.
3. Submit HealthCard,register a market to the network view your profile, etc.


### How it works<a name="howitworks"></a>
1. Uses Volley for real-time and seamless transmission of data to the <a href="https://nodejs.org/en/" target="_blank">Node.js</a> server.
2. Uses AES Encryption for sensitive data transmission such as health card data.
3. Uses SHA512 Hashing techniques for passwords to render anyone unable to ever figure it out.


## Technology stack<a name="techstack"></a>
1.  Bootstrap
2.  HTML
3.  CSS
4.  NodeJS
5.  Python
6.  Android/Java

## Contributers<a name="contrib"></a>
1.  <a href="https://github.com/alok217" >Alok Pandey</a>
2.  <a href="https://github.com/M1th1lesh">Mithilesh Chaudhari</a>
3.  <a href="https://github.com/adish29" >Adish Pathare</a>
