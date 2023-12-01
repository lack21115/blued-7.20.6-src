package okhttp3;

import java.net.Socket;
import javax.annotation.Nullable;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/Connection.class */
public interface Connection {
    @Nullable
    Handshake handshake();

    Protocol protocol();

    Route route();

    Socket socket();
}
