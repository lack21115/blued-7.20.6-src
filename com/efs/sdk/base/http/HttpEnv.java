package com.efs.sdk.base.http;

import com.efs.sdk.base.core.util.a.a;
import com.efs.sdk.base.core.util.concurrent.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/http/HttpEnv.class */
public class HttpEnv {
    private List<b<HttpResponse>> mHttpListenerList;
    private IHttpUtil mHttpUtil;

    /* loaded from: source-7206380-dex2jar.jar:com/efs/sdk/base/http/HttpEnv$SingletonHolder.class */
    static class SingletonHolder {
        private static final HttpEnv INSTANCE = new HttpEnv();

        private SingletonHolder() {
        }
    }

    private HttpEnv() {
        this.mHttpUtil = a.a();
        this.mHttpListenerList = new ArrayList(1);
    }

    public static HttpEnv getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void addListener(AbsHttpListener absHttpListener) {
        this.mHttpListenerList.add(absHttpListener);
    }

    public List<b<HttpResponse>> getHttpListenerList() {
        return new ArrayList(this.mHttpListenerList);
    }

    public IHttpUtil getHttpUtil() {
        return this.mHttpUtil;
    }

    public void removeListener(AbsHttpListener absHttpListener) {
        this.mHttpListenerList.remove(absHttpListener);
    }

    public void setHttpUtil(IHttpUtil iHttpUtil) {
        this.mHttpUtil = iHttpUtil;
    }
}
