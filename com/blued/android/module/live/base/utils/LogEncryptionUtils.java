package com.blued.android.module.live.base.utils;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/utils/LogEncryptionUtils.class */
public class LogEncryptionUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f11473a = {66, 89, -81, 81, -1, -77, 2, 104, 98, -50, -38, 17, 0, -23, 68, 1};

    public static String a(String str, String str2) throws GeneralSecurityException {
        try {
            SecretKeySpec a2 = a(str);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(1, a2, new IvParameterSpec(f11473a));
            return Base64.encodeToString(cipher.doFinal(str2.getBytes("UTF-8")), 2);
        } catch (UnsupportedEncodingException e) {
            throw new GeneralSecurityException(e);
        }
    }

    private static SecretKeySpec a(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = (str + "d68a1c8a0a8b8710f7c771065165867fc8e73b50ee6809a7e9f53873b38e3e0d").getBytes("UTF-8");
        messageDigest.update(bytes, 0, bytes.length);
        return new SecretKeySpec(messageDigest.digest(), "AES");
    }

    public static String b(String str, String str2) throws GeneralSecurityException {
        try {
            SecretKeySpec a2 = a(str);
            byte[] decode = Base64.decode(str2, 2);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(2, a2, new IvParameterSpec(f11473a));
            return new String(cipher.doFinal(decode), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new GeneralSecurityException(e);
        }
    }
}
