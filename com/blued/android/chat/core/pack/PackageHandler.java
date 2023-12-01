package com.blued.android.chat.core.pack;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/pack/PackageHandler.class */
public interface PackageHandler {
    void onReceive(BasePackage basePackage);

    void onSendFailed(BasePackage basePackage, String str);

    void onSendSuccess(BasePackage basePackage);
}
