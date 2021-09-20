# Local-Book-Electronic-Store

Project Name: EStoreSearch
Author: Anh Nguyen
Date of last update: Nov 9th, 2020

Purpose: Create an eStore that holds multiple kind of products and allow user to add 
and search for them online. For this project, we are limited to two kinds of products:
Books and Electronics. ThencCreate a GUI for user to input informations of products with existing logic. 

General problem: 
- user friendly UI
- add/serch/quit
- Store objects with many informations in a single ArrayList
- Make sure the user are entering relevant entries to what's being asked
- Adding objects in a single ArrayList using inheritance 
- Search even when 1, 2 or 3 informations are missing or the year is a period of time
- Take relevant entries even when it is capitalized
- Make multiple methods in a class to handle repetitive tasks
- Make sure the variables are right in term of type(private/default/static/public)

Assumptions & Limitations:
- Reset text fields after user successfully entered a product
- User may leave some entries when adding a product blank
- User may leave some or all entries blank when searrching for a product
- When asking user what they want to do in eStore, user may leave it blank
- When asking user if they want to add/search for a book/eletronic, user may leave it blank
- Assume user only input year in digits but that limit user from inputing year with a letter i.e. 123r

How to test for correctness:

For Add:
- Input something different from the options promted on the screen
- Enter ID with more or less than 6 digits 
- 2nd time enter the same ID 
- Leave the description of the product empty
- Enter year less than 1000 or more than 9999

For search:
- Enter ID but either less than 6 digits or not numbers
- Enter years(start and end) with a year not in between 1000-9999 or not numbers
- Leave 1 or 2 or all the entries empty
- Enter year in different format i.e. '2000'(specific), '2000-'(2000 and after)
'2000-2010'(2000 to 2020), '-2020'(before 2020)


How to build and test:
- To compile, use: gradle build
- To run tests, use: gradle clean test
- To run main, use: gradle run --args'filename.txt'

Possible improvements:
- Allow user to input year in letters and convert that to digits
- Create more methods for repetitive tasks such as promting and receiving entries from users
- Make the program shorter by deleting unnessessary code
- Better color design
- Better text area
