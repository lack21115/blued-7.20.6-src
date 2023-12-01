package com.blued.android.chat.grpc.listener;

import com.google.protobuf.Any;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/grpc/listener/MsgConsumer.class */
public interface MsgConsumer {
    boolean consumeMsg(Any any);
}
