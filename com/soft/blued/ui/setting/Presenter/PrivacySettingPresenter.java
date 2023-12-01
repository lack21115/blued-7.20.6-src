package com.soft.blued.ui.setting.Presenter;

import android.content.Context;
import android.util.Log;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.ToastUtils;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.http.ProfileHttpUtils;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.ui.msg.MsgFragment;
import com.soft.blued.ui.setting.Contract.IPrivacySettingContract;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.utils.BluedPreferences;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Presenter/PrivacySettingPresenter.class */
public class PrivacySettingPresenter implements IPrivacySettingContract.IPresenter {

    /* renamed from: c  reason: collision with root package name */
    private IPrivacySettingContract.IView f33241c;
    private Context d;
    private IRequestHost e;
    private BluedUIHttpResponse r;
    private boolean g = false;
    private boolean h = false;
    private boolean i = false;
    private boolean j = true;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private boolean n = true;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;

    /* renamed from: a  reason: collision with root package name */
    public String f33240a = "";
    public String b = "";
    private Map<String, String> f = BluedHttpTools.a();

    public PrivacySettingPresenter(Context context, IRequestHost iRequestHost, IPrivacySettingContract.IView iView) {
        this.r = new BluedUIHttpResponse<BluedEntityA<BluedBlackList.privacySettingEntity>>("my_privacy_setting", this.e) { // from class: com.soft.blued.ui.setting.Presenter.PrivacySettingPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<BluedBlackList.privacySettingEntity> parseData(String str) {
                return (BluedEntityA) super.parseData(str);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUICache(BluedEntityA<BluedBlackList.privacySettingEntity> bluedEntityA) {
                super.onUICache(bluedEntityA);
                PrivacySettingPresenter.this.a(bluedEntityA);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: b */
            public void onUIUpdate(BluedEntityA<BluedBlackList.privacySettingEntity> bluedEntityA) {
                PrivacySettingPresenter.this.a(bluedEntityA);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
            }
        };
        this.f33241c = iView;
        this.d = context;
        this.e = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BluedEntityA<BluedBlackList.privacySettingEntity> bluedEntityA) {
        if (bluedEntityA != null) {
            try {
                if (bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                boolean z = bluedEntityA.data.get(0).is_access_follows == 1;
                this.g = z;
                this.f33241c.f(z);
                boolean z2 = bluedEntityA.data.get(0).is_access_followers == 1;
                this.i = z2;
                this.f33241c.g(z2);
                boolean z3 = bluedEntityA.data.get(0).is_global_view_secretly == 1;
                this.h = z3;
                this.f33241c.i(z3);
                boolean z4 = bluedEntityA.data.get(0).is_invisible_map == 1;
                this.j = z4;
                this.f33241c.j(z4);
                boolean z5 = bluedEntityA.data.get(0).is_hide_last_operate == 1;
                this.k = z5;
                this.f33241c.k(z5);
                boolean z6 = bluedEntityA.data.get(0).is_hide_distance == 1;
                this.l = z6;
                this.f33241c.l(z6);
                boolean z7 = bluedEntityA.data.get(0).is_traceless_access == 1;
                this.m = z7;
                this.f33241c.m(z7);
                this.n = bluedEntityA.data.get(0).is_invisible_half == 1;
                String str = bluedEntityA.data.get(0).stealth_distance;
                this.f33240a = str;
                this.f33241c.b(this.n, str);
                boolean z8 = bluedEntityA.data.get(0).is_un_disturb == 1;
                this.o = z8;
                this.f33241c.n(z8);
                this.f33241c.o(bluedEntityA.data.get(0).avatar_location_status == 1);
                boolean z9 = bluedEntityA.data.get(0).is_access_groups == 1;
                this.p = z9;
                this.f33241c.h(z9);
                this.q = bluedEntityA.data.get(0).is_open_individuality_recommend == 1;
                BluedPreferences.C(bluedEntityA.data.get(0).is_open_individuality_recommend == 1);
                UserInfo.getInstance().getLoginUserInfo().setBlackCount(String.valueOf(bluedEntityA.data.get(0).black_count));
                UserInfo.getInstance().getLoginUserInfo().setBlackMax(String.valueOf(bluedEntityA.data.get(0).black_allowed_count));
                this.f33241c.a(bluedEntityA.data.get(0).black_count + "", bluedEntityA.data.get(0).black_allowed_count + "");
            } catch (Exception e) {
                e.printStackTrace();
                AppMethods.a((CharSequence) AppInfo.d().getResources().getString(2131887272));
            }
        }
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IPresenter
    public void a(boolean z) {
        e(z);
        ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.setting.Presenter.PrivacySettingPresenter.4
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                if (bluedEntityA != null) {
                    return;
                }
                try {
                    AppMethods.a((CharSequence) AppInfo.d().getResources().getString(2131887272));
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a((CharSequence) AppInfo.d().getResources().getString(2131887272));
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), this.f);
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IPresenter
    public void a(final boolean z, final boolean z2) {
        d(z);
        ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<AppConfigModel.VIPRight>>() { // from class: com.soft.blued.ui.setting.Presenter.PrivacySettingPresenter.3
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<AppConfigModel.VIPRight> bluedEntityA) {
                if (bluedEntityA != null && bluedEntityA.hasData()) {
                    PrivacySettingPresenter privacySettingPresenter = PrivacySettingPresenter.this;
                    boolean z3 = true;
                    if (bluedEntityA.getSingleData().is_global_view_secretly != 1) {
                        z3 = false;
                    }
                    privacySettingPresenter.h = z3;
                    if (PrivacySettingPresenter.this.d instanceof HomeActivity) {
                        BluedPreferences.Y(PrivacySettingPresenter.this.h);
                        ToastUtils.a(PrivacySettingPresenter.this.d.getString(PrivacySettingPresenter.this.h ? 2131890895 : 2131890894));
                    } else {
                        BluedPreferences.Y(false);
                    }
                    if (!PrivacySettingPresenter.this.h) {
                        ChatManager.getInstance().clearAllSecretLook();
                    }
                }
                try {
                    if (z2) {
                        if (bluedEntityA != null) {
                            AppMethods.a((CharSequence) AppInfo.d().getResources().getString(R.string.privacy_setting_done));
                        } else {
                            AppMethods.a((CharSequence) AppInfo.d().getResources().getString(2131887272));
                        }
                    }
                    BluedPreferences.B(z);
                    LiveEventBus.get(EventBusConstant.KEY_EVENT_SYNC_SECRET_LOOK_STATE).post(Boolean.valueOf(z));
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a((CharSequence) AppInfo.d().getResources().getString(2131887272));
                }
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), this.f);
    }

    @Override // com.blued.android.framework.mvp_similarity.BasePresenter
    public void ar_() {
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IPresenter
    public void b() {
        BluedUIHttpResponse bluedUIHttpResponse = this.r;
        if (bluedUIHttpResponse != null) {
            bluedUIHttpResponse.refresh();
        }
    }

    public void b(boolean z) {
        if (this.g != z) {
            this.f.put("is_access_follows", z ? "1" : "0");
        }
    }

    @Override // com.soft.blued.ui.setting.Contract.IPrivacySettingContract.IPresenter
    public void c() {
        ProfileHttpUtils.a(this.d, this.r, UserInfo.getInstance().getLoginUserInfo().getUid(), this.e);
    }

    public void c(boolean z) {
        if (this.i != z) {
            this.f.put("is_access_followers", z ? "1" : "0");
        }
    }

    public void d() {
        try {
            int parseInt = Integer.parseInt(UserInfo.getInstance().getLoginUserInfo().getBlackCount());
            int parseInt2 = Integer.parseInt(UserInfo.getInstance().getLoginUserInfo().getBlackMax());
            this.f33241c.a(parseInt + "", parseInt2 + "");
        } catch (Exception e) {
            this.f33241c.a("0", this.d.getResources().getString(R.string.black_list_max));
        }
    }

    public void d(boolean z) {
        if ((this.f33241c instanceof MsgFragment) || this.h != z) {
            this.f.put("is_global_view_secretly", z ? "1" : "0");
        }
    }

    public void e() {
        final boolean D = this.f33241c.D();
        final boolean E = this.f33241c.E();
        if (E) {
            this.f.put("stealth_distance", BluedPreferences.ab());
        }
        Log.v("drb", "ajaxParams.size():" + this.f.size());
        if (this.f.size() > 0) {
            ProfileHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.setting.Presenter.PrivacySettingPresenter.2
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                    if (bluedEntityA == null) {
                        AppMethods.a((CharSequence) AppInfo.d().getResources().getString(2131887272));
                        return;
                    }
                    AppMethods.a((CharSequence) AppInfo.d().getResources().getString(R.string.privacy_setting_done));
                    if (D) {
                        UserInfo.getInstance().getLoginUserInfo().is_invisible_all = 1;
                    } else {
                        UserInfo.getInstance().getLoginUserInfo().is_invisible_all = 0;
                    }
                    if (E) {
                        UserInfo.getInstance().getLoginUserInfo().is_invisible_half = 1;
                    } else {
                        UserInfo.getInstance().getLoginUserInfo().is_invisible_half = 0;
                    }
                }
            }, UserInfo.getInstance().getLoginUserInfo().getUid(), this.f);
        }
    }

