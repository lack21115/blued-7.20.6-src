package com.tencent.cloud.huiyansdkface.okhttp3;

import java.util.Collections;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/CookieJar.class */
public interface CookieJar {

    /* renamed from: a  reason: collision with root package name */
    public static final CookieJar f35845a = new CookieJar() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.CookieJar.1
        @Override // com.tencent.cloud.huiyansdkface.okhttp3.CookieJar
        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            return Collections.emptyList();
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.CookieJar
        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        }
    };

    List<Cookie> loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);
}
