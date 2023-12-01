package com.tencent.cos.xml.crypto;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencentcloudapi.kms.v20190118.models.DecryptRequest;
import com.tencentcloudapi.kms.v20190118.models.DecryptResponse;
import com.tencentcloudapi.kms.v20190118.models.EncryptRequest;
import com.tencentcloudapi.kms.v20190118.models.EncryptResponse;
import com.tencentcloudapi.kms.v20190118.models.GenerateDataKeyRequest;
import com.tencentcloudapi.kms.v20190118.models.GenerateDataKeyResponse;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/QCLOUDKMS.class */
public interface QCLOUDKMS {
    DecryptResponse decrypt(DecryptRequest decryptRequest) throws CosXmlClientException;

    EncryptResponse encrypt(EncryptRequest encryptRequest) throws CosXmlClientException;

    GenerateDataKeyResponse generateDataKey(GenerateDataKeyRequest generateDataKeyRequest) throws CosXmlClientException;

    void shutdown();
}
