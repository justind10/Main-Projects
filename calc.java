import java.util.*;
public class calc {
/*This program will accept an infix expression from the user
and them for a value of x that will use the infix expression to produce a result.
*/
        private Stack <Character> s; //the stack
        public static void main(String[] args) 
        {
            calc p = new calc(); //for calculator
            p.Execute(); 

        }

        //Execution of the program
        public void Execute()
        {
            System.out.println("Please enter infix equation (Please enter negative numbers as (0-X) if you use any: \n");
            String k = forPostfix(input());
            System.out.println("Enter a value for X: ");
            int x = inputInteger();
            evaluatePostfix(k,x);
        }

        //Converts user input into a string and returns it to main.
        public String input()
        {
            Scanner input = new Scanner(System.in);
            String str = input.nextLine();
            return str;
        }

        //Converts user input into a integer value and returns it.
        public int inputInteger()
        {
            Scanner input = new Scanner(System.in);
            int in = input.nextInt();
            return in;
        }

        //This merthod converts infix to postfix.
        public String forPostfix(String str)
        {
            String postfix = "";
            String pfix = "";
            s = new Stack<Character>();
            int right = 0;
            int left = 0;
            char previous = str.charAt(0);

            str = str.replaceAll("\\s",""); 
            str = str.toLowerCase();

            for(int i = 0; i < str.length(); i++)
            {
                char c = str.charAt(i);

                char last = str.charAt(str.length() - 1);

                /*This statement checks the last character of the infix expression. 
                 *If operator, informs the user
                	and terminates program.*/
                if (isOperator(last))
                {
                    System.out.print("\nError in expression!! Last token must be an operand.");
                    System.exit(1);
                }

                /*This statement checks for periods within the string. 
                 * If a period is found, informs the user
                	and terminates program.*/
                if(str.indexOf('.') != -1)
                {
                    System.out.print("\nError in expression!! Cannot accept floating point numbers.");
                    System.exit(1);
                }

                if (isOperator(c))
                {
                    if(previous!=')'|| previous!='(')
                    {
                        pfix += " ";
                    }

                    /*This statement checks for missing operator between parentheses.
                     *  If missing, informs the user
                    	and terminates program */
                    if(previous == '(')
                    {
                        System.out.print("\nError in expression!! No operator between operand and left parentheses.");
                        System.exit(1);
                    }

                    //checks to see if operator is preceded by another operator.
                    if(isOperator(previous))
                    {
                        System.out.print("\nError in expression!! An operator cannot be preceded by another operator.");
                        System.exit(1);
                    }

                    while(!s.isEmpty() && s.peek()!='(' && highPriority(s.peek(),c))
                    {
                        postfix += s.peek();
                        pfix += s.peek();
                        s.pop();
                    }
                    s.push(c);
                }

                else if(isOperand(c))
                {
                    postfix += c;
                    pfix += c;
                }

                else if( c =='(' )
                {
                    left++;
                    s.push(c);
                }

                else if( c ==')' )
                {
                    right++;

                    /*This statement checks for missing parentheses. 
                     * If missing, informs the user
                    	and terminates program */
                    if(right>left)
                    {
                        System.out.print("\nError in expression!! No matching left parentheses for a right parentheses.");
                        System.exit(1);
                    }

                    while(!s.isEmpty() && s.peek() != '(')
                    {
                        postfix += s.peek();
                        pfix += s.peek();
                        s.pop();
                    }
                    s.pop();
                }
                previous = c;
            }

            while(!s.isEmpty())
            {
                postfix += s.peek();
                pfix += s.peek();
                s.pop();
            }

            /*This statement checks for missing parentheses. 
             * If missing, informs the user
            	and terminates program */
            if( isRightFormat(right,left) > 0)
            {
                System.out.println("\nError in expression!! No matching left parentheses for a right parentheses.");
                System.exit(1);
            }

            /*This statement checks for missing parentheses on the right side. 
             * If missing, informs the user
            	and terminates program */
            if( isRightFormat(right,left) < 0)
            {
                System.out.println("\nError in expression!! No matching right parentheses for a left parentheses.");
                System.exit(1);
            }

            System.out.print("Converted Expression: "+postfix+"\n");
            return pfix; //returns string in postfix
        }

