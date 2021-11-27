/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dec2bin;

import java.util.*;




/**
 *
 * @author Donna
 */
public class Dec2Bin {
    static Scanner sc=new Scanner(System.in);
    static long origVal;

    public static void main(String[] args) {
        long decVal;
        int cType; //conversion type 1=recursive 2=string 3=array
        System.out.println("Convert decimal values to binary");
        decVal = getDecimalValue();
        while (decVal != 0 ) {
            cType = getConvertType();
            origVal = decVal;
            switch (cType) {
                case 1:
                    convertByRecursion(decVal);
                    break;
                case 2:
                    convertByString(decVal);
                    break;
                case 3:
                    convertByArray(decVal);
                    break;
            }
            
            System.out.println("\n");
            decVal = getDecimalValue();

        }
        System.out.println("\nThanks for using the decimal converter.");
    } //end of main



    public static void convertByRecursion(long decVal)  {
        int r; //r=remainder
        long nextVal;
        nextVal = decVal /2; //integer division
        r = (int)(decVal % 2); //long to modulus into integer so explicitly cast as integer
        System.out.println("Decimal  " + decVal + " divided by 2 equals " + nextVal + " with a remainder of: " + r);
        if (nextVal > 0) {
               convertByRecursion(nextVal);
       } else {
               System.out.print("\nTherefore the binary value of " + origVal + " is: ");
       }
       System.out.print(r);
    } //end convertByRecursion
    
    public static void convertByString(long decVal)  {
        int r; //r=remainder
        String b=""; //b=binary string - initialize
        long nextVal;
        do {
            nextVal = decVal /2; //integer division
            r = (int)(decVal % 2); //long to modulus into integer so explicitly cast as integer
            System.out.println("Decimal  " + decVal + " divided by 2 equals " + nextVal + " with a remainder of: " + r);
            b = String.valueOf(r) + b;
            decVal = nextVal;
          } while (decVal > 0);
           System.out.println("\nTherefore the binary value of " + origVal + " is: " + b);

    } //end convertByString

    public static void convertByArray(long decVal)  {
        int[] r = new int[32]; //new integer array of 32 positions
        int i=0; 
        String b=""; //b=binary string - initialize
        long nextVal;
        long maxval = (long) (Math.pow(2,32) - 1); //implicitly cast as long
                if (decVal > maxval) {
                  System.out.println("Maximum conversion value for array method = " + maxval + " too large .");
                }else {
                        do {
                            nextVal = decVal /2; //integer division
                            r[i] = (int)(decVal % 2); //long to modulus into integer so explicitly cast as integer
                            System.out.println("Decimal  " + decVal + " divided by 2 equals " + nextVal + " with a remainder of: " + String.valueOf(r[i]) );
                            i++;                         
                            //print line and use r[i] and then increment counter
                            decVal = nextVal;
                        } while (decVal != 0);
                 } //endif 
              
               for (int j=i-1; j >=0; j--) 
                   // set index to end of array, decrease AFTER loop until index is at beginning/zero
               {
                   b = b + (r[j]);  //concatenate array alements while reading backwards
               }
  
            System.out.println("\nTherefore the binary value of " + origVal + " is: " + b);

} //end class

            // *****convertByArray***********
            //while nextVal != 0
            //interger division
            //place remainder into array with a subscript of loop counter
            //continue until nextVal = 0 - can't divide by zero
            //display contents of array in reverse order (calc creates binary in revers, so read/print array)
            // *******************************
   

    public static long getDecimalValue() {
        long dV;
        do {
            try {
               System.out.println("\nPlease enter your decimal value to be converted (0 to quit): ");
               dV = sc.nextLong();
               if (dV < 0) { //check for positive integers
                   System.out.println("Please enter non-negative values.");
               }
            } catch (Exception e) {
                System.out.println("Illegal input - integers only please.");
                dV = -1;
                sc.next();
            }
        } while (dV < 0);
        return dV;

        } // end getDecimalValue

    public static int getConvertType()  {
        int cType;
        do {
            try {
               System.out.println("Enter conversion type 1=Recursive, 2=String, 3=Array");
               cType = sc.nextInt();
               if (cType < 1 || cType > 3 ) { //check for positive integers
                   System.out.println("Please enter 1, 2 or 3.");
               }
            } catch (Exception e) {
                System.out.println("Illegal input - integers only please.");
                cType = -1;
                sc.next();
            }
            } while (cType < 1 || cType > 3);
        return cType;

    }//end of getConvertType


} //end of  class



