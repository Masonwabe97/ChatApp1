/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
import com.mycompany.chatapp1.Message;
    import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {


    // ======================================================
    // Test Message ID
    // ======================================================

    @Test
    public void testCheckMessageID() {

        Message msg =
                new Message(
                        1,
                        "+27831234567",
                        "Hello how are you"
                );

        assertTrue(msg.checkMessageID());
    }


    // ======================================================
    // Test Valid Recipient Number
    // ======================================================

    @Test
    public void testValidRecipientCell() {

        Message msg =
                new Message(
                        1,
                        "+27831234567",
                        "Hello how are you"
                );

        assertTrue(msg.checkRecipientCell());
    }


    // ======================================================
    // Test Invalid Recipient Number
    // ======================================================

    @Test
    public void testInvalidRecipientCell() {

        Message msg =
                new Message(
                        1,
                        "0831234567",
                        "Hello how are you"
                );

        assertFalse(msg.checkRecipientCell());
    }


    // ======================================================
    // Test Message Hash
    // ======================================================

    @Test
    public void testCreateMessageHash() {

        Message msg =
                new Message(
                        1,
                        "+27831234567",
                        "Hello how are you"
                );

        String hash =
                msg.createMessageHash();

        assertNotNull(hash);

        assertTrue(hash.contains(":"));
    }


    // ======================================================
    // Test Sent Message
    // ======================================================

    @Test
    public void testSentMessage() {

        Message msg =
                new Message(
                        1,
                        "+27831234567",
                        "Hello how are you"
                );

        assertEquals(
                "Message successfully sent.",
                msg.sentMessage()
        );
    }


    // ======================================================
    // Test Total Messages
    // ======================================================

    @Test
    public void testReturnTotalMessages() {

        int before =
                Message.returnTotalMessages();

        new Message(
                1,
                "+27831234567",
                "Test message"
        );

        int after =
                Message.returnTotalMessages();

        assertEquals(before + 1, after);
    }


    // ======================================================
    // Test JSON Conversion
    // ======================================================

    @Test
    public void testToJSON() {

        Message msg =
                new Message(
                        1,
                        "+27831234567",
                        "Hello how are you"
                );

        JSONObject json =
                msg.toJSON();

        assertEquals(
                "+27831234567",
                json.getString("Recipient")
        );

        assertEquals(
                "Hello how are you",
                json.getString("MessageText")
        );
    }
}