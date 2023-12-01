package com.tencent.cos.xml.crypto;

import java.security.SecureRandom;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/COSCryptoScheme.class */
final class COSCryptoScheme {
    static final String AES = "AES";
    static final String RSA = "RSA";
    private static final SecureRandom srand = new SecureRandom();
    private final ContentCryptoScheme contentCryptoScheme;
    private final COSKeyWrapScheme kwScheme;

    private COSCryptoScheme(ContentCryptoScheme contentCryptoScheme, COSKeyWrapScheme cOSKeyWrapScheme) {
        this.contentCryptoScheme = contentCryptoScheme;
        this.kwScheme = cOSKeyWrapScheme;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static COSCryptoScheme from() {
        return new COSCryptoScheme(ContentCryptoScheme.AES_CTR, new COSKeyWrapScheme());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAesGcm(String str) {
        return ContentCryptoScheme.AES_GCM.getCipherAlgorithm().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContentCryptoScheme getContentCryptoScheme() {
        return this.contentCryptoScheme;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public COSKeyWrapScheme getKeyWrapScheme() {
        return this.kwScheme;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SecureRandom getSecureRandom() {
        return srand;
    }
}
