package com.soft.blued.ui.welcome;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.anythink.core.api.ATAdInfo;
import com.anythink.splashad.api.ATSplashAd;
import com.anythink.splashad.api.ATSplashAdExtraInfo;
import com.anythink.splashad.api.ATSplashAdListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.urlroute.BluedURIRouter;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.utils.AnimationUtils;
import com.blued.android.module.player.media.model.VideoPlayConfig;
import com.blued.android.module.player.media.view.PLVideoPageView;
import com.blued.android.ui.TimeoutFragment;
import com.blued.das.login.LoginAndRegisterProtos;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.splash.SplashAdDisplayListener;
import com.huawei.hms.ads.splash.SplashView;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.miui.externalserver.IExternalMediaSplashAdListener;
import com.miui.externalserver.IExternalMediaSplashAdService;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import com.soft.blued.R;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.http.HttpUtils;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.model.Bid;
import com.soft.blued.model.ReachMaxResponse;
import com.soft.blued.model.Seatbid;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.ui.welcome.SerialSplashFragment;
import com.soft.blued.ui.welcome.manager.KSSplashManager;
import com.soft.blued.ui.welcome.manager.OppoSplashManager;
import com.soft.blued.ui.welcome.manager.SplashAdListenerAdapter;
import com.soft.blued.ui.welcome.model.ADClickCoordinate;
import com.soft.blued.ui.welcome.model.SplashEntity;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.VideoLoadController;
import com.soft.blued.utils.WeChatUtils;
import com.soft.blued.utils.third.TTADUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/SerialSplashFragment.class */
public class SerialSplashFragment extends TimeoutFragment {
    public static boolean q = false;
    private ATSplashAd A;
    private ImageView B;
    private boolean C;
    private SplashAD F;
    private VideoLoadController.IVideoController J;
    private PLVideoPageView K;
    private String L;
    private boolean M;
    private boolean O;
    private boolean Q;
    public Context m;
    public View n;
    public long o;
    public int s;
    private FrameLayout t;
    private View u;
    private View v;
    private View w;
    private View x;
    private ImageView y;
    private ImageView z;
    public boolean p = false;
    private boolean D = false;
    public List<SplashEntity.ShowEntity> r = new ArrayList();
    private int E = 5;
    private long G = 0;
    private int H = 500;
    private AdsCountdownTask I = new AdsCountdownTask();
    private ADClickCoordinate N = null;
    private IExternalMediaSplashAdListener P = new IExternalMediaSplashAdListener.Stub() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.21
        @Override // com.miui.externalserver.IExternalMediaSplashAdListener
        public void a() throws RemoteException {
            SerialSplashFragment.this.p = true;
            SerialSplashFragment.this.o = System.currentTimeMillis();
            Log.v("drb", "小米 onAdLoaded");
            if (SerialSplashFragment.this.j != null) {
                FindHttpUtils.b(SerialSplashFragment.this.j.show_url);
                EventTrackLoginAndRegister.b(LoginAndRegisterProtos.Event.OPEN_AD_RETURN_SUCCESS, SerialSplashFragment.this.j);
                EventTrackLoginAndRegister.d(LoginAndRegisterProtos.Event.OPEN_AD_SHOW, SerialSplashFragment.this.j);
            }
            SerialSplashFragment.this.d = true;
        }

        @Override // com.miui.externalserver.IExternalMediaSplashAdListener
        public void a(int i) throws RemoteException {
            SerialSplashFragment.this.l();
            Log.v("drb", "小米 onAdError:" + i);
            if (SerialSplashFragment.this.j != null) {
                SerialSplashFragment serialSplashFragment = SerialSplashFragment.this;
                serialSplashFragment.a(serialSplashFragment.j);
                SerialSplashFragment.this.n();
            }
        }

