## Task 9 
Generate a 6 digits random number. 

Make a guess of the number. 

If the number entered is less than the generated number, hint to player that the number entered is lower. 

If the number entered is greater than the generated number, hint to player that the number entered is higher. 

If the number entered is the same as the generated number, player wins. 

Game restarts. 


## Task 10 
Randomly generate 10 number between 1 to 100. 

Shuffle the 10 numbers. 

Show the first shuffled number.  

Guess whether the next number is higher or lower. 

For every guess, put the shuffled number (guessed) onto a guessed array. 

For every guess, display the count of numbers that are greater than the shuffled number. 

Display the count of numbers that are lower than or equal to the shuffled number. 


## Task 11 
Create a deck of 52 cards and shuffle them. 

SUIT (CLUB, DIAMOND, HEART, SPADE) 

NUMBER(1,2,3,4,5,6,7,8,9,10, JACK, QUEEN, KING) 

Display the shuffle cards 


## Task 12 

Play BlackJack using what you have done on Task 9. 

Rules: 

### Build and run
In project root folder, i.e. project01am

To compile
1. javac -d bin --source-path . ./*.java Card/*.java

To run the compile bytecode (.class) main entrypoint
java -cp bin<packageName>.<ClassName>
2. java -cpbin project01am.App

To package into jar file, go into the bin folder
3. jar -c -v -f day09.jar -e project01am.App .

To run the jar file inside the bin folder where the jar is created
4. java -jar day09.jar

To run the jar file in the project root folder (outside the bin folder)
5. java -jar bin/day09.jar