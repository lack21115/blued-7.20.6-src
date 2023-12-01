package com.tencent.cos.xml.model.object;

import com.google.common.net.HttpHeaders;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.qcloud.core.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/OptionObjectResult.class */
public final class OptionObjectResult extends CosXmlResult {
    public List<String> accessControlAllowHeaders;
    public List<String> accessControlAllowMethods;
    public String accessControlAllowOrigin;
    public List<String> accessControlExposeHeaders;
    public long accessControlMaxAge;

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlServiceException, CosXmlClientException {
        super.parseResponseBody(httpResponse);
        this.accessControlAllowOrigin = httpResponse.header(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN);
        if (httpResponse.header(HttpHeaders.ACCESS_CONTROL_MAX_AGE) != null) {
            this.accessControlMaxAge = Long.parseLong(httpResponse.header(HttpHeaders.ACCESS_CONTROL_MAX_AGE));
        }
        if (httpResponse.header(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS) != null) {
            this.accessControlAllowMethods = Arrays.asList(httpResponse.header(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS).split(","));
        }
        if (httpResponse.header(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS) != null) {
            this.accessControlAllowHeaders = Arrays.asList(httpResponse.header(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS).split(","));
        }
        if (httpResponse.header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS) != null) {
            this.accessControlExposeHeaders = Arrays.asList(httpResponse.header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS).split(","));
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public String printResult() {
        return super.printResult() + "\n" + this.accessControlAllowOrigin + "\n" + this.accessControlMaxAge + "\n";
    }
}
