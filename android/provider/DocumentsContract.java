package android.provider;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import android.os.RemoteException;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import com.huawei.hms.ads.fw;
import java.io.BufferedInputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import libcore.io.IoUtils;

/* loaded from: source-9557208-dex2jar.jar:android/provider/DocumentsContract.class */
public final class DocumentsContract {
    public static final String ACTION_MANAGE_DOCUMENT = "android.provider.action.MANAGE_DOCUMENT";
    public static final String ACTION_MANAGE_ROOT = "android.provider.action.MANAGE_ROOT";
    public static final String EXTRA_ERROR = "error";
    public static final String EXTRA_INFO = "info";
    public static final String EXTRA_LOADING = "loading";
    public static final String EXTRA_ORIENTATION = "android.content.extra.ORIENTATION";
    public static final String EXTRA_PACKAGE_NAME = "android.content.extra.PACKAGE_NAME";
    public static final String EXTRA_SHOW_ADVANCED = "android.content.extra.SHOW_ADVANCED";
    public static final String EXTRA_URI = "uri";
    public static final String METHOD_CREATE_DOCUMENT = "android:createDocument";
    public static final String METHOD_DELETE_DOCUMENT = "android:deleteDocument";
    public static final String METHOD_RENAME_DOCUMENT = "android:renameDocument";
    private static final String PARAM_MANAGE = "manage";
    private static final String PARAM_QUERY = "query";
    private static final String PATH_CHILDREN = "children";
    private static final String PATH_DOCUMENT = "document";
    private static final String PATH_RECENT = "recent";
    private static final String PATH_ROOT = "root";
    private static final String PATH_SEARCH = "search";
    private static final String PATH_TREE = "tree";
    public static final String PROVIDER_INTERFACE = "android.content.action.DOCUMENTS_PROVIDER";
    private static final String TAG = "Documents";
    private static final int THUMBNAIL_BUFFER_SIZE = 131072;

    /* loaded from: source-9557208-dex2jar.jar:android/provider/DocumentsContract$Document.class */
    public static final class Document {
        public static final String COLUMN_DISPLAY_NAME = "_display_name";
        public static final String COLUMN_DOCUMENT_ID = "document_id";
        public static final String COLUMN_FLAGS = "flags";
        public static final String COLUMN_ICON = "icon";
        public static final String COLUMN_LAST_MODIFIED = "last_modified";
        public static final String COLUMN_MIME_TYPE = "mime_type";
        public static final String COLUMN_SIZE = "_size";
        public static final String COLUMN_SUMMARY = "summary";
        public static final int FLAG_DIR_HIDE_GRID_TITLES = 65536;
        public static final int FLAG_DIR_PREFERS_GRID = 16;
        public static final int FLAG_DIR_PREFERS_LAST_MODIFIED = 32;
        public static final int FLAG_DIR_SUPPORTS_CREATE = 8;
        public static final int FLAG_SUPPORTS_DELETE = 4;
        public static final int FLAG_SUPPORTS_RENAME = 64;
        public static final int FLAG_SUPPORTS_THUMBNAIL = 1;
        public static final int FLAG_SUPPORTS_WRITE = 2;
        public static final String MIME_TYPE_DIR = "vnd.android.document/directory";

        private Document() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/provider/DocumentsContract$Root.class */
    public static final class Root {
        public static final String COLUMN_AVAILABLE_BYTES = "available_bytes";
        public static final String COLUMN_DOCUMENT_ID = "document_id";
        public static final String COLUMN_FLAGS = "flags";
        public static final String COLUMN_ICON = "icon";
        public static final String COLUMN_MIME_TYPES = "mime_types";
        public static final String COLUMN_ROOT_ID = "root_id";
        public static final String COLUMN_SUMMARY = "summary";
        public static final String COLUMN_TITLE = "title";
        public static final int FLAG_ADVANCED = 131072;
        public static final int FLAG_EMPTY = 65536;
        public static final int FLAG_LOCAL_ONLY = 2;
        public static final int FLAG_SUPPORTS_CREATE = 1;
        public static final int FLAG_SUPPORTS_IS_CHILD = 16;
        public static final int FLAG_SUPPORTS_RECENTS = 4;
        public static final int FLAG_SUPPORTS_SEARCH = 8;
        public static final String MIME_TYPE_ITEM = "vnd.android.document/root";

