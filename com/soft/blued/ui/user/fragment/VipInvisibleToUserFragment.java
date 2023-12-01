package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewbinding.ViewBinding;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.base.dialog.CommonDialogFragment;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentVipInvisibleToUserBinding;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.user.adapter.InvisibleUserDeleteListener;
import com.soft.blued.ui.user.adapter.VipInvisibleListAdapter;
import com.soft.blued.ui.user.model.InvisibleToUserModel;
import com.soft.blued.ui.user.state.VipInvisibleToUserAction;
import com.soft.blued.ui.user.state.VipInvisibleToUserState;
import com.soft.blued.ui.user.viewmodel.VipInvisibleToUserViewModel;
import java.util.ArrayList;
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
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VipInvisibleToUserFragment.class */
public class VipInvisibleToUserFragment extends MVIBaseFragment<VipInvisibleToUserViewModel> {
    static final /* synthetic */ KProperty<Object>[] b = {(KProperty) Reflection.a(new PropertyReference1Impl(VipInvisibleToUserFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/FragmentVipInvisibleToUserBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    public CommonDialogFragment f20482c;
    public VipInvisibleListAdapter d;
    private final ViewBindingProperty e;
    private int f;
    private int g;
    private List<String> h;
    private final Lazy i;

    public VipInvisibleToUserFragment() {
        super((int) R.layout.fragment_vip_invisible_to_user);
        this.e = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<VipInvisibleToUserFragment, FragmentVipInvisibleToUserBinding>() { // from class: com.soft.blued.ui.user.fragment.VipInvisibleToUserFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/user/fragment/VipInvisibleToUserFragment;)Lcom/soft/blued/databinding/FragmentVipInvisibleToUserBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentVipInvisibleToUserBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<VipInvisibleToUserFragment, FragmentVipInvisibleToUserBinding>() { // from class: com.soft.blued.ui.user.fragment.VipInvisibleToUserFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/user/fragment/VipInvisibleToUserFragment;)Lcom/soft/blued/databinding/FragmentVipInvisibleToUserBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentVipInvisibleToUserBinding.a(fragment.requireView());
            }
        });
        this.h = new ArrayList();
        this.i = LazyKt.a(new Function0<NoDataAndLoadFailView>() { // from class: com.soft.blued.ui.user.fragment.VipInvisibleToUserFragment$noDataView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: a */
            public final NoDataAndLoadFailView invoke() {
                return new NoDataAndLoadFailView(VipInvisibleToUserFragment.this.getContext());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VipInvisibleToUserFragment vipInvisibleToUserFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(vipInvisibleToUserFragment, "this$0");
        if (vipInvisibleToUserFragment.a() != null) {
            vipInvisibleToUserFragment.a().dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VipInvisibleToUserFragment vipInvisibleToUserFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(vipInvisibleToUserFragment, "this$0");
        if (!vipInvisibleToUserFragment.h.isEmpty()) {
            BluedStructureExtKt.a(vipInvisibleToUserFragment, new VipInvisibleToUserAction.cancelInvisibleUser(vipInvisibleToUserFragment.h));
        }
        if (vipInvisibleToUserFragment.a() != null) {
            vipInvisibleToUserFragment.a().dismiss();
        }
    }

    public final CommonDialogFragment a() {
        CommonDialogFragment commonDialogFragment = this.f20482c;
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
        this.f20482c = commonDialogFragment;
    }

    public final void a(VipInvisibleListAdapter vipInvisibleListAdapter) {
        Intrinsics.e(vipInvisibleListAdapter, "<set-?>");
        this.d = vipInvisibleListAdapter;
    }

    public final void a(InvisibleToUserModel invisibleToUserModel) {
        Intrinsics.e(invisibleToUserModel, "parseData");
        FragmentVipInvisibleToUserBinding b2 = b();
        if (b2 == null || getContext() == null) {
            return;
        }
        a(invisibleToUserModel.total);
        b(invisibleToUserModel.setTotal);
        TextView textView = b2.f;
        StringBuilder sb = new StringBuilder();
        sb.append(e());
        sb.append('/');
        sb.append(d());
        textView.setText(sb.toString());
        if (invisibleToUserModel.lists != null) {
            c().setNewData(invisibleToUserModel.lists);
            if (invisibleToUserModel.lists.size() == 0) {
                g().a();
            }
        }
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

    public void m() {
        Context context;
        final FragmentVipInvisibleToUserBinding b2 = b();
        if (b2 != null && (context = getContext()) != null) {
            b2.f15334c.c(false);
            b2.f15334c.l(false);
            b2.d.setCenterText(context.getString(R.string.invisible_to_him));
            b2.d.getTitleBackground().setBackground(new ColorDrawable(0));
            b2.d.setRightText((int) R.string.done);
            b2.d.setRightTextColor(2131101766);
            b2.d.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VipInvisibleToUserFragment$Jrp3mGpVZ3v-NTt60WCaiJvS0gY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VipInvisibleToUserFragment.a(VipInvisibleToUserFragment.this, view);
                }
            });
            b2.d.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VipInvisibleToUserFragment$a6S2LkockJJyXkP6U-o8l_ldawc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VipInvisibleToUserFragment.b(VipInvisibleToUserFragment.this, view);
                }
            });
            a(new VipInvisibleListAdapter(context));
            b2.b.setLayoutManager(new LinearLayoutManager(context));
            b2.b.setAdapter(c());
            c().a(new InvisibleUserDeleteListener() { // from class: com.soft.blued.ui.user.fragment.VipInvisibleToUserFragment$initView$1$1$3
                @Override // com.soft.blued.ui.user.adapter.InvisibleUserDeleteListener
                public void a(InvisibleToUserModel.InvisibleUser invisibleUser) {
                    Intrinsics.e(invisibleUser, "user");
                    List<String> f = VipInvisibleToUserFragment.this.f();
                    String str = invisibleUser.uid;
                    Intrinsics.c(str, "user.uid");
                    f.add(str);
                    VipInvisibleToUserFragment.this.c().getData().remove(invisibleUser);
                    if (VipInvisibleToUserFragment.this.c().getData().size() == 0) {
                        VipInvisibleToUserFragment.this.g().a();
                    }
                    VipInvisibleToUserFragment.this.c().notifyDataSetChanged();
                    VipInvisibleToUserFragment vipInvisibleToUserFragment = VipInvisibleToUserFragment.this;
                    vipInvisibleToUserFragment.b(vipInvisibleToUserFragment.e() - 1);
                    TextView textView = b2.f;
                    StringBuilder sb = new StringBuilder();
                    sb.append(VipInvisibleToUserFragment.this.e());
                    sb.append('/');
                    sb.append(VipInvisibleToUserFragment.this.d());
                    textView.setText(sb.toString());
                    EventTrackPersonalProfile.d(PersonalProfileProtos.Event.HIDE_SETTING_SEE_HIDE_LIST_ONE_REMOVE, invisibleUser.uid);
                }
            });
            g().setNoDataImg(2131233630);
            g().setBackgroundColorRes(2131102388);
            g().setTopSpace(DensityUtils.a(getContext(), 40.0f));
            g().d();
            c().setEmptyView((View) g());
        }
        BluedStructureExtKt.a(this, new VipInvisibleToUserAction.getInvisibleUserData(1, 20));
    }

    public void o() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner, "viewLifecycleOwner");
        BluedStructureExtKt.a(this, viewLifecycleOwner, new PropertyReference1Impl() { // from class: com.soft.blued.ui.user.fragment.VipInvisibleToUserFragment$liveDataObserver$1
            public Object a(Object obj) {
                return ((VipInvisibleToUserState) obj).a();
            }
        }, new Function1<InvisibleToUserModel, Unit>() { // from class: com.soft.blued.ui.user.fragment.VipInvisibleToUserFragment$liveDataObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(InvisibleToUserModel invisibleToUserModel) {
                Intrinsics.e(invisibleToUserModel, "it");
                VipInvisibleToUserFragment.this.a(invisibleToUserModel);
            }

            public /* synthetic */ Object invoke(Object obj) {
                a((InvisibleToUserModel) obj);
                return Unit.a;
            }
        });
    }
}
