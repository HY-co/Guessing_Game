import java.util.Random;

public class Jar {
  private int maxNo;
  private String item;
  private Random random;
  private int count;
  private int answer;
  private int guessedNumber;
  
  public Jar(String item, int maxNo) {
    this.maxNo = maxNo;
    this.item = item;
    random = new Random();
    count = 0;
    answer = fill(maxNo);
    guessedNumber = -1;
  }
  
  private int fill(int maxNo) {
    return 1 + random.nextInt(maxNo);  
  }
  
  public void applyGuess(String guess) {
    try {
      guessedNumber = Integer.parseInt(guess);
      if (guessedNumber < 1) throw new IllegalArgumentException();
      if (guessedNumber > maxNo) {
        System.out.println("Your guess must be less than " + maxNo);
        return;
      }
      
      if (guessedNumber < answer) System.out.println("Your guess is too low");
      else if (guessedNumber > answer) {
        System.out.println("Your guess is too high");  
      }
      
      count++;
    }catch (Exception e) {
      System.out.println("Please enter a valid number between 1 and " + maxNo + ".");  
    }
  }
  
  public int getCount() {
    return count;  
  }
  
  public int getMaxNo() {
    return maxNo;  
  }
  
  public String getItem() {
    return item;  
  }
  
  public boolean isWon() {
    return guessedNumber == answer;  
  }
}