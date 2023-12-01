package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import com.blued.android.module.live_china.databinding.LiveCommentTipViewBinding;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveCommentTipView.class */
public final class LiveCommentTipView extends FrameLayout {
    private final Lazy a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveCommentTipView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveCommentTipView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveCommentTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.a = LazyKt.a(new Function0<LiveCommentTipViewBinding>() { // from class: com.blued.android.module.live_china.view.LiveCommentTipView$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LiveCommentTipViewBinding invoke() {
                LiveCommentTipViewBinding a = LiveCommentTipViewBinding.a(LayoutInflater.from(LiveCommentTipView.this.getContext()), LiveCommentTipView.this, true);
                Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
                return a;
            }
        });
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveCommentTipView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveCommentTipViewBinding binding = this$0.getBinding();
        CardView root = binding == null ? null : binding.getRoot();
        if (root == null) {
            return;
        }
        root.setVisibility(8);
    }

    public final void a() {
        ImageView imageView;
        LiveCommentTipViewBinding binding = getBinding();
        CardView root = binding == null ? null : binding.getRoot();
        if (root != null) {
            root.setVisibility(8);
        }
        LiveCommentTipViewBinding binding2 = getBinding();
        if (binding2 == null || (imageView = binding2.a) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveCommentTipView$Ty-xGhC1Qg6r5b0lb6D_dFS8eYQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveCommentTipView.a(LiveCommentTipView.this, view);
            }
        });
    }

    public final void a(String str, String str2) {
        LiveCommentTipViewBinding binding = getBinding();
        CardView root = binding == null ? null : binding.getRoot();
        if (root != null) {
            root.setVisibility(0);
        }
        LiveCommentTipViewBinding binding2 = getBinding();
        (binding2 == null ? null : binding2.b).setText(str2);
        LiveCommentTipViewBinding binding3 = getBinding();
        (binding3 == null ? null : binding3.c).setText(str);
    }

    public final LiveCommentTipViewBinding getBinding() {
        return (LiveCommentTipViewBinding) this.a.getValue();
    }
}
