package android.content;

import android.accounts.Account;
import android.app.ActivityManagerNative;
import android.app.ActivityThread;
import android.content.IContentService;
import android.content.ISyncStatusObserver;
import android.content.SyncRequest;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.CrossProcessCursorWrapper;
import android.database.Cursor;
import android.database.IContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.DeadObjectException;
import android.os.ICancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemClock;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.api.IAdInterListener;
import dalvik.system.CloseGuard;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: source-9557208-dex2jar.jar:android/content/ContentResolver.class */
public abstract class ContentResolver {
    public static final String ANY_CURSOR_ITEM_TYPE = "vnd.android.cursor.item/*";
    public static final String CONTENT_SERVICE_NAME = "content";
    public static final String CURSOR_DIR_BASE_TYPE = "vnd.android.cursor.dir";
    public static final String CURSOR_ITEM_BASE_TYPE = "vnd.android.cursor.item";
    private static final boolean ENABLE_CONTENT_SAMPLE = false;
    public static final String EXTRA_SIZE = "android.content.extra.SIZE";
    public static final String SCHEME_ANDROID_RESOURCE = "android.resource";
    public static final String SCHEME_CONTENT = "content";
    public static final String SCHEME_FILE = "file";
    private static final int SLOW_THRESHOLD_MILLIS = 500;
    public static final int SYNC_ERROR_AUTHENTICATION = 2;
    public static final int SYNC_ERROR_CONFLICT = 5;
    public static final int SYNC_ERROR_INTERNAL = 8;
    public static final int SYNC_ERROR_IO = 3;
    public static final int SYNC_ERROR_PARSE = 4;
    public static final int SYNC_ERROR_SYNC_ALREADY_IN_PROGRESS = 1;
    public static final int SYNC_ERROR_TOO_MANY_DELETIONS = 6;
    public static final int SYNC_ERROR_TOO_MANY_RETRIES = 7;
    @Deprecated
    public static final String SYNC_EXTRAS_ACCOUNT = "account";
    public static final String SYNC_EXTRAS_DISALLOW_METERED = "allow_metered";
    public static final String SYNC_EXTRAS_DISCARD_LOCAL_DELETIONS = "discard_deletions";
    public static final String SYNC_EXTRAS_DO_NOT_RETRY = "do_not_retry";
    public static final String SYNC_EXTRAS_EXPECTED_DOWNLOAD = "expected_download";
    public static final String SYNC_EXTRAS_EXPECTED_UPLOAD = "expected_upload";
    public static final String SYNC_EXTRAS_EXPEDITED = "expedited";
    @Deprecated
    public static final String SYNC_EXTRAS_FORCE = "force";
    public static final String SYNC_EXTRAS_IGNORE_BACKOFF = "ignore_backoff";
    public static final String SYNC_EXTRAS_IGNORE_SETTINGS = "ignore_settings";
    public static final String SYNC_EXTRAS_INITIALIZE = "initialize";
    public static final String SYNC_EXTRAS_MANUAL = "force";
    public static final String SYNC_EXTRAS_OVERRIDE_TOO_MANY_DELETIONS = "deletions_override";
    public static final String SYNC_EXTRAS_PRIORITY = "sync_priority";
    public static final String SYNC_EXTRAS_UPLOAD = "upload";
    public static final int SYNC_OBSERVER_TYPE_ACTIVE = 4;
    public static final int SYNC_OBSERVER_TYPE_ALL = Integer.MAX_VALUE;
    public static final int SYNC_OBSERVER_TYPE_PENDING = 2;
    public static final int SYNC_OBSERVER_TYPE_SETTINGS = 1;
    public static final int SYNC_OBSERVER_TYPE_STATUS = 8;
    private static final String TAG = "ContentResolver";
    private static IContentService sContentService;
    private final Context mContext;
    final String mPackageName;
    private final Random mRandom = new Random();
    public static final Intent ACTION_SYNC_CONN_STATUS_CHANGED = new Intent("com.android.sync.SYNC_CONN_STATUS_CHANGED");
    private static final String[] SYNC_ERROR_NAMES = {"already-in-progress", "authentication-error", "io-error", "parse-error", "conflict", "too-many-deletions", "too-many-retries", "internal-error"};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/content/ContentResolver$CursorWrapperInner.class */
    public final class CursorWrapperInner extends CrossProcessCursorWrapper {
        public static final String TAG = "CursorWrapperInner";
        private final CloseGuard mCloseGuard;
        private final IContentProvider mContentProvider;
        private boolean mProviderReleased;

        CursorWrapperInner(Cursor cursor, IContentProvider iContentProvider) {
            super(cursor);
            this.mCloseGuard = CloseGuard.get();
            this.mContentProvider = iContentProvider;
            this.mCloseGuard.open("close");
        }

        @Override // android.database.CursorWrapper, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            ContentResolver.this.releaseProvider(this.mContentProvider);
            this.mProviderReleased = true;
            if (this.mCloseGuard != null) {
                this.mCloseGuard.close();
            }
        }

