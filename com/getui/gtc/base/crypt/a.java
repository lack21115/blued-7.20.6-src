package com.getui.gtc.base.crypt;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Calendar;
import javax.crypto.SecretKey;
import javax.security.auth.x500.X500Principal;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/crypt/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Object f8293a = new Object();
    private final Object b = new Object();

    private KeyPair a(Context context, String str) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        KeyGenParameterSpec build;
        KeyPair generateKeyPair;
        synchronized (this.b) {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
            if (Build.VERSION.SDK_INT >= 23) {
                build = new KeyGenParameterSpec.Builder(str, 3).setBlockModes("ECB").setEncryptionPaddings("PKCS1Padding").setKeySize(1024).build();
            } else {
                Calendar calendar = Calendar.getInstance();
                Calendar calendar2 = Calendar.getInstance();
                calendar2.add(1, 30);
                build = new KeyPairGeneratorSpec.Builder(context).setAlias(str).setSubject(new X500Principal("CN=".concat(String.valueOf(str)))).setSerialNumber(BigInteger.TEN).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            }
            keyPairGenerator.initialize(build);
            generateKeyPair = keyPairGenerator.generateKeyPair();
        }
        return generateKeyPair;
    }

    public final KeyPair a(Context context, String str, boolean z) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, UnrecoverableKeyException, NoSuchProviderException, InvalidAlgorithmParameterException {
        synchronized (this.b) {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (keyStore.containsAlias(str) || !z) {
                return new KeyPair(keyStore.getCertificate(str).getPublicKey(), (PrivateKey) keyStore.getKey(str, null));
            }
            return a(context, str);
        }
    }

    public final SecretKey a(String str) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException, UnrecoverableKeyException, NoSuchProviderException, InvalidAlgorithmParameterException {
        SecretKey secretKey;
        synchronized (this.f8293a) {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            keyStore.containsAlias(str);
            secretKey = (SecretKey) keyStore.getKey(str, null);
        }
        return secretKey;
    }
}