        private Root() {
        }
    }

    private DocumentsContract() {
    }

    public static Uri buildChildDocumentsUri(String str, String str2) {
        return new Uri.Builder().scheme("content").authority(str).appendPath(PATH_DOCUMENT).appendPath(str2).appendPath(PATH_CHILDREN).build();
    }

    public static Uri buildChildDocumentsUriUsingTree(Uri uri, String str) {
        return new Uri.Builder().scheme("content").authority(uri.getAuthority()).appendPath(PATH_TREE).appendPath(getTreeDocumentId(uri)).appendPath(PATH_DOCUMENT).appendPath(str).appendPath(PATH_CHILDREN).build();
    }

    public static Uri buildDocumentUri(String str, String str2) {
        return new Uri.Builder().scheme("content").authority(str).appendPath(PATH_DOCUMENT).appendPath(str2).build();
    }

    public static Uri buildDocumentUriMaybeUsingTree(Uri uri, String str) {
        return isTreeUri(uri) ? buildDocumentUriUsingTree(uri, str) : buildDocumentUri(uri.getAuthority(), str);
    }

    public static Uri buildDocumentUriUsingTree(Uri uri, String str) {
        return new Uri.Builder().scheme("content").authority(uri.getAuthority()).appendPath(PATH_TREE).appendPath(getTreeDocumentId(uri)).appendPath(PATH_DOCUMENT).appendPath(str).build();
    }

    public static Uri buildRecentDocumentsUri(String str, String str2) {
        return new Uri.Builder().scheme("content").authority(str).appendPath(PATH_ROOT).appendPath(str2).appendPath(PATH_RECENT).build();
    }

    public static Uri buildRootUri(String str, String str2) {
        return new Uri.Builder().scheme("content").authority(str).appendPath(PATH_ROOT).appendPath(str2).build();
    }

    public static Uri buildRootsUri(String str) {
        return new Uri.Builder().scheme("content").authority(str).appendPath(PATH_ROOT).build();
    }

    public static Uri buildSearchDocumentsUri(String str, String str2, String str3) {
        return new Uri.Builder().scheme("content").authority(str).appendPath(PATH_ROOT).appendPath(str2).appendPath("search").appendQueryParameter("query", str3).build();
    }

    public static Uri buildTreeDocumentUri(String str, String str2) {
        return new Uri.Builder().scheme("content").authority(str).appendPath(PATH_TREE).appendPath(str2).build();
    }

    public static Uri createDocument(ContentProviderClient contentProviderClient, Uri uri, String str, String str2) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putParcelable("uri", uri);
        bundle.putString("mime_type", str);
        bundle.putString("_display_name", str2);
        return (Uri) contentProviderClient.call(METHOD_CREATE_DOCUMENT, null, bundle).getParcelable("uri");
    }

