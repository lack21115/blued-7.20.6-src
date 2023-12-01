package com.soft.blued.ui.msg.presenter;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.ui.msg.model.UserGiftPackageModel;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/presenter/UserGiftPresenter.class */
public class UserGiftPresenter extends MvpPresenter {
    public void a(final IFetchDataListener iFetchDataListener) {
        UserHttpUtils.b(new BluedUIHttpResponse<BluedEntityA<UserGiftPackageModel>>(g()) { // from class: com.soft.blued.ui.msg.presenter.UserGiftPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<UserGiftPackageModel> bluedEntityA) {
                if (bluedEntityA.hasData()) {
                    iFetchDataListener.a("DATA_PACKAGE", bluedEntityA.data);
                } else {
                    iFetchDataListener.a("DATA_PACKAGE", new ArrayList());
                }
            }

            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                iFetchDataListener.a(z);
            }
        }, g());
    }

    public void a(String str, String str2, String str3, String str4) {
        UserHttpUtils.a(str, str2, str3, str4, new BluedUIHttpResponse(g()) { // from class: com.soft.blued.ui.msg.presenter.UserGiftPresenter.2
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    UserGiftPresenter.this.f_("DATA_BUY_SUCCEED");
                }
            }

            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, g());
    }

    public void b(IFetchDataListener iFetchDataListener) {
    }
}
