package com.sobot.network.http.request;

import com.sobot.network.http.utils.Exceptions;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/request/PostStringRequest.class */
public class PostStringRequest extends OkHttpRequest {
    private static MediaType MEDIA_TYPE_PLAIN = MediaType.parse("text/plain;charset=utf-8");
    private String content;
    private MediaType mediaType;

    public PostStringRequest(String str, Object obj, Map<String, String> map, Map<String, String> map2, String str2, MediaType mediaType) {
        super(str, obj, map, map2);
        this.content = str2;
        this.mediaType = mediaType;
        if (str2 == null) {
            Exceptions.illegalArgument("the content can not be null !", new Object[0]);
        }
        if (this.mediaType == null) {
            this.mediaType = MEDIA_TYPE_PLAIN;
        }
    }

    @Override // com.sobot.network.http.request.OkHttpRequest
    protected Request buildRequest(RequestBody requestBody) {
        return this.builder.post(requestBody).build();
    }

    @Override // com.sobot.network.http.request.OkHttpRequest
    protected RequestBody buildRequestBody() {
        return RequestBody.create(this.mediaType, this.content);
    }
}
