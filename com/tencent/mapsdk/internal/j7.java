package com.tencent.mapsdk.internal;

import android.view.animation.Interpolator;
import com.tencent.mapsdk.internal.a8;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationListener;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/j7.class */
public abstract class j7 implements Animation {

    /* renamed from: a  reason: collision with root package name */
    public a8 f23872a = null;
    public a b;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/j7$a.class */
    public static class a implements a8.a {

        /* renamed from: a  reason: collision with root package name */
        private AnimationListener f23873a;

        /* renamed from: com.tencent.mapsdk.internal.j7$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/j7$a$a.class */
        public class RunnableC0799a implements Runnable {
            public RunnableC0799a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f23873a.onAnimationStart();
            }
        }

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/j7$a$b.class */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f23873a.onAnimationEnd();
            }
        }

        public a(AnimationListener animationListener) {
            this.f23873a = animationListener;
        }

        @Override // com.tencent.mapsdk.internal.a8.a
        public void a() {
            if (this.f23873a != null) {
                ca.b(new b());
            }
        }

        @Override // com.tencent.mapsdk.internal.a8.a
        public void onAnimationStart() {
            if (this.f23873a != null) {
                ca.b(new RunnableC0799a());
            }
        }
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public AnimationListener getAnimationListener() {
        a aVar = this.b;
        if (aVar != null) {
            return aVar.f23873a;
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public long getDuration() {
        a8 a8Var = this.f23872a;
        if (a8Var != null) {
            return a8Var.c();
        }
        return 0L;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public Interpolator getInterpolator() {
        a8 a8Var = this.f23872a;
        if (a8Var != null) {
            return a8Var.d();
        }
        return null;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.Animation
    public void setAnimationListener(AnimationListener animationListener) {
        a aVar = new a(animationListener);
        this.b = aVar;
        a8 a8Var = this.f23872a;
        if (a8Var != null) {
            a8Var.a(aVar);
        }
    }
}
