# Pencil: Test Take-Home Assessment - Selenium Automation Script

This project contains a Selenium WebDriver automation script for performing integration tests on the **Pencil** application. 

## Goal
The goal is to ensure that the **Pencil Space** works correctly by testing the following user actions:

1. **Login to the Pencil app** (`https://spaces.pencilapp.com`)
2. **Verify page loading time** (should take less than 1000 milliseconds)
3. **On the space list page:**
   - There should be only one space listed with the title “My First Space”.
   - Verify two entries in the left navigation panel: **Home** and **Messages**.
   - The **Create Space** button should be visible.
   - The **profile picture avatar** should be visible in the top right corner.
4. **Enter the first space** and:
   - Draw a vertical line of height 50px.
   - Select the line and move it 10px to the right.
   - Insert a text box and enter “This is a test” in the box.
   - Click outside the text box to set it.
5. **Logout** by clicking the user avatar in the top right and selecting “Logout”.
   - Verify that the user is redirected to the login page.
6. **Change the URL to** `my.pencilapp.com` and ensure the user is redirected to the login page.

## Setup

### Prerequisites
- Java Development Kit (JDK) installed on your machine
- Maven installed on your machine
- Web browser (Chrome, Firefox, etc.) installed on your machine

### Dependencies
- Selenium WebDriver
- TestNG
- Apache POI
- Extent Reports

### Installation Steps

1. **Navigate to the project directory:**
    ```bash
    cd project-directory
    ```

2. **Download dependencies using Maven:**
    ```bash
    mvn clean install
    ```

3. **Compile the Source Code:**
    ```bash
    mvn compile
    ```

4. **Run Tests:**
    ```bash
    mvn test
    ```

## Test Scenario
The test scenario is based on simulating a real user interaction on the Pencil app, verifying that all components 
and features work as expected.

## Test Steps

1. **Login to Pencil:**
   - The script will navigate to `https://spaces.pencilapp.com`.
   - It will log in using a valid credentials.

2. **Verify Page Load Time:**
   - After logging in, the script will measure the time it takes for the page to load and ensure it takes 
   **less than 10000 milliseconds**.

3. **Validate Space List Page:**
   - The script will validate the following:
      - Only **one space** is listed with the title “**My First Space**”.
      - In the left navigation panel, the entries for **Home** and **Messages** exist.
      - The **Create Space** button is visible.
      - The **profile picture avatar** is visible in the top right corner.

4. **Enter First Space:**
   - The script will enter the first space.
   - It will **draw a vertical line** with a height of 50px.
   - The line will be selected and moved 10px to the right.

5. **Insert Text Box:**
   - The script will insert a **text box** using the **text tool** from the bottom toolbar.
   - The text box will contain “**This is a test**”.
   - The text box will be set by clicking outside the box.

6. **Logout and Redirection:**
   - The user will log out by clicking the **user avatar** in the top right and selecting **Logout**.
   - The script will verify that the user is redirected to the **login page**.

7. **Verify Redirection to Login:**
   - The URL will be changed to `my.pencilapp.com` to verify the redirection to the login page.

## Test Execution

Once you have completed the installation and setup:

1. **Run the tests** using Maven:
    ```bash
    mvn test
    ```

2. The test will simulate a real user’s interactions with the Pencil app, performing all actions as described above and
3. ensuring that the expected behaviors are verified.