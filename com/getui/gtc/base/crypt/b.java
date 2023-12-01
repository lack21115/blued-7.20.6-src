package com.getui.gtc.base.crypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/crypt/b.class */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private SecretKey f21901a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String str) throws NoSuchAlgorithmException {
        this.f21901a = CryptTools.wrapperKey("RC4", CryptTools.digest("MD5", str.getBytes()));
    }

    public final byte[] a(byte[] bArr) throws NoSuchPaddingException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        return CryptTools.encrypt("RC4", this.f21901a, (IvParameterSpec) null, bArr);
    }

    public final byte[] b(byte[] bArr) throws NoSuchPaddingException, InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException {
        return CryptTools.decrypt("RC4", this.f21901a, (IvParameterSpec) null, bArr);
    }
}
