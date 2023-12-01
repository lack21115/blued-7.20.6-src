package com.soft.blued.app;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.chat.BluedChat;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppHandoverListener;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.UiUtils;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.statistics.BluedStatistics;
import com.blued.community.manager.CommunityManager;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.CommonConstants;
import com.soft.blued.manager.SendNotificationManager;
import com.soft.blued.push.PushManager;
import com.soft.blued.sdk.SDKActionManager;
import com.soft.blued.ui.discover.fragment.SendFeedFloatManager;
import com.soft.blued.ui.find.manager.FlashZegoApiManager;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.msg.customview.GlobalTaskFloatManager;
import com.soft.blued.ui.setting.fragment.LockPatternStartupFragment;
import com.soft.blued.ui.user.utils.CommandManager;
import com.soft.blued.ui.web.WebLinkManager;
import com.soft.blued.ui.welcome.WelcomeFragment;
import com.soft.blued.ui.welcome.model.SplashEntity;
import com.soft.blued.ui.welcome.model.SplashExtraEntity;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.BuglyCrashRecorder;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.activity.BDActivityManager;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/app/BluedAppHandoverListener.class */
public class BluedAppHandoverListener implements AppHandoverListener {
    private Context b;
    private WeakReference<Activity> d;
    private long e;
    private Runnable f;
    private Runnable g;

    /* renamed from: c  reason: collision with root package name */
    private boolean f28243c = false;

