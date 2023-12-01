package com.tencent.cos.xml.model.ci;

import android.text.TextUtils;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.exception.CosXmlServiceException;
import com.tencent.cos.xml.model.CosXmlResult;
import com.tencent.qcloud.core.http.HttpResponse;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/ci/PreviewDocumentInHtmlLinkResult.class */
public class PreviewDocumentInHtmlLinkResult extends CosXmlResult {
    private String previewUrl;

    public String getPreviewUrl() {
        return this.previewUrl;
    }

    @Override // com.tencent.cos.xml.model.CosXmlResult
    public void parseResponseBody(HttpResponse httpResponse) throws CosXmlClientException, CosXmlServiceException {
        super.parseResponseBody(httpResponse);
        try {
            String string = httpResponse.string();
            if (TextUtils.isEmpty(string)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("PreviewUrl")) {
                this.previewUrl = jSONObject.getString("PreviewUrl");
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
