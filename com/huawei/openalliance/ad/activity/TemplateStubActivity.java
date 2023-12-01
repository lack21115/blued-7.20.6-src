package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import com.bytedance.applog.tracker.Tracker;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.f;
import com.huawei.hms.ads.ge;
import com.huawei.hms.ads.kr;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.uiengine.IRemoteViewDelegate;
import com.huawei.openalliance.ad.constant.bc;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.z;
import java.lang.ref.WeakReference;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/activity/TemplateStubActivity.class */
public class TemplateStubActivity extends Activity {
    private static final String Code = "TemplateStubActivity";
    private static AdContentData I;
    private boolean B = false;
    private IRemoteViewDelegate V;
    private View Z;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/activity/TemplateStubActivity$a.class */
    static class a extends IPPSUiEngineCallback.b {
        private WeakReference<TemplateStubActivity> V;

        public a(TemplateStubActivity templateStubActivity) {
            this.V = new WeakReference<>(templateStubActivity);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x008f, code lost:
            if (r8.equals("show") != false) goto L6;
         */
        @Override // com.huawei.hms.ads.uiengine.IPPSUiEngineCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onCallResult(java.lang.String r8, android.os.Bundle r9) {
            /*
                Method dump skipped, instructions count: 379
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.activity.TemplateStubActivity.a.onCallResult(java.lang.String, android.os.Bundle):void");
        }
    }

    private void B() {
        try {
            if (this.V != null) {
                this.V.onDestroy();
            }
        } catch (Throwable th) {
            ge.I(Code, "onDestroy failed: " + th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle Code(String str, Bundle bundle) {
        try {
            if (this.V != null) {
                return this.V.sendCommand(str, bundle);
            }
            return null;
        } catch (Throwable th) {
            ge.I(Code, "%s failed: %s ", str, th.getClass().getSimpleName());
            return null;
        }
    }

    private static void Code(AdContentData adContentData) {
        I = adContentData;
    }

    private void I() {
        getWindow().setFlags(1024, 1024);
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().addFlags(134217728);
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || 1 != getResources().getConfiguration().orientation) {
                return;
            }
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            getWindow().setAttributes(attributes);
        } catch (Throwable th) {
            Log.w(Code, "set CutoutMode error:" + th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        finish();
        overridePendingTransition(0, R.anim.hiad_anim_fade_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        try {
            if (this.V != null) {
                View view = (View) ObjectWrapper.unwrap(this.V.getView());
                this.Z = view;
                setContentView(view);
            }
        } catch (Throwable th) {
            ge.I(Code, "plugRemoteView " + th.getClass().getSimpleName());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.hiad_anim_fade_out);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        SafeIntent safeIntent = new SafeIntent(getIntent());
        String stringExtra = safeIntent.getStringExtra("content");
        Code((AdContentData) z.V(stringExtra, AdContentData.class, new Class[0]));
        if (ay.V(getApplicationContext())) {
            ge.V(Code, "screen locked");
            kr.Code(getApplicationContext()).Code(I, 1);
            finish();
        }
        IRemoteCreator Code2 = f.Code(getApplicationContext());
        if (Code2 == null) {
            kr.Code(getApplicationContext()).Code(I, 2);
            finish();
            return;
        }
        I();
        Bundle bundle2 = new Bundle();
        bundle2.putString("filePath", safeIntent.getStringExtra("filePath"));
        bundle2.putString("content", stringExtra);
        try {
            IRemoteViewDelegate newRemoteViewDelegate = Code2.newRemoteViewDelegate(ObjectWrapper.wrap(this), safeIntent.getStringExtra(bc.e.S), null);
            this.V = newRemoteViewDelegate;
            newRemoteViewDelegate.onCreate(bundle2);
            this.V.setCallback(new a(this));
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.activity.TemplateStubActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    TemplateStubActivity.this.Z();
                    TemplateStubActivity.this.Code("start", null);
                    ay.Code(TemplateStubActivity.this.Z, TemplateStubActivity.this);
                    TemplateStubActivity.this.Z.startAnimation(AnimationUtils.loadAnimation(TemplateStubActivity.this.getApplicationContext(), R.anim.hiad_anim_fade_in));
                }
            });
        } catch (Throwable th) {
            ge.I(Code, "create remoteViewDelegate err: %s", th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ge.V(Code, "onDestroy");
        B();
        kr.Code(getApplicationContext()).V(I);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        ge.V(Code, "onPause");
        this.B = true;
        try {
            if (this.V != null) {
                this.V.onPause();
            }
        } catch (Throwable th) {
            ge.I(Code, "onPause " + th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        ge.V(Code, "onRestart, hasPause= %s", Boolean.valueOf(this.B));
        if (this.B) {
            finish();
        }
        try {
            if (this.V != null) {
                this.V.onRestart();
            }
        } catch (Throwable th) {
            ge.I(Code, "onRestart " + th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        ge.V(Code, "onResume, hasPause= %s", Boolean.valueOf(this.B));
        if (this.B) {
            finish();
        }
        try {
            if (this.V != null) {
                this.V.onResume();
            }
        } catch (Throwable th) {
            ge.I(Code, "onResume " + th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        try {
            if (this.V != null) {
                this.V.onStart();
            }
        } catch (Throwable th) {
            ge.I(Code, "onStart " + th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        ge.V(Code, "onStop");
        try {
            if (this.V != null) {
                this.V.onStop();
            }
        } catch (Throwable th) {
            ge.I(Code, "onStop " + th.getClass().getSimpleName());
        }
        finish();
    }
}
