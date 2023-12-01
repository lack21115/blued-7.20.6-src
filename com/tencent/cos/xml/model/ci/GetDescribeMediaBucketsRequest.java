package com.tencent.cos.xml.model.ci;

import com.tencent.cos.xml.CosXmlServiceConfig;
import com.tencent.cos.xml.model.CosXmlRequest;
import com.tencent.qcloud.core.http.RequestBodySerializer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/GetDescribeMediaBucketsRequest.class */
public final class GetDescribeMediaBucketsRequest extends CosXmlRequest {
    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "GET";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getPath(CosXmlServiceConfig cosXmlServiceConfig) {
        return "/mediabucket";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() {
        return null;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getRequestHost(CosXmlServiceConfig cosXmlServiceConfig) {
        return String.format("ci.%s.myqcloud.com", cosXmlServiceConfig.getRegion());
    }

    public void setBucketName(String str) {
        this.queryParameters.put("bucketName", str);
    }

    public void setBucketNames(String str) {
        this.queryParameters.put("bucketNames", str);
    }

    public void setPageNumber(int i) {
        this.queryParameters.put("pageNumber", String.valueOf(i));
    }

    public void setPageSize(int i) {
        this.queryParameters.put("pageSize", String.valueOf(i));
    }

    public void setRegions(String str) {
        this.queryParameters.put("regions", str);
    }
}
