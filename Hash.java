import java.util.*;
public class Hash {
    public static int asciiValues(String input)
    {
        int sum=0;
        for(int i=0;i<input.length();i++)
        {
          
            char ch=input.charAt(i);
            int value=(int)ch;
            System.out.println("ascii value of character "+ch+" is "+value);
            sum+=value;
        }
        return sum;
    }

    public static int hash(int asciisum,int tableSize)
    {
      return asciisum%tableSize;

    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter table size");
        int tableSize=sc.nextInt();
        System.out.println("input string");
        String input=sc.next();

        int asciisum=asciiValues(input);

        int hashValue=hash(asciisum,tableSize);
        System.out.println("hash value of "+input+" is "+hashValue);
    }
    
}