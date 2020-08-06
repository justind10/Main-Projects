import java.io.*;

import java.util.*;

import java.util.Queue;

import java.util.LinkedList;

import java.util.concurrent.Executors;

import java.util.concurrent.ScheduledExecutorService;

import java.util.concurrent.TimeUnit;

public class bank

{

    public static void main(String[] args)

   {

     

       Scanner scan = new Scanner(System.in);

       while(true)

       {

           System.out.println("Start program?.. Enter \"yes\" or \"no\": ");

           String choice = scan.nextLine();

           choice.toLowerCase();

       if (choice.equals("yes") || choice.equals("y"))

       {

      

       Runnable bankRunnable = new Runnable()

       {

     

           Random bank_random = new Random();

           Queue<Integer> bank_queue = new LinkedList<Integer>();

           boolean bankteller_one,bankteller_two,bankteller_three,bankteller_four,bankteller_five = false;

           boolean[] bank_Array = {bankteller_one, bankteller_two, bankteller_three, bankteller_four, bankteller_five};

           int[] bank_Arraytwo = {(bank_random.nextInt(5 - 2) + 2),(bank_random.nextInt(5 - 2) + 2),(bank_random.nextInt(5 - 2) + 2),(bank_random.nextInt(5 - 2) + 2),(bank_random.nextInt(5 - 2) + 2)};

           int BI = 0;

           int bank_a1, bank_b1, bank_c1, bank_d1, bank_e1;

           int customer_Servedone, customer_Servedtwo, customer_Servedthree, customer_Servedfour, customer_Servedfive = 0;

           int occupied_Timeone, occupied_Timetwo, occupied_Timethree, occupied_Timefour, occupied_Timefive = 0;

           int bank_f1, bank_g1, bank_h1, bank_i1, bank_j1 = 1;

      

        public void run()

        {

             

                  if(BI == 120)

                  {

                   

                      System.out.println("The total amount of customers that visited the bank for that 2 minutes is :" + (customer_Servedone + customer_Servedtwo+ customer_Servedthree

                      + customer_Servedfour + customer_Servedfive + 5 + bank_queue.size()) + " customers.");

                      System.out.println("The total amount of customers that each teller helped: ");

                 

                      System.out.println("Teller one served: " + (customer_Servedone + 1));

                      System.out.println("Teller two served: " + (customer_Servedtwo + 1));

                      System.out.println("Teller three served: " + (customer_Servedthree + 1));

                      System.out.println("Teller four served: " + (customer_Servedfour + 1));

                      System.out.println("Teller five served: " + (customer_Servedfive + 1));

                      System.out.println("Total teller time of " + (customer_Servedone + customer_Servedtwo + customer_Servedthree

                      + customer_Servedfour + customer_Servedfive + 5) + " customers.");

                      System.out.println("The total amount of time that each teller was occupied.: " + (occupied_Timeone + occupied_Timetwo + occupied_Timethree

                      + occupied_Timefour + occupied_Timefive) + " seconds.");

                      System.out.println("The total amount of customers that did not get to see a teller: " + bank_queue.size() + " customers");

                      System.out.println("simulation ends...");

                      System.exit(0);

                  }

           

                  else

                  {

                   if(bank_random.nextInt(4) < 6)

                   {

                       int b_time = (bank_random.nextInt(5 - 2) + 3);

                       bank_queue.add(b_time);

                   }

                  

                   while(bank_f1 == 1)

                   {  

                       bank_a1 = BI;

                       bank_f1 = 0;

                   }

                

                   if ((BI - bank_a1) >= bank_Arraytwo[0])

                   {

                       bank_Array[0] = true;

                     

                       if (bank_Array[0] == true && bank_queue.isEmpty() == false)

                       {

                           occupied_Timeone += bank_Arraytwo[0];

                           bank_Arraytwo[0] = bank_queue.poll();

                           bank_f1 = 1;

                           customer_Servedone++;

                       }

                   }

                 

                   while(bank_g1 == 1)

                   {

                       bank_b1 = BI;

                       bank_g1 = 0;

                   }

                 

                   if ((BI - bank_b1) >= bank_Arraytwo[1])

                   {

                       bank_Array[1] = true;

                       if (bank_Array[1] == true && bank_queue.isEmpty() == false)

                       {

                           occupied_Timetwo += bank_Arraytwo[1];

                           bank_Arraytwo[1] = bank_queue.poll();

                           bank_g1 = 1;

                           customer_Servedtwo++;

                       }

                   }

                

                   while(bank_h1 == 1)

                   {

                       bank_c1 = BI;

                       bank_h1 = 0;

                   }

                

                   if ((BI - bank_c1) >= bank_Arraytwo[2])

                   {

                       bank_Array[2] = true;

                       if (bank_Array[2] == true && bank_queue.isEmpty() == false)

                       {

                           occupied_Timethree += bank_Arraytwo[2];

                           bank_Arraytwo[2] = bank_queue.poll();

                           bank_h1 = 1;

                           customer_Servedthree++;

                       }

                   }

                 

                   while(bank_i1 == 1)

                   {

                       bank_d1 = BI;

                       bank_i1 = 0;

                   }

                

                   if ((BI - bank_d1) >= bank_Arraytwo[3])

                   {

                       bank_Array[3] = true;

                       if (bank_Array[3] == true && bank_queue.isEmpty() == false)

                       {

                           occupied_Timefour += bank_Arraytwo[3];

                           bank_Arraytwo[3] = bank_queue.poll();

                           bank_i1 = 1;

                           customer_Servedfour++;

                       }

                   }

                 

                 

                 while(bank_j1 == 1)

                   {

                       bank_e1 = BI;

                       bank_j1 = 0;

                   }

              

                   if ((BI - bank_e1) >= bank_Arraytwo[4])

                   {

                       bank_Array[4] = true;

                       if (bank_Array[4] == true && bank_queue.isEmpty() == false)

                       {

                           occupied_Timefive += bank_Arraytwo[4];

                           bank_Arraytwo[4] = bank_queue.poll();

                           bank_j1 = 1;

                           customer_Servedfive++;

                       }

                   }

                   BI++;

                   if(bank_queue.size() == 1)

                   {

                       System.out.println("There is only " + bank_queue.size() + " person in the queue.");

                   }

                   else

                   {

                       System.out.println("There are " + bank_queue.size() + " people in the queue.");

                   }

                   System.out.println("There are " + (120 - BI) + " seconds left in the simulation.");

                   System.out.println("--------");

               }

           }

       };

       ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

       exec.scheduleAtFixedRate(bankRunnable, 0, 1, TimeUnit.SECONDS);

    }

    else if (choice.equals("no") || choice.equals("n"))

   {

     

        System.out.println("Ending Program");

        System.exit(0);     

    }

    else

   {     

        System.out.println("Invalid Response. Please Enter \"yes\" or \"no\": ");

    }

    }

    }

}