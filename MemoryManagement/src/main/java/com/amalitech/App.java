package com.amalitech;

import static com.amalitech.UserGenerator.generateUser;

/**
 * Hello world!
 *
 */
public class App 
{
//    private static final MovieQuoteService movieQuoteService = new MovieQuoteService();
    private static final MovieQuoteOptimized movieQuoteOptimized = new MovieQuoteOptimized();
    static{
//        movieQuoteService.start();
        movieQuoteOptimized.start();
    }
    public static void main( String[] args )
    {
        while(true){
            User user = generateUser();
            System.out.println(user.getFullName() + " logged in");
//            user.subscribe(movieQuoteService);
            user.subscribe(movieQuoteOptimized);
            userUsingService();
            System.out.println(user.getFullName() + " logged out");
        }
    }

    private static void userUsingService(){
        try{
            Thread.sleep(10);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
