package com.soft.blued.ui.msg_group.fragment;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.anythink.expressad.a;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinObserver;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.enums.PopupAnimation;
import com.blued.android.framework.ui.xpop.enums.PopupPosition;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.view.CommonTopTitleNoTrans;
import com.blued.android.module.common.widget.consecutivescroller.ConsecutiveScrollerLayout;
import com.blued.android.module.common.widget.consecutivescroller.ConsecutiveViewPager;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.das.client.socialnet.SocialNetWorkProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.heytap.mcssdk.constant.IntentConstant;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.customview.TabPageIndicatorWithDot;
import com.soft.blued.databinding.FmMyGroupNewBinding;
import com.soft.blued.databinding.ViewSearchBinding;
import com.soft.blued.log.track.EventTrackGroup;
import com.soft.blued.ui.msg.model.GroupGuideModel;
import com.soft.blued.ui.msg.pop.GuideAttachPop;
import com.soft.blued.ui.msg_group.adapter.MyGroupAdapter;
import com.soft.blued.ui.msg_group.constant.GroupConstant;
import com.soft.blued.ui.msg_group.event.RecommendRefreshEvent;
import com.soft.blued.ui.msg_group.event.ScrollEvent;
import com.soft.blued.ui.msg_group.fragment.GroupCategoryFragment;
import com.soft.blued.ui.msg_group.fragment.RecommendGroupFragment;
import com.soft.blued.ui.msg_group.model.GroupCommandDetailResp;
import com.soft.blued.ui.msg_group.model.GroupIdentifyModel;
import com.soft.blued.ui.msg_group.model.GroupPrivilegeModel;
import com.soft.blued.ui.msg_group.pop.CreateGroupHintPop;
import com.soft.blued.ui.msg_group.pop.PopGroupHelpDetail;
import com.soft.blued.ui.msg_group.pop.PopGroupRecover;
import com.soft.blued.ui.msg_group.utils.GroupUtil;
import com.soft.blued.ui.msg_group.viewmodel.MyGroupViewModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import skin.support.observe.SkinObservable;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/MyGroupFragmentNew.class */
public class MyGroupFragmentNew extends MVVMBaseFragment<MyGroupViewModel> implements BluedSkinObserver {

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f19078c;
    private boolean d;
    private int e;
    private final MyGroupAdapter f;
    private MyAdapter g;
    static final /* synthetic */ KProperty<Object>[] b = {(KProperty) Reflection.a(new PropertyReference1Impl(MyGroupFragmentNew.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/FmMyGroupNewBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19077a = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/MyGroupFragmentNew$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, Bundle bundle) {
            TerminalActivity.d(context, MyGroupFragmentNew.class, bundle);
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/MyGroupFragmentNew$MyAdapter.class */
    public static final class MyAdapter extends FragmentStatePagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayList<String> f19079a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager, 1);
            Intrinsics.e(fragmentManager, "fm");
            this.f19079a = CollectionsKt.d(new String[]{AppInfo.d().getString(R.string.group_nearby_tab), AppInfo.d().getString(R.string.group_recommend_tab)});
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f19079a.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            if (i != 0 && i == 1) {
                return (Fragment) new RecommendGroupFragment(RecommendGroupFragment.RecommendType.RECOMMEND);
            }
            return (Fragment) new RecommendGroupFragment(RecommendGroupFragment.RecommendType.NEARBY);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            String str = this.f19079a.get(i);
            Intrinsics.c(str, "tabs[position]");
            return str;
        }
    }

