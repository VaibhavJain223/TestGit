********READ ME******** 
--------------------------------------------------------------------------------------------------------------------------------------------------------------
Requirement Description
Project Name: AstraZe-Global Reltio Support 

Project ID: 54124

Module: Issues

Detailed Description:
1. Login to the mainspring website.
2. Select the Project Name: AstraZe-Global Reltio Support.
2. Select the module assgned.
3. Fill in the data required and save the page.

Cohort: INTQEA21QE001 
Author: Team 03
Team Members: Abhishek Yadav - 905035
              Jyoti Singh - 905045
              Pavan Mantri -  905050
              Prathamesh Kulkarni - 904306
              Pooja Sadafule - 905043
              Vaibhav Jain - 904694 
              
Date of creation:28th April 2021
------------------------------------------------------------------------------------------------------------------------------------------------------------------

[F]-Folder
[P]-Package
[PRO]- Project folder
[c]-class

------------------------------------------------------------------------------------------------------------------------------------------------------------------

Folder structure :

INTQEA21QE001_Team03_Issues_AutomationScript[PRO] 
    
src/main/java [F] - com.library [P] - BaseTestClass [C]
                                      Data [C]
                                      DataProviderr [C]
                                      TestBase [C]
                    com.report [P] - Extent_Report [C]
                    Pages [P] - Pages - IssueDetails [C]
                                        LoginDetails [C]

src/test/java [F] - TestScript [P] - TestScript1 [C]  
                                 
src/main/resources [F] - log4j.properties , manual.logs, selenium.logs

ExtentReport [F] - testReport.html

HTMLReport [F] - report.html

excel [F] - put.xlsx (.xlsx file for test data)

test-output [F] - emailable-report.html (automatically generated emailable testNG report) 

pom.xml (contains all the dependancies)
                                           
------------------------------------------------------------------------------------------------------------------------------------------------------------------

Steps to execute :

1. In log4j user can change its own system's manual.logs and selenium.logs path by clicking on manual.logs and from properties copy path and paste in log4j
   text file by replacing backword slash with double forward slash in application logs and same procedure for selenium.logs also.
2. Please execute the src/test/java---> TestScript ---> TestScript1.java file -> Right click -> Run as 1 TestNG Test
------------------------------------------------------------------------------------------------------------------------------------------------------------------

Note:

1. After the site opens, the user should enter the Username, Password and OTP manually and login to the site.
2. The test data can be chosen by the user, steps: Data[C]--> change the values of the variables "Starting_row" and "Ending_row" according to the iteration column
   value desired by the user. For choosing only one row of data, select same value for both the variables. 
3. There are two reports, i. Customised HTML report in : HTMLReport [F] --> report.html
                          ii. Extent_Report generated report in : ExtentReport [F] --> testReport.html 
4. The program takes a bit of time to start at beginning.
5. When the data is being entered in the website, there is a time lag.
 
------------------------------------------------------------------------------------------------------------------------------------------------------------------
