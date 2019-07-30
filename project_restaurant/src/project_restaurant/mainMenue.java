package project_restaurant;

import java.util.Scanner;
public class mainMenue {
	final String APPETIZERS[]= {
			"0-Misu soup:1.50"
			,"1-Endamame:3.95"
			,"2-Gyoza:5.95"
			,"3-Agedashi:5.95"
			,"4-Tofu:6.95"
			,"5-Yakitori:6.95"
			,"6-Fried Clamentori:6.95",
			"7-Baked Dynamite:8.95",
	"8-Salmon Collar:7.95"};
	// the array structure fo APPETIZERS 
	double[]AppetizerPrice={1.50,3.95,5.95,5.95,6.95,6.95,8.95,7.95,5.60};
	// the array structure fo APPETIZERS price

	final String MAIN_MEAL[]={
			"0-911 Roll:12.50"
			,"1-Ashi Tower Roll:15.95"
			,"2-alaskan Roll:11.50"
			,"3-Albacore delight Roll:12.50"
			,"4-Baked Dynamite Roll:13.50"
			,"5-Crawfish Roll:14.45"
			,"6-Crunchy Roll:10.50"
			,"7-Dragon Roll:12.50,"
			,"8-Fire cracker Roll:15.95"};
	// the array to define main menue 
	double MAIN_MEALPrice[]= {12.50,15.95,11.50,12.50,13.50,14.45,10.50,12.50,15.95};
	// the array to define main menue prices
	final String DESSERT[]={
			"0-Lemoncello Marscapone layer cake:6.00"
			,"1-Chocolate layer chip:6.00"
			,"2-New York style cheese cake:6.95"
			,"3-Warm apple cake with ice cream:6"
			,"4-Fresh Pineapple:7.50"
			,"5-Fried icecream:6.00"
			,"6-green tea Ice cream:7.95"
			,"7-Tartufu:5"
			,"8-Mochi:6"};
	// array structure to store DESSERT names
	double DESSERTPrice[]= {6.00,6.00,6.95,6,7.50,6.00,7.95,5,6};
	// array structure to store  DESSERT prices
	final String SALAD[]={
			"0-Garden Saled:12.50"
			,"1-Seaweed SALAD:15.95"
			,"2-Sashimi SALAD:11.50"
			,"3-Ika or Toko SALAD:12.50"
			,"4-Baked Dynamite Roll:13.50"
			,"5-Crawfish Roll:14.45"
			,"6-Crunchy Roll:10.50"
			,"7-Dragon Roll:12.50"
			,"8-Fire cracker Roll:15.95"
	};
	// array structure to store SALAD names
	double SALADPrice[]= {12.50,15.95,11.50,12.50,13.50,14.45,10.50,12.50,15.95};
	// array structure to store  sald prices
	final String BEVERAGE[]={
			"0-coke:12.50"
			,"1-spirit:15.95"
			,"2-orange juice:11.50"
			,"3-green tea:12.50"
			,"4-apple juice:13.50"
			,"5-red wine:14.45"
			,"6-pineaaple juice:10.50"
			,"7-lemonade:12.50"
			,"8-coffee:,15.95"};
	double BEVERAGEPrice[]= {12.50,15.95,11.50,12.50,13.50,14.45,10.50,12.50,15.95};
	final int APPETIZER_COUNT=APPETIZERS.length;// captilize
	final int MAIN_MEAL_COUNT=MAIN_MEAL.length;
	final int SALAD_COUNT=SALAD.length;
	final int BEVERAGE_COUNT=BEVERAGE.length;
	final int DESSERT_COUNT=DESSERT.length;
	final String NAME_MENUE[]= {"Appetizer","main meal","SALAD","DESSERT","BEVERAGE"};
	final int MENUE_COUNT[]= {APPETIZERS.length,MAIN_MEAL.length,SALAD.length,DESSERT.length,BEVERAGE.length};
	// declare instance variable
	Scanner input=new Scanner(System.in); 
	int orderNumber[]=new int[30];
	int orderItems[][][]=new int [30][5][];
	double totalPrice[]=new double[30];
	int count=0;
	int menue=0;
	int choice=0;
	String order="";
	String[] totalOrder=new String [30];
	String status[]=new String[30];

	double price;
	//constructor
	mainMenue(){
		// initializing 3-dim-array
		for(int cnt=0;cnt<orderItems.length;cnt++) {
			orderItems[cnt][0]=new int[APPETIZER_COUNT];
			orderItems[cnt][1]=new int[MAIN_MEAL_COUNT];
			orderItems[cnt][2]=new int[SALAD_COUNT];
			orderItems[cnt][3]=new int[BEVERAGE_COUNT];
			orderItems[cnt][4]=new int[DESSERT_COUNT];
		}

	}
	public void mainMenue2() {
		int choice=0;do {
			// display welcome massage
			System.out.println("===========================welcome to Izaya restaurant===========================");
			// display options
			System.out.println("1-main menue");
			System.out.println("2-Modify order");
			System.out.println("3-make payment");
			System.out.println("4-dispaly all the oders");
			System.out.println("5-exit");
			System.out.println("enter your choice(1...5)");
			if (count>29)
			{
				count=0;
				System.out.println("====sales quota for the day has met====");
				displayAllOrders();
				exit();
				break;
			}
			choice=input.nextInt();
			switch(choice)
			{
			case 1:;totalOrder[count]="";order="";takeOrder();printOrder(count); count++;break;
			case 2: modification();break;
			case 3:payment();break;
			case 4:displayAllOrders();break;
			case 5:exit();break;
			default: System.out.println("invalid choice please try again");
			}
			
		}while(choice!=5);// validation to loop back in this menue if choice is invalid
	}

	public void printOrder(int count) {
		if (count<=orderNumber.length&&count>=0&&orderNumber[count]==count&&totalOrder[count]!=null&&count>=0) {
			//  search and display order number 
			System.out.println("Your order number:"+orderNumber[count]);
			// search for the order number in structure and display it
			System.out.printf("total price:RM %.2f",totalPrice[count]);
			System.out.println();
			// search and display total order of that particular order number
			System.out.println("total order :"+totalOrder[count]);}

		else
		{
			System.out.println("data doesnt exist");
			// validation to show error message if either order number is wrong (out of range) or order number was not assigned to any customers yet

		}


	}

	void takeOrder() {
		int ans1=1;// variable used to ask user if they want anything from main menue
		int ans2=0; // variable used to ask user if they want anything from same menue


		// assign the count value in the array to save the order numbers
		orderNumber[count]=count;
		// display order number
		System.out.println("Your order number:"+orderNumber[count]);
		//dispay order number 
		loop:do {
			do{
				// prompt user to enter the option they want to proceed to
				System.out.println("please enter the the  menue option of your choice\n1-appetizer\n2-main dishes\n3-salad\n4-dessert\n5-beverage");
				int temp1=input.nextInt();


				if (temp1<=NAME_MENUE.length&&temp1>=0) {
					menue=temp1;
				}

				else 
				{
					System.out.println("invalid input,try again");
					continue loop;
				}




			} while(menue>NAME_MENUE.length||menue<1);




			do{
				displayMenueItems(menue);
				System.out.println("please choose the item you like");
				int temp2=input.nextInt();
				// tempory variable which is used to assigne choice with user input once it is checked to be valid

				if(temp2<orderItems[count][menue-1].length&&temp2>=0) {
					choice=temp2;
					// if temp value was valid choice value is qualized to temp


				}
				else {
					System.out.println("invalid input,try again");
					// shows error massage if choice inputed is invalid

					continue loop;
				}

				adjustment(choice,menue);
				// this method is used to search for the price and menue items from the structures 

				System.out.println("please choose the quantity of the items you like\n no more than 100 will be served");
				// prompt uder to enter the a valid quantity for each item
				int quantity=input.nextInt();
				if(quantity>100||quantity<0) {
					// validation to show error massage for invalid quantity
					System.out.println("invalid input,try again");
					continue loop;
				}
				list(count,menue,choice,quantity);
				// method which is used to form the totalorder structure based on the input data
				calculation(count,menue,choice);
				// method which is used to calculate orders price


				System.out.println("do you want anything else from this menue?\n1-yes\nany other key-No");
				// prompt user to answer whether they want any more order from the same menue
				ans2=input.nextInt();

			}while(ans2==1);// loop that is used to keep users in the same menue until they say no
			System.out.println("do you want to add anythign from the main menue\n1-yes\nany other key-No?");
			// prompt user to answer whether they want any more order anything from the main menue
			ans1=input.nextInt();
			if (ans1!=1&&totalPrice[count]==0)
				count--;// if no order was placed count value is not wasted 

		}while(ans1==1);// loop that is used to keep users in the main menue until they say no


	}

