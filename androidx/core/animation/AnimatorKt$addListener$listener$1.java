package androidx.core.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/animation/AnimatorKt$addListener$listener$1.class */
public final class AnimatorKt$addListener$listener$1 implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function1<Animator, Unit> f2307a;
    final /* synthetic */ Function1<Animator, Unit> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function1<Animator, Unit> f2308c;
    final /* synthetic */ Function1<Animator, Unit> d;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimatorKt$addListener$listener$1(Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function12, Function1<? super Animator, Unit> function13, Function1<? super Animator, Unit> function14) {
        this.f2307a = function1;
        this.b = function12;
        this.f2308c = function13;
        this.d = function14;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Intrinsics.e(animator, "animator");
        this.f2308c.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics.e(animator, "animator");
        this.b.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Intrinsics.e(animator, "animator");
        this.f2307a.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Intrinsics.e(animator, "animator");
        this.d.invoke(animator);
    }
}