    /* renamed from: a  reason: collision with root package name */
    public BluedUIHttpResponse f28242a = new BluedUIHttpResponse<BluedEntity<SplashEntity, SplashExtraEntity>>(null) { // from class: com.soft.blued.app.BluedAppHandoverListener.3
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<SplashEntity, SplashExtraEntity> bluedEntity) {
            SplashExtraEntity splashExtraEntity;
            if (bluedEntity == null || bluedEntity.extra == null || (splashExtraEntity = bluedEntity.extra) == null || splashExtraEntity.splash_config == null) {
                return;
            }
            BluedPreferences.a(splashExtraEntity.splash_config.interval);
        }
    };

    public BluedAppHandoverListener(Context context) {
        this.f = null;
        this.g = null;
        this.b = context.getApplicationContext();
        this.f = new Runnable() { // from class: com.soft.blued.app.BluedAppHandoverListener.1
            @Override // java.lang.Runnable
            public void run() {
                BluedChat.getInstance().pauseIMService();
            }
        };
        this.g = new Runnable() { // from class: com.soft.blued.app.BluedAppHandoverListener.2
            @Override // java.lang.Runnable
            public void run() {
                BluedChat.getInstance().resumeIMService();
            }
        };
    }

    public boolean a() {
        return this.f28243c;
    }

    public Activity b() {
        WeakReference<Activity> weakReference = this.d;
        if (weakReference != null) {
            Activity activity = weakReference.get();
            if (UiUtils.a(activity)) {
                return activity;
            }
            return null;
        }
        return null;
    }

    public long c() {
        return this.e;
    }

    @Override // com.blued.android.core.AppHandoverListener
    public void onAppBack() {
        this.d = null;
        Logger.c("tempTest", "onAppBack, last_isAppOnForeground:", Boolean.valueOf(this.f28243c));
        Activity b = SendNotificationManager.a().b();
        if (b != null) {
            CommunityManager.f19086a.a().a(b.getClass().getSimpleName());
        }
        LiveEventBus.get("APP_CHANGE_TO_BACKGROUND").postDelay(true, 100L);
        if (this.f28243c) {
            this.f28243c = false;
            BluedStatistics.e().d();
            long currentTimeMillis = System.currentTimeMillis();
            if (!CommonConstants.b.booleanValue()) {
                BluedPreferences.b(currentTimeMillis);
            }
            BluedPreferences.c(currentTimeMillis);
            SDKActionManager.a();
            ChatManager.getInstance().appActiveChanged(false);
            AppInfo.n().postDelayed(this.f, m.ag);
        }
        LiveFloatManager.a().l();
        SendFeedFloatManager.a().g();
        FlashZegoApiManager.a().d();
        AudioChannelManager.j().b();
        GlobalTaskFloatManager.a().d();
        BluedPreferences.ag(false);
    }

    @Override // com.blued.android.core.AppHandoverListener
    public void onAppFore(Activity activity) {
        boolean z;
        this.d = new WeakReference<>(activity);
        String str = "";
        CommunityManager.f19086a.a().b("");
        if (activity != null) {
            BuglyCrashRecorder.f34723a = activity.getClass().getName();
            CommunityManager.f19086a.a().a(activity.getClass().getSimpleName());
            if (activity instanceof BaseFragmentActivity) {
                List<Fragment> fragments = ((BaseFragmentActivity) activity).getSupportFragmentManager().getFragments();
                if (fragments.size() > 0) {
                    int i = 0;
                    while (i < fragments.size()) {
                        String str2 = str;
                        if (fragments.get(i) instanceof BaseFragment) {
                            str2 = str;
                            if (fragments.get(i) != null) {
                                str2 = str + ((BaseFragment) fragments.get(i)).getSimpleName() + ", ";
                            }
                        }
                        i++;
                        str = str2;
                    }
                    CommunityManager.f19086a.a().b(str);
                }
            }
        }
        LiveEventBus.get("APP_CHANGE_TO_BACKGROUND").postDelay(false, 100L);
        if (Build.VERSION.SDK_INT < 29 || !BluedPreferences.dr()) {
            BluedPreferences.W(false);
        } else {
            BluedPreferences.W(true);
            BluedPreferences.O(BluedSkinUtils.a(activity));
        }
        Logger.e("tempTest", "skin auto system : ", Boolean.valueOf(BluedPreferences.dr()));
        Logger.e("tempTest", "skin current type : ", Boolean.valueOf(BluedPreferences.cK()));
        Logger.c("tempTest", "onAppFore, last_isAppOnForeground:", Boolean.valueOf(this.f28243c));
        if (this.f28243c) {
            return;
        }
        this.f28243c = true;
        BluedStatistics.e().c();
        try {
            BluedChat.getInstance().startIMService(AppInfo.d());
        } catch (Throwable th) {
        }
        ChatManager.getInstance().appActiveChanged(true);
        PushManager.a().c(AppInfo.d());
        AppInfo.n().removeCallbacks(this.f);
        AppInfo.n().post(this.g);
        WebLinkManager.f34474a.a();
        long currentTimeMillis = System.currentTimeMillis();
        List<Activity> b = BDActivityManager.f34819a.b();
        if (b != null) {
            for (Activity activity2 : b) {
                if (activity2 instanceof HomeActivity) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        Log.v("drb", "----------- onAppFore:" + z);
        if (b() != null) {
            int aU = (int) (BluedPreferences.aU() * 1000.0f);
            int i2 = aU;
            if (aU <= 0) {
                i2 = 900000;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("时间条件：");
            long j = i2;
            sb.append(currentTimeMillis - BluedPreferences.bd().longValue() > j);
            Log.v("drb", sb.toString());
            Log.v("drb", "登录条件：" + UserInfo.getInstance().isLogin());
            Log.v("drb", "视频条件：" + ShortVideoProxy.e().b());
            if (currentTimeMillis - BluedPreferences.bd().longValue() > j && UserInfo.getInstance().isLogin() && !ShortVideoProxy.e().b() && !WelcomeFragment.b) {
                WelcomeFragment.a((Context) b(), true, !z);
            }
        }
        this.e = currentTimeMillis;
        long longValue = BluedPreferences.bc().longValue();
        long j2 = longValue;
        if (longValue == 0) {
            j2 = longValue;
            if (!BluedApplicationLike.isMainApplication(this.b)) {
                j2 = currentTimeMillis;
            }
        }
        if (!BluedPreferences.aY() || !UserInfo.getInstance().isLogin() || CommonConstants.b.booleanValue()) {
            LiveFloatManager.a().k();
            if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                CommandManager.a().a(activity);
            }
            AudioChannelManager.j().a();
            GlobalTaskFloatManager.a().e();
        } else if (currentTimeMillis - j2 <= 30000) {
            LiveFloatManager.a().k();
            AudioChannelManager.j().a();
            GlobalTaskFloatManager.a().e();
        } else {
            CommonConstants.b = true;
            if (b() != null) {
                TerminalActivity.d(b(), LockPatternStartupFragment.class, null);
            }
        }
    }
}
