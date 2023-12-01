package com.soft.blued.ui.login_register.presenter;

import android.content.Context;
import android.os.Bundle;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.login_register.Contract.StartLoginVerifyContract;
import com.soft.blued.ui.login_register.View.VerifyCodeFragment;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/presenter/StartLoginVerifyPresenter.class */
public class StartLoginVerifyPresenter implements StartLoginVerifyContract.IPresenter {

    /* renamed from: a  reason: collision with root package name */
    private StartLoginVerifyContract.IView f17882a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f17883c;

    /* renamed from: com.soft.blued.ui.login_register.presenter.StartLoginVerifyPresenter$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/presenter/StartLoginVerifyPresenter$2.class */
    class AnonymousClass2 extends BluedUIHttpResponse<BluedEntityA<Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Bundle f17885a;
        final /* synthetic */ StartLoginVerifyPresenter b;

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
            VerifyCodeFragment.a(this.b.b, this.f17885a);
        }
    }

    public StartLoginVerifyPresenter(Context context, StartLoginVerifyContract.IView iView, IRequestHost iRequestHost) {
        this.f17882a = iView;
        this.b = context;
        this.f17883c = iRequestHost;
    }

    @Override // com.soft.blued.ui.login_register.Contract.StartLoginVerifyContract.IPresenter
    public void a(final Bundle bundle) {
        String str;
        String str2;
        if (bundle != null) {
            str = bundle.getString("token");
            str2 = bundle.getString("safe_device_type");
        } else {
            str = "";
            str2 = str;
        }
        LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>(this.f17883c) { // from class: com.soft.blued.ui.login_register.presenter.StartLoginVerifyPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                VerifyCodeFragment.a(StartLoginVerifyPresenter.this.b, bundle);
            }
        }, str, "send", "", str2, this.f17883c);
    }

    public void ar_() {
    }
}
