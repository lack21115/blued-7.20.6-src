package android.content.pm;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.IPackageInstallerCallback;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.FileBridge;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.ExceptionUtils;
import android.util.Log;
import com.android.internal.util.IndentingPrintWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageInstaller.class */
public class PackageInstaller {
    public static final String ACTION_CONFIRM_PERMISSIONS = "android.content.pm.action.CONFIRM_PERMISSIONS";
    public static final String ACTION_SESSION_DETAILS = "android.content.pm.action.SESSION_DETAILS";
    public static final String EXTRA_CALLBACK = "android.content.pm.extra.CALLBACK";
    public static final String EXTRA_LEGACY_BUNDLE = "android.content.pm.extra.LEGACY_BUNDLE";
    public static final String EXTRA_LEGACY_STATUS = "android.content.pm.extra.LEGACY_STATUS";
    public static final String EXTRA_OTHER_PACKAGE_NAME = "android.content.pm.extra.OTHER_PACKAGE_NAME";
    public static final String EXTRA_PACKAGE_NAME = "android.content.pm.extra.PACKAGE_NAME";
    @Deprecated
    public static final String EXTRA_PACKAGE_NAMES = "android.content.pm.extra.PACKAGE_NAMES";
    public static final String EXTRA_SESSION_ID = "android.content.pm.extra.SESSION_ID";
    public static final String EXTRA_STATUS = "android.content.pm.extra.STATUS";
    public static final String EXTRA_STATUS_MESSAGE = "android.content.pm.extra.STATUS_MESSAGE";
    public static final String EXTRA_STORAGE_PATH = "android.content.pm.extra.STORAGE_PATH";
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_FAILURE_ABORTED = 3;
    public static final int STATUS_FAILURE_BLOCKED = 2;
    public static final int STATUS_FAILURE_CONFLICT = 5;
    public static final int STATUS_FAILURE_INCOMPATIBLE = 7;
    public static final int STATUS_FAILURE_INVALID = 4;
    public static final int STATUS_FAILURE_STORAGE = 6;
    public static final int STATUS_PENDING_USER_ACTION = -1;
    public static final int STATUS_SUCCESS = 0;
    private static final String TAG = "PackageInstaller";
    private final Context mContext;
    private final ArrayList<SessionCallbackDelegate> mDelegates = new ArrayList<>();
    private final IPackageInstaller mInstaller;
    private final String mInstallerPackageName;
    private final PackageManager mPm;
    private final int mUserId;

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageInstaller$Session.class */
    public static class Session implements Closeable {
        private IPackageInstallerSession mSession;

        public Session(IPackageInstallerSession iPackageInstallerSession) {
            this.mSession = iPackageInstallerSession;
        }

        public void abandon() {
            try {
                this.mSession.abandon();
            } catch (RemoteException e) {
                throw e.rethrowAsRuntimeException();
            }
        }

