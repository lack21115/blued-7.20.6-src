package com.sobot.network.http.request;

import android.text.TextUtils;
import com.sobot.network.http.SobotOkHttpUtils;
import com.sobot.network.http.utils.Exceptions;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.internal.http.HttpMethod;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/request/OtherRequest.class */
public class OtherRequest extends OkHttpRequest {
    private static MediaType MEDIA_TYPE_PLAIN = MediaType.parse("text/plain;charset=utf-8");
    private String content;
    private String method;
    private RequestBody requestBody;

    public OtherRequest(RequestBody requestBody, String str, String str2, String str3, Object obj, Map<String, String> map, Map<String, String> map2) {
        super(str3, obj, map, map2);
        this.requestBody = requestBody;
        this.method = str2;
        this.content = str;
    }

    @Override // com.sobot.network.http.request.OkHttpRequest
    protected Request buildRequest(RequestBody requestBody) {
        if (this.method.equals("PUT")) {
            this.builder.put(requestBody);
        } else if (this.method.equals("DELETE")) {
            if (requestBody == null) {
                this.builder.delete();
            } else {
                this.builder.delete(requestBody);
            }
        } else if (this.method.equals("HEAD")) {
            this.builder.head();
        } else if (this.method.equals(SobotOkHttpUtils.METHOD.PATCH)) {
            this.builder.patch(requestBody);
        }
        return this.builder.build();
    }

    @Override // com.sobot.network.http.request.OkHttpRequest
    protected RequestBody buildRequestBody() {
        if (this.requestBody == null && TextUtils.isEmpty(this.content) && HttpMethod.b(this.method)) {
            Exceptions.illegalArgument("requestBody and content can not be null in method:" + this.method, new Object[0]);
        }
        if (this.requestBody == null && !TextUtils.isEmpty(this.content)) {
            this.requestBody = RequestBody.create(MEDIA_TYPE_PLAIN, this.content);
        }
        return this.requestBody;
    }
}
