package com.blued.android.module.yy_china.fragment;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.SharedPreferencesUtils;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.YYFollowAdapter;
import com.blued.android.module.yy_china.databinding.FragmentYyHomeMineBinding;
import com.blued.android.module.yy_china.listener.OnCLickRoomItemToGoRoomListener;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYChatRoomFollowedModel;
import com.blued.android.module.yy_china.presenter.YYHomeMineViewModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHomeMineFragment.class */
public final class YYHomeMineFragment extends MVVMBaseFragment<YYHomeMineViewModel> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f17281a = {Reflection.a(new PropertyReference1Impl(YYHomeMineFragment.class, "vb", "getVb()Lcom/blued/android/module/yy_china/databinding/FragmentYyHomeMineBinding;", 0))};
    private final ViewBindingProperty b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17282c;
    private final String d;
    private YYFollowAdapter e;
    private YYFollowAdapter f;
    private OnCLickRoomItemToGoRoomListener g;

    public YYHomeMineFragment() {
        super(R.layout.fragment_yy_home_mine);
        this.b = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<YYHomeMineFragment, FragmentYyHomeMineBinding>() { // from class: com.blued.android.module.yy_china.fragment.YYHomeMineFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentYyHomeMineBinding invoke(YYHomeMineFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyHomeMineBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<YYHomeMineFragment, FragmentYyHomeMineBinding>() { // from class: com.blued.android.module.yy_china.fragment.YYHomeMineFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentYyHomeMineBinding invoke(YYHomeMineFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyHomeMineBinding.a(fragment.requireView());
            }
        });
        this.f17282c = "YY_HOME_FOLLOW_GUIDE_TIME";
        this.d = "YY_HOME_FOLLOW_GUIDE_NUM";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYHomeMineFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        List<YYChatRoomFollowedModel> data;
        Intrinsics.e(this$0, "this$0");
        if (ClickUtils.a(R.id.item_follow_layout, 2000L)) {
            return;
        }
        YYChatRoomFollowedModel yYChatRoomFollowedModel = null;
        if (YYRoomInfoManager.e().c().l()) {
            Context context = this$0.getContext();
            AppMethods.a((CharSequence) (context == null ? null : context.getString(R.string.yy_living_toast)));
            return;
        }
        YYFollowAdapter yYFollowAdapter = this$0.f;
        if (yYFollowAdapter != null && (data = yYFollowAdapter.getData()) != null) {
            yYChatRoomFollowedModel = data.get(i);
        }
        Intrinsics.a(yYChatRoomFollowedModel);
        OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener = this$0.g;
        if (onCLickRoomItemToGoRoomListener != null && onCLickRoomItemToGoRoomListener != null) {
            onCLickRoomItemToGoRoomListener.a(yYChatRoomFollowedModel.room_id, this$0.j().d());
        }
        this$0.a(yYChatRoomFollowedModel, "history_room");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYHomeMineFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        LogUtils.d("EVENT_REFRESH_OR_LOAD_MORE_FINISH", Intrinsics.a("YYMineFragment refresh event tab type: ", (Object) str));
        if (TextUtils.equals(str, "-1")) {
            YYHomeMineViewModel j = this$0.j();
            ActivityFragmentActive fragmentActive = this$0.getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            j.a(fragmentActive);
        }
    }

    private final void a(YYChatRoomFollowedModel yYChatRoomFollowedModel, String str) {
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_TAB_PAGE_ROOM_CLICK, yYChatRoomFollowedModel.room_id, yYChatRoomFollowedModel.uid, "-1", yYChatRoomFollowedModel.type_id, false, str, j().d(), yYChatRoomFollowedModel.label_link);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<? extends YYChatRoomFollowedModel> list) {
        FragmentYyHomeMineBinding p = p();
        RecyclerView recyclerView = p == null ? null : p.m;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        FragmentYyHomeMineBinding p2 = p();
        TextView textView = p2 == null ? null : p2.p;
        if (textView != null) {
            textView.setVisibility(8);
        }
        YYFollowAdapter yYFollowAdapter = this.f;
        Intrinsics.a(yYFollowAdapter);
        yYFollowAdapter.setNewData(list);
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYHomeMineFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        List<YYChatRoomFollowedModel> data;
        Intrinsics.e(this$0, "this$0");
        YYFollowAdapter yYFollowAdapter = this$0.e;
        YYChatRoomFollowedModel yYChatRoomFollowedModel = (yYFollowAdapter == null || (data = yYFollowAdapter.getData()) == null) ? null : data.get(i);
        Intrinsics.a(yYChatRoomFollowedModel);
        if (yYChatRoomFollowedModel.isOnLive()) {
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_FOLLOW_ROOM_CLICK, yYChatRoomFollowedModel.room_id, yYChatRoomFollowedModel.uid, yYChatRoomFollowedModel.type_id, ChatRoomProtos.From.FOLLOW_ROOM_LIST_SECOND_PAGE);
        } else {
            EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_FOLLOW_ROOM_CLICK, (String) null, yYChatRoomFollowedModel.uid, yYChatRoomFollowedModel.type_id, ChatRoomProtos.From.FOLLOW_ROOM_LIST_SECOND_PAGE);
        }
        if (!yYChatRoomFollowedModel.isOnLive()) {
            YYRoomInfoManager.e().c().a(this$0.getContext(), yYChatRoomFollowedModel.uid, yYChatRoomFollowedModel.name, yYChatRoomFollowedModel.avatar, 0, 2);
        } else if (ClickUtils.a(R.id.item_follow_layout, 2000L)) {
        } else {
            if (YYRoomInfoManager.e().c().l()) {
                AppMethods.a((CharSequence) this$0.getString(R.string.yy_living_toast));
                return;
            }
            this$0.j().f(true);
            OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener = this$0.g;
            if (onCLickRoomItemToGoRoomListener != null) {
                onCLickRoomItemToGoRoomListener.a(yYChatRoomFollowedModel.room_id, this$0.j().d());
            }
            this$0.a(yYChatRoomFollowedModel, "follow_room");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(List<? extends YYChatRoomFollowedModel> list) {
        FragmentYyHomeMineBinding p = p();
        RecyclerView recyclerView = p == null ? null : p.l;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        FragmentYyHomeMineBinding p2 = p();
        TextView textView = p2 == null ? null : p2.n;
        if (textView != null) {
            textView.setVisibility(8);
        }
        YYFollowAdapter yYFollowAdapter = this.e;
        if (yYFollowAdapter != null) {
            yYFollowAdapter.setNewData(list);
        }
        t();
        for (YYChatRoomFollowedModel yYChatRoomFollowedModel : list) {
            if (yYChatRoomFollowedModel.isOnLive()) {
                Calendar calendar = Calendar.getInstance();
                Intrinsics.c(calendar, "getInstance()");
                calendar.set(11, 0);
                calendar.set(12, 0);
                calendar.set(13, 0);
                calendar.set(14, 0);
                long timeInMillis = calendar.getTimeInMillis() / 1000;
                if (timeInMillis == SharedPreferencesUtils.b().getLong(Intrinsics.a(this.f17282c, (Object) YYRoomInfoManager.e().k()), 0L)) {
                    int i = SharedPreferencesUtils.b().getInt(Intrinsics.a(this.d, (Object) YYRoomInfoManager.e().k()), 0);
                    if (i >= 1) {
                        return;
                    }
                    SharedPreferencesUtils.b().edit().putInt(Intrinsics.a(this.d, (Object) YYRoomInfoManager.e().k()), i + 1).apply();
                } else {
                    SharedPreferencesUtils.b().edit().putLong(Intrinsics.a(this.f17282c, (Object) YYRoomInfoManager.e().k()), timeInMillis).apply();
                    SharedPreferencesUtils.b().edit().putInt(Intrinsics.a(this.d, (Object) YYRoomInfoManager.e().k()), 0).apply();
                }
                OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener = this.g;
                if (onCLickRoomItemToGoRoomListener == null) {
                    return;
                }
                onCLickRoomItemToGoRoomListener.q();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean z) {
        FragmentYyHomeMineBinding p = p();
        RecyclerView recyclerView = p == null ? null : p.m;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        FragmentYyHomeMineBinding p2 = p();
        TextView textView = p2 == null ? null : p2.p;
        if (textView != null) {
            textView.setVisibility(0);
        }
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(boolean z) {
        FragmentYyHomeMineBinding p = p();
        RecyclerView recyclerView = p == null ? null : p.l;
        if (recyclerView != null) {
            recyclerView.setVisibility(8);
        }
        FragmentYyHomeMineBinding p2 = p();
        TextView textView = p2 == null ? null : p2.n;
        if (textView != null) {
            textView.setVisibility(0);
        }
        t();
    }

    private final void d(boolean z) {
        ImageView imageView;
        FragmentYyHomeMineBinding p = p();
        FrameLayout frameLayout = p == null ? null : p.f16504a;
        if (frameLayout != null) {
            frameLayout.setVisibility(z ? 8 : 0);
        }
        FragmentYyHomeMineBinding p2 = p();
        View view = p2 == null ? null : p2.f16505c;
        if (view != null) {
            int i = 8;
            if (z) {
                i = 0;
            }
            view.setVisibility(i);
        }
        FragmentYyHomeMineBinding p3 = p();
        TextView textView = p3 == null ? null : p3.o;
        if (textView != null) {
            textView.setText(z ? "展开" : "收起");
        }
        FragmentYyHomeMineBinding p4 = p();
        if (p4 == null || (imageView = p4.d) == null) {
            return;
        }
        imageView.setImageDrawable(BluedSkinUtils.b(getContext(), z ? R.drawable.icon_yy_arrow_down : R.drawable.icon_yy_arrow_up));
    }

    private final void e(boolean z) {
        ImageView imageView;
        FragmentYyHomeMineBinding p = p();
        FrameLayout frameLayout = p == null ? null : p.b;
        if (frameLayout != null) {
            frameLayout.setVisibility(z ? 8 : 0);
        }
        FragmentYyHomeMineBinding p2 = p();
        TextView textView = p2 == null ? null : p2.q;
        if (textView != null) {
            textView.setText(z ? "展开" : "收起");
        }
        FragmentYyHomeMineBinding p3 = p();
        if (p3 == null || (imageView = p3.e) == null) {
            return;
        }
        imageView.setImageDrawable(BluedSkinUtils.b(getContext(), z ? R.drawable.icon_yy_arrow_down : R.drawable.icon_yy_arrow_up));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentYyHomeMineBinding p() {
        return (FragmentYyHomeMineBinding) this.b.b(this, f17281a[0]);
    }

    private final void q() {
        Context context = getContext();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        String d = j().d();
        Intrinsics.a((Object) d);
        this.f = new YYFollowAdapter(context, fragmentActive, d, "history_room");
        FragmentYyHomeMineBinding p = p();
        RecyclerView recyclerView = p == null ? null : p.m;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(s());
        }
        FragmentYyHomeMineBinding p2 = p();
        RecyclerView recyclerView2 = p2 == null ? null : p2.m;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f);
        }
        YYFollowAdapter yYFollowAdapter = this.f;
        if (yYFollowAdapter != null) {
            yYFollowAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHomeMineFragment$sqzKMqwja5xKy3eQ1gqLV4NhxdY
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    YYHomeMineFragment.a(YYHomeMineFragment.this, baseQuickAdapter, view, i);
                }
            });
        }
        e(!j().g());
        YYFollowAdapter yYFollowAdapter2 = this.f;
        if (yYFollowAdapter2 == null) {
            return;
        }
        yYFollowAdapter2.a(true);
    }

    private final void r() {
        Context context = getContext();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        String d = j().d();
        Intrinsics.a((Object) d);
        this.e = new YYFollowAdapter(context, fragmentActive, d, "follow_room");
        FragmentYyHomeMineBinding p = p();
        RecyclerView recyclerView = p == null ? null : p.l;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(s());
        }
        FragmentYyHomeMineBinding p2 = p();
        RecyclerView recyclerView2 = p2 == null ? null : p2.l;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.e);
        }
        YYFollowAdapter yYFollowAdapter = this.e;
        if (yYFollowAdapter != null) {
            yYFollowAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHomeMineFragment$9NZrRiAuPaLOYRPeOcBYWm7QyN0
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    YYHomeMineFragment.b(YYHomeMineFragment.this, baseQuickAdapter, view, i);
                }
            });
        }
        d(!j().f());
        YYFollowAdapter yYFollowAdapter2 = this.e;
        if (yYFollowAdapter2 == null) {
            return;
        }
        yYFollowAdapter2.a(true);
    }

    private final LinearLayoutManager s() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        return linearLayoutManager;
    }

    private final void t() {
        LiveEventBus.get("refresh_or_loadmore_finish").post("");
    }

    public final void a(OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener) {
        this.g = onCLickRoomItemToGoRoomListener;
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        SmartRefreshLayout smartRefreshLayout4;
        r();
        q();
        FragmentYyHomeMineBinding p = p();
        if (p != null && (smartRefreshLayout4 = p.i) != null) {
            smartRefreshLayout4.l(false);
        }
        FragmentYyHomeMineBinding p2 = p();
        if (p2 != null && (linearLayout2 = p2.g) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentYyHomeMineBinding p3 = p();
        if (p3 != null && (linearLayout = p3.h) != null) {
            linearLayout.setOnClickListener(this);
        }
        FragmentYyHomeMineBinding p4 = p();
        if (p4 != null && (smartRefreshLayout3 = p4.i) != null) {
            smartRefreshLayout3.l(false);
        }
        if (j().e()) {
            FragmentYyHomeMineBinding p5 = p();
            if (p5 == null || (smartRefreshLayout = p5.i) == null) {
                return;
            }
            smartRefreshLayout.a(new OnRefreshLoadMoreListener() { // from class: com.blued.android.module.yy_china.fragment.YYHomeMineFragment$initView$1
                @Override // com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
                public void onLoadMore(RefreshLayout refreshLayout) {
                    Intrinsics.e(refreshLayout, "refreshLayout");
                }

                @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
                public void onRefresh(RefreshLayout refreshLayout) {
                    YYHomeMineViewModel j;
                    FragmentYyHomeMineBinding p6;
                    OnCLickRoomItemToGoRoomListener onCLickRoomItemToGoRoomListener;
                    SmartRefreshLayout smartRefreshLayout5;
                    Intrinsics.e(refreshLayout, "refreshLayout");
                    j = YYHomeMineFragment.this.j();
                    ActivityFragmentActive fragmentActive = YYHomeMineFragment.this.getFragmentActive();
                    Intrinsics.c(fragmentActive, "fragmentActive");
                    j.a(fragmentActive);
                    p6 = YYHomeMineFragment.this.p();
                    if (p6 != null && (smartRefreshLayout5 = p6.i) != null) {
                        smartRefreshLayout5.j();
                    }
                    onCLickRoomItemToGoRoomListener = YYHomeMineFragment.this.g;
                    if (onCLickRoomItemToGoRoomListener == null) {
                        return;
                    }
                    onCLickRoomItemToGoRoomListener.r();
                }
            });
            return;
        }
        FragmentYyHomeMineBinding p6 = p();
        if (p6 == null || (smartRefreshLayout2 = p6.i) == null) {
            return;
        }
        smartRefreshLayout2.c(false);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void k() {
        LiveEventBus.get("refresh_or_loadmore", String.class).observe(this, new Observer() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHomeMineFragment$mcfD5KJdJFDE54geRW6rBJ_NQ0c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YYHomeMineFragment.a(YYHomeMineFragment.this, (String) obj);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        YYHomeMineFragment yYHomeMineFragment = this;
        LifecycleExtKt.a(yYHomeMineFragment, j().i(), new YYHomeMineFragment$liveDataObserver$1(this));
        LifecycleExtKt.a(yYHomeMineFragment, j().j(), new YYHomeMineFragment$liveDataObserver$2(this));
        LifecycleExtKt.a(yYHomeMineFragment, j().l(), new YYHomeMineFragment$liveDataObserver$3(this));
        LifecycleExtKt.a(yYHomeMineFragment, j().k(), new YYHomeMineFragment$liveDataObserver$4(this));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        Intrinsics.a(view);
        int id = view.getId();
        if (id == R.id.ll_history_flexible) {
            boolean g = j().g();
            e(g);
            j().e(!g);
        } else if (id == R.id.ll_follow_flexible) {
            boolean f = j().f();
            d(f);
            j().d(!f);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        YYFollowAdapter yYFollowAdapter = this.e;
        if (yYFollowAdapter != null) {
            yYFollowAdapter.a(false);
        }
        YYFollowAdapter yYFollowAdapter2 = this.f;
        if (yYFollowAdapter2 == null) {
            return;
        }
        yYFollowAdapter2.a(false);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (j().h()) {
            j().f(false);
            YYHomeMineViewModel j = j();
            ActivityFragmentActive fragmentActive = getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            j.a(fragmentActive);
        }
    }
}
