/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.app.bsapp.util;

import java.security.SecureRandom;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author MARLON FIGUEROA
 */
public class SHA512HasherUnitTest {

    private SHA512Hasher hasher;
    private SecureRandom secureRandom;

    @Before
    public void setUp() throws Exception {
        hasher = new SHA512Hasher();
        secureRandom = new SecureRandom();
    }

    @Test
    public void givenSamePasswordAndSalt_whenHashed_checkResultingHashesAreEqual() throws Exception {
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        String hash1 = hasher.hash("password", salt);
        String hash2 = hasher.hash("password", salt);
        Assert.assertEquals(hash1, hash2);
    }

    @Test
    public void givenSamePasswordAndDifferentSalt_whenHashed_checkResultingHashesNotEqual() throws Exception {
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        String hash1 = hasher.hash("password", salt);
        //generate a second salt
        byte[] secondSalt = new byte[16];
        String hash2 = hasher.hash("password", secondSalt);
        Assert.assertNotEquals(hash1, hash2);
    }

    @Test
    public void givenPredefinedHash_whenCorrectAttemptGiven_checkAuthenticationSucceeds() throws Exception {
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        String originalHash = hasher.hash("password123", salt);
        Assert.assertTrue(hasher.checkPassword(originalHash, "password123", salt));
    }

    @Test
    public void givenPredefinedHash_whenIncorrectAttemptGiven_checkAuthenticationFails() throws Exception {
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        String originalHash = hasher.hash("password123", salt);
        Assert.assertFalse(hasher.checkPassword(originalHash, "password124", salt));
    }

}
