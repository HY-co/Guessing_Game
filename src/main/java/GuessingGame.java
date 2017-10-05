import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
      // encapsulate all the IO operations in Prompter class
      // prompt for administrator and initialize the jar
      String item = Prompter.promptForItem();
      int maxNumber = Prompter.promptForMaxNo();
      Jar jar = new Jar(item, maxNumber);
      
      // initialize a new prompter object and pass the jar object to it
      Prompter prompter = new Prompter(jar);
      prompter.promptForPlayer();
      do {
        prompter.promptForGuess();  
      }while (!jar.isWon());
      
      prompter.displayOutcome();
    }
}
