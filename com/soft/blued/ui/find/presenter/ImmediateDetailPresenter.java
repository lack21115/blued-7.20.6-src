package com.soft.blued.ui.find.presenter;

import android.content.Context;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.model.BluedMyExtra;
import com.soft.blued.ui.find.contract.ImmediateDetailContract;
import com.soft.blued.ui.find.model.ImmediateTabModel;
import com.soft.blued.ui.find.model.ImmediateUserModel;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/presenter/ImmediateDetailPresenter.class */
public class ImmediateDetailPresenter implements ImmediateDetailContract.IPresenter {

    /* renamed from: a  reason: collision with root package name */
    private Context f30633a;
    private ImmediateDetailContract.IView b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f30634c;
    private String d;
    private String e;
    private int f;

    /* renamed from: com.soft.blued.ui.find.presenter.ImmediateDetailPresenter$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/presenter/ImmediateDetailPresenter$2.class */
    class AnonymousClass2 extends BluedUIHttpResponse<BluedEntity<ImmediateUserModel, BluedMyExtra>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImmediateDetailPresenter f30636a;

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            this.f30636a.b.b();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<ImmediateUserModel, BluedMyExtra> bluedEntity) {
            if (bluedEntity != null) {
                try {
                    if (bluedEntity.hasData()) {
                        if (bluedEntity.extra != null) {
                            this.f30636a.d = bluedEntity.extra.getNext_min_dist();
                            this.f30636a.e = bluedEntity.extra.getNext_skip_uid();
                            this.f30636a.f = bluedEntity.extra.hasmore;
                            this.f30636a.b.b(bluedEntity.extra.hasmore);
                        }
                        this.f30636a.b.a(bluedEntity.data.get(0));
                        if (this.f30636a.f == 0) {
                            this.f30636a.b.c();
                            return;
                        }
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.f30636a.b.a() != 1) {
                        this.f30636a.b.a(this.f30636a.b.a() - 1);
                        return;
                    }
                    return;
                }
            }
            if (this.f30636a.b.a() != 1) {
                this.f30636a.b.a(this.f30636a.b.a() - 1);
            } else {
                AppMethods.a((CharSequence) this.f30636a.f30633a.getResources().getString(2131887275));
            }
        }
    }

    @Override // com.blued.android.framework.mvp_similarity.BasePresenter
    public void ar_() {
        b();
    }

    public void b() {
        NearbyHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<ImmediateTabModel>>(this.f30634c) { // from class: com.soft.blued.ui.find.presenter.ImmediateDetailPresenter.1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ImmediateTabModel> bluedEntityA) {
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.hasData()) {
                            ImmediateTabModel immediateTabModel = bluedEntityA.data.get(0);
                            List<ImmediateTabModel.Tab> list = bluedEntityA.data.get(0).conf;
                            if (list == null || list.size() <= 0) {
                                return;
                            }
                            ImmediateDetailPresenter.this.b.a(immediateTabModel);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, this.f30634c, "");
    }
}
