package com.hihonor.push.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: source-7994992-dex2jar.jar:com/hihonor/push/sdk/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static volatile r0 f8674a;
    public static final c b = new c();

    public final void a(Context context) {
        if (f8674a == null) {
            f8674a = new r0(context, "push");
        }
    }

    public void a(Context context, String str) {
        byte[] bArr;
        byte[] bArr2;
        synchronized (this) {
            a(context);
            if (TextUtils.isEmpty(str)) {
                f8674a.a("key_push_token");
                return;
            }
            String a2 = a.a(context, context.getPackageName());
            byte[] a3 = a.a(BuildConfig.PUSH_SERVICE_PKG_ANDROID_SIGN);
            byte[] a4 = a.a(a2);
            try {
                bArr = new byte[32];
                new SecureRandom().nextBytes(bArr);
            } catch (Exception e) {
                bArr = new byte[0];
            }
            String encodeToString = Base64.encodeToString(a.a(a.a(a.a(a.a(a3, -4), a4), 6), bArr), 0);
            boolean a5 = f8674a.a("key_aes_gcm", encodeToString);
            byte[] decode = Base64.decode(encodeToString, 0);
            String str2 = "";
            if (!TextUtils.isEmpty(str)) {
                str2 = "";
                if (decode != null) {
                    str2 = "";
                    if (decode.length >= 16) {
                        try {
                            bArr2 = new byte[12];
                            new SecureRandom().nextBytes(bArr2);
                        } catch (Exception e2) {
                            try {
                                bArr2 = new byte[0];
                            } catch (GeneralSecurityException e3) {
                                new StringBuilder("GCM encrypt data error").append(e3.getMessage());
                                str2 = "";
                            }
                        }
                        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
                        SecretKeySpec secretKeySpec = new SecretKeySpec(decode, "AES");
                        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                        cipher.init(1, secretKeySpec, new GCMParameterSpec(128, bArr2));
                        byte[] doFinal = cipher.doFinal(bytes);
                        str2 = "";
                        if (doFinal != null) {
                            str2 = "";
                            if (doFinal.length != 0) {
                                str2 = a.a(bArr2) + a.a(doFinal);
                            }
                        }
                    }
                }
            }
            if (a5 && !TextUtils.isEmpty(str2)) {
                f8674a.a("key_push_token", str2);
            }
        }
    }

    public String b(Context context) {
        String str;
        synchronized (this) {
            a(context);
            SharedPreferences sharedPreferences = f8674a.f8715a;
            str = "";
            if (sharedPreferences != null && sharedPreferences.contains("key_push_token")) {
                SharedPreferences sharedPreferences2 = f8674a.f8715a;
                if (sharedPreferences2 != null && sharedPreferences2.contains("key_aes_gcm")) {
                    SharedPreferences sharedPreferences3 = f8674a.f8715a;
                    String string = sharedPreferences3 != null ? sharedPreferences3.getString("key_push_token", "") : "";
                    SharedPreferences sharedPreferences4 = f8674a.f8715a;
                    byte[] decode = Base64.decode(sharedPreferences4 != null ? sharedPreferences4.getString("key_aes_gcm", "") : "", 0);
                    str = "";
                    if (!TextUtils.isEmpty(string)) {
                        str = "";
                        if (decode != null) {
                            str = "";
                            if (decode.length >= 16) {
                                try {
                                    SecretKeySpec secretKeySpec = new SecretKeySpec(decode, "AES");
                                    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                                    String substring = string.substring(0, 24);
                                    String substring2 = string.substring(24);
                                    str = "";
                                    if (!TextUtils.isEmpty(substring)) {
                                        str = "";
                                        if (!TextUtils.isEmpty(substring2)) {
                                            cipher.init(2, secretKeySpec, new GCMParameterSpec(128, a.a(substring)));
                                            str = new String(cipher.doFinal(a.a(substring2)), StandardCharsets.UTF_8);
                                        }
                                    }
                                } catch (Exception e) {
                                    new StringBuilder("GCM decrypt data exception: ").append(e.getMessage());
                                    str = "";
                                }
                            }
                        }
                    }
                    if (TextUtils.isEmpty(str)) {
                        f8674a.a("key_aes_gcm");
                        f8674a.a("key_push_token");
                        str = "";
                    }
                } else {
                    f8674a.a("key_push_token");
                    str = "";
                }
            }
        }
        return str;
    }
}
