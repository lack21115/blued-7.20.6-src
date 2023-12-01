package com.android.internal.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.util.Slog;
import com.android.internal.os.BackgroundThread;
import java.util.HashSet;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/content/PackageMonitor.class */
public abstract class PackageMonitor extends BroadcastReceiver {
    public static final int PACKAGE_PERMANENT_CHANGE = 3;
    public static final int PACKAGE_TEMPORARY_CHANGE = 2;
    public static final int PACKAGE_UNCHANGED = 0;
    public static final int PACKAGE_UPDATING = 1;
    String[] mAppearingPackages;
    int mChangeType;
    String[] mDisappearingPackages;
    String[] mModifiedPackages;
    Context mRegisteredContext;
    Handler mRegisteredHandler;
    boolean mSomePackagesChanged;
    static final IntentFilter sPackageFilt = new IntentFilter();
    static final IntentFilter sNonDataFilt = new IntentFilter();
    static final IntentFilter sExternalFilt = new IntentFilter();
    final HashSet<String> mUpdatingPackages = new HashSet<>();
    int mChangeUserId = -10000;
    String[] mTempArray = new String[1];

    static {
        sPackageFilt.addAction(Intent.ACTION_PACKAGE_ADDED);
        sPackageFilt.addAction(Intent.ACTION_PACKAGE_REMOVED);
        sPackageFilt.addAction(Intent.ACTION_PACKAGE_CHANGED);
        sPackageFilt.addAction(Intent.ACTION_QUERY_PACKAGE_RESTART);
        sPackageFilt.addAction(Intent.ACTION_PACKAGE_RESTARTED);
        sPackageFilt.addAction(Intent.ACTION_UID_REMOVED);
        sPackageFilt.addDataScheme("package");
        sNonDataFilt.addAction(Intent.ACTION_UID_REMOVED);
        sNonDataFilt.addAction(Intent.ACTION_USER_STOPPED);
        sExternalFilt.addAction(Intent.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE);
        sExternalFilt.addAction(Intent.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE);
    }

    public boolean anyPackagesAppearing() {
        return this.mAppearingPackages != null;
    }

    public boolean anyPackagesDisappearing() {
        return this.mDisappearingPackages != null;
    }

    public boolean didSomePackagesChange() {
        return this.mSomePackagesChanged;
    }

    public int getChangingUserId() {
        return this.mChangeUserId;
    }

