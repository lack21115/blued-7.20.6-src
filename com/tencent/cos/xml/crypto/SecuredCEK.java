package com.tencent.cos.xml.crypto;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/SecuredCEK.class */
class SecuredCEK {
    private final byte[] encrypted;
    private final String keyWrapAlgorithm;
    private final Map<String, String> matdesc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SecuredCEK(byte[] bArr, String str, Map<String, String> map) {
        this.encrypted = bArr;
        this.keyWrapAlgorithm = str;
        this.matdesc = Collections.unmodifiableMap(new TreeMap(map));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] getEncrypted() {
        return this.encrypted;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getKeyWrapAlgorithm() {
        return this.keyWrapAlgorithm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> getMaterialDescription() {
        return this.matdesc;
    }
}
