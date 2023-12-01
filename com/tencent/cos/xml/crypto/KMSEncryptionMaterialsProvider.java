package com.tencent.cos.xml.crypto;

import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/KMSEncryptionMaterialsProvider.class */
public class KMSEncryptionMaterialsProvider extends StaticEncryptionMaterialsProvider implements Serializable {
    public KMSEncryptionMaterialsProvider(KMSEncryptionMaterials kMSEncryptionMaterials) {
        super(kMSEncryptionMaterials);
    }

    public KMSEncryptionMaterialsProvider(String str) {
        this(new KMSEncryptionMaterials(str));
    }
}
