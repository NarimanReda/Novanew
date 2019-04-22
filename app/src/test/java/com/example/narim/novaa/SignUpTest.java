package com.example.narim.novaa;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * The type Sign up test.
 */
public class SignUpTest {

    /**
     * Check email.
     */
    @Test
    public void checkEmail() {
        String input = "hjh.com";
        boolean Expected = true;
        boolean Output;
        SignUp Obj = new SignUp();
        Output = Obj.CheckEmail(input);
        assertEquals(Expected,Output);
    }

    /**
     * Check screen name.
     */
    @Test
    public void checkScreenName() {
        String input = "AAAAAAAAAAAAAA";
        boolean Expected = true;
        boolean Output;
        SignUp Obj = new SignUp();
        Output = Obj.CheckScreenName(input);
        assertEquals(Expected,Output);
    }

    /**
     * Check name.
     */
    @Test
    public void checkName() {
        String input = "    a ";
        boolean Expected = true;
        boolean Output;
        SignUp Obj = new SignUp();
        Output = Obj.CheckName(input);
        assertEquals(Expected,Output);
    }

    /**
     * Check password.
     */
    @Test
    public void checkPassword() {
        String input1 = "1aaaAaaa";
        String input2 = "1aaaAaaa";
        boolean Expected = true;
        boolean Output;
        SignUp Obj = new SignUp();
        Output = Obj.CheckPassword(input1,input2);
        assertEquals(Expected,Output);
    }

    /**
     * Check.
     */
    @Test
    public void check() {
    }
}