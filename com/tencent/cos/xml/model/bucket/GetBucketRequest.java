package com.tencent.cos.xml.model.bucket;

import com.tencent.connect.common.Constants;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/bucket/GetBucketRequest.class */
public final class GetBucketRequest extends BucketRequest {
    private String delimiter;
    private String encodingType;
    private String marker;
    private String maxKeys;
    private String prefix;

    public GetBucketRequest(String str) {
        super(str);
        this.prefix = null;
        this.delimiter = null;
        this.marker = null;
        this.maxKeys = Constants.DEFAULT_UIN;
    }

    public GetBucketRequest(String str, String str2, String str3) {
        super(str2);
        this.prefix = null;
        this.delimiter = null;
        this.marker = null;
        this.maxKeys = Constants.DEFAULT_UIN;
        this.region = str;
        this.prefix = str3;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public String getMarker() {
        return this.marker;
    }

    public long getMaxKeys() {
        return Long.parseLong(this.maxKeys);
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "GET";
    }

    public String getPrefix() {
        return this.prefix;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        if (this.prefix != null) {
            this.queryParameters.put("prefix", this.prefix);
        }
        if (this.delimiter != null) {
            this.queryParameters.put("delimiter", this.delimiter);
        }
        if (this.encodingType != null) {
            this.queryParameters.put("encoding-type", this.encodingType);
        }
        if (this.marker != null) {
            this.queryParameters.put("marker", this.marker);
        }
        if (this.maxKeys != null) {
            this.queryParameters.put("max-keys", this.maxKeys);
        }
        if (this.prefix != null) {
            this.queryParameters.put("prefix", this.prefix);
        }
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() {
        return null;
    }

    @Deprecated
    public void setDelimiter(char c2) {
        setDelimiter(String.valueOf(c2));
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public void setEncodingType(String str) {
        this.encodingType = str;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public void setMaxKeys(long j) {
        this.maxKeys = String.valueOf(j);
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }
}
