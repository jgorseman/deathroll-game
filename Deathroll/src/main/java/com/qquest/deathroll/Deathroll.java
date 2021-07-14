/*
 * MIT License
 * 
 */
package com.qquest.deathroll;
import java.util.*;
/**
 *
 * @author Jorrit Gorseman
 */
public class Deathroll {
    static int input;
    static int playerResult = 0;
    static int computerResult = 0;
    static int rollTimes = 0;
    static boolean chosenToKeep = false;
    
    public static void main(String[] args) {
        game();
    }
    
    public static void game() {
        String choice = "";
        
        System.out.println("DEATHROLL");
        
        System.out.println("");
        System.out.println("Deathrolling is a luck-based game played by rolling between one and a chosen number.");
        System.out.println("You start by choosing a number to start rolling from, and whoever's next rolls from the number you roll.");
        System.out.println("The goal is to roll as low as possible without rolling 1. You get the choice to continue rolling after each of your rolls, or to stop.");
        System.out.println("If you stop, the computer keeps rolling until it either rolls lower than you (which means you lose) or rolls 1, in which case you win.");
        System.out.println("Whoever reaches 1 first loses. Good luck!");
        
        System.out.println("");
        
        int gamesPlayed = 0;
        int gamesWon = 0;
        int gamesLost = 0;
        
        boolean start = true;       
        while (start) {          
            rollTimes = 0;
            chosenToKeep = false;
            playerResult = 0;
            computerResult = 0;
            gamesPlayed++;
            
            System.out.println("Choose a number to roll from: ");
        
            Scanner sc= new Scanner(System.in);    
            input = sc.nextInt();
        
            System.out.println("");
            System.out.println("You have chosen " + input + ".");
            
            while (playerResult != 1 && computerResult != 1) {
                
                if (rollTimes >= 1 && !chosenToKeep) {
                    System.out.println("");
                    System.out.println("Computer rolled " + computerResult + ". Continue rolling (r) or keep (k) your own roll (" + playerResult +")?");
                    Scanner scanTwo= new Scanner(System.in);    
                    String inputTwo = scanTwo.nextLine();
                    if (inputTwo.equals("k")) {
                        chosenToKeep = true; 
                    }
                }
                
                if (chosenToKeep == false) {
                    playerRollNumber(input);
                    if (playerResult != 1) {
                        computerRollNumber(input);  
                    }
                } else {
                    computerRollFurther(input);
                }
                
                
                if (playerResult == 1 || ((computerResult < playerResult) && chosenToKeep && computerResult != 1)) {
                    System.out.println("");
                    System.out.println("You lost.");
                    gamesLost++;
                    break;
                }             
                
                if (computerResult == 1) {                   
                    System.out.println("");
                    System.out.println("You won!");
                    gamesWon++;
                    break;
                }
            }
            
            System.out.println("");
            System.out.println("You've played " + gamesPlayed + " games.");
            System.out.println("Won: " + gamesWon);
            System.out.println("Lost: " + gamesLost);
            System.out.println("");
            choice = "";
            
            while (!choice.equals("y") && !choice.equals("n")) {
                System.out.println("Wanna try again? Enter y/n:");           
            
                Scanner sc2= new Scanner(System.in);
                choice = sc2.nextLine();
                                
                if (choice.equals("y")) {
                    start = true;
                    System.out.println("");
                    break;
                } else if (choice.equals("n")) {
                    start = false;
                    break;
                } else {
                    continue;
                }
            }
            
        }
        System.out.println("");
        System.out.println("Thanks for playing!");
    }     
    
    public static int getRandomNumber(int max){
        Random r = new Random();
        return r.nextInt(max)+ 1;         
    }
    
    public static void playerRollNumber(int x) { 
        
            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {}

            System.out.println("");
            System.out.println("Rolling between 1 and " + input + "...");

            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {}

            playerResult = getRandomNumber(input);
            System.out.println("You rolled: " + playerResult);               
            input = playerResult;
            rollTimes++;
        
    }
    
    public static void computerRollNumber(int x) {
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {}
        
        System.out.println("");
        System.out.println("Computer rolling between 1 and " + input + "...");
        
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {}
        
        computerResult = getRandomNumber(playerResult);                
        System.out.println("Computer rolled: " + computerResult);               
        input = computerResult;       
    }
    
    public static void computerRollFurther(int x) {
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {}
        
        System.out.println("");
        System.out.println("Computer rolling between 1 and " + input + "...");
        
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {}
        
        computerResult = getRandomNumber(computerResult);                
        System.out.println("Computer rolled: " + computerResult);               
        input = computerResult;       
    }
}
