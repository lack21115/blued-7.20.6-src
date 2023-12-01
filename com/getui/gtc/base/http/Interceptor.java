package com.getui.gtc.base.http;

import java.io.IOException;
import java.net.HttpURLConnection;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/Interceptor.class */
public interface Interceptor {

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/Interceptor$Chain.class */
    public interface Chain {
        HttpURLConnection connection();

        Response proceed(Request request) throws IOException;

        Request request();
    }

    Response intercept(Chain chain) throws IOException;
}
