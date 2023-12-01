package android.util;

import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/util/ExceptionUtils.class */
public class ExceptionUtils {
    private static final String PREFIX_IO = "☃";

    public static String getCompleteMessage(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str).append(": ");
        }
        sb.append(th.getMessage());
        while (true) {
            th = th.getCause();
            if (th == null) {
                return sb.toString();
            }
            sb.append(": ").append(th.getMessage());
        }
    }

    public static String getCompleteMessage(Throwable th) {
        return getCompleteMessage(null, th);
    }

    public static void maybeUnwrapIOException(RuntimeException runtimeException) throws IOException {
        if ((runtimeException instanceof IllegalStateException) && runtimeException.getMessage().startsWith(PREFIX_IO)) {
            throw new IOException(runtimeException.getMessage().substring(PREFIX_IO.length()));
        }
    }

    public static RuntimeException wrap(IOException iOException) {
        throw new IllegalStateException(PREFIX_IO + iOException.getMessage());
    }
}
