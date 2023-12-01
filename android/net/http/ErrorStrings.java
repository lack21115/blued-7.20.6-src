package android.net.http;

import android.R;
import android.content.Context;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/net/http/ErrorStrings.class */
public class ErrorStrings {
    private static final String LOGTAG = "Http";

    private ErrorStrings() {
    }

    public static int getResource(int i) {
        switch (i) {
            case -15:
                return 17039797;
            case -14:
                return 17039796;
            case -13:
                return 17039795;
            case -12:
                return R.string.httpErrorBadUrl;
            case -11:
                return 17039794;
            case -10:
                return R.string.httpErrorUnsupportedScheme;
            case -9:
                return 17039793;
            case -8:
                return 17039792;
            case -7:
                return 17039791;
            case -6:
                return 17039790;
            case -5:
                return 17039789;
            case -4:
                return 17039788;
            case -3:
                return 17039787;
            case -2:
                return 17039786;
            case -1:
                return 17039785;
            case 0:
                return 17039784;
            default:
                Log.w(LOGTAG, "Using generic message for unknown error code: " + i);
                return 17039785;
        }
    }

    public static String getString(int i, Context context) {
        return context.getText(getResource(i)).toString();
    }
}
