package android.provider;

import android.Manifest;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.util.Log;
import java.io.FileNotFoundException;
import java.util.Objects;
import libcore.io.IoUtils;

/* loaded from: source-9557208-dex2jar.jar:android/provider/DocumentsProvider.class */
public abstract class DocumentsProvider extends ContentProvider {
    private static final int MATCH_CHILDREN = 6;
    private static final int MATCH_CHILDREN_TREE = 8;
    private static final int MATCH_DOCUMENT = 5;
    private static final int MATCH_DOCUMENT_TREE = 7;
    private static final int MATCH_RECENT = 3;
    private static final int MATCH_ROOT = 2;
    private static final int MATCH_ROOTS = 1;
    private static final int MATCH_SEARCH = 4;
    private static final String TAG = "DocumentsProvider";
    private String mAuthority;
    private UriMatcher mMatcher;

    private void enforceTree(Uri uri) {
        if (DocumentsContract.isTreeUri(uri)) {
            String treeDocumentId = DocumentsContract.getTreeDocumentId(uri);
            String documentId = DocumentsContract.getDocumentId(uri);
            if (!Objects.equals(treeDocumentId, documentId) && !isChildDocument(treeDocumentId, documentId)) {
                throw new SecurityException("Document " + documentId + " is not a descendant of " + treeDocumentId);
            }
        }
    }

