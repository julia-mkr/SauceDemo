### Lesson 12. Homework

1. Обновить версии всех библиотек в проекте и ее вывод:

**a.**

[INFO] The following dependencies in Dependencies have newer versions:

[INFO]   org.seleniumhq.selenium:selenium-java .............. 3.141.59 -> 4.0.0

[INFO] BUILD SUCCESS

**b.** 
[INFO] Updated org.seleniumhq.selenium:selenium-java:jar:3.141.59 to version 4.0.0

[INFO] BUILD SUCCESS


2. Запустить тесты, используя mvn clean test команду и ее вывод:

   [INFO] Tests run: 17, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 258.835 s - in TestSuite

   [INFO] Results:

   [INFO] Tests run: 17, Failures: 0, Errors: 0, Skipped: 0

   [INFO] BUILD SUCCESS
------------------
###### Checklist for the SauceDemo website

**_Modal:_** Login page
1. Log in using valid login data provided by the website; [PASSED] 

**_Modal:_** Products page

1. Add any item to the cart using the "ADD TO CART" button; [PASSED]
2. Remove an item using the "REMOVE" button from the Products page; [PASSED]
3. Add several items using the "ADD TO CART" button from the Products page; [PASSED]
4. Sort items by name in ascending order (A to Z); [PASSED]
5. Sort items by name in descending order (Z to A); [PASSED]
6. Sort items by price from low to high; [PASSED]
7. Sort items by price from high to low; [PASSED]

**_Modal:_** Item Description page
1. Check the description of any item; [PASSED]
2. Add any item to the cart from the item description page using the "ADD TO CART" button; [PASSED]
3. Remove an item from the item description page using the "REMOVE" button; [PASSED]

**_Modal:_** Cart page
1. Change the quantity of any item in the cart; [FAILED]
2. Remove an item from the cart page using the "REMOVE" button; [PASSED]
3. Proceed to checkout; [PASSED]

**_Modal:_** Checkout page
1. Fill in checkout information with valid data; [PASSED]
2. Finish the checkout; [PASSED]

**_Modal:_** Menu
1. Return to the Products page clicking on the "ALL ITEMS" tab; [PASSED]
2. Click on the "ABOUT" tab; [PASSED]
3. Logout; [PASSED]
4. Reset app state; [PASSED]