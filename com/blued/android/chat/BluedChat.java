package com.blued.android.chat;

import android.content.Context;
import com.blued.android.config.FlexDebugSevConfig;
import com.blued.android.framework.http.HappyDnsUtils;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.widget.emoticon.manager.EmotionManager;
import com.blued.android.module.live_china.msg.LiveMsgSendManager;
import com.blued.android.statistics.BluedStatistics;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.service.AutoStartService;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.msg.controller.tools.IMManager;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.ServiceUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.tencent.bugly.crashreport.CrashReport;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/chat/BluedChat.class */
public class BluedChat {
    private static final String TAG = "BluedChat";
    private static BluedChat instance;
    private final AtomicBoolean started = new AtomicBoolean(false);
    private final IMTipsListener imTipsListener = new IMTipsListener();

    private BluedChat() {
    }

    public static BluedChat getInstance() {
        if (instance == null) {
            synchronized (BluedChat.class) {
                try {
                    if (instance == null) {
                        instance = new BluedChat();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return instance;
    }

    public void pauseIMService() {
        ChatManager.getInstance().pause();
        IMManager.a().g();
    }

    public void resumeIMService() {
        ChatManager.getInstance().resume();
        IMManager.a().f();
    }

    public void startIMService(Context context) {
        startIMService(context, true);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00e1 -> B:25:0x006c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00e5 -> B:29:0x00be). Please submit an issue!!! */
    public void startIMService(Context context, boolean z) {
        synchronized (this) {
            if (BluedApplicationLike.isMainApplication(context)) {
                if (!this.started.get() && UserInfo.getInstance().isLogin()) {
                    if (ServiceUtils.a()) {
                        AutoStartService.startService(context);
                    }
                    CrashReport.setUserId(UserInfo.getInstance().getLoginUserInfo().getUid());
                    BluedStatistics.a().f(UserInfo.getInstance().getLoginUserInfo().getUid());
                    FlexDebugSevConfig.a().c();
                    if (z) {
                        Logger.c("loginInBackground", new Object[0]);
                        UserRelationshipUtils.b();
                    }
                    EmotionManager.c(BluedHttpUrl.q());
                    try {
                        IMManager.a().d();
                    } catch (Exception e) {
                    }
                    ChatManager.getInstance().setServerInfo(BluedHttpUrl.t(), BluedHttpUrl.u(), BluedHttpUrl.v(), HappyDnsUtils.d(), HappyDnsUtils.a(), BluedHttpUrl.h());
                    ChatManager.getInstance().start(CommonTools.e(UserInfo.getInstance().getLoginUserInfo().getUid()), EncryptTool.b(UserInfo.getInstance().getLoginUserInfo().getUid()), UserInfo.getInstance().getAccessToken());
                    ChatManager.getInstance().registerTipsListener(this.imTipsListener);
                    try {
                        LiveMsgSendManager.a().b();
                        LiveMsgSendManager.a().c();
                    } catch (Exception e2) {
                    }
                    if (BluedPreferences.cL()) {
                        LoginRegisterTools.e();
                        BluedPreferences.P(false);
                    }
                    GroupUtil.a();
                    this.started.set(true);
                }
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0052 -> B:31:0x003c). Please submit an issue!!! */
    public void stopIMService(Context context) {
        synchronized (this) {
            Logger.a(TAG, "stopIMService()");
            if (BluedApplicationLike.isMainApplication(context)) {
                if (ServiceUtils.a()) {
                    AutoStartService.stopService(context);
                }
                ChatManager.getInstance().unregisterTipsListener(this.imTipsListener);
                ChatManager.getInstance().stop();
                try {
                    IMManager.a().e();
                } catch (Exception e) {
                }
                try {
                    LiveMsgSendManager.a().d();
                } catch (Exception e2) {
                }
                this.started.set(false);
            }
        }
    }
}
