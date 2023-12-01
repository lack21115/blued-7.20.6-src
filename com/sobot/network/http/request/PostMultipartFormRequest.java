package com.sobot.network.http.request;

import com.sobot.network.http.builder.PostMultipartFormBuilder;
import com.sobot.network.http.callback.Callback;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/network/http/request/PostMultipartFormRequest.class */
public class PostMultipartFormRequest extends OkHttpRequest {
    private List<PostMultipartFormBuilder.FileInput> files;

    public PostMultipartFormRequest(String str, Object obj, Map<String, String> map, Map<String, String> map2, List<PostMultipartFormBuilder.FileInput> list) {
        super(str, obj, map, map2);
        this.files = list;
    }

    private void addParams(FormBody.Builder builder) {
        if (this.params != null) {
            for (String str : this.params.keySet()) {
                if (this.params.get(str) != null) {
                    builder.add(str, this.params.get(str));
                }
            }
        }
    }

    private void addParams(MultipartBody.Builder builder) {
        if (this.params == null || this.params.isEmpty()) {
            return;
        }
        for (String str : this.params.keySet()) {
            builder.addPart(Headers.of("Content-Disposition", "form-data; name=\"" + str + "\""), RequestBody.create((MediaType) null, this.params.get(str)));
        }
    }

    private String guessMimeType(String str) {
        String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str.replace("#", ""));
        String str2 = contentTypeFor;
        if (contentTypeFor == null) {
            str2 = "application/octet-stream";
        }
        return str2;
    }

    @Override // com.sobot.network.http.request.OkHttpRequest
    protected Request buildRequest(RequestBody requestBody) {
        return this.builder.post(requestBody).build();
    }

    @Override // com.sobot.network.http.request.OkHttpRequest
    protected RequestBody buildRequestBody() {
        MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
        addParams(type);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.files.size()) {
                return type.build();
            }
            PostMultipartFormBuilder.FileInput fileInput = this.files.get(i2);
            try {
                type.addFormDataPart(fileInput.key, URLEncoder.encode(fileInput.filename, "UTF-8"), RequestBody.create(MediaType.parse(guessMimeType(fileInput.filename)), fileInput.file));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            i = i2 + 1;
        }
    }

    @Override // com.sobot.network.http.request.OkHttpRequest
    protected RequestBody wrapRequestBody(RequestBody requestBody, Callback callback) {
        ProgressRequestBody progressRequestBody = new ProgressRequestBody(requestBody, callback);
        progressRequestBody.setInterceptor(this.uploadInterceptor);
        return progressRequestBody;
    }
}
