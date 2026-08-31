package com.myapp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        if ( args.length == 0 )
        {
            System.err.println( "Usage: myapp <name>" );
            System.exit( 1 );
        }
        System.out.println( args[0] + " is saying Hello World!" );
    }
}
