package com.blued.community.ui.circle.vm;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.community.http.CircleHttpUtils;
import com.blued.community.ui.circle.model.CircleTypeListModel;
import com.blued.community.ui.circle.model.CircleTypeModel;
import com.blued.community.ui.circle.model.MyCircleExtra;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.das.client.feed.FeedProtos;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/vm/CircleTypeListViewModel.class */
public final class CircleTypeListViewModel extends BaseViewModel {
    private FeedProtos.SourcePage a = FeedProtos.SourcePage.UNKNOWN_SOURCE_PAGE;
    private int b = Integer.MIN_VALUE;
    private final MutableLiveData<CircleTypeListModel> c = new MutableLiveData<>();
    private final MutableLiveData<List<CircleTypeModel.DataBean>> d = new MutableLiveData<>();
    private final MutableLiveData<Boolean> e = new MutableLiveData<>();
    private int f = 20;
    private int g = -1;
    private Map<Integer, CircleTypeListModel> h = new LinkedHashMap();
    private boolean i;

    private final void a(final boolean z, final IRequestHost iRequestHost) {
        CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntity<MyCircleModel, MyCircleExtra>>(z, this) { // from class: com.blued.community.ui.circle.vm.CircleTypeListViewModel$getCircleListData$1
            final /* synthetic */ boolean b;
            final /* synthetic */ CircleTypeListViewModel c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = z;
                this.c = this;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z2) {
                super.onUIFinish(z2);
                if (!z2) {
                    CircleTypeListViewModel circleTypeListViewModel = this.c;
                    circleTypeListViewModel.b(circleTypeListViewModel.o() - 1);
                }
                this.c.a(z2);
                this.c.d(z2);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<MyCircleModel, MyCircleExtra> bluedEntity) {
                if (bluedEntity != null) {
                    if (bluedEntity.hasData()) {
                        if (this.b) {
                            CircleTypeListModel p = this.c.p();
                            List<MyCircleModel> list = bluedEntity.data;
                            Intrinsics.c(list, "parseData.data");
                            p.setCircleList(list);
                        } else {
                            CircleTypeListModel p2 = this.c.p();
                            List<MyCircleModel> circleList = p2.getCircleList();
                            List<MyCircleModel> list2 = bluedEntity.data;
                            Intrinsics.c(list2, "parseData.data");
                            p2.setCircleList(CollectionsKt.b((Collection) circleList, (Iterable) list2));
                        }
                    }
                    this.c.p().setHasMore(bluedEntity.hasMore());
                }
                this.c.f().setValue(this.c.p());
                CircleTypeListViewModel circleTypeListViewModel = this.c;
                circleTypeListViewModel.b(circleTypeListViewModel.p().getHasMore());
            }
        }, o(), this.f, String.valueOf(this.g));
    }

    public final void a(int i) {
        this.g = i;
    }

    @Override // com.blued.android.module.common.base.mvvm.BaseViewModel
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle != null) {
            FeedProtos.SourcePage serializable = bundle.getSerializable("circle_new_list_from_page");
            Intrinsics.a(serializable);
            this.a = serializable;
            this.b = bundle.getInt("circle_list_type", Integer.MIN_VALUE);
        }
        n();
    }

    public final void a(IRequestHost requestActive) {
        Intrinsics.e(requestActive, "requestActive");
        b(1);
        a(true, requestActive);
    }

    public final void b(int i) {
        CircleTypeListModel circleTypeListModel = this.h.get(Integer.valueOf(this.g));
        if (circleTypeListModel == null) {
            return;
        }
        circleTypeListModel.setPage(i);
    }

    public final void b(IRequestHost requestActive) {
        Intrinsics.e(requestActive, "requestActive");
        b(o() + 1);
        a(false, requestActive);
    }

    public final void c(boolean z) {
        this.i = z;
    }

    public final FeedProtos.SourcePage d() {
        return this.a;
    }

    public final void d(boolean z) {
        CircleTypeListModel circleTypeListModel = this.h.get(Integer.valueOf(this.g));
        if (circleTypeListModel == null) {
            return;
        }
        circleTypeListModel.setSuccess(z);
    }

    public final int e() {
        return this.b;
    }

    public final MutableLiveData<CircleTypeListModel> f() {
        return this.c;
    }

    public final MutableLiveData<List<CircleTypeModel.DataBean>> g() {
        return this.d;
    }

    public final MutableLiveData<Boolean> h() {
        return this.e;
    }

    public final int i() {
        return this.g;
    }

    public final Map<Integer, CircleTypeListModel> j() {
        return this.h;
    }

    public final boolean k() {
        return this.i;
    }

    public final boolean l() {
        return this.h.get(Integer.valueOf(this.g)) != null;
    }

    public final void m() {
        this.c.setValue(p());
        b(p().getHasMore());
    }

    public final void n() {
        CircleHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<CircleTypeModel.DataBean>>() { // from class: com.blued.community.ui.circle.vm.CircleTypeListViewModel$getCircleTypeData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<CircleTypeModel.DataBean> bluedEntityA) {
                CircleTypeListViewModel.this.g().setValue(bluedEntityA == null ? null : bluedEntityA.data);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                CircleTypeListViewModel.this.a(z);
                CircleTypeListViewModel.this.h().setValue(Boolean.valueOf(z));
            }
        });
    }

    public final int o() {
        CircleTypeListModel circleTypeListModel = this.h.get(Integer.valueOf(this.g));
        if (circleTypeListModel == null) {
            return 1;
        }
        return circleTypeListModel.getPage();
    }

    public final CircleTypeListModel p() {
        CircleTypeListModel circleTypeListModel = this.h.get(Integer.valueOf(this.g));
        CircleTypeListModel circleTypeListModel2 = circleTypeListModel;
        if (circleTypeListModel == null) {
            circleTypeListModel2 = new CircleTypeListModel();
        }
        j().put(Integer.valueOf(i()), circleTypeListModel2);
        return circleTypeListModel2;
    }
}
