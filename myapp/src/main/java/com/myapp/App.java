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
        
        String version = App.class.getPackage().getImplementationVersion();
        if (version == null) {
            version = "unknown";
        }
        
        System.out.println( args[0] + " is saying Hello World (Version: " + version + ") and bye" );
    }
}
