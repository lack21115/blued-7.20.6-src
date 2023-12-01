package com.tencent.cos.xml.model.ci;

import android.text.TextUtils;
import com.tencent.cos.xml.CosXmlServiceConfig;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.bucket.BucketRequest;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import com.umeng.analytics.pro.bh;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/SensitiveContentRecognitionRequest.class */
public class SensitiveContentRecognitionRequest extends BucketRequest {
    private String bizType;
    private String cosPath;
    private String detectUrl;
    private int interval;
    private boolean largeImageDetect;
    private int maxFrames;
    private final Set<String> types;

    public SensitiveContentRecognitionRequest(String str) {
        super(str);
        this.types = new HashSet();
    }

    public SensitiveContentRecognitionRequest(String str, String str2) {
        super(str);
        this.types = new HashSet();
        setCosPath(str2);
    }

    private void addCiParams() {
        if (this.types.isEmpty()) {
            this.types.add("porn");
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : this.types) {
            int i2 = i + 1;
            sb.append(str);
            i = i2;
            if (i2 < this.types.size()) {
                sb.append(",");
                i = i2;
            }
        }
        this.queryParameters.put("ci-process", "sensitive-content-recognition");
        if (!TextUtils.isEmpty(this.bizType)) {
            this.queryParameters.put("biz-type", this.bizType);
        }
        if (!TextUtils.isEmpty(this.detectUrl)) {
            this.queryParameters.put("detect-url", this.detectUrl);
        }
        if (this.interval > 0) {
            this.queryParameters.put(bh.aX, String.valueOf(this.interval));
        }
        if (this.maxFrames > 0) {
            this.queryParameters.put("max-frames", String.valueOf(this.maxFrames));
        }
        this.queryParameters.put("large-image-detect", this.largeImageDetect ? "1" : "0");
        this.queryParameters.put("detect-type", sb.toString());
    }

    public void addType(String str) {
        this.types.add(str);
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        String str;
        super.checkParameters();
        if (this.bucket == null || this.bucket.length() < 1) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "bucket must not be null ");
        }
        String str2 = this.cosPath;
        if ((str2 == null || str2.length() < 1) && ((str = this.detectUrl) == null || str.length() < 1)) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "cosPath or detectUrl must not be null ");
        }
        addCiParams();
    }

    public String getCosPath() {
        return this.cosPath;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "GET";
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public String getPath(CosXmlServiceConfig cosXmlServiceConfig) {
        String str = this.bucket;
        String str2 = this.cosPath;
        String str3 = str2;
        if (str2 == null) {
            str3 = "";
        }
        return cosXmlServiceConfig.getUrlPath(str, str3);
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        return null;
    }

    public void setBizType(String str) {
        this.bizType = str;
    }

    public void setCosPath(String str) {
        this.cosPath = str;
    }

    public void setDetectUrl(String str) {
        this.detectUrl = str;
    }

    public void setInterval(int i) {
        this.interval = i;
    }

    public void setLargeImageDetect(boolean z) {
        this.largeImageDetect = z;
    }

    public void setMaxFrames(int i) {
        this.maxFrames = i;
    }
}