        @Override // com.miui.externalserver.IExternalMediaSplashAdListener
        public void b() throws RemoteException {
            SerialSplashFragment.this.l();
            SerialSplashFragment.this.d = false;
            if (SerialSplashFragment.this.j != null) {
                EventTrackLoginAndRegister.d(LoginAndRegisterProtos.Event.OPEN_AD_SKIP_CLICK, SerialSplashFragment.this.j);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.welcome.SerialSplashFragment$24  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/SerialSplashFragment$24.class */
    public class AnonymousClass24 implements ImageFileLoader.OnLoadFileListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SplashAdListener f34569a;
        final /* synthetic */ SplashEntity.ShowEntity b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.soft.blued.ui.welcome.SerialSplashFragment$24$1  reason: invalid class name */
        /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/SerialSplashFragment$24$1.class */
        public class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a(SplashEntity.ShowEntity showEntity, SplashAdListener splashAdListener, View view) {
                Tracker.onClick(view);
                SerialSplashFragment.this.a(showEntity, splashAdListener, SerialSplashFragment.this.N);
                SerialSplashFragment.this.D = true;
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageLoader.a(SerialSplashFragment.this.getFragmentActive(), AnonymousClass24.this.b.ads_pics).a(new ImageLoadResult(SerialSplashFragment.this.getFragmentActive()) { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.24.1.1
                    @Override // com.blued.android.core.image.ImageLoadResult
                    public void a() {
                        AnonymousClass24.this.f34569a.a(AnonymousClass24.this.b.show_url, AnonymousClass24.this.b.show_post_url);
                        SerialSplashFragment.this.C = true;
                        SerialSplashFragment.this.q();
                        BluedPreferences.I(true);
                        if (TextUtils.equals("16", AnonymousClass24.this.b.adms_type) || TextUtils.equals("17", AnonymousClass24.this.b.adms_type) || TextUtils.equals("18", AnonymousClass24.this.b.adms_type) || TextUtils.equals("19", AnonymousClass24.this.b.adms_type) || TextUtils.equals(BaseWrapper.ENTER_ID_SYSTEM_HELPER, AnonymousClass24.this.b.adms_type) || TextUtils.equals("21", AnonymousClass24.this.b.adms_type) || TextUtils.equals("22", AnonymousClass24.this.b.adms_type) || TextUtils.equals("23", AnonymousClass24.this.b.adms_type) || TextUtils.equals("25", AnonymousClass24.this.b.adms_type) || TextUtils.equals("26", AnonymousClass24.this.b.adms_type)) {
                            SerialSplashFragment.this.w.setVisibility(0);
                            Log.v("drb", "展示底部blued logo 当前广告类型：" + AnonymousClass24.this.b.adms_type);
                        } else {
                            Log.v("drb", "隐藏底部blued logo 当前广告类型：" + AnonymousClass24.this.b.adms_type);
                            SerialSplashFragment.this.w.setVisibility(8);
                        }
                        SerialSplashFragment.this.v.setVisibility(4);
                        SerialSplashFragment.this.B.setVisibility(0);
                        SerialSplashFragment.this.d(AnonymousClass24.this.b.is_show_adm_icon, AnonymousClass24.this.b.adms_type);
                        Log.v("drb", "图片广告类型  adms_type=" + AnonymousClass24.this.b.adms_type);
                    }

                    @Override // com.blued.android.core.image.ImageLoadResult
                    public void a(int i, Exception exc) {
                        SplashAdListener splashAdListener = AnonymousClass24.this.f34569a;
                        splashAdListener.a(i + "", exc.toString());
                    }
                }).a(SerialSplashFragment.this.B);
                SerialSplashFragment.this.u.setVisibility(0);
                ImageView imageView = SerialSplashFragment.this.B;
                final SplashEntity.ShowEntity showEntity = AnonymousClass24.this.b;
                final SplashAdListener splashAdListener = AnonymousClass24.this.f34569a;
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$SerialSplashFragment$24$1$rYcUuLLXtdct5hhS_8x1zOu4t3w
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SerialSplashFragment.AnonymousClass24.AnonymousClass1.this.a(showEntity, splashAdListener, view);
                    }
                });
                final ADClickCoordinate aDClickCoordinate = new ADClickCoordinate();
                SerialSplashFragment.this.B.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.24.1.2
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            ADClickCoordinate aDClickCoordinate2 = aDClickCoordinate;
                            aDClickCoordinate2.down_x = motionEvent.getX() + "";
                            ADClickCoordinate aDClickCoordinate3 = aDClickCoordinate;
                            aDClickCoordinate3.down_y = motionEvent.getY() + "";
                            return true;
                        } else if (action != 1) {
                            return true;
                        } else {
                            ADClickCoordinate aDClickCoordinate4 = aDClickCoordinate;
                            aDClickCoordinate4.up_x = motionEvent.getX() + "";
                            ADClickCoordinate aDClickCoordinate5 = aDClickCoordinate;
                            aDClickCoordinate5.up_y = motionEvent.getY() + "";
                            SerialSplashFragment.this.a(AnonymousClass24.this.b, AnonymousClass24.this.f34569a, aDClickCoordinate);
                            SerialSplashFragment.this.D = true;
                            return true;
                        }
                    }
                });
                SerialSplashFragment.this.u.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.24.1.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        InstantLog.a("splash_ad_skip");
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= AnonymousClass24.this.b.hidden_url.length) {
                                AnonymousClass24.this.f34569a.b(AnonymousClass24.this.b.hidden_url);
                                return;
                            } else {
                                FindHttpUtils.a(AnonymousClass24.this.b.hidden_url[i2]);
                                i = i2 + 1;
                            }
                        }
                    }
                });
            }
        }

        AnonymousClass24(SplashAdListener splashAdListener, SplashEntity.ShowEntity showEntity) {
            this.f34569a = splashAdListener;
            this.b = showEntity;
        }

        @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
        public void onUIFinish(File file, Exception exc) {
            this.f34569a.a();
            if (file == null || !file.exists()) {
                Log.v("drb", "广告失败：showEntity.adms_type = " + this.b.adms_type);
                if ("9".equalsIgnoreCase(this.b.adms_type)) {
                    Log.v("drb", "百威广告失败：文件不存在");
                } else if ("2".equalsIgnoreCase(this.b.adms_type)) {
                    Log.v("drb", "淘宝广告失败：文件不存在");
                } else if ("16".equalsIgnoreCase(this.b.adms_type)) {
                    Log.v("drb", "海贝广告失败：文件不存在");
                } else if ("17".equalsIgnoreCase(this.b.adms_type)) {
                    Log.v("drb", "拼多多广告失败：文件不存在");
                } else if ("18".equalsIgnoreCase(this.b.adms_type)) {
                    Log.v("drb", "桔柚广告失败：文件不存在");
                } else if ("19".equalsIgnoreCase(this.b.adms_type)) {
                    Log.v("drb", "InMobi广告失败：文件不存在");
                } else {
                    Log.v("drb", "直客广告失败：文件不存在");
                }
                this.f34569a.a("", "API广告失败：文件不存在");
                return;
            }
            try {
                AppInfo.n().post(new AnonymousClass1());
            } catch (Exception e) {
                this.f34569a.a("", e.toString());
                if ("9".equalsIgnoreCase(this.b.adms_type)) {
                    Log.v("drb", "百威广告失败：" + e.toString());
                } else if ("2".equalsIgnoreCase(this.b.adms_type)) {
                    Log.v("drb", "淘宝广告失败：" + e.toString());
                } else if ("16".equalsIgnoreCase(this.b.adms_type)) {
                    Log.v("drb", "海贝广告失败：" + e.toString());
                } else if ("17".equalsIgnoreCase(this.b.adms_type)) {
                    Log.v("drb", "拼多多广告失败：" + e.toString());
                } else if ("18".equalsIgnoreCase(this.b.adms_type)) {
                    Log.v("drb", "桔柚广告失败：" + e.toString());
                } else if ("19".equalsIgnoreCase(this.b.adms_type)) {
                    Log.v("drb", "InMobi广告失败：" + e.toString());
                } else {
                    Log.v("drb", "直客广告失败：" + e.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.welcome.SerialSplashFragment$25  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/SerialSplashFragment$25.class */
    public class AnonymousClass25 implements VideoLoadController.IVideoController {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SplashAdListener f34575a;
        final /* synthetic */ SplashEntity.ShowEntity b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SerialSplashFragment f34576c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.soft.blued.ui.welcome.SerialSplashFragment$25$1  reason: invalid class name */
        /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/SerialSplashFragment$25$1.class */
        public class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a(SplashEntity.ShowEntity showEntity, SplashAdListener splashAdListener, View view) {
                Tracker.onClick(view);
                Log.v("drb", IAdInterListener.AdCommandType.AD_CLICK);
                AnonymousClass25.this.f34576c.a(showEntity, splashAdListener, AnonymousClass25.this.f34576c.N);
                AnonymousClass25.this.f34576c.D = true;
            }

            @Override // java.lang.Runnable
            public void run() {
                PLVideoPageView pLVideoPageView = AnonymousClass25.this.f34576c.K;
                final SplashEntity.ShowEntity showEntity = AnonymousClass25.this.b;
                final SplashAdListener splashAdListener = AnonymousClass25.this.f34575a;
                pLVideoPageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$SerialSplashFragment$25$1$P1en70CEjO8j1xw1QLyRIISpFHc
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SerialSplashFragment.AnonymousClass25.AnonymousClass1.this.a(showEntity, splashAdListener, view);
                    }
                });
                AnonymousClass25.this.f34576c.u.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.25.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        InstantLog.a("splash_ad_skip");
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= AnonymousClass25.this.b.hidden_url.length) {
                                AnonymousClass25.this.f34575a.b(AnonymousClass25.this.b.hidden_url);
                                return;
                            } else {
                                FindHttpUtils.a(AnonymousClass25.this.b.hidden_url[i2]);
                                i = i2 + 1;
                            }
                        }
                    }
                });
            }
        }

        @Override // com.soft.blued.utils.VideoLoadController.IVideoController
        public void a(String str) {
            Log.v("drb", "视频下载失败 videoUrl:" + str);
            this.f34575a.a("", "");
        }

        @Override // com.soft.blued.utils.VideoLoadController.IVideoController
        public void a(String str, int i) {
            Log.v("drb", "视频开始下载 onDownloading:" + i);
        }

        @Override // com.soft.blued.utils.VideoLoadController.IVideoController
        public void a(String str, String str2) {
            Log.v("drb", "视频下载成功 filePath:" + str2);
            if (this.f34576c.Q) {
                return;
            }
            this.f34575a.a();
            VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
            videoPlayConfig.b = str2;
            videoPlayConfig.j = false;
            videoPlayConfig.s = false;
            videoPlayConfig.l = true;
            videoPlayConfig.w = false;
            this.f34576c.K.b(videoPlayConfig);
            this.f34576c.K.setVisibility(4);
            this.f34576c.K.c();
            this.f34576c.postSafeRunOnUiThread(new AnonymousClass1());
        }
    }

    /* renamed from: com.soft.blued.ui.welcome.SerialSplashFragment$26  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/SerialSplashFragment$26.class */
    class AnonymousClass26 implements PLVideoPageView.OnPLVideoListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SplashAdListener f34579a;
        final /* synthetic */ SplashEntity.ShowEntity b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SerialSplashFragment f34580c;

        @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
        public void a() {
        }

        @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
        public void a(int i) {
            Log.v("drb", "onRender");
            if (this.f34580c.Q) {
                return;
            }
            AnimationUtils.b(this.f34580c.K, 200L);
            this.f34579a.a(this.b.show_url, this.b.show_post_url);
            this.f34580c.d(this.b.is_show_adm_icon, this.b.adms_type);
            this.f34580c.u.setVisibility(0);
            this.f34580c.b(1000L);
        }

        @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
        public void a(long j, long j2) {
        }

        @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
        public void b() {
            Log.v("drb", "onLoadingDismiss");
        }

        @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
        public void c() {
            Log.v("drb", "onStart");
        }

        @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
        public void d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.welcome.SerialSplashFragment$27  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/SerialSplashFragment$27.class */
    public class AnonymousClass27 implements VideoLoadController.IVideoController {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f34581a;
        final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SplashEntity.ShowEntity f34582c;
        final /* synthetic */ SplashAdListener d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.soft.blued.ui.welcome.SerialSplashFragment$27$1  reason: invalid class name */
        /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/SerialSplashFragment$27$1.class */
        public class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void a(SplashEntity.ShowEntity showEntity, SplashAdListener splashAdListener, View view) {
                Tracker.onClick(view);
                Log.v("drb", IAdInterListener.AdCommandType.AD_CLICK);
                SerialSplashFragment.this.a(showEntity, splashAdListener, SerialSplashFragment.this.N);
                SerialSplashFragment.this.D = true;
            }

            @Override // java.lang.Runnable
            public void run() {
                PLVideoPageView pLVideoPageView = SerialSplashFragment.this.K;
                final SplashEntity.ShowEntity showEntity = AnonymousClass27.this.f34582c;
                final SplashAdListener splashAdListener = AnonymousClass27.this.d;
                pLVideoPageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.-$$Lambda$SerialSplashFragment$27$1$HRCZ16VJd6hztLts7JKnx80ymIA
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SerialSplashFragment.AnonymousClass27.AnonymousClass1.this.a(showEntity, splashAdListener, view);
                    }
                });
                final ADClickCoordinate aDClickCoordinate = new ADClickCoordinate();
                SerialSplashFragment.this.K.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.27.1.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            ADClickCoordinate aDClickCoordinate2 = aDClickCoordinate;
                            aDClickCoordinate2.down_x = motionEvent.getX() + "";
                            ADClickCoordinate aDClickCoordinate3 = aDClickCoordinate;
                            aDClickCoordinate3.down_y = motionEvent.getY() + "";
                            return true;
                        } else if (action != 1) {
                            return true;
                        } else {
                            ADClickCoordinate aDClickCoordinate4 = aDClickCoordinate;
                            aDClickCoordinate4.up_x = motionEvent.getX() + "";
                            ADClickCoordinate aDClickCoordinate5 = aDClickCoordinate;
                            aDClickCoordinate5.up_y = motionEvent.getY() + "";
                            SerialSplashFragment.this.a(AnonymousClass27.this.f34582c, AnonymousClass27.this.d, aDClickCoordinate);
                            SerialSplashFragment.this.D = true;
                            return true;
                        }
                    }
                });
                SerialSplashFragment.this.K.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.27.1.2
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            ADClickCoordinate aDClickCoordinate2 = aDClickCoordinate;
                            aDClickCoordinate2.down_x = motionEvent.getX() + "";
                            ADClickCoordinate aDClickCoordinate3 = aDClickCoordinate;
                            aDClickCoordinate3.down_y = motionEvent.getY() + "";
                            return true;
                        } else if (action != 1) {
                            return true;
                        } else {
                            ADClickCoordinate aDClickCoordinate4 = aDClickCoordinate;
                            aDClickCoordinate4.up_x = motionEvent.getX() + "";
                            ADClickCoordinate aDClickCoordinate5 = aDClickCoordinate;
                            aDClickCoordinate5.up_y = motionEvent.getY() + "";
                            SerialSplashFragment.this.a(AnonymousClass27.this.f34582c, AnonymousClass27.this.d, aDClickCoordinate);
                            SerialSplashFragment.this.D = true;
                            return true;
                        }
                    }
                });
                SerialSplashFragment.this.u.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.27.1.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        InstantLog.a("splash_ad_skip");
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= AnonymousClass27.this.f34582c.hidden_url.length) {
                                AnonymousClass27.this.d.b(AnonymousClass27.this.f34582c.hidden_url);
                                return;
                            } else {
                                FindHttpUtils.a(AnonymousClass27.this.f34582c.hidden_url[i2]);
                                i = i2 + 1;
                            }
                        }
                    }
                });
            }
        }

        AnonymousClass27(int i, int i2, SplashEntity.ShowEntity showEntity, SplashAdListener splashAdListener) {
            this.f34581a = i;
            this.b = i2;
            this.f34582c = showEntity;
            this.d = splashAdListener;
        }

        @Override // com.soft.blued.utils.VideoLoadController.IVideoController
        public void a(String str) {
            Log.v("drb", "视频下载失败 videoUrl:" + str);
            this.d.a("", "");
        }

        @Override // com.soft.blued.utils.VideoLoadController.IVideoController
        public void a(String str, int i) {
            Log.v("drb", "视频开始下载 onDownloading:" + i);
        }

        @Override // com.soft.blued.utils.VideoLoadController.IVideoController
        public void a(String str, String str2) {
            Log.v("drb", "视频下载成功 filePath:" + str2);
            if (SerialSplashFragment.this.Q) {
                return;
            }
            if (SerialSplashFragment.this.getFragmentActive() == null || SerialSplashFragment.this.getFragmentActive().isActive()) {
                VideoPlayConfig videoPlayConfig = new VideoPlayConfig();
                videoPlayConfig.b = str2;
                videoPlayConfig.e = this.f34581a;
                videoPlayConfig.f = this.b;
                videoPlayConfig.j = false;
                videoPlayConfig.s = false;
                videoPlayConfig.l = true;
                videoPlayConfig.w = false;
                if (TextUtils.equals("16", this.f34582c.adms_type) || TextUtils.equals("17", this.f34582c.adms_type) || TextUtils.equals("18", this.f34582c.adms_type) || TextUtils.equals("19", this.f34582c.adms_type) || TextUtils.equals(BaseWrapper.ENTER_ID_SYSTEM_HELPER, this.f34582c.adms_type) || TextUtils.equals("21", this.f34582c.adms_type) || TextUtils.equals("22", this.f34582c.adms_type) || TextUtils.equals("23", this.f34582c.adms_type) || TextUtils.equals("25", this.f34582c.adms_type) || TextUtils.equals("26", this.f34582c.adms_type)) {
                    SerialSplashFragment.this.x.setVisibility(0);
                } else {
                    SerialSplashFragment.this.x.setVisibility(8);
                }
                SerialSplashFragment.this.K.b(videoPlayConfig);
                SerialSplashFragment.this.K.setVisibility(4);
                SerialSplashFragment.this.K.c();
                SerialSplashFragment.this.postSafeRunOnUiThread(new AnonymousClass1());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.welcome.SerialSplashFragment$29  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/SerialSplashFragment$29.class */
    public class AnonymousClass29 implements TTADUtils.TTGetSplashAdListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f34589a = false;
        final /* synthetic */ SplashAdListener b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SplashEntity.ShowEntity f34590c;

        AnonymousClass29(SplashAdListener splashAdListener, SplashEntity.ShowEntity showEntity) {
            this.b = splashAdListener;
            this.f34590c = showEntity;
        }

        @Override // com.soft.blued.utils.third.TTADUtils.TTGetSplashAdListener
        public void a() {
            if (this.f34589a) {
                return;
            }
            this.b.a("", "onNoAD");
        }

        @Override // com.soft.blued.utils.third.TTADUtils.TTGetSplashAdListener
        public void a(int i, String str) {
            if (this.f34589a) {
                return;
            }
            SplashAdListener splashAdListener = this.b;
            splashAdListener.a(i + "", str);
        }

        @Override // com.soft.blued.utils.third.TTADUtils.TTGetSplashAdListener
        public void a(TTSplashAd tTSplashAd) {
            this.f34589a = true;
            this.b.a();
            View splashView = tTSplashAd.getSplashView();
            FragmentActivity activity = SerialSplashFragment.this.getActivity();
            if (splashView != null && SerialSplashFragment.this.t != null && activity != null && !activity.isFinishing()) {
                SerialSplashFragment.this.t.removeAllViews();
                SerialSplashFragment.this.t.addView(splashView);
            }
            tTSplashAd.setSplashInteractionListener(new TTSplashAd.AdInteractionListener() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.29.1
                @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                public void onAdClicked(View view, int i) {
                    AnonymousClass29.this.b.a(AnonymousClass29.this.f34590c.click_url);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                public void onAdShow(View view, int i) {
                    AnonymousClass29.this.b.a(AnonymousClass29.this.f34590c.show_url, AnonymousClass29.this.f34590c.show_post_url);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                public void onAdSkip() {
                    AnonymousClass29.this.b.b(AnonymousClass29.this.f34590c.hidden_url);
                }

                @Override // com.bytedance.sdk.openadsdk.TTSplashAd.AdInteractionListener
                public void onAdTimeOver() {
                    if (AnonymousClass29.this.f34589a) {
                        return;
                    }
                    AnonymousClass29.this.b.a("", "onAdTimeOver");
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/SerialSplashFragment$AdsCountdownTask.class */
    public class AdsCountdownTask implements Runnable {
        AdsCountdownTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SerialSplashFragment.this.Q) {
                return;
            }
            Log.v("drb", "广告倒计时：" + SerialSplashFragment.this.E);
            if (SerialSplashFragment.this.E == 0) {
                if (SerialSplashFragment.this.j != null && SerialSplashFragment.this.j.adms_type.equalsIgnoreCase("16") && SerialSplashFragment.this.j.material_type == 1) {
                    FindHttpUtils.b(SerialSplashFragment.this.j.video_click);
                }
                SerialSplashFragment.this.r();
                return;
            }
            SerialSplashFragment.o(SerialSplashFragment.this);
            if (SerialSplashFragment.this.E == 0) {
                AppInfo.n().post(this);
            } else {
                AppInfo.n().postDelayed(this, 1000L);
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/SerialSplashFragment$SplashAdListener.class */
    public interface SplashAdListener {
        void a();

        void a(String str, String str2);

        void a(String[] strArr);

        void a(String[] strArr, String[] strArr2);

        void b(String[] strArr);
    }

    public static void a(Fragment fragment, SplashEntity.ShowEntity showEntity, int i) {
        if (showEntity == null || q || !fragment.isAdded()) {
            Log.v("drb", "开机图请求页未跳转成功");
            return;
        }
        q = true;
        Bundle bundle = new Bundle();
        bundle.putSerializable("AD_DATA", (Serializable) showEntity.splashResultList);
        bundle.putInt("AD_TIMEOUT", showEntity.timeout);
        bundle.putInt("timeout_ms", showEntity.security * 1000);
        TerminalActivity.a(fragment, SerialSplashFragment.class, bundle, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SplashEntity.ShowEntity showEntity) {
        if (this.r.remove(showEntity)) {
            Log.v("drb", "首次删除广告成功，准备开始请求下一个");
            return;
        }
        Log.v("drb", "首次删除广告失败，准备第二次删除");
        Iterator<SplashEntity.ShowEntity> it = this.r.iterator();
        while (it.hasNext()) {
            if (it.next().ads_id == showEntity.ads_id) {
                it.remove();
                Log.v("drb", "第二次删除成功");
            }
        }
    }

    private void a(final SplashEntity.ShowEntity showEntity, final SplashAdListener splashAdListener) {
        String str;
        Log.v("drb", "广告地址：" + showEntity.ads_pics);
        if (showEntity.material_type == 0) {
            str = "ceshi1012";
        } else if (showEntity.material_type != 1) {
            Log.v("drb", "百威广告 参数异常 material_type：" + showEntity.material_type);
            splashAdListener.a("", "");
            return;
        } else {
            str = "ceshi0712";
        }
        LoginRegisterHttpUtils.a(new StringHttpResponseHandler() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.23
            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onSuccess(String str2) {
                try {
                    ReachMaxResponse reachMaxResponse = (ReachMaxResponse) AppInfo.f().fromJson(str2, (Class<Object>) ReachMaxResponse.class);
                    LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.AD_REACH_MAX_RESPONSE;
                    EventTrackLoginAndRegister.a(event, showEntity.ads_id + "");
                    if (reachMaxResponse.seatbid == null || reachMaxResponse.seatbid.size() <= 0) {
                        return;
                    }
                    Seatbid seatbid = reachMaxResponse.seatbid.get(0);
                    if (seatbid.bid == null || seatbid.bid.size() <= 0) {
                        return;
                    }
                    Bid bid = seatbid.bid.get(0);
                    if (bid.ext != null) {
                        if (bid.ext.cm != null) {
                            if (showEntity.click_url != null) {
                                String[] strArr = showEntity.click_url;
                                int length = strArr.length;
                                int i = 0;
                                while (true) {
                                    int i2 = i;
                                    if (i2 >= length) {
                                        break;
                                    }
                                    bid.ext.cm.add(strArr[i2]);
                                    i = i2 + 1;
                                }
                            }
                            showEntity.click_url = (String[]) bid.ext.cm.toArray(new String[0]);
                        }
                        if (bid.ext.pm != null) {
                            if (showEntity.show_url != null) {
                                String[] strArr2 = showEntity.show_url;
                                int length2 = strArr2.length;
                                int i3 = 0;
                                while (true) {
                                    int i4 = i3;
                                    if (i4 >= length2) {
                                        break;
                                    }
                                    bid.ext.pm.add(strArr2[i4]);
                                    i3 = i4 + 1;
                                }
                            }
                            showEntity.show_url = (String[]) bid.ext.pm.toArray(new String[0]);
                        }
                        showEntity.target_url = bid.ext.ldp;
                    }
                    if (bid.adm == null || bid.adm.size() <= 0) {
                        return;
                    }
                    if (showEntity.material_type == 0) {
                        String str3 = bid.adm.get(0);
                        Log.v("drb", "百威图片地址：" + str3);
                        showEntity.ads_pics = str3;
                        SerialSplashFragment.this.b(showEntity, splashAdListener);
                        return;
                    }
                    String str4 = bid.adm.get(0);
                    Log.v("drb", "百威视频地址：" + str4);
                    showEntity.ads_pics = str4;
                    Integer[] a2 = LoginRegisterHttpUtils.a();
                    SplashEntity.ShowEntity showEntity2 = showEntity;
                    showEntity2.material_width = a2[1] + "";
                    SplashEntity.ShowEntity showEntity3 = showEntity;
                    showEntity3.material_height = a2[0] + "";
                    SerialSplashFragment.this.c(showEntity, splashAdListener);
                } catch (Exception e) {
                    splashAdListener.a("", e.toString());
                }
            }
        }, showEntity.request_id, str);
    }

    private void a(final String str, final IExternalMediaSplashAdListener iExternalMediaSplashAdListener) {
        if (getActivity() == null || getActivity().getApplication() == null) {
            return;
        }
        getActivity().getApplication().bindService(p(), new ServiceConnection() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.22
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("splash_default_enable", true);
                try {
                    IExternalMediaSplashAdService.Stub.a(iBinder).a(str, iExternalMediaSplashAdListener, bundle);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
            }
        }, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j) {
        if (this.j != null) {
            if (this.j.show_time_limit > 0) {
                this.E = this.j.show_time_limit;
            } else {
                this.E = 5;
            }
        }
        AppInfo.n().postDelayed(this.I, j);
    }

    private void b(final SplashEntity.ShowEntity showEntity) {
        new KSSplashManager().a(this.m, showEntity.third_id, this.t, getFragmentActive(), new SplashAdListenerAdapter() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.19
            @Override // com.soft.blued.ui.welcome.manager.SplashAdListenerAdapter, com.soft.blued.ui.welcome.manager.SplashAdListener
            public void a() {
                SerialSplashFragment.this.v.setBackgroundColor(SerialSplashFragment.this.m.getResources().getColor(2131102478));
                SerialSplashFragment.this.a(showEntity.hot_area_limit_type);
                SerialSplashFragment.this.f();
                EventTrackLoginAndRegister.b(LoginAndRegisterProtos.Event.OPEN_AD_RETURN_SUCCESS, showEntity);
                Log.v("drb", "快手广告 onAdLoaded");
            }

            @Override // com.soft.blued.ui.welcome.manager.SplashAdListenerAdapter, com.soft.blued.ui.welcome.manager.SplashAdListener
            public void a(int i, String str) {
                Log.v("drb", "快手广告 onAdError");
                SerialSplashFragment.this.p = true;
                SerialSplashFragment.this.a(showEntity);
                SerialSplashFragment.this.n();
                LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.OPEN_AD_RETURN_FAIL;
                SplashEntity.ShowEntity showEntity2 = showEntity;
                EventTrackLoginAndRegister.a(event, showEntity2, str, i + "");
            }

            @Override // com.soft.blued.ui.welcome.manager.SplashAdListenerAdapter, com.soft.blued.ui.welcome.manager.SplashAdListener
            public void b() {
                Log.v("drb", "快手广告 onAdShow");
                SerialSplashFragment.this.p = true;
                SerialSplashFragment.this.o = System.currentTimeMillis();
                FindHttpUtils.b(showEntity.show_url);
                SerialSplashFragment.this.d = true;
                EventTrackLoginAndRegister.d(LoginAndRegisterProtos.Event.OPEN_AD_SHOW, showEntity);
            }

            @Override // com.soft.blued.ui.welcome.manager.SplashAdListenerAdapter, com.soft.blued.ui.welcome.manager.SplashAdListener
            public void c() {
                Log.v("drb", "快手广告 onAdClick");
                FindHttpUtils.b(showEntity.click_url);
                EventTrackLoginAndRegister.d(LoginAndRegisterProtos.Event.OPEN_AD_CLICK, showEntity);
            }

            @Override // com.soft.blued.ui.welcome.manager.SplashAdListenerAdapter, com.soft.blued.ui.welcome.manager.SplashAdListener
            public void d() {
                Log.v("drb", "快手广告 onAdDismiss");
                SerialSplashFragment.this.l();
                SerialSplashFragment.this.d = false;
                EventTrackLoginAndRegister.d(LoginAndRegisterProtos.Event.OPEN_AD_SKIP_CLICK, showEntity);
            }

            @Override // com.soft.blued.ui.welcome.manager.SplashAdListenerAdapter, com.soft.blued.ui.welcome.manager.SplashAdListener
            public void e() {
                Log.v("drb", "快手广告 onAdDismiss");
                SerialSplashFragment.this.l();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(SplashEntity.ShowEntity showEntity, SplashAdListener splashAdListener) {
        if (!StringUtils.d(showEntity.ads_pics)) {
            ImageFileLoader.a(getFragmentActive()).a(showEntity.ads_pics).a(new AnonymousClass24(splashAdListener, showEntity)).a();
            return;
        }
        if ("9".equalsIgnoreCase(showEntity.adms_type)) {
            Log.v("drb", "百威广告失败：地址为空");
        } else if ("2".equalsIgnoreCase(showEntity.adms_type)) {
            Log.v("drb", "淘宝广告失败：地址为空");
        } else if ("16".equalsIgnoreCase(showEntity.adms_type)) {
            Log.v("drb", "海贝广告失败：地址为空");
        } else if ("17".equalsIgnoreCase(showEntity.adms_type)) {
            Log.v("drb", "拼多多广告失败：地址为空");
        } else if ("18".equalsIgnoreCase(showEntity.adms_type)) {
            Log.v("drb", "桔柚广告失败：地址为空");
        } else if ("19".equalsIgnoreCase(showEntity.adms_type)) {
            Log.v("drb", "InMobi广告失败：地址为空");
        } else {
            Log.v("drb", "直客广告失败：地址为空");
        }
        splashAdListener.a("", "API广告失败：地址为空");
    }

    private void c(final SplashEntity.ShowEntity showEntity) {
        new OppoSplashManager().a(this.m, showEntity.third_id, this.t, getFragmentActive(), new SplashAdListenerAdapter() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.20
            @Override // com.soft.blued.ui.welcome.manager.SplashAdListenerAdapter, com.soft.blued.ui.welcome.manager.SplashAdListener
            public void a() {
                SerialSplashFragment.this.a(showEntity.hot_area_limit_type);
                SerialSplashFragment.this.f();
                EventTrackLoginAndRegister.b(LoginAndRegisterProtos.Event.OPEN_AD_RETURN_SUCCESS, showEntity);
            }

            @Override // com.soft.blued.ui.welcome.manager.SplashAdListenerAdapter, com.soft.blued.ui.welcome.manager.SplashAdListener
            public void a(int i, String str) {
                SerialSplashFragment.this.p = true;
                SerialSplashFragment.this.a(showEntity);
                SerialSplashFragment.this.n();
                LoginAndRegisterProtos.Event event = LoginAndRegisterProtos.Event.OPEN_AD_RETURN_FAIL;
                SplashEntity.ShowEntity showEntity2 = showEntity;
                EventTrackLoginAndRegister.a(event, showEntity2, str, i + "");
            }

            @Override // com.soft.blued.ui.welcome.manager.SplashAdListenerAdapter, com.soft.blued.ui.welcome.manager.SplashAdListener
            public void b() {
                SerialSplashFragment.this.p = true;
                SerialSplashFragment.this.o = System.currentTimeMillis();
                FindHttpUtils.b(showEntity.show_url);
                SerialSplashFragment.this.d = true;
                EventTrackLoginAndRegister.d(LoginAndRegisterProtos.Event.OPEN_AD_SHOW, showEntity);
            }

            @Override // com.soft.blued.ui.welcome.manager.SplashAdListenerAdapter, com.soft.blued.ui.welcome.manager.SplashAdListener
            public void c() {
                FindHttpUtils.b(showEntity.click_url);
                EventTrackLoginAndRegister.d(LoginAndRegisterProtos.Event.OPEN_AD_CLICK, showEntity);
            }

            @Override // com.soft.blued.ui.welcome.manager.SplashAdListenerAdapter, com.soft.blued.ui.welcome.manager.SplashAdListener
            public void d() {
                FindHttpUtils.b(showEntity.hidden_url);
                Log.v("drb", "接收到onAdDismiss回调开始跳转首页");
                SerialSplashFragment.this.l();
                SerialSplashFragment.this.d = false;
                EventTrackLoginAndRegister.d(LoginAndRegisterProtos.Event.OPEN_AD_SKIP_CLICK, showEntity);
            }

            @Override // com.soft.blued.ui.welcome.manager.SplashAdListenerAdapter, com.soft.blued.ui.welcome.manager.SplashAdListener
            public void e() {
                SerialSplashFragment.this.l();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final SplashEntity.ShowEntity showEntity, final SplashAdListener splashAdListener) {
        int i;
        int i2;
        float f;
        this.B.setVisibility(8);
        int i3 = AppInfo.l;
        int a2 = AppInfo.m + StatusBarHelper.a(this.m);
        Log.v("drb", "width:" + i3 + " -- height:" + a2);
        int c2 = StringUtils.c(showEntity.material_width);
        int c3 = StringUtils.c(showEntity.material_height);
        if (c2 == 0 || c3 == 0) {
            Log.v("drb", "直客广告失败 参数异常：" + c2 + " - " + c3);
            splashAdListener.a("", "");
        } else if (TextUtils.isEmpty(showEntity.ads_pics)) {
            Log.v("drb", "直客广告失败 参数异常 showEntity.ads_pics：" + showEntity.ads_pics);
            splashAdListener.a("", "");
        } else {
            this.L = showEntity.ads_pics;
            float f2 = i3;
            float f3 = c2;
            float f4 = f2 / f3;
            float f5 = a2;
            float f6 = c3;
            float f7 = f5 / f6;
            if (f4 > f7) {
                i = (int) (f3 * f4);
                f = f6 * f4;
            } else if (f4 > f7) {
                i = 0;
                i2 = 0;
                Log.v("drb", "videoWH[0]:" + i + " -- " + i2);
                VideoLoadController.a(this.L);
                AnonymousClass27 anonymousClass27 = new AnonymousClass27(i, i2, showEntity, splashAdListener);
                this.K.setOnPLVideoListener(new PLVideoPageView.OnPLVideoListener() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.28
                    @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
                    public void a() {
                    }

                    @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
                    public void a(int i4) {
                        Log.v("drb", "onRender");
                        if (SerialSplashFragment.this.Q) {
                            return;
                        }
                        splashAdListener.a();
                        AnimationUtils.b(SerialSplashFragment.this.K, 300L);
                        splashAdListener.a(showEntity.show_url, showEntity.show_post_url);
                        SerialSplashFragment.this.d(showEntity.is_show_adm_icon, showEntity.adms_type);
                        Log.v("drb", "视频广告类型  adms_type=" + showEntity.adms_type);
                        SerialSplashFragment.this.u.setVisibility(0);
                        SerialSplashFragment.this.b(1000L);
                    }

                    @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
                    public void a(long j, long j2) {
                    }

                    @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
                    public void b() {
                        Log.v("drb", "onLoadingDismiss");
                    }

                    @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
                    public void c() {
                        Log.v("drb", "onStart");
                        FindHttpUtils.b(showEntity.video_start);
                    }

                    @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
                    public void d() {
                    }
                });
                this.J = anonymousClass27;
                VideoLoadController.a(this.L, anonymousClass27);
            } else {
                i = (int) (f3 * f7);
                f = f6 * f7;
            }
            i2 = (int) f;
            Log.v("drb", "videoWH[0]:" + i + " -- " + i2);
            VideoLoadController.a(this.L);
            AnonymousClass27 anonymousClass272 = new AnonymousClass27(i, i2, showEntity, splashAdListener);
            this.K.setOnPLVideoListener(new PLVideoPageView.OnPLVideoListener() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.28
                @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
                public void a() {
                }

                @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
                public void a(int i4) {
                    Log.v("drb", "onRender");
                    if (SerialSplashFragment.this.Q) {
                        return;
                    }
                    splashAdListener.a();
                    AnimationUtils.b(SerialSplashFragment.this.K, 300L);
                    splashAdListener.a(showEntity.show_url, showEntity.show_post_url);
                    SerialSplashFragment.this.d(showEntity.is_show_adm_icon, showEntity.adms_type);
                    Log.v("drb", "视频广告类型  adms_type=" + showEntity.adms_type);
                    SerialSplashFragment.this.u.setVisibility(0);
                    SerialSplashFragment.this.b(1000L);
                }

                @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
                public void a(long j, long j2) {
                }

                @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
                public void b() {
                    Log.v("drb", "onLoadingDismiss");
                }

                @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
                public void c() {
                    Log.v("drb", "onStart");
                    FindHttpUtils.b(showEntity.video_start);
                }

                @Override // com.blued.android.module.player.media.view.PLVideoPageView.OnPLVideoListener
                public void d() {
                }
            });
            this.J = anonymousClass272;
            VideoLoadController.a(this.L, anonymousClass272);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i, String str) {
        if (i != 1) {
            this.y.setVisibility(8);
        } else if (TextUtils.equals(str, "17")) {
            this.z.setVisibility(0);
            this.y.setVisibility(8);
            this.z.setImageResource(2131235995);
        } else if (TextUtils.equals(str, "18")) {
            this.z.setVisibility(0);
            this.y.setVisibility(8);
            this.z.setImageResource(R.drawable.jy_ad_icon);
        } else if (TextUtils.equals(str, "19")) {
            this.z.setVisibility(0);
            this.y.setVisibility(8);
            this.z.setImageResource(R.drawable.im_ad_icon);
        } else if (TextUtils.equals(str, BaseWrapper.ENTER_ID_SYSTEM_HELPER)) {
            this.z.setVisibility(0);
            this.y.setVisibility(8);
            this.z.setImageResource(R.drawable.tg_ad_icon);
        } else if (TextUtils.equals(str, "21")) {
            this.z.setVisibility(0);
            this.y.setVisibility(8);
            this.z.setImageResource(R.drawable.sm_ad_icon);
        } else if (TextUtils.equals(str, "22")) {
            this.z.setVisibility(0);
            this.y.setVisibility(8);
            this.z.setImageResource(R.drawable.lz_ad_icon);
        } else if (TextUtils.equals(str, "23")) {
            this.z.setVisibility(0);
            this.y.setVisibility(8);
            this.z.setImageResource(R.drawable.kd_ad_icon);
        } else if (TextUtils.equals(str, "25")) {
            this.z.setVisibility(0);
            this.y.setVisibility(8);
            this.z.setImageResource(R.drawable.rg_ad_icon);
        } else if (TextUtils.equals(str, "26")) {
            this.z.setVisibility(0);
            this.y.setVisibility(8);
            this.z.setImageResource(R.drawable.fw_ad_icon);
        } else {
            this.z.setVisibility(8);
            this.y.setVisibility(0);
            if (TextUtils.equals(str, "16")) {
                this.y.setImageResource(2131232908);
            } else {
                this.y.setImageResource(2131230919);
            }
        }
    }

    private void d(SplashEntity.ShowEntity showEntity) {
        if ("2".equalsIgnoreCase(showEntity.adms_type)) {
            FindHttpUtils.a(showEntity.target_url);
        }
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.JD_AD_TO_H5);
        BluedApplicationLike.outUri = BluedURIRouter.a().f(showEntity.target_url);
        if (BluedApplicationLike.outUri == null) {
            WebViewShowInfoFragment.show(this.m, showEntity.target_url, 9);
            l();
        }
    }

    private void d(SplashEntity.ShowEntity showEntity, SplashAdListener splashAdListener) {
        Log.v("drb", "广告地址：" + showEntity.ads_pics);
        if (showEntity.material_type == 0) {
            b(showEntity, splashAdListener);
        } else if (showEntity.material_type == 1) {
            c(showEntity, splashAdListener);
        } else {
            Log.v("drb", "API广告失败 参数异常 material_type：" + showEntity.material_type);
            splashAdListener.a("", "API广告失败 参数异常 material_type:" + showEntity.material_type);
        }
    }

    private void e(SplashEntity.ShowEntity showEntity, SplashAdListener splashAdListener) {
        TTADUtils.a(this.m, showEntity.third_id, new AnonymousClass29(splashAdListener, showEntity));
    }

    private void f(final SplashEntity.ShowEntity showEntity, final SplashAdListener splashAdListener) {
        this.G = System.currentTimeMillis();
        SplashAD splashAD = new SplashAD(getActivity(), showEntity.third_id, new SplashADListener() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.30
            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADClicked() {
                splashAdListener.a(showEntity.click_url);
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADDismissed() {
                splashAdListener.b(showEntity.hidden_url);
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADExposure() {
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADLoaded(long j) {
                splashAdListener.a();
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADPresent() {
                splashAdListener.a(showEntity.show_url, showEntity.show_post_url);
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADTick(long j) {
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onNoAD(AdError adError) {
                Log.v("drb", "广点通回调 onNoAD:" + adError.getErrorMsg());
                SplashAdListener splashAdListener2 = splashAdListener;
                splashAdListener2.a(adError.getErrorCode() + "", adError.getErrorMsg());
            }
        }, 3000);
        this.F = splashAD;
        splashAD.fetchAndShowIn(this.t);
    }

    private void g(final SplashEntity.ShowEntity showEntity, final SplashAdListener splashAdListener) {
        ATSplashAd aTSplashAd = new ATSplashAd(this.m, showEntity.third_id, new ATSplashAdListener() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.31
            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onAdClick(ATAdInfo aTAdInfo) {
                splashAdListener.a(showEntity.click_url);
            }

            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onAdDismiss(ATAdInfo aTAdInfo, ATSplashAdExtraInfo aTSplashAdExtraInfo) {
                splashAdListener.b(showEntity.hidden_url);
            }

            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onAdLoadTimeout() {
            }

            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onAdLoaded(boolean z) {
                splashAdListener.a();
            }

            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onAdShow(ATAdInfo aTAdInfo) {
                splashAdListener.a(showEntity.show_url, showEntity.show_post_url);
            }

            @Override // com.anythink.splashad.api.ATSplashAdListener
            public void onNoAdError(com.anythink.core.api.AdError adError) {
                splashAdListener.a(adError.getCode(), adError.getFullErrorInfo());
                Log.v("drb", "topon广告载入失败：" + adError.getFullErrorInfo());
            }
        });
        this.A = aTSplashAd;
        if (aTSplashAd.isAdReady()) {
            this.A.show(getActivity(), this.t);
        } else {
            this.A.loadAd();
        }
    }

    private void h(final SplashEntity.ShowEntity showEntity, final SplashAdListener splashAdListener) {
        AdParam build = new AdParam.Builder().build();
        SplashView.SplashAdLoadListener splashAdLoadListener = new SplashView.SplashAdLoadListener() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.32
            @Override // com.huawei.hms.ads.splash.SplashView.SplashAdLoadListener
            public void onAdDismissed() {
                splashAdListener.b(showEntity.hidden_url);
            }

            @Override // com.huawei.hms.ads.splash.SplashView.SplashAdLoadListener
            public void onAdFailedToLoad(int i) {
                Log.v("drb", "华为广告失败错误码：" + i);
                SplashAdListener splashAdListener2 = splashAdListener;
                splashAdListener2.a(i + "", "");
            }

            @Override // com.huawei.hms.ads.splash.SplashView.SplashAdLoadListener
            public void onAdLoaded() {
                splashAdListener.a();
            }
        };
        SplashView splashView = new SplashView(this.m);
        splashView.setAudioFocusType(1);
        splashView.setAdDisplayListener(new SplashAdDisplayListener() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.33
            @Override // com.huawei.hms.ads.splash.SplashAdDisplayListener
            public void onAdClick() {
                splashAdListener.a(showEntity.click_url);
            }

            @Override // com.huawei.hms.ads.splash.SplashAdDisplayListener
            public void onAdShowed() {
                splashAdListener.a(showEntity.show_url, showEntity.show_post_url);
            }
        });
        FragmentActivity activity = getActivity();
        if (this.t != null && activity != null && !activity.isFinishing()) {
            this.t.removeAllViews();
            this.t.addView(splashView);
        }
        splashView.load(showEntity.third_id, 1, build, splashAdLoadListener);
    }

    private void m() {
        LiveEventBus.get(EventBusConstant.KEY_EVENT_SPLASH_AD_SKIP_TO_HOME, Boolean.class).observe(this, new Observer<Boolean>() { // from class: com.soft.blued.ui.welcome.SerialSplashFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(Boolean bool) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x022d, code lost:
        if (r0.equals("3") != false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void n() {
        /*
            Method dump skipped, instructions count: 1279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.welcome.SerialSplashFragment.n():void");
    }

    static /* synthetic */ int o(SerialSplashFragment serialSplashFragment) {
        int i = serialSplashFragment.E;
        serialSplashFragment.E = i - 1;
        return i;
    }

    private void o() {
        a(AppInfo.f9486a, this.P);
    }

    private Intent p() {
        Intent intent = new Intent();
        intent.setClassName("com.miui.systemAdSolution", "com.miui.systemAdSolution.splashAd.ExternalMediaSplashAdService");
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        b(0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        if (this.K.getVisibility() == 0) {
            this.K.g();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            q = false;
            Intent intent = new Intent();
            long j = this.o;
            long j2 = j;
            if (j == 0) {
                j2 = System.currentTimeMillis();
            }
            intent.putExtra("THIRD_UNVALID_DURATION", j2);
            intent.putExtra("THIRD_HAS_CALL_BACK", this.p);
            activity.setResult(-1, intent);
            activity.finish();
        }
    }

    public void a(int i, int i2, String str, String str2, String str3) {
        Log.v("drb", "播放动画 hotDynamic:" + i + " -- alpha：" + i2);
        switch (i) {
            case 0:
            case 1:
                a(i2, str);
                return;
            case 2:
                b(i2, str);
                return;
            case 3:
                c(i2, str);
                return;
            case 4:
                a(str2);
                return;
            case 5:
                a(i2, str, str3);
                return;
            case 6:
                b(i2, str, str3);
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.ui.TimeoutFragment
    public void a(ADClickCoordinate aDClickCoordinate) {
        if (this.j == null || !k()) {
            return;
        }
        this.N = aDClickCoordinate;
        ImageView imageView = this.B;
        if (imageView != null && imageView.getVisibility() == 0) {
            this.B.callOnClick();
            return;
        }
        PLVideoPageView pLVideoPageView = this.K;
        if (pLVideoPageView == null || pLVideoPageView.getVisibility() != 0) {
            return;
        }
        this.K.callOnClick();
    }

    public void a(SplashEntity.ShowEntity showEntity, SplashAdListener splashAdListener, ADClickCoordinate aDClickCoordinate) {
        Log.v("drb", "开机图点击：intoADUrl（）");
        if (aDClickCoordinate != null) {
            splashAdListener.a(null);
        }
        if (showEntity.adms_type.equalsIgnoreCase("16") && showEntity.material_type == 1) {
            FindHttpUtils.b(showEntity.video_click);
        }
        if (showEntity.click_url != null && showEntity.click_url.length > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= showEntity.click_url.length) {
                    break;
                }
                String str = showEntity.click_url[i2];
                Log.v("drb", "showEntity.click_url:" + str);
                String str2 = str;
                if (str.startsWith(BluedHttpUrl.q())) {
                    Map<String, String> a2 = BluedHttpTools.a();
                    if (this.D) {
                        a2.put("is_valid", "0");
                    } else {
                        a2.put("is_valid", "1");
                    }
                    str2 = HttpUtils.a(a2, str);
                }
                FindHttpUtils.a(str2, aDClickCoordinate);
                i = i2 + 1;
            }
            this.D = true;
        }
        FindHttpUtils.a(showEntity.click_post_url);
        if (showEntity.download != null) {
            Log.v("drb", "开机图点击：当前是下载类型广告：" + showEntity.download);
            AdDownLoadAppDialogFragment.f34505a.a(getChildFragmentManager(), this.m, showEntity.download);
            return;
        }
        if (showEntity.wx != null) {
            Log.v("drb", "开机图点击：当前是小程序类型广告：" + showEntity.wx);
            if (!TextUtils.isEmpty(showEntity.wx.id) && !TextUtils.isEmpty(showEntity.wx.path)) {
                if (showEntity.wx.is_popup == 1) {
                    AdMiniAppDialogFragment.a(getChildFragmentManager(), showEntity.wx.id, showEntity.wx.path, showEntity);
                    return;
                }
                WeChatUtils.a(this.m, showEntity.wx.id, showEntity.wx.path);
                l();
                return;
            }
        }
        Log.v("drb", "开机图点击： adExtra.deep_link_url:" + showEntity.deep_link_url);
        Log.v("drb", "开机图点击： adExtra.target_url:" + showEntity.target_url);
        if (TextUtils.isEmpty(showEntity.deep_link_url)) {
            d(showEntity);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(showEntity.deep_link_url));
        if (!AppUtils.a(intent)) {
            Log.v("drb", "开机图点击：deep_link不可以跳转第三方app");
            d(showEntity);
            return;
        }
        if ("2".equalsIgnoreCase(showEntity.adms_type)) {
            FindHttpUtils.a(showEntity.deep_link_url);
        }
        EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.JD_AD_TO_APP);
        this.m.startActivity(intent);
        FindHttpUtils.a(showEntity.dp_post_url);
        FindHttpUtils.b(showEntity.dp_url);
        if (showEntity.deep_link_url.contains("market://")) {
            AppInfo.n().removeCallbacks(this.I);
            d();
            this.O = true;
        } else {
            l();
        }
        Log.v("drb", "开机图点击：deep_link可以跳转第三方app");
    }

    @Override // com.blued.android.ui.TimeoutFragment
    public void b() {
        if (this.j == null || !k()) {
            return;
        }
        ImageView imageView = this.B;
        if (imageView == null || imageView.getVisibility() != 0) {
            PLVideoPageView pLVideoPageView = this.K;
            if (pLVideoPageView != null && pLVideoPageView.getVisibility() == 0) {
                this.K.callOnClick();
            }
        } else {
            this.B.callOnClick();
        }
        Log.v("drb", "向上滑动 :" + this.j.ads_id);
        EventTrackLoginAndRegister.d(LoginAndRegisterProtos.Event.OPEN_AD_UP_SLIDE, this.j);
    }

    @Override // com.blued.android.ui.TimeoutFragment
    public void c() {
        if (this.j != null) {
            if ((this.j.hot_dynamic == 5 || this.j.hot_dynamic == 6) && k()) {
                ImageView imageView = this.B;
                if (imageView == null || imageView.getVisibility() != 0) {
                    PLVideoPageView pLVideoPageView = this.K;
                    if (pLVideoPageView != null && pLVideoPageView.getVisibility() == 0) {
                        this.K.callOnClick();
                    }
                } else {
                    this.B.callOnClick();
                }
                Log.v("drb", "摇一摇 :" + this.j.ads_id);
                EventTrackLoginAndRegister.d(LoginAndRegisterProtos.Event.OPEN_AD_SHAKE, this.j);
            }
        }
    }

    @Override // com.blued.android.ui.TimeoutFragment
    public void g() {
        Log.v("drb", "串联广告请求超时，关闭页面");
        l();
    }

    @Override // com.blued.android.ui.TimeoutFragment
    public View h() {
        return this.n;
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public boolean isActivitySwipeBackEnable() {
        return false;
    }

    public void j() {
        getActivity().getWindow().getDecorView().setBackground(BluedSkinUtils.b(this.m, R.drawable.app_loading_bg));
        this.t = (FrameLayout) this.n.findViewById(R.id.fl_ad_content);
        this.u = this.n.findViewById(R.id.ll_click_skip);
        this.B = (ImageView) this.n.findViewById(R.id.iv_pictrue);
        this.v = this.n.findViewById(R.id.view_btm_bar);
        this.w = this.n.findViewById(R.id.iv_btm_bar);
        this.x = this.n.findViewById(R.id.iv_video_ad_btm_bar);
        this.y = (ImageView) this.n.findViewById(2131364417);
        this.z = (ImageView) this.n.findViewById(R.id.img_ad_left_icon);
        this.K = (PLVideoPageView) this.n.findViewById(2131373091);
        this.v.setVisibility(0);
        this.v.setBackgroundColor(this.m.getResources().getColor(2131102388));
        a(this.s * 1000);
        n();
    }

    public boolean k() {
        return "0".equalsIgnoreCase(this.j.adms_type) || "2".equalsIgnoreCase(this.j.adms_type) || "9".equalsIgnoreCase(this.j.adms_type) || "16".equalsIgnoreCase(this.j.adms_type) || "17".equalsIgnoreCase(this.j.adms_type) || "18".equalsIgnoreCase(this.j.adms_type) || "19".equalsIgnoreCase(this.j.adms_type) || BaseWrapper.ENTER_ID_SYSTEM_HELPER.equalsIgnoreCase(this.j.adms_type) || "21".equalsIgnoreCase(this.j.adms_type) || "22".equalsIgnoreCase(this.j.adms_type) || "23".equalsIgnoreCase(this.j.adms_type) || "25".equalsIgnoreCase(this.j.adms_type) || "26".equalsIgnoreCase(this.j.adms_type);
    }

    public void l() {
        AppInfo.n().removeCallbacks(this.I);
        Log.v("drb", "关闭串联广告页面");
        r();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getActivity().getWindow().setFlags(1024, 1024);
        this.m = getActivity();
        getActivity().overridePendingTransition(R.anim.activity_switch_none, R.anim.activity_switch_none);
        View view = this.n;
        if (view == null) {
            if (getArguments() != null) {
                List<SplashEntity> list = (List) getArguments().getSerializable("AD_DATA");
                if (list != null) {
                    for (SplashEntity splashEntity : list) {
                        this.r.add(splashEntity.today);
                    }
                }
                this.s = getArguments().getInt("AD_TIMEOUT");
                Log.v("drb", "串联广告超时时间：" + this.s);
            }
            this.n = layoutInflater.inflate(R.layout.fragment_tx_splash, viewGroup, false);
            j();
            m();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.n.getParent()).removeView(this.n);
        }
        return this.n;
    }

    @Override // com.blued.android.ui.TimeoutFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        AppInfo.n().removeCallbacks(this.I);
        ATSplashAd aTSplashAd = this.A;
        if (aTSplashAd != null) {
            aTSplashAd.onDestory();
        }
        q = false;
        Log.v("drb", "开机图页面销毁，重置IF_AD_SHOW");
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnKeyListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 || i == 3) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.blued.android.ui.TimeoutFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.O) {
            AppInfo.n().post(this.I);
        } else if (this.Q) {
            b(1000L);
        }
        this.Q = false;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        BluedPreferences.N(true);
        Log.v("drb", "广告页面onStart");
        if (this.M) {
            Log.v("drb", "从其他页面回到开屏页面时调用，进入应用");
            l();
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        Log.v("drb", "广告页面onStop");
        this.Q = true;
        f();
    }
}
