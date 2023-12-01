package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.android.internal.util.cm.SpamFilter;
import com.anythink.core.api.ATAdConst;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.urlroute.BluedUrlParser;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.common.web.LoaderConstants;
import com.blued.android.module.common.web.jsbridge.BridgeManager;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.common.web.jsbridge.CallBackFunction;
import com.blued.android.module.live.base.model.LiveGiftNumberModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.HTMLNoticeModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveRewardConfigModel;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.view.PopLiveActivityWebView;
import com.blued.android.module.live_china.web.LiveWebCallBack;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopLiveActivityWebView.class */
public class PopLiveActivityWebView extends FrameLayout {
    private int A;
    private long B;
    private HTMLNoticeModel C;
    private int D;
    private PopLiveWebEvent E;
    public View a;
    public View b;
    public View c;
    public Context d;
    public LayoutInflater e;
    private View f;
    private TextView g;
    private ImageView h;
    private boolean i;
    private boolean j;
    private ProgressBar k;
    private BluedWebView l;
    private CardView m;
    private WebView n;
    private ImageView o;
    private FrameLayout p;
    private ImageView q;
    private TextView r;
    private Button s;
    private Fragment t;
    private boolean u;
    private short v;
    private BridgeManager w;
    private String x;
    private String y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.view.PopLiveActivityWebView$8  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopLiveActivityWebView$8.class */
    public class AnonymousClass8 extends LiveWebCallBack {
        AnonymousClass8() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(String str) {
            LogUtils.c("bridgeManager callback: " + str);
        }

        @Override // com.blued.android.module.live_china.web.LiveWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
        public void a(BluedWebView bluedWebView, int i) {
        }

        @Override // com.blued.android.module.live_china.web.LiveWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
        public void a(BluedWebView bluedWebView, int i, String str, String str2) {
        }

        @Override // com.blued.android.module.live_china.web.LiveWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
        public void a(BluedWebView bluedWebView, String str) {
            if (PopLiveActivityWebView.this.i) {
                PopLiveActivityWebView.this.g.setText(str);
            }
        }

        @Override // com.blued.android.module.live_china.web.LiveWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
        public void a(BluedWebView bluedWebView, String str, boolean z) {
            if (PopLiveActivityWebView.this.w != null) {
                PopLiveActivityWebView.this.w.onLoadPageOverrideLoad(bluedWebView, str, z);
            }
        }

