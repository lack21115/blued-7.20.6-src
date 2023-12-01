package com.blued.android.chat.grpc.listener;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/listener/ConnectListener.class */
public interface ConnectListener {
    void onConnected();

    void onConnecting();

    void onDisconnected(int i, String str);
}
