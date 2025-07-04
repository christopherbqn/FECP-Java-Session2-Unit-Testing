package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    BankAccount account;

    @BeforeEach
    void setUp(){
        account = new BankAccount(11111, "John Doe", 100.0);
    }

    @Test
    void testDepositValidAmount(){
        boolean result = account.deposit(50.0);
        assertTrue(result);
        assertEquals(150.0,account.getBalance());
    }

    @Test
    void testDepositInvalidAmount(){
        boolean result = account.deposit(-10);
        assertFalse(result);
        assertEquals(100, account.getBalance());
    }

    @Test
    void testWithdrawalValidAmount(){
        boolean result = account.withdraw(100);
        assertTrue(result);
        assertEquals(0,account.getBalance());
    }

    @Test
    void testWithdrawalInvalidAmount(){
        boolean result = account.withdraw(-13);
        assertFalse(result);
        assertEquals(100, account.getBalance());
    }

    @Test
    void testWithdrawalExceedsBalance(){
        boolean result = account.withdraw(101);
        assertFalse(result);
        assertEquals(100, account.getBalance());
    }

    @Test
    void testGetAccountNumber(){
        assertEquals(11111, account.getAccountNumber());
    }

    @Test
    void testCreateAccountWithoutInitialDeposit(){
        BankAccount newAccount = new BankAccount(100,"Jane Doe", 0.0);
        assertEquals(100, newAccount.getAccountNumber());
        assertEquals("Jane Doe", newAccount.getName());
        assertEquals(0.0, newAccount.getBalance());
    }


}