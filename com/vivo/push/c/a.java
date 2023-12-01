package com.vivo.push.c;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import com.vivo.push.util.p;
import java.security.KeyStore;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/c/a.class */
public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private KeyStore f27370a;
    private SecretKey b;

    public a() {
        a();
        b();
    }

    private void a() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            this.f27370a = keyStore;
            keyStore.load(null);
        } catch (Exception e) {
            e.printStackTrace();
            p.a("AesSecurity", "initKeyStore error" + e.getMessage());
        }
    }

    private SecretKey b() {
        SecretKey d;
        try {
            if (this.b != null) {
                return this.b;
            }
            if (c()) {
                d = d();
            } else {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                if (Build.VERSION.SDK_INT >= 23) {
                    keyGenerator.init(new KeyGenParameterSpec.Builder("AesKeyAlias", 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build());
                }
                d = keyGenerator.generateKey();
            }
            this.b = d;
            return this.b;
        } catch (Exception e) {
            e.printStackTrace();
            p.a("AesSecurity", "getSecretKey error" + e.getMessage());
            return null;
        }
    }

    private boolean c() {
        try {
            if (this.f27370a == null) {
                a();
            }
            return this.f27370a.containsAlias("AesKeyAlias");
        } catch (Exception e) {
            e.printStackTrace();
            p.a("AesSecurity", "hasAESKey error" + e.getMessage());
            return false;
        }
    }

    private SecretKey d() {
        try {
            return ((KeyStore.SecretKeyEntry) this.f27370a.getEntry("AesKeyAlias", null)).getSecretKey();
        } catch (Exception e) {
            e.printStackTrace();
            p.a("AesSecurity", "getAESSecretKey error" + e.getMessage());
            return null;
        }
    }
}
