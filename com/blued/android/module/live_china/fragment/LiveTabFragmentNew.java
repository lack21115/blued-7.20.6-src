package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageFileWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.PauseOnScrollListener;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.view.CustomTwoLevelHeader;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveTabAdapter;
import com.blued.android.module.live_china.databinding.FragmentLiveTabNewBinding;
import com.blued.android.module.live_china.databinding.NodataShowLiveListBinding;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.AnchorLiveStateModel;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.model.LiveTwoFloorModel;
import com.blued.android.module.live_china.utils.LiveRoomUtils;
import com.blued.android.module.live_china.utils.log.EventTrackLive;
import com.blued.android.module.live_china.view.LiveTwoLevelRefreshView;
import com.blued.android.module.live_china.view_model.LiveTabViewModel;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.opos.acs.st.STManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.OnTwoLevelListener;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveTabFragmentNew.class */
public final class LiveTabFragmentNew extends MVVMBaseFragment<LiveTabViewModel> {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f13277c;
    private boolean d;
    private LiveTwoFloorModel e;
    private LiveTabAdapter f;
    private boolean g;
    private String h;
    private String i;
    private String j;
    private boolean k;
    private boolean l;
    private PauseOnScrollListener m;
    private long n;
    private String o;
    private final Observer<String> p;
    private final Observer<String> q;
    private final Observer<Boolean> r;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(LiveTabFragmentNew.class, "viewBinding", "getViewBinding()Lcom/blued/android/module/live_china/databinding/FragmentLiveTabNewBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f13276a = new Companion(null);

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveTabFragmentNew$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveTabFragmentNew a(String str, String str2, String str3, String details) {
            Intrinsics.e(details, "details");
            LiveTabFragmentNew liveTabFragmentNew = new LiveTabFragmentNew();
            Bundle bundle = new Bundle();
            bundle.putString(STManager.KEY_TAB_ID, str);
            bundle.putString("tabName", str2);
            bundle.putString("tabPoint", str3);
            bundle.putString("live_pay_beans_details", details);
            liveTabFragmentNew.setArguments(bundle);
            return liveTabFragmentNew;
        }
    }