        protected void finalize() throws Throwable {
            try {
                if (this.mCloseGuard != null) {
                    this.mCloseGuard.warnIfOpen();
                }
                if (!this.mProviderReleased && this.mContentProvider != null) {
                    Log.w(TAG, "Cursor finalized without prior close()");
                    ContentResolver.this.releaseProvider(this.mContentProvider);
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/ContentResolver$OpenResourceIdResult.class */
    public class OpenResourceIdResult {
        public int id;
        public Resources r;

        public OpenResourceIdResult() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/content/ContentResolver$ParcelFileDescriptorInner.class */
    public final class ParcelFileDescriptorInner extends ParcelFileDescriptor {
        private final IContentProvider mContentProvider;
        private boolean mProviderReleased;

        ParcelFileDescriptorInner(ParcelFileDescriptor parcelFileDescriptor, IContentProvider iContentProvider) {
            super(parcelFileDescriptor);
            this.mContentProvider = iContentProvider;
        }

        @Override // android.os.ParcelFileDescriptor
        public void releaseResources() {
            if (this.mProviderReleased) {
                return;
            }
            ContentResolver.this.releaseProvider(this.mContentProvider);
            this.mProviderReleased = true;
        }
    }

    public ContentResolver(Context context) {
        this.mContext = context == null ? ActivityThread.currentApplication() : context;
        this.mPackageName = this.mContext.getOpPackageName();
    }

    public static void addPeriodicSync(Account account, String str, Bundle bundle, long j) {
        validateSyncExtrasBundle(bundle);
        if (bundle.getBoolean("force", false) || bundle.getBoolean(SYNC_EXTRAS_DO_NOT_RETRY, false) || bundle.getBoolean(SYNC_EXTRAS_IGNORE_BACKOFF, false) || bundle.getBoolean(SYNC_EXTRAS_IGNORE_SETTINGS, false) || bundle.getBoolean(SYNC_EXTRAS_INITIALIZE, false) || bundle.getBoolean("force", false) || bundle.getBoolean(SYNC_EXTRAS_EXPEDITED, false)) {
            throw new IllegalArgumentException("illegal extras were set");
        }
        try {
            getContentService().addPeriodicSync(account, str, bundle, j);
        } catch (RemoteException e) {
        }
    }

    public static Object addStatusChangeListener(int i, final SyncStatusObserver syncStatusObserver) {
        if (syncStatusObserver == null) {
            throw new IllegalArgumentException("you passed in a null callback");
        }
        try {
            ISyncStatusObserver.Stub stub = new ISyncStatusObserver.Stub() { // from class: android.content.ContentResolver.1
                @Override // android.content.ISyncStatusObserver
                public void onStatusChanged(int i2) throws RemoteException {
                    SyncStatusObserver.this.onStatusChanged(i2);
                }
            };
            getContentService().addStatusChangeListener(i, stub);
            return stub;
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    public static void cancelSync(Account account, String str) {
        try {
            getContentService().cancelSync(account, str, null);
        } catch (RemoteException e) {
        }
    }

    public static void cancelSync(SyncRequest syncRequest) {
        if (syncRequest == null) {
            throw new IllegalArgumentException("request cannot be null");
        }
        try {
            getContentService().cancelRequest(syncRequest);
        } catch (RemoteException e) {
        }
    }

    public static void cancelSyncAsUser(Account account, String str, int i) {
        try {
            getContentService().cancelSyncAsUser(account, str, null, i);
        } catch (RemoteException e) {
        }
    }

    public static IContentService getContentService() {
        if (sContentService != null) {
            return sContentService;
        }
        sContentService = IContentService.Stub.asInterface(ServiceManager.getService("content"));
        return sContentService;
    }

    @Deprecated
    public static SyncInfo getCurrentSync() {
        try {
            List<SyncInfo> currentSyncs = getContentService().getCurrentSyncs();
            if (currentSyncs.isEmpty()) {
                return null;
            }
            return currentSyncs.get(0);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    public static List<SyncInfo> getCurrentSyncs() {
        try {
            return getContentService().getCurrentSyncs();
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    public static List<SyncInfo> getCurrentSyncsAsUser(int i) {
        try {
            return getContentService().getCurrentSyncsAsUser(i);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    public static int getIsSyncable(Account account, String str) {
        try {
            return getContentService().getIsSyncable(account, str);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    public static int getIsSyncableAsUser(Account account, String str, int i) {
        try {
            return getContentService().getIsSyncableAsUser(account, str, i);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    public static boolean getMasterSyncAutomatically() {
        try {
            return getContentService().getMasterSyncAutomatically();
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    public static boolean getMasterSyncAutomaticallyAsUser(int i) {
        try {
            return getContentService().getMasterSyncAutomaticallyAsUser(i);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    public static List<PeriodicSync> getPeriodicSyncs(Account account, String str) {
        try {
            return getContentService().getPeriodicSyncs(account, str, null);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    public static SyncAdapterType[] getSyncAdapterTypes() {
        try {
            return getContentService().getSyncAdapterTypes();
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    public static SyncAdapterType[] getSyncAdapterTypesAsUser(int i) {
        try {
            return getContentService().getSyncAdapterTypesAsUser(i);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    public static boolean getSyncAutomatically(Account account, String str) {
        try {
            return getContentService().getSyncAutomatically(account, str);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    public static boolean getSyncAutomaticallyAsUser(Account account, String str, int i) {
        try {
            return getContentService().getSyncAutomaticallyAsUser(account, str, i);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    public static SyncStatusInfo getSyncStatus(Account account, String str) {
        try {
            return getContentService().getSyncStatus(account, str, null);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    public static SyncStatusInfo getSyncStatusAsUser(Account account, String str, int i) {
        try {
            return getContentService().getSyncStatusAsUser(account, str, null, i);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    public static boolean invalidPeriodicExtras(Bundle bundle) {
        boolean z = false;
        if (bundle.getBoolean("force", false) || bundle.getBoolean(SYNC_EXTRAS_DO_NOT_RETRY, false) || bundle.getBoolean(SYNC_EXTRAS_IGNORE_BACKOFF, false) || bundle.getBoolean(SYNC_EXTRAS_IGNORE_SETTINGS, false) || bundle.getBoolean(SYNC_EXTRAS_INITIALIZE, false) || bundle.getBoolean("force", false) || bundle.getBoolean(SYNC_EXTRAS_EXPEDITED, false)) {
            z = true;
        }
        return z;
    }

    public static boolean isSyncActive(Account account, String str) {
        if (account == null) {
            throw new IllegalArgumentException("account must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("authority must not be null");
        }
        try {
            return getContentService().isSyncActive(account, str, null);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    public static boolean isSyncPending(Account account, String str) {
        return isSyncPendingAsUser(account, str, UserHandle.myUserId());
    }

    public static boolean isSyncPendingAsUser(Account account, String str, int i) {
        try {
            return getContentService().isSyncPendingAsUser(account, str, null, i);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    private void maybeLogQueryToEventLog(long j, Uri uri, String[] strArr, String str, String str2) {
    }

    private void maybeLogUpdateToEventLog(long j, Uri uri, String str, String str2) {
    }

    public static void removePeriodicSync(Account account, String str, Bundle bundle) {
        validateSyncExtrasBundle(bundle);
        try {
            getContentService().removePeriodicSync(account, str, bundle);
        } catch (RemoteException e) {
            throw new RuntimeException("the ContentService should always be reachable", e);
        }
    }

    public static void removeStatusChangeListener(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("you passed in a null handle");
        }
        try {
            getContentService().removeStatusChangeListener((ISyncStatusObserver.Stub) obj);
        } catch (RemoteException e) {
        }
    }

    public static void requestSync(Account account, String str, Bundle bundle) {
        requestSyncAsUser(account, str, UserHandle.myUserId(), bundle);
    }

    public static void requestSync(SyncRequest syncRequest) {
        try {
            getContentService().sync(syncRequest);
        } catch (RemoteException e) {
        }
    }

    public static void requestSyncAsUser(Account account, String str, int i, Bundle bundle) {
        if (bundle == null) {
            throw new IllegalArgumentException("Must specify extras.");
        }
        try {
            getContentService().syncAsUser(new SyncRequest.Builder().setSyncAdapter(account, str).setExtras(bundle).syncOnce().build(), i);
        } catch (RemoteException e) {
        }
    }

    private int samplePercentForDuration(long j) {
        if (j >= 500) {
            return 100;
        }
        return ((int) ((100 * j) / 500)) + 1;
    }

    public static void setIsSyncable(Account account, String str, int i) {
        try {
            getContentService().setIsSyncable(account, str, i);
        } catch (RemoteException e) {
        }
    }

    public static void setMasterSyncAutomatically(boolean z) {
        setMasterSyncAutomaticallyAsUser(z, UserHandle.myUserId());
    }

    public static void setMasterSyncAutomaticallyAsUser(boolean z, int i) {
        try {
            getContentService().setMasterSyncAutomaticallyAsUser(z, i);
        } catch (RemoteException e) {
        }
    }

    public static void setSyncAutomatically(Account account, String str, boolean z) {
        setSyncAutomaticallyAsUser(account, str, z, UserHandle.myUserId());
    }

    public static void setSyncAutomaticallyAsUser(Account account, String str, boolean z, int i) {
        try {
            getContentService().setSyncAutomaticallyAsUser(account, str, z, i);
        } catch (RemoteException e) {
        }
    }

    public static int syncErrorStringToInt(String str) {
        int length = SYNC_ERROR_NAMES.length;
        for (int i = 0; i < length; i++) {
            if (SYNC_ERROR_NAMES[i].equals(str)) {
                return i + 1;
            }
        }
        if (str != null) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                Log.d(TAG, "error parsing sync error: " + str);
                return 0;
            }
        }
        return 0;
    }

    public static String syncErrorToString(int i) {
        return (i < 1 || i > SYNC_ERROR_NAMES.length) ? String.valueOf(i) : SYNC_ERROR_NAMES[i - 1];
    }

    public static void validateSyncExtrasBundle(Bundle bundle) {
        try {
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Boolean) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof String) && !(obj instanceof Account)) {
                    throw new IllegalArgumentException("unexpected value type: " + obj.getClass().getName());
                }
            }
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw new IllegalArgumentException("error unparceling Bundle", e2);
        }
    }

    public final ContentProviderClient acquireContentProviderClient(Uri uri) {
        IContentProvider acquireProvider = acquireProvider(uri);
        if (acquireProvider != null) {
            return new ContentProviderClient(this, acquireProvider, true);
        }
        return null;
    }

    public final ContentProviderClient acquireContentProviderClient(String str) {
        IContentProvider acquireProvider = acquireProvider(str);
        if (acquireProvider != null) {
            return new ContentProviderClient(this, acquireProvider, true);
        }
        return null;
    }

    protected IContentProvider acquireExistingProvider(Context context, String str) {
        return acquireProvider(context, str);
    }

    public final IContentProvider acquireExistingProvider(Uri uri) {
        String authority;
        if ("content".equals(uri.getScheme()) && (authority = uri.getAuthority()) != null) {
            return acquireExistingProvider(this.mContext, authority);
        }
        return null;
    }

    protected abstract IContentProvider acquireProvider(Context context, String str);

    public final IContentProvider acquireProvider(Uri uri) {
        String authority;
        if ("content".equals(uri.getScheme()) && (authority = uri.getAuthority()) != null) {
            return acquireProvider(this.mContext, authority);
        }
        return null;
    }

    public final IContentProvider acquireProvider(String str) {
        if (str == null) {
            return null;
        }
        return acquireProvider(this.mContext, str);
    }

    public final ContentProviderClient acquireUnstableContentProviderClient(Uri uri) {
        IContentProvider acquireUnstableProvider = acquireUnstableProvider(uri);
        if (acquireUnstableProvider != null) {
            return new ContentProviderClient(this, acquireUnstableProvider, false);
        }
        return null;
    }

    public final ContentProviderClient acquireUnstableContentProviderClient(String str) {
        IContentProvider acquireUnstableProvider = acquireUnstableProvider(str);
        if (acquireUnstableProvider != null) {
            return new ContentProviderClient(this, acquireUnstableProvider, false);
        }
        return null;
    }

    protected abstract IContentProvider acquireUnstableProvider(Context context, String str);

    public final IContentProvider acquireUnstableProvider(Uri uri) {
        if ("content".equals(uri.getScheme()) && uri.getAuthority() != null) {
            return acquireUnstableProvider(this.mContext, uri.getAuthority());
        }
        return null;
    }

    public final IContentProvider acquireUnstableProvider(String str) {
        if (str == null) {
            return null;
        }
        return acquireUnstableProvider(this.mContext, str);
    }

    public void appNotRespondingViaProvider(IContentProvider iContentProvider) {
        throw new UnsupportedOperationException("appNotRespondingViaProvider");
    }

    public ContentProviderResult[] applyBatch(String str, ArrayList<ContentProviderOperation> arrayList) throws RemoteException, OperationApplicationException {
        ContentProviderClient acquireContentProviderClient = acquireContentProviderClient(str);
        if (acquireContentProviderClient == null) {
            throw new IllegalArgumentException("Unknown authority " + str);
        }
        try {
            return acquireContentProviderClient.applyBatch(arrayList);
        } finally {
            acquireContentProviderClient.release();
        }
    }

    public final int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        IContentProvider acquireProvider = acquireProvider(uri);
        if (acquireProvider == null) {
            throw new IllegalArgumentException("Unknown URL " + uri);
        }
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            int bulkInsert = acquireProvider.bulkInsert(this.mPackageName, uri, contentValuesArr);
            maybeLogUpdateToEventLog(SystemClock.uptimeMillis() - uptimeMillis, uri, "bulkinsert", null);
            releaseProvider(acquireProvider);
            return bulkInsert;
        } catch (RemoteException e) {
            releaseProvider(acquireProvider);
            return 0;
        } catch (Throwable th) {
            releaseProvider(acquireProvider);
            throw th;
        }
    }

    public final Bundle call(Uri uri, String str, String str2, Bundle bundle) {
        if (uri == null) {
            throw new NullPointerException("uri == null");
        }
        if (str == null) {
            throw new NullPointerException("method == null");
        }
        IContentProvider acquireProvider = acquireProvider(uri);
        if (acquireProvider == null) {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
        try {
            Bundle call = acquireProvider.call(this.mPackageName, str, str2, bundle);
            releaseProvider(acquireProvider);
            return call;
        } catch (RemoteException e) {
            releaseProvider(acquireProvider);
            return null;
        } catch (Throwable th) {
            releaseProvider(acquireProvider);
            throw th;
        }
    }

    @Deprecated
    public void cancelSync(Uri uri) {
        cancelSync(null, uri != null ? uri.getAuthority() : null);
    }

    public final Uri canonicalize(Uri uri) {
        IContentProvider acquireProvider = acquireProvider(uri);
        if (acquireProvider == null) {
            return null;
        }
        try {
            Uri canonicalize = acquireProvider.canonicalize(this.mPackageName, uri);
            releaseProvider(acquireProvider);
            return canonicalize;
        } catch (RemoteException e) {
            releaseProvider(acquireProvider);
            return null;
        } catch (Throwable th) {
            releaseProvider(acquireProvider);
            throw th;
        }
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        IContentProvider acquireProvider = acquireProvider(uri);
        if (acquireProvider == null) {
            throw new IllegalArgumentException("Unknown URL " + uri);
        }
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            int delete = acquireProvider.delete(this.mPackageName, uri, str, strArr);
            maybeLogUpdateToEventLog(SystemClock.uptimeMillis() - uptimeMillis, uri, "delete", str);
            releaseProvider(acquireProvider);
            return delete;
        } catch (RemoteException e) {
            releaseProvider(acquireProvider);
            return -1;
        } catch (Throwable th) {
            releaseProvider(acquireProvider);
            throw th;
        }
    }

    public List<UriPermission> getOutgoingPersistedUriPermissions() {
        try {
            return ActivityManagerNative.getDefault().getPersistedUriPermissions(this.mPackageName, false).getList();
        } catch (RemoteException e) {
            throw new RuntimeException("Activity manager has died", e);
        }
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public List<UriPermission> getPersistedUriPermissions() {
        try {
            return ActivityManagerNative.getDefault().getPersistedUriPermissions(this.mPackageName, true).getList();
        } catch (RemoteException e) {
            throw new RuntimeException("Activity manager has died", e);
        }
    }

    public OpenResourceIdResult getResourceId(Uri uri) throws FileNotFoundException {
        int parseInt;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    parseInt = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size != 2) {
                throw new FileNotFoundException("More than two path segments: " + uri);
            } else {
                parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (parseInt == 0) {
                throw new FileNotFoundException("No resource found for: " + uri);
            }
            OpenResourceIdResult openResourceIdResult = new OpenResourceIdResult();
            openResourceIdResult.r = resourcesForApplication;
            openResourceIdResult.id = parseInt;
            return openResourceIdResult;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    public String[] getStreamTypes(Uri uri, String str) {
        IContentProvider acquireProvider = acquireProvider(uri);
        if (acquireProvider == null) {
            return null;
        }
        try {
            String[] streamTypes = acquireProvider.getStreamTypes(uri, str);
            releaseProvider(acquireProvider);
            return streamTypes;
        } catch (RemoteException e) {
            releaseProvider(acquireProvider);
            return null;
        } catch (Throwable th) {
            releaseProvider(acquireProvider);
            throw th;
        }
    }

    public final String getType(Uri uri) {
        String str = null;
        IContentProvider acquireExistingProvider = acquireExistingProvider(uri);
        try {
            if (acquireExistingProvider != null) {
                try {
                    String type = acquireExistingProvider.getType(uri);
                    releaseProvider(acquireExistingProvider);
                    str = type;
                } catch (RemoteException e) {
                    releaseProvider(acquireExistingProvider);
                    return null;
                } catch (Exception e2) {
                    Log.w(TAG, "Failed to get type for: " + uri + " (" + e2.getMessage() + ")");
                    releaseProvider(acquireExistingProvider);
                    return null;
                }
            } else if ("content".equals(uri.getScheme())) {
                try {
                    return ActivityManagerNative.getDefault().getProviderMimeType(ContentProvider.getUriWithoutUserId(uri), resolveUserId(uri));
                } catch (RemoteException e3) {
                    return null;
                } catch (Exception e4) {
                    Log.w(TAG, "Failed to get type for: " + uri + " (" + e4.getMessage() + ")");
                    return null;
                }
            }
            return str;
        } catch (Throwable th) {
            releaseProvider(acquireExistingProvider);
            throw th;
        }
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        IContentProvider acquireProvider = acquireProvider(uri);
        if (acquireProvider == null) {
            throw new IllegalArgumentException("Unknown URL " + uri);
        }
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            Uri insert = acquireProvider.insert(this.mPackageName, uri, contentValues);
            maybeLogUpdateToEventLog(SystemClock.uptimeMillis() - uptimeMillis, uri, "insert", null);
            releaseProvider(acquireProvider);
            return insert;
        } catch (RemoteException e) {
            releaseProvider(acquireProvider);
            return null;
        } catch (Throwable th) {
            releaseProvider(acquireProvider);
            throw th;
        }
    }

    public void notifyChange(Uri uri, ContentObserver contentObserver) {
        notifyChange(uri, contentObserver, true);
    }

    public void notifyChange(Uri uri, ContentObserver contentObserver, boolean z) {
        notifyChange(uri, contentObserver, z, UserHandle.myUserId());
    }

    public void notifyChange(Uri uri, ContentObserver contentObserver, boolean z, int i) {
        try {
            getContentService().notifyChange(uri, contentObserver == null ? null : contentObserver.getContentObserver(), contentObserver != null && contentObserver.deliverSelfNotifications(), z, i);
        } catch (RemoteException e) {
        }
    }

    public final AssetFileDescriptor openAssetFileDescriptor(Uri uri, String str) throws FileNotFoundException {
        return openAssetFileDescriptor(uri, str, null);
    }

    public final AssetFileDescriptor openAssetFileDescriptor(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptor;
        IContentProvider iContentProvider;
        AssetFileDescriptor assetFileDescriptor2;
        String scheme = uri.getScheme();
        if (SCHEME_ANDROID_RESOURCE.equals(scheme)) {
            if (!"r".equals(str)) {
                throw new FileNotFoundException("Can't write resources: " + uri);
            }
            OpenResourceIdResult resourceId = getResourceId(uri);
            try {
                assetFileDescriptor2 = resourceId.r.openRawResourceFd(resourceId.id);
            } catch (Resources.NotFoundException e) {
                throw new FileNotFoundException("Resource does not exist: " + uri);
            }
        } else if (SCHEME_FILE.equals(scheme)) {
            return new AssetFileDescriptor(ParcelFileDescriptor.open(new File(uri.getPath()), ParcelFileDescriptor.parseMode(str)), 0L, -1L);
        } else {
            if ("r".equals(str)) {
                return openTypedAssetFileDescriptor(uri, "*/*", null, cancellationSignal);
            }
            IContentProvider acquireUnstableProvider = acquireUnstableProvider(uri);
            if (acquireUnstableProvider == null) {
                throw new FileNotFoundException("No content provider: " + uri);
            }
            ICancellationSignal iCancellationSignal = null;
            try {
                if (cancellationSignal != null) {
                    scheme = null;
                    try {
                        cancellationSignal.throwIfCanceled();
                        iCancellationSignal = acquireUnstableProvider.createCancellationSignal();
                        cancellationSignal.setRemote(iCancellationSignal);
                    } catch (RemoteException e2) {
                        throw new FileNotFoundException("Failed opening content provider: " + uri);
                    } catch (FileNotFoundException e3) {
                        throw e3;
                    }
                }
                try {
                    AssetFileDescriptor openAssetFile = acquireUnstableProvider.openAssetFile(this.mPackageName, uri, str, iCancellationSignal);
                    assetFileDescriptor = openAssetFile;
                    iContentProvider = null;
                    if (openAssetFile == null) {
                        assetFileDescriptor2 = null;
                        if (cancellationSignal != null) {
                            cancellationSignal.setRemote(null);
                        }
                        if (0 != 0) {
                            releaseProvider(null);
                        }
                        if (acquireUnstableProvider != null) {
                            releaseUnstableProvider(acquireUnstableProvider);
                            return null;
                        }
                    }
                } catch (DeadObjectException e4) {
                    unstableProviderDied(acquireUnstableProvider);
                    IContentProvider acquireProvider = acquireProvider(uri);
                    if (acquireProvider == null) {
                        throw new FileNotFoundException("No content provider: " + uri);
                    }
                    AssetFileDescriptor openAssetFile2 = acquireProvider.openAssetFile(this.mPackageName, uri, str, iCancellationSignal);
                    assetFileDescriptor = openAssetFile2;
                    iContentProvider = acquireProvider;
                    if (openAssetFile2 == null) {
                        assetFileDescriptor2 = null;
                        if (cancellationSignal != null) {
                            cancellationSignal.setRemote(null);
                        }
                        if (acquireProvider != null) {
                            releaseProvider(acquireProvider);
                        }
                        if (acquireUnstableProvider != null) {
                            releaseUnstableProvider(acquireUnstableProvider);
                            return null;
                        }
                    }
                }
                IContentProvider iContentProvider2 = iContentProvider;
                if (iContentProvider == null) {
                    iContentProvider2 = acquireProvider(uri);
                }
                IContentProvider iContentProvider3 = iContentProvider2;
                releaseUnstableProvider(acquireUnstableProvider);
                IContentProvider iContentProvider4 = iContentProvider2;
                AssetFileDescriptor assetFileDescriptor3 = new AssetFileDescriptor(new ParcelFileDescriptorInner(assetFileDescriptor.getParcelFileDescriptor(), iContentProvider2), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getDeclaredLength());
                if (cancellationSignal != null) {
                    cancellationSignal.setRemote(null);
                }
                if (0 != 0) {
                    releaseProvider(null);
                }
                assetFileDescriptor2 = assetFileDescriptor3;
                if (acquireUnstableProvider != null) {
                    releaseUnstableProvider(acquireUnstableProvider);
                    return assetFileDescriptor3;
                }
            } catch (Throwable th) {
                if (cancellationSignal != null) {
                    cancellationSignal.setRemote(null);
                }
                if (scheme != null) {
                    releaseProvider(scheme);
                }
                if (acquireUnstableProvider != null) {
                    releaseUnstableProvider(acquireUnstableProvider);
                }
                throw th;
            }
        }
        return assetFileDescriptor2;
    }

    public final ParcelFileDescriptor openFileDescriptor(Uri uri, String str) throws FileNotFoundException {
        return openFileDescriptor(uri, str, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:11:0x0020). Please submit an issue!!! */
    public final ParcelFileDescriptor openFileDescriptor(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        AssetFileDescriptor openAssetFileDescriptor = openAssetFileDescriptor(uri, str, cancellationSignal);
        if (openAssetFileDescriptor == null) {
            return null;
        }
        if (openAssetFileDescriptor.getDeclaredLength() < 0) {
            return openAssetFileDescriptor.getParcelFileDescriptor();
        }
        try {
            openAssetFileDescriptor.close();
        } catch (IOException e) {
        }
        throw new FileNotFoundException("Not a whole file");
    }

    public final InputStream openInputStream(Uri uri) throws FileNotFoundException {
        String scheme = uri.getScheme();
        if (SCHEME_ANDROID_RESOURCE.equals(scheme)) {
            OpenResourceIdResult resourceId = getResourceId(uri);
            try {
                return resourceId.r.openRawResource(resourceId.id);
            } catch (Resources.NotFoundException e) {
                throw new FileNotFoundException("Resource does not exist: " + uri);
            }
        } else if (SCHEME_FILE.equals(scheme)) {
            return new FileInputStream(uri.getPath());
        } else {
            AssetFileDescriptor openAssetFileDescriptor = openAssetFileDescriptor(uri, "r", null);
            FileInputStream fileInputStream = null;
            if (openAssetFileDescriptor != null) {
                try {
                    fileInputStream = openAssetFileDescriptor.createInputStream();
                } catch (IOException e2) {
                    throw new FileNotFoundException("Unable to create stream");
                }
            }
            return fileInputStream;
        }
    }

    public final OutputStream openOutputStream(Uri uri) throws FileNotFoundException {
        return openOutputStream(uri, IAdInterListener.AdReqParam.WIDTH);
    }

    public final OutputStream openOutputStream(Uri uri, String str) throws FileNotFoundException {
        AssetFileDescriptor openAssetFileDescriptor = openAssetFileDescriptor(uri, str, null);
        FileOutputStream fileOutputStream = null;
        if (openAssetFileDescriptor != null) {
            try {
                fileOutputStream = openAssetFileDescriptor.createOutputStream();
            } catch (IOException e) {
                throw new FileNotFoundException("Unable to create stream");
            }
        }
        return fileOutputStream;
    }

    public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri, String str, Bundle bundle) throws FileNotFoundException {
        return openTypedAssetFileDescriptor(uri, str, bundle, null);
    }

    public final AssetFileDescriptor openTypedAssetFileDescriptor(Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        IContentProvider iContentProvider;
        AssetFileDescriptor assetFileDescriptor;
        AssetFileDescriptor assetFileDescriptor2;
        AssetFileDescriptor openTypedAssetFile;
        IContentProvider acquireUnstableProvider = acquireUnstableProvider(uri);
        if (acquireUnstableProvider == null) {
            throw new FileNotFoundException("No content provider: " + uri);
        }
        ICancellationSignal iCancellationSignal = null;
        try {
            if (cancellationSignal != null) {
                try {
                    cancellationSignal.throwIfCanceled();
                    iCancellationSignal = acquireUnstableProvider.createCancellationSignal();
                    cancellationSignal.setRemote(iCancellationSignal);
                } catch (RemoteException e) {
                    throw new FileNotFoundException("Failed opening content provider: " + uri);
                } catch (FileNotFoundException e2) {
                    throw e2;
                }
            }
            try {
                openTypedAssetFile = acquireUnstableProvider.openTypedAssetFile(this.mPackageName, uri, str, bundle, iCancellationSignal);
                iContentProvider = null;
                assetFileDescriptor = openTypedAssetFile;
            } catch (DeadObjectException e3) {
                unstableProviderDied(acquireUnstableProvider);
                IContentProvider acquireProvider = acquireProvider(uri);
                if (acquireProvider == null) {
                    throw new FileNotFoundException("No content provider: " + uri);
                }
                AssetFileDescriptor openTypedAssetFile2 = acquireProvider.openTypedAssetFile(this.mPackageName, uri, str, bundle, iCancellationSignal);
                iContentProvider = acquireProvider;
                assetFileDescriptor = openTypedAssetFile2;
                if (openTypedAssetFile2 == null) {
                    assetFileDescriptor2 = null;
                    if (cancellationSignal != null) {
                        cancellationSignal.setRemote(null);
                    }
                    if (acquireProvider != null) {
                        releaseProvider(acquireProvider);
                    }
                    if (acquireUnstableProvider != null) {
                        releaseUnstableProvider(acquireUnstableProvider);
                        return null;
                    }
                }
            }
            if (openTypedAssetFile == null) {
                if (cancellationSignal != null) {
                    cancellationSignal.setRemote(null);
                }
                if (0 != 0) {
                    releaseProvider(null);
                }
                assetFileDescriptor2 = null;
                if (acquireUnstableProvider != null) {
                    releaseUnstableProvider(acquireUnstableProvider);
                    assetFileDescriptor2 = null;
                }
                return assetFileDescriptor2;
            }
            IContentProvider iContentProvider2 = iContentProvider;
            if (iContentProvider == null) {
                iContentProvider2 = acquireProvider(uri);
            }
            IContentProvider iContentProvider3 = iContentProvider2;
            releaseUnstableProvider(acquireUnstableProvider);
            IContentProvider iContentProvider4 = iContentProvider2;
            AssetFileDescriptor assetFileDescriptor3 = new AssetFileDescriptor(new ParcelFileDescriptorInner(assetFileDescriptor.getParcelFileDescriptor(), iContentProvider2), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getDeclaredLength());
            if (cancellationSignal != null) {
                cancellationSignal.setRemote(null);
            }
            if (0 != 0) {
                releaseProvider(null);
            }
            assetFileDescriptor2 = assetFileDescriptor3;
            if (acquireUnstableProvider != null) {
                releaseUnstableProvider(acquireUnstableProvider);
                return assetFileDescriptor3;
            }
            return assetFileDescriptor2;
        } catch (Throwable th) {
            if (cancellationSignal != null) {
                cancellationSignal.setRemote(null);
            }
            if (0 != 0) {
                releaseProvider(null);
            }
            if (acquireUnstableProvider != null) {
                releaseUnstableProvider(acquireUnstableProvider);
            }
            throw th;
        }
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return query(uri, strArr, str, strArr2, str2, null);
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
        CursorWrapperInner cursorWrapperInner;
        IContentProvider iContentProvider;
        Cursor cursor;
        IContentProvider acquireUnstableProvider = acquireUnstableProvider(uri);
        if (acquireUnstableProvider == null) {
            cursorWrapperInner = null;
        } else {
            IContentProvider iContentProvider2 = null;
            Cursor cursor2 = null;
            IContentProvider iContentProvider3 = null;
            Cursor cursor3 = null;
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                ICancellationSignal iCancellationSignal = null;
                if (cancellationSignal != null) {
                    cancellationSignal.throwIfCanceled();
                    iCancellationSignal = acquireUnstableProvider.createCancellationSignal();
                    cancellationSignal.setRemote(iCancellationSignal);
                }
                try {
                    cursor = acquireUnstableProvider.query(this.mPackageName, uri, strArr, str, strArr2, str2, iCancellationSignal);
                    iContentProvider = null;
                } catch (DeadObjectException e) {
                    unstableProviderDied(acquireUnstableProvider);
                    IContentProvider acquireProvider = acquireProvider(uri);
                    if (acquireProvider == null) {
                        cursorWrapperInner = null;
                        if (0 != 0) {
                            throw new NullPointerException();
                        }
                        if (cancellationSignal != null) {
                            cancellationSignal.setRemote(null);
                        }
                        if (acquireUnstableProvider != null) {
                            releaseUnstableProvider(acquireUnstableProvider);
                        }
                        if (acquireProvider != null) {
                            releaseProvider(acquireProvider);
                            return null;
                        }
                    } else {
                        Cursor query = acquireProvider.query(this.mPackageName, uri, strArr, str, strArr2, str2, iCancellationSignal);
                        iContentProvider = acquireProvider;
                        cursor = query;
                    }
                }
                if (cursor == null) {
                    cursorWrapperInner = null;
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (cancellationSignal != null) {
                        cancellationSignal.setRemote(null);
                    }
                    if (acquireUnstableProvider != null) {
                        releaseUnstableProvider(acquireUnstableProvider);
                    }
                    if (iContentProvider != null) {
                        releaseProvider(iContentProvider);
                        return null;
                    }
                } else {
                    cursor.getCount();
                    IContentProvider iContentProvider4 = iContentProvider;
                    maybeLogQueryToEventLog(SystemClock.uptimeMillis() - uptimeMillis, uri, strArr, str, str2);
                    iContentProvider2 = iContentProvider;
                    cursor2 = cursor;
                    iContentProvider3 = iContentProvider;
                    cursor3 = cursor;
                    CursorWrapperInner cursorWrapperInner2 = new CursorWrapperInner(cursor, iContentProvider != null ? iContentProvider : acquireProvider(uri));
                    if (0 != 0) {
                        throw new NullPointerException();
                    }
                    if (cancellationSignal != null) {
                        cancellationSignal.setRemote(null);
                    }
                    if (acquireUnstableProvider != null) {
                        releaseUnstableProvider(acquireUnstableProvider);
                    }
                    cursorWrapperInner = cursorWrapperInner2;
                    if (0 != 0) {
                        releaseProvider(null);
                        return cursorWrapperInner2;
                    }
                }
            } catch (RemoteException e2) {
                cursorWrapperInner = null;
                if (cursor2 != null) {
                    cursor2.close();
                }
                if (cancellationSignal != null) {
                    cancellationSignal.setRemote(null);
                }
                if (acquireUnstableProvider != null) {
                    releaseUnstableProvider(acquireUnstableProvider);
                }
                if (iContentProvider2 != null) {
                    releaseProvider(iContentProvider2);
                    return null;
                }
            } catch (Throwable th) {
                if (cursor3 != null) {
                    cursor3.close();
                }
                if (cancellationSignal != null) {
                    cancellationSignal.setRemote(null);
                }
                if (acquireUnstableProvider != null) {
                    releaseUnstableProvider(acquireUnstableProvider);
                }
                if (iContentProvider3 != null) {
                    releaseProvider(iContentProvider3);
                }
                throw th;
            }
        }
        return cursorWrapperInner;
    }

    public final void registerContentObserver(Uri uri, boolean z, ContentObserver contentObserver) {
        registerContentObserver(uri, z, contentObserver, UserHandle.myUserId());
    }

    public final void registerContentObserver(Uri uri, boolean z, ContentObserver contentObserver, int i) {
        try {
            getContentService().registerContentObserver(uri, z, contentObserver.getContentObserver(), i);
        } catch (RemoteException e) {
        }
    }

    public void releasePersistableUriPermission(Uri uri, int i) {
        try {
            ActivityManagerNative.getDefault().releasePersistableUriPermission(ContentProvider.getUriWithoutUserId(uri), i, resolveUserId(uri));
        } catch (RemoteException e) {
        }
    }

    public abstract boolean releaseProvider(IContentProvider iContentProvider);

    public abstract boolean releaseUnstableProvider(IContentProvider iContentProvider);

    public int resolveUserId(Uri uri) {
        return ContentProvider.getUserIdFromUri(uri, this.mContext.getUserId());
    }

    @Deprecated
    public void startSync(Uri uri, Bundle bundle) {
        Account account = null;
        if (bundle != null) {
            String string = bundle.getString("account");
            account = null;
            if (!TextUtils.isEmpty(string)) {
                account = new Account(string, "com.google");
            }
            bundle.remove("account");
        }
        requestSync(account, uri != null ? uri.getAuthority() : null, bundle);
    }

    public void takePersistableUriPermission(Uri uri, int i) {
        try {
            ActivityManagerNative.getDefault().takePersistableUriPermission(ContentProvider.getUriWithoutUserId(uri), i, resolveUserId(uri));
        } catch (RemoteException e) {
        }
    }

    public final Uri uncanonicalize(Uri uri) {
        IContentProvider acquireProvider = acquireProvider(uri);
        if (acquireProvider == null) {
            return null;
        }
        try {
            Uri uncanonicalize = acquireProvider.uncanonicalize(this.mPackageName, uri);
            releaseProvider(acquireProvider);
            return uncanonicalize;
        } catch (RemoteException e) {
            releaseProvider(acquireProvider);
            return null;
        } catch (Throwable th) {
            releaseProvider(acquireProvider);
            throw th;
        }
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
        try {
            IContentObserver releaseContentObserver = contentObserver.releaseContentObserver();
            if (releaseContentObserver != null) {
                getContentService().unregisterContentObserver(releaseContentObserver);
            }
        } catch (RemoteException e) {
        }
    }

    public abstract void unstableProviderDied(IContentProvider iContentProvider);

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        IContentProvider acquireProvider = acquireProvider(uri);
        if (acquireProvider == null) {
            throw new IllegalArgumentException("Unknown URI " + uri);
        }
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            int update = acquireProvider.update(this.mPackageName, uri, contentValues, str, strArr);
            maybeLogUpdateToEventLog(SystemClock.uptimeMillis() - uptimeMillis, uri, "update", str);
            releaseProvider(acquireProvider);
            return update;
        } catch (RemoteException e) {
            releaseProvider(acquireProvider);
            return -1;
        } catch (Throwable th) {
            releaseProvider(acquireProvider);
            throw th;
        }
    }
}
