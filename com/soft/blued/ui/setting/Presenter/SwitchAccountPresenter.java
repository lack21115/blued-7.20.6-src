package com.soft.blued.ui.setting.Presenter;

import android.content.DialogInterface;
import android.os.Bundle;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityStack;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.module.common.db.UserAccountsVDao;
import com.blued.android.module.common.db.model.UserAccountsModel;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.settings.SettingsProtos;
import com.blued.login.face.AVConfig;
import com.blued.login.face.AVConfigExtra;
import com.bytedance.applog.tracker.Tracker;
import com.j256.ormlite.dao.Dao;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.push.PushManager;
import com.soft.blued.ui.login_register.AdultVerifyFragment;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.login_register.SignInActivity;
import com.soft.blued.ui.welcome.FirstActivity;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.utils.third.YouMengUtils;
import com.tencent.bugly.crashreport.CrashReport;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Presenter/SwitchAccountPresenter.class */
public class SwitchAccountPresenter extends MvpPresenter {
    public static final String h = SwitchAccountPresenter.class.getSimpleName();
    private CopyOnWriteArrayList<UserAccountsModel> i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.soft.blued.ui.setting.Presenter.SwitchAccountPresenter$4  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Presenter/SwitchAccountPresenter$4.class */
    public class AnonymousClass4 extends BluedUIHttpResponse<BluedEntity<BluedLoginResult, AVConfigExtra>> {

