package com.soft.blued.ui.home;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.anythink.expressad.video.dynview.a.a;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.blued.android.chat.BluedChat;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableSessionListListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.chat.model.VideoChatMsgContentModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.chat.ModuleChatConfig;
import com.blued.android.module.chat.manager.MsgFilterManager;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.statistics.BluedStatistics;
import com.blued.community.ui.send.manager.FeedSendManager;
import com.blued.community.ui.send.observer.FeedRefreshObserver;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.AppHttpUtils;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.MsgGroupHttpUtils;
import com.soft.blued.ui.discover.observer.SystemNoticeViewModel;
import com.soft.blued.ui.find.manager.FilterNewHelper;
import com.soft.blued.ui.home.HomeContract;
import com.soft.blued.ui.home.HomePresenter;
import com.soft.blued.ui.home.manager.UrlRouter;
import com.soft.blued.ui.home.model.HomeViewModel;
import com.soft.blued.ui.home.model.MessageTabBubbleModel;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.SignInActivity;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.ui.msg.manager.MsgBoxManager;
import com.soft.blued.ui.msg.model.MsgBoxSettingResponse;
import com.soft.blued.ui.msg.model.RefreshSessionEvent;
import com.soft.blued.ui.user.manager.VipBubbleManager;
import com.soft.blued.ui.user.utils.CommandManager;
import com.soft.blued.ui.user.utils.VirtualImageUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/HomePresenter.class */
public class HomePresenter implements FeedRefreshObserver.IFeedRefreshObserver, HomeContract.Presenter {

