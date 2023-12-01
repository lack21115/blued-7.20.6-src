package com.soft.blued.ui.setting.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import com.blued.android.chat.IMDebuger;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.pool.ThreadPriority;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.LogUploadHelper;
import com.blued.android.framework.utils.RegExpUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.NetworkUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.blued.android.module.im.biz.IMConnectorDebuger;
import com.blued.android.web.SimpleWebCallBack;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.soft.blued.R;
import com.soft.blued.tinker.util.TinkerTools;
import com.soft.blued.ui.msg.controller.tools.IMManager;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.PhoneUtils;
import com.soft.blued.utils.third.HuaweiChannelUtils;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/DebugFragment.class */
public class DebugFragment extends BaseFragment implements View.OnClickListener {
    private String D;
    private String E;
    private int F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String M;
    private String N;
    private String O;
    private Context P;
    private ScrollView R;
    private TextView S;
    private String T;
    private String U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private String Z;
    private String aa;
    private String ab;
    private String ac;
    private String ad;
    private String ae;
    private String af;
    private String ag;
    private View l;
    private CommonTopTitleNoTrans m;
    private ShapeTextView n;
    private ShapeTextView o;
    private ShapeTextView p;
    private ProgressBar q;
    private ProgressBar r;
    private TextView s;
    private TextView t;
    private TextView u;
    private ShapeTextView v;
    private ShapeTextView w;
    private WebView x;
    private BluedWebView y;
    private View z;

    /* renamed from: a  reason: collision with root package name */
    private final String[] f19648a = {"https://www.bldimg.com/test_img_10k.jpg", "https://static.blued.com/test_img_10k.jpg", "https://staticsg.bldimg.com/test_img_10k.jpg", "https://staticus.bldimg.com/test_img_10k.jpg"};
    private final String b = "https://" + BluedHttpUrl.t();

    /* renamed from: c  reason: collision with root package name */
    private final String f19649c = "https://" + BluedHttpUrl.z();
    private final String d = BluedHttpUrl.q();
    private final String e = "https://app.blued.cn/intl/speed-test";
    private final String f = BluedHttpUrl.r();
    private final String g = "https://www.baidu.com";
    private final String h = "http://pv.sohu.com/cityjson?ie=utf-8";
    private final String i = "https://pay.blued.com";
    private final String j = "https://www.google.com";
    private final String k = "https://ifconfig.co/json";
    private boolean A = false;
    private int B = 0;
    private int C = 13;
    private String L = "";
    private int Q = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.setting.fragment.DebugFragment$7  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/DebugFragment$7.class */
    public class AnonymousClass7 extends StringHttpResponseHandler {

        /* renamed from: a  reason: collision with root package name */
        String f19660a;

        AnonymousClass7(boolean z) {
            super(z);
            this.f19660a = "";
        }

        /* renamed from: a */
        public void onSuccess(String str) {
            this.f19660a = str;
        }

        /* renamed from: a */
        public void onFailure(Throwable th, int i, String str) {
            super.onFailure(th, i, str);
            this.f19660a = "failure, code:" + i;
        }

