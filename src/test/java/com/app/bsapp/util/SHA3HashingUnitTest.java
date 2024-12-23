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
public class SHA3HashingUnitTest {

    private static final String ORIGINAL_VALUE = "abc123";
    private static final String HASHED_VALUE = "f58fa3df820114f56e1544354379820cff464c9c41cb3ca0ad0b0843c9bb67ee";

    /* works with JDK9+ only */
    //@Test
    public void testHashWithJavaMessageDigestJDK9() throws Exception {
        final String currentHashedValue = SHA3Hashing.hashWithJavaMessageDigestJDK9(ORIGINAL_VALUE);
        assertEquals(HASHED_VALUE, currentHashedValue);
    }

    @Test
    public void testHashWithJavaMessageDigest() throws Exception {
        final String currentHashedValue = SHA3Hashing.hashWithJavaMessageDigest(ORIGINAL_VALUE);
        assertEquals(HASHED_VALUE, currentHashedValue);
    }

    /* works with JDK9+ only */
    //@Test
    public void testHashWithApacheCommonsJDK9() {
        final String currentHashedValue = SHA3Hashing.hashWithApacheCommonsJDK9(ORIGINAL_VALUE);
        assertEquals(HASHED_VALUE, currentHashedValue);
    }

    @Test
    public void testHashWithBouncyCastle() {
        final String currentHashedValue = SHA3Hashing.hashWithBouncyCastle(ORIGINAL_VALUE);
        assertEquals(HASHED_VALUE, currentHashedValue);
    }

}
