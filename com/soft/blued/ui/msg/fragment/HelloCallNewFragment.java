package com.soft.blued.ui.msg.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.community.view.FloatFooterView;
import com.blued.das.guy.GuyProtos;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentHelloCallNewBinding;
import com.soft.blued.databinding.HelloCallNewHeaderBinding;
import com.soft.blued.http.NearbyHttpUtils;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.model.CallMeStatusData;
import com.soft.blued.ui.find.model.FilterEntity;
import com.soft.blued.ui.find.model.HelloDataExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.find.observer.CallHelloObserver;
import com.soft.blued.ui.msg.adapter.PeopleHelloQuickAdapter;
import com.soft.blued.ui.msg.fragment.HelloFilterDialogFragment;
import com.soft.blued.ui.msg.state.HelloCallAction;
import com.soft.blued.ui.msg.state.HelloCallState;
import com.soft.blued.ui.msg.viewModel.HelloCallViewModel;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/HelloCallNewFragment.class */
public final class HelloCallNewFragment extends MVIBaseFragment<HelloCallViewModel> implements CallHelloObserver.ICallHelloObserver {
    private final ViewBindingProperty d;
    private int e;
    private int f;
    private boolean g;
    private String h;
    private String i;
    private PeopleHelloQuickAdapter j;
    private PeopleHelloQuickAdapter k;
    private View l;
    private NoDataAndLoadFailView m;
    private HelloCallNewHeaderBinding n;
    private RecyclerView o;
    private boolean p;

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f18668c = {(KProperty) Reflection.a(new PropertyReference1Impl(HelloCallNewFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/FragmentHelloCallNewBinding;", 0))};
    public static final Companion b = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/HelloCallNewFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, String str) {
            Intrinsics.e(context, "context");
            Intrinsics.e(str, "title");
            Bundle bundle = new Bundle();
            bundle.putString("hello_title", str);
            TerminalActivity.d(context, HelloCallNewFragment.class, bundle);
        }
    }

    public HelloCallNewFragment() {
        super((int) R.layout.fragment_hello_call_new);
        this.d = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<HelloCallNewFragment, FragmentHelloCallNewBinding>() { // from class: com.soft.blued.ui.msg.fragment.HelloCallNewFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/msg/fragment/HelloCallNewFragment;)Lcom/soft/blued/databinding/FragmentHelloCallNewBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentHelloCallNewBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<HelloCallNewFragment, FragmentHelloCallNewBinding>() { // from class: com.soft.blued.ui.msg.fragment.HelloCallNewFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/msg/fragment/HelloCallNewFragment;)Lcom/soft/blued/databinding/FragmentHelloCallNewBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentHelloCallNewBinding.a(fragment.requireView());
            }
        });
        this.e = 1;
        this.f = 30;
        this.h = "";
        this.i = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(HelloCallNewFragment helloCallNewFragment, View view) {
        ShapeTextView shapeTextView;
        Tracker.onClick(view);
        Intrinsics.e(helloCallNewFragment, "this$0");
        HelloCallNewHeaderBinding helloCallNewHeaderBinding = helloCallNewFragment.n;
        if (helloCallNewHeaderBinding == null || (shapeTextView = helloCallNewHeaderBinding.h) == null) {
            return;
        }
        shapeTextView.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(HelloCallNewFragment helloCallNewFragment, PullToRefreshBase pullToRefreshBase) {
        Intrinsics.e(helloCallNewFragment, "this$0");
        helloCallNewFragment.e = 1;
        helloCallNewFragment.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(HelloCallNewFragment helloCallNewFragment, String str) {
        PullToRefreshRecyclerView pullToRefreshRecyclerView;
        Intrinsics.e(helloCallNewFragment, "this$0");
        Intrinsics.c(str, "r");
        helloCallNewFragment.i = str;
        helloCallNewFragment.g();
        RecyclerView recyclerView = helloCallNewFragment.o;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
        FragmentHelloCallNewBinding c2 = helloCallNewFragment.c();
        if (c2 == null || (pullToRefreshRecyclerView = c2.f) == null) {
            return;
        }
        pullToRefreshRecyclerView.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(HelloCallNewFragment helloCallNewFragment, boolean z) {
        Intrinsics.e(helloCallNewFragment, "this$0");
        if (z) {
            CallHelloManager.a().a(helloCallNewFragment.getContext(), (IRequestHost) helloCallNewFragment.getFragmentActive(), false, 8);
        }
    }

    private final void b(CallMeStatusData callMeStatusData) {
        Context context;
        FragmentHelloCallNewBinding c2 = c();
        if (c2 == null || (context = getContext()) == null || callMeStatusData == null) {
            return;
        }
        CallHelloManager.a().c();
        int i = callMeStatusData.call_status;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    c2.b.setBtnText(R.string.call_under_review);
                    return;
                } else if (i != 4) {
                    if (i != 5) {
                        return;
                    }
                    c2.b.setBtnText(getResources().getString(R.string.finish_call));
                    return;
                }
            }
            CallHelloManager.a().a(context, (IRequestHost) getFragmentActive(), 8);
        } else if (callMeStatusData.free_count != 0) {
            c2.b.setBtnText(R.string.free_call);
        } else if (callMeStatusData.pay_count == 0) {
            c2.b.setBtnText(R.string.open_call);
        } else {
            FloatFooterView floatFooterView = c2.b;
            floatFooterView.setBtnText(context.getString(R.string.open_call_x) + " X " + callMeStatusData.pay_count);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(HelloCallNewFragment helloCallNewFragment, View view) {
        ShapeTextView shapeTextView;
        Tracker.onClick(view);
        Intrinsics.e(helloCallNewFragment, "this$0");
        HelloCallNewHeaderBinding helloCallNewHeaderBinding = helloCallNewFragment.n;
        if (helloCallNewHeaderBinding == null || (shapeTextView = helloCallNewHeaderBinding.i) == null) {
            return;
        }
        shapeTextView.callOnClick();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(HelloCallNewFragment helloCallNewFragment, boolean z) {
        Intrinsics.e(helloCallNewFragment, "this$0");
        if (z) {
            CallHelloManager.a().a(helloCallNewFragment.getContext(), (IRequestHost) helloCallNewFragment.getFragmentActive(), false, 8);
        }
    }

    private final FragmentHelloCallNewBinding c() {
        return (FragmentHelloCallNewBinding) this.d.b(this, f18668c[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(HelloCallNewFragment helloCallNewFragment, View view) {
        LinearLayout linearLayout;
        Tracker.onClick(view);
        Intrinsics.e(helloCallNewFragment, "this$0");
        HelloCallNewHeaderBinding helloCallNewHeaderBinding = helloCallNewFragment.n;
        if (helloCallNewHeaderBinding == null || (linearLayout = helloCallNewHeaderBinding.f15371a) == null) {
            return;
        }
        linearLayout.callOnClick();
    }

    private final void d() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hello_call_new_header, (ViewGroup) null, false);
        this.l = inflate;
        Intrinsics.a(inflate);
        HelloCallNewHeaderBinding a2 = HelloCallNewHeaderBinding.a(inflate);
        this.n = a2;
        if (a2 == null) {
            return;
        }
        a2.h.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$HelloCallNewFragment$HosNImyNsnqmlrCe1iJNbq2vXUw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HelloCallNewFragment.d(HelloCallNewFragment.this, view);
            }
        });
        a2.i.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$HelloCallNewFragment$6CVXJTMD-0l1nP4uU94s4q_NcvY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HelloCallNewFragment.e(HelloCallNewFragment.this, view);
            }
        });
        a2.f15371a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$HelloCallNewFragment$Nvb8dihc8-VwZkKJn7zBvtrfHjQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HelloCallNewFragment.f(HelloCallNewFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(HelloCallNewFragment helloCallNewFragment, View view) {
        PullToRefreshRecyclerView pullToRefreshRecyclerView;
        Tracker.onClick(view);
        Intrinsics.e(helloCallNewFragment, "this$0");
        EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_AUTO_SORT_CLICK);
        helloCallNewFragment.h = "intelligent";
        helloCallNewFragment.h();
        FragmentHelloCallNewBinding c2 = helloCallNewFragment.c();
        if (c2 != null && (pullToRefreshRecyclerView = c2.f) != null) {
            pullToRefreshRecyclerView.k();
        }
        PeopleHelloQuickAdapter peopleHelloQuickAdapter = helloCallNewFragment.j;
        if (peopleHelloQuickAdapter == null) {
            return;
        }
        peopleHelloQuickAdapter.a(MessageProtos.SortType.AI_SORT_TYPE);
    }

    private final void e() {
        FragmentHelloCallNewBinding c2 = c();
        if (c2 == null) {
            return;
        }
        c2.g.a();
        c2.g.setLeftImg(2131233902);
        c2.g.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$HelloCallNewFragment$CMgp12rNJI7aJInHtZjB1MnT7bo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HelloCallNewFragment.g(HelloCallNewFragment.this, view);
            }
        });
        c2.g.setCenterText((int) R.string.hello_page_title);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(final HelloCallNewFragment helloCallNewFragment) {
        Intrinsics.e(helloCallNewFragment, "this$0");
        CallHelloManager.a().a(helloCallNewFragment.getContext(), (IRequestHost) helloCallNewFragment.getFragmentActive(), 8, new CallHelloManager.ToOpenListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$HelloCallNewFragment$C31_TSU1cv90hE0o0CttzB4xbls
            @Override // com.soft.blued.ui.find.manager.CallHelloManager.ToOpenListener
            public final void done(boolean z) {
                HelloCallNewFragment.a(HelloCallNewFragment.this, z);
            }
        });
        CallMeStatusData b2 = CallHelloManager.a().b();
        if (b2 != null) {
            int i = b2.call_status;
            if (i == 0) {
                if (b2.free_count != 0) {
                    EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.FREE_VOCATIVE);
                    return;
                } else if (b2.pay_count != 0) {
                    EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.OPEN_VOCATIVE_NUM);
                    return;
                } else {
                    EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.OPEN_VOCATIVE);
                    return;
                }
            }
            if (i != 1) {
                if (i == 2) {
                    EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.IN_CHECK);
                    return;
                } else if (i != 4) {
                    if (i != 5) {
                        return;
                    }
                    EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.COMPLETE_VOCATIVE);
                    return;
                }
            }
            EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.IN_VOCATIVE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(HelloCallNewFragment helloCallNewFragment, View view) {
        PullToRefreshRecyclerView pullToRefreshRecyclerView;
        Tracker.onClick(view);
        Intrinsics.e(helloCallNewFragment, "this$0");
        EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_DISTANCE_SORT_CLICK);
        helloCallNewFragment.h = "distance";
        helloCallNewFragment.h();
        FragmentHelloCallNewBinding c2 = helloCallNewFragment.c();
        if (c2 != null && (pullToRefreshRecyclerView = c2.f) != null) {
            pullToRefreshRecyclerView.k();
        }
        PeopleHelloQuickAdapter peopleHelloQuickAdapter = helloCallNewFragment.j;
        if (peopleHelloQuickAdapter == null) {
            return;
        }
        peopleHelloQuickAdapter.a(MessageProtos.SortType.DISTANCE_SORT_TYPE);
    }

    private final void f() {
        HelloCallNewHeaderBinding helloCallNewHeaderBinding = this.n;
        if (helloCallNewHeaderBinding == null) {
            return;
        }
        h();
        g();
        this.g = BluedConfig.a().E();
        helloCallNewHeaderBinding.f15372c.setVisibility(this.g ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final HelloCallNewFragment helloCallNewFragment) {
        Intrinsics.e(helloCallNewFragment, "this$0");
        CallHelloManager.a().a(helloCallNewFragment.getContext(), (IRequestHost) helloCallNewFragment.getFragmentActive(), 8, new CallHelloManager.ToOpenListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$HelloCallNewFragment$VyfAdgQDoXxDXkqCXXTiJWmpSzk
            @Override // com.soft.blued.ui.find.manager.CallHelloManager.ToOpenListener
            public final void done(boolean z) {
                HelloCallNewFragment.b(HelloCallNewFragment.this, z);
            }
        });
        CallMeStatusData b2 = CallHelloManager.a().b();
        if (b2 != null) {
            int i = b2.call_status;
            if (i == 0) {
                if (b2.free_count != 0) {
                    EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.FREE_VOCATIVE);
                    return;
                } else if (b2.pay_count != 0) {
                    EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.OPEN_VOCATIVE_NUM);
                    return;
                } else {
                    EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.OPEN_VOCATIVE);
                    return;
                }
            }
            if (i != 1) {
                if (i == 2) {
                    EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.IN_CHECK);
                    return;
                } else if (i != 4) {
                    if (i != 5) {
                        return;
                    }
                    EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.COMPLETE_VOCATIVE);
                    return;
                }
            }
            EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_BTN_CLICK, GuyProtos.BtnType.IN_VOCATIVE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final HelloCallNewFragment helloCallNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(helloCallNewFragment, "this$0");
        FragmentActivity activity = helloCallNewFragment.getActivity();
        if (activity == null) {
            return;
        }
        HelloFilterDialogFragment helloFilterDialogFragment = new HelloFilterDialogFragment();
        helloFilterDialogFragment.a(new HelloFilterDialogFragment.OnHelloFilterChange() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$HelloCallNewFragment$syJ6bQSDcvVefD1-q5WM63DHswg
            @Override // com.soft.blued.ui.msg.fragment.HelloFilterDialogFragment.OnHelloFilterChange
            public final void change(String str) {
                HelloCallNewFragment.a(HelloCallNewFragment.this, str);
            }
        });
        helloFilterDialogFragment.show(activity.getSupportFragmentManager(), HelloFilterDialogFragment.class.getSimpleName());
    }

    private final void g() {
        HelloCallNewHeaderBinding helloCallNewHeaderBinding = this.n;
        if (helloCallNewHeaderBinding != null) {
            if (TextUtils.isEmpty(a())) {
                helloCallNewHeaderBinding.f.setTextColor(BluedSkinUtils.a(getContext(), 2131102254));
                helloCallNewHeaderBinding.b.setImageDrawable(BluedSkinUtils.b(getContext(), (int) R.drawable.icon_hello_call_filter_close));
            } else {
                helloCallNewHeaderBinding.f.setTextColor(BluedSkinUtils.a(getContext(), 2131101766));
                helloCallNewHeaderBinding.b.setImageDrawable(BluedSkinUtils.b(getContext(), (int) R.drawable.icon_hello_call_filter_open));
            }
        }
        FragmentHelloCallNewBinding c2 = c();
        if (c2 == null) {
            return;
        }
        if (TextUtils.isEmpty(a())) {
            c2.h.setTextColor(BluedSkinUtils.a(getContext(), 2131102254));
            c2.f15160c.setImageDrawable(BluedSkinUtils.b(getContext(), (int) R.drawable.icon_hello_call_filter_close));
            return;
        }
        c2.h.setTextColor(BluedSkinUtils.a(getContext(), 2131101766));
        c2.f15160c.setImageDrawable(BluedSkinUtils.b(getContext(), (int) R.drawable.icon_hello_call_filter_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(HelloCallNewFragment helloCallNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(helloCallNewFragment, "this$0");
        FragmentActivity activity = helloCallNewFragment.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    private final void h() {
        HelloCallNewHeaderBinding helloCallNewHeaderBinding = this.n;
        if (helloCallNewHeaderBinding != null) {
            if (TextUtils.equals("intelligent", this.h)) {
                ShapeHelper.a(helloCallNewHeaderBinding.h, 2131102254);
                ShapeHelper.a(helloCallNewHeaderBinding.i, 2131102263);
                this.h = "intelligent";
                BluedPreferences.Z("intelligent");
            } else {
                ShapeHelper.a(helloCallNewHeaderBinding.h, 2131102263);
                ShapeHelper.a(helloCallNewHeaderBinding.i, 2131102254);
                this.h = "distance";
                BluedPreferences.Z("distance");
            }
        }
        FragmentHelloCallNewBinding c2 = c();
        if (c2 == null) {
            return;
        }
        if (TextUtils.equals("intelligent", this.h)) {
            ShapeHelper.a(c2.i, 2131102254);
            ShapeHelper.a(c2.j, 2131102263);
            this.h = "intelligent";
            BluedPreferences.Z("intelligent");
            return;
        }
        ShapeHelper.a(c2.i, 2131102263);
        ShapeHelper.a(c2.j, 2131102254);
        this.h = "distance";
        BluedPreferences.Z("distance");
    }

    private final void i() {
        final FragmentHelloCallNewBinding c2 = c();
        if (c2 == null) {
            return;
        }
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(getContext());
        this.m = noDataAndLoadFailView;
        Intrinsics.a(noDataAndLoadFailView);
        noDataAndLoadFailView.setNoDataStr((int) R.string.people_search_no_data_tip);
        NoDataAndLoadFailView noDataAndLoadFailView2 = this.m;
        Intrinsics.a(noDataAndLoadFailView2);
        noDataAndLoadFailView2.setNoDataImg(2131233637);
        NoDataAndLoadFailView noDataAndLoadFailView3 = this.m;
        Intrinsics.a(noDataAndLoadFailView3);
        noDataAndLoadFailView3.d();
        c2.f.setRefreshEnabled(true);
        c2.f.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$HelloCallNewFragment$HEOpuNqAMWrYnw8DmLXm0aLJ0Us
            public final void onRefresh(PullToRefreshBase pullToRefreshBase) {
                HelloCallNewFragment.a(HelloCallNewFragment.this, pullToRefreshBase);
            }
        });
        View refreshableView = c2.f.getRefreshableView();
        if (refreshableView == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        }
        RecyclerView recyclerView = (RecyclerView) refreshableView;
        this.o = recyclerView;
        final int[] iArr = new int[2];
        final int[] iArr2 = new int[2];
        Intrinsics.a(recyclerView);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soft.blued.ui.msg.fragment.HelloCallNewFragment$initList$1$2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView2, int i) {
                Intrinsics.e(recyclerView2, "recyclerView");
                if (FragmentHelloCallNewBinding.this.b == null || i != 0) {
                    return;
                }
                if (!recyclerView2.canScrollVertically(-1)) {
                    FragmentHelloCallNewBinding.this.b.startBtmBtnShow();
                } else if (recyclerView2.canScrollVertically(1)) {
                } else {
                    FragmentHelloCallNewBinding.this.b.startBtmBtnHide();
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
                r0 = r5.n;
             */
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onScrolled(androidx.recyclerview.widget.RecyclerView r5, int r6, int r7) {
                /*
                    r4 = this;
                    r0 = r5
                    java.lang.String r1 = "recyclerView"
                    kotlin.jvm.internal.Intrinsics.e(r0, r1)
                    r0 = r7
                    if (r0 >= 0) goto L17
                    r0 = r4
                    com.soft.blued.databinding.FragmentHelloCallNewBinding r0 = com.soft.blued.databinding.FragmentHelloCallNewBinding.this
                    com.blued.community.view.FloatFooterView r0 = r0.b
                    r0.startBtmBtnShow()
                    goto L25
                L17:
                    r0 = r7
                    if (r0 <= 0) goto L25
                    r0 = r4
                    com.soft.blued.databinding.FragmentHelloCallNewBinding r0 = com.soft.blued.databinding.FragmentHelloCallNewBinding.this
                    com.blued.community.view.FloatFooterView r0 = r0.b
                    r0.startBtmBtnHide()
                L25:
                    r0 = r4
                    com.soft.blued.ui.msg.fragment.HelloCallNewFragment r0 = r5
                    boolean r0 = com.soft.blued.ui.msg.fragment.HelloCallNewFragment.a(r0)
                    if (r0 == 0) goto L8d
                    r0 = r4
                    com.soft.blued.ui.msg.fragment.HelloCallNewFragment r0 = r5
                    com.soft.blued.databinding.HelloCallNewHeaderBinding r0 = com.soft.blued.ui.msg.fragment.HelloCallNewFragment.b(r0)
                    r5 = r0
                    r0 = r5
                    if (r0 != 0) goto L3c
                    return
                L3c:
                    r0 = r4
                    com.soft.blued.databinding.FragmentHelloCallNewBinding r0 = com.soft.blued.databinding.FragmentHelloCallNewBinding.this
                    r8 = r0
                    r0 = r4
                    int[] r0 = r6
                    r9 = r0
                    r0 = r4
                    int[] r0 = r7
                    r10 = r0
                    r0 = r8
                    com.blued.android.module.common.view.CommonTopTitleNoTrans r0 = r0.g
                    r1 = r9
                    r0.getLocationOnScreen(r1)
                    r0 = r9
                    r1 = 1
                    r0 = r0[r1]
                    r6 = r0
                    r0 = r8
                    android.widget.LinearLayout r0 = r0.d
                    int r0 = r0.getHeight()
                    r7 = r0
                    r0 = r5
                    android.widget.LinearLayout r0 = r0.f15372c
                    r1 = r10
                    r0.getLocationOnScreen(r1)
                    r0 = r10
                    r1 = 1
                    r0 = r0[r1]
                    r1 = r6
                    r2 = r7
                    int r1 = r1 + r2
                    if (r0 >= r1) goto L83
                    r0 = r8
                    android.widget.LinearLayout r0 = r0.d
                    r1 = 0
                    r0.setVisibility(r1)
                    return
                L83:
                    r0 = r8
                    android.widget.LinearLayout r0 = r0.d
                    r1 = 8
                    r0.setVisibility(r1)
                L8d:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.fragment.HelloCallNewFragment$initList$1$2.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
            }
        });
        c2.f.k();
        CallHelloManager.a().a(getContext(), (IRequestHost) getFragmentActive(), 8, (CallHelloManager.ToOpenListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        HelloCallNewFragment helloCallNewFragment = this;
        int i = this.e;
        int i2 = this.f;
        String str = this.g ? this.h : "";
        String str2 = this.g ? this.i : "";
        String a2 = NearbyHttpUtils.a(NearbyHttpUtils.a(getContext(), new FilterEntity()));
        Intrinsics.c(a2, "getFilterConditionJson(N…context, FilterEntity()))");
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        BluedStructureExtKt.a(helloCallNewFragment, new HelloCallAction.GetHelloCallData(i, i2, str, str2, a2, fragmentActive));
    }

    public final String a() {
        return this.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.blued.android.framework.http.parser.BluedEntity<com.soft.blued.ui.find.model.UserFindResult, com.soft.blued.ui.find.model.HelloDataExtra> r4) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.fragment.HelloCallNewFragment.a(com.blued.android.framework.http.parser.BluedEntity):void");
    }

    @Override // com.soft.blued.ui.find.observer.CallHelloObserver.ICallHelloObserver
    public void a(CallMeStatusData callMeStatusData) {
        b(callMeStatusData);
    }

    @Override // com.soft.blued.ui.find.observer.CallHelloObserver.ICallHelloObserver
    public void a(boolean z, String str) {
    }

    public void a(boolean z, boolean z2) {
        NoDataAndLoadFailView noDataAndLoadFailView;
        NoDataAndLoadFailView noDataAndLoadFailView2;
        FragmentHelloCallNewBinding c2 = c();
        if (c2 == null) {
            return;
        }
        if (z) {
            if (this.j == null || this.k == null) {
                b();
            }
            PeopleHelloQuickAdapter peopleHelloQuickAdapter = this.j;
            if (peopleHelloQuickAdapter != null) {
                peopleHelloQuickAdapter.setEnableLoadMore(z2);
            }
            PeopleHelloQuickAdapter peopleHelloQuickAdapter2 = this.j;
            Intrinsics.a(peopleHelloQuickAdapter2);
            if (peopleHelloQuickAdapter2.getItemCount() == 0 && (noDataAndLoadFailView2 = this.m) != null) {
                noDataAndLoadFailView2.a();
            }
        } else {
            PeopleHelloQuickAdapter peopleHelloQuickAdapter3 = this.j;
            boolean z3 = false;
            if (peopleHelloQuickAdapter3 != null && peopleHelloQuickAdapter3.getItemCount() == 0) {
                z3 = true;
            }
            if (z3 && (noDataAndLoadFailView = this.m) != null) {
                noDataAndLoadFailView.b();
            }
        }
        PeopleHelloQuickAdapter peopleHelloQuickAdapter4 = this.j;
        if (peopleHelloQuickAdapter4 != null) {
            peopleHelloQuickAdapter4.notifyDataSetChanged();
        }
        c2.f.j();
        PeopleHelloQuickAdapter peopleHelloQuickAdapter5 = this.j;
        if (peopleHelloQuickAdapter5 == null) {
            return;
        }
        peopleHelloQuickAdapter5.loadMoreComplete();
    }

    public final void b() {
        if (c() == null) {
            return;
        }
        RecyclerView recyclerView = this.o;
        if (recyclerView != null && this.j == null) {
            this.j = new PeopleHelloQuickAdapter(new ArrayList(), getActivity(), getFragmentActive(), "msg_hello_detail", recyclerView, this, 2);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
            PeopleHelloQuickAdapter peopleHelloQuickAdapter = this.j;
            Intrinsics.a(peopleHelloQuickAdapter);
            peopleHelloQuickAdapter.setEmptyView((View) this.m);
            PeopleHelloQuickAdapter peopleHelloQuickAdapter2 = this.j;
            Intrinsics.a(peopleHelloQuickAdapter2);
            peopleHelloQuickAdapter2.a(Intrinsics.a("intelligent", this.h) ? MessageProtos.SortType.AI_SORT_TYPE : MessageProtos.SortType.DISTANCE_SORT_TYPE);
            recyclerView.setAdapter(this.j);
            PeopleHelloQuickAdapter peopleHelloQuickAdapter3 = this.j;
            Intrinsics.a(peopleHelloQuickAdapter3);
            peopleHelloQuickAdapter3.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() { // from class: com.soft.blued.ui.msg.fragment.HelloCallNewFragment$initAdapter$1$1$1
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.RequestLoadMoreListener
                public void onLoadMoreRequested() {
                    int i;
                    HelloCallNewFragment helloCallNewFragment = HelloCallNewFragment.this;
                    i = helloCallNewFragment.e;
                    helloCallNewFragment.e = i + 1;
                    HelloCallNewFragment.this.j();
                }
            }, recyclerView);
        }
        HelloCallNewHeaderBinding helloCallNewHeaderBinding = this.n;
        if (helloCallNewHeaderBinding != null && this.k == null) {
            this.k = new PeopleHelloQuickAdapter(new ArrayList(), getActivity(), getFragmentActive(), "msg_hello_detail", helloCallNewHeaderBinding.d, this, 1);
            helloCallNewHeaderBinding.d.setLayoutManager(new GridLayoutManager(getContext(), 3));
            helloCallNewHeaderBinding.d.setAdapter(this.k);
        }
    }

    @Override // com.soft.blued.ui.find.observer.CallHelloObserver.ICallHelloObserver
    public void b(int i) {
        FloatFooterView floatFooterView;
        FragmentHelloCallNewBinding c2 = c();
        if (c2 == null || (floatFooterView = c2.b) == null) {
            return;
        }
        floatFooterView.setBtnText(TimeAndDateUtils.a(i, false));
    }

    public void m() {
        d();
        e();
        f();
        i();
        FragmentHelloCallNewBinding c2 = c();
        if (c2 == null) {
            return;
        }
        c2.b.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$HelloCallNewFragment$-dvlfZqfO2yfTwqyWt1N6m7eGlw
            @Override // com.blued.community.view.FloatFooterView.OnBtnClickListener
            public final void onPostFeedClick() {
                HelloCallNewFragment.e(HelloCallNewFragment.this);
            }
        });
        c2.b.setOnBtnClickListener(new FloatFooterView.OnBtnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$HelloCallNewFragment$LvTDXdZ9nuEF4wKkW5OHQ0Ap2yU
            @Override // com.blued.community.view.FloatFooterView.OnBtnClickListener
            public final void onPostFeedClick() {
                HelloCallNewFragment.f(HelloCallNewFragment.this);
            }
        });
        c2.i.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$HelloCallNewFragment$jaZ5L0XQe1Qm3U6QgjZTjrszqRY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HelloCallNewFragment.a(HelloCallNewFragment.this, view);
            }
        });
        c2.j.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$HelloCallNewFragment$JvKM33F8KjV65RjSqWgM6F6uHTk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HelloCallNewFragment.b(HelloCallNewFragment.this, view);
            }
        });
        c2.f15159a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.fragment.-$$Lambda$HelloCallNewFragment$7pIwmuuMR6heus0MCdqgf16zTXA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HelloCallNewFragment.c(HelloCallNewFragment.this, view);
            }
        });
    }

    public void o() {
        CallHelloObserver.a().a(this, getLifecycle());
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner, "viewLifecycleOwner");
        BluedStructureExtKt.a(this, viewLifecycleOwner, new PropertyReference1Impl() { // from class: com.soft.blued.ui.msg.fragment.HelloCallNewFragment$liveDataObserver$1
            public Object a(Object obj) {
                return ((HelloCallState) obj).a();
            }
        }, new Function1<BluedEntity<UserFindResult, HelloDataExtra>, Unit>() { // from class: com.soft.blued.ui.msg.fragment.HelloCallNewFragment$liveDataObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(BluedEntity<UserFindResult, HelloDataExtra> bluedEntity) {
                Intrinsics.e(bluedEntity, "it");
                HelloCallNewFragment.this.a(bluedEntity);
            }

            public /* synthetic */ Object invoke(Object obj) {
                a((BluedEntity) obj);
                return Unit.a;
            }
        });
    }
}