        /* renamed from: a  reason: collision with root package name */
        String f33254a;
        final /* synthetic */ UserAccountsModel b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f33255c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(IRequestHost iRequestHost, UserAccountsModel userAccountsModel, int i) {
            super(iRequestHost);
            this.b = userAccountsModel;
            this.f33255c = i;
            this.f33254a = "";
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(final int i, String str, String str2) {
            ThreadManager.a().a(new ThreadExecutor("") { // from class: com.soft.blued.ui.setting.Presenter.SwitchAccountPresenter.4.1
                @Override // com.blued.android.framework.pool.ThreadExecutor
                public void execute() {
                    if (AnonymousClass4.this.b != null) {
                        SwitchAccountPresenter.this.c(AnonymousClass4.this.b);
                    }
                    if (i == 401) {
                        return;
                    }
                    AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.setting.Presenter.SwitchAccountPresenter.4.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwitchAccountPresenter.this.d(AnonymousClass4.this.b);
                        }
                    });
                }
            });
            return super.onUIFailure(i, str, str2);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<BluedLoginResult, AVConfigExtra> bluedEntity) {
            if (bluedEntity == null || bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                return;
            }
            if (bluedEntity.extra != null) {
                AVConfig.a().a(bluedEntity.extra.f20538a, false);
            }
            try {
                BluedLoginResult bluedLoginResult = (BluedLoginResult) AppInfo.f().fromJson(AesCrypto2.a(bluedEntity.data.get(0).getEncrypted()), (Class<Object>) BluedLoginResult.class);
                YouMengUtils.a(bluedLoginResult.uid);
                CrashReport.setUserId(bluedLoginResult.uid);
                SwitchAccountPresenter.this.a(this.b.getUsername(), this.f33255c, this.f33254a, bluedLoginResult);
            } catch (Exception e) {
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public BluedEntity<BluedLoginResult, AVConfigExtra> parseData(String str) {
            this.f33254a = str;
            return super.parseData(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, String str2, BluedLoginResult bluedLoginResult) {
        UserInfo.getInstance().saveUserInfo(str, i, str2, bluedLoginResult, new String[0]);
        if (bluedLoginResult != null && bluedLoginResult.getNeedAdultVerify() == 1) {
            UserRelationshipUtils.a();
            AdultVerifyFragment.a(h());
            return;
        }
        ActivityStack.a().c();
        if (h() != null) {
            PushManager.a().d();
            FirstActivity.a(h());
        }
    }

    private void b(UserAccountsModel userAccountsModel) {
        int loginType = userAccountsModel.getLoginType();
        LoginRegisterHttpUtils.a(new AnonymousClass4(g(), userAccountsModel, loginType), loginType != 0 ? loginType != 1 ? loginType != 2 ? null : UserAccountsModel.ACCOUNT_THREE_WEIXIN : "mobile" : "email", LoginRegisterTools.f(userAccountsModel.getAccessToken()), userAccountsModel.getUid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(UserAccountsModel userAccountsModel) {
        if (userAccountsModel != null) {
            userAccountsModel.setAccessToken("");
            userAccountsModel.setLastHandleTime(System.currentTimeMillis());
            try {
                UserAccountsVDao.a().b().update((Dao<UserAccountsModel, Integer>) userAccountsModel);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(UserAccountsModel userAccountsModel) {
        if (g().isActive()) {
            CommonAlertDialog.a(h(), 0, "", h().getResources().getString(R.string.switch_login_failed), null, AppUtils.a(2131886752), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.Presenter.SwitchAccountPresenter.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    dialogInterface.dismiss();
                    FirstActivity.a(AppInfo.d());
                }
            }, null, null, null, false, 1, 0, false, false);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(final IFetchDataListener iFetchDataListener) {
        ThreadManager.a().a(new ThreadExecutor("FetchAccount") { // from class: com.soft.blued.ui.setting.Presenter.SwitchAccountPresenter.1
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                SwitchAccountPresenter.this.i = UserAccountsVDao.a().h();
                iFetchDataListener.a("data_account", SwitchAccountPresenter.this.i);
                iFetchDataListener.a(true);
            }
        });
    }

    public void a(UserAccountsModel userAccountsModel) {
        if (!StringUtils.d(userAccountsModel.getAccessToken())) {
            b(userAccountsModel);
            return;
        }
        UserInfo.getInstance().logout(true);
        c(userAccountsModel);
        FirstActivity.a(AppInfo.d());
    }

    public void a(final boolean z) {
        UserRelationshipUtils.a(new Runnable() { // from class: com.soft.blued.ui.setting.Presenter.SwitchAccountPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                LiveEventBus.get(EventBusConstant.KEY_EVENT_HIDE_LOGIN_BACK).post(null);
                if (z) {
                    SwitchAccountPresenter.this.p();
                }
                if (SwitchAccountPresenter.this.i == null || SwitchAccountPresenter.this.i.size() < 2) {
                    return;
                }
                UserAccountsModel userAccountsModel = (UserAccountsModel) SwitchAccountPresenter.this.i.get(1);
                if (!z) {
                    EventTrackSettings.b(SettingsProtos.Event.CHANGE_ACCOUNT_CLICK, userAccountsModel.getUid());
                }
                SwitchAccountPresenter.this.a(userAccountsModel);
            }
        }, "switch_Acc");
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void m() {
        CopyOnWriteArrayList<UserAccountsModel> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() < 1) {
            return;
        }
        b(this.i.get(0));
    }

    public void n() {
        CopyOnWriteArrayList<UserAccountsModel> copyOnWriteArrayList;
        if (h() == null || (copyOnWriteArrayList = this.i) == null || copyOnWriteArrayList.size() <= 0) {
            return;
        }
        UserAccountsModel userAccountsModel = this.i.get(0);
        Bundle bundle = new Bundle();
        bundle.putString("aliasUserId", userAccountsModel.getUid());
        SignInActivity.a(h(), bundle);
    }

    public void o() {
        CopyOnWriteArrayList<UserAccountsModel> copyOnWriteArrayList = this.i;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() < 2) {
            return;
        }
        this.i.remove(1);
        a("data_account", (String) this.i);
    }

    public void p() {
        if (this.i == null) {
            return;
        }
        ThreadManager.a().a(new ThreadExecutor("deleteAliasUserId") { // from class: com.soft.blued.ui.setting.Presenter.SwitchAccountPresenter.3
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                Iterator it = SwitchAccountPresenter.this.i.iterator();
                while (it.hasNext()) {
                    UserAccountsModel userAccountsModel = (UserAccountsModel) it.next();
                    userAccountsModel.setAliasUserId("");
                    try {
                        UserAccountsVDao.a().b().update((Dao<UserAccountsModel, Integer>) userAccountsModel);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
