package com.blued.android.module.common.fragment;

import android.app.Dialog;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.framework.ui.SimpleFragment;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.R;
import com.blued.android.module.common.adapter.CommonAdapter;
import com.blued.android.module.common.utils.CommonHttpUtils;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.sina.weibo.sdk.constant.WBPageConstants;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/fragment/BaseListFragment.class */
public abstract class BaseListFragment<T, S extends BluedEntityBaseExtra> extends SimpleFragment {

    /* renamed from: a  reason: collision with root package name */
    protected CommonTopTitleNoTrans f10817a;
    protected RenrenPullToRefreshListView b;

    /* renamed from: c  reason: collision with root package name */
    protected ListView f10818c;
    protected CommonAdapter<T> d;
    protected NoDataAndLoadFailView e;
    private Dialog g;
    private int h = 0;
    protected int f = 20;

    protected BluedUIHttpResponse<BluedEntity<T, S>> a(int i) {
        BluedUIHttpResponse<BluedEntity<T, S>> bluedUIHttpResponse = (BluedUIHttpResponse<BluedEntity<T, S>>) new BluedUIHttpResponse<BluedEntity<T, S>>(getFragmentActive()) { // from class: com.blued.android.module.common.fragment.BaseListFragment.2

            /* renamed from: a  reason: collision with root package name */
            boolean f10820a = false;

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i2, String str) {
                this.f10820a = true;
                return super.onUIFailure(i2, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                BaseListFragment.this.b.j();
                BaseListFragment.this.b.q();
                if (!BaseListFragment.this.d.isEmpty()) {
                    BaseListFragment.this.e.d();
                } else if (this.f10820a) {
                    BaseListFragment.this.e.b();
                } else {
                    BaseListFragment.this.e.a();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x0078  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x00ac  */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onUIUpdate(com.blued.android.framework.http.parser.BluedEntity r5) {
                /*
                    r4 = this;
                    r0 = 0
                    r6 = r0
                    r0 = r4
                    r1 = 0
                    r0.f10820a = r1
                    r0 = r4
                    java.lang.Object r0 = r0.getData()
                    java.lang.Integer r0 = (java.lang.Integer) r0
                    int r0 = r0.intValue()
                    r7 = r0
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r1 = r0
                    r1.<init>()
                    r8 = r0
                    r0 = r8
                    java.lang.String r1 = "reqPage: "
                    java.lang.StringBuilder r0 = r0.append(r1)
                    r0 = r8
                    r1 = r7
                    java.lang.StringBuilder r0 = r0.append(r1)
                    r0 = r8
                    java.lang.String r0 = r0.toString()
                    int r0 = com.blued.android.framework.utils.LogUtils.c(r0)
                    r0 = r5
                    if (r0 == 0) goto Lb7
                    r0 = r5
                    boolean r0 = r0.hasData()
                    if (r0 == 0) goto Lb7
                    r0 = r7
                    r1 = 1
                    if (r0 != r1) goto L56
                    r0 = r4
                    com.blued.android.module.common.fragment.BaseListFragment r0 = com.blued.android.module.common.fragment.BaseListFragment.this
                    com.blued.android.module.common.adapter.CommonAdapter<T> r0 = r0.d
                    r1 = r5
                    java.util.List<T> r1 = r1.data
                    r0.a(r1)
                L51:
                    r0 = 1
                    r6 = r0
                    goto L74
                L56:
                    r0 = r7
                    r1 = r4
                    com.blued.android.module.common.fragment.BaseListFragment r1 = com.blued.android.module.common.fragment.BaseListFragment.this
                    int r1 = com.blued.android.module.common.fragment.BaseListFragment.a(r1)
                    r2 = 1
                    int r1 = r1 + r2
                    if (r0 != r1) goto L74
                    r0 = r4
                    com.blued.android.module.common.fragment.BaseListFragment r0 = com.blued.android.module.common.fragment.BaseListFragment.this
                    com.blued.android.module.common.adapter.CommonAdapter<T> r0 = r0.d
                    r1 = r5
                    java.util.List<T> r1 = r1.data
                    r0.b(r1)
                    goto L51
                L74:
                    r0 = r6
                    if (r0 == 0) goto Lac
                    r0 = r4
                    com.blued.android.module.common.fragment.BaseListFragment r0 = com.blued.android.module.common.fragment.BaseListFragment.this
                    r1 = r7
                    int r0 = com.blued.android.module.common.fragment.BaseListFragment.a(r0, r1)
                    r0 = r4
                    com.blued.android.module.common.fragment.BaseListFragment r0 = com.blued.android.module.common.fragment.BaseListFragment.this
                    r1 = r5
                    boolean r0 = r0.a(r1)
                    if (r0 == 0) goto L99
                    r0 = r4
                    com.blued.android.module.common.fragment.BaseListFragment r0 = com.blued.android.module.common.fragment.BaseListFragment.this
                    com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView r0 = r0.b
                    r0.o()
                    goto La3
                L99:
                    r0 = r4
                    com.blued.android.module.common.fragment.BaseListFragment r0 = com.blued.android.module.common.fragment.BaseListFragment.this
                    com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView r0 = r0.b
                    r0.p()
                La3:
                    r0 = r4
                    com.blued.android.module.common.fragment.BaseListFragment r0 = com.blued.android.module.common.fragment.BaseListFragment.this
                    r1 = r5
                    r0.b(r1)
                    return
                Lac:
                    r0 = r4
                    com.blued.android.module.common.fragment.BaseListFragment r0 = com.blued.android.module.common.fragment.BaseListFragment.this
                    com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView r0 = r0.b
                    r0.p()
                    return
                Lb7:
                    r0 = r4
                    com.blued.android.module.common.fragment.BaseListFragment r0 = com.blued.android.module.common.fragment.BaseListFragment.this
                    com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView r0 = r0.b
                    r0.p()
                    r0 = r4
                    com.blued.android.module.common.fragment.BaseListFragment r0 = com.blued.android.module.common.fragment.BaseListFragment.this
                    int r1 = com.blued.android.module.common.R.string.common_nomore_data
                    java.lang.String r0 = r0.getString(r1)
                    com.blued.android.core.AppMethods.a(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.fragment.BaseListFragment.AnonymousClass2.onUIUpdate(com.blued.android.framework.http.parser.BluedEntity):void");
            }
        };
        bluedUIHttpResponse.setData(Integer.valueOf(i));
        bluedUIHttpResponse.setDataType(b());
        return bluedUIHttpResponse;
    }

    public abstract CommonAdapter<T> a();

    protected void a(boolean z) {
        if (z) {
            this.h = 0;
        }
        int i = this.h + 1;
        CommonHttpUtils.a(a(i), c(), b(i), getFragmentActive());
    }

    public boolean a(BluedEntity<T, S> bluedEntity) {
        if (bluedEntity == null) {
            return false;
        }
        return bluedEntity.hasMore();
    }

    public abstract Type b();

    public Map<String, String> b(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("page_size", String.valueOf(this.f));
        hashMap.put(WBPageConstants.ParamKey.PAGE, String.valueOf(i));
        return hashMap;
    }

    public void b(BluedEntity<T, S> bluedEntity) {
    }

    public abstract String c();

    @Override // com.blued.android.framework.ui.SimpleFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        DialogUtils.b(this.g);
        super.onDestroy();
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onInitView() {
        super.onInitView();
        this.f10817a = (CommonTopTitleNoTrans) this.rootView.findViewById(R.id.base_list_title);
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.rootView.findViewById(R.id.base_list_prlv);
        this.b = renrenPullToRefreshListView;
        this.f10818c = (ListView) renrenPullToRefreshListView.getRefreshableView();
        this.b.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.blued.android.module.common.fragment.BaseListFragment.1
            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void a() {
                BaseListFragment.this.a(true);
            }

            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void b() {
                BaseListFragment.this.a(false);
            }
        });
        this.f10818c.setClipToPadding(false);
        this.f10818c.setScrollBarStyle(33554432);
        this.f10818c.setHeaderDividersEnabled(false);
        this.f10818c.setDividerHeight(0);
        CommonAdapter<T> a2 = a();
        this.d = a2;
        this.f10818c.setAdapter((ListAdapter) a2);
        this.e = (NoDataAndLoadFailView) this.rootView.findViewById(R.id.base_list_no_data);
        this.g = DialogUtils.a(getActivity());
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public void onInitViewFinished() {
        super.onInitViewFinished();
        a(true);
    }

    @Override // com.blued.android.framework.ui.SimpleFragment
    public int onSetRootViewId() {
        return R.layout.fragment_base_list;
    }
}
