package com.tencent.cos.xml.model.object;

import android.util.Base64;
import com.tencent.cos.xml.CosXmlServiceConfig;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.crypto.Headers;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.cos.xml.utils.DigestUtils;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/ObjectRequest.class */
public abstract class ObjectRequest extends CosXmlRequest {
    protected String cosPath;

    public ObjectRequest(String str, String str2) {
        this.bucket = str;
        this.cosPath = str2;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.requestURL != null) {
            return;
        }
        if (this.bucket == null || this.bucket.length() < 1) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "bucket must not be null ");
        }
        String str = this.cosPath;
        if (str == null || str.length() < 1) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "cosPath must not be null ");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0039, code lost:
        if (r4.isEmpty() != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0.isEmpty() != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getContentType() {
        /*
            r3 = this;
            r0 = r3
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r0 = r0.requestHeaders
            java.lang.String r1 = "Content-Type"
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L1e
            r0 = r5
            r4 = r0
            r0 = r5
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L2d
        L1e:
            r0 = r3
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r0 = r0.requestHeaders
            java.lang.String r1 = "content-type"
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
            r4 = r0
        L2d:
            r0 = r4
            if (r0 == 0) goto L3c
            r0 = r4
            r5 = r0
            r0 = r4
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L4b
        L3c:
            r0 = r3
            java.util.Map<java.lang.String, java.util.List<java.lang.String>> r0 = r0.requestHeaders
            java.lang.String r1 = "Content-type"
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
            r5 = r0
        L4b:
            r0 = r5
            if (r0 == 0) goto L63
            r0 = r5
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L63
            r0 = r5
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            return r0
        L63:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cos.xml.model.object.ObjectRequest.getContentType():java.lang.String");
    }

    public String getCosPath() {
        return this.cosPath;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getPath(CosXmlServiceConfig cosXmlServiceConfig) {
        return cosXmlServiceConfig.getUrlPath(this.bucket, this.cosPath);
    }

    public void setCOSServerSideEncryption() {
        addHeader(Headers.SERVER_SIDE_ENCRYPTION, "AES256");
    }

    public void setCOSServerSideEncryptionWithCustomerKey(String str) throws CosXmlClientException {
        if (str != null) {
            addHeader(Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_ALGORITHM, "AES256");
            addHeader(Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY, DigestUtils.getBase64(str));
            try {
                addHeader(Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY_MD5, Base64.encodeToString(MessageDigest.getInstance("MD5").digest(str.getBytes(Charset.forName("UTF-8"))), 2));
            } catch (NoSuchAlgorithmException e) {
                throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), e);
            }
        }
    }

    public void setCOSServerSideEncryptionWithKMS(String str, String str2) throws CosXmlClientException {
        addHeader(Headers.SERVER_SIDE_ENCRYPTION, "cos/kms");
        if (str != null) {
            addHeader(Headers.SERVER_SIDE_ENCRYPTION_COS_KMS_KEY_ID, str);
        }
        if (str2 != null) {
            addHeader(Headers.SERVER_SIDE_ENCRYPTION_CONTEXT, DigestUtils.getBase64(str2));
        }
    }

    public void setCosPath(String str) {
        this.cosPath = str;
    }
}
