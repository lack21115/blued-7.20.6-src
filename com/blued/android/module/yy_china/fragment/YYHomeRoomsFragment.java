package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.utils.ClickUtils;
import com.blued.android.framework.utils.SharedPreferencesUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.adapter.HomeRightMenuAdapter;
import com.blued.android.module.yy_china.databinding.FragmentYyHomeRoomsBinding;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.HomeRightMenuDotModel;
import com.blued.android.module.yy_china.model.HomeRightMenuModel;
import com.blued.android.module.yy_china.model.HomeRightMenuModels;
import com.blued.android.module.yy_china.model.YYHomeExtraModel;
import com.blued.android.module.yy_china.model.YYHomeRoomsViewModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYHomeRoomsFragment.class */
public final class YYHomeRoomsFragment extends MVVMBaseFragment<YYHomeRoomsViewModel> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f17284a = {Reflection.a(new PropertyReference1Impl(YYHomeRoomsFragment.class, "vb", "getVb()Lcom/blued/android/module/yy_china/databinding/FragmentYyHomeRoomsBinding;", 0))};
    private final ViewBindingProperty b;

    /* renamed from: c  reason: collision with root package name */
    private YYChatRoomsListFragment f17285c;
    private YYHomeChatsFragment d;
    private boolean e;

    public YYHomeRoomsFragment() {
        super(R.layout.fragment_yy_home_rooms);
        this.b = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<YYHomeRoomsFragment, FragmentYyHomeRoomsBinding>() { // from class: com.blued.android.module.yy_china.fragment.YYHomeRoomsFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentYyHomeRoomsBinding invoke(YYHomeRoomsFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyHomeRoomsBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<YYHomeRoomsFragment, FragmentYyHomeRoomsBinding>() { // from class: com.blued.android.module.yy_china.fragment.YYHomeRoomsFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentYyHomeRoomsBinding invoke(YYHomeRoomsFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentYyHomeRoomsBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYHomeRoomsFragment this$0, View view) {
        LinearLayout linearLayout;
        Intrinsics.e(this$0, "this$0");
        EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_HALL_HEAD_ICON_CLICK);
        FragmentYyHomeRoomsBinding p = this$0.p();
        if ((p == null || (linearLayout = p.e) == null || linearLayout.getVisibility() != 0) ? false : true) {
            FragmentYyHomeRoomsBinding p2 = this$0.p();
            LinearLayout linearLayout2 = p2 == null ? null : p2.e;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            FragmentYyHomeRoomsBinding p3 = this$0.p();
            View view2 = p3 == null ? null : p3.b;
            if (view2 == null) {
                return;
            }
            view2.setVisibility(8);
            return;
        }
        FragmentYyHomeRoomsBinding p4 = this$0.p();
        LinearLayout linearLayout3 = p4 == null ? null : p4.e;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        FragmentYyHomeRoomsBinding p5 = this$0.p();
        View view3 = p5 == null ? null : p5.b;
        if (view3 == null) {
            return;
        }
        view3.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(YYHomeRoomsFragment this$0, HomeRightMenuModels state, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(state, "$state");
        this$0.b(state);
        FragmentYyHomeRoomsBinding p = this$0.p();
        LinearLayout linearLayout = p == null ? null : p.e;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        FragmentYyHomeRoomsBinding p2 = this$0.p();
        View view2 = p2 == null ? null : p2.b;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final HomeRightMenuModels homeRightMenuModels) {
        this.e = true;
        b(homeRightMenuModels);
        FragmentYyHomeRoomsBinding p = p();
        RecyclerView recyclerView = p == null ? null : p.f;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        HomeRightMenuAdapter homeRightMenuAdapter = new HomeRightMenuAdapter(this, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHomeRoomsFragment$P1bmbT5wUsipIPaPjdJgeEMMMcA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYHomeRoomsFragment.a(YYHomeRoomsFragment.this, homeRightMenuModels, view);
            }
        });
        FragmentYyHomeRoomsBinding p2 = p();
        RecyclerView recyclerView2 = p2 == null ? null : p2.f;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(homeRightMenuAdapter);
        }
        homeRightMenuAdapter.setNewData(homeRightMenuModels.getDatas());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYHomeExtraModel yYHomeExtraModel) {
        if (yYHomeExtraModel == null) {
            return;
        }
        YYRoomInfoManager.e().f17579c = yYHomeExtraModel.getSwitch_svga();
        if (StringUtils.a(yYHomeExtraModel.getExperiment_group(), "new")) {
            r();
        } else {
            s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYHomeRoomsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    private final void b(HomeRightMenuModels homeRightMenuModels) {
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        CommonTopTitleNoTrans commonTopTitleNoTrans2;
        HomeRightMenuDotModel dot;
        Iterator<HomeRightMenuModel> it = homeRightMenuModels.getDatas().iterator();
        boolean z = false;
        while (it.hasNext()) {
            HomeRightMenuModel next = it.next();
            if ((next == null || (dot = next.getDot()) == null || dot.getStatus() != 1) ? false : true) {
                if (SharedPreferencesUtils.b().getInt("YYHOME_RIGHT_MENU_DoT" + next.getName() + next.getDot().getVersion() + ((Object) YYRoomInfoManager.e().k()), 0) == 0) {
                    next.getDot().setStatus(1);
                    z = true;
                } else {
                    next.getDot().setStatus(0);
                }
            }
        }
        if (z) {
            FragmentYyHomeRoomsBinding p = p();
            if (p == null || (commonTopTitleNoTrans2 = p.g) == null) {
                return;
            }
            commonTopTitleNoTrans2.a(0);
            return;
        }
        FragmentYyHomeRoomsBinding p2 = p();
        if (p2 == null || (commonTopTitleNoTrans = p2.g) == null) {
            return;
        }
        commonTopTitleNoTrans.a(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYHomeRoomsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        if (ClickUtils.a(R.id.ctt_right)) {
            return;
        }
        EventTrackYY.a(ChatRoomProtos.Event.YY_HALL_RANK_CLICK);
        YYRoomInfoManager.e().c().a(this$0.getContext(), "from=0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(YYHomeRoomsFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        FragmentYyHomeRoomsBinding p = this$0.p();
        LinearLayout linearLayout = p == null ? null : p.e;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        FragmentYyHomeRoomsBinding p2 = this$0.p();
        View view2 = p2 == null ? null : p2.b;
        if (view2 == null) {
            return;
        }
        view2.setVisibility(8);
    }

    private final FragmentYyHomeRoomsBinding p() {
        return (FragmentYyHomeRoomsBinding) this.b.b(this, f17284a[0]);
    }

    private final void q() {
        ImageView imageView;
        FragmentYyHomeRoomsBinding p = p();
        if (p != null) {
            p.g.f();
            p.g.setLeftImg(R.drawable.icon_title_back);
            p.g.setCenterText(getString(R.string.yy_chat_room));
            p.g.setLeftClickListener(this);
            p.g.f();
            p.g.setCenterTextColor(R.color.syc_h);
            p.g.a(R.drawable.icon_yy_home_gift_user, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHomeRoomsFragment$aJy_0jNz4llT5s5EXGTQ-IW6dCI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYHomeRoomsFragment.a(YYHomeRoomsFragment.this, view);
                }
            });
            p.g.setLeftClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHomeRoomsFragment$g-zXzI3WC_Yp6W3Kybwt38WXxN0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYHomeRoomsFragment.b(YYHomeRoomsFragment.this, view);
                }
            });
            p.g.a(0);
            p.g.setRightClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHomeRoomsFragment$LmI3YaetBjTZv1RzYJ5dWQZakkc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYHomeRoomsFragment.c(YYHomeRoomsFragment.this, view);
                }
            });
            if (StatusBarHelper.a()) {
                ViewGroup.LayoutParams layoutParams = p.g.getLayoutParams();
                if (layoutParams == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = StatusBarHelper.a(getContext());
                p.g.setLayoutParams(layoutParams2);
            }
            LinearLayout titleBackground = p.g.getTitleBackground();
            if (titleBackground != null) {
                titleBackground.setBackgroundResource(R.color.transparent);
            }
        }
        FragmentYyHomeRoomsBinding p2 = p();
        if (p2 == null || (imageView = p2.d) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYHomeRoomsFragment$MrlRse5XqJdwgn2z8WzgZQBJmP8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YYHomeRoomsFragment.d(YYHomeRoomsFragment.this, view);
            }
        });
    }

    private final void r() {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.c(beginTransaction, "childFragmentManager.beginTransaction()");
        YYHomeChatsFragment yYHomeChatsFragment = (YYHomeChatsFragment) getChildFragmentManager().findFragmentByTag("homeNewDataFragment");
        this.d = yYHomeChatsFragment;
        if (yYHomeChatsFragment == null) {
            YYHomeChatsFragment yYHomeChatsFragment2 = new YYHomeChatsFragment();
            this.d = yYHomeChatsFragment2;
            if (yYHomeChatsFragment2 != null) {
                yYHomeChatsFragment2.setArguments(t());
            }
            int i = R.id.fra;
            YYHomeChatsFragment yYHomeChatsFragment3 = this.d;
            Intrinsics.a(yYHomeChatsFragment3);
            beginTransaction.add(i, yYHomeChatsFragment3, "homeNewDataFragment");
        } else if (yYHomeChatsFragment != null) {
            yYHomeChatsFragment.setArguments(t());
            beginTransaction.show(yYHomeChatsFragment);
        }
        beginTransaction.commitNowAllowingStateLoss();
    }

    private final void s() {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        Intrinsics.c(beginTransaction, "childFragmentManager.beginTransaction()");
        YYChatRoomsListFragment yYChatRoomsListFragment = (YYChatRoomsListFragment) getChildFragmentManager().findFragmentByTag("homeOldDataFragment");
        this.f17285c = yYChatRoomsListFragment;
        if (yYChatRoomsListFragment == null) {
            YYChatRoomsListFragment yYChatRoomsListFragment2 = new YYChatRoomsListFragment();
            this.f17285c = yYChatRoomsListFragment2;
            if (yYChatRoomsListFragment2 != null) {
                yYChatRoomsListFragment2.setArguments(t());
            }
            int i = R.id.fra;
            YYChatRoomsListFragment yYChatRoomsListFragment3 = this.f17285c;
            Intrinsics.a(yYChatRoomsListFragment3);
            beginTransaction.add(i, yYChatRoomsListFragment3, "homeOldDataFragment");
        } else if (yYChatRoomsListFragment != null) {
            yYChatRoomsListFragment.setArguments(t());
            beginTransaction.show(yYChatRoomsListFragment);
        }
        beginTransaction.commitNowAllowingStateLoss();
    }

    private final Bundle t() {
        Bundle bundle = new Bundle();
        bundle.putString("from_source", j().e());
        bundle.putString("type_id", j().d());
        bundle.putString(TTLiveConstants.ROOMID_KEY, j().f());
        return bundle;
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void f() {
        q();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        YYHomeRoomsFragment yYHomeRoomsFragment = this;
        LifecycleExtKt.a(yYHomeRoomsFragment, j().g(), new YYHomeRoomsFragment$liveDataObserver$1(this));
        LifecycleExtKt.a(yYHomeRoomsFragment, j().h(), new YYHomeRoomsFragment$liveDataObserver$2(this));
        LifecycleExtKt.a(yYHomeRoomsFragment, j().i(), new YYHomeRoomsFragment$liveDataObserver$3(this));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (!TextUtils.isEmpty(j().f()) || this.e) {
            if (TextUtils.isEmpty(j().f())) {
                return;
            }
            YYRoomInfoManager.e().a((BaseFragmentActivity) getActivity(), j().f(), j().e());
            j().c("");
            return;
        }
        YYHomeRoomsViewModel j = j();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        j.a(fragmentActive);
    }
}
