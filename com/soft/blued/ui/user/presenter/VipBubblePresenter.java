package com.soft.blued.ui.user.presenter;

import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.utils.ToastUtils;
import com.soft.blued.ui.user.manager.VipBubbleManager;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/presenter/VipBubblePresenter.class */
public class VipBubblePresenter extends MvpPresenter {

    /* renamed from: com.soft.blued.ui.user.presenter.VipBubblePresenter$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/presenter/VipBubblePresenter$2.class */
    class AnonymousClass2 extends BluedUIHttpResponse<BluedEntityA<Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f34304a;
        final /* synthetic */ VipBubblePresenter b;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str, String str2) {
            return true;
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish(boolean z) {
            super.onUIFinish(z);
            ToastUtils.a(this.b.h().getString(z ? 2131886835 : 2131886834));
            if (z) {
                VipBubbleManager.a().a(this.f34304a);
                this.b.i();
            }
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(final IFetchDataListener iFetchDataListener) {
        VipBubbleManager.a().a(new VipBubbleManager.RefreshListener() { // from class: com.soft.blued.ui.user.presenter.VipBubblePresenter.1
            @Override // com.soft.blued.ui.user.manager.VipBubbleManager.RefreshListener
            public void a() {
                iFetchDataListener.a("data_bubble", VipBubbleManager.a().d());
            }
        }, g());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }
}
