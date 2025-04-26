![meamngirlCalculator](https://github.com/user-attachments/assets/380a2a60-fff0-499c-a9c2-22a8a8ea41e9)
# PlasticCalculator
A fun and fabulous Mean Girls-themed calculator built with JavaFX!
Every button press comes with sass, style, and iconic quotes from the Plastics.
Perfect for anyone who believes "the limit does not exist!" 💖

Features
Basic operations: Addition, Subtraction, Multiplication, Division

Special buttons:

Fetch: Multiplies the current number by 1.5 (because fetch is extra!)

Limit: Squares the current number (because, again, the limit does not exist!)

Clear (C) and Backspace (⌫) buttons for easy correction

Displays random Mean Girls quotes throughout your calculations

Stylish pink-themed user interface with hotpink accents

Handles division by zero gracefully with a sassy message

Error handling for invalid input

How to Run
Ensure you have Java 8 or newer installed, with JavaFX libraries available.

Compile and run the application:

bash
Copy
Edit
javac JavaFXSwingApplication1.java
java JavaFXSwingApplication1
Or if you're using an IDE (like IntelliJ IDEA, Eclipse, or NetBeans):

Import the project

Set the main class to JavaFXSwingApplication1

Click Run

Note: If your Java version is 11 or higher, you may need to separately install and configure JavaFX SDK.

Project Structure

Component	Purpose
display	Shows the numbers and results
quoteLabel	Displays a random or specific Mean Girls quote
createButtons()	Creates and organizes all calculator buttons
handleButtonClick(text)	Manages user input from buttons
calculateResult()	Executes the arithmetic operations
fetchAction()	"Fetch" functionality (multiply by 1.5)
limitAction()	"Limit" functionality (square the number)
getRandomQuote()	Picks a random quote
updateQuote()	Updates the displayed quote after actions
Special Buttons

Button	Description
C	Clear the current input
⌫	Backspace (delete last digit)
Fetch	Multiplies current number by 1.5
Limit	Squares the current number
=	Computes the result
Screenshots
![Screenshot Placeholder]
(You can add a screenshot of your calculator here if you want!)

About the Developer
Made with love, sass, and a little bit of Plastics magic ✨.
Because math isn't just for nerds — it's for Mean Girls too!

