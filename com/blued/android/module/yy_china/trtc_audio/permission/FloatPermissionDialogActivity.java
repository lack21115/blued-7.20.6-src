package com.blued.android.module.yy_china.trtc_audio.permission;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.trtc_audio.model.FloatPermissionEvent;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/trtc_audio/permission/FloatPermissionDialogActivity.class */
public class FloatPermissionDialogActivity extends BaseActivity {
    CustomDialog f;
    View g;
    public int e = 0;
    private Handler h = new Handler();

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        FloatPermissionEvent floatPermissionEvent = new FloatPermissionEvent();
        floatPermissionEvent.status = i;
        LiveEventBus.get("event_request_float_permission").post(floatPermissionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        CustomDialog customDialog = this.f;
        if (customDialog != null && customDialog.isShowing()) {
            this.f.dismiss();
        }
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.h.postDelayed(new Runnable() { // from class: com.blued.android.module.yy_china.trtc_audio.permission.FloatPermissionDialogActivity.5
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Settings.canDrawOverlays(AppInfo.d())) {
                            FloatPermissionDialogActivity.this.a(0);
                        } else {
                            FloatPermissionDialogActivity.this.a(1);
                        }
                    }
                }, 1000L);
            } else {
                a(0);
            }
            c();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.e = getIntent().getExtras().getInt("flag", 0);
        }
        if (this.e == 0) {
            c();
            return;
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.float_permission_dialog, (ViewGroup) null);
        this.g = inflate;
        int i = this.e;
        if (1 == i) {
            ((TextView) inflate.findViewById(R.id.tv_title)).setVisibility(8);
            TextView textView = (TextView) this.g.findViewById(R.id.tv_cancel);
            textView.setText(getString(R.string.common_cancel));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.trtc_audio.permission.FloatPermissionDialogActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    FloatPermissionDialogActivity.this.c();
                }
            });
            TextView textView2 = (TextView) this.g.findViewById(R.id.tv_ok);
            textView2.setText(R.string.setting);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.trtc_audio.permission.FloatPermissionDialogActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", FloatPermissionDialogActivity.this.getPackageName(), null));
                    FloatPermissionDialogActivity.this.startActivity(intent);
                    FloatPermissionDialogActivity.this.c();
                }
            });
            ((TextView) this.g.findViewById(R.id.tv_des)).setText(getString(R.string.live_window_permisson_title));
        } else if (2 == i) {
            TextView textView3 = (TextView) inflate.findViewById(R.id.tv_title);
            textView3.setText(R.string.live_float_dialog_title);
            textView3.setVisibility(8);
            TextView textView4 = (TextView) this.g.findViewById(R.id.tv_cancel);
            textView4.setText(getString(R.string.common_cancel));
            textView4.setVisibility(8);
            this.g.findViewById(R.id.tv_divide).setVisibility(8);
            TextView textView5 = (TextView) this.g.findViewById(R.id.tv_ok);
            textView5.setText(R.string.live_float_dialog_open);
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.trtc_audio.permission.FloatPermissionDialogActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    try {
                        FloatPermissionDialogActivity.this.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + FloatPermissionDialogActivity.this.getPackageName())), 1);
                    } catch (Exception e) {
                        e.printStackTrace();
                        FloatPermissionDialogActivity.this.c();
                    }
                }
            });
            ((TextView) this.g.findViewById(R.id.tv_des)).setText(getString(R.string.live_float_dialog_des));
        } else {
            c();
        }
        CustomDialog customDialog = new CustomDialog(this, R.style.TranslucentBackground);
        this.f = customDialog;
        customDialog.a(this.g, new CustomDialog.OnBackCallBack() { // from class: com.blued.android.module.yy_china.trtc_audio.permission.FloatPermissionDialogActivity.4
            @Override // com.blued.android.framework.view.CustomDialog.OnBackCallBack
            public void a() {
                if (FloatPermissionDialogActivity.this.e == 2) {
                    FloatPermissionDialogActivity.this.a(1);
                }
                FloatPermissionDialogActivity.this.c();
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
            window.getDecorView().setSystemUiVisibility(BluedSkinUtils.c() ? systemUiVisibility | 16 : systemUiVisibility & (-17));
            window.addFlags(Integer.MIN_VALUE);
            window.setNavigationBarColor(BluedSkinUtils.a(this, AppInfo.k()));
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        overridePendingTransition(0, 0);
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.e = getIntent().getExtras().getInt("flag", 0);
        }
        if (this.e == 0) {
            c();
        }
        super.onCreate(bundle, persistableBundle);
    }

    @Override // com.blued.android.core.ui.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
