import transection.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int nextId=1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Transaction> transactionList = new ArrayList<>();



        while(true){
            System.out.println("""
            1. Press 1 to Add Transaction
            2. Press 2 to View Transactions
            3. Press 3 to Update Transaction
            4. Press 4 to Delete Transaction
            5. Press 5 to Calculate Balance
            6. Press 6 to Exit
            """
                    );


            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                //input
                String id = String.valueOf(nextId);
                System.out.println("Add transaction selected");
                Transaction transaction =Transaction.getInstance(sc,id);
                nextId++;

                transactionList.add(transaction);
                System.out.println("Transaction added successfully");

            }


            else if (choice == 2) {
                //view

                System.out.println("View transactions selected");
                if(transactionList.isEmpty()){
                    System.out.println("No transactions found");
                }
                else {
                    for (Transaction transaction : transactionList) {
                        System.out.println(transaction);
                    }}

            }


            else if (choice == 3) {
                //update

                System.out.println("Update transaction selected");
                if(transactionList.isEmpty()){
                    System.out.println("No transactions found");
                }
                else {

                    int transactionIndex = getIndexofTransaction("Enter %d to update the transaction below:", sc , transactionList);
                    if(transactionIndex == -1){continue;}


                    System.out.println(transactionList.get(transactionIndex));

                    Transaction transaction = transactionList.get(transactionIndex);

                    System.out.println("Enter new type (Income/Expense): ");
                    String newType = sc.nextLine().trim().toUpperCase();


                    System.out.println("Enter new amount: ");

                    double newAmount = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Enter new description: ");
                    String newDescription = sc.nextLine();


                    String newDate = Transaction.getDateTransaction(sc);


                    transaction.setType(newType);
                    transaction.setAmount(newAmount);
                    transaction.setDescription(newDescription);
                    transaction.setDate(newDate);

                    System.out.println("Transaction updated successfully.");


                }
            }


            else if (choice == 4) {
                //delete

                int transactionDel = getIndexofTransaction("Enter %d to delete the transaction below:", sc, transactionList);

                if (transactionDel == -1) {
                    continue;
                }

                transactionList.remove(transactionDel);


                System.out.println("Transaction removed successfully.");

            }


            else if (choice == 5) {
                //calculate
                double balance = 0;

                for (Transaction transaction : transactionList) {
                    if (transaction.getType().equals("INCOME")) {
                        balance += transaction.getAmount();
                    } else if (transaction.getType().equals("EXPENSE")) {
                        balance -= transaction.getAmount();
                    }
                }

                System.out.println("Current balance is " + balance);

            }


            else if (choice == 6) {
                //khatam

                System.out.println("Thank You");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }




    }
    private static int getIndexofTransaction(String message,Scanner sc,List<Transaction> transactionList){
        for(int i = 0; i < transactionList.size(); i++){
            String msg = String.format(message,i+1);
            System.out.println(msg);
            System.out.println(transactionList.get(i));

        }
        System.out.print("Enter transaction number: ");
        int transactionIndex = sc.nextInt();
        sc.nextLine();

        if (transactionIndex < 1 || transactionIndex > transactionList.size()) {
            System.out.println("Invalid transaction number.");
            return -1;
        }

        return transactionIndex -1;
    }


}