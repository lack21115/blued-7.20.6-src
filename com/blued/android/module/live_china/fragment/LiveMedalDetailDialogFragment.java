package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveMedalVpAdapter;
import com.blued.android.module.live_china.databinding.DialogLiveMedalDetailBinding;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.model.LiveMedalItemData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMedalDetailDialogFragment.class */
public final class LiveMedalDetailDialogFragment extends LiveCurBaseDialogFragment {
    public static final Companion a = new Companion(null);
    private boolean b;
    private final Lazy c;
    private int d;
    private final Lazy e;
    private final ArrayList<Fragment> f;
    private final ArrayList<LiveMedalItemData> g;
    private final Lazy h;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMedalDetailDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveMedalDetailDialogFragment a(ArrayList<LiveMedalItemData> medalData, int i, FragmentManager manager) {
            Intrinsics.e(medalData, "medalData");
            Intrinsics.e(manager, "manager");
            LiveMedalDetailDialogFragment liveMedalDetailDialogFragment = new LiveMedalDetailDialogFragment(medalData, i);
            liveMedalDetailDialogFragment.show(manager, LiveMedalDetailDialogFragment.class.getSimpleName());
            return liveMedalDetailDialogFragment;
        }
    }

    public LiveMedalDetailDialogFragment() {
        this.c = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<DialogLiveMedalDetailBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveMedalDetailDialogFragment$viewBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final DialogLiveMedalDetailBinding invoke() {
                return DialogLiveMedalDetailBinding.a(LayoutInflater.from(LiveMedalDetailDialogFragment.this.requireContext()));
            }
        });
        this.e = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<ArrayList<LiveMedalItemData>>() { // from class: com.blued.android.module.live_china.fragment.LiveMedalDetailDialogFragment$medalDataList$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final ArrayList<LiveMedalItemData> invoke() {
                return new ArrayList<>();
            }
        });
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LiveMedalVpAdapter>() { // from class: com.blued.android.module.live_china.fragment.LiveMedalDetailDialogFragment$medalDataVpAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveMedalVpAdapter invoke() {
                ArrayList arrayList;
                arrayList = LiveMedalDetailDialogFragment.this.g;
                return new LiveMedalVpAdapter(arrayList);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveMedalDetailDialogFragment(ArrayList<LiveMedalItemData> medalData, int i) {
        this();
        Intrinsics.e(medalData, "medalData");
        this.b = LiveFloatManager.a().C();
        this.d = i;
        k().clear();
        k().addAll(medalData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogLiveMedalDetailBinding it, int i, View view) {
        Intrinsics.e(it, "$it");
        int currentItem = it.e.getCurrentItem() - 1;
        int i2 = currentItem;
        if (currentItem < 0) {
            i2 = i - 1;
        }
        it.e.setCurrentItem(i2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogLiveMedalDetailBinding it, Ref.IntRef curItem) {
        Intrinsics.e(it, "$it");
        Intrinsics.e(curItem, "$curItem");
        it.e.setCurrentItem(curItem.a, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveMedalDetailDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(Ref.FloatRef actionDownX, final DialogLiveMedalDetailBinding it, int i, int i2, View view, MotionEvent motionEvent) {
        int i3;
        Intrinsics.e(actionDownX, "$actionDownX");
        Intrinsics.e(it, "$it");
        int action = motionEvent.getAction();
        if (action == 0) {
            actionDownX.a = motionEvent.getX();
            return false;
        } else if (action != 1) {
            return false;
        } else {
            int currentItem = it.e.getCurrentItem();
            if (currentItem == 0 || currentItem == i - 1) {
                float x = motionEvent.getX();
                if (Math.abs(x - actionDownX.a) > i2) {
                    if (x - actionDownX.a > 0.0f && currentItem != (i3 = i - 1)) {
                        it.e.setCurrentItem(i3, false);
                        return false;
                    } else if (x - actionDownX.a >= 0.0f || currentItem == 0) {
                        return false;
                    } else {
                        final Ref.IntRef intRef = new Ref.IntRef();
                        intRef.a = it.e.getCurrentItem();
                        intRef.a++;
                        int i4 = intRef.a;
                        ViewGroup viewGroup = it.e;
                        Intrinsics.c(viewGroup, "it.vpMedalDetail");
                        if (i4 > viewGroup.getChildCount() - 1) {
                            intRef.a = 0;
                        }
                        it.e.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveMedalDetailDialogFragment$tPr7X4cpp_qXWd6Ku9kt3aNgz2M
                            @Override // java.lang.Runnable
                            public final void run() {
                                LiveMedalDetailDialogFragment.a(DialogLiveMedalDetailBinding.this, intRef);
                            }
                        });
                        return false;
                    }
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DialogLiveMedalDetailBinding it, int i, View view) {
        Intrinsics.e(it, "$it");
        int currentItem = it.e.getCurrentItem() + 1;
        int i2 = currentItem;
        if (currentItem > i - 1) {
            i2 = 0;
        }
        it.e.setCurrentItem(i2, false);
    }

    private final DialogLiveMedalDetailBinding j() {
        return (DialogLiveMedalDetailBinding) this.c.getValue();
    }

    private final ArrayList<LiveMedalItemData> k() {
        return (ArrayList) this.e.getValue();
    }

    private final LiveMedalVpAdapter l() {
        return (LiveMedalVpAdapter) this.h.getValue();
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
        this.g.clear();
        this.f.clear();
        Iterator<LiveMedalItemData> it = k().iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                final DialogLiveMedalDetailBinding j = j();
                j.e.setOffscreenPageLimit(1);
                j.e.setAdapter(l());
                j.a.setViewPager(j.e);
                j.e.setCurrentItem(this.d, false);
                final int size = this.g.size();
                j.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveMedalDetailDialogFragment$UFWdNdhWN1eK6oVjshixLYfIS8A
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LiveMedalDetailDialogFragment.a(DialogLiveMedalDetailBinding.this, size, view);
                    }
                });
                j.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveMedalDetailDialogFragment$_vGFF-nAW1xwezBOIfMPKeM5vqQ
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LiveMedalDetailDialogFragment.b(DialogLiveMedalDetailBinding.this, size, view);
                    }
                });
                j.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveMedalDetailDialogFragment$gl5sk26w8TY1DbPK671Gdak-294
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LiveMedalDetailDialogFragment.a(LiveMedalDetailDialogFragment.this, view);
                    }
                });
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                j.e.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveMedalDetailDialogFragment$g1hCveL1BDFAIQwL69Sqe7Vrhd0
                    @Override // android.view.View.OnTouchListener
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        boolean a2;
                        a2 = LiveMedalDetailDialogFragment.a(Ref.FloatRef.this, j, size, r7, view, motionEvent);
                        return a2;
                    }
                });
                return;
            }
            LiveMedalItemData next = it.next();
            String name = next.getName();
            if (name == null || name.length() == 0) {
                z = true;
            }
            if (!z && next.getType() != -1) {
                this.g.add(next);
            }
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i();
    }
}
