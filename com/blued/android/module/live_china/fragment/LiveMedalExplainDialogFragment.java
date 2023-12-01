package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveMedalDescAdapter;
import com.blued.android.module.live_china.databinding.DialogLiveMedalExplainBinding;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMedalExplainDialogFragment.class */
public final class LiveMedalExplainDialogFragment extends LiveCurBaseDialogFragment {
    public static final Companion a = new Companion(null);
    private boolean b;
    private final ArrayList<String> c;
    private String d;
    private final Lazy e;
    private final Lazy f;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMedalExplainDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveMedalExplainDialogFragment a(FragmentManager manager, String uid, ArrayList<String> arrayList) {
            Intrinsics.e(manager, "manager");
            Intrinsics.e(uid, "uid");
            LiveMedalExplainDialogFragment liveMedalExplainDialogFragment = new LiveMedalExplainDialogFragment(arrayList, uid);
            liveMedalExplainDialogFragment.show(manager, LiveMedalExplainDialogFragment.class.getSimpleName());
            return liveMedalExplainDialogFragment;
        }
    }

    public LiveMedalExplainDialogFragment() {
        this.c = new ArrayList<>();
        this.e = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<DialogLiveMedalExplainBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveMedalExplainDialogFragment$viewBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final DialogLiveMedalExplainBinding invoke() {
                return DialogLiveMedalExplainBinding.a(LayoutInflater.from(LiveMedalExplainDialogFragment.this.requireContext()));
            }
        });
        this.f = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LiveMedalDescAdapter>() { // from class: com.blued.android.module.live_china.fragment.LiveMedalExplainDialogFragment$liveMedalDescAdapter$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveMedalDescAdapter invoke() {
                return new LiveMedalDescAdapter();
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveMedalExplainDialogFragment(ArrayList<String> arrayList, String uid) {
        this();
        Intrinsics.e(uid, "uid");
        this.d = uid;
        this.b = LiveFloatManager.a().C();
        this.c.clear();
        if (arrayList == null) {
            return;
        }
        this.c.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveMedalExplainDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final DialogLiveMedalExplainBinding j() {
        return (DialogLiveMedalExplainBinding) this.e.getValue();
    }

    private final LiveMedalDescAdapter k() {
        return (LiveMedalDescAdapter) this.f.getValue();
    }

    @Override // com.blued.android.module.live_china.fragment.LiveCurBaseDialogFragment
    public float e() {
        return 384.0f;
    }

    @Override // com.blued.android.module.live_china.fragment.LiveCurBaseDialogFragment
    public void f() {
    }

    @Override // com.blued.android.module.live_china.fragment.LiveCurBaseDialogFragment
    public int g() {
        return R.drawable.shape_live_medal_wall_bg_top_radius;
    }

    @Override // com.blued.android.module.live_china.fragment.LiveCurBaseDialogFragment
    /* renamed from: h */
    public FrameLayout d() {
        FrameLayout root = j().getRoot();
        Intrinsics.c(root, "viewBinding.root");
        return root;
    }

    public final void i() {
        DialogLiveMedalExplainBinding j = j();
        j.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveMedalExplainDialogFragment$Q3Scdo0B4dNQceL5chBwZ2ET1b8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveMedalExplainDialogFragment.a(LiveMedalExplainDialogFragment.this, view);
            }
        });
        j.a.setLayoutManager(new LinearLayoutManager(requireContext()));
        j.a.setHasFixedSize(true);
        k().setNewData(this.c);
        j.a.setAdapter(k());
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EventTrackLive.u(LiveProtos.Event.LIVE_MEDAL_WALL_EXPLAIN_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this.d);
        i();
    }
}