        public void onFinish() {
            super.onFinish();
            DebugFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.DebugFragment.7.1
                @Override // java.lang.Runnable
                public void run() {
                    DebugFragment.this.m.b();
                    DebugFragment.this.r.setVisibility(8);
                    DebugFragment.this.u.setText(AnonymousClass7.this.f19660a);
                }
            });
        }
    }

    private void a() {
        final EditText editText = (EditText) this.l.findViewById(R.id.et_uid_input);
        TextView textView = (TextView) this.l.findViewById(R.id.tv_go);
        final TextView textView2 = (TextView) this.l.findViewById(R.id.tv_result);
        View findViewById = this.l.findViewById(R.id.tv_decrypt);
        this.z = this.l.findViewById(R.id.ll_debug);
        if (AppInfo.m()) {
            this.z.setVisibility(0);
        } else {
            this.z.setVisibility(8);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$DebugFragment$DsLiRZWNDbY-so0QqekLDDRHLiM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugFragment.this.a(editText, view);
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.DebugFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                try {
                    textView2.setText(AesCrypto2.a(editText.getText().toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                    textView2.setText(e.toString());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        String[] strArr = this.f19648a;
        if (i >= strArr.length) {
            return;
        }
        String str = strArr[i];
        FileDownloader.a(str, RecyclingUtils.e(str), new FileHttpResponseHandler() { // from class: com.soft.blued.ui.setting.fragment.DebugFragment.6

            /* renamed from: a  reason: collision with root package name */
            Long f19657a = Long.valueOf(System.currentTimeMillis());
            boolean b = false;

            /* renamed from: a */
            public void onSuccess(File file) {
            }

            /* renamed from: a */
            public void onFailure(Throwable th, int i2, File file) {
                this.b = true;
            }

            public void onFinish() {
                super.onFinish();
                String str2 = this.b ? " ms/failure" : " ms/success";
                int i2 = i;
                if (i2 == 0) {
                    DebugFragment debugFragment = DebugFragment.this;
                    debugFragment.ad = (System.currentTimeMillis() - this.f19657a.longValue()) + str2;
                } else if (i2 == 1) {
                    DebugFragment debugFragment2 = DebugFragment.this;
                    debugFragment2.ae = (System.currentTimeMillis() - this.f19657a.longValue()) + str2;
                } else if (i2 == 2) {
                    DebugFragment debugFragment3 = DebugFragment.this;
                    debugFragment3.af = (System.currentTimeMillis() - this.f19657a.longValue()) + str2;
                } else if (i2 == 3) {
                    DebugFragment debugFragment4 = DebugFragment.this;
                    debugFragment4.ag = (System.currentTimeMillis() - this.f19657a.longValue()) + str2;
                }
                DebugFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.DebugFragment.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DebugFragment.g(DebugFragment.this);
                        DebugFragment.this.e();
                        DebugFragment.this.a(i + 1);
                    }
                });
            }
        }, (IRequestHost) null);
    }

    public static void a(Context context) {
        TerminalActivity.d(context, DebugFragment.class, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(EditText editText, View view) {
        Tracker.onClick(view);
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.uid = editText.getText().toString();
        UserInfoFragmentNew.a(this.P, userBasicModel, "", false, new MsgSourceEntity(MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE));
    }

    private void a(final String str) {
        ThreadManager.a().a(new ThreadExecutor("getIp", ThreadPriority.b) { // from class: com.soft.blued.ui.setting.fragment.DebugFragment.4
            public void execute() {
                String str2;
                try {
                    String[] query = HappyDnsUtils.d().query(new URL(str).getHost());
                    str2 = "x.x.x.x";
                    if (query != null) {
                        str2 = "x.x.x.x";
                        if (query.length > 0) {
                            str2 = query[0];
                        }
                    }
                } catch (IOException e) {
                    str2 = "x.x.x.x";
                }
                if (str.equals(DebugFragment.this.b)) {
                    DebugFragment.this.V = str2;
                } else if (str.equals(DebugFragment.this.f19649c)) {
                    DebugFragment.this.W = str2;
                } else if (str.equals(DebugFragment.this.d)) {
                    DebugFragment.this.X = str2;
                } else if (str.equals(DebugFragment.this.f) || str.equals("https://pay.blued.com")) {
                    DebugFragment.this.Y = str2;
                } else if (str.equals(DebugFragment.this.f19648a[0])) {
                    DebugFragment.this.Z = str2;
                } else if (str.equals(DebugFragment.this.f19648a[1])) {
                    DebugFragment.this.aa = str2;
                } else if (str.equals(DebugFragment.this.f19648a[2])) {
                    DebugFragment.this.ab = str2;
                } else if (str.equals(DebugFragment.this.f19648a[3])) {
                    DebugFragment.this.ac = str2;
                }
                DebugFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.DebugFragment.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DebugFragment.g(DebugFragment.this);
                        DebugFragment.this.e();
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view) {
        c(this.s.getText().toString());
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b() {
        CommonTopTitleNoTrans findViewById = this.l.findViewById(2131370694);
        this.m = findViewById;
        findViewById.setLeftClickListener(this);
        this.m.setRightClickListener(this);
        this.m.setRightTextColor(2131102254);
        ShapeTextView findViewById2 = this.l.findViewById(R.id.tab_bg);
        this.w = findViewById2;
        ShapeHelper.b(findViewById2, 2131102360);
        ShapeTextView findViewById3 = this.l.findViewById(R.id.tv_basic_switch);
        this.n = findViewById3;
        ShapeHelper.b(findViewById3, 2131102361);
        ShapeHelper.a(this.n, 2131102254);
        this.n.setOnClickListener(this);
        ShapeTextView findViewById4 = this.l.findViewById(R.id.tv_im_switch);
        this.p = findViewById4;
        ShapeHelper.b(findViewById4, 2131102360);
        ShapeHelper.a(this.p, 2131102254);
        this.p.setOnClickListener(this);
        ShapeTextView findViewById5 = this.l.findViewById(R.id.tv_speed_web_switch);
        this.o = findViewById5;
        ShapeHelper.b(findViewById5, 2131102360);
        ShapeHelper.a(this.o, 2131102254);
        this.o.setOnClickListener(this);
        this.R = (ScrollView) this.l.findViewById(R.id.sv_im_detail);
        this.S = (TextView) this.l.findViewById(R.id.tv_im_detail);
        WebView webView = (WebView) this.l.findViewById(R.id.speed_web_view);
        this.x = webView;
        webView.setBackgroundColor(BluedSkinUtils.a(this.P, 2131101796));
        this.y = new BluedWebView(this, this.x, (ViewGroup) null, new SimpleWebCallBack() { // from class: com.soft.blued.ui.setting.fragment.DebugFragment.2
            public void a(BluedWebView bluedWebView, int i, String str, String str2) {
                DebugFragment.this.A = false;
                AppMethods.d(2131887272);
            }

            public void a(BluedWebView bluedWebView, String str, boolean z) {
                DebugFragment.this.A = true;
            }
        });
        TextView textView = (TextView) this.l.findViewById(R.id.tv_basic_info_view);
        this.s = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$DebugFragment$RJ6YuSfLNtrwb1rMy1q4lExz_fs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DebugFragment.this.b(view);
            }
        });
        this.t = (TextView) this.l.findViewById(R.id.tv_network_info_view);
        this.u = (TextView) this.l.findViewById(R.id.tv_report_view);
        this.q = (ProgressBar) this.l.findViewById(R.id.pb_network);
        this.r = (ProgressBar) this.l.findViewById(R.id.pb_report);
        ShapeTextView findViewById6 = this.l.findViewById(R.id.tv_info_upload);
        this.v = findViewById6;
        findViewById6.setVisibility(8);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Tracker.onClick(view);
        int i = this.Q;
        if (i < 7) {
            this.Q = i + 1;
            return;
        }
        File file = new File(AppMethods.b(""), "patch_signed_7zip.apk");
        if (file.exists()) {
            File file2 = new File(CommonTools.a(), "patch_signed_7zip.apk");
            if (AppMethods.a(file.getAbsolutePath(), file2.getAbsolutePath(), true)) {
                TinkerInstaller.onReceiveUpgradePatch(AppInfo.d(), file2.getAbsolutePath());
                AppMethods.a("patch安装完成，请重启APP验证patch是否生效");
                file.delete();
            } else {
                AppMethods.a("patch文件复制失败");
            }
        } else {
            AppMethods.a("patch文件不存在，请检查路径和文件名");
        }
        this.Q = 0;
    }

    private void b(final String str) {
        HttpManager.a(str, new StringHttpResponseHandler(true) { // from class: com.soft.blued.ui.setting.fragment.DebugFragment.5
            /* renamed from: a */
            public void onSuccess(String str2) {
                if (str.equals("https://www.baidu.com") || str.contains("https://www.google.com")) {
                    DebugFragment.this.T = BasicPushStatus.SUCCESS_CODE;
                } else if (str.equals("http://pv.sohu.com/cityjson?ie=utf-8") || str.equals("https://ifconfig.co/json")) {
                    DebugFragment.this.U = str2;
                }
            }

            /* renamed from: a */
            public void onFailure(Throwable th, int i, String str2) {
                super.onFailure(th, i, str2);
                if (str.equals("https://www.baidu.com") || str.contains("https://www.google.com")) {
                    DebugFragment.this.T = String.valueOf(i);
                } else if (str.equals("http://pv.sohu.com/cityjson?ie=utf-8") || str.equals("https://ifconfig.co/json")) {
                    DebugFragment.this.U = String.valueOf(i);
                }
            }

            public void onFinish() {
                super.onFinish();
                DebugFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.setting.fragment.DebugFragment.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DebugFragment.g(DebugFragment.this);
                        DebugFragment.this.e();
                    }
                });
            }
        }, getFragmentActive()).b(BluedHttpTools.a(false)).h();
    }

    private void c() {
        this.q.setVisibility(0);
        this.m.a();
        this.T = "";
        this.U = "";
        this.V = "";
        this.W = "";
        this.X = "";
        this.Y = "";
        this.Z = "";
        this.aa = "";
        this.ab = "";
        this.ac = "";
        this.ad = "";
        this.ae = "";
        this.af = "";
        this.ag = "";
        this.D = AppInfo.e();
        this.E = UserInfo.getInstance().getLoginUserInfo().getName();
        this.F = DeviceUtils.b();
        this.G = TinkerTools.a();
        this.H = AppInfo.c;
        this.I = TimeZone.getDefault().getID();
        this.J = AppInfo.d + "_" + AppMethods.a();
        this.K = BlueAppLocal.c().getLanguage();
        String d = NetworkUtils.d();
        this.L = d;
        if (TextUtils.isEmpty(d)) {
            this.L = "no network";
        } else if (!TextUtils.equals(this.L, "wifi")) {
            this.L += " " + PhoneUtils.a();
        }
        this.M = IMDebuger.getIMInformation();
        this.N = IMDebuger.getLastReceivePackageInfo();
        this.O = IMConnectorDebuger.c() + ", " + IMConnectorDebuger.d();
        a(this.b);
        a(this.f19649c);
        a(this.d);
        a("1".equals(this.D) ? this.f : "https://pay.blued.com");
        int i = 0;
        while (true) {
            int i2 = i;
            String[] strArr = this.f19648a;
            if (i2 >= strArr.length) {
                break;
            }
            a(strArr[i2]);
            i = i2 + 1;
        }
        b("1".equals(this.D) ? "https://www.baidu.com" : "https://www.google.com");
        b("1".equals(this.D) ? "http://pv.sohu.com/cityjson?ie=utf-8" : "https://ifconfig.co/json");
        a(0);
    }

    private void c(String str) {
        if (Build.VERSION.SDK_INT != 18) {
            ClipboardManager clipboardManager = (ClipboardManager) this.P.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData newPlainText = ClipData.newPlainText("simple text", RegExpUtils.a(str));
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(newPlainText);
            }
        } else {
            ((android.text.ClipboardManager) this.P.getSystemService(Context.CLIPBOARD_SERVICE)).setText(RegExpUtils.a(str));
        }
        AppMethods.a(this.P.getResources().getString(R.string.copy));
    }

    private void d() {
        this.r.setVisibility(0);
        HashMap hashMap = new HashMap();
        hashMap.put("contents", ((Object) this.s.getText()) + "\n" + ((Object) this.t.getText()));
        HttpManager.b(BluedHttpUrl.q() + "/blued/monitor/report", new AnonymousClass7(true)).b(BluedHttpTools.a(true)).a(BluedHttpTools.a(hashMap)).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        String str;
        try {
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            Long l = 1691982355534L;
            calendar.setTimeInMillis(l.longValue());
            str = new SimpleDateFormat("yyyy-MM-dd,HH:mm", BlueAppLocal.c()).format(calendar.getTime());
        } catch (Exception e) {
            str = "";
        }
        String str2 = "Name:" + this.E + "    Language:" + this.K + "\nApp version:" + this.F + "    patch:" + this.G + "    Channel:" + this.H + "\nTimezone:" + this.I + "\nDevices:" + this.J + "\n" + ("Oaid:" + BluedDeviceIdentity.a().h() + "\n") + "Build Time:" + str;
        String str3 = str2;
        if (AppInfo.m()) {
            str3 = str2;
            if (b(this.P) != null) {
                str3 = str2;
                if (b(this.P).length == 2) {
                    str3 = str2 + "\nDevice Info:{\"device_id\"=\"" + b(this.P)[0] + "\",\"mac\":\"" + b(this.P)[1] + "\"}";
                }
            }
        }
        String str4 = str3;
        if (AppInfo.c.equalsIgnoreCase("a0031a")) {
            str4 = str3 + "\nTrackID:" + HuaweiChannelUtils.a(this.P);
        }
        this.s.setText((str4 + "\nIM gRPC:" + FlexDebugSevConfig.a().d() + ", state:" + IMManager.a().f18547a) + "\nLive gRPC:" + FlexDebugSevConfig.a().e());
        this.s.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$DebugFragment$lno-0VolOaXvWFteWLPtuSZr73c
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean a2;
                a2 = DebugFragment.this.a(view);
                return a2;
            }
        });
        this.t.setText("Network:" + this.L + "\nWeb Test:" + this.T + "\nIfconfig:" + this.U + "\n\nIM State:" + this.M + "\nLast Package:" + this.N + "\n\n" + this.O + "\n\nh4-->" + this.V + "\nh8-->" + this.W + "\nar-->" + this.X + "\npa-->" + this.Y + "\n\nww-->" + this.Z + "    " + this.ad + "\nst-->" + this.aa + "    " + this.ae + "\nsg-->" + this.ab + "    " + this.af + "\nus-->" + this.ac + "    " + this.ag);
        if (this.B == this.C) {
            this.B = 0;
            this.q.setVisibility(8);
            d();
        }
    }

    static /* synthetic */ int g(DebugFragment debugFragment) {
        int i = debugFragment.B;
        debugFragment.B = i + 1;
        return i;
    }

    public String[] b(Context context) {
        String[] strArr = new String[2];
        if (context != null) {
            try {
                strArr[0] = DeviceConfig.getDeviceIdForGeneral(context);
                strArr[1] = DeviceConfig.getMac(context);
            } catch (Exception e) {
                return strArr;
            }
        }
        return strArr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case 2131363120:
                getActivity().finish();
                return;
            case 2131363126:
                this.u.setText("");
                c();
                return;
            case R.id.tv_basic_switch /* 2131370964 */:
                this.x.setVisibility(8);
                this.R.setVisibility(8);
                ShapeHelper.b(this.n, 2131102361);
                ShapeHelper.b(this.p, 2131102360);
                ShapeHelper.b(this.o, 2131102360);
                return;
            case R.id.tv_im_switch /* 2131371713 */:
                this.x.setVisibility(8);
                this.R.setVisibility(0);
                ShapeHelper.b(this.n, 2131102360);
                ShapeHelper.b(this.p, 2131102361);
                ShapeHelper.b(this.o, 2131102360);
                this.S.setText(IMDebuger.getSocketDetail());
                return;
            case R.id.tv_info_upload /* 2131371721 */:
                this.v.setEnabled(false);
                ShapeHelper.b(this.v, 2131102205);
                this.v.setText("Uploading, please wait.");
                new LogUploadHelper(getActivity().getApplication()).a(BluedHttpUrl.q(), ((Object) this.s.getText()) + "\n\n" + ((Object) this.t.getText()), new LogUploadHelper.OnUploadListener() { // from class: com.soft.blued.ui.setting.fragment.DebugFragment.3
                    public void a() {
                        DebugFragment.this.v.setEnabled(true);
                        Log.e("LogUploadHelper", "onFail");
                        DebugFragment.this.v.setText("Operation failed. Please try again.");
                        AppMethods.a("upload fail");
                    }

                    public void a(String str) {
                        Log.e("LogUploadHelper", "onSuccess");
                        DebugFragment.this.v.setVisibility(8);
                        AppMethods.a("upload success");
                    }
                });
                return;
            case R.id.tv_speed_web_switch /* 2131372628 */:
                this.x.setVisibility(0);
                this.R.setVisibility(8);
                if (!this.A) {
                    this.y.a("https://app.blued.cn/intl/speed-test");
                }
                ShapeHelper.b(this.n, 2131102360);
                ShapeHelper.b(this.p, 2131102360);
                ShapeHelper.b(this.o, 2131102361);
                return;
            default:
                return;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.P = getActivity();
        View view = this.l;
        if (view == null) {
            this.l = layoutInflater.inflate(R.layout.fragment_debug, viewGroup, false);
            b();
            c();
            e();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.l.getParent()).removeView(this.l);
        }
        return this.l;
    }
}
