import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Game 
{
	int random_int;
	int wheel;
	int score;
	int step;
	int a_count;
	int b_count;
	int piece;
	int pieces;
	boolean flag = false;
	Stack alphabet;
	String selected_country_string;
	String temp;
	CircularQueue Q5;
	
	
	public Stack textReader(String filename) throws IOException 
	{
        BufferedReader objReader_1 = new BufferedReader(new FileReader(filename));
        BufferedReader objReader_2 = new BufferedReader(new FileReader(filename));

        Stack data = new Stack(20);
        
        int counter = 0;
        String sentence;
        while ((sentence = objReader_1.readLine()) != null) 
        {
            if(!sentence.equals(""))
                counter++;
        }
        
        sentence = "";
        int i = 0;
        while (counter > i) 
        {
            sentence = objReader_2.readLine();
            if(!sentence.equals("")) 
            {
            	data.push(sentence);
                i++;
            }
        }

        objReader_1.close();
        objReader_2.close();

        return data;
    }
	
	public void writerln(Stack s1)
	{
		int count = s1.size();
		while(count > 0)
		{
			System.out.println(s1.pop());
			count--;
		}
	}
	
	public Stack first_alphabet()
	{
		String alpha ="abcdefghijklmnopqrstuvwxyz";
		
		Stack stack_alpha = new Stack(26);
		Stack temp = new Stack(26);
		
		int count = 0;
		while(count < 26)
		{
			temp.push(alpha.charAt(count));
			count++;
		}
		
		count = 0;
		while(count < 26)
		{
			stack_alpha.push(temp.peek());
			temp.pop();
			count++;
		}
		
		return(stack_alpha);
	}
	
	public Stack writer(Stack s2)
	{
		int count = s2.size();
		int count2 = s2.size();
		
		Stack temp = new Stack(count);
		
		if(step == 0)
		{
			while(count > 0)
			{
				System.out.print(s2.pop());
				count--;
			}
		}
		else
		{
			char last = (char) s2.pop();
			while(count - 1 > 0)
			{
				System.out.print(s2.peek());
				temp.push(s2.pop());
				count--;
			}
			
			
			while(count< count2)
			{
				this.alphabet.push(temp.peek());
				temp.pop();
				count++;
			}
			this.alphabet.push(last);
		}
		return alphabet;
	}
	
	public Stack country_sorter(Stack s3)
	{
		int count = 19;
		int count2 = 20;
		int count3 = 20;
		String temp_word = null;
		String temp_word2;
		
		Stack temp_stack = new Stack(20);
		Stack temp_stack2 = new Stack(20);
		Stack sorted_stack = new Stack(20);
		
		while(count2 > 0)
		{
			if(s3.peek() != null)
			{
				temp_word = (String) s3.peek();
				temp_stack.push(s3.peek());
				s3.pop();
			}
			while(count > 0) 
			{
				if(s3.peek() != null)
				{
 					temp_word2 = (String) s3.peek();
    					temp_stack.push(s3.peek());
					s3.pop();
 					count--;
		
					if(temp_word.charAt(0) > temp_word2.charAt(0))
					{
						temp_word = temp_word2;
					}
					else if(temp_word.charAt(0) == temp_word2.charAt(0))
					{
						if(temp_word.charAt(1) > temp_word2.charAt(1))
						{
							temp_word = temp_word2;
						}
					}
				}
			}
		
			while(count2 > 0) 
			{	
				if(temp_stack.peek().equals(temp_word))
				{
					temp_stack.pop();
					count2--;
				}
				else
				{
					s3.push(temp_stack.peek());
					temp_stack.pop();
					count2--;
				}
			}
		
			count3--;
			count2 = count3;
			count = count2 - 1;
		
			temp_stack2.push(temp_word);
		}
		
		count = 0;
		while(count < 20)
		{
			sorted_stack.push(temp_stack2.peek());
			temp_stack2.pop();
			count++;
		}
		
		return sorted_stack;
	}
	
	public int stack_size(Stack s4)
	{
		return(s4.size());
	}
	
	public Stack sorted_high_score(Stack s5)
	{
		int count = s5.size();
		int i = 0;
		int score = 0;
		int temp_score = 0;
		int size = -1;
		int size2 = -1;
		int size3 = -1;
		int name_size = -1;
		int name_size2 = -1;
		int count_size = 0;
		String string = null;
		String name = null;
		String name_score = null;
		
		Stack name_stack = new Stack(20);
		Stack score_stack = new Stack(20);
		Stack score_stack2 = new Stack(20);
		Stack score_stack3 = new Stack(20);
		Stack name_stack2 = new Stack(20);
		Stack temp_stack = new Stack(20);
		Stack return_stack = new Stack(20);
		
		while(count > 0)
		{
			string = (String) s5.peek();
			while(i > -1)
			{
				if(string.charAt(i) == ' ')
				{
					break;
				}
				i++;
			}
			
			name = string.substring(0, i);
			score = Integer.parseInt(string.substring(i + 1));
			name_stack.push(name);
			score_stack.push(score);
			s5.pop();
			
			i = 0;
			count--;
		}
		
		int count2 = score_stack.size() - 1;
		while(count2 >= 0)
		{
			temp_score = (Integer) score_stack.peek();
			size2 = score_stack.size();
			score_stack2.push(score_stack.peek());
			score_stack.pop();
		
			while(count < size2 - 1)
			{
				if(temp_score < (Integer) score_stack.peek())
				{
					temp_score = (Integer) score_stack.peek();
					size = score_stack.size();
					score_stack2.push(score_stack.peek());
					score_stack.pop();
					count_size++;
				}
				else
				{
					score_stack2.push(score_stack.peek());
					score_stack.pop();
				}
			count++;
			}
		
			if(count_size == 0)
			{
				size = size2;
			}
		
			count_size = 0;
		
			count = 0;
			size3 = score_stack2.size();
			while(count < size3)
			{
				if(temp_score == (Integer) score_stack2.peek())
				{
					score_stack2.pop();
				}
				else
				{
					score_stack.push(score_stack2.peek());
					score_stack2.pop();
				}
			
				count++;
			}
		
			count = 0;
			name_size = name_stack.size();
			while(count < name_size)
			{
				if(size == name_stack.size())
				{
					temp_stack.push(name_stack.peek());
					name_stack.pop();
				}
				else
				{
					name_stack2.push(name_stack.peek());
					name_stack.pop();
				}
				count++;
			}
		
			count = 0;
			while(count < name_size - 1)
			{
				name_stack.push(name_stack2.peek());
				name_stack2.pop();
				count++;
			}
		
			count = 0;
			score_stack3.push(temp_score);
			count2--;
		}
		
		name_size2 = temp_stack.size();
		while(name_size2 > 0)
		{
			name_score =(String) temp_stack.pop() + " " + score_stack3.pop();
			return_stack.push(name_score);
			name_size2--;
		}
		
		return return_stack;
	}
	
	public Stack sorted_name_stack(Stack s6)
	{
		int count = s6.size();
		int i = 0;
		String string = null;
		String name = null;
		
		Stack temp_stack = new Stack(20);
		Stack name_stack = new Stack(20);
		
		while(count > 0)
		{
			string = (String) s6.peek();
			while(i > -1)
			{
				if(string.charAt(i) == ' ')
				{
					break;
				}
				i++;
			}
			
			name = string.substring(0, i);
			temp_stack.push(name);
			s6.pop();
			
			i = 0;
			count--;
		}
		
		count = temp_stack.size();
		while(count > 0)
		{
			name_stack.push(temp_stack.peek());
			temp_stack.pop();
			count--;
		}
		
		return name_stack;
	}
	
	public Stack sorted_score_stack(Stack s7)
	{
		int count = s7.size();
		int i = 0;
		int score = 0;
		String string = null;
		
		Stack temp_stack = new Stack(20);
		Stack score_stack = new Stack(20);
		
		while(count > 0)
		{
			string = (String) s7.peek();
			while(i > -1)
			{
				if(string.charAt(i) == ' ')
				{
					break;
				}
				i++;
			}
			
			score = Integer.parseInt(string.substring(i + 1));
			temp_stack.push(score);
			s7.pop();
			
			i = 0;
			count--;
		}
		
		count = temp_stack.size();
		while(count > 0)
		{
			score_stack.push(temp_stack.peek());
			temp_stack.pop();
			count--;
		}
		
		return score_stack;
	}
	
	public void scoreboard_writer(Stack s8, Stack s9)
	{
		int controler = 0;
		int count = s8.size();
		while(count > 0)
		{
			if((score > (int) s9.peek()) && controler == 0)
			{
				System.out.println("You " + score);
				controler = 1;
			}
			else
			{
				System.out.print(s8.pop() + " " + s9.pop());
				System.out.println();
			}
			
			
			
			count--;
		}
		if(controler == 0)
		{
			System.out.println("You " + score);
		}
	}
	
	public int random_number(int min, int max)
	{
		random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
	    
		return(random_int);
	}
	
	public String selected_country(int random_number, Stack s10)
	{	
		boolean flag = false;
		
		while(flag == false)
		{
			if(s10.size() != random_number)
			{
				s10.pop();
			}
			else
			{
				selected_country_string = ((String) s10.peek()) + " ";
				flag = true;
			}
		}

		return(selected_country_string);
	}
	
	public int country_queue(String word)
	{		
		int count2 = 0;
		
		while(word.charAt(a_count) != ' ')
		{
			a_count++;
		}
		
		Queue Q1 = new Queue(a_count);
		Queue Q2 = new Queue(a_count);
		
		while(count2 < a_count)
		{
			Q1.enqueue(word.charAt(count2));
			Q2.enqueue('_');
			count2++;
		}
		
		b_count = a_count;
		a_count = 0;
		
		while(a_count < count2)
		{
			System.out.print(' ');
			System.out.print(Q2.peek());
			Q2.dequeue();
			a_count++;
		}
		
		
		return a_count;
	}
	
	public int wheel(int random_number)
	{	
		switch(random_number)
		{
		case 1: //Double money
			wheel = 2;
			break;
			
		case 2: //Bankrupt
			wheel = 0;
			break;
			
		case 3:
			wheel = 10;
			break;
		
		case 4:
			wheel = 50;
			break;
			
		case 5:
			wheel = 100;
			break;
			
		case 6:
			wheel = 250;
			break;
			
		case 7:
			wheel = 500;
			break;
			
		case 8:
			wheel = 1000;
			break;
		}
	    
		return(wheel);
	}
	
	public int score(int wheel, int score)
	{
		
		
		int count = 0;
		int count2 = 1;
		CircularQueue c = new CircularQueue (a_count);

		
		if(wheel == 2)
		{
			if((piece - pieces) != 0)
			{
				this.score = (this.score * wheel);
			}
			
		}
		else if(wheel == 0)
		{
			this.score = (this.score * wheel) * (piece - pieces);
		}
		else
		{
			if((piece - pieces) != 0)
			{
				this.score = this.score + wheel * (piece - pieces);
			}
			
		}
		score = this.score;
		pieces = piece;
		return score;
	}
	
	public void step()
	{
		System.out.print(step + 1);
		step++;
	}
	
	public Stack letter_and_alphabet(int random_number, Stack alpha)
	{
		int count = 0;
		int count2 = 0;
		char letter = '1';
		
		while(count < alpha.size())
		{
			count++;
		}
		
		this.alphabet = new Stack(count +20);
		Stack temp = new Stack(count);
		
		while(count2 < count)
		{
			if((random_number) != (alpha.size()))
			{
				temp.push(alpha.pop());
				
				count2++;
			}
			else
			{
				letter = (char) alpha.peek();
				alpha.pop();
				
				count2++;
			}
			
		}
		
		count = 0;
		
		while(count < count2 - 1)
		{
			alphabet.push(temp.peek());
			temp.pop();
			count++;
		}
		
		alphabet.push(letter);
		System.out.println(alphabet.pop());
		System.out.println();
		alphabet.push(letter);
		
		return alphabet;
	}
	public String check(String selected_country_string, Stack alphabet, int a_count, CircularQueue Q5, String temp)
	{
		
		int count = this.a_count;
		int count2 = 1;

		int control = 0;
		
		Q5 = new CircularQueue(a_count);
		CircularQueue b = new CircularQueue(a_count);
		
		count = 0;
		
		while(count < a_count)
		{
			if(this.selected_country_string.charAt(count) == (char) this.alphabet.peek())
			{
				Q5.enqueue(selected_country_string.charAt(count));
				piece++;
				
			}
			else
			{
				Q5.enqueue('_');
			}
			count++;
		}
		
		count = 0;
		
		if(this.temp == null)
		{
			while(count < a_count)
			{
				if(count == 0)
				{
					this.temp = " " + Q5.peek();
				}
				else
				{
					this.temp = this.temp + " " + Q5.peek();
				}
				count++;
				Q5.dequeue();
			}
			
		}
		
		if(Q5.size() == 0)
		{
			count = 0;
			
			while(count < a_count)
			{
				if(this.selected_country_string.charAt(count) == (char) this.alphabet.peek())
				{
					Q5.enqueue(selected_country_string.charAt(count));
					
					
				}
				else
				{
					Q5.enqueue('_');
				}
				count++;
			}
		}
		
		alphabet.pop();
		count = 0;
		while(count < a_count)
		{

			if (count == 0)
			{
				if((this.temp.charAt(count + count2) != (char) Q5.peek()) && ((char) Q5.peek() == '_'))
				{
					
					
					b.enqueue(this.temp.charAt(count + count2));
					Q5.dequeue();
					control = 1;
				}
			}
			else if (count == a_count - 1)
			{
				if(((count + count2) % 2 == 1) && (this.temp.charAt(count + count2) != (char) Q5.peek()) && ((char) Q5.peek() == '_'))
				{
					b.enqueue(this.temp.charAt(count + count2));
					Q5.dequeue();
					
					
					control = 1;
				}
			}
			else
			{
				if(((count + count2) % 2 == 1) && (this.temp.charAt(count + count2) != (char) Q5.peek()) && ((char) Q5.peek() == '_'))
				{
					b.enqueue(this.temp.charAt(count + count2));
					Q5.dequeue();
					
					control = 1;
				}
			}
			if (control == 0)
			{
				b.enqueue(Q5.peek());
				Q5.dequeue();
			}
			

			count++;
			count2++;
			control = 0;
		}
	
		count = 0;
		
		while(count < a_count)
		{
			Q5.enqueue(b.peek());
			b.dequeue();
			count++;
		}
		
		count = 0;
		count2 = 1;
		this.temp = null;
		
		if(this.temp == null)
		{
			while(count < a_count)
			{
				if(count == 0)
				{
					this.temp = " " + Q5.peek();
				}
				else
				{
					this.temp = this.temp + " " + Q5.peek();
				}
				count++;
				Q5.dequeue();
			}
			
		}
		temp = this.temp;
		return temp;
		
		
	}
	
	public void que_writer(String temp)
	{
		System.out.print(temp);

	}
}
