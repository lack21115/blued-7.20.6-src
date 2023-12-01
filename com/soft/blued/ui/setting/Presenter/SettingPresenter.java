package com.soft.blued.ui.setting.Presenter;

import android.content.Context;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.user.model.VerifyStatus;
import com.soft.blued.http.GroupHttpUtils;
import com.soft.blued.ui.setting.Contract.SettingContract;
import com.soft.blued.utils.UserRelationshipUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Presenter/SettingPresenter.class */
public class SettingPresenter implements SettingContract.IPresenter {

    /* renamed from: a  reason: collision with root package name */
    private ActivityFragmentActive f33248a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private SettingContract.IView f33249c;

    public SettingPresenter(SettingContract.IView iView, Context context, ActivityFragmentActive activityFragmentActive) {
        if (iView == null || context == null || activityFragmentActive == null) {
            return;
        }
        this.f33249c = iView;
        this.b = context;
        this.f33248a = activityFragmentActive;
    }

    @Override // com.blued.android.framework.mvp_similarity.BasePresenter
    public void ar_() {
        d();
    }

    @Override // com.soft.blued.ui.setting.Contract.SettingContract.IPresenter
    public void b() {
        if (UserInfo.getInstance().getLoginUserInfo() != null) {
            String avatar = UserInfo.getInstance().getLoginUserInfo().getAvatar();
            String str = UserInfo.getInstance().getLoginUserInfo().getVBadge() + "";
            this.f33249c.a(UserInfo.getInstance().getLoginUserInfo().getVerify(), str, UserInfo.getInstance().getLoginUserInfo().getName(), avatar, UserInfo.getInstance().getLoginUserInfo().getUid());
        }
    }

    @Override // com.soft.blued.ui.setting.Contract.SettingContract.IPresenter
    public void c() {
        UserRelationshipUtils.a("", new int[0]);
    }

    public void d() {
        GroupHttpUtils.k(null, new BluedUIHttpResponse<BluedEntityA<VerifyStatus>>(this.f33248a) { // from class: com.soft.blued.ui.setting.Presenter.SettingPresenter.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<VerifyStatus> bluedEntityA) {
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.hasData()) {
                            UserInfo.getInstance().getLoginUserInfo().setVerify(new VerifyStatus[]{bluedEntityA.data.get(0)});
                            SettingPresenter.this.f33249c.a(UserInfo.getInstance().getLoginUserInfo().getVerify());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        SettingPresenter.this.f33249c.a();
                    }
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
                SettingPresenter.this.f33249c.a();
            }
        }, UserInfo.getInstance().getLoginUserInfo().getUid(), null);
    }
}
