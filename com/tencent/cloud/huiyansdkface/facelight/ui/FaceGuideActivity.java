package com.tencent.cloud.huiyansdkface.facelight.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.applog.tracker.Tracker;
import com.sobot.chat.core.channel.Const;
import com.tencent.cloud.huiyansdkface.R;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceError;
import com.tencent.cloud.huiyansdkface.facelight.api.result.WbFaceVerifyResult;
import com.tencent.cloud.huiyansdkface.facelight.c.b.e;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.facelight.net.AuthUploadRequest;
import com.tencent.cloud.huiyansdkface.facelight.process.d;
import com.tencent.cloud.huiyansdkface.facelight.ui.widget.c;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import java.io.IOException;
import java.util.Properties;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/FaceGuideActivity.class */
public class FaceGuideActivity extends com.tencent.cloud.huiyansdkface.facelight.ui.a.a {

    /* renamed from: a  reason: collision with root package name */
    private static int f21968a;
    private d b;
    private c d;
    private LinearLayout e;
    private ImageView f;
    private RelativeLayout g;
    private TextView h;
    private ImageView i;
    private TextView j;
    private CheckBox k;
    private TextView l;
    private ImageView m;
    private RelativeLayout n;
    private LinearLayout o;
    private LinearLayout p;
    private LinearLayout q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private int v;
    private CountDownTimer w;
    private String x;
    private boolean y;
    private boolean z;

    /* renamed from: c  reason: collision with root package name */
    private e f21969c = new e(Const.SOCKET_CHECK_CHANNEL);
    private View.OnClickListener A = new View.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            WLogger.d("FaceGuideActivity", "点击跳转协议详情页面");
            FaceGuideActivity.this.y = true;
            Intent intent = new Intent();
            intent.putExtra("isChecked", FaceGuideActivity.this.z);
            intent.setClass(FaceGuideActivity.this, FaceProtocalActivity.class);
            FaceGuideActivity.this.startActivity(intent);
            FaceGuideActivity.this.overridePendingTransition(0, 0);
            FaceGuideActivity.this.finish();
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/ui/FaceGuideActivity$a.class */
    public static class a implements c.b {

        /* renamed from: a  reason: collision with root package name */
        private d f21979a;
        private Activity b;

        public a(d dVar, Activity activity) {
            this.f21979a = dVar;
            this.b = activity;
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.c.b
        public void a() {
            WLogger.e("FaceGuideActivity", "onHomePressed");
            KycWaSDK.getInstance().trackCustomKVEvent(this.b.getApplicationContext(), "authpage_exit_self", "点击home键返回", null);
            this.f21979a.e(true);
            if (this.f21979a.y() != null) {
                WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
                wbFaceVerifyResult.setIsSuccess(false);
                wbFaceVerifyResult.setOrderNo(this.f21979a.w());
                wbFaceVerifyResult.setSign(null);
                WbFaceError wbFaceError = new WbFaceError();
                wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
                wbFaceError.setCode(WbFaceError.WBFaceErrorCodeUserCancle);
                wbFaceError.setDesc("用户取消");
                wbFaceError.setReason("home键：用户授权中取消");
                wbFaceVerifyResult.setError(wbFaceError);
                Properties properties = new Properties();
                properties.setProperty("errorDesc", wbFaceError.toString());
                this.f21979a.a(this.b, WbFaceError.WBFaceErrorCodeUserCancle, properties);
                this.f21979a.y().onFinish(wbFaceVerifyResult);
            }
            this.b.finish();
        }

        @Override // com.tencent.cloud.huiyansdkface.facelight.ui.widget.c.b
        public void b() {
            WLogger.e("FaceGuideActivity", "onHomeLongPressed");
        }
    }

    private void a() {
        int i;
        WLogger.i("FaceGuideActivity", "setThemeAndTitleBar");
        String J = this.b.x().J();
        this.x = J;
        if (WbCloudFaceContant.BLACK.equals(J)) {
            i = R.style.wbcfFaceProtocolThemeBlack;
        } else if (WbCloudFaceContant.CUSTOM.equals(this.x)) {
            i = R.style.wbcfFaceProtocolThemeCustom;
        } else {
            WLogger.e("FaceGuideActivity", "set default WHITE");
            this.x = WbCloudFaceContant.WHITE;
            i = R.style.wbcfFaceProtocolThemeWhite;
        }
        setTheme(i);
        a(this.x);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x03bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            Method dump skipped, instructions count: 986
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.b():void");
    }

