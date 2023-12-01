package com.getui.gtc.dim;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dim/AppDataProvider.class */
public interface AppDataProvider {
    Object getAppData(String str);

    void onDataFailed(String str, Throwable th);
}
