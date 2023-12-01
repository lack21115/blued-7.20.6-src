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
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
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
    private final ViewBindingProperty f32769c;
    private boolean d;
    private int e;
    private final MyGroupAdapter f;
    private MyAdapter g;
    static final /* synthetic */ KProperty<Object>[] b = {Reflection.a(new PropertyReference1Impl(MyGroupFragmentNew.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/FmMyGroupNewBinding;", 0))};

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f32768a = new Companion(null);

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
        private final ArrayList<String> f32770a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MyAdapter(FragmentManager fm) {
            super(fm, 1);
            Intrinsics.e(fm, "fm");
            this.f32770a = CollectionsKt.d(AppInfo.d().getString(R.string.group_nearby_tab), AppInfo.d().getString(R.string.group_recommend_tab));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f32770a.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i) {
            if (i != 0 && i == 1) {
                return new RecommendGroupFragment(RecommendGroupFragment.RecommendType.RECOMMEND);
            }
            return new RecommendGroupFragment(RecommendGroupFragment.RecommendType.NEARBY);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i) {
            String str = this.f32770a.get(i);
            Intrinsics.c(str, "tabs[position]");
            return str;
        }
    }

    public MyGroupFragmentNew() {
        super(R.layout.fm_my_group_new);
        this.f32769c = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<MyGroupFragmentNew, FmMyGroupNewBinding>() { // from class: com.soft.blued.ui.msg_group.fragment.MyGroupFragmentNew$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmMyGroupNewBinding invoke(MyGroupFragmentNew fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmMyGroupNewBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<MyGroupFragmentNew, FmMyGroupNewBinding>() { // from class: com.soft.blued.ui.msg_group.fragment.MyGroupFragmentNew$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FmMyGroupNewBinding invoke(MyGroupFragmentNew fragment) {
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
    public static final void a(FmMyGroupNewBinding it, ValueAnimator valueAnimator) {
        Intrinsics.e(it, "$it");
        ConsecutiveScrollerLayout consecutiveScrollerLayout = it.d;
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        consecutiveScrollerLayout.scrollTo(0, ((Integer) animatedValue).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MyGroupFragmentNew this$0) {
        int e;
        int e2;
        Intrinsics.e(this$0, "this$0");
        final FmMyGroupNewBinding p = this$0.p();
        if (p != null && (e2 = (e = this$0.a().e() + BluedViewExtKt.a(20)) - BluedViewExtKt.a(40)) > 0) {
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
    public static final void a(MyGroupFragmentNew this$0, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(this$0, "this$0");
        dialogInterface.dismiss();
        WebViewShowInfoFragment.show(this$0.getContext(), Intrinsics.a(GroupConstant.f32663a, (Object) "create_group"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MyGroupFragmentNew this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.a().k();
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_CREATE_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MyGroupFragmentNew this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        Object obj = baseQuickAdapter.getData().get(i);
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.common.group.GroupInfoModel");
        }
        GroupInfoModel groupInfoModel = (GroupInfoModel) obj;
        if (groupInfoModel.itemType != 0 && groupInfoModel.itemType != 5) {
            if (groupInfoModel.itemType == 4) {
                WebViewShowInfoFragment.show(this$0.getContext(), Intrinsics.a(GroupConstant.f32663a, (Object) "group_list"));
                return;
            }
            return;
        }
        EventTrackGroup.a(SocialNetWorkProtos.Event.GROUP_CLICK, groupInfoModel.label, groupInfoModel.group_role == 1 ? SocialNetWorkProtos.SourceType.CREATE : SocialNetWorkProtos.SourceType.JOIN, String.valueOf(groupInfoModel.group_id));
        Context context = this$0.getContext();
        GroupInfoFragment.a(context, groupInfoModel.group_id + "", groupInfoModel, SocialNetWorkProtos.SourceType.MYGROUP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MyGroupFragmentNew this$0, RefreshLayout it) {
        ConsecutiveViewPager consecutiveViewPager;
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(it, "it");
        this$0.a().l();
        FmMyGroupNewBinding p = this$0.p();
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
    public static final void a(MyGroupFragmentNew this$0, GroupGuideModel groupGuideModel) {
        Intrinsics.e(this$0, "this$0");
        String str = groupGuideModel.square;
        Intrinsics.c(str, "it.square");
        this$0.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final MyGroupFragmentNew this$0, GroupIdentifyModel groupIdentifyModel) {
        Context context;
        Intrinsics.e(this$0, "this$0");
        if (groupIdentifyModel.getVerify() == 1 && groupIdentifyModel.getVideo_verify() == 1 && (context = this$0.getContext()) != null) {
            new XPopup.Builder(context).a(PopupAnimation.ScaleAlphaFromCenter).c((Boolean) false).d((Boolean) true).a((BasePopupView) new CreateGroupHintPop(context, new View.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$W-8grbPbjIbOvWvptQ3UPpkms5o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MyGroupFragmentNew.e(MyGroupFragmentNew.this, view);
                }
            })).h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MyGroupFragmentNew this$0, GroupPrivilegeModel groupPrivilegeModel) {
        Context context;
        Intrinsics.e(this$0, "this$0");
        if (groupPrivilegeModel == null || (context = this$0.getContext()) == null) {
            return;
        }
        new XPopup.Builder(context).a(PopupAnimation.ScaleAlphaFromCenter).a((BasePopupView) new PopGroupRecover(context, this$0.a(), groupPrivilegeModel)).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final MyGroupFragmentNew this$0, String str) {
        Intrinsics.e(this$0, "this$0");
        CommonAlertDialog.a(this$0.getContext(), this$0.getString(R.string.group_create_limit), str, this$0.getString(R.string.group_go_to), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$MYAf2JERCCbMd0T0r55wSfjPpi8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MyGroupFragmentNew.a(MyGroupFragmentNew.this, dialogInterface, i);
            }
        }, this$0.getString(2131886885), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$823lNP6WXBQmYsM0BA5Sqne7I3c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MyGroupFragmentNew.a(dialogInterface, i);
            }
        }, (DialogInterface.OnDismissListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final MyGroupFragmentNew this$0, List list) {
        TextView textView;
        SmartRefreshLayout smartRefreshLayout;
        Intrinsics.e(this$0, "this$0");
        FmMyGroupNewBinding p = this$0.p();
        if (p != null && (smartRefreshLayout = p.b) != null) {
            smartRefreshLayout.j();
        }
        this$0.f.setEnableLoadMore(false);
        this$0.f.setNewData(list);
        FmMyGroupNewBinding p2 = this$0.p();
        RecyclerView recyclerView = p2 == null ? null : p2.f28757a;
        if (recyclerView != null) {
            recyclerView.setAdapter(this$0.f);
        }
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        FmMyGroupNewBinding p3 = this$0.p();
        RelativeLayout relativeLayout = p3 == null ? null : p3.f28758c;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        FmMyGroupNewBinding p4 = this$0.p();
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
        if (BluedConstant.f28239a || !GroupUtil.b || BluedPreferences.et() || TextUtils.isEmpty(str) || (context = getContext()) == null) {
            return;
        }
        GuideAttachPop guideAttachPop = new GuideAttachPop(context, str, GuideAttachPop.ArrowPosition.RIGHT, GuideAttachPop.Position.BOTTOM, BluedViewExtKt.a(10));
        XPopup.Builder d = new XPopup.Builder(context).d((Boolean) false);
        FmMyGroupNewBinding p = p();
        ImageView imageView = null;
        if (p != null && (commonTopTitleNoTrans = p.g) != null) {
            imageView = commonTopTitleNoTrans.getRightImg();
        }
        d.a(imageView).a(PopupPosition.Bottom).a(PopupAnimation.ScaleAlphaFromCenter).c(BluedViewExtKt.a(-8)).b(BluedViewExtKt.a(10)).a(new MyGroupFragmentNew$showGuide$1$1(this)).a((BasePopupView) guideAttachPop).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MyGroupFragmentNew this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MyGroupFragmentNew this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        TerminalActivity.d(this$0.getContext(), SearchGroupFragment.class, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MyGroupFragmentNew this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Context context = this$0.getContext();
        if (context == null) {
            return;
        }
        MyGroupAllFragment.b.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MyGroupFragmentNew this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        GroupCategoryFragment.Companion.a(GroupCategoryFragment.b, this$0, 0, null, 4, null);
    }

    private final FmMyGroupNewBinding p() {
        return (FmMyGroupNewBinding) this.f32769c.b(this, b[0]);
    }

    @Override // skin.support.observe.SkinObserver
    public void a(SkinObservable skinObservable, Object obj) {
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void e() {
        super.e();
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.d = arguments.getBoolean("group_my_need_anim");
        this.e = arguments.getInt("group_my_index");
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
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
                commonTopTitleNoTrans3.setRightImg(R.drawable.icon_group_create);
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
            commonTopTitleNoTrans5.setCenterText(getString(2131888331));
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
        RecyclerView recyclerView = p7 == null ? null : p7.f28757a;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        }
        FragmentManager it = getChildFragmentManager();
        Intrinsics.c(it, "it");
        this.g = new MyAdapter(it);
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
        RecyclerView recyclerView2 = p14 == null ? null : p14.f28757a;
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

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void g() {
        a().l();
        a().m();
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment
    public void l() {
        MyGroupFragmentNew myGroupFragmentNew = this;
        a().d().observe(myGroupFragmentNew, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$wTksUlBj3_NlrSH3-gLYEEImOrc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MyGroupFragmentNew.a(MyGroupFragmentNew.this, (List) obj);
            }
        });
        a().f().observe(myGroupFragmentNew, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$4jsP_rq2TYjVgpwI0kVeDRWyrbQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MyGroupFragmentNew.a(MyGroupFragmentNew.this, (GroupIdentifyModel) obj);
            }
        });
        a().g().observe(myGroupFragmentNew, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$k3mu-BXhKDd8Qzer5t9JBsKbcI4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MyGroupFragmentNew.a(MyGroupFragmentNew.this, (GroupPrivilegeModel) obj);
            }
        });
        a().i().observe(myGroupFragmentNew, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$yNtWV08o-gdbnTOyANLBRKe6sSE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MyGroupFragmentNew.a(MyGroupFragmentNew.this, (String) obj);
            }
        });
        a().j().observe(myGroupFragmentNew, new Observer() { // from class: com.soft.blued.ui.msg_group.fragment.-$$Lambda$MyGroupFragmentNew$QJLV4g4KKbVATfpGgkjO22OQIYA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MyGroupFragmentNew.a(MyGroupFragmentNew.this, (GroupGuideModel) obj);
            }
        });
    }

    @Override // com.blued.android.module.common.base.mvvm.MVVMBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Context context;
        Intrinsics.e(view, "view");
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
            String command = arguments.getString("group_command", "");
            Serializable serializable = arguments.getSerializable("group_command_data");
            if (serializable == null || (context = getContext()) == null) {
                return;
            }
            XPopup.Builder a2 = new XPopup.Builder(context).b((Boolean) false).d((Boolean) true).a(PopupAnimation.ScaleAlphaFromCenter);
            Intrinsics.c(command, "command");
            a2.a((BasePopupView) new PopGroupHelpDetail(context, command, (GroupCommandDetailResp) serializable)).h();
        }
    }
}
