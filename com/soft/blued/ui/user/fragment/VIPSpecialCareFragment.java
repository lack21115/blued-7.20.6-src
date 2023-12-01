package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.base.dialog.CommonDialogFragment;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.bytedance.applog.tracker.Tracker;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentVipInvisibleToUserBinding;
import com.soft.blued.ui.user.adapter.InvisibleUserDeleteListener;
import com.soft.blued.ui.user.adapter.VipInvisibleListAdapter;
import com.soft.blued.ui.user.model.InvisibleToUserModel;
import com.soft.blued.ui.user.state.SpecialCareAction;
import com.soft.blued.ui.user.state.SpecialCareState;
import com.soft.blued.ui.user.viewmodel.SpecialCareViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VIPSpecialCareFragment.class */
public final class VIPSpecialCareFragment extends MVIBaseFragment<SpecialCareViewModel> {
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(VIPSpecialCareFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/FragmentVipInvisibleToUserBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    public CommonDialogFragment f34154c;
    public VipInvisibleListAdapter d;
    private final ViewBindingProperty e;
    private int f;
    private int g;
    private List<String> h;
    private final Lazy i;
    private final int j;
    private int k;

    public VIPSpecialCareFragment() {
        super(R.layout.fragment_vip_invisible_to_user);
        this.e = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<VIPSpecialCareFragment, FragmentVipInvisibleToUserBinding>() { // from class: com.soft.blued.ui.user.fragment.VIPSpecialCareFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentVipInvisibleToUserBinding invoke(VIPSpecialCareFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentVipInvisibleToUserBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<VIPSpecialCareFragment, FragmentVipInvisibleToUserBinding>() { // from class: com.soft.blued.ui.user.fragment.VIPSpecialCareFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentVipInvisibleToUserBinding invoke(VIPSpecialCareFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentVipInvisibleToUserBinding.a(fragment.requireView());
            }
        });
        this.h = new ArrayList();
        this.i = LazyKt.a(new Function0<NoDataAndLoadFailView>() { // from class: com.soft.blued.ui.user.fragment.VIPSpecialCareFragment$noDataView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final NoDataAndLoadFailView invoke() {
                return new NoDataAndLoadFailView(VIPSpecialCareFragment.this.getContext());
            }
        });
        this.j = 20;
        this.k = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPSpecialCareFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        if (this$0.a() != null) {
            this$0.a().dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPSpecialCareFragment this$0, RefreshLayout it) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.k++;
        this$0.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VIPSpecialCareFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        if (!this$0.h.isEmpty()) {
            BluedStructureExtKt.a(this$0, new SpecialCareAction.cancelSpecialCareUser(this$0.h));
        }
        if (this$0.a() != null) {
            this$0.a().dismiss();
        }
    }

    private final void i() {
        BluedStructureExtKt.a(this, new SpecialCareAction.getSpecialCareData(this.k, this.j));
    }

    public final CommonDialogFragment a() {
        CommonDialogFragment commonDialogFragment = this.f34154c;
        if (commonDialogFragment != null) {
            return commonDialogFragment;
        }
        Intrinsics.c("dialog");
        return null;
    }

    public final void a(int i) {
        this.f = i;
    }

    public final void a(CommonDialogFragment commonDialogFragment) {
        Intrinsics.e(commonDialogFragment, "<set-?>");
        this.f34154c = commonDialogFragment;
    }

    public final void a(VipInvisibleListAdapter vipInvisibleListAdapter) {
        Intrinsics.e(vipInvisibleListAdapter, "<set-?>");
        this.d = vipInvisibleListAdapter;
    }

    public final void a(InvisibleToUserModel parseData) {
        Intrinsics.e(parseData, "parseData");
        FragmentVipInvisibleToUserBinding b2 = b();
        if (b2 == null || getContext() == null) {
            return;
        }
        a(parseData.total);
        b(parseData.setTotal);
        TextView textView = b2.f;
        StringBuilder sb = new StringBuilder();
        sb.append(e());
        sb.append('/');
        sb.append(d());
        textView.setText(sb.toString());
        if (parseData.lists != null) {
            if (h() == 1) {
                c().setNewData(parseData.lists);
            } else {
                c().addData((Collection) parseData.lists);
            }
            if (parseData.lists.size() == 0) {
                g().a();
            }
        }
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void a(boolean z, boolean z2) {
        SmartRefreshLayout smartRefreshLayout;
        FragmentVipInvisibleToUserBinding b2 = b();
        if (b2 != null && (smartRefreshLayout = b2.f29024c) != null) {
            smartRefreshLayout.l(z2);
        }
        FragmentVipInvisibleToUserBinding b3 = b();
        if (b3 == null) {
            return;
        }
        b3.f29024c.h();
    }

    public final FragmentVipInvisibleToUserBinding b() {
        return (FragmentVipInvisibleToUserBinding) this.e.b(this, b[0]);
    }

    public final void b(int i) {
        this.g = i;
    }

    public final VipInvisibleListAdapter c() {
        VipInvisibleListAdapter vipInvisibleListAdapter = this.d;
        if (vipInvisibleListAdapter != null) {
            return vipInvisibleListAdapter;
        }
        Intrinsics.c("mAdapter");
        return null;
    }

    public final int d() {
        return this.f;
    }

    public final int e() {
        return this.g;
    }

    public final List<String> f() {
        return this.h;
    }

    public final NoDataAndLoadFailView g() {
        return (NoDataAndLoadFailView) this.i.getValue();
    }

    public final int h() {
        return this.k;
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        Context context;
        final FragmentVipInvisibleToUserBinding b2 = b();
        if (b2 != null && (context = getContext()) != null) {
            b2.d.setCenterText(context.getString(R.string.msg_special_care));
            b2.e.setText(context.getString(R.string.msg_special_care_list_tips));
            b2.e.setGravity(0);
            b2.d.getTitleBackground().setBackground(new ColorDrawable(0));
            b2.d.setRightText(R.string.done);
            b2.d.setRightTextColor(2131101766);
            b2.d.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPSpecialCareFragment$H1p0c1IQX4Oe07RInIfVMAAQdxM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VIPSpecialCareFragment.a(VIPSpecialCareFragment.this, view);
                }
            });
            b2.d.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPSpecialCareFragment$GNkzorITcE7bTuXd-JiNc5zou74
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VIPSpecialCareFragment.b(VIPSpecialCareFragment.this, view);
                }
            });
            a(new VipInvisibleListAdapter(context));
            b2.b.setLayoutManager(new LinearLayoutManager(context));
            b2.b.setAdapter(c());
            c().a(new InvisibleUserDeleteListener() { // from class: com.soft.blued.ui.user.fragment.VIPSpecialCareFragment$initView$1$1$3
                @Override // com.soft.blued.ui.user.adapter.InvisibleUserDeleteListener
                public void a(InvisibleToUserModel.InvisibleUser user) {
                    Intrinsics.e(user, "user");
                    List<String> f = VIPSpecialCareFragment.this.f();
                    String str = user.uid;
                    Intrinsics.c(str, "user.uid");
                    f.add(str);
                    VIPSpecialCareFragment.this.c().getData().remove(user);
                    if (VIPSpecialCareFragment.this.c().getData().size() == 0) {
                        VIPSpecialCareFragment.this.g().a();
                    }
                    VIPSpecialCareFragment.this.c().notifyDataSetChanged();
                    VIPSpecialCareFragment vIPSpecialCareFragment = VIPSpecialCareFragment.this;
                    vIPSpecialCareFragment.b(vIPSpecialCareFragment.e() - 1);
                    TextView textView = b2.f;
                    StringBuilder sb = new StringBuilder();
                    sb.append(VIPSpecialCareFragment.this.e());
                    sb.append('/');
                    sb.append(VIPSpecialCareFragment.this.d());
                    textView.setText(sb.toString());
                }
            });
            g().setNoDataImg(2131233630);
            g().setBackgroundColorRes(2131102388);
            g().setTopSpace(DensityUtils.a(getContext(), 40.0f));
            g().setNoDataStr(R.string.msg_special_care_list_no_data);
            g().d();
            NoDataAndLoadFailView noDataAndLoadFailView = b2.f29023a;
            c().setEmptyView(g());
            b2.f29024c.l(true);
            b2.f29024c.c(false);
            b2.f29024c.a(new OnLoadMoreListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPSpecialCareFragment$P6GjFlrcYEJTVoefHdMf9QzuPVs
                @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
                public final void onLoadMore(RefreshLayout refreshLayout) {
                    VIPSpecialCareFragment.a(VIPSpecialCareFragment.this, refreshLayout);
                }
            });
        }
        i();
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void o() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner, "viewLifecycleOwner");
        BluedStructureExtKt.a(this, viewLifecycleOwner, new PropertyReference1Impl() { // from class: com.soft.blued.ui.user.fragment.VIPSpecialCareFragment$liveDataObserver$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object a(Object obj) {
                return ((SpecialCareState) obj).a();
            }
        }, new Function1<InvisibleToUserModel, Unit>() { // from class: com.soft.blued.ui.user.fragment.VIPSpecialCareFragment$liveDataObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(InvisibleToUserModel it) {
                Intrinsics.e(it, "it");
                VIPSpecialCareFragment.this.a(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(InvisibleToUserModel invisibleToUserModel) {
                a(invisibleToUserModel);
                return Unit.f42314a;
            }
        });
    }
}
