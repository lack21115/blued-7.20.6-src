package com.soft.blued.ui.user.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.net.wifi.WifiEnterpriseConfig;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewbinding.ViewBinding;
import com.anythink.expressad.a;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragmentActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.interfaces.SimpleCallback;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.ImageUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeRelativeLayout;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.base.mvi.UiEvent;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.extensions.BluedViewExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.PermissionUtils;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.android.module.live_china.click.SingleClickProxy;
import com.blued.das.live.LiveProtos;
import com.blued.das.profile.PersonalProfileProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.FmVirtualImageBinding;
import com.soft.blued.log.track.EventTrackPersonalProfile;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.user.fragment.VirtualImageFragment;
import com.soft.blued.ui.user.fragment.VirtualImageSelectFragment;
import com.soft.blued.ui.user.fragment.VirtualImageShareDialogFragment;
import com.soft.blued.ui.user.model.VirtualImageModel;
import com.soft.blued.ui.user.pop.VirtualImageDoubleTapGuide;
import com.soft.blued.ui.user.state.VirtualImageAction;
import com.soft.blued.ui.user.state.VirtualImageEvent;
import com.soft.blued.ui.user.state.VirtualImageState;
import com.soft.blued.ui.user.utils.VirtualImageUtils;
import com.soft.blued.ui.user.vm.VirtualImageVM;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VirtualImageFragment.class */
public final class VirtualImageFragment extends MVIBaseFragment<VirtualImageVM> {
    private final ViewBindingProperty d;
    private List<VirtualImageModel.CategoryModel> e;
    private List<VirtualImageModel.CategoryModel> f;
    private final VirtualImageUtils g;
    private VirtualImageSelectFragment h;
    private int i;
    private String j;
    private int k;
    private boolean l;
    private boolean m;
    private BackListener n;
    private final int o;

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f20492c = {(KProperty) Reflection.a(new PropertyReference1Impl(VirtualImageFragment.class, "vb", "getVb()Lcom/soft/blued/databinding/FmVirtualImageBinding;", 0))};
    public static final Companion b = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VirtualImageFragment$BackListener.class */
    public interface BackListener {
        void a();
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VirtualImageFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context) {
            TerminalActivity.d(context, VirtualImageFragment.class, TerminalActivity.a(new Bundle()));
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/fragment/VirtualImageFragment$ImageCallBack.class */
    public interface ImageCallBack {
        void a();

        void a(int i);

        void a(int i, VirtualImageModel.ImageGoodsModel imageGoodsModel);

        void a(ImageView imageView, VirtualImageModel.ImageGoodsModel imageGoodsModel);

        void b();

        void c();

        void d();

        void e();
    }

    public VirtualImageFragment() {
        super((int) R.layout.fm_virtual_image);
        this.d = ((Fragment) this) instanceof DialogFragment ? (ViewBindingProperty) new DialogFragmentViewBindingProperty(new Function1<VirtualImageFragment, FmVirtualImageBinding>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$special$$inlined$viewBindingFragment$default$1
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/user/fragment/VirtualImageFragment;)Lcom/soft/blued/databinding/FmVirtualImageBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmVirtualImageBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<VirtualImageFragment, FmVirtualImageBinding>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$special$$inlined$viewBindingFragment$default$2
            /* JADX WARN: Incorrect types in method signature: (Lcom/soft/blued/ui/user/fragment/VirtualImageFragment;)Lcom/soft/blued/databinding/FmVirtualImageBinding; */
            /* renamed from: a */
            public final ViewBinding invoke(Fragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FmVirtualImageBinding.a(fragment.requireView());
            }
        });
        this.g = new VirtualImageUtils();
        this.i = 1;
        this.j = UserInfo.getInstance().getLoginUserInfo().uid;
        this.o = 300000;
    }

    private final Bitmap a(View view) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight() - DensityUtils.a(getContext(), 100.0f), Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            return createBitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(PointF pointF) {
        final ImageView imageView;
        FmVirtualImageBinding b2 = b();
        if (b2 == null || (imageView = b2.j) == null) {
            return;
        }
        imageView.setX(pointF.x - BluedViewExtKt.a(61));
        imageView.setY(pointF.y - BluedViewExtKt.a(65));
        imageView.setVisibility(0);
        ImageLoader.c(getFragmentActive(), "anim_virtual_image_guide_nudge.png").f().a(new ImageLoader.OnAnimationStateListener() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$playDoubleTapAnim$1$1
            public void a() {
            }

            public void b() {
                imageView.setVisibility(8);
            }
        }).a(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final VirtualImageFragment virtualImageFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageFragment, "this$0");
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_VIRTUAL_PAGE_SHARE_CLICK);
        PermissionUtils.f(new PermissionCallbacks() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$initView$1$1$1
            public void U_() {
                VirtualImageFragment.this.p();
            }

            public void a(String[] strArr) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FmVirtualImageBinding b() {
        return (FmVirtualImageBinding) this.d.b(this, f20492c[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(int i) {
        Long au = BluedPreferences.au(this.j);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < au.longValue() + this.o) {
            ToastUtils.b((int) R.string.user_virtual_image_in_5_minutes);
            return;
        }
        BluedPreferences.a(this.j, currentTimeMillis);
        EventTrackPersonalProfile.b(PersonalProfileProtos.Event.PERSONAL_VIRTUAL_PAGE_CLICK, this.j);
        long a2 = StringUtils.a(this.j, 0L);
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = getString(i);
        Intrinsics.c(string, "getString(stringId)");
        String format = String.format(string, Arrays.copyOf(new Object[]{UserInfo.getInstance().getLoginUserInfo().name}, 1));
        Intrinsics.c(format, "format(format, *args)");
        ChatHelperV4.a().c(ChatHelper.getChattingModelForSendmsg(a2, (short) 256, format, ChatHelperV4.a().b(), "", (short) 2), "", "", 0, 0, 0, 0, 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VirtualImageFragment virtualImageFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageFragment, "this$0");
        EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_VIRTUAL_PAGE_EDIT_CLICK);
        virtualImageFragment.d();
    }

    private final void c() {
        FmVirtualImageBinding b2 = b();
        if (b2 == null) {
            return;
        }
        if (Intrinsics.a(this.j, UserInfo.getInstance().getLoginUserInfo().uid)) {
            b2.b.setVisibility(8);
            b2.n.setVisibility(0);
            b2.f15083c.setVisibility(0);
            b2.e.setVisibility(0);
        } else {
            b2.b.setVisibility(0);
            b2.n.setVisibility(8);
            b2.f15083c.setVisibility(8);
            b2.e.setVisibility(8);
        }
        if (this.l) {
            b2.e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(int i) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        XPopup.Builder a2 = new XPopup.Builder(context).a(new SimpleCallback() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$showGuidePop$1$1
            public void c(BasePopupView basePopupView) {
                Intrinsics.e(basePopupView, "popupView");
                super.c(basePopupView);
            }

            public void d(BasePopupView basePopupView) {
                Intrinsics.e(basePopupView, "popupView");
                super.d(basePopupView);
            }
        });
        IRequestHost fragmentActive = getFragmentActive();
        Intrinsics.c(fragmentActive, "fragmentActive");
        a2.a(new VirtualImageDoubleTapGuide(context, i, fragmentActive)).h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(VirtualImageFragment virtualImageFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageFragment, "this$0");
        virtualImageFragment.onBackPressed();
    }

    private final void d() {
        List<VirtualImageModel.CategoryModel> list = this.e;
        boolean z = false;
        if (list == null || list.isEmpty()) {
            BluedStructureExtKt.a(this, VirtualImageAction.GetImageCategory.f20626a);
            return;
        }
        VirtualImageFragment virtualImageFragment = this;
        BluedStructureExtKt.a(virtualImageFragment, VirtualImageAction.GetBeanCount.f20624a);
        BluedStructureExtKt.a(virtualImageFragment, VirtualImageAction.GetMarketingPicture.f20627a);
        if (getContext() == null) {
            return;
        }
        final VirtualImageSelectFragment virtualImageSelectFragment = new VirtualImageSelectFragment();
        this.h = virtualImageSelectFragment;
        if (virtualImageSelectFragment != null) {
            virtualImageSelectFragment.a(new VirtualImageSelectFragment.DismissListener() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$showSelectDialog$1$1$1
                @Override // com.soft.blued.ui.user.fragment.VirtualImageSelectFragment.DismissListener
                public void a() {
                    FmVirtualImageBinding b2;
                    VirtualImageFragment.this.g();
                    b2 = VirtualImageFragment.this.b();
                    FrameLayout frameLayout = b2 == null ? null : b2.e;
                    if (frameLayout != null) {
                        frameLayout.setVisibility(0);
                    }
                    VirtualImageFragment.this.getChildFragmentManager().beginTransaction().remove((Fragment) virtualImageSelectFragment).commitAllowingStateLoss();
                    BaseFragmentActivity activity = virtualImageSelectFragment.getActivity();
                    BaseFragmentActivity baseFragmentActivity = null;
                    if (activity instanceof BaseFragmentActivity) {
                        baseFragmentActivity = activity;
                    }
                    if (baseFragmentActivity == null) {
                        return;
                    }
                    baseFragmentActivity.a(VirtualImageFragment.this);
                }
            });
            List<VirtualImageModel.CategoryModel> list2 = this.e;
            ArrayList arrayList = list2;
            if (list2 == null) {
                arrayList = new ArrayList();
            }
            virtualImageSelectFragment.a(arrayList);
            List<VirtualImageModel.CategoryModel> list3 = this.f;
            ArrayList arrayList2 = list3;
            if (list3 == null) {
                arrayList2 = new ArrayList();
            }
            virtualImageSelectFragment.b(arrayList2);
            virtualImageSelectFragment.a(this.g);
            virtualImageSelectFragment.a(e());
            if (this.k == 1) {
                z = true;
            }
            virtualImageSelectFragment.a(z);
        }
        VirtualImageSelectFragment virtualImageSelectFragment2 = this.h;
        if (virtualImageSelectFragment2 != null) {
            getChildFragmentManager().beginTransaction().add(R.id.fl_select_goods_layout, (Fragment) virtualImageSelectFragment2, "virtualImageSelect").commitAllowingStateLoss();
        }
        FmVirtualImageBinding b2 = b();
        FrameLayout frameLayout = b2 == null ? null : b2.e;
        if (frameLayout == null) {
            return;
        }
        frameLayout.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(VirtualImageFragment virtualImageFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageFragment, "this$0");
        BluedStructureExtKt.a(virtualImageFragment, VirtualImageAction.GetImageCategory.f20626a);
    }

    private final ImageCallBack e() {
        return new ImageCallBack() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$getImageCallback$1
            @Override // com.soft.blued.ui.user.fragment.VirtualImageFragment.ImageCallBack
            public void a() {
            }

            @Override // com.soft.blued.ui.user.fragment.VirtualImageFragment.ImageCallBack
            public void a(int i) {
                int i2;
                i2 = VirtualImageFragment.this.i;
                if (i2 != i) {
                    if (i == 0) {
                        VirtualImageFragment.this.f();
                    } else if (i != 2) {
                    } else {
                        VirtualImageFragment.this.h();
                    }
                }
            }

            @Override // com.soft.blued.ui.user.fragment.VirtualImageFragment.ImageCallBack
            public void a(int i, VirtualImageModel.ImageGoodsModel imageGoodsModel) {
                FmVirtualImageBinding b2;
                VirtualImageUtils virtualImageUtils;
                Intrinsics.e(imageGoodsModel, "good");
                b2 = VirtualImageFragment.this.b();
                if (b2 == null) {
                    return;
                }
                VirtualImageFragment virtualImageFragment = VirtualImageFragment.this;
                virtualImageUtils = virtualImageFragment.g;
                FrameLayout frameLayout = b2.g;
                Intrinsics.c(frameLayout, "it.fmImage");
                ActivityFragmentActive fragmentActive = virtualImageFragment.getFragmentActive();
                Intrinsics.c(fragmentActive, "fragmentActive");
                virtualImageUtils.selectedGood(imageGoodsModel, frameLayout, (IRequestHost) fragmentActive);
            }

            @Override // com.soft.blued.ui.user.fragment.VirtualImageFragment.ImageCallBack
            public void a(ImageView imageView, VirtualImageModel.ImageGoodsModel imageGoodsModel) {
                VirtualImageUtils virtualImageUtils;
                Intrinsics.e(imageView, a.B);
                Intrinsics.e(imageGoodsModel, "good");
                virtualImageUtils = VirtualImageFragment.this.g;
                ActivityFragmentActive fragmentActive = VirtualImageFragment.this.getFragmentActive();
                Intrinsics.c(fragmentActive, "fragmentActive");
                virtualImageUtils.loadGoodIcon(imageView, imageGoodsModel, (IRequestHost) fragmentActive);
            }

            @Override // com.soft.blued.ui.user.fragment.VirtualImageFragment.ImageCallBack
            public void b() {
                VirtualImageUtils virtualImageUtils;
                VirtualImageUtils virtualImageUtils2;
                VirtualImageFragment.this.k = 1;
                PersonalProfileProtos.Event event = PersonalProfileProtos.Event.PERSONAL_VIRTUAL_EDIT_PAGE_SAVE_CLICK;
                virtualImageUtils = VirtualImageFragment.this.g;
                EventTrackPersonalProfile.a(event, virtualImageUtils.getChangeGoodIdsString());
                VirtualImageFragment virtualImageFragment = VirtualImageFragment.this;
                virtualImageUtils2 = virtualImageFragment.g;
                BluedStructureExtKt.a(virtualImageFragment, new VirtualImageAction.Save(virtualImageUtils2.getSelectedGoodsJsonString()));
            }

            @Override // com.soft.blued.ui.user.fragment.VirtualImageFragment.ImageCallBack
            public void c() {
                BluedStructureExtKt.a(VirtualImageFragment.this, VirtualImageAction.GetImageCategory.f20626a);
            }

            @Override // com.soft.blued.ui.user.fragment.VirtualImageFragment.ImageCallBack
            public void d() {
                BluedStructureExtKt.a(VirtualImageFragment.this, VirtualImageAction.GetBeanCount.f20624a);
            }

            @Override // com.soft.blued.ui.user.fragment.VirtualImageFragment.ImageCallBack
            public void e() {
                VirtualImageFragment.this.k = 0;
                BluedStructureExtKt.a(VirtualImageFragment.this, VirtualImageAction.GetImageCategory.f20626a);
                VirtualImageFragment.BackListener a2 = VirtualImageFragment.this.a();
                if (a2 == null) {
                    return;
                }
                a2.a();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(VirtualImageFragment virtualImageFragment, View view) {
        Tracker.onClick(view);
        Intrinsics.e(virtualImageFragment, "this$0");
        b.a(virtualImageFragment.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        this.i = 0;
        FmVirtualImageBinding b2 = b();
        if (b2 == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        float a2 = ((AppInfo.m - BluedViewExtKt.a(320)) - BluedViewExtKt.a(40)) / BluedViewExtKt.a((int) LiveProtos.Event.LIVE_NOBLE_MSG_GO_CLICK_VALUE);
        Log.e("xxx", Intrinsics.a("toSmallAnim scale=", Float.valueOf(a2)));
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b2.g, "ScaleX", a2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(b2.g, "ScaleY", a2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(b2.g, "translationY", BluedViewExtKt.a(-60));
        ofFloat.setDuration(300L);
        ofFloat2.setDuration(300L);
        ofFloat3.setDuration(300L);
        animatorSet.play(ofFloat3).with(ofFloat2).with(ofFloat);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g() {
        this.i = 1;
        FmVirtualImageBinding b2 = b();
        if (b2 == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b2.g, "ScaleX", 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(b2.g, "ScaleY", 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(b2.g, "translationY", 0.0f);
        ofFloat.setDuration(300L);
        ofFloat2.setDuration(300L);
        ofFloat3.setDuration(300L);
        animatorSet.play(ofFloat3).with(ofFloat2).with(ofFloat);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        this.i = 2;
        FmVirtualImageBinding b2 = b();
        if (b2 == null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        float min = Math.min(2.8f, (AppInfo.m - BluedViewExtKt.a(320)) / (BluedViewExtKt.a((int) LiveProtos.Event.LIVE_NOBLE_MSG_GO_CLICK_VALUE) * 0.3f));
        float y = b2.g.getY();
        float a2 = ((BluedViewExtKt.a((int) LiveProtos.Event.LIVE_NOBLE_MSG_GO_CLICK_VALUE) * min) - b2.g.getHeight()) / 2;
        float a3 = BluedViewExtKt.a(40);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(b2.g, "ScaleX", min);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(b2.g, "ScaleY", min);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(b2.g, "translationY", -((y - a2) + a3));
        ofFloat.setDuration(300L);
        ofFloat2.setDuration(300L);
        ofFloat3.setDuration(300L);
        animatorSet.play(ofFloat3).with(ofFloat2).with(ofFloat);
        animatorSet.start();
    }

    private final void i() {
        if (Intrinsics.a(this.j, UserInfo.getInstance().getLoginUserInfo().uid) || BluedPreferences.fq()) {
            return;
        }
        c(1);
        BluedPreferences.ad(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(VirtualImageFragment virtualImageFragment) {
        Intrinsics.e(virtualImageFragment, "this$0");
        virtualImageFragment.m = false;
    }

    private final void j() {
        FmVirtualImageBinding b2;
        final View view;
        if (BluedPreferences.fr() || (b2 = b()) == null || (view = b2.p) == null) {
            return;
        }
        view.setVisibility(0);
        BluedViewExtKt.a(view, new Function1<View, Unit>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$initDoubleTapsGuide$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void a(View view2) {
                Intrinsics.e(view2, "it");
                view.setVisibility(8);
                this.c(2);
                BluedPreferences.ae(true);
            }

            public /* synthetic */ Object invoke(Object obj) {
                a((View) obj);
                return Unit.a;
            }
        });
    }

    private final void l() {
        NoDataAndLoadFailView noDataAndLoadFailView;
        FmVirtualImageBinding b2 = b();
        if (b2 == null || (noDataAndLoadFailView = b2.l) == null) {
            return;
        }
        noDataAndLoadFailView.d();
    }

    private final void n() {
        NoDataAndLoadFailView noDataAndLoadFailView;
        FmVirtualImageBinding b2 = b();
        if (b2 == null || (noDataAndLoadFailView = b2.l) == null) {
            return;
        }
        noDataAndLoadFailView.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        ConstraintLayout constraintLayout;
        Bitmap a2;
        Context context = getContext();
        if (context == null) {
            return;
        }
        FmVirtualImageBinding b2 = b();
        RelativeLayout relativeLayout = b2 == null ? null : b2.n;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        FmVirtualImageBinding b3 = b();
        ShapeRelativeLayout shapeRelativeLayout = b3 == null ? null : b3.f15083c;
        if (shapeRelativeLayout != null) {
            shapeRelativeLayout.setVisibility(8);
        }
        FmVirtualImageBinding b4 = b();
        RelativeLayout relativeLayout2 = b4 == null ? null : b4.b;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        FmVirtualImageBinding b5 = b();
        FrameLayout frameLayout = b5 == null ? null : b5.e;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        FmVirtualImageBinding b6 = b();
        if (b6 == null || (constraintLayout = b6.h) == null || (a2 = a(constraintLayout)) == null) {
            return;
        }
        String a3 = a(a2);
        Bundle bundle = new Bundle();
        a2.recycle();
        c();
        FmVirtualImageBinding b7 = b();
        FrameLayout frameLayout2 = b7 == null ? null : b7.e;
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(0);
        }
        bundle.putString("user_face", a3);
        VirtualImageShareDialogFragment.Companion companion = VirtualImageShareDialogFragment.f20529a;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.core.ui.BaseFragmentActivity");
        }
        companion.a(context, (BaseFragmentActivity) activity, bundle);
    }

    private final void q() {
        FmVirtualImageBinding b2 = b();
        if (b2 == null) {
            return;
        }
        View view = b2.q;
        Intrinsics.c(view, "vHeader");
        BluedViewExtKt.a(view, new Function2<View, PointF, Unit>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$initDoubleTapLayer$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void a(View view2, PointF pointF) {
                Intrinsics.e(view2, "$noName_0");
                Intrinsics.e(pointF, "p");
                VirtualImageFragment.this.a(pointF);
                VirtualImageFragment.this.b((int) R.string.user_virtual_image_click_header);
            }

            public /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((View) obj, (PointF) obj2);
                return Unit.a;
            }
        });
        View view2 = b2.u;
        Intrinsics.c(view2, "vUpperBody");
        BluedViewExtKt.a(view2, new Function2<View, PointF, Unit>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$initDoubleTapLayer$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void a(View view3, PointF pointF) {
                Intrinsics.e(view3, "$noName_0");
                Intrinsics.e(pointF, "p");
                VirtualImageFragment.this.a(pointF);
                VirtualImageFragment.this.b((int) R.string.user_virtual_image_click_upper_body);
            }

            public /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((View) obj, (PointF) obj2);
                return Unit.a;
            }
        });
        View view3 = b2.s;
        Intrinsics.c(view3, "vLowerBody");
        BluedViewExtKt.a(view3, new Function2<View, PointF, Unit>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$initDoubleTapLayer$1$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void a(View view4, PointF pointF) {
                Intrinsics.e(view4, "$noName_0");
                Intrinsics.e(pointF, "p");
                VirtualImageFragment.this.a(pointF);
                VirtualImageFragment.this.b((int) R.string.user_virtual_image_click_lower_body);
            }

            public /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((View) obj, (PointF) obj2);
                return Unit.a;
            }
        });
        View view4 = b2.r;
        Intrinsics.c(view4, "vLeftArm");
        BluedViewExtKt.a(view4, new Function2<View, PointF, Unit>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$initDoubleTapLayer$1$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void a(View view5, PointF pointF) {
                Intrinsics.e(view5, "$noName_0");
                Intrinsics.e(pointF, "p");
                VirtualImageFragment.this.a(pointF);
                VirtualImageFragment.this.b((int) R.string.user_virtual_image_click_arm);
            }

            public /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((View) obj, (PointF) obj2);
                return Unit.a;
            }
        });
        View view5 = b2.t;
        Intrinsics.c(view5, "vRightArm");
        BluedViewExtKt.a(view5, new Function2<View, PointF, Unit>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$initDoubleTapLayer$1$5
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final void a(View view6, PointF pointF) {
                Intrinsics.e(view6, "$noName_0");
                Intrinsics.e(pointF, "p");
                VirtualImageFragment.this.a(pointF);
                VirtualImageFragment.this.b((int) R.string.user_virtual_image_click_arm);
            }

            public /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((View) obj, (PointF) obj2);
                return Unit.a;
            }
        });
    }

    public final BackListener a() {
        return this.n;
    }

    public final String a(Bitmap bitmap) {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String str = externalStoragePublicDirectory.getAbsolutePath() + ((Object) File.separator) + "blued";
        if (bitmap != null) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            if (Intrinsics.a(Environment.MEDIA_MOUNTED, Environment.getExternalStorageState())) {
                String str2 = str;
                if (str == null) {
                    File externalStoragePublicDirectory2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                    str2 = externalStoragePublicDirectory2.getAbsolutePath() + ((Object) File.separator) + "blued";
                }
                String str3 = str2 + ((Object) File.separator) + valueOf;
                if (Build.VERSION.SDK_INT >= 29 && !Environment.isExternalStorageLegacy()) {
                    ImageUtils.a(bitmap, valueOf, Intrinsics.a(Environment.DIRECTORY_PICTURES, "/blued"), 100, false);
                    return str3;
                }
                ImageUtils.b(bitmap, str3, 100, false);
                AppUtils.a(AppInfo.d(), str3, false);
                return str3;
            }
            return "";
        }
        return "";
    }

    public final void a(int i) {
        FmVirtualImageBinding b2 = b();
        FrameLayout frameLayout = b2 == null ? null : b2.e;
        if (frameLayout != null) {
            frameLayout.setVisibility(i);
        }
        if (i == 0) {
            i();
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (BluedSkinUtils.c()) {
                StatusBarHelper.a(activity, true);
            } else {
                StatusBarHelper.a(activity, false);
            }
        }
    }

    public final void a(BackListener backListener) {
        this.n = backListener;
    }

    public final void a(boolean z) {
        this.m = z;
        if (z) {
            postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageFragment$J1xYn2aFnId1cqoCYJjqFDv4IOU
                @Override // java.lang.Runnable
                public final void run() {
                    VirtualImageFragment.i(VirtualImageFragment.this);
                }
            }, 1000L);
        }
    }

    public void m() {
        int i = 0;
        if (BluedPreferences.ft()) {
            BluedPreferences.ad(false);
            BluedPreferences.ae(false);
            BluedPreferences.fs();
        }
        EventTrackPersonalProfile.d(PersonalProfileProtos.Event.PERSONAL_VIRTUAL_PAGE_SHOW, this.j);
        ((VirtualImageVM) y()).a(this.g);
        FmVirtualImageBinding b2 = b();
        if (b2 != null) {
            ImageLoader.a(getFragmentActive(), (int) R.drawable.virtual_image_bg).a(b2.k);
            b2.f15083c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageFragment$icfvoJLPkocFkQhN_yIY9J48_T4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VirtualImageFragment.a(VirtualImageFragment.this, view);
                }
            });
            b2.f15082a.setOnClickListener((View.OnClickListener) new SingleClickProxy(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageFragment$bH9SXSMEVb0fFAYwMlGaQgy1N3g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VirtualImageFragment.b(VirtualImageFragment.this, view);
                }
            }));
            b2.e.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageFragment$dnkKFeAPA5xCuE1Jl3izOg81lDo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VirtualImageFragment.c(VirtualImageFragment.this, view);
                }
            });
            b2.l.setNoDataImg(2131233635);
            b2.l.setNoDataStr((int) R.string.user_virtual_image_net_failed);
            ShapeHelper.b(b2.l.getBtn(), 2131102203);
            Context context = getContext();
            if (context != null) {
                b2.l.getBtn().setTextColor(ContextCompat.getColor(context, 2131102170));
            }
            b2.l.setFailBtnListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageFragment$U8k3eezdAnl8uuXpbsjbkwUJxM8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VirtualImageFragment.d(VirtualImageFragment.this, view);
                }
            });
            b2.l.getBtn().setText(getString(R.string.retry));
            b2.l.d();
            c();
            b2.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.user.fragment.-$$Lambda$VirtualImageFragment$InmNNJi5mg0fmbIK8_CFeGRiUJA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VirtualImageFragment.e(VirtualImageFragment.this, view);
                }
            });
            ConstraintLayout constraintLayout = b2.d;
            if (Intrinsics.a(this.j, UserInfo.getInstance().getLoginUserInfo().uid)) {
                i = 8;
            } else {
                q();
            }
            constraintLayout.setVisibility(i);
        }
        if (Intrinsics.a(this.j, UserInfo.getInstance().getLoginUserInfo().uid)) {
            BluedStructureExtKt.a(this, VirtualImageAction.GetImageCategory.f20626a);
            return;
        }
        String str = this.j;
        Intrinsics.c(str, "uid");
        BluedStructureExtKt.a(this, new VirtualImageAction.GetGuestImage(str));
        j();
    }

    public void o() {
        VirtualImageFragment virtualImageFragment = this;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner, "viewLifecycleOwner");
        BluedStructureExtKt.a(virtualImageFragment, viewLifecycleOwner, new MutablePropertyReference1Impl() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$liveDataObserver$1
            public Object a(Object obj) {
                return ((VirtualImageState) obj).getGuestGoodsList();
            }
        }, new Function1<List<? extends VirtualImageModel.GuestImageGoodsModel>, Unit>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$liveDataObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(List<VirtualImageModel.GuestImageGoodsModel> list) {
                FmVirtualImageBinding b2;
                VirtualImageUtils virtualImageUtils;
                Intrinsics.e(list, "data");
                b2 = VirtualImageFragment.this.b();
                if (b2 == null) {
                    return;
                }
                VirtualImageFragment virtualImageFragment2 = VirtualImageFragment.this;
                virtualImageUtils = virtualImageFragment2.g;
                FrameLayout frameLayout = b2.g;
                Intrinsics.c(frameLayout, "it.fmImage");
                ActivityFragmentActive fragmentActive = virtualImageFragment2.getFragmentActive();
                Intrinsics.c(fragmentActive, "fragmentActive");
                virtualImageUtils.initGuestImage(frameLayout, list, (IRequestHost) fragmentActive);
            }

            public /* synthetic */ Object invoke(Object obj) {
                a((List) obj);
                return Unit.a;
            }
        });
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner2, "viewLifecycleOwner");
        BluedStructureExtKt.a(virtualImageFragment, viewLifecycleOwner2, new MutablePropertyReference1Impl() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$liveDataObserver$3
            public Object a(Object obj) {
                return Integer.valueOf(((VirtualImageState) obj).getRedDot());
            }
        }, new Function1<Integer, Unit>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$liveDataObserver$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(int i) {
                FmVirtualImageBinding b2;
                b2 = VirtualImageFragment.this.b();
                if (b2 == null) {
                    return;
                }
                b2.o.setVisibility(i == 1 ? 0 : 8);
            }

            public /* synthetic */ Object invoke(Object obj) {
                a(((Number) obj).intValue());
                return Unit.a;
            }
        });
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner3, "viewLifecycleOwner");
        BluedStructureExtKt.a(virtualImageFragment, viewLifecycleOwner3, new MutablePropertyReference1Impl() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$liveDataObserver$5
            public Object a(Object obj) {
                return ((VirtualImageState) obj).getAllCategoriesList();
            }
        }, new Function1<List<? extends VirtualImageModel.CategoryModel>, Unit>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$liveDataObserver$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
                r0 = r3.f20506a.h;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void a(java.util.List<com.soft.blued.ui.user.model.VirtualImageModel.CategoryModel> r4) {
                /*
                    r3 = this;
                    r0 = r4
                    java.lang.String r1 = "it"
                    kotlin.jvm.internal.Intrinsics.e(r0, r1)
                    r0 = r3
                    com.soft.blued.ui.user.fragment.VirtualImageFragment r0 = com.soft.blued.ui.user.fragment.VirtualImageFragment.this
                    r1 = r4
                    com.soft.blued.ui.user.fragment.VirtualImageFragment.a(r0, r1)
                    r0 = r3
                    com.soft.blued.ui.user.fragment.VirtualImageFragment r0 = com.soft.blued.ui.user.fragment.VirtualImageFragment.this
                    com.soft.blued.ui.user.fragment.VirtualImageSelectFragment r0 = com.soft.blued.ui.user.fragment.VirtualImageFragment.f(r0)
                    r6 = r0
                    r0 = 0
                    r5 = r0
                    r0 = r6
                    if (r0 != 0) goto L1f
                    goto L29
                L1f:
                    r0 = r6
                    boolean r0 = r0.isVisible()
                    r1 = 1
                    if (r0 != r1) goto L29
                    r0 = 1
                    r5 = r0
                L29:
                    r0 = r5
                    if (r0 == 0) goto L3f
                    r0 = r3
                    com.soft.blued.ui.user.fragment.VirtualImageFragment r0 = com.soft.blued.ui.user.fragment.VirtualImageFragment.this
                    com.soft.blued.ui.user.fragment.VirtualImageSelectFragment r0 = com.soft.blued.ui.user.fragment.VirtualImageFragment.f(r0)
                    r6 = r0
                    r0 = r6
                    if (r0 != 0) goto L3a
                    return
                L3a:
                    r0 = r6
                    r1 = r4
                    r0.c(r1)
                L3f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.user.fragment.VirtualImageFragment$liveDataObserver$6.a(java.util.List):void");
            }

            public /* synthetic */ Object invoke(Object obj) {
                a((List) obj);
                return Unit.a;
            }
        });
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner4, "viewLifecycleOwner");
        BluedStructureExtKt.a(virtualImageFragment, viewLifecycleOwner4, new MutablePropertyReference1Impl() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$liveDataObserver$7
            public Object a(Object obj) {
                return ((VirtualImageState) obj).getAllPackageCategoriesList();
            }
        }, new Function1<List<? extends VirtualImageModel.CategoryModel>, Unit>() { // from class: com.soft.blued.ui.user.fragment.VirtualImageFragment$liveDataObserver$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
                r0 = r3.f20508a.h;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void a(java.util.List<com.soft.blued.ui.user.model.VirtualImageModel.CategoryModel> r4) {
                /*
                    r3 = this;
                    r0 = r4
                    java.lang.String r1 = "it"
                    kotlin.jvm.internal.Intrinsics.e(r0, r1)
                    r0 = r3
                    com.soft.blued.ui.user.fragment.VirtualImageFragment r0 = com.soft.blued.ui.user.fragment.VirtualImageFragment.this
                    r1 = r4
                    com.soft.blued.ui.user.fragment.VirtualImageFragment.b(r0, r1)
                    r0 = r3
                    com.soft.blued.ui.user.fragment.VirtualImageFragment r0 = com.soft.blued.ui.user.fragment.VirtualImageFragment.this
                    com.soft.blued.ui.user.fragment.VirtualImageSelectFragment r0 = com.soft.blued.ui.user.fragment.VirtualImageFragment.f(r0)
                    r6 = r0
                    r0 = 0
                    r5 = r0
                    r0 = r6
                    if (r0 != 0) goto L1f
                    goto L29
                L1f:
                    r0 = r6
                    boolean r0 = r0.isVisible()
                    r1 = 1
                    if (r0 != r1) goto L29
                    r0 = 1
                    r5 = r0
                L29:
                    r0 = r5
                    if (r0 == 0) goto L3f
                    r0 = r3
                    com.soft.blued.ui.user.fragment.VirtualImageFragment r0 = com.soft.blued.ui.user.fragment.VirtualImageFragment.this
                    com.soft.blued.ui.user.fragment.VirtualImageSelectFragment r0 = com.soft.blued.ui.user.fragment.VirtualImageFragment.f(r0)
                    r6 = r0
                    r0 = r6
                    if (r0 != 0) goto L3a
                    return
                L3a:
                    r0 = r6
                    r1 = r4
                    r0.d(r1)
                L3f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.user.fragment.VirtualImageFragment$liveDataObserver$8.a(java.util.List):void");
            }

            public /* synthetic */ Object invoke(Object obj) {
                a((List) obj);
                return Unit.a;
            }
        });
    }

    public boolean onBackPressed() {
        if (this.m) {
            return true;
        }
        if (this.l) {
            BackListener backListener = this.n;
            if (backListener == null) {
                return true;
            }
            backListener.a();
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return true;
        }
        activity.finish();
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            Bundle arguments = getArguments();
            if (arguments == null) {
                return;
            }
            if (arguments.containsKey(WifiEnterpriseConfig.PRIVATE_KEY_ID_KEY)) {
                this.l = true;
            }
            Object obj = arguments.get(WifiEnterpriseConfig.PRIVATE_KEY_ID_KEY);
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            this.j = (String) obj;
            Object obj2 = arguments.get("saved_face");
            if (obj2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            this.k = ((Integer) obj2).intValue();
        } catch (Throwable th) {
        }
    }

    public void onEvent(UiEvent uiEvent) {
        VirtualImageSelectFragment virtualImageSelectFragment;
        Intrinsics.e(uiEvent, "event");
        if (uiEvent instanceof VirtualImageEvent.SaveEvent) {
            if (!((VirtualImageEvent.SaveEvent) uiEvent).a()) {
                ToastUtils.b(getString(R.string.user_virtual_image_save_failed));
                return;
            }
            ToastUtils.b(getString(R.string.user_virtual_image_save_succeed));
            VirtualImageSelectFragment virtualImageSelectFragment2 = this.h;
            if (virtualImageSelectFragment2 != null) {
                virtualImageSelectFragment2.e();
            }
            this.g.updateRawGoodsIds();
            BluedStructureExtKt.a(this, VirtualImageAction.GetImageCategory.f20626a);
        } else if (uiEvent instanceof VirtualImageEvent.BeanCount) {
            VirtualImageSelectFragment virtualImageSelectFragment3 = this.h;
            if (virtualImageSelectFragment3 == null) {
                return;
            }
            virtualImageSelectFragment3.a((int) ((VirtualImageEvent.BeanCount) uiEvent).a());
        } else if (uiEvent instanceof VirtualImageEvent.ErrorEvent) {
            n();
        } else if (!(uiEvent instanceof VirtualImageEvent.GoodsEvent)) {
            if (!(uiEvent instanceof VirtualImageEvent.MarketingPictureEvent) || (virtualImageSelectFragment = this.h) == null) {
                return;
            }
            virtualImageSelectFragment.a(((VirtualImageEvent.MarketingPictureEvent) uiEvent).a());
        } else {
            l();
            FmVirtualImageBinding b2 = b();
            if (b2 == null) {
                return;
            }
            VirtualImageUtils virtualImageUtils = this.g;
            FrameLayout frameLayout = b2.g;
            Intrinsics.c(frameLayout, "it.fmImage");
            List<VirtualImageModel.ImageGoodsModel> a2 = ((VirtualImageEvent.GoodsEvent) uiEvent).a();
            ActivityFragmentActive fragmentActive = getFragmentActive();
            Intrinsics.c(fragmentActive, "fragmentActive");
            virtualImageUtils.initImage(frameLayout, a2, (IRequestHost) fragmentActive);
        }
    }
}
