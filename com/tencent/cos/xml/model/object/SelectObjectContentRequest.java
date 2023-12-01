package com.tencent.cos.xml.model.object;

import com.ishumei.sdk.captcha.SmCaptchaWebView;
import com.tencent.cos.xml.common.ClientErrorCode;
import com.tencent.cos.xml.exception.CosXmlClientException;
import com.tencent.cos.xml.listener.SelectObjectContentListener;
import com.tencent.cos.xml.model.tag.eventstreaming.InputSerialization;
import com.tencent.cos.xml.model.tag.eventstreaming.OutputSerialization;
import com.tencent.cos.xml.model.tag.eventstreaming.RequestProgress;
import com.tencent.cos.xml.model.tag.eventstreaming.SelectRequest;
import com.tencent.cos.xml.transfer.XmlBuilder;
import com.tencent.qcloud.core.http.RequestBodySerializer;
import java.io.IOException;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/object/SelectObjectContentRequest.class */
public class SelectObjectContentRequest extends ObjectRequest {
    public static final String EXPRESSION_TYPE_SQL = "SQL";
    private String expression;
    private String expressionType;
    private InputSerialization inputSerialization;
    private OutputSerialization outputSerialization;
    private RequestProgress requestProgress;
    private SelectObjectContentListener selectObjectContentProgressListener;
    private String selectResponseFilePath;

    public SelectObjectContentRequest(String str, String str2, String str3, String str4, RequestProgress requestProgress, InputSerialization inputSerialization, OutputSerialization outputSerialization) {
        super(str, str2);
        this.expression = str4;
        this.expressionType = str3;
        this.requestProgress = requestProgress;
        this.inputSerialization = inputSerialization;
        this.outputSerialization = outputSerialization;
    }

    public SelectObjectContentRequest(String str, String str2, String str3, boolean z, InputSerialization inputSerialization, OutputSerialization outputSerialization) {
        this(str, str2, EXPRESSION_TYPE_SQL, str3, new RequestProgress(Boolean.valueOf(z)), inputSerialization, outputSerialization);
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public String getMethod() {
        return "POST";
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public Map<String, String> getQueryString() {
        this.queryParameters.put(SmCaptchaWebView.MODE_SELECT, null);
        this.queryParameters.put("select-type", "2");
        return this.queryParameters;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public RequestBodySerializer getRequestBody() throws CosXmlClientException {
        try {
            return RequestBodySerializer.string("application/xml", XmlBuilder.buildSelectRequest(new SelectRequest(this.expressionType, this.expression, this.requestProgress, this.inputSerialization, this.outputSerialization)));
        } catch (IOException e) {
            throw new CosXmlClientException(ClientErrorCode.IO_ERROR.getCode(), e);
        } catch (XmlPullParserException e2) {
            throw new CosXmlClientException(ClientErrorCode.INVALID_ARGUMENT.getCode(), e2);
        }
    }

    public SelectObjectContentListener getSelectObjectContentProgressListener() {
        return this.selectObjectContentProgressListener;
    }

    public String getSelectResponseFilePath() {
        return this.selectResponseFilePath;
    }

    @Override // com.tencent.cos.xml.model.CosXmlRequest
    public boolean isNeedMD5() {
        return true;
    }

    public void setSelectObjectContentProgressListener(SelectObjectContentListener selectObjectContentListener) {
        this.selectObjectContentProgressListener = selectObjectContentListener;
    }

    public void setSelectResponseFilePath(String str) {
        this.selectResponseFilePath = str;
    }
}
