package com.blued.android.chat.core.worker.link;

import com.blued.android.chat.core.pack.BasePackage;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/core/worker/link/LinkListener.class */
public interface LinkListener {
    void onLinkReceive(BasePackage basePackage);

    void onLinkSendFailed(BasePackage basePackage, String str);

    void onLinkSendSuccess(BasePackage basePackage);

    void onLinkStateChanged(int i);
}
