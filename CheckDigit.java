import java.util.ArrayList;

public class CheckDigit
{
    /** Returns the check digit for num
    * Precondition: The number of digits in num is between one and six, inclusive.
    * num >= 0
    */       
    public static int getCheck(int num)
    {
        int checkDigit = 0;       
        int sum = 0;
        String scannableNum = "" + num;
        /*
         * scan original number, right-to-left,
         * isolate each digit, multiply * factor(1 or 2)
         * and sum each individual digit
         */
        int factor = 2;        
        for(int i = scannableNum.length() - 1; i >= 0; i--)
        {
            int digit = Integer.parseInt("" + scannableNum.charAt(i));
            digit = digit * factor;
            
            // sum individual digits of factored digit
            String factoredDigit = "" + digit;            
            for(int j = 0; j < factoredDigit.length(); j++)
            {
                digit = Integer.parseInt("" + factoredDigit.charAt(j));
                sum += digit;
            }            
            
            // toggle factor between 1 and 2 as we go through the individual digits
            if(factor == 2) factor = 1;
            else            factor = 2;
        }
        
        // get whole number of 7's
        int div = sum / 7;
        // check digit is how much more it takes to get to the next highest multiple of 7
        checkDigit = sum - (7 * div);
        
        return checkDigit;
    }
    
    /** Returns true if numWithCheckDigit is valid, or false otherwise,
    * as described in part (a)
    * Precondition: The number of digits in numWithCheckDigit is
    * between two and seven, inclusive.
    * numWithCheckDigit >= 0
    */
    public static boolean isValid(int numWithCheckDigit)
    { 
        // make a copy of the number as a string so we can scan each digit
        String snum = "" + numWithCheckDigit;
        
        // extract the last digit
        String schk = snum.substring(snum.length()-1);
        int inputCheckDigit = Integer.valueOf(schk);
        
        // separate the rest of the number from the last digit        
        snum = snum.substring(0, snum.length()-1 );               
        int num = Integer.valueOf(snum);
        
        // calculate the check digit
        int calculatedCheckDigit = getCheck(num);
        
        // if the calulated value matches the incoming one, return true;
        // otherwise, return false.
        return calculatedCheckDigit == inputCheckDigit;
    }
    
}
