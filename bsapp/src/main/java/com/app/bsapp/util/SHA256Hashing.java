/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.bsapp.util;

import static com.app.bsapp.util.DigestAlgorithms.SHA_256;
import static com.app.bsapp.util.SHACommonUtils.bytesToHex;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.util.encoders.Hex;

/**
 *
 * @author MARLON FIGUEROA
 */
public class SHA256Hashing {

    private SHA256Hashing() {
        throw new IllegalArgumentException("Operaciones estaticas de utilidad");
    }
    
    public static String HashWithJavaMessageDigest(final String originalString) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance(SHA_256);
        final byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encodedhash);
    }

    public static String hashWithGuava(final String originalString) {
        final String sha256hex = Hashing.sha256().hashString(originalString, StandardCharsets.UTF_8).toString();
        return sha256hex;
    }

    public static String HashWithApacheCommons(final String originalString) {
        final String sha256hex = DigestUtils.sha256Hex(originalString);
        return sha256hex;
    }

    public static String HashWithBouncyCastle(final String originalString) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance(SHA_256);
        final byte[] hash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
        final String sha256hex = new String(Hex.encode(hash));
        return sha256hex;
    }

}
