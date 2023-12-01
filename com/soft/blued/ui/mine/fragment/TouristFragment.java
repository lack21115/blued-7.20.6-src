package com.soft.blued.ui.mine.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.core.utils.skin.listener.BluedSkinObserver;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.base.mvi.MVIBaseFragment;
import com.blued.android.module.common.extensions.BluedStructureExtKt;
import com.blued.android.module.common.extensions.DialogFragmentViewBindingProperty;
import com.blued.android.module.common.extensions.FragmentViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.blued.android.module.common.view.ObservableScrollView;
import com.blued.login.fragment.LoginMainFragment;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.FragmentTouristBinding;
import com.soft.blued.databinding.ItemMineHealthEntryBinding;
import com.soft.blued.databinding.ItemMineHealthyBannerBinding;
import com.soft.blued.databinding.ItemMineNewHealthEntryBinding;
import com.soft.blued.databinding.ItemMineZhealthEntryBinding;
import com.soft.blued.ui.mine.model.MinePageModel;
import com.soft.blued.ui.mine.state.TouristAction;
import com.soft.blued.ui.mine.state.TouristState;
import com.soft.blued.ui.mine.vm.TouristVM;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.BluedPreferences;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import skin.support.SkinCompatManager;
import skin.support.observe.SkinObservable;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/TouristFragment.class */
public final class TouristFragment extends MVIBaseFragment<TouristVM> implements View.OnClickListener, BluedSkinObserver {
    private final ViewBindingProperty d;

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f31630c = {Reflection.a(new PropertyReference1Impl(TouristFragment.class, "viewBinding", "getViewBinding()Lcom/soft/blued/databinding/FragmentTouristBinding;", 0))};
    public static final Companion b = new Companion(null);

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/TouristFragment$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public TouristFragment() {
        super(R.layout.fragment_tourist);
        this.d = this instanceof DialogFragment ? new DialogFragmentViewBindingProperty(new Function1<TouristFragment, FragmentTouristBinding>() { // from class: com.soft.blued.ui.mine.fragment.TouristFragment$special$$inlined$viewBindingFragment$default$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentTouristBinding invoke(TouristFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentTouristBinding.a(fragment.requireView());
            }
        }) : new FragmentViewBindingProperty(new Function1<TouristFragment, FragmentTouristBinding>() { // from class: com.soft.blued.ui.mine.fragment.TouristFragment$special$$inlined$viewBindingFragment$default$2
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final FragmentTouristBinding invoke(TouristFragment fragment) {
                Intrinsics.e(fragment, "fragment");
                return FragmentTouristBinding.a(fragment.requireView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentTouristBinding a() {
        return (FragmentTouristBinding) this.d.b(this, f31630c[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View view) {
        Tracker.onClick(view);
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
    public static final void a(TouristFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TouristFragment this$0, ObservableScrollView observableScrollView, int i, int i2, int i3, int i4) {
        Intrinsics.e(this$0, "this$0");
        int a2 = DensityUtils.a(this$0.getContext(), 72.0f);
        if (i2 >= a2) {
            FragmentTouristBinding a3 = this$0.a();
            FrameLayout frameLayout = a3 == null ? null : a3.W;
            if (frameLayout != null) {
                frameLayout.setAlpha(1.0f);
            }
            FragmentTouristBinding a4 = this$0.a();
            LinearLayout linearLayout = a4 == null ? null : a4.R;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setAlpha(1.0f);
            return;
        }
        float f = i2 / a2;
        FragmentTouristBinding a5 = this$0.a();
        FrameLayout frameLayout2 = a5 == null ? null : a5.W;
        if (frameLayout2 != null) {
            frameLayout2.setAlpha(f);
        }
        FragmentTouristBinding a6 = this$0.a();
        LinearLayout linearLayout2 = a6 == null ? null : a6.R;
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setAlpha(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TouristFragment this$0, MinePageModel.ColumnsItem columnsItem, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.a(columnsItem.url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TouristFragment this$0, MinePageModel.ColumnsItem columnsItem, ItemMineZhealthEntryBinding zhealthyItemVB, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(zhealthyItemVB, "$zhealthyItemVB");
        this$0.a(columnsItem.item.get(0).url);
        zhealthyItemVB.b.setVisibility(8);
        BluedPreferences.Q(columnsItem.item.get(0).item_key);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(MinePageModel.HealthItem healthItem) {
        ShapeLinearLayout shapeLinearLayout;
        ShapeLinearLayout shapeLinearLayout2;
        ShapeLinearLayout shapeLinearLayout3;
        if (healthItem == null) {
            FragmentTouristBinding a2 = a();
            LinearLayout linearLayout = a2 == null ? null : a2.w;
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
        FragmentTouristBinding a3 = a();
        LinearLayout linearLayout2 = a3 == null ? null : a3.w;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        FragmentTouristBinding a4 = a();
        if (a4 != null && (shapeLinearLayout3 = a4.x) != null) {
            shapeLinearLayout3.removeAllViews();
        }
        MinePageModel.ColumnsItem columnsItem = healthItem.left;
        ItemMineNewHealthEntryBinding a5 = ItemMineNewHealthEntryBinding.a(inflate);
        Intrinsics.c(a5, "bind(rootView)");
        a5.d.setText(columnsItem.title);
        a5.f29234c.setVisibility(8);
        a5.f29233a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$TouristFragment$oSE3oztf7lnjpis4X-g01CGmsZo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TouristFragment.e(TouristFragment.this, view);
            }
        });
        a5.b.removeAllViews();
        int size = columnsItem.item.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                break;
            }
            View inflate2 = getLayoutInflater().inflate(R.layout.item_mine_health_entry, (ViewGroup) null);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -1);
            layoutParams2.weight = 1.0f;
            if (i2 != 0) {
                layoutParams2.leftMargin = DensityUtils.a(getContext(), 5.0f);
            }
            inflate2.setLayoutParams(layoutParams2);
            ItemMineHealthEntryBinding a6 = ItemMineHealthEntryBinding.a(inflate2);
            Intrinsics.c(a6, "bind(rootItemView)");
            a6.g.setText(columnsItem.item.get(i2).title);
            a6.f.setText(columnsItem.item.get(i2).recommend_text);
            if (columnsItem.item.get(i2).is_highlight == 1) {
                a6.f.setTextColor(Color.parseColor("#00CCCC"));
            } else {
                a6.f.setTextColor(BluedSkinUtils.a(getContext(), 2131101625));
            }
            ImageLoader.a(getFragmentActive(), columnsItem.item.get(i2).icon1).a(a6.f29224c);
            a5.b.addView(inflate2);
            a6.b.setVisibility(8);
            TextView textView = a6.g;
            Intrinsics.c(textView, "healthyItemVB.tvTitle");
            a(textView, columnsItem.item.get(i2).title_color);
            TextView textView2 = a6.f;
            Intrinsics.c(textView2, "healthyItemVB.tvDes");
            a(textView2, columnsItem.item.get(i2).content_color);
            a6.f29223a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$TouristFragment$-HFPGMpikCW7DPARQRnvC1j4A-A
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TouristFragment.f(TouristFragment.this, view);
                }
            });
            i = i2 + 1;
        }
        FragmentTouristBinding a7 = a();
        if (a7 != null && (shapeLinearLayout2 = a7.x) != null) {
            shapeLinearLayout2.addView(inflate);
        }
        View inflate3 = getLayoutInflater().inflate(R.layout.item_mine_new_health_entry, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -1);
        layoutParams3.weight = 1.0f;
        inflate3.setLayoutParams(layoutParams3);
        final MinePageModel.ColumnsItem columnsItem2 = healthItem.right;
        ItemMineNewHealthEntryBinding a8 = ItemMineNewHealthEntryBinding.a(inflate3);
        Intrinsics.c(a8, "bind(zhealthView)");
        a8.d.setText(columnsItem2.title);
        a8.f29234c.setVisibility(0);
        a8.f29233a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$TouristFragment$cwE5AHBxChT5WTef6523FeoCLes
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TouristFragment.a(TouristFragment.this, columnsItem2, view);
            }
        });
        a8.b.removeAllViews();
        View inflate4 = getLayoutInflater().inflate(R.layout.item_mine_zhealth_entry, (ViewGroup) null);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -1);
        layoutParams4.weight = 1.0f;
        inflate4.setLayoutParams(layoutParams4);
        final ItemMineZhealthEntryBinding a9 = ItemMineZhealthEntryBinding.a(inflate4);
        Intrinsics.c(a9, "bind(zhealthItemView)");
        a9.g.setText(columnsItem2.item.get(0).title);
        a9.f.setText(columnsItem2.item.get(0).recommend_text);
        if (columnsItem2.item.get(0).is_highlight == 1) {
            a9.f.setTextColor(Color.parseColor("#00CCCC"));
        } else {
            a9.f.setTextColor(BluedSkinUtils.a(getContext(), 2131101625));
        }
        ImageLoader.a(getFragmentActive(), columnsItem2.item.get(0).icon1).a(a9.f29246c);
        ImageLoader.a(getFragmentActive(), columnsItem2.item.get(0).icon2).a(a9.d);
        a8.b.addView(inflate4);
        if (BluedPreferences.P(columnsItem2.item.get(0).item_key)) {
            a9.b.setVisibility(0);
        } else {
            a9.b.setVisibility(8);
        }
        TextView textView3 = a9.g;
        Intrinsics.c(textView3, "zhealthyItemVB.tvTitle");
        a(textView3, columnsItem2.item.get(0).title_color);
        TextView textView4 = a9.f;
        Intrinsics.c(textView4, "zhealthyItemVB.tvDes");
        a(textView4, columnsItem2.item.get(0).content_color);
        a9.f29245a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$TouristFragment$F4mF_0iYNbZimDfZwobayLiyBF4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TouristFragment.a(TouristFragment.this, columnsItem2, a9, view);
            }
        });
        FragmentTouristBinding a10 = a();
        if (a10 == null || (shapeLinearLayout = a10.x) == null) {
            return;
        }
        shapeLinearLayout.addView(inflate3);
    }

    private final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        WebViewShowInfoFragment.show(getContext(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(final List<? extends MinePageModel.ColumnsItem> list) {
        ViewFlipper viewFlipper;
        ViewFlipper viewFlipper2;
        ViewFlipper viewFlipper3;
        Animation inAnimation;
        ViewFlipper viewFlipper4;
        ViewFlipper viewFlipper5;
        if (list == null || list.isEmpty()) {
            FragmentTouristBinding a2 = a();
            ViewFlipper viewFlipper6 = a2 == null ? null : a2.al;
            if (viewFlipper6 == null) {
                return;
            }
            viewFlipper6.setVisibility(0);
            return;
        }
        FragmentTouristBinding a3 = a();
        ViewFlipper viewFlipper7 = a3 == null ? null : a3.al;
        if (viewFlipper7 != null) {
            viewFlipper7.setVisibility(0);
        }
        FragmentTouristBinding a4 = a();
        if (a4 != null && (viewFlipper5 = a4.al) != null) {
            viewFlipper5.removeAllViews();
        }
        for (MinePageModel.ColumnsItem columnsItem : list) {
            if (columnsItem != null) {
                View inflate = getLayoutInflater().inflate(R.layout.item_mine_healthy_banner, (ViewGroup) null);
                ItemMineHealthyBannerBinding a5 = ItemMineHealthyBannerBinding.a(inflate);
                Intrinsics.c(a5, "bind(bannerView)");
                a5.f29232c.setText(columnsItem.title);
                a5.b.setText(columnsItem.content);
                ImageLoader.a(getFragmentActive(), columnsItem.icon).a(a5.f29231a);
                TextView textView = a5.f29232c;
                Intrinsics.c(textView, "bannerVB.tvTitle");
                a(textView, columnsItem.title_color);
                TextView textView2 = a5.b;
                Intrinsics.c(textView2, "bannerVB.tvDes");
                a(textView2, columnsItem.content_color);
                a5.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$TouristFragment$deHiClnMX3ZL2FKXTpf0Nzf5Tb0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TouristFragment.g(TouristFragment.this, view);
                    }
                });
                FragmentTouristBinding a6 = a();
                if (a6 != null && (viewFlipper4 = a6.al) != null) {
                    viewFlipper4.addView(inflate);
                }
            }
        }
        FragmentTouristBinding a7 = a();
        if (a7 != null && (viewFlipper3 = a7.al) != null && (inAnimation = viewFlipper3.getInAnimation()) != null) {
            inAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.mine.fragment.TouristFragment$setHealthBannerEntry$2
                /* JADX WARN: Code restructure failed: missing block: B:4:0x0013, code lost:
                    r0 = r5.a();
                 */
                @Override // android.view.animation.Animation.AnimationListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onAnimationEnd(android.view.animation.Animation r4) {
                    /*
                        r3 = this;
                        r0 = r4
                        java.lang.String r1 = "animation"
                        kotlin.jvm.internal.Intrinsics.e(r0, r1)
                        r0 = r3
                        java.util.List<com.soft.blued.ui.mine.model.MinePageModel$ColumnsItem> r0 = r4
                        int r0 = r0.size()
                        r1 = 1
                        if (r0 > r1) goto L2e
                        r0 = r3
                        com.soft.blued.ui.mine.fragment.TouristFragment r0 = r5
                        com.soft.blued.databinding.FragmentTouristBinding r0 = com.soft.blued.ui.mine.fragment.TouristFragment.a(r0)
                        r4 = r0
                        r0 = r4
                        if (r0 != 0) goto L20
                        return
                    L20:
                        r0 = r4
                        android.widget.ViewFlipper r0 = r0.al
                        r4 = r0
                        r0 = r4
                        if (r0 != 0) goto L2a
                        return
                    L2a:
                        r0 = r4
                        r0.stopFlipping()
                    L2e:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.mine.fragment.TouristFragment$setHealthBannerEntry$2.onAnimationEnd(android.view.animation.Animation):void");
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
            FragmentTouristBinding a8 = a();
            if (a8 == null || (viewFlipper2 = a8.al) == null) {
                return;
            }
            viewFlipper2.startFlipping();
            return;
        }
        FragmentTouristBinding a9 = a();
        if (a9 == null || (viewFlipper = a9.al) == null) {
            return;
        }
        viewFlipper.stopFlipping();
    }

    private final void b() {
        ObservableScrollView observableScrollView;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        LinearLayout linearLayout;
        FragmentTouristBinding a2 = a();
        if (a2 != null && (linearLayout = a2.R) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$TouristFragment$AQ2JgivOeTAuhzQwmAFelP3RaLE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TouristFragment.a(view);
                }
            });
        }
        FragmentTouristBinding a3 = a();
        ImageView imageView5 = a3 == null ? null : a3.S;
        if (imageView5 != null) {
            imageView5.setVisibility(0);
        }
        FragmentTouristBinding a4 = a();
        if (a4 != null && (imageView4 = a4.S) != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$TouristFragment$Y9pENLB62vFkXrL86G5f1zTrdGQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TouristFragment.a(TouristFragment.this, view);
                }
            });
        }
        FragmentTouristBinding a5 = a();
        if (a5 != null && (imageView3 = a5.V) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$TouristFragment$lSwhr63MsSyShch52VB_mH4mZvI
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TouristFragment.b(TouristFragment.this, view);
                }
            });
        }
        FragmentTouristBinding a6 = a();
        if (a6 != null && (imageView2 = a6.T) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$TouristFragment$HZsmnWg5KAZcm3SVeJ1Kfok5trY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TouristFragment.c(TouristFragment.this, view);
                }
            });
        }
        FragmentTouristBinding a7 = a();
        if (a7 != null && (imageView = a7.V) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$TouristFragment$rNxD_9qsUvUrMwcM9HOB0AgGv04
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TouristFragment.d(TouristFragment.this, view);
                }
            });
        }
        FragmentTouristBinding a8 = a();
        if (a8 == null || (observableScrollView = a8.Q) == null) {
            return;
        }
        observableScrollView.setScrollViewListener(new ObservableScrollView.ScrollViewListener() { // from class: com.soft.blued.ui.mine.fragment.-$$Lambda$TouristFragment$5iOsytlrFoTjteonUIhcq8S9uYI
            @Override // com.blued.android.module.common.view.ObservableScrollView.ScrollViewListener
            public final void onScrollChanged(ObservableScrollView observableScrollView2, int i, int i2, int i3, int i4) {
                TouristFragment.a(TouristFragment.this, observableScrollView2, i, i2, i3, i4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(TouristFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.c();
    }

    private final void c() {
        TerminalActivity.d(getContext(), LoginMainFragment.class, null);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(TouristFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        WebViewShowInfoFragment.show(this$0.getContext(), "https://activity.blued.cn/activity-blued/work/hnaaydgt", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(TouristFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(TouristFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(TouristFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(TouristFragment this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.c();
    }

    @Override // skin.support.observe.SkinObserver
    public void a(SkinObservable skinObservable, Object obj) {
        StatusBarHelper.a((Activity) getActivity());
        StatusBarHelper.a(getActivity(), BluedSkinUtils.a(getContext(), AppInfo.k()));
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void m() {
        ImageView imageView;
        Resources resources;
        b();
        BluedStructureExtKt.a(this, TouristAction.GetData.f31642a);
        FragmentTouristBinding a2 = a();
        if (a2 == null) {
            return;
        }
        a2.g.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101780));
        a2.g.b(5.0f, true);
        a2.g.f10205a.a(BluedSkinUtils.a(getContext(), 2131101780), 1.0f, true);
        a2.u.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101780));
        a2.u.b(5.0f, true);
        a2.u.f10205a.a(BluedSkinUtils.a(getContext(), 2131101780), 1.0f, true);
        a2.f.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101780));
        a2.f.b(5.0f, true);
        a2.f.f10205a.a(BluedSkinUtils.a(getContext(), 2131101780), 1.0f, true);
        a2.O.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101780));
        a2.O.b(5.0f, true);
        a2.O.f10205a.a(BluedSkinUtils.a(getContext(), 2131101780), 1.0f, true);
        a2.P.setBackgroundColor(BluedSkinUtils.a(getContext(), 2131101780));
        a2.P.b(5.0f, true);
        a2.P.f10205a.a(BluedSkinUtils.a(getContext(), 2131101780), 1.0f, true);
        FragmentTouristBinding a3 = a();
        if (a3 != null && (imageView = a3.s) != null) {
            Context context = getContext();
            Drawable drawable = null;
            if (context != null && (resources = context.getResources()) != null) {
                drawable = resources.getDrawable(2131237327);
            }
            imageView.setImageDrawable(drawable);
        }
        ShapeTextView shapeTextView = a2.ad;
        TouristFragment touristFragment = this;
        shapeTextView.setOnClickListener(touristFragment);
        a2.I.setOnClickListener(touristFragment);
        a2.J.setOnClickListener(touristFragment);
        a2.t.setOnClickListener(touristFragment);
        a2.ak.setOnClickListener(touristFragment);
        a2.l.setOnClickListener(touristFragment);
        a2.ab.setOnClickListener(touristFragment);
        a2.k.setOnClickListener(touristFragment);
        a2.aa.setOnClickListener(touristFragment);
        a2.N.setOnClickListener(touristFragment);
        a2.L.setOnClickListener(touristFragment);
        a2.z.setOnClickListener(touristFragment);
        a2.E.setOnClickListener(touristFragment);
        a2.F.setOnClickListener(touristFragment);
        a2.D.setOnClickListener(touristFragment);
        a2.G.setOnClickListener(touristFragment);
        a2.h.setOnClickListener(touristFragment);
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment
    public void o() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.c(viewLifecycleOwner, "viewLifecycleOwner");
        BluedStructureExtKt.a(this, viewLifecycleOwner, new PropertyReference1Impl() { // from class: com.soft.blued.ui.mine.fragment.TouristFragment$liveDataObserver$1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object a(Object obj) {
                return ((TouristState) obj).getData();
            }
        }, new Function1<MinePageModel, Unit>() { // from class: com.soft.blued.ui.mine.fragment.TouristFragment$liveDataObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(MinePageModel it) {
                Intrinsics.e(it, "it");
                TouristFragment.this.a(it.healthy_banner);
                TouristFragment.this.a(it.healthy);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(MinePageModel minePageModel) {
                a(minePageModel);
                return Unit.f42314a;
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Tracker.onClick(v);
        Intrinsics.e(v, "v");
        switch (v.getId()) {
            case 2131364232:
            case R.id.iv_feed /* 2131365314 */:
            case R.id.iv_interact /* 2131365526 */:
            case R.id.iv_visit /* 2131366053 */:
            case R.id.ll_live /* 2131367969 */:
            case R.id.ll_main_feed /* 2131368000 */:
            case R.id.ll_main_find /* 2131368001 */:
            case R.id.ll_main_live /* 2131368002 */:
            case R.id.ll_main_msg /* 2131368003 */:
            case R.id.ll_my_attentions /* 2131368053 */:
            case R.id.ll_my_fans /* 2131368054 */:
            case R.id.ll_other_entry /* 2131368110 */:
            case R.id.ll_top_entry /* 2131368307 */:
            case R.id.tv_feed /* 2131371418 */:
            case R.id.tv_interact /* 2131371725 */:
            case R.id.tv_login_register /* 2131371878 */:
            case 2131372933:
                c();
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.module.common.base.mvi.MVIBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null && StatusBarHelper.a((Activity) activity)) {
            activity.findViewById(16908290).setFitsSystemWindows(true);
            FragmentActivity fragmentActivity = activity;
            activity.getWindow().setBackgroundDrawable(StatusBarHelper.a(fragmentActivity, AppInfo.k(), AppInfo.l(), AppInfo.j(), true));
            if (SkinCompatManager.a() != null) {
                activity.findViewById(16908290).setBackgroundColor(BluedSkinUtils.a(fragmentActivity, 2131101796));
            }
        }
    }
}
