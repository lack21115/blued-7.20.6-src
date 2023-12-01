package com.soft.blued.ui.setting.Presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto2;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.login.model.BluedCheckResult;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.login_register.LoginRegisterTools;
import com.soft.blued.ui.setting.Contract.BindingSecureEmailContract;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Presenter/BindingSecureEmailPresenter.class */
public class BindingSecureEmailPresenter implements BindingSecureEmailContract.IPresenter {

    /* renamed from: a  reason: collision with root package name */
    private static final String f19524a = BindingSecureEmailPresenter.class.getSimpleName();
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private BindingSecureEmailContract.IView f19525c;
    private String d = "";

    public BindingSecureEmailPresenter(Context context, BindingSecureEmailContract.IView iView) {
        if (context == null || iView == null) {
            return;
        }
        this.b = context;
        this.f19525c = iView;
    }

    public void a(String str) {
        this.d = str;
    }

    @Override // com.soft.blued.ui.setting.Contract.BindingSecureEmailContract.IPresenter
    public void a(final String str, int i, final String str2, final String str3) {
        LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<Object>>() { // from class: com.soft.blued.ui.setting.Presenter.BindingSecureEmailPresenter.2
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public BluedEntityA<Object> parseData(String str4) {
                Logger.b(BindingSecureEmailPresenter.f19524a, "===success", "responseJson:", str4);
                return super.parseData(str4);
            }

            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                try {
                    BindingSecureEmailPresenter.this.f19525c.d();
                    BindingSecureEmailPresenter.this.a(str2, str3);
                } catch (Exception e) {
                    e.printStackTrace();
                    BindingSecureEmailPresenter.this.f19525c.c();
                }
            }

            public void onFailure(Throwable th, int i2, String str4) {
                Logger.b(BindingSecureEmailPresenter.f19524a, "===error", "responseCode:", Integer.valueOf(i2), ",responseJson:", str4);
                super.onFailure(th, i2, str4);
                if (i2 != 403) {
                    if (StringUtils.d(BindingSecureEmailPresenter.this.b())) {
                        return;
                    }
                    AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.setting.Presenter.BindingSecureEmailPresenter.2.4
                        @Override // java.lang.Runnable
                        public void run() {
                            BindingSecureEmailPresenter.this.f19525c.a(BindingSecureEmailPresenter.this.b());
                        }
                    });
                    return;
                }
                int intValue = ((Integer) BluedHttpUtils.a(th, i2, str4).first).intValue();
                if (intValue == 4036002) {
                    BindingSecureEmailPresenter.this.f19525c.e();
                    BindingSecureEmailPresenter.this.a(LoginRegisterTools.a(str4));
                    if (StringUtils.d(BindingSecureEmailPresenter.this.b())) {
                        return;
                    }
                    AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.setting.Presenter.BindingSecureEmailPresenter.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BindingSecureEmailPresenter.this.f19525c.a(BindingSecureEmailPresenter.this.b());
                        }
                    });
                } else if (intValue == 4036104) {
                    CommonAlertDialog.a(BindingSecureEmailPresenter.this.b, (String) null, BindingSecureEmailPresenter.this.b.getResources().getString(2131890493), BindingSecureEmailPresenter.this.b.getResources().getString(2131886739), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.setting.Presenter.BindingSecureEmailPresenter.2.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            Tracker.onClick(dialogInterface, i3);
                            BindingSecureEmailPresenter.this.a(str, 1, str2, str3);
                        }
                    }, (String) null, (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
                } else if (StringUtils.d(BindingSecureEmailPresenter.this.b())) {
                } else {
                    AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.setting.Presenter.BindingSecureEmailPresenter.2.3
                        @Override // java.lang.Runnable
                        public void run() {
                            BindingSecureEmailPresenter.this.f19525c.a(BindingSecureEmailPresenter.this.b());
                        }
                    });
                }
            }

            public void onUIFinish() {
                BindingSecureEmailPresenter.this.f19525c.a();
            }

            public void onUIStart() {
                BindingSecureEmailPresenter.this.f19525c.b();
            }
        }, str, i, str2, (IRequestHost) null);
    }

    public void a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("binding_type", str2);
        bundle.putString(LoginRegisterTools.f17710c, this.d);
        bundle.putString("secure_email", str);
        this.f19525c.a(bundle);
    }

    public void ar_() {
        c();
    }

    @Override // com.soft.blued.ui.setting.Contract.BindingSecureEmailContract.IPresenter
    public String b() {
        return this.d;
    }

    public void c() {
        LoginRegisterHttpUtils.d(new BluedUIHttpResponse<BluedEntityA<BluedCheckResult>>() { // from class: com.soft.blued.ui.setting.Presenter.BindingSecureEmailPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public BluedEntityA<BluedCheckResult> parseData(String str) {
                BluedEntityA<BluedCheckResult> parseData = super.parseData(str);
                if (parseData != null) {
                    try {
                        if (parseData.hasData()) {
                            String a2 = AesCrypto2.a(((BluedCheckResult) parseData.data.get(0)).getEncrypted());
                            Logger.b(BindingSecureEmailPresenter.f19524a, "解密：deData===", a2);
                            parseData.data.set(0, (BluedCheckResult) AppInfo.f().fromJson(a2, (Class<Object>) BluedCheckResult.class));
                            return parseData;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        BindingSecureEmailPresenter.this.f19525c.c();
                    }
                }
                return parseData;
            }

            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedCheckResult> bluedEntityA) {
                BluedCheckResult bluedCheckResult;
                try {
                    if (bluedEntityA.data.get(0) == null || (bluedCheckResult = (BluedCheckResult) bluedEntityA.data.get(0)) == null) {
                        return;
                    }
                    BindingSecureEmailPresenter.this.a(bluedCheckResult.getCaptcha());
                    if (StringUtils.d(BindingSecureEmailPresenter.this.b())) {
                        return;
                    }
                    BindingSecureEmailPresenter.this.f19525c.a(BindingSecureEmailPresenter.this.d);
                } catch (Exception e) {
                    e.printStackTrace();
                    BindingSecureEmailPresenter.this.f19525c.c();
                }
            }

            public void onUIFinish() {
                BindingSecureEmailPresenter.this.f19525c.a();
            }

            public void onUIStart() {
                BindingSecureEmailPresenter.this.f19525c.b();
            }
        }, null);
    }
}
