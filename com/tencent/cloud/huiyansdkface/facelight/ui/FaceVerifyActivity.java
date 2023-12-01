package com.tencent.cloud.huiyansdkface.facelight.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import com.tencent.cloud.huiyansdkface.R;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceVerifyResult;
import com.tencent.cloud.huiyansdkface.facelight.c.c.c;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.facelight.provider.PermissionInfo;
import com.tencent.cloud.huiyansdkface.facelight.provider.WbFaceModeProviders;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.a;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/FaceVerifyActivity.class */
public class FaceVerifyActivity extends com.tencent.cloud.huiyansdkface.facelight.ui.a.a {
    private static Map<a, Class<?>> j;
    private static int k;

    /* renamed from: a  reason: collision with root package name */
    private Activity f21988a;
    private com.tencent.cloud.huiyansdkface.facelight.ui.widget.a b;

    /* renamed from: c  reason: collision with root package name */
    private com.tencent.cloud.huiyansdkface.facelight.ui.widget.a f21989c;
    private RelativeLayout d;
    private TextView e;
    private TextView f;
    private boolean g;
    private boolean h;
    private d i;
    private PermissionInfo l;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/FaceVerifyActivity$a.class */
    public enum a {
        FaceLiveFragment
    }

    static {
        HashMap hashMap = new HashMap();
        j = hashMap;
        hashMap.put(a.FaceLiveFragment, com.tencent.cloud.huiyansdkface.facelight.ui.b.a.class);
    }

    private void a(a.InterfaceC0746a interfaceC0746a, PermissionInfo.PermissionTip permissionTip) {
        WLogger.d("FaceVerifyActivity", "showPermissionConfirmDialog");
        if (this.b == null) {
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.a d = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.a(this.f21988a).a(permissionTip.title).b(permissionTip.content).c(this.i.f().kyc_set_up).d(this.i.f().kyc_cancel);
            this.b = d;
            d.getWindow().setBackgroundDrawableResource(R.color.wbcf_translucent_background);
        }
        this.b.a(interfaceC0746a);
        if (isFinishing()) {
            return;
        }
        this.b.show();
        KycWaSDK.getInstance().trackCustomKVEvent(this, "camera_face_alert_show", null, null);
    }

    private void a(String[] strArr, int[] iArr) {
        final PermissionInfo.PermissionTip d = d(strArr, iArr);
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a d2 = new com.tencent.cloud.huiyansdkface.facelight.ui.widget.a(this.f21988a).a("设置").b("是否去设置页面申请权限").c("继续").d("取消");
        this.f21989c = d2;
        d2.getWindow().setBackgroundDrawableResource(R.color.wbcf_translucent_background);
        this.f21989c.a(new a.InterfaceC0746a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceVerifyActivity.1
            @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0746a
            public void a() {
                if (FaceVerifyActivity.this.b != null) {
                    FaceVerifyActivity.this.b.dismiss();
                }
                FaceVerifyActivity.this.g();
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0746a
            public void b() {
                if (FaceVerifyActivity.this.b != null) {
                    FaceVerifyActivity.this.b.dismiss();
                }
                FaceVerifyActivity.this.c(d.noPermissionTip);
            }
        });
        this.f21989c.show();
    }

    private boolean a(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (iArr[i2] != 0) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private int[] a(String[] strArr) {
        int[] iArr = new int[strArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return iArr;
            }
            iArr[i2] = b(strArr[i2]);
            i = i2 + 1;
        }
    }

    private int b(String str) {
        return Build.VERSION.SDK_INT >= 23 ? checkSelfPermission(str) : getPackageManager().checkPermission(str, getPackageName());
    }

