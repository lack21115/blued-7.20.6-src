package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.libwebp;
import com.tencent.smtt.utils.TbsLog;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/u.class */
public class u {

    /* renamed from: a  reason: collision with root package name */
    private Context f38887a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f38888c;
    private String[] d;
    private DexLoader e;
    private String f;
    private String g = null;

    public u(Context context, Context context2, String str, String str2, String[] strArr, String str3) throws Exception {
        boolean z;
        boolean z2;
        this.f38887a = null;
        this.b = null;
        this.f38888c = null;
        this.d = null;
        this.e = null;
        this.f = "TbsDexOpt";
        TbsLog.i("TbsWizard", "construction start...");
        if (context == null || ((context2 == null && TbsShareManager.getHostCorePathAppDefined() == null) || TextUtils.isEmpty(str) || strArr == null || strArr.length == 0)) {
            throw new Exception("TbsWizard paramter error:-1callerContext:" + context + "hostcontext" + context2 + "isEmpty" + TextUtils.isEmpty(str) + "dexfileList" + strArr);
        }
        this.f38887a = context.getApplicationContext();
        if (context2.getApplicationContext() != null) {
            this.b = context2.getApplicationContext();
        } else {
            this.b = context2;
        }
        this.f38888c = str;
        this.d = strArr;
        this.f = str2;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.length) {
                break;
            }
            TbsLog.i("TbsWizard", "#2 mDexFileList[" + i2 + "]: " + this.d[i2]);
            i = i2 + 1;
        }
        TbsLog.i("TbsWizard", "new DexLoader #2 libraryPath is " + str3 + " mCallerAppContext is " + this.f38887a + " dexOutPutDir is " + str2);
        this.e = new DexLoader(str3, this.f38887a, this.d, str2, QbSdk.n);
        System.currentTimeMillis();
        a(context);
        libwebp.loadWepLibraryIfNeed(context2, this.f38888c);
        if ("com.nd.android.pandahome2".equals(this.f38887a.getApplicationInfo().packageName)) {
            this.e.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new Class[]{Context.class}, this.f38887a);
        }
        if (QbSdk.n != null) {
            try {
                z = TbsPVConfig.getInstance(this.f38887a).getTbsCoreSandboxModeEnable();
            } catch (Throwable th) {
                z = false;
            }
            try {
                z2 = "true".equals(String.valueOf(QbSdk.n.get(TbsCoreSettings.TBS_SETTINGS_USE_SANDBOX)));
            } catch (Throwable th2) {
                th2.printStackTrace();
                z2 = false;
            }
            QbSdk.n.put(TbsCoreSettings.TBS_SETTINGS_USE_SANDBOX, Boolean.valueOf(z && z2));
            this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, QbSdk.n);
        }
        int b = b(context);
        if (b >= 0) {
            TbsLog.i("TbsWizard", "construction end...");
            return;
        }
        throw new Exception("TbsWizard init error: " + b + "; msg: " + this.g);
    }

    private int b(Context context) {
        Object invokeStaticMethod;
        int i;
        String str;
        Throwable th;
        if (this.b != null || TbsShareManager.getHostCorePathAppDefined() == null) {
            TbsLog.i("TbsWizard", "initTesRuntimeEnvironment callerContext is " + context + " mHostContext is " + this.b + " mDexLoader is " + this.e + " mtbsInstallLocation is " + this.f38888c + " mDexOptPath is " + this.f);
            invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class}, context, this.b, this.e, this.f38888c, this.f, TbsConfig.TBS_SDK_VERSIONNAME, 43967, QbSdk.a());
        } else {
            invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class, String.class, Integer.TYPE, String.class, String.class}, context, this.b, this.e, this.f38888c, this.f, TbsConfig.TBS_SDK_VERSIONNAME, 43967, QbSdk.a(), TbsShareManager.getHostCorePathAppDefined());
        }
        Object obj = invokeStaticMethod;
        if (invokeStaticMethod == null) {
            c();
            d();
            DexLoader dexLoader = this.e;
            obj = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new Class[]{Context.class, Context.class, DexLoader.class, String.class, String.class}, context, this.b, dexLoader, this.f38888c, this.f);
        }
        if (obj == null) {
            i = -3;
        } else if (obj instanceof Integer) {
            i = ((Integer) obj).intValue();
        } else if (obj instanceof Throwable) {
            TbsCoreLoadStat.getInstance().a(this.f38887a, 328, (Throwable) obj);
            i = -5;
        } else {
            i = -4;
        }
        if (i < 0) {
            Object invokeStaticMethod2 = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
            if (invokeStaticMethod2 instanceof Throwable) {
                this.g = "#" + th.getMessage() + "; cause: " + th.getCause() + "; th: " + ((Throwable) invokeStaticMethod2);
            }
            if (invokeStaticMethod2 instanceof String) {
                str = (String) invokeStaticMethod2;
            }
            return i;
        }
        str = null;
        this.g = str;
        return i;
    }

    private void c() {
        this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new Class[]{String.class}, TbsConfig.TBS_SDK_VERSIONNAME);
    }

    private void d() {
        this.e.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", 43967);
    }

    public String a() {
        String str = null;
        Object invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new Class[]{Boolean.TYPE, String.class, String.class, Class[].class, Object[].class}, true, "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        Object obj = invokeStaticMethod;
        if (invokeStaticMethod == null) {
            obj = this.e.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new Object[0]);
        }
        if (obj != null) {
            str = String.valueOf(obj) + " ReaderPackName=" + TbsReaderView.gReaderPackName + " ReaderPackVersion=" + TbsReaderView.gReaderPackVersion;
        }
        String str2 = str;
        if (str == null) {
            str2 = "X5 core get nothing...";
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(android.content.Context r4) {
        /*
            r3 = this;
            java.util.Map<java.lang.String, java.lang.Object> r0 = com.tencent.smtt.sdk.QbSdk.n
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L24
            r0 = r6
            java.lang.String r1 = "check_tbs_validity"
            java.lang.Object r0 = r0.get(r1)
            r6 = r0
            r0 = r6
            boolean r0 = r0 instanceof java.lang.Boolean
            if (r0 == 0) goto L24
            r0 = r6
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r5 = r0
            goto L26
        L24:
            r0 = 1
            r5 = r0
        L26:
            r0 = r5
            if (r0 == 0) goto L2f
            r0 = r4
            boolean r0 = com.tencent.smtt.utils.l.b(r0)
        L2f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.u.a(android.content.Context):void");
    }

    public void a(Context context, Context context2, String str, String str2, String[] strArr, String str3) throws Exception {
        this.f38887a = context.getApplicationContext();
        if (this.b.getApplicationContext() != null) {
            this.b = this.b.getApplicationContext();
        }
        this.f38888c = str;
        this.d = strArr;
        this.f = str2;
        libwebp.loadWepLibraryIfNeed(context2, str);
        if (QbSdk.n != null) {
            this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new Class[]{Map.class}, QbSdk.n);
        }
        int b = b(context);
        if (b >= 0) {
            return;
        }
        throw new Exception("continueInit init error: " + b + "; msg: " + this.g);
    }

    public boolean a(Context context, String str, String str2, Bundle bundle) {
        Object invokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new Class[]{Context.class, String.class, String.class, Bundle.class}, context, str, str2, bundle);
        if (invokeStaticMethod == null) {
            return false;
        }
        return ((Boolean) invokeStaticMethod).booleanValue();
    }

    public DexLoader b() {
        return this.e;
    }
}
