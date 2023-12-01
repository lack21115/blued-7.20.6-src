package androidx.core.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import java.io.FileNotFoundException;
import java.util.List;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/DocumentsContractCompat.class */
public final class DocumentsContractCompat {

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/DocumentsContractCompat$DocumentCompat.class */
    public static final class DocumentCompat {
        public static final int FLAG_VIRTUAL_DOCUMENT = 512;

        private DocumentCompat() {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/DocumentsContractCompat$DocumentsContractApi19Impl.class */
    static class DocumentsContractApi19Impl {
        private DocumentsContractApi19Impl() {
        }

        static String a(Uri uri) {
            return DocumentsContract.getDocumentId(uri);
        }

        static boolean a(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
            return DocumentsContract.deleteDocument(contentResolver, uri);
        }

        static boolean a(Context context, Uri uri) {
            return DocumentsContract.isDocumentUri(context, uri);
        }

        public static Uri buildDocumentUri(String str, String str2) {
            return DocumentsContract.buildDocumentUri(str, str2);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/DocumentsContractCompat$DocumentsContractApi21Impl.class */
    static class DocumentsContractApi21Impl {
        private DocumentsContractApi21Impl() {
        }

        static Uri a(ContentResolver contentResolver, Uri uri, String str) throws FileNotFoundException {
            return DocumentsContract.renameDocument(contentResolver, uri, str);
        }

        static Uri a(ContentResolver contentResolver, Uri uri, String str, String str2) throws FileNotFoundException {
            return DocumentsContract.createDocument(contentResolver, uri, str, str2);
        }

        static Uri a(Uri uri, String str) {
            return DocumentsContract.buildDocumentUriUsingTree(uri, str);
        }

        static Uri a(String str, String str2) {
            return DocumentsContract.buildChildDocumentsUri(str, str2);
        }

        static String a(Uri uri) {
            return DocumentsContract.getTreeDocumentId(uri);
        }

        static Uri b(Uri uri, String str) {
            return DocumentsContract.buildChildDocumentsUriUsingTree(uri, str);
        }

        public static Uri buildTreeDocumentUri(String str, String str2) {
            return DocumentsContract.buildTreeDocumentUri(str, str2);
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/provider/DocumentsContractCompat$DocumentsContractApi24Impl.class */
    static class DocumentsContractApi24Impl {
        private DocumentsContractApi24Impl() {
        }

        static boolean a(ContentResolver contentResolver, Uri uri, Uri uri2) throws FileNotFoundException {
            return DocumentsContract.removeDocument(contentResolver, uri, uri2);
        }

        static boolean a(Uri uri) {
            return DocumentsContract.isTreeUri(uri);
        }
    }

    private DocumentsContractCompat() {
    }

    public static Uri buildChildDocumentsUri(String str, String str2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return DocumentsContractApi21Impl.a(str, str2);
        }
        return null;
    }

    public static Uri buildChildDocumentsUriUsingTree(Uri uri, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            return DocumentsContractApi21Impl.b(uri, str);
        }
        return null;
    }

    public static Uri buildDocumentUri(String str, String str2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return DocumentsContractApi19Impl.buildDocumentUri(str, str2);
        }
        return null;
    }

    public static Uri buildDocumentUriUsingTree(Uri uri, String str) {
        if (Build.VERSION.SDK_INT >= 21) {
            return DocumentsContractApi21Impl.a(uri, str);
        }
        return null;
    }

    public static Uri buildTreeDocumentUri(String str, String str2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return DocumentsContractApi21Impl.buildTreeDocumentUri(str, str2);
        }
        return null;
    }

    public static Uri createDocument(ContentResolver contentResolver, Uri uri, String str, String str2) throws FileNotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return DocumentsContractApi21Impl.a(contentResolver, uri, str, str2);
        }
        return null;
    }

    public static String getDocumentId(Uri uri) {
        if (Build.VERSION.SDK_INT >= 19) {
            return DocumentsContractApi19Impl.a(uri);
        }
        return null;
    }

    public static String getTreeDocumentId(Uri uri) {
        if (Build.VERSION.SDK_INT >= 21) {
            return DocumentsContractApi21Impl.a(uri);
        }
        return null;
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 19) {
            return DocumentsContractApi19Impl.a(context, uri);
        }
        return false;
    }

    public static boolean isTreeUri(Uri uri) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 24) {
            List<String> pathSegments = uri.getPathSegments();
            boolean z = false;
            if (pathSegments.size() >= 2) {
                z = false;
                if ("tree".equals(pathSegments.get(0))) {
                    z = true;
                }
            }
            return z;
        }
        return DocumentsContractApi24Impl.a(uri);
    }

    public static boolean removeDocument(ContentResolver contentResolver, Uri uri, Uri uri2) throws FileNotFoundException {
        if (Build.VERSION.SDK_INT >= 24) {
            return DocumentsContractApi24Impl.a(contentResolver, uri, uri2);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return DocumentsContractApi19Impl.a(contentResolver, uri);
        }
        return false;
    }

    public static Uri renameDocument(ContentResolver contentResolver, Uri uri, String str) throws FileNotFoundException {
        if (Build.VERSION.SDK_INT >= 21) {
            return DocumentsContractApi21Impl.a(contentResolver, uri, str);
        }
        return null;
    }
}
