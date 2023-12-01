package com.huawei.hms.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.NotInstalledHmsAdapter;
import com.huawei.hms.adapter.ui.UpdateAdapter;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.note.AppSpoofResolution;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/adapter/AvailableAdapter.class */
public class AvailableAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final int f8801a;
    public AvailableCallBack b;
    public SystemObserver d = new a();

    /* renamed from: c  reason: collision with root package name */
    public boolean f8802c = false;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/adapter/AvailableAdapter$AvailableCallBack.class */
    public interface AvailableCallBack {
        void onComplete(int i);
    }

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/adapter/AvailableAdapter$a.class */
    public class a implements SystemObserver {
        public a() {
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onNoticeResult(int i) {
            AvailableCallBack a2 = AvailableAdapter.this.a();
            if (a2 == null) {
                HMSLog.e("AvailableAdapter", "onNoticeResult baseCallBack null");
                return true;
            }
            a2.onComplete(i);
            return true;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onSolutionResult(Intent intent, String str) {
            return false;
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemObserver
        public boolean onUpdateResult(int i) {
            AvailableCallBack a2 = AvailableAdapter.this.a();
            if (a2 == null) {
                HMSLog.e("AvailableAdapter", "onUpdateResult baseCallBack null");
                return true;
            }
            a2.onComplete(i);
            return true;
        }
    }

    public AvailableAdapter(int i) {
        this.f8801a = i;
    }

    public final int a(Context context) {
        if (Build.VERSION.SDK_INT < 16) {
            HMSLog.i("AvailableAdapter", "HMS can not be supported under android 4.1");
            return 21;
        } else if (HMSPackageManager.getInstance(context).isUseOldCertificate()) {
            HMSLog.e("AvailableAdapter", "The CP uses the old certificate to terminate the connection.");
            return 13;
        } else {
            PackageManagerHelper.PackageStates hMSPackageStatesForMultiService = HMSPackageManager.getInstance(context).getHMSPackageStatesForMultiService();
            if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(hMSPackageStatesForMultiService)) {
                HMSLog.i("AvailableAdapter", "HMS is not installed");
                return 1;
            } else if (PackageManagerHelper.PackageStates.SPOOF.equals(hMSPackageStatesForMultiService)) {
                HMSLog.i("AvailableAdapter", "HMS is spoofed");
                return 29;
            } else if (PackageManagerHelper.PackageStates.DISABLED.equals(hMSPackageStatesForMultiService)) {
                HMSLog.i("AvailableAdapter", "HMS is disabled");
                return 3;
            } else {
                return 0;
            }
        }
    }

    public final AvailableCallBack a() {
        return this.b;
    }

    public final void a(Activity activity, AvailableCallBack availableCallBack) {
        HMSLog.i("AvailableAdapter", "<showHmsApkNotInstalledDialog> startResolution");
        if (!NotInstalledHmsAdapter.getShowLock()) {
            availableCallBack.onComplete(31);
            return;
        }
        this.b = availableCallBack;
        SystemManager.getSystemNotifier().registerObserver(this.d);
        activity.startActivity(BridgeActivity.getIntentStartBridgeActivity(activity, NotInstalledHmsAdapter.class.getName()));
    }

    public final boolean a(Activity activity) {
        if (HMSPackageManager.getInstance(activity).getHmsVersionCode() >= 40000000) {
            HMSLog.i("AvailableAdapter", "enter 4.0 HmsCore upgrade process");
            return true;
        }
        return false;
    }

    public final void b(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    public int checkHuaweiMobileServicesForUpdate(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        int a2 = a(context);
        if (a2 != 0) {
            return a2;
        }
        if (HMSPackageManager.getInstance(context).isApkNeedUpdate(this.f8801a)) {
            HMSLog.i("AvailableAdapter", "The current version does not meet the target version requirements");
            a2 = 2;
        }
        return a2;
    }

    public int isHuaweiMobileServicesAvailable(Context context) {
        Checker.checkNonNull(context, "context must not be null.");
        int a2 = a(context);
        if (a2 != 0) {
            return a2;
        }
        if (HMSPackageManager.getInstance(context).isApkUpdateNecessary(this.f8801a)) {
            HMSLog.i("AvailableAdapter", "The current version does not meet the minimum version requirements");
            a2 = 2;
        }
        return a2;
    }

    public boolean isUserNoticeError(int i) {
        return i == 29;
    }

    public boolean isUserResolvableError(int i) {
        return i == 1 || i == 2;
    }

    public void setCalledBySolutionInstallHms(boolean z) {
        this.f8802c = z;
    }

    public void startNotice(Activity activity, AvailableCallBack availableCallBack) {
        if (activity == null || availableCallBack == null) {
            return;
        }
        if (UIUtil.isBackground(activity)) {
            HMSLog.i("AvailableAdapter", "current app is in Background");
            availableCallBack.onComplete(28);
            return;
        }
        HMSLog.i("AvailableAdapter", "startNotice");
        this.b = availableCallBack;
        SystemManager.getSystemNotifier().registerObserver(this.d);
        activity.startActivity(BridgeActivity.getIntentStartBridgeActivity(activity, AppSpoofResolution.class.getName()));
    }

    public void startResolution(Activity activity, AvailableCallBack availableCallBack) {
        if (activity == null || availableCallBack == null) {
            return;
        }
        b(activity);
        if (UIUtil.isBackground(activity)) {
            HMSLog.i("AvailableAdapter", "current app is in Background");
            availableCallBack.onComplete(28);
            return;
        }
        boolean a2 = a(activity);
        if (!AvailableUtil.isInstallerLibExist(activity) && !a2) {
            a(activity, availableCallBack);
            return;
        }
        HMSLog.i("AvailableAdapter", "startResolution");
        this.b = availableCallBack;
        SystemManager.getSystemNotifier().registerObserver(this.d);
        Intent intentStartBridgeActivity = BridgeActivity.getIntentStartBridgeActivity(activity, UpdateAdapter.class.getName());
        intentStartBridgeActivity.putExtra("update_version", this.f8801a);
        if (this.f8802c) {
            intentStartBridgeActivity.putExtra("installHMS", "installHMS");
        }
        intentStartBridgeActivity.putExtra(CommonCode.MapKey.NEW_UPDATE, a2);
        activity.startActivity(intentStartBridgeActivity);
    }
}
