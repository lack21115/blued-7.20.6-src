package com.tencent.cos.xml.model.bucket;

import com.tencent.connect.common.Constants;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

@Deprecated
/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/bucket/ListBucketVersionsRequest.class */
public class ListBucketVersionsRequest extends BucketRequest {
    private String delimiter;
    private String encodingType;
    private String keyMarker;
    private String maxKeys;
    private String prefix;
    private String versionIdMarker;

    public ListBucketVersionsRequest(String str) {
        super(str);
        this.maxKeys = Constants.DEFAULT_UIN;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "GET";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("versions", null);
        if (this.prefix != null) {
            this.queryParameters.put("prefix", this.prefix);
        }
        if (this.keyMarker != null) {
            this.queryParameters.put("key-marker", this.keyMarker);
        }
        if (this.versionIdMarker != null) {
            this.queryParameters.put("version-id-marker", this.versionIdMarker);
        }
        if (this.delimiter != null) {
            this.queryParameters.put("delimiter", this.delimiter);
        }
        if (this.encodingType != null) {
            this.queryParameters.put("encoding-type", this.encodingType);
        }
        if (!this.maxKeys.equals(Constants.DEFAULT_UIN)) {
            this.queryParameters.put("max-keys", this.maxKeys);
        }
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        return null;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public void setEncodingType(String str) {
        this.encodingType = str;
    }

    public void setKeyMarker(String str) {
        if (str != null) {
            this.keyMarker = str;
        }
    }

    public void setMaxKeys(int i) {
        this.maxKeys = String.valueOf(i);
    }

    public void setPrefix(String str) {
        if (str != null) {
            this.prefix = str;
        }
    }

    public void setVersionIdMarker(String str) {
        if (str != null) {
            this.versionIdMarker = str;
        }
    }
}
