import java.util.Scanner;


public class PigGame {

	int Rolldice = 0;
	int dicePoints = 0;
	int maximumScore = 100;
	int humanScore = 0;
	int compScore = 0;
	String state = "r";
	String turn = "";
	String gameOver = "no";


	public static void main(String[] args){

		PigGame game = new PigGame();
		game.go();
	}

	public void go(){
		System.out.println("Welcome to the Pig Game!!.");
		Scanner in = new Scanner(System.in); 
		turn = "human";
		while(gameOver.equals("no"))
		{
			dicePoints=0;

			while(turn.equals("human"))
			{
				//Generate random number
				Rolldice = (int)(Math.random()*6)+1;

				if (Rolldice == 1)
				{
					dicePoints = 0;
					System.out.println("Sorry you stateed: " + Rolldice);
					System.out.println("It is the computer's turn:");
					turn = "computersTurn";
				}
				else
				{
					//Checking if the state is 'h' hold 
					if (state.equalsIgnoreCase("h"))
					{
						humanScore+=dicePoints;
						System.out.println("It is the computer's turn:"); 
						turn="computersTurn";
					}

					else
					{
						System.out.println("You stateed: " + Rolldice); 
						dicePoints+=Rolldice;
						System.out.println("Your score is : "+dicePoints);
						System.out.println("Do you wish to roll(r) or hold(h)?");
						state = in.nextLine(); 
						turn="human";

						if (humanScore >= maximumScore)
						{
							System.out.println("The Computer Score is " + compScore + " and your score is " + humanScore + "."); 
							System.out.println("Congratulations. The human wins the game");
							System.exit(0);
						}
					}
				}
			}
			System.out.println("Your score is: " + humanScore + " Computer's score is: " + compScore);


			while(turn.equals("computersTurn"))
			{
				Rolldice = (int)(Math.random()*6)+1;
				System.out.println("The computer stateed: " + Rolldice); 

				if (Rolldice == 1)
				{
					dicePoints = 0;
					turn = "human";
				}
				else
				{
					dicePoints+=Rolldice;

					if (dicePoints >= 20)
					{
						state = "h";
						compScore+=dicePoints;
						System.out.println(" it is Humans turn:");
						turn = "human";
					}
					else
						state = "r";
				}
				//Comparing the maxscore with computer score 
				if (compScore >= maximumScore)
				{
					System.out.println("The Computer Score is " + compScore + " and your score is " + humanScore + "."); 
					System.out.println("Congratulation!! The Computer Wins.  \n The Game ends here");
					System.exit(0);

				}
			}
			System.out.println("Your score is: " + humanScore + " Computer's score is: " + compScore);

		}
	} 
}