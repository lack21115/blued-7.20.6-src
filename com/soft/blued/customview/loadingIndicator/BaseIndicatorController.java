package com.soft.blued.customview.loadingIndicator;

import android.animation.Animator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/loadingIndicator/BaseIndicatorController.class */
public abstract class BaseIndicatorController {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<View> f14921a;
    private List<Animator> b;

    /* renamed from: com.soft.blued.customview.loadingIndicator.BaseIndicatorController$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/loadingIndicator/BaseIndicatorController$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f14922a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x002f -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x002b -> B:15:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[AnimStatus.values().length];
            f14922a = iArr;
            try {
                iArr[AnimStatus.START.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14922a[AnimStatus.END.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14922a[AnimStatus.CANCEL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/loadingIndicator/BaseIndicatorController$AnimStatus.class */
    public enum AnimStatus {
        START,
        END,
        CANCEL
    }

    public abstract List<Animator> a();

    public abstract void a(Canvas canvas, Paint paint);

    public void a(View view) {
        this.f14921a = new WeakReference<>(view);
    }

    public void a(AnimStatus animStatus) {
        List<Animator> list = this.b;
        if (list == null) {
            return;
        }
        int size = list.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            Animator animator = this.b.get(i2);
            boolean isRunning = animator.isRunning();
            int i3 = AnonymousClass1.f14922a[animStatus.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 && isRunning) {
                        animator.cancel();
                    }
                } else if (isRunning) {
                    animator.end();
                }
            } else if (!isRunning) {
                animator.start();
            }
            i = i2 + 1;
        }
    }

    public View b() {
        WeakReference<View> weakReference = this.f14921a;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int c() {
        if (b() != null) {
            return b().getWidth();
        }
        return 0;
    }

    public int d() {
        if (b() != null) {
            return b().getHeight();
        }
        return 0;
    }

    public void e() {
        if (b() != null) {
            b().postInvalidate();
        }
    }

    public void f() {
        this.b = a();
    }
}
