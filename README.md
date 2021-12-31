# Attendance-Regularization-Automation-Assignment
An automated script that regularises attendance on KEKA

**INTRODUCTION OF PROJECT**
This project contains script that automates KEKA.com website to regularize the attendance. Using this script ,Every step will be executed from landing to KEKA.com to request for regularization. You need to give your data in a excel sheet and that data will be fetched and applied in scripts and scripts will be executed.

**Steps for execution this project in your Local**


step1 :- clone this project <br/>
step2 :- Import this project in Intellij and intellij will package all the dependencies <br/>
step3 :- Because everthing is provided in this project i.e. test data, chromedriver and geckodriver so you can directly run this project without adding any external files <br/>
step4 :- Go to project location and open terminal -----> run "mvn test -Dtest=CompleteProcess" <br/>


#NOTE:- <br/>
>While runnig this project browser will ask to authenticate 2-factor authentication ,So for security reasons we did not automated that part and you will have to authenticate manually. <br/>
>This script will be applicable only with missing attendance and unlogged attendance Hence approved attendance can't be regularized. <br/>
>To run script in headless browser ,you need to uncomment headless browser part and give "options" parameter in driver = new FirefoxDriver(); / driver = new ChromeDriver(); <br/>

