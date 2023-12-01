package android.content;

import android.net.Uri;

/* loaded from: source-9557208-dex2jar.jar:android/content/ContentUris.class */
public class ContentUris {
    public static Uri.Builder appendId(Uri.Builder builder, long j) {
        return builder.appendEncodedPath(String.valueOf(j));
    }

    public static long parseId(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1L;
        }
        return Long.parseLong(lastPathSegment);
    }

    public static Uri withAppendedId(Uri uri, long j) {
        return appendId(uri.buildUpon(), j).build();
    }
}
