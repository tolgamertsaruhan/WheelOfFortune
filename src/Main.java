import java.io.IOException;

public class Main 
{
	public static void main (String[] args) throws IOException, InterruptedException
	{
		Game test = new Game();
		int count = 0;
		int count2 = 0;
		int number = test.random_number(1, 20);
		
		do
		{
			if(test.step == 0)
			{
				System.out.println("Randomly generated number to choose the word: " + number);
				System.out.println();
				System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				System.out.println();
				Thread.sleep(1500);
				
				while(count < 30)
				{
					System.out.print('-');
					count++;
				}
				System.out.println();
				System.out.print("| ");
				test.writer(test.first_alphabet());
				System.out.print(" |");
				System.out.println();
				count = 0;
				while(count < 30)
				{
					System.out.print('-');
					count++;
				}
			}
			System.out.println();
			System.out.println();
			System.out.print("Word: ");
			if(test.step == 0)
			{
				test.country_queue(test.selected_country(number, test.country_sorter(test.textReader("src//countries.txt"))));
			}
			else
			{
				
				test.que_writer(test.check(test.selected_country_string, test.alphabet, test.a_count, test.Q5, test.temp));
			}
			System.out.print("     ");
			System.out.print("Step: ");
			test.step();
			if((test.b_count != 0) )
			{
				if(test.b_count == test.piece)
				{
					if(test.wheel != 0 && test.wheel != 2)
					{
						test.score = test.score + test.wheel * (test.piece - test.pieces);
					}
					else
					{
						test.score = test.score * test.wheel;
					}
					break;
				}
			}
			System.out.print("     ");
			System.out.print("Score: ");
			test.score(test.wheel, test.score);
			System.out.print(test.score);
			
			System.out.print("     ");
			System.out.println();
			System.out.println();
			System.out.print("Wheel: ");
			
	
			test.score(test.wheel(test.random_number(1, 8)), test.score);
			
			
			
			if(test.wheel != 0 && test.wheel != 2)
			{
				System.out.print(test.wheel);
			}
			else if (test.wheel == 2)
			{
				System.out.print("Double Money");
			}
			else
			{
				System.out.print("Bankrupt");
			}
			
			System.out.println();
			System.out.println();
			
			System.out.print("Guess: ");
			
			
			if(test.step == 1)
			{
				test.letter_and_alphabet(test.random_number(1, 26), test.first_alphabet());
			}
			else if(test.alphabet.size() != 0)
			{
				test.letter_and_alphabet(test.random_number(1, 26 - test.step + 1), test.alphabet);
			}
			
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println();
			Thread.sleep(1500);
			if(test.alphabet.size() != 0)
			{
				
				count = 0;
				while(count < test.alphabet.size() + 3)
				{
					System.out.print('-');
					count++;
				}
				System.out.println();
				System.out.print("| ");
				test.writer(test.alphabet);
				System.out.print(" |");
				System.out.println();
				count = 0;
				while(count < test.alphabet.size() + 3)
				{
					System.out.print('-');
					count++;
				}
			}
			
		
			
			count2++;
		}while((test.alphabet.size() != 0) && (test.b_count != test.piece));
		
		System.out.println();
		System.out.println();
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		Thread.sleep(1500);
		System.out.println("All letters of the word are opened!     Score: " + test.score);
		System.out.println();
		Thread.sleep(1500);
		test.scoreboard_writer(test.sorted_name_stack(test.sorted_high_score(test.textReader("src//HighScoreTable.txt"))), test.sorted_score_stack(test.sorted_high_score(test.textReader("src//HighScoreTable.txt"))));
	}
}
