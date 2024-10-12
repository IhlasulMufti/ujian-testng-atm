package com.juaracoding;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ATMTest {

    ATM atm;

    @BeforeMethod
    public void setUp() {
        atm = new ATM(1000);
    }

    // Testing lihatSaldo
    @Test(priority = 1)
    public void testLihatSaldo() {
        Assert.assertEquals(atm.lihatSaldo(), 1000);
    }

    // Testing setorUang
    // Positive Test
    @Test(priority = 2)
    public void testSetorUang() {
        atm.setorUang(1000);
        double actualSaldo = atm.lihatSaldo();
        double expectedSaldo = 2000; // Saldo awal + Jumlah (1000 + 1000 = 2000)
        Assert.assertEquals(actualSaldo, expectedSaldo);
    }

    // Negative Test
    @Test(priority = 3, expectedExceptions = IllegalArgumentException.class)
    public void testSetorUangNegatif() {
        atm.setorUang(-1000);
    }

    // Testing tarikUang
    // Positive Test
    @Test(priority = 4)
    public void testTarikUang() {
        atm.tarikUang(500);
        double actualSaldo = atm.lihatSaldo();
        double expectedSaldo = 500; // Saldo awal - Jumlah (1000 - 500 = 500)
        Assert.assertEquals(actualSaldo, expectedSaldo);
    }

    // Negative Test
    @Test(priority = 5, expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangLebihDariSaldo() {
        atm.tarikUang(2000);
    }

    @Test(priority = 6, expectedExceptions = IllegalArgumentException.class)
    public void testTarikUangNegatif() {
        atm.tarikUang(-1500);
    }
}