    public MyGroupFragmentNew() {
        super((int) R.layout.fm_my_group_new);
        this.f19078c = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<MyGroupFragmentNew, FmMyGroupNewBinding>() { // from class: com.soft.blued.ui.msg_group.fragment.MyGroupFragmentNew$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/msg_group/fragment/MyGroupFragmentNew;)Lcom/soft/blued/databinding/FmMyGroupNewBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmMyGroupNewBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<MyGroupFragmentNew, FmMyGroupNewBinding>() { // from class: com.soft.blued.ui.msg_group.fragment.MyGroupFragmentNew$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/msg_group/fragment/MyGroupFragmentNew;)Lcom/soft/blued/databinding/FmMyGroupNewBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmMyGroupNewBinding.a(fragment.requireView());
            }
        });
        this.f = new MyGroupAdapter(getFragmentActive());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(FmMyGroupNewBinding fmMyGroupNewBinding, ValueAnimator valueAnimator) {
        Intrinsics.e(fmMyGroupNewBinding, "$it");
        ConsecutiveScrollerLayout consecutiveScrollerLayout = fmMyGroupNewBinding.d;
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        consecutiveScrollerLayout.scrollTo(0, ((Integer) animatedValue).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MyGroupFragmentNew myGroupFragmentNew) {
        int e;
        int e2;
        Intrinsics.e(myGroupFragmentNew, "this$0");
        final FmMyGroupNewBinding p = myGroupFragmentNew.p();
        if (p != null && (e2 = (e = ((MyGroupViewModel) myGroupFragmentNew.a()).e() + BluedViewExtKt.a(20)) - BluedViewExtKt.a(40)) > 0) {
            p.d.scrollTo(0, e2);
            ValueAnimator ofInt = ValueAnimator.ofInt(e2, e);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$k8MG_MK5Jkob-CamvTZG36hLun8
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MyGroupFragmentNew.a(FmMyGroupNewBinding.this, valueAnimator);
                }
            });
            ofInt.addListener(new AnimatorListenerAdapter() { // from class: com.soft.blued.ui.msg_group.fragment.MyGroupFragmentNew$onViewCreated$1$1$2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    LiveEventBus.get("group_refresh_recommend_List", ScrollEvent.class).post(new ScrollEvent(true));
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    LiveEventBus.get("group_refresh_recommend_List", ScrollEvent.class).post(new ScrollEvent(false));
                }
            });
            ofInt.setDuration(1000L);
            ofInt.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MyGroupFragmentNew myGroupFragmentNew, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(myGroupFragmentNew, "this$0");
        dialogInterface.dismiss();
        WebViewShowInfoFragment.show(myGroupFragmentNew.getContext(), Intrinsics.a(GroupConstant.f18972a, "create_group"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MyGroupFragmentNew myGroupFragmentNew, View view) {
        Tracker.onClick(view);
        Intrinsics.e(myGroupFragmentNew, "this$0");
        ((MyGroupViewModel) myGroupFragmentNew.a()).k();
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_CREATE_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MyGroupFragmentNew myGroupFragmentNew, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(myGroupFragmentNew, "this$0");
        Object obj = baseQuickAdapter.getData().get(i);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.group.GroupInfoModel");
        }
        GroupInfoModel groupInfoModel = (GroupInfoModel) obj;
        if (groupInfoModel.itemType != 0 && groupInfoModel.itemType != 5) {
            if (groupInfoModel.itemType == 4) {
                WebViewShowInfoFragment.show(myGroupFragmentNew.getContext(), Intrinsics.a(GroupConstant.f18972a, "group_list"));
                return;
            }
            return;
        }
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_CLICK, groupInfoModel.label, groupInfoModel.group_role == 1 ? SocialNetWorkProtos.SourceType.CREATE : SocialNetWorkProtos.SourceType.JOIN, String.valueOf(groupInfoModel.group_id));
        Context context = myGroupFragmentNew.getContext();
        GroupInfoFragment.a(context, groupInfoModel.group_id + "", groupInfoModel, SocialNetWorkProtos.SourceType.MYGROUP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MyGroupFragmentNew myGroupFragmentNew, RefreshLayout refreshLayout) {
        ConsecutiveViewPager consecutiveViewPager;
        Intrinsics.e(myGroupFragmentNew, "this$0");
        Intrinsics.e(refreshLayout, "it");
        ((MyGroupViewModel) myGroupFragmentNew.a()).l();
        FmMyGroupNewBinding p = myGroupFragmentNew.p();
        if (p == null || (consecutiveViewPager = p.j) == null) {
            return;
        }
        if (consecutiveViewPager.getCurrentItem() == 0) {
            LiveEventBus.get("group_refresh_recommend_List", RecommendRefreshEvent.class).post(new RecommendRefreshEvent(RecommendGroupFragment.RecommendType.NEARBY));
        } else {
            LiveEventBus.get("group_refresh_recommend_List", RecommendRefreshEvent.class).post(new RecommendRefreshEvent(RecommendGroupFragment.RecommendType.RECOMMEND));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MyGroupFragmentNew myGroupFragmentNew, GroupGuideModel groupGuideModel) {
        Intrinsics.e(myGroupFragmentNew, "this$0");
        String str = groupGuideModel.square;
        Intrinsics.c(str, "it.square");
        myGroupFragmentNew.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final MyGroupFragmentNew myGroupFragmentNew, GroupIdentifyModel groupIdentifyModel) {
        Context context;
        Intrinsics.e(myGroupFragmentNew, "this$0");
        if (groupIdentifyModel.getVerify() == 1 && groupIdentifyModel.getVideo_verify() == 1 && (context = myGroupFragmentNew.getContext()) != null) {
            new XPopup.Builder(context).a(PopupAnimation.a).c(false).d(true).a(new CreateGroupHintPop(context, new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$W-8grbPbjIbOvWvptQ3UPpkms5o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyGroupFragmentNew.e(MyGroupFragmentNew.this, view);
                }
            })).h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MyGroupFragmentNew myGroupFragmentNew, GroupPrivilegeModel groupPrivilegeModel) {
        Context context;
        Intrinsics.e(myGroupFragmentNew, "this$0");
        if (groupPrivilegeModel == null || (context = myGroupFragmentNew.getContext()) == null) {
            return;
        }
        new XPopup.Builder(context).a(PopupAnimation.a).a(new PopGroupRecover(context, (MyGroupViewModel) myGroupFragmentNew.a(), groupPrivilegeModel)).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final MyGroupFragmentNew myGroupFragmentNew, String str) {
        Intrinsics.e(myGroupFragmentNew, "this$0");
        CommonAlertDialog.a(myGroupFragmentNew.getContext(), myGroupFragmentNew.getString(R.string.group_create_limit), str, myGroupFragmentNew.getString(R.string.group_go_to), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$MYAf2JERCCbMd0T0r55wSfjPpi8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MyGroupFragmentNew.a(MyGroupFragmentNew.this, dialogInterface, i);
            }
        }, myGroupFragmentNew.getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$823lNP6WXBQmYsM0BA5Sqne7I3c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MyGroupFragmentNew.a(dialogInterface, i);
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final MyGroupFragmentNew myGroupFragmentNew, List list) {
        TextView textView;
        SmartRefreshLayout smartRefreshLayout;
        Intrinsics.e(myGroupFragmentNew, "this$0");
        FmMyGroupNewBinding p = myGroupFragmentNew.p();
        if (p != null && (smartRefreshLayout = p.b) != null) {
            smartRefreshLayout.j();
        }
        myGroupFragmentNew.f.setEnableLoadMore(false);
        myGroupFragmentNew.f.setNewData(list);
        FmMyGroupNewBinding p2 = myGroupFragmentNew.p();
        RecyclerView recyclerView = p2 == null ? null : p2.f15067a;
        if (recyclerView != null) {
            recyclerView.setAdapter(myGroupFragmentNew.f);
        }
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        FmMyGroupNewBinding p3 = myGroupFragmentNew.p();
        RelativeLayout relativeLayout = p3 == null ? null : p3.f15068c;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        FmMyGroupNewBinding p4 = myGroupFragmentNew.p();
        if (p4 == null || (textView = p4.h) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$8xq4nJL_66HCwHWkQf7cT0rZX4Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyGroupFragmentNew.d(MyGroupFragmentNew.this, view);
            }
        });
    }

    private final void a(String str) {
        Context context;
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        if (BluedConstant.f14549a || !GroupUtil.b || BluedPreferences.et() || TextUtils.isEmpty(str) || (context = getContext()) == null) {
            return;
        }
        BasePopupView guideAttachPop = new GuideAttachPop(context, str, GuideAttachPop.ArrowPosition.RIGHT, GuideAttachPop.Position.BOTTOM, BluedViewExtKt.a(10));
        XPopup.Builder d = new XPopup.Builder(context).d(false);
        FmMyGroupNewBinding p = p();
        ImageView imageView = null;
        if (p != null && (commonTopTitleNoTrans = p.g) != null) {
            imageView = commonTopTitleNoTrans.getRightImg();
        }
        d.a(imageView).a(PopupPosition.d).a(PopupAnimation.a).c(BluedViewExtKt.a(-8)).b(BluedViewExtKt.a(10)).a(new MyGroupFragmentNew$showGuide$1$1(this)).a(guideAttachPop).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MyGroupFragmentNew myGroupFragmentNew, View view) {
        Tracker.onClick(view);
        Intrinsics.e(myGroupFragmentNew, "this$0");
        FragmentActivity activity = myGroupFragmentNew.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MyGroupFragmentNew myGroupFragmentNew, View view) {
        Tracker.onClick(view);
        Intrinsics.e(myGroupFragmentNew, "this$0");
        TerminalActivity.d(myGroupFragmentNew.getContext(), SearchGroupFragment.class, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MyGroupFragmentNew myGroupFragmentNew, View view) {
        Tracker.onClick(view);
        Intrinsics.e(myGroupFragmentNew, "this$0");
        Context context = myGroupFragmentNew.getContext();
        if (context == null) {
            return;
        }
        MyGroupAllFragment.b.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MyGroupFragmentNew myGroupFragmentNew, View view) {
        Tracker.onClick(view);
        Intrinsics.e(myGroupFragmentNew, "this$0");
        GroupCategoryFragment.Companion.a(GroupCategoryFragment.b, (Fragment) myGroupFragmentNew, 0, null, 4, null);
    }

    private final FmMyGroupNewBinding p() {
        return (FmMyGroupNewBinding) this.f19078c.b(this, b[0]);
    }

    public void a(SkinObservable skinObservable, Object obj) {
    }

    public void e() {
        super.e();
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.d = arguments.getBoolean("group_my_need_anim");
        this.e = arguments.getInt("group_my_index");
    }

    public void f() {
        CommonTopTitleNoTrans commonTopTitleNoTrans;
        CommonTopTitleNoTrans commonTopTitleNoTrans2;
        CommonTopTitleNoTrans commonTopTitleNoTrans3;
        SmartRefreshLayout smartRefreshLayout;
        ConsecutiveViewPager consecutiveViewPager;
        ViewSearchBinding viewSearchBinding;
        ShapeLinearLayout shapeLinearLayout;
        TabPageIndicatorWithDot tabPageIndicatorWithDot;
        SmartRefreshLayout smartRefreshLayout2;
        CommonTopTitleNoTrans commonTopTitleNoTrans4;
        CommonTopTitleNoTrans commonTopTitleNoTrans5;
        CommonTopTitleNoTrans commonTopTitleNoTrans6;
        if (GroupUtil.b) {
            FmMyGroupNewBinding p = p();
            ImageView rightImg = (p == null || (commonTopTitleNoTrans = p.g) == null) ? null : commonTopTitleNoTrans.getRightImg();
            if (rightImg != null) {
                rightImg.setVisibility(0);
            }
            FmMyGroupNewBinding p2 = p();
            if (p2 != null && (commonTopTitleNoTrans3 = p2.g) != null) {
                commonTopTitleNoTrans3.setRightImg((int) R.drawable.icon_group_create);
            }
            FmMyGroupNewBinding p3 = p();
            if (p3 != null && (commonTopTitleNoTrans2 = p3.g) != null) {
                commonTopTitleNoTrans2.setRightClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$Ztj2AHnwjO2wyl_2W9JVk4jMnn8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MyGroupFragmentNew.a(MyGroupFragmentNew.this, view);
                    }
                });
            }
        } else {
            FmMyGroupNewBinding p4 = p();
            ImageView rightImg2 = (p4 == null || (commonTopTitleNoTrans6 = p4.g) == null) ? null : commonTopTitleNoTrans6.getRightImg();
            if (rightImg2 != null) {
                rightImg2.setVisibility(8);
            }
        }
        FmMyGroupNewBinding p5 = p();
        if (p5 != null && (commonTopTitleNoTrans5 = p5.g) != null) {
            commonTopTitleNoTrans5.setCenterText(getString(R.string.group_chat));
        }
        FmMyGroupNewBinding p6 = p();
        if (p6 != null && (commonTopTitleNoTrans4 = p6.g) != null) {
            commonTopTitleNoTrans4.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$fHpgNRNIdW0dWLDGBrEMUUcQEfA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyGroupFragmentNew.b(MyGroupFragmentNew.this, view);
                }
            });
        }
        FmMyGroupNewBinding p7 = p();
        RecyclerView recyclerView = p7 == null ? null : p7.f15067a;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "it");
        this.g = new MyAdapter(childFragmentManager);
        FmMyGroupNewBinding p8 = p();
        ConsecutiveViewPager consecutiveViewPager2 = p8 == null ? null : p8.j;
        if (consecutiveViewPager2 != null) {
            MyAdapter myAdapter = this.g;
            MyAdapter myAdapter2 = myAdapter;
            if (myAdapter == null) {
                Intrinsics.c("vpAdapter");
                myAdapter2 = null;
            }
            consecutiveViewPager2.setAdapter(myAdapter2);
        }
        FmMyGroupNewBinding p9 = p();
        ConsecutiveViewPager consecutiveViewPager3 = p9 == null ? null : p9.j;
        if (consecutiveViewPager3 != null) {
            MyAdapter myAdapter3 = this.g;
            MyAdapter myAdapter4 = myAdapter3;
            if (myAdapter3 == null) {
                Intrinsics.c("vpAdapter");
                myAdapter4 = null;
            }
            consecutiveViewPager3.setOffscreenPageLimit(myAdapter4.getCount());
        }
        FmMyGroupNewBinding p10 = p();
        if (p10 != null && (smartRefreshLayout2 = p10.b) != null) {
            smartRefreshLayout2.l(false);
        }
        FmMyGroupNewBinding p11 = p();
        if (p11 != null && (tabPageIndicatorWithDot = p11.f) != null) {
            FmMyGroupNewBinding p12 = p();
            tabPageIndicatorWithDot.setViewPager(p12 == null ? null : p12.j);
        }
        FmMyGroupNewBinding p13 = p();
        TabPageIndicatorWithDot tabPageIndicatorWithDot2 = p13 == null ? null : p13.f;
        if (tabPageIndicatorWithDot2 != null) {
            tabPageIndicatorWithDot2.setForeverShowTabIndicator(false);
        }
        FmMyGroupNewBinding p14 = p();
        RecyclerView recyclerView2 = p14 == null ? null : p14.f15067a;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(this.f);
        }
        FmMyGroupNewBinding p15 = p();
        if (p15 != null && (viewSearchBinding = p15.k) != null && (shapeLinearLayout = viewSearchBinding.b) != null) {
            shapeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$bxsqof7udpDtlKvYmhqP9DbZd1E
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyGroupFragmentNew.c(MyGroupFragmentNew.this, view);
                }
            });
        }
        this.f.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$dYraXG2MwV1hSDODqPe-sLOqt9o
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                MyGroupFragmentNew.a(MyGroupFragmentNew.this, baseQuickAdapter, view, i);
            }
        });
        FmMyGroupNewBinding p16 = p();
        if (p16 != null && (consecutiveViewPager = p16.j) != null) {
            consecutiveViewPager.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101780));
        }
        FmMyGroupNewBinding p17 = p();
        if (p17 == null || (smartRefreshLayout = p17.b) == null) {
            return;
        }
        smartRefreshLayout.a(new OnRefreshListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$3zsQ-gDc5Q9u_pqHnj58g3YeB8s
            @Override // com.scwang.smartrefresh.layout.listener.OnRefreshListener
            public final void onRefresh(RefreshLayout refreshLayout) {
                MyGroupFragmentNew.a(MyGroupFragmentNew.this, refreshLayout);
            }
        });
    }

    public void g() {
        ((MyGroupViewModel) a()).l();
        ((MyGroupViewModel) a()).m();
    }

    public void l() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        ((MyGroupViewModel) a()).d().observe(lifecycleOwner, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$wTksUlBj3_NlrSH3-gLYEEImOrc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MyGroupFragmentNew.a(MyGroupFragmentNew.this, (List) obj);
            }
        });
        ((MyGroupViewModel) a()).f().observe(lifecycleOwner, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$4jsP_rq2TYjVgpwI0kVeDRWyrbQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MyGroupFragmentNew.a(MyGroupFragmentNew.this, (GroupIdentifyModel) obj);
            }
        });
        ((MyGroupViewModel) a()).g().observe(lifecycleOwner, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$k3mu-BXhKDd8Qzer5t9JBsKbcI4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MyGroupFragmentNew.a(MyGroupFragmentNew.this, (GroupPrivilegeModel) obj);
            }
        });
        ((MyGroupViewModel) a()).i().observe(lifecycleOwner, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$yNtWV08o-gdbnTOyANLBRKe6sSE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MyGroupFragmentNew.a(MyGroupFragmentNew.this, (String) obj);
            }
        });
        ((MyGroupViewModel) a()).j().observe(lifecycleOwner, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$QJLV4g4KKbVATfpGgkjO22OQIYA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MyGroupFragmentNew.a(MyGroupFragmentNew.this, (GroupGuideModel) obj);
            }
        });
    }

    public void onViewCreated(View view, Bundle bundle) {
        Context context;
        Intrinsics.e(view, a.B);
        super.onViewCreated(view, bundle);
        if (this.d) {
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$MlrRm1sKk-NQFCmDHW8k0BnJjUQ
                @Override // java.lang.Runnable
                public final void run() {
                    MyGroupFragmentNew.a(MyGroupFragmentNew.this);
                }
            }, 300L);
        }
        FmMyGroupNewBinding p = p();
        ConsecutiveViewPager consecutiveViewPager = p == null ? null : p.j;
        if (consecutiveViewPager != null) {
            consecutiveViewPager.setCurrentItem(this.e);
        }
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("group_command")) {
            String string = arguments.getString("group_command", "");
            Serializable serializable = arguments.getSerializable("group_command_data");
            if (serializable == null || (context = getContext()) == null) {
                return;
            }
            XPopup.Builder a2 = new XPopup.Builder(context).b(false).d(true).a(PopupAnimation.a);
            Intrinsics.c(string, IntentConstant.COMMAND);
            a2.a(new PopGroupHelpDetail(context, string, (GroupCommandDetailResp) serializable)).h();
        }
    }
}
