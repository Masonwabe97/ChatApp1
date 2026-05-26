/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp1;

/**
 *
 * @author Student
 */
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

public final class Message {

    static String returnTotalMessagesStatic() {  
        return null;
       
     }

    // Fields
    private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;

    // Static variable for total messages
    private static int totalMessages = 0;


    // Constructor
    public Message(int messageNumber, String recipient, String messageText) {

        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText;

        this.messageID = generateMessageID();
        this.messageHash = createMessageHash();

        totalMessages++;
    }


    // Generate 10-digit Message ID
    private String generateMessageID() {

        long number = (long)(Math.random() * 9000000000L) + 1000000000L;
        return String.valueOf(number);
    }


    // Check if Message ID is valid
    public boolean checkMessageID() {

        return messageID.length() == 10;
    }


    // Validate recipient number
    public boolean checkRecipientCell() {

        return recipient.startsWith("+") && recipient.length() <= 13;
    }


    // Create Message Hash
    public String createMessageHash() {

        String[] words = messageText.split(" ");

        String firstWord = words[0].toUpperCase();
        String lastWord = words[words.length - 1].toUpperCase();

        return messageID.substring(0, 2) + ":" +
               messageNumber + ":" +
               firstWord + lastWord;
    }


    // Send message
    public String sentMessage() {

        return "Message successfully sent.";
    }


    // Print message details
    public void printMessages() {

        System.out.println("Message ID: " + messageID);
        System.out.println("Message Number: " + messageNumber);
        System.out.println("Recipient: " + recipient);
        System.out.println("Message: " + messageText);
        System.out.println("Message Hash: " + messageHash);
    }
    
    public void storeMessages() {
        JSONObject obj = new JSONObject();
        obj.put("messageID", this.messageID);
        obj.put("recipient", this.recipient);
        obj.put("message", this.messageText);

        try (FileWriter fw = new FileWriter("messages.json", true)) {
            fw.write(obj.toString() + System.lineSeparator());
        }catch (IOException e) {
                System.out.println("Error saving JSON data: " + e.getMessage());
        }
    }

    // Return total messages
    public static int returnTotalMessages() {

        return totalMessages;
    }


    // Convert message to JSON
    public JSONObject toJSON() {

        JSONObject json = new JSONObject();

        json.put("MessageID", messageID);
        json.put("MessageNumber", messageNumber);
        json.put("Recipient", recipient);
        json.put("MessageText", messageText);
        json.put("MessageHash", messageHash);

        return json;
    }


    // Main method
    public static void main(String[] args) {

        // Create message object
        Message msg = new Message(
                1,
                "",
                "Hello how are you"
        );

        // Validate Message ID
        System.out.println("Valid Message ID: " + msg.checkMessageID());

        // Validate recipient
        System.out.println("Valid Recipient: " + msg.checkRecipientCell());

        // Send message
        System.out.println(msg.sentMessage());

        // Print message details
        msg.printMessages();

        // Print total messages
        System.out.println("Total Messages: " +
                Message.returnTotalMessages());

        // Convert to JSON
        JSONObject jsonMessage = msg.toJSON();
   
        // Print JSON
        System.out.println("\nJSON Output:");
        System.out.println(jsonMessage.toString(4));
    }

    String getMessageID() {
        
        return null;
        
    }
}