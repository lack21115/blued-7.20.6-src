package com.soft.blued.ui.login_register.View;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.module.common.db.UserAccountsVDao;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.das.login.LoginAndRegisterProtos;
import com.blued.login.constant.LoginConstants;
import com.blued.login.face.AVConfig;
import com.blued.login.face.AVConfigExtra;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.log.track.EventTrackLoginAndRegister;
import com.soft.blued.push.PushManager;
import com.soft.blued.ui.home.HomeArgumentHelper;
import com.soft.blued.ui.login_register.AdultVerifyFragment;
import com.soft.blued.ui.login_register.presenter.LoginWithTypePresenter;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.third.model.OneLoginResult;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/View/OneLoginFragment.class */
public class OneLoginFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    public final String f31527a = "drb";
    public Context b;

    /* renamed from: c  reason: collision with root package name */
    public View f31528c;
    public String d;
    private Dialog e;
    private String f;

    /* renamed from: com.soft.blued.ui.login_register.View.OneLoginFragment$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/View/OneLoginFragment$1.class */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OneLoginResult f31529a;
        final /* synthetic */ OneLoginFragment b;

        @Override // java.lang.Runnable
        public void run() {
            LiveEventBus.get(EventBusConstant.KEY_EVENT_HIDE_LOGIN_BACK).post(null);
            UserAccountsVDao.a().i();
            LoginRegisterHttpUtils.a(this.f31529a, this.b.getFragmentActive(), this.b.c());
        }
    }

    private void a() {
    }

    private void b() {
        if (getArguments() != null) {
            this.d = getArguments().getString("aliasUserId");
            Log.v("drb", "aliasUserId:" + this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BluedUIHttpResponse c() {
        return new BluedUIHttpResponse<BluedEntity<BluedLoginResult, AVConfigExtra>>(getFragmentActive()) { // from class: com.soft.blued.ui.login_register.View.OneLoginFragment.2
            /* JADX WARN: Removed duplicated region for block: B:37:0x011e  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x0125 A[RETURN] */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean onUIFailure(int r10, java.lang.String r11, java.lang.String r12) {
                /*
                    Method dump skipped, instructions count: 303
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.login_register.View.OneLoginFragment.AnonymousClass2.onUIFailure(int, java.lang.String, java.lang.String):boolean");
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                DialogUtils.b(OneLoginFragment.this.e);
                OneLoginFragment.this.d();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedLoginResult, AVConfigExtra> bluedEntity) {
                if (bluedEntity != null) {
                    try {
                        if (bluedEntity.hasData()) {
                            boolean z = false;
                            if (bluedEntity.data.get(0) != null) {
                                Logger.b("drb", bluedEntity);
                                if (bluedEntity.extra != null) {
                                    AVConfig.a().a(bluedEntity.extra.f20538a, false);
                                }
                                BluedLoginResult bluedLoginResult = bluedEntity.data.get(0);
                                EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.LOGIN_SUCCESS, LoginAndRegisterProtos.Source.ONE_CLICK, bluedLoginResult.uid);
                                Logger.b("drb", "===success", "加密：responseJson:", bluedEntity);
                                UserInfo.getInstance().saveUserInfo(bluedLoginResult.uid, 2, OneLoginFragment.this.f, bluedLoginResult, OneLoginFragment.this.d);
                                if (!StringUtils.d(OneLoginFragment.this.d)) {
                                    UserAccountsVDao.a().c(OneLoginFragment.this.d);
                                }
                                PushManager.a().d();
                                if (bluedLoginResult != null && bluedLoginResult.getNeedAdultVerify() == 1) {
                                    AdultVerifyFragment.a(OneLoginFragment.this.b);
                                    return;
                                }
                                Bundle bundle = new Bundle();
                                bundle.putString("from_tag_page", "from_tag_login");
                                Log.v("drb", "跳转home openHomeActivityWithTab");
                                OneLoginFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.login_register.View.OneLoginFragment.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                    }
                                });
                                HomeArgumentHelper.a(OneLoginFragment.this.b, (String) null, bundle);
                                LoginConstants.f20505c = "";
                                LoginWithTypePresenter.e();
                                ChatManager.getInstance().initLanguage();
                                if (bluedLoginResult.getDevice_safe() == 1) {
                                    z = true;
                                }
                                BluedPreferences.J(z);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public BluedEntity<BluedLoginResult, AVConfigExtra> parseData(String str) {
                OneLoginFragment.this.f = str;
                BluedEntity<BluedLoginResult, AVConfigExtra> parseData = super.parseData(str);
                if (parseData != null) {
                    try {
                        if (parseData.data != null && parseData.data.size() > 0) {
                            String a2 = AesCrypto2.a(parseData.data.get(0).getEncrypted());
                            Logger.b("drb", "解密：deData===", a2);
                            parseData.data.set(0, (BluedLoginResult) AppInfo.f().fromJson(a2, (Class<Object>) BluedLoginResult.class));
                            return parseData;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return parseData;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        getActivity().finish();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Log.v("drb", "OneLoginFragment onCreateView");
        this.b = getActivity();
        View view = this.f31528c;
        if (view == null) {
            this.f31528c = layoutInflater.inflate(R.layout.fragment_ad_video, viewGroup, false);
            b();
            a();
            EventTrackLoginAndRegister.a(LoginAndRegisterProtos.Event.ONE_CLICK_POP_SHOW);
        } else if (view.getParent() != null) {
            ((ViewGroup) this.f31528c.getParent()).removeView(this.f31528c);
        }
        return this.f31528c;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
