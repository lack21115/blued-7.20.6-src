package com.cmic.gen.sdk.tencent.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.applog.tracker.Tracker;
import com.cmic.gen.sdk.tencent.auth.GenAuthnHelper;
import com.cmic.gen.sdk.tencent.auth.GenTokenListener;
import com.cmic.gen.sdk.tencent.e.h;
import com.cmic.gen.sdk.tencent.e.n;
import com.cmic.gen.sdk.tencent.e.q;
import com.cmic.gen.sdk.tencent.view.b;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/view/GenLoginAuthActivity.class */
public class GenLoginAuthActivity extends Activity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f21685a = GenLoginAuthActivity.class.getSimpleName();
    private GenAuthThemeConfig A;
    private int B;
    private int C;
    private boolean D;
    private Dialog E;
    private Handler b;

    /* renamed from: c  reason: collision with root package name */
    private Context f21686c;
    private RelativeLayout d;
    private d e;
    private d f;
    private d g;
    private d h;
    private d i;
    private ArrayList<d> j;
    private ArrayList<String> k;
    private String[] l;
    private com.cmic.gen.sdk.tencent.a m;
    private com.cmic.gen.sdk.tencent.auth.a n;
    private CheckBox p;
    private RelativeLayout q;
    private RelativeLayout r;
    private GenTokenListener v;
    private RelativeLayout x;
    private String y;
    private String z;
    private String o = "";
    private long s = 0;
    private int t = 0;
    private a u = null;
    private boolean w = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/view/GenLoginAuthActivity$a.class */
    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<GenLoginAuthActivity> f21695a;

        a(GenLoginAuthActivity genLoginAuthActivity) {
            this.f21695a = new WeakReference<>(genLoginAuthActivity);
        }

        private void a(Message message) {
            GenLoginAuthActivity genLoginAuthActivity = this.f21695a.get();
            if (genLoginAuthActivity == null || message.what != 1) {
                return;
            }
            genLoginAuthActivity.c();
            genLoginAuthActivity.k();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                a(message);
            } catch (Exception e) {
                com.cmic.gen.sdk.tencent.d.c.b.add(e);
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/view/GenLoginAuthActivity$b.class */
    public static class b extends n.a {

        /* renamed from: a  reason: collision with root package name */
        WeakReference<GenLoginAuthActivity> f21696a;
        WeakReference<c> b;

        protected b(GenLoginAuthActivity genLoginAuthActivity, c cVar) {
            this.f21696a = new WeakReference<>(genLoginAuthActivity);
            this.b = new WeakReference<>(cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            c cVar = this.b.get();
            if (this.f21696a.get() == null || cVar == null) {
                return false;
            }
            return cVar.a(false);
        }

        @Override // com.cmic.gen.sdk.tencent.e.n.a
        public void a() {
            final GenLoginAuthActivity genLoginAuthActivity = this.f21696a.get();
            genLoginAuthActivity.m.a("logintype", 1);
            h.a(true, false);
            genLoginAuthActivity.n.b(genLoginAuthActivity.m, new com.cmic.gen.sdk.tencent.auth.b() { // from class: com.cmic.gen.sdk.tencent.view.GenLoginAuthActivity.b.1
                @Override // com.cmic.gen.sdk.tencent.auth.b
                public void a(String str, String str2, com.cmic.gen.sdk.tencent.a aVar, JSONObject jSONObject) {
                    if (b.this.b()) {
                        long b = aVar.b("loginTime", 0L);
                        String b2 = aVar.b("phonescrip");
                        if (b != 0) {
                            aVar.a("loginTime", System.currentTimeMillis() - b);
                        }
                        if (!"103000".equals(str) || TextUtils.isEmpty(b2)) {
                            genLoginAuthActivity.w = false;
                            com.cmic.gen.sdk.tencent.d.a.a("authClickFailed");
                        } else {
                            com.cmic.gen.sdk.tencent.d.a.a("authClickSuccess");
                            genLoginAuthActivity.w = true;
                        }
                        genLoginAuthActivity.a(str, str2, aVar, jSONObject);
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        genLoginAuthActivity.u.sendEmptyMessage(1);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/cmic/gen/sdk/tencent/view/GenLoginAuthActivity$c.class */
    public class c implements Runnable {
        private com.cmic.gen.sdk.tencent.a b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f21699c;

        c(com.cmic.gen.sdk.tencent.a aVar) {
            this.b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean a(boolean z) {
            boolean z2;
            synchronized (this) {
                z2 = this.f21699c;
                this.f21699c = z;
            }
            return !z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a(true)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(ProcessBridgeProvider.KEY_RESULT_CODE, "102507");
                    jSONObject.put("resultString", "请求超时");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                GenLoginAuthActivity.this.w = false;
                com.cmic.gen.sdk.tencent.d.a.a("authClickFailed");
                GenLoginAuthActivity.this.u.sendEmptyMessage(1);
                long b = this.b.b("loginTime", 0L);
                if (b != 0) {
                    this.b.a("loginTime", System.currentTimeMillis() - b);
                }
                GenLoginAuthActivity.this.a("102507", "请求超时", this.b, jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, com.cmic.gen.sdk.tencent.a aVar, JSONObject jSONObject) {
        GenAuthnHelper genAuthnHelper;
        try {
            this.b.removeCallbacksAndMessages(null);
            if ("103000".equals(str)) {
                if (GenAuthnHelper.getInstance((Context) this) == null || com.cmic.gen.sdk.tencent.e.e.c(aVar.b("traceId")) == null) {
                    return;
                }
                aVar.a("keepListener", true);
                genAuthnHelper = GenAuthnHelper.getInstance((Context) this);
            } else if ("200020".equals(str)) {
                if (GenAuthnHelper.getInstance((Context) this) != null) {
                    if (com.cmic.gen.sdk.tencent.e.e.c(aVar.b("traceId")) != null) {
                        GenAuthnHelper.getInstance((Context) this).callBackResult(str, str2, aVar, jSONObject);
                    }
                    a();
                    return;
                }
                return;
            } else {
                aVar.a("keepListener", true);
                genAuthnHelper = GenAuthnHelper.getInstance((Context) this);
            }
            genAuthnHelper.callBackResult(str, str2, aVar, jSONObject);
        } catch (Exception e) {
            com.cmic.gen.sdk.tencent.e.c.a(f21685a, "CallbackResult:未知错误");
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        try {
            com.cmic.gen.sdk.tencent.d.a.a("authPageOut");
            a("200020", "登录页面关闭", this.m, null);
        } catch (Exception e) {
            com.cmic.gen.sdk.tencent.d.c.b.add(e);
            e.printStackTrace();
        }
    }

    private void d() {
        String str;
        com.cmic.gen.sdk.tencent.a d = com.cmic.gen.sdk.tencent.e.e.d(getIntent().getStringExtra("traceId"));
        this.m = d;
        if (d == null) {
            this.m = new com.cmic.gen.sdk.tencent.a(0);
        }
        this.v = com.cmic.gen.sdk.tencent.e.e.c(this.m.b("traceId", ""));
        getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.b = new Handler(getMainLooper());
        this.u = new a(this);
        this.o = this.m.b(com.tencent.tendinsv.b.x);
        String str2 = f21685a;
        com.cmic.gen.sdk.tencent.e.c.b(str2, "mSecurityPhone value is " + this.o);
        String b2 = this.m.b("operatortype", "");
        String str3 = f21685a;
        com.cmic.gen.sdk.tencent.e.c.b(str3, "operator value is " + b2);
        if (this.A.getAppLanguageType() == 1) {
            this.l = com.cmic.gen.sdk.tencent.c.b;
        } else if (this.A.getAppLanguageType() == 2) {
            this.l = com.cmic.gen.sdk.tencent.c.f21617c;
        } else {
            this.l = com.cmic.gen.sdk.tencent.c.f21616a;
        }
        if (b2.equals("1")) {
            this.y = this.l[0];
            str = com.tencent.tendinsv.b.d;
        } else if (b2.equals("3")) {
            this.y = this.l[1];
            str = com.tencent.tendinsv.b.b;
        } else {
            this.y = this.l[2];
            str = "https://opencloud.wostore.cn/authz/resource/html/disclaimer.html?fromsdk=true";
        }
        d dVar = new d(this.f21686c, 16973840, this.y, str);
        this.e = dVar;
        dVar.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.cmic.gen.sdk.tencent.view.GenLoginAuthActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == 4 && keyEvent.getAction() == 1 && keyEvent.getRepeatCount() == 0) {
                    GenLoginAuthActivity.this.e.b();
                    return true;
                }
                return true;
            }
        });
        this.j = new ArrayList<>();
        this.k = new ArrayList<>();
        if (!TextUtils.isEmpty(this.A.getClauseUrl())) {
            d dVar2 = new d(this.f21686c, 16973840, this.A.getClauseName(), this.A.getClauseUrl());
            this.f = dVar2;
            dVar2.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.cmic.gen.sdk.tencent.view.GenLoginAuthActivity.2
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i == 4 && keyEvent.getAction() == 1 && keyEvent.getRepeatCount() == 0) {
                        GenLoginAuthActivity.this.f.b();
                        return true;
                    }
                    return true;
                }
            });
            this.j.add(this.f);
            this.k.add(this.A.getClauseName());
        }
        if (!TextUtils.isEmpty(this.A.getClauseUrl2())) {
            d dVar3 = new d(this.f21686c, 16973840, this.A.getClauseName2(), this.A.getClauseUrl2());
            this.g = dVar3;
            dVar3.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.cmic.gen.sdk.tencent.view.GenLoginAuthActivity.3
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i == 4 && keyEvent.getAction() == 1 && keyEvent.getRepeatCount() == 0) {
                        GenLoginAuthActivity.this.g.b();
                        return true;
                    }
                    return true;
                }
            });
            this.j.add(this.g);
            this.k.add(this.A.getClauseName2());
        }
        if (!TextUtils.isEmpty(this.A.getClauseUrl3())) {
            d dVar4 = new d(this.f21686c, 16973840, this.A.getClauseName3(), this.A.getClauseUrl3());
            this.h = dVar4;
            dVar4.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.cmic.gen.sdk.tencent.view.GenLoginAuthActivity.4
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i == 4 && keyEvent.getAction() == 1 && keyEvent.getRepeatCount() == 0) {
                        GenLoginAuthActivity.this.h.b();
                        return true;
                    }
                    return true;
                }
            });
            this.j.add(this.h);
            this.k.add(this.A.getClauseName3());
        }
        if (!TextUtils.isEmpty(this.A.getClauseUrl4())) {
            d dVar5 = new d(this.f21686c, 16973840, this.A.getClauseName4(), this.A.getClauseUrl4());
            this.i = dVar5;
            dVar5.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.cmic.gen.sdk.tencent.view.GenLoginAuthActivity.5
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i == 4 && keyEvent.getAction() == 1 && keyEvent.getRepeatCount() == 0) {
                        GenLoginAuthActivity.this.i.b();
                        return true;
                    }
                    return true;
                }
            });
            this.j.add(this.i);
            this.k.add(this.A.getClauseName4());
        }
        j();
        if (this.A.isPrivacyBookSymbol()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.k.size()) {
                    break;
                }
                String format = String.format("《%s》", this.k.get(i2));
                this.z = this.z.replaceFirst(this.k.get(i2), format);
                this.k.set(i2, format);
                i = i2 + 1;
            }
        }
        com.cmic.gen.sdk.tencent.view.b.a().a(new b.a() { // from class: com.cmic.gen.sdk.tencent.view.GenLoginAuthActivity.6
            @Override // com.cmic.gen.sdk.tencent.view.b.a
            public void a() {
                GenLoginAuthActivity.this.b.removeCallbacksAndMessages(null);
                if (GenLoginAuthActivity.this.e != null && GenLoginAuthActivity.this.e.isShowing()) {
                    GenLoginAuthActivity.this.e.dismiss();
                }
                if (GenLoginAuthActivity.this.f != null && GenLoginAuthActivity.this.f.isShowing()) {
                    GenLoginAuthActivity.this.f.dismiss();
                }
                GenLoginAuthActivity.this.a(true);
            }
        });
    }

    private void e() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.r.getLayoutParams();
        if (this.A.getNumFieldOffsetY() > 0 || this.A.getNumFieldOffsetY_B() < 0) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            this.r.measure(makeMeasureSpec, makeMeasureSpec);
            String str = f21685a;
            com.cmic.gen.sdk.tencent.e.c.b(str, "mPhoneLayout.getMeasuredHeight()=" + this.r.getMeasuredHeight());
            if (this.A.getNumFieldOffsetY() <= 0 || (this.B - this.r.getMeasuredHeight()) - e.a(this.f21686c, this.A.getNumFieldOffsetY()) <= 0) {
                layoutParams.addRule(12, -1);
            } else {
                com.cmic.gen.sdk.tencent.e.c.b(f21685a, "numberField_top");
                layoutParams.addRule(10, -1);
                layoutParams.setMargins(0, e.a(this.f21686c, this.A.getNumFieldOffsetY()), 0, 0);
            }
        } else if (this.A.getNumFieldOffsetY_B() <= 0 || (this.B - this.r.getMeasuredHeight()) - e.a(this.f21686c, this.A.getNumFieldOffsetY_B()) <= 0) {
            layoutParams.addRule(10, -1);
        } else {
            com.cmic.gen.sdk.tencent.e.c.b(f21685a, "numberField_bottom");
            layoutParams.addRule(12, -1);
            layoutParams.setMargins(0, 0, 0, e.a(this.f21686c, this.A.getNumFieldOffsetY_B()));
        }
        this.r.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.d.getLayoutParams();
        int max = Math.max(this.A.getLogBtnMarginLeft(), 0);
        int max2 = Math.max(this.A.getLogBtnMarginRight(), 0);
        if (this.A.getLogBtnOffsetY() > 0 || this.A.getLogBtnOffsetY_B() < 0) {
            if (this.A.getLogBtnOffsetY() <= 0 || this.B - e.a(this.f21686c, this.A.getLogBtnHeight() + this.A.getLogBtnOffsetY()) <= 0) {
                layoutParams2.addRule(12, -1);
                layoutParams2.setMargins(e.a(this.f21686c, max), 0, e.a(this.f21686c, max2), 0);
            } else {
                com.cmic.gen.sdk.tencent.e.c.b(f21685a, "logBtn_top");
                layoutParams2.addRule(10, -1);
                layoutParams2.setMargins(e.a(this.f21686c, max), e.a(this.f21686c, this.A.getLogBtnOffsetY()), e.a(this.f21686c, max2), 0);
            }
        } else if (this.A.getLogBtnOffsetY_B() <= 0 || this.B - e.a(this.f21686c, this.A.getLogBtnHeight() + this.A.getLogBtnOffsetY_B()) <= 0) {
            layoutParams2.addRule(10, -1);
            layoutParams2.setMargins(e.a(this.f21686c, max), 0, e.a(this.f21686c, max2), 0);
        } else {
            com.cmic.gen.sdk.tencent.e.c.b(f21685a, "logBtn_bottom");
            layoutParams2.addRule(12, -1);
            layoutParams2.setMargins(e.a(this.f21686c, max), 0, e.a(this.f21686c, max2), e.a(this.f21686c, this.A.getLogBtnOffsetY_B()));
        }
        this.d.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.q.getLayoutParams();
        int privacyMarginLeft = this.A.getPrivacyMarginLeft() >= 0 ? this.A.getCheckedImgWidth() > 30 ? this.A.getPrivacyMarginLeft() : this.A.getPrivacyMarginLeft() - (30 - this.A.getCheckedImgWidth()) : this.A.getCheckedImgWidth() > 30 ? 0 : -(30 - this.A.getCheckedImgWidth());
        int max3 = Math.max(this.A.getPrivacyMarginRight(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.q.measure(makeMeasureSpec2, makeMeasureSpec2);
        if (this.A.getPrivacyOffsetY() > 0 || this.A.getPrivacyOffsetY_B() < 0) {
            if (this.A.getPrivacyOffsetY() <= 0 || (this.B - this.q.getMeasuredHeight()) - e.a(this.f21686c, this.A.getPrivacyOffsetY()) <= 0) {
                String str2 = f21685a;
                com.cmic.gen.sdk.tencent.e.c.b(str2, "privacy_bottom=" + privacyMarginLeft);
                layoutParams3.addRule(12, -1);
                layoutParams3.setMargins(e.a(this.f21686c, (float) privacyMarginLeft), 0, e.a(this.f21686c, (float) max3), 0);
            } else {
                String str3 = f21685a;
                com.cmic.gen.sdk.tencent.e.c.b(str3, "privacy_top = " + this.q.getMeasuredHeight());
                layoutParams3.addRule(10, -1);
                layoutParams3.setMargins(e.a(this.f21686c, (float) privacyMarginLeft), e.a(this.f21686c, (float) this.A.getPrivacyOffsetY()), e.a(this.f21686c, (float) max3), 0);
            }
        } else if (this.A.getPrivacyOffsetY_B() <= 0 || (this.B - this.q.getMeasuredHeight()) - e.a(this.f21686c, this.A.getPrivacyOffsetY_B()) <= 0) {
            layoutParams3.addRule(10, -1);
            layoutParams3.setMargins(e.a(this.f21686c, privacyMarginLeft), 0, e.a(this.f21686c, max3), 0);
            com.cmic.gen.sdk.tencent.e.c.b(f21685a, "privacy_top");
        } else {
            String str4 = f21685a;
            com.cmic.gen.sdk.tencent.e.c.b(str4, "privacy_bottom=" + this.q.getMeasuredHeight());
            layoutParams3.addRule(12, -1);
            layoutParams3.setMargins(e.a(this.f21686c, (float) privacyMarginLeft), 0, e.a(this.f21686c, (float) max3), e.a(this.f21686c, (float) this.A.getPrivacyOffsetY_B()));
        }
        this.q.setLayoutParams(layoutParams3);
    }

    private void f() {
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().addFlags(67108864);
            getWindow().addFlags(134217728);
            if (this.A.getStatusBarColor() != 0) {
                getWindow().addFlags(Integer.MIN_VALUE);
                getWindow().clearFlags(67108864);
                getWindow().setStatusBarColor(this.A.getStatusBarColor());
                getWindow().setNavigationBarColor(this.A.getStatusBarColor());
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.A.isLightColor()) {
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().getDecorView().setSystemUiVisibility(0);
            }
        }
        ViewGroup relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        View contentView = this.A.getContentView();
        if (contentView != null) {
            ViewParent parent = contentView.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(contentView);
            }
            relativeLayout.addView(contentView);
        } else if (this.A.getLayoutResID() != -1) {
            getLayoutInflater().inflate(this.A.getLayoutResID(), relativeLayout);
        }
        setContentView(relativeLayout);
        int requestedOrientation = getRequestedOrientation();
        this.B = e.b(this.f21686c);
        int a2 = e.a(this.f21686c);
        this.C = a2;
        if ((requestedOrientation == 1 && a2 > this.B) || (requestedOrientation == 0 && this.C < this.B)) {
            int i = this.C;
            this.C = this.B;
            this.B = i;
        }
        com.cmic.gen.sdk.tencent.e.c.b(f21685a, "orientation = " + requestedOrientation + "--screenWidth = " + this.C + "--screenHeight = " + this.B);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (this.A.getWindowWidth() != 0) {
            getWindow().getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            getWindowManager().getDefaultDisplay().getSize(new Point());
            attributes.width = e.a(this.f21686c, this.A.getWindowWidth());
            attributes.height = e.a(this.f21686c, this.A.getWindowHeight());
            this.C = attributes.width;
            this.B = attributes.height;
            attributes.x = e.a(this.f21686c, this.A.getWindowX());
            if (this.A.getWindowBottom() == 1) {
                getWindow().setGravity(80);
            } else {
                attributes.y = e.a(this.f21686c, this.A.getWindowY());
            }
            getWindow().setAttributes(attributes);
        }
        relativeLayout.setFitsSystemWindows(this.A.isFitsSystemWindows());
        relativeLayout.setClipToPadding(true);
        try {
            g();
            relativeLayout.addView(this.r);
            relativeLayout.addView(h());
            relativeLayout.addView(i());
            e();
            this.d.setOnClickListener(this);
            this.x.setOnClickListener(this);
            this.p.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cmic.gen.sdk.tencent.view.GenLoginAuthActivity.7
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    CheckBox checkBox;
                    GenLoginAuthActivity genLoginAuthActivity;
                    String str;
                    Tracker.onCheckedChanged(compoundButton, z);
                    GenLoginAuthActivity.this.A.getGenCheckedChangeListener().onCheckedChanged(z);
                    if (z) {
                        GenLoginAuthActivity.this.d.setEnabled(true);
                        try {
                            GenLoginAuthActivity.this.p.setBackgroundResource(com.cmic.gen.sdk.tencent.view.c.b(GenLoginAuthActivity.this, GenLoginAuthActivity.this.A.getCheckedImgPath()));
                            return;
                        } catch (Exception e) {
                            checkBox = GenLoginAuthActivity.this.p;
                            genLoginAuthActivity = GenLoginAuthActivity.this;
                            str = "umcsdk_check_image";
                        }
                    } else {
                        RelativeLayout relativeLayout2 = GenLoginAuthActivity.this.d;
                        boolean z2 = true;
                        if (GenLoginAuthActivity.this.A.getGenCheckBoxListener() == null) {
                            z2 = !TextUtils.isEmpty(GenLoginAuthActivity.this.A.getCheckTipText());
                        }
                        relativeLayout2.setEnabled(z2);
                        try {
                            GenLoginAuthActivity.this.p.setBackgroundResource(com.cmic.gen.sdk.tencent.view.c.b(GenLoginAuthActivity.this, GenLoginAuthActivity.this.A.getUncheckedImgPath()));
                            return;
                        } catch (Exception e2) {
                            checkBox = GenLoginAuthActivity.this.p;
                            genLoginAuthActivity = GenLoginAuthActivity.this;
                            str = "umcsdk_uncheck_image";
                        }
                    }
                    checkBox.setBackgroundResource(com.cmic.gen.sdk.tencent.view.c.b(genLoginAuthActivity, str));
                }
            });
            k();
            try {
                if (this.A.isPrivacyState()) {
                    this.p.setChecked(true);
                    this.p.setBackgroundResource(com.cmic.gen.sdk.tencent.view.c.b(this, this.A.getCheckedImgPath()));
                    this.d.setEnabled(true);
                    return;
                }
                this.p.setChecked(false);
                RelativeLayout relativeLayout2 = this.d;
                boolean z = true;
                if (this.A.getGenCheckBoxListener() == null) {
                    z = !TextUtils.isEmpty(this.A.getCheckTipText());
                }
                relativeLayout2.setEnabled(z);
                this.p.setBackgroundResource(com.cmic.gen.sdk.tencent.view.c.b(this, this.A.getUncheckedImgPath()));
            } catch (Exception e) {
                this.p.setChecked(false);
            }
        } catch (Exception e2) {
            com.cmic.gen.sdk.tencent.d.c.b.add(e2);
            e2.printStackTrace();
            com.cmic.gen.sdk.tencent.e.c.a(f21685a, e2.toString());
            a("200040", "UI资源加载异常", this.m, null);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(1:3)(11:22|(2:24|(1:26)(1:27))|5|6|7|(1:9)|10|11|12|13|14)|4|5|6|7|(0)|10|11|12|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00bd, code lost:
        r0.setTextSize(2, 18.0f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0103, code lost:
        r0.setTextColor(-13421773);
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g() {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.gen.sdk.tencent.view.GenLoginAuthActivity.g():void");
    }

    private RelativeLayout h() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.d = relativeLayout;
        relativeLayout.setId(17476);
        this.d.setLayoutParams(new RelativeLayout.LayoutParams(e.a(this.f21686c, this.A.getLogBtnWidth()), e.a(this.f21686c, this.A.getLogBtnHeight())));
        TextView textView = new TextView(this);
        textView.setTextSize(2, this.A.getLogBtnTextSize());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        textView.setLayoutParams(layoutParams);
        if (this.A.isLogBtnTextBold()) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        this.d.addView(textView);
        textView.setText(this.A.getLogBtnText());
        try {
            textView.setTextColor(this.A.getLogBtnTextColor());
        } catch (Exception e) {
            textView.setTextColor(-1);
        }
        try {
            this.d.setBackgroundResource(com.cmic.gen.sdk.tencent.view.c.b(this.f21686c, this.A.getLogBtnBackgroundPath()));
        } catch (Exception e2) {
            e2.printStackTrace();
            this.d.setBackgroundResource(com.cmic.gen.sdk.tencent.view.c.b(this.f21686c, "umcsdk_login_btn_bg"));
        }
        return this.d;
    }

    private RelativeLayout i() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.q = relativeLayout;
        relativeLayout.setHorizontalGravity(1);
        this.q.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int checkedImgWidth = this.A.getCheckedImgWidth();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(e.a(this.f21686c, Math.max(checkedImgWidth, 30)), e.a(this.f21686c, Math.max(this.A.getCheckedImgHeight(), 30)));
        if (this.A.getCheckBoxLocation() == 1) {
            layoutParams.addRule(15, -1);
        }
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        this.x = relativeLayout2;
        relativeLayout2.setId(34952);
        this.x.setLayoutParams(layoutParams);
        CheckBox checkBox = new CheckBox(this);
        this.p = checkBox;
        checkBox.setChecked(false);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(e.a(this.f21686c, this.A.getCheckedImgWidth()), e.a(this.f21686c, this.A.getCheckedImgHeight()));
        layoutParams2.setMargins(e.a(this.f21686c, checkedImgWidth > 30 ? 0.0f : 30 - checkedImgWidth), 0, 0, 0);
        layoutParams2.addRule(11, -1);
        if (this.A.getCheckBoxLocation() == 1) {
            layoutParams2.addRule(15, -1);
        }
        this.p.setLayoutParams(layoutParams2);
        this.x.addView(this.p);
        this.q.addView(this.x);
        TextView textView = new TextView(this);
        textView.setTextSize(2, this.A.getPrivacyTextSize());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(e.a(this.f21686c, 5.0f), 0, 0, e.a(this.f21686c, 5.0f));
        layoutParams3.addRule(1, 34952);
        textView.setLayoutParams(layoutParams3);
        this.q.addView(textView);
        textView.setTextColor(this.A.getClauseBaseColor());
        textView.setText(e.a(this, this.z, this.y, this.e, this.j, this.k));
        textView.setLineSpacing(8.0f, 1.0f);
        textView.setIncludeFontPadding(false);
        if (this.A.isPrivacyTextBold()) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        if (this.A.isPrivacyTextGravityCenter()) {
            textView.setGravity(17);
        }
        textView.setHighlightColor(getResources().getColor(17170445));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.p.setButtonDrawable(new ColorDrawable());
        try {
            this.p.setBackgroundResource(com.cmic.gen.sdk.tencent.view.c.b(this, this.A.getUncheckedImgPath()));
        } catch (Exception e) {
            this.p.setBackgroundResource(com.cmic.gen.sdk.tencent.view.c.b(this, "umcsdk_uncheck_image"));
        }
        return this.q;
    }

    private String j() {
        this.z = this.A.getPrivacy();
        if (this.A.isPrivacyBookSymbol()) {
            this.y = String.format("《%s》", this.y);
        }
        if (this.z.contains(GenAuthThemeConfig.PLACEHOLDER)) {
            this.z = this.z.replace(GenAuthThemeConfig.PLACEHOLDER, this.y);
        }
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.d.setClickable(true);
        this.p.setClickable(true);
    }

    private void l() {
        this.d.setClickable(false);
        this.p.setClickable(false);
    }

    private void m() {
        try {
            if (this.t >= 5) {
                Toast.makeText(this.f21686c, "网络不稳定,请返回重试其他登录方式", 1).show();
                this.d.setClickable(true);
                return;
            }
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb = new StringBuilder();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i2];
                com.cmic.gen.sdk.tencent.e.c.a("stack", stackTraceElement.getClassName());
                String className = stackTraceElement.getClassName();
                if (!TextUtils.isEmpty(className) && className.contains("com.cmic.gen.sdk.tencent.activity") && !sb.toString().contains(className)) {
                    sb.append(className);
                    sb.append(";");
                }
                i = i2 + 1;
            }
            this.m.a("loginTime", System.currentTimeMillis());
            String b2 = this.m.b("traceId", "");
            if (!TextUtils.isEmpty(b2) && com.cmic.gen.sdk.tencent.e.e.a(b2)) {
                String c2 = q.c();
                this.m.a("traceId", c2);
                com.cmic.gen.sdk.tencent.e.e.a(c2, this.v);
            }
            b();
            l();
            c cVar = new c(this.m);
            this.b.postDelayed(cVar, GenAuthnHelper.getInstance((Context) this).getOverTime());
            n.a(new b(this, cVar));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a() {
        this.b.removeCallbacksAndMessages(null);
        d dVar = this.e;
        if (dVar != null && dVar.isShowing()) {
            this.e.dismiss();
        }
        d dVar2 = this.f;
        if (dVar2 != null && dVar2.isShowing()) {
            this.f.dismiss();
        }
        c();
        this.E = null;
        if (0 != 0) {
            throw new NullPointerException();
        }
        this.q.clearAnimation();
        finish();
        if (this.A.getAuthPageActOut() == null || this.A.getActivityIn() == null) {
            return;
        }
        overridePendingTransition(com.cmic.gen.sdk.tencent.view.c.c(this, this.A.getActivityIn()), com.cmic.gen.sdk.tencent.view.c.c(this, this.A.getAuthPageActOut()));
    }

    public void b() {
        com.cmic.gen.sdk.tencent.e.c.a(f21685a, "loginClickStart");
        try {
            this.D = true;
            if (this.A.getGenLoginClickListener() != null) {
                this.A.getGenLoginClickListener().onLoginClickStart(this.f21686c, null);
            } else if (this.E != null) {
                this.E.show();
                return;
            } else {
                AlertDialog create = new AlertDialog.Builder(this).create();
                this.E = create;
                create.setCancelable(false);
                this.E.setCanceledOnTouchOutside(false);
                this.E.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.cmic.gen.sdk.tencent.view.GenLoginAuthActivity.8
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        return i == 4;
                    }
                });
                RelativeLayout relativeLayout = new RelativeLayout(this.E.getContext());
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                ImageView imageView = new ImageView(this.E.getContext());
                imageView.setImageResource(com.cmic.gen.sdk.tencent.view.c.b(this.f21686c, "dialog_loading"));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(80, 80);
                layoutParams.addRule(13, -1);
                relativeLayout.addView(imageView, layoutParams);
                if (this.E.getWindow() != null) {
                    this.E.getWindow().setDimAmount(0.0f);
                }
                this.E.show();
                this.E.setContentView(relativeLayout);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.cmic.gen.sdk.tencent.e.c.a(f21685a, "loginClickStart");
    }

    public void c() {
        try {
            com.cmic.gen.sdk.tencent.e.c.a(f21685a, "loginClickComplete");
            if (this.A.getGenLoginClickListener() != null && this.D) {
                this.D = false;
                this.A.getGenLoginClickListener().onLoginClickComplete(this.f21686c, null);
            } else if (this.E == null || !this.E.isShowing()) {
            } else {
                this.E.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        Tracker.dispatchTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        try {
            int id = view.getId();
            if (id != 17476) {
                if (id == 26214) {
                    a(false);
                    return;
                } else if (id != 34952) {
                    return;
                } else {
                    if (this.p.isChecked()) {
                        this.p.setChecked(false);
                        return;
                    } else {
                        this.p.setChecked(true);
                        return;
                    }
                }
            }
            if (!this.p.isChecked()) {
                if (this.A.getPrivacyAnimation() != null) {
                    this.q.startAnimation(AnimationUtils.loadAnimation(this.f21686c, com.cmic.gen.sdk.tencent.view.c.c(this.f21686c, this.A.getPrivacyAnimation())));
                }
                if (this.A.getGenCheckBoxListener() != null) {
                    this.A.getGenCheckBoxListener().onLoginClick(this.f21686c, null);
                    return;
                } else if (!TextUtils.isEmpty(this.A.getCheckTipText())) {
                    Toast.makeText(this.f21686c, this.A.getCheckTipText(), 1).show();
                    return;
                }
            }
            this.t++;
            m();
        } catch (Exception e) {
            com.cmic.gen.sdk.tencent.d.c.b.add(e);
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            if (bundle != null) {
                finish();
            }
            this.f21686c = this;
            GenAuthThemeConfig authThemeConfig = GenAuthnHelper.getInstance((Context) this).getAuthThemeConfig();
            this.A = authThemeConfig;
            if (authThemeConfig != null) {
                if (authThemeConfig.getThemeId() != -1) {
                    setTheme(this.A.getThemeId());
                }
                if (this.A.getAuthPageActIn() != null && this.A.getActivityOut() != null) {
                    overridePendingTransition(com.cmic.gen.sdk.tencent.view.c.c(this, this.A.getAuthPageActIn()), com.cmic.gen.sdk.tencent.view.c.c(this, this.A.getActivityOut()));
                }
            }
            com.cmic.gen.sdk.tencent.d.a.a("authPageIn");
            this.s = System.currentTimeMillis();
            this.n = com.cmic.gen.sdk.tencent.auth.a.a(this);
            d();
            f();
        } catch (Exception e) {
            if (this.m == null) {
                this.m = new com.cmic.gen.sdk.tencent.a(0);
            }
            this.m.a().f21653a.add(e);
            com.cmic.gen.sdk.tencent.e.c.a(f21685a, e.toString());
            e.printStackTrace();
            a("200025", "发生未知错误", this.m, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        try {
            this.b.removeCallbacksAndMessages(null);
            com.cmic.gen.sdk.tencent.d.a.a("timeOnAuthPage", (System.currentTimeMillis() - this.s) + "");
            com.cmic.gen.sdk.tencent.d.a.a("authPrivacyState", this.p.isChecked() ? "1" : "0");
            com.cmic.gen.sdk.tencent.d.a.a(this.f21686c.getApplicationContext(), this.m);
            com.cmic.gen.sdk.tencent.d.a.a();
            this.E = null;
            com.cmic.gen.sdk.tencent.view.b.a().c();
            this.u.removeCallbacksAndMessages(null);
        } catch (Exception e) {
            com.cmic.gen.sdk.tencent.e.c.a(f21685a, "GenLoginAuthActivity clear failed");
            com.cmic.gen.sdk.tencent.d.c.b.add(e);
            e.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4 && !keyEvent.isCanceled() && keyEvent.getRepeatCount() == 0) {
            if (this.A.getGenBackPressedListener() != null) {
                this.A.getGenBackPressedListener().onBackPressed();
            }
            if (this.A.getWindowWidth() == 0 || this.A.isBackButton()) {
                a(false);
                return true;
            }
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            if (this.m != null) {
                this.m.a("loginMethod", "loginAuth");
            }
            GenAuthnHelper.getInstance((Context) this).loginPageInCallBack("200087", null);
        } catch (Exception e) {
            this.m.a().f21653a.add(e);
            a("200025", "发生未知错误", this.m, null);
        }
    }
}
