package com.soft.blued.ui.setting.Presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.setting.Contract.LoginDeviceListContract;
import com.soft.blued.ui.setting.model.DeviceModel;
import com.soft.blued.ui.setting.model.LoginProtectionModel;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Presenter/LoginDeviceListPresenter.class */
public class LoginDeviceListPresenter implements LoginDeviceListContract.IPresenter {

    /* renamed from: a  reason: collision with root package name */
    private LoginDeviceListContract.IView f19536a;
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private List<DeviceModel> f19537c = new ArrayList();

    public LoginDeviceListPresenter(LoginDeviceListContract.IView iView, IRequestHost iRequestHost) {
        this.f19536a = iView;
        this.b = iRequestHost;
    }

    @Override // com.soft.blued.ui.setting.Contract.LoginDeviceListContract.IPresenter
    public void a(final String str, String str2) {
        LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<LoginProtectionModel>>(this.b) { // from class: com.soft.blued.ui.setting.Presenter.LoginDeviceListPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LoginProtectionModel> bluedEntityA) {
                boolean z;
                String str3 = str;
                int hashCode = str3.hashCode();
                if (hashCode == -1335458389) {
                    if (str3.equals("delete")) {
                        z = true;
                    }
                    z = true;
                } else if (hashCode != 102230) {
                    if (hashCode == 113762 && str3.equals("set")) {
                        z = false;
                    }
                    z = true;
                } else {
                    if (str3.equals(MonitorConstants.CONNECT_TYPE_GET)) {
                        z = true;
                    }
                    z = true;
                }
                if (!z) {
                    LoginDeviceListPresenter.this.f19536a.a((bluedEntityA == null || !bluedEntityA.hasData()) ? "" : ((LoginProtectionModel) bluedEntityA.getSingleData()).mobile);
                } else if (bluedEntityA == null || !bluedEntityA.hasData()) {
                } else {
                    LoginDeviceListPresenter.this.f19537c = ((LoginProtectionModel) bluedEntityA.getSingleData()).devices;
                    LoginDeviceListPresenter.this.f19536a.a((LoginProtectionModel) bluedEntityA.getSingleData());
                }
            }

            public boolean onUIFailure(int i, String str3) {
                if (i == 4035008) {
                    LoginDeviceListPresenter.this.f19536a.c();
                    return true;
                }
                if ("set".equals(str)) {
                    LoginDeviceListPresenter.this.f19536a.a(false);
                } else if ("close".equals(str)) {
                    LoginDeviceListPresenter.this.f19536a.a(true);
                }
                return super.onUIFailure(i, str3);
            }

            public void onUIFinish() {
                super.onUIFinish();
                LoginDeviceListPresenter.this.f19536a.b();
            }

            public void onUIStart() {
                super.onUIStart();
                LoginDeviceListPresenter.this.f19536a.a();
            }
        }, str, "", str2, this.b);
    }

    public void ar_() {
        a(MonitorConstants.CONNECT_TYPE_GET, "");
    }

    @Override // com.soft.blued.ui.setting.Contract.LoginDeviceListContract.IPresenter
    public List<DeviceModel> b() {
        return this.f19537c;
    }
}
