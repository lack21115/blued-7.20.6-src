package okhttp3;

import java.io.IOException;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/Callback.class */
public interface Callback {
    void onFailure(Call call, IOException iOException);

    void onResponse(Call call, Response response) throws IOException;
}
