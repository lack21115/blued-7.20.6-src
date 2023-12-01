package com.blued.community.ui.common;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.ui.SimpleFragment;
import com.blued.android.module.common.utils.CommonHttpUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.R;
import com.blued.community.view.CommonMultiItemAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/common/CommonRecyclerFragment.class */
public abstract class CommonRecyclerFragment<T extends MultiItemEntity, S extends BluedEntityBaseExtra> extends SimpleFragment {

    /* renamed from: a  reason: collision with root package name */
    private CommonTopTitleNoTrans f19495a;
    private SmartRefreshLayout b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f19496c;
    private CommonMultiItemAdapter<T> d;
    private NoDataAndLoadFailView e;
    private int f = 1;
    private int g = 20;
    private final AtomicBoolean h = new AtomicBoolean(false);
    private boolean i;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CommonRecyclerFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CommonRecyclerFragment this$0, RefreshLayout it) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.a(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CommonRecyclerFragment this$0, RefreshLayout it) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.a(false);
    }

    private final void q() {
        this.f19495a = (CommonTopTitleNoTrans) this.rootView.findViewById(R.id.top_title);
        if (!e()) {
            CommonTopTitleNoTrans commonTopTitleNoTrans = this.f19495a;
            if (commonTopTitleNoTrans == null) {
                return;
            }
            commonTopTitleNoTrans.setVisibility(8);
            return;
        }
        CommonTopTitleNoTrans commonTopTitleNoTrans2 = this.f19495a;
        if (commonTopTitleNoTrans2 != null) {
            commonTopTitleNoTrans2.setCenterText(f());
        }
        CommonTopTitleNoTrans commonTopTitleNoTrans3 = this.f19495a;
        if (commonTopTitleNoTrans3 != null) {
            commonTopTitleNoTrans3.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.community.ui.common.-$$Lambda$CommonRecyclerFragment$DvqLmRIppGO842O2dEDiPBQvscA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommonRecyclerFragment.a(CommonRecyclerFragment.this, view);
                }
            });
        }
        CommonTopTitleNoTrans commonTopTitleNoTrans4 = this.f19495a;
        if (commonTopTitleNoTrans4 != null) {
            commonTopTitleNoTrans4.f();
        }
        CommonTopTitleNoTrans commonTopTitleNoTrans5 = this.f19495a;
        if (commonTopTitleNoTrans5 == null) {
            return;
        }
        commonTopTitleNoTrans5.setVisibility(0);
    }

    public final CommonMultiItemAdapter<T> a() {
        return this.d;
    }

    public final void a(int i) {
        this.f = i;
    }

    public void a(boolean z) {
        if (this.h.get()) {
            return;
        }
        this.h.set(true);
        if (z) {
            this.f = 1;
        } else {
            this.f++;
        }
        int i = this.f;
        CommonHttpUtils.a(b(i), l(), c(i), getFragmentActive());
    }

    public boolean a(BluedEntity<T, S> bluedEntity) {
        return bluedEntity != null && bluedEntity.hasMore();
    }

    protected BluedUIHttpResponse<BluedEntity<T, S>> b(int i) {
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        BluedUIHttpResponse<BluedEntity<T, S>> bluedUIHttpResponse = (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntity<T, S>>(this, fragmentActive) { // from class: com.blued.community.ui.common.CommonRecyclerFragment$getHttpResponse$httpResponse$1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CommonRecyclerFragment<T, S> f19497a;
            private boolean b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f19497a = this;
            }

            public final boolean a() {
                return this.b;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                this.b = true;
                return super.onUIFailure(i2, errorMessage);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                this.f19497a.o();
                CommonMultiItemAdapter<T> a2 = this.f19497a.a();
                if (a2 == null) {
                    return;
                }
                CommonRecyclerFragment<T, S> commonRecyclerFragment = this.f19497a;
                if (a2.getData().size() != 0) {
                    commonRecyclerFragment.b(false);
                } else if (a()) {
                    commonRecyclerFragment.p();
                } else {
                    commonRecyclerFragment.b(true);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<T, S> bluedEntity) {
                CommonMultiItemAdapter<T> a2;
                this.b = false;
                Object data = getData();
                if (data == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                int intValue = ((Integer) data).intValue();
                if (intValue == 1 && (a2 = this.f19497a.a()) != null) {
                    a2.setDataAndNotify(new ArrayList());
                }
                if (bluedEntity == null || !bluedEntity.hasData()) {
                    this.f19497a.n();
                    return;
                }
                CommonMultiItemAdapter<T> a3 = this.f19497a.a();
                if (a3 != null) {
                    a3.addDataAndNotify(bluedEntity.data);
                }
                this.f19497a.a(intValue);
                if (this.f19497a.a(bluedEntity)) {
                    this.f19497a.m();
                } else {
                    this.f19497a.n();
                }
                this.f19497a.b(bluedEntity);
            }
        };
        bluedUIHttpResponse.setData(Integer.valueOf(i));
        bluedUIHttpResponse.setDataType(k());
        return bluedUIHttpResponse;
    }

    public final NoDataAndLoadFailView b() {
        return this.e;
    }

    public void b(BluedEntity<T, S> bluedEntity) {
    }

    public void b(boolean z) {
        if (z) {
            NoDataAndLoadFailView noDataAndLoadFailView = this.e;
            if (noDataAndLoadFailView == null) {
                return;
            }
            noDataAndLoadFailView.a();
            return;
        }
        NoDataAndLoadFailView noDataAndLoadFailView2 = this.e;
        if (noDataAndLoadFailView2 == null) {
            return;
        }
        noDataAndLoadFailView2.d();
    }

    public Map<String, String> c(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("page_size", String.valueOf(this.g));
        hashMap.put(WBPageConstants.ParamKey.PAGE, String.valueOf(i));
        return hashMap;
    }

    protected boolean c() {
        return false;
    }

    protected boolean d() {
        return true;
    }

    protected boolean e() {
        return true;
    }

    protected int f() {
        return R.string.common_main_feed;
    }

    public abstract CommonMultiItemAdapter<T> g();

    protected void h() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    protected void i() {
        RecyclerView recyclerView = this.f19496c;
        if (recyclerView == null) {
            return;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    public void j() {
    }

    public abstract Type k();

    public abstract String l();

    public void m() {
        SmartRefreshLayout smartRefreshLayout = this.b;
        if (smartRefreshLayout == null) {
            return;
        }
        smartRefreshLayout.l(true);
    }

    public void n() {
        SmartRefreshLayout smartRefreshLayout = this.b;
        if (smartRefreshLayout == null) {
            return;
        }
        smartRefreshLayout.l(false);
    }

    public void o() {
        SmartRefreshLayout smartRefreshLayout = this.b;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.j();
        }
        SmartRefreshLayout smartRefreshLayout2 = this.b;
        if (smartRefreshLayout2 != null) {
            smartRefreshLayout2.h();
        }
        this.h.set(false);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        q();
        this.b = (SmartRefreshLayout) this.rootView.findViewById(R.id.refresh_layout);
        this.f19496c = (RecyclerView) this.rootView.findViewById(R.id.recycler_view);
        i();
        SmartRefreshLayout smartRefreshLayout = this.b;
        if (smartRefreshLayout != null) {
            smartRefreshLayout.a(new OnRefreshListener() { // from class: com.blued.community.ui.common.-$$Lambda$CommonRecyclerFragment$qK54NEfdHuvkT3LQyHq3n7U6fDE
                @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
                public final void onRefresh(RefreshLayout refreshLayout) {
                    CommonRecyclerFragment.a(CommonRecyclerFragment.this, refreshLayout);
                }
            });
        }
        SmartRefreshLayout smartRefreshLayout2 = this.b;
        if (smartRefreshLayout2 != null) {
            smartRefreshLayout2.a(new OnLoadMoreListener() { // from class: com.blued.community.ui.common.-$$Lambda$CommonRecyclerFragment$M8uslSlNopHmuDZnDEUObdfZEdI
                @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
                public final void onLoadMore(RefreshLayout refreshLayout) {
                    CommonRecyclerFragment.b(CommonRecyclerFragment.this, refreshLayout);
                }
            });
        }
        SmartRefreshLayout smartRefreshLayout3 = this.b;
        if (smartRefreshLayout3 != null) {
            smartRefreshLayout3.c(true);
        }
        SmartRefreshLayout smartRefreshLayout4 = this.b;
        if (smartRefreshLayout4 != null) {
            smartRefreshLayout4.l(true);
        }
        SmartRefreshLayout smartRefreshLayout5 = this.b;
        if (smartRefreshLayout5 != null) {
            smartRefreshLayout5.k(true);
        }
        CommonMultiItemAdapter<T> g = g();
        this.d = g;
        RecyclerView recyclerView = this.f19496c;
        if (recyclerView != null) {
            recyclerView.setAdapter(g);
        }
        this.e = new NoDataAndLoadFailView(getContext());
        j();
        NoDataAndLoadFailView noDataAndLoadFailView = this.e;
        if (noDataAndLoadFailView != null) {
            CommonMultiItemAdapter<T> a2 = a();
            if (a2 != null) {
                a2.setEmptyView(noDataAndLoadFailView);
            }
            CommonMultiItemAdapter<T> a3 = a();
            if (a3 != null) {
                a3.isUseEmpty(true);
            }
        }
        if (d()) {
            if (!c()) {
                SmartRefreshLayout smartRefreshLayout6 = this.b;
                if (smartRefreshLayout6 == null) {
                    return;
                }
                smartRefreshLayout6.i();
            } else if (!getUserVisibleHint() || this.i) {
            } else {
                this.i = true;
                SmartRefreshLayout smartRefreshLayout7 = this.b;
                if (smartRefreshLayout7 == null) {
                    return;
                }
                smartRefreshLayout7.i();
            }
        }
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return R.layout.fragment_common_recycler;
    }

    public void p() {
        NoDataAndLoadFailView noDataAndLoadFailView = this.e;
        if (noDataAndLoadFailView == null) {
            return;
        }
        noDataAndLoadFailView.b();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (this.isUserVisibleHint && d() && c() && !this.i && getLifecycle().getCurrentState().compareTo(Lifecycle.State.CREATED) >= 0) {
            this.i = true;
            SmartRefreshLayout smartRefreshLayout = this.b;
            if (smartRefreshLayout == null) {
                return;
            }
            smartRefreshLayout.i();
        }
    }
}
