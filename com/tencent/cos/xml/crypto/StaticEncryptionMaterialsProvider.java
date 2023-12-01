package com.tencent.cos.xml.crypto;

import java.io.Serializable;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/StaticEncryptionMaterialsProvider.class */
public class StaticEncryptionMaterialsProvider implements EncryptionMaterialsProvider, Serializable {
    private final EncryptionMaterials materials;

    public StaticEncryptionMaterialsProvider(EncryptionMaterials encryptionMaterials) {
        this.materials = encryptionMaterials;
    }

    @Override // com.tencent.cos.xml.crypto.EncryptionMaterialsFactory
    public EncryptionMaterials getEncryptionMaterials() {
        return this.materials;
    }

    @Override // com.tencent.cos.xml.crypto.EncryptionMaterialsAccessor
    public EncryptionMaterials getEncryptionMaterials(Map<String, String> map) {
        EncryptionMaterials encryptionMaterials;
        EncryptionMaterials encryptionMaterials2 = this.materials;
        if (encryptionMaterials2 == null) {
            return null;
        }
        Map<String, String> materialsDescription = encryptionMaterials2.getMaterialsDescription();
        if (map == null || !map.equals(materialsDescription)) {
            EncryptionMaterialsAccessor accessor = this.materials.getAccessor();
            if (accessor == null || (encryptionMaterials = accessor.getEncryptionMaterials(map)) == null) {
                boolean z = false;
                boolean z2 = map == null || map.size() == 0;
                if (materialsDescription == null || materialsDescription.size() == 0) {
                    z = true;
                }
                EncryptionMaterials encryptionMaterials3 = null;
                if (z2) {
                    encryptionMaterials3 = null;
                    if (z) {
                        encryptionMaterials3 = this.materials;
                    }
                }
                return encryptionMaterials3;
            }
            return encryptionMaterials;
        }
        return this.materials;
    }

    @Override // com.tencent.cos.xml.crypto.EncryptionMaterialsProvider
    public void refresh() {
    }
}
