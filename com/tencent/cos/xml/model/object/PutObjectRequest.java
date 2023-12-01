package com.tencent.cos.xml.model.object;

import android.net.Uri;
import com.tencent.cos.xml.common.COSACL;
import com.tencent.cos.xml.common.COSRequestHeaderKey;
import com.tencent.cos.xml.common.COSStorageClass;
import com.tencent.cos.xml.crypto.ObjectMetadata;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.ACLAccount;
import com.tencent.cos.xml.model.tag.pic.PicOperations;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/PutObjectRequest.class */
public class PutObjectRequest extends BasePutObjectRequest implements TransferRequest {
    private ObjectMetadata metadata;

    public PutObjectRequest(String str, String str2) {
        super(str, str2);
    }

    public PutObjectRequest(String str, String str2, Uri uri) {
        super(str, str2, uri);
    }

    public PutObjectRequest(String str, String str2, InputStream inputStream) {
        super(str, str2, inputStream);
    }

    public PutObjectRequest(String str, String str2, String str3) {
        super(str, str2, str3);
    }

    public PutObjectRequest(String str, String str2, StringBuilder sb) {
        super(str, str2, sb);
    }

    public PutObjectRequest(String str, String str2, URL url) {
        super(str, str2, url);
    }

    public PutObjectRequest(String str, String str2, byte[] bArr) {
        super(str, str2, bArr);
    }

    @Override // com.tencent.cos.xml.model.object.BasePutObjectRequest, com.tencent.cos.xml.model.object.ObjectRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        ObjectMetadata objectMetadata = this.metadata;
        if (objectMetadata != null) {
            Map<String, Object> rawMetadata = objectMetadata.getRawMetadata();
            Map<String, String> userMetadata = this.metadata.getUserMetadata();
            for (Map.Entry<String, Object> entry : rawMetadata.entrySet()) {
                addHeader(entry.getKey(), entry.getValue().toString());
            }
            for (Map.Entry<String, String> entry2 : userMetadata.entrySet()) {
                addHeader(entry2.getKey(), entry2.getValue());
            }
        }
    }

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public void setCacheControl(String str) {
        if (str == null) {
            return;
        }
        addHeader("Cache-Control", str);
    }

    public void setContentDisposition(String str) {
        if (str == null) {
            return;
        }
        addHeader("Content-Disposition", str);
    }

    public void setContentEncodeing(String str) {
        if (str == null) {
            return;
        }
        addHeader("Content-Encoding", str);
    }

    public void setExpires(String str) {
        if (str == null) {
            return;
        }
        addHeader("Expires", str);
    }

    public void setMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public void setPicOperations(PicOperations picOperations) {
        addHeader("Pic-Operations", picOperations.toJsonStr());
    }

    public void setStroageClass(COSStorageClass cOSStorageClass) {
        addHeader("x-cos-storage-class", cOSStorageClass.getStorageClass());
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
