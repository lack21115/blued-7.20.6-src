package com.blued.android.framework.permission;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.R;
import com.blued.android.framework.ui.dialog.AuxiliaryDialogFragment;
import com.blued.android.framework.ui.dialog.ConfirmDialog;
import com.blued.android.framework.utils.AppUtils;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/permission/PermissionActivity.class */
public class PermissionActivity extends BaseFragmentActivity {

    /* renamed from: c  reason: collision with root package name */
    private String[] f9821c;
    private ConfirmDialog d;
    private AuxiliaryDialogFragment e;

    private void a(ArrayList<String> arrayList) {
        ConfirmDialog confirmDialog = this.d;
        if (confirmDialog == null || !confirmDialog.c()) {
            String a2 = PermissionManager.a(this, arrayList);
            String string = getResources().getString(R.string.permission, AppUtils.a(this), a2);
            View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_permission, (ViewGroup) null);
            inflate.setVisibility(8);
            ((TextView) inflate.findViewById(R.id.tv_title)).setText(R.string.permission_title);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_cancel);
            textView.setText(R.string.permission_cancel);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.framework.permission.PermissionActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    PermissionActivity.this.i();
                }
            });
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_ok);
            textView2.setText(R.string.permission_setting);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.framework.permission.PermissionActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (PermissionActivity.this.d != null && PermissionActivity.this.d.c()) {
                        PermissionActivity.this.d.a();
                    }
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    intent.setData(Uri.fromParts("package", PermissionActivity.this.getPackageName(), null));
                    PermissionActivity.this.startActivityForResult(intent, 2001);
                }
            });
            TextView textView3 = (TextView) inflate.findViewById(R.id.tv_des);
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(a2)) {
                textView3.setText(string);
            } else {
                int indexOf = string.indexOf(a2);
                if (indexOf >= 0) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#2593f4")), indexOf, a2.length() + indexOf, 33);
                    textView3.setText(spannableStringBuilder);
                } else {
                    textView3.setText(string);
                }
            }
            ConfirmDialog confirmDialog2 = new ConfirmDialog(this);
            this.d = confirmDialog2;
            confirmDialog2.a(false);
            this.d.a(inflate);
            this.d.a(new ConfirmDialog.OperationListener() { // from class: com.blued.android.framework.permission.PermissionActivity.4
                @Override // com.blued.android.framework.ui.dialog.ConfirmDialog.OperationListener
                public void a(ConfirmDialog.Operation operation) {
                    if (operation == ConfirmDialog.Operation.CANCEL) {
                        PermissionActivity.this.i();
                    }
                }
            });
            this.d.b();
            inflate.setVisibility(0);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setFillAfter(false);
            alphaAnimation.setDuration(300L);
            inflate.setAnimation(alphaAnimation);
            alphaAnimation.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (TextUtils.isEmpty(PermissionManager.a()) || TextUtils.isEmpty(PermissionManager.b())) {
            return;
        }
        this.e = AuxiliaryDialogFragment.a(getSupportFragmentManager(), PermissionManager.a(), PermissionManager.b());
    }

    private void g() {
        AuxiliaryDialogFragment auxiliaryDialogFragment = this.e;
        if (auxiliaryDialogFragment == null || !auxiliaryDialogFragment.isVisible()) {
            return;
        }
        this.e.dismissAllowingStateLoss();
    }

    private void h() {
        if (AppInfo.m()) {
            Log.v("PermissionActivity", "blued permission Granted.");
        }
        j();
        PermissionManager.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (AppInfo.m()) {
            Log.v("PermissionActivity", "blued permission Denied.");
        }
        j();
        PermissionManager.b(this.f9821c);
    }

    private void j() {
        ConfirmDialog confirmDialog = this.d;
        if (confirmDialog != null) {
            confirmDialog.a();
        }
        g();
        overridePendingTransition(0, 0);
        PermissionManager.a(new PermissionAuxiliaryDialogSetting() { // from class: com.blued.android.framework.permission.PermissionActivity.5
            @Override // com.blued.android.framework.permission.PermissionAuxiliaryDialogSetting
            public String a() {
                return null;
            }

            @Override // com.blued.android.framework.permission.PermissionAuxiliaryDialogSetting
            public String b() {
                return null;
            }
        });
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (AppInfo.m()) {
            Log.v("PermissionActivity", "onActivityResult requestCode:" + i);
        }
        if (i == 2001) {
            if (PermissionManager.a(this.f9821c)) {
                h();
            } else {
                i();
            }
        }
        if (AppInfo.p()) {
            g();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        if (AppInfo.p()) {
            StatusBarHelper.a((Activity) this, false);
        }
        if (getIntent() != null) {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                String[] stringArray = extras.getStringArray("com.blued.android.framework.reqeust_permission_code");
                this.f9821c = stringArray;
                if (stringArray != null && stringArray.length > 0) {
                    ActivityCompat.requestPermissions(this, stringArray, 2002);
                    if (AppInfo.p()) {
                        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.framework.permission.PermissionActivity.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (PermissionActivity.this.d == null || !PermissionActivity.this.d.c()) {
                                    PermissionActivity.this.f();
                                }
                            }
                        }, 300L);
                        return;
                    }
                    return;
                }
            }
            finish();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (AppInfo.m()) {
            Log.i("PermissionActivity", "onRequestPermissionsResult:" + i + ", " + Arrays.toString(strArr) + ", " + Arrays.toString(iArr));
        }
        if (AppInfo.p()) {
            g();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= strArr.length) {
                break;
            }
            String str = strArr[i3];
            if (iArr[i3] == 0) {
                arrayList.add(str);
                if (AppInfo.m()) {
                    Log.v("PermissionActivity", "onRequestPermissionsResul: PERMISSION_GRANTED: " + str);
                }
            } else {
                arrayList2.add(str);
                if (AppInfo.m()) {
                    Log.v("PermissionActivity", "onRequestPermissionsResult: PERMISSION_DENIED: " + str);
                }
            }
            if (!PermissionManager.a(strArr[i3])) {
                arrayList3.add(str);
            }
            i2 = i3 + 1;
        }
        if (!arrayList.isEmpty() && arrayList2.isEmpty() && arrayList3.isEmpty()) {
            h();
        } else if (arrayList2.isEmpty() && arrayList3.isEmpty()) {
        } else {
            ArrayList<String> arrayList4 = new ArrayList<>();
            arrayList4.addAll(arrayList2);
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                Iterator<? extends String> it2 = arrayList2.iterator();
                boolean z = true;
                while (it2.hasNext()) {
                    if (TextUtils.equals(str2, it2.next())) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList4.add(str2);
                    if (AppInfo.m()) {
                        Log.v("PermissionActivity", "onRequestPermissionsResul: permissionStillNotGet: " + str2);
                    }
                }
            }
            this.f9821c = (String[]) arrayList4.toArray(new String[arrayList4.size()]);
            a(arrayList4);
        }
    }
}
