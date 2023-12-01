package com.soft.blued.ui.find.view;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.view.CubicInterpolator;
import com.blued.android.module.yy_china.fragment.YYChatRoomsListFragment;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.databinding.NearbyChatRoomHostViewBinding;
import com.soft.blued.ui.find.model.NearbyChatRoomModel;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/NearbyChatHostRoomView.class */
public final class NearbyChatHostRoomView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final NearbyChatRoomHostViewBinding f17016a;
    private BaseFragment b;

    /* renamed from: c  reason: collision with root package name */
    private int f17017c;
    private NearbyChatRoomModel d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NearbyChatHostRoomView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NearbyChatHostRoomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearbyChatHostRoomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        NearbyChatRoomHostViewBinding a2 = NearbyChatRoomHostViewBinding.a(LayoutInflater.from(getContext()), this, true);
        this.f17016a = a2;
        a2.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.view.-$$Lambda$NearbyChatHostRoomView$EbUj2Yi_YBrJ83P5FeA9-csIuok
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NearbyChatHostRoomView.a(NearbyChatHostRoomView.this, view);
            }
        });
        ImageLoader.c((IRequestHost) null, "anim_nearby_chat.png").e(this.f17016a.f15797c.getId()).g(-1).a(this.f17016a.f15797c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(NearbyChatRoomHostViewBinding nearbyChatRoomHostViewBinding, ValueAnimator valueAnimator) {
        Intrinsics.e(nearbyChatRoomHostViewBinding, "$it");
        ViewGroup.LayoutParams layoutParams = nearbyChatRoomHostViewBinding.getRoot().getLayoutParams();
        if (layoutParams != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            layoutParams.width = ((Integer) animatedValue).intValue();
        }
        nearbyChatRoomHostViewBinding.getRoot().setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(NearbyChatHostRoomView nearbyChatHostRoomView, View view) {
        Tracker.onClick(view);
        Intrinsics.e(nearbyChatHostRoomView, "this$0");
        YYChatRoomsListFragment.Companion companion = YYChatRoomsListFragment.a;
        Context context = nearbyChatHostRoomView.getContext();
        Intrinsics.c(context, "context");
        companion.a(context, "home_yy_hall");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(NearbyChatRoomHostViewBinding nearbyChatRoomHostViewBinding, ValueAnimator valueAnimator) {
        Intrinsics.e(nearbyChatRoomHostViewBinding, "$it");
        ViewGroup.LayoutParams layoutParams = nearbyChatRoomHostViewBinding.getRoot().getLayoutParams();
        if (layoutParams != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            layoutParams.width = ((Integer) animatedValue).intValue();
        }
        nearbyChatRoomHostViewBinding.getRoot().setLayoutParams(layoutParams);
    }

    public final void a() {
        NearbyChatRoomHostViewBinding nearbyChatRoomHostViewBinding = this.f17016a;
        if (nearbyChatRoomHostViewBinding == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = nearbyChatRoomHostViewBinding.getRoot().getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = DensityUtils.a(getContext(), 164.0f);
        }
        nearbyChatRoomHostViewBinding.getRoot().setLayoutParams(layoutParams);
        nearbyChatRoomHostViewBinding.e.setVisibility(0);
        nearbyChatRoomHostViewBinding.g.setVisibility(8);
    }

    public final void a(NearbyChatRoomModel nearbyChatRoomModel, BaseFragment baseFragment) {
        Intrinsics.e(nearbyChatRoomModel, "mode");
        Intrinsics.e(baseFragment, "fra");
        this.b = baseFragment;
        this.f17017c = 0;
        this.d = nearbyChatRoomModel;
        NearbyChatRoomHostViewBinding nearbyChatRoomHostViewBinding = this.f17016a;
        if (nearbyChatRoomHostViewBinding == null) {
            return;
        }
        nearbyChatRoomHostViewBinding.b.setVisibility(8);
        if (nearbyChatRoomModel.room_data.isEmpty() || nearbyChatRoomModel.room_data.size() <= 0) {
            nearbyChatRoomHostViewBinding.d.setVisibility(0);
        } else {
            nearbyChatRoomHostViewBinding.d.setVisibility(8);
            ArrayList arrayList = new ArrayList();
            Iterator<YYRoomModel> it = nearbyChatRoomModel.room_data.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().avatar);
            }
            nearbyChatRoomHostViewBinding.b.setVisibility(0);
            nearbyChatRoomHostViewBinding.b.a(arrayList, baseFragment.getFragmentActive());
        }
        if (StringUtils.d(nearbyChatRoomModel.ceremony_text)) {
            return;
        }
        nearbyChatRoomHostViewBinding.f15796a.setVisibility(0);
        ImageLoader.a((IRequestHost) null, nearbyChatRoomModel.ceremony_text).a(nearbyChatRoomHostViewBinding.f15796a);
    }

    public final void b() {
        final NearbyChatRoomHostViewBinding nearbyChatRoomHostViewBinding = this.f17016a;
        if (nearbyChatRoomHostViewBinding == null) {
            return;
        }
        nearbyChatRoomHostViewBinding.e.setVisibility(0);
        nearbyChatRoomHostViewBinding.g.setVisibility(8);
        ValueAnimator ofInt = ObjectAnimator.ofInt(DensityUtils.a(getContext(), 47.0f), DensityUtils.a(getContext(), 164.0f));
        ofInt.setDuration(100L);
        ofInt.setInterpolator((TimeInterpolator) new CubicInterpolator(0.36f, 0.79f, 0.33f, 0.99f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.view.-$$Lambda$NearbyChatHostRoomView$csd3HSSLiMSqbGjc2YdxqdjiotA
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                NearbyChatHostRoomView.a(NearbyChatRoomHostViewBinding.this, valueAnimator);
            }
        });
        ofInt.start();
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(100L);
        nearbyChatRoomHostViewBinding.g.startAnimation(alphaAnimation);
    }

    public final void c() {
        final NearbyChatRoomHostViewBinding nearbyChatRoomHostViewBinding = this.f17016a;
        if (nearbyChatRoomHostViewBinding != null) {
            nearbyChatRoomHostViewBinding.e.setVisibility(8);
            nearbyChatRoomHostViewBinding.g.setVisibility(0);
            ValueAnimator ofInt = ObjectAnimator.ofInt(DensityUtils.a(getContext(), 164.0f), DensityUtils.a(getContext(), 47.0f));
            ofInt.setDuration(100L);
            ofInt.setInterpolator((TimeInterpolator) new CubicInterpolator(0.36f, 0.79f, 0.33f, 0.99f));
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.view.-$$Lambda$NearbyChatHostRoomView$hQWbFRXMB39H7FTW7pWvgrDdK2c
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    NearbyChatHostRoomView.b(NearbyChatRoomHostViewBinding.this, valueAnimator);
                }
            });
            ofInt.start();
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(100L);
            nearbyChatRoomHostViewBinding.g.startAnimation(alphaAnimation);
        }
        d();
    }

    public final void d() {
    }

    public final BaseFragment getFr() {
        return this.b;
    }

    public final NearbyChatRoomHostViewBinding getMBinding() {
        return this.f17016a;
    }

    public final int getMIndex() {
        return this.f17017c;
    }

    public final NearbyChatRoomModel getMod() {
        return this.d;
    }

    public final void setFr(BaseFragment baseFragment) {
        this.b = baseFragment;
    }

    public final void setMIndex(int i) {
        this.f17017c = i;
    }

    public final void setMod(NearbyChatRoomModel nearbyChatRoomModel) {
        this.d = nearbyChatRoomModel;
    }

    public final void setText(String str) {
        NearbyChatRoomHostViewBinding nearbyChatRoomHostViewBinding = this.f17016a;
        TextView textView = nearbyChatRoomHostViewBinding == null ? null : nearbyChatRoomHostViewBinding.f;
        if (textView != null) {
            textView.setText(str);
        }
        NearbyChatRoomHostViewBinding nearbyChatRoomHostViewBinding2 = this.f17016a;
        TextView textView2 = nearbyChatRoomHostViewBinding2 == null ? null : nearbyChatRoomHostViewBinding2.f;
        if (textView2 == null) {
            return;
        }
        textView2.setSelected(true);
    }
}
