import java.util.*;


public class NumberGuess {
	
	static Scanner input = new Scanner(System.in);
	static Random rand = new Random();
	static int start;
	static int numberGuess;
	static int[] randomArray = new int[4];
	static int[] userArray = new int[4];
	static int[] testArray = new int[]{1,2,3,4};
	static int triesLeft = 8;
	static int howManyTimes;

	public static int[] createNumArray(){
		int randomNum; 
		for (int i = 0; i <= 3; i++){
			randomNum = rand.nextInt(9)+1;
			randomArray[i] = randomNum;
			System.out.println(randomNum);
		}
		return randomArray;
		
	}

	
	public static void gameStart(){
		System.out.println("Please input 1 number at a time in the order you think it will come.");
		for (int n = 0; n <= 3; n++){
			numberGuess = input.nextInt();
			userArray[n] = numberGuess;
		}
		compareArrays();
		
	}
	
	public static void compareArrays(){
		triesLeft--;
		for (int z = 0; z <= 3; z++){
			int getNumUser = userArray[z];
			int getNumComp = randomArray[z];
			int getNumTest = testArray[z];
			if (getNumUser == getNumTest){
				howManyTimes++;
				System.out.println("You have placed the correct number " + howManyTimes + " times");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to mastermind!");
		System.out.println("Enter 1. to start or 2. to exit.");
		start = input.nextInt();
		
		//System.out.println(randomNum);
		if (start  == 1){
			gameStart();
		}
		else if (start == 2){
			System.out.println("Bye!");
			System.exit(0);
		}

	}

}