    private void b() {
        setRequestedOrientation(this.i.x().Q() ? 0 : 1);
        int requestedOrientation = getRequestedOrientation();
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        WLogger.d("FaceVerifyActivity", "getActivityOrientation:" + requestedOrientation + ",screenRotation:" + rotation);
        KycWaSDK kycWaSDK = KycWaSDK.getInstance();
        kycWaSDK.trackCustomKVEvent(this, "faceservice_activity_create", "ori=" + requestedOrientation + ",rotation:" + rotation, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String[] strArr, int[] iArr) {
        WLogger.e("FaceVerifyActivity", "Didn't get all permission!");
        final PermissionInfo.PermissionTip d = d(strArr, iArr);
        if (this.g || this.h) {
            WLogger.d("FaceVerifyActivity", "reject,quit sdk");
            c(d.noPermissionTip);
            return;
        }
        WLogger.d("FaceVerifyActivity", "first reject,show confirm dialog");
        this.g = true;
        a(new a.InterfaceC0746a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceVerifyActivity.3
            @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0746a
            public void a() {
                WLogger.e("FaceVerifyActivity", "user try permission again!");
                if (FaceVerifyActivity.this.b != null) {
                    FaceVerifyActivity.this.b.dismiss();
                }
                FaceVerifyActivity.this.j();
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0746a
            public void b() {
                WLogger.e("FaceVerifyActivity", "user didnt open permissions!");
                if (FaceVerifyActivity.this.b != null) {
                    FaceVerifyActivity.this.b.dismiss();
                }
                FaceVerifyActivity.this.c(d.noPermissionTip);
            }
        }, d);
    }

    private void c() {
        String str;
        TextView textView;
        String g;
        this.d = (RelativeLayout) findViewById(R.id.wbcf_permission_tip_rl);
        this.e = (TextView) findViewById(R.id.wbcf_permission_tip);
        this.f = (TextView) findViewById(R.id.wbcf_permission_reason);
        if (WbFaceModeProviders.isUseWillSdk()) {
            this.e.setText(this.i.f().kyc_auth_tip_use_cam_mic);
            String z = this.i.x().z();
            str = z;
            if (TextUtils.isEmpty(z)) {
                textView = this.f;
                g = this.i.e().f();
                textView.setText(g);
                return;
            }
            this.f.setText(str);
        }
        this.e.setText(this.i.f().kyc_auth_tip_use_cam);
        String y = this.i.x().y();
        str = y;
        if (TextUtils.isEmpty(y)) {
            textView = this.f;
            g = this.i.e().g();
            textView.setText(g);
            return;
        }
        this.f.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        WLogger.d("FaceVerifyActivity", "askPermissionError");
        KycWaSDK.getInstance().trackCustomKVEvent(this.f21988a, "camera_auth_reject", null, null);
        this.i.e(true);
        if (this.i.y() != null) {
            WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
            wbFaceVerifyResult.setIsSuccess(false);
            wbFaceVerifyResult.setOrderNo(this.i.w());
            wbFaceVerifyResult.setSign(null);
            WbFaceError wbFaceError = new WbFaceError();
            wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
            wbFaceError.setCode(WbFaceError.WBFaceErrorCodeNoPermission);
            wbFaceError.setDesc("权限异常，未获取权限");
            wbFaceError.setReason(str);
            wbFaceVerifyResult.setError(wbFaceError);
            Properties properties = new Properties();
            properties.setProperty("errorDesc", wbFaceError.toString());
            this.i.a(this.f21988a, WbFaceError.WBFaceErrorCodeNoPermission, properties);
            this.i.y().onFinish(wbFaceVerifyResult);
        }
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar = this.b;
        if (aVar != null) {
            aVar.dismiss();
            this.b = null;
        }
        WLogger.d("FaceVerifyActivity", "finish activity");
        finish();
    }

    private boolean c(String[] strArr, int[] iArr) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                return false;
            }
            if (iArr[i2] != 0 && !shouldShowRequestPermissionRationale(strArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    private PermissionInfo.PermissionTip d(String[] strArr, int[] iArr) {
        String str;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= strArr.length) {
                str = "";
                break;
            } else if (iArr[i2] != 0) {
                str = strArr[i2];
                break;
            } else {
                i = i2 + 1;
            }
        }
        return e().getPermissionTip(str);
    }

