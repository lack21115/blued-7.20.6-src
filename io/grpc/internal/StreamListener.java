package io.grpc.internal;

import java.io.InputStream;
import javax.annotation.Nullable;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/StreamListener.class */
public interface StreamListener {

    /* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/StreamListener$MessageProducer.class */
    public interface MessageProducer {
        @Nullable
        InputStream next();
    }

    void messagesAvailable(MessageProducer messageProducer);

    void onReady();
}
