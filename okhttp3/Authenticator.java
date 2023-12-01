package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/Authenticator.class */
public interface Authenticator {
    public static final Authenticator NONE = new Authenticator() { // from class: okhttp3.Authenticator.1
        @Override // okhttp3.Authenticator
        public Request authenticate(@Nullable Route route, Response response) {
            return null;
        }
    };

    @Nullable
    Request authenticate(@Nullable Route route, Response response) throws IOException;
}
