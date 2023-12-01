package com.soft.blued.ui.setting.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.common.base.config.ListConfig;
import com.blued.android.module.common.base.mvi.BaseListAction;
import com.blued.android.module.common.base.mvi.BaseListFragment;
import com.blued.android.module.common.base.mvi.BaseListState;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.databinding.FmServiceCenterBinding;
import com.soft.blued.ui.setting.adapter.SystemPermissionAdapter;
import com.soft.blued.ui.setting.model.PermissionModel;
import com.soft.blued.ui.setting.vm.SystemPermissionVM;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/SystemPermissionFragment.class */
public final class SystemPermissionFragment extends BaseListFragment<SystemPermissionVM, PermissionModel> {
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(SystemPermissionFragment.class, "vb", "getVb()Lcom/soft/blued/databinding/FmServiceCenterBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f33618c;

    public SystemPermissionFragment() {
        super(R.layout.fm_service_center);
        this.f33618c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<SystemPermissionFragment, FmServiceCenterBinding>() { // from class: com.soft.blued.ui.setting.fragment.SystemPermissionFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmServiceCenterBinding invoke(SystemPermissionFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmServiceCenterBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<SystemPermissionFragment, FmServiceCenterBinding>() { // from class: com.soft.blued.ui.setting.fragment.SystemPermissionFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmServiceCenterBinding invoke(SystemPermissionFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmServiceCenterBinding.a(fragment.requireView());
            }
        });
    }

    private final FmServiceCenterBinding D() {
        return (FmServiceCenterBinding) this.f33618c.b(this, b[0]);
    }

    private final void E() {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        FragmentActivity activity = getActivity();
        intent.setData(Uri.parse(Intrinsics.a("package:", (Object) (activity == null ? null : activity.getPackageName()))));
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.startActivity(intent);
        }
        EventTrackSettings.a(SettingsProtos.Event.MINE_SETTINGS_PRIVACY_GO_SETTINGS_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(SystemPermissionFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SystemPermissionFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.E();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    /* renamed from: C */
    public SystemPermissionAdapter i() {
        return new SystemPermissionAdapter();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public ListConfig h() {
        return new ListConfig.Builder().c(false).b(false).a(false).a();
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment
    public void j() {
        super.j();
        FmServiceCenterBinding D = D();
        a(D == null ? null : D.f28768c);
        FmServiceCenterBinding D2 = D();
        a(D2 == null ? null : D2.b);
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListFragment, com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        ImageView leftImg;
        CommonTopTitleNoTrans commonTopTitleNoTrans2;
        super.m();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner, "viewLifecycleOwner");
        BluedStructureExtKt.a(this, viewLifecycleOwner, new PropertyReference1Impl() { // from class: com.soft.blued.ui.setting.fragment.SystemPermissionFragment$initView$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object a(Object obj) {
                return ((BaseListState) obj).a();
            }
        }, new Function1<List<? extends PermissionModel>, Unit>() { // from class: com.soft.blued.ui.setting.fragment.SystemPermissionFragment$initView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(List<PermissionModel> it) {
                BaseQuickAdapter f;
                Intrinsics.e(it, "it");
                f = SystemPermissionFragment.this.f();
                f.setNewData(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(List<? extends PermissionModel> list) {
                a(list);
                return Unit.f42314a;
            }
        });
        FmServiceCenterBinding D = D();
        if (D != null && (commonTopTitleNoTrans2 = D.d) != null) {
            commonTopTitleNoTrans2.setCenterText(getString(R.string.system_permissions));
        }
        FmServiceCenterBinding D2 = D();
        if (D2 != null && (commonTopTitleNoTrans = D2.d) != null && (leftImg = commonTopTitleNoTrans.getLeftImg()) != null) {
            leftImg.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$SystemPermissionFragment$ZFgOggfaOm1eLmHLXhS5HdNnBa0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SystemPermissionFragment.a(SystemPermissionFragment.this, view);
                }
            });
        }
        FmServiceCenterBinding D3 = D();
        TextView textView = D3 == null ? null : D3.e;
        if (textView != null) {
            textView.setText(getString(R.string.system_permissions_hint));
        }
        ((TextView) requireView().findViewById(2131371023)).setText(getString(R.string.system_to_setting));
        ((ShapeRelativeLayout) requireView().findViewById(R.id.btn_service)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$SystemPermissionFragment$hIP5LDF-CvstkJ70R9TXjrM7q5w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SystemPermissionFragment.b(SystemPermissionFragment.this, view);
            }
        });
        Context context = getContext();
        if (context == null) {
            return;
        }
        FmServiceCenterBinding D4 = D();
        if (D4 != null && (recyclerView2 = D4.f28768c) != null) {
            recyclerView2.setBackgroundColor(ContextCompat.getColor(context, 2131102388));
        }
        FmServiceCenterBinding D5 = D();
        if (D5 == null || (recyclerView = D5.f28768c) == null) {
            return;
        }
        recyclerView.setPadding(0, 0, 0, 0);
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ((SystemPermissionVM) y()).dispatchAction(BaseListAction.RefreshData.f10668a);
    }
}
