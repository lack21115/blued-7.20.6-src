package com.huawei.openalliance.ad.utils;

import com.huawei.hms.ads.ge;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/aq.class */
public class aq {
    private static final String Code = "Sha256Util";

    public static String Code(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("utf-8"));
            return u.Code(messageDigest.digest());
        } catch (IOException | NoSuchAlgorithmException e) {
            ge.I(Code, "fail to get file sha256");
            return null;
        }
    }

    public static byte[] Code(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            ge.Z(Code, "sha256 NoSuchAlgorithmException");
            return new byte[0];
        }
    }
}
