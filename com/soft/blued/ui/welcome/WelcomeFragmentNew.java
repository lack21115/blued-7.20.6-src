package com.soft.blued.ui.welcome;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.module.common.log.oldtrack.InstantLogBody;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.url.Host;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.device_identity.library.BluedDeviceIdentity;
import com.blued.android.ui.TimeoutFragment;
import com.blued.das.login.LoginAndRegisterProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.HttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.home.manager.WelcomeADManager;
import com.soft.blued.ui.login_register.SignInActivity;
import com.soft.blued.ui.welcome.WelcomeFragmentNew;
import com.soft.blued.ui.welcome.model.SplashEntity;
import com.soft.blued.ui.welcome.model.SplashExtraEntity;
import com.soft.blued.ui.welcome.observer.ADDownloadObserver;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.io.File;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@Deprecated
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/WelcomeFragmentNew.class */
public class WelcomeFragmentNew extends TimeoutFragment implements View.OnClickListener, ADDownloadObserver.IADDownloadObserver {
    private static final String m = WelcomeFragmentNew.class.getSimpleName();
    private ImageView B;
    private Timer C;
    private long F;
    private long K;
    private long L;
    private long M;
    private Context r;
    private View s;
    private ImageView t;
    private TextView u;
    private ImageView v;
    private LinearLayout w;
    private boolean x;
    private boolean y;
    private boolean z;
    private boolean n = true;
    private boolean o = true;
    private Runnable p = null;
    private long q = 1000;
    private int A = 5;
    private boolean D = false;
    private boolean E = false;
    private final int G = 101;
    private final int H = 102;
    private final int I = 103;
    private final int J = 104;
    private Runnable N = new Runnable() { // from class: com.soft.blued.ui.welcome.WelcomeFragmentNew.6
        @Override // java.lang.Runnable
        public void run() {
            if (WelcomeFragmentNew.this.y || WelcomeFragmentNew.this.x) {
                return;
            }
            if (WelcomeFragmentNew.this.A == 0) {
                WelcomeFragmentNew.this.c("adsShowCountdownTask adsCountDown == 0");
                return;
            }
            TextView textView = WelcomeFragmentNew.this.u;
            textView.setText(WelcomeFragmentNew.this.A + "");
            WelcomeFragmentNew.m(WelcomeFragmentNew.this);
            if (WelcomeFragmentNew.this.A == 0) {
                AppInfo.n().post(this);
            } else {
                AppInfo.n().postDelayed(this, 1000L);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.welcome.WelcomeFragmentNew$5  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/WelcomeFragmentNew$5.class */
    public class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            Tracker.onClick(view);
            WelcomeFragmentNew.this.k();
            WelcomeFragmentNew.this.E = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            WelcomeFragmentNew.this.L = System.currentTimeMillis();
            ImageLoader.a(WelcomeFragmentNew.this.getFragmentActive(), WelcomeADManager.a().g()).f().g(-1).a(new ImageLoadResult(WelcomeFragmentNew.this.getFragmentActive()) { // from class: com.soft.blued.ui.welcome.WelcomeFragmentNew.5.1
                public void a() {
                    Log.v("drb", "onSuccess");
                    if (WelcomeADManager.a().e().today != null) {
                        FindHttpUtils.b(WelcomeADManager.a().e().today.show_url);
                    }
                    WelcomeFragmentNew.this.z = true;
                    AppInfo.n().post(WelcomeFragmentNew.this.N);
                    BluedPreferences.I(true);
                    WelcomeFragmentNew.this.B.setVisibility(8);
                    WelcomeFragmentNew.this.t.setVisibility(0);
                    SplashEntity e = WelcomeADManager.a().e();
                    if (e.extra_json == null || e.extra_json.splash == null) {
                        return;
                    }
                    WelcomeFragmentNew.this.a(e.extra_json.splash.hot_area_limit_type);
                }

                public void a(int i, Exception exc) {
                    WelcomeFragmentNew.this.c("image onLoadingFailed");
                }
            }).a(WelcomeFragmentNew.this.t);
            if (WelcomeADManager.a().e() == null || WelcomeADManager.a().e().today == null || WelcomeADManager.a().e().today.is_show_adm_icon != 1) {
                WelcomeFragmentNew.this.v.setVisibility(8);
            } else {
                WelcomeFragmentNew.this.v.setVisibility(0);
            }
            WelcomeFragmentNew.this.w.setVisibility(0);
            WelcomeFragmentNew.this.t.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$WelcomeFragmentNew$5$GFtukyDOhfOChL_e0_PbyulzU6Y
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WelcomeFragmentNew.AnonymousClass5.this.a(view);
                }
            });
            WelcomeFragmentNew.this.u.setVisibility(8);
        }
    }

    public static void a(Context context, boolean z) {
        if (!GuideFragment.a(context)) {
            if (!UserInfo.getInstance().isLogin()) {
                SignInActivity.a(context, new Bundle[0]);
            } else if (z) {
                HomeArgumentHelper.a(context);
                if (WelcomeADManager.a().h() == -1) {
                    InstantLogBody instantLogBody = new InstantLogBody();
                    instantLogBody.service = "AD_REQUEST_TIMEOUT";
                    Map a2 = BluedHttpTools.a();
                    a2.put("req_id", WelcomeADManager.a().b());
                    InstantLog.a(instantLogBody, a2);
                    EventTrackLoginAndRegister.b(LoginAndRegisterProtos.Event.AD_REQUEST_TIMEOUT, WelcomeADManager.a().b());
                }
            } else {
                if (BluedApplicationLike.outUri != null) {
                    Log.v("drb", "skipWelcome BluedApplicationLike.outUri:" + BluedApplicationLike.outUri);
                    BluedURIRouter.a().a(context, BluedApplicationLike.outUri);
                    BluedApplicationLike.outUri = null;
                }
                if (context instanceof Activity) {
                    Log.v("drb", "skipWelcome finish()");
                    ((Activity) context).finish();
                }
            }
        }
        DeviceUtils.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Log.v("drb", "结束广告图展示 endAdsShow:" + str);
        if (this.x) {
            return;
        }
        this.x = true;
        if ((!this.y || this.z) && this.p != null) {
            AppInfo.n().postDelayed(this.p, this.q);
        }
    }

    static /* synthetic */ int m(WelcomeFragmentNew welcomeFragmentNew) {
        int i = welcomeFragmentNew.A;
        welcomeFragmentNew.A = i - 1;
        return i;
    }

    private void n() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.n = arguments.getBoolean("arg_show_ad");
            this.o = arguments.getBoolean("arg_open_home", this.o);
            Log.v("drb", "init openHome:" + this.o);
        }
        Log.v("xxxx", "环境状态" + BluedHttpUrl.j());
        Log.v("xxxx", "本地存储状态" + Host.b());
        if (this.p == null) {
            this.p = new Runnable() { // from class: com.soft.blued.ui.welcome.WelcomeFragmentNew.3
                @Override // java.lang.Runnable
                public void run() {
                    if (CommonTools.a(WelcomeFragmentNew.this)) {
                        WelcomeFragmentNew.this.D = true;
                        WelcomeFragmentNew.this.r();
                    }
                }
            };
        }
    }

    private void o() {
        this.t = (ImageView) this.s.findViewById(R.id.iv_pictrue);
        ImageView imageView = (ImageView) this.s.findViewById(R.id.view_btm_bar);
        this.B = imageView;
        imageView.setImageDrawable(this.r.getResources().getDrawable(R.drawable.icon_blued_banner_logo));
        this.B.setVisibility(0);
        this.u = (TextView) this.s.findViewById(R.id.tv_daotime);
        LinearLayout linearLayout = (LinearLayout) this.s.findViewById(R.id.ll_click_skip);
        this.w = linearLayout;
        linearLayout.setOnClickListener(this);
        this.v = (ImageView) this.s.findViewById(R.id.img_ad_icon);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        c("judgeLastTo StringDealwith.isEmpty(WelcomeADManager.getInstance().getTodayADPicUrl())||!RecyclingUtils.isFileDownloaded(WelcomeADManager.getInstance().getTodayADPicUrl())");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        if (this.n) {
            this.q = 0L;
            try {
                AppInfo.n().post(new AnonymousClass5());
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                c("showPicTimeDown try catch exception");
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        synchronized (this) {
            BluedDeviceIdentity a2 = BluedDeviceIdentity.a();
            Context d = AppInfo.d();
            a2.a(d, BluedHttpUrl.q() + "/blued/device", 2);
            if (this.D) {
                this.s.postDelayed(new Runnable() { // from class: com.soft.blued.ui.welcome.WelcomeFragmentNew.7
                    @Override // java.lang.Runnable
                    public void run() {
                        FragmentActivity activity = WelcomeFragmentNew.this.getActivity();
                        if (activity != null) {
                            WelcomeFragmentNew.a(activity, WelcomeFragmentNew.this.o);
                            Log.v("drb", "skip finish()");
                            activity.finish();
                            WelcomeADManager.a().a(false);
                        }
                    }
                }, 0L);
                this.D = false;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(SplashEntity.ShowEntity showEntity) {
        Logger.a("drb", "showThirdSplash:" + showEntity.adms_type);
        Log.v("drb", "开机广告 adms_type:" + showEntity.adms_type + "third_id：" + showEntity.third_id);
        if (showEntity == null || FlexDebugSevConfig.a().b().android_forbidden_splash_ad != 0) {
            a(this.r, this.o);
            return;
        }
        this.M = System.currentTimeMillis();
        SerialSplashFragment.a((Fragment) this, showEntity, 105);
    }

    public TimerTask b(final String str) {
        return new TimerTask() { // from class: com.soft.blued.ui.welcome.WelcomeFragmentNew.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SplashEntity e = WelcomeADManager.a().e();
                if (e != null && e.today != null) {
                    WelcomeFragmentNew.this.a(e.today);
                    return;
                }
                WelcomeFragmentNew welcomeFragmentNew = WelcomeFragmentNew.this;
                welcomeFragmentNew.c("getFinishTask:" + str);
            }
        };
    }

    public void g() {
        Log.v("drb", "onTimeoutFinish finish()");
        a(this.r, true);
    }

    public View h() {
        return this.s;
    }

    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    public void j() {
        Timer timer = this.C;
        if (timer != null) {
            timer.cancel();
            this.C.purge();
            this.C = null;
        }
        Logger.e("xxx", "judgeLastTo = " + WelcomeADManager.a().g());
        if (StringUtils.d(WelcomeADManager.a().g())) {
            p();
        } else {
            ImageFileLoader.a(getFragmentActive()).b(WelcomeADManager.a().g()).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.welcome.WelcomeFragmentNew.4
                public void onUIFinish(File file, Exception exc) {
                    if (file == null || !file.exists()) {
                        WelcomeFragmentNew.this.p();
                    } else if (WelcomeFragmentNew.this.q()) {
                    } else {
                        WelcomeFragmentNew.this.c("judgeLastTo showPicTimeDown()==false");
                    }
                }
            }).a();
        }
    }

    public void k() {
        if (WelcomeADManager.a().e() == null || WelcomeADManager.a().e().today == null) {
            return;
        }
        if (WelcomeADManager.a().e().today.click_url != null && WelcomeADManager.a().e().today.click_url.length > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= WelcomeADManager.a().e().today.click_url.length) {
                    break;
                }
                String str = WelcomeADManager.a().e().today.click_url[i2];
                String str2 = str;
                if (str.startsWith(BluedHttpUrl.q())) {
                    if (this.E) {
                        Map a2 = BluedHttpTools.a();
                        a2.put("is_valid", "0");
                        str2 = HttpUtils.a(a2, str);
                    } else {
                        Map a3 = BluedHttpTools.a();
                        a3.put("is_valid", "1");
                        str2 = HttpUtils.a(a3, str);
                    }
                }
                FindHttpUtils.a(str2);
                i = i2 + 1;
            }
            this.E = true;
        }
        SplashEntity.ShowEntity showEntity = WelcomeADManager.a().e().today;
        Log.v("drb", "intoADUrl adExtra.deep_link_url:" + ((BluedADExtra) showEntity).deep_link_url);
        Log.v("drb", "intoADUrl adExtra.target_url:" + ((BluedADExtra) showEntity).target_url);
        if (TextUtils.isEmpty(((BluedADExtra) showEntity).deep_link_url)) {
            BluedApplicationLike.outUri = BluedURIRouter.a().f(((BluedADExtra) showEntity).target_url);
            if (BluedApplicationLike.outUri == null) {
                BluedApplicationLike.outUri = BluedURIRouter.a().a(((BluedADExtra) showEntity).target_url, 9);
            }
            c("intoADUrl");
            EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.JD_AD_TO_H5);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(((BluedADExtra) showEntity).deep_link_url));
        if (AppUtils.a(intent)) {
            EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.JD_AD_TO_APP);
            this.r.startActivity(intent);
            return;
        }
        BluedApplicationLike.outUri = BluedURIRouter.a().f(((BluedADExtra) showEntity).target_url);
        if (BluedApplicationLike.outUri == null) {
            BluedApplicationLike.outUri = BluedURIRouter.a().a(((BluedADExtra) showEntity).target_url, 9);
        }
        c("intoADUrl");
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.JD_AD_TO_H5);
    }

    public void l() {
        SplashExtraEntity f = WelcomeADManager.a().f();
        if (f == null || f.TIMEOUT <= 5) {
            return;
        }
        Long valueOf = Long.valueOf((f.TIMEOUT * 1000) - Long.valueOf(Long.valueOf(System.currentTimeMillis()).longValue() - this.F).longValue());
        if (valueOf.longValue() <= 0) {
            j();
            return;
        }
        Timer timer = this.C;
        if (timer != null) {
            timer.cancel();
            this.C.purge();
            this.C = null;
        }
        Timer timer2 = new Timer();
        this.C = timer2;
        timer2.schedule(b("notifyGetADExtraSuccess"), valueOf.longValue());
    }

    @Override // com.soft.blued.ui.welcome.observer.ADDownloadObserver.IADDownloadObserver
    public void m() {
        SplashEntity e = WelcomeADManager.a().e();
        if (e == null || e.today == null) {
            j();
            return;
        }
        a(e.today);
        Timer timer = this.C;
        if (timer != null) {
            timer.cancel();
            this.C.purge();
            this.C = null;
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Log.v("drb", "WelcomeFragmentNew onActivityCreated");
        Log.v("drb", "WelcomeADManager.getInstance().isHasAD()" + WelcomeADManager.a().h());
        int h = WelcomeADManager.a().h();
        if (h == -1) {
            long j = 5000;
            if (this.F > 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.F;
                if (currentTimeMillis < 5000) {
                    j = 5000 - currentTimeMillis;
                } else {
                    j();
                    j = 5000;
                }
            }
            Timer timer = this.C;
            if (timer != null) {
                timer.cancel();
                this.C.purge();
                this.C = null;
            }
            Timer timer2 = new Timer();
            this.C = timer2;
            timer2.schedule(b("onCreateView no response yet"), j);
            ADDownloadObserver.a().a(this);
        } else if (h == 0) {
            if (this.n) {
                j();
                return;
            }
            this.D = true;
            Timer timer3 = this.C;
            if (timer3 != null) {
                timer3.cancel();
                this.C.purge();
                this.C = null;
            }
            r();
        } else if (h != 1) {
        } else {
            Log.v("drb", "case WelcomeADManager.HAS_AD_STATUS.HAS_AD:" + WelcomeADManager.a().e().today.adms_type);
            if (!WelcomeADManager.a().i()) {
                if (!StringUtils.d(WelcomeADManager.a().g())) {
                    ImageFileLoader.a(getFragmentActive()).b(WelcomeADManager.a().g()).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.welcome.WelcomeFragmentNew.2
                        public void onUIFinish(File file, Exception exc) {
                            if (file == null || !file.exists()) {
                                WelcomeFragmentNew.this.l();
                                ADDownloadObserver.a().a(WelcomeFragmentNew.this);
                            } else {
                                WelcomeFragmentNew.this.j();
                            }
                            SplashEntity e = WelcomeADManager.a().e();
                            if (e.extra_json == null || e.extra_json.splash == null) {
                                return;
                            }
                            WelcomeFragmentNew.this.A = e.extra_json.splash.show_time_limit;
                        }
                    }).a();
                    return;
                }
                l();
                ADDownloadObserver.a().a(this);
                return;
            }
            Timer timer4 = this.C;
            if (timer4 != null) {
                timer4.cancel();
                this.C.purge();
                this.C = null;
            }
            a(WelcomeADManager.a().e().today);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        a(this.r, this.o);
        if (intent != null) {
            if (intent.getLongExtra("THIRD_UNVALID_DURATION", 0L) != 0) {
                long j = this.M;
            }
            intent.getBooleanExtra("THIRD_HAS_CALL_BACK", false);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() != 2131367704) {
            return;
        }
        InstantLog.a("splash_ad_skip");
        if (WelcomeADManager.a().e() != null && WelcomeADManager.a().e().today != null && WelcomeADManager.a().e().today.hidden_url != null && WelcomeADManager.a().e().today.hidden_url.length > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= WelcomeADManager.a().e().today.hidden_url.length) {
                    break;
                }
                FindHttpUtils.a(WelcomeADManager.a().e().today.hidden_url[i2]);
                i = i2 + 1;
            }
        }
        c("onClick ll_click_skip");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TXSplashFragment.p = false;
        this.r = getActivity();
        BluedPreferences.I(false);
        n();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.F = System.currentTimeMillis();
        View view = this.s;
        if (view == null) {
            this.s = layoutInflater.inflate(R.layout.fragment_welcome, viewGroup, false);
            o();
            r();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.s.getParent()).removeView(this.s);
        }
        EventTrackGuy.b("open");
        return this.s;
    }

    public void onDestroy() {
        super.onDestroy();
        BluedPreferences.N(false);
        WelcomeADManager.a().a(false);
        if (this.p != null) {
            AppInfo.n().removeCallbacks(this.p);
            this.p = null;
        }
        ADDownloadObserver.a().b(this);
        WelcomeADManager.a().d();
    }

    public void onStart() {
        super.onStart();
        Log.v("drb", "WelcomeFragment onStart");
        BluedPreferences.N(true);
        if (this.y) {
            if (this.z) {
                AppInfo.n().post(this.N);
            } else {
                Log.v("drb", "如果之前没有在广告倒计时, 则进入结束展示广告逻辑 onStart");
                if (this.p != null) {
                    AppInfo.n().postDelayed(this.p, this.q);
                }
            }
        }
        this.y = false;
    }

    public void onStop() {
        super.onStop();
        Log.v("drb", "WelcomeFragment onStop");
        this.y = true;
        if (this.p != null) {
            AppInfo.n().removeCallbacks(this.p);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.K = System.currentTimeMillis();
    }
}
