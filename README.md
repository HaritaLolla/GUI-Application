# GUI Application
 
It is a simple GUI application that collects, stores and dislpays cars information. To get an overview refer to the UML diagram as it highlights the classes, their dependencies, methods and properperties that are used in this project. 
 
 This project consists of three parts:
  1. The application package is responsible fetching the information from the database and displaying it on the screen in the form of        GUI. 
     Ex: 
     1.Cars:Porsche Cayenne S; Category:Racing; Price:2005463 EUR; Year:2017
     2.Cars:Ferrari 599 GTB; Category:Racing; Price:29658453 EUR; Year:2015
     3.Cars:Land Rover; Category:Suv; Price:2095623 EUR; Year:2016
     
  2. The collection package is responsible for sorting data. The output for this is just displayed in the console. 
     EX: 
     After sortByName()
     1.Cars:Audi; Category:Sedan; Price:202637 EUR; Year:2011
     2.Cars:BMW; Category:Sedan; Price:3036336 EUR; Year:2013
     3.Cars:Ferrari 599 GTB; Category:Racing; Price:29658453 EUR; Year:2015
     
     After sortByCategory()
     1.Cars:Ford; Category:HatchBack; Price:20563 EUR; Year:2016
     2.Cars:Mazada; Category:HatchBack; Price:1585463 EUR; Year:2015
     3.Cars:Swift; Category:HatchBack; Price:194636 EUR; Year:2010
     
  3. The src package is responsible for database operations such as inserting new data, deleting the exsisiting data and allows              navigation through the exisiting data in the database. 
     
In this project Apache Maven was used for managing the build, reporting and documentation.
