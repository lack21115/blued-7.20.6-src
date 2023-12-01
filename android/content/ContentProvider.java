package android.content;

import android.Manifest;
import android.app.AppOpsManager;
import android.content.pm.PathPermission;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.ICancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/content/ContentProvider.class */
public abstract class ContentProvider implements ComponentCallbacks2 {
    private static final String TAG = "ContentProvider";
    private String[] mAuthorities;
    private String mAuthority;
    private final ThreadLocal<String> mCallingPackage;
    private Context mContext;
    private boolean mExported;
    private int mMyUid;
    private boolean mNoPerms;
    private PathPermission[] mPathPermissions;
    private String mReadPermission;
    private boolean mSingleUser;
    private Transport mTransport;
    private String mWritePermission;

    /* loaded from: source-9557208-dex2jar.jar:android/content/ContentProvider$PipeDataWriter.class */
    public interface PipeDataWriter<T> {
        void writeDataToPipe(ParcelFileDescriptor parcelFileDescriptor, Uri uri, String str, Bundle bundle, T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/content/ContentProvider$Transport.class */
    public class Transport extends ContentProviderNative {
        AppOpsManager mAppOpsManager = null;
        int mReadOp = -1;
        int mWriteOp = -1;

        Transport() {
        }

        private int enforceDeletePermission(String str, Uri uri) throws SecurityException {
            ContentProvider.this.enforceWritePermissionInner(uri, null);
            if (this.mWriteOp != -1) {
                int i = this.mWriteOp;
                switch (this.mWriteOp) {
                    case 5:
                        i = 57;
                        break;
                    case 7:
                        i = 58;
                        break;
                    case 15:
                        i = 55;
                        break;
                    case 52:
                        i = 56;
                        break;
                }
                return this.mAppOpsManager.noteOp(i, Binder.getCallingUid(), str);
            }
            return 0;
        }

        private void enforceFilePermission(String str, Uri uri, String str2, IBinder iBinder) throws FileNotFoundException, SecurityException {
            if (str2 == null || str2.indexOf(119) == -1) {
                if (enforceReadPermission(str, uri, iBinder) != 0) {
                    throw new FileNotFoundException("App op not allowed");
                }
            } else if (enforceWritePermission(str, uri, iBinder) != 0) {
                throw new FileNotFoundException("App op not allowed");
            }
        }

        private int enforceReadPermission(String str, Uri uri, IBinder iBinder) throws SecurityException {
            ContentProvider.this.enforceReadPermissionInner(uri, iBinder);
            if (this.mReadOp != -1) {
                return this.mAppOpsManager.noteOp(this.mReadOp, Binder.getCallingUid(), str);
            }
            return 0;
        }

        private int enforceWritePermission(String str, Uri uri, IBinder iBinder) throws SecurityException {
            ContentProvider.this.enforceWritePermissionInner(uri, iBinder);
            if (this.mWriteOp != -1) {
                return this.mAppOpsManager.noteOp(this.mWriteOp, Binder.getCallingUid(), str);
            }
            return 0;
        }

        @Override // android.content.IContentProvider
        public ContentProviderResult[] applyBatch(String str, ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
            int size = arrayList.size();
            int[] iArr = new int[size];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    String callingPackage = ContentProvider.this.setCallingPackage(str);
                    try {
                        ContentProviderResult[] applyBatch = ContentProvider.this.applyBatch(arrayList);
                        if (applyBatch != null) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3;
                                if (i4 >= applyBatch.length) {
                                    break;
                                }
                                if (iArr[i4] != -2) {
                                    applyBatch[i4] = new ContentProviderResult(applyBatch[i4], iArr[i4]);
                                }
                                i3 = i4 + 1;
                            }
                        }
                        return applyBatch;
                    } finally {
                        ContentProvider.this.setCallingPackage(callingPackage);
                    }
                }
                ContentProviderOperation contentProviderOperation = arrayList.get(i2);
                Uri uri = contentProviderOperation.getUri();
                ContentProvider.this.validateIncomingUri(uri);
                iArr[i2] = ContentProvider.getUserIdFromUri(uri);
                ContentProviderOperation contentProviderOperation2 = contentProviderOperation;
                if (iArr[i2] != -2) {
                    contentProviderOperation2 = new ContentProviderOperation(contentProviderOperation, true);
                    arrayList.set(i2, contentProviderOperation2);
                }
                if (contentProviderOperation2.isReadOperation() && enforceReadPermission(str, uri, null) != 0) {
                    throw new OperationApplicationException("App op not allowed", 0);
                }
                if (contentProviderOperation2.isDeleteOperation()) {
                    if (enforceDeletePermission(str, uri) != 0) {
                        throw new OperationApplicationException("App op not allowed", 0);
                    }
                } else if (contentProviderOperation2.isWriteOperation() && enforceWritePermission(str, uri, null) != 0) {
                    throw new OperationApplicationException("App op not allowed", 0);
                }
                i = i2 + 1;
            }
        }

        @Override // android.content.IContentProvider
        public int bulkInsert(String str, Uri uri, ContentValues[] contentValuesArr) {
            ContentProvider.this.validateIncomingUri(uri);
            Uri uriWithoutUserId = ContentProvider.getUriWithoutUserId(uri);
            if (enforceWritePermission(str, uriWithoutUserId, null) != 0) {
                return 0;
            }
            String callingPackage = ContentProvider.this.setCallingPackage(str);
            try {
                return ContentProvider.this.bulkInsert(uriWithoutUserId, contentValuesArr);
            } finally {
                ContentProvider.this.setCallingPackage(callingPackage);
            }
        }

        @Override // android.content.IContentProvider
        public Bundle call(String str, String str2, String str3, Bundle bundle) {
            String callingPackage = ContentProvider.this.setCallingPackage(str);
            try {
                return ContentProvider.this.call(str2, str3, bundle);
            } finally {
                ContentProvider.this.setCallingPackage(callingPackage);
            }
        }

        @Override // android.content.IContentProvider
        public Uri canonicalize(String str, Uri uri) {
            ContentProvider.this.validateIncomingUri(uri);
            int userIdFromUri = ContentProvider.getUserIdFromUri(uri);
            Uri uriWithoutUserId = ContentProvider.getUriWithoutUserId(uri);
            if (enforceReadPermission(str, uriWithoutUserId, null) != 0) {
                return null;
            }
            String callingPackage = ContentProvider.this.setCallingPackage(str);
            try {
                return ContentProvider.maybeAddUserId(ContentProvider.this.canonicalize(uriWithoutUserId), userIdFromUri);
            } finally {
                ContentProvider.this.setCallingPackage(callingPackage);
            }
        }

        @Override // android.content.IContentProvider
        public ICancellationSignal createCancellationSignal() {
            return CancellationSignal.createTransport();
        }

        @Override // android.content.IContentProvider
        public int delete(String str, Uri uri, String str2, String[] strArr) {
            ContentProvider.this.validateIncomingUri(uri);
            Uri uriWithoutUserId = ContentProvider.getUriWithoutUserId(uri);
            if (enforceDeletePermission(str, uriWithoutUserId) != 0) {
                return 0;
            }
            String callingPackage = ContentProvider.this.setCallingPackage(str);
            try {
                return ContentProvider.this.delete(uriWithoutUserId, str2, strArr);
            } finally {
                ContentProvider.this.setCallingPackage(callingPackage);
            }
        }

        ContentProvider getContentProvider() {
            return ContentProvider.this;
        }

        @Override // android.content.ContentProviderNative
        public String getProviderName() {
            return getContentProvider().getClass().getName();
        }

        @Override // android.content.IContentProvider
        public String[] getStreamTypes(Uri uri, String str) {
            ContentProvider.this.validateIncomingUri(uri);
            return ContentProvider.this.getStreamTypes(ContentProvider.getUriWithoutUserId(uri), str);
        }

        @Override // android.content.IContentProvider
        public String getType(Uri uri) {
            ContentProvider.this.validateIncomingUri(uri);
            return ContentProvider.this.getType(ContentProvider.getUriWithoutUserId(uri));
        }

        @Override // android.content.IContentProvider
        public Uri insert(String str, Uri uri, ContentValues contentValues) {
            ContentProvider.this.validateIncomingUri(uri);
            int userIdFromUri = ContentProvider.getUserIdFromUri(uri);
            Uri uriWithoutUserId = ContentProvider.getUriWithoutUserId(uri);
            if (enforceWritePermission(str, uriWithoutUserId, null) != 0) {
                return ContentProvider.this.rejectInsert(uriWithoutUserId, contentValues);
            }
            String callingPackage = ContentProvider.this.setCallingPackage(str);
            try {
                return ContentProvider.maybeAddUserId(ContentProvider.this.insert(uriWithoutUserId, contentValues), userIdFromUri);
            } finally {
                ContentProvider.this.setCallingPackage(callingPackage);
            }
        }

        @Override // android.content.IContentProvider
        public AssetFileDescriptor openAssetFile(String str, Uri uri, String str2, ICancellationSignal iCancellationSignal) throws FileNotFoundException {
            ContentProvider.this.validateIncomingUri(uri);
            Uri uriWithoutUserId = ContentProvider.getUriWithoutUserId(uri);
            enforceFilePermission(str, uriWithoutUserId, str2, null);
            String callingPackage = ContentProvider.this.setCallingPackage(str);
            try {
                return ContentProvider.this.openAssetFile(uriWithoutUserId, str2, CancellationSignal.fromTransport(iCancellationSignal));
            } finally {
                ContentProvider.this.setCallingPackage(callingPackage);
            }
        }

        @Override // android.content.IContentProvider
        public ParcelFileDescriptor openFile(String str, Uri uri, String str2, ICancellationSignal iCancellationSignal, IBinder iBinder) throws FileNotFoundException {
            ContentProvider.this.validateIncomingUri(uri);
            Uri uriWithoutUserId = ContentProvider.getUriWithoutUserId(uri);
            enforceFilePermission(str, uriWithoutUserId, str2, iBinder);
            String callingPackage = ContentProvider.this.setCallingPackage(str);
            try {
                return ContentProvider.this.openFile(uriWithoutUserId, str2, CancellationSignal.fromTransport(iCancellationSignal));
            } finally {
                ContentProvider.this.setCallingPackage(callingPackage);
            }
        }

        @Override // android.content.IContentProvider
        public AssetFileDescriptor openTypedAssetFile(String str, Uri uri, String str2, Bundle bundle, ICancellationSignal iCancellationSignal) throws FileNotFoundException {
            ContentProvider.this.validateIncomingUri(uri);
            Uri uriWithoutUserId = ContentProvider.getUriWithoutUserId(uri);
            enforceFilePermission(str, uriWithoutUserId, "r", null);
            String callingPackage = ContentProvider.this.setCallingPackage(str);
            try {
                return ContentProvider.this.openTypedAssetFile(uriWithoutUserId, str2, bundle, CancellationSignal.fromTransport(iCancellationSignal));
            } finally {
                ContentProvider.this.setCallingPackage(callingPackage);
            }
        }

        @Override // android.content.IContentProvider
        public Cursor query(String str, Uri uri, String[] strArr, String str2, String[] strArr2, String str3, ICancellationSignal iCancellationSignal) {
            ContentProvider.this.validateIncomingUri(uri);
            Uri uriWithoutUserId = ContentProvider.getUriWithoutUserId(uri);
            if (enforceReadPermission(str, uriWithoutUserId, null) != 0) {
                return ContentProvider.this.rejectQuery(uriWithoutUserId, strArr, str2, strArr2, str3, CancellationSignal.fromTransport(iCancellationSignal));
            }
            String callingPackage = ContentProvider.this.setCallingPackage(str);
            try {
                return ContentProvider.this.query(uriWithoutUserId, strArr, str2, strArr2, str3, CancellationSignal.fromTransport(iCancellationSignal));
            } finally {
                ContentProvider.this.setCallingPackage(callingPackage);
            }
        }

        @Override // android.content.IContentProvider
        public Uri uncanonicalize(String str, Uri uri) {
            ContentProvider.this.validateIncomingUri(uri);
            int userIdFromUri = ContentProvider.getUserIdFromUri(uri);
            Uri uriWithoutUserId = ContentProvider.getUriWithoutUserId(uri);
            if (enforceReadPermission(str, uriWithoutUserId, null) != 0) {
                return null;
            }
            String callingPackage = ContentProvider.this.setCallingPackage(str);
            try {
                return ContentProvider.maybeAddUserId(ContentProvider.this.uncanonicalize(uriWithoutUserId), userIdFromUri);
            } finally {
                ContentProvider.this.setCallingPackage(callingPackage);
            }
        }

        @Override // android.content.IContentProvider
        public int update(String str, Uri uri, ContentValues contentValues, String str2, String[] strArr) {
            ContentProvider.this.validateIncomingUri(uri);
            Uri uriWithoutUserId = ContentProvider.getUriWithoutUserId(uri);
            if (enforceWritePermission(str, uriWithoutUserId, null) != 0) {
                return 0;
            }
            String callingPackage = ContentProvider.this.setCallingPackage(str);
            try {
                return ContentProvider.this.update(uriWithoutUserId, contentValues, str2, strArr);
            } finally {
                ContentProvider.this.setCallingPackage(callingPackage);
            }
        }
    }

    public ContentProvider() {
        this.mContext = null;
        this.mCallingPackage = new ThreadLocal<>();
        this.mTransport = new Transport();
    }

    public ContentProvider(Context context, String str, String str2, PathPermission[] pathPermissionArr) {
        this.mContext = null;
        this.mCallingPackage = new ThreadLocal<>();
        this.mTransport = new Transport();
        this.mContext = context;
        this.mReadPermission = str;
        this.mWritePermission = str2;
        this.mPathPermissions = pathPermissionArr;
    }

    private void attachInfo(Context context, ProviderInfo providerInfo, boolean z) {
        this.mNoPerms = z;
        if (this.mContext == null) {
            this.mContext = context;
            if (context != null) {
                this.mTransport.mAppOpsManager = (AppOpsManager) context.getSystemService(Context.APP_OPS_SERVICE);
            }
            this.mMyUid = Process.myUid();
            if (providerInfo != null) {
                setReadPermission(providerInfo.readPermission);
                setWritePermission(providerInfo.writePermission);
                setPathPermissions(providerInfo.pathPermissions);
                this.mExported = providerInfo.exported;
                this.mSingleUser = (providerInfo.flags & 1073741824) != 0;
                setAuthorities(providerInfo.authority);
            }
            onCreate();
        }
    }

    public static ContentProvider coerceToLocalContentProvider(IContentProvider iContentProvider) {
        if (iContentProvider instanceof Transport) {
            return ((Transport) iContentProvider).getContentProvider();
        }
        return null;
    }

    public static String getAuthorityWithoutUserId(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(str.lastIndexOf(64) + 1);
    }

    public static Uri getUriWithoutUserId(Uri uri) {
        if (uri == null) {
            return null;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.authority(getAuthorityWithoutUserId(uri.getAuthority()));
        return buildUpon.build();
    }

    public static int getUserIdFromAuthority(String str) {
        return getUserIdFromAuthority(str, -2);
    }

    public static int getUserIdFromAuthority(String str, int i) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf(64)) == -1) {
            return i;
        }
        try {
            return Integer.parseInt(str.substring(0, lastIndexOf));
        } catch (NumberFormatException e) {
            Log.w(TAG, "Error parsing userId.", e);
            return -10000;
        }
    }

    public static int getUserIdFromUri(Uri uri) {
        return getUserIdFromUri(uri, -2);
    }

    public static int getUserIdFromUri(Uri uri, int i) {
        return uri == null ? i : getUserIdFromAuthority(uri.getAuthority(), i);
    }

    public static Uri maybeAddUserId(Uri uri, int i) {
        Uri uri2;
        if (uri == null) {
            uri2 = null;
        } else {
            uri2 = uri;
            if (i != -2) {
                uri2 = uri;
                if ("content".equals(uri.getScheme())) {
                    uri2 = uri;
                    if (!uriHasUserId(uri)) {
                        Uri.Builder buildUpon = uri.buildUpon();
                        buildUpon.encodedAuthority("" + i + "@" + uri.getEncodedAuthority());
                        return buildUpon.build();
                    }
                }
            }
        }
        return uri2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String setCallingPackage(String str) {
        String str2 = this.mCallingPackage.get();
        this.mCallingPackage.set(str);
        return str2;
    }

    public static boolean uriHasUserId(Uri uri) {
        return (uri == null || TextUtils.isEmpty(uri.getUserInfo())) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void validateIncomingUri(Uri uri) throws SecurityException {
        String authority = uri.getAuthority();
        int userIdFromAuthority = getUserIdFromAuthority(authority, -2);
        if (userIdFromAuthority != -2 && userIdFromAuthority != this.mContext.getUserId()) {
            throw new SecurityException("trying to query a ContentProvider in user " + this.mContext.getUserId() + " with a uri belonging to user " + userIdFromAuthority);
        }
        if (matchesOurAuthorities(getAuthorityWithoutUserId(authority))) {
            return;
        }
        String str = "The authority of the uri " + uri + " does not match the one of the contentProvider: ";
        throw new SecurityException(this.mAuthority != null ? str + this.mAuthority : str + this.mAuthorities);
    }

    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        int size = arrayList.size();
        ContentProviderResult[] contentProviderResultArr = new ContentProviderResult[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return contentProviderResultArr;
            }
            contentProviderResultArr[i2] = arrayList.get(i2).apply(this, contentProviderResultArr, i2);
            i = i2 + 1;
        }
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        attachInfo(context, providerInfo, false);
    }

    public void attachInfoForTesting(Context context, ProviderInfo providerInfo) {
        attachInfo(context, providerInfo, true);
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        int length = contentValuesArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return length;
            }
            insert(uri, contentValuesArr[i2]);
            i = i2 + 1;
        }
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        return null;
    }

    public Uri canonicalize(Uri uri) {
        return null;
    }

    boolean checkUser(int i, int i2, Context context) {
        return UserHandle.getUserId(i2) == context.getUserId() || this.mSingleUser || context.checkPermission(Manifest.permission.INTERACT_ACROSS_USERS, i, i2) == 0;
    }

    public abstract int delete(Uri uri, String str, String[] strArr);

    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.println("nothing to dump");
    }

    protected void enforceReadPermissionInner(Uri uri, IBinder iBinder) throws SecurityException {
        Context context = getContext();
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        String str = null;
        if (UserHandle.isSameApp(callingUid, this.mMyUid)) {
            return;
        }
        String str2 = null;
        if (this.mExported) {
            str2 = null;
            if (checkUser(callingPid, callingUid, context)) {
                String readPermission = getReadPermission();
                if (readPermission != null) {
                    if (context.checkPermission(readPermission, callingPid, callingUid, iBinder) == 0) {
                        return;
                    }
                    str = readPermission;
                }
                boolean z = readPermission == null;
                PathPermission[] pathPermissions = getPathPermissions();
                boolean z2 = z;
                str2 = str;
                if (pathPermissions != null) {
                    String path = uri.getPath();
                    int length = pathPermissions.length;
                    int i = 0;
                    while (true) {
                        z2 = z;
                        str2 = str;
                        if (i >= length) {
                            break;
                        }
                        PathPermission pathPermission = pathPermissions[i];
                        String readPermission2 = pathPermission.getReadPermission();
                        boolean z3 = z;
                        String str3 = str;
                        if (readPermission2 != null) {
                            z3 = z;
                            str3 = str;
                            if (!pathPermission.match(path)) {
                                continue;
                            } else if (context.checkPermission(readPermission2, callingPid, callingUid, iBinder) == 0) {
                                return;
                            } else {
                                z3 = false;
                                str3 = readPermission2;
                            }
                        }
                        i++;
                        z = z3;
                        str = str3;
                    }
                }
                if (z2) {
                    return;
                }
            }
        }
        if (context.checkUriPermission((!this.mSingleUser || UserHandle.isSameUser(this.mMyUid, callingUid)) ? uri : maybeAddUserId(uri, UserHandle.getUserId(callingUid)), callingPid, callingUid, 1, iBinder) != 0) {
            throw new SecurityException("Permission Denial: reading " + getClass().getName() + " uri " + uri + " from pid=" + callingPid + ", uid=" + callingUid + (this.mExported ? " requires " + str2 + ", or grantUriPermission()" : " requires the provider be exported, or grantUriPermission()"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void enforceWritePermissionInner(Uri uri, IBinder iBinder) throws SecurityException {
        Context context = getContext();
        int callingPid = Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        String str = null;
        if (UserHandle.isSameApp(callingUid, this.mMyUid)) {
            return;
        }
        String str2 = null;
        if (this.mExported) {
            str2 = null;
            if (checkUser(callingPid, callingUid, context)) {
                String writePermission = getWritePermission();
                if (writePermission != null) {
                    if (context.checkPermission(writePermission, callingPid, callingUid, iBinder) == 0) {
                        return;
                    }
                    str = writePermission;
                }
                boolean z = writePermission == null;
                PathPermission[] pathPermissions = getPathPermissions();
                boolean z2 = z;
                str2 = str;
                if (pathPermissions != null) {
                    String path = uri.getPath();
                    int length = pathPermissions.length;
                    int i = 0;
                    while (true) {
                        z2 = z;
                        str2 = str;
                        if (i >= length) {
                            break;
                        }
                        PathPermission pathPermission = pathPermissions[i];
                        String writePermission2 = pathPermission.getWritePermission();
                        boolean z3 = z;
                        String str3 = str;
                        if (writePermission2 != null) {
                            z3 = z;
                            str3 = str;
                            if (!pathPermission.match(path)) {
                                continue;
                            } else if (context.checkPermission(writePermission2, callingPid, callingUid, iBinder) == 0) {
                                return;
                            } else {
                                z3 = false;
                                str3 = writePermission2;
                            }
                        }
                        i++;
                        z = z3;
                        str = str3;
                    }
                }
                if (z2) {
                    return;
                }
            }
        }
        if (context.checkUriPermission(uri, callingPid, callingUid, 2, iBinder) != 0) {
            throw new SecurityException("Permission Denial: writing " + getClass().getName() + " uri " + uri + " from pid=" + callingPid + ", uid=" + callingUid + (this.mExported ? " requires " + str2 + ", or grantUriPermission()" : " requires the provider be exported, or grantUriPermission()"));
        }
    }

    public AppOpsManager getAppOpsManager() {
        return this.mTransport.mAppOpsManager;
    }

    public final String getCallingPackage() {
        String str = this.mCallingPackage.get();
        if (str != null) {
            this.mTransport.mAppOpsManager.checkPackage(Binder.getCallingUid(), str);
        }
        return str;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public IContentProvider getIContentProvider() {
        return this.mTransport;
    }

    public final PathPermission[] getPathPermissions() {
        return this.mPathPermissions;
    }

    public final String getReadPermission() {
        return this.mReadPermission;
    }

    public String[] getStreamTypes(Uri uri, String str) {
        return null;
    }

    public abstract String getType(Uri uri);

    public final String getWritePermission() {
        return this.mWritePermission;
    }

    public abstract Uri insert(Uri uri, ContentValues contentValues);

    protected boolean isTemporary() {
        return false;
    }

    protected final boolean matchesOurAuthorities(String str) {
        if (this.mAuthority != null) {
            return this.mAuthority.equals(str);
        }
        if (this.mAuthorities == null) {
            return false;
        }
        int length = this.mAuthorities.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (this.mAuthorities[i2].equals(str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    public abstract boolean onCreate();

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
    }

    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        ParcelFileDescriptor openFile = openFile(uri, str);
        if (openFile != null) {
            return new AssetFileDescriptor(openFile, 0L, -1L);
        }
        return null;
    }

    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return openAssetFile(uri, str);
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        throw new FileNotFoundException("No files supported by provider at " + uri);
    }

    public ParcelFileDescriptor openFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return openFile(uri, str);
    }

    protected final ParcelFileDescriptor openFileHelper(Uri uri, String str) throws FileNotFoundException {
        int i = 0;
        Cursor query = query(uri, new String[]{"_data"}, null, null, null);
        if (query != null) {
            i = query.getCount();
        }
        if (i != 1) {
            if (query != null) {
                query.close();
            }
            if (i == 0) {
                throw new FileNotFoundException("No entry for " + uri);
            }
            throw new FileNotFoundException("Multiple items at " + uri);
        }
        query.moveToFirst();
        int columnIndex = query.getColumnIndex("_data");
        String string = columnIndex >= 0 ? query.getString(columnIndex) : null;
        query.close();
        if (string == null) {
            throw new FileNotFoundException("Column _data not found.");
        }
        return ParcelFileDescriptor.open(new File(string), ParcelFileDescriptor.parseMode(str));
    }

    public <T> ParcelFileDescriptor openPipeHelper(final Uri uri, final String str, final Bundle bundle, final T t, final PipeDataWriter<T> pipeDataWriter) throws FileNotFoundException {
        try {
            final ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
            new AsyncTask<Object, Object, Object>() { // from class: android.content.ContentProvider.1
                @Override // android.os.AsyncTask
                protected Object doInBackground(Object... objArr) {
                    pipeDataWriter.writeDataToPipe(createPipe[1], uri, str, bundle, t);
                    try {
                        createPipe[1].close();
                        return null;
                    } catch (IOException e) {
                        Log.w(ContentProvider.TAG, "Failure closing pipe", e);
                        return null;
                    }
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
            return createPipe[0];
        } catch (IOException e) {
            throw new FileNotFoundException("failure making pipe");
        }
    }

    public AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle) throws FileNotFoundException {
        if ("*/*".equals(str)) {
            return openAssetFile(uri, "r");
        }
        String type = getType(uri);
        if (type == null || !ClipDescription.compareMimeTypes(type, str)) {
            throw new FileNotFoundException("Can't open " + uri + " as type " + str);
        }
        return openAssetFile(uri, "r");
    }

    public AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        return openTypedAssetFile(uri, str, bundle);
    }

    public abstract Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2);

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return query(uri, strArr, str, strArr2, str2);
    }

    public Uri rejectInsert(Uri uri, ContentValues contentValues) {
        return uri.buildUpon().appendPath("0").build();
    }

    public Cursor rejectQuery(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        return query(uri, strArr, (str == null || str.isEmpty()) ? "'A' = 'B'" : "'A' = 'B' AND (" + str + ")", strArr2, str2, cancellationSignal);
    }

    public final void setAppOps(int i, int i2) {
        if (this.mNoPerms) {
            return;
        }
        this.mTransport.mReadOp = i;
        this.mTransport.mWriteOp = i2;
    }

    protected final void setAuthorities(String str) {
        if (str != null) {
            if (str.indexOf(59) == -1) {
                this.mAuthority = str;
                this.mAuthorities = null;
                return;
            }
            this.mAuthority = null;
            this.mAuthorities = str.split(";");
        }
    }

    protected final void setPathPermissions(PathPermission[] pathPermissionArr) {
        this.mPathPermissions = pathPermissionArr;
    }

    protected final void setReadPermission(String str) {
        this.mReadPermission = str;
    }

    protected final void setWritePermission(String str) {
        this.mWritePermission = str;
    }

    public void shutdown() {
        Log.w(TAG, "implement ContentProvider shutdown() to make sure all database connections are gracefully shutdown");
    }

    public Uri uncanonicalize(Uri uri) {
        return uri;
    }

    public abstract int update(Uri uri, ContentValues contentValues, String str, String[] strArr);
}
