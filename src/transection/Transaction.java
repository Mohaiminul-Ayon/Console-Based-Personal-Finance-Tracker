package transection;

import java.time.LocalDate;
import java.util.IdentityHashMap;
import java.util.Scanner;

public class Transaction {
    private String id;
    private String type;
    private double amount;
    private String description;
    private String date;

    public Transaction(String id, String type, double amount, String description, String date) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }


    public Transaction() {}

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction {" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", date=" + date +
                '}';
    }

    public static String getDateTransaction(Scanner sc) {
        System.out.println("""
                1. Use today's date
                2. Enter the day manually
                
                enter your choice:
                """);
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            return LocalDate.now().toString();
        }
        else if (choice == 2) {
            System.out.println("Enter The Date (dd/MM/yyyy) :");

            return sc.nextLine();
        }
        else {
            System.out.println("Invalid choice");
            return null;
        }

    }

    public static Transaction getInstance(Scanner sc,String id) {
        System.out.println("Enter your Income/Expense");
        String type = sc.nextLine().trim().toUpperCase();

        System.out.println("Enter your amount :");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter your description :");
        String description = sc.nextLine();




        String date = getDateTransaction(sc);

        return new Transaction(id,type,  amount, description, date);

    }



}
