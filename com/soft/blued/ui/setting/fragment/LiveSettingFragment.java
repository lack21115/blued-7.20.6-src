package com.soft.blued.ui.setting.fragment;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.viewbinding.ViewBinding;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live_china.model.LiveSettingModel;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentLiveSettingBinding;
import com.soft.blued.ui.setting.vm.LiveSettingViewModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/LiveSettingFragment.class */
public final class LiveSettingFragment extends MVVMBaseFragment<LiveSettingViewModel> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f19705c;
    private String d;
    private int e;
    private String f;
    static final /* synthetic */ KProperty<Object>[] b = {(KProperty) Reflection.a(new PropertyReference1Impl(LiveSettingFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/FragmentLiveSettingBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19704a = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/fragment/LiveSettingFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LiveSettingFragment() {
        super((int) R.layout.fragment_live_setting);
        this.f19705c = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<LiveSettingFragment, FragmentLiveSettingBinding>() { // from class: com.soft.blued.ui.setting.fragment.LiveSettingFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/setting/fragment/LiveSettingFragment;)Lcom/soft/blued/databinding/FragmentLiveSettingBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentLiveSettingBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<LiveSettingFragment, FragmentLiveSettingBinding>() { // from class: com.soft.blued.ui.setting.fragment.LiveSettingFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/setting/fragment/LiveSettingFragment;)Lcom/soft/blued/databinding/FragmentLiveSettingBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentLiveSettingBinding.a(fragment.requireView());
            }
        });
        this.d = "";
        this.f = "至尊贵族及以上用户可使用";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveSettingFragment liveSettingFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(liveSettingFragment, "this$0");
        FragmentActivity activity = liveSettingFragment.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveSettingFragment liveSettingFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(liveSettingFragment, "this$0");
        if (liveSettingFragment.e == 0) {
            ToastUtils.a(liveSettingFragment.f);
        } else {
            WebViewShowInfoFragment.show(liveSettingFragment.getContext(), liveSettingFragment.d);
        }
    }

    public final void a(int i) {
        this.e = i;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public final void a(CompoundButton compoundButton, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.d = str;
    }

    public final void a(List<? extends LiveSettingModel> list) {
        Intrinsics.e(list, "liveSettingList");
        for (LiveSettingModel liveSettingModel : list) {
            Integer valueOf = liveSettingModel == null ? null : Integer.valueOf(liveSettingModel.privilege_type);
            boolean z = false;
            if (valueOf != null && valueOf.intValue() == 3) {
                FragmentLiveSettingBinding p = p();
                ToggleButton toggleButton = p == null ? null : p.b;
                if (toggleButton != null) {
                    toggleButton.setChecked(liveSettingModel.privilege_status == 1);
                }
            } else if (valueOf != null && valueOf.intValue() == 4) {
                FragmentLiveSettingBinding p2 = p();
                ToggleButton toggleButton2 = p2 == null ? null : p2.f15186c;
                if (toggleButton2 != null) {
                    toggleButton2.setChecked(liveSettingModel.privilege_status == 1);
                }
            } else if (valueOf != null && valueOf.intValue() == 2) {
                FragmentLiveSettingBinding p3 = p();
                ToggleButton toggleButton3 = p3 == null ? null : p3.g;
                if (toggleButton3 != null) {
                    toggleButton3.setChecked(liveSettingModel.privilege_status == 1);
                }
            } else if (valueOf != null && valueOf.intValue() == 1) {
                FragmentLiveSettingBinding p4 = p();
                ToggleButton toggleButton4 = p4 == null ? null : p4.f;
                if (toggleButton4 != null) {
                    toggleButton4.setChecked(liveSettingModel.privilege_status == 1);
                }
            } else if (valueOf != null && valueOf.intValue() == 5) {
                FragmentLiveSettingBinding p5 = p();
                ToggleButton toggleButton5 = p5 == null ? null : p5.d;
                if (toggleButton5 != null) {
                    toggleButton5.setChecked(liveSettingModel.privilege_status == 1);
                }
            } else if (valueOf != null && valueOf.intValue() == 6) {
                FragmentLiveSettingBinding p6 = p();
                ToggleButton toggleButton6 = p6 == null ? null : p6.e;
                if (toggleButton6 != null) {
                    toggleButton6.setChecked(liveSettingModel.privilege_status == 1);
                }
            } else if (valueOf != null && valueOf.intValue() == 7) {
                FragmentLiveSettingBinding p7 = p();
                RelativeLayout relativeLayout = p7 == null ? null : p7.f15185a;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
                a(liveSettingModel.privilege_status);
                String str = liveSettingModel.link;
                Intrinsics.c(str, "it.link");
                a(str);
                String str2 = liveSettingModel.text;
                if (!((str2 == null || str2.length() == 0) ? true : true)) {
                    b(liveSettingModel.text);
                }
            }
        }
    }

    public final LiveSettingModel b(int i) {
        MutableLiveData<List<LiveSettingModel>> d;
        List<LiveSettingModel> value;
        LiveSettingViewModel liveSettingViewModel = (LiveSettingViewModel) j();
        if (liveSettingViewModel == null || (d = liveSettingViewModel.d()) == null || (value = d.getValue()) == null) {
            return null;
        }
        for (LiveSettingModel liveSettingModel : value) {
            if (liveSettingModel.privilege_type == i) {
                return liveSettingModel;
            }
        }
        return null;
    }

    public final void b(String str) {
        this.f = str;
    }

    public void f() {
        FragmentLiveSettingBinding p = p();
        if (p != null) {
            p.h.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$LiveSettingFragment$Czrt6qcmHTNxJQZ64ctAegK-iYY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveSettingFragment.a(LiveSettingFragment.this, view);
                }
            });
            p.b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$FbT9clp-qgGKmeGrxE8hxTD92Nc
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    LiveSettingFragment.this.a(compoundButton, z);
                }
            });
            p.f15186c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$FbT9clp-qgGKmeGrxE8hxTD92Nc
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    LiveSettingFragment.this.a(compoundButton, z);
                }
            });
            p.g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$FbT9clp-qgGKmeGrxE8hxTD92Nc
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    LiveSettingFragment.this.a(compoundButton, z);
                }
            });
            p.f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$FbT9clp-qgGKmeGrxE8hxTD92Nc
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    LiveSettingFragment.this.a(compoundButton, z);
                }
            });
            p.d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$FbT9clp-qgGKmeGrxE8hxTD92Nc
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    LiveSettingFragment.this.a(compoundButton, z);
                }
            });
            p.e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$FbT9clp-qgGKmeGrxE8hxTD92Nc
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    LiveSettingFragment.this.a(compoundButton, z);
                }
            });
            p.f15185a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$LiveSettingFragment$aF6b12UiaAxOYCssjlN3v4XsnNc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveSettingFragment.b(LiveSettingFragment.this, view);
                }
            });
        }
        LiveSettingViewModel liveSettingViewModel = (LiveSettingViewModel) a();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        liveSettingViewModel.a(fragmentActive);
    }

    public void g() {
    }

    public final int getType(int i) {
        ToggleButton toggleButton;
        ToggleButton toggleButton2;
        ToggleButton toggleButton3;
        ToggleButton toggleButton4;
        ToggleButton toggleButton5;
        ToggleButton toggleButton6;
        FragmentLiveSettingBinding p = p();
        if ((p == null || (toggleButton = p.b) == null || i != toggleButton.getId()) ? false : true) {
            return 3;
        }
        FragmentLiveSettingBinding p2 = p();
        if ((p2 == null || (toggleButton2 = p2.f15186c) == null || i != toggleButton2.getId()) ? false : true) {
            return 4;
        }
        FragmentLiveSettingBinding p3 = p();
        if ((p3 == null || (toggleButton3 = p3.g) == null || i != toggleButton3.getId()) ? false : true) {
            return 2;
        }
        FragmentLiveSettingBinding p4 = p();
        if ((p4 == null || (toggleButton4 = p4.f) == null || i != toggleButton4.getId()) ? false : true) {
            return 1;
        }
        FragmentLiveSettingBinding p5 = p();
        if ((p5 == null || (toggleButton5 = p5.d) == null || i != toggleButton5.getId()) ? false : true) {
            return 5;
        }
        FragmentLiveSettingBinding p6 = p();
        return p6 != null && (toggleButton6 = p6.e) != null && i == toggleButton6.getId() ? 6 : -1;
    }

    public void l() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LiveSettingViewModel liveSettingViewModel = (LiveSettingViewModel) j();
        LifecycleExtKt.a(lifecycleOwner, liveSettingViewModel == null ? null : liveSettingViewModel.d(), new LiveSettingFragment$liveDataObserver$1(this));
    }

    public final FragmentLiveSettingBinding p() {
        return (FragmentLiveSettingBinding) this.f19705c.b(this, b[0]);
    }
}
