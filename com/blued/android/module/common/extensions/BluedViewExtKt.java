package com.blued.android.module.common.extensions;

import android.content.res.Resources;
import android.graphics.PointF;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/extensions/BluedViewExtKt.class */
public final class BluedViewExtKt {
    private static boolean a;
    private static Runnable b = new Runnable() { // from class: com.blued.android.module.common.extensions.-$$Lambda$BluedViewExtKt$AJQeuJT8DsJbX23GHxoYQXxLUnA
        @Override // java.lang.Runnable
        public final void run() {
            BluedViewExtKt.a();
        }
    };
    private static final long c = 500;

    public static final float a(float f) {
        return TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
    }

    public static final int a(int i) {
        return (int) a(i);
    }

    public static final View a(View view, int i) {
        Intrinsics.e(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = layoutParams;
        if (layoutParams == null) {
            layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
        }
        layoutParams2.width = i;
        view.setLayoutParams(layoutParams2);
        return view;
    }

    public static final View a(View view, int i, int i2) {
        Intrinsics.e(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = layoutParams;
        if (layoutParams == null) {
            layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
        }
        layoutParams2.width = i;
        layoutParams2.height = i2;
        view.setLayoutParams(layoutParams2);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a() {
        a = false;
    }

    public static final void a(View view, final Function1<? super View, Unit> action) {
        Intrinsics.e(view, "<this>");
        Intrinsics.e(action, "action");
        final Ref.LongRef longRef = new Ref.LongRef();
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.extensions.-$$Lambda$BluedViewExtKt$Ti3GS8E1CLefmVENMN3-goU6ycs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BluedViewExtKt.a(Ref.LongRef.this, action, view2);
            }
        });
    }

    public static final void a(View view, final Function2<? super View, ? super PointF, Unit> action) {
        Intrinsics.e(view, "<this>");
        Intrinsics.e(action, "action");
        final PointF pointF = new PointF();
        final Ref.LongRef longRef = new Ref.LongRef();
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.blued.android.module.common.extensions.-$$Lambda$BluedViewExtKt$TwPRMsKPGOIpWqevZDhnirLE0y8
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean a2;
                a2 = BluedViewExtKt.a(pointF, view2, motionEvent);
                return a2;
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.common.extensions.-$$Lambda$BluedViewExtKt$sgCgxORMzwKjYdA99GBDjztGwLk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BluedViewExtKt.a(Ref.LongRef.this, action, pointF, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ref.LongRef lastClickTime, Function1 action, View it) {
        Intrinsics.e(lastClickTime, "$lastClickTime");
        Intrinsics.e(action, "$action");
        if (SystemClock.elapsedRealtime() - lastClickTime.a < c) {
            Intrinsics.c(it, "it");
            action.invoke(it);
        }
        lastClickTime.a = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ref.LongRef lastClickTime, Function2 action, PointF coordinates, View it) {
        Intrinsics.e(lastClickTime, "$lastClickTime");
        Intrinsics.e(action, "$action");
        Intrinsics.e(coordinates, "$coordinates");
        if (SystemClock.elapsedRealtime() - lastClickTime.a < c) {
            Intrinsics.c(it, "it");
            action.invoke(it, coordinates);
        }
        lastClickTime.a = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(PointF coordinates, View view, MotionEvent motionEvent) {
        Intrinsics.e(coordinates, "$coordinates");
        if (motionEvent.getAction() == 0) {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            coordinates.set(motionEvent.getX() + iArr[0], motionEvent.getY() + iArr[1]);
            return false;
        }
        return false;
    }
}
