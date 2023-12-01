package com.soft.blued.ui.user.fragment;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.anythink.expressad.a;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module.common.base.mvi.EmptyMviViewModel;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.NoScrollViewPager;
import com.blued.android.module.common.view.PageTabLayout;
import com.blued.android.module.common.widget.dialog.BluedAlertDialog;
import com.blued.android.module.live_china.click.SingleClickProxy;
import com.blued.das.profile.PersonalProfileProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentVirtualImageSelectBinding;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.pay.BeansPrePayFragment;
import com.soft.blued.ui.user.fragment.VirtualImageFragment;
import com.soft.blued.ui.user.fragment.VirtualImageSelectFragment;
import com.soft.blued.ui.user.fragment.VirtualImageSettingFragment;
import com.soft.blued.ui.user.model.VirtualImageModel;
import com.soft.blued.ui.user.pop.PopVirtualImageHint;
import com.soft.blued.ui.user.pop.VirtualImageEventNotification;
import com.soft.blued.ui.user.pop.VirtualImageGoodsCart;
import com.soft.blued.ui.user.utils.VirtualImagePayUtils;
import com.soft.blued.ui.user.utils.VirtualImageUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VirtualImageSelectFragment.class */
public final class VirtualImageSelectFragment extends MVIBaseFragment<EmptyMviViewModel> {
    static final /* synthetic */ KProperty<Object>[] b = {(KProperty) Reflection.a(new PropertyReference1Impl(VirtualImageSelectFragment.class, "vb", "getVb()Lcom/soft/blued/databinding/FragmentVirtualImageSelectBinding;", 0))};

    /* renamed from: c  reason: collision with root package name */
    private final ViewBindingProperty f20516c;
    private DismissListener d;
    private List<VirtualImageModel.CategoryModel> e;
    private List<VirtualImageModel.CategoryModel> f;
    private VirtualImageUtils g;
    private VirtualImageFragment.ImageCallBack h;
    private boolean i;
    private final int j;
    private final int k;
    private int l;
    private boolean m;
    private Dialog n;
    private Dialog o;
    private TreeMap<Float, VirtualImageModel.ImageGoodsModel> p;
    private BasePopupView q;
    private BasePopupView r;
    private BasePopupView s;
    private boolean t;
    private int u;
    private final HashMap<Integer, VirtualImageGoodsFragment> v;
    private VirtualImagePackageFragment w;
    private VirtualImageModel.MarketingPopup x;
    private final HashMap<Integer, Boolean> y;
    private int z;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VirtualImageSelectFragment$DismissListener.class */
    public interface DismissListener {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VirtualImageSelectFragment$GoodPagerAdapter.class */
    public static final class GoodPagerAdapter extends FragmentPagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final VirtualImageSelectFragment f20517a;
        private final VirtualImageFragment.ImageCallBack b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GoodPagerAdapter(FragmentManager fragmentManager, VirtualImageSelectFragment virtualImageSelectFragment, VirtualImageFragment.ImageCallBack imageCallBack) {
            super(fragmentManager, 1);
            Intrinsics.e(fragmentManager, "fragmentManager");
            Intrinsics.e(virtualImageSelectFragment, "fragment");
            Intrinsics.e(imageCallBack, "callBack");
            this.f20517a = virtualImageSelectFragment;
            this.b = imageCallBack;
        }

        public final VirtualImageSelectFragment a() {
            return this.f20517a;
        }

