package com.tencent.cos.xml.model.bucket;

import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/bucket/GetBucketObjectVersionsRequest.class */
public class GetBucketObjectVersionsRequest extends BucketRequest {
    private String delimiter;
    private String encodingType;
    private String keyMarker;
    private int maxKeys;
    private String prefix;
    private String versionIdMarker;

    public GetBucketObjectVersionsRequest(String str) {
        super(str);
        this.maxKeys = 1000;
    }

    public GetBucketObjectVersionsRequest(String str, String str2, String str3, String str4) {
        this(str, "", str2, str3, str4);
    }

    public GetBucketObjectVersionsRequest(String str, String str2, String str3, String str4, String str5) {
        super(str);
        this.maxKeys = 1000;
        this.prefix = str2;
        this.delimiter = str3;
        this.keyMarker = str4;
        this.versionIdMarker = str5;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getKeyMarker() {
        return this.keyMarker;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "GET";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("versions", null);
        addQuery("prefix", this.prefix);
        addQuery("delimiter", this.delimiter);
        addQuery("encoding-type", this.encodingType);
        addQuery("key-marker", this.keyMarker);
        addQuery("version-id-marker", this.versionIdMarker);
        addQuery("max-keys", String.valueOf(this.maxKeys));
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        return null;
    }

    public String getVersionIdMarker() {
        return this.versionIdMarker;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    public void setEncodingType(String str) {
        this.encodingType = str;
    }

    public void setKeyMarker(String str) {
        this.keyMarker = str;
    }

    public void setMaxKeys(int i) {
        this.maxKeys = i;
    }

    public void setPrefix(String str) {
        this.prefix = str;
    }

    public void setVersionIdMarker(String str) {
        this.versionIdMarker = str;
    }
}