        @Override // com.blued.android.module.live_china.web.LiveWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
        public boolean a(BluedWebView bluedWebView, BluedUrlParser bluedUrlParser) {
            String str;
            int i;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            if ("liveplay".equals(bluedUrlParser.a()) && !LiveRoomManager.a().K()) {
                String str7 = bluedUrlParser.b().get("lid");
                String str8 = bluedUrlParser.b().get("uid");
                String str9 = str8;
                if (!TextUtils.isEmpty(str8)) {
                    str9 = EncryptTool.a(str8);
                }
                String str10 = bluedUrlParser.b().get("from");
                String str11 = str10;
                if (TextUtils.isEmpty(str10)) {
                    str11 = "web";
                }
                PlayingOnliveFragment.a(PopLiveActivityWebView.this.getContext(), new LiveRoomData(CommonTools.a(str7), 0, str11, str9, "", "", 0));
                return true;
            }
            int i2 = 0;
            if ("liveroom_card".equals(bluedUrlParser.a())) {
                if (bluedUrlParser.b() != null) {
                    LiveSetDataObserver.a().a(EncryptTool.a(bluedUrlParser.b().get("uid")), 1);
                    return true;
                }
                return false;
            } else if ("liveroom_gift".equals(bluedUrlParser.a())) {
                if (bluedUrlParser.b() != null) {
                    String str12 = bluedUrlParser.b().get("goods_id");
                    str2 = bluedUrlParser.b().get("goods_name");
                    i2 = Integer.parseInt(bluedUrlParser.b().get(SpamFilter.SpamContract.NotificationTable.COUNT));
                    str3 = bluedUrlParser.b().get("images_static");
                    str4 = bluedUrlParser.b().get("fun");
                    str5 = bluedUrlParser.b().get("errfun");
                    str6 = str12;
                } else {
                    str2 = null;
                    str3 = null;
                    str4 = null;
                    str5 = null;
                    str6 = null;
                }
                LiveGiftModel liveGiftModel = new LiveGiftModel();
                liveGiftModel.goods_id = str6;
                liveGiftModel.name = str2;
                liveGiftModel.count = i2;
                liveGiftModel.images_static = str3;
                liveGiftModel.selectNumModel = new LiveGiftNumberModel();
                liveGiftModel.selectNumModel.count = i2;
                PopLiveActivityWebView.this.a(liveGiftModel, str4, str5);
                return true;
            } else if ("liveroom_close_dialog".equals(bluedUrlParser.a())) {
                PopLiveActivityWebView.this.d();
                return true;
            } else if ("live_sendRP".equals(bluedUrlParser.a())) {
                if (bluedUrlParser.b() != null) {
                    LiveRewardConfigModel liveRewardConfigModel = new LiveRewardConfigModel();
                    liveRewardConfigModel.beans = Integer.parseInt(bluedUrlParser.b().get(ReqAckPackage.REQ_RESPONSE_KEY.BEANS));
                    liveRewardConfigModel.count = Integer.parseInt(bluedUrlParser.b().get(SpamFilter.SpamContract.NotificationTable.COUNT));
                    liveRewardConfigModel.condition = bluedUrlParser.b().get("condition");
                    liveRewardConfigModel.size = bluedUrlParser.b().get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE);
                    liveRewardConfigModel.hb_beans_id = Integer.parseInt(bluedUrlParser.b().get("id"));
                    PopLiveActivityWebView.this.a(liveRewardConfigModel);
                    return true;
                }
                return true;
            } else if ("open_gift".equals(bluedUrlParser.a())) {
                LiveEventBus.get("live_half_web_close").post(true);
                LiveRefreshUIObserver.a().j();
                return false;
            } else if (!"web_page".equals(bluedUrlParser.a())) {
                if ("closeAlert".equals(bluedUrlParser.a())) {
                    LiveEventBus.get("close_multi_dialog").post("");
                    return false;
                }
                return false;
            } else {
                if (bluedUrlParser.b() != null) {
                    str = bluedUrlParser.b().get("weburl");
                    i = StringUtils.a(bluedUrlParser.b().get("flag"), 0);
                } else {
                    str = "";
                    i = 0;
                }
                if (!TextUtils.isEmpty(str)) {
                    if (i == 0) {
                        LiveSetDataObserver.a().b(str, 25);
                    } else {
                        LiveSetDataObserver.a().c(str, 25);
                    }
                }
                LiveEventBus.get("close_multi_dialog").post("");
                return false;
            }
        }

