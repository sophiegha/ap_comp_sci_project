import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class Hangman{
    private static ArrayList<String> words = new ArrayList<String>();
    public static String x = new String(new char[words.size()]);
	  private static int count = 0;
    public void createWords(File text) throws FileNotFoundException{
      Scanner read = new Scanner(text); 
      while(read.hasNextLine()){
      String line = read.nextLine(); 
      String x = "";
      words.add(line);
        }
        x = words.get((int)(Math.random()*words.size()));
			System.out.println(x);
    }
    public int getLength(){
      return x.length(); 
    }
    public static boolean hang(String guess) {
		for (int a = 0; a < x.length(); a++) {
			if (x.charAt(a) == guess.charAt(0)) {
          return true; 
        }
		  }
      hangmanImage(count++); 
			return false; 
    }
    public static boolean won(String temp){
      if(x == temp){
        System.out.println("Correct! Congratulations! The word was " + x);
        return true; 
      }
      return false; 
    }
    public static void hangmanImage(int count) {
		if (count == 1) {
			System.out.println("Wrong guess, please try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (count == 2) {
			System.out.println("Wrong guess, please try again");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 3) {
			System.out.println("Wrong guess, please try again");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (count == 4) {
			System.out.println("Wrong guess, please try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 5) {
			System.out.println("Wrong guess, please try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (count == 6) {
			System.out.println("Wrong guess, please try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (count == 7) {
			System.out.println("Sorry! Game over.");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("The word was " + x);
		}
  }
}
class Main{ 
  public static void main(String[] args) throws FileNotFoundException{
    File text = new File("./dictionary.txt"); 
    Hangman x = new Hangman(); 
    x.createWords(text);
    String temp = "";
    Scanner sc = new Scanner(System.in);
    int count = 0; 
      while (count< 7) {
			System.out.println("Please guess a letter.");
			String guess = sc.next();
        x.hang(guess);
        temp = temp + guess; 
        count++; 
		}
    x.won(temp); 
		sc.close();
  }
}