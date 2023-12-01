package kotlinx.coroutines.android;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/android/HandlerDispatcherKt.class */
public final class HandlerDispatcherKt {
    public static final HandlerDispatcher a;
    private static volatile Choreographer choreographer;

    static {
        Object f;
        try {
            Result.Companion companion = Result.a;
            f = Result.f(new HandlerContext(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.a;
            f = Result.f(ResultKt.a(th));
        }
        if (Result.b(f)) {
            f = null;
        }
        a = (HandlerDispatcher) f;
    }

    public static final Handler a(Looper looper, boolean z) {
        if (!z || Build.VERSION.SDK_INT < 16) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, true);
            } catch (NoSuchMethodException e) {
                return new Handler(looper);
            }
        }
        Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        if (invoke != null) {
            return (Handler) invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
    }

    private static final void a(Choreographer choreographer2, final CancellableContinuation<? super Long> cancellableContinuation) {
        choreographer2.postFrameCallback(new Choreographer.FrameCallback() { // from class: kotlinx.coroutines.android.-$$Lambda$HandlerDispatcherKt$X7A987sU-cBJ3WkJmfLbPkRAyOs
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j) {
                HandlerDispatcherKt.a(CancellableContinuation.this, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(CancellableContinuation cancellableContinuation, long j) {
        Dispatchers dispatchers = Dispatchers.a;
        cancellableContinuation.a((CoroutineDispatcher) Dispatchers.b(), (MainCoroutineDispatcher) Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(CancellableContinuation<? super Long> cancellableContinuation) {
        Choreographer choreographer2 = choreographer;
        Choreographer choreographer3 = choreographer2;
        if (choreographer2 == null) {
            choreographer3 = Choreographer.getInstance();
            Intrinsics.a(choreographer3);
            choreographer = choreographer3;
        }
        a(choreographer3, cancellableContinuation);
    }
}
