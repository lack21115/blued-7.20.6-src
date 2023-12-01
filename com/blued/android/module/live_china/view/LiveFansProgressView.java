package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.databinding.LiveFansProgressViewBinding;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveFansProgressView.class */
public final class LiveFansProgressView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f14462a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f14463c;
    private int d;
    private int e;
    private int f;
    private LiveFansInfoModel g;
    private LiveFansProgressViewBinding h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveFansProgressView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveFansProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveFansProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.d = DensityUtil.a(10.0f);
        this.e = DensityUtil.a(2.5f);
        this.f = DensityUtil.a(8.0f);
        LiveFansProgressViewBinding a2 = LiveFansProgressViewBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(\n            Lay…ontext), this, true\n    )");
        this.h = a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        if (this.b == 0 || this.f14462a == 0) {
            return;
        }
        Log.i("==xpp", "setLayout");
        LiveFansProgressViewBinding liveFansProgressViewBinding = this.h;
        ViewGroup.LayoutParams layoutParams = (liveFansProgressViewBinding == null ? null : liveFansProgressViewBinding.e).getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.leftMargin = this.b - this.e;
        marginLayoutParams.rightMargin = this.d;
        LiveFansProgressViewBinding liveFansProgressViewBinding2 = this.h;
        (liveFansProgressViewBinding2 == null ? null : liveFansProgressViewBinding2.e).setLayoutParams(marginLayoutParams);
        this.f14463c = (this.f14462a - marginLayoutParams.leftMargin) - marginLayoutParams.rightMargin;
        LiveFansProgressViewBinding liveFansProgressViewBinding3 = this.h;
        ViewGroup.LayoutParams layoutParams2 = (liveFansProgressViewBinding3 == null ? null : liveFansProgressViewBinding3.b).getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
        marginLayoutParams2.leftMargin = (this.f14462a - this.d) - this.e;
        LiveFansProgressViewBinding liveFansProgressViewBinding4 = this.h;
        (liveFansProgressViewBinding4 == null ? null : liveFansProgressViewBinding4.b).setLayoutParams(marginLayoutParams2);
        LiveFansProgressViewBinding liveFansProgressViewBinding5 = this.h;
        (liveFansProgressViewBinding5 == null ? null : liveFansProgressViewBinding5.d).post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveFansProgressView$moVAoN9uz3pfI5doB4JGYyYwldI
            @Override // java.lang.Runnable
            public final void run() {
                LiveFansProgressView.m4215setLayout$lambda0(LiveFansProgressView.this);
            }
        });
        LiveFansProgressViewBinding liveFansProgressViewBinding6 = this.h;
        (liveFansProgressViewBinding6 == null ? null : liveFansProgressViewBinding6.f).post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveFansProgressView$bDPbwfZKuUeUGH77K0Kp1FEaj3s
            @Override // java.lang.Runnable
            public final void run() {
                LiveFansProgressView.m4216setLayout$lambda1(LiveFansProgressView.this);
            }
        });
    }

    private final void getWH() {
        LiveFansProgressViewBinding liveFansProgressViewBinding = this.h;
        (liveFansProgressViewBinding == null ? null : liveFansProgressViewBinding.f12196a).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.module.live_china.view.LiveFansProgressView$getWH$1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                LiveFansProgressView liveFansProgressView = LiveFansProgressView.this;
                LiveFansProgressViewBinding binding = liveFansProgressView.getBinding();
                liveFansProgressView.setTotalWidth((binding == null ? null : binding.f12196a).getWidth());
                Log.i("==xpp", Intrinsics.a("totalWidth:", (Object) Integer.valueOf(LiveFansProgressView.this.getTotalWidth())));
                if (LiveFansProgressView.this.getTotalWidth() != 0) {
                    LiveFansProgressViewBinding binding2 = LiveFansProgressView.this.getBinding();
                    (binding2 == null ? null : binding2.f12196a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    LiveFansProgressView.this.a();
                }
            }
        });
        LiveFansProgressViewBinding liveFansProgressViewBinding2 = this.h;
        (liveFansProgressViewBinding2 == null ? null : liveFansProgressViewBinding2.f12197c).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.blued.android.module.live_china.view.LiveFansProgressView$getWH$2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                LiveFansProgressView liveFansProgressView = LiveFansProgressView.this;
                LiveFansProgressViewBinding binding = liveFansProgressView.getBinding();
                liveFansProgressView.setLeftWidth((binding == null ? null : binding.f12197c).getWidth());
                Log.i("==xpp", Intrinsics.a("leftWidth:", (Object) Integer.valueOf(LiveFansProgressView.this.getLeftWidth())));
                if (LiveFansProgressView.this.getLeftWidth() != 0) {
                    LiveFansProgressViewBinding binding2 = LiveFansProgressView.this.getBinding();
                    (binding2 == null ? null : binding2.f12197c).getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    LiveFansProgressView.this.a();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setLayout$lambda-0  reason: not valid java name */
    public static final void m4215setLayout$lambda0(LiveFansProgressView this$0) {
        Intrinsics.e(this$0, "this$0");
        LiveFansProgressViewBinding liveFansProgressViewBinding = this$0.h;
        ViewGroup.LayoutParams layoutParams = (liveFansProgressViewBinding == null ? null : liveFansProgressViewBinding.d).getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        LiveFansInfoModel liveFansInfoModel = this$0.g;
        if (liveFansInfoModel != null) {
            Intrinsics.a(liveFansInfoModel);
            if (liveFansInfoModel.next_level_relation > 0) {
                int i = this$0.b;
                int i2 = this$0.f14463c;
                LiveFansInfoModel liveFansInfoModel2 = this$0.g;
                Intrinsics.a(liveFansInfoModel2);
                int i3 = liveFansInfoModel2.relation;
                LiveFansInfoModel liveFansInfoModel3 = this$0.g;
                Intrinsics.a(liveFansInfoModel3);
                marginLayoutParams.leftMargin = ((i + ((i2 * i3) / liveFansInfoModel3.next_level_relation)) - (this$0.f / 2)) - this$0.e;
                LiveFansProgressViewBinding liveFansProgressViewBinding2 = this$0.h;
                (liveFansProgressViewBinding2 == null ? null : liveFansProgressViewBinding2.d).setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setLayout$lambda-1  reason: not valid java name */
    public static final void m4216setLayout$lambda1(LiveFansProgressView this$0) {
        Intrinsics.e(this$0, "this$0");
        LiveFansProgressViewBinding liveFansProgressViewBinding = this$0.h;
        ViewGroup.LayoutParams layoutParams = (liveFansProgressViewBinding == null ? null : liveFansProgressViewBinding.f).getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        LiveFansInfoModel liveFansInfoModel = this$0.g;
        if (liveFansInfoModel != null) {
            Intrinsics.a(liveFansInfoModel);
            if (liveFansInfoModel.next_level_relation > 0) {
                int i = this$0.b;
                int i2 = this$0.f14463c;
                LiveFansInfoModel liveFansInfoModel2 = this$0.g;
                Intrinsics.a(liveFansInfoModel2);
                int i3 = liveFansInfoModel2.relation;
                LiveFansInfoModel liveFansInfoModel3 = this$0.g;
                Intrinsics.a(liveFansInfoModel3);
                int i4 = (i2 * i3) / liveFansInfoModel3.next_level_relation;
                LiveFansProgressViewBinding liveFansProgressViewBinding2 = this$0.h;
                int width = ((i + i4) - ((liveFansProgressViewBinding2 == null ? null : liveFansProgressViewBinding2.f).getWidth() / 2)) - this$0.e;
                int i5 = this$0.b;
                int i6 = this$0.f14463c;
                LiveFansProgressViewBinding liveFansProgressViewBinding3 = this$0.h;
                int i7 = width;
                if (width > ((i5 + i6) - (liveFansProgressViewBinding3 == null ? null : liveFansProgressViewBinding3.f).getWidth()) - this$0.e) {
                    int i8 = this$0.b;
                    int i9 = this$0.f14463c;
                    LiveFansProgressViewBinding liveFansProgressViewBinding4 = this$0.h;
                    i7 = ((i8 + i9) - (liveFansProgressViewBinding4 == null ? null : liveFansProgressViewBinding4.f).getWidth()) - this$0.e;
                }
                marginLayoutParams.leftMargin = i7;
                LiveFansProgressViewBinding liveFansProgressViewBinding5 = this$0.h;
                (liveFansProgressViewBinding5 == null ? null : liveFansProgressViewBinding5.f).setLayoutParams(marginLayoutParams);
            }
        }
    }

    public final LiveFansProgressViewBinding getBinding() {
        return this.h;
    }

    public final int getInter() {
        return this.e;
    }

    public final int getLeftWidth() {
        return this.b;
    }

    public final LiveFansInfoModel getLiveFansInfo() {
        return this.g;
    }

    public final int getMiddleWidth() {
        return this.f14463c;
    }

    public final int getPointWidth() {
        return this.f;
    }

    public final int getRightWidth() {
        return this.d;
    }

    public final int getTotalWidth() {
        return this.f14462a;
    }

    public final void setBinding(LiveFansProgressViewBinding liveFansProgressViewBinding) {
        Intrinsics.e(liveFansProgressViewBinding, "<set-?>");
        this.h = liveFansProgressViewBinding;
    }

    public final void setInter(int i) {
        this.e = i;
    }

    public final void setLeftWidth(int i) {
        this.b = i;
    }

    public final void setLevel(LiveFansInfoModel liveFansInfoModel) {
        long j;
        LiveFansInfoModel liveFansInfoModel2;
        if (liveFansInfoModel == null) {
            return;
        }
        this.g = liveFansInfoModel;
        if (liveFansInfoModel == null) {
            return;
        }
        try {
            Intrinsics.a(liveFansInfoModel);
            float f = liveFansInfoModel.relation;
            float f2 = 100;
            Intrinsics.a(this.g);
            j = ((f * 1.0f) * f2) / liveFansInfoModel2.next_level_relation;
        } catch (ArithmeticException e) {
            j = 0;
        }
        LiveFansProgressViewBinding liveFansProgressViewBinding = this.h;
        ShapeTextView shapeTextView = liveFansProgressViewBinding == null ? null : liveFansProgressViewBinding.f12197c;
        LiveFansInfoModel liveFansInfoModel3 = this.g;
        Intrinsics.a(liveFansInfoModel3);
        shapeTextView.setText(Intrinsics.a("Lv", (Object) Integer.valueOf(liveFansInfoModel3.level)));
        LiveFansProgressViewBinding liveFansProgressViewBinding2 = this.h;
        (liveFansProgressViewBinding2 == null ? null : liveFansProgressViewBinding2.e).setMax(100);
        LiveFansProgressViewBinding liveFansProgressViewBinding3 = this.h;
        (liveFansProgressViewBinding3 == null ? null : liveFansProgressViewBinding3.e).setProgress((int) j);
        LiveFansProgressViewBinding liveFansProgressViewBinding4 = this.h;
        ShapeTextView shapeTextView2 = liveFansProgressViewBinding4 == null ? null : liveFansProgressViewBinding4.f;
        StringBuilder sb = new StringBuilder();
        LiveFansInfoModel liveFansInfoModel4 = this.g;
        Intrinsics.a(liveFansInfoModel4);
        sb.append(liveFansInfoModel4.relation);
        sb.append('/');
        LiveFansInfoModel liveFansInfoModel5 = this.g;
        Intrinsics.a(liveFansInfoModel5);
        sb.append(liveFansInfoModel5.next_level_relation);
        shapeTextView2.setText(sb.toString());
        getWH();
        LiveFansInfoModel liveFansInfoModel6 = this.g;
        Intrinsics.a(liveFansInfoModel6);
        int i = liveFansInfoModel6.relation;
        LiveFansInfoModel liveFansInfoModel7 = this.g;
        Intrinsics.a(liveFansInfoModel7);
        int i2 = liveFansInfoModel7.next_level_relation;
    }

    public final void setLiveFansInfo(LiveFansInfoModel liveFansInfoModel) {
        this.g = liveFansInfoModel;
    }

    public final void setMiddleWidth(int i) {
        this.f14463c = i;
    }

    public final void setPointWidth(int i) {
        this.f = i;
    }

    public final void setRightWidth(int i) {
        this.d = i;
    }

    public final void setTotalWidth(int i) {
        this.f14462a = i;
    }
}
