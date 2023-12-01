package com.blued.android.module.live_china.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
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
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/activity/LiveFloatDialogActivity.class */
public class LiveFloatDialogActivity extends BaseActivity {
    public int e = 0;
    public long f;
    CustomDialog g;
    public View h;

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        CustomDialog customDialog = this.g;
        if (customDialog != null && customDialog.isShowing()) {
            this.g.dismiss();
        }
        finish();
        LiveRoomInfo.a().a((Activity) this);
    }

    public void c() {
        ((TextView) this.h.findViewById(R.id.tv_des)).setText(getString(R.string.live_float_dialog_des));
    }

    public void d() {
        LiveFloatManager.a().a(this.f);
    }

    public void e() {
        LiveFloatManager.a().m();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (Build.VERSION.SDK_INT < 23) {
                d();
            } else if (Settings.canDrawOverlays(AppInfo.d())) {
                d();
            } else {
                e();
            }
            f();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getIntent() != null && getIntent().getExtras() != null) {
            int i = getIntent().getExtras().getInt("flag", 0);
            this.e = i;
            if (i == 2) {
                this.f = getIntent().getExtras().getLong("timer", 0L);
            }
        }
        if (this.e == 0) {
            f();
            return;
        }
        View inflate = LayoutInflater.from(this).inflate(R.layout.layout_common_dialog, (ViewGroup) null);
        this.h = inflate;
        int i2 = this.e;
        if (1 == i2) {
            ((TextView) inflate.findViewById(R.id.tv_title)).setVisibility(8);
            TextView textView = (TextView) this.h.findViewById(R.id.tv_cancel);
            textView.setText(getString(R.string.live_window_permisson_cancel));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.activity.LiveFloatDialogActivity.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    LiveFloatDialogActivity.this.f();
                }
            });
            TextView textView2 = (TextView) this.h.findViewById(R.id.tv_ok);
            textView2.setText(R.string.live_window_permisson_ok);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.activity.LiveFloatDialogActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", LiveFloatDialogActivity.this.getPackageName(), null));
                    LiveFloatDialogActivity.this.startActivity(intent);
                    LiveFloatDialogActivity.this.f();
                }
            });
            ((TextView) this.h.findViewById(R.id.tv_des)).setText(getString(R.string.live_window_permisson_title));
        } else if (2 == i2) {
            TextView textView3 = (TextView) inflate.findViewById(R.id.tv_title);
            textView3.setText(R.string.live_float_dialog_title);
            textView3.setVisibility(8);
            TextView textView4 = (TextView) this.h.findViewById(R.id.tv_cancel);
            textView4.setText(getString(R.string.biao_v4_cancel));
            textView4.setVisibility(8);
            this.h.findViewById(R.id.tv_divide).setVisibility(8);
            TextView textView5 = (TextView) this.h.findViewById(R.id.tv_ok);
            textView5.setText(R.string.live_float_dialog_open);
            textView5.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.activity.LiveFloatDialogActivity.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    try {
                        LiveFloatDialogActivity.this.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + LiveFloatDialogActivity.this.getPackageName())), 1);
                    } catch (Exception e) {
                        e.printStackTrace();
                        LiveFloatDialogActivity.this.f();
                    }
                }
            });
            c();
        } else {
            f();
        }
        if (isFinishing() || isDestroyed()) {
            return;
        }
        CustomDialog customDialog = new CustomDialog(this, R.style.TranslucentBackground);
        this.g = customDialog;
        customDialog.a(this.h, new CustomDialog.OnBackCallBack() { // from class: com.blued.android.module.live_china.activity.LiveFloatDialogActivity.4
            @Override // com.blued.android.framework.view.CustomDialog.OnBackCallBack
            public void a() {
                if (LiveFloatDialogActivity.this.e == 2) {
                    LiveFloatDialogActivity.this.e();
                }
                LiveFloatDialogActivity.this.f();
            }
        });
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.g.getWindow();
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
            window.getDecorView().setSystemUiVisibility(BluedSkinUtils.c() ? systemUiVisibility | 16 : systemUiVisibility & (-17));
            window.addFlags(Integer.MIN_VALUE);
            window.setNavigationBarColor(BluedSkinUtils.a(this, AppInfo.k()));
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        LiveRoomInfo.a().a((Activity) this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            int i = getIntent().getExtras().getInt("flag", 0);
            this.e = i;
            if (i == 2) {
                this.f = getIntent().getExtras().getLong("timer", 0L);
            }
        }
        if (this.e == 0) {
            f();
        }
        super.onCreate(bundle, persistableBundle);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CustomDialog customDialog = this.g;
        if (customDialog == null || !customDialog.isShowing()) {
            return;
        }
        this.g.dismiss();
    }

    @Override // com.blued.android.core.ui.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