    public static Uri createDocument(ContentResolver contentResolver, Uri uri, String str, String str2) {
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri.getAuthority());
        try {
            try {
                return createDocument(acquireUnstableContentProviderClient, uri, str, str2);
            } catch (Exception e) {
                Log.w(TAG, "Failed to create document", e);
                ContentProviderClient.releaseQuietly(acquireUnstableContentProviderClient);
                return null;
            }
        } finally {
            ContentProviderClient.releaseQuietly(acquireUnstableContentProviderClient);
        }
    }

    public static void deleteDocument(ContentProviderClient contentProviderClient, Uri uri) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putParcelable("uri", uri);
        contentProviderClient.call(METHOD_DELETE_DOCUMENT, null, bundle);
    }

    public static boolean deleteDocument(ContentResolver contentResolver, Uri uri) {
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri.getAuthority());
        try {
            try {
                deleteDocument(acquireUnstableContentProviderClient, uri);
                ContentProviderClient.releaseQuietly(acquireUnstableContentProviderClient);
                return true;
            } catch (Exception e) {
                Log.w(TAG, "Failed to delete document", e);
                ContentProviderClient.releaseQuietly(acquireUnstableContentProviderClient);
                return false;
            }
        } catch (Throwable th) {
            ContentProviderClient.releaseQuietly(acquireUnstableContentProviderClient);
            throw th;
        }
    }

    public static String getDocumentId(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() < 2 || !PATH_DOCUMENT.equals(pathSegments.get(0))) {
            if (pathSegments.size() >= 4 && PATH_TREE.equals(pathSegments.get(0)) && PATH_DOCUMENT.equals(pathSegments.get(2))) {
                return pathSegments.get(3);
            }
            throw new IllegalArgumentException("Invalid URI: " + uri);
        }
        return pathSegments.get(1);
    }

    public static Bitmap getDocumentThumbnail(ContentProviderClient contentProviderClient, Uri uri, Point point, CancellationSignal cancellationSignal) throws RemoteException, IOException {
        Bitmap decodeFileDescriptor;
        Bundle bundle = new Bundle();
        bundle.putParcelable(ContentResolver.EXTRA_SIZE, point);
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            AssetFileDescriptor openTypedAssetFileDescriptor = contentProviderClient.openTypedAssetFileDescriptor(uri, "image/*", bundle, cancellationSignal);
            FileDescriptor fileDescriptor = openTypedAssetFileDescriptor.getFileDescriptor();
            long startOffset = openTypedAssetFileDescriptor.getStartOffset();
            BufferedInputStream bufferedInputStream = null;
            assetFileDescriptor = openTypedAssetFileDescriptor;
            try {
                Os.lseek(fileDescriptor, startOffset, OsConstants.SEEK_SET);
            } catch (ErrnoException e) {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(fileDescriptor), 131072);
                bufferedInputStream.mark(131072);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            if (bufferedInputStream != null) {
                BitmapFactory.decodeStream(bufferedInputStream, null, options);
            } else {
                BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            }
            int i = options.outWidth / point.x;
            int i2 = options.outHeight / point.y;
            options.inJustDecodeBounds = false;
            options.inSampleSize = Math.min(i, i2);
            if (bufferedInputStream != null) {
                bufferedInputStream.reset();
                decodeFileDescriptor = BitmapFactory.decodeStream(bufferedInputStream, null, options);
            } else {
                assetFileDescriptor = openTypedAssetFileDescriptor;
                try {
                    Os.lseek(fileDescriptor, startOffset, OsConstants.SEEK_SET);
                } catch (ErrnoException e2) {
                    e2.rethrowAsIOException();
                }
                decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            }
            Bundle extras = openTypedAssetFileDescriptor.getExtras();
            int i3 = extras != null ? extras.getInt(EXTRA_ORIENTATION, 0) : 0;
            Bitmap bitmap = decodeFileDescriptor;
            if (i3 != 0) {
                int width = decodeFileDescriptor.getWidth();
                int height = decodeFileDescriptor.getHeight();
                Matrix matrix = new Matrix();
                matrix.setRotate(i3, width / 2, height / 2);
                assetFileDescriptor = openTypedAssetFileDescriptor;
                bitmap = Bitmap.createBitmap(decodeFileDescriptor, 0, 0, width, height, matrix, false);
            }
            IoUtils.closeQuietly(openTypedAssetFileDescriptor);
            return bitmap;
        } catch (Throwable th) {
            IoUtils.closeQuietly(assetFileDescriptor);
            throw th;
        }
    }

    public static Bitmap getDocumentThumbnail(ContentResolver contentResolver, Uri uri, Point point, CancellationSignal cancellationSignal) {
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri.getAuthority());
        try {
            try {
                return getDocumentThumbnail(acquireUnstableContentProviderClient, uri, point, cancellationSignal);
            } catch (Exception e) {
                if (!(e instanceof OperationCanceledException)) {
                    Log.w(TAG, "Failed to load thumbnail for " + uri + ": " + e);
                }
                ContentProviderClient.releaseQuietly(acquireUnstableContentProviderClient);
                return null;
            }
        } finally {
            ContentProviderClient.releaseQuietly(acquireUnstableContentProviderClient);
        }
    }

    public static String getRootId(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() < 2 || !PATH_ROOT.equals(pathSegments.get(0))) {
            throw new IllegalArgumentException("Invalid URI: " + uri);
        }
        return pathSegments.get(1);
    }

    public static String getSearchDocumentsQuery(Uri uri) {
        return uri.getQueryParameter("query");
    }

    public static String getTreeDocumentId(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() < 2 || !PATH_TREE.equals(pathSegments.get(0))) {
            throw new IllegalArgumentException("Invalid URI: " + uri);
        }
        return pathSegments.get(1);
    }

    public static boolean isDocumentUri(Context context, Uri uri) {
        boolean z;
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2 && PATH_DOCUMENT.equals(pathSegments.get(0))) {
            z = isDocumentsProvider(context, uri.getAuthority());
        } else {
            z = false;
            if (pathSegments.size() == 4) {
                z = false;
                if (PATH_TREE.equals(pathSegments.get(0))) {
                    z = false;
                    if (PATH_DOCUMENT.equals(pathSegments.get(2))) {
                        return isDocumentsProvider(context, uri.getAuthority());
                    }
                }
            }
        }
        return z;
    }

    private static boolean isDocumentsProvider(Context context, String str) {
        boolean z;
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentContentProviders(new Intent(PROVIDER_INTERFACE), 0).iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            } else if (str.equals(it.next().providerInfo.authority)) {
                z = true;
                break;
            }
        }
        return z;
    }

    public static boolean isManageMode(Uri uri) {
        return uri.getBooleanQueryParameter(PARAM_MANAGE, false);
    }

    public static boolean isTreeUri(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        boolean z = false;
        if (pathSegments.size() >= 2) {
            z = false;
            if (PATH_TREE.equals(pathSegments.get(0))) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.res.AssetFileDescriptor openImageThumbnail(java.io.File r9) throws java.io.FileNotFoundException {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.provider.DocumentsContract.openImageThumbnail(java.io.File):android.content.res.AssetFileDescriptor");
    }

    public static Uri renameDocument(ContentProviderClient contentProviderClient, Uri uri, String str) throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putParcelable("uri", uri);
        bundle.putString("_display_name", str);
        Uri uri2 = (Uri) contentProviderClient.call(METHOD_RENAME_DOCUMENT, null, bundle).getParcelable("uri");
        return uri2 != null ? uri2 : uri;
    }

    public static Uri renameDocument(ContentResolver contentResolver, Uri uri, String str) {
        ContentProviderClient acquireUnstableContentProviderClient = contentResolver.acquireUnstableContentProviderClient(uri.getAuthority());
        try {
            try {
                return renameDocument(acquireUnstableContentProviderClient, uri, str);
            } catch (Exception e) {
                Log.w(TAG, "Failed to rename document", e);
                ContentProviderClient.releaseQuietly(acquireUnstableContentProviderClient);
                return null;
            }
        } finally {
            ContentProviderClient.releaseQuietly(acquireUnstableContentProviderClient);
        }
    }

    public static Uri setManageMode(Uri uri) {
        return uri.buildUpon().appendQueryParameter(PARAM_MANAGE, fw.Code).build();
    }
}
