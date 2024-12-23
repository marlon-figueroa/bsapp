/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bsapp.util;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author MARLON FIGUEROA
 */
public class SHA256HashingUnitTest {

    private static final String ORIGINAL_VALUE = "abc123";
    private static final String HASHED_VALUE = "6ca13d52ca70c883e0f0bb101e425a89e8624de51db2d2392593af6a84118090";

    @Test
    public void testHashWithJavaMessageDigest() throws Exception {
        final String currentHashedValue = SHA256Hashing.HashWithJavaMessageDigest(ORIGINAL_VALUE);
        assertEquals(HASHED_VALUE, currentHashedValue);
    }

    @Test
    public void testHashWithGuava() throws Exception {
        final String currentHashedValue = SHA256Hashing.hashWithGuava(ORIGINAL_VALUE);
        assertEquals(HASHED_VALUE, currentHashedValue);
    }

    @Test
    public void testHashWithApacheCommans() throws Exception {
        final String currentHashedValue = SHA256Hashing.HashWithApacheCommons(ORIGINAL_VALUE);
        assertEquals(HASHED_VALUE, currentHashedValue);
    }

    @Test
    public void testHashWithBouncyCastle() throws Exception {
        final String currentHashedValue = SHA256Hashing.HashWithBouncyCastle(ORIGINAL_VALUE);
        assertEquals(HASHED_VALUE, currentHashedValue);
    }

}
