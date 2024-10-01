# Software Engineering Capstone
## Guest Management System Web Application


## Project Links
[AWS Deployed Application - Guest Management System](http://d424-capstone-elasticbean-env.eba-xjpmv8ym.us-east-1.elasticbeanstalk.com/)

## Local Development Guide

### 1. Clone Project from GitHub
Using Terminal or Command Line, clone the following repo to a new folder on your local computer. Remember where the project was cloned as it will be used in future steps.

### 2. Execute the `wedding_database_dev.sql` Script

* Start a new connection under the `root` user
* Open MySQL Workbench and choose `File --> Open SQL Script...`
* Navigate to the project root folder
* Select the `wedding_database_dev.sql` file and click `Open`
* Execute the SQL Script using the lightning bolt icon inside of MySQL Workbench. Alternatively, while the script is open in the editor, choose `Query --> Execute (All or Selection)`
* After script has successfully run, you may close MySQL Workbench and return to IntelliJ IDEA

### 3. Import Project Folder to IntelliJ

Import the project root folder in IntelliJ IDEA.

The project will download all dependencies using Maven and prepare the application to be run.

After importing the Project and downloading all dependencies.

### 4. Run `WeddingApplication` in IntelliJ IDEA

> **NOTE:** The application will not run if Step 2 was not completed. Do not RUN the application until Step 2 is completed successfully.

* Choose either `Run --> Run 'WeddingApplication'` or click the `Run` icon in the top right corner of IntelliJ IDEA
* The `Console` should show the application successfully launching and building the database tables
    * If prompted to enable Lombok annotation processing in the IntelliJ IDEA console window, please enable.


### 5. Ensure Application is Running

* Navigate to [`http://localhost:5000/`](http://localhost:5000/)
* If a login window showing `GMS Login` is shown, the application is successfully running.
* The default Login / Password for testing purposes is located in the `application.properties` file, and is shown below:
    * **Username**: `admin`
    * **Password**: `TestPass1234!`
* Log in to ensure the application is working as expected
* Proceed to the User Guide below to learn how to use the Application


## Application User Guide

### 1. Add Guest

On the main page, click `Add Guest` from the left menu.

![Add Guest](./readme_images/03%20-%20Main%20Page%20:%20Successful%20Login.png)

### 2. Fill Out Guest Details

On the Edit page, fill out the guest details and click "Save" to save the Guest to the application.

> NOTE: First Name, Last Name, Valid E-Mail, and Valid Phone Number are required. 

![Add / Edit Guest Details](./readme_images/07%20-%20Edit%20Details.png)

### 3. View or Edit Guest Details

After adding a guest, the newly added guests details are shown. You can either Edit the guest information, or Delete the guest. When done, click the back button highlighted below to go back to the main page.

![Guest Details](./readme_images/06%20-%20Guest%20Details%20:%20Successful%20Add.png)


### 4. Multiple Guests

The main page shows all guests entered in to the Guest Management System. Clicking the "eye" icon next to the guests name, as shown below, allows one to edit or delete that guests details. 

![Edit Guest from Main Page](./readme_images/09%20-%20Guest%20List%20(Multiple%20Guests).png)


### 5. Search Guest by First or Last Name

In the search field in the top right hand corner of the application, the guest list may be searched by entering either a first name **-OR-** last name. 

- A search for "Simpson" is shown below, yielding only guests with the first or last name of "Simpson":
![Simpson Search](./readme_images/13%20-%20Search%20(Simpson).png)
- A search for "Flanders" is shown below, yielding only guests with the first or last name of "Flanders":
![Flanders Search](./readme_images/14%20-%20Search%20(Flanders).png)


### 6. View Reports

Clicking on the "Reports" section on the left menu brings the user to the `Reports` page. Here, users can view the RSVP count (`Yes`, `No`, and `Maybe`). Users may also view the selected meal preferences of their guests. 

> **NOTE**: Meal Preferences are only counted in the reporting if the Guest has an RSVP status of "Yes". This is to ensure an accurate count of meal preferences is provided to vendors, caterers, etc. In the first image below, only one guest has RSVP "Yes", therefore only one meal is counted. In the second screenshot, two guests have RSVP "Yes", therefore both meals are counted.

![Reporting page](./readme_images/12%20-%20Report.png)
![Reporting page](./readme_images/12.1%20-%20Reports.png)


### 7. Delete Guest

Finally, to delete a guest, click on the View Icon next to the guest to be deleted. On the Guest Details page, click the "Delete" button. 

> **NOTE**: There is not a confirmation for deletion, and this is a destructive action. Only click the "Delete" button if seeking to delete that guest entirely. 

![Delete Guest](./readme_images/15%20-%20Delete%20Guest.png)