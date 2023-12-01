package com.qq.e.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.applog.tracker.Tracker;
import com.qq.e.comm.managers.b;
import com.qq.e.comm.managers.plugin.a;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/ads/ADActivity.class */
public class ADActivity extends Activity {
    public static final String NOTCH_CONTAINER_TAG = "NOTCH_CONTAINER";

    /* renamed from: a  reason: collision with root package name */
    protected ACTD f27850a;
    private FrameLayout b;

    private void a() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        super.setContentView(linearLayout);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setTag(NOTCH_CONTAINER_TAG);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(frameLayout);
        this.b = new FrameLayout(this);
        this.b.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.addView(this.b);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ACTD actd = this.f27850a;
        if (actd != null) {
            actd.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ACTD actd = this.f27850a;
        if (actd != null) {
            actd.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ACTD actd = this.f27850a;
        if (actd != null) {
            actd.onConfigurationChanged(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        String str = null;
        try {
            POFactory pOFactory = b.b().c().getPOFactory();
            if (pOFactory != null) {
                Intent intent = getIntent();
                if (!SDKStatus.isNoPlugin) {
                    intent.setExtrasClassLoader(pOFactory.getClass().getClassLoader());
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    String string = extras.getString(ACTD.DELEGATE_NAME_KEY);
                    String string2 = extras.getString("appid");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && b.b().d()) {
                        ACTD activityDelegate = pOFactory.getActivityDelegate(string, this);
                        this.f27850a = activityDelegate;
                        if (activityDelegate == null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("创建 ADActivity Delegate ");
                            sb.append(string);
                            sb.append(" 失败");
                            str = string;
                            GDTLogger.e(sb.toString());
                        }
                    }
                }
            }
        } catch (Throwable th) {
            GDTLogger.e("创建ADActivity Delegate" + str + "发生异常", th);
        }
        ACTD actd = this.f27850a;
        if (actd != null) {
            actd.onBeforeCreate(bundle);
        } else {
            try {
                finish();
            } catch (Throwable th2) {
                GDTLogger.e("ADActivity onCreate 发生异常", th2);
            }
        }
        try {
            super.onCreate(bundle);
        } catch (Throwable th3) {
            a.a(th3, "ADActivity onCreate 发生异常");
            GDTLogger.e("ADActivity onCreate 发生异常", th3);
        }
        ACTD actd2 = this.f27850a;
        if (actd2 != null) {
            actd2.onAfterCreate(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ACTD actd = this.f27850a;
        if (actd != null) {
            actd.onDestroy();
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        ACTD actd = this.f27850a;
        if (actd != null) {
            actd.onPause();
        }
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        ACTD actd = this.f27850a;
        if (actd != null) {
            actd.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        ACTD actd = this.f27850a;
        if (actd != null) {
            actd.onStop();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        a();
        LayoutInflater.from(this).inflate(i, (ViewGroup) this.b, true);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        a();
        this.b.addView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a();
        this.b.addView(view, layoutParams);
    }
}
