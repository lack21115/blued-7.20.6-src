package com.getui.gtc.base.http;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/Call.class */
public interface Call {

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/http/Call$Callback.class */
    public interface Callback {
        void onFailure(Call call, Exception exc);

        void onResponse(Call call, Response response);
    }

    void cancel();

    void enqueue(Callback callback);

    Response execute() throws Exception;

    boolean isCanceled();

    boolean isExecuted();

    Request request();
}
