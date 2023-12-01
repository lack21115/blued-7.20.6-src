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
    private Context f16943a;
    private ImmediateDetailContract.IView b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f16944c;
    private String d;
    private String e;
    private int f;

    /* renamed from: com.soft.blued.ui.find.presenter.ImmediateDetailPresenter$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/presenter/ImmediateDetailPresenter$2.class */
    class AnonymousClass2 extends BluedUIHttpResponse<BluedEntity<ImmediateUserModel, BluedMyExtra>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImmediateDetailPresenter f16946a;

        public void onUIFinish() {
            this.f16946a.b.b();
        }

        public void onUIUpdate(BluedEntity<ImmediateUserModel, BluedMyExtra> bluedEntity) {
            if (bluedEntity != null) {
                try {
                    if (bluedEntity.hasData()) {
                        if (bluedEntity.extra != null) {
                            this.f16946a.d = ((BluedMyExtra) bluedEntity.extra).getNext_min_dist();
                            this.f16946a.e = ((BluedMyExtra) bluedEntity.extra).getNext_skip_uid();
                            this.f16946a.f = ((BluedMyExtra) bluedEntity.extra).hasmore;
                            this.f16946a.b.b(((BluedMyExtra) bluedEntity.extra).hasmore);
                        }
                        this.f16946a.b.a((ImmediateUserModel) bluedEntity.data.get(0));
                        if (this.f16946a.f == 0) {
                            this.f16946a.b.c();
                            return;
                        }
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.f16946a.b.a() != 1) {
                        this.f16946a.b.a(this.f16946a.b.a() - 1);
                        return;
                    }
                    return;
                }
            }
            if (this.f16946a.b.a() != 1) {
                this.f16946a.b.a(this.f16946a.b.a() - 1);
            } else {
                AppMethods.a(this.f16946a.f16943a.getResources().getString(2131887275));
            }
        }
    }

    public void ar_() {
        b();
    }

    public void b() {
        NearbyHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<ImmediateTabModel>>(this.f16944c) { // from class: com.soft.blued.ui.find.presenter.ImmediateDetailPresenter.1
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<ImmediateTabModel> bluedEntityA) {
                if (bluedEntityA != null) {
                    try {
                        if (bluedEntityA.hasData()) {
                            ImmediateTabModel immediateTabModel = (ImmediateTabModel) bluedEntityA.data.get(0);
                            List<ImmediateTabModel.Tab> list = ((ImmediateTabModel) bluedEntityA.data.get(0)).conf;
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
        }, this.f16944c, "");
    }
}
