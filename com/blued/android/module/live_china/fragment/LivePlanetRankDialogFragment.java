package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.FragmentLivePlanetRankBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetRankDialogFragment.class */
public final class LivePlanetRankDialogFragment extends BaseDialogFragment {
    public static final Companion a = new Companion(null);
    private final Lazy b = LazyKt.a(new Function0<FragmentLivePlanetRankBinding>() { // from class: com.blued.android.module.live_china.fragment.LivePlanetRankDialogFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final FragmentLivePlanetRankBinding invoke() {
            return FragmentLivePlanetRankBinding.a(LayoutInflater.from(LivePlanetRankDialogFragment.this.getContext()));
        }
    });
    private String c = "";

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetRankDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LivePlanetRankDialogFragment a(Fragment fragment, String tip) {
            Intrinsics.e(fragment, "fragment");
            Intrinsics.e(tip, "tip");
            LivePlanetRankDialogFragment livePlanetRankDialogFragment = new LivePlanetRankDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("tip", tip);
            livePlanetRankDialogFragment.setArguments(bundle);
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "fragment.childFragmentManager");
            livePlanetRankDialogFragment.show(childFragmentManager, LivePlanetRankDialogFragment.class.getSimpleName());
            return livePlanetRankDialogFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LivePlanetRankDialogFragment$MyAdapter.class */
    public static final class MyAdapter extends FragmentStatePagerAdapter {
        private final Context a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyAdapter(Context context, FragmentManager fm) {
            super(fm, 1);
            Intrinsics.e(fm, "fm");
            this.a = context;
        }

        public final Context getContext() {
            return this.a;
        }

        public int getCount() {
            return 2;
        }

        public Fragment getItem(int i) {
            LivePlanetRankItemFragment livePlanetRankItemFragment = new LivePlanetRankItemFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", i);
            livePlanetRankItemFragment.setArguments(bundle);
            return livePlanetRankItemFragment;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LivePlanetRankDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.e().d.setCurrentItem(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LivePlanetRankDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.e().d.setCurrentItem(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LivePlanetRankDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentLivePlanetRankBinding e() {
        return (FragmentLivePlanetRankBinding) this.b.getValue();
    }

    private final void f() {
        Context context = getContext();
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        e().d.setAdapter(new MyAdapter(context, childFragmentManager));
        e().c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetRankDialogFragment$Cn-yTo3pEKSUe1JJ0KZx7VsDFEQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetRankDialogFragment.a(LivePlanetRankDialogFragment.this, view);
            }
        });
        e().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetRankDialogFragment$CmLM3Fap1wepRDXrRz9jMM18C_o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetRankDialogFragment.b(LivePlanetRankDialogFragment.this, view);
            }
        });
        e().d.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.fragment.LivePlanetRankDialogFragment$getData$3
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                FragmentLivePlanetRankBinding e;
                FragmentLivePlanetRankBinding e2;
                FragmentLivePlanetRankBinding e3;
                FragmentLivePlanetRankBinding e4;
                if (i == 0) {
                    e3 = LivePlanetRankDialogFragment.this.e();
                    e3.c.setBackgroundResource(R.drawable.live_planet_rank_title_bg_select);
                    e4 = LivePlanetRankDialogFragment.this.e();
                    e4.b.setBackgroundResource(R.drawable.live_planet_rank_title_bg);
                    return;
                }
                e = LivePlanetRankDialogFragment.this.e();
                e.c.setBackgroundResource(R.drawable.live_planet_rank_title_bg);
                e2 = LivePlanetRankDialogFragment.this.e();
                e2.b.setBackgroundResource(R.drawable.live_planet_rank_title_bg_select);
            }
        });
        e().a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LivePlanetRankDialogFragment$28BY910G5o_EY-4UAW3-zNPWOlw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LivePlanetRankDialogFragment.c(LivePlanetRankDialogFragment.this, view);
            }
        });
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.c = str;
    }

    public final void d() {
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            Intrinsics.a(dialog);
            if (dialog.isShowing()) {
                dismissAllowingStateLoss();
            }
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int a2 = DensityUtils.a(getContext(), 520.0f);
        Dialog dialog = new Dialog(requireActivity(), R.style.transparentFrameWindowStyleLive);
        dialog.requestWindowFeature(1);
        dialog.setContentView(e().getRoot(), new ViewGroup.LayoutParams(-1, a2));
        Window window = dialog.getWindow();
        Intrinsics.a(window);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setWindowAnimations(R.style.main_menu_animstyle);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = a2;
        attributes.gravity = 80;
        dialog.onWindowAttributesChanged(attributes);
        return dialog;
    }

    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        dialog.setContentView(e().getRoot());
        Window window = dialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("tip", "");
            Intrinsics.c(string, "it.getString(\"tip\", \"\")");
            a(string);
        }
        f();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public void show(FragmentManager manager, String str) {
        Intrinsics.e(manager, "manager");
        try {
            FragmentTransaction beginTransaction = manager.beginTransaction();
            Intrinsics.c(beginTransaction, "manager.beginTransaction()");
            beginTransaction.add((Fragment) this, str);
            beginTransaction.commitAllowingStateLoss();
        } catch (Exception e) {
            super.show(manager, str);
        }
    }
}
