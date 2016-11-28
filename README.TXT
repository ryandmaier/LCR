------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: LCR Dice Game
PURPOSE OF PROJECT: to create a dice game with graphical component
VERSION or DATE: 11.28.16
HOW TO START THIS PROJECT: open BlueJ on a laptop or computer. we created a main class
for graphical component, and an LCR class for logic component. create an instance of the 
"main" class and run the start() method on this instance
AUTHORS: Naren Karur, Ryan Maier
USER INSTRUCTIONS: create an instance of the "main" class and run the start() method on 
this instance

a. Who are the members of the team?
Ryan Maier, Naren Karur
b. Whose code did you start with?
Ryan Maier's code
c. Why did you chose that code to start with?
Because it had an easily mutable "print" method, which we modified to return the values for
each player's coins in an ArrayList of integers. We then used these values in outputting to
our graphical window.
d. One a scale of one to five, how much did you need to modify/restructure the code for
it to work in the graphical context (1 = no changes, program was already graphical and
well designed for OOP, 5 = complete rewrite of all the code)
3... as we said, the code had an easily mutable "print" method, which we modified to return the values for
each player's coins in an ArrayList of integers. We then used these values in outputting to
our graphical window.
e. In the end, what are the various classes that you created and how are they related
(used by) one another?
We created the main class, which sets up the graphical component. it has a timer and a 
start() method to run this timer.
The player class contains the attributes of the players of the game, such as how many coins
they have and their names.
The LCR class ties these players together into the web of the
game logic, manipulating them according to the rules of the game.
We fed values into the LCR class instead of making them rely on user input.
Then in the main class, we created an instance of the LCR class and ran its methods to gain
data on the amount of coins each person had, outputting it to the graphical component.