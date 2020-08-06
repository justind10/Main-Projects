import java.util.*;
public class Restaurant {
	static Scanner input = new Scanner(System.in);
	private static int storeCounter = 1;
	private static String[] Menu;
	private static int storeID;
	private static boolean OpenClosed;
	private static int newInt;
	private static int newBoolean;
	public Restaurant() {
		storeID = storeCounter;
		OpenClosed = true;
		Menu = new String[2];	
	}
	
	public Restaurant(int newInt, boolean newBoolean) {
		OpenClosed = newBoolean;
		Menu = new String[newInt];
	}
	public static void setMenu() {
		System.out.println("Enter item 1: " );	
			Menu[0] = input.nextLine();
			System.out.println("Enter item 2: " );	
			Menu[1] = input.nextLine();	
		
	}
	public static void setMenuEasy() {
		Menu[0] = "Hamburger";
		Menu[1] = "Hot Dog";
		Menu[2] = "Pizza";
	}
	public static void Details() {
		System.out.println("Store ID:" + storeID);
		System.out.println(Menu);
		if (OpenClosed = true){
			System.out.println("Open");
		}
		else {
			System.out.println("Closed");
		}
	}
	
	public static void main(String[] args) {
		Restaurant First = new Restaurant();
		Restaurant Second = new Restaurant(2,true);
		Restaurant Third = new Restaurant(3,false);
	
		First.setMenuEasy();
		Third.setMenuEasy();
		Second.setMenu();
		First.Details();
		Second.Details();
		Third.Details();
		
	}

}
