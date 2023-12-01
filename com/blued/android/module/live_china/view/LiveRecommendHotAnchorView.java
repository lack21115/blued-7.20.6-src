package com.blued.android.module.live_china.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.amap.api.services.core.AMapException;
import com.blued.android.framework.utils.UiUtils;
import com.blued.android.module.live_china.databinding.LayoutLiveHotRedBinding;
import com.blued.android.module.live_china.model.BluedLiveListData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveRecommendHotAnchorView.class */
public final class LiveRecommendHotAnchorView extends FrameLayout {
    private final Lazy a;
    private String b;
    private String c;
    private List<BluedLiveListData> d;
    private BluedLiveListData e;
    private List<AnimatorSet> f;
    private final int g;
    private final int h;
    private boolean i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveRecommendHotAnchorView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveRecommendHotAnchorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveRecommendHotAnchorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.a = LazyKt.a(new Function0<LayoutLiveHotRedBinding>() { // from class: com.blued.android.module.live_china.view.LiveRecommendHotAnchorView$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LayoutLiveHotRedBinding invoke() {
                LayoutLiveHotRedBinding a = LayoutLiveHotRedBinding.a(LayoutInflater.from(LiveRecommendHotAnchorView.this.getContext()), LiveRecommendHotAnchorView.this, true);
                Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
                return a;
            }
        });
        this.f = new ArrayList();
        this.g = AMapException.CODE_AMAP_ROUTE_OUT_OF_SERVICE;
        this.h = AMapException.CODE_AMAP_ROUTE_OUT_OF_SERVICE;
        a();
    }

    private final void a(View view) {
        AnimatorSet.Builder with;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", view.getScaleX(), 0.0f, view.getScaleX());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", view.getScaleY(), 0.0f, view.getScaleX());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f, 1.0f);
        AnimatorSet.Builder play = animatorSet.play(ofFloat);
        if (play != null && (with = play.with(ofFloat2)) != null) {
            with.with(ofFloat3);
        }
        animatorSet.setDuration(1000L);
        animatorSet.start();
        this.f.add(animatorSet);
    }

    private final void a(View view, float f, float f2) {
        AnimatorSet.Builder with;
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationX", view.getTranslationX(), f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleX", view.getScaleX(), f2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "scaleY", view.getScaleY(), f2);
        AnimatorSet.Builder play = animatorSet.play(ofFloat);
        if (play != null && (with = play.with(ofFloat2)) != null) {
            with.with(ofFloat3);
        }
        animatorSet.setDuration(1000L);
        animatorSet.start();
        this.f.add(animatorSet);
    }

    public final void a() {
        this.i = false;
        for (AnimatorSet animatorSet : this.f) {
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (animatorSet != null) {
                animatorSet.end();
            }
        }
        List<AnimatorSet> list = this.f;
        if (list == null) {
            return;
        }
        list.clear();
    }

    public final void a(int i) {
        int i2;
        if (i < 0) {
            i2 = 0;
        } else {
            i2 = i;
            if (i > 2) {
                i2 = 2;
            }
        }
        List<AnimatorSet> list = this.f;
        if (list != null) {
            list.clear();
        }
        LayoutLiveHotRedBinding binding = getBinding();
        if (i2 == 0) {
            ImageView flipperShow = binding.d;
            Intrinsics.c(flipperShow, "flipperShow");
            a(flipperShow, 0.0f, 1.0f);
            ImageView flipperNext = binding.a;
            Intrinsics.c(flipperNext, "flipperNext");
            a(flipperNext, 0.0f, 1.0f);
            ImageView flipperNext2 = binding.a;
            Intrinsics.c(flipperNext2, "flipperNext");
            a(flipperNext2);
            ImageView flipperPre = binding.b;
            Intrinsics.c(flipperPre, "flipperPre");
            a(flipperPre, 0.0f, 1.0f);
            binding.a.setElevation(0.0f);
            binding.d.setElevation(10.0f);
            binding.b.setElevation(1.0f);
        } else if (i2 == 1) {
            ImageView flipperShow2 = binding.d;
            Intrinsics.c(flipperShow2, "flipperShow");
            a(flipperShow2, -UiUtils.a(getContext(), 22.0f), 0.78f);
            ImageView flipperNext3 = binding.a;
            Intrinsics.c(flipperNext3, "flipperNext");
            a(flipperNext3, -UiUtils.a(getContext(), 22.0f), 1.28f);
            ImageView flipperPre2 = binding.b;
            Intrinsics.c(flipperPre2, "flipperPre");
            a(flipperPre2, UiUtils.a(getContext(), 47.0f), 1.0f);
            ImageView flipperPre3 = binding.b;
            Intrinsics.c(flipperPre3, "flipperPre");
            a(flipperPre3);
            binding.a.setElevation(10.0f);
            binding.d.setElevation(1.0f);
            binding.b.setElevation(1.0f);
        } else if (i2 != 2) {
        } else {
            ImageView flipperShow3 = binding.d;
            Intrinsics.c(flipperShow3, "flipperShow");
            a(flipperShow3, UiUtils.a(getContext(), 22.0f), 0.78f);
            ImageView flipperShow4 = binding.d;
            Intrinsics.c(flipperShow4, "flipperShow");
            a(flipperShow4);
            ImageView flipperNext4 = binding.a;
            Intrinsics.c(flipperNext4, "flipperNext");
            a(flipperNext4, -UiUtils.a(getContext(), 47.0f), 1.0f);
            ImageView flipperPre4 = binding.b;
            Intrinsics.c(flipperPre4, "flipperPre");
            a(flipperPre4, UiUtils.a(getContext(), 22.0f), 1.28f);
            binding.a.setElevation(1.0f);
            binding.d.setElevation(0.0f);
            binding.b.setElevation(10.0f);
        }
    }

    public final LayoutLiveHotRedBinding getBinding() {
        return (LayoutLiveHotRedBinding) this.a.getValue();
    }

    public final String getComeCode() {
        return this.b;
    }

    public final BluedLiveListData getData() {
        return this.e;
    }

    public final List<BluedLiveListData> getListData() {
        return this.d;
    }

    public final List<AnimatorSet> getSetAnimList() {
        return this.f;
    }

    public final String getTabId() {
        return this.c;
    }

    public final void setComeCode(String str) {
        this.b = str;
    }

    public final void setData(BluedLiveListData bluedLiveListData) {
        this.e = bluedLiveListData;
    }

    public final void setListData(List<BluedLiveListData> list) {
        this.d = list;
    }

    public final void setSetAnimList(List<AnimatorSet> list) {
        Intrinsics.e(list, "<set-?>");
        this.f = list;
    }

    public final void setTabId(String str) {
        this.c = str;
    }
}
