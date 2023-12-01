package com.huawei.hms.ads.uiengineloader;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/ad.class */
public abstract class ad {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8933a = "Sha256Util";

    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            aa.d(f8933a, "sha256 NoSuchAlgorithmException");
            return new byte[0];
        }
    }
}
