package com.blued.android.chat.listener;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/listener/RetractionListener.class */
public interface RetractionListener {
    void onMsgRetractedTimeout();

    void onRetractFailed();

    void onRetractSuccess();
}
