package kotlin.concurrent;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/concurrent/ThreadsKt$thread$thread$1.class */
public final class ThreadsKt$thread$thread$1 extends Thread {
    final /* synthetic */ Function0<Unit> a;

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.a.invoke();
    }
}
