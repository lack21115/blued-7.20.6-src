package com.tencent.cos.xml.crypto;

import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/crypto/ObjectMetadata.class */
public class ObjectMetadata {
    private static final long serialVersionUID = 1;
    private Date expirationTime;
    private String expirationTimeRuleId;
    private Date httpExpiresDate;
    private boolean isDeleteMarker;
    private Map<String, Object> metadata;
    private Boolean ongoingRestore;
    private Date restoreExpirationTime;
    private Map<String, String> userMetadata;

    public ObjectMetadata() {
        this.userMetadata = new HashMap();
        this.metadata = new HashMap();
    }

    private ObjectMetadata(ObjectMetadata objectMetadata) {
        this.userMetadata = objectMetadata.userMetadata == null ? null : new HashMap(objectMetadata.userMetadata);
        this.metadata = objectMetadata.metadata == null ? null : new HashMap(objectMetadata.metadata);
        this.expirationTime = objectMetadata.expirationTime;
        this.expirationTimeRuleId = objectMetadata.expirationTimeRuleId;
        this.httpExpiresDate = objectMetadata.httpExpiresDate;
    }

    public ObjectMetadata(Map<String, List<String>> map) {
        this.userMetadata = new HashMap();
        this.metadata = new HashMap();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            String str = null;
            if (value != null) {
                str = null;
                if (!value.isEmpty()) {
                    str = value.get(0);
                }
            }
            if (!TextUtils.isEmpty(key) && str != null) {
                if (key.startsWith(Headers.COS_USER_METADATA_PREFIX)) {
                    this.userMetadata.put(key, str);
                } else {
                    this.metadata.put(key, str);
                }
            }
        }
    }

    public void addUserMetadata(String str, String str2) {
        this.userMetadata.put(str, str2);
    }

    /* renamed from: clone */
    public ObjectMetadata m10179clone() {
        return new ObjectMetadata(this);
    }

    public String getCacheControl() {
        return (String) this.metadata.get("Cache-Control");
    }

    public String getContentDisposition() {
        return (String) this.metadata.get("Content-Disposition");
    }

    public String getContentEncoding() {
        return (String) this.metadata.get("Content-Encoding");
    }

    public String getContentLanguage() {
        return (String) this.metadata.get("Content-Language");
    }

    public long getContentLength() {
        Long l = (Long) this.metadata.get("Content-Length");
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public String getContentMD5() {
        return (String) this.metadata.get("Content-MD5");
    }

    public String getContentType() {
        return (String) this.metadata.get("Content-Type");
    }

    public String getCrc64Ecma() {
        return (String) this.metadata.get(Headers.COS_HASH_CRC64_ECMA);
    }

    public String getETag() {
        return (String) this.metadata.get("ETag");
    }

    public Date getExpirationTime() {
        return this.expirationTime;
    }

    public Date getHttpExpiresDate() {
        return this.httpExpiresDate;
    }

    public long getInstanceLength() {
        int lastIndexOf;
        String str = (String) this.metadata.get("Content-Range");
        return (str == null || (lastIndexOf = str.lastIndexOf(BridgeUtil.SPLIT_MARK)) < 0) ? getContentLength() : Long.parseLong(str.substring(lastIndexOf + 1));
    }

    public Date getLastModified() {
        return (Date) this.metadata.get("Last-Modified");
    }

    public Boolean getOngoingRestore() {
        return this.ongoingRestore;
    }

    public Map<String, Object> getRawMetadata() {
        return Collections.unmodifiableMap(this.metadata);
    }

    public Object getRawMetadataValue(String str) {
        return this.metadata.get(str);
    }

    public Date getRestoreExpirationTime() {
        return this.restoreExpirationTime;
    }

    public String getSSEAlgorithm() {
        return (String) this.metadata.get(Headers.SERVER_SIDE_ENCRYPTION);
    }

    public String getSSECOSKmsKeyId() {
        return (String) this.metadata.get(Headers.SERVER_SIDE_ENCRYPTION_QCLOUD_KMS_KEYID);
    }

    public String getSSECustomerAlgorithm() {
        return (String) this.metadata.get(Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_ALGORITHM);
    }

    public String getSSECustomerKeyMd5() {
        return (String) this.metadata.get(Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY_MD5);
    }

    public String getServerSideEncryption() {
        return (String) this.metadata.get(Headers.SERVER_SIDE_ENCRYPTION);
    }

    public String getStorageClass() {
        Object obj = this.metadata.get("x-cos-storage-class");
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public String getUserMetaDataOf(String str) {
        Map<String, String> map = this.userMetadata;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public Map<String, String> getUserMetadata() {
        return this.userMetadata;
    }

    public String getVersionId() {
        return (String) this.metadata.get(Headers.COS_VERSION_ID);
    }

    public boolean isDeleteMarker() {
        return this.isDeleteMarker;
    }

    public void setCacheControl(String str) {
        this.metadata.put("Cache-Control", str);
    }

    public void setContentDisposition(String str) {
        this.metadata.put("Content-Disposition", str);
    }

    public void setContentEncoding(String str) {
        this.metadata.put("Content-Encoding", str);
    }

    public void setContentLanguage(String str) {
        this.metadata.put("Content-Language", str);
    }

    public void setContentLength(long j) {
        this.metadata.put("Content-Length", Long.valueOf(j));
    }

    public void setContentMD5(String str) {
        if (str == null) {
            this.metadata.remove("Content-MD5");
        } else {
            this.metadata.put("Content-MD5", str);
        }
    }

    public void setContentType(String str) {
        this.metadata.put("Content-Type", str);
    }

    public void setDeleteMarker(boolean z) {
        this.isDeleteMarker = z;
    }

    public void setExpirationTime(Date date) {
        this.expirationTime = date;
    }

    public void setHeader(String str, Object obj) {
        this.metadata.put(str, obj);
    }

    public void setHttpExpiresDate(Date date) {
        this.httpExpiresDate = date;
    }

    public void setLastModified(Date date) {
        this.metadata.put("Last-Modified", date);
    }

    public void setOngoingRestore(boolean z) {
        this.ongoingRestore = Boolean.valueOf(z);
    }

    public void setRestoreExpirationTime(Date date) {
        this.restoreExpirationTime = date;
    }

    public void setSSEAlgorithm(String str) {
        this.metadata.put(Headers.SERVER_SIDE_ENCRYPTION, str);
    }

    public void setSSECustomerAlgorithm(String str) {
        this.metadata.put(Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_ALGORITHM, str);
    }

    public void setSSECustomerKeyMd5(String str) {
        this.metadata.put(Headers.SERVER_SIDE_ENCRYPTION_CUSTOMER_KEY_MD5, str);
    }

    public void setSecurityToken(String str) {
        this.metadata.put(Headers.SECURITY_TOKEN, str);
    }

    public void setServerSideEncryption(String str) {
        this.metadata.put(Headers.SERVER_SIDE_ENCRYPTION, str);
    }

    public void setUserMetadata(Map<String, String> map) {
        this.userMetadata = map;
    }
}
