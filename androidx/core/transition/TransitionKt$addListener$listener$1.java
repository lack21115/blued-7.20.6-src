package androidx.core.transition;

import android.transition.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/transition/TransitionKt$addListener$listener$1.class */
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function1<Transition, Unit> f2592a;
    final /* synthetic */ Function1<Transition, Unit> b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Function1<Transition, Unit> f2593c;
    final /* synthetic */ Function1<Transition, Unit> d;
    final /* synthetic */ Function1<Transition, Unit> e;

    /* JADX WARN: Multi-variable type inference failed */
    public TransitionKt$addListener$listener$1(Function1<? super Transition, Unit> function1, Function1<? super Transition, Unit> function12, Function1<? super Transition, Unit> function13, Function1<? super Transition, Unit> function14, Function1<? super Transition, Unit> function15) {
        this.f2592a = function1;
        this.b = function12;
        this.f2593c = function13;
        this.d = function14;
        this.e = function15;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
        Intrinsics.e(transition, "transition");
        this.d.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        Intrinsics.e(transition, "transition");
        this.f2592a.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
        Intrinsics.e(transition, "transition");
        this.f2593c.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
        Intrinsics.e(transition, "transition");
        this.b.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        Intrinsics.e(transition, "transition");
        this.e.invoke(transition);
    }
}
