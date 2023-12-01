package okhttp3;

import javax.annotation.Nullable;
import okio.ByteString;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/WebSocket.class */
public interface WebSocket {

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/WebSocket$Factory.class */
    public interface Factory {
        WebSocket newWebSocket(Request request, WebSocketListener webSocketListener);
    }

    void cancel();

    boolean close(int i, @Nullable String str);

    long queueSize();

    Request request();

    boolean send(String str);

    boolean send(ByteString byteString);
}
