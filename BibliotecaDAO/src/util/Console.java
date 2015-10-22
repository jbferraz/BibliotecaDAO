package util;

import java.util.Scanner;

/**
 *
 * @author 771400163
 */
public class Console {
	
    /**
     *
     * @param out
     * @return
     */
    public static String scanString(Object out)
	{
		System.out.print(out);
		Scanner scanner = new Scanner (System.in);
		return(scanner.nextLine());
	}
	
    /**
     *
     * @param out
     * @return
     */
    public static int scanInt(Object out)
	{
		System.out.print(out);
		Scanner scanner = new Scanner (System.in);
		return(scanner.nextInt());		
	}

    /**
     *
     * @param out
     * @return
     */
    public static double scanDouble(Object out)
	{
		System.out.print(out);
		Scanner scanner = new Scanner (System.in);
		return(scanner.nextDouble());		
	}

    /**
     *
     * @param out
     * @return
     */
    public static float scanFloat(Object out)
	{
		System.out.print(out);
		Scanner scanner = new Scanner (System.in);
		return(scanner.nextFloat());		
	}

    /**
     *
     * @param out
     * @return
     */
    public static boolean scanBoolean(Object out)
	{
		System.out.print(out);
		Scanner scanner = new Scanner (System.in);
		return(scanner.nextBoolean());		
	}
	
    /**
     *
     * @param out
     * @return
     */
    public static char scanChar(Object out)
	{
		System.out.print(out);
		Scanner scanner = new Scanner (System.in);
		return(scanner.next().charAt(0));				
	}
        
	
}
