package com.tencent.cos.xml.crypto;

import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/KMSSecuredCEK.class */
final class KMSSecuredCEK extends SecuredCEK {
    static final String KEY_PROTECTION_MECHANISM = "KMS/TencentCloud";

    /* JADX INFO: Access modifiers changed from: package-private */
    public KMSSecuredCEK(byte[] bArr, Map<String, String> map) {
        super(bArr, KEY_PROTECTION_MECHANISM, map);
    }

    public static boolean isKMSKeyWrapped(String str) {
        return KEY_PROTECTION_MECHANISM.equals(str);
    }
}
