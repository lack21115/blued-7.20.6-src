package com.tencent.cos.xml.model.object;

import android.util.Base64;
import com.tencent.cos.xml.CosXmlServiceConfig;
import com.tencent.cos.xml.common.COSACL;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.common.COSStorageClass;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.common.MetaDataDirective;
import com.tencent.cos.xml.crypto.Headers;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.ACLAccount;
import com.tencent.cos.xml.utils.DigestUtils;
import com.tencent.cos.xml.utils.URLEncodeUtils;
import com.tencent.qcloud.core.auth.STSCredentialScope;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/CopyObjectRequest.class */
public class CopyObjectRequest extends ObjectRequest {
    private CopySourceStruct copySourceStruct;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/CopyObjectRequest$CopySourceStruct.class */
    public static class CopySourceStruct {
        public String bucket;
        public String cosPath;
        public String region;
        public String versionId;

        public CopySourceStruct(String str, String str2, String str3) {
            this.bucket = str;
            this.region = str2;
            this.cosPath = str3;
        }

        @Deprecated
        public CopySourceStruct(String str, String str2, String str3, String str4) {
            this.bucket = str2.concat(Constants.ACCEPT_TIME_SEPARATOR_SERVER).concat(str);
            this.region = str3;
            this.cosPath = str4;
        }

        public CopySourceStruct(String str, String str2, String str3, String str4, String str5) {
            this(str, str2, str3, str4);
            this.versionId = str5;
        }

        public void checkParameters() throws CosXmlClientException {
            if (this.bucket == null) {
                throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "copy source bucket must not be null");
            }
            String str = this.cosPath;
            if (str == null) {
                throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "copy source cosPath must not be null");
            }
            if (this.region == null) {
                throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "copy source region must not be null");
            }
            this.cosPath = URLEncodeUtils.cosPathEncode(str);
        }

        public String getSource(CosXmlServiceConfig cosXmlServiceConfig) {
            String str = this.cosPath;
            if (str != null && !str.startsWith("/")) {
                this.cosPath = "/" + this.cosPath;
            }
            String str2 = cosXmlServiceConfig.getDefaultRequestHost(this.region, this.bucket) + this.cosPath;
            String str3 = str2;
            if (this.versionId != null) {
                str3 = str2 + "?versionId=" + this.versionId;
            }
            return str3;
        }
    }

    public CopyObjectRequest(String str, String str2, CopySourceStruct copySourceStruct) {
        super(str, str2);
        this.copySourceStruct = copySourceStruct;
    }

    @Override // com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        CopySourceStruct copySourceStruct = this.copySourceStruct;
        if (copySourceStruct == null) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "copy source must not be null");
        }
        copySourceStruct.checkParameters();
    }

    public CopySourceStruct getCopySource() {
        return this.copySourceStruct;
    }

    @Override // com.tencent.cos.xml.model.object.ObjectRequest
    public String getCosPath() {
        return this.cosPath;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "PUT";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        return RequestBodySerializer.bytes(null, new byte[0]);
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public STSCredentialScope[] getSTSCredentialScope(CosXmlServiceConfig cosXmlServiceConfig) {
        return STSCredentialScope.toArray(new STSCredentialScope("name/cos:PutObject", cosXmlServiceConfig.getBucket(this.bucket), cosXmlServiceConfig.getRegion(), getPath(cosXmlServiceConfig)), new STSCredentialScope("name/cos:GetObject", this.copySourceStruct.bucket, this.copySourceStruct.region, this.copySourceStruct.cosPath));
    }

    public void setCopyIfMatch(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.X_COS_COPY_SOURCE_IF_MATCH, str);
        }
    }

    public void setCopyIfModifiedSince(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.X_COS_COPY_SOURCE_IF_MODIFIED_SINCE, str);
        }
    }

    public void setCopyIfNoneMatch(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.X_COS_COPY_SOURCE_IF_NONE_MATCH, str);
        }
    }

    public void setCopyIfUnmodifiedSince(String str) {
        if (str != null) {
            addHeader(COSRequestHeaderKey.X_COS_COPY_SOURCE_IF_UNMODIFIED_SINCE, str);
        }
    }

    public void setCopyMetaDataDirective(MetaDataDirective metaDataDirective) {
        if (metaDataDirective != null) {
            addHeader("x-cos-metadata-directive", metaDataDirective.getMetaDirective());
        }
    }

    public void setCopySource(CopySourceStruct copySourceStruct, CosXmlServiceConfig cosXmlServiceConfig) throws CosXmlClientException {
        this.copySourceStruct = copySourceStruct;
        if (copySourceStruct != null) {
            addHeader(COSRequestHeaderKey.X_COS_COPY_SOURCE, copySourceStruct.getSource(cosXmlServiceConfig));
        }
    }

    public void setCopySourceServerSideEncryptionCustomerKey(String str) throws CosXmlClientException {
        if (str != null) {
            addHeader(Headers.COPY_SOURCE_SERVER_SIDE_ENCRYPTION_CUSTOMER_ALGORITHM, "AES256");
            addHeader(Headers.COPY_SOURCE_SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY, DigestUtils.getBase64(str));
            try {
                addHeader(Headers.COPY_SOURCE_SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY_MD5, Base64.encodeToString(MessageDigest.getInstance("MD5").digest(str.getBytes(Charset.forName("UTF-8"))), 2));
            } catch (NoSuchAlgorithmException e) {
                throw new CosXmlClientException(ClientErrorCode.INTERNAL_ERROR.getCode(), e);
            }
        }
    }

    public void setCopySourceServerSideEncryptionKMS(String str, String str2) throws CosXmlClientException {
        addHeader("'x-cos-copy-source-server-side-encryption", "cos/kms");
        if (str != null) {
            addHeader("x-cos-copy-source-server-side-encryption-cos-kms-key-id", str);
        }
        if (str2 != null) {
            addHeader("x-cos-copy-source-server-side-encryption-context", DigestUtils.getBase64(str2));
        }
    }

    @Override // com.tencent.cos.xml.model.object.ObjectRequest
    public void setCosPath(String str) {
        this.cosPath = str;
    }

    public void setCosStorageClass(COSStorageClass cOSStorageClass) {
        if (cOSStorageClass != null) {
            addHeader("x-cos-storage-class", cOSStorageClass.getStorageClass());
        }
    }

    public void setXCOSACL(COSACL cosacl) {
        if (cosacl != null) {
            addHeader("x-cos-acl", cosacl.getAcl());
        }
    }

    public void setXCOSACL(String str) {
        if (str != null) {
            addHeader("x-cos-acl", str);
        }
    }

    public void setXCOSGrantRead(ACLAccount aCLAccount) {
        if (aCLAccount != null) {
            addHeader(COSRequestHeaderKey.X_COS_GRANT_READ, aCLAccount.getAccount());
        }
    }

    public void setXCOSGrantWrite(ACLAccount aCLAccount) {
        if (aCLAccount != null) {
            addHeader(COSRequestHeaderKey.X_COS_GRANT_WRITE, aCLAccount.getAccount());
        }
    }

    public void setXCOSMeta(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        addHeader(str, str2);
    }

    public void setXCOSReadWrite(ACLAccount aCLAccount) {
        if (aCLAccount != null) {
            addHeader(COSRequestHeaderKey.X_COS_GRANT_FULL_CONTROL, aCLAccount.getAccount());
        }
    }
}
