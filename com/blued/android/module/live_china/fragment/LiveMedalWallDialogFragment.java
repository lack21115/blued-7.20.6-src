package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveMedalListAdapter;
import com.blued.android.module.live_china.adapter.LiveVp2Adapter;
import com.blued.android.module.live_china.databinding.DialogLiveMedalWallBinding;
import com.blued.android.module.live_china.fragment.LiveMedalDetailDialogFragment;
import com.blued.android.module.live_china.fragment.LiveMedalExplainDialogFragment;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveMedalData;
import com.blued.android.module.live_china.model.LiveMedalItemData;
import com.blued.android.module.live_china.model.LiveRoomUserModel;
import com.blued.android.module.live_china.presenter.LiveMedalWallPresenter;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.das.live.LiveProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMedalWallDialogFragment.class */
public final class LiveMedalWallDialogFragment extends LiveCurBaseDialogFragment {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13060a = new Companion(null);
    private IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13061c;
    private boolean d;
    private final Lazy e;
    private final Lazy f;
    private final Lazy g;
    private final Lazy h;
    private final ArrayList<Fragment> i;
    private final Lazy j;
    private LiveRoomUserModel k;
    private LiveMedalData l;
    private int m;
    private final Lazy n;
    private final ArrayList<LiveMedalItemData> o;
    private final HashMap<Integer, ArrayList<LiveMedalItemData>> p;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveMedalWallDialogFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveMedalWallDialogFragment a(LiveRoomUserModel liveRoomUserModel, FragmentManager manager, BaseFragment fragment) {
            Intrinsics.e(manager, "manager");
            Intrinsics.e(fragment, "fragment");
            LiveMedalWallDialogFragment liveMedalWallDialogFragment = new LiveMedalWallDialogFragment(fragment, liveRoomUserModel);
            liveMedalWallDialogFragment.show(manager, LiveMedalWallDialogFragment.class.getSimpleName());
            return liveMedalWallDialogFragment;
        }
    }

    public LiveMedalWallDialogFragment() {
        this.e = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<DialogLiveMedalWallBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveMedalWallDialogFragment$viewBinding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final DialogLiveMedalWallBinding invoke() {
                return DialogLiveMedalWallBinding.a(LayoutInflater.from(LiveMedalWallDialogFragment.this.requireContext()));
            }
        });
        this.f = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<String>() { // from class: com.blued.android.module.live_china.fragment.LiveMedalWallDialogFragment$anchorMedalStr$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final String invoke() {
                String string = LiveMedalWallDialogFragment.this.getString(R.string.live_medal_anchor);
                Intrinsics.c(string, "getString(R.string.live_medal_anchor)");
                return string;
            }
        });
        this.g = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<String>() { // from class: com.blued.android.module.live_china.fragment.LiveMedalWallDialogFragment$userMedalStr$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final String invoke() {
                String string = LiveMedalWallDialogFragment.this.getString(R.string.live_medal_user);
                Intrinsics.c(string, "getString(R.string.live_medal_user)");
                return string;
            }
        });
        this.h = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LiveMedalWallPresenter>() { // from class: com.blued.android.module.live_china.fragment.LiveMedalWallDialogFragment$presenter$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveMedalWallPresenter invoke() {
                return new LiveMedalWallPresenter();
            }
        });
        this.i = new ArrayList<>();
        this.j = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LiveVp2Adapter>() { // from class: com.blued.android.module.live_china.fragment.LiveMedalWallDialogFragment$medalWallVpAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveVp2Adapter invoke() {
                ArrayList arrayList;
                FragmentManager childFragmentManager = LiveMedalWallDialogFragment.this.getChildFragmentManager();
                Intrinsics.c(childFragmentManager, "childFragmentManager");
                Lifecycle lifecycle = LiveMedalWallDialogFragment.this.getLifecycle();
                Intrinsics.c(lifecycle, "lifecycle");
                arrayList = LiveMedalWallDialogFragment.this.i;
                return new LiveVp2Adapter(childFragmentManager, lifecycle, arrayList);
            }
        });
        this.n = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0<LiveMedalListAdapter>() { // from class: com.blued.android.module.live_china.fragment.LiveMedalWallDialogFragment$medalListAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveMedalListAdapter invoke() {
                IRequestHost iRequestHost;
                iRequestHost = LiveMedalWallDialogFragment.this.b;
                return new LiveMedalListAdapter(iRequestHost);
            }
        });
        this.o = new ArrayList<>();
        this.p = new HashMap<>();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveMedalWallDialogFragment(BaseFragment fragment, LiveRoomUserModel liveRoomUserModel) {
        this();
        Intrinsics.e(fragment, "fragment");
        this.k = liveRoomUserModel;
        this.b = fragment.getFragmentActive();
        this.f13061c = LiveFloatManager.a().C();
        this.d = TextUtils.equals(liveRoomUserModel == null ? null : liveRoomUserModel.uid, LiveRoomManager.a().g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveMedalWallDialogFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (ClickUtils.a(view.getId())) {
            return;
        }
        LiveMedalExplainDialogFragment.Companion companion = LiveMedalExplainDialogFragment.f13056a;
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        LiveRoomUserModel liveRoomUserModel = this$0.k;
        String valueOf = String.valueOf(liveRoomUserModel == null ? null : liveRoomUserModel.uid);
        LiveMedalData liveMedalData = this$0.l;
        companion.a(childFragmentManager, valueOf, liveMedalData == null ? null : liveMedalData.getDesc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveMedalWallDialogFragment this$0, TextView leftTvIt, DialogLiveMedalWallBinding this_run, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(leftTvIt, "$leftTvIt");
        Intrinsics.e(this_run, "$this_run");
        this$0.q();
        if (this$0.m == 0) {
            return;
        }
        this$0.m = 0;
        this$0.s();
        leftTvIt.setAlpha(1.0f);
        this_run.i.setAlpha(0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveMedalWallDialogFragment this$0, LiveMedalData liveMedalData) {
        String str;
        Intrinsics.e(this$0, "this$0");
        this$0.l = liveMedalData;
        ArrayList<LiveMedalItemData> anchor = liveMedalData.getAnchor();
        String str2 = " (0)";
        if (anchor == null || anchor.isEmpty()) {
            str = " (0)";
        } else {
            str = " (" + liveMedalData.getAnchor().size() + ')';
        }
        ArrayList<LiveMedalItemData> user = liveMedalData.getUser();
        if (!(user == null || user.isEmpty())) {
            str2 = " (" + liveMedalData.getUser().size() + ')';
        }
        String a2 = this$0.d ? Intrinsics.a(this$0.l(), (Object) str) : Intrinsics.a(this$0.m(), (Object) str2);
        String a3 = this$0.d ? Intrinsics.a(this$0.m(), (Object) str2) : Intrinsics.a(this$0.l(), (Object) str);
        this$0.p.put(0, this$0.d ? liveMedalData.getAnchor() : liveMedalData.getUser());
        this$0.p.put(1, this$0.d ? liveMedalData.getUser() : liveMedalData.getAnchor());
        this$0.s();
        DialogLiveMedalWallBinding k = this$0.k();
        k.h.setText(a2);
        k.i.setText(a3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveMedalWallDialogFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        if (ClickUtils.a(view.getId())) {
            return;
        }
        String name = this$0.o.get(i).getName();
        if ((name == null || name.length() == 0) && this$0.o.get(i).getType() == -1) {
            return;
        }
        LiveProtos.Event event = LiveProtos.Event.LIVE_MEDAL_WALL_ONE_CLICK;
        String badge_id = this$0.o.get(i).getBadge_id();
        String e = LiveRoomManager.a().e();
        String g = LiveRoomManager.a().g();
        LiveRoomUserModel liveRoomUserModel = this$0.k;
        EventTrackLive.h(event, badge_id, e, g, liveRoomUserModel == null ? null : liveRoomUserModel.uid);
        LiveMedalDetailDialogFragment.Companion companion = LiveMedalDetailDialogFragment.f13051a;
        ArrayList<LiveMedalItemData> arrayList = this$0.o;
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        companion.a(arrayList, i, childFragmentManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveMedalWallDialogFragment this$0, TextView rightTvIt, DialogLiveMedalWallBinding this_run, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(rightTvIt, "$rightTvIt");
        Intrinsics.e(this_run, "$this_run");
        this$0.r();
        if (this$0.m == 1) {
            return;
        }
        this$0.m = 1;
        this$0.s();
        rightTvIt.setAlpha(1.0f);
        this_run.h.setAlpha(0.5f);
    }

    private final DialogLiveMedalWallBinding k() {
        return (DialogLiveMedalWallBinding) this.e.getValue();
    }

    private final String l() {
        return (String) this.f.getValue();
    }

    private final String m() {
        return (String) this.g.getValue();
    }

    private final LiveMedalWallPresenter n() {
        return (LiveMedalWallPresenter) this.h.getValue();
    }

    private final LiveMedalListAdapter o() {
        return (LiveMedalListAdapter) this.n.getValue();
    }

    private final void p() {
        LiveEventBus.get("LIVE_MEDAL_DATA", LiveMedalData.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveMedalWallDialogFragment$_FZypAs7j8diXpNu41lnAsmwD4E
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveMedalWallDialogFragment.a(LiveMedalWallDialogFragment.this, (LiveMedalData) obj);
            }
        });
    }

    private final void q() {
        String str = null;
        if (!this.d) {
            LiveProtos.Event event = LiveProtos.Event.LIVE_MEDAL_WALL_USER_TAB_CLICK;
            String e = LiveRoomManager.a().e();
            String g = LiveRoomManager.a().g();
            LiveRoomUserModel liveRoomUserModel = this.k;
            EventTrackLive.u(event, e, g, liveRoomUserModel == null ? null : liveRoomUserModel.uid);
            return;
        }
        LiveProtos.Event event2 = LiveProtos.Event.LIVE_MEDAL_WALL_ANCHOR_TAB_CLICK;
        String e2 = LiveRoomManager.a().e();
        String g2 = LiveRoomManager.a().g();
        LiveRoomUserModel liveRoomUserModel2 = this.k;
        if (liveRoomUserModel2 != null) {
            str = liveRoomUserModel2.uid;
        }
        EventTrackLive.u(event2, e2, g2, str);
    }

    private final void r() {
        String str = null;
        if (!this.d) {
            LiveProtos.Event event = LiveProtos.Event.LIVE_MEDAL_WALL_ANCHOR_TAB_CLICK;
            String e = LiveRoomManager.a().e();
            String g = LiveRoomManager.a().g();
            LiveRoomUserModel liveRoomUserModel = this.k;
            EventTrackLive.u(event, e, g, liveRoomUserModel == null ? null : liveRoomUserModel.uid);
            return;
        }
        LiveProtos.Event event2 = LiveProtos.Event.LIVE_MEDAL_WALL_USER_TAB_CLICK;
        String e2 = LiveRoomManager.a().e();
        String g2 = LiveRoomManager.a().g();
        LiveRoomUserModel liveRoomUserModel2 = this.k;
        if (liveRoomUserModel2 != null) {
            str = liveRoomUserModel2.uid;
        }
        EventTrackLive.u(event2, e2, g2, str);
    }

    private final void s() {
        ArrayList<LiveMedalItemData> arrayList = this.p.get(Integer.valueOf(this.m));
        ArrayList<LiveMedalItemData> arrayList2 = arrayList;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            DialogLiveMedalWallBinding k = k();
            LinearLayout linearLayout = k.f;
            Intrinsics.c(linearLayout, "it.llEmptyView");
            BluedViewExKt.b(linearLayout);
            RecyclerView recyclerView = k.g;
            Intrinsics.c(recyclerView, "it.rvMedalWall");
            BluedViewExKt.a(recyclerView);
            return;
        }
        DialogLiveMedalWallBinding k2 = k();
        LinearLayout linearLayout2 = k2.f;
        Intrinsics.c(linearLayout2, "it.llEmptyView");
        BluedViewExKt.a(linearLayout2);
        RecyclerView recyclerView2 = k2.g;
        Intrinsics.c(recyclerView2, "it.rvMedalWall");
        BluedViewExKt.b(recyclerView2);
        int size = arrayList.size();
        if (size == 1) {
            arrayList.add(new LiveMedalItemData(0L, 0L, 0, 0, null, null, null, null, null, 511, null));
            arrayList.add(new LiveMedalItemData(0L, 0L, 0, 0, null, null, null, null, null, 511, null));
        } else if (size == 2) {
            arrayList.add(new LiveMedalItemData(0L, 0L, 0, 0, null, null, null, null, null, 511, null));
        }
        this.o.clear();
        this.o.addAll(arrayList2);
        o().notifyDataSetChanged();
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
        FrameLayout root = k().getRoot();
        Intrinsics.c(root, "viewBinding.root");
        return root;
    }

    public final void i() {
        LiveMedalWallPresenter n = n();
        LiveRoomUserModel liveRoomUserModel = this.k;
        n.a(String.valueOf(liveRoomUserModel == null ? null : liveRoomUserModel.uid), this.b);
    }

    public final void j() {
        final DialogLiveMedalWallBinding k = k();
        LiveRoomUserModel liveRoomUserModel = this.k;
        if (liveRoomUserModel != null) {
            ImageLoader.a(this.b, liveRoomUserModel.avatar).b(R.drawable.user_bg_round).c().a(k.f11789c);
            k.j.setText(liveRoomUserModel.name);
            if (TextUtils.isEmpty(liveRoomUserModel.avatar_frame)) {
                ImageView ivAvatarDecorate = k.d;
                Intrinsics.c(ivAvatarDecorate, "ivAvatarDecorate");
                BluedViewExKt.c(ivAvatarDecorate);
            } else {
                ImageView ivAvatarDecorate2 = k.d;
                Intrinsics.c(ivAvatarDecorate2, "ivAvatarDecorate");
                BluedViewExKt.b(ivAvatarDecorate2);
                ImageLoader.a((IRequestHost) null, liveRoomUserModel.avatar_frame).e(k.d.hashCode()).g(-1).a(k.d);
            }
        }
        k.g.setLayoutManager(new GridLayoutManager(getContext(), 3));
        o().setNewData(this.o);
        k.g.setAdapter(o());
        o().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveMedalWallDialogFragment$PiaMUykXwYUK8KcHxHIveF9dS8o
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                LiveMedalWallDialogFragment.a(LiveMedalWallDialogFragment.this, baseQuickAdapter, view, i);
            }
        });
        final TextView textView = k.h;
        textView.setText(this.d ? l() : m());
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveMedalWallDialogFragment$2mRO9AJgjDE5lOGSK89bFBTBt50
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveMedalWallDialogFragment.a(LiveMedalWallDialogFragment.this, textView, k, view);
            }
        });
        final TextView textView2 = k.i;
        textView2.setText(this.d ? m() : l());
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveMedalWallDialogFragment$FBNkI0-ov11WfTFVoOadL-vbH2E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveMedalWallDialogFragment.b(LiveMedalWallDialogFragment.this, textView2, k, view);
            }
        });
        k.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveMedalWallDialogFragment$IOEBS7UPQB-PMMtumJ9e3nIxF5s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveMedalWallDialogFragment.a(LiveMedalWallDialogFragment.this, view);
            }
        });
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setupDialog(Dialog dialog, int i) {
        Intrinsics.e(dialog, "dialog");
        super.setupDialog(dialog, i);
        LiveProtos.Event event = LiveProtos.Event.LIVE_MEDAL_WALL_SHOW;
        String e = LiveRoomManager.a().e();
        String g = LiveRoomManager.a().g();
        LiveRoomUserModel liveRoomUserModel = this.k;
        EventTrackLive.u(event, e, g, liveRoomUserModel == null ? null : liveRoomUserModel.uid);
        j();
        i();
        p();
    }
}