        public void addProgress(float f) {
            try {
                this.mSession.addClientProgress(f);
            } catch (RemoteException e) {
                throw e.rethrowAsRuntimeException();
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            try {
                this.mSession.close();
            } catch (RemoteException e) {
                throw e.rethrowAsRuntimeException();
            }
        }

        public void commit(IntentSender intentSender) {
            try {
                this.mSession.commit(intentSender);
            } catch (RemoteException e) {
                throw e.rethrowAsRuntimeException();
            }
        }

        public void fsync(OutputStream outputStream) throws IOException {
            if (!(outputStream instanceof FileBridge.FileBridgeOutputStream)) {
                throw new IllegalArgumentException("Unrecognized stream");
            }
            ((FileBridge.FileBridgeOutputStream) outputStream).fsync();
        }

        public String[] getNames() throws IOException {
            try {
                return this.mSession.getNames();
            } catch (RemoteException e) {
                throw e.rethrowAsRuntimeException();
            } catch (RuntimeException e2) {
                ExceptionUtils.maybeUnwrapIOException(e2);
                throw e2;
            }
        }

        public InputStream openRead(String str) throws IOException {
            try {
                return new ParcelFileDescriptor.AutoCloseInputStream(this.mSession.openRead(str));
            } catch (RemoteException e) {
                throw e.rethrowAsRuntimeException();
            } catch (RuntimeException e2) {
                ExceptionUtils.maybeUnwrapIOException(e2);
                throw e2;
            }
        }

        public OutputStream openWrite(String str, long j, long j2) throws IOException {
            try {
                return new FileBridge.FileBridgeOutputStream(this.mSession.openWrite(str, j, j2));
            } catch (RemoteException e) {
                throw e.rethrowAsRuntimeException();
            } catch (RuntimeException e2) {
                ExceptionUtils.maybeUnwrapIOException(e2);
                throw e2;
            }
        }

        @Deprecated
        public void setProgress(float f) {
            setStagingProgress(f);
        }

        public void setStagingProgress(float f) {
            try {
                this.mSession.setClientProgress(f);
            } catch (RemoteException e) {
                throw e.rethrowAsRuntimeException();
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageInstaller$SessionCallback.class */
    public static abstract class SessionCallback {
        public abstract void onActiveChanged(int i, boolean z);

        public abstract void onBadgingChanged(int i);

        public abstract void onCreated(int i);

        public abstract void onFinished(int i, boolean z);

        public abstract void onProgressChanged(int i, float f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageInstaller$SessionCallbackDelegate.class */
    public static class SessionCallbackDelegate extends IPackageInstallerCallback.Stub implements Handler.Callback {
        private static final int MSG_SESSION_ACTIVE_CHANGED = 3;
        private static final int MSG_SESSION_BADGING_CHANGED = 2;
        private static final int MSG_SESSION_CREATED = 1;
        private static final int MSG_SESSION_FINISHED = 5;
        private static final int MSG_SESSION_PROGRESS_CHANGED = 4;
        final SessionCallback mCallback;
        final Handler mHandler;

        public SessionCallbackDelegate(SessionCallback sessionCallback, Looper looper) {
            this.mCallback = sessionCallback;
            this.mHandler = new Handler(looper, this);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            boolean z = false;
            int i = message.arg1;
            switch (message.what) {
                case 1:
                    this.mCallback.onCreated(i);
                    return true;
                case 2:
                    this.mCallback.onBadgingChanged(i);
                    return true;
                case 3:
                    if (message.arg2 != 0) {
                        z = true;
                    }
                    this.mCallback.onActiveChanged(i, z);
                    return true;
                case 4:
                    this.mCallback.onProgressChanged(i, ((Float) message.obj).floatValue());
                    return true;
                case 5:
                    SessionCallback sessionCallback = this.mCallback;
                    boolean z2 = false;
                    if (message.arg2 != 0) {
                        z2 = true;
                    }
                    sessionCallback.onFinished(i, z2);
                    return true;
                default:
                    return false;
            }
        }

        @Override // android.content.pm.IPackageInstallerCallback
        public void onSessionActiveChanged(int i, boolean z) {
            this.mHandler.obtainMessage(3, i, z ? 1 : 0).sendToTarget();
        }

        @Override // android.content.pm.IPackageInstallerCallback
        public void onSessionBadgingChanged(int i) {
            this.mHandler.obtainMessage(2, i, 0).sendToTarget();
        }

        @Override // android.content.pm.IPackageInstallerCallback
        public void onSessionCreated(int i) {
            this.mHandler.obtainMessage(1, i, 0).sendToTarget();
        }

        @Override // android.content.pm.IPackageInstallerCallback
        public void onSessionFinished(int i, boolean z) {
            this.mHandler.obtainMessage(5, i, z ? 1 : 0).sendToTarget();
        }

        @Override // android.content.pm.IPackageInstallerCallback
        public void onSessionProgressChanged(int i, float f) {
            this.mHandler.obtainMessage(4, i, 0, Float.valueOf(f)).sendToTarget();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageInstaller$SessionInfo.class */
    public static class SessionInfo implements Parcelable {
        public static final Parcelable.Creator<SessionInfo> CREATOR = new Parcelable.Creator<SessionInfo>() { // from class: android.content.pm.PackageInstaller.SessionInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SessionInfo createFromParcel(Parcel parcel) {
                return new SessionInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SessionInfo[] newArray(int i) {
                return new SessionInfo[i];
            }
        };
        public boolean active;
        public Bitmap appIcon;
        public CharSequence appLabel;
        public String appPackageName;
        public String installerPackageName;
        public int mode;
        public float progress;
        public String resolvedBaseCodePath;
        public boolean sealed;
        public int sessionId;
        public long sizeBytes;

        public SessionInfo() {
        }

        public SessionInfo(Parcel parcel) {
            this.sessionId = parcel.readInt();
            this.installerPackageName = parcel.readString();
            this.resolvedBaseCodePath = parcel.readString();
            this.progress = parcel.readFloat();
            this.sealed = parcel.readInt() != 0;
            this.active = parcel.readInt() != 0;
            this.mode = parcel.readInt();
            this.sizeBytes = parcel.readLong();
            this.appPackageName = parcel.readString();
            this.appIcon = (Bitmap) parcel.readParcelable(null);
            this.appLabel = parcel.readString();
        }

        public Intent createDetailsIntent() {
            Intent intent = new Intent(PackageInstaller.ACTION_SESSION_DETAILS);
            intent.putExtra(PackageInstaller.EXTRA_SESSION_ID, this.sessionId);
            intent.setPackage(this.installerPackageName);
            intent.setFlags(268435456);
            return intent;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public Bitmap getAppIcon() {
            return this.appIcon;
        }

        public CharSequence getAppLabel() {
            return this.appLabel;
        }

        public String getAppPackageName() {
            return this.appPackageName;
        }

        @Deprecated
        public Intent getDetailsIntent() {
            return createDetailsIntent();
        }

        public String getInstallerPackageName() {
            return this.installerPackageName;
        }

        public float getProgress() {
            return this.progress;
        }

        public int getSessionId() {
            return this.sessionId;
        }

        public boolean isActive() {
            return this.active;
        }

        @Deprecated
        public boolean isOpen() {
            return isActive();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.sessionId);
            parcel.writeString(this.installerPackageName);
            parcel.writeString(this.resolvedBaseCodePath);
            parcel.writeFloat(this.progress);
            parcel.writeInt(this.sealed ? 1 : 0);
            parcel.writeInt(this.active ? 1 : 0);
            parcel.writeInt(this.mode);
            parcel.writeLong(this.sizeBytes);
            parcel.writeString(this.appPackageName);
            parcel.writeParcelable(this.appIcon, i);
            parcel.writeString(this.appLabel != null ? this.appLabel.toString() : null);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/content/pm/PackageInstaller$SessionParams.class */
    public static class SessionParams implements Parcelable {
        public static final Parcelable.Creator<SessionParams> CREATOR = new Parcelable.Creator<SessionParams>() { // from class: android.content.pm.PackageInstaller.SessionParams.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SessionParams createFromParcel(Parcel parcel) {
                return new SessionParams(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SessionParams[] newArray(int i) {
                return new SessionParams[i];
            }
        };
        public static final int MODE_FULL_INSTALL = 1;
        public static final int MODE_INHERIT_EXISTING = 2;
        public static final int MODE_INVALID = -1;
        public String abiOverride;
        public Bitmap appIcon;
        public long appIconLastModified;
        public String appLabel;
        public String appPackageName;
        public int installFlags;
        public int installLocation;
        public int mode;
        public Uri originatingUri;
        public Uri referrerUri;
        public long sizeBytes;

        public SessionParams(int i) {
            this.mode = -1;
            this.installLocation = 1;
            this.sizeBytes = -1L;
            this.appIconLastModified = -1L;
            this.mode = i;
        }

        public SessionParams(Parcel parcel) {
            this.mode = -1;
            this.installLocation = 1;
            this.sizeBytes = -1L;
            this.appIconLastModified = -1L;
            this.mode = parcel.readInt();
            this.installFlags = parcel.readInt();
            this.installLocation = parcel.readInt();
            this.sizeBytes = parcel.readLong();
            this.appPackageName = parcel.readString();
            this.appIcon = (Bitmap) parcel.readParcelable(null);
            this.appLabel = parcel.readString();
            this.originatingUri = (Uri) parcel.readParcelable(null);
            this.referrerUri = (Uri) parcel.readParcelable(null);
            this.abiOverride = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void dump(IndentingPrintWriter indentingPrintWriter) {
            indentingPrintWriter.printPair("mode", Integer.valueOf(this.mode));
            indentingPrintWriter.printHexPair("installFlags", this.installFlags);
            indentingPrintWriter.printPair("installLocation", Integer.valueOf(this.installLocation));
            indentingPrintWriter.printPair("sizeBytes", Long.valueOf(this.sizeBytes));
            indentingPrintWriter.printPair("appPackageName", this.appPackageName);
            indentingPrintWriter.printPair("appIcon", Boolean.valueOf(this.appIcon != null));
            indentingPrintWriter.printPair("appLabel", this.appLabel);
            indentingPrintWriter.printPair("originatingUri", this.originatingUri);
            indentingPrintWriter.printPair("referrerUri", this.referrerUri);
            indentingPrintWriter.printPair("abiOverride", this.abiOverride);
            indentingPrintWriter.println();
        }

        public void setAppIcon(Bitmap bitmap) {
            this.appIcon = bitmap;
        }

        public void setAppLabel(CharSequence charSequence) {
            this.appLabel = charSequence != null ? charSequence.toString() : null;
        }

        public void setAppPackageName(String str) {
            this.appPackageName = str;
        }

        public void setInstallFlagsExternal() {
            this.installFlags |= 8;
            this.installFlags &= -17;
        }

        public void setInstallFlagsInternal() {
            this.installFlags |= 16;
            this.installFlags &= -9;
        }

        public void setInstallLocation(int i) {
            this.installLocation = i;
        }

        public void setOriginatingUri(Uri uri) {
            this.originatingUri = uri;
        }

        public void setReferrerUri(Uri uri) {
            this.referrerUri = uri;
        }

        public void setSize(long j) {
            this.sizeBytes = j;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mode);
            parcel.writeInt(this.installFlags);
            parcel.writeInt(this.installLocation);
            parcel.writeLong(this.sizeBytes);
            parcel.writeString(this.appPackageName);
            parcel.writeParcelable(this.appIcon, i);
            parcel.writeString(this.appLabel);
            parcel.writeParcelable(this.originatingUri, i);
            parcel.writeParcelable(this.referrerUri, i);
            parcel.writeString(this.abiOverride);
        }
    }

    public PackageInstaller(Context context, PackageManager packageManager, IPackageInstaller iPackageInstaller, String str, int i) {
        this.mContext = context;
        this.mPm = packageManager;
        this.mInstaller = iPackageInstaller;
        this.mInstallerPackageName = str;
        this.mUserId = i;
    }

    public void abandonSession(int i) {
        try {
            this.mInstaller.abandonSession(i);
        } catch (RemoteException e) {
            throw e.rethrowAsRuntimeException();
        }
    }

    @Deprecated
    public void addSessionCallback(SessionCallback sessionCallback) {
        registerSessionCallback(sessionCallback);
    }

    @Deprecated
    public void addSessionCallback(SessionCallback sessionCallback, Handler handler) {
        registerSessionCallback(sessionCallback, handler);
    }

    public int createSession(SessionParams sessionParams) throws IOException {
        try {
            return this.mInstaller.createSession(sessionParams, this.mInstallerPackageName, this.mUserId);
        } catch (RemoteException e) {
            throw e.rethrowAsRuntimeException();
        } catch (RuntimeException e2) {
            ExceptionUtils.maybeUnwrapIOException(e2);
            throw e2;
        }
    }

    public List<SessionInfo> getAllSessions() {
        ApplicationInfo applicationInfo = this.mContext.getApplicationInfo();
        if ("com.google.android.googlequicksearchbox".equals(applicationInfo.packageName) && applicationInfo.versionCode <= 300400110) {
            Log.d(TAG, "Ignoring callback request from old prebuilt");
            return Collections.EMPTY_LIST;
        }
        try {
            return this.mInstaller.getAllSessions(this.mUserId).getList();
        } catch (RemoteException e) {
            throw e.rethrowAsRuntimeException();
        }
    }

    public List<SessionInfo> getMySessions() {
        try {
            return this.mInstaller.getMySessions(this.mInstallerPackageName, this.mUserId).getList();
        } catch (RemoteException e) {
            throw e.rethrowAsRuntimeException();
        }
    }

    public SessionInfo getSessionInfo(int i) {
        try {
            return this.mInstaller.getSessionInfo(i);
        } catch (RemoteException e) {
            throw e.rethrowAsRuntimeException();
        }
    }

    public Session openSession(int i) throws IOException {
        try {
            return new Session(this.mInstaller.openSession(i));
        } catch (RemoteException e) {
            throw e.rethrowAsRuntimeException();
        } catch (RuntimeException e2) {
            ExceptionUtils.maybeUnwrapIOException(e2);
            throw e2;
        }
    }

    public void registerSessionCallback(SessionCallback sessionCallback) {
        registerSessionCallback(sessionCallback, new Handler());
    }

    public void registerSessionCallback(SessionCallback sessionCallback, Handler handler) {
        ApplicationInfo applicationInfo = this.mContext.getApplicationInfo();
        if ("com.google.android.googlequicksearchbox".equals(applicationInfo.packageName) && applicationInfo.versionCode <= 300400110) {
            Log.d(TAG, "Ignoring callback request from old prebuilt");
            return;
        }
        synchronized (this.mDelegates) {
            SessionCallbackDelegate sessionCallbackDelegate = new SessionCallbackDelegate(sessionCallback, handler.getLooper());
            try {
                this.mInstaller.registerCallback(sessionCallbackDelegate, this.mUserId);
                this.mDelegates.add(sessionCallbackDelegate);
            } catch (RemoteException e) {
                throw e.rethrowAsRuntimeException();
            }
        }
    }

    @Deprecated
    public void removeSessionCallback(SessionCallback sessionCallback) {
        unregisterSessionCallback(sessionCallback);
    }

    public void setPermissionsResult(int i, boolean z) {
        try {
            this.mInstaller.setPermissionsResult(i, z);
        } catch (RemoteException e) {
            throw e.rethrowAsRuntimeException();
        }
    }

    public void uninstall(String str, IntentSender intentSender) {
        try {
            this.mInstaller.uninstall(str, 0, intentSender, this.mUserId);
        } catch (RemoteException e) {
            throw e.rethrowAsRuntimeException();
        }
    }

    public void unregisterSessionCallback(SessionCallback sessionCallback) {
        synchronized (this.mDelegates) {
            Iterator<SessionCallbackDelegate> it = this.mDelegates.iterator();
            while (it.hasNext()) {
                SessionCallbackDelegate next = it.next();
                if (next.mCallback == sessionCallback) {
                    try {
                        this.mInstaller.unregisterCallback(next);
                        it.remove();
                    } catch (RemoteException e) {
                        throw e.rethrowAsRuntimeException();
                    }
                }
            }
        }
    }

    public void updateSessionAppIcon(int i, Bitmap bitmap) {
        try {
            this.mInstaller.updateSessionAppIcon(i, bitmap);
        } catch (RemoteException e) {
            throw e.rethrowAsRuntimeException();
        }
    }

    public void updateSessionAppLabel(int i, CharSequence charSequence) {
        String charSequence2;
        if (charSequence != null) {
            try {
                charSequence2 = charSequence.toString();
            } catch (RemoteException e) {
                throw e.rethrowAsRuntimeException();
            }
        } else {
            charSequence2 = null;
        }
        this.mInstaller.updateSessionAppLabel(i, charSequence2);
    }
}
