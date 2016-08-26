import java.lang.reflect.Array;
import java.util.*;


public class NumberGuess {
	
	static Scanner input = new Scanner(System.in);
	static Random rand = new Random();
	static int start;
	static int numberGuess;
	static int[] randomArray = new int[5];
	static int[] userArray = new int[5];
	static int[] testArray = new int[]{1,1,3,4};
	static int[] repeatChecker = new int[10];
	static int repeatCheckerVar;
	static int triesLeft = 8;
	static int howManyTimes;
	static int howManyTimes2;
	

	public static int[] createNumArray(){
		int randomNum; 
		for (int i = 0; i <= 3; i++){
			randomNum = rand.nextInt(9)+1;
			randomArray[i] = randomNum;
			//System.out.println(randomNum);
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
	
	public static boolean contains(int[] arr, int i) {
	      for (int n : arr) {
	         if (i == n) {
	            return true;
	         }
	      }
	      return false;
	   }
	
	public static void goAgainMethod(){
		int goAgain;
		System.out.println("Please input 1. to go again, and 2. to exit.\n\n\n");
		goAgain = input.nextInt();
		switch (goAgain){
		
		case 1: main(null);
		
		case 2: System.exit(0);
		
		default: System.out.println("Invalid input");
				goAgainMethod();
		}
	}
	
	
	public static void compareArrays(){
		howManyTimes = 0;
		howManyTimes2 = 0;
		if (Arrays.equals(userArray, randomArray)){
			System.out.println("Congrats! You win!");
			goAgainMethod();
			}
			
		triesLeft--;
		for (int z = 0; z <= 3; z++){
			int getNumUser = userArray[z];
			int getNumComp = randomArray[z];
			//int getNumTest = testArray[z];
			if (getNumUser == getNumComp){
				//System.out.println(getNumUser);
				//System.out.println(getNumComp);
				howManyTimes++;
			}
		}
		if (howManyTimes >= 1){
			System.out.println("You have placed the correct number in the correct place " + howManyTimes + " time(s).");
		}
		for (int a = 0; a <= 3; a++){
			for (int b = 0; b <= 3; b++){
				int getNumUser2 = userArray[a];
				int getNumComp2 = randomArray[b];
				//int getNumTest2 = testArray[b];
				if (getNumUser2 == getNumComp2){
					if (contains(repeatChecker, getNumUser2)){
						continue;
					}
					System.out.println(getNumUser2);
					System.out.println(getNumComp2);
					repeatChecker[repeatCheckerVar] = userArray[a];
					howManyTimes2++;
					
				}
				
			}
		}
		if (howManyTimes2 >= 1){
			System.out.println("In your set of numbers, " + howManyTimes2 + " of your numbers are correct.");
		}
		if (triesLeft == 0){
			System.out.println("You failed!");
			System.out.println("The array of numbers you were guess for is: " + Arrays.toString(randomArray));
			goAgainMethod();
			
		}
		System.out.println("You have " + triesLeft + " tries left.\n\n");
		gameStart();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to mastermind!");
		System.out.println("Enter 1. to start or 2. to exit.");
		start = input.nextInt();
		
		//System.out.println(randomNum);
		if (start  == 1){
			createNumArray();
			randomArray = createNumArray();
			for (int k = 0; k < 4; k++){
				System.out.println(randomArray[k]);
			}
			gameStart();
		}
		else if (start == 2){
			System.out.println("Bye!");
			System.exit(0);
		}

	}

}
