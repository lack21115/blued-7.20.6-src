package com.sina.weibo.sdk.component;

import android.content.Context;
import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/sina/weibo/sdk/component/WeiboCallbackManager.class */
public class WeiboCallbackManager {
    private static WeiboCallbackManager sInstance;
    private Context mContext;
    private Map<String, WeiboAuthListener> mWeiboAuthListenerMap = new HashMap();
    private Map<String, WidgetRequestParam.WidgetRequestCallback> mWidgetRequestCallbackMap = new HashMap();

    private WeiboCallbackManager(Context context) {
        this.mContext = context;
    }

    public static WeiboCallbackManager getInstance(Context context) {
        WeiboCallbackManager weiboCallbackManager;
        synchronized (WeiboCallbackManager.class) {
            try {
                if (sInstance == null) {
                    sInstance = new WeiboCallbackManager(context);
                }
                weiboCallbackManager = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return weiboCallbackManager;
    }

    public String genCallbackKey() {
        return String.valueOf(System.currentTimeMillis());
    }

    public WeiboAuthListener getWeiboAuthListener(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.mWeiboAuthListenerMap.get(str);
        }
    }

    public WidgetRequestParam.WidgetRequestCallback getWidgetRequestCallback(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.mWidgetRequestCallbackMap.get(str);
        }
    }

    public void removeWeiboAuthListener(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mWeiboAuthListenerMap.remove(str);
        }
    }

    public void removeWidgetRequestCallback(String str) {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mWidgetRequestCallbackMap.remove(str);
        }
    }

    public void setWeiboAuthListener(String str, WeiboAuthListener weiboAuthListener) {
        synchronized (this) {
            if (TextUtils.isEmpty(str) || weiboAuthListener == null) {
                return;
            }
            this.mWeiboAuthListenerMap.put(str, weiboAuthListener);
        }
    }

    public void setWidgetRequestCallback(String str, WidgetRequestParam.WidgetRequestCallback widgetRequestCallback) {
        synchronized (this) {
            if (TextUtils.isEmpty(str) || widgetRequestCallback == null) {
                return;
            }
            this.mWidgetRequestCallbackMap.put(str, widgetRequestCallback);
        }
    }
}
