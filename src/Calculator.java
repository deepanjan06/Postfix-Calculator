import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calculator {
    
	private static float result = 0;
	private static int invalid = 0;
	private static int valid = 0; 
	private static float aggregate = 0;
	private static float highest = -Float.MAX_VALUE;
	private static float lowest= Float.MAX_VALUE;

	
	public static void main(String[] args) {
		
        String filename = "";
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Press K to read expressions keyboard or F to read expressions from a file");
		String user_input = keyboard.nextLine();
		String[] ui = user_input.split(" "); //splits user input
		//--------Evaluation from keyboard---------
		
		if (ui[0].equals("k") | ui[0].equals("K")) {
			while (true) {  //infinite loop that keeps asking for postfix expressions, until pressed enter  
				System.out.println("Enter an expression in post-fix notation: "); //if the user's input is valid, it asks for the expression
				String input = keyboard.nextLine();
				String[] elements = input.split(" ");   //splits the string 'input' with a space
				
				//----------------For statistics of keyboard----------------

				if (input.equals("")) {  //calls statistics method for calculation and display statistics of evaluated expression; line 453
					statistics();
					return;
				}
				//----------------------------------------------------------
				if (elements.length >= 3) {		//checks whether input elements are greater than or equal to 3, if not then shows error
					try {
						float num1, num2; //variable for first and second number of the expression
						
						int num3, num4; //number variables for binary operators
						
						num1 = Float.parseFloat(elements[0]); //parsing float variables num1 and num2 as string elements[0] and elements[1]
						num2 = Float.parseFloat(elements[1]);
								
						
						
						/*if the user enters +,-,*,/,>>,<<,&,|,% the program carry outs calculation 
						and prints result on the screen
				
						 valid++ counts every valid expression
				
						 evaluate(result) calls out evaluate method to record values of result; line 440	
				 		*/
										
						if (elements[2].equals("+")) {  
							result = num1 + num2;
							System.out.println(num1 + " " + "+" + " " + num2 + " " + "=" + " " + result);							
							valid++; 
							evaluate(result);
							
							
						} else if (elements[2].equals("-")) {  
							result = num1 - num2;
							System.out.println(num1 + " " + "-" + " " + num2 + " " + "=" + " " + result);							
							valid++;
							evaluate(result); 

						} else if (elements[2].equals("*")) { 
							result = num1 * num2;
							System.out.println(num1 + " " + "*" + " " + num2 + " " + "=" + " " + result);							
							valid++;
							evaluate(result);
						
						} else if (elements[2].equals("/")) {
							result = num1 / num2;
							System.out.println(num1 + " " + "/" + " " + num2 + " " + "=" + " " + result);							
							valid++;
							evaluate(result);
					}
					//---------------Binary operators----------------							
												
						//Parsing integers num3 and num4 as string elements[0] and elements[1] inside every else if loop
						
						else if (elements[2].equals("<<")) {
							num3 = Integer.parseInt(elements[0]);
							num4 = Integer.parseInt(elements[1]);
							int result;
							result  = (num3 << num4);
							System.out.println(num3 + " " + "<<" + " " + num4 + " " + "=" + " " + result);							
							valid++;
							evaluate(result);
						}
						
						else if (elements[2].equals(">>")) { 
							num3 = Integer.parseInt(elements[0]);
							num4 = Integer.parseInt(elements[1]);
							int result;
							result = (num3 >> num4);
							System.out.println(num3 + " " + ">>" + " " + num4 + " " + "=" + " " + result);							
							valid++;
							evaluate(result);
						}
						else if (elements[2].equals("%")) {
							num3 = Integer.parseInt(elements[0]);
							num4 = Integer.parseInt(elements[1]);
							int result;
							result = (num3 % num4);
							System.out.println(num3 + " " + "%" + " " + num4 + " " + "=" + " " + result);							
							valid++;
							evaluate(result);
						}
						else if (elements[2].equals("&")) { 
							num3 = Integer.parseInt(elements[0]);
							num4 = Integer.parseInt(elements[1]);
							int result;
							result = (num3 & num4);
							System.out.println(num3 + " " + "&" + " " + num4 + " " + "=" + " " + result);							
							valid++;
							evaluate(result);
						}
						else if (elements[2].equals("|")) {
							num3 = Integer.parseInt(elements[0]);
							num4 = Integer.parseInt(elements[1]);
							int result;
							result = (num3 | num4);
							System.out.println(num3 + " " + "|" + " " + num4 + " " + "=" + " " + result);							
							valid++;
							evaluate(result);
						}
																		
						else {
							System.out.println("Error! Invalid Expression: " + input); //Error prompt if the operator input is invalid
							System.out.println("");
							invalid++;     //invalid expression counter
							
						}
						
					} catch (NumberFormatException e) {
						System.out.println("Error! Invalid Expresion: " + input);   //Error prompt if the input are not numeric
						System.out.println("");
						invalid++;     //invalid expression counter
						
					}
				} 
				
				
				else if (elements.length < 3) {
					System.out.println("Error! Invalid Expression: " + input); //Error prompt if the input elements are greater than 3
					System.out.println("");
					invalid++;     //invalid expression counter
					
				}

			}
		}

		
		//---------------Evaluation from a text file-----------------
		
		else if (ui[0].equals("f") | ui[0].equals("F")) {
			while(true) {   //infinite loop that keeps asking for file name, until a valid one is entered
			try {
				System.out.println("Please enter file name: ");  //if the input matches f or F, asks for a file name
				filename = keyboard.nextLine();
				Scanner f = new Scanner(new File(filename));
				String exp = f.nextLine();
				String array[] = exp.split(" ");
				if (array.length >= 3) {    //checks if the array length is greater than or equal to 3
					try {
						float array1, array2;  //declaring array1 and array2 as float variables
						int array3, array4;		//integer variables for binary operators
						
						array1 = Float.parseFloat(array[0]);     //parsing float variables array1 and array2 as string array[0] and array[1]
						array2 = Float.parseFloat(array[1]);
						
						/*if the file contains +,-,*,/,>>,<<,&,|,% operators the program carry outs calculation 
						and prints result on the screen
				
						 valid++ counts every valid expression
				
						 evaluate(result) calls out evaluate method to record values of result; line 440
						*/
						
						if (array[2].equals("+")) {     //if-else loop to calculate the expression from the file
							result = array1 + array2;
							System.out.println("Postfix Expression: " + exp);
							System.out.println(array1 + " " + array[2] + " " + array2 + " = " + result);							
							valid++;
							evaluate(result);

						} else if (array[2].equals("*")) {
							result = array1 * array2;
							System.out.println("Postfix Expression: " + exp);
							System.out.println(array1 + " " + array[2] + " " + array2 + " = " + result);							
							valid++;
							evaluate(result);

						} else if (array[2].equals("/")) {
							result = array1 / array2;
							System.out.println("Postfix Expression: " + exp);
							System.out.println(array1 + " " + array[2] + " " + array2 + " = " + result);							
							valid++;
							evaluate(result);

						} else if (array[2].equals("-")) {
							result = array1 - array2;
							System.out.println("Postfix Expression: " + exp);
							System.out.println(array1 + " " + array[2] + " " + array2 + " = " + result);							
							valid++;
							evaluate(result);
						} 
						
						//------------Binary Operators------------------
						
						//Parsing integers array3 and array4 as string array[0] and array[1] inside every else if loop
						
						else if (array[2].equals(">>")) {
							array3 = Integer.parseInt(array[0]);						
							array4 = Integer.parseInt(array[1]);
							result = array3 >> array4;
							System.out.println("Postfix Expression: " + exp);
							System.out.println(array3 + " " + array[2] + " " + array4 + " = " + result);							
							valid++;
							evaluate(result);
						}
						else if (array[2].equals("<<")) {
							array3 = Integer.parseInt(array[0]);						
							array4 = Integer.parseInt(array[1]);
							result = array3 << array4;
							System.out.println("Postfix Expression: " + exp);
							System.out.println(array3 + " " + array[2] + " " + array4 + " = " + result);							
							valid++;
							evaluate(result);
						}
						else if (array[2].equals("%")) {
							array3 = Integer.parseInt(array[0]);						
							array4 = Integer.parseInt(array[1]);
							result = array3 % array4;
							System.out.println("Postfix Expression: " + exp);
							System.out.println(array3 + " " + array[2] + " " + array4 + " = " + result);							
							valid++;
							evaluate(result);
						}
						else if (array[2].equals("&")) {
							array3 = Integer.parseInt(array[0]);						
							array4 = Integer.parseInt(array[1]);
							result = array3 & array4;
							System.out.println("Postfix Expression: " + exp);
							System.out.println(array3 + " " + array[2] + " " + array4 + " = " + result);							
							valid++;
							evaluate(result);
						}
						else if (array[2].equals("|")) {
							array3 = Integer.parseInt(array[0]);						
							array4 = Integer.parseInt(array[1]);
							result = array3 | array4;
							System.out.println("Postfix Expression: " + exp);
							System.out.println(array3 + " " + array[2] + " " + array4 + " = " + result);							
							valid++;
							evaluate(result);
						}
						
						else {
							System.out.println("Error! Invalid Expression: " + exp); //Error prompt if the operator is invalid
							System.out.println("");
							invalid++;     //invalid expression counter
							

						}
					} catch (NumberFormatException e) {
						System.out.println("Error! Invalid Expresion: " + exp);   //Error prompt if the input are not numeric
						System.out.println("");
						invalid++;      //invalid expression counter
						

					}
				} else if (array.length < 3) {
					System.out.println("Error! Invalid Expression: " + exp);  //Error prompt if the input length is greater than 3
					System.out.println("");
					invalid++;     //invalid expression counter
					
				}
				
				while (f.hasNext()) {    //while loop to calculate the rest of the lines in the file
					String exp2 = f.nextLine();
					String ar[] = exp2.split(" ");
					if (ar.length >= 3) {   //checks if the length of the array is greater than or equal to 3
						try {				
							float ar1, ar2;
							int ar3, ar4;
							
							ar1 = Float.parseFloat(ar[0]);		//parsing variables ar1 and ar2 as string ar[0] and ar[1]
							ar2 = Float.parseFloat(ar[1]);	
							
							/*if the rest of the lines contains +,-,*,/,>>,<<,&,|,% operators the program carry outs calculation 
							and prints result on the screen
					
							 valid++ counts every valid expression
					
							 evaluate(result) calls out evaluate method to record values of result; line 440
							*/
							if (ar[2].equals("+")) {
								
								result = ar1 + ar2;
								System.out.println("Postfix Expression: " + exp2);
								System.out.println(ar1 + " " + ar[2] + " " + ar2 + " = " + result);
								System.out.println("");								
								valid++;
								evaluate(result);
								
							} else if (ar[2].equals("*")) {
								result = ar1 * ar2;
								System.out.println("Postfix Expression: " + exp2);
								System.out.println(ar1 + " " + ar[2] + " " + ar2 + " = " + result);
								System.out.println("");								
								valid++;
								evaluate(result);
								
							} else if (ar[2].equals("/")) {
								result = ar1 / ar2;
								System.out.println("Postfix Expression: " + exp2);
								System.out.println(ar1 + " " + ar[2] + " " + ar2 + " = " + result);
								System.out.println("");								
								valid++;
								evaluate(result);
								
							} else if (ar[2].equals("-")) {
								result = ar1 - ar2;
								System.out.println("Postfix Expression: " + exp2);
								System.out.println(ar1 + " " + ar[2] + " " + ar2 + " = " + result);
								System.out.println("");								
								valid++;
								evaluate(result);
							} 
							
							//---------------Binary Operators------------------
						
							//Parsing integers ar3 and ar4 as string ar[0] and ar[1]

							else if (ar[2].equals(">>")) {
								ar3 = Integer.parseInt(ar[0]);						
								ar4 = Integer.parseInt(ar[1]);
								result = ar3 >> ar4;
								System.out.println("Postfix Expression: " + exp2);
								System.out.println(ar3 + " " + ar[2] + " " + ar4 + " = " + result);
								System.out.println("");								
								valid++;
								evaluate(result);
							}
							else if (ar[2].equals("<<")) {
								ar3 = Integer.parseInt(ar[0]);						
								ar4 = Integer.parseInt(ar[1]);
								result = ar3 << ar4;
								System.out.println("Postfix Expression: " + exp2);
								System.out.println(ar3 + " " + ar[2] + " " + ar4 + " = " + result);
								System.out.println("");								
								valid++;
								evaluate(result);
							}
							else if (ar[2].equals("%")) {
								ar3 = Integer.parseInt(ar[0]);						
								ar4 = Integer.parseInt(ar[1]);
								result = ar3 % ar4;
								System.out.println("Postfix Expression: " + exp2);
								System.out.println(ar3 + " " + ar[2] + " " + ar4 + " = " + result);
								System.out.println("");								
								valid++;
								evaluate(result);
							}
							else if (ar[2].equals("&")) {
								ar3 = Integer.parseInt(ar[0]);						
								ar4 = Integer.parseInt(ar[1]);
								result = ar3 & ar4;
								System.out.println("Postfix Expression: " + exp2);
								System.out.println(ar3 + " " + ar[2] + " " + ar4 + " = " + result);
								System.out.println("");							
								valid++;
								evaluate(result);
							}
							else if (ar[2].equals("|")) {
								ar3 = Integer.parseInt(ar[0]);						
								ar4 = Integer.parseInt(ar[1]);
								result = ar3 | ar4;
								System.out.println("Postfix Expression: " + exp2);
								System.out.println(ar3 + " " + ar[2] + " " + ar4 + " = " + result);
								System.out.println("");								
								valid++;
								evaluate(result);
							}
							
							else {
								System.out.println("Error! Invalid Expression: " + exp2);
								System.out.println("");  //Error prompt if the operator is invalid
								invalid++;     //invalid expression counter
								

							}
							
						} catch (NumberFormatException e) {
							System.out.println("Error! Invalid Expresion: " + exp2);
							System.out.println("");    //Error prompt if the first two inputs are not numbers
							invalid++;     //invalid expression counter
							

						}

					} else if (ar.length < 3) {
						System.out.println("Error! Invalid Expression: " + exp2);
						System.out.println("");   //Error prompt if length of the array length is less than 3
						invalid++;     //invalid expression counter
						

					}
				
				}
				//----------------For statistics of file----------------

				statistics();     //calls statistics method to display statistics of the evaluated expressions; line 453
				return;
			}
			//------------------------------------------------------------			
			
			catch (FileNotFoundException e) {        //If the file is not found, shows an error
				System.out.println("Error: File does not exist, please re-enter: ");
				filename = keyboard.nextLine();		
				//If the filename is invalid or not found, it asks the user to re-enter the filename
				}
			}
		}
			else {
			System.out.println("Wrong user input! Program terminating.");//Error prompt if the user enters anything other than k or f
			keyboard.close();
			return;
		}
		
	}
	
	//----------Statistics calculation
	public static float evaluate(float result){
		
		aggregate += result;     //calculates the aggregate of all the results
		
        if (result > highest) {     
            highest = result;	//records the highest result
        }
        if (result < lowest) {
            lowest = result;	//records the lowest result
        }
        return result;
	}
	//--------------------Statistics result display------------------
	private static void statistics() {
		if (valid != 0) {    //displays statistics if there is one or more valid results
        	System.out.println("Evaluation complete");
			System.out.println("-----------------------------------------");
			System.out.println("Highest result: " + highest);	//prints the highest result
	        System.out.println("Lowest result: " + lowest);	  //prints the lowest result
	        System.out.println("Aggregate result: " + (aggregate));		//prints the aggregate of all results
	        System.out.println("Average result: "+ (aggregate/valid));		//prints the average of all results
	        System.out.println("Valid expressions: " + valid); 	//prints the total no. of valid results
	        System.out.println("Invalid expressions: " + invalid); 	//prints the total no. of invalid results
        	}
        
        else {     //if there no valid expression then displays highest, lowest, aggregate and average as N/A
        	
        	System.out.println("Evaluation complete");
			System.out.println("-----------------------------------------");
			System.out.println("Highest result: " + "N/A");   //prints the highest result as N/A
			System.out.println("Lowest result: " + "N/A");   //prints the lowest result as N/A
			System.out.println("Aggregate result: " + aggregate);   //prints the aggregate result as N/A
	        System.out.println("Average result: "+ "N/A"); 	   //prints the average result as N/A 
	        System.out.println("Valid expressions: " + valid); 	//prints the total no. of valid results
	        System.out.println("Invalid expressions: " + invalid); 	//prints the total no. of invalid results
        }
	}	
}