        @Override // com.blued.android.module.live_china.web.LiveWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
        public void b(BluedWebView bluedWebView, String str, boolean z) {
            LogUtils.c("onLoadPageFinished: " + str);
            PopLiveActivityWebView.this.z = true;
            if (PopLiveActivityWebView.this.w != null) {
                PopLiveActivityWebView.this.w.onLoadPageFinished(bluedWebView, str);
                if (PopLiveActivityWebView.this.C != null && PopLiveActivityWebView.this.C.pushTime > PopLiveActivityWebView.this.B) {
                    LogUtils.c("setJsBridgeData onLoadPageFinished : " + PopLiveActivityWebView.this.C.html_msg);
                    PopLiveActivityWebView popLiveActivityWebView = PopLiveActivityWebView.this;
                    popLiveActivityWebView.B = popLiveActivityWebView.C.pushTime;
                    PopLiveActivityWebView.this.w.callHandler(LoaderConstants.NATIVE_TO_JS, PopLiveActivityWebView.this.C.html_msg, new CallBackFunction() { // from class: com.blued.android.module.live_china.view.-$$Lambda$PopLiveActivityWebView$8$-ogUB3nGU6a5a86OcJmEgat-Sj0
                        @Override // com.blued.android.module.common.web.jsbridge.CallBackFunction
                        public final void onCallBack(String str2) {
                            PopLiveActivityWebView.AnonymousClass8.d(str2);
                        }
                    });
                    PopLiveActivityWebView.this.C = null;
                }
            }
            PopLiveActivityWebView.this.j = true;
            PopLiveActivityWebView.this.k.setVisibility(8);
            if (PopLiveActivityWebView.this.D == 0 || PopLiveActivityWebView.this.D == -1) {
                PopLiveActivityWebView.this.o.setVisibility(8);
            } else {
                PopLiveActivityWebView.this.o.setVisibility(0);
            }
            PopLiveActivityWebView.this.n.setVisibility(0);
            if (PopLiveActivityWebView.this.i) {
                PopLiveActivityWebView.this.f.setVisibility(0);
            }
            if (PopLiveActivityWebView.this.u) {
                return;
            }
            PopLiveActivityWebView.this.l.c().clearHistory();
            PopLiveActivityWebView.this.u = true;
            if (PopLiveActivityWebView.this.D != -1) {
                if (PopLiveActivityWebView.this.D == 0) {
                    PopLiveActivityWebView.this.c.startAnimation(AnimationUtils.loadAnimation(PopLiveActivityWebView.this.d, R.anim.pop_down_in));
                } else {
                    PopLiveActivityWebView.this.c.startAnimation(AnimationUtils.loadAnimation(PopLiveActivityWebView.this.d, R.anim.push_center_in));
                }
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopLiveActivityWebView$PopLiveWebEvent.class */
    public interface PopLiveWebEvent {
        void d();
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopLiveActivityWebView$URL_TYPE.class */
    public interface URL_TYPE {
    }

    public PopLiveActivityWebView(Context context) {
        this(context, null);
    }

    public PopLiveActivityWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PopLiveActivityWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = false;
        this.j = false;
        this.u = false;
        this.v = (short) 4;
        this.z = false;
        this.A = 0;
        this.B = 0L;
        this.d = context;
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LiveRewardConfigModel liveRewardConfigModel) {
        LiveEventBus.get("live_reward").post(liveRewardConfigModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str) {
        LogUtils.c("bridgeManager callback: " + str);
    }

    private void h() {
        this.e = LayoutInflater.from(this.d);
        a();
        this.b = this.a.findViewById(R.id.tv_bg);
        this.k = (ProgressBar) this.a.findViewById(R.id.pro_bar);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopLiveActivityWebView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        View findViewById = this.a.findViewById(R.id.ll_content);
        this.c = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopLiveActivityWebView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        this.o = (ImageView) this.a.findViewById(R.id.live_activity_close);
        this.p = (FrameLayout) findViewById(R.id.live_activity_result_layout);
        this.q = (ImageView) findViewById(R.id.live_activity_result_image);
        this.r = (TextView) findViewById(R.id.live_activity_result_text);
        this.s = (Button) findViewById(R.id.live_activity_result_btn);
        this.o.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopLiveActivityWebView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PopLiveActivityWebView.this.d();
            }
        });
        this.f = findViewById(R.id.ll_title_layout);
        this.g = (TextView) findViewById(R.id.tv_title);
        ImageView imageView = (ImageView) findViewById(R.id.iv_back);
        this.h = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopLiveActivityWebView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PopLiveActivityWebView.this.f();
            }
        });
    }

    private void i() {
        WebView webView = this.n;
        if (webView == null || webView.getVisibility() != 0) {
            return;
        }
        this.n.reload();
    }

    private void j() {
        this.m = this.a.findViewById(R.id.live_activity_cardView);
        WebView webView = (WebView) this.a.findViewById(R.id.live_activity_webview);
        this.n = webView;
        webView.setLongClickable(true);
        this.n.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.blued.android.module.live_china.view.PopLiveActivityWebView.7
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                return true;
            }
        });
        this.n.setBackgroundColor(0);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        String e = LiveRoomManager.a().e();
        String g = LiveRoomManager.a().g();
        try {
            concurrentHashMap.put("live_id", TextUtils.isEmpty(e) ? "" : AesCrypto.a(e));
            concurrentHashMap.put("anchor_id", TextUtils.isEmpty(g) ? "" : AesCrypto.a(g));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        BluedWebView.a(concurrentHashMap);
        BluedWebView bluedWebView = new BluedWebView(this.t, this.n, null, new AnonymousClass8());
        this.l = bluedWebView;
        this.w = new BridgeManager(bluedWebView);
    }

    public void a() {
        this.a = this.e.inflate(R.layout.pop_live_activity, this);
    }

    public void a(Fragment fragment) {
        this.t = fragment;
        j();
    }

    public void a(LiveGiftModel liveGiftModel, final String str, final String str2) {
        if (LiveRoomManager.a().p() == null) {
            return;
        }
        Fragment fragment = this.t;
        if ((fragment instanceof BaseFragment) || (fragment instanceof BaseDialogFragment)) {
            ActivityFragmentActive activityFragmentActive = null;
            BaseDialogFragment baseDialogFragment = this.t;
            if (baseDialogFragment instanceof BaseFragment) {
                activityFragmentActive = ((BaseFragment) baseDialogFragment).getFragmentActive();
            } else if (baseDialogFragment instanceof BaseDialogFragment) {
                activityFragmentActive = baseDialogFragment.a();
            }
            long d = LiveRoomManager.a().d();
            String g = LiveRoomManager.a().g();
            if (TextUtils.isEmpty(liveGiftModel.name)) {
                liveGiftModel.name = "幸运星";
            }
            LiveGiftPayTools.a().a(this.d, this.t.getFragmentManager(), this.v, d, activityFragmentActive, liveGiftModel, g, "", liveGiftModel.count, new LiveGiftPayTools.BackGiftStatusListener() { // from class: com.blued.android.module.live_china.view.PopLiveActivityWebView.6
                @Override // com.blued.android.module.live_china.utils.LiveGiftPayTools.BackGiftStatusListener
                public void a() {
                }

                @Override // com.blued.android.module.live_china.utils.LiveGiftPayTools.BackGiftStatusListener
                public void a(LiveGiftModel liveGiftModel2, final LiveGiftModel liveGiftModel3, List<LiveGiftModel> list) {
                    AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.view.PopLiveActivityWebView.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (liveGiftModel3.sendGiftStatus == 3) {
                                if (TextUtils.isEmpty(str)) {
                                    return;
                                }
                                WebView webView = PopLiveActivityWebView.this.n;
                                Tracker.loadUrl(webView, BridgeUtil.JAVASCRIPT_STR + str);
                            } else if (TextUtils.isEmpty(str2)) {
                            } else {
                                WebView webView2 = PopLiveActivityWebView.this.n;
                                Tracker.loadUrl(webView2, BridgeUtil.JAVASCRIPT_STR + str2);
                            }
                        }
                    });
                }
            });
        }
    }

    public void a(String str) {
        d();
        AppMethods.a((CharSequence) str);
    }

    public void a(String str, int i) {
        if (LiveRoomManager.a().p() == null) {
            return;
        }
        Fragment fragment = this.t;
        if ((fragment instanceof BaseFragment) || (fragment instanceof BaseDialogFragment)) {
            ActivityFragmentActive activityFragmentActive = null;
            BaseDialogFragment baseDialogFragment = this.t;
            if (baseDialogFragment instanceof BaseFragment) {
                activityFragmentActive = ((BaseFragment) baseDialogFragment).getFragmentActive();
            } else if (baseDialogFragment instanceof BaseDialogFragment) {
                activityFragmentActive = baseDialogFragment.a();
            }
            long d = LiveRoomManager.a().d();
            String g = LiveRoomManager.a().g();
            LiveGiftModel liveGiftModel = new LiveGiftModel();
            liveGiftModel.goods_id = str;
            if (TextUtils.isEmpty(liveGiftModel.name)) {
                liveGiftModel.name = "";
            }
            LiveGiftPayTools.a().a(this.d, this.t.getFragmentManager(), this.v, d, activityFragmentActive, liveGiftModel, g, "", 1, new LiveGiftPayTools.BackGiftStatusListener() { // from class: com.blued.android.module.live_china.view.PopLiveActivityWebView.5
                @Override // com.blued.android.module.live_china.utils.LiveGiftPayTools.BackGiftStatusListener
                public void a() {
                }

                @Override // com.blued.android.module.live_china.utils.LiveGiftPayTools.BackGiftStatusListener
                public void a(final LiveGiftModel liveGiftModel2, final LiveGiftModel liveGiftModel3, List<LiveGiftModel> list) {
                    AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.view.PopLiveActivityWebView.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (liveGiftModel3.sendGiftStatus == 3) {
                                PopLiveActivityWebView.this.b();
                            } else if (TextUtils.isEmpty(liveGiftModel2.errorMessage)) {
                            } else {
                                PopLiveActivityWebView.this.a(liveGiftModel2.errorMessage);
                            }
                        }
                    });
                }
            });
        }
    }

    public void a(String str, int i, boolean z) {
        this.u = false;
        this.D = i;
        this.x = str;
        this.z = false;
        LogUtils.c("OpenUrl: " + str);
        if (str == null || !str.contains("?")) {
            this.y = str;
        } else {
            this.y = str.substring(0, str.indexOf("?"));
        }
        setVisibility(0);
        this.f.setVisibility(8);
        this.i = ((i != 0 && i != -1) || TextUtils.isEmpty(str) || str.contains("blued_mode=hide_nav")) ? false : true;
        this.j = false;
        CardView cardView = this.m;
        if (cardView != null) {
            cardView.setRadius(this.A);
        }
        this.k.setVisibility(0);
        this.c.setVisibility(0);
        this.c.clearAnimation();
        this.n.stopLoading();
        if (z) {
            this.n.setVisibility(4);
        }
        this.l.a(str);
        this.p.setVisibility(8);
        this.o.setVisibility(8);
        if (i == -1) {
            this.b.setVisibility(8);
            return;
        }
        if (i == 0) {
            this.b.setVisibility(8);
            LiveEventBus.get("live_show_dialog").post(true);
        } else {
            this.b.setVisibility(0);
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.PopLiveActivityWebView.9
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    public void b() {
        d();
        int i = this.D;
        if (i == 1) {
            AppMethods.d(R.string.live_fist_top_up_success);
        } else if (i == 2) {
            AppMethods.d(R.string.live_top_up_success);
        }
        LiveEventBus.get("live_playing_hide_activity_pop").post(false);
    }

    public void b(String str, int i) {
        a(str, i, true);
    }

    public void c() {
        i();
    }

    public void d() {
        if (this.c.getVisibility() == 8) {
            return;
        }
        LiveEventBus.get("live_show_dialog").post(false);
        if (this.D != -1) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setFillAfter(true);
            this.b.startAnimation(alphaAnimation);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.PopLiveActivityWebView.10
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PopLiveActivityWebView.this.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            if (this.D == 0) {
                this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.pop_down_out));
            } else {
                this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_center_out));
            }
            this.c.setVisibility(8);
            this.o.setVisibility(8);
        }
        PopLiveWebEvent popLiveWebEvent = this.E;
        if (popLiveWebEvent != null) {
            popLiveWebEvent.d();
        }
    }

    public boolean e() {
        StringBuilder sb = new StringBuilder();
        sb.append("isShow =");
        sb.append(getVisibility() == 0);
        Log.v("pk", sb.toString());
        return getVisibility() == 0;
    }

    public void f() {
        BluedWebView bluedWebView = this.l;
        if (bluedWebView != null && bluedWebView.c().canGoBack() && this.u) {
            this.l.c().goBack();
        } else {
            d();
        }
    }

    public void g() {
        BluedWebView bluedWebView = this.l;
        if (bluedWebView != null) {
            bluedWebView.a(this.x);
        }
    }

    public void setJsBridgeData(HTMLNoticeModel hTMLNoticeModel) {
        if (hTMLNoticeModel == null || TextUtils.isEmpty(hTMLNoticeModel.html_msg) || TextUtils.isEmpty(hTMLNoticeModel.html_href) || TextUtils.isEmpty(this.y) || hTMLNoticeModel.pushTime <= this.B) {
            return;
        }
        if (!this.z) {
            LogUtils.c("isPageFinished = false");
            this.C = hTMLNoticeModel;
            return;
        }
        this.B = hTMLNoticeModel.pushTime;
        if (!StringUtils.a(hTMLNoticeModel.html_href.contains("?") ? hTMLNoticeModel.html_href.substring(0, hTMLNoticeModel.html_href.indexOf("?")) : hTMLNoticeModel.html_href, this.y) || this.w == null) {
            return;
        }
        this.B = hTMLNoticeModel.pushTime;
        LogUtils.c("setJsBridgeData: " + hTMLNoticeModel.html_msg);
        this.w.callHandler(LoaderConstants.NATIVE_TO_JS, hTMLNoticeModel.html_msg, new CallBackFunction() { // from class: com.blued.android.module.live_china.view.-$$Lambda$PopLiveActivityWebView$BIRd_4mTu2iFYDRwptlfYZxsg6Y
            @Override // com.blued.android.module.common.web.jsbridge.CallBackFunction
            public final void onCallBack(String str) {
                PopLiveActivityWebView.b(str);
            }
        });
    }

    public void setPopLiveWebEvent(PopLiveWebEvent popLiveWebEvent) {
        this.E = popLiveWebEvent;
    }

    public void setWebViewRadius(int i) {
        this.A = i;
    }
}
