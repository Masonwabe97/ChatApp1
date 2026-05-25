/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.chatapp1.Login;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {
    Login login = new Login();
    
    @Test
    public void testUsername(){
        assertTrue(login.checkUserName("kyl_1"));
    }
    
    @Test
    public void testInvalidUsername_NoUnswerscore(){
        assertFalse(login.checkUserName("kyle!!!!!!"));
    }
    
    @Test
    public void testValidPassword(){
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99"));
    }
    
    @Test
    public void testInvalidPassword_NoCharacter(){
        assertFalse(login.checkPasswordComplexity("password"));
    }
    
    @Test
    public void testValidPhoneNumber(){
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }
    
    @Test
    public void testInvalidPhoneNumber_NoSAcode(){
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
    
    @Test
    public void testLoginSuccessful() {
        // Registering a username, password, and phone number for login
        login.registerUsername("kyl_1");
        login.registerPassword("Ch&&sec@ke99");
        login.registerCellPhoneNumber("+27838968976");

        // Verifying that the login is successful when correct credentials are used
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99"));
    }
    
    @Test
    public void testLoginFailed() {
        // Registering a username, password, and phone number for login
        login.registerUsername("kyl_1");
        login.registerPassword("Ch&&sec@ke99");
        login.registerCellPhoneNumber("+27838968976");

        // Verifying that the login fails when incorrect credentials are used
        assertFalse(login.loginUser("wrong_username", "Ch&&sec@ke99"));
        assertFalse(login.loginUser("kyl_1", "wrong_password"));
    }
}
