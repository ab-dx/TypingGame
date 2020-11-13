import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
class TypingGame{
	String[] words = new String[59479];
	String random_word;
	String random_part;
	String input;
	int points = 0;
	Scanner in = new Scanner(System.in);
	public TypingGame(){
		try{
			BufferedReader br = new BufferedReader(new FileReader("word.txt"));
			String line = "";
			for(int j = 0; (line = br.readLine()) != null; j++){
				words[j] = line;
			}
			br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		TypingGame game = new TypingGame();
		System.out.println("Enter number of rounds:");
		int n = game.in.nextInt();
		for(int i = 1; i <= n ; i++){
			game.makeWords();
		}
		System.out.println("Score: " + (((double) game.points / n) * 100) + "%");
	}

	public void makeWords(){
		random_word = words[(int) Math.floor(Math.random() * words.length)];
		int a = (int) Math.floor(Math.random() * (random_word.length() - 3)); // a & b for random substring
		int b = a + 3;
		random_part = random_word.substring(a,b);
		System.out.println("Type a word containg: " + random_part);
		input = in.next().toUpperCase();
		for(int i = 0; i <= words.length - 1; i++){
			if(input.equalsIgnoreCase(words[i]) && input.contains(random_part)){
				points++;
				break;
			}
		}
		System.out.println("Points: " + points);
	}
}
