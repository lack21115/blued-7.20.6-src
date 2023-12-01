package androidx.documentfile.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: source-8756600-dex2jar.jar:androidx/documentfile/provider/DocumentsContractApi19.class */
class DocumentsContractApi19 {
    private DocumentsContractApi19() {
    }

    private static int a(Context context, Uri uri, String str, int i) {
        return (int) a(context, uri, str, i);
    }

    private static long a(Context context, Uri uri, String str, long j) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                Cursor query = contentResolver.query(uri, new String[]{str}, null, null, null);
                if (!query.moveToFirst() || query.isNull(0)) {
                    a(query);
                    return j;
                }
                cursor2 = query;
                cursor = query;
                long j2 = query.getLong(0);
                a(query);
                return j2;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                Cursor cursor3 = cursor;
                sb.append("Failed query: ");
                Cursor cursor4 = cursor;
                sb.append(e);
                Cursor cursor5 = cursor;
                Log.w("DocumentFile", sb.toString());
                a(cursor);
                return j;
            }
        } catch (Throwable th) {
            a(cursor2);
            throw th;
        }
    }

    private static String a(Context context, Uri uri) {
        return a(context, uri, "mime_type", (String) null);
    }

    private static String a(Context context, Uri uri, String str, String str2) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                Cursor query = contentResolver.query(uri, new String[]{str}, null, null, null);
                if (!query.moveToFirst() || query.isNull(0)) {
                    a(query);
                    return str2;
                }
                cursor2 = query;
                cursor = query;
                String string = query.getString(0);
                a(query);
                return string;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                Cursor cursor3 = cursor;
                sb.append("Failed query: ");
                Cursor cursor4 = cursor;
                sb.append(e);
                Cursor cursor5 = cursor;
                Log.w("DocumentFile", sb.toString());
                a(cursor);
                return str2;
            }
        } catch (Throwable th) {
            a(cursor2);
            throw th;
        }
    }

    private static void a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static boolean canRead(Context context, Uri uri) {
        return context.checkCallingOrSelfUriPermission(uri, 1) == 0 && !TextUtils.isEmpty(a(context, uri));
    }

    public static boolean canWrite(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        String a2 = a(context, uri);
        int a3 = a(context, uri, "flags", 0);
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        if ((a3 & 4) != 0) {
            return true;
        }
        if (!DocumentsContract.Document.MIME_TYPE_DIR.equals(a2) || (a3 & 8) == 0) {
            return (TextUtils.isEmpty(a2) || (a3 & 2) == 0) ? false : true;
        }
        return true;
    }

    public static boolean exists(Context context, Uri uri) {
        ContentResolver contentResolver = context.getContentResolver();
        boolean z = false;
        Cursor cursor = null;
        Cursor cursor2 = null;
        try {
            try {
                Cursor query = contentResolver.query(uri, new String[]{"document_id"}, null, null, null);
                cursor2 = query;
                cursor = query;
                if (query.getCount() > 0) {
                    z = true;
                }
                a(query);
                return z;
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                Cursor cursor3 = cursor;
                sb.append("Failed query: ");
                Cursor cursor4 = cursor;
                sb.append(e);
                cursor2 = cursor;
                Log.w("DocumentFile", sb.toString());
                a(cursor);
                return false;
            }
        } catch (Throwable th) {
            a(cursor2);
            throw th;
        }
    }

    public static long getFlags(Context context, Uri uri) {
        return a(context, uri, "flags", 0L);
    }

    public static String getName(Context context, Uri uri) {
        return a(context, uri, "_display_name", (String) null);
    }

    public static String getType(Context context, Uri uri) {
        String a2 = a(context, uri);
        String str = a2;
        if (DocumentsContract.Document.MIME_TYPE_DIR.equals(a2)) {
            str = null;
        }
        return str;
    }

    public static boolean isDirectory(Context context, Uri uri) {
        return DocumentsContract.Document.MIME_TYPE_DIR.equals(a(context, uri));
    }

    public static boolean isFile(Context context, Uri uri) {
        String a2 = a(context, uri);
        return (DocumentsContract.Document.MIME_TYPE_DIR.equals(a2) || TextUtils.isEmpty(a2)) ? false : true;
    }

    public static boolean isVirtual(Context context, Uri uri) {
        boolean z = false;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if ((getFlags(context, uri) & 512) != 0) {
                z = true;
            }
            return z;
        }
        return false;
    }

    public static long lastModified(Context context, Uri uri) {
        return a(context, uri, DocumentsContract.Document.COLUMN_LAST_MODIFIED, 0L);
    }

    public static long length(Context context, Uri uri) {
        return a(context, uri, "_size", 0L);
    }
}
