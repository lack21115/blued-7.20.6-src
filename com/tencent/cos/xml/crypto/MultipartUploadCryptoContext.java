package com.tencent.cos.xml.crypto;

import com.tencent.cos.xml.exception.CosXmlClientException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/MultipartUploadCryptoContext.class */
public class MultipartUploadCryptoContext {
    private final String bucketName;
    private final ContentCryptoMaterial cekMaterial;
    private boolean hasFinalPartBeenSeen;
    private final String key;
    private Map<String, String> materialsDescription;
    private int partNumber;
    private volatile boolean partUploadInProgress;

    /* JADX INFO: Access modifiers changed from: protected */
    public MultipartUploadCryptoContext(String str, String str2, ContentCryptoMaterial contentCryptoMaterial) {
        this.bucketName = str;
        this.key = str2;
        this.cekMaterial = contentCryptoMaterial;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void beginPartUpload(int i) throws CosXmlClientException {
        if (i < 1) {
            throw new IllegalArgumentException("part number must be at least 1");
        }
        if (this.partUploadInProgress) {
            throw CosXmlClientException.internalException("Parts are required to be uploaded in series");
        }
        synchronized (this) {
            if (this.partUploadInProgress) {
                throw CosXmlClientException.internalException("Parts are required to be uploaded in series");
            }
            if (i - this.partNumber > 1) {
                throw CosXmlClientException.internalException("Parts are required to be uploaded in series (partNumber=" + this.partNumber + ", nextPartNumber=" + i + ")");
            }
            this.partNumber = i;
            this.partUploadInProgress = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void endPartUpload() {
        this.partUploadInProgress = false;
    }

    public final String getBucketName() {
        return this.bucketName;
    }

    public CipherLite getCipherLite() {
        return this.cekMaterial.getCipherLite();
    }

    ContentCryptoMaterial getContentCryptoMaterial() {
        return this.cekMaterial;
    }

    public final String getKey() {
        return this.key;
    }

    public final Map<String, String> getMaterialsDescription() {
        return this.materialsDescription;
    }

    public final boolean hasFinalPartBeenSeen() {
        return this.hasFinalPartBeenSeen;
    }

    public final void setHasFinalPartBeenSeen(boolean z) {
        this.hasFinalPartBeenSeen = z;
    }

    public final void setMaterialsDescription(Map<String, String> map) {
        this.materialsDescription = map == null ? null : Collections.unmodifiableMap(new HashMap(map));
    }
}
