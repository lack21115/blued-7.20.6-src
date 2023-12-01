package com.soft.blued.ui.user.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.user.contract.InterestGalleryContract;
import com.soft.blued.ui.user.model.PictureTabModel;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/presenter/InterestGalleryPresenter.class */
public class InterestGalleryPresenter implements InterestGalleryContract.IPresenter {

    /* renamed from: a  reason: collision with root package name */
    private InterestGalleryContract.IView f20566a;
    private IRequestHost b;

    public InterestGalleryPresenter(InterestGalleryContract.IView iView, IRequestHost iRequestHost) {
        this.f20566a = iView;
        this.b = iRequestHost;
    }

    public void ar_() {
        b();
    }

    public void b() {
        MineHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<PictureTabModel>>() { // from class: com.soft.blued.ui.user.presenter.InterestGalleryPresenter.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<PictureTabModel> bluedEntityA) {
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.hasData()) {
                            InterestGalleryPresenter.this.f20566a.a(bluedEntityA.data);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            public void onUIFinish() {
                super.onUIFinish();
                InterestGalleryPresenter.this.f20566a.a();
            }
        }, this.b);
    }
}
