package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.wehttp2.WeLog;
import java.io.IOException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeCookieLog.class */
public class WeCookieLog implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private WeLog f36124a;

    public WeCookieLog(WeLog weLog) {
        this.f36124a = weLog;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        if (this.f36124a.d == WeLog.Level.HEADERS || this.f36124a.d == WeLog.Level.BODY) {
            Request request = chain.request();
            Headers headers = request.headers();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= headers.size()) {
                    break;
                }
                String name = headers.name(i2);
                if ("Cookie".equals(name)) {
                    LogTag logTag = (LogTag) request.tag(LogTag.class);
                    WeLog.InnerLogger innerLogger = this.f36124a.f36131c;
                    StringBuilder sb = new StringBuilder();
                    sb.append((!this.f36124a.b || logTag == null) ? "" : logTag.getTag());
                    sb.append(name);
                    sb.append(":");
                    sb.append(headers.value(i2));
                    innerLogger.log(sb.toString());
                }
                i = i2 + 1;
            }
        }
        return chain.proceed(chain.request());
    }
}
