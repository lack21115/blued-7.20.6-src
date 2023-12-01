package com.soft.blued.ui.setting.fragment;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
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
import java.util.Iterator;
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
    private final ViewBindingProperty f33396c;
    private String d;
    private int e;
    private String f;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(LiveSettingFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/FragmentLiveSettingBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f33395a = new Companion(null);

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
        super(R.layout.fragment_live_setting);
        this.f33396c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<LiveSettingFragment, FragmentLiveSettingBinding>() { // from class: com.soft.blued.ui.setting.fragment.LiveSettingFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentLiveSettingBinding invoke(LiveSettingFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentLiveSettingBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<LiveSettingFragment, FragmentLiveSettingBinding>() { // from class: com.soft.blued.ui.setting.fragment.LiveSettingFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentLiveSettingBinding invoke(LiveSettingFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentLiveSettingBinding.a(fragment.requireView());
            }
        });
        this.d = "";
        this.f = "至尊贵族及以上用户可使用";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveSettingFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveSettingFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        if (this$0.e == 0) {
            ToastUtils.a(this$0.f);
        } else {
            WebViewShowInfoFragment.show(this$0.getContext(), this$0.d);
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

    public final void a(List<? extends LiveSettingModel> liveSettingList) {
        Intrinsics.e(liveSettingList, "liveSettingList");
        Iterator<? extends LiveSettingModel> it = liveSettingList.iterator();
        while (it.hasNext()) {
            LiveSettingModel next = it.next();
            Integer valueOf = next == null ? null : Integer.valueOf(next.privilege_type);
            boolean z = false;
            boolean z2 = false;
            if (valueOf != null && valueOf.intValue() == 3) {
                FragmentLiveSettingBinding p = p();
                ToggleButton toggleButton = p == null ? null : p.b;
                if (toggleButton != null) {
                    if (next.privilege_status == 1) {
                        z2 = true;
                    }
                    toggleButton.setChecked(z2);
                }
            } else if (valueOf != null && valueOf.intValue() == 4) {
                FragmentLiveSettingBinding p2 = p();
                ToggleButton toggleButton2 = p2 == null ? null : p2.f28876c;
                if (toggleButton2 != null) {
                    boolean z3 = false;
                    if (next.privilege_status == 1) {
                        z3 = true;
                    }
                    toggleButton2.setChecked(z3);
                }
            } else if (valueOf != null && valueOf.intValue() == 2) {
                FragmentLiveSettingBinding p3 = p();
                ToggleButton toggleButton3 = p3 == null ? null : p3.g;
                if (toggleButton3 != null) {
                    boolean z4 = false;
                    if (next.privilege_status == 1) {
                        z4 = true;
                    }
                    toggleButton3.setChecked(z4);
                }
            } else if (valueOf != null && valueOf.intValue() == 1) {
                FragmentLiveSettingBinding p4 = p();
                ToggleButton toggleButton4 = p4 == null ? null : p4.f;
                if (toggleButton4 != null) {
                    boolean z5 = false;
                    if (next.privilege_status == 1) {
                        z5 = true;
                    }
                    toggleButton4.setChecked(z5);
                }
            } else if (valueOf != null && valueOf.intValue() == 5) {
                FragmentLiveSettingBinding p5 = p();
                ToggleButton toggleButton5 = p5 == null ? null : p5.d;
                if (toggleButton5 != null) {
                    boolean z6 = false;
                    if (next.privilege_status == 1) {
                        z6 = true;
                    }
                    toggleButton5.setChecked(z6);
                }
            } else if (valueOf != null && valueOf.intValue() == 6) {
                FragmentLiveSettingBinding p6 = p();
                ToggleButton toggleButton6 = p6 == null ? null : p6.e;
                if (toggleButton6 != null) {
                    boolean z7 = false;
                    if (next.privilege_status == 1) {
                        z7 = true;
                    }
                    toggleButton6.setChecked(z7);
                }
            } else if (valueOf != null && valueOf.intValue() == 7) {
                FragmentLiveSettingBinding p7 = p();
                RelativeLayout relativeLayout = p7 == null ? null : p7.f28875a;
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(0);
                }
                a(next.privilege_status);
                String str = next.link;
                Intrinsics.c(str, "it.link");
                a(str);
                String str2 = next.text;
                if (str2 == null || str2.length() == 0) {
                    z = true;
                }
                if (!z) {
                    b(next.text);
                }
            }
        }
    }

    public final LiveSettingModel b(int i) {
        MutableLiveData<List<LiveSettingModel>> d;
        List<LiveSettingModel> value;
        LiveSettingViewModel j = j();
        if (j == null || (d = j.d()) == null || (value = d.getValue()) == null) {
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

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
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
            p.f28876c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$FbT9clp-qgGKmeGrxE8hxTD92Nc
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
            p.f28875a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.setting.fragment.-$$Lambda$LiveSettingFragment$aF6b12UiaAxOYCssjlN3v4XsnNc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveSettingFragment.b(LiveSettingFragment.this, view);
                }
            });
        }
        LiveSettingViewModel a2 = a();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        a2.a(fragmentActive);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
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
        if ((p2 == null || (toggleButton2 = p2.f28876c) == null || i != toggleButton2.getId()) ? false : true) {
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

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        LiveSettingFragment liveSettingFragment = this;
        LiveSettingViewModel j = j();
        LifecycleExtKt.a(liveSettingFragment, j == null ? null : j.d(), new LiveSettingFragment$liveDataObserver$1(this));
    }

    public final FragmentLiveSettingBinding p() {
        return (FragmentLiveSettingBinding) this.f33396c.b(this, b[0]);
    }
}
