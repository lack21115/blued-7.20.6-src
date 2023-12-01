package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.common.utils.freedom.FreedomItem;
import com.blued.android.module.live_china.databinding.FragmentLuckyBagBinding;
import com.blued.android.module.live_china.fitem.FitemLuckyBagLuckyCome;
import com.blued.android.module.live_china.fitem.FitemLuckyBagSubtitle;
import com.blued.android.module.live_china.fitem.FitemLuckyBagTable;
import com.blued.android.module.live_china.fitem.FitemLuckyBagTableHead;
import com.blued.android.module.live_china.model.LuckyBagLuckyComeModel;
import com.blued.android.module.live_china.model.LuckyBagModel;
import com.blued.android.module.live_china.model.LuckyBagRewardModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveLuckyBagFragment.class */
public final class LiveLuckyBagFragment extends BaseFragment {
    private final LuckyBagModel a;
    private FragmentLuckyBagBinding b;
    private final ArrayList<FreedomItem> c;
    private FreedomAdapter d;

    public LiveLuckyBagFragment(LuckyBagModel model) {
        Intrinsics.e(model, "model");
        this.a = model;
        this.c = new ArrayList<>();
    }

    private final void a() {
        LuckyBagLuckyComeModel break_even = this.a.getBreak_even();
        if (break_even != null && break_even.is_enable()) {
            this.c.add(new FitemLuckyBagLuckyCome(break_even));
        }
        this.c.add(new FitemLuckyBagSubtitle(this.a.getGoods_name()));
        this.c.add(new FitemLuckyBagTableHead());
        ArrayList<LuckyBagRewardModel> reward_settings = this.a.getReward_settings();
        if (reward_settings != null) {
            for (LuckyBagRewardModel luckyBagRewardModel : reward_settings) {
                this.c.add(new FitemLuckyBagTable(luckyBagRewardModel));
            }
        }
        ArrayList<FreedomItem> arrayList = this.c;
        FreedomItem freedomItem = (FreedomItem) CollectionsKt.c((List<? extends Object>) arrayList, arrayList.size() - 1);
        if (freedomItem != null && (freedomItem instanceof FitemLuckyBagTable)) {
            ((FitemLuckyBagTable) freedomItem).a(true);
        }
        b();
        FragmentLuckyBagBinding fragmentLuckyBagBinding = this.b;
        FragmentLuckyBagBinding fragmentLuckyBagBinding2 = fragmentLuckyBagBinding;
        if (fragmentLuckyBagBinding == null) {
            Intrinsics.c("vb");
            fragmentLuckyBagBinding2 = null;
        }
        fragmentLuckyBagBinding2.a.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.android.module.live_china.fragment.LiveLuckyBagFragment$initView$4
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                Intrinsics.e(recyclerView, "recyclerView");
                if (i == 0) {
                    LiveEventBusUtil.b(true);
                } else if (i != 1) {
                } else {
                    LiveEventBusUtil.b(false);
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                Intrinsics.e(recyclerView, "recyclerView");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveLuckyBagFragment this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.a();
    }

    private final void b() {
        FreedomAdapter freedomAdapter = this.d;
        if (freedomAdapter != null) {
            if (freedomAdapter == null) {
                return;
            }
            freedomAdapter.notifyDataSetChanged();
            return;
        }
        this.d = new FreedomAdapter(getContext(), getFragmentActive(), this.c);
        FragmentLuckyBagBinding fragmentLuckyBagBinding = this.b;
        FragmentLuckyBagBinding fragmentLuckyBagBinding2 = fragmentLuckyBagBinding;
        if (fragmentLuckyBagBinding == null) {
            Intrinsics.c("vb");
            fragmentLuckyBagBinding2 = null;
        }
        RecyclerView recyclerView = fragmentLuckyBagBinding2.a;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        FragmentLuckyBagBinding fragmentLuckyBagBinding3 = this.b;
        FragmentLuckyBagBinding fragmentLuckyBagBinding4 = fragmentLuckyBagBinding3;
        if (fragmentLuckyBagBinding3 == null) {
            Intrinsics.c("vb");
            fragmentLuckyBagBinding4 = null;
        }
        RecyclerView recyclerView2 = fragmentLuckyBagBinding4.a;
        if (recyclerView2 != null) {
            recyclerView2.setItemAnimator(new DefaultItemAnimator());
        }
        FragmentLuckyBagBinding fragmentLuckyBagBinding5 = this.b;
        if (fragmentLuckyBagBinding5 == null) {
            Intrinsics.c("vb");
            fragmentLuckyBagBinding5 = null;
        }
        RecyclerView recyclerView3 = fragmentLuckyBagBinding5.a;
        if (recyclerView3 == null) {
            return;
        }
        recyclerView3.setAdapter(this.d);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        FragmentLuckyBagBinding a = FragmentLuckyBagBinding.a(getLayoutInflater(), viewGroup, false);
        Intrinsics.c(a, "inflate(layoutInflater, container, false)");
        this.b = a;
        FragmentLuckyBagBinding fragmentLuckyBagBinding = a;
        if (a == null) {
            Intrinsics.c("vb");
            fragmentLuckyBagBinding = null;
        }
        if (fragmentLuckyBagBinding.getRoot().getParent() != null) {
            FragmentLuckyBagBinding fragmentLuckyBagBinding2 = this.b;
            FragmentLuckyBagBinding fragmentLuckyBagBinding3 = fragmentLuckyBagBinding2;
            if (fragmentLuckyBagBinding2 == null) {
                Intrinsics.c("vb");
                fragmentLuckyBagBinding3 = null;
            }
            ViewParent parent = fragmentLuckyBagBinding3.getRoot().getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ViewGroup viewGroup2 = (ViewGroup) parent;
            FragmentLuckyBagBinding fragmentLuckyBagBinding4 = this.b;
            FragmentLuckyBagBinding fragmentLuckyBagBinding5 = fragmentLuckyBagBinding4;
            if (fragmentLuckyBagBinding4 == null) {
                Intrinsics.c("vb");
                fragmentLuckyBagBinding5 = null;
            }
            viewGroup2.removeView(fragmentLuckyBagBinding5.getRoot());
        }
        FragmentLuckyBagBinding fragmentLuckyBagBinding6 = this.b;
        FragmentLuckyBagBinding fragmentLuckyBagBinding7 = fragmentLuckyBagBinding6;
        if (fragmentLuckyBagBinding6 == null) {
            Intrinsics.c("vb");
            fragmentLuckyBagBinding7 = null;
        }
        fragmentLuckyBagBinding7.a.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveLuckyBagFragment$yA7z21AO_1lIzU-GT4UaJkxp8Bc
            @Override // java.lang.Runnable
            public final void run() {
                LiveLuckyBagFragment.a(LiveLuckyBagFragment.this);
            }
        });
        FragmentLuckyBagBinding fragmentLuckyBagBinding8 = this.b;
        if (fragmentLuckyBagBinding8 == null) {
            Intrinsics.c("vb");
            fragmentLuckyBagBinding8 = null;
        }
        return fragmentLuckyBagBinding8.getRoot();
    }
}
