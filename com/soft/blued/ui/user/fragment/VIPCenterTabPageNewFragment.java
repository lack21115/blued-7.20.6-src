package com.soft.blued.ui.user.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.common.utils.ImgURLMap;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.view.AutoScrollViewPager;
import com.blued.android.module.common.view.LinePageIndicator;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentVipCenterTabPageNewBinding;
import com.soft.blued.databinding.ItemVipCenterBannerBinding;
import com.soft.blued.databinding.LayoutVipCenterHeaderBinding;
import com.soft.blued.databinding.LayoutVipCenterNewUserHeaderBinding;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.setting.fragment.ChangeBluedIconFragment;
import com.soft.blued.ui.user.adapter.NoVIPPrivilegeAdapter;
import com.soft.blued.ui.user.adapter.VIPCenterBannerAdapter;
import com.soft.blued.ui.user.adapter.VIPGradePrivilegeAdapter;
import com.soft.blued.ui.user.adapter.VIPNewUserOptionAdapter;
import com.soft.blued.ui.user.adapter.VIPPrivilegeTabAdapter;
import com.soft.blued.ui.user.adapter.VIPRightOptionNewAdapter;
import com.soft.blued.ui.user.model.VIPCenterForJsonParse;
import com.soft.blued.ui.user.model.VIPCenterNewModel;
import com.soft.blued.ui.user.model.VIPRightOption;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.user.state.VIPCenterAction;
import com.soft.blued.ui.user.state.VIPCenterState;
import com.soft.blued.ui.user.viewmodel.VIPCenterTabPageViewModel;
import com.soft.blued.ui.user.views.VipGradeProgress;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VIPCenterTabPageNewFragment.class */
public final class VIPCenterTabPageNewFragment extends MVIBaseFragment<VIPCenterTabPageViewModel> implements VIPBuyResultObserver.IVIPBuyResultObserver {
    private final ViewBindingProperty d;
    private LayoutVipCenterHeaderBinding e;
    private LayoutVipCenterNewUserHeaderBinding f;
    private String g;
    private VIPRightOptionNewAdapter h;
    private int i;
    private int j;
    private String k;
    private boolean l;
    private boolean m;
    private VIPCenterNewModel.OptionList n;
    private Rect o;
    private boolean p;
    private boolean q;

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f34138c = {Reflection.a(new PropertyReference1Impl(VIPCenterTabPageNewFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/FragmentVipCenterTabPageNewBinding;", 0))};
    public static final Companion b = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VIPCenterTabPageNewFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BaseFragment a(int i, String vipDetail) {
            Intrinsics.e(vipDetail, "vipDetail");
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_VIP_GRADE", i);
            bundle.putString("KEY_VIP_DETAIL", vipDetail);
            VIPCenterTabPageNewFragment vIPCenterTabPageNewFragment = new VIPCenterTabPageNewFragment();
            vIPCenterTabPageNewFragment.setArguments(bundle);
            return vIPCenterTabPageNewFragment;
        }

        public final void a(Context context, int i, String vipDetail) {
            Intrinsics.e(context, "context");
            Intrinsics.e(vipDetail, "vipDetail");
            BluedConfig.a().b = true;
            Bundle bundle = new Bundle();
            bundle.putInt("KEY_VIP_GRADE", i);
            bundle.putString("KEY_VIP_DETAIL", vipDetail);
            bundle.putBoolean("KEY_INDEPENDENT_PAGE", true);
            TerminalActivity.a(bundle);
            TerminalActivity.d(context, VIPCenterTabPageNewFragment.class, bundle);
        }
    }

    public VIPCenterTabPageNewFragment() {
        super(R.layout.fragment_vip_center_tab_page_new);
        this.d = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<VIPCenterTabPageNewFragment, FragmentVipCenterTabPageNewBinding>() { // from class: com.soft.blued.ui.user.fragment.VIPCenterTabPageNewFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentVipCenterTabPageNewBinding invoke(VIPCenterTabPageNewFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentVipCenterTabPageNewBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<VIPCenterTabPageNewFragment, FragmentVipCenterTabPageNewBinding>() { // from class: com.soft.blued.ui.user.fragment.VIPCenterTabPageNewFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentVipCenterTabPageNewBinding invoke(VIPCenterTabPageNewFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentVipCenterTabPageNewBinding.a(fragment.requireView());
            }
        });
        this.g = "";
        this.j = 2;
        this.k = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Context context, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(context, "$context");
        VIPLvlPrivilegeFragment.b.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Context context, VIPCenterTabPageNewFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(context, "$context");
        Intrinsics.e(this$0, "this$0");
        WebViewShowInfoFragment.show(context, BluedHttpUrl.a(-1, "", this$0.j, UserInfo.getInstance().getLoginUserInfo().vip_grade), -1);
    }

    private final void a(ImageView imageView, int i, int i2) {
        if (imageView == null || i <= 0 || this.j == 0) {
            return;
        }
        String a2 = i2 > 0 ? Intrinsics.a("_center_", (Object) "expire_") : "_center_";
        int i3 = this.j;
        if (i3 == 1) {
            imageView.setVisibility(0);
            a2 = "vip" + a2 + i;
        } else if (i3 == 2) {
            imageView.setVisibility(0);
            a2 = "bluedx" + a2 + i;
        }
        imageView.setImageResource(AppInfo.d().getResources().getIdentifier(a2, i.f7952c, AppInfo.d().getPackageName()));
        imageView.setAdjustViewBounds(true);
    }

