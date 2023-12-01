package com.soft.blued.ui.find.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.ui.find.contract.ImmediateTabsContract;
import com.soft.blued.ui.find.model.ImmediateTabModel;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/presenter/ImmediateTabsPresenter.class */
public class ImmediateTabsPresenter implements ImmediateTabsContract.IPresenter {

    /* renamed from: a  reason: collision with root package name */
    private ImmediateTabsContract.IView f16947a;
    private IRequestHost b;

    /* renamed from: com.soft.blued.ui.find.presenter.ImmediateTabsPresenter$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/presenter/ImmediateTabsPresenter$2.class */
    class AnonymousClass2 extends BluedUIHttpResponse<BluedEntityA<Object>> {
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
        }
    }

    public void ar_() {
        b();
    }

    public void b() {
        NearbyHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<ImmediateTabModel>>(this.b) { // from class: com.soft.blued.ui.find.presenter.ImmediateTabsPresenter.1
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ImmediateTabModel> bluedEntityA) {
                List<ImmediateTabModel.Tab> list;
                if (bluedEntityA == null || !bluedEntityA.hasData() || bluedEntityA.data.get(0) == null || (list = ((ImmediateTabModel) bluedEntityA.data.get(0)).conf) == null || list.size() <= 0) {
                    return;
                }
                ImmediateTabsPresenter.this.f16947a.a(((ImmediateTabModel) bluedEntityA.data.get(0)).conf);
            }
        }, this.b, "main");
    }
}
