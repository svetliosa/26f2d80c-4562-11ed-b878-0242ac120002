# 26f2d80c-4562-11ed-b878-0242ac120002

Documentation

Database is MS SQL Server
There are two endpoints (/saveData and /country/{COUNTRYCODE}):
- /saveData endpoint load data from json file, mapped it and save it in database
- /country/{COUNTRYCODE} get the data from database via country code

There are 5 packages in the project:
-Entity
-Repository
-Service
-Resource
-Dto