    public void e(boolean z) {
        if (this.j != z) {
            this.f.put("is_invisible_map", z ? "1" : "0");
        }
    }

    public void f(boolean z) {
        if (this.k != z) {
            this.f.put("is_hide_last_operate", z ? "1" : "0");
        }
    }

    public void g(boolean z) {
        if (this.l != z) {
            this.f.put("is_hide_distance", z ? "1" : "0");
        }
    }

    public void h(boolean z) {
        if (this.m != z) {
            this.f.put("is_traceless_access", z ? "1" : "0");
        }
    }

    public void i(boolean z) {
        if (this.p != z) {
            this.f.put("is_access_groups", z ? "1" : "0");
        }
    }

    public void j(boolean z) {
        if (this.n == z && this.b.equals(this.f33240a)) {
            return;
        }
        this.f.put("is_invisible_half", z ? "1" : "0");
        this.f.put("stealth_distance", this.b);
    }

    public void k(boolean z) {
        if (this.q != z) {
            String str = BluedPreferences.aA() ? "1" : "0";
            this.f.put("is_open_individuality_recommend", str);
            Log.v("drb", "setOpenIndividualityRecommend:" + str);
        }
    }

    public void l(boolean z) {
        if (this.o != z) {
            this.f.put("is_un_disturb", z ? "1" : "0");
        }
    }
}