    private static int getCallingOrSelfUriPermissionModeFlags(Context context, Uri uri) {
        int i = 0;
        if (context.checkCallingOrSelfUriPermission(uri, 1) == 0) {
            i = 0 | 1;
        }
        int i2 = i;
        if (context.checkCallingOrSelfUriPermission(uri, 2) == 0) {
            i2 = i | 2;
        }
        int i3 = i2;
        if (context.checkCallingOrSelfUriPermission(uri, 65) == 0) {
            i3 = i2 | 64;
        }
        return i3;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        this.mAuthority = providerInfo.authority;
        this.mMatcher = new UriMatcher(-1);
        this.mMatcher.addURI(this.mAuthority, "root", 1);
        this.mMatcher.addURI(this.mAuthority, "root/*", 2);
        this.mMatcher.addURI(this.mAuthority, "root/*/recent", 3);
        this.mMatcher.addURI(this.mAuthority, "root/*/search", 4);
        this.mMatcher.addURI(this.mAuthority, "document/*", 5);
        this.mMatcher.addURI(this.mAuthority, "document/*/children", 6);
        this.mMatcher.addURI(this.mAuthority, "tree/*/document/*", 7);
        this.mMatcher.addURI(this.mAuthority, "tree/*/document/*/children", 8);
        if (!providerInfo.exported) {
            throw new SecurityException("Provider must be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grantUriPermissions");
        }
        if (!Manifest.permission.MANAGE_DOCUMENTS.equals(providerInfo.readPermission) || !Manifest.permission.MANAGE_DOCUMENTS.equals(providerInfo.writePermission)) {
            throw new SecurityException("Provider must be protected by MANAGE_DOCUMENTS");
        }
        super.attachInfo(context, providerInfo);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        Bundle bundle2;
        if (str.startsWith("android:")) {
            Context context = getContext();
            Uri uri = (Uri) bundle.getParcelable("uri");
            String authority = uri.getAuthority();
            String documentId = DocumentsContract.getDocumentId(uri);
            if (!this.mAuthority.equals(authority)) {
                throw new SecurityException("Requested authority " + authority + " doesn't match provider " + this.mAuthority);
            }
            enforceTree(uri);
            Bundle bundle3 = new Bundle();
            try {
                if (DocumentsContract.METHOD_CREATE_DOCUMENT.equals(str)) {
                    enforceWritePermissionInner(uri, null);
                    bundle3.putParcelable("uri", DocumentsContract.buildDocumentUriMaybeUsingTree(uri, createDocument(documentId, bundle.getString("mime_type"), bundle.getString("_display_name"))));
                    return bundle3;
                } else if (!DocumentsContract.METHOD_RENAME_DOCUMENT.equals(str)) {
                    if (DocumentsContract.METHOD_DELETE_DOCUMENT.equals(str)) {
                        enforceWritePermissionInner(uri, null);
                        deleteDocument(documentId);
                        revokeDocumentPermission(documentId);
                        return bundle3;
                    }
                    throw new UnsupportedOperationException("Method not supported " + str);
                } else {
                    enforceWritePermissionInner(uri, null);
                    String renameDocument = renameDocument(documentId, bundle.getString("_display_name"));
                    bundle2 = bundle3;
                    if (renameDocument != null) {
                        Uri buildDocumentUriMaybeUsingTree = DocumentsContract.buildDocumentUriMaybeUsingTree(uri, renameDocument);
                        if (!DocumentsContract.isTreeUri(buildDocumentUriMaybeUsingTree)) {
                            context.grantUriPermission(getCallingPackage(), buildDocumentUriMaybeUsingTree, getCallingOrSelfUriPermissionModeFlags(context, uri));
                        }
                        bundle3.putParcelable("uri", buildDocumentUriMaybeUsingTree);
                        revokeDocumentPermission(documentId);
                        return bundle3;
                    }
                }
            } catch (FileNotFoundException e) {
                throw new IllegalStateException("Failed call " + str, e);
            }
        } else {
            bundle2 = super.call(str, str2, bundle);
        }
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public Uri canonicalize(Uri uri) {
        Context context = getContext();
        switch (this.mMatcher.match(uri)) {
            case 7:
                enforceTree(uri);
                Uri buildDocumentUri = DocumentsContract.buildDocumentUri(uri.getAuthority(), DocumentsContract.getDocumentId(uri));
                context.grantUriPermission(getCallingPackage(), buildDocumentUri, getCallingOrSelfUriPermissionModeFlags(context, uri));
                return buildDocumentUri;
            default:
                return null;
        }
    }

    public String createDocument(String str, String str2, String str3) throws FileNotFoundException {
        throw new UnsupportedOperationException("Create not supported");
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Delete not supported");
    }

    public void deleteDocument(String str) throws FileNotFoundException {
        throw new UnsupportedOperationException("Delete not supported");
    }

    public String getDocumentType(String str) throws FileNotFoundException {
        Cursor queryDocument = queryDocument(str, null);
        try {
            if (queryDocument.moveToFirst()) {
                return queryDocument.getString(queryDocument.getColumnIndexOrThrow("mime_type"));
            }
            IoUtils.closeQuietly(queryDocument);
            return null;
        } finally {
            IoUtils.closeQuietly(queryDocument);
        }
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        try {
            switch (this.mMatcher.match(uri)) {
                case 2:
                    return DocumentsContract.Root.MIME_TYPE_ITEM;
                case 3:
                case 4:
                case 6:
                default:
                    return null;
                case 5:
                case 7:
                    enforceTree(uri);
                    return getDocumentType(DocumentsContract.getDocumentId(uri));
            }
        } catch (FileNotFoundException e) {
            Log.w(TAG, "Failed during getType", e);
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Insert not supported");
    }

    public boolean isChildDocument(String str, String str2) {
        return false;
    }

    @Override // android.content.ContentProvider
    public final AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        enforceTree(uri);
        ParcelFileDescriptor openDocument = openDocument(DocumentsContract.getDocumentId(uri), str, null);
        AssetFileDescriptor assetFileDescriptor = null;
        if (openDocument != null) {
            assetFileDescriptor = new AssetFileDescriptor(openDocument, 0L, -1L);
        }
        return assetFileDescriptor;
    }

    @Override // android.content.ContentProvider
    public final AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        enforceTree(uri);
        ParcelFileDescriptor openDocument = openDocument(DocumentsContract.getDocumentId(uri), str, cancellationSignal);
        if (openDocument != null) {
            return new AssetFileDescriptor(openDocument, 0L, -1L);
        }
        return null;
    }