    String getPackageName(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            return data.getSchemeSpecificPart();
        }
        return null;
    }

    public Handler getRegisteredHandler() {
        return this.mRegisteredHandler;
    }

    public int isPackageAppearing(String str) {
        if (this.mAppearingPackages == null) {
            return 0;
        }
        int length = this.mAppearingPackages.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return 0;
            }
            if (str.equals(this.mAppearingPackages[i])) {
                return this.mChangeType;
            }
            length = i;
        }
    }

    public int isPackageDisappearing(String str) {
        if (this.mDisappearingPackages == null) {
            return 0;
        }
        int length = this.mDisappearingPackages.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return 0;
            }
            if (str.equals(this.mDisappearingPackages[i])) {
                return this.mChangeType;
            }
            length = i;
        }
    }

    public boolean isPackageModified(String str) {
        if (this.mModifiedPackages == null) {
            return false;
        }
        int length = this.mModifiedPackages.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return false;
            }
            if (str.equals(this.mModifiedPackages[i])) {
                return true;
            }
            length = i;
        }
    }

    boolean isPackageUpdating(String str) {
        boolean contains;
        synchronized (this.mUpdatingPackages) {
            contains = this.mUpdatingPackages.contains(str);
        }
        return contains;
    }

    public boolean isReplacing() {
        return this.mChangeType == 1;
    }

    public void onBeginPackageChanges() {
    }

    public void onFinishPackageChanges() {
    }

    public boolean onHandleForceStop(Intent intent, String[] strArr, int i, boolean z) {
        return false;
    }

    public void onHandleUserStop(Intent intent, int i) {
    }

    public void onPackageAdded(String str, int i) {
    }

    public void onPackageAppeared(String str, int i) {
    }

    public boolean onPackageChanged(String str, int i, String[] strArr) {
        if (strArr == null) {
            return false;
        }
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            if (str.equals(strArr[i3])) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    public void onPackageDisappeared(String str, int i) {
    }

    public void onPackageModified(String str) {
    }

    public void onPackageRemoved(String str, int i) {
    }

    public void onPackageRemovedAllUsers(String str, int i) {
    }

    public void onPackageUpdateFinished(String str, int i) {
    }

    public void onPackageUpdateStarted(String str, int i) {
    }

    public void onPackagesAvailable(String[] strArr) {
    }

    public void onPackagesUnavailable(String[] strArr) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        int i = 2;
        this.mChangeUserId = intent.getIntExtra(Intent.EXTRA_USER_HANDLE, -10000);
        if (this.mChangeUserId == -10000) {
            Slog.w("PackageMonitor", "Intent broadcast does not contain user handle: " + intent);
            return;
        }
        onBeginPackageChanges();
        this.mAppearingPackages = null;
        this.mDisappearingPackages = null;
        this.mSomePackagesChanged = false;
        String action = intent.getAction();
        if (Intent.ACTION_PACKAGE_ADDED.equals(action)) {
            String packageName = getPackageName(intent);
            int intExtra = intent.getIntExtra(Intent.EXTRA_UID, 0);
            this.mSomePackagesChanged = true;
            if (packageName != null) {
                this.mAppearingPackages = this.mTempArray;
                this.mTempArray[0] = packageName;
                if (intent.getBooleanExtra(Intent.EXTRA_REPLACING, false)) {
                    this.mModifiedPackages = this.mTempArray;
                    this.mChangeType = 1;
                    onPackageUpdateFinished(packageName, intExtra);
                    onPackageModified(packageName);
                } else {
                    this.mChangeType = 3;
                    onPackageAdded(packageName, intExtra);
                }
                onPackageAppeared(packageName, this.mChangeType);
                if (this.mChangeType == 1) {
                    synchronized (this.mUpdatingPackages) {
                        this.mUpdatingPackages.remove(packageName);
                    }
                }
            }
        } else if (Intent.ACTION_PACKAGE_REMOVED.equals(action)) {
            String packageName2 = getPackageName(intent);
            int intExtra2 = intent.getIntExtra(Intent.EXTRA_UID, 0);
            if (packageName2 != null) {
                this.mDisappearingPackages = this.mTempArray;
                this.mTempArray[0] = packageName2;
                if (intent.getBooleanExtra(Intent.EXTRA_REPLACING, false)) {
                    this.mChangeType = 1;
                    synchronized (this.mUpdatingPackages) {
                    }
                    onPackageUpdateStarted(packageName2, intExtra2);
                } else {
                    this.mChangeType = 3;
                    this.mSomePackagesChanged = true;
                    onPackageRemoved(packageName2, intExtra2);
                    if (intent.getBooleanExtra(Intent.EXTRA_REMOVED_FOR_ALL_USERS, false)) {
                        onPackageRemovedAllUsers(packageName2, intExtra2);
                    }
                }
                onPackageDisappeared(packageName2, this.mChangeType);
            }
        } else if (Intent.ACTION_PACKAGE_CHANGED.equals(action)) {
            String packageName3 = getPackageName(intent);
            int intExtra3 = intent.getIntExtra(Intent.EXTRA_UID, 0);
            String[] stringArrayExtra = intent.getStringArrayExtra(Intent.EXTRA_CHANGED_COMPONENT_NAME_LIST);
            if (packageName3 != null) {
                this.mModifiedPackages = this.mTempArray;
                this.mTempArray[0] = packageName3;
                this.mChangeType = 3;
                if (onPackageChanged(packageName3, intExtra3, stringArrayExtra)) {
                    this.mSomePackagesChanged = true;
                }
                onPackageModified(packageName3);
            }
        } else if (Intent.ACTION_QUERY_PACKAGE_RESTART.equals(action)) {
            this.mDisappearingPackages = intent.getStringArrayExtra(Intent.EXTRA_PACKAGES);
            this.mChangeType = 2;
            if (onHandleForceStop(intent, this.mDisappearingPackages, intent.getIntExtra(Intent.EXTRA_UID, 0), false)) {
                setResultCode(-1);
            }
        } else if (Intent.ACTION_PACKAGE_RESTARTED.equals(action)) {
            this.mDisappearingPackages = new String[]{getPackageName(intent)};
            this.mChangeType = 2;
            onHandleForceStop(intent, this.mDisappearingPackages, intent.getIntExtra(Intent.EXTRA_UID, 0), true);
        } else if (Intent.ACTION_UID_REMOVED.equals(action)) {
            onUidRemoved(intent.getIntExtra(Intent.EXTRA_UID, 0));
        } else if (Intent.ACTION_USER_STOPPED.equals(action)) {
            if (intent.hasExtra(Intent.EXTRA_USER_HANDLE)) {
                onHandleUserStop(intent, intent.getIntExtra(Intent.EXTRA_USER_HANDLE, 0));
            }
        } else if (Intent.ACTION_EXTERNAL_APPLICATIONS_AVAILABLE.equals(action)) {
            String[] stringArrayExtra2 = intent.getStringArrayExtra(Intent.EXTRA_CHANGED_PACKAGE_LIST);
            this.mAppearingPackages = stringArrayExtra2;
            if (intent.getBooleanExtra(Intent.EXTRA_REPLACING, false)) {
                i = 1;
            }
            this.mChangeType = i;
            this.mSomePackagesChanged = true;
            if (stringArrayExtra2 != null) {
                onPackagesAvailable(stringArrayExtra2);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= stringArrayExtra2.length) {
                        break;
                    }
                    onPackageAppeared(stringArrayExtra2[i3], this.mChangeType);
                    i2 = i3 + 1;
                }
            }
        } else if (Intent.ACTION_EXTERNAL_APPLICATIONS_UNAVAILABLE.equals(action)) {
            String[] stringArrayExtra3 = intent.getStringArrayExtra(Intent.EXTRA_CHANGED_PACKAGE_LIST);
            this.mDisappearingPackages = stringArrayExtra3;
            if (intent.getBooleanExtra(Intent.EXTRA_REPLACING, false)) {
                i = 1;
            }
            this.mChangeType = i;
            this.mSomePackagesChanged = true;
            if (stringArrayExtra3 != null) {
                onPackagesUnavailable(stringArrayExtra3);
                int i4 = 0;
                while (true) {
                    int i5 = i4;
                    if (i5 >= stringArrayExtra3.length) {
                        break;
                    }
                    onPackageDisappeared(stringArrayExtra3[i5], this.mChangeType);
                    i4 = i5 + 1;
                }
            }
        }
        if (this.mSomePackagesChanged) {
            onSomePackagesChanged();
        }
        onFinishPackageChanges();
        this.mChangeUserId = -10000;
    }

    public void onSomePackagesChanged() {
    }

    public void onUidRemoved(int i) {
    }

    public void register(Context context, Looper looper, UserHandle userHandle, boolean z) {
        if (this.mRegisteredContext != null) {
            throw new IllegalStateException("Already registered");
        }
        this.mRegisteredContext = context;
        if (looper == null) {
            this.mRegisteredHandler = BackgroundThread.getHandler();
        } else {
            this.mRegisteredHandler = new Handler(looper);
        }
        if (userHandle != null) {
            context.registerReceiverAsUser(this, userHandle, sPackageFilt, null, this.mRegisteredHandler);
            context.registerReceiverAsUser(this, userHandle, sNonDataFilt, null, this.mRegisteredHandler);
            if (z) {
                context.registerReceiverAsUser(this, userHandle, sExternalFilt, null, this.mRegisteredHandler);
                return;
            }
            return;
        }
        context.registerReceiver(this, sPackageFilt, null, this.mRegisteredHandler);
        context.registerReceiver(this, sNonDataFilt, null, this.mRegisteredHandler);
        if (z) {
            context.registerReceiver(this, sExternalFilt, null, this.mRegisteredHandler);
        }
    }

    public void register(Context context, Looper looper, boolean z) {
        register(context, looper, null, z);
    }

    public void unregister() {
        if (this.mRegisteredContext == null) {
            throw new IllegalStateException("Not registered");
        }
        this.mRegisteredContext.unregisterReceiver(this);
        this.mRegisteredContext = null;
    }
}
