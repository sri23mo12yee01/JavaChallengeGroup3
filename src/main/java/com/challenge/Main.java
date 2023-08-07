package com.challenge;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.apache.log4j.BasicConfigurator;
import org.bson.Document;
import java.util.*;
import java.util.logging.Logger;
        public class Main {

            private static final Scanner read = new Scanner(System.in);
            private static ArrayList<BankAccount> accounts;
            public static void addAccount() {
                System.out.println("Please choose the Account type: \n(a) BankAccount\t(b) SavingsAccount\n");
                char input = read.next().charAt(0);
                System.out.println("Please enter the name: ");
                String name = read.next();
                System.out.println("Please enter the balance: ");
                double balance = read.nextDouble();
                BankAccount newAccount;

                switch (input) {
                    case 'a' -> {
                        String accType="Bank Account";
                        newAccount = new BankAccount(name, balance);
                    }
                    case 'b' -> {
                        newAccount = new SavingsAccount(name, balance);
                    }
                    default -> {
                        System.out.println("Wrong Input!!");
                        return;
                    }
                }
                System.out.println("Account Created: \n" + newAccount);
                accounts.add(newAccount);

            }
            public static void transactions()
            {

            }
            public static void displayAccounts() {
                if(accounts.size() > 0)
                {
                    for(int i=0; i<accounts.size(); i++)
                        System.out.println("Account " + (i+1) + ":\n" + accounts.get(i) + "\n");
                }
                else {
                    System.out.println("No Accounts created!!");
                }
            }
            public static void saveToDB(ArrayList<BankAccount> accounts) {
                MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
                MongoDatabase database = mongoClient.getDatabase("BankAccounts");
                MongoCollection<Document> accountsCollection = database.getCollection("Accounts");
                for (BankAccount account : accounts) {
                    Document doc = new Document();
                    doc.append("Account Type", account.accountType);
                    doc.append("Name", account.getAccountName());
                    doc.append("Balance", account.getBalance());
                    accountsCollection.insertOne(doc);

                }
            }
            public static void main(String[] args) {
                Logger logger = Logger.getLogger("BankAccount.class");
                BasicConfigurator.configure();
                accounts = new ArrayList<>();
                char input = 'w';
                while(input != 'q')
                {
                    System.out.println("Main Menu: \n(a) Add Account\t(l) Display Accounts\t(s) Save to DataBase\t(q) Quit\n");
                    input = read.next().charAt(0);
                    switch (input) {
                        case 'a' -> addAccount();
                        case 'l' -> displayAccounts();
                        case 's' -> saveToDB(accounts);
                        case 'q' -> System.out.println("Quitting!!");
                        default -> System.out.println("Wrong Input!!");
                    }
                }
            }
            }

