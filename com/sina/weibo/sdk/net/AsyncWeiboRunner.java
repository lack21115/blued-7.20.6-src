package com.sina.weibo.sdk.net;

import android.content.Context;
import android.os.AsyncTask;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.exception.WeiboException;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/net/AsyncWeiboRunner.class */
public class AsyncWeiboRunner {
    private Context mContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/net/AsyncWeiboRunner$AsyncTaskResult.class */
    public static class AsyncTaskResult<T> {
        private WeiboException error;
        private T result;

        public AsyncTaskResult(WeiboException weiboException) {
            this.error = weiboException;
        }

        public AsyncTaskResult(T t) {
            this.result = t;
        }

        public WeiboException getError() {
            return this.error;
        }

        public T getResult() {
            return this.result;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/net/AsyncWeiboRunner$RequestRunner.class */
    static class RequestRunner extends AsyncTask<Void, Void, AsyncTaskResult<String>> {
        private final Context mContext;
        private final String mHttpMethod;
        private final RequestListener mListener;
        private final WeiboParameters mParams;
        private final String mUrl;

        public RequestRunner(Context context, String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
            this.mContext = context;
            this.mUrl = str;
            this.mParams = weiboParameters;
            this.mHttpMethod = str2;
            this.mListener = requestListener;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public AsyncTaskResult<String> doInBackground(Void... voidArr) {
            try {
                return new AsyncTaskResult<>(HttpManager.openUrl(this.mContext, this.mUrl, this.mHttpMethod, this.mParams));
            } catch (WeiboException e) {
                return new AsyncTaskResult<>(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(AsyncTaskResult<String> asyncTaskResult) {
            WeiboException error = asyncTaskResult.getError();
            if (error != null) {
                this.mListener.onWeiboException(error);
            } else {
                this.mListener.onComplete(asyncTaskResult.getResult());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPreExecute() {
        }
    }

    public AsyncWeiboRunner(Context context) {
        this.mContext = context;
    }

    public String request(String str, WeiboParameters weiboParameters, String str2) throws WeiboException {
        WbAppActivator.getInstance(this.mContext, weiboParameters.getAppKey()).activateApp();
        return HttpManager.openUrl(this.mContext, str, str2, weiboParameters);
    }

    public void requestAsync(String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
        WbAppActivator.getInstance(this.mContext, weiboParameters.getAppKey()).activateApp();
        new RequestRunner(this.mContext, str, weiboParameters, str2, requestListener).execute(new Void[1]);
    }

    @Deprecated
    public void requestByThread(final String str, final WeiboParameters weiboParameters, final String str2, final RequestListener requestListener) {
        new Thread() { // from class: com.sina.weibo.sdk.net.AsyncWeiboRunner.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    String openUrl = HttpManager.openUrl(AsyncWeiboRunner.this.mContext, str, str2, weiboParameters);
                    if (requestListener != null) {
                        requestListener.onComplete(openUrl);
                    }
                } catch (WeiboException e) {
                    RequestListener requestListener2 = requestListener;
                    if (requestListener2 != null) {
                        requestListener2.onWeiboException(e);
                    }
                }
            }
        }.start();
    }
}
