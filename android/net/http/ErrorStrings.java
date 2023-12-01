package android.net.http;

import android.content.Context;
import android.util.Log;
import com.android.internal.R;

/* loaded from: source-9557208-dex2jar.jar:android/net/http/ErrorStrings.class */
public class ErrorStrings {
    private static final String LOGTAG = "Http";

    private ErrorStrings() {
    }

    public static int getResource(int i) {
        switch (i) {
            case -15:
                return R.string.httpErrorTooManyRequests;
            case -14:
                return R.string.httpErrorFileNotFound;
            case -13:
                return R.string.httpErrorFile;
            case -12:
                return 17039367;
            case -11:
                return R.string.httpErrorFailedSslHandshake;
            case -10:
                return 17039368;
            case -9:
                return R.string.httpErrorRedirectLoop;
            case -8:
                return R.string.httpErrorTimeout;
            case -7:
                return R.string.httpErrorIO;
            case -6:
                return R.string.httpErrorConnect;
            case -5:
                return R.string.httpErrorProxyAuth;
            case -4:
                return R.string.httpErrorAuth;
            case -3:
                return R.string.httpErrorUnsupportedAuthScheme;
            case -2:
                return R.string.httpErrorLookup;
            case -1:
                return R.string.httpError;
            case 0:
                return R.string.httpErrorOk;
            default:
                Log.w(LOGTAG, "Using generic message for unknown error code: " + i);
                return R.string.httpError;
        }
    }

    public static String getString(int i, Context context) {
        return context.getText(getResource(i)).toString();
    }
}