	public void list(int count, int menue,int choice,int quantity) {
		// this method is used to form totalOrder data structure which stores all orders in the form of string values
		orderItems[count][menue-1][choice]=quantity;
		// this array structure countains quantity of items ordered 
		order=order+"*"+quantity+"";
		// this string valriable is used to put pr
		totalOrder[count]=totalOrder[count]+"\n/"+order;

	}

	public void calculation(int count,int menue,int choice) {
		// method to calculate total price
		adjustment(choice,menue);
		// executes adjustment method to search structure for the correct price

		totalPrice[count]=totalPrice[count]+price*orderItems[count][menue-1][choice];
	}

	public void printSymbole(int max) {
		// method to design the title of each menue option by printing repeated underlines
		for(int j=1;j<=50;j++)
			System.out.printf("%s","_");
	}
	
	public void adjustment(int choice,int menue) {
		// methode to search arrays for the right price and menue item 

		switch(menue) {

		case 1:

			price=AppetizerPrice[choice];
			order="code:"+menue+APPETIZERS[choice];
			break;
		case 2:

			price=MAIN_MEALPrice[choice];
			order="code:"+menue+MAIN_MEAL[choice];
			break;
		case 3:

			price=DESSERTPrice[choice];
			order="code:"+menue+DESSERT[choice];
			break;
		case 4:

			price=SALADPrice[choice];
			order="code:"+menue+SALAD[choice];
			break;
		case 5:

			price=BEVERAGEPrice[choice];
			order="code:"+menue+BEVERAGE[choice];
			break;
		default : System.out.println("invalid input");
		break;

		}
	}
	public void displayMenueItems(int menue) {
		// display menue titel
		printSymbole(50);
		System.out.print(NAME_MENUE[menue-1]);
		printSymbole(50);

		System.out.println();
		// display the correct menue option based on user menue inputed
		if(menue==1) {
			for(String option:APPETIZERS) {

				System.out.println(option);

			}
		}
		else if(menue==2) {
			for(String option:MAIN_MEAL) {

				System.out.println(option);

			}
		}
		else if(menue==3) {

			for(String option:SALAD) {

				System.out.println(option);

			}

		}
		else if(menue==4)
			for(String option:DESSERT) {

				System.out.println(option);

			}
		else if(menue==5)
			for(String option:BEVERAGE) {

				System.out.println(option);

			}
		
		else {
			System.out.println("invalid input"); 
			// validation to show error massage if menue option entered is out of acceptable rage
		}
	}
	public void payment() {
		int ans4=1;
		// prompt order number
		while(true) {
			System.out.println("please enter your order number");
			// prompt user to enter their order no
			int number=input.nextInt();
			if (number>=orderNumber.length||number<0) {
				// if number was out of acceptable range loop is broken
				System.out.println("invalid input, try again");
				break;
			}
			if(orderNumber[number]!=number||totalOrder[number]==null||totalPrice[number]==0)
			{
				// if oder numebr is in the valid range but it is still not used by any customer 
				// show error massage
				System.out.println("invalid input, try again");
				continue;
			}
			//else {


			if (status[number] != null && status[number].equals("paid"))
				// if oder is paid before loop is broken
			{
				System.out.println("this order is already paid");
				break;
			}
			printOrder(number);
			// display orders 
			System.out.println("Amount received:");
			// prompt user to enter the amount received
			double received=input.nextDouble();
			if (received<totalPrice[number]||received<0) {

				System.out.println("invalid input, try again");
				break;}
			// show order summary +show total

			System.out.printf("your total is:%.2f RM",totalPrice[number]);
			System.out.println();
			System.out.printf("change:RM %.2f",(received-totalPrice[number]));
			System.out.println();
			// if payment is setteled , status of that order number is changed to "paid"
			status[number]="paid";
			// prompt user to answer if they want to make any other payment
			System.out.println("do you want to make any other payment anymore?\n1-yes\nany other key-No");
			ans4=input.nextInt();
			if (ans4!=1)
				break;
		}
	}
	public void modification() {
		int ans3=1; // the variable that is used to ansk user if they want to make any more modification

		while(true) {	
			System.out.println("please enter your order number");
			// prompt user to enter their order number
			int number=input.nextInt();
			if (number<0||number>orderNumber.length||orderNumber[number]!=number||totalPrice[number]==0)
				// if input for order number is invalid an error massage is shown
			{
				System.out.println("invalid input");
				break;
			}


			if (status[number] != null && status[number].equals("paid"))
				// if an order is already paind, no modificarion can be done
			{
				System.out.println("cannot modify, You have already paid");
				break;
			}



			else {
				// display  orders of that number
				printOrder(number);
				// prompt user to enter order menue of modification item
				System.out.println("please enter the menue option that your order belongs to(1..5)\nfrist digit of the order code");
				System.out.println("you can add order or modify pre-ordered items ");
				int menue=input.nextInt();


				if(menue<1||menue>NAME_MENUE.length) {
					// if menue is invalid show error message
					System.out.println("invalid input; try again");
					break;
				}

				// prompt user to enter item number
				System.out.println("please enter the item number\nsecond digit of order code");
				int choice=input.nextInt();

				if (choice<orderItems[number][menue-1].length&&choice>=0) {
					// if choice is in acceptable range, 
					// prompt user to enter new quantity

					System.out.println("please enter the new quantity/note that we don't provide orders more than 100");
					int newQuantity=input.nextInt();

					if (newQuantity>100||newQuantity<0) {
						// if quantity is invalid >> break
						System.out.println("invalid input; try again");
						break;
					}
					
					// change total order array by adding the new modifications
					totalOrder[number]=totalOrder[number]+"\nmodifications";
					adjustment(choice,menue);
					// change quantity of that array to a new quantity by prompting it
					int a=newQuantity-orderItems[number][menue-1][choice];
					// change total price array
					totalPrice[number]=totalPrice[number]+a*price;


					// display new total price
					System.out.printf("New total price:RM %.2f",totalPrice[number]);
					System.out.println();
					// update structures 
					list(number,menue,choice,newQuantity);
					// display  new total order
					System.out.println("new order list:"+totalOrder[number]);
					// ask user if they want any more modification
					System.out.println("do you want to modify anymore?\n1-yes\nany other key-No");
					ans3=input.nextInt();
					if (ans3!=1)

						break;
				}
				else
					// if choice is invalid
					System.out.println("invalid input,try again");
			}
		}
	}

	public void displayAllOrders() {
		for(int i=0;i<orderNumber.length;i++) {
			// display all orders in total order arrays + order number+ stautus+ total price
			System.out.printf(" /orders:%s \t \t  /order no:%d/ \t \t   /total price(RM):%.2f/ \t \t  /status:%s/ %n%n",totalOrder[i],orderNumber[i],totalPrice[i],status[i]);
			System.out.println("================================================================================================================================================================");
		}
	}
	public void exit() {
		// display ending message when exit option is chosen
		System.out.println("good bye!");

	}
	public static void main(String[]args) {
		// declare and instantiate m1 obj
		mainMenue m1=new mainMenue();
		// initializing obj
		// execute mainMenue2 method
		m1.mainMenue2();



	}



}