        //Method calculates the value of the postfix expression. uses string and integer captured from user input
        public void evaluatePostfix(String str, int x)
        {
            Stack<Integer> stack = new Stack <Integer>();
            String optione1 = "";
            String optione2 = "";
            int option1, option2, option;
            int count = 0;
            String cstr = "";
            int result = 0;
            char previous = str.charAt(0);

            String var = Integer.toString(x);    //converts integer to string
            str = str.replaceAll("x",var);       //replaces x with input value


            for (int j =0;j<str.length(); j++)
            {
                char c = str.charAt(j);
                if(c==' ' && isOperator(previous))
                {
                    continue;
                }

                if(isOperator(c) && previous==' ')
                {
                    cstr = cstr.substring(0,cstr.length() -1) + c;
                }
                else cstr += c;
                previous = c;
            }

            previous = cstr.charAt(0);

            for(int i = 0; i<cstr.length(); i++)
            {
                char c = cstr.charAt(i);

                if(isOperand(c))
                {
                    if(count%2==0)
                    {
                        optione1 += c;
                    }
                    else
                    {
                        optione2 += c;
                    }
                }

                else if(c==' ' && count%2==0 || !isOperator(previous) && isOperator(c) && count%2==0)
                {
                    count++;
                    option = Integer.parseInt(optione1);
                    stack.push(option);
                    optione1 = "";
                }

                else if(c==' ' && count%2!=0 || !isOperator(previous) && isOperator(c) && count%2!=0)
                {
                    count++;
                    option = Integer.parseInt(optione2);
                    stack.push(option);
                    optione2 = "";
                }

                if(isOperator(c)) //operator switch
                {
                    option2 = stack.peek();
                    stack.pop();

                    option1 = stack.peek();
                    stack.pop();

                    switch (c) //switch
                    {
                        case '/': result = option1 / option2; break;
                        case '*': result = option1 * option2; break;
                        case '^': result = (int) Math.pow(option1, option2); break;
                        case '+': result = option1 + option2; break;
                        case '-': result = option1 - option2; break;
                        case '%': result = option1 % option2; break;
                        default:
                            break;
                    }
                    stack.push(result);
                }

                previous = c;
            }

            result = stack.peek();
            stack.pop();

            System.out.println("The result is: "+result+"\n");
        }

        //Method to verify if a character is an operand or not.
        public boolean isOperand(char c)
        {
            if(c >= '0' && c <= '9') return true;
            if(c >= 'a' && c <= 'z') return true;
            if(c >= 'z' && c <= 'Z') return true;
            else return false;
        }


        //Method to verify if a character is an operator or not.
        public boolean isOperator(char option)
        {
            switch(option)
            {
                case '+': return true;
                case '-': return true;
                case '/': return true;
                case '*': return true;
                case '%': return true;
                default: return false;
            }
        }

        //Method to determine the highest priority of two operators
        public boolean highPriority(char option1, char option2)
        {
            int op1Weight = priorityLevel(option1);
            int op2Weight = priorityLevel(option2);

            if(op1Weight < op2Weight)
                return false;
            else
                return true;
        }


        //Method to set priority to operators
        public int priorityLevel(char option)
        {
            int pl;
            switch(option)
            {
                case '+': case'-': pl =1; break;
                case '*': case'/': case'%': pl=2; break;
                default: pl = -1;
            }
            return pl;
        }

        //method to make sure equation is correct
        public int isRightFormat(int r, int l)
        {
            if (r == l) return 0;
            if (r > l) return 1;
            else return -1;
        }
        //In conclusion, this program should accept infixes and solve their postfix
        // expressions similar to the way a desmos calculator would.
        
    }
