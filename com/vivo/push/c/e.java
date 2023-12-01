package com.vivo.push.c;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.p;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* loaded from: source-8829756-dex2jar.jar:com/vivo/push/c/e.class */
public final class e implements b {

    /* renamed from: a  reason: collision with root package name */
    private static PrivateKey f41064a;
    private static PublicKey b;

    /* renamed from: c  reason: collision with root package name */
    private static KeyStore f41065c;
    private static X500Principal d;
    private Context e;

    public e(Context context) {
        this.e = context;
        try {
            b();
            a(context);
        } catch (Exception e) {
            e.printStackTrace();
            p.a("RsaSecurity", "init error" + e.getMessage());
        }
    }

    private static void a(Context context) {
        try {
            if (context == null) {
                p.d("RsaSecurity", " generateRSAKeyPairSign context == null ");
            } else if (b("PushRsaKeyAlias")) {
                p.d("RsaSecurity", " generateRSAKeyPairSign this keyAlias PushRsaKeyAlias is Created ");
            } else {
                Calendar calendar = Calendar.getInstance();
                Calendar calendar2 = Calendar.getInstance();
                calendar2.add(1, 999);
                if (Build.VERSION.SDK_INT >= 18) {
                    KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(d).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    keyPairGenerator.initialize(build);
                    keyPairGenerator.generateKeyPair();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            p.a("RsaSecurity", "generateRSAKeyPairSign error" + e.getMessage());
        }
    }

    private static PrivateKey b(Context context) {
        try {
            if (f41064a != null) {
                return f41064a;
            }
            if (context == null) {
                p.d("RsaSecurity", " getPrivateKeySigin context == null ");
                return null;
            }
            if (!b("PushRsaKeyAlias")) {
                a(context);
            }
            KeyStore.Entry entry = f41065c.getEntry("PushRsaKeyAlias", null);
            if (entry instanceof KeyStore.PrivateKeyEntry) {
                PrivateKey privateKey = ((KeyStore.PrivateKeyEntry) entry).getPrivateKey();
                f41064a = privateKey;
                return privateKey;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            p.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
            return null;
        }
    }

    private static void b() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            f41065c = keyStore;
            keyStore.load(null);
            d = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
        } catch (Exception e) {
            e.printStackTrace();
            p.a("RsaSecurity", "initKeyStore error" + e.getMessage());
        }
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (f41065c == null) {
                b();
            }
            return f41065c.containsAlias(str);
        } catch (Exception e) {
            e.printStackTrace();
            p.a("RsaSecurity", "getPrivateKeySigin error" + e.getMessage());
            return false;
        }
    }

    @Override // com.vivo.push.c.b
    public final String a(String str) {
        try {
            if (TextUtils.isEmpty(str) || b(this.e) == null) {
                return null;
            }
            byte[] bytes = str.getBytes("UTF-8");
            PrivateKey b2 = b(this.e);
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(b2);
            signature.update(bytes);
            String encodeToString = Base64.encodeToString(signature.sign(), 2);
            p.d("RsaSecurity", str.hashCode() + " = " + encodeToString);
            return encodeToString;
        } catch (Exception e) {
            e.printStackTrace();
            p.a("RsaSecurity", "signClientSDK error" + e.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.c.b
    public final PublicKey a() {
        try {
            if (b != null) {
                return b;
            }
            if (!b("PushRsaKeyAlias")) {
                a(this.e);
            }
            KeyStore.Entry entry = f41065c.getEntry("PushRsaKeyAlias", null);
            if (entry instanceof KeyStore.PrivateKeyEntry) {
                PublicKey publicKey = ((KeyStore.PrivateKeyEntry) entry).getCertificate().getPublicKey();
                b = publicKey;
                return publicKey;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            p.a("RsaSecurity", "getPublicKeySign error" + e.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.c.b
    public final boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception e) {
            e.printStackTrace();
            p.a("RsaSecurity", "verifyClientSDK error" + e.getMessage());
            return false;
        }
    }
}
