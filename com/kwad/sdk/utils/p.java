package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import java.io.InputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/utils/p.class */
public class p {
    private static String azu = "";
    private static String azv = "";
    private static String azw = "";

    private static String a(String str, InputStream inputStream) {
        String eq;
        synchronized (p.class) {
            try {
                com.kwad.sdk.pngencrypt.o oVar = new com.kwad.sdk.pngencrypt.o(inputStream, true);
                oVar.BR();
                eq = oVar.BQ().eq(str);
                oVar.end();
            } catch (Throwable th) {
                throw th;
            }
        }
        return eq;
    }

    public static String ce(int i) {
        String str;
        String str2;
        Context CA = ServiceProvider.CA();
        if (i == 0) {
            str = azu;
            str2 = "aes_key";
        } else if (i == 1) {
            str = azv;
            str2 = "rsa_public_key";
        } else if (i != 2) {
            str = "";
            str2 = str;
        } else {
            str = azw;
            str2 = "rsa_private_key";
        }
        if (TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str2)) {
                com.kwad.sdk.core.d.b.e("EncryptUtils", "EncryptUtils getKey get id is error ");
            }
            try {
                InputStream open = CA.getResources().getAssets().open("ksad_common_encrypt_image.png");
                InputStream inputStream = open;
                if (open == null) {
                    inputStream = CA.getAssets().open("ksad_common_encrypt_image.png");
                }
                String a2 = a(str2, inputStream);
                if (TextUtils.isEmpty(a2)) {
                    com.kwad.sdk.core.d.b.e("EncryptUtils", "EncryptUtils getKey get encryptedKey is invalid ");
                }
                if (i == 0) {
                    azu = a2;
                    return a2;
                } else if (i == 1) {
                    azv = a2;
                    return a2;
                } else if (i != 2) {
                    return a2;
                } else {
                    azw = a2;
                    return a2;
                }
            }
        }
        return str;
    }
}
