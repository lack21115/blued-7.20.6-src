package com.blued.android.module.live.base.music;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.live.base.R;
import com.blued.android.module.live.base.databinding.FragmentYyMusicListBinding;
import com.blued.android.module.live.base.databinding.YyMusicListLoadErrorBinding;
import com.blued.android.module.live.base.databinding.YyMusicListNoDataBinding;
import com.blued.android.module.live.base.databinding.YyMusicSearchNoDataBinding;
import com.blued.android.module.live.base.music.adapter.YYBackgroundMusicListAdapter;
import com.blued.android.module.live.base.music.adapter.YYMusicEventCallBack;
import com.blued.android.module.live.base.music.model.YYKtvMusicModel;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/YyBackgroundItemFragment.class */
public final class YyBackgroundItemFragment extends MVVMBaseFragment<YYBackgroundItemViewModel> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f11437a = {Reflection.a(new PropertyReference1Impl(YyBackgroundItemFragment.class, "vb", "getVb()Lcom/blued/android/module/live/base/databinding/FragmentYyMusicListBinding;", 0))};
    private final ViewBindingProperty b;

    /* renamed from: c  reason: collision with root package name */
    private YYBackgroundMusicListAdapter f11438c;
    private BackgroundMusicView d;
    private BlackMusicListener e;
    private final Observer<String> f;
    private final Observer<String> g;

    public YyBackgroundItemFragment() {
        super(R.layout.fragment_yy_music_list);
        this.b = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<YyBackgroundItemFragment, FragmentYyMusicListBinding>() { // from class: com.blued.android.module.live.base.music.YyBackgroundItemFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentYyMusicListBinding invoke(YyBackgroundItemFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyMusicListBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<YyBackgroundItemFragment, FragmentYyMusicListBinding>() { // from class: com.blued.android.module.live.base.music.YyBackgroundItemFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentYyMusicListBinding invoke(YyBackgroundItemFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyMusicListBinding.a(fragment.requireView());
            }
        });
        this.f = new Observer() { // from class: com.blued.android.module.live.base.music.-$$Lambda$YyBackgroundItemFragment$q3BPabKbEpyqAZhJ-BRzxMnIi6w
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YyBackgroundItemFragment.a(YyBackgroundItemFragment.this, (String) obj);
            }
        };
        this.g = new Observer() { // from class: com.blued.android.module.live.base.music.-$$Lambda$YyBackgroundItemFragment$DMR6fIF0_xWS46uM2yx6FZauLBk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YyBackgroundItemFragment.b(YyBackgroundItemFragment.this, (String) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YyBackgroundItemFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        YYBackgroundMusicListAdapter yYBackgroundMusicListAdapter = this$0.f11438c;
        if (yYBackgroundMusicListAdapter == null) {
            return;
        }
        yYBackgroundMusicListAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<? extends YYKtvMusicModel> list) {
        YYBackgroundMusicListAdapter yYBackgroundMusicListAdapter;
        if (list == null || (yYBackgroundMusicListAdapter = this.f11438c) == null) {
            return;
        }
        yYBackgroundMusicListAdapter.addData((Collection) list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YyBackgroundItemFragment this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        YYBackgroundMusicListAdapter yYBackgroundMusicListAdapter = this$0.f11438c;
        if (yYBackgroundMusicListAdapter == null) {
            return;
        }
        yYBackgroundMusicListAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(List<? extends YYKtvMusicModel> list) {
        LogUtils.c("music", Intrinsics.a("showDataToUI list=", (Object) (list == null ? null : Integer.valueOf(list.size()))));
        if (list == null) {
            return;
        }
        FragmentYyMusicListBinding p = p();
        RecyclerView recyclerView = p == null ? null : p.e;
        if (recyclerView != null) {
            recyclerView.setVisibility(0);
        }
        YYBackgroundMusicListAdapter yYBackgroundMusicListAdapter = this.f11438c;
        if (yYBackgroundMusicListAdapter == null) {
            return;
        }
        yYBackgroundMusicListAdapter.a(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void b(boolean z) {
        ArrayList arrayList;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        FragmentYyMusicListBinding p = p();
        ProgressBar progressBar = p == null ? null : p.d;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        YYBackgroundMusicListAdapter yYBackgroundMusicListAdapter = this.f11438c;
        if (yYBackgroundMusicListAdapter == null) {
            arrayList = new ArrayList();
        } else {
            List data = yYBackgroundMusicListAdapter == null ? null : yYBackgroundMusicListAdapter.getData();
            Intrinsics.a(data);
            Intrinsics.c(data, "musicAdapter?.data!!");
            arrayList = data;
        }
        if (arrayList.size() <= 0) {
            e(false);
            return;
        }
        YYKtvMusicModel yYKtvMusicModel = (YYKtvMusicModel) arrayList.get(arrayList.size() - 1);
        if (yYKtvMusicModel != null && yYKtvMusicModel.type != 1) {
            YYKtvMusicModel yYKtvMusicModel2 = new YYKtvMusicModel();
            yYKtvMusicModel2.type = 1;
            arrayList.add(yYKtvMusicModel2);
            YYBackgroundMusicListAdapter yYBackgroundMusicListAdapter2 = this.f11438c;
            if (yYBackgroundMusicListAdapter2 != 0) {
                yYBackgroundMusicListAdapter2.a(arrayList);
            }
        }
        FragmentYyMusicListBinding p2 = p();
        if (p2 != null && (smartRefreshLayout2 = p2.f) != null) {
            smartRefreshLayout2.h();
        }
        FragmentYyMusicListBinding p3 = p();
        if (p3 == null || (smartRefreshLayout = p3.f) == null) {
            return;
        }
        smartRefreshLayout.l(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(boolean z) {
        SmartRefreshLayout smartRefreshLayout;
        FragmentYyMusicListBinding p = p();
        if (p == null || (smartRefreshLayout = p.f) == null) {
            return;
        }
        smartRefreshLayout.l(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(boolean z) {
        YyMusicListNoDataBinding yyMusicListNoDataBinding;
        FrameLayout root;
        if (t()) {
            FragmentYyMusicListBinding p = p();
            LinearLayout root2 = (p == null || (yyMusicListNoDataBinding = p.f11380a) == null) ? null : yyMusicListNoDataBinding.getRoot();
            if (root2 != null) {
                root2.setVisibility(8);
            }
            FragmentYyMusicListBinding p2 = p();
            RecyclerView recyclerView = p2 == null ? null : p2.e;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            if (j().e()) {
                return;
            }
            FragmentYyMusicListBinding p3 = p();
            if (p3 == null) {
                root = null;
            } else {
                YyMusicListLoadErrorBinding yyMusicListLoadErrorBinding = p3.f11381c;
                root = yyMusicListLoadErrorBinding == null ? null : yyMusicListLoadErrorBinding.getRoot();
            }
            if (root == null) {
                return;
            }
            root.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(boolean z) {
        YyMusicListNoDataBinding yyMusicListNoDataBinding;
        FrameLayout root;
        YyMusicSearchNoDataBinding yyMusicSearchNoDataBinding;
        if (t()) {
            if (j().e()) {
                FragmentYyMusicListBinding p = p();
                LinearLayout root2 = (p == null || (yyMusicSearchNoDataBinding = p.b) == null) ? null : yyMusicSearchNoDataBinding.getRoot();
                if (root2 != null) {
                    root2.setVisibility(0);
                }
            } else {
                FragmentYyMusicListBinding p2 = p();
                LinearLayout root3 = (p2 == null || (yyMusicListNoDataBinding = p2.f11380a) == null) ? null : yyMusicListNoDataBinding.getRoot();
                if (root3 != null) {
                    root3.setVisibility(0);
                }
            }
            FragmentYyMusicListBinding p3 = p();
            RecyclerView recyclerView = p3 == null ? null : p3.e;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            FragmentYyMusicListBinding p4 = p();
            if (p4 == null) {
                root = null;
            } else {
                YyMusicListLoadErrorBinding yyMusicListLoadErrorBinding = p4.f11381c;
                root = yyMusicListLoadErrorBinding == null ? null : yyMusicListLoadErrorBinding.getRoot();
            }
            if (root == null) {
                return;
            }
            root.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(boolean z) {
        FragmentYyMusicListBinding p = p();
        ProgressBar progressBar = p == null ? null : p.d;
        if (progressBar == null) {
            return;
        }
        progressBar.setVisibility(0);
    }

    private final void r() {
        LiveEventBus.get("live_music_changed", String.class).observeForever(this.f);
        LiveEventBus.get("live_music_exit", String.class).observeForever(this.g);
    }

    private final void s() {
        LiveEventBus.get("live_music_changed", String.class).removeObserver(this.f);
        LiveEventBus.get("live_music_exit", String.class).removeObserver(this.g);
    }

    private final boolean t() {
        YyMusicSearchNoDataBinding yyMusicSearchNoDataBinding;
        YyMusicListNoDataBinding yyMusicListNoDataBinding;
        FrameLayout root;
        SmartRefreshLayout smartRefreshLayout;
        FragmentYyMusicListBinding p = p();
        ProgressBar progressBar = p == null ? null : p.d;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        FragmentYyMusicListBinding p2 = p();
        if (p2 != null && (smartRefreshLayout = p2.f) != null) {
            smartRefreshLayout.h();
        }
        YYBackgroundMusicListAdapter yYBackgroundMusicListAdapter = this.f11438c;
        if (yYBackgroundMusicListAdapter != null && yYBackgroundMusicListAdapter.c() > 0) {
            FragmentYyMusicListBinding p3 = p();
            LinearLayout root2 = (p3 == null || (yyMusicSearchNoDataBinding = p3.b) == null) ? null : yyMusicSearchNoDataBinding.getRoot();
            if (root2 != null) {
                root2.setVisibility(8);
            }
            FragmentYyMusicListBinding p4 = p();
            LinearLayout root3 = (p4 == null || (yyMusicListNoDataBinding = p4.f11380a) == null) ? null : yyMusicListNoDataBinding.getRoot();
            if (root3 != null) {
                root3.setVisibility(8);
            }
            FragmentYyMusicListBinding p5 = p();
            RecyclerView recyclerView = p5 == null ? null : p5.e;
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
            }
            FragmentYyMusicListBinding p6 = p();
            if (p6 == null) {
                root = null;
            } else {
                YyMusicListLoadErrorBinding yyMusicListLoadErrorBinding = p6.f11381c;
                root = yyMusicListLoadErrorBinding == null ? null : yyMusicListLoadErrorBinding.getRoot();
            }
            if (root == null) {
                return false;
            }
            root.setVisibility(8);
            return false;
        }
        return true;
    }

    public final void a(BackgroundMusicView backgroundMusicView) {
        this.d = backgroundMusicView;
    }

    public final void a(BlackMusicListener blackMusicListener) {
        this.e = blackMusicListener;
    }

    public final void a(String searchKey) {
        Intrinsics.e(searchKey, "searchKey");
        YYBackgroundMusicListAdapter yYBackgroundMusicListAdapter = this.f11438c;
        if (yYBackgroundMusicListAdapter != null && yYBackgroundMusicListAdapter != null) {
            yYBackgroundMusicListAdapter.a((List<? extends YYKtvMusicModel>) null);
        }
        YYBackgroundItemViewModel j = j();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        j.a(searchKey, fragmentActive);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        YyMusicListLoadErrorBinding yyMusicListLoadErrorBinding;
        ShapeTextView shapeTextView;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        SmartRefreshLayout smartRefreshLayout4;
        YYBackgroundMusicListAdapter yYBackgroundMusicListAdapter = new YYBackgroundMusicListAdapter();
        this.f11438c = yYBackgroundMusicListAdapter;
        if (yYBackgroundMusicListAdapter != null) {
            yYBackgroundMusicListAdapter.a(this.e);
        }
        FragmentYyMusicListBinding p = p();
        if (p != null && (smartRefreshLayout4 = p.f) != null) {
            smartRefreshLayout4.l(false);
        }
        FragmentYyMusicListBinding p2 = p();
        if (p2 != null && (smartRefreshLayout3 = p2.f) != null) {
            smartRefreshLayout3.c(false);
        }
        FragmentYyMusicListBinding p3 = p();
        if (p3 != null && (smartRefreshLayout2 = p3.f) != null) {
            smartRefreshLayout2.a(new MusicLoadMoreView(getContext()));
        }
        FragmentYyMusicListBinding p4 = p();
        if (p4 != null && (smartRefreshLayout = p4.f) != null) {
            smartRefreshLayout.b((OnMultiPurposeListener) new SimpleMultiPurposeListener() { // from class: com.blued.android.module.live.base.music.YyBackgroundItemFragment$initView$1
                @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnLoadMoreListener
                public void onLoadMore(RefreshLayout refreshLayout) {
                    YYBackgroundItemViewModel j;
                    Intrinsics.e(refreshLayout, "refreshLayout");
                    j = YyBackgroundItemFragment.this.j();
                    ActivityFragmentActive fragmentActive = YyBackgroundItemFragment.this.getFragmentActive();
                    Intrinsics.c(fragmentActive, "fragmentActive");
                    j.a(fragmentActive);
                }

                @Override // com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener, com.scwang.smartrefresh.layout.listener.OnRefreshListener
                public void onRefresh(RefreshLayout refreshLayout) {
                    Intrinsics.e(refreshLayout, "refreshLayout");
                }
            });
        }
        FragmentYyMusicListBinding p5 = p();
        if (p5 != null && (yyMusicListLoadErrorBinding = p5.f11381c) != null && (shapeTextView = yyMusicListLoadErrorBinding.f11401a) != null) {
            shapeTextView.setOnClickListener(this);
        }
        YYBackgroundMusicListAdapter yYBackgroundMusicListAdapter2 = this.f11438c;
        if (yYBackgroundMusicListAdapter2 != null) {
            yYBackgroundMusicListAdapter2.setEnableLoadMore(false);
        }
        YYBackgroundMusicListAdapter yYBackgroundMusicListAdapter3 = this.f11438c;
        if (yYBackgroundMusicListAdapter3 != null) {
            yYBackgroundMusicListAdapter3.a(new YYMusicEventCallBack() { // from class: com.blued.android.module.live.base.music.YyBackgroundItemFragment$initView$2
                @Override // com.blued.android.module.live.base.music.adapter.YYMusicEventCallBack
                public Boolean a(String music_id) {
                    YYPlayMusicListener playMusicListener;
                    Intrinsics.e(music_id, "music_id");
                    BackgroundMusicView q = YyBackgroundItemFragment.this.q();
                    if (q == null || (playMusicListener = q.getPlayMusicListener()) == null) {
                        return null;
                    }
                    return Boolean.valueOf(playMusicListener.a(music_id));
                }

                @Override // com.blued.android.module.live.base.music.adapter.YYMusicEventCallBack
                public void a(YYKtvMusicModel model) {
                    YYBackgroundItemViewModel j;
                    YYBackgroundItemViewModel j2;
                    Intrinsics.e(model, "model");
                    BackgroundMusicView q = YyBackgroundItemFragment.this.q();
                    if (q == null) {
                        return;
                    }
                    YyBackgroundItemFragment yyBackgroundItemFragment = YyBackgroundItemFragment.this;
                    if (q.getPlayMusicListener().a(model.musicId)) {
                        return;
                    }
                    j = yyBackgroundItemFragment.j();
                    model.sheetId = j.d();
                    j2 = yyBackgroundItemFragment.j();
                    model.fromSearchPage = j2.e();
                    q.a(model);
                }

                @Override // com.blued.android.module.live.base.music.adapter.YYMusicEventCallBack
                public Boolean b(String music_id) {
                    YYPlayMusicListener playMusicListener;
                    Intrinsics.e(music_id, "music_id");
                    BackgroundMusicView q = YyBackgroundItemFragment.this.q();
                    if (q == null || (playMusicListener = q.getPlayMusicListener()) == null) {
                        return null;
                    }
                    return Boolean.valueOf(playMusicListener.b(music_id));
                }

                @Override // com.blued.android.module.live.base.music.adapter.YYMusicEventCallBack
                public void b(YYKtvMusicModel music) {
                    BackgroundMusicView q;
                    YYPlayMusicListener playMusicListener;
                    Intrinsics.e(music, "music");
                    if (YyBackgroundItemFragment.this.q() != null) {
                        BackgroundMusicView q2 = YyBackgroundItemFragment.this.q();
                        if ((q2 == null ? null : q2.getPlayMusicListener()) == null || (q = YyBackgroundItemFragment.this.q()) == null || (playMusicListener = q.getPlayMusicListener()) == null) {
                            return;
                        }
                        playMusicListener.b(music);
                    }
                }

                @Override // com.blued.android.module.live.base.music.adapter.YYMusicEventCallBack
                public Boolean c(String music_id) {
                    YYPlayMusicListener playMusicListener;
                    Intrinsics.e(music_id, "music_id");
                    BackgroundMusicView q = YyBackgroundItemFragment.this.q();
                    if (q == null || (playMusicListener = q.getPlayMusicListener()) == null) {
                        return null;
                    }
                    return Boolean.valueOf(playMusicListener.d(music_id));
                }
            });
        }
        FragmentYyMusicListBinding p6 = p();
        RecyclerView recyclerView = p6 == null ? null : p6.e;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        FragmentYyMusicListBinding p7 = p();
        RecyclerView recyclerView2 = p7 == null ? null : p7.e;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f11438c);
        }
        YYBackgroundItemViewModel j = j();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        j.b(fragmentActive);
        BlackMusicListener blackMusicListener = this.e;
        if (blackMusicListener == null || blackMusicListener.f() == null) {
            return;
        }
        blackMusicListener.a(ChatRoomProtos.Event.CHAT_ROOM_TOOLBOX_MUSIC_TAB_SHOW, LiveProtos.Event.LIVE_MUSIC_TAB_PAGE_SHOW, blackMusicListener.f(), j().d());
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        YyBackgroundItemFragment yyBackgroundItemFragment = this;
        LifecycleExtKt.a(yyBackgroundItemFragment, j().g(), new YyBackgroundItemFragment$liveDataObserver$1(this));
        LifecycleExtKt.a(yyBackgroundItemFragment, j().h(), new YyBackgroundItemFragment$liveDataObserver$2(this));
        LifecycleExtKt.a(yyBackgroundItemFragment, j().i(), new YyBackgroundItemFragment$liveDataObserver$3(this));
        LifecycleExtKt.a(yyBackgroundItemFragment, j().m(), new YyBackgroundItemFragment$liveDataObserver$4(this));
        LifecycleExtKt.a(yyBackgroundItemFragment, j().n(), new YyBackgroundItemFragment$liveDataObserver$5(this));
        LifecycleExtKt.a(yyBackgroundItemFragment, j().k(), new YyBackgroundItemFragment$liveDataObserver$6(this));
        LifecycleExtKt.a(yyBackgroundItemFragment, j().l(), new YyBackgroundItemFragment$liveDataObserver$7(this));
        LifecycleExtKt.a(yyBackgroundItemFragment, j().j(), new YyBackgroundItemFragment$liveDataObserver$8(this));
        r();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        Intrinsics.a(view);
        if (view.getId() == R.id.tv_reload) {
            YYBackgroundItemViewModel j = j();
            ActivityFragmentActive fragmentActive = getFragmentActive();
            Intrinsics.c(fragmentActive, "this.fragmentActive");
            j.b(fragmentActive);
        }
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        s();
    }

    public final FragmentYyMusicListBinding p() {
        return (FragmentYyMusicListBinding) this.b.b(this, f11437a[0]);
    }

    public final BackgroundMusicView q() {
        return this.d;
    }
}
