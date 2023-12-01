package com.soft.blued.ui.home.pop;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.framework.ui.xpop.core.AttachPopupView;
import com.blued.android.module.common.extensions.ViewBindingProperty;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.databinding.PopTabBubbleBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/home/pop/TabBubblePop.class */
public final class TabBubblePop extends AttachPopupView {
    static final /* synthetic */ KProperty<Object>[] t = {Reflection.a(new PropertyReference1Impl(TabBubblePop.class, "vb", "getVb()Lcom/soft/blued/databinding/PopTabBubbleBinding;", 0))};
    private final ViewBindingProperty u;
    private View.OnClickListener v;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(TabBubblePop this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        View.OnClickListener onClickListener = this$0.v;
        if (onClickListener == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    private final PopTabBubbleBinding getVb() {
        return (PopTabBubbleBinding) this.u.b(this, t[0]);
    }

    @Override // com.blued.android.framework.ui.xpop.core.AttachPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        ConstraintLayout constraintLayout;
        super.b();
        PopTabBubbleBinding vb = getVb();
        if (vb == null || (constraintLayout = vb.b) == null) {
            return;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.home.pop.-$$Lambda$TabBubblePop$hou4ZNNTZqKJhL5UQd9ZH2jJTeA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TabBubblePop.a(TabBubblePop.this, view);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_tab_bubble;
    }

    public final void setRootClickListener(View.OnClickListener listener) {
        Intrinsics.e(listener, "listener");
        this.v = listener;
    }

    public final void setText(String str) {
        Intrinsics.e(str, "str");
        PopTabBubbleBinding vb = getVb();
        TextView textView = vb == null ? null : vb.f29558c;
        if (textView == null) {
            return;
        }
        textView.setText(str);
    }

    public final void setTextResId(int i) {
        TextView textView;
        PopTabBubbleBinding vb = getVb();
        if (vb == null || (textView = vb.f29558c) == null) {
            return;
        }
        textView.setText(i);
    }
}
