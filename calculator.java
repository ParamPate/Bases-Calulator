/* 
 * Param Patel
 * 
 */
class calculator 
{
  public static void main(String[]args)
  {
    String start; 
    do
    {
      System.out.println("Welcome to the different base calculator"); 
      System.out.println("Enter (1) to use the calculator"); 
      System.out.println("Enter (stop) to exit the program");
      start = In.getString(); 
      start = start.toLowerCase(); 
      if(start.equals("1"))
      {
        display(); 
      }
      if(start.equals("1") == false && start.equals("stop")==false )
      {
        System.out.println("Invalid input"); 
      }
    }
    while(start.equals("stop")==false);
    System.out.println("Goodbye");
  }
  
  
  public static void display()
  {
    
    System.out.println("Enter the base for both integers, integer, operand, integer and output base");
    String userInput = In.getString();
    while(properFormat(userInput) == false) 
    {
      System.out.println("Incorrect Input, only enter numbers and operands");
      userInput = In.getString();
    }
    
    while(spaceCheck(userInput) == false)
    {
      System.out.println("Incorrect Input, Make sure to only put one space between each value");
      userInput = In.getString();
    }
    
    String [] input = inputFinder(userInput); // 0 base, 1 num1, 2 operand, 3 num2, 4 outbase 
    int base = Integer.parseInt(input[0]); 
    int outBase = Integer.parseInt(input[4]); 
    validBase(base);
    input[1] = deciValid(input[1], base);
    
    if(!(input[2].equals("+")||input[2].equals("-")||input[2].equals("/")||input[2].equals("*")))
    {
      while((!(input[2].equals("+") || input[2].equals("-") || input[2].equals("/") || input[2].equals("*"))))
      {
        System.out.println("Please enter a valid operand"); 
        input[2] = In.getString(); 
      }
    }  
    input[3] = deciValid(input[3], base);
    validBase(outBase);
    
    
    
    int deci1 = toDecimal(input[1],base); 
    int deci2 = toDecimal(input[3],base); 
    int cal = calculations(input[2], deci1, deci2);
    if(input[2].equals("/"))
    {
      int r = deci1%deci2;
      int output = getValueInBase(cal,outBase);
      System.out.println(input[1] + "(base " + base + ") " + input[3] + " (base " + base+")");
      System.out.println("= " + deci1 +" "+ input[2] +" "+ deci2);
      System.out.println("= " + output +" R " + r+ " (base " + outBase +")");
    }
    else
    {
      int output = getValueInBase(cal,outBase);
      System.out.println(input[1] + "(base " + base + ") " + input[3] + " (base " + base+")");
      System.out.println("= " + deci1 +" "+ input[2] +" "+ deci2);
      System.out.println("= " + output +" (base " + outBase +")");
      
    }
  }
  public static boolean properFormat(String num)
  {
    String valids = "1234567890+-/*%";
    for(int i = 0; i<num.length(); i++)
    {
      for(int k = 0; k<valids.length(); k++)
      {
        if(num.charAt(i) == valids.charAt(k))
        {
          return true;
        }
      }
    }
    return false;
  }
  public static boolean spaceCheck(String num)
  {
    for(int i = 0; i<num.length(); i++)
    {
      if(num.charAt(i) == (' '))
      {
        if(num.charAt(i+1) == (' '))
        {
          return false;
        }
      }
    }
    return true; 
  }
  
  
  
  
  public static boolean validBase(int base)
  {
    if(2>=base && 10<= base)
    {
      return true;
    }
    while(base < 2 && 10 < base)
    {
      System.out.println("Your base was not between 2 and 10");//<-------------------------------------------------------------------
      base = In.getInt();  
    }
    return false;
  }
  
  public static String deciValid(String num, int base)
  {
    int k = Integer.parseInt(num);
    int counter = 0;
    while(k>0) {
      int remainder = k % 10;
      if( remainder > base-1)
      {
        counter++;
      }
      k = k / 10;    
    } 
    if(counter>0)
    {
      System.out.println("Please enter a valid number"); 
      num = In.getString(); 
    }
    return num;
  }
  
  
  public static int toDecimal(String num, int base) 
  {
    int decimal = 0;  
    for(int i = 0; i<num.length(); i++)
    {
      decimal += Math.pow(base,num.length() - i)*Integer.parseInt(num.substring(i,i+1));
    }
    decimal =decimal/base;
    return decimal;
  }
  public static int getValueInBase(int num, int base) {
    int total = 0;
    int multiple10 = 1; //to go to next place value
    while (num > 0) {
      int remainder = num % base;
      num = num / base;
      total = total + (remainder * multiple10);
      multiple10 *= 10;
    }
    return total;
    
  }
  public static String[] inputFinder(String s) 
  {
    String[]a = new String[5];
    int i = 0;
    int space = s.indexOf(' '); 
    
    while(space != -1)
    {
      String valueforarray =  s.substring(0,space);
      a[i] = (valueforarray);
      
      String newString = s.substring(space+1,s.length()); 
      
      space = newString.indexOf(' ');
      
      s = newString; 
      i++;
    }
    a[i] = s;
    return a; 
  }
  public static int calculations(String operand,int num1,int num2)
  {
    if(operand.equals("+") == true)
    {
      return num1 + num2;
    }
    if(operand.equals("-") == true)
    {
      return num1-num2;
    }
    if(operand.equals("*") == true)
    {
      return num1*num2; 
    }
    if(operand.equals("/") == true)
    {  
      return num1/num2;
    }
    if(operand.equals("%") == true)
    {
      return num1%num2; 
    }
    else return -1; 
  }
}
















