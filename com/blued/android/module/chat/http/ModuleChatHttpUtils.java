package com.blued.android.module.chat.http;

import com.blued.android.framework.http.BluedUIHttpResponse;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/http/ModuleChatHttpUtils.class */
public class ModuleChatHttpUtils {
    private static final String TAG = ModuleChatHttpUtils.class.getSimpleName();
    private static ModuleChatHttpUtils instance;
    private IModuleChatHttp mImpl;

    private ModuleChatHttpUtils() {
    }

    public static ModuleChatHttpUtils getInstance() {
        if (instance == null) {
            instance = new ModuleChatHttpUtils();
        }
        return instance;
    }

    public void getChatRelationData(BluedUIHttpResponse bluedUIHttpResponse, Long[] lArr) {
        IModuleChatHttp iModuleChatHttp = this.mImpl;
        if (iModuleChatHttp != null) {
            iModuleChatHttp.getChatRelationData(bluedUIHttpResponse, lArr);
        }
    }

    public void setHttpImpl(IModuleChatHttp iModuleChatHttp) {
        this.mImpl = iModuleChatHttp;
    }
}
