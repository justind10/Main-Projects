import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
public class elevator {
public static void main(String[] args) {
while(true){

Random Rand=new Random();

//Initialization of the UpArray and DownArray arrays
ArrayList<Integer> UpArray=new ArrayList<Integer>(12);
ArrayList<Integer> DownArray=new ArrayList<Integer>(12);
//Sets the minimum and maximum for the up array. These will be the boundaries for the up array.
int UpArrayMin=2,UpArrayMax=12,count=0;


while(count!=8){

//Generates random numbers within the boundaries of the array. 
int RandomNum = Rand.nextInt((UpArrayMax - UpArrayMin) + 1) + UpArrayMin;

//Segment used to check and contain RandomNum( the generator) in the array.
if(!UpArray.contains(RandomNum)){


UpArray.add(RandomNum);
count++;
}
}

Collections.sort(UpArray);
System.out.println("=============================================================");
System.out.println(" Elevator floors upward. ");
System.out.println(" "+UpArray);



count=0;
//Initializes boundaries for the down array.
int DownArrayMin=1,DownArrayMax=11;
while(count!=5){

	//Generates random numbers within the boundaries of the array. 
int RandomNum = Rand.nextInt((DownArrayMax - DownArrayMin) + 1) + DownArrayMin;

//Segment used to check and contain RandomNum( the generator) in the array.
if(!DownArray.contains(RandomNum)){


DownArray.add(RandomNum);
count++;
}
}
//Sorts down array in the descending order.
Collections.sort(DownArray, Collections.reverseOrder());
//Messages to display descending order.
System.out.println("Elevator Floors Downward ");
System.out.println(" "+DownArray);
System.out.println("=============================================================");


System.out.println("\n=============================================================");
System.out.println(" Elevator Going Up");
System.out.println("=============================================================");

// Variable defined for the floor we're going to start on.
int start=1;
while(true){
//Breaks assuming there is no value left or that can be read.
if(UpArray.isEmpty()){

break;
}
//'Value' Helps us to define what floor we're currently on.
int value=UpArray.get(0);
System.out.println("Starting at floor "+start);
System.out.println(" Going Up: now at floor "+value);
System.out.println("Stopping at floor "+value+" for 3 seconds -> 1,2,3");
System.out.println("");


start=value;


UpArray.remove(0);
}

System.out.println("\n=============================================================");
System.out.println(" Elevator Going Down");
System.out.println("=============================================================");

//Starting at the top
start=12;
while(true){

//Checks if there's numbers left to be read or any value left, if not, it breaks.
if(DownArray.isEmpty()){
break;
}
int value=DownArray.get(0);
System.out.println("Starting at floor "+start);
System.out.println(" Going Down: now at floor "+value);
System.out.println("Stopping at floor "+value+" for 3 seconds -> 1,2,3");
System.out.println("");
start=value;
DownArray.remove(0);
}

//Prompt to re-run the program.
System.out.println("Do you want to run the elevator again?");
Scanner sc=new Scanner(System.in);
char choice=sc.nextLine().charAt(0);
if(choice=='N'||choice=='n'){
break;
}
}

}
}