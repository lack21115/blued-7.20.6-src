package com.tencent.cos.xml.model.object;

import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.model.tag.RestoreConfigure;
import com.tencent.cos.xml.transfer.XmlBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/RestoreRequest.class */
public class RestoreRequest extends ObjectRequest {
    private RestoreConfigure restoreConfigure;

    public RestoreRequest(String str, String str2) {
        super(str, str2);
        RestoreConfigure restoreConfigure = new RestoreConfigure();
        this.restoreConfigure = restoreConfigure;
        restoreConfigure.casJobParameters = new RestoreConfigure.CASJobParameters();
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "POST";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put("restore", null);
        return this.queryParameters;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlBuilder.buildRestore(this.restoreConfigure));
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

    public void setExpireDays(int i) {
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        this.restoreConfigure.days = i2;
    }

    public void setTier(RestoreConfigure.Tier tier) {
        if (tier != null) {
            this.restoreConfigure.casJobParameters.tier = tier.getTier();
        }
    }
}
