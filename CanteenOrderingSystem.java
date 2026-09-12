//Coding Exercise: Canteer Ordering System

import java.util.Scanner;

public class CanteenOrderingSystem{
    public static void main(String[]args){

        Scanner input = new Scanner(System.in);

        System.out.printf("%-4s %s %-4s%n", "====", "M E N U", "=====");
        System.out.printf("%d. %-10s - $%.2f%n", 1, "Burger", 80.00);
        System.out.printf("%d. %-10s - $%.2f%n", 2, "Pizza", 120.00);
        System.out.printf("%d. %-10s - $%.2f%n", 3, "Pasta", 100.00);
        System.out.printf("%d. %-10s - $%.2f%n", 4, "Sandwich", 70.00);
        System.out.printf("%d. %-10s - $%.2f%n", 5, "Milk Tea", 90.00);
        
        char orderAgain;
        int totalItem = 0;
        double beforeDiscount = 0;
        double totalDiscount = 0;
        double finalAmount;
        
        do{
            int orderCode, orderQuantity;
            char isStudent;

            System.out.print("\nEnter item number: ");
            orderCode = input.nextInt();
            System.out.print("Enter quatity: ");
            orderQuantity = input.nextInt();
            System.out.print("Are you a student? (Y/N): ");
            isStudent = input.next().charAt(0);

            double[] result = processOrder(orderCode, orderQuantity, isStudent);

            if(result != null){
                totalItem += orderQuantity;
                beforeDiscount += result[0];
                totalDiscount += result[1];
            }

            System.out.print("\nDo you want to order again? (Y/N): ");
            orderAgain = input.next().charAt(0);

        }while(orderAgain == 'Y');

        finalAmount = beforeDiscount - totalDiscount;

        orderSummary(totalItem, beforeDiscount, totalDiscount, finalAmount);

        input.close();
    }
    
    public static double[] processOrder(int orderCode, int orderQuantity, char isStudent){
        double price = 0;
        double getSubtotal;
        double getDiscount;
        double currentTotal;
        switch(orderCode){
            case 1:
                price = 80;

                break;

            case 2:
                price = 120;

                break;

            case 3:
                price = 100;

                break;

            case 4:
                price = 70;

                break;

            case 5:
                price = 90;

                break;
            
            default:
                System.out.println("Invalid item number!");
            return null;
        }

        if(orderQuantity > 0 && orderQuantity <= 10){
            getSubtotal = price * orderQuantity;
            
            if(isStudent == 'Y'){
                getDiscount = (getSubtotal >= 500) ? getSubtotal * 0.15 : getSubtotal * 0.10;
            } else {
                getDiscount = (getSubtotal >= 500) ? getSubtotal  * 0.05 : 0;
            }
        } else{
            System.out.println("Invalid order! Please enter a valid item and quantity. ");
            return  null;
        }

        currentTotal = getSubtotal - getDiscount;

        System.out.printf("\nSubtotal: $%.2f%n", getSubtotal);
        System.out.printf("Discount: $%.2f%n", getDiscount);
        System.out.printf("Order total: $%.2f%n", currentTotal);

        return new double[]{getSubtotal, getDiscount};
    }

    public static void orderSummary(int totalItem, double beforeDiscount, double totalDiscount, double finalAmount){
        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.printf("Total items: %d%n", totalItem);
        System.out.printf("Total before discount: $%.2f%n", beforeDiscount);
        System.out.printf("Total discount: $%.2f%n", totalDiscount);
        System.out.printf("Final amount: $%.2f%n", finalAmount);
        System.out.println("Thank you for ordering!");
    }
}