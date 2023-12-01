package androidx.core.os;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/os/HandlerKt$postDelayed$runnable$1.class */
public final class HandlerKt$postDelayed$runnable$1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Function0<Unit> f2461a;

    public HandlerKt$postDelayed$runnable$1(Function0<Unit> function0) {
        this.f2461a = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2461a.invoke();
    }
}