    private boolean d(String str) {
        KycWaSDK kycWaSDK;
        Context applicationContext;
        String str2;
        String str3;
        if (this.i.t()) {
            return false;
        }
        WLogger.i("FaceVerifyActivity", str + "quit faceVerify");
        if (!d.z().c()) {
            kycWaSDK = KycWaSDK.getInstance();
            applicationContext = getApplicationContext();
            str2 = str + ", 应用被动离开前台";
            str3 = "facepage_exit_forced";
        } else if (d.z().d()) {
            kycWaSDK = KycWaSDK.getInstance();
            applicationContext = getApplicationContext();
            str2 = str + ", 应用被动离开前台";
            str3 = "willpage_answer_exit_forced";
        } else {
            kycWaSDK = KycWaSDK.getInstance();
            applicationContext = getApplicationContext();
            str2 = str + ", 应用被动离开前台";
            str3 = "willpage_exit_forced";
        }
        kycWaSDK.trackCustomKVEvent(applicationContext, str3, str2, null);
        this.i.e(true);
        if (this.i.y() != null) {
            WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
            wbFaceVerifyResult.setIsSuccess(false);
            wbFaceVerifyResult.setOrderNo(this.i.w());
            wbFaceVerifyResult.setSign(null);
            WbFaceError wbFaceError = new WbFaceError();
            wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
            wbFaceError.setCode(WbFaceError.WBFaceErrorCodeUserCancle);
            wbFaceError.setDesc("用户取消");
            wbFaceError.setReason("用户取消，回到后台activity," + str);
            wbFaceVerifyResult.setError(wbFaceError);
            Properties properties = new Properties();
            properties.setProperty("errorDesc", wbFaceError.toString());
            this.i.a(this.f21988a, WbFaceError.WBFaceErrorCodeUserCancle, properties);
            this.i.y().onFinish(wbFaceVerifyResult);
            return true;
        }
        return true;
    }

    private String[] d() {
        return e().getPermissionArray();
    }

    private PermissionInfo e() {
        if (this.l == null) {
            this.l = WbFaceModeProviders.faceMode().getPermissionList();
        }
        return this.l;
    }

    private boolean f() {
        String[] d = d();
        int length = d.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (shouldShowRequestPermissionRationale(d[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.fromParts("package", getApplicationContext().getPackageName(), null));
            if (getPackageManager().resolveActivity(intent, 0) != null) {
                startActivityForResult(intent, 1024);
            }
        } catch (Exception e) {
            e.printStackTrace();
            a(1024);
        }
    }

    private void h() {
        KycWaSDK.getInstance().trackCustomKVEvent(this, "camera_auth_agree", null, null);
        i();
    }

    private void i() {
        WLogger.d("FaceVerifyActivity", "updateUI");
        this.d.setVisibility(8);
        com.tencent.cloud.huiyansdkface.facelight.ui.b.a aVar = new com.tencent.cloud.huiyansdkface.facelight.ui.b.a();
        if (getFragmentManager().findFragmentByTag("rootFragment") != null) {
            WLogger.d("FaceVerifyActivity", "rootFragment already exists:" + aVar);
            return;
        }
        WLogger.d("FaceVerifyActivity", "addRootFragment:" + aVar);
        getFragmentManager().beginTransaction().add(R.id.wbcf_fragment_container, aVar, "rootFragment").commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            ActivityCompat.requestPermissions(this, d(), 1024);
        } catch (Exception e) {
            e.printStackTrace();
            onRequestPermissionsResult(1024, d(), new int[]{-1});
        }
    }

    private void k() {
        if (this.i.y() != null) {
            WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
            wbFaceVerifyResult.setIsSuccess(false);
            wbFaceVerifyResult.setOrderNo(this.i.w());
            wbFaceVerifyResult.setSign(null);
            WbFaceError wbFaceError = new WbFaceError();
            wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
            wbFaceError.setCode(WbFaceError.WBFaceErrorCodeSdkInitFail);
            wbFaceError.setDesc("初始化sdk异常");
            wbFaceError.setReason("mWbCloudFaceVerifySdk not init!");
            wbFaceVerifyResult.setError(wbFaceError);
            Properties properties = new Properties();
            properties.setProperty("errorDesc", wbFaceError.toString());
            this.i.a(getApplicationContext(), WbFaceError.WBFaceErrorCodeSdkInitFail, properties);
            this.i.y().onFinish(wbFaceVerifyResult);
        }
        WLogger.d("FaceVerifyActivity", "finish activity");
        finish();
    }

    public void a() {
        WLogger.d("FaceVerifyActivity", "startWithPermissionCheck");
        String[] d = d();
        int[] a2 = a(d);
        if (a(a2)) {
            h();
        } else if (Build.VERSION.SDK_INT < 23) {
            a(d, a2);
        } else if (f()) {
            a(d, a2, false);
        } else {
            requestPermissions(d, 1024);
        }
    }

