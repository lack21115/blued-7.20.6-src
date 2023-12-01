package com.tencent.cos.xml.crypto;

import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.qcloud.core.auth.BasicQCloudCredentials;
import com.tencent.qcloud.core.auth.QCloudCredentialProvider;
import com.tencent.qcloud.core.auth.QCloudCredentials;
import com.tencent.qcloud.core.auth.SessionQCloudCredentials;
import com.tencent.qcloud.core.common.QCloudClientException;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.kms.v20190118.KmsClient;
import com.tencentcloudapi.kms.v20190118.models.DecryptRequest;
import com.tencentcloudapi.kms.v20190118.models.DecryptResponse;
import com.tencentcloudapi.kms.v20190118.models.EncryptRequest;
import com.tencentcloudapi.kms.v20190118.models.EncryptResponse;
import com.tencentcloudapi.kms.v20190118.models.GenerateDataKeyRequest;
import com.tencentcloudapi.kms.v20190118.models.GenerateDataKeyResponse;
import java.util.Locale;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/TencentCloudKMSClient.class */
public class TencentCloudKMSClient implements QCLOUDKMS {
    private QCloudCredentialProvider credentialProvider;
    private final KmsClient kmsClient;

    public TencentCloudKMSClient(String str, QCloudCredentialProvider qCloudCredentialProvider) {
        this.kmsClient = new KmsClient((Credential) null, str);
        this.credentialProvider = qCloudCredentialProvider;
    }

    private CosXmlClientException getClientException(TencentCloudSDKException tencentCloudSDKException, String str) {
        return new CosXmlClientException(ClientErrorCode.KMS_ERROR.getCode(), String.format(Locale.ENGLISH, "%s: %s, error code: %s, requestId: %s", str, tencentCloudSDKException.getMessage(), tencentCloudSDKException.getErrorCode(), tencentCloudSDKException.getRequestId()));
    }

    public void assetCredentials() throws CosXmlClientException {
        Credential credential;
        try {
            QCloudCredentials credentials = this.credentialProvider.getCredentials();
            if (credentials instanceof SessionQCloudCredentials) {
                SessionQCloudCredentials sessionQCloudCredentials = (SessionQCloudCredentials) credentials;
                credential = new Credential(sessionQCloudCredentials.getSecretId(), sessionQCloudCredentials.getSecretKey(), sessionQCloudCredentials.getToken());
            } else if (!(credentials instanceof BasicQCloudCredentials)) {
                throw CosXmlClientException.internalException("credentials is neither SessionQCloudCredentials nor BasicQCloudCredentials ");
            } else {
                BasicQCloudCredentials basicQCloudCredentials = (BasicQCloudCredentials) credentials;
                credential = new Credential(basicQCloudCredentials.getSecretId(), basicQCloudCredentials.getSecretKey());
            }
            this.kmsClient.setCredential(credential);
        } catch (QCloudClientException e) {
            throw CosXmlClientException.internalException(e.getMessage());
        }
    }

    @Override // com.tencent.cos.xml.crypto.QCLOUDKMS
    public DecryptResponse decrypt(DecryptRequest decryptRequest) throws CosXmlClientException {
        try {
            assetCredentials();
            return this.kmsClient.Decrypt(decryptRequest);
        } catch (TencentCloudSDKException e) {
            throw getClientException(e, "TencentCloudKMS Service got exception while Decrypt");
        }
    }

    @Override // com.tencent.cos.xml.crypto.QCLOUDKMS
    public EncryptResponse encrypt(EncryptRequest encryptRequest) throws CosXmlClientException {
        try {
            assetCredentials();
            return this.kmsClient.Encrypt(encryptRequest);
        } catch (TencentCloudSDKException e) {
            throw getClientException(e, "TencentCloudKMS Service got exception while Encrypt");
        }
    }

    @Override // com.tencent.cos.xml.crypto.QCLOUDKMS
    public GenerateDataKeyResponse generateDataKey(GenerateDataKeyRequest generateDataKeyRequest) throws CosXmlClientException {
        try {
            assetCredentials();
            return this.kmsClient.GenerateDataKey(generateDataKeyRequest);
        } catch (TencentCloudSDKException e) {
            throw getClientException(e, "TencentCloudKMS Service got exception while GenerateDataKey");
        }
    }

    @Override // com.tencent.cos.xml.crypto.QCLOUDKMS
    public void shutdown() {
    }
}
