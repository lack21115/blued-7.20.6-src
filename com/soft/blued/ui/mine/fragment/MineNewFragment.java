package com.soft.blued.ui.mine.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.PagerAdapter;
import com.anythink.expressad.a;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.chat.listener.SingleSessionListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinObserver;
import com.blued.android.framework.utils.CommonTools;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.view.badgeview.QBadgeContainer;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvvm.LifecycleExtKt;
import com.blued.android.module.common.base.mvvm.MVVMBaseFragment;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.android.module.common.user.model.AuditingProfileModel;
import com.blued.android.module.common.user.model.BluedLoginResult;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.AvatarUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.AutoScrollViewPager;
import com.blued.android.module.common.view.LinePageIndicator;
import com.blued.android.module.common.view.ObservableScrollView;
import com.blued.android.module.common.widget.pop.BluedPopupWindow;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.utils.LiveUtils;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.community.databinding.ItemMineEmotionBinding;
import com.blued.community.ui.feed.fragment.InteractFeedFragment;
import com.blued.das.settings.SettingsProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.BluedConstant;
import com.soft.blued.R;
import com.soft.blued.constant.EventBusConstant;
import com.soft.blued.customview.BluedADConstraintLayout;
import com.soft.blued.databinding.FragmentMineNewBinding;
import com.soft.blued.databinding.ItemMineHealthEntryExperienceBinding;
import com.soft.blued.databinding.ItemMineHealthEntryExperienceMidBinding;
import com.soft.blued.databinding.ItemMineHealthEntryExperienceMidChildBinding;
import com.soft.blued.databinding.ItemMineHealthyBannerBinding;
import com.soft.blued.databinding.ItemMineNewHealthEntryBinding;
import com.soft.blued.databinding.ItemMineVasEntry2Binding;
import com.soft.blued.databinding.ItemMineVasEntry3Binding;
import com.soft.blued.databinding.ItemMineVasEntryBinding;
import com.soft.blued.databinding.ItemMineVipBannerBinding;
import com.soft.blued.databinding.ItemMineZhealthEntryBinding;
import com.soft.blued.databinding.LayoutMineTipBinding;
import com.soft.blued.http.FindHttpUtils;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.bytedance.SettingsEventUtils;
import com.soft.blued.ui.find.fragment.VisitHistoryFragment;
import com.soft.blued.ui.mine.model.MinePageAdModel;
import com.soft.blued.ui.mine.model.MinePageModel;
import com.soft.blued.ui.mine.view.ResourcePromotionView;
import com.soft.blued.ui.mine.vm.MineViewModel;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.GroupGuideModel;
import com.soft.blued.ui.msg_group.fragment.MyGroupFragmentNew;
import com.soft.blued.ui.pay.BeansPrePayFragment;
import com.soft.blued.ui.setting.fragment.HelpCenterFragment;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.setting.fragment.SettingFragment;
import com.soft.blued.ui.setting.tools.ServiceHelper;
import com.soft.blued.ui.user.fragment.FollowedAndFansFragment;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.manager.AvatarWidgetManager;
import com.soft.blued.ui.user.model.UserInfoEntity;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.ui.welcome.AdMiniAppDialogFragment;
import com.soft.blued.ui.welcome.BaseADVideoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.AppUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.WeChatUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import skin.support.observe.SkinObservable;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/MineNewFragment.class */
public final class MineNewFragment extends MVVMBaseFragment<MineViewModel> implements SingleSessionListener, BluedSkinObserver {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f17930a = {(KProperty) Reflection.a(new PropertyReference1Impl(MineNewFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/FragmentMineNewBinding;", 0))};
    private final ViewBindingProperty b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17931c;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/MineNewFragment$MyPagerAdapter.class */
    public static final class MyPagerAdapter extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final Context f17932a;
        private final List<View> b;

        /* JADX WARN: Multi-variable type inference failed */
        public MyPagerAdapter(Context context, List<? extends View> list) {
            Intrinsics.e(context, "context");
            Intrinsics.e(list, "emotions");
            this.f17932a = context;
            this.b = list;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            Intrinsics.e(viewGroup, "container");
            Intrinsics.e(obj, "object");
            viewGroup.removeView((View) obj);
        }

        public final Context getContext() {
            return this.f17932a;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.b.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            Intrinsics.e(viewGroup, "container");
            viewGroup.addView(this.b.get(i));
            return this.b.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            Intrinsics.e(view, a.B);
            Intrinsics.e(obj, "object");
            return Intrinsics.a(view, obj);
        }
    }

    public MineNewFragment() {
        super((int) R.layout.fragment_mine_new);
        this.b = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<MineNewFragment, FragmentMineNewBinding>() { // from class: com.soft.blued.ui.mine.fragment.MineNewFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/mine/fragment/MineNewFragment;)Lcom/soft/blued/databinding/FragmentMineNewBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentMineNewBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<MineNewFragment, FragmentMineNewBinding>() { // from class: com.soft.blued.ui.mine.fragment.MineNewFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/mine/fragment/MineNewFragment;)Lcom/soft/blued/databinding/FragmentMineNewBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentMineNewBinding.a(fragment.requireView());
            }
        });
        this.f17931c = "http://native.blued.cn?action=emotion_shop&index=0";
    }

