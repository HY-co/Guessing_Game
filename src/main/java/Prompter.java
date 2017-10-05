import java.util.Scanner;

public class Prompter {
  private Jar jar;
  private Scanner scan;
  private static String item;
  
  public Prompter(Jar jar) {
    scan = new Scanner(System.in);
    this.jar = jar;  
  }
  
  public static String promptForItem() {
      Scanner scan = new Scanner(System.in);
      System.out.print("What type of item? ");
      item = scan.nextLine();
      return item;
  }
  
  public static int promptForMaxNo() {
    String maxNo;
    int maxNumber = 0;
    boolean isValidNo = false;
    Scanner scan = new Scanner(System.in);
    
    do {
      System.out.print("What is the maximum amount of " + item + "s? ");
      maxNo = scan.nextLine();
      try {
        maxNumber = Integer.parseInt(maxNo);
        if (maxNumber < 0) throw new Exception("Value less than 0");
        isValidNo = true;
      }catch (Exception e) {
        System.out.println(e.getMessage() + ", please enter a valid number: ");  
      }
    }while (!isValidNo);
    
    return maxNumber;
  }
  
  public void promptForPlayer() {
    System.out.println("How many " + jar.getItem() + "s are in the jar?" +"Pick a number between 1 and " +
                     jar.getMaxNo() + ".");
  }
  
  public void promptForGuess() {
    System.out.print("Guess: ");
    String guess = scan.nextLine();
    jar.applyGuess(guess);
  }
  
  public void displayOutcome() {
    System.out.print("You got it in " + jar.getCount() + (jar.getCount() == 1 ? " attempt." : " attempts."));
  }
}