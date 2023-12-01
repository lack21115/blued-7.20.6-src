package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.live_china.databinding.LiveRandomGiftHostPowerBinding;
import com.blued.android.module.live_china.fitem.randomgift.FitemRandomGiftHostPowerItem;
import com.blued.android.module.live_china.model.RandomGiftHostDialogDataModel;
import com.blued.android.module.live_china.model.RandomGiftItemModel;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveRandomGiftHostPowerFragment.class */
public final class LiveRandomGiftHostPowerFragment extends BaseFragment {
    private LiveRandomGiftHostPowerBinding a;
    private ArrayList<RandomGiftItemModel> b;
    private final ArrayList<FitemRandomGiftHostPowerItem> c = new ArrayList<>();
    private FreedomAdapter d;
    private float e;
    private float f;
    private int g;

    private final void a(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FreedomAdapter freedomAdapter = new FreedomAdapter(getContext(), getFragmentActive(), this.c);
        this.d = freedomAdapter;
        if (freedomAdapter != null) {
            freedomAdapter.b("FragmentManager", getChildFragmentManager());
        }
        FreedomAdapter freedomAdapter2 = this.d;
        if (freedomAdapter2 != null) {
            freedomAdapter2.b("BaseFragment", this);
        }
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(LiveRandomGiftHostPowerFragment this$0, RecyclerView rvList, View view, MotionEvent motionEvent) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(rvList, "$rvList");
        int action = motionEvent.getAction();
        if (action == 0) {
            this$0.e = motionEvent.getX();
            this$0.f = motionEvent.getY();
            view.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
        if (action != 1) {
            int i = 2;
            if (action == 2) {
                if (this$0.g == 0) {
                    float abs = Math.abs(this$0.e - motionEvent.getX());
                    float abs2 = Math.abs(this$0.f - motionEvent.getY());
                    if (abs <= 0.0f || abs2 <= 0.0f) {
                        return false;
                    }
                    if (abs <= abs2) {
                        i = 1;
                    }
                    this$0.g = i;
                    if (i != 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    } else if (motionEvent.getY() > this$0.f) {
                        if (rvList.canScrollVertically(-1)) {
                            view.getParent().requestDisallowInterceptTouchEvent(true);
                            return false;
                        }
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    } else if (rvList.canScrollVertically(1)) {
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                        return false;
                    } else {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    }
                }
                return false;
            } else if (action != 3) {
                return false;
            }
        }
        this$0.e = 0.0f;
        this$0.f = 0.0f;
        this$0.g = 0;
        view.getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    }

    private final void b(final RecyclerView recyclerView) {
        recyclerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveRandomGiftHostPowerFragment$m2CMA9HZgg-WwMQmLLWS8y73XCE
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean a;
                a = LiveRandomGiftHostPowerFragment.a(LiveRandomGiftHostPowerFragment.this, recyclerView, view, motionEvent);
                return a;
            }
        });
    }

    public final ArrayList<RandomGiftItemModel> a() {
        return this.b;
    }

    public final void b() {
        RecyclerView recyclerView;
        Bundle arguments = getArguments();
        if ((arguments == null ? null : arguments.getSerializable("model")) instanceof RandomGiftHostDialogDataModel) {
            Bundle arguments2 = getArguments();
            Serializable serializable = arguments2 == null ? null : arguments2.getSerializable("model");
            if (serializable == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.RandomGiftHostDialogDataModel");
            }
            ArrayList<RandomGiftItemModel> reward_power = ((RandomGiftHostDialogDataModel) serializable).getReward_power();
            if (reward_power != null) {
                this.b = reward_power;
            }
        }
        ArrayList<RandomGiftItemModel> arrayList = this.b;
        if (arrayList == null || arrayList.isEmpty()) {
            LiveRandomGiftHostPowerBinding liveRandomGiftHostPowerBinding = this.a;
            RelativeLayout relativeLayout = liveRandomGiftHostPowerBinding == null ? null : liveRandomGiftHostPowerBinding.b;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            LiveRandomGiftHostPowerBinding liveRandomGiftHostPowerBinding2 = this.a;
            LinearLayout linearLayout = liveRandomGiftHostPowerBinding2 == null ? null : liveRandomGiftHostPowerBinding2.a;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        LiveRandomGiftHostPowerBinding liveRandomGiftHostPowerBinding3 = this.a;
        RelativeLayout relativeLayout2 = liveRandomGiftHostPowerBinding3 == null ? null : liveRandomGiftHostPowerBinding3.b;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        LiveRandomGiftHostPowerBinding liveRandomGiftHostPowerBinding4 = this.a;
        LinearLayout linearLayout2 = liveRandomGiftHostPowerBinding4 == null ? null : liveRandomGiftHostPowerBinding4.a;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        LiveRandomGiftHostPowerBinding liveRandomGiftHostPowerBinding5 = this.a;
        if (liveRandomGiftHostPowerBinding5 == null || (recyclerView = liveRandomGiftHostPowerBinding5.c) == null) {
            return;
        }
        this.c.clear();
        ArrayList<RandomGiftItemModel> a = a();
        if (a != null) {
            for (RandomGiftItemModel randomGiftItemModel : a) {
                this.c.add(new FitemRandomGiftHostPowerItem(randomGiftItemModel));
            }
        }
        a(recyclerView);
        b(recyclerView);
    }

    @Override // com.blued.android.core.ui.BaseFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout root;
        FrameLayout root2;
        Intrinsics.e(inflater, "inflater");
        LiveRandomGiftHostPowerBinding a = LiveRandomGiftHostPowerBinding.a(getLayoutInflater(), viewGroup, false);
        this.a = a;
        if (((a == null || (root = a.getRoot()) == null) ? null : root.getParent()) != null) {
            LiveRandomGiftHostPowerBinding liveRandomGiftHostPowerBinding = this.a;
            ViewParent parent = (liveRandomGiftHostPowerBinding == null || (root2 = liveRandomGiftHostPowerBinding.getRoot()) == null) ? null : root2.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ViewGroup viewGroup2 = (ViewGroup) parent;
            LiveRandomGiftHostPowerBinding liveRandomGiftHostPowerBinding2 = this.a;
            viewGroup2.removeView(liveRandomGiftHostPowerBinding2 == null ? null : liveRandomGiftHostPowerBinding2.getRoot());
        }
        b();
        LiveRandomGiftHostPowerBinding liveRandomGiftHostPowerBinding3 = this.a;
        return liveRandomGiftHostPowerBinding3 == null ? null : liveRandomGiftHostPowerBinding3.getRoot();
    }
}