    /* renamed from: a  reason: collision with root package name */
    public static final String f17325a = HomePresenter.class.getSimpleName();
    private static ExecutorService k = Executors.newSingleThreadExecutor();
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f17326c;
    private HomeContract.View d;
    private HomePageSessionListener g;
    private IRequestHost h;
    private List<SessionModel> l;
    private boolean e = false;
    private long f = 0;
    private int i = 0;
    private boolean j = false;
    private boolean m = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.home.HomePresenter$10  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/HomePresenter$10.class */
    public class AnonymousClass10 extends BluedUIHttpResponse<BluedEntityA<MessageTabBubbleModel>> {
        AnonymousClass10(IRequestHost iRequestHost) {
            super(iRequestHost);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i, MessageTabBubbleModel messageTabBubbleModel) {
            if (System.currentTimeMillis() - BluedPreferences.az(UserInfo.getInstance().getLoginUserInfo().uid) >= i) {
                HomePresenter.this.d.g(messageTabBubbleModel.label);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<MessageTabBubbleModel> bluedEntityA) {
            if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() == 0) {
                return;
            }
            final MessageTabBubbleModel messageTabBubbleModel = (MessageTabBubbleModel) bluedEntityA.data.get(0);
            if (messageTabBubbleModel.open == 0 || TextUtils.isEmpty(messageTabBubbleModel.label) || messageTabBubbleModel.rate_day == 0) {
                return;
            }
            final int i = messageTabBubbleModel.rate_day * 24 * 60 * 60 * 1000;
            AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.home.-$$Lambda$HomePresenter$10$qJKCn8xxGn3GIGM0gJHJui2hU8M
                @Override // java.lang.Runnable
                public final void run() {
                    HomePresenter.AnonymousClass10.this.a(i, messageTabBubbleModel);
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/HomePresenter$CountNewSessionThread.class */
    public class CountNewSessionThread implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f17338a = 0;
        int b = 0;

        /* renamed from: c  reason: collision with root package name */
        boolean f17339c = false;
        List<SessionModel> d;

        public CountNewSessionThread(List<SessionModel> list) {
            this.d = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.c(HomePresenter.f17325a, "计算未读数");
            ChatHelperV4.a(this.d, false);
            if (this.d != null) {
                for (int i = 0; i < this.d.size(); i++) {
                    SessionModel sessionModel = this.d.get(i);
                    if (!MsgBoxManager.a().c() || !MsgBoxManager.a().a(sessionModel)) {
                        SessionSettingModel sessionSettingModel = sessionModel.sessionSettingModel;
                        if (sessionSettingModel == null || sessionSettingModel.getRemindAudio() == 0) {
                            if (BluedConstant.f14549a) {
                                if (sessionModel.sessionType != 3) {
                                    if (sessionModel.sessionType != 1) {
                                        this.f17338a += sessionModel.noReadMsgCount;
                                    } else if (sessionModel.sessionId != 2) {
                                        this.f17338a += sessionModel.noReadMsgCount;
                                    }
                                }
                            } else if (sessionModel.sessionType != 2 || sessionModel.sessionId >= 0 || sessionModel.lastMsgType != 281) {
                                this.f17338a += sessionModel.noReadMsgCount;
                            }
                            if (sessionModel.noReadRedDot == 1 && this.f17338a == 0) {
                                this.f17339c = true;
                            }
                        }
                        if (sessionModel.lastMsgType == 52 && sessionModel.noReadMsgCount > 0 && sessionModel.lastMsgContent != null) {
                            VideoChatMsgContentModel videoChatMsgContentModel = (VideoChatMsgContentModel) AppInfo.f().fromJson(sessionModel.lastMsgContent, (Class<Object>) VideoChatMsgContentModel.class);
                            if (videoChatMsgContentModel != null && videoChatMsgContentModel.room_type == 2) {
                                this.b = 2;
                            } else if (videoChatMsgContentModel != null && videoChatMsgContentModel.room_type == 1) {
                                this.b = 1;
                            }
                        }
                    }
                }
                this.d.clear();
            }
            this.d = null;
            AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.home.HomePresenter.CountNewSessionThread.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CountNewSessionThread.this.b == 2) {
                        HomePresenter.this.d.b("msg", R.drawable.calling_msg_video_tab);
                    } else if (CountNewSessionThread.this.b == 1) {
                        HomePresenter.this.d.b("msg", R.drawable.calling_msg_audio_tab);
                    } else {
                        HomePresenter.this.d.f("msg");
                    }
                    CountNewSessionThread.this.f17338a += DateTodayManager.f18714a.j();
                    if ((CountNewSessionThread.this.f17338a > 0 || HomePresenter.this.i > 0) && CountNewSessionThread.this.b == 0) {
                        HomePresenter.this.d.a("msg", CountNewSessionThread.this.f17338a + HomePresenter.this.i);
                        if (HomePresenter.this.b != null) {
                            ((HomeViewModel) ViewModelProviders.of((FragmentActivity) ((HomeActivity) HomePresenter.this.b)).get(HomeViewModel.class)).f17357a.postValue(Integer.valueOf(CountNewSessionThread.this.f17338a));
                        }
                    } else {
                        HomePresenter.this.d.c("msg");
                    }
                    if (HomePresenter.this.d.b("msg") || !CountNewSessionThread.this.f17339c) {
                        HomePresenter.this.d.e("msg");
                    } else {
                        HomePresenter.this.d.d("msg");
                    }
                    if (HomePresenter.this.b != null) {
                        SystemNoticeViewModel systemNoticeViewModel = (SystemNoticeViewModel) ViewModelProviders.of((FragmentActivity) ((HomeActivity) HomePresenter.this.b)).get(SystemNoticeViewModel.class);
                        systemNoticeViewModel.f16156a = CountNewSessionThread.this.f17338a;
                        systemNoticeViewModel.e.postValue(Integer.valueOf(CountNewSessionThread.this.f17338a));
                        systemNoticeViewModel.d.postValue(Integer.valueOf(systemNoticeViewModel.f16156a + systemNoticeViewModel.b.getSum() + systemNoticeViewModel.f16157c));
                    }
                    HomePresenter.this.i = 0;
                    HomePresenter.this.m = false;
                    HomePresenter.this.k();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/HomePresenter$HomePageSessionListener.class */
    public class HomePageSessionListener extends StableSessionListListener {
        private HomePageSessionListener() {
        }

        public void onUISessionDataChanged(List<SessionModel> list) {
            String str = HomePresenter.f17325a;
            Logger.c(str, "onUISessionDataChanged=====" + list.size());
            HomePresenter.this.l = list;
            HomePresenter.this.k();
        }
    }

    public HomePresenter(Context context, String str, HomeContract.View view, IRequestHost iRequestHost) {
        this.b = context;
        this.f17326c = str;
        this.d = view;
        this.h = iRequestHost;
    }

    private void a(final Context context, String str, String str2, String str3) {
        String a2;
        if (StringUtils.d(BluedApplicationLike.previousLanguage)) {
            a2 = H5Url.a(32);
        } else {
            a2 = H5Url.a(32, new Object[]{"?lan=" + BluedApplicationLike.previousLanguage});
        }
        final String str4 = a2;
        CommonAlertDialog.a(context, (View) null, "", str, str2, str3, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.home.HomePresenter.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                WebViewShowInfoFragment.show(context, str4, 7);
                BluedPreferences.aH();
            }
        }, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.home.HomePresenter.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Tracker.onClick(dialogInterface, i);
                BluedPreferences.aH();
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.soft.blued.ui.home.HomePresenter.8
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                BluedPreferences.aH();
            }
        }, true);
    }

    private void a(List<SessionModel> list) {
        boolean z;
        boolean z2;
        boolean z3;
        final SystemNoticeViewModel systemNoticeViewModel = (SystemNoticeViewModel) ViewModelProviders.of((FragmentActivity) ((HomeActivity) this.b)).get(SystemNoticeViewModel.class);
        boolean z4 = false;
        if (list == null || list.size() <= 0) {
            z = false;
            z2 = false;
            z3 = false;
        } else {
            z4 = false;
            z = false;
            z2 = false;
            z3 = false;
            for (SessionModel sessionModel : list) {
                if (sessionModel.sessionType == 1 && (sessionModel.sessionId == 3 || sessionModel.sessionId == 11 || sessionModel.sessionId == 22)) {
                    Logger.e(f17325a, "找到动态session===" + sessionModel.noReadMsgCount + "===" + sessionModel.sessionId);
                    if (sessionModel.noReadMsgCount > 0) {
                        this.i += sessionModel.noReadMsgCount;
                        if (systemNoticeViewModel.f16157c != sessionModel.noReadMsgCount) {
                            systemNoticeViewModel.f16157c = sessionModel.noReadMsgCount;
                            systemNoticeViewModel.g.postValue(Integer.valueOf(systemNoticeViewModel.f16157c));
                        }
                        this.d.e(IAdInterListener.AdProdType.PRODUCT_FEEDS);
                        z4 = true;
                    }
                } else if (sessionModel.sessionType == 1 && (sessionModel.sessionId == 6 || sessionModel.sessionId == 7)) {
                    if (sessionModel.noReadMsgCount > 0) {
                        this.d.d("live");
                        z = true;
                    }
                } else if (sessionModel.sessionType == 1 && sessionModel.sessionId == 12) {
                    if (sessionModel.noReadMsgCount > 0) {
                        this.d.d("mine");
                    }
                } else if (sessionModel.sessionType == 1 && sessionModel.sessionId == 13) {
                    if (sessionModel.noReadMsgCount > 0) {
                        if (!this.d.b(IAdInterListener.AdProdType.PRODUCT_FEEDS)) {
                            this.d.d(IAdInterListener.AdProdType.PRODUCT_FEEDS);
                        }
                        z2 = true;
                    }
                } else if (sessionModel.sessionType == 1 && sessionModel.sessionId == 14) {
                    if (sessionModel.noReadMsgCount > 0) {
                        if (!this.d.b(IAdInterListener.AdProdType.PRODUCT_FEEDS)) {
                            this.d.d(IAdInterListener.AdProdType.PRODUCT_FEEDS);
                        }
                        z3 = true;
                    }
                } else if (sessionModel.sessionType == 1 && sessionModel.sessionId == 5) {
                    if (sessionModel.noReadMsgCount > 0) {
                        this.i += sessionModel.noReadMsgCount;
                        systemNoticeViewModel.b.followers = sessionModel.noReadMsgCount;
                        z3 = true;
                    }
                } else if (sessionModel.sessionType == 1 && sessionModel.sessionId == 21) {
                    if (sessionModel.noReadMsgCount > 0) {
                        this.i += sessionModel.noReadMsgCount;
                        systemNoticeViewModel.b.liked = sessionModel.noReadMsgCount;
                        z3 = true;
                    }
                } else if (sessionModel.sessionType == 1 && sessionModel.sessionId == 2) {
                    if (sessionModel.noReadMsgCount > 0) {
                        this.i += sessionModel.noReadMsgCount;
                        systemNoticeViewModel.b.groups = sessionModel.noReadMsgCount;
                        z3 = true;
                    }
                } else if (sessionModel.sessionType == 1 && sessionModel.sessionId == 24 && sessionModel.noReadMsgCount > 0) {
                    this.i += sessionModel.noReadMsgCount;
                    systemNoticeViewModel.b.circle = sessionModel.noReadMsgCount;
                    z3 = true;
                }
            }
            Logger.c(f17325a, "attention_like_vote_count = " + this.i);
            AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.home.HomePresenter.9
                @Override // java.lang.Runnable
                public void run() {
                    if (HomePresenter.this.b != null) {
                        systemNoticeViewModel.h.postValue(systemNoticeViewModel.b);
                        systemNoticeViewModel.f.postValue(Integer.valueOf(systemNoticeViewModel.b.getSum() + systemNoticeViewModel.f16157c));
                        systemNoticeViewModel.d.postValue(Integer.valueOf(systemNoticeViewModel.f16156a + systemNoticeViewModel.b.getSum() + systemNoticeViewModel.f16157c));
                    }
                }
            });
        }
        if (!z4 && !this.j) {
            this.d.c(IAdInterListener.AdProdType.PRODUCT_FEEDS);
        }
        if (!z) {
            this.d.e("live");
            if (BluedPreferences.aO()) {
                this.d.d("live");
            } else {
                this.d.e("live");
            }
        }
        if (z2 || z3) {
            return;
        }
        this.d.e(IAdInterListener.AdProdType.PRODUCT_FEEDS);
    }

    private void g() {
        ChatHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<MsgBoxSettingResponse>>(this.h) { // from class: com.soft.blued.ui.home.HomePresenter.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MsgBoxSettingResponse> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() == 0) {
                    return;
                }
                boolean z = false;
                BluedPreferences.T(((MsgBoxSettingResponse) bluedEntityA.data.get(0)).source);
                if (StringUtils.d(((MsgBoxSettingResponse) bluedEntityA.data.get(0)).distance)) {
                    BluedPreferences.U("0-0");
                } else {
                    BluedPreferences.U(((MsgBoxSettingResponse) bluedEntityA.data.get(0)).distance);
                }
                if (((MsgBoxSettingResponse) bluedEntityA.data.get(0)).is_open == 1) {
                    z = true;
                }
                BluedPreferences.V(z);
            }
        }, this.h);
    }

    private void h() {
        i();
        ModuleChatConfig.getInstance().setHttpImpl(new ChatHttpUtils());
        FeedRefreshObserver.a().a(this);
        FeedSendManager.a().b();
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.home.HomePresenter.3
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(LoginRegisterTools.d()) && TextUtils.isEmpty(LoginRegisterTools.b())) {
                    LoginRegisterTools.a(HomePresenter.this.b, 2, 0);
                } else if (TextUtils.isEmpty(LoginRegisterTools.d())) {
                    LoginRegisterTools.a(HomePresenter.this.b, 1, 1);
                } else if (TextUtils.isEmpty(LoginRegisterTools.b())) {
                    LoginRegisterTools.a(HomePresenter.this.b, 1, 0);
                }
            }
        }, 2000L);
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.home.HomePresenter.4
            @Override // java.lang.Runnable
            public void run() {
                HomePresenter.this.j();
            }
        }, 2100L);
        this.g = new HomePageSessionListener();
        LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_UNREAD_MSG_CNT, RefreshSessionEvent.class).observe((LifecycleOwner) this.d, new Observer<RefreshSessionEvent>() { // from class: com.soft.blued.ui.home.HomePresenter.5
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(RefreshSessionEvent refreshSessionEvent) {
                if (refreshSessionEvent.list.size() == 0) {
                    return;
                }
                String str = HomePresenter.f17325a;
                Logger.e(str, "KEY_EVENT_REFRESH_UNREAD_MSG_CNT==" + refreshSessionEvent.list.size());
                HomePresenter.this.l = refreshSessionEvent.list;
                HomePresenter.this.k();
            }
        });
        String str = f17325a;
        Log.w(str, "abtest reqeust value = " + BluedStatistics.g().a("mql-blued国内-客户端实验测试-2_name", ""));
    }

    private void i() {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(this.f17326c) || !(this.f17326c.equals("from_tag_register") || this.f17326c.equals("from_tag_login"))) {
            z = false;
        } else {
            if (BluedPreferences.aC() == 1 || BluedPreferences.aD()) {
                CommandManager.a().a(this.b);
            }
            z = true;
        }
        if (!UserInfo.getInstance().isLogin()) {
            SignInActivity.a(this.b, new Bundle[0]);
            return;
        }
        try {
            BluedChat bluedChat = BluedChat.getInstance();
            Context context = this.b;
            if (z) {
                z2 = false;
            }
            bluedChat.startIMService(context, z2);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        String[] stringArray = this.b.getResources().getStringArray(R.array.content_remind_international);
        String[] stringArray2 = this.b.getResources().getStringArray(R.array.download_international);
        String[] stringArray3 = this.b.getResources().getStringArray(R.array.cancel);
        if (!BluedPreferences.aG() || BluedApplicationLike.previousLanguage == null) {
            return;
        }
        String str = BluedApplicationLike.previousLanguage;
        boolean z = true;
        int hashCode = str.hashCode();
        if (hashCode != 3383) {
            if (hashCode != 3428) {
                if (hashCode == 3700 && str.equals("th")) {
                    z = true;
                }
            } else if (str.equals(a.Y)) {
                z = true;
            }
        } else if (str.equals(a.W)) {
            z = false;
        }
        if (!z) {
            a(this.b, stringArray[1], stringArray3[1], stringArray2[1]);
        } else if (z) {
            a(this.b, stringArray[2], stringArray3[2], stringArray2[2]);
        } else if (z) {
            a(this.b, stringArray[3], stringArray3[3], stringArray2[3]);
        } else if (a.V.equals(BluedApplicationLike.previousLanguage) || "en".equals(BluedApplicationLike.previousLanguage)) {
        } else {
            a(this.b, stringArray[0], stringArray3[0], stringArray2[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (this.l == null || this.m) {
            return;
        }
        this.m = true;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.l);
        a(arrayList);
        k.execute(new CountNewSessionThread(arrayList));
        this.l.clear();
        this.l = null;
    }

    private void l() {
        MsgGroupHttpUtils.a(new AnonymousClass10(this.h), this.h);
    }

    public void a(Object obj, int i) {
        if (i == 3) {
            FeedSendManager.a().g();
        } else if (i == 4) {
            FeedSendManager.a().g();
        } else if (i != 5) {
        } else {
            this.d.f(IAdInterListener.AdProdType.PRODUCT_FEEDS);
        }
    }

    @Override // com.soft.blued.ui.home.HomeContract.Presenter
    public void a(boolean z) {
        this.j = z;
    }

    @Override // com.soft.blued.ui.home.HomeContract.Presenter
    public void ar_() {
        if (!this.e) {
            h();
            this.e = true;
        }
        ChatManager.getInstance().registerSessionListener(this.g);
    }

    @Override // com.soft.blued.ui.home.HomeContract.Presenter
    public void b() {
        ChatManager.getInstance().unregisterSessionListener(this.g);
        MsgFilterManager.getInstance().unRegisterSessionListener();
    }

    @Override // com.soft.blued.ui.home.HomeContract.Presenter
    public void c() {
        FeedRefreshObserver.a().b(this);
    }

    @Override // com.soft.blued.ui.home.HomeContract.Presenter
    public void d() {
        UrlRouter.a();
    }

    @Override // com.soft.blued.ui.home.HomeContract.Presenter
    public void e() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f > 2000) {
            ToastUtils.b((int) R.string.biao_quit_notice);
            this.f = currentTimeMillis;
            return;
        }
        System.currentTimeMillis();
        AppUtils.a(AppInfo.d());
        BluedPreferences.b(0L);
    }

    @Override // com.soft.blued.ui.home.HomeContract.Presenter
    public void f() {
        g();
        VipBubbleManager.a().a((VipBubbleManager.RefreshListener) null, (IRequestHost) null);
        if (!TimeAndDateUtils.f(BluedPreferences.fe())) {
            AppHttpUtils.d(new BluedUIHttpResponse(this.h) { // from class: com.soft.blued.ui.home.HomePresenter.1
                public void onUIUpdate(BluedEntity bluedEntity) {
                    BluedPreferences.C(System.currentTimeMillis());
                }
            });
        }
        VirtualImageUtils.Companion.a();
        FilterNewHelper.f16903a.k();
        l();
    }
}