    private final void A() {
        Resources resources;
        EventTrackSettings.a(SettingsProtos.Event.MINE_EDIT_PROFILE_CLICK);
        if (!YYRoomInfoManager.e().y()) {
            if (PopMenuUtils.a(getContext())) {
                return;
            }
            InstantLog.b("my_model", 2);
            InstantLog.a("modify_user_profile", (Object) 0);
            ModifyUserInfoFragment.a(getContext(), 601, false);
            return;
        }
        Context context = getContext();
        CharSequence charSequence = null;
        if (context != null && (resources = context.getResources()) != null) {
            charSequence = resources.getText(R.string.yy_in_use_owners);
        }
        AppMethods.a(charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = AppInfo.l;
        layoutParams.height = AppInfo.m;
        view.setLayoutParams(layoutParams);
    }

    private final void a(TextView textView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            textView.setTextColor(Color.parseColor(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BluedPopupWindow bluedPopupWindow, View view) {
        Tracker.onClick(view);
        bluedPopupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MineNewFragment mineNewFragment, SessionModel sessionModel) {
        Intrinsics.e(mineNewFragment, "this$0");
        if (CommonTools.a((Fragment) mineNewFragment)) {
            if (sessionModel.noReadMsgCount <= 0) {
                FragmentMineNewBinding p = mineNewFragment.p();
                ShapeTextView shapeTextView = p == null ? null : p.q;
                if (shapeTextView == null) {
                    return;
                }
                shapeTextView.setVisibility(4);
                return;
            }
            BluedPreferences.G(true);
            FragmentMineNewBinding p2 = mineNewFragment.p();
            ShapeTextView shapeTextView2 = p2 == null ? null : p2.q;
            if (shapeTextView2 != null) {
                shapeTextView2.setText(Intrinsics.a("+", Integer.valueOf(sessionModel.noReadMsgCount)));
            }
            FragmentMineNewBinding p3 = mineNewFragment.p();
            ShapeTextView shapeTextView3 = p3 == null ? null : p3.q;
            if (shapeTextView3 == null) {
                return;
            }
            shapeTextView3.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MineNewFragment mineNewFragment, ObservableScrollView observableScrollView, int i, int i2, int i3, int i4) {
        Intrinsics.e(mineNewFragment, "this$0");
        int a2 = DensityUtils.a(mineNewFragment.getContext(), 72.0f);
        if (i2 >= a2) {
            FragmentMineNewBinding p = mineNewFragment.p();
            FrameLayout frameLayout = p == null ? null : p.an;
            if (frameLayout != null) {
                frameLayout.setAlpha(1.0f);
            }
            FragmentMineNewBinding p2 = mineNewFragment.p();
            LinearLayout linearLayout = p2 == null ? null : p2.ai;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setAlpha(1.0f);
            return;
        }
        float f = i2 / a2;
        FragmentMineNewBinding p3 = mineNewFragment.p();
        FrameLayout frameLayout2 = p3 == null ? null : p3.an;
        if (frameLayout2 != null) {
            frameLayout2.setAlpha(f);
        }
        FragmentMineNewBinding p4 = mineNewFragment.p();
        LinearLayout linearLayout2 = p4 == null ? null : p4.ai;
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setAlpha(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MineNewFragment mineNewFragment, MinePageModel.ColumnsItem columnsItem, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.b(columnsItem.url);
        SettingsEventUtils.a(SettingsProtos.Event.MINE_BTN_CLICK.name(), columnsItem.url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MineNewFragment mineNewFragment, UserInfoEntity userInfoEntity, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.a(Integer.valueOf(userInfoEntity.anchor_sing_type));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MineNewFragment mineNewFragment, UserInfoEntity userInfoEntity, MinePageModel.VipInfo vipInfo, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.b(userInfoEntity, vipInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MineNewFragment mineNewFragment, Boolean bool) {
        Intrinsics.e(mineNewFragment, "this$0");
        MineViewModel mineViewModel = (MineViewModel) mineNewFragment.j();
        ActivityFragmentActive fragmentActive = mineNewFragment.getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        mineViewModel.a(fragmentActive);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MineNewFragment mineNewFragment, Integer num) {
        Intrinsics.e(mineNewFragment, "this$0");
        MinePageModel value = ((MineViewModel) mineNewFragment.a()).d().getValue();
        UserInfoEntity userInfoEntity = value == null ? null : value.user;
        if (userInfoEntity != null) {
            Intrinsics.c(num, "resID");
            userInfoEntity.theme_pendant = num.intValue();
        }
        IRequestHost fragmentActive = mineNewFragment.getFragmentActive();
        AvatarWidgetManager a2 = AvatarWidgetManager.a();
        Intrinsics.c(num, "resID");
        ImageWrapper a3 = ImageLoader.a(fragmentActive, a2.a(num.intValue()));
        FragmentMineNewBinding p = mineNewFragment.p();
        a3.a(p == null ? null : p.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MineNewFragment mineNewFragment, Object obj) {
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MineNewFragment mineNewFragment, List list, View view) {
        ViewFlipper viewFlipper;
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        Intrinsics.e(list, "$bannerList");
        FragmentMineNewBinding p = mineNewFragment.p();
        Integer num = null;
        if (p != null && (viewFlipper = p.aD) != null) {
            num = Integer.valueOf(viewFlipper.getDisplayedChild());
        }
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        if (!TextUtils.isEmpty(((MinePageModel.VipBroadcast) list.get(intValue)).url)) {
            EventTrackSettings.a(SettingsProtos.Event.MINE_VIP_BANNER_COPYWRITING_CLICK, ((MinePageModel.VipBroadcast) list.get(intValue)).url, intValue + 1);
        }
        InstantLog.a("mine_vip_banner_right_click");
        WebViewShowInfoFragment.show(mineNewFragment.getContext(), ((MinePageModel.VipBroadcast) list.get(intValue)).url, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MineNewFragment mineNewFragment, List list, ItemMineVasEntry2Binding itemMineVasEntry2Binding, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        Intrinsics.e(itemMineVasEntry2Binding, "$leftViewBinding");
        mineNewFragment.b(((MinePageModel.ColumnsItem) list.get(0)).url);
        itemMineVasEntry2Binding.f15546a.setVisibility(8);
        BluedPreferences.Q(((MinePageModel.ColumnsItem) list.get(0)).item_key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(MinePageAdModel minePageAdModel) {
        ResourcePromotionView resourcePromotionView;
        ResourcePromotionView resourcePromotionView2;
        ResourcePromotionView resourcePromotionView3;
        if ((minePageAdModel == null ? null : minePageAdModel.getPopup()) == null) {
            FragmentMineNewBinding p = p();
            ResourcePromotionView resourcePromotionView4 = p == null ? null : p.af;
            if (resourcePromotionView4 == null) {
                return;
            }
            resourcePromotionView4.setVisibility(8);
        } else if (BluedPreferences.fC()) {
            FragmentMineNewBinding p2 = p();
            ResourcePromotionView resourcePromotionView5 = p2 == null ? null : p2.af;
            if (resourcePromotionView5 == null) {
                return;
            }
            resourcePromotionView5.setVisibility(8);
        } else {
            FragmentMineNewBinding p3 = p();
            if (p3 != null && (resourcePromotionView3 = p3.af) != null) {
                ActivityFragmentActive fragmentActive = getFragmentActive();
                Intrinsics.c(fragmentActive, "fragmentActive");
                resourcePromotionView3.a(minePageAdModel, (IRequestHost) fragmentActive);
            }
            long fE = BluedPreferences.fE();
            long currentTimeMillis = System.currentTimeMillis();
            MinePageAdModel.PopupAd popup = minePageAdModel.getPopup();
            if (popup == null) {
                return;
            }
            if (TimeAndDateUtils.a(fE, currentTimeMillis, popup.getFrequency_day())) {
                FragmentMineNewBinding p4 = p();
                if (p4 != null && (resourcePromotionView2 = p4.af) != null) {
                    resourcePromotionView2.a();
                }
                BluedPreferences.F(currentTimeMillis);
            } else {
                FragmentMineNewBinding p5 = p();
                if (p5 != null && (resourcePromotionView = p5.af) != null) {
                    resourcePromotionView.d();
                }
            }
            if (minePageAdModel.isShow()) {
                return;
            }
            minePageAdModel.setShow(true);
            FindHttpUtils.b(minePageAdModel.show_url);
            EventTrackSettings.a(SettingsProtos.Event.MINE_RESOURCE_SHOW, minePageAdModel.getJump_url());
            Log.v("drb", Intrinsics.a("我的页面_居中资源位_曝光： ", Long.valueOf(minePageAdModel.ads_id)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MinePageModel.ColumnsItem columnsItem, int i, MineNewFragment mineNewFragment, ItemMineHealthEntryExperienceBinding itemMineHealthEntryExperienceBinding, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        Intrinsics.e(itemMineHealthEntryExperienceBinding, "$healthyItemVB");
        SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
        String str = columnsItem.item.get(i).url;
        String str2 = columnsItem.item.get(i).key;
        boolean z = true;
        if (BluedConfig.a().g().is_chat_shadow != 1) {
            z = false;
        }
        EventTrackSettings.a(event, str, str2, z);
        Log.v("drb", Intrinsics.a("columnsItem.item[i].url:", columnsItem.item.get(i).url));
        mineNewFragment.b(columnsItem.item.get(i).url);
        itemMineHealthEntryExperienceBinding.b.setVisibility(8);
        BluedPreferences.Q(columnsItem.item.get(i).item_key);
        SettingsEventUtils.a(SettingsProtos.Event.MINE_BTN_CLICK.name(), columnsItem.item.get(i).url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MinePageModel.ColumnsItem columnsItem, MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(columnsItem, "$banner");
        Intrinsics.e(mineNewFragment, "this$0");
        SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
        String str = columnsItem.url;
        String str2 = columnsItem.id;
        boolean z = true;
        if (BluedConfig.a().g().is_chat_shadow != 1) {
            z = false;
        }
        EventTrackSettings.a(event, str, str2, z);
        mineNewFragment.b(columnsItem.url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MinePageModel.ColumnsItem columnsItem, MineNewFragment mineNewFragment, ItemMineZhealthEntryBinding itemMineZhealthEntryBinding, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        Intrinsics.e(itemMineZhealthEntryBinding, "$zhealthyItemVB");
        SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
        String str = columnsItem.item.get(0).url;
        String str2 = columnsItem.item.get(0).id;
        boolean z = true;
        if (BluedConfig.a().g().is_chat_shadow != 1) {
            z = false;
        }
        EventTrackSettings.a(event, str, str2, z);
        mineNewFragment.b(columnsItem.item.get(0).url);
        itemMineZhealthEntryBinding.b.setVisibility(8);
        BluedPreferences.Q(columnsItem.item.get(0).item_key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MinePageModel.EmotionItem emotionItem, MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(emotionItem, "$emotion");
        Intrinsics.e(mineNewFragment, "this$0");
        SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
        String str = emotionItem.redirect_url;
        String str2 = emotionItem.emotion_id;
        boolean z = true;
        if (BluedConfig.a().g().is_chat_shadow != 1) {
            z = false;
        }
        EventTrackSettings.a(event, str, str2, z);
        WebViewShowInfoFragment.show(mineNewFragment.getContext(), emotionItem.redirect_url);
    }

    private final void a(MinePageModel.HealthItem healthItem) {
        ShapeLinearLayout shapeLinearLayout;
        ShapeLinearLayout shapeLinearLayout2;
        ShapeLinearLayout shapeLinearLayout3;
        if (healthItem == null) {
            FragmentMineNewBinding p = p();
            LinearLayout linearLayout = p == null ? null : p.M;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        View inflate = getLayoutInflater().inflate(R.layout.item_mine_new_health_entry, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 2.0f;
        inflate.setLayoutParams(layoutParams);
        FragmentMineNewBinding p2 = p();
        LinearLayout linearLayout2 = p2 == null ? null : p2.M;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        FragmentMineNewBinding p3 = p();
        if (p3 != null && (shapeLinearLayout3 = p3.N) != null) {
            shapeLinearLayout3.removeAllViews();
        }
        final MinePageModel.ColumnsItem columnsItem = healthItem.left;
        ItemMineNewHealthEntryBinding a2 = ItemMineNewHealthEntryBinding.a(inflate);
        Intrinsics.c(a2, "bind(rootView)");
        a2.d.setText(columnsItem.title);
        a2.f15544c.setVisibility(8);
        a2.f15543a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$RqB5ZL6bI5sWiLFeBrLqWRYTFnw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.a(MineNewFragment.this, columnsItem, view);
            }
        });
        a2.b.removeAllViews();
        SettingsEventUtils.a(SettingsProtos.Event.MINE_AREA_SHOW.name(), columnsItem.url);
        a(healthItem, a2);
        FragmentMineNewBinding p4 = p();
        if (p4 != null && (shapeLinearLayout2 = p4.N) != null) {
            shapeLinearLayout2.addView(inflate);
        }
        View inflate2 = getLayoutInflater().inflate(R.layout.item_mine_new_health_entry, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        layoutParams2.weight = 1.0f;
        inflate2.setLayoutParams(layoutParams2);
        final MinePageModel.ColumnsItem columnsItem2 = healthItem.right;
        ItemMineNewHealthEntryBinding a3 = ItemMineNewHealthEntryBinding.a(inflate2);
        Intrinsics.c(a3, "bind(zhealthView)");
        a3.d.setText(columnsItem2.title);
        a3.f15544c.setVisibility(0);
        a3.f15543a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$CnoO2QlVT4KEym2OwHi0EAPpDbI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.b(MineNewFragment.this, columnsItem2, view);
            }
        });
        a3.b.removeAllViews();
        View inflate3 = getLayoutInflater().inflate(R.layout.item_mine_zhealth_entry, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        inflate3.setLayoutParams(layoutParams3);
        final ItemMineZhealthEntryBinding a4 = ItemMineZhealthEntryBinding.a(inflate3);
        Intrinsics.c(a4, "bind(zhealthItemView)");
        a4.g.setText(columnsItem2.item.get(0).title);
        a4.f.setText(columnsItem2.item.get(0).recommend_text);
        if (columnsItem2.item.get(0).is_highlight == 1) {
            a4.f.setTextColor(Color.parseColor("#00CCCC"));
        } else {
            a4.f.setTextColor(BluedSkinUtils.a(getContext(), 2131101625));
        }
        ImageLoader.a(getFragmentActive(), columnsItem2.item.get(0).icon1).a(a4.f15556c);
        if (TextUtils.isEmpty(columnsItem2.item.get(0).icon2)) {
            a4.d.setVisibility(8);
        } else {
            a4.d.setVisibility(0);
            ImageLoader.a(getFragmentActive(), columnsItem2.item.get(0).icon2).a(a4.d);
        }
        a3.b.addView(inflate3);
        if (BluedPreferences.P(columnsItem2.item.get(0).item_key)) {
            a4.b.setVisibility(0);
        } else {
            a4.b.setVisibility(8);
        }
        TextView textView = a4.g;
        Intrinsics.c(textView, "zhealthyItemVB.tvTitle");
        a(textView, columnsItem2.item.get(0).title_color);
        TextView textView2 = a4.f;
        Intrinsics.c(textView2, "zhealthyItemVB.tvDes");
        a(textView2, columnsItem2.item.get(0).content_color);
        a4.f15555a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$ReGq2c4aTzXH73dMTTTVIq4hrYM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.a(MinePageModel.ColumnsItem.this, this, a4, view);
            }
        });
        FragmentMineNewBinding p5 = p();
        if (p5 == null || (shapeLinearLayout = p5.N) == null) {
            return;
        }
        shapeLinearLayout.addView(inflate2);
    }

    private final void a(MinePageModel.HealthItem healthItem, ItemMineNewHealthEntryBinding itemMineNewHealthEntryBinding) {
        if (healthItem == null) {
            return;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        linearLayout2.setOrientation(1);
        layoutParams.weight = 0.6f;
        linearLayout2.setLayoutParams(layoutParams);
        linearLayout.addView(linearLayout2);
        View inflate = getLayoutInflater().inflate(R.layout.item_mine_health_entry_experience_mid, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
        layoutParams2.weight = 0.4f;
        inflate.setLayoutParams(layoutParams2);
        final ItemMineHealthEntryExperienceMidBinding a2 = ItemMineHealthEntryExperienceMidBinding.a(inflate);
        Intrinsics.c(a2, "bind(midItemView)");
        linearLayout.addView(inflate);
        a2.d.removeAllViews();
        if (healthItem.mid != null && healthItem.mid.item != null) {
            List<MinePageModel.ColumnsItem> list = healthItem.mid.item;
            Intrinsics.c(list, "healthy.mid.item");
            final List<MinePageModel.ColumnsItem> c2 = c(list);
            if (!c2.isEmpty()) {
                for (final MinePageModel.ColumnsItem columnsItem : c2) {
                    View inflate2 = getLayoutInflater().inflate(R.layout.item_mine_health_entry_experience_mid_child, (ViewGroup) null);
                    ItemMineHealthEntryExperienceMidChildBinding a3 = ItemMineHealthEntryExperienceMidChildBinding.a(inflate2);
                    Intrinsics.c(a3, "bind(goodsView)");
                    a3.f15540c.setText(columnsItem.title);
                    ImageLoader.a(getFragmentActive(), columnsItem.icon1).f().g(-1).a(a3.b);
                    a3.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$mytpolbczgNdsgF6aoXcwKepGQ0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            MineNewFragment.b(MinePageModel.ColumnsItem.this, this, view);
                        }
                    });
                    a2.d.addView(inflate2);
                }
                Animation inAnimation = a2.d.getInAnimation();
                if (inAnimation != null) {
                    inAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.mine.fragment.MineNewFragment$setHealthExperienceEntry$2
                        /* JADX WARN: Code restructure failed: missing block: B:13:0x0117, code lost:
                            r0 = r6.p();
                         */
                        @Override // android.view.animation.Animation.AnimationListener
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public void onAnimationEnd(android.view.animation.Animation r7) {
                            /*
                                Method dump skipped, instructions count: 307
                                To view this dump change 'Code comments level' option to 'DEBUG'
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.mine.fragment.MineNewFragment$setHealthExperienceEntry$2.onAnimationEnd(android.view.animation.Animation):void");
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                            Intrinsics.e(animation, "animation");
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            Intrinsics.e(animation, "animation");
                        }
                    });
                }
                if (c2.size() > 1) {
                    a2.d.startFlipping();
                } else {
                    a2.d.stopFlipping();
                    EventTrackSettings.a(SettingsProtos.Event.MINE_AREA_SHOW, SettingsProtos.ModuleType.HEALTH, c2.get(0).url, c2.get(0).key, BluedConfig.a().g().is_chat_shadow == 1);
                    SettingsEventUtils.a(SettingsProtos.Event.MINE_AREA_SHOW.name(), c2.get(0).url);
                    Log.v("drb", "商品曝光id=" + ((Object) c2.get(0).key) + " -- url=" + ((Object) c2.get(0).url));
                }
            }
        }
        final MinePageModel.ColumnsItem columnsItem2 = healthItem.left;
        int size = columnsItem2.item.size();
        int i = 0;
        while (true) {
            final int i2 = i;
            if (i2 >= size) {
                itemMineNewHealthEntryBinding.b.getLayoutParams().height = DensityUtils.a(getContext(), 120.0f);
                return;
            }
            View inflate3 = getLayoutInflater().inflate(R.layout.item_mine_health_entry_experience, (ViewGroup) null);
            inflate3.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            final ItemMineHealthEntryExperienceBinding a4 = ItemMineHealthEntryExperienceBinding.a(inflate3);
            Intrinsics.c(a4, "bind(rootItemView)");
            a4.e.setText(columnsItem2.item.get(i2).title);
            a4.d.setText(columnsItem2.item.get(i2).recommend_text);
            if (columnsItem2.item.get(i2).is_highlight == 1) {
                a4.d.setTextColor(Color.parseColor("#00CCCC"));
            } else {
                a4.d.setTextColor(BluedSkinUtils.a(getContext(), 2131101625));
            }
            ImageLoader.a(getFragmentActive(), columnsItem2.item.get(i2).icon1).a(a4.f15536c);
            linearLayout2.addView(inflate3);
            if (BluedPreferences.P(columnsItem2.item.get(i2).item_key)) {
                a4.b.setVisibility(0);
            } else {
                a4.b.setVisibility(8);
            }
            TextView textView = a4.e;
            Intrinsics.c(textView, "healthyItemVB.tvTitle");
            a(textView, columnsItem2.item.get(i2).title_color);
            TextView textView2 = a4.d;
            Intrinsics.c(textView2, "healthyItemVB.tvDes");
            a(textView2, columnsItem2.item.get(i2).content_color);
            a4.f15535a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$6UEyB-ddXju-TB6nCiIezZHNhh0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineNewFragment.a(MinePageModel.ColumnsItem.this, i2, this, a4, view);
                }
            });
            SettingsEventUtils.a(SettingsProtos.Event.MINE_AREA_SHOW.name(), columnsItem2.item.get(i2).url);
            ViewParent parent = linearLayout.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeAllViews();
            }
            itemMineNewHealthEntryBinding.b.addView(linearLayout);
            i = i2 + 1;
        }
    }

    private final void a(final MinePageModel.MineBanner mineBanner) {
        BluedADConstraintLayout bluedADConstraintLayout;
        if ((mineBanner == null ? null : mineBanner.img) == null) {
            FragmentMineNewBinding p = p();
            CardView cardView = p == null ? null : p.l;
            if (cardView == null) {
                return;
            }
            cardView.setVisibility(8);
            return;
        }
        FragmentMineNewBinding p2 = p();
        CardView cardView2 = p2 == null ? null : p2.l;
        if (cardView2 != null) {
            cardView2.setVisibility(0);
        }
        ImageWrapper a2 = ImageLoader.a(getFragmentActive(), mineBanner.img);
        FragmentMineNewBinding p3 = p();
        a2.a(p3 == null ? null : p3.u);
        FragmentMineNewBinding p4 = p();
        if (p4 == null || (bluedADConstraintLayout = p4.f15202a) == null) {
            return;
        }
        bluedADConstraintLayout.a(mineBanner, new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$eBIThOztawrp1UvxzPEx7eI_0Yk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.a(MinePageModel.MineBanner.this, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(MinePageModel.MineBanner mineBanner, MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        EventTrackSettings.a(SettingsProtos.Event.MINE_BTN_CLICK, mineBanner.link, (String) null, BluedConfig.a().g().is_chat_shadow == 1);
        if (mineBanner.wx != null && !TextUtils.isEmpty(mineBanner.wx.id) && !TextUtils.isEmpty(mineBanner.wx.path)) {
            if (mineBanner.wx.is_popup != 1) {
                WeChatUtils.a(mineNewFragment.getContext(), mineBanner.wx.id, mineBanner.wx.path);
                return;
            }
            AdMiniAppDialogFragment.Companion companion = AdMiniAppDialogFragment.f20819a;
            FragmentManager childFragmentManager = mineNewFragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "childFragmentManager");
            String str = mineBanner.wx.id;
            Intrinsics.c(str, "banner.wx.id");
            String str2 = mineBanner.wx.path;
            Intrinsics.c(str2, "banner.wx.path");
            companion.a(childFragmentManager, str, str2, mineBanner);
        } else if (mineBanner.adm_type == 2) {
            BaseADVideoFragment.a(mineNewFragment.getContext(), mineBanner, 1);
        } else if (TextUtils.isEmpty(mineBanner.deep_link_url)) {
            WebViewShowInfoFragment.show(mineNewFragment.getContext(), mineBanner.link, 9);
        } else {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(mineBanner.deep_link_url));
            if (!AppUtils.a(intent)) {
                WebViewShowInfoFragment.show(mineNewFragment.getContext(), mineBanner.link, 9);
                return;
            }
            Context context = mineNewFragment.getContext();
            if (context == null) {
                return;
            }
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(MinePageModel minePageModel) {
        c(minePageModel.user);
        a(minePageModel.user, minePageModel.vip_broadcast);
        b(minePageModel.user);
        d(minePageModel.service);
        a(minePageModel.healthy);
        b(minePageModel.healthy_banner);
        a(minePageModel.banner);
        UserInfoEntity userInfoEntity = minePageModel.user;
        a(userInfoEntity == null ? null : userInfoEntity.credit_score);
        a(minePageModel.emotions);
        a(minePageModel.user);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(GroupGuideModel groupGuideModel) {
        FragmentMineNewBinding p = p();
        if (p == null) {
            return;
        }
        if (TextUtils.isEmpty(groupGuideModel.my) || TextUtils.equals(BluedPreferences.fG(), groupGuideModel.my)) {
            p.n.setVisibility(4);
            return;
        }
        BluedPreferences.aw(groupGuideModel.my);
        p.n.setVisibility(0);
        p.n.setText(groupGuideModel.my);
    }

    private final void a(UserInfoEntity userInfoEntity) {
        ShapeLinearLayout shapeLinearLayout;
        ShapeLinearLayout shapeLinearLayout2;
        ShapeLinearLayout shapeLinearLayout3;
        if (userInfoEntity == null || userInfoEntity.is_anchor != 1) {
            FragmentMineNewBinding p = p();
            ShapeLinearLayout shapeLinearLayout4 = p == null ? null : p.R;
            if (shapeLinearLayout4 != null) {
                shapeLinearLayout4.setVisibility(8);
            }
        } else {
            FragmentMineNewBinding p2 = p();
            ShapeLinearLayout shapeLinearLayout5 = p2 == null ? null : p2.R;
            if (shapeLinearLayout5 != null) {
                shapeLinearLayout5.setVisibility(0);
            }
            FragmentMineNewBinding p3 = p();
            if (p3 != null && (shapeLinearLayout3 = p3.R) != null) {
                shapeLinearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$iyIJOcx1vr6p-qT7XvweP1oSV7E
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        MineNewFragment.d(MineNewFragment.this, view);
                    }
                });
            }
            ImageWrapper a2 = ImageLoader.a(getFragmentActive(), userInfoEntity.anchor_level_icon);
            FragmentMineNewBinding p4 = p();
            a2.a(p4 == null ? null : p4.B);
        }
        FragmentMineNewBinding p5 = p();
        TextView textView = p5 == null ? null : p5.av;
        if (textView != null) {
            textView.setText(Intrinsics.a("Lv", LiveUtils.a(UserInfo.getInstance().getLoginUserInfo().getRich_level())));
        }
        FragmentMineNewBinding p6 = p();
        if (p6 != null && (shapeLinearLayout2 = p6.Q) != null) {
            shapeLinearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$ZVzdTUWbyKEtd27JiIQsUa7rId0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineNewFragment.e(MineNewFragment.this, view);
                }
            });
        }
        FragmentMineNewBinding p7 = p();
        if (p7 == null || (shapeLinearLayout = p7.T) == null) {
            return;
        }
        shapeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$xhyQrqMid54NFBFku4HzNiVuNBk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.f(MineNewFragment.this, view);
            }
        });
    }

    private final void a(final UserInfoEntity userInfoEntity, final MinePageModel.VipInfo vipInfo) {
        LinearLayout linearLayout;
        Context context;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        Resources resources;
        ViewFlipper viewFlipper = null;
        if (vipInfo != null) {
            ImageWrapper d = ImageLoader.a(getFragmentActive(), vipInfo.getBg()).f().b((int) R.drawable.mine_vip_bg).d((int) R.drawable.mine_vip_bg);
            FragmentMineNewBinding p = p();
            d.a(p == null ? null : p.D);
            FragmentMineNewBinding p2 = p();
            TextView textView6 = p2 == null ? null : p2.az;
            if (textView6 != null) {
                textView6.setText(vipInfo.title);
            }
            if (TextUtils.isEmpty(vipInfo.vip_level_pic)) {
                FragmentMineNewBinding p3 = p();
                ImageView imageView = p3 == null ? null : p3.F;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            } else {
                FragmentMineNewBinding p4 = p();
                TextView textView7 = p4 == null ? null : p4.az;
                if (textView7 != null) {
                    textView7.setVisibility(8);
                }
                FragmentMineNewBinding p5 = p();
                ImageView imageView2 = p5 == null ? null : p5.F;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                }
                ImageWrapper a2 = ImageLoader.a(getFragmentActive(), vipInfo.vip_level_pic);
                FragmentMineNewBinding p6 = p();
                a2.a(p6 == null ? null : p6.F);
            }
            FragmentMineNewBinding p7 = p();
            TextView textView8 = p7 == null ? null : p7.ay;
            if (textView8 != null) {
                textView8.setText(vipInfo.btn);
            }
            FragmentMineNewBinding p8 = p();
            if (p8 != null && (textView5 = p8.ay) != null) {
                Context context2 = getContext();
                Integer valueOf = (context2 == null || (resources = context2.getResources()) == null) ? null : Integer.valueOf(resources.getColor(2131102203));
                Intrinsics.a(valueOf);
                textView5.setTextColor(valueOf.intValue());
            }
            if (userInfoEntity != null && (context = getContext()) != null) {
                if (userInfoEntity.vip_grade == 2) {
                    FragmentMineNewBinding p9 = p();
                    if (p9 != null && (textView4 = p9.ay) != null) {
                        textView4.setTextColor(context.getResources().getColor(R.color.syc_254791));
                    }
                } else if (userInfoEntity.vip_grade == 1) {
                    FragmentMineNewBinding p10 = p();
                    if (p10 != null && (textView3 = p10.ay) != null) {
                        textView3.setTextColor(context.getResources().getColor(R.color.syc_7B401D));
                    }
                } else if (userInfoEntity.expire_type == 1) {
                    FragmentMineNewBinding p11 = p();
                    if (p11 != null && (textView2 = p11.ay) != null) {
                        textView2.setTextColor(context.getResources().getColor(R.color.syc_7B401D));
                    }
                } else {
                    FragmentMineNewBinding p12 = p();
                    if (p12 != null && (textView = p12.ay) != null) {
                        textView.setTextColor(context.getResources().getColor(R.color.syc_254791));
                    }
                }
            }
            FragmentMineNewBinding p13 = p();
            ShapeHelper.b(p13 == null ? null : p13.ad, 2131102170);
            FragmentMineNewBinding p14 = p();
            ImageView imageView3 = p14 == null ? null : p14.E;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
            }
            ImageWrapper d2 = ImageLoader.a(getFragmentActive(), vipInfo.arrow_pic).b((int) R.drawable.icon_vip_center_arrow_right).d((int) R.drawable.icon_vip_center_arrow_right);
            FragmentMineNewBinding p15 = p();
            d2.a(p15 == null ? null : p15.E);
            if (vipInfo.carousels == null || vipInfo.carousels.size() <= 0) {
                FragmentMineNewBinding p16 = p();
                ViewFlipper viewFlipper2 = p16 == null ? null : p16.aD;
                if (viewFlipper2 != null) {
                    viewFlipper2.setVisibility(8);
                }
            } else {
                FragmentMineNewBinding p17 = p();
                ViewFlipper viewFlipper3 = p17 == null ? null : p17.aD;
                if (viewFlipper3 != null) {
                    viewFlipper3.setVisibility(0);
                }
                List<MinePageModel.VipBroadcast> list = vipInfo.carousels;
                Intrinsics.c(list, "broadcast.carousels");
                a(list, userInfoEntity);
            }
        } else {
            FragmentMineNewBinding p18 = p();
            if (p18 != null) {
                viewFlipper = p18.aD;
            }
            if (viewFlipper != null) {
                viewFlipper.setVisibility(8);
            }
        }
        FragmentMineNewBinding p19 = p();
        if (p19 == null || (linearLayout = p19.I) == null) {
            return;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$b9D-Fwz6tXtq0GLZOi7xeGAmpqk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.a(MineNewFragment.this, userInfoEntity, vipInfo, view);
            }
        });
    }

    private final void a(Integer num) {
        boolean z = false;
        if (num != null && num.intValue() == 1) {
            SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
            String a2 = H5Url.a(1);
            if (BluedConfig.a().g().is_chat_shadow == 1) {
                z = true;
            }
            EventTrackSettings.a(event, a2, "", z);
            b(H5Url.a(1));
        } else if (num != null && num.intValue() == 2) {
            SettingsProtos.Event event2 = SettingsProtos.Event.MINE_BTN_CLICK;
            String a3 = H5Url.a(70);
            boolean z2 = false;
            if (BluedConfig.a().g().is_chat_shadow == 1) {
                z2 = true;
            }
            EventTrackSettings.a(event2, a3, "", z2);
            b(H5Url.a(70));
        } else if (num != null && num.intValue() == 3) {
            SettingsProtos.Event event3 = SettingsProtos.Event.MINE_BTN_CLICK;
            boolean z3 = false;
            if (BluedConfig.a().g().is_chat_shadow == 1) {
                z3 = true;
            }
            EventTrackSettings.a(event3, "live_report_page", "", z3);
            LiveChatReportWebViewFragment.a(getContext());
        } else if (num != null && num.intValue() == 4) {
            SettingsProtos.Event event4 = SettingsProtos.Event.MINE_BTN_CLICK;
            String a4 = H5Url.a(71);
            boolean z4 = false;
            if (BluedConfig.a().g().is_chat_shadow == 1) {
                z4 = true;
            }
            EventTrackSettings.a(event4, a4, "", z4);
            b(H5Url.a(71));
        }
    }

    private final void a(String str) {
        ShapeLinearLayout shapeLinearLayout;
        ShapeLinearLayout shapeLinearLayout2;
        FragmentMineNewBinding p = p();
        TextView textView = p == null ? null : p.ax;
        if (textView != null) {
            String str2 = str;
            if (TextUtils.isEmpty(str2)) {
            }
            textView.setText(str2);
        }
        FragmentMineNewBinding p2 = p();
        if (p2 != null && (shapeLinearLayout2 = p2.Z) != null) {
            shapeLinearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$wIHO3GFBfBUDwb64Z2eNezarP9k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineNewFragment.g(MineNewFragment.this, view);
                }
            });
        }
        FragmentMineNewBinding p3 = p();
        if (p3 == null || (shapeLinearLayout = p3.O) == null) {
            return;
        }
        shapeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$R9o76hram6_iP_-E4kSa0nQnF6g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.h(MineNewFragment.this, view);
            }
        });
    }

    private final void a(List<? extends MinePageModel.EmotionItem> list) {
        LinePageIndicator linePageIndicator;
        AutoScrollViewPager autoScrollViewPager;
        if (list == null || list.isEmpty()) {
            FragmentMineNewBinding p = p();
            ShapeConstraintLayout shapeConstraintLayout = p == null ? null : p.L;
            if (shapeConstraintLayout == null) {
                return;
            }
            shapeConstraintLayout.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (final MinePageModel.EmotionItem emotionItem : list) {
            ItemMineEmotionBinding a2 = ItemMineEmotionBinding.a(LayoutInflater.from(getContext()).inflate(R.layout.item_mine_emotion, (ViewGroup) null));
            Intrinsics.c(a2, "bind(emotionView)");
            ImageLoader.a((IRequestHost) null, emotionItem.banner).a(a2.a);
            a2.a().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$gAlNKwYe5z9mGDCHNBDvuXMshHc
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineNewFragment.a(MinePageModel.EmotionItem.this, this, view);
                }
            });
            arrayList.add(a2.a());
        }
        FragmentMineNewBinding p2 = p();
        ShapeConstraintLayout shapeConstraintLayout2 = p2 == null ? null : p2.L;
        if (shapeConstraintLayout2 != null) {
            shapeConstraintLayout2.setVisibility(0);
        }
        FragmentMineNewBinding p3 = p();
        AutoScrollViewPager autoScrollViewPager2 = p3 == null ? null : p3.ae;
        if (autoScrollViewPager2 != null) {
            Context context = getContext();
            Intrinsics.a(context);
            Intrinsics.c(context, "context!!");
            autoScrollViewPager2.setAdapter(new MyPagerAdapter(context, arrayList));
        }
        FragmentMineNewBinding p4 = p();
        if (p4 != null && (autoScrollViewPager = p4.ae) != null) {
            autoScrollViewPager.a(3000);
        }
        FragmentMineNewBinding p5 = p();
        AutoScrollViewPager autoScrollViewPager3 = p5 == null ? null : p5.ae;
        if (autoScrollViewPager3 != null) {
            autoScrollViewPager3.setInterval((long) m.ag);
        }
        FragmentMineNewBinding p6 = p();
        if (p6 != null && (linePageIndicator = p6.v) != null) {
            FragmentMineNewBinding p7 = p();
            linePageIndicator.setViewPager(p7 == null ? null : p7.ae);
        }
        if (list.size() == 1) {
            FragmentMineNewBinding p8 = p();
            LinePageIndicator linePageIndicator2 = p8 == null ? null : p8.v;
            if (linePageIndicator2 == null) {
                return;
            }
            linePageIndicator2.setVisibility(8);
            return;
        }
        FragmentMineNewBinding p9 = p();
        LinePageIndicator linePageIndicator3 = p9 == null ? null : p9.v;
        if (linePageIndicator3 == null) {
            return;
        }
        linePageIndicator3.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(List list, int i, MineNewFragment mineNewFragment, ItemMineVasEntryBinding itemMineVasEntryBinding, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        Intrinsics.e(itemMineVasEntryBinding, "$vasViewBinding");
        SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
        String str = ((MinePageModel.ColumnsItem) list.get(i)).url;
        String str2 = ((MinePageModel.ColumnsItem) list.get(i)).id;
        boolean z = true;
        if (BluedConfig.a().g().is_chat_shadow != 1) {
            z = false;
        }
        EventTrackSettings.a(event, str, str2, z);
        mineNewFragment.b(((MinePageModel.ColumnsItem) list.get(i)).url);
        itemMineVasEntryBinding.f15550a.setVisibility(8);
        BluedPreferences.Q(((MinePageModel.ColumnsItem) list.get(i)).item_key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(List list, MineNewFragment mineNewFragment, ItemMineVasEntry3Binding itemMineVasEntry3Binding, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        Intrinsics.e(itemMineVasEntry3Binding, "$rightViewBinding");
        EventTrackSettings.a(SettingsProtos.Event.MINE_BTN_CLICK, ((MinePageModel.ColumnsItem) list.get(1)).url, ((MinePageModel.ColumnsItem) list.get(1)).id, BluedConfig.a().g().is_chat_shadow == 1);
        mineNewFragment.b(((MinePageModel.ColumnsItem) list.get(1)).url);
        itemMineVasEntry3Binding.f15548a.setVisibility(8);
        BluedPreferences.Q(((MinePageModel.ColumnsItem) list.get(1)).item_key);
    }

    private final void a(final List<? extends MinePageModel.VipBroadcast> list, UserInfoEntity userInfoEntity) {
        ViewFlipper viewFlipper;
        ViewFlipper viewFlipper2;
        ViewFlipper viewFlipper3;
        Animation inAnimation;
        LinearLayout linearLayout;
        ViewFlipper viewFlipper4;
        Context context;
        ViewFlipper viewFlipper5;
        FragmentMineNewBinding p = p();
        if (p != null && (viewFlipper5 = p.aD) != null) {
            viewFlipper5.removeAllViews();
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            MinePageModel.VipBroadcast vipBroadcast = list.get(i2);
            if (!TextUtils.isEmpty(vipBroadcast.text)) {
                View inflate = getLayoutInflater().inflate(R.layout.item_mine_vip_banner, (ViewGroup) null);
                ItemMineVipBannerBinding a2 = ItemMineVipBannerBinding.a(inflate);
                Intrinsics.c(a2, "bind(bannerView)");
                if (userInfoEntity != null && (context = getContext()) != null) {
                    if (userInfoEntity.vip_grade == 2) {
                        a2.b.setTextColor(context.getResources().getColor(2131102170));
                    } else if (userInfoEntity.vip_grade == 1) {
                        a2.b.setTextColor(context.getResources().getColor(R.color.syc_7B401D));
                    } else if (userInfoEntity.expire_type == 1) {
                        a2.b.setTextColor(context.getResources().getColor(R.color.syc_7B401D));
                    } else {
                        a2.b.setTextColor(context.getResources().getColor(2131102170));
                    }
                }
                a2.b.setText(vipBroadcast.text);
                FragmentMineNewBinding p2 = p();
                if (p2 != null && (viewFlipper4 = p2.aD) != null) {
                    viewFlipper4.addView(inflate);
                }
            }
            i = i2 + 1;
        }
        FragmentMineNewBinding p3 = p();
        if (p3 != null && (linearLayout = p3.ac) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$ovboyjpFfxW57UpaqVU3UnoItC8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineNewFragment.a(MineNewFragment.this, list, view);
                }
            });
        }
        FragmentMineNewBinding p4 = p();
        if (p4 != null && (viewFlipper3 = p4.aD) != null && (inAnimation = viewFlipper3.getInAnimation()) != null) {
            inAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.mine.fragment.MineNewFragment$setVipBroadcast$3
                /* JADX WARN: Code restructure failed: missing block: B:13:0x00d1, code lost:
                    r0 = r5.f17937a.p();
                 */
                @Override // android.view.animation.Animation.AnimationListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onAnimationEnd(android.view.animation.Animation r6) {
                    /*
                        Method dump skipped, instructions count: 237
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.mine.fragment.MineNewFragment$setVipBroadcast$3.onAnimationEnd(android.view.animation.Animation):void");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Intrinsics.e(animation, "animation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Intrinsics.e(animation, "animation");
                }
            });
        }
        if (list.size() > 1) {
            FragmentMineNewBinding p5 = p();
            if (p5 == null || (viewFlipper2 = p5.aD) == null) {
                return;
            }
            viewFlipper2.startFlipping();
            return;
        }
        FragmentMineNewBinding p6 = p();
        if (p6 != null && (viewFlipper = p6.aD) != null) {
            viewFlipper.stopFlipping();
        }
        if (TextUtils.isEmpty(list.get(0).url)) {
            return;
        }
        EventTrackSettings.a(SettingsProtos.Event.MINE_VIP_BANNER_COPYWRITING_SHOW, list.get(0).url, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(View view) {
        Tracker.onClick(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MineNewFragment mineNewFragment) {
        CardView cardView;
        ViewGroup.LayoutParams layoutParams;
        CardView cardView2;
        Intrinsics.e(mineNewFragment, "this$0");
        FragmentMineNewBinding p = mineNewFragment.p();
        if (p == null || (cardView = p.e) == null || (layoutParams = cardView.getLayoutParams()) == null) {
            return;
        }
        layoutParams.width = AppInfo.l - DensityUtils.a(mineNewFragment.getContext(), 24.0f);
        layoutParams.height = (int) ((layoutParams.width * 140.0f) / 710.0f);
        FragmentMineNewBinding p2 = mineNewFragment.p();
        if (p2 == null || (cardView2 = p2.e) == null) {
            return;
        }
        cardView2.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
        boolean z = true;
        if (BluedConfig.a().g().is_chat_shadow != 1) {
            z = false;
        }
        EventTrackSettings.a(event, "http://native.blued.cn/?action=setting", "", z);
        SettingFragment.a(mineNewFragment.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MineNewFragment mineNewFragment, MinePageModel.ColumnsItem columnsItem, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.b(columnsItem.url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MineNewFragment mineNewFragment, UserInfoEntity userInfoEntity, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.a(userInfoEntity == null ? null : Integer.valueOf(userInfoEntity.anchor_sing_type));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(MinePageModel.ColumnsItem columnsItem, MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(columnsItem, "$it");
        Intrinsics.e(mineNewFragment, "this$0");
        SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
        String str = columnsItem.url;
        String str2 = columnsItem.key;
        boolean z = true;
        if (BluedConfig.a().g().is_chat_shadow != 1) {
            z = false;
        }
        EventTrackSettings.a(event, str, str2, z);
        Log.v("drb", "商品点击id：" + ((Object) columnsItem.key) + " -- url:" + ((Object) columnsItem.url));
        SettingsEventUtils.a(SettingsProtos.Event.MINE_BTN_CLICK.name(), columnsItem.url);
        mineNewFragment.b(columnsItem.url);
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b(final com.soft.blued.ui.user.model.UserInfoEntity r7) {
        /*
            Method dump skipped, instructions count: 747
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.mine.fragment.MineNewFragment.b(com.soft.blued.ui.user.model.UserInfoEntity):void");
    }

    private final void b(UserInfoEntity userInfoEntity, MinePageModel.VipInfo vipInfo) {
        if (vipInfo == null) {
            return;
        }
        if (userInfoEntity != null) {
            EventTrackSettings.a(SettingsProtos.Event.MINE_VIP_BANNER_CENTER_CLICK, EventTrackSettings.a(userInfoEntity.vip_expire_state, userInfoEntity.expire_type));
        }
        WebViewShowInfoFragment.show(getContext(), TextUtils.isEmpty(vipInfo.url) ? BluedHttpUrl.g() : vipInfo.url, 0);
    }

    private final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        WebViewShowInfoFragment.show(getContext(), str);
    }

    private final void b(final List<? extends MinePageModel.ColumnsItem> list) {
        ViewFlipper viewFlipper;
        ViewFlipper viewFlipper2;
        ViewFlipper viewFlipper3;
        Animation inAnimation;
        ViewFlipper viewFlipper4;
        ViewFlipper viewFlipper5;
        if (list == null || list.isEmpty()) {
            FragmentMineNewBinding p = p();
            ViewFlipper viewFlipper6 = p == null ? null : p.aC;
            if (viewFlipper6 == null) {
                return;
            }
            viewFlipper6.setVisibility(0);
            return;
        }
        FragmentMineNewBinding p2 = p();
        ViewFlipper viewFlipper7 = p2 == null ? null : p2.aC;
        if (viewFlipper7 != null) {
            viewFlipper7.setVisibility(0);
        }
        FragmentMineNewBinding p3 = p();
        if (p3 != null && (viewFlipper5 = p3.aC) != null) {
            viewFlipper5.removeAllViews();
        }
        for (final MinePageModel.ColumnsItem columnsItem : list) {
            View inflate = getLayoutInflater().inflate(R.layout.item_mine_healthy_banner, (ViewGroup) null);
            ItemMineHealthyBannerBinding a2 = ItemMineHealthyBannerBinding.a(inflate);
            Intrinsics.c(a2, "bind(bannerView)");
            a2.f15542c.setText(columnsItem.title);
            a2.b.setText(columnsItem.content);
            ImageLoader.a(getFragmentActive(), columnsItem.icon).a(a2.f15541a);
            TextView textView = a2.f15542c;
            Intrinsics.c(textView, "bannerVB.tvTitle");
            a(textView, columnsItem.title_color);
            TextView textView2 = a2.b;
            Intrinsics.c(textView2, "bannerVB.tvDes");
            a(textView2, columnsItem.content_color);
            a2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$qn5q3TiG4NpV4vTs-jacKoS9wI8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineNewFragment.a(MinePageModel.ColumnsItem.this, this, view);
                }
            });
            FragmentMineNewBinding p4 = p();
            if (p4 != null && (viewFlipper4 = p4.aC) != null) {
                viewFlipper4.addView(inflate);
            }
        }
        FragmentMineNewBinding p5 = p();
        if (p5 != null && (viewFlipper3 = p5.aC) != null && (inAnimation = viewFlipper3.getInAnimation()) != null) {
            inAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.mine.fragment.MineNewFragment$setHealthBannerEntry$2
                /* JADX WARN: Code restructure failed: missing block: B:19:0x00e9, code lost:
                    r0 = r6.f17934a.p();
                 */
                @Override // android.view.animation.Animation.AnimationListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onAnimationEnd(android.view.animation.Animation r7) {
                    /*
                        Method dump skipped, instructions count: 261
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.mine.fragment.MineNewFragment$setHealthBannerEntry$2.onAnimationEnd(android.view.animation.Animation):void");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Intrinsics.e(animation, "animation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Intrinsics.e(animation, "animation");
                }
            });
        }
        if (list.size() > 1) {
            FragmentMineNewBinding p6 = p();
            if (p6 == null || (viewFlipper2 = p6.aC) == null) {
                return;
            }
            viewFlipper2.startFlipping();
            return;
        }
        FragmentMineNewBinding p7 = p();
        if (p7 != null && (viewFlipper = p7.aC) != null) {
            viewFlipper.stopFlipping();
        }
        EventTrackSettings.a(SettingsProtos.Event.MINE_AREA_SHOW, SettingsProtos.ModuleType.HEALTH, list.get(0).url, list.get(0).id, BluedConfig.a().g().is_chat_shadow == 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(List list, MineNewFragment mineNewFragment, ItemMineVasEntry3Binding itemMineVasEntry3Binding, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        Intrinsics.e(itemMineVasEntry3Binding, "$rightViewBinding");
        SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
        String str = ((MinePageModel.ColumnsItem) list.get(2)).url;
        String str2 = ((MinePageModel.ColumnsItem) list.get(2)).id;
        boolean z = true;
        if (BluedConfig.a().g().is_chat_shadow != 1) {
            z = false;
        }
        EventTrackSettings.a(event, str, str2, z);
        mineNewFragment.b(((MinePageModel.ColumnsItem) list.get(2)).url);
        itemMineVasEntry3Binding.b.setVisibility(8);
        BluedPreferences.Q(((MinePageModel.ColumnsItem) list.get(2)).item_key);
    }

    private final void b(boolean z) {
        if (z) {
            EventTrackSettings.a(SettingsProtos.Event.MINE_TOP_BAR_PHOTO_CLICK);
        } else {
            EventTrackSettings.a(SettingsProtos.Event.MINE_NICKNAME_CLICK);
        }
        Bundle bundle = new Bundle();
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.uid = UserInfo.getInstance().getLoginUserInfo().uid;
        bundle.putSerializable("user", (Serializable) userBasicModel);
        TerminalActivity.a(bundle);
        TerminalActivity.d(getContext(), UserInfoFragmentNew.class, bundle);
    }

    private final List<MinePageModel.ColumnsItem> c(List<? extends MinePageModel.ColumnsItem> list) {
        ArrayList arrayList = new ArrayList();
        List<? extends MinePageModel.ColumnsItem> list2 = list;
        if (!list2.isEmpty()) {
            List a2 = CollectionsKt.a(CollectionsKt.c(list2), new Comparator() { // from class: com.soft.blued.ui.mine.fragment.MineNewFragment$findShowItems$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.a(Integer.valueOf(((MinePageModel.ColumnsItem) t2).sort), Integer.valueOf(((MinePageModel.ColumnsItem) t).sort));
                }
            });
            int i = 0;
            int i2 = ((MinePageModel.ColumnsItem) a2.get(0)).sort;
            int size = a2.size();
            int i3 = 0;
            while (i < size) {
                int i4 = i + 1;
                if (i4 == a2.size() || ((MinePageModel.ColumnsItem) a2.get(i4)).sort != i2) {
                    arrayList.add(a2.get(RangesKt.a(new IntRange(i3, i), Random.a)));
                    if (i4 < a2.size()) {
                        i2 = ((MinePageModel.ColumnsItem) a2.get(i4)).sort;
                        i = i4;
                        i3 = i;
                    }
                }
                i = i4;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MineNewFragment mineNewFragment) {
        Intrinsics.e(mineNewFragment, "this$0");
        if (CommonTools.a((Fragment) mineNewFragment)) {
            FragmentMineNewBinding p = mineNewFragment.p();
            ShapeTextView shapeTextView = p == null ? null : p.q;
            if (shapeTextView == null) {
                return;
            }
            shapeTextView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        WebViewShowInfoFragment.show(mineNewFragment.getContext(), "https://activity.blued.cn/activity-blued/work/hnaaydgt", 0);
    }

    private final void c(UserInfoEntity userInfoEntity) {
        String str;
        Resources resources;
        FragmentMineNewBinding p = p();
        if (p == null) {
            return;
        }
        BluedLoginResult loginUserInfo = UserInfo.getInstance().getLoginUserInfo();
        Intrinsics.c(loginUserInfo, "getInstance().loginUserInfo");
        int vBadge = loginUserInfo.getVBadge();
        if (vBadge == 0) {
            ImageView imageView = p.C;
            Context context = getContext();
            imageView.setImageDrawable((context == null || (resources = context.getResources()) == null) ? null : resources.getDrawable(2131237327));
        } else {
            UserInfoHelper.a(p.C, vBadge, 1);
        }
        d(userInfoEntity);
        String name = loginUserInfo.getName();
        String avatar = loginUserInfo.getAvatar();
        AuditingProfileModel auditingProfileModel = loginUserInfo.auditing_profile;
        if (auditingProfileModel == null) {
            str = avatar;
        } else {
            String str2 = name;
            if (loginUserInfo.is_audited == 0) {
                String str3 = auditingProfileModel.name;
                str2 = name;
                if (!(str3 == null || str3.length() == 0)) {
                    str2 = auditingProfileModel.name;
                }
            }
            name = str2;
            str = avatar;
            if (loginUserInfo.avatar_audited == 0) {
                String str4 = auditingProfileModel.latest_avatar;
                boolean z = true;
                if (str4 != null) {
                    z = str4.length() == 0;
                }
                name = str2;
                str = avatar;
                if (!z) {
                    str = auditingProfileModel.latest_avatar;
                    name = str2;
                }
            }
        }
        p.aw.setText(name);
        ImageLoader.a(getFragmentActive(), AvatarUtils.a(0, str)).b(2131237310).d(2131237310).c().a(p.s);
        if (userInfoEntity != null) {
            ImageLoader.a(getFragmentActive(), AvatarWidgetManager.a().a(userInfoEntity.theme_pendant)).a(p.w);
        }
        p.j.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$GNSekDsmLkOpm2PpZFXb3sJSXzM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.j(MineNewFragment.this, view);
            }
        });
        p.aq.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$J_x7mWqHQmQZoZ4ruV_Ied7yma0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.k(MineNewFragment.this, view);
            }
        });
        p.x.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$l_oRYcANRNrAMH6rV8C_DQC6i6o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.l(MineNewFragment.this, view);
            }
        });
        p.ao.setText(loginUserInfo.getFollowedCount());
        p.f15203ar.setText(loginUserInfo.getFollowerCount());
        p.U.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$UYLkx3R5Z14taZCK2d12Tnbzpys
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.m(MineNewFragment.this, view);
            }
        });
        p.V.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$4nHmgzC_mioWYS1v9PXHDEq1XIk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.n(MineNewFragment.this, view);
            }
        });
        if (!BluedPreferences.be()) {
            if (userInfoEntity == null || TextUtils.isEmpty(userInfoEntity.visit_increase) || TextUtils.equals(userInfoEntity.visit_increase, "0")) {
                p.q.setVisibility(4);
            } else {
                p.q.setVisibility(0);
                p.q.setText(Intrinsics.a("+", userInfoEntity.visit_increase));
            }
        }
        if (userInfoEntity != null) {
            TextView textView = p.as;
            String str5 = userInfoEntity.ticktock_count;
            Context context2 = getContext();
            textView.setText(Intrinsics.a(str5, context2 == null ? null : context2.getString(R.string.feed_feeds)));
        }
        if (BluedConstant.b) {
            p.g.setVisibility(8);
        } else {
            EventTrackSettings.a(SettingsProtos.Event.MINE_GROUP_SHOW);
            p.g.setVisibility(0);
            String groupsCount = TextUtils.isEmpty(loginUserInfo.getGroupsCount()) ? "0" : loginUserInfo.getGroupsCount();
            TextView textView2 = p.at;
            Context context3 = getContext();
            textView2.setText(Intrinsics.a(groupsCount, context3 == null ? null : context3.getString(R.string.mine_groups)));
            p.at.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$iILk-60urk24JHJLAld6vU1xp9g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineNewFragment.o(MineNewFragment.this, view);
                }
            });
            p.z.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$wfZdfUuJPJOCSmmsjCMbi4mNAZo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineNewFragment.p(MineNewFragment.this, view);
                }
            });
        }
        p.au.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$6_sVwY7NBfDvZQnjVn1i0o4vuI0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.q(MineNewFragment.this, view);
            }
        });
        p.A.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$jLkQhwLSCMO7z_N5PkEsmKxMGMw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.r(MineNewFragment.this, view);
            }
        });
        p.aA.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$ZLc3xLOWQMRRJQllnwRr-PI_uAY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.s(MineNewFragment.this, view);
            }
        });
        p.G.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$HYUAMEUCaG3RjgxynX3VOEeGpPo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.t(MineNewFragment.this, view);
            }
        });
        p.as.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$J6TExPUBLdyUaEGY67bdmweypiU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.u(MineNewFragment.this, view);
            }
        });
        p.y.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$SUI-_Vdnm8mIJDkO7T1geD3j9_A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.v(MineNewFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
        String a2 = H5Url.a(68);
        boolean z = true;
        if (BluedConfig.a().g().is_chat_shadow != 1) {
            z = false;
        }
        EventTrackSettings.a(event, a2, "", z);
        mineNewFragment.b(H5Url.a(68));
    }

    private final void d(UserInfoEntity userInfoEntity) {
        FragmentMineNewBinding p = p();
        if (p == null) {
            return;
        }
        ShapeTextView shapeTextView = p.ah;
        BluedLoginResult loginUserInfo = UserInfo.getInstance().getLoginUserInfo();
        Intrinsics.c(loginUserInfo, "getInstance().loginUserInfo");
        int i = 0;
        if (loginUserInfo.avatar_audited == 0) {
            if (loginUserInfo.is_audited == 0) {
                shapeTextView.setText(shapeTextView.getContext().getText(R.string.audited_picture_profile_in_review));
            } else {
                shapeTextView.setText(shapeTextView.getContext().getText(R.string.audited_picture_in_review));
            }
        } else if (loginUserInfo.is_audited == 0) {
            shapeTextView.setText(shapeTextView.getContext().getText(R.string.audited_profile_in_review));
        } else {
            i = 8;
        }
        shapeTextView.setVisibility(i);
    }

    private final void d(final List<? extends MinePageModel.ColumnsItem> list) {
        GridLayout gridLayout;
        GridLayout gridLayout2;
        GridLayout gridLayout3;
        GridLayout gridLayout4;
        if (list == null || list.isEmpty()) {
            FragmentMineNewBinding p = p();
            LinearLayout linearLayout = p == null ? null : p.ab;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(8);
            return;
        }
        FragmentMineNewBinding p2 = p();
        LinearLayout linearLayout2 = p2 == null ? null : p2.ab;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        FragmentMineNewBinding p3 = p();
        if (p3 != null && (gridLayout4 = p3.r) != null) {
            gridLayout4.removeAllViews();
        }
        int a2 = (AppInfo.l - DensityUtils.a(getContext(), 29.0f)) / 2;
        if (list.size() == 3) {
            View inflate = getLayoutInflater().inflate(R.layout.item_mine_vas_entry, (ViewGroup) null);
            final ItemMineVasEntry2Binding a3 = ItemMineVasEntry2Binding.a(inflate);
            Intrinsics.c(a3, "bind(leftRootView)");
            inflate.setLayoutParams(new GridLayout.LayoutParams(new ViewGroup.MarginLayoutParams(a2, DensityUtils.a(getContext(), 127.0f))));
            a3.f.setText(list.get(0).title);
            TextView textView = a3.f;
            Intrinsics.c(textView, "leftViewBinding.tvTitle");
            a(textView, list.get(0).title_color);
            a3.d.setText(list.get(0).recommend_text);
            if (!TextUtils.isEmpty(list.get(0).activity_text)) {
                a3.e.setText(list.get(0).activity_text);
                a3.e.setVisibility(0);
            }
            TextView textView2 = a3.d;
            Intrinsics.c(textView2, "leftViewBinding.tvDes");
            a(textView2, list.get(0).content_color);
            ImageLoader.a(getFragmentActive(), list.get(0).icon).a(a3.b);
            ImageLoader.a(getFragmentActive(), list.get(0).icon2).a(a3.f15547c);
            if (BluedPreferences.P(list.get(0).item_key)) {
                a3.f15546a.setVisibility(0);
            } else {
                a3.f15546a.setVisibility(8);
            }
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$fIOZbx_rGmT6TaJ7WZqSPePDWC8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineNewFragment.a(MineNewFragment.this, list, a3, view);
                }
            });
            View inflate2 = getLayoutInflater().inflate(R.layout.item_mine_vas_entry3, (ViewGroup) null);
            final ItemMineVasEntry3Binding a4 = ItemMineVasEntry3Binding.a(inflate2);
            Intrinsics.c(a4, "bind(rightRootView)");
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(new ViewGroup.MarginLayoutParams(a2, DensityUtils.a(getContext(), 127.0f)));
            layoutParams.leftMargin = DensityUtils.a(getContext(), 5.0f);
            inflate2.setLayoutParams(layoutParams);
            a4.l.setText(list.get(1).title);
            TextView textView3 = a4.l;
            Intrinsics.c(textView3, "rightViewBinding.tvTitle1");
            a(textView3, list.get(1).title_color);
            a4.h.setText(list.get(1).recommend_text);
            TextView textView4 = a4.h;
            Intrinsics.c(textView4, "rightViewBinding.tvDes1");
            a(textView4, list.get(1).content_color);
            ImageLoader.a(getFragmentActive(), list.get(1).icon).a(a4.f15549c);
            if (!TextUtils.isEmpty(list.get(1).activity_text)) {
                a4.j.setText(list.get(1).activity_text);
                a4.j.setVisibility(0);
            }
            if (BluedPreferences.P(list.get(1).item_key)) {
                a4.f15548a.setVisibility(0);
            } else {
                a4.f15548a.setVisibility(8);
            }
            a4.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$L76OKIDVI8gnn-nAli0Y1WowrxY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineNewFragment.a(list, this, a4, view);
                }
            });
            a4.m.setText(list.get(2).title);
            TextView textView5 = a4.m;
            Intrinsics.c(textView5, "rightViewBinding.tvTitle2");
            a(textView5, list.get(2).title_color);
            a4.i.setText(list.get(2).recommend_text);
            TextView textView6 = a4.i;
            Intrinsics.c(textView6, "rightViewBinding.tvDes2");
            a(textView6, list.get(2).content_color);
            ImageLoader.a(getFragmentActive(), list.get(2).icon).a(a4.d);
            if (!TextUtils.isEmpty(list.get(2).activity_text)) {
                a4.k.setText(list.get(2).activity_text);
                a4.k.setVisibility(0);
            }
            if (BluedPreferences.P(list.get(2).item_key)) {
                a4.b.setVisibility(0);
            } else {
                a4.b.setVisibility(8);
            }
            a4.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$Hi9O7r98WQquDoIsuFY83-izgw0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineNewFragment.b(list, this, a4, view);
                }
            });
            FragmentMineNewBinding p4 = p();
            if (p4 != null && (gridLayout3 = p4.r) != null) {
                gridLayout3.addView(inflate);
            }
            FragmentMineNewBinding p5 = p();
            if (p5 == null || (gridLayout2 = p5.r) == null) {
                return;
            }
            gridLayout2.addView(inflate2);
            return;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            final int i2 = i;
            if (i2 >= size) {
                return;
            }
            View inflate3 = getLayoutInflater().inflate(R.layout.item_mine_vas_entry, (ViewGroup) null);
            final ItemMineVasEntryBinding a5 = ItemMineVasEntryBinding.a(inflate3);
            Intrinsics.c(a5, "bind(rootView)");
            GridLayout.LayoutParams layoutParams2 = new GridLayout.LayoutParams(new ViewGroup.MarginLayoutParams(a2, DensityUtils.a(getContext(), 99.0f)));
            if (i2 != 0 && i2 != 1) {
                layoutParams2.topMargin = DensityUtils.a(getContext(), 5.0f);
            }
            if (i2 % 2 == 1) {
                layoutParams2.leftMargin = DensityUtils.a(getContext(), 5.0f);
            }
            inflate3.setLayoutParams(layoutParams2);
            a5.g.setText(list.get(i2).title);
            TextView textView7 = a5.g;
            Intrinsics.c(textView7, "vasViewBinding.tvTitle");
            a(textView7, list.get(i2).title_color);
            a5.e.setText(list.get(i2).recommend_text);
            if (!TextUtils.isEmpty(list.get(i2).activity_text)) {
                a5.f.setText(list.get(i2).activity_text);
                a5.f.setVisibility(0);
            }
            TextView textView8 = a5.e;
            Intrinsics.c(textView8, "vasViewBinding.tvDes");
            a(textView8, list.get(i2).content_color);
            if (TextUtils.isEmpty(list.get(i2).icon)) {
                a5.b.setVisibility(8);
            } else {
                a5.b.setVisibility(0);
                ImageLoader.a(getFragmentActive(), list.get(i2).icon).a(a5.b);
            }
            if (TextUtils.isEmpty(list.get(i2).icon2)) {
                a5.f15551c.setVisibility(8);
            } else {
                a5.f15551c.setVisibility(0);
                ImageLoader.a(getFragmentActive(), list.get(i2).icon2).a(a5.f15551c);
                if (a5.b.getVisibility() == 8) {
                    ViewGroup.LayoutParams layoutParams3 = a5.f15551c.getLayoutParams();
                    if (layoutParams3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin = 0;
                    a5.f15551c.requestLayout();
                }
            }
            if (BluedPreferences.P(list.get(i2).item_key)) {
                a5.f15550a.setVisibility(0);
            } else {
                a5.f15550a.setVisibility(8);
            }
            inflate3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$tmwSazzKYkWgq4FBiH6xPE1q5pQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineNewFragment.a(list, i2, this, a5, view);
                }
            });
            FragmentMineNewBinding p6 = p();
            if (p6 != null && (gridLayout = p6.r) != null) {
                gridLayout.addView(inflate3);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
        boolean z = true;
        if (BluedConfig.a().g().is_chat_shadow != 1) {
            z = false;
        }
        EventTrackSettings.a(event, "https://app.blued.cn/?action=live_fans", "", z);
        WebViewShowInfoFragment.show(mineNewFragment.getContext(), "https://app.blued.cn/?action=live_fans");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        EventTrackSettings.a(SettingsProtos.Event.MINE_BTN_CLICK, H5Url.a(69, new Object[]{EncryptTool.b(LiveRoomInfo.a().f())}), "", BluedConfig.a().g().is_chat_shadow == 1);
        mineNewFragment.b(H5Url.a(69, new Object[]{EncryptTool.b(LiveRoomInfo.a().f())}));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
        String a2 = H5Url.a(67);
        boolean z = true;
        if (BluedConfig.a().g().is_chat_shadow != 1) {
            z = false;
        }
        EventTrackSettings.a(event, a2, (String) null, z);
        mineNewFragment.b(H5Url.a(67));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        SettingsProtos.Event event = SettingsProtos.Event.MINE_BTN_CLICK;
        boolean z = true;
        if (BluedConfig.a().g().is_chat_shadow != 1) {
            z = false;
        }
        EventTrackSettings.a(event, "http://native.blued.cn/?action=helpcenter", (String) null, z);
        HelpCenterFragment.a(mineNewFragment.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        EventTrackSettings.a(SettingsProtos.Event.MINE_BTN_CLICK, "http://native.blued.cn/?action=charge&from=1", "", BluedConfig.a().g().is_chat_shadow == 1);
        BeansPrePayFragment.a(mineNewFragment.getContext(), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentMineNewBinding p() {
        return (FragmentMineNewBinding) this.b.b(this, f17930a[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.u();
    }

    private final void q() {
        FrameLayout frameLayout;
        if (StatusBarHelper.a()) {
            FragmentMineNewBinding p = p();
            FrameLayout frameLayout2 = null;
            ViewGroup.LayoutParams layoutParams = (p == null || (frameLayout = p.an) == null) ? null : frameLayout.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = StatusBarHelper.a(getActivity());
            }
            FragmentMineNewBinding p2 = p();
            if (p2 != null) {
                frameLayout2 = p2.an;
            }
            if (frameLayout2 == null) {
                return;
            }
            frameLayout2.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.x();
    }

    private final void r() {
        if (!BluedPreferences.eB() || p() == null) {
            return;
        }
        BluedPreferences.eC();
        final View inflate = getLayoutInflater().inflate(R.layout.layout_mine_tip, (ViewGroup) null);
        LayoutMineTipBinding a2 = LayoutMineTipBinding.a(inflate);
        Intrinsics.c(a2, "bind(tipView)");
        final BluedPopupWindow a3 = BluedPopupWindow.Builder.a(getActivity(), inflate).a(AppInfo.l, AppInfo.m).a(0.3f).a(false).a();
        inflate.post(new Runnable() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$8_1JJ-8TtV3hA_A1Y7kdr4AgyZs
            @Override // java.lang.Runnable
            public final void run() {
                MineNewFragment.a(inflate);
            }
        });
        if (BluedConfig.a().G()) {
            a2.e.setVisibility(0);
            a2.f.setVisibility(0);
        }
        a2.i.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$tOoQAsP9REnswKq1Gvm3vuJpyPY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MineNewFragment.a(a3, view);
            }
        });
        try {
            FragmentMineNewBinding p = p();
            Intrinsics.a(p);
            a3.a(p.an, 1, 3, 0, 0);
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.x();
    }

    private final void s() {
        ObservableScrollView observableScrollView;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        LinearLayout linearLayout;
        FragmentMineNewBinding p = p();
        if (p != null && (linearLayout = p.ai) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$pY2HKDcSYJzOWBCGB83sJXe8OAk
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineNewFragment.b(view);
                }
            });
        }
        FragmentMineNewBinding p2 = p();
        ImageView imageView4 = p2 == null ? null : p2.aj;
        if (imageView4 != null) {
            imageView4.setVisibility(0);
        }
        ImageWrapper c2 = ImageLoader.a(getFragmentActive(), AvatarUtils.a(1, UserInfo.getInstance().getLoginUserInfo().getAvatar())).b(2131237310).d(2131237310).c();
        FragmentMineNewBinding p3 = p();
        c2.a(p3 == null ? null : p3.aj);
        FragmentMineNewBinding p4 = p();
        if (p4 != null && (imageView3 = p4.aj) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$OgSjKKDZAk3aqNROpRrAYZxOI3o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineNewFragment.a(MineNewFragment.this, view);
                }
            });
        }
        FragmentMineNewBinding p5 = p();
        if (p5 != null && (imageView2 = p5.am) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$tqcyq1e8SkFhA-zZUlPY-wnmFD0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineNewFragment.b(MineNewFragment.this, view);
                }
            });
        }
        FragmentMineNewBinding p6 = p();
        if (p6 != null && (imageView = p6.ak) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$tWLLpm3Qauf_9Eb-s4-PtJmoQEM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MineNewFragment.c(MineNewFragment.this, view);
                }
            });
        }
        FragmentMineNewBinding p7 = p();
        if (p7 == null || (observableScrollView = p7.ag) == null) {
            return;
        }
        observableScrollView.setScrollViewListener(new ObservableScrollView.ScrollViewListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$QBiIlLs8epfAdp_Qq2mssHHUkIw
            public final void onScrollChanged(ObservableScrollView observableScrollView2, int i, int i2, int i3, int i4) {
                MineNewFragment.a(MineNewFragment.this, observableScrollView2, i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.w();
    }

    private final void t() {
        ShapeLinearLayout shapeLinearLayout;
        QBadgeContainer findViewById;
        ShapeLinearLayout shapeLinearLayout2;
        FragmentMineNewBinding p = p();
        View view = null;
        if (p != null && (shapeLinearLayout2 = p.O) != null) {
            view = shapeLinearLayout2.findViewById((int) R.id.bindView);
        }
        FragmentMineNewBinding p2 = p();
        if (p2 == null || (shapeLinearLayout = p2.O) == null || (findViewById = shapeLinearLayout.findViewById((int) R.id.badge_container)) == null || view == null) {
            return;
        }
        ServiceHelper.f19954a.a(findViewById, view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.w();
    }

    private final void u() {
        ShapeTextView shapeTextView;
        Context context = getContext();
        if (context == null) {
            return;
        }
        FragmentMineNewBinding p = p();
        boolean z = false;
        if (p != null && (shapeTextView = p.n) != null && shapeTextView.getVisibility() == 0) {
            z = true;
        }
        if (z) {
            FragmentMineNewBinding p2 = p();
            ShapeTextView shapeTextView2 = p2 == null ? null : p2.n;
            if (shapeTextView2 != null) {
                shapeTextView2.setVisibility(4);
            }
        }
        MyGroupFragmentNew.f19077a.a(context, null);
        EventTrackSettings.a(SettingsProtos.Event.MINE_GROUP_CLICK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.v();
    }

    private final void v() {
        EventTrackSettings.a(SettingsProtos.Event.MINE_FEED_CLICK);
        Bundle bundle = new Bundle();
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.uid = UserInfo.getInstance().getLoginUserInfo().uid;
        bundle.putSerializable("user", (Serializable) userBasicModel);
        bundle.putInt("tab", 1);
        TerminalActivity.a(bundle);
        TerminalActivity.d(getContext(), UserInfoFragmentNew.class, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(MineNewFragment mineNewFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(mineNewFragment, "this$0");
        mineNewFragment.v();
    }

    private final void w() {
        BluedPreferences.G(false);
        FragmentMineNewBinding p = p();
        ShapeTextView shapeTextView = p == null ? null : p.q;
        if (shapeTextView != null) {
            shapeTextView.setVisibility(4);
        }
        ChatHelperV4.a().a(4L);
        VisitHistoryFragment.a(getContext());
    }

    private final void x() {
        EventTrackSettings.a(SettingsProtos.Event.MINE_INTERACT_CLICK);
        InteractFeedFragment.a.a(getContext());
    }

    private final void y() {
        BluedConstant.d = 0;
        Bundle bundle = new Bundle();
        bundle.putString("followed_or_fan", "followed");
        bundle.putString("uid", UserInfo.getInstance().getLoginUserInfo().getUid());
        TerminalActivity.d(getActivity(), FollowedAndFansFragment.class, bundle);
    }

    private final void z() {
        BluedConstant.d = 1;
        Bundle bundle = new Bundle();
        bundle.putString("followed_or_fan", "fans");
        bundle.putString("uid", UserInfo.getInstance().getLoginUserInfo().getUid());
        TerminalActivity.d(getActivity(), FollowedAndFansFragment.class, bundle);
    }

    public void a(SkinObservable skinObservable, Object obj) {
        MineViewModel mineViewModel = (MineViewModel) a();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        mineViewModel.a(fragmentActive);
    }

    public boolean c() {
        return true;
    }

    public void f() {
    }

    public void g() {
        super.g();
        postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$L3klPsrpLJrHzdVUm3st1RQmJi0
            @Override // java.lang.Runnable
            public final void run() {
                MineNewFragment.b(MineNewFragment.this);
            }
        });
        r();
        s();
        c((UserInfoEntity) null);
        a((UserInfoEntity) null, (MinePageModel.VipInfo) null);
        b((UserInfoEntity) null);
        d((List<? extends MinePageModel.ColumnsItem>) null);
        a((MinePageModel.HealthItem) null);
        b((List<? extends MinePageModel.ColumnsItem>) null);
        a((MinePageModel.MineBanner) null);
        a((String) null);
        a((List<? extends MinePageModel.EmotionItem>) null);
        a((UserInfoEntity) null);
        BluedPreferences.ag(false);
    }

    public void k() {
        super.k();
        ChatHelperV4.a().c(this);
        BluedSkinUtils.a(this);
        getViewLifecycleOwner().getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.soft.blued.ui.mine.fragment.MineNewFragment$onRegisterLiveListener$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Intrinsics.e(lifecycleOwner, "source");
                Intrinsics.e(event, "event");
                if (event == Lifecycle.Event.ON_DESTROY) {
                    ChatHelperV4.a().d(MineNewFragment.this);
                    BluedSkinUtils.b(MineNewFragment.this);
                }
            }
        });
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LiveEventBus.get("feed_avatar_widget", Integer.TYPE).observe(lifecycleOwner, new Observer() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$xswsPPCPwt0zVxNm4uJdOxXRyBc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MineNewFragment.a(MineNewFragment.this, (Integer) obj);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_ZHI_CHI_MSG).observe(lifecycleOwner, new Observer() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$b9hOZoXsICUEkYj4V9Kb7qQ4nGI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MineNewFragment.a(MineNewFragment.this, obj);
            }
        });
        LiveEventBus.get(EventBusConstant.KEY_EVENT_REFRESH_USER_VIP_INFO, Boolean.TYPE).observe(lifecycleOwner, new Observer() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$87X2kmA02y7_TrmGib2xyEcxHwQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MineNewFragment.a(MineNewFragment.this, (Boolean) obj);
            }
        });
    }

    public void l() {
        LifecycleOwner lifecycleOwner = (LifecycleOwner) this;
        LifecycleExtKt.a(lifecycleOwner, ((MineViewModel) a()).d(), new MineNewFragment$liveDataObserver$1(this));
        LifecycleExtKt.a(lifecycleOwner, ((MineViewModel) a()).e(), new MineNewFragment$liveDataObserver$2(this));
        LifecycleExtKt.a(lifecycleOwner, ((MineViewModel) a()).f(), new MineNewFragment$liveDataObserver$3(this));
    }

    public void onDestroy() {
        ResourcePromotionView resourcePromotionView;
        super.onDestroy();
        FragmentMineNewBinding p = p();
        if (p == null || (resourcePromotionView = p.af) == null) {
            return;
        }
        resourcePromotionView.b();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ((MineViewModel) j()).d().removeObservers((LifecycleOwner) this);
    }

    public void onResume() {
        super.onResume();
        q();
        if (!b()) {
            s();
            c((UserInfoEntity) null);
        }
        MineViewModel mineViewModel = (MineViewModel) j();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        mineViewModel.a(fragmentActive);
        if (!BluedPreferences.be()) {
            FragmentMineNewBinding p = p();
            ShapeTextView shapeTextView = p == null ? null : p.q;
            if (shapeTextView != null) {
                shapeTextView.setVisibility(4);
            }
        }
        if (BluedPreferences.dI()) {
            FragmentMineNewBinding p2 = p();
            ShapeTextView shapeTextView2 = p2 == null ? null : p2.p;
            if (shapeTextView2 != null) {
                shapeTextView2.setVisibility(8);
            }
        }
        t();
    }

    public void onSessionDataChanged(final SessionModel sessionModel) {
        boolean z = false;
        if (sessionModel != null && sessionModel.sessionId == 4) {
            z = true;
        }
        if (z) {
            postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$Kk39JHyNs5ITrXftLxyIm8MJZ3Y
                @Override // java.lang.Runnable
                public final void run() {
                    MineNewFragment.a(MineNewFragment.this, sessionModel);
                }
            });
        }
    }

    public void onSessionRemoved(short s, long j) {
        if (s == 1 && j == 4) {
            AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$MineNewFragment$GMAC1_w-iCfnc-i_eOQz7cICst0
                @Override // java.lang.Runnable
                public final void run() {
                    MineNewFragment.c(MineNewFragment.this);
                }
            });
        }
    }
}