    public void a(int i) {
        try {
            startActivityForResult(new Intent(Settings.ACTION_SETTINGS), i);
        } catch (Exception e) {
            e.printStackTrace();
            onRequestPermissionsResult(1024, d(), new int[]{-1});
        }
    }

    public boolean a(final String[] strArr, final int[] iArr, final boolean z) {
        WLogger.d("FaceVerifyActivity", "onShouldTipUser");
        this.h = true;
        a(new a.InterfaceC0746a() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceVerifyActivity.2
            @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0746a
            public void a() {
                if (FaceVerifyActivity.this.b != null) {
                    FaceVerifyActivity.this.b.dismiss();
                }
                if (z) {
                    FaceVerifyActivity.this.g();
                } else {
                    FaceVerifyActivity.this.j();
                }
            }

            @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.a.InterfaceC0746a
            public void b() {
                WLogger.e("FaceVerifyActivity", "user didnt open permissions!");
                if (FaceVerifyActivity.this.b != null) {
                    FaceVerifyActivity.this.b.dismiss();
                }
                FaceVerifyActivity.this.b(strArr, iArr);
            }
        }, d(strArr, iArr));
        return true;
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        WLogger.d("FaceVerifyActivity", "onConfigurationChanged");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        super.onCreate(bundle);
        WLogger.d("FaceVerifyActivity", "Activity onCreate");
        d z = d.z();
        this.i = z;
        if (z == null || !z.g()) {
            WLogger.e("FaceVerifyActivity", "mWbCloudFaceVerifySdk null or mWbCloudFaceVerifySdk not init");
            k();
            return;
        }
        b();
        String J = this.i.x().J();
        if (WbCloudFaceContant.BLACK.equals(J)) {
            i = R.style.wbcfFaceThemeBlack;
        } else if (WbCloudFaceContant.CUSTOM.equals(J)) {
            i = R.style.wbcfFaceThemeCustom;
        } else {
            WLogger.d("FaceVerifyActivity", "set default white");
            i = R.style.wbcfFaceThemeWhite;
        }
        setTheme(i);
        a(J);
        setContentView(R.layout.wbcf_face_verify_layout);
        KycWaSDK.getInstance().trackCustomKVEvent(this, "faceservice_load_ui", null, null);
        this.f21988a = this;
        this.i.e(false);
        c();
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (k != 0) {
            WLogger.d("FaceVerifyActivity", "NOT Same Activity onDestroy ");
            return;
        }
        WLogger.d("FaceVerifyActivity", "Activity onDestroy");
        d("onDestroy");
        this.i.h();
        com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar = this.b;
        if (aVar != null) {
            aVar.dismiss();
            this.b = null;
        }
        if (this.f21988a != null) {
            this.f21988a = null;
        }
        WLogger.i("FaceVerifyActivity", "close bugly report");
        c.a().a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        WLogger.d("FaceVerifyActivity", "onNewIntent()");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        WLogger.d("FaceVerifyActivity", "Activity onPause");
        super.onPause();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        boolean z;
        if (i == 1024 && strArr.length > 0 && iArr.length > 0) {
            int length = iArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    z = true;
                    break;
                } else if (iArr[i3] != 0) {
                    z = false;
                    break;
                } else {
                    i2 = i3 + 1;
                }
            }
            if (z) {
                h();
            } else if (Build.VERSION.SDK_INT < 23 || c(strArr, iArr)) {
                a(strArr, iArr);
            } else {
                b(strArr, iArr);
            }
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        WLogger.d("FaceVerifyActivity", "Activity onResume");
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        k++;
        WLogger.d("FaceVerifyActivity", "Activity onStart:" + k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        k--;
        WLogger.d("FaceVerifyActivity", "Activity onStop:" + k);
        if (k != 0) {
            WLogger.e("FaceVerifyActivity", "not same activity");
            KycWaSDK.getInstance().trackCustomKVEvent(this, "facepage_not_same_activity", null, null);
        } else if (this.i.b()) {
            WLogger.d("FaceVerifyActivity", "inUpload stop,no finish verify");
        } else if (d("onStop")) {
            com.tencent.cloud.huiyansdkface.facelight.ui.widget.a aVar = this.b;
            if (aVar != null) {
                aVar.dismiss();
                this.b = null;
            }
            WLogger.d("FaceVerifyActivity", "finish activity");
            finish();
        }
    }
}
