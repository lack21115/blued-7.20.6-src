package com.blued.android.module.live_china.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveVp2Adapter;
import com.blued.android.module.live_china.databinding.DialogLiveOnlineUserBinding;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveNobleConfigModel;
import com.blued.android.module.live_china.model.LiveOnLineUserCountModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveOnlineUserDialogFragment.class */
public final class LiveOnlineUserDialogFragment extends LiveCurBaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13080a = new Companion(null);
    private final Lazy b = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<DialogLiveOnlineUserBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveOnlineUserDialogFragment$viewBinding$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final DialogLiveOnlineUserBinding invoke() {
            return DialogLiveOnlineUserBinding.a(LayoutInflater.from(LiveOnlineUserDialogFragment.this.getContext()));
        }
    });

    /* renamed from: c  reason: collision with root package name */
    private final Lazy f13081c = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LiveVp2Adapter>() { // from class: com.blued.android.module.live_china.fragment.LiveOnlineUserDialogFragment$vp2Adapter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveVp2Adapter invoke() {
            FragmentManager childFragmentManager = LiveOnlineUserDialogFragment.this.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "childFragmentManager");
            Lifecycle lifecycle = LiveOnlineUserDialogFragment.this.getLifecycle();
            Intrinsics.c(lifecycle, "lifecycle");
            return new LiveVp2Adapter(childFragmentManager, lifecycle, LiveOnlineUserDialogFragment.this.i());
        }
    });
    private final ArrayList<Fragment> d = new ArrayList<>();

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveOnlineUserDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveOnlineUserDialogFragment a(FragmentManager manager) {
            Intrinsics.e(manager, "manager");
            LiveOnlineUserDialogFragment liveOnlineUserDialogFragment = new LiveOnlineUserDialogFragment();
            liveOnlineUserDialogFragment.show(manager, LiveOnlineUserDialogFragment.class.getSimpleName());
            return liveOnlineUserDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogLiveOnlineUserBinding this_run, View view) {
        Intrinsics.e(this_run, "$this_run");
        this_run.h.setCurrentItem(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveOnlineUserDialogFragment this$0, LiveOnLineUserCountModel liveOnLineUserCountModel) {
        Intrinsics.e(this$0, "this$0");
        if (liveOnLineUserCountModel == null) {
            return;
        }
        this$0.n().f.setText(liveOnLineUserCountModel.getOnLineUserCount());
        this$0.n().d.setText(liveOnLineUserCountModel.getOnLineNobleUserCount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveOnlineUserDialogFragment this$0, Boolean bool) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DialogLiveOnlineUserBinding this_run, View view) {
        Intrinsics.e(this_run, "$this_run");
        this_run.h.setCurrentItem(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(DialogLiveOnlineUserBinding this_run, View view) {
        Intrinsics.e(this_run, "$this_run");
        this_run.h.setCurrentItem(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(DialogLiveOnlineUserBinding this_run, View view) {
        Intrinsics.e(this_run, "$this_run");
        this_run.h.setCurrentItem(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DialogLiveOnlineUserBinding n() {
        return (DialogLiveOnlineUserBinding) this.b.getValue();
    }

    @Override // com.blued.android.module.live_china.fragment.LiveCurBaseDialogFragment
    public View d() {
        ShapeRelativeLayout root = n().getRoot();
        Intrinsics.c(root, "viewBinding.root");
        return root;
    }

    @Override // com.blued.android.module.live_china.fragment.LiveCurBaseDialogFragment
    public float e() {
        return 512.0f;
    }

    @Override // com.blued.android.module.live_china.fragment.LiveCurBaseDialogFragment
    public void f() {
        j();
        k();
        l();
    }

    @Override // com.blued.android.module.live_china.fragment.LiveCurBaseDialogFragment
    public int g() {
        return R.drawable.shape_live_online_user_bg_top_radius;
    }

    public final LiveVp2Adapter h() {
        return (LiveVp2Adapter) this.f13081c.getValue();
    }

    public final ArrayList<Fragment> i() {
        return this.d;
    }

    public final void j() {
        final DialogLiveOnlineUserBinding n = n();
        n.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveOnlineUserDialogFragment$lRxIQ4H2I54hc0TcZKuSVkIyWfo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveOnlineUserDialogFragment.a(DialogLiveOnlineUserBinding.this, view);
            }
        });
        n.f.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveOnlineUserDialogFragment$8jc5VgS9hbW38N92EEytM65Qe7w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveOnlineUserDialogFragment.b(DialogLiveOnlineUserBinding.this, view);
            }
        });
        n.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveOnlineUserDialogFragment$RPeyTIP0siraZqwkVOI_k6xFOQk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveOnlineUserDialogFragment.c(DialogLiveOnlineUserBinding.this, view);
            }
        });
        n.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveOnlineUserDialogFragment$XjkJN_5KMGdkghuc6M-Vrympl_M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveOnlineUserDialogFragment.d(DialogLiveOnlineUserBinding.this, view);
            }
        });
        i().add(new LiveOnlineUserFragment());
        if (LiveRoomManager.a().p().noble_config == 1) {
            DialogLiveOnlineUserBinding n2 = n();
            TextView tvOnlineNobleUserTitle = n2.e;
            Intrinsics.c(tvOnlineNobleUserTitle, "tvOnlineNobleUserTitle");
            BluedViewExKt.b(tvOnlineNobleUserTitle);
            TextView tvOnlineNobleUserCount = n2.d;
            Intrinsics.c(tvOnlineNobleUserCount, "tvOnlineNobleUserCount");
            BluedViewExKt.b(tvOnlineNobleUserCount);
            i().add(new LiveOnlineNobleUserFragment());
        }
        n.h.setAdapter(h());
        n.h.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.blued.android.module.live_china.fragment.LiveOnlineUserDialogFragment$initView$1$6
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                if (i == 0) {
                    ShapeTextView stvOnlineNobleUserSelBar = DialogLiveOnlineUserBinding.this.b;
                    Intrinsics.c(stvOnlineNobleUserSelBar, "stvOnlineNobleUserSelBar");
                    BluedViewExKt.a(stvOnlineNobleUserSelBar);
                    ShapeTextView stvOnlineUserSelBar = DialogLiveOnlineUserBinding.this.f11793c;
                    Intrinsics.c(stvOnlineUserSelBar, "stvOnlineUserSelBar");
                    BluedViewExKt.b(stvOnlineUserSelBar);
                } else if (i != 1) {
                } else {
                    ShapeTextView stvOnlineUserSelBar2 = DialogLiveOnlineUserBinding.this.f11793c;
                    Intrinsics.c(stvOnlineUserSelBar2, "stvOnlineUserSelBar");
                    BluedViewExKt.a(stvOnlineUserSelBar2);
                    ShapeTextView stvOnlineNobleUserSelBar2 = DialogLiveOnlineUserBinding.this.b;
                    Intrinsics.c(stvOnlineNobleUserSelBar2, "stvOnlineNobleUserSelBar");
                    BluedViewExKt.b(stvOnlineNobleUserSelBar2);
                }
            }
        });
    }

    public final void k() {
        m();
    }

    public final void l() {
        LiveOnlineUserDialogFragment liveOnlineUserDialogFragment = this;
        LiveEventBus.get("update_online_user_count", LiveOnLineUserCountModel.class).observe(liveOnlineUserDialogFragment, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveOnlineUserDialogFragment$dzEDp6FGf-87xx9ej7Oi6iW5GlI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveOnlineUserDialogFragment.a(LiveOnlineUserDialogFragment.this, (LiveOnLineUserCountModel) obj);
            }
        });
        LiveEventBus.get("close_online_user_dialog", Boolean.TYPE).observe(liveOnlineUserDialogFragment, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveOnlineUserDialogFragment$M9PhcF1mS5eUWF0hbNK2aYgoczE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveOnlineUserDialogFragment.a(LiveOnlineUserDialogFragment.this, (Boolean) obj);
            }
        });
    }

    public final void m() {
        String e = LiveRoomManager.a().e();
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.n(e, new BluedUIHttpResponse<BluedEntity<?, LiveNobleConfigModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveOnlineUserDialogFragment$getNobleConfig$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<?, LiveNobleConfigModel> bluedEntity) {
                DialogLiveOnlineUserBinding n;
                if (isActive() && bluedEntity != null) {
                    LiveOnlineUserDialogFragment liveOnlineUserDialogFragment = LiveOnlineUserDialogFragment.this;
                    if (bluedEntity.extra.getHas_target_noble() != 1 || liveOnlineUserDialogFragment.i().size() <= 1) {
                        return;
                    }
                    n = liveOnlineUserDialogFragment.n();
                    n.h.setCurrentItem(1);
                }
            }
        }, a());
    }
}