    public abstract ParcelFileDescriptor openDocument(String str, String str2, CancellationSignal cancellationSignal) throws FileNotFoundException;

    public AssetFileDescriptor openDocumentThumbnail(String str, Point point, CancellationSignal cancellationSignal) throws FileNotFoundException {
        throw new UnsupportedOperationException("Thumbnails not supported");
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        enforceTree(uri);
        return openDocument(DocumentsContract.getDocumentId(uri), str, null);
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        enforceTree(uri);
        return openDocument(DocumentsContract.getDocumentId(uri), str, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    public final AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle) throws FileNotFoundException {
        enforceTree(uri);
        if (bundle == null || !bundle.containsKey(ContentResolver.EXTRA_SIZE)) {
            return super.openTypedAssetFile(uri, str, bundle);
        }
        return openDocumentThumbnail(DocumentsContract.getDocumentId(uri), (Point) bundle.getParcelable(ContentResolver.EXTRA_SIZE), null);
    }

    @Override // android.content.ContentProvider
    public final AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        enforceTree(uri);
        if (bundle == null || !bundle.containsKey(ContentResolver.EXTRA_SIZE)) {
            return super.openTypedAssetFile(uri, str, bundle, cancellationSignal);
        }
        return openDocumentThumbnail(DocumentsContract.getDocumentId(uri), (Point) bundle.getParcelable(ContentResolver.EXTRA_SIZE), cancellationSignal);
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            switch (this.mMatcher.match(uri)) {
                case 1:
                    return queryRoots(strArr);
                case 2:
                default:
                    throw new UnsupportedOperationException("Unsupported Uri " + uri);
                case 3:
                    return queryRecentDocuments(DocumentsContract.getRootId(uri), strArr);
                case 4:
                    return querySearchDocuments(DocumentsContract.getRootId(uri), DocumentsContract.getSearchDocumentsQuery(uri), strArr);
                case 5:
                case 7:
                    enforceTree(uri);
                    return queryDocument(DocumentsContract.getDocumentId(uri), strArr);
                case 6:
                case 8:
                    enforceTree(uri);
                    return DocumentsContract.isManageMode(uri) ? queryChildDocumentsForManage(DocumentsContract.getDocumentId(uri), strArr, str2) : queryChildDocuments(DocumentsContract.getDocumentId(uri), strArr, str2);
            }
        } catch (FileNotFoundException e) {
            Log.w(TAG, "Failed during query", e);
            return null;
        }
    }

    public abstract Cursor queryChildDocuments(String str, String[] strArr, String str2) throws FileNotFoundException;

    public Cursor queryChildDocumentsForManage(String str, String[] strArr, String str2) throws FileNotFoundException {
        throw new UnsupportedOperationException("Manage not supported");
    }

    public abstract Cursor queryDocument(String str, String[] strArr) throws FileNotFoundException;

    public Cursor queryRecentDocuments(String str, String[] strArr) throws FileNotFoundException {
        throw new UnsupportedOperationException("Recent not supported");
    }

    public abstract Cursor queryRoots(String[] strArr) throws FileNotFoundException;

    public Cursor querySearchDocuments(String str, String str2, String[] strArr) throws FileNotFoundException {
        throw new UnsupportedOperationException("Search not supported");
    }

    public String renameDocument(String str, String str2) throws FileNotFoundException {
        throw new UnsupportedOperationException("Rename not supported");
    }

    public final void revokeDocumentPermission(String str) {
        Context context = getContext();
        context.revokeUriPermission(DocumentsContract.buildDocumentUri(this.mAuthority, str), -1);
        context.revokeUriPermission(DocumentsContract.buildTreeDocumentUri(this.mAuthority, str), -1);
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Update not supported");
    }
}
