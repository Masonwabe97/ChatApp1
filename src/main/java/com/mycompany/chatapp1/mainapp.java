package com.mycompany.chatapp1;

import java.util.Scanner;

public class mainapp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ================= REGISTRATION =================
        System.out.print("Enter first name: ");
        String firstName = input.nextLine();

        System.out.print("Enter last name: ");
        String lastName = input.nextLine();

        Login user = new Login(firstName, lastName);

        // USERNAME
        String username;
        while (true) {

            System.out.print("Enter username: ");
            username = input.nextLine();

            System.out.println(user.registerUsername(username));

            if (user.checkUserName(username)) {
                break;
            }
        }

        // PASSWORD
        String password;
        while (true) {

            System.out.print("Enter password: ");
            password = input.nextLine();

            System.out.println(user.registerPassword(password));

            if (user.checkPasswordComplexity(password)) {
                break;
            }
        }

        // PHONE NUMBER
        String phone;
        while (true) {

            System.out.print("Enter phone number (+27xxxxxxxxx): ");
            phone = input.nextLine();

            System.out.println(user.registerCellPhoneNumber(phone));

            if (user.checkCellPhoneNumber(phone)) {
                break;
            }
        }

        // ================= LOGIN =================
        boolean loggedIn = false;

        while (!loggedIn) {

            System.out.println("\n===== LOGIN =====");

            System.out.print("Enter username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = input.nextLine();

            System.out.println(user.returnLoginStatus(loginUsername, loginPassword));

            loggedIn = user.loginUser(loginUsername, loginPassword);
        }

        // WELCOME MESSAGE
        System.out.println("Welcome to ChatApp.");

        // ================= MENU =================
        boolean running = true;

        while (running) {

            System.out.println("\n===== MENU =====");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");

            System.out.print("Choose option: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    // ASK NUMBER OF MESSAGES
                    System.out.print("How many messages would you like to send? ");
                    int numMessages = input.nextInt();
                    input.nextLine();

                    // FOR LOOP
                    for (int i = 0; i < numMessages; i++) {

                        int messageNumber = i + 1;

                        System.out.println("\n----- Message " + messageNumber + " -----");

                        // RECIPIENT
                        System.out.print("Enter recipient number: ");
                        String recipient = input.nextLine();

                        // MESSAGE TEXT
                        System.out.print("Enter message: ");
                        String messageText = input.nextLine();

                        // CREATE MESSAGE OBJECT
                        Message msg = new Message(messageNumber, recipient, messageText);

                        // VALIDATE RECIPIENT
                        System.out.println(msg.checkRecipientCell());

                        // VALIDATE MESSAGE LENGTH
                        if (messageText.length() > 250) {

                            int over = messageText.length() - 250;

                            System.out.println(
                                    "Message exceeds 250 characters by "
                                    + over
                                    + ", please reduce the size."
                            );

                        } else {

                            System.out.println("Message ready to send.");
                        }

                        // MESSAGE ID
                        System.out.println("Message ID: " + msg.getMessageID());

                        // MESSAGE HASH
                        System.out.println("Message Hash: " + msg.createMessageHash());

                        // SEND OPTION
                        System.out.println(msg.sentMessage());
                        
                        //Ask User what to do
                        System.out.println("\nChoose an option");
                        System.out.println("1) Send Message");
                        System.out.println("2) Disregard Message");
                        System.out.println("3) Store Message");
                        
                        int sendChoice = input.nextInt();
                        input.nextLine();
                        
                        //Show remote 
                        System.out.println(message.sentMessage(sendChoice));
                        
                        //Display full message details
                        System.out.println("\n" + message.printMessages());    
                    }
                    System.out.println("\nTotal messages sent: "
                    + Message.returnTotalMessagesStatic());

                    break;

                case 2:

                    System.out.println("Coming Soon.");

                    break;

                case 3:

                    System.out.println("Exiting application...");
                    running = false;

                    break;

                default:

                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }

        input.close();
    }
}