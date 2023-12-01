package com.soft.blued.ui.home.pop;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.module.common.extensions.CustomViewBindingProperty;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.PopDiscoveryFeedBinding;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/pop/HomeTabBubblePop.class */
public final class HomeTabBubblePop extends AttachPopupView {
    static final /* synthetic */ KProperty<Object>[] t = {(KProperty) Reflection.a(new PropertyReference1Impl(HomeTabBubblePop.class, "vb", "getVb()Lcom/soft/blued/databinding/PopDiscoveryFeedBinding;", 0))};
    private final ViewBindingProperty u;
    private View.OnClickListener v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeTabBubblePop(Context context) {
        super(context);
        Intrinsics.e(context, "context");
        BasePopupView basePopupView = (BasePopupView) this;
        this.u = new CustomViewBindingProperty(new Function1<HomeTabBubblePop, PopDiscoveryFeedBinding>() { // from class: com.soft.blued.ui.home.pop.HomeTabBubblePop$special$$inlined$viewBindingFragment$default$1
            /* renamed from: a */
            public final PopDiscoveryFeedBinding invoke(HomeTabBubblePop homeTabBubblePop) {
                Intrinsics.e(homeTabBubblePop, "popView");
                return PopDiscoveryFeedBinding.a(homeTabBubblePop.getPopupImplView());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(HomeTabBubblePop homeTabBubblePop, View view) {
        Tracker.onClick(view);
        Intrinsics.e(homeTabBubblePop, "this$0");
        View.OnClickListener onClickListener = homeTabBubblePop.v;
        if (onClickListener == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    private final PopDiscoveryFeedBinding getVb() {
        return (PopDiscoveryFeedBinding) this.u.b(this, t[0]);
    }

    public void b() {
        ConstraintLayout constraintLayout;
        super.b();
        PopDiscoveryFeedBinding vb = getVb();
        if (vb == null || (constraintLayout = vb.b) == null) {
            return;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.home.pop.-$$Lambda$HomeTabBubblePop$maIq6t6_t1_OHdj8lRosuQWz0JY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeTabBubblePop.a(HomeTabBubblePop.this, view);
            }
        });
    }

    public int getImplLayoutId() {
        return R.layout.pop_discovery_feed;
    }

    public final void setRootClickListener(View.OnClickListener onClickListener) {
        Intrinsics.e(onClickListener, "listener");
        this.v = onClickListener;
    }

    public final void setText(String str) {
        Intrinsics.e(str, "str");
        PopDiscoveryFeedBinding vb = getVb();
        TextView textView = vb == null ? null : vb.f15825c;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public final void setTextResId(int i) {
        TextView textView;
        PopDiscoveryFeedBinding vb = getVb();
        if (vb == null || (textView = vb.f15825c) == null) {
            return;
        }
        textView.setText(i);
    }
}
