package com.tencent.cos.xml.crypto;

import java.io.Serializable;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/EncryptionMaterials.class */
public class EncryptionMaterials implements Serializable {
    private static final long serialVersionUID = 1;
    private final Map<String, String> desc;
    private final KeyPair keyPair;
    private final SecretKey symmetricKey;

    public EncryptionMaterials(KeyPair keyPair) {
        this(keyPair, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public EncryptionMaterials(KeyPair keyPair, SecretKey secretKey) {
        this.desc = new HashMap();
        this.keyPair = keyPair;
        this.symmetricKey = secretKey;
    }

    public EncryptionMaterials(SecretKey secretKey) {
        this(null, secretKey);
    }

    public EncryptionMaterials addDescription(String str, String str2) {
        this.desc.put(str, str2);
        return this;
    }

    public EncryptionMaterials addDescriptions(Map<String, String> map) {
        this.desc.putAll(map);
        return this;
    }

    public EncryptionMaterialsAccessor getAccessor() {
        return null;
    }

    public String getCustomerMasterKeyId() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getDescription(String str) {
        return this.desc.get(str);
    }

    public KeyPair getKeyPair() {
        return this.keyPair;
    }

    public Map<String, String> getMaterialsDescription() {
        return new HashMap(this.desc);
    }

    public SecretKey getSymmetricKey() {
        return this.symmetricKey;
    }

    public boolean isKMSEnabled() {
        return false;
    }
}
