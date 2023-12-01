package com.soft.blued.ui.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import androidx.appcompat.view.WindowCallbackWrapper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseActivity;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.init.InitTaskManager;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.das.authority.SystemAuthorityProtos;
import com.huawei.hms.framework.common.ContainerUtils;
import com.soft.blued.R;
import com.soft.blued.app.BluedApplicationLike;
import com.soft.blued.constant.CommonConstants;
import com.soft.blued.log.track.EventTrackSystemAuthority;
import com.soft.blued.push.PushCommonUtils;
import com.soft.blued.push.PushMsgModel;
import com.soft.blued.ui.home.manager.UrlRouter;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.umeng.analytics.MobclickAgent;
import java.io.Serializable;
import java.util.Iterator;
import skin.support.content.res.SkinCompatResources;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/FirstActivity.class */
public class FirstActivity extends BaseFragmentActivity {

    /* renamed from: c  reason: collision with root package name */
    private boolean f20841c = true;
    private boolean d = true;
    private boolean e = false;

    public static void a(Context context) {
        a(context, true);
    }

    public static void a(Context context, boolean z) {
        BaseActivity.a = null;
        Intent intent = new Intent(context, FirstActivity.class);
        if (z) {
            intent.setFlags(268468224);
        }
        intent.putExtra("extra_bool_open_welcome_page", false);
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x00a7, code lost:
        if (android.content.Intent.ACTION_MAIN.equals(r0) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Intent r5) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.welcome.FirstActivity.a(android.content.Intent):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(Bundle bundle) {
        if (f()) {
            Log.i("FirstActivity", "OPEN_APP_FINISH mayGoToShowPush");
            Log.v("FirstActivity", "FirstActivity doOnCreate finish");
            finish();
        } else if (CommonConstants.f14626c) {
            Log.i("FirstActivity", "OPEN_APP_FINISH CommonConstants.exitApp");
            finish();
            MobclickAgent.onKillProcess(this);
            Process.killProcess(Process.myPid());
            System.exit(0);
        } else {
            a(getIntent());
            if ((getIntent().getFlags() & 4194304) > 0) {
                Log.i("FirstActivity", "OPEN_APP_FINISH  (getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT)> 0");
                UrlRouter.a();
                finish();
                return;
            }
            if (BluedPreferences.aC() == -1) {
                if (StringUtils.d(BluedPreferences.C())) {
                    BluedPreferences.c(0);
                } else {
                    BluedPreferences.c(1);
                }
            }
            c(this);
            if (this.e) {
                overridePendingTransition(R.anim.activity_switch_none, R.anim.activity_switch_none);
            }
        }
    }

    private void b(Intent intent) {
        Object obj;
        if (intent != null) {
            Bundle extras = intent.getExtras();
            String str = "";
            String str2 = str;
            if (extras != null) {
                Iterator<String> it = extras.keySet().iterator();
                while (true) {
                    str2 = str;
                    if (!it.hasNext()) {
                        break;
                    }
                    String next = it.next();
                    if (extras.get(next) != null) {
                        str = str + ContainerUtils.FIELD_DELIMITER + next + "=" + obj.toString();
                    }
                }
            }
            Log.i("FirstActivity", "HW_PUSH_TEST  url=" + str2);
            EventTrackSystemAuthority.a(SystemAuthorityProtos.Event.SPECIAL_WAY_OPEN_APP, str2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarHelper.a(this, true);
    }

    private void c(Context context) {
        Logger.e("FirstActivity", "checkClauseAndPermission: ------> " + BluedPreferences.aC() + " ---->  " + BluedApplicationLike.isEnterLogin + " ---->  " + BluedPreferences.aD());
        if (BluedPreferences.aC() != 1 && !BluedApplicationLike.isEnterLogin && !BluedPreferences.aD()) {
            ClausePermissionFragment.a(context);
            return;
        }
        Logger.e("FirstActivity", "checkGoingTo ------> ");
        b(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean f() {
        Serializable serializableExtra;
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("is_push_key", false) && (serializableExtra = intent.getSerializableExtra("push_msg_model")) != null && (serializableExtra instanceof PushMsgModel)) {
            Log.d("FirstActivity", "PushMsgModel : " + serializableExtra);
            PushCommonUtils.a(this, (PushMsgModel) serializableExtra);
            return true;
        }
        return false;
    }

    public void b(Context context) {
        Logger.c("FirstActivity", "login result is_kids", Integer.valueOf(UserInfo.getInstance().getLoginUserInfo().getNeedAdultVerify()));
        if (UserInfo.getInstance().isLogin() && UserInfo.getInstance().getLoginUserInfo().getNeedAdultVerify() == 1) {
            UserInfo.getInstance().logout(false);
        }
        Log.v("drb", "FirstActivity showWelcomePage:" + this.f20841c + "  isLogin:" + UserInfo.getInstance().isLogin());
        if (this.f20841c) {
            WelcomeFragment.a(context, UserInfo.getInstance().isLogin());
        } else {
            WelcomeFragment.b(context, true);
        }
        if (this.e) {
            overridePendingTransition(R.anim.activity_switch_none, R.anim.activity_switch_none);
        }
        Logger.b("FirstActivity", "OPEN_APP_FINISH checkGoingTo");
        Log.v("FirstActivity", "FirstActivity checkGoingTo finish");
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(final Bundle bundle) {
        BluedApplicationLike.initAppGlobal(getApplication());
        if (InitTaskManager.b()) {
            this.e = false;
            if (getWindow() == null || getWindow().getCallback() == null || !(getWindow().getCallback() instanceof WindowCallbackWrapper)) {
                super.onCreate(bundle);
            } else {
                LogUtils.c("getWindow.getCallback: " + getWindow().getCallback());
                LogUtils.c("getWindow.getCallback: " + getWindow().getCallback().getClass().getName());
                String str = "callback: " + getWindow().getCallback() + ", name:" + getWindow().getCallback().getClass().getName();
                if (AppInfo.m()) {
                    ToastUtils.a(str);
                }
                try {
                    super.onCreate(bundle);
                } catch (Exception e) {
                    LogUtils.a("FirstActivity.onCreate: ", e);
                    finish();
                    return;
                }
            }
            a(bundle);
        } else {
            this.e = true;
            b(bundle);
            InitTaskManager.a().a(getApplication(), new InitTaskManager.OnResultListener() { // from class: com.soft.blued.ui.welcome.FirstActivity.1
                public void a() {
                    com.blued.android.framework.utils.Logger.c("InitTaskManager", new Object[]{"FirstActivity.onFinished = ", Long.valueOf(System.currentTimeMillis())});
                    FirstActivity.this.a(bundle);
                }
            });
        }
        StatusBarHelper.b(this, SkinCompatResources.a().d());
    }
}
