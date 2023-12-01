package com.tencent.smtt.export.external.interfaces;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/export/external/interfaces/HttpAuthHandler.class */
public interface HttpAuthHandler {
    void cancel();

    void proceed(String str, String str2);

    boolean useHttpAuthUsernamePassword();
}
