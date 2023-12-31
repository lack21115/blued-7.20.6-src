package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.availableupdate.a;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/adapter/ui/UpdateAdapter.class */
public class UpdateAdapter implements IBridgeActivityDelegate {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Activity> f8823a;
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public int f8824c;
    public UpdateBean d;
    public boolean e = false;

    public static Object invokeMethod(String str, String str2, Object[] objArr) {
        Class<?>[] clsArr = new Class[objArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                try {
                    Class<?> cls = Class.forName(str);
                    return cls.getMethod(str2, clsArr).invoke(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), objArr);
                } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                    HMSLog.e("UpdateAdapter", "invoke " + str + "." + str2 + " fail. " + e.getMessage());
                    return null;
                }
            }
            if (objArr[i2] instanceof Activity) {
                clsArr[i2] = Activity.class;
            } else if (objArr[i2] instanceof Context) {
                clsArr[i2] = Context.class;
            } else if (objArr[i2] instanceof UpdateBean) {
                clsArr[i2] = UpdateBean.class;
            } else if (objArr[i2] instanceof Integer) {
                clsArr[i2] = Integer.TYPE;
            } else if (objArr[i2] instanceof Boolean) {
                clsArr[i2] = Boolean.TYPE;
            } else {
                HMSLog.e("UpdateAdapter", "not set args[" + i2 + "] type");
            }
            i = i2 + 1;
        }
    }

    public final void a() {
        Activity b = b();
        if (b == null || b.isFinishing()) {
            return;
        }
        b.finish();
    }

    public final void a(Intent intent) {
        int intExtra = intent.getIntExtra(BridgeActivity.EXTRA_RESULT, -1);
        if (intExtra == 0) {
            HMSLog.i("UpdateAdapter", "Error resolved successfully!");
            SystemManager.getInstance().notifyUpdateResult(0);
        } else if (intExtra == 13) {
            HMSLog.i("UpdateAdapter", "Resolve error process canceled by user!");
            SystemManager.getInstance().notifyUpdateResult(13);
        } else if (intExtra == 8) {
            HMSLog.i("UpdateAdapter", "Internal error occurred, recommended retry.");
            SystemManager.getInstance().notifyUpdateResult(8);
        } else {
            HMSLog.i("UpdateAdapter", "Other error codes.");
            SystemManager.getInstance().notifyUpdateResult(intExtra);
        }
    }

    public final boolean a(Context context, String str, int i) {
        boolean z = false;
        if (context != null) {
            z = false;
            if (!TextUtils.isEmpty(str)) {
                if (i == 0) {
                    return false;
                }
                PackageManagerHelper packageManagerHelper = new PackageManagerHelper(context);
                if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(packageManagerHelper.getPackageStates(str))) {
                    return true;
                }
                z = false;
                if (packageManagerHelper.getPackageVersionCode(str) < i) {
                    z = true;
                }
            }
        }
        return z;
    }

    public final boolean a(Intent intent, Activity activity) {
        if (intent.getBooleanExtra(CommonCode.MapKey.NEW_UPDATE, false)) {
            HMSLog.i("UpdateAdapter", "4.0 framework HMSCore upgrade process");
            String hMSPackageName = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
            ComponentName componentName = new ComponentName(hMSPackageName, "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
            Intent intent2 = new Intent();
            intent2.putExtra(KpmsConstant.CALLER_PACKAGE_NAME, activity.getApplicationContext().getPackageName());
            intent2.putExtra(KpmsConstant.UPDATE_PACKAGE_NAME, hMSPackageName);
            intent2.setComponent(componentName);
            activity.startActivityForResult(intent2, 1001);
            return true;
        }
        return false;
    }

    public final Activity b() {
        WeakReference<Activity> weakReference = this.f8823a;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public final void c() {
        SystemManager.getInstance().notifyUpdateResult(8);
        a();
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 1001;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity activity) {
        if (activity == null) {
            HMSLog.i("UpdateAdapter", "activity == null");
            c();
            return;
        }
        this.b = activity.getApplicationContext();
        this.f8823a = new WeakReference<>(activity);
        if (a.b.a(b())) {
            Intent intent = activity.getIntent();
            if (intent == null) {
                c();
                return;
            }
            int intExtra = intent.getIntExtra("update_version", 0);
            this.f8824c = intExtra;
            if (intExtra == 0) {
                c();
                return;
            }
            if (intent.hasExtra("installHMS")) {
                this.e = true;
            }
            if (!a(intent, activity) && AvailableUtil.isInstallerLibExist(this.b)) {
                UpdateBean updateBean = (UpdateBean) invokeMethod("com.huawei.hms.adapter.ui.InstallerAdapter", "setUpdateBean", new Object[]{activity, Integer.valueOf(this.f8824c), Boolean.valueOf(this.e)});
                this.d = updateBean;
                invokeMethod("com.huawei.hms.adapter.ui.InstallerAdapter", "startUpdateHms", new Object[]{activity, updateBean, 1001});
                this.d = null;
            }
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        HMSLog.i("UpdateAdapter", "onBridgeActivityDestroy");
        a.b.b(b());
        this.f8823a = null;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int i, int i2, Intent intent) {
        if (i != getRequestCode()) {
            this.d = null;
            return false;
        }
        HMSLog.i("UpdateAdapter", "onBridgeActivityResult " + i2);
        if (AvailableUtil.isInstallerLibExist(this.b) && i2 == 1214) {
            HMSLog.i("UpdateAdapter", "Enter update escape route");
            Activity b = b();
            if (b == null) {
                HMSLog.e("UpdateAdapter", "bridgeActivity is null, update escape failed ");
                this.d = null;
                return true;
            }
            invokeMethod("com.huawei.hms.update.manager.UpdateManager", "startUpdate", new Object[]{b, 1001, this.d});
            this.d = null;
        }
        if (i2 == -1) {
            if (intent != null) {
                if (intent.getIntExtra(KpmsConstant.KIT_UPDATE_RESULT, 0) == 1) {
                    HMSLog.i("UpdateAdapter", "new framework update process,Error resolved successfully!");
                    SystemManager.getInstance().notifyUpdateResult(0);
                    this.d = null;
                    a();
                    return true;
                }
                a(intent);
            }
        } else if (i2 == 0) {
            HMSLog.i("UpdateAdapter", "Activity.RESULT_CANCELED");
            this.d = null;
            Activity b2 = b();
            if (b2 == null) {
                return true;
            }
            String hMSPackageName = HMSPackageManager.getInstance(b2.getApplicationContext()).getHMSPackageName();
            if (this.e || a(b2, hMSPackageName, this.f8824c)) {
                HMSLog.i("UpdateAdapter", "Resolve error, process canceled by user clicking back button!");
                SystemManager.getInstance().notifyUpdateResult(13);
            } else {
                SystemManager.getInstance().notifyUpdateResult(0);
            }
        } else if (i2 == 1) {
            SystemManager.getInstance().notifyUpdateResult(28);
        }
        a();
        return true;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
        HMSLog.i("UpdateAdapter", "onBridgeConfigurationChanged");
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int i, KeyEvent keyEvent) {
        HMSLog.i("UpdateAdapter", "On key up when resolve conn error");
    }
}