        public final VirtualImageFragment.ImageCallBack b() {
            return this.b;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f20517a.a().size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i == 0) {
                VirtualImagePackageFragment virtualImagePackageFragment = new VirtualImagePackageFragment();
                a().w = virtualImagePackageFragment;
                virtualImagePackageFragment.a(b());
                virtualImagePackageFragment.a(a().b());
                return (Fragment) virtualImagePackageFragment;
            } else if (i + 1 == this.f20517a.a().size()) {
                VirtualImageSettingFragment virtualImageSettingFragment = new VirtualImageSettingFragment();
                virtualImageSettingFragment.a(a().c());
                virtualImageSettingFragment.a(new VirtualImageSettingFragment.OnVirtualImageDeletedListener() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSelectFragment$GoodPagerAdapter$getItem$2$1
                    @Override // com.soft.blued.ui.user.fragment.VirtualImageSettingFragment.OnVirtualImageDeletedListener
                    public void a() {
                        VirtualImageSelectFragment.GoodPagerAdapter.this.b().e();
                    }
                });
                virtualImageSettingFragment.a(new VirtualImageSettingFragment.OnBackPressedListener() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSelectFragment$GoodPagerAdapter$getItem$2$2
                    @Override // com.soft.blued.ui.user.fragment.VirtualImageSettingFragment.OnBackPressedListener
                    public void a() {
                        VirtualImageSelectFragment.GoodPagerAdapter.this.a().p();
                    }
                });
                return (Fragment) virtualImageSettingFragment;
            } else {
                VirtualImageGoodsFragment virtualImageGoodsFragment = new VirtualImageGoodsFragment();
                a().v.put(Integer.valueOf(a().a().get(i).getId()), virtualImageGoodsFragment);
                virtualImageGoodsFragment.a(b());
                Bundle bundle = new Bundle();
                bundle.putSerializable("data_category", a().a().get(i));
                virtualImageGoodsFragment.setArguments(bundle);
                return (Fragment) virtualImageGoodsFragment;
            }
        }
    }

    public VirtualImageSelectFragment() {
        super((int) R.layout.fragment_virtual_image_select);
        this.f20516c = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<VirtualImageSelectFragment, FragmentVirtualImageSelectBinding>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSelectFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/user/fragment/VirtualImageSelectFragment;)Lcom/soft/blued/databinding/FragmentVirtualImageSelectBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentVirtualImageSelectBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<VirtualImageSelectFragment, FragmentVirtualImageSelectBinding>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSelectFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/user/fragment/VirtualImageSelectFragment;)Lcom/soft/blued/databinding/FragmentVirtualImageSelectBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentVirtualImageSelectBinding.a(fragment.requireView());
            }
        });
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.j = 2;
        this.k = 8;
        this.p = new TreeMap<>();
        this.v = new HashMap<>();
        this.y = new HashMap<>();
        this.z = -1;
    }

    private final int C() {
        int i = 0;
        for (Map.Entry<Float, VirtualImageModel.ImageGoodsModel> entry : this.p.entrySet()) {
            if (entry.getValue().is_have() != 1) {
                i++;
            }
        }
        return i;
    }

    private final List<VirtualImageModel.PayGoodsInfo> D() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Float, VirtualImageModel.ImageGoodsModel> entry : this.p.entrySet()) {
            VirtualImageModel.ImageGoodsModel value = entry.getValue();
            if (value.getCBuy()) {
                VirtualImageModel.PayGoodsInfo payGoodsInfo = new VirtualImageModel.PayGoodsInfo();
                payGoodsInfo.setGoods_id(value.getId());
                payGoodsInfo.setGoods_num(value.getCBuyCount());
                arrayList.add(payGoodsInfo);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E() {
        ArrayList<Number> arrayList = new ArrayList();
        for (Map.Entry<Float, VirtualImageModel.ImageGoodsModel> entry : this.p.entrySet()) {
            if (entry.getValue().getCBuy()) {
                arrayList.add(entry.getKey());
            }
        }
        for (Number number : arrayList) {
            this.p.remove(Float.valueOf(number.floatValue()));
        }
        l();
    }

    private final boolean F() {
        boolean z = false;
        for (Map.Entry<Float, VirtualImageModel.ImageGoodsModel> entry : this.p.entrySet()) {
            if (entry.getValue().is_have() != 1) {
                z = true;
            }
        }
        return z;
    }

    private final void G() {
        Context context;
        VirtualImageUtils virtualImageUtils = this.g;
        if (virtualImageUtils == null || (context = getContext()) == null) {
            return;
        }
        this.q = new XPopup.Builder(context).a(new SimpleCallback() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSelectFragment$showGoodCart$1$1$1
            public void c(BasePopupView basePopupView) {
                Intrinsics.e(basePopupView, "popupView");
                super.c(basePopupView);
            }

            public void d(BasePopupView basePopupView) {
                Intrinsics.e(basePopupView, "popupView");
                super.d(basePopupView);
            }
        }).a(a(context, virtualImageUtils)).h();
    }

    private final List<Integer> H() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Float, VirtualImageModel.ImageGoodsModel> entry : this.p.entrySet()) {
            VirtualImageModel.ImageGoodsModel value = entry.getValue();
            if (value.getCBuy()) {
                arrayList.add(Integer.valueOf(value.getId()));
            }
        }
        return arrayList;
    }

    private final void I() {
        VirtualImageModel.MarketingPopup marketingPopup = this.x;
        if (marketingPopup == null || Intrinsics.a(BluedPreferences.fu(), marketingPopup.getPop_key())) {
            return;
        }
        boolean z = true;
        if (marketingPopup.is_show() == 1) {
            if (marketingPopup.getImg().length() <= 0) {
                z = false;
            }
            if (z) {
                BluedPreferences.at(marketingPopup.getPop_key());
                Context context = getContext();
                if (context == null) {
                    return;
                }
                this.r = new XPopup.Builder(context).a(new SimpleCallback() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSelectFragment$showEvent$1$1$1
                    public void c(BasePopupView basePopupView) {
                        Intrinsics.e(basePopupView, "popupView");
                        super.c(basePopupView);
                    }

                    public void d(BasePopupView basePopupView) {
                        Intrinsics.e(basePopupView, "popupView");
                        super.d(basePopupView);
                    }
                }).b(false).a(BluedViewExtKt.a(300)).a(a(context, marketingPopup.getImg(), marketingPopup.getLink())).h();
            }
        }
    }

    private final void J() {
        Context context;
        if (BluedPreferences.fp() || (context = getContext()) == null) {
            return;
        }
        BasePopupView basePopupView = this.s;
        boolean z = false;
        if (basePopupView != null && basePopupView.isShown()) {
            z = true;
        }
        if (z) {
            return;
        }
        this.s = new XPopup.Builder(context).a(new SimpleCallback() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSelectFragment$showFirstEntrancePop$1$1
            public void c(BasePopupView basePopupView2) {
                super.c(basePopupView2);
                BluedPreferences.fo();
            }
        }).a(new PopVirtualImageHint(context)).h();
    }

    private final BottomPopupView a(Context context, VirtualImageUtils virtualImageUtils) {
        IRequestHost fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        return new VirtualImageGoodsCart(context, fragmentActive, s(), virtualImageUtils, new VirtualImageGoodsCart.OnCartClickListener() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSelectFragment$createCartView$1
            @Override // com.soft.blued.ui.user.pop.VirtualImageGoodsCart.OnCartClickListener
            public void a(int i) {
                int i2;
                VirtualImageSelectFragment.this.a(VipProtos.Event.VIRTUAL_BUY_CLICK, i);
                if (VirtualImageSelectFragment.this.isAdded()) {
                    i2 = VirtualImageSelectFragment.this.u;
                    if (i2 >= i) {
                        VirtualImageSelectFragment.this.b(i);
                    } else {
                        VirtualImageSelectFragment.this.j();
                    }
                }
            }
        });
    }

    private final CenterPopupView a(final Context context, String str, String str2) {
        IRequestHost fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        return new VirtualImageEventNotification(context, fragmentActive, str, str2, new VirtualImageEventNotification.OnEventClickListener() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSelectFragment$createEventView$1
            @Override // com.soft.blued.ui.user.pop.VirtualImageEventNotification.OnEventClickListener
            public void a(String str3) {
                Intrinsics.e(str3, "eventUrl");
                WebViewShowInfoFragment.show(Context.this, str3, -1);
            }
        });
    }

    private final void a(Context context) {
        VirtualImageUtils virtualImageUtils = this.g;
        if (virtualImageUtils != null) {
            virtualImageUtils.updateCurrentUseIds();
        }
        List<VirtualImageModel.PayGoodsInfo> D = D();
        VirtualImagePayUtils virtualImagePayUtils = new VirtualImagePayUtils();
        ActivityFragmentActive fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        virtualImagePayUtils.a(context, (IRequestHost) fragmentActive, BluedPreferences.G(""), "", 0, D, new VirtualImagePayUtils.PayResult() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSelectFragment$goToPay$1
            @Override // com.soft.blued.ui.user.utils.VirtualImagePayUtils.PayResult
            public void a(int i) {
                BasePopupView basePopupView;
                ToastUtils.b(VirtualImageSelectFragment.this.getString(R.string.user_virtual_image_pay_success));
                VirtualImageSelectFragment.this.a(i);
                VirtualImageSelectFragment.this.E();
                VirtualImageFragment.ImageCallBack d = VirtualImageSelectFragment.this.d();
                if (d != null) {
                    d.c();
                }
                basePopupView = VirtualImageSelectFragment.this.q;
                if (basePopupView != null && basePopupView.isShown()) {
                    basePopupView.p();
                }
            }

            @Override // com.soft.blued.ui.user.utils.VirtualImagePayUtils.PayResult
            public void a(int i, String str) {
                if (i == 4032007) {
                    VirtualImageSelectFragment.this.j();
                    return;
                }
                String str2 = str;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                AppMethods.a(str2);
            }
        });
    }

    private final void a(final PageTabLayout pageTabLayout) {
        View a2;
        PageTabLayout.Tab a3 = pageTabLayout.a(this.j);
        if (a3 == null || (a2 = a3.a()) == null) {
            return;
        }
        a(a().get(this.j), a2, this.j, true);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(a2, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(350L);
        ofFloat.start();
        final int width = a2.getWidth();
        int i = this.k;
        int i2 = this.j;
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.a = this.j + 1;
        ValueAnimator ofInt = ValueAnimator.ofInt(0, (i - i2) * width);
        ofInt.setDuration(350L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSelectFragment$0ZhWmIFse8T7CssB7YVS1v2_XHU
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                VirtualImageSelectFragment.a(VirtualImageSelectFragment.this, width, intRef, pageTabLayout, valueAnimator);
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSelectFragment$expendTabViews$1$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                int i3;
                int i4;
                View a4;
                i3 = VirtualImageSelectFragment.this.j;
                int i5 = i3 + 1;
                i4 = VirtualImageSelectFragment.this.k;
                if (i5 > i4) {
                    return;
                }
                while (true) {
                    PageTabLayout.Tab a5 = pageTabLayout.a(i5);
                    if (a5 != null && (a4 = a5.a()) != null) {
                        VirtualImageSelectFragment virtualImageSelectFragment = VirtualImageSelectFragment.this;
                        virtualImageSelectFragment.a(virtualImageSelectFragment.a().get(i5), a4, i5, true);
                    }
                    if (i5 == i4) {
                        return;
                    }
                    i5++;
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(VipProtos.Event event, int i) {
        EventTrackVIP.a(event, CollectionsKt.a(H(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImageSelectFragment virtualImageSelectFragment, int i, DialogInterface dialogInterface, int i2) {
        Tracker.onClick(dialogInterface, i2);
        Intrinsics.e(virtualImageSelectFragment, "this$0");
        Context context = virtualImageSelectFragment.getContext();
        if (context == null) {
            return;
        }
        virtualImageSelectFragment.a(VipProtos.Event.VIRTUAL_BUY_POP_YES_CLICK, i);
        virtualImageSelectFragment.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImageSelectFragment virtualImageSelectFragment, int i, Ref.IntRef intRef, PageTabLayout pageTabLayout, ValueAnimator valueAnimator) {
        PageTabLayout.Tab a2;
        View a3;
        View a4;
        Intrinsics.e(virtualImageSelectFragment, "this$0");
        Intrinsics.e(intRef, "$lastIndex");
        Intrinsics.e(pageTabLayout, "$tabLayout");
        int i2 = virtualImageSelectFragment.j;
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        int intValue = i2 + 1 + (((Integer) animatedValue).intValue() / i);
        if (intRef.a != intValue) {
            PageTabLayout.Tab a5 = pageTabLayout.a(intRef.a);
            if (a5 != null && (a4 = a5.a()) != null) {
                ViewGroup.LayoutParams layoutParams = a4.getLayoutParams();
                layoutParams.width = i;
                a4.setLayoutParams(layoutParams);
            }
            intRef.a = intValue;
        }
        if (intValue > virtualImageSelectFragment.k || (a2 = pageTabLayout.a(intValue)) == null || (a3 = a2.a()) == null) {
            return;
        }
        a3.setVisibility(0);
        ViewGroup.LayoutParams layoutParams2 = a3.getLayoutParams();
        Object animatedValue2 = valueAnimator.getAnimatedValue();
        if (animatedValue2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        layoutParams2.width = ((Integer) animatedValue2).intValue() % i;
        a3.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImageSelectFragment virtualImageSelectFragment, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(virtualImageSelectFragment, "this$0");
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_VIRTUAL_EDIT_PAGE_BACK_CLICK, true);
        VirtualImageFragment.ImageCallBack imageCallBack = virtualImageSelectFragment.h;
        if (imageCallBack == null) {
            return;
        }
        imageCallBack.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImageSelectFragment virtualImageSelectFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageSelectFragment, "this$0");
        if (virtualImageSelectFragment.C() > 0) {
            ToastUtils.b(virtualImageSelectFragment.getString(R.string.user_virtual_image_save_need_to_pay));
            virtualImageSelectFragment.G();
        } else if (!virtualImageSelectFragment.m) {
            ToastUtils.b(virtualImageSelectFragment.getString(R.string.user_virtual_image_nothing_changed));
        } else {
            VirtualImageFragment.ImageCallBack imageCallBack = virtualImageSelectFragment.h;
            if (imageCallBack == null) {
                return;
            }
            imageCallBack.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImageSelectFragment virtualImageSelectFragment, PageTabLayout pageTabLayout) {
        Intrinsics.e(virtualImageSelectFragment, "this$0");
        Intrinsics.e(pageTabLayout, "$it");
        virtualImageSelectFragment.i = false;
        virtualImageSelectFragment.a(pageTabLayout);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(VirtualImageModel.CategoryModel categoryModel, View view, int i, boolean z) {
        View findViewById = view.findViewById(R.id.fl_tab_icon);
        Intrinsics.c(findViewById, "tabView.findViewById(R.id.fl_tab_icon)");
        FrameLayout frameLayout = (FrameLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.iv_tab_icon);
        Intrinsics.c(findViewById2, "tabView.findViewById(R.id.iv_tab_icon)");
        ImageView imageView = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.v_tab_red_dot);
        Intrinsics.c(findViewById3, "tabView.findViewById(R.id.v_tab_red_dot)");
        View findViewById4 = view.findViewById(R.id.v_split_line_1);
        Intrinsics.c(findViewById4, "tabView.findViewById(R.id.v_split_line_1)");
        View findViewById5 = view.findViewById(R.id.v_split_line_2);
        Intrinsics.c(findViewById5, "tabView.findViewById(R.id.v_split_line_2)");
        findViewById4.setVisibility(8);
        findViewById5.setVisibility(8);
        int id = categoryModel.getId();
        if (id == -2) {
            imageView.setImageResource(i != this.l ? 2131234041 : 2131234040);
            findViewById4.setVisibility(0);
        } else if (id != -1) {
            a(categoryModel, frameLayout, imageView, i);
            if (i == 1) {
                findViewById5.setVisibility(0);
            }
        } else {
            imageView.setImageResource(i != this.l ? 2131234038 : 2131234037);
        }
        if (z) {
            int i2 = 8;
            if (Intrinsics.a(this.y.get(Integer.valueOf(i)), true)) {
                i2 = 0;
            }
            findViewById3.setVisibility(i2);
        } else if (findViewById3.getVisibility() == 0) {
            findViewById3.setVisibility(8);
            BluedPreferences.a(categoryModel.getId(), categoryModel.getRed_dot());
        }
    }

    private final void a(VirtualImageModel.CategoryModel categoryModel, FrameLayout frameLayout, ImageView imageView, int i) {
        String str;
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        if (this.i && i == this.j) {
            layoutParams2.width = BluedViewExtKt.a(42);
            layoutParams2.setMarginStart(BluedViewExtKt.a(5));
            layoutParams2.setMarginEnd(BluedViewExtKt.a(5));
            imageView.setImageResource(R.drawable.icon_virtual_image_collapsed);
        } else {
            layoutParams2.width = BluedViewExtKt.a(28);
            if (i == 0) {
                layoutParams2.setMarginStart(BluedViewExtKt.a(15));
                layoutParams2.setMarginEnd(BluedViewExtKt.a(15));
            } else if (i != 1) {
                layoutParams2.setMarginStart(BluedViewExtKt.a(12));
                layoutParams2.setMarginEnd(BluedViewExtKt.a(12));
            } else {
                layoutParams2.setMarginStart(BluedViewExtKt.a(16));
                layoutParams2.setMarginEnd(BluedViewExtKt.a(12));
            }
            VirtualImageModel.Resource resource = categoryModel.getResource();
            IRequestHost fragmentActive = getFragmentActive();
            if (i != this.l) {
                if (resource == null) {
                    str = "";
                } else {
                    String icon = resource.getIcon();
                    str = icon;
                    if (icon == null) {
                        str = "";
                    }
                }
            } else if (resource == null) {
                str = "";
            } else {
                String checked = resource.getChecked();
                str = checked;
                if (checked == null) {
                    str = "";
                }
            }
            ImageLoader.a(fragmentActive, str).a(imageView);
        }
        frameLayout.setLayoutParams(layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(VirtualImageModel.ImageGoodsModel imageGoodsModel) {
        if ((imageGoodsModel.is_have() == 2 && imageGoodsModel.getBeans() == 0) || (imageGoodsModel.is_have() == 1 && imageGoodsModel.getExpire_at() == 0)) {
            this.p.remove(Float.valueOf(imageGoodsModel.getBlock_code()));
        } else {
            this.p.put(Float.valueOf(imageGoodsModel.getBlock_code()), imageGoodsModel);
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(VirtualImageModel.MarketingActive marketingActive, VirtualImageSelectFragment virtualImageSelectFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(marketingActive, "$this_apply");
        Intrinsics.e(virtualImageSelectFragment, "this$0");
        EventTrackVIP.c(VipProtos.Event.VIRTUAL_EDIT_PAGE_ACTIVITY_CLICK, marketingActive.getLink());
        WebViewShowInfoFragment.show(virtualImageSelectFragment.getContext(), marketingActive.getLink(), -1);
    }

    private final boolean a(VirtualImageModel.CategoryModel categoryModel) {
        return (TextUtils.isEmpty(categoryModel.getRed_dot()) || Intrinsics.a(categoryModel.getRed_dot(), BluedPreferences.z(categoryModel.getId()))) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(final int i) {
        Dialog dialog = this.o;
        if (dialog != null && dialog.isShowing()) {
            return;
        }
        BluedAlertDialog.Builder builder = new BluedAlertDialog.Builder(getContext());
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = getResources().getString(R.string.user_virtual_image_pay_confirm);
        Intrinsics.c(string, "resources.getString(R.st…irtual_image_pay_confirm)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.c(format, "format(format, *args)");
        Dialog a2 = builder.b(format).a((int) R.string.user_virtual_image_payment, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSelectFragment$TPdFSI-1tSMTuLayP9pAbFU5XI0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                VirtualImageSelectFragment.a(VirtualImageSelectFragment.this, i, dialogInterface, i2);
            }
        }).b(2131886885, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSelectFragment$SyTcn1Dq1pJJ9ivpBDxyLr65Hgk
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                VirtualImageSelectFragment.b(VirtualImageSelectFragment.this, i, dialogInterface, i2);
            }
        }).b().a();
        this.o = a2;
        if (a2 == null) {
            return;
        }
        a2.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VirtualImageSelectFragment virtualImageSelectFragment, int i, DialogInterface dialogInterface, int i2) {
        Tracker.onClick(dialogInterface, i2);
        Intrinsics.e(virtualImageSelectFragment, "this$0");
        virtualImageSelectFragment.a(VipProtos.Event.VIRTUAL_BUY_POP_NO_CLICK, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VirtualImageSelectFragment virtualImageSelectFragment, DialogInterface dialogInterface, int i) {
        Tracker.onClick(dialogInterface, i);
        Intrinsics.e(virtualImageSelectFragment, "this$0");
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_VIRTUAL_EDIT_PAGE_BACK_CLICK, false);
        virtualImageSelectFragment.e();
        VirtualImageFragment.ImageCallBack imageCallBack = virtualImageSelectFragment.h;
        if (imageCallBack == null) {
            return;
        }
        imageCallBack.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VirtualImageSelectFragment virtualImageSelectFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageSelectFragment, "this$0");
        virtualImageSelectFragment.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(VirtualImageModel.CategoryModel categoryModel) {
        VirtualImageFragment.ImageCallBack imageCallBack = this.h;
        if (imageCallBack == null) {
            return;
        }
        imageCallBack.a(categoryModel.getZoom_in() == 1 ? 2 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(VirtualImageSelectFragment virtualImageSelectFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageSelectFragment, "this$0");
        EventTrackVIP.a(VipProtos.Event.VIRTUAL_EDIT_PAGE_BUY_CLICK);
        virtualImageSelectFragment.G();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(VirtualImageSelectFragment virtualImageSelectFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageSelectFragment, "this$0");
        EventTrackVIP.a(VipProtos.Event.VIRTUAL_EDIT_PAGE_WANDOU_CLICK);
        virtualImageSelectFragment.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentVirtualImageSelectBinding f() {
        return (FragmentVirtualImageSelectBinding) this.f20516c.b(this, b[0]);
    }

    private final void g() {
        int i;
        NoScrollViewPager noScrollViewPager;
        final PageTabLayout pageTabLayout;
        PageTabLayout pageTabLayout2;
        PageTabLayout.Tab a2;
        View a3;
        PageTabLayout pageTabLayout3;
        PageTabLayout pageTabLayout4;
        PageTabLayout pageTabLayout5;
        NoScrollViewPager noScrollViewPager2;
        FragmentVirtualImageSelectBinding f = f();
        NoScrollViewPager noScrollViewPager3 = f == null ? null : f.m;
        if (noScrollViewPager3 != null) {
            noScrollViewPager3.setOffscreenPageLimit(this.e.size());
        }
        FragmentVirtualImageSelectBinding f2 = f();
        if (f2 != null && (noScrollViewPager2 = f2.m) != null) {
            noScrollViewPager2.a(false);
        }
        FragmentVirtualImageSelectBinding f3 = f();
        NoScrollViewPager noScrollViewPager4 = f3 == null ? null : f3.m;
        if (noScrollViewPager4 != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "childFragmentManager");
            noScrollViewPager4.setAdapter(new GoodPagerAdapter(childFragmentManager, this, new VirtualImageFragment.ImageCallBack() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSelectFragment$setViewPager$1
                @Override // com.soft.blued.ui.user.fragment.VirtualImageFragment.ImageCallBack
                public void a() {
                    FragmentVirtualImageSelectBinding f4;
                    VirtualImageFragment.ImageCallBack d = VirtualImageSelectFragment.this.d();
                    if (d != null) {
                        d.a();
                    }
                    VirtualImageSelectFragment.this.m = true;
                    f4 = VirtualImageSelectFragment.this.f();
                    ShapeHelper.b(f4 == null ? null : f4.l, 2131101864);
                }

                @Override // com.soft.blued.ui.user.fragment.VirtualImageFragment.ImageCallBack
                public void a(int i2) {
                    VirtualImageFragment.ImageCallBack d = VirtualImageSelectFragment.this.d();
                    if (d == null) {
                        return;
                    }
                    d.a(i2);
                }

                @Override // com.soft.blued.ui.user.fragment.VirtualImageFragment.ImageCallBack
                public void a(int i2, VirtualImageModel.ImageGoodsModel imageGoodsModel) {
                    int i3;
                    Intrinsics.e(imageGoodsModel, "goods");
                    VirtualImageFragment.ImageCallBack d = VirtualImageSelectFragment.this.d();
                    if (d != null) {
                        d.a(i2, imageGoodsModel);
                    }
                    List<VirtualImageModel.CategoryModel> a4 = VirtualImageSelectFragment.this.a();
                    i3 = VirtualImageSelectFragment.this.l;
                    if (a4.get(i3).getId() >= 0) {
                        VirtualImageSelectFragment.this.a(imageGoodsModel);
                    }
                }

                @Override // com.soft.blued.ui.user.fragment.VirtualImageFragment.ImageCallBack
                public void a(ImageView imageView, VirtualImageModel.ImageGoodsModel imageGoodsModel) {
                    Intrinsics.e(imageView, a.B);
                    Intrinsics.e(imageGoodsModel, "goods");
                    VirtualImageFragment.ImageCallBack d = VirtualImageSelectFragment.this.d();
                    if (d == null) {
                        return;
                    }
                    d.a(imageView, imageGoodsModel);
                }

                @Override // com.soft.blued.ui.user.fragment.VirtualImageFragment.ImageCallBack
                public void b() {
                }

                @Override // com.soft.blued.ui.user.fragment.VirtualImageFragment.ImageCallBack
                public void c() {
                    VirtualImageFragment.ImageCallBack d = VirtualImageSelectFragment.this.d();
                    if (d == null) {
                        return;
                    }
                    d.a();
                }

                @Override // com.soft.blued.ui.user.fragment.VirtualImageFragment.ImageCallBack
                public void d() {
                }

                @Override // com.soft.blued.ui.user.fragment.VirtualImageFragment.ImageCallBack
                public void e() {
                    VirtualImageSelectFragment.this.e();
                    VirtualImageFragment.ImageCallBack d = VirtualImageSelectFragment.this.d();
                    if (d == null) {
                        return;
                    }
                    d.e();
                }
            }));
        }
        FragmentVirtualImageSelectBinding f4 = f();
        if (f4 != null && (pageTabLayout5 = f4.i) != null) {
            pageTabLayout5.setScrollableTabMinWidth(0);
        }
        FragmentVirtualImageSelectBinding f5 = f();
        if (f5 != null && (pageTabLayout4 = f5.i) != null) {
            FragmentVirtualImageSelectBinding f6 = f();
            pageTabLayout4.setupWithViewPager(f6 == null ? null : f6.m);
        }
        h();
        if (this.i) {
            int i2 = this.j;
            int i3 = this.k;
            int i4 = this.z;
            if (i2 <= i4 && i4 <= i3) {
                this.i = false;
            }
            i = this.z;
        } else {
            i = 1;
        }
        int i5 = 0;
        boolean z = false;
        for (VirtualImageModel.CategoryModel categoryModel : this.e) {
            View inflate = View.inflate(getContext(), R.layout.layout_virtual_image_tab_icon, null);
            FragmentVirtualImageSelectBinding f7 = f();
            PageTabLayout.Tab a4 = (f7 == null || (pageTabLayout3 = f7.i) == null) ? null : pageTabLayout3.a(i5);
            if (a4 != null) {
                a4.a(inflate);
            }
            if (this.i) {
                if (i5 <= this.k && this.j + 1 <= i5) {
                    inflate.setVisibility(8);
                    if (Intrinsics.a(this.y.get(Integer.valueOf(i5)), true)) {
                        z = true;
                    }
                    i5++;
                }
            }
            Intrinsics.c(inflate, "tabView");
            a(categoryModel, inflate, i5, true);
            i5++;
        }
        if (this.i) {
            FragmentVirtualImageSelectBinding f8 = f();
            if (f8 != null && (pageTabLayout2 = f8.i) != null && (a2 = pageTabLayout2.a(this.j)) != null && (a3 = a2.a()) != null) {
                if (Intrinsics.a(this.y.get(Integer.valueOf(this.j)), true)) {
                    z = true;
                }
                a3.findViewById(R.id.v_tab_red_dot).setVisibility(z ? 0 : 8);
            }
            FragmentVirtualImageSelectBinding f9 = f();
            if (f9 != null && (pageTabLayout = f9.i) != null) {
                pageTabLayout.a(this.j, new PageTabLayout.OnPlaceHolderSelectedListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSelectFragment$MxxAybHZ7JBwKmy8l11vk7WCZmM
                    public final void onSelected() {
                        VirtualImageSelectFragment.a(VirtualImageSelectFragment.this, pageTabLayout);
                    }
                });
            }
        }
        FragmentVirtualImageSelectBinding f10 = f();
        if (f10 != null && (noScrollViewPager = f10.m) != null) {
            noScrollViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.soft.blued.ui.user.fragment.VirtualImageSelectFragment$setViewPager$4
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i6) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i6, float f11, int i7) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i6) {
                    int i7;
                    FragmentVirtualImageSelectBinding f11;
                    FragmentVirtualImageSelectBinding f12;
                    VirtualImagePackageFragment virtualImagePackageFragment;
                    PageTabLayout pageTabLayout6;
                    PageTabLayout.Tab a5;
                    View a6;
                    PageTabLayout pageTabLayout7;
                    PageTabLayout.Tab a7;
                    View a8;
                    i7 = VirtualImageSelectFragment.this.l;
                    VirtualImageSelectFragment.this.l = i6;
                    f11 = VirtualImageSelectFragment.this.f();
                    if (f11 != null && (pageTabLayout7 = f11.i) != null && (a7 = pageTabLayout7.a(i7)) != null && (a8 = a7.a()) != null) {
                        VirtualImageSelectFragment virtualImageSelectFragment = VirtualImageSelectFragment.this;
                        virtualImageSelectFragment.a(virtualImageSelectFragment.a().get(i7), a8, i7, false);
                    }
                    f12 = VirtualImageSelectFragment.this.f();
                    if (f12 != null && (pageTabLayout6 = f12.i) != null && (a5 = pageTabLayout6.a(i6)) != null && (a6 = a5.a()) != null) {
                        VirtualImageSelectFragment virtualImageSelectFragment2 = VirtualImageSelectFragment.this;
                        virtualImageSelectFragment2.a(virtualImageSelectFragment2.a().get(i6), a6, i6, false);
                    }
                    VirtualImageSelectFragment virtualImageSelectFragment3 = VirtualImageSelectFragment.this;
                    virtualImageSelectFragment3.b(virtualImageSelectFragment3.a().get(i6));
                    if (i6 != 0) {
                        VirtualImageGoodsFragment virtualImageGoodsFragment = (VirtualImageGoodsFragment) VirtualImageSelectFragment.this.v.get(Integer.valueOf(VirtualImageSelectFragment.this.a().get(i6).getId()));
                        if (virtualImageGoodsFragment == null) {
                            return;
                        }
                        virtualImageGoodsFragment.E();
                        return;
                    }
                    EventTrackVIP.a();
                    virtualImagePackageFragment = VirtualImageSelectFragment.this.w;
                    if (virtualImagePackageFragment == null) {
                        return;
                    }
                    virtualImagePackageFragment.c();
                }
            });
        }
        FragmentVirtualImageSelectBinding f11 = f();
        NoScrollViewPager noScrollViewPager5 = f11 == null ? null : f11.m;
        if (noScrollViewPager5 == null) {
            return;
        }
        noScrollViewPager5.setCurrentItem(i);
    }

    private final void h() {
        int i = 0;
        int i2 = -1;
        for (VirtualImageModel.CategoryModel categoryModel : this.e) {
            boolean a2 = a(categoryModel);
            this.y.put(Integer.valueOf(i), Boolean.valueOf(a2));
            if (a2 && this.z == -1) {
                this.z = i;
            }
            if (categoryModel.getId() == 17) {
                i2 = i;
            }
            i++;
        }
        if (this.z == -1) {
            this.z = i2;
        }
    }

    private final void i() {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        FrameLayout frameLayout3;
        FrameLayout frameLayout4;
        FragmentVirtualImageSelectBinding f = f();
        if (f != null && (frameLayout4 = f.e) != null) {
            frameLayout4.setOnClickListener((View.OnClickListener) new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSelectFragment$ThXlOh1NfoUA2iDrRaS4DDn4T1I
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VirtualImageSelectFragment.a(VirtualImageSelectFragment.this, view);
                }
            }));
        }
        FragmentVirtualImageSelectBinding f2 = f();
        if (f2 != null && (frameLayout3 = f2.b) != null) {
            frameLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSelectFragment$IDSWErCY5_XW738vYdXbW3HPrVM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VirtualImageSelectFragment.b(VirtualImageSelectFragment.this, view);
                }
            });
        }
        FragmentVirtualImageSelectBinding f3 = f();
        if (f3 != null && (frameLayout2 = f3.d) != null) {
            frameLayout2.setOnClickListener((View.OnClickListener) new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSelectFragment$i2IkCLToXYWvldDCs-b0Fo3rdQM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VirtualImageSelectFragment.c(VirtualImageSelectFragment.this, view);
                }
            }));
        }
        FragmentVirtualImageSelectBinding f4 = f();
        if (f4 == null || (frameLayout = f4.f15340c) == null) {
            return;
        }
        frameLayout.setOnClickListener((View.OnClickListener) new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSelectFragment$t_BYHOXFfFA_FjYYDSwBLzauIG0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualImageSelectFragment.d(VirtualImageSelectFragment.this, view);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        BeansPrePayFragment.a(getContext(), 11);
        this.t = true;
    }

    private final void l() {
        ShapeHelper.ShapeView shapeView;
        String str;
        int size = this.p.size();
        int C = C();
        boolean z = size > 0;
        FragmentVirtualImageSelectBinding f = f();
        FrameLayout frameLayout = f == null ? null : f.d;
        if (frameLayout != null) {
            frameLayout.setEnabled(z);
        }
        FragmentVirtualImageSelectBinding f2 = f();
        if (f2 == null || (shapeView = f2.k) == null) {
            return;
        }
        int i = z ? 2131101864 : 2131101502;
        ShapeHelper.ShapeView shapeView2 = shapeView;
        ShapeHelper.d(shapeView2, i);
        ShapeHelper.a(shapeView2, i);
        if (C > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(C);
            sb.append(')');
            str = sb.toString();
        } else {
            str = "";
        }
        shapeView.setText(Intrinsics.a(getString(R.string.user_virtual_image_buy), str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(VirtualImageSelectFragment virtualImageSelectFragment) {
        Intrinsics.e(virtualImageSelectFragment, "this$0");
        virtualImageSelectFragment.q();
        virtualImageSelectFragment.I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(VirtualImageSelectFragment virtualImageSelectFragment) {
        Intrinsics.e(virtualImageSelectFragment, "this$0");
        virtualImageSelectFragment.J();
    }

    private final void n() {
        Dialog dialog = this.n;
        if (dialog != null && dialog.isShowing()) {
            return;
        }
        Dialog a2 = new BluedAlertDialog.Builder(getContext()).b(getResources().getString(R.string.user_virtual_image_back_hint)).a((int) R.string.common_save, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSelectFragment$qCscMxpO5nSV_6iAKeD-hMyUldE
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                VirtualImageSelectFragment.a(VirtualImageSelectFragment.this, dialogInterface, i);
            }
        }).b((int) R.string.give_up, new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSelectFragment$uuVVOAAA8QbsxZytJelQUKg2lxk
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                VirtualImageSelectFragment.b(VirtualImageSelectFragment.this, dialogInterface, i);
            }
        }).b().a();
        this.n = a2;
        if (a2 == null) {
            return;
        }
        a2.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        if (this.m && !F()) {
            n();
            return;
        }
        e();
        VirtualImageFragment.ImageCallBack imageCallBack = this.h;
        if (imageCallBack != null) {
            imageCallBack.c();
        }
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_VIRTUAL_EDIT_PAGE_BACK_CLICK, false);
    }

    private final void q() {
        ShapeLinearLayout shapeLinearLayout;
        FragmentVirtualImageSelectBinding f = f();
        if (f != null && (shapeLinearLayout = f.h) != null) {
            shapeLinearLayout.setTranslationY(BluedViewExtKt.a(320));
            shapeLinearLayout.setVisibility(0);
            shapeLinearLayout.animate().translationY(0.0f).setDuration(300L).start();
        }
        VirtualImageFragment.ImageCallBack imageCallBack = this.h;
        if (imageCallBack == null) {
            return;
        }
        imageCallBack.a(0);
    }

    private final List<MultiItemEntity> s() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Float, VirtualImageModel.ImageGoodsModel> entry : this.p.entrySet()) {
            VirtualImageModel.ImageGoodsModel value = entry.getValue();
            if (value.is_have() != 1) {
                value.setCBuy(true);
                value.getBeans();
                arrayList.add(value);
            }
        }
        if (arrayList.size() > 0) {
            VirtualImageModel.CartCategoryHeader cartCategoryHeader = new VirtualImageModel.CartCategoryHeader();
            String string = getString(R.string.user_virtual_image_cart_not_pay);
            Intrinsics.c(string, "getString(R.string.user_…rtual_image_cart_not_pay)");
            cartCategoryHeader.setText(string);
            arrayList.add(0, cartCategoryHeader);
        }
        int size = arrayList.size();
        for (Map.Entry<Float, VirtualImageModel.ImageGoodsModel> entry2 : this.p.entrySet()) {
            VirtualImageModel.ImageGoodsModel value2 = entry2.getValue();
            if (value2.is_have() == 1) {
                value2.setCBuy(false);
                value2.getBeans();
                arrayList.add(value2);
            }
        }
        if (size < arrayList.size()) {
            VirtualImageModel.CartCategoryHeader cartCategoryHeader2 = new VirtualImageModel.CartCategoryHeader();
            String string2 = getString(R.string.user_virtual_image_cart_paid);
            Intrinsics.c(string2, "getString(R.string.user_virtual_image_cart_paid)");
            cartCategoryHeader2.setText(string2);
            arrayList.add(size, cartCategoryHeader2);
        }
        return CollectionsKt.f(arrayList);
    }

    public final List<VirtualImageModel.CategoryModel> a() {
        return this.e;
    }

    public final void a(int i) {
        this.u = i;
        FragmentVirtualImageSelectBinding f = f();
        TextView textView = f == null ? null : f.j;
        if (textView == null) {
            return;
        }
        textView.setText(StringUtils.a(String.valueOf(i)));
    }

    public final void a(VirtualImageFragment.ImageCallBack imageCallBack) {
        this.h = imageCallBack;
    }

    public final void a(DismissListener dismissListener) {
        this.d = dismissListener;
    }

    public final void a(VirtualImageModel.MarketingPicture marketingPicture) {
        ImageView imageView;
        Intrinsics.e(marketingPicture, "picture");
        this.x = marketingPicture.getPopup();
        final VirtualImageModel.MarketingActive active = marketingPicture.getActive();
        if (active == null || TextUtils.isEmpty(active.getImg()) || TextUtils.isEmpty(active.getLink()) || active.is_show() != 1) {
            return;
        }
        FragmentVirtualImageSelectBinding f = f();
        CardView cardView = f == null ? null : f.f15339a;
        if (cardView != null) {
            cardView.setVisibility(0);
        }
        FragmentVirtualImageSelectBinding f2 = f();
        if (f2 == null || (imageView = f2.g) == null) {
            return;
        }
        EventTrackVIP.c(VipProtos.Event.VIRTUAL_EDIT_PAGE_ACTIVITY_SHOW, active.getLink());
        ImageLoader.a(getFragmentActive(), active.getImg()).a(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSelectFragment$twViGIIONJ_-00iL9Yf69rVEzyw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VirtualImageSelectFragment.a(VirtualImageModel.MarketingActive.this, this, view);
            }
        });
    }

    public final void a(VirtualImageUtils virtualImageUtils) {
        this.g = virtualImageUtils;
    }

    public final void a(List<VirtualImageModel.CategoryModel> list) {
        Intrinsics.e(list, "<set-?>");
        this.e = list;
    }

    public final void a(boolean z) {
        this.i = z;
    }

    public final List<VirtualImageModel.CategoryModel> b() {
        return this.f;
    }

    public final void b(List<VirtualImageModel.CategoryModel> list) {
        Intrinsics.e(list, "<set-?>");
        this.f = list;
    }

    public final VirtualImageUtils c() {
        return this.g;
    }

    public final void c(List<VirtualImageModel.CategoryModel> list) {
        VirtualImageGoodsFragment virtualImageGoodsFragment;
        Intrinsics.e(list, "newData");
        for (VirtualImageModel.CategoryModel categoryModel : list) {
            if (this.v.containsKey(Integer.valueOf(categoryModel.getId())) && (virtualImageGoodsFragment = this.v.get(Integer.valueOf(categoryModel.getId()))) != null) {
                virtualImageGoodsFragment.a(categoryModel);
            }
        }
    }

    public final VirtualImageFragment.ImageCallBack d() {
        return this.h;
    }

    public final void d(List<VirtualImageModel.CategoryModel> list) {
        Intrinsics.e(list, "newPackData");
        VirtualImagePackageFragment virtualImagePackageFragment = this.w;
        if (virtualImagePackageFragment == null) {
            return;
        }
        virtualImagePackageFragment.b(list);
    }

    public final void e() {
        DismissListener dismissListener = this.d;
        if (dismissListener == null) {
            return;
        }
        dismissListener.a();
    }

    public void m() {
        FragmentVirtualImageSelectBinding f = f();
        if (f != null) {
            ShapeHelper.b(f.l, 2131101502);
        }
        l();
        a(0);
        g();
        i();
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSelectFragment$f3Yz9dEbGrN4hpDyWwjEkwLv1yA
            @Override // java.lang.Runnable
            public final void run() {
                VirtualImageSelectFragment.l(VirtualImageSelectFragment.this);
            }
        }, 300L);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageSelectFragment$1SGXl1mdpPuo_2MFsh2R1SwtbCY
            @Override // java.lang.Runnable
            public final void run() {
                VirtualImageSelectFragment.m(VirtualImageSelectFragment.this);
            }
        }, 500L);
    }

    public void o() {
    }

    public void onResume() {
        VirtualImageFragment.ImageCallBack imageCallBack;
        super.onResume();
        if (this.t && (imageCallBack = this.h) != null) {
            imageCallBack.d();
        }
        this.t = false;
    }
}
