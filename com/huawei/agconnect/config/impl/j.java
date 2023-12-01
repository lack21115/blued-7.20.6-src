package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/config/impl/j.class */
class j implements d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f8730a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context, String str) {
        this.f8730a = context;
        this.b = str;
    }

    private static String a(String str) {
        try {
            return "agc_" + Hex.encodeHexString(a(str.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            return "";
        }
    }

    private static byte[] a(byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256").digest(bArr);
    }

    @Override // com.huawei.agconnect.config.impl.d
    public String a(String str, String str2) {
        int identifier;
        String a2 = a(str);
        if (!TextUtils.isEmpty(a2) && (identifier = this.f8730a.getResources().getIdentifier(a2, "string", this.b)) != 0) {
            try {
                return this.f8730a.getResources().getString(identifier);
            } catch (Resources.NotFoundException e) {
                return str2;
            }
        }
        return str2;
    }
}
