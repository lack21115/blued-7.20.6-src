package com.tencent.cloud.huiyansdkface.wehttp2;

import com.igexin.push.core.b;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.MediaType;
import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/MockInterceptor.class */
public class MockInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private List<Mock> f22403a = new ArrayList();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/MockInterceptor$JsonMock.class */
    public static abstract class JsonMock<T> implements Mock {
        public boolean isMock(HttpUrl httpUrl, Request request) {
            return false;
        }

        public boolean isPathMock(String str) {
            return false;
        }

        @Override // com.tencent.cloud.huiyansdkface.wehttp2.MockInterceptor.Mock
        public Response mock(Interceptor.Chain chain) {
            Request request = chain.request();
            HttpUrl url = request.url();
            boolean isMock = isMock(url, request);
            boolean z = isMock;
            if (!isMock) {
                z = isPathMock(request.url().encodedPath());
            }
            boolean z2 = z;
            if (!z) {
                String mockPath = mockPath();
                z2 = z;
                if (mockPath != null) {
                    z2 = z;
                    if (!mockPath.equals("")) {
                        z2 = z;
                        if (url.encodedPath().endsWith(mockPath)) {
                            z2 = true;
                        }
                    }
                }
            }
            if (z2) {
                Response resp = resp(request);
                Response response = resp;
                if (resp == null) {
                    Response.Builder request2 = new Response.Builder().protocol(Protocol.HTTP_1_1).code(200).message(b.x).request(request);
                    ResponseBody respBody = respBody(request);
                    ResponseBody responseBody = respBody;
                    if (respBody == null) {
                        WeJson weJson = new WeJson();
                        T respObj = respObj(request);
                        responseBody = ResponseBody.create(MediaType.g, !(respObj instanceof String) ? weJson.toJson(respObj) : (String) respObj);
                    }
                    response = request2.body(responseBody).build();
                }
                return response;
            }
            return null;
        }

        public abstract String mockPath();

        public Response resp(Request request) {
            return null;
        }

        public ResponseBody respBody(Request request) {
            return null;
        }

        public abstract T respObj(Request request);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/MockInterceptor$Mock.class */
    public interface Mock {
        Response mock(Interceptor.Chain chain);
    }

    public MockInterceptor addMock(Mock mock) {
        if (mock != null && !this.f22403a.contains(mock)) {
            this.f22403a.add(mock);
        }
        return this;
    }

    public MockInterceptor clear() {
        this.f22403a.clear();
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        if (this.f22403a.size() != 0) {
            int size = this.f22403a.size();
            while (true) {
                int i = size - 1;
                if (i < 0) {
                    break;
                }
                Response mock = this.f22403a.get(i).mock(chain);
                if (mock != null) {
                    return mock;
                }
                size = i;
            }
        }
        return chain.proceed(chain.request());
    }

    public MockInterceptor removeMock(Mock mock) {
        if (mock != null && this.f22403a.contains(mock)) {
            this.f22403a.remove(mock);
        }
        return this;
    }
}
