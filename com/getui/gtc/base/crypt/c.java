package com.getui.gtc.base.crypt;

import android.content.Context;
import com.getui.gtc.base.util.io.IOUtils;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/crypt/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    KeyPair f21902a;
    private b b;

    /* renamed from: c  reason: collision with root package name */
    private File f21903c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, KeyPair keyPair) throws NoSuchAlgorithmException {
        this.f21903c = context.getFilesDir();
        this.f21902a = keyPair;
        if (keyPair == null) {
            this.b = new b(context.getPackageName());
        }
    }

    public final SecretKey a(String str) throws InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, IOException, InvalidAlgorithmParameterException {
        return a(str, true, this.f21902a);
    }

    public final SecretKey a(String str, boolean z, KeyPair keyPair) throws InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, IOException, InvalidAlgorithmParameterException {
        byte[] b;
        File file = new File(this.f21903c, str);
        if (!file.exists() && z) {
            SecretKey generateKey = CryptTools.generateKey("AES", 128);
            byte[] encoded = generateKey.getEncoded();
            KeyPair keyPair2 = this.f21902a;
            IOUtils.saveToFile(keyPair2 != null ? CryptTools.encrypt("RSA/ECB/PKCS1Padding", keyPair2.getPublic(), encoded) : this.b.a(encoded), new File(this.f21903c, str));
            return generateKey;
        }
        try {
            byte[] readFile = IOUtils.readFile(file);
            if (keyPair == null) {
                if (this.f21902a == null) {
                    b = this.b.b(readFile);
                    return CryptTools.wrapperKey("AES", b);
                }
                keyPair = this.f21902a;
            }
            b = CryptTools.decrypt("RSA/ECB/PKCS1Padding", keyPair.getPrivate(), readFile);
            return CryptTools.wrapperKey("AES", b);
        } catch (IOException | InvalidAlgorithmParameterException e) {
            return null;
        }
    }

    public final IvParameterSpec b(String str, boolean z, KeyPair keyPair) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException, InvalidAlgorithmParameterException {
        byte[] b;
        File file = new File(this.f21903c, str);
        if (!file.exists() && z) {
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            KeyPair keyPair2 = this.f21902a;
            IOUtils.saveToFile(keyPair2 != null ? CryptTools.encrypt("RSA/ECB/PKCS1Padding", keyPair2.getPublic(), bArr) : this.b.a(bArr), new File(this.f21903c, str));
            return new IvParameterSpec(bArr);
        }
        try {
            byte[] readFile = IOUtils.readFile(file);
            if (keyPair == null) {
                if (this.f21902a == null) {
                    b = this.b.b(readFile);
                    return new IvParameterSpec(b);
                }
                keyPair = this.f21902a;
            }
            b = CryptTools.decrypt("RSA/ECB/PKCS1Padding", keyPair.getPrivate(), readFile);
            return new IvParameterSpec(b);
        } catch (IOException | InvalidAlgorithmParameterException e) {
            return null;
        }
    }
}
