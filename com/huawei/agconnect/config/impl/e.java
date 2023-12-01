package com.huawei.agconnect.config.impl;

import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/config/impl/e.class */
public class e implements g {

    /* renamed from: a  reason: collision with root package name */
    private final d f8727a;
    private SecretKey b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f8727a = dVar;
        a();
    }

    private SecretKey a() {
        try {
            String a2 = this.f8727a.a("/code/code1", null);
            String a3 = this.f8727a.a("/code/code2", null);
            String a4 = this.f8727a.a("/code/code3", null);
            String a5 = this.f8727a.a("/code/code4", null);
            if (a2 != null && a3 != null && a4 != null && a5 != null) {
                this.b = i.a(Hex.decodeHexString(a2), Hex.decodeHexString(a3), Hex.decodeHexString(a4), Hex.decodeHexString(a5), 10000);
            }
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            Log.e("ExclamationMark", "Exception when reading the 'K&I' for 'Config'.");
            this.b = null;
        }
        return this.b;
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && Pattern.matches("^\\[!([A-Fa-f0-9]*)]", str);
    }

    static String b(String str) {
        try {
            Matcher matcher = Pattern.compile("^\\[!([A-Fa-f0-9]*)]").matcher(str);
            return matcher.find() ? matcher.group(1) : "";
        } catch (IllegalStateException | IndexOutOfBoundsException e) {
            Log.e("ExclamationMark", "getRawString exception");
            return "";
        }
    }

    @Override // com.huawei.agconnect.config.impl.g
    public String a(String str, String str2) {
        String str3;
        if (this.b == null) {
            str3 = "mKey is null, return default value";
        } else if (!a(str)) {
            return str2;
        } else {
            try {
                return new String(i.a(this.b, Hex.decodeHexString(b(str))), "UTF-8");
            } catch (UnsupportedEncodingException | IllegalArgumentException | GeneralSecurityException e) {
                str3 = "UnsupportedEncodingException||GeneralSecurityException||IllegalArgumentException";
            }
        }
        Log.e("ExclamationMark", str3);
        return str2;
    }
}
