package okhttp3;

import java.io.IOException;
import okio.Timeout;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/Call.class */
public interface Call extends Cloneable {

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/Call$Factory.class */
    public interface Factory {
        Call newCall(Request request);
    }

    void cancel();

    Call clone();

    void enqueue(Callback callback);

    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    Timeout timeout();
}
