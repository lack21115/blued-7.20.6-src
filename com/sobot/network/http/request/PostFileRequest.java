package com.sobot.network.http.request;

import com.sobot.network.http.utils.Exceptions;
import java.io.File;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/request/PostFileRequest.class */
public class PostFileRequest extends OkHttpRequest {
    private static MediaType MEDIA_TYPE_STREAM = MediaType.parse("application/octet-stream");
    private File file;
    private MediaType mediaType;

    public PostFileRequest(String str, Object obj, Map<String, String> map, Map<String, String> map2, File file, MediaType mediaType) {
        super(str, obj, map, map2);
        this.file = file;
        this.mediaType = mediaType;
        if (file == null) {
            Exceptions.illegalArgument("the file can not be null !", new Object[0]);
        }
        if (this.mediaType == null) {
            this.mediaType = MEDIA_TYPE_STREAM;
        }
    }

    @Override // com.sobot.network.http.request.OkHttpRequest
    protected Request buildRequest(RequestBody requestBody) {
        return this.builder.post(requestBody).build();
    }

    @Override // com.sobot.network.http.request.OkHttpRequest
    protected RequestBody buildRequestBody() {
        return RequestBody.create(this.mediaType, this.file);
    }
}
