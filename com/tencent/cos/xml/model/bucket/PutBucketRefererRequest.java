package com.tencent.cos.xml.model.bucket;

import android.provider.Downloads;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.RefererConfiguration;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import com.tencent.qcloud.qcloudxml.core.QCloudXml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/bucket/PutBucketRefererRequest.class */
public class PutBucketRefererRequest extends BucketRequest {
    private final RefererConfiguration refererConfiguration;

    public PutBucketRefererRequest(String str, boolean z, RefererConfiguration.RefererType refererType) {
        super(str);
        RefererConfiguration refererConfiguration = new RefererConfiguration();
        this.refererConfiguration = refererConfiguration;
        refererConfiguration.setEnabled(z);
        this.refererConfiguration.setRefererType(refererType);
        this.refererConfiguration.setAllowEmptyRefer(false);
        this.refererConfiguration.domainList = new ArrayList();
    }

    @Override // com.tencent.cos.xml.model.bucket.BucketRequest, com.tencent.cos.xml.model.CosXmlRequest
    public void checkParameters() throws CosXmlClientException {
        super.checkParameters();
        if (this.refererConfiguration.domainList == null || this.refererConfiguration.domainList.size() <= 0) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), "DomainList must not be null");
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "PUT";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put(Downloads.Impl.COLUMN_REFERER, null);
        return super.getQueryString();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", QCloudXml.toXml(this.refererConfiguration));
        } catch (IOException e) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e2);
        }
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public boolean isNeedMD5() {
        return true;
    }

    public void setAllowEmptyRefer(boolean z) {
        this.refererConfiguration.setAllowEmptyRefer(z);
    }

    public void setDomainList(List<RefererConfiguration.Domain> list) {
        this.refererConfiguration.domainList = list;
    }

    public void setEnabled(boolean z) {
        this.refererConfiguration.setEnabled(z);
    }

    public void setRefererType(RefererConfiguration.RefererType refererType) {
        this.refererConfiguration.setRefererType(refererType);
    }
}