    private void c() {
        WLogger.d("FaceGuideActivity", "initListeners");
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                WLogger.d("FaceGuideActivity", "左上角返回键，无上一页，退出授权sdk");
                KycWaSDK.getInstance().trackCustomKVEvent(FaceGuideActivity.this.getApplicationContext(), "authpage_exit_self", "左上角返回", null);
                FaceGuideActivity.this.b.e(true);
                if (FaceGuideActivity.this.b.y() != null) {
                    WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
                    wbFaceVerifyResult.setIsSuccess(false);
                    wbFaceVerifyResult.setOrderNo(FaceGuideActivity.this.b.w());
                    wbFaceVerifyResult.setSign(null);
                    WbFaceError wbFaceError = new WbFaceError();
                    wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
                    wbFaceError.setCode(WbFaceError.WBFaceErrorCodeUserCancle);
                    wbFaceError.setDesc("用户取消");
                    wbFaceError.setReason("左上角返回键：用户授权中取消");
                    wbFaceVerifyResult.setError(wbFaceError);
                    Properties properties = new Properties();
                    properties.setProperty("errorDesc", wbFaceError.toString());
                    FaceGuideActivity.this.b.a(FaceGuideActivity.this.getApplicationContext(), WbFaceError.WBFaceErrorCodeUserCancle, properties);
                    FaceGuideActivity.this.b.y().onFinish(wbFaceVerifyResult);
                }
                FaceGuideActivity.this.finish();
            }
        });
        this.k.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.3
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                Tracker.onCheckedChanged(compoundButton, z);
                WLogger.d("FaceGuideActivity", "protocalCb onCheckedChanged");
                FaceGuideActivity.this.z = z;
                FaceGuideActivity faceGuideActivity = FaceGuideActivity.this;
                if (z) {
                    faceGuideActivity.e();
                    FaceGuideActivity.this.g.setVisibility(8);
                    return;
                }
                faceGuideActivity.f();
                FaceGuideActivity.this.d();
            }
        });
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                WLogger.d("FaceGuideActivity", "protocalCb OnClickListener");
            }
        });
        this.l.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CheckBox checkBox;
                Tracker.onClick(view);
                if (FaceGuideActivity.this.k.getVisibility() == 8) {
                    return;
                }
                FaceGuideActivity.h(FaceGuideActivity.this);
                boolean z = true;
                if (FaceGuideActivity.this.v % 2 == 1) {
                    checkBox = FaceGuideActivity.this.k;
                } else {
                    checkBox = FaceGuideActivity.this.k;
                    z = false;
                }
                checkBox.setChecked(z);
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CheckBox checkBox;
                Tracker.onClick(view);
                if (FaceGuideActivity.this.k.getVisibility() == 8) {
                    return;
                }
                FaceGuideActivity.h(FaceGuideActivity.this);
                boolean z = true;
                if (FaceGuideActivity.this.v % 2 == 1) {
                    checkBox = FaceGuideActivity.this.k;
                } else {
                    checkBox = FaceGuideActivity.this.k;
                    z = false;
                }
                checkBox.setChecked(z);
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                WLogger.d("FaceGuideActivity", "user agreed protocal!");
                KycWaSDK.getInstance().trackCustomKVEvent(FaceGuideActivity.this.getApplicationContext(), "authpage_confirm", null, null);
                FaceGuideActivity.this.g();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.k.getVisibility() == 0) {
            this.g.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        TextView textView;
        int i;
        this.j.setEnabled(true);
        if (this.x.equals(WbCloudFaceContant.CUSTOM)) {
            this.j.setTextColor(getResources().getColor(R.color.wbcf_custom_auth_btn_text_checked));
            textView = this.j;
            i = R.drawable.wbcf_custom_auth_btn_checked;
        } else {
            textView = this.j;
            i = R.drawable.wbcf_protocol_btn_checked;
        }
        textView.setBackgroundResource(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        TextView textView;
        int i;
        this.j.setEnabled(false);
        if (this.x.equals(WbCloudFaceContant.CUSTOM)) {
            this.j.setTextColor(getResources().getColor(R.color.wbcf_custom_auth_btn_text_unchecked));
            textView = this.j;
            i = R.drawable.wbcf_custom_auth_btn_unchecked;
        } else {
            textView = this.j;
            i = R.drawable.wbcf_protocol_btn_unchecked;
        }
        textView.setBackgroundResource(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!this.b.x().S()) {
            WLogger.d("FaceGuideActivity", "uploadAuthInfo");
            h();
        }
        WLogger.d("FaceGuideActivity", "start go to FaceVerify from AuthPage!");
        this.y = true;
        Intent intent = new Intent();
        intent.setClass(getApplicationContext(), FaceVerifyActivity.class);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }

    static /* synthetic */ int h(FaceGuideActivity faceGuideActivity) {
        int i = faceGuideActivity.v;
        faceGuideActivity.v = i + 1;
        return i;
    }

    private void h() {
        AuthUploadRequest.requestExec(this.b.a(), new WeReq.Callback<AuthUploadRequest.AuthUploadResponse>() { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.8
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            /* renamed from: a */
            public void onSuccess(WeReq weReq, AuthUploadRequest.AuthUploadResponse authUploadResponse) {
                WLogger.d("FaceGuideActivity", "upload auth success!");
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFailed(WeReq weReq, WeReq.ErrType errType, int i, String str, IOException iOException) {
                WLogger.e("FaceGuideActivity", "upload auth failed!errType=" + errType + "i=" + i + "s=" + str);
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onFinish() {
            }

            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
            public void onStart(WeReq weReq) {
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        WLogger.d("FaceGuideActivity", "返回键，无上一页可回，退出授权页面");
        super.onBackPressed();
        KycWaSDK.getInstance().trackCustomKVEvent(getApplicationContext(), "authpage_exit_self", "返回键", null);
        this.b.e(true);
        if (this.b.y() != null) {
            WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
            wbFaceVerifyResult.setIsSuccess(false);
            wbFaceVerifyResult.setOrderNo(this.b.w());
            wbFaceVerifyResult.setSign(null);
            WbFaceError wbFaceError = new WbFaceError();
            wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
            wbFaceError.setCode(WbFaceError.WBFaceErrorCodeUserCancle);
            wbFaceError.setDesc("用户取消");
            wbFaceError.setReason("返回键：用户授权中取消");
            wbFaceVerifyResult.setError(wbFaceError);
            Properties properties = new Properties();
            properties.setProperty("errorDesc", wbFaceError.toString());
            this.b.a(getApplicationContext(), WbFaceError.WBFaceErrorCodeUserCancle, properties);
            this.b.y().onFinish(wbFaceVerifyResult);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        WLogger.d("FaceGuideActivity", "onCreate：" + getRequestedOrientation());
        int rotation = getWindowManager().getDefaultDisplay().getRotation();
        WLogger.d("FaceGuideActivity", "setActivityOrientation:" + rotation);
        d z = d.z();
        this.b = z;
        z.e(false);
        KycWaSDK.getInstance().trackCustomKVEvent(getApplicationContext(), "authpage_enter", null, null);
        a();
        super.onCreate(bundle);
        setContentView(R.layout.wbcf_face_guide_layout);
        if (getIntent() != null) {
            this.z = getIntent().getBooleanExtra("isChecked", false);
        }
        b();
        c();
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WLogger.i("FaceGuideActivity", "onDestroy");
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        WLogger.d("FaceGuideActivity", "onPause");
        c cVar = this.d;
        if (cVar != null) {
            cVar.b();
        }
        this.f21969c.a();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        WLogger.d("FaceGuideActivity", "onResume");
        c cVar = this.d;
        if (cVar != null) {
            cVar.a();
        }
        this.f21969c.a(getApplicationContext());
    }

    @Override // android.app.Activity
    public void onStart() {
        WLogger.d("FaceGuideActivity", "onStart");
        super.onStart();
        f21968a++;
        long X = d.z().e().X();
        this.w = new CountDownTimer(X, X) { // from class: com.tencent.cloud.huiyansdkface.facelight.ui.FaceGuideActivity.9
            @Override // android.os.CountDownTimer
            public void onFinish() {
                FaceGuideActivity.this.e.setVisibility(0);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
            }
        }.start();
    }

    @Override // android.app.Activity
    public void onStop() {
        WLogger.i("FaceGuideActivity", "onStop");
        super.onStop();
        CountDownTimer countDownTimer = this.w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.w = null;
        }
        int i = f21968a - 1;
        f21968a = i;
        if (i != 0) {
            WLogger.e("FaceGuideActivity", "not same activity");
        } else if (this.y) {
            WLogger.d("FaceGuideActivity", "gotoDetail,dont exit");
        } else {
            WLogger.d("FaceGuideActivity", "same activity ");
            if (this.b.t()) {
                return;
            }
            WLogger.i("FaceGuideActivity", "onStop quit authPage");
            KycWaSDK.getInstance().trackCustomKVEvent(getApplicationContext(), "authpage_exit_forced", "onStop, 应用被动离开前台", null);
            if (this.b.y() != null) {
                WbFaceVerifyResult wbFaceVerifyResult = new WbFaceVerifyResult();
                wbFaceVerifyResult.setIsSuccess(false);
                wbFaceVerifyResult.setOrderNo(this.b.w());
                wbFaceVerifyResult.setSign(null);
                WbFaceError wbFaceError = new WbFaceError();
                wbFaceError.setDomain(WbFaceError.WBFaceErrorDomainNativeProcess);
                wbFaceError.setCode(WbFaceError.WBFaceErrorCodeUserCancle);
                wbFaceError.setDesc("用户取消");
                wbFaceError.setReason("用户取消，授权中回到后台activity onStop");
                wbFaceVerifyResult.setError(wbFaceError);
                Properties properties = new Properties();
                properties.setProperty("errorDesc", wbFaceError.toString());
                this.b.a(this, WbFaceError.WBFaceErrorCodeUserCancle, properties);
                this.b.y().onFinish(wbFaceVerifyResult);
            }
            finish();
        }
    }
}