    private final void a(LinearLayout linearLayout, final ItemVipCenterBannerBinding itemVipCenterBannerBinding, List<VIPCenterNewModel.BannerItem> list) {
        List<VIPCenterNewModel.BannerItem> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        for (VIPCenterNewModel.BannerItem bannerItem : list) {
            VIPCenterForJsonParse._banner _bannerVar = new VIPCenterForJsonParse._banner();
            _bannerVar.img = bannerItem.img;
            _bannerVar.link = bannerItem.link;
            arrayList.add(_bannerVar);
        }
        VIPCenterBannerAdapter vIPCenterBannerAdapter = new VIPCenterBannerAdapter(getContext(), getFragmentActive(), this.j, arrayList);
        AutoScrollViewPager autoScrollViewPager = itemVipCenterBannerBinding.f29351a;
        Intrinsics.c(autoScrollViewPager, "bannerView.bannerViewPager");
        LinePageIndicator linePageIndicator = itemVipCenterBannerBinding.b;
        Intrinsics.c(linePageIndicator, "bannerView.indicator");
        if (list.size() == 1) {
            linePageIndicator.setVisibility(4);
        } else {
            linePageIndicator.setVisibility(0);
        }
        autoScrollViewPager.setAdapter(vIPCenterBannerAdapter);
        autoScrollViewPager.setInterval(m.ag);
        autoScrollViewPager.a();
        linePageIndicator.setViewPager(autoScrollViewPager);
        if (i()) {
            a(itemVipCenterBannerBinding, 0);
        } else if (getUserVisibleHint()) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.soft.blued.ui.user.fragment.VIPCenterNewFragment");
            }
            if (((VIPCenterNewFragment) parentFragment).c() == this.j) {
                a(itemVipCenterBannerBinding, 0);
            }
        }
        autoScrollViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.user.fragment.VIPCenterTabPageNewFragment$setBanner$2
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (VIPCenterTabPageNewFragment.this.getUserVisibleHint()) {
                    VIPCenterTabPageNewFragment.this.a(itemVipCenterBannerBinding, i);
                }
            }
        });
    }

    private final void a(TextView textView) {
        final Context context = getContext();
        if (context == null) {
            return;
        }
        String string = context.getString(R.string.hello_agree_new);
        Intrinsics.c(string, "mContext.getString(R.string.hello_agree_new)");
        String string2 = context.getString(R.string.hello_service_agreement_new);
        Intrinsics.c(string2, "mContext.getString(R.str…lo_service_agreement_new)");
        String string3 = context.getString(R.string.hello_stop_interval);
        Intrinsics.c(string3, "mContext.getString(R.string.hello_stop_interval)");
        String string4 = context.getString(R.string.hello_subscribe);
        Intrinsics.c(string4, "mContext.getString(R.string.hello_subscribe)");
        String string5 = context.getString(2131890425);
        Intrinsics.c(string5, "mContext.getString(R.str…login_clause_info_policy)");
        String str = string + string2 + string3 + string4 + string3 + string5;
        String str2 = str;
        SpannableString spannableString = new SpannableString(str2);
        if (this.j == 2) {
            textView.setTextColor(ContextCompat.getColor(context, 2131102170));
        } else {
            textView.setTextColor(ContextCompat.getColor(context, R.color.syc_825133));
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.user.fragment.VIPCenterTabPageNewFragment$setAgreement$1$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.e(widget, "widget");
                WebViewShowInfoFragment.show(VIPCenterTabPageNewFragment.this.getActivity(), H5Url.a(35), 7);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                int i;
                Intrinsics.e(ds, "ds");
                i = VIPCenterTabPageNewFragment.this.j;
                if (i == 2) {
                    ds.setColor(ContextCompat.getColor(context, 2131102170));
                } else {
                    ds.setColor(ContextCompat.getColor(context, R.color.syc_825133));
                }
                ds.setFakeBoldText(true);
            }
        }, StringsKt.a((CharSequence) str2, string2, 0, false, 6, (Object) null), Intrinsics.a(string, (Object) string2).length(), 33);
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.user.fragment.VIPCenterTabPageNewFragment$setAgreement$1$2
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.e(widget, "widget");
                WebViewShowInfoFragment.show(VIPCenterTabPageNewFragment.this.getActivity(), H5Url.a(34), 7);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                int i;
                Intrinsics.e(ds, "ds");
                i = VIPCenterTabPageNewFragment.this.j;
                if (i == 2) {
                    ds.setColor(ContextCompat.getColor(context, 2131102170));
                } else {
                    ds.setColor(ContextCompat.getColor(context, R.color.syc_825133));
                }
                ds.setFakeBoldText(true);
            }
        }, StringsKt.a((CharSequence) str2, string4, 0, false, 6, (Object) null), (string + string2 + string3 + string4).length(), 33);
        spannableString.setSpan(new ClickableSpan() { // from class: com.soft.blued.ui.user.fragment.VIPCenterTabPageNewFragment$setAgreement$1$3
            @Override // android.text.style.ClickableSpan
            public void onClick(View widget) {
                Intrinsics.e(widget, "widget");
                WebViewShowInfoFragment.show(Context.this, H5Url.a(22), 0);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                int i;
                Intrinsics.e(ds, "ds");
                i = this.j;
                if (i == 2) {
                    ds.setColor(ContextCompat.getColor(Context.this, 2131102170));
                } else {
                    ds.setColor(ContextCompat.getColor(Context.this, R.color.syc_825133));
                }
                ds.setFakeBoldText(true);
            }
        }, StringsKt.a((CharSequence) str2, string5, 0, false, 6, (Object) null), str.length(), 33);
        textView.setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(ItemVipCenterBannerBinding itemVipCenterBannerBinding, int i) {
        if (itemVipCenterBannerBinding == null) {
            return;
        }
        AutoScrollViewPager autoScrollViewPager = itemVipCenterBannerBinding.f29351a;
        Intrinsics.c(autoScrollViewPager, "bannerView.bannerViewPager");
        if (autoScrollViewPager.getAdapter() == null) {
            return;
        }
        VIPCenterBannerAdapter vIPCenterBannerAdapter = (VIPCenterBannerAdapter) autoScrollViewPager.getAdapter();
        Intrinsics.a(vIPCenterBannerAdapter);
        VIPCenterForJsonParse._banner a2 = vIPCenterBannerAdapter.a(i);
        if (a2 == null || a2.ifShowed) {
            return;
        }
        a2.ifShowed = true;
        EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_BANNER_SHOW, UserInfo.getInstance().getLoginUserInfo().vip_grade, this.j, a2.link);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(NoVIPPrivilegeAdapter privilegeAdapter, VIPCenterTabPageNewFragment this$0, Context context, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(privilegeAdapter, "$privilegeAdapter");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        int i2 = privilegeAdapter.getData().get(i).pid;
        EventTrackVIP.a(UserInfo.getInstance().getLoginUserInfo().vip_grade, this$0.j, false, i2);
        if (i2 == 4) {
            VipInvisibleDialogFragment vipInvisibleDialogFragment = new VipInvisibleDialogFragment();
            if (vipInvisibleDialogFragment.isAdded()) {
                vipInvisibleDialogFragment.dismiss();
            } else {
                vipInvisibleDialogFragment.b = privilegeAdapter.getData().get(i).title;
                FragmentManager fragmentManager = this$0.getFragmentManager();
                if (fragmentManager != null) {
                    vipInvisibleDialogFragment.show(fragmentManager, VIPRightOptionNewAdapter.class.getName());
                }
            }
            BluedPreferences.dU();
        } else if (i2 == 14) {
            ChangeBluedIconFragment.a(context, this$0.j);
        } else if (i2 == 32) {
            EventTrackVIP.a(VipProtos.Event.VIP_CENTER_PHOTO_PENDANT_CLICK, this$0.j);
            BluedPreferences.dQ();
            WidgetListFragment.a(context, this$0.j, "photo_pendant_vip_center", VipProtos.FromType.PHOTO_PENDANT_VIP_CENTER);
        } else if (i2 == 34) {
            BluedPreferences.dS();
            WebViewShowInfoFragment.show(context, BluedHttpUrl.a(i2, "groups_expand_vip", this$0.j, UserInfo.getInstance().getLoginUserInfo().vip_grade), -1);
        } else if (i2 == 36) {
            WebViewShowInfoFragment.show(context, BluedHttpUrl.a(i2, "", this$0.j, UserInfo.getInstance().getLoginUserInfo().vip_grade), -1);
            BluedPreferences.dW();
        } else {
            switch (i2) {
                case 28:
                    BluedURIRouterAdapter.goChatAndOpenMsgBox(this$0.getFragmentManager(), this$0.j);
                    return;
                case 29:
                    BluedPreferences.dO();
                    DynamicSkinFragment.a(context, this$0.j, "vip_center_dynamic_skin");
                    return;
                case 30:
                    BluedPreferences.dM();
                    VipBubbleFragment.a(context, this$0.j, "vip_center_msg_bubble");
                    return;
                default:
                    WebViewShowInfoFragment.show(context, BluedHttpUrl.a(i2, "", this$0.j, UserInfo.getInstance().getLoginUserInfo().vip_grade), -1);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPNewUserOptionAdapter optionAdapter, VIPCenterTabPageNewFragment this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(optionAdapter, "$optionAdapter");
        Intrinsics.e(this$0, "this$0");
        List<VIPCenterNewModel.OptionList> data = optionAdapter.getData();
        Intrinsics.c(data, "optionAdapter.data");
        for (VIPCenterNewModel.OptionList optionList : data) {
            optionList.choosen = false;
        }
        optionAdapter.getData().get(i).choosen = true;
        this$0.n = optionAdapter.getData().get(i);
        optionAdapter.notifyDataSetChanged();
        List<VIPCenterNewModel.OptionList> data2 = optionAdapter.getData();
        Intrinsics.c(data2, "optionAdapter.data");
        this$0.a(data2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPCenterTabPageNewFragment this$0, Context context, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        int i = this$0.j;
        String str = i != 1 ? i != 2 ? "" : "vip_center_now_svip" : "vip_center_now_vip";
        int i2 = this$0.j;
        if (!Intrinsics.a((Object) "", (Object) this$0.k)) {
            str = this$0.k;
        }
        PayUtils.a(context, i2, str, -1, VipProtos.FromType.UNKNOWN_FROM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPCenterTabPageNewFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPCenterTabPageNewFragment this$0, NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        Intrinsics.e(this$0, "this$0");
        Fragment parentFragment = this$0.getParentFragment();
        if (parentFragment == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.soft.blued.ui.user.fragment.VIPCenterNewFragment");
        }
        VIPCenterNewFragment vIPCenterNewFragment = (VIPCenterNewFragment) parentFragment;
        int i5 = this$0.i;
        if (i2 >= i5) {
            vIPCenterNewFragment.a(1.0f, this$0.j);
            StatusBarHelper.a((Activity) this$0.getActivity(), true);
            return;
        }
        float f = i2 / i5;
        vIPCenterNewFragment.a(f, this$0.j);
        if (this$0.j != 2) {
            StatusBarHelper.a((Activity) this$0.getActivity(), true);
        } else if (f > 0.5f) {
            StatusBarHelper.a((Activity) this$0.getActivity(), true);
        } else {
            StatusBarHelper.a((Activity) this$0.getActivity(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPCenterTabPageNewFragment this$0, FragmentVipCenterTabPageNewBinding this_apply, NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(this_apply, "$this_apply");
        int i5 = this$0.i;
        if (i2 >= i5) {
            this_apply.h.setAlpha(1.0f);
            StatusBarHelper.a((Activity) this$0.getActivity(), true);
            return;
        }
        float f = i2 / i5;
        this_apply.h.setAlpha(f);
        if (this$0.j == 2) {
            if (f > 0.5f) {
                StatusBarHelper.a((Activity) this$0.getActivity(), true);
            } else {
                StatusBarHelper.a((Activity) this$0.getActivity(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPCenterTabPageNewFragment this$0, LayoutVipCenterNewUserHeaderBinding this_apply, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(this_apply, "$this_apply");
        boolean z = !this$0.q;
        this$0.q = z;
        if (z) {
            if (this$0.j == 2) {
                this_apply.e.setImageResource(R.drawable.icon_svip_agreement_select);
            } else {
                this_apply.e.setImageResource(R.drawable.icon_vip_agreement_select);
            }
        } else if (this$0.j == 2) {
            this_apply.e.setImageResource(R.drawable.icon_svip_agreement_unselect);
        } else {
            this_apply.e.setImageResource(R.drawable.icon_vip_agreement_unselect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPCenterTabPageNewFragment this$0, VIPNewUserOptionAdapter optionAdapter, Context context, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(optionAdapter, "$optionAdapter");
        Intrinsics.e(context, "$context");
        if (!this$0.q) {
            AppMethods.d((int) R.string.hello_bug_tips);
            return;
        }
        int i = this$0.j;
        String str = i != 1 ? i != 2 ? "" : "vip_center_buy_svip" : "vip_center_buy_vip";
        EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_RESUME_BUY_BTN_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade, this$0.j, VipProtos.BtnType.NOW_BUY);
        VIPCenterNewModel.OptionList a2 = optionAdapter.a();
        if (a2 != null) {
            VIPCenterNewModel.OptionList optionList = a2;
            if (!Intrinsics.a((Object) "", (Object) this$0.k)) {
                str = this$0.k;
            }
            PayPreOrderFragment.a(context, optionList, "list", str, 0);
        }
        EventTrackVIP.a(VipProtos.Event.VIP_BUY_OPEN_BTN_CLICK, this$0.j == 2 ? VipProtos.Name.SVIP : VipProtos.Name.VIP, (VipProtos.FromType) null, VipProtos.PageVersion.V_0730);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPCenterTabPageNewFragment this$0, Boolean bool) {
        Intrinsics.e(this$0, "this$0");
        VIPRightOptionNewAdapter vIPRightOptionNewAdapter = this$0.h;
        if (vIPRightOptionNewAdapter == null) {
            return;
        }
        for (VIPRightOption vIPRightOption : vIPRightOptionNewAdapter.getData()) {
            if (vIPRightOption.pid == 3 && vIPRightOption.is_on == 1) {
                Intrinsics.a(bool);
                if (!bool.booleanValue()) {
                    vIPRightOption.is_on = 0;
                }
            }
        }
        vIPRightOptionNewAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPCenterTabPageNewFragment this$0, String str, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        WebViewShowInfoFragment.show(this$0.getContext(), str, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(VIPCenterNewModel vIPCenterNewModel) {
        ImageView imageView;
        TextView textView;
        ImageView imageView2;
        TextView textView2;
        if (vIPCenterNewModel == null) {
            return;
        }
        if (vIPCenterNewModel.user_info.grade == 0 && vIPCenterNewModel.user_info.expire_type == 0) {
            if (!this.p) {
                e();
            }
        } else if (this.j == vIPCenterNewModel.user_info.expire_type || this.j == vIPCenterNewModel.user_info.grade) {
            if (this.p) {
                d();
            }
        } else if (!this.p) {
            e();
        }
        b(vIPCenterNewModel);
        c(vIPCenterNewModel);
        if (vIPCenterNewModel.user_info.is_show_level == 1) {
            FragmentVipCenterTabPageNewBinding b2 = b();
            LinearLayout linearLayout = b2 == null ? null : b2.s;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else {
            FragmentVipCenterTabPageNewBinding b3 = b();
            LinearLayout linearLayout2 = b3 == null ? null : b3.s;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (this.j == 1) {
            FragmentVipCenterTabPageNewBinding b4 = b();
            TextView textView3 = b4 == null ? null : b4.n;
            if (textView3 != null) {
                textView3.setText(vIPCenterNewModel.explain_list.vip);
            }
            FragmentVipCenterTabPageNewBinding b5 = b();
            if (b5 != null && (textView2 = b5.l) != null) {
                textView2.setTextColor(context.getResources().getColor(R.color.syc_7B401D));
            }
            FragmentVipCenterTabPageNewBinding b6 = b();
            if (b6 == null || (imageView2 = b6.e) == null) {
                return;
            }
            imageView2.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_vip_new_page_buy_btn_bg));
            return;
        }
        FragmentVipCenterTabPageNewBinding b7 = b();
        TextView textView4 = b7 == null ? null : b7.n;
        if (textView4 != null) {
            textView4.setText(vIPCenterNewModel.explain_list.svip);
        }
        FragmentVipCenterTabPageNewBinding b8 = b();
        if (b8 != null && (textView = b8.l) != null) {
            textView.setTextColor(context.getResources().getColor(2131102170));
        }
        FragmentVipCenterTabPageNewBinding b9 = b();
        if (b9 == null || (imageView = b9.e) == null) {
            return;
        }
        imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_svip_new_page_buy_btn_bg));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPCenterNewModel model, NoVIPPrivilegeAdapter privilegeAdapter, VIPPrivilegeTabAdapter privilegeTabAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(model, "$model");
        Intrinsics.e(privilegeAdapter, "$privilegeAdapter");
        Intrinsics.e(privilegeTabAdapter, "$privilegeTabAdapter");
        List<VIPCenterNewModel.PrivilegeModel> list = model.privilege;
        Intrinsics.c(list, "model.privilege");
        for (VIPCenterNewModel.PrivilegeModel privilegeModel : list) {
            privilegeModel.checked = false;
        }
        model.privilege.get(i).checked = true;
        privilegeAdapter.setNewData(model.privilege.get(i).privilege_list);
        privilegeAdapter.notifyDataSetChanged();
        privilegeTabAdapter.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPCenterNewModel model, VIPCenterTabPageNewFragment this$0, Context context, View view) {
        String str;
        Tracker.onClick(view);
        Intrinsics.e(model, "$model");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(context, "$context");
        int i = model.user_info.grade;
        if (i == 0) {
            if (model.user_info.expire_type > 0) {
                int i2 = this$0.j;
                str = i2 != 1 ? i2 != 2 ? "" : "vip_center_resume_buy_svip" : "vip_center_resume_buy_vip";
                EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_RESUME_BUY_BTN_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade, this$0.j, VipProtos.BtnType.RENEW);
            }
            str = "";
        } else if (i != 1) {
            if (i == 2) {
                EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_RESUME_BUY_BTN_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade, this$0.j, VipProtos.BtnType.NOW_RESUME);
                str = "vip_center_renew_svip";
            }
            str = "";
        } else {
            EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_RESUME_BUY_BTN_CLICK, UserInfo.getInstance().getLoginUserInfo().vip_grade, this$0.j, VipProtos.BtnType.NOW_RESUME);
            str = "vip_center_renew_vip";
        }
        int i3 = this$0.j;
        if (!Intrinsics.a((Object) "", (Object) this$0.k)) {
            str = this$0.k;
        }
        PayUtils.a(context, i3, str, -1, VipProtos.FromType.UNKNOWN_FROM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VIPCenterNewModel model, VIPCenterTabPageNewFragment this$0, VIPPrivilegeTabAdapter privilegeTabAdapter, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(model, "$model");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(privilegeTabAdapter, "$privilegeTabAdapter");
        List<VIPCenterNewModel.PrivilegeModel> list = model.privilege;
        Intrinsics.c(list, "model.privilege");
        for (VIPCenterNewModel.PrivilegeModel privilegeModel : list) {
            privilegeModel.checked = false;
        }
        model.privilege.get(i).checked = true;
        VIPRightOptionNewAdapter vIPRightOptionNewAdapter = this$0.h;
        if (vIPRightOptionNewAdapter != null) {
            List<VIPRightOption> list2 = model.privilege.get(i).privilege_list;
            Intrinsics.c(list2, "model.privilege[position].privilege_list");
            vIPRightOptionNewAdapter.a(list2);
        }
        VIPRightOptionNewAdapter vIPRightOptionNewAdapter2 = this$0.h;
        if (vIPRightOptionNewAdapter2 != null) {
            vIPRightOptionNewAdapter2.notifyDataSetChanged();
        }
        privilegeTabAdapter.notifyDataSetChanged();
    }

    private final void a(List<VIPCenterNewModel.OptionList> list) {
        for (VIPCenterNewModel.OptionList optionList : list) {
            if (optionList.choosen) {
                LayoutVipCenterNewUserHeaderBinding layoutVipCenterNewUserHeaderBinding = this.f;
                TextView textView = layoutVipCenterNewUserHeaderBinding == null ? null : layoutVipCenterNewUserHeaderBinding.k;
                if (textView != null) {
                    textView.setText(optionList.item.remark);
                }
                FragmentVipCenterTabPageNewBinding b2 = b();
                TextView textView2 = b2 == null ? null : b2.l;
                if (textView2 != null) {
                    textView2.setText(optionList.item.button);
                }
            }
        }
    }

    private final FragmentVipCenterTabPageNewBinding b() {
        return (FragmentVipCenterTabPageNewBinding) this.d.b(this, f34138c[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VIPCenterTabPageNewFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VIPCenterTabPageNewFragment this$0, String str, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        WebViewShowInfoFragment.show(this$0.getContext(), str, -1);
    }

    private final void b(VIPCenterNewModel vIPCenterNewModel) {
        if (vIPCenterNewModel.user_info.grade == 0 && vIPCenterNewModel.user_info.expire_type == 0) {
            d(vIPCenterNewModel);
        } else if (this.j == vIPCenterNewModel.user_info.expire_type || this.j == vIPCenterNewModel.user_info.grade) {
            e(vIPCenterNewModel);
        } else {
            d(vIPCenterNewModel);
        }
    }

    private final void c() {
        FragmentVipCenterTabPageNewBinding b2;
        if (getContext() == null || (b2 = b()) == null) {
            return;
        }
        if (this.j == 2) {
            ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("icon_svip_center_bg")).a(b2.d);
        } else {
            ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("icon_vip_center_bg")).a(b2.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(VIPCenterTabPageNewFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Context context = this$0.getContext();
        if (context == null) {
            return;
        }
        VIPLvlPrivilegeFragment.b.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(VIPCenterTabPageNewFragment this$0, String str, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        WebViewShowInfoFragment.show(this$0.getContext(), str, -1);
    }

    private final void c(final VIPCenterNewModel vIPCenterNewModel) {
        FragmentVipCenterTabPageNewBinding b2;
        final Context context = getContext();
        if (context == null || (b2 = b()) == null) {
            return;
        }
        final VIPPrivilegeTabAdapter vIPPrivilegeTabAdapter = new VIPPrivilegeTabAdapter(this.j);
        b2.k.setLayoutManager(new LinearLayoutManager(context, 0, false));
        b2.k.setAdapter(vIPPrivilegeTabAdapter);
        vIPCenterNewModel.privilege.get(0).checked = true;
        vIPPrivilegeTabAdapter.setNewData(vIPCenterNewModel.privilege);
        vIPPrivilegeTabAdapter.notifyDataSetChanged();
        b2.f29019a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$r1HGHIvsePyMvbsKc8X1drS7WLU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCenterTabPageNewFragment.a(Context.this, this, view);
            }
        });
        if (this.j == 1) {
            List<VIPCenterNewModel.PrivilegeModel> list = vIPCenterNewModel.privilege;
            Intrinsics.c(list, "model.privilege");
            for (VIPCenterNewModel.PrivilegeModel privilegeModel : list) {
                ArrayList arrayList = new ArrayList();
                List<VIPRightOption> list2 = privilegeModel.privilege_list;
                Intrinsics.c(list2, "privilegeModel.privilege_list");
                for (VIPRightOption privilegeItem : list2) {
                    if (privilegeItem.is_svip != 1) {
                        Intrinsics.c(privilegeItem, "privilegeItem");
                        arrayList.add(privilegeItem);
                    }
                }
                privilegeModel.privilege_list = arrayList;
            }
        }
        if (vIPCenterNewModel.user_info.grade == 0 || vIPCenterNewModel.user_info.grade != this.j) {
            ActivityFragmentActive fragmentActive = getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            final NoVIPPrivilegeAdapter noVIPPrivilegeAdapter = new NoVIPPrivilegeAdapter(fragmentActive, this.j, b2.i.getWidth(), 1);
            b2.i.setLayoutManager(new GridLayoutManager(context, 4));
            b2.i.setAdapter(noVIPPrivilegeAdapter);
            noVIPPrivilegeAdapter.setNewData(vIPCenterNewModel.privilege.get(0).privilege_list);
            noVIPPrivilegeAdapter.notifyDataSetChanged();
            vIPPrivilegeTabAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$Uap33ZdUijsGtAawPPKBMRnsHPE
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    VIPCenterTabPageNewFragment.a(VIPCenterNewModel.this, noVIPPrivilegeAdapter, vIPPrivilegeTabAdapter, baseQuickAdapter, view, i);
                }
            });
            noVIPPrivilegeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$U6sO7d6nzm8X3NMP9F7QezWLuHI
                @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
                public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                    VIPCenterTabPageNewFragment.a(NoVIPPrivilegeAdapter.this, this, context, baseQuickAdapter, view, i);
                }
            });
            return;
        }
        ActivityFragmentActive fragmentActive2 = getFragmentActive();
        Intrinsics.c(fragmentActive2, "fragmentActive");
        this.h = new VIPRightOptionNewAdapter(context, fragmentActive2, this.j, getFragmentManager(), y());
        b2.i.setLayoutManager(new LinearLayoutManager(context));
        b2.i.setAdapter(this.h);
        VIPRightOptionNewAdapter vIPRightOptionNewAdapter = this.h;
        if (vIPRightOptionNewAdapter != null) {
            List<VIPRightOption> list3 = vIPCenterNewModel.privilege.get(0).privilege_list;
            Intrinsics.c(list3, "model.privilege[0].privilege_list");
            vIPRightOptionNewAdapter.a(list3);
        }
        VIPRightOptionNewAdapter vIPRightOptionNewAdapter2 = this.h;
        if (vIPRightOptionNewAdapter2 != null) {
            vIPRightOptionNewAdapter2.notifyDataSetChanged();
        }
        vIPPrivilegeTabAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$7OtFSHs4quRSpdufN_6S9pZPGuM
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                VIPCenterTabPageNewFragment.a(VIPCenterNewModel.this, this, vIPPrivilegeTabAdapter, baseQuickAdapter, view, i);
            }
        });
    }

    private final void d() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        this.p = false;
        LinearLayout linearLayout3 = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_vip_center_header, (ViewGroup) null, false);
        this.e = LayoutVipCenterHeaderBinding.a(inflate);
        FragmentVipCenterTabPageNewBinding b2 = b();
        if (b2 != null && (linearLayout2 = b2.f29020c) != null) {
            linearLayout2.removeAllViews();
        }
        FragmentVipCenterTabPageNewBinding b3 = b();
        if (b3 != null && (linearLayout = b3.f29020c) != null) {
            linearLayout.addView(inflate);
        }
        FragmentVipCenterTabPageNewBinding b4 = b();
        if (b4 != null) {
            linearLayout3 = b4.f;
        }
        if (linearLayout3 == null) {
            return;
        }
        linearLayout3.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(VIPCenterTabPageNewFragment this$0, String str, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        WebViewShowInfoFragment.show(this$0.getContext(), str, -1);
    }

    private final void d(VIPCenterNewModel vIPCenterNewModel) {
        final LayoutVipCenterNewUserHeaderBinding layoutVipCenterNewUserHeaderBinding;
        FrameLayout frameLayout;
        final Context context = getContext();
        if (context == null || vIPCenterNewModel == null || (layoutVipCenterNewUserHeaderBinding = this.f) == null) {
            return;
        }
        ImageLoader.a(getFragmentActive(), UserInfo.getInstance().getLoginUserInfo().getAvatar()).c().a(2.0f, context.getResources().getColor(2131102170)).b(2131237310).d(2131237310).a(layoutVipCenterNewUserHeaderBinding.g);
        layoutVipCenterNewUserHeaderBinding.m.setText(UserInfo.getInstance().getLoginUserInfo().name);
        layoutVipCenterNewUserHeaderBinding.n.setText(context.getString(R.string.vip_new_page_not_yet_open));
        List<VIPCenterNewModel.BannerItem> list = this.j == 2 ? vIPCenterNewModel.banner.svip : vIPCenterNewModel.banner.vip;
        LinearLayout bannerRootView = layoutVipCenterNewUserHeaderBinding.b;
        Intrinsics.c(bannerRootView, "bannerRootView");
        ItemVipCenterBannerBinding bannerView = layoutVipCenterNewUserHeaderBinding.f29437c;
        Intrinsics.c(bannerView, "bannerView");
        List<VIPCenterNewModel.BannerItem> banner = list;
        Intrinsics.c(banner, "banner");
        a(bannerRootView, bannerView, list);
        if (this.j == 2) {
            layoutVipCenterNewUserHeaderBinding.m.setTextColor(context.getResources().getColor(2131102170));
            layoutVipCenterNewUserHeaderBinding.n.setTextColor(context.getResources().getColor(2131102170));
            layoutVipCenterNewUserHeaderBinding.d.setBackgroundResource(R.drawable.svip_center_new_user_to_be_vip_btn);
            layoutVipCenterNewUserHeaderBinding.f.setImageDrawable(context.getDrawable(R.drawable.icon_svip_center_arrow_right));
            layoutVipCenterNewUserHeaderBinding.l.setTextColor(context.getResources().getColor(2131102170));
            ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("icon_svip_top_right_bg")).a(layoutVipCenterNewUserHeaderBinding.h);
        } else {
            layoutVipCenterNewUserHeaderBinding.m.setTextColor(context.getResources().getColor(R.color.syc_461C03));
            layoutVipCenterNewUserHeaderBinding.n.setTextColor(context.getResources().getColor(R.color.syc_461C03));
            layoutVipCenterNewUserHeaderBinding.d.setBackgroundResource(R.drawable.vip_center_new_user_to_be_vip_btn);
            layoutVipCenterNewUserHeaderBinding.l.setTextColor(context.getResources().getColor(R.color.syc_825033));
            layoutVipCenterNewUserHeaderBinding.f.setImageDrawable(context.getDrawable(R.drawable.icon_vip_center_arrow_right));
            ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("icon_vip_top_right_bg")).a(layoutVipCenterNewUserHeaderBinding.h);
        }
        final VIPNewUserOptionAdapter vIPNewUserOptionAdapter = new VIPNewUserOptionAdapter(this.j);
        layoutVipCenterNewUserHeaderBinding.i.setLayoutManager(new LinearLayoutManager(context, 0, false));
        layoutVipCenterNewUserHeaderBinding.i.setAdapter(vIPNewUserOptionAdapter);
        if (this.j == 2) {
            List<VIPCenterNewModel.OptionList> list2 = vIPCenterNewModel.svip_list;
            if (!(list2 == null || list2.isEmpty())) {
                vIPCenterNewModel.svip_list.get(0).choosen = true;
                this.n = vIPCenterNewModel.svip_list.get(0);
            }
            vIPNewUserOptionAdapter.setNewData(vIPCenterNewModel.svip_list);
            List<VIPCenterNewModel.OptionList> list3 = vIPCenterNewModel.svip_list;
            Intrinsics.c(list3, "model.svip_list");
            a(list3);
            layoutVipCenterNewUserHeaderBinding.k.setTextColor(context.getResources().getColor(2131102170));
        } else {
            List<VIPCenterNewModel.OptionList> list4 = vIPCenterNewModel.vip_list;
            if (!(list4 == null || list4.isEmpty())) {
                vIPCenterNewModel.vip_list.get(0).choosen = true;
                this.n = vIPCenterNewModel.vip_list.get(0);
            }
            vIPNewUserOptionAdapter.setNewData(vIPCenterNewModel.vip_list);
            List<VIPCenterNewModel.OptionList> list5 = vIPCenterNewModel.vip_list;
            Intrinsics.c(list5, "model.vip_list");
            a(list5);
            layoutVipCenterNewUserHeaderBinding.k.setTextColor(context.getResources().getColor(R.color.syc_825133));
        }
        vIPNewUserOptionAdapter.notifyDataSetChanged();
        vIPNewUserOptionAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$QRbrBABrzE-_jfvjv2ypSL7nFXY
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                VIPCenterTabPageNewFragment.a(VIPNewUserOptionAdapter.this, this, baseQuickAdapter, view, i);
            }
        });
        TextView tvAgreementText = layoutVipCenterNewUserHeaderBinding.j;
        Intrinsics.c(tvAgreementText, "tvAgreementText");
        a(tvAgreementText);
        if (this.j == 2) {
            layoutVipCenterNewUserHeaderBinding.e.setImageResource(R.drawable.icon_svip_agreement_unselect);
        } else {
            layoutVipCenterNewUserHeaderBinding.e.setImageResource(R.drawable.icon_vip_agreement_unselect);
        }
        layoutVipCenterNewUserHeaderBinding.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$jWQPgO7k-gp0DHbkEYGMUJ18_sc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCenterTabPageNewFragment.a(VIPCenterTabPageNewFragment.this, layoutVipCenterNewUserHeaderBinding, view);
            }
        });
        layoutVipCenterNewUserHeaderBinding.d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$fuxKv3x8l0fBTvCBaIgSoy44UVo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCenterTabPageNewFragment.a(VIPCenterTabPageNewFragment.this, context, view);
            }
        });
        FragmentVipCenterTabPageNewBinding b2 = b();
        if (b2 == null || (frameLayout = b2.b) == null) {
            return;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$dLTdrmv4UFWBgtcxQKxPyr2K3YY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCenterTabPageNewFragment.a(VIPCenterTabPageNewFragment.this, vIPNewUserOptionAdapter, context, view);
            }
        });
    }

    private final void e() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        this.p = true;
        LinearLayout linearLayout3 = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_vip_center_new_user_header, (ViewGroup) null, false);
        this.f = LayoutVipCenterNewUserHeaderBinding.a(inflate);
        FragmentVipCenterTabPageNewBinding b2 = b();
        if (b2 != null && (linearLayout2 = b2.f29020c) != null) {
            linearLayout2.removeAllViews();
        }
        FragmentVipCenterTabPageNewBinding b3 = b();
        if (b3 != null && (linearLayout = b3.f29020c) != null) {
            linearLayout.addView(inflate);
        }
        FragmentVipCenterTabPageNewBinding b4 = b();
        if (b4 != null) {
            linearLayout3 = b4.f;
        }
        if (linearLayout3 == null) {
            return;
        }
        linearLayout3.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(VIPCenterTabPageNewFragment this$0, String str, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        WebViewShowInfoFragment.show(this$0.getContext(), str, -1);
    }

    private final void e(final VIPCenterNewModel vIPCenterNewModel) {
        final Context context;
        long j;
        FrameLayout frameLayout;
        final LayoutVipCenterHeaderBinding layoutVipCenterHeaderBinding = this.e;
        if (layoutVipCenterHeaderBinding == null || (context = getContext()) == null) {
            return;
        }
        ImageLoader.a(getFragmentActive(), UserInfo.getInstance().getLoginUserInfo().getAvatar()).c().a(2.0f, context.getResources().getColor(2131102170)).b(2131237310).d(2131237310).a(layoutVipCenterHeaderBinding.e);
        layoutVipCenterHeaderBinding.k.setText(UserInfo.getInstance().getLoginUserInfo().name);
        ImageView ivVipGradle = layoutVipCenterHeaderBinding.f;
        Intrinsics.c(ivVipGradle, "ivVipGradle");
        a(ivVipGradle, vIPCenterNewModel.user_info.vip_exp_lvl, vIPCenterNewModel.user_info.expire_type);
        List<VIPCenterNewModel.BannerItem> list = this.j == 2 ? vIPCenterNewModel.banner.svip : vIPCenterNewModel.banner.vip;
        LinearLayout bannerRootView = layoutVipCenterHeaderBinding.f29434a;
        Intrinsics.c(bannerRootView, "bannerRootView");
        ItemVipCenterBannerBinding bannerView = layoutVipCenterHeaderBinding.b;
        Intrinsics.c(bannerView, "bannerView");
        List<VIPCenterNewModel.BannerItem> banner = list;
        Intrinsics.c(banner, "banner");
        a(bannerRootView, bannerView, list);
        if (vIPCenterNewModel.user_info.expire_type != 0) {
            if (!i() && vIPCenterNewModel.user_info.expire_type != 0) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.soft.blued.ui.user.fragment.VIPCenterNewFragment");
                }
                ((VIPCenterNewFragment) parentFragment).b(vIPCenterNewModel.user_info.expire_type == 1 ? 1 : 0);
            }
            if (this.j == 2) {
                layoutVipCenterHeaderBinding.l.setText(context.getString(R.string.vip_new_page_out_date) + 'X' + vIPCenterNewModel.user_info.vip_exp_lvl);
                layoutVipCenterHeaderBinding.k.setTextColor(context.getResources().getColor(R.color.syc_445771));
                layoutVipCenterHeaderBinding.l.setTextColor(context.getResources().getColor(R.color.syc_445771));
                layoutVipCenterHeaderBinding.g.d();
                ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("icon_svip_center_header_out_time_bg")).a(layoutVipCenterHeaderBinding.d);
            } else {
                layoutVipCenterHeaderBinding.l.setText(context.getString(R.string.vip_new_page_out_date) + 'V' + vIPCenterNewModel.user_info.vip_exp_lvl);
                layoutVipCenterHeaderBinding.k.setTextColor(context.getResources().getColor(R.color.syc_7D7D7D));
                layoutVipCenterHeaderBinding.l.setTextColor(context.getResources().getColor(R.color.syc_7D7D7D));
                layoutVipCenterHeaderBinding.g.c();
                layoutVipCenterHeaderBinding.d.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_vip_center_header_out_time_bg));
            }
            ArrayList arrayList = new ArrayList();
            int[] iArr = vIPCenterNewModel.grade_list;
            Intrinsics.c(iArr, "model.grade_list");
            int i = 0;
            for (int i2 : iArr) {
                i++;
                StringBuilder sb = new StringBuilder();
                sb.append("Lv.");
                sb.append(i);
                sb.append('(');
                StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
                String string = context.getString(R.string.vip_new_grade_reduce_num);
                Intrinsics.c(string, "context.getString(R.stri…vip_new_grade_reduce_num)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Intrinsics.a("", (Object) Integer.valueOf(Math.abs(vIPCenterNewModel.user_info.day_growth_value)))}, 1));
                Intrinsics.c(format, "format(format, *args)");
                sb.append(format);
                sb.append(')');
                arrayList.add(sb.toString());
            }
            layoutVipCenterHeaderBinding.g.setData(arrayList);
            layoutVipCenterHeaderBinding.g.setSelectIndex(vIPCenterNewModel.user_info.vip_exp_lvl - 1);
        } else {
            if (this.j == 2) {
                layoutVipCenterHeaderBinding.k.setTextColor(context.getResources().getColor(R.color.syc_2A7BDF));
                layoutVipCenterHeaderBinding.l.setTextColor(context.getResources().getColor(R.color.syc_2A7BDF));
                layoutVipCenterHeaderBinding.g.b();
                j = vIPCenterNewModel.user_info.svip_endtime;
                ImageLoader.a((IRequestHost) null, ImgURLMap.f10885a.a("icon_svip_center_header_bg")).a(layoutVipCenterHeaderBinding.d);
            } else {
                layoutVipCenterHeaderBinding.k.setTextColor(context.getResources().getColor(R.color.syc_A3623C));
                layoutVipCenterHeaderBinding.l.setTextColor(context.getResources().getColor(R.color.syc_B16D44));
                layoutVipCenterHeaderBinding.g.a();
                j = vIPCenterNewModel.user_info.vip_endtime;
                layoutVipCenterHeaderBinding.d.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_vip_center_header_bg));
            }
            ArrayList arrayList2 = new ArrayList();
            int[] iArr2 = vIPCenterNewModel.grade_list;
            Intrinsics.c(iArr2, "model.grade_list");
            int i3 = 0;
            for (int i4 : iArr2) {
                i3++;
                if (vIPCenterNewModel.user_info.vip_exp_lvl == i3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Lv.");
                    sb2.append(vIPCenterNewModel.user_info.vip_exp_lvl);
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.f42549a;
                    String string2 = context.getString(R.string.vip_new_grade_current_num);
                    Intrinsics.c(string2, "context.getString(R.stri…ip_new_grade_current_num)");
                    String format2 = String.format(string2, Arrays.copyOf(new Object[]{Intrinsics.a("", (Object) Long.valueOf(vIPCenterNewModel.user_info.vip_exp))}, 1));
                    Intrinsics.c(format2, "format(format, *args)");
                    sb2.append(format2);
                    arrayList2.add(sb2.toString());
                } else if (vIPCenterNewModel.user_info.vip_exp_lvl < i3) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Lv.");
                    sb3.append(i3);
                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.f42549a;
                    String string3 = context.getString(R.string.vip_new_grade_lack_num);
                    Intrinsics.c(string3, "context.getString(\n     …                        )");
                    String format3 = String.format(string3, Arrays.copyOf(new Object[]{Intrinsics.a("", (Object) Long.valueOf(i4 - vIPCenterNewModel.user_info.vip_exp))}, 1));
                    Intrinsics.c(format3, "format(format, *args)");
                    sb3.append(format3);
                    arrayList2.add(sb3.toString());
                } else {
                    arrayList2.add("Lv." + i3 + context.getString(R.string.vip_new_grade_complete));
                }
            }
            layoutVipCenterHeaderBinding.g.setData(arrayList2);
            layoutVipCenterHeaderBinding.g.setSelectIndex(vIPCenterNewModel.user_info.vip_exp_lvl - 1);
            long j2 = 1000 * j;
            if (j2 > System.currentTimeMillis()) {
                int a2 = TimeAndDateUtils.a(System.currentTimeMillis(), j2);
                if (a2 > 15) {
                    layoutVipCenterHeaderBinding.l.setText(Intrinsics.a(context.getString(R.string.vip_new_end_time), (Object) TimeAndDateUtils.m.get().format(new Date(j2))));
                } else {
                    layoutVipCenterHeaderBinding.l.setText(a2 + context.getString(R.string.vip_new_some_days_later));
                }
            }
        }
        ViewGroup.LayoutParams layoutParams = layoutVipCenterHeaderBinding.h.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        int i5 = AppInfo.l;
        int i6 = layoutParams2.leftMargin;
        int marginEnd = layoutParams2.getMarginEnd();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        final VIPGradePrivilegeAdapter vIPGradePrivilegeAdapter = new VIPGradePrivilegeAdapter(fragmentActive, (i5 - i6) - marginEnd, vIPCenterNewModel.user_info.expire_type > 0 ? 0 : vIPCenterNewModel.user_info.vip_exp_lvl, this.j);
        vIPGradePrivilegeAdapter.a(vIPCenterNewModel.user_info.vip_exp_lvl);
        layoutVipCenterHeaderBinding.i.setLayoutManager(new LinearLayoutManager(context, 0, false));
        layoutVipCenterHeaderBinding.i.setAdapter(vIPGradePrivilegeAdapter);
        if (vIPCenterNewModel.user_info.vip_exp_lvl - 1 < vIPCenterNewModel.level_privilege.size()) {
            vIPGradePrivilegeAdapter.setNewData(vIPCenterNewModel.level_privilege.get(vIPCenterNewModel.user_info.vip_exp_lvl - 1));
        }
        vIPGradePrivilegeAdapter.notifyDataSetChanged();
        vIPGradePrivilegeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$3GhWl5YIBpVv_OikHWm0fRXcW7E
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i7) {
                VIPCenterTabPageNewFragment.a(Context.this, baseQuickAdapter, view, i7);
            }
        });
        FragmentVipCenterTabPageNewBinding b2 = b();
        TextView textView = b2 == null ? null : b2.l;
        if (textView != null) {
            textView.setText(context.getString(R.string.vip_new_page_renew));
        }
        layoutVipCenterHeaderBinding.g.setOnDropLickListener(new VipGradeProgress.OnDropLickListener() { // from class: com.soft.blued.ui.user.fragment.VIPCenterTabPageNewFragment$setVIPHeaderData$1$1$4
            @Override // com.soft.blued.ui.user.views.VipGradeProgress.OnDropLickListener
            public void a(int i7, float f) {
                int width = (int) (f - (LayoutVipCenterHeaderBinding.this.f29435c.getWidth() / 2));
                int i8 = width;
                if (width < 0) {
                    i8 = 0;
                }
                LayoutVipCenterHeaderBinding.this.j.smoothScrollTo(i8, 0);
                if (i7 < vIPCenterNewModel.level_privilege.size()) {
                    vIPGradePrivilegeAdapter.setNewData(vIPCenterNewModel.level_privilege.get(i7));
                    vIPGradePrivilegeAdapter.a(i7 + 1);
                    vIPGradePrivilegeAdapter.notifyDataSetChanged();
                }
            }
        });
        FragmentVipCenterTabPageNewBinding b3 = b();
        if (b3 == null || (frameLayout = b3.b) == null) {
            return;
        }
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$TiNRVkqgP_YPQV_sqWsQsHbWbQg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCenterTabPageNewFragment.a(VIPCenterNewModel.this, this, context, view);
            }
        });
    }

    private final void f() {
        FragmentVipCenterTabPageNewBinding b2 = b();
        if (b2 == null) {
            return;
        }
        final String a2 = H5Url.a(35);
        final String a3 = H5Url.a(34);
        final String a4 = H5Url.a(14);
        final String a5 = H5Url.a(40);
        final String a6 = H5Url.a(22);
        b2.u.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$ogUQa_IIdFy5Hj0EE2cIj8PE5KU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCenterTabPageNewFragment.a(VIPCenterTabPageNewFragment.this, a2, view);
            }
        });
        b2.t.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$7IkxiL1YEX7Kx-L5kkKUun2QNHE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCenterTabPageNewFragment.b(VIPCenterTabPageNewFragment.this, a3, view);
            }
        });
        b2.p.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$JVr240DGt6HXWJL5-m97z128oKM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCenterTabPageNewFragment.c(VIPCenterTabPageNewFragment.this, a5, view);
            }
        });
        b2.q.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$PLzY6WlyNcot9dMNAWtb0OB2PzQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCenterTabPageNewFragment.d(VIPCenterTabPageNewFragment.this, a4, view);
            }
        });
        b2.r.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$dcUlt-BEZYbR5vgSvN_q_g571Tw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCenterTabPageNewFragment.e(VIPCenterTabPageNewFragment.this, a6, view);
            }
        });
        b2.s.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$K85j_ksDfmii3Yi9lJRg6jxM9t8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VIPCenterTabPageNewFragment.c(VIPCenterTabPageNewFragment.this, view);
            }
        });
    }

    private final void g() {
        if (this.l) {
            return;
        }
        this.l = true;
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_PAGE_SHOW, UserInfo.getInstance().getLoginUserInfo().vip_grade, arguments.getInt("KEY_VIP_GRADE", 2));
    }

    private final void h() {
        if (this.m) {
            return;
        }
        this.m = true;
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0 && UserInfo.getInstance().getLoginUserInfo().expire_type == 0) {
            EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_RESUME_BUY_BTN_SHOW, UserInfo.getInstance().getLoginUserInfo().vip_grade, this.j, VipProtos.BtnType.NOW_BUY);
        } else if (this.j != UserInfo.getInstance().getLoginUserInfo().expire_type && this.j != UserInfo.getInstance().getLoginUserInfo().vip_grade) {
            EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_RESUME_BUY_BTN_SHOW, UserInfo.getInstance().getLoginUserInfo().vip_grade, this.j, VipProtos.BtnType.NOW_BUY);
        } else if (UserInfo.getInstance().getLoginUserInfo().expire_type > 0) {
            EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_RESUME_BUY_BTN_SHOW, UserInfo.getInstance().getLoginUserInfo().vip_grade, this.j, VipProtos.BtnType.RENEW);
        } else if (UserInfo.getInstance().getLoginUserInfo().vip_grade > 0) {
            EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_RESUME_BUY_BTN_SHOW, UserInfo.getInstance().getLoginUserInfo().vip_grade, this.j, VipProtos.BtnType.NOW_RESUME);
        }
    }

    private final boolean i() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        return arguments.getBoolean("KEY_INDEPENDENT_PAGE", false);
    }

    private final void j() {
        if (i()) {
            BluedConfig.a().c();
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            activity.finish();
        }
    }

    public final Rect a() {
        return this.o;
    }

    @Override // com.soft.blued.ui.user.observer.VIPBuyResultObserver.IVIPBuyResultObserver
    public void a(int i, boolean z) {
        if (i == 2 && z && i()) {
            Context context = getContext();
            if (context != null) {
                b.a(context, UserInfo.getInstance().getLoginUserInfo().vip_grade, this.k);
            }
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return;
            }
            activity.finish();
        }
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        BluedStructureExtKt.a(this, VIPCenterAction.GetVIPData.f34310a);
        StatusBarHelper.a((Activity) getActivity(), false);
        if (i()) {
            VIPBuyResultObserver.a().a(this, getLifecycle());
        }
        DialogUtils.a(t());
        String ab = BluedPreferences.ab();
        Intrinsics.c(ab, "getINVISIBLE_DISTANCE_RANGE()");
        this.g = ab;
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
            e();
        } else {
            d();
        }
        this.i = DensityUtil.a(150.0f);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.j = arguments.getInt("KEY_VIP_GRADE", 2);
            String string = arguments.getString("KEY_VIP_DETAIL", "");
            Intrinsics.c(string, "getString(VIPConstants.D…onstants.PAY_DETAIL.NONE)");
            this.k = string;
            if (i()) {
                EventTrackVIP.a(VipProtos.Event.VIP_CENTRE_PAGE_SHOW, UserInfo.getInstance().getLoginUserInfo().vip_grade, this.j);
                h();
            }
        }
        c();
        final FragmentVipCenterTabPageNewBinding b2 = b();
        if (b2 == null) {
            return;
        }
        if (i()) {
            b2.g.setVisibility(0);
            b2.g.setCenterTextColor(2131102170);
            b2.h.setVisibility(0);
            b2.h.setCenterTextColor(2131102203);
            b2.h.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131102170));
            b2.h.setAlpha(0.0f);
            b2.g.setPadding(0, StatusBarHelper.a(getContext()), 0, 0);
            b2.h.setPadding(0, StatusBarHelper.a(getContext()), 0, 0);
            b2.g.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$ayfLBKQvjJhn_isisC-2wiqp-4g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VIPCenterTabPageNewFragment.a(VIPCenterTabPageNewFragment.this, view);
                }
            });
            b2.h.setLeftClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$lSIaD3fURTe1BGDCxWPl3sj9_II
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VIPCenterTabPageNewFragment.b(VIPCenterTabPageNewFragment.this, view);
                }
            });
            if (this.j == 1) {
                StatusBarHelper.a((Activity) getActivity(), true);
                b2.g.setCenterText(R.string.vip);
                b2.h.setCenterText(R.string.vip);
            } else {
                b2.g.setCenterText(R.string.svip);
                b2.h.setCenterText(R.string.svip);
            }
            b2.j.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$kYSHKFwbhMNbMMpWq5bt8xmSYvg
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                    VIPCenterTabPageNewFragment.a(VIPCenterTabPageNewFragment.this, b2, nestedScrollView, i, i2, i3, i4);
                }
            });
        } else {
            b2.g.setVisibility(4);
            b2.h.setVisibility(4);
            b2.j.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$ldIDMCNGAEXLlJj3E1KWnE2K_Bg
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public final void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                    VIPCenterTabPageNewFragment.a(VIPCenterTabPageNewFragment.this, nestedScrollView, i, i2, i3, i4);
                }
            });
        }
        f();
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void o() {
        LiveEventBus.get("INVISIBLE_DISTANCE", Boolean.TYPE).observe(this, new Observer() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VIPCenterTabPageNewFragment$ZbL1_csvtT6OpX-SMvTSd6grJl8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VIPCenterTabPageNewFragment.a(VIPCenterTabPageNewFragment.this, (Boolean) obj);
            }
        });
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner, "viewLifecycleOwner");
        BluedStructureExtKt.a(this, viewLifecycleOwner, new PropertyReference1Impl() { // from class: com.soft.blued.ui.user.fragment.VIPCenterTabPageNewFragment$liveDataObserver$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object a(Object obj) {
                return ((VIPCenterState) obj).a();
            }
        }, new Function1<VIPCenterNewModel, Unit>() { // from class: com.soft.blued.ui.user.fragment.VIPCenterTabPageNewFragment$liveDataObserver$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(VIPCenterNewModel it) {
                Dialog t;
                Intrinsics.e(it, "it");
                t = VIPCenterTabPageNewFragment.this.t();
                DialogUtils.b(t);
                VIPCenterTabPageNewFragment.this.a(it);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(VIPCenterNewModel vIPCenterNewModel) {
                a(vIPCenterNewModel);
                return Unit.f42314a;
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        j();
        return super.onBackPressed();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        BluedConfig.a().b = false;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        this.isUserVisibleHint = z;
        if (z) {
            LayoutVipCenterHeaderBinding layoutVipCenterHeaderBinding = this.e;
            if (layoutVipCenterHeaderBinding != null) {
                ItemVipCenterBannerBinding bannerView = layoutVipCenterHeaderBinding.b;
                Intrinsics.c(bannerView, "bannerView");
                a(bannerView, layoutVipCenterHeaderBinding.b.f29351a.getCurrentItem());
            }
            LayoutVipCenterNewUserHeaderBinding layoutVipCenterNewUserHeaderBinding = this.f;
            if (layoutVipCenterNewUserHeaderBinding != null) {
                ItemVipCenterBannerBinding bannerView2 = layoutVipCenterNewUserHeaderBinding.f29437c;
                Intrinsics.c(bannerView2, "bannerView");
                a(bannerView2, layoutVipCenterNewUserHeaderBinding.f29437c.f29351a.getCurrentItem());
            }
            h();
            g();
        }
    }
}