    public LiveTabFragmentNew() {
        super(R.layout.fragment_live_tab_new);
        this.f13277c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<LiveTabFragmentNew, FragmentLiveTabNewBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveTabFragmentNew$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentLiveTabNewBinding invoke(LiveTabFragmentNew fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentLiveTabNewBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<LiveTabFragmentNew, FragmentLiveTabNewBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveTabFragmentNew$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentLiveTabNewBinding invoke(LiveTabFragmentNew fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentLiveTabNewBinding.a(fragment.requireView());
            }
        });
        this.o = "";
        this.p = new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveTabFragmentNew$9Op2GfMgnI6EkWnqC4POOkugRuU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveTabFragmentNew.a(LiveTabFragmentNew.this, (String) obj);
            }
        };
        this.q = new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveTabFragmentNew$UDI__0JGIuhDKbAsA2iZUpUg64o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveTabFragmentNew.b(LiveTabFragmentNew.this, (String) obj);
            }
        };
        this.r = new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveTabFragmentNew$s2aiS1ZS52e-BJAkVmMMaBvky6w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveTabFragmentNew.a(LiveTabFragmentNew.this, (Boolean) obj);
            }
        };
    }

    private final void A() {
        LiveEventBus.get("live_float_dismiss", String.class).removeObserver(this.p);
        LiveEventBus.get("live_back_to_two_level", String.class).removeObserver(this.q);
        LiveEventBus.get("live_tab_page", Boolean.TYPE).removeObserver(this.r);
    }

    private final void B() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        FragmentLiveTabNewBinding p = p();
        RecyclerView.LayoutManager layoutManager = null;
        if (p != null && (recyclerView2 = p.d) != null) {
            layoutManager = recyclerView2.getLayoutManager();
        }
        if (layoutManager == null) {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
            FragmentLiveTabNewBinding p2 = p();
            if (p2 != null && (recyclerView = p2.d) != null) {
                recyclerView.setLayoutManager(gridLayoutManager);
            }
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.live_china.fragment.LiveTabFragmentNew$updateRecyclerView$1
                @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                public int getSpanSize(int i) {
                    LiveTabAdapter q = LiveTabFragmentNew.this.q();
                    if ((q == null ? null : (BluedLiveListData) q.getItem(i)) != null) {
                        LiveTabAdapter q2 = LiveTabFragmentNew.this.q();
                        Integer valueOf = q2 == null ? null : Integer.valueOf(q2.getItemViewType(i));
                        if (valueOf != null && valueOf.intValue() == 11) {
                            return 2;
                        }
                        return ((valueOf != null && valueOf.intValue() == 0) || valueOf == null || valueOf.intValue() != 12) ? 1 : 2;
                    }
                    return 1;
                }
            });
            LiveTabAdapter liveTabAdapter = this.f;
            if (liveTabAdapter == null) {
                return;
            }
            liveTabAdapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FragmentLiveTabNewBinding binding) {
        Intrinsics.e(binding, "$binding");
        SmartRefreshLayout smartRefreshLayout = binding.e;
        if (smartRefreshLayout == null) {
            return;
        }
        smartRefreshLayout.b(binding.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveTabFragmentNew this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (this$0.getParentFragment() instanceof LiveMainFragment) {
            Fragment parentFragment = this$0.getParentFragment();
            if (parentFragment == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.fragment.LiveMainFragment");
            }
            LiveRoomInfo.a().a(((LiveMainFragment) parentFragment).getParentFragment());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveTabFragmentNew this$0, Boolean bool) {
        FragmentLiveTabNewBinding p;
        SmartRefreshLayout smartRefreshLayout;
        Intrinsics.e(this$0, "this$0");
        if (!this$0.y() || (p = this$0.p()) == null || (smartRefreshLayout = p.e) == null) {
            return;
        }
        smartRefreshLayout.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveTabFragmentNew this$0, String str) {
        LiveTabAdapter liveTabAdapter;
        Intrinsics.e(this$0, "this$0");
        if (!this$0.y() || (liveTabAdapter = this$0.f) == null) {
            return;
        }
        liveTabAdapter.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(RefreshLayout it) {
        Intrinsics.e(it, "it");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveTabFragmentNew this$0) {
        SmartRefreshLayout smartRefreshLayout;
        Intrinsics.e(this$0, "this$0");
        this$0.g = true;
        FragmentLiveTabNewBinding p = this$0.p();
        if (p == null || (smartRefreshLayout = p.e) == null) {
            return;
        }
        smartRefreshLayout.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final LiveTabFragmentNew this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        this$0.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveTabFragmentNew$oBuvBqfoHKCMzh6dvjlc0hgTQ7w
            @Override // java.lang.Runnable
            public final void run() {
                LiveTabFragmentNew.c(LiveTabFragmentNew.this);
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveTabFragmentNew this$0) {
        CustomTwoLevelHeader customTwoLevelHeader;
        Intrinsics.e(this$0, "this$0");
        FragmentLiveTabNewBinding p = this$0.p();
        if (p == null || (customTwoLevelHeader = p.b) == null) {
            return;
        }
        customTwoLevelHeader.a();
    }

    private final void z() {
        LiveEventBus.get("live_float_dismiss", String.class).observeForever(this.p);
        LiveEventBus.get("live_back_to_two_level", String.class).observeForever(this.q);
        LiveEventBus.get("live_tab_page", Boolean.TYPE).observeForever(this.r);
    }

    public final void a(PauseOnScrollListener pauseOnScrollListener) {
        this.m = pauseOnScrollListener;
    }

    public final void a(LiveTabAdapter liveTabAdapter) {
        this.f = liveTabAdapter;
    }

    public final void a(AnchorLiveStateModel model) {
        Intrinsics.e(model, "model");
        if (model.is_live != 1) {
            LiveRoomInfo.a().a(getContext(), model.uid, model.name, model.avatar, 0, 1);
            return;
        }
        LiveRoomData liveRoomData = new LiveRoomData(model.lid, 0, Intrinsics.a("tag_", (Object) this.h), model.uid, model.name, model.avatar, 0);
        liveRoomData.details = this.o;
        this.o = "";
        ArrayList arrayList = new ArrayList();
        LiveTabAdapter liveTabAdapter = this.f;
        List<BluedLiveListData> list = null;
        String a2 = liveTabAdapter == null ? null : liveTabAdapter.a();
        LiveTabAdapter liveTabAdapter2 = this.f;
        if (liveTabAdapter2 != null) {
            list = liveTabAdapter2.b();
        }
        Intrinsics.a(list);
        arrayList.addAll(list);
        List<LiveRoomData> a3 = LiveRoomUtils.a(arrayList, a2);
        Intrinsics.c(a3, "getLiveRoomDataList(datas, comeCode)");
        a3.add(0, liveRoomData);
        LiveRoomInfo.a().a(getContext(), liveRoomData, 0, a3, (Bundle) null);
    }

    public final void a(String str) {
        this.h = str;
    }

    public final void a(List<BluedLiveListData> list) {
        LinearLayout root;
        NodataShowLiveListBinding nodataShowLiveListBinding;
        TextView textView;
        LinearLayout root2;
        Intrinsics.e(list, "list");
        LiveRoomUtils.c(a().g().tabId, list);
        if (a().g().getPage() == 1) {
            LiveTabAdapter liveTabAdapter = this.f;
            if (liveTabAdapter != null) {
                liveTabAdapter.a(list);
            }
        } else {
            LiveTabAdapter liveTabAdapter2 = this.f;
            if (liveTabAdapter2 != null) {
                liveTabAdapter2.b(list);
            }
        }
        B();
        LiveTabAdapter liveTabAdapter3 = this.f;
        if (liveTabAdapter3 != null) {
            Intrinsics.a(liveTabAdapter3);
            if (liveTabAdapter3.b().size() > 0) {
                FragmentLiveTabNewBinding p = p();
                RecyclerView recyclerView = p == null ? null : p.d;
                if (recyclerView != null) {
                    recyclerView.setVisibility(0);
                }
                FragmentLiveTabNewBinding p2 = p();
                if (p2 == null) {
                    root2 = null;
                } else {
                    NodataShowLiveListBinding nodataShowLiveListBinding2 = p2.f11974c;
                    root2 = nodataShowLiveListBinding2 == null ? null : nodataShowLiveListBinding2.getRoot();
                }
                if (root2 == null) {
                    return;
                }
                root2.setVisibility(8);
                return;
            }
        }
        FragmentLiveTabNewBinding p3 = p();
        RecyclerView recyclerView2 = p3 == null ? null : p3.d;
        if (recyclerView2 != null) {
            recyclerView2.setVisibility(8);
        }
        FragmentLiveTabNewBinding p4 = p();
        if (p4 == null) {
            root = null;
        } else {
            NodataShowLiveListBinding nodataShowLiveListBinding3 = p4.f11974c;
            root = nodataShowLiveListBinding3 == null ? null : nodataShowLiveListBinding3.getRoot();
        }
        if (root != null) {
            root.setVisibility(0);
        }
        FragmentLiveTabNewBinding p5 = p();
        if (p5 == null || (nodataShowLiveListBinding = p5.f11974c) == null || (textView = nodataShowLiveListBinding.b) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveTabFragmentNew$s6IKqnFwE7VakHeA1aLMh15KUt4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveTabFragmentNew.a(LiveTabFragmentNew.this, view);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void a(boolean z) {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentLiveTabNewBinding p = p();
        if (p != null && (smartRefreshLayout2 = p.e) != null) {
            smartRefreshLayout2.j();
        }
        FragmentLiveTabNewBinding p2 = p();
        if (p2 == null || (smartRefreshLayout = p2.e) == null) {
            return;
        }
        smartRefreshLayout.h();
    }

    public final void b(String str) {
        this.i = str;
    }

    public final void b(List<? extends LiveTwoFloorModel> list) {
        Intrinsics.e(list, "list");
        if (list.size() > 0) {
            LiveTwoFloorModel liveTwoFloorModel = list.get(0);
            this.e = liveTwoFloorModel;
            if (liveTwoFloorModel != null) {
                if (TextUtils.equals("1", liveTwoFloorModel == null ? null : liveTwoFloorModel.type)) {
                    LiveTwoFloorModel liveTwoFloorModel2 = this.e;
                    if (StringUtils.a(liveTwoFloorModel2 == null ? null : liveTwoFloorModel2.lid, 0L) > 0) {
                        this.d = true;
                    }
                }
                LiveTwoFloorModel liveTwoFloorModel3 = this.e;
                if (TextUtils.equals(r0, liveTwoFloorModel3 == null ? null : liveTwoFloorModel3.type)) {
                    LiveTwoFloorModel liveTwoFloorModel4 = this.e;
                    if (!TextUtils.isEmpty(liveTwoFloorModel4 == null ? null : liveTwoFloorModel4.activity_addr)) {
                        this.d = true;
                    }
                }
                this.d = false;
            } else {
                this.d = false;
            }
        } else {
            this.e = null;
            this.d = false;
        }
        if (getParentFragment() instanceof LiveMainFragment) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.fragment.LiveMainFragment");
            }
            LiveMainFragment liveMainFragment = (LiveMainFragment) parentFragment;
            liveMainFragment.a(this.e);
            liveMainFragment.b(this.d);
        }
        x();
    }

    public final void b(boolean z) {
        this.g = z;
    }

    public final void c(String str) {
        this.j = str;
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public boolean c() {
        return true;
    }

    public final void d(String str) {
        Intrinsics.e(str, "<set-?>");
        this.o = str;
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void e() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        Log.i("==okr", Intrinsics.a("tabId:", (Object) arguments.getString(STManager.KEY_TAB_ID)));
        a(arguments.getString(STManager.KEY_TAB_ID, ""));
        b(arguments.getString("tabName", ""));
        c(arguments.getString("tabPoint", ""));
        String string = arguments.getString("live_pay_beans_details", "");
        Intrinsics.c(string, "it.getString(OnliveConst…VE_PAY_BEANS_DETAILS, \"\")");
        d(string);
        LiveTabViewModel a2 = a();
        if (a2 != null) {
            String s = s();
            Intrinsics.a((Object) s);
            String t = t();
            Intrinsics.a((Object) t);
            a2.a(s, t);
        }
        a(new PauseOnScrollListener(false, true));
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        Log.i("==xpm", "tab:" + ((Object) this.h) + " initView");
        final FragmentLiveTabNewBinding p = p();
        if (p == null) {
            return;
        }
        p.b.b(300);
        p.b.a(new OnTwoLevelListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveTabFragmentNew$sU7VpUnIfFnmyp6VevY7QjtPdrI
            @Override // com.scwang.smartrefresh.layout.api.OnTwoLevelListener
            public final boolean onTwoLevel(RefreshLayout refreshLayout) {
                boolean a2;
                a2 = LiveTabFragmentNew.a(refreshLayout);
                return a2;
            }
        });
        p.e.l(false);
        if (q() == null) {
            a(new LiveTabAdapter(getContext(), new ArrayList(), s(), j()));
        }
        p.d.setAdapter(q());
        if (TextUtils.equals(s(), "11")) {
            p.e.setBackgroundColor(BluedSkinUtils.a(getContext(), R.color.syc_b));
        }
        p.d.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.blued.android.module.live_china.fragment.LiveTabFragmentNew$initView$1$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                Intrinsics.e(recyclerView, "recyclerView");
                super.onScrollStateChanged(recyclerView, i);
                PauseOnScrollListener u = LiveTabFragmentNew.this.u();
                if (u != null) {
                    u.onScrollStateChanged(null, i);
                }
                if (i != 0) {
                    if (i == 1 && LiveTabFragmentNew.this.q() != null) {
                        LiveTabAdapter q = LiveTabFragmentNew.this.q();
                        Intrinsics.a(q);
                        q.b(true);
                    }
                } else if (LiveTabFragmentNew.this.q() != null) {
                    LiveTabAdapter q2 = LiveTabFragmentNew.this.q();
                    Intrinsics.a(q2);
                    q2.b(false);
                    LiveTabAdapter q3 = LiveTabFragmentNew.this.q();
                    Intrinsics.a(q3);
                    q3.e();
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                Intrinsics.e(recyclerView, "recyclerView");
                super.onScrolled(recyclerView, i, i2);
            }
        });
        p.e.b((OnMultiPurposeListener) new SimpleMultiPurposeListener() { // from class: com.blued.android.module.live_china.fragment.LiveTabFragmentNew$initView$1$3
            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener
            public void a(RefreshHeader header, boolean z, float f, int i, int i2, int i3) {
                LiveTwoFloorModel liveTwoFloorModel;
                LiveTwoFloorModel liveTwoFloorModel2;
                Intrinsics.e(header, "header");
                super.a(header, z, f, i, i2, i3);
                String str = null;
                if (TextUtils.equals(LiveTabFragmentNew.this.s(), "11")) {
                    LiveRoomInfo a2 = LiveRoomInfo.a();
                    Fragment parentFragment = LiveTabFragmentNew.this.getParentFragment();
                    a2.a(parentFragment == null ? null : parentFragment.getParentFragment(), 0.0f, 0);
                } else if (!(LiveTabFragmentNew.this.getParentFragment() instanceof LiveMainFragment)) {
                    LiveRoomInfo a3 = LiveRoomInfo.a();
                    Fragment parentFragment2 = LiveTabFragmentNew.this.getParentFragment();
                    a3.a(parentFragment2 == null ? null : parentFragment2.getParentFragment(), 0.0f, 0);
                } else {
                    Fragment parentFragment3 = LiveTabFragmentNew.this.getParentFragment();
                    if (parentFragment3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.fragment.LiveMainFragment");
                    }
                    LiveMainFragment liveMainFragment = (LiveMainFragment) parentFragment3;
                    liveTwoFloorModel = LiveTabFragmentNew.this.e;
                    if (liveTwoFloorModel != null) {
                        liveTwoFloorModel2 = LiveTabFragmentNew.this.e;
                        if (liveTwoFloorModel2 != null) {
                            str = liveTwoFloorModel2.two_floor_picture;
                        }
                        if (!TextUtils.isEmpty(str) && LiveTabFragmentNew.this.y()) {
                            liveMainFragment.a(f, i);
                            LiveRoomInfo.a().a(liveMainFragment.getParentFragment(), f, i);
                            return;
                        }
                    }
                    liveMainFragment.a(0.0f, 0);
                    LiveRoomInfo.a().a(liveMainFragment.getParentFragment(), 0.0f, 0);
                }
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
            public void a(RefreshLayout refreshLayout, RefreshState oldState, RefreshState newState) {
                LiveTwoFloorModel liveTwoFloorModel;
                LiveTwoFloorModel liveTwoFloorModel2;
                LiveTwoFloorModel liveTwoFloorModel3;
                LiveTwoFloorModel liveTwoFloorModel4;
                LiveTwoFloorModel liveTwoFloorModel5;
                LiveTwoFloorModel liveTwoFloorModel6;
                LiveTwoFloorModel liveTwoFloorModel7;
                LiveTwoFloorModel liveTwoFloorModel8;
                LiveTwoFloorModel liveTwoFloorModel9;
                LiveTwoFloorModel liveTwoFloorModel10;
                LiveTwoFloorModel liveTwoFloorModel11;
                LiveTwoFloorModel liveTwoFloorModel12;
                LiveTwoFloorModel liveTwoFloorModel13;
                LiveTwoFloorModel liveTwoFloorModel14;
                LiveTwoFloorModel liveTwoFloorModel15;
                LiveTwoFloorModel liveTwoFloorModel16;
                LiveTwoFloorModel liveTwoFloorModel17;
                Intrinsics.e(refreshLayout, "refreshLayout");
                Intrinsics.e(oldState, "oldState");
                Intrinsics.e(newState, "newState");
                if (newState == RefreshState.None) {
                    LiveTabFragmentNew.this.x();
                    liveTwoFloorModel8 = LiveTabFragmentNew.this.e;
                    if (liveTwoFloorModel8 != null) {
                        liveTwoFloorModel14 = LiveTabFragmentNew.this.e;
                        if (!TextUtils.isEmpty(liveTwoFloorModel14 == null ? null : liveTwoFloorModel14.two_floor_picture)) {
                            LiveProtos.Event event = LiveProtos.Event.LIVE_HOME_REFRESH_IMAGE_SHOW;
                            liveTwoFloorModel15 = LiveTabFragmentNew.this.e;
                            String str = liveTwoFloorModel15 == null ? null : liveTwoFloorModel15.lid;
                            liveTwoFloorModel16 = LiveTabFragmentNew.this.e;
                            String str2 = liveTwoFloorModel16 == null ? null : liveTwoFloorModel16.uid;
                            liveTwoFloorModel17 = LiveTabFragmentNew.this.e;
                            EventTrackLive.a(event, str, str2, liveTwoFloorModel17 == null ? null : liveTwoFloorModel17.id);
                        }
                    }
                    liveTwoFloorModel9 = LiveTabFragmentNew.this.e;
                    if (liveTwoFloorModel9 != null) {
                        liveTwoFloorModel10 = LiveTabFragmentNew.this.e;
                        if (StringUtils.a(liveTwoFloorModel10 == null ? null : liveTwoFloorModel10.lid, 0L) > 0) {
                            LiveProtos.Event event2 = LiveProtos.Event.LIVE_HOME_REFRESH_WORD_SHOW;
                            liveTwoFloorModel11 = LiveTabFragmentNew.this.e;
                            String str3 = liveTwoFloorModel11 == null ? null : liveTwoFloorModel11.lid;
                            liveTwoFloorModel12 = LiveTabFragmentNew.this.e;
                            String str4 = liveTwoFloorModel12 == null ? null : liveTwoFloorModel12.uid;
                            liveTwoFloorModel13 = LiveTabFragmentNew.this.e;
                            EventTrackLive.a(event2, str3, str4, liveTwoFloorModel13 == null ? null : liveTwoFloorModel13.id);
                        }
                    }
                } else if (newState != RefreshState.ReleaseToTwoLevel && newState == RefreshState.TwoLevelReleased) {
                    LiveTabViewModel a2 = LiveTabFragmentNew.this.a();
                    ActivityFragmentActive fragmentActive = LiveTabFragmentNew.this.getFragmentActive();
                    Intrinsics.c(fragmentActive, "fragmentActive");
                    a2.b(fragmentActive);
                    liveTwoFloorModel = LiveTabFragmentNew.this.e;
                    if (liveTwoFloorModel == null) {
                        return;
                    }
                    liveTwoFloorModel2 = LiveTabFragmentNew.this.e;
                    if (TextUtils.equals(r0, liveTwoFloorModel2 == null ? null : liveTwoFloorModel2.type)) {
                        liveTwoFloorModel6 = LiveTabFragmentNew.this.e;
                        if (!TextUtils.isEmpty(liveTwoFloorModel6 == null ? null : liveTwoFloorModel6.activity_addr)) {
                            LiveRoomInfo a3 = LiveRoomInfo.a();
                            Context context = LiveTabFragmentNew.this.getContext();
                            liveTwoFloorModel7 = LiveTabFragmentNew.this.e;
                            a3.b(context, liveTwoFloorModel7 == null ? null : liveTwoFloorModel7.activity_addr);
                            return;
                        }
                    }
                    liveTwoFloorModel3 = LiveTabFragmentNew.this.e;
                    if (TextUtils.equals(r0, liveTwoFloorModel3 == null ? null : liveTwoFloorModel3.type)) {
                        liveTwoFloorModel4 = LiveTabFragmentNew.this.e;
                        if (StringUtils.a(liveTwoFloorModel4 == null ? null : liveTwoFloorModel4.lid, 0L) > 0) {
                            LiveRoomInfo a4 = LiveRoomInfo.a();
                            Context context2 = LiveTabFragmentNew.this.getContext();
                            liveTwoFloorModel5 = LiveTabFragmentNew.this.e;
                            a4.a(context2, liveTwoFloorModel5);
                        }
                    }
                }
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
            public void onLoadMore(RefreshLayout refreshLayout) {
                Intrinsics.e(refreshLayout, "refreshLayout");
                LiveTabViewModel a2 = LiveTabFragmentNew.this.a();
                ActivityFragmentActive fragmentActive = LiveTabFragmentNew.this.getFragmentActive();
                Intrinsics.c(fragmentActive, "fragmentActive");
                a2.a((IRequestHost) fragmentActive, false);
            }

            @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public void onRefresh(RefreshLayout refreshLayout) {
                FragmentLiveTabNewBinding fragmentLiveTabNewBinding;
                RecyclerView recyclerView;
                RecyclerView recyclerView2;
                RecyclerView recyclerView3;
                RecyclerView.LayoutManager layoutManager;
                Intrinsics.e(refreshLayout, "refreshLayout");
                LiveTabAdapter q = LiveTabFragmentNew.this.q();
                if (q != null) {
                    q.d();
                }
                FragmentLiveTabNewBinding fragmentLiveTabNewBinding2 = p;
                if (fragmentLiveTabNewBinding2 != null && (recyclerView3 = fragmentLiveTabNewBinding2.d) != null && (layoutManager = recyclerView3.getLayoutManager()) != null) {
                    layoutManager.scrollToPosition(0);
                }
                FragmentLiveTabNewBinding fragmentLiveTabNewBinding3 = p;
                Boolean bool = null;
                if (fragmentLiveTabNewBinding3 != null && (recyclerView2 = fragmentLiveTabNewBinding3.d) != null) {
                    bool = Boolean.valueOf(recyclerView2.canScrollVertically(-1));
                }
                if (!bool.booleanValue() && (fragmentLiveTabNewBinding = p) != null && (recyclerView = fragmentLiveTabNewBinding.d) != null) {
                    recyclerView.stopScroll();
                }
                LiveTabViewModel a2 = LiveTabFragmentNew.this.a();
                ActivityFragmentActive fragmentActive = LiveTabFragmentNew.this.getFragmentActive();
                Intrinsics.c(fragmentActive, "fragmentActive");
                a2.a(fragmentActive);
                if (LiveTabFragmentNew.this.getParentFragment() instanceof LiveMainFragment) {
                    Fragment parentFragment = LiveTabFragmentNew.this.getParentFragment();
                    if (parentFragment == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.fragment.LiveMainFragment");
                    }
                    LiveMainFragment liveMainFragment = (LiveMainFragment) parentFragment;
                    if (!LiveTabFragmentNew.this.r()) {
                        liveMainFragment.w();
                    }
                    LiveTabFragmentNew.this.b(false);
                    LiveRoomInfo.a().a(liveMainFragment.getParentFragment(), true);
                }
            }
        });
        postSafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveTabFragmentNew$m1k9oAQ-1fl_EK4BBSklhAW9wew
            @Override // java.lang.Runnable
            public final void run() {
                LiveTabFragmentNew.a(FragmentLiveTabNewBinding.this);
            }
        });
        x();
        if (a().g().hasRequestData) {
            List<BluedLiveListData> c2 = LiveRoomUtils.c(a().g().tabId);
            Intrinsics.c(c2, "getApaterData(mViewModel.commonModel.tabId)");
            a(c2);
            p.e.l(a().g().getHasData());
        }
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void g() {
        Log.i("==okr", Intrinsics.a("lazyLoad:", (Object) a().g().tabId));
        if (a().g().hasRequestData) {
            return;
        }
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveTabFragmentNew$9K2Ljiow3oeTP0Y2gTcXuqvd8MQ
            @Override // java.lang.Runnable
            public final void run() {
                LiveTabFragmentNew.b(LiveTabFragmentNew.this);
            }
        }, 300L);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void k() {
        z();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        LiveTabFragmentNew liveTabFragmentNew = this;
        LifecycleExtKt.a(liveTabFragmentNew, a().e(), new LiveTabFragmentNew$liveDataObserver$1(this));
        LifecycleExtKt.a(liveTabFragmentNew, a().d(), new LiveTabFragmentNew$liveDataObserver$2(this));
        LifecycleExtKt.a(liveTabFragmentNew, a().f(), new LiveTabFragmentNew$liveDataObserver$3(this));
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void m() {
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void n() {
        SmartRefreshLayout smartRefreshLayout;
        FragmentLiveTabNewBinding p = p();
        if (p == null || (smartRefreshLayout = p.e) == null) {
            return;
        }
        smartRefreshLayout.l(true);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void o() {
        SmartRefreshLayout smartRefreshLayout;
        FragmentLiveTabNewBinding p = p();
        if (p == null || (smartRefreshLayout = p.e) == null) {
            return;
        }
        smartRefreshLayout.l(false);
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        A();
        super.onDestroy();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FragmentLiveTabNewBinding p = p();
        RecyclerView recyclerView = p == null ? null : p.d;
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
        }
        A();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.l = false;
        Log.i("==xpm", "tab:" + ((Object) this.h) + " on pause");
        v();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Log.i("==xpm", "tab:" + ((Object) this.h) + " onResume");
        this.l = true;
        v();
    }

    public final FragmentLiveTabNewBinding p() {
        return (FragmentLiveTabNewBinding) this.f13277c.b(this, b[0]);
    }

    public final LiveTabAdapter q() {
        return this.f;
    }

    public final boolean r() {
        return this.g;
    }

    public final String s() {
        return this.h;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        Log.i("==xpm", "tab:" + ((Object) this.h) + " setUserVisibleHint:" + z);
        this.k = z;
        v();
    }

    public final String t() {
        return this.i;
    }

    public final PauseOnScrollListener u() {
        return this.m;
    }

    public final void v() {
        if (!TextUtils.equals(this.h, "11")) {
            LiveTabAdapter liveTabAdapter = this.f;
            if (liveTabAdapter != null) {
                liveTabAdapter.a(y());
            }
            if (!y()) {
                Log.i("==xpm", "tab:" + ((Object) this.h) + " check to pause");
                LiveTabAdapter liveTabAdapter2 = this.f;
                if (liveTabAdapter2 != null) {
                    liveTabAdapter2.d();
                }
                this.n = System.currentTimeMillis();
                return;
            }
            Log.i("==xpm", "tab:" + ((Object) this.h) + " check to play");
            com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive.g(LiveProtos.Event.LIVE_SECOND_TAB_SHOW, this.j);
            LiveTabAdapter liveTabAdapter3 = this.f;
            if (liveTabAdapter3 != null) {
                liveTabAdapter3.c();
            }
            w();
            return;
        }
        LiveTabAdapter liveTabAdapter4 = this.f;
        if (liveTabAdapter4 != null) {
            liveTabAdapter4.a(this.k && this.l);
        }
        if (!this.k || !this.l) {
            Log.i("==xpm", "tab:" + ((Object) this.h) + " check to pause");
            LiveTabAdapter liveTabAdapter5 = this.f;
            if (liveTabAdapter5 != null) {
                liveTabAdapter5.d();
            }
            this.n = System.currentTimeMillis();
            return;
        }
        Log.i("==xpm", "tab:" + ((Object) this.h) + " check to play");
        com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive.g(LiveProtos.Event.LIVE_FIRST_TAB_SHOW, this.j);
        LiveTabAdapter liveTabAdapter6 = this.f;
        if (liveTabAdapter6 != null) {
            liveTabAdapter6.c();
        }
        w();
    }

    public final void w() {
        FragmentLiveTabNewBinding p;
        SmartRefreshLayout smartRefreshLayout;
        if (this.n != 0) {
            if (System.currentTimeMillis() - this.n > 900000 && (p = p()) != null && (smartRefreshLayout = p.e) != null) {
                smartRefreshLayout.i();
            }
            this.n = 0L;
        }
    }

    public final void x() {
        UserBasicModel userBasicModel;
        String str;
        if (getParentFragment() instanceof LiveMainFragment) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.fragment.LiveMainFragment");
            }
            LiveMainFragment liveMainFragment = (LiveMainFragment) parentFragment;
            this.e = liveMainFragment.t();
            this.d = liveMainFragment.s();
        }
        FragmentLiveTabNewBinding p = p();
        if (p == null) {
            return;
        }
        SmartRefreshLayout smartRefreshLayout = p.e;
        if ((smartRefreshLayout == null ? null : smartRefreshLayout.getState()) == RefreshState.None) {
            CustomTwoLevelHeader customTwoLevelHeader = p.b;
            if (customTwoLevelHeader != null) {
                customTwoLevelHeader.a(this.d);
            }
            LiveTwoFloorModel liveTwoFloorModel = this.e;
            String str2 = liveTwoFloorModel != null ? liveTwoFloorModel == null ? null : liveTwoFloorModel.two_floor_picture : "";
            if (TextUtils.isEmpty(str2)) {
                LiveTwoLevelRefreshView liveTwoLevelRefreshView = p.f;
                if (liveTwoLevelRefreshView != null) {
                    liveTwoLevelRefreshView.a(this.d, false);
                }
            } else {
                LiveTwoLevelRefreshView liveTwoLevelRefreshView2 = p.f;
                if (liveTwoLevelRefreshView2 != null) {
                    liveTwoLevelRefreshView2.a(this.d, true);
                }
            }
            if (getParentFragment() instanceof LiveMainFragment) {
                Fragment parentFragment2 = getParentFragment();
                if (parentFragment2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.fragment.LiveMainFragment");
                }
                LiveMainFragment liveMainFragment2 = (LiveMainFragment) parentFragment2;
                LiveRoomInfo.a().a(liveMainFragment2.getParentFragment(), this.d, str2, liveMainFragment2.x());
            }
            LiveTwoFloorModel liveTwoFloorModel2 = this.e;
            if (liveTwoFloorModel2 != null) {
                if ((liveTwoFloorModel2 == null ? null : liveTwoFloorModel2.anchor) != null) {
                    LiveTwoFloorModel liveTwoFloorModel3 = this.e;
                    if (TextUtils.isEmpty((liveTwoFloorModel3 == null || (userBasicModel = liveTwoFloorModel3.anchor) == null) ? null : userBasicModel.avatar)) {
                        return;
                    }
                    ImageFileWrapper a2 = ImageFileLoader.a(getFragmentActive());
                    LiveTwoFloorModel liveTwoFloorModel4 = this.e;
                    if (liveTwoFloorModel4 == null) {
                        str = null;
                    } else {
                        UserBasicModel userBasicModel2 = liveTwoFloorModel4.anchor;
                        str = userBasicModel2 == null ? null : userBasicModel2.avatar;
                    }
                    a2.a(str).a();
                }
            }
        }
    }

    public final boolean y() {
        if (TextUtils.equals(this.h, "11")) {
            return this.k;
        }
        if (getParentFragment() instanceof LiveMainFragment) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                return ((LiveMainFragment) parentFragment).r() && this.l;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.fragment.LiveMainFragment");
        }
        return false;
    }
}
