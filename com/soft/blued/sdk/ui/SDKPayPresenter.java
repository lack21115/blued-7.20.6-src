package com.soft.blued.sdk.ui;

import android.content.Context;
import android.text.TextUtils;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.user.model.UserInfo;
import com.soft.blued.R;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.sdk.SDKActionManager;
import com.soft.blued.sdk.SDKBaseAction;
import com.soft.blued.sdk.SDKPayAction;
import com.soft.blued.sdk.model.SDKPayBalanceModel;
import com.soft.blued.sdk.model.SDKPayConsumeModel;
import com.soft.blued.sdk.model.SDKPayOrderModel;
import com.soft.blued.sdk.ui.SDKPayContract;
import com.soft.blued.ui.pay.BeansPrePayFragment;
import com.soft.blued.ui.setting.fragment.PayPasswordSettingFragment;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/sdk/ui/SDKPayPresenter.class */
public class SDKPayPresenter implements SDKPayContract.IPresenter {

    /* renamed from: a  reason: collision with root package name */
    Context f29756a;
    long b;

    /* renamed from: c  reason: collision with root package name */
    int f29757c;
    String d;
    String e;
    String f;
    String g;
    String h;
    String i;
    SDKPayContract.IView j;
    private String k;
    private int l = 0;

    public SDKPayPresenter(Context context, long j, int i, String str, String str2, String str3, String str4, String str5, String str6, SDKPayContract.IView iView) {
        this.f29756a = context;
        this.b = j;
        this.f29757c = i;
        this.d = str;
        this.e = str2;
        this.g = str3;
        this.h = str4;
        this.f = str5;
        this.i = str6;
        this.j = iView;
    }

    private void b(String str) {
        this.j.a();
        PayHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<SDKPayConsumeModel>>() { // from class: com.soft.blued.sdk.ui.SDKPayPresenter.2
            private SDKPayConsumeModel b = null;

            /* renamed from: c  reason: collision with root package name */
            private int f29760c = 0;

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<SDKPayConsumeModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                this.b = bluedEntityA.data.get(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str2) {
                this.f29760c = i;
                if (i == 403000203 || i == 403000213 || i == 403000210 || i == 403000212 || TextUtils.isEmpty(str2)) {
                    return true;
                }
                AppMethods.a((CharSequence) str2);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                SDKPayPresenter.this.j.b();
                if (this.b != null) {
                    SDKBaseAction b = SDKActionManager.b(SDKPayPresenter.this.b);
                    if (b != null && (b instanceof SDKPayAction)) {
                        ((SDKPayAction) b).a(SDKPayPresenter.this.f29756a, 0, 0, this.b.balance);
                    }
                    SDKPayPresenter.this.j.f();
                    return;
                }
                int i = this.f29760c;
                if (i == 403000203) {
                    SDKPayPresenter.this.j.g();
                } else if (i == 403000213) {
                    SDKPayPresenter.this.j.h();
                } else if (i == 403000210 && SDKPayPresenter.this.l == 0) {
                    SDKPayPresenter.this.l = 1;
                    SDKPayPresenter.this.a((String) null);
                } else if (this.f29760c == 403000212) {
                    AppMethods.d((int) R.string.sdk_pay_paycode_error);
                }
            }
        }, this.j.getFragmentActive(), this.k, str, this.d, this.e, this.g, this.h, this.f, this.i);
    }

    @Override // com.soft.blued.sdk.ui.SDKPayContract.IPresenter
    public void a(String str) {
        if (TextUtils.isEmpty(this.k)) {
            return;
        }
        if (this.l == 1 && TextUtils.isEmpty(str)) {
            this.j.e();
        } else {
            b(str);
        }
    }

    @Override // com.soft.blued.sdk.ui.SDKPayContract.IPresenter
    public void a(boolean z) {
        this.j.a(UserInfo.getInstance().getUserPrice());
        if (z) {
            PayHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<SDKPayBalanceModel>>() { // from class: com.soft.blued.sdk.ui.SDKPayPresenter.3
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<SDKPayBalanceModel> bluedEntityA) {
                    SDKPayBalanceModel sDKPayBalanceModel;
                    if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0 || (sDKPayBalanceModel = bluedEntityA.data.get(0)) == null) {
                        return;
                    }
                    UserInfo.getInstance().setUserPrice(sDKPayBalanceModel.balance);
                    SDKPayPresenter.this.j.a(sDKPayBalanceModel.balance);
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i, String str) {
                    if (TextUtils.isEmpty(str)) {
                        return true;
                    }
                    AppMethods.a((CharSequence) str);
                    return true;
                }
            }, this.j.getFragmentActive(), this.d, this.e, this.g, this.h, this.f);
        }
    }

    @Override // com.blued.android.framework.mvp_similarity.BasePresenter
    public void ar_() {
        d();
    }

    @Override // com.soft.blued.sdk.ui.SDKPayContract.IPresenter
    public void b() {
        BeansPrePayFragment.a(this.f29756a, 0);
    }

    @Override // com.soft.blued.sdk.ui.SDKPayContract.IPresenter
    public void c() {
        TerminalActivity.d(this.f29756a, PayPasswordSettingFragment.class, null);
    }

    public void d() {
        this.j.a();
        this.j.d();
        PayHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<SDKPayOrderModel>>() { // from class: com.soft.blued.sdk.ui.SDKPayPresenter.1
            private int b = 0;

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<SDKPayOrderModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                SDKPayOrderModel sDKPayOrderModel = bluedEntityA.data.get(0);
                SDKPayPresenter.this.j.a(sDKPayOrderModel.beans);
                SDKPayPresenter.this.j.c(sDKPayOrderModel.goods_name);
                SDKPayPresenter.this.j.b(sDKPayOrderModel.orders_id);
                SDKPayPresenter.this.j.a(sDKPayOrderModel.name);
                SDKPayPresenter.this.j.c();
                SDKPayPresenter.this.k = sDKPayOrderModel.orders_id;
                SDKPayPresenter.this.l = sDKPayOrderModel.has_payment;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                this.b = i;
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                AppMethods.a((CharSequence) str);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                SDKPayPresenter.this.j.b();
                if (TextUtils.isEmpty(SDKPayPresenter.this.k)) {
                    SDKBaseAction b = SDKActionManager.b(SDKPayPresenter.this.b);
                    if (b != null && (b instanceof SDKPayAction)) {
                        ((SDKPayAction) b).a(SDKPayPresenter.this.f29756a, 1, this.b, 0);
                    }
                    SDKPayPresenter.this.j.f();
                }
            }
        }, this.j.getFragmentActive(), this.f29757c, this.d, this.e, this.g, this.h, this.f);
    }
}
