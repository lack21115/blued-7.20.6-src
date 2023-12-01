package com.blued.android.module.im.grpc;

import com.google.protobuf.Any;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/grpc/OnConnectStateListener.class */
public interface OnConnectStateListener {
    void onConnected();

    void onConnecting();

    void onDisconnected();

    void onReceive(Any any);
}
