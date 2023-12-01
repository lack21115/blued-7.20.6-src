package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/android/HandlerContext.class */
public final class HandlerContext extends HandlerDispatcher implements Delay {
    private volatile HandlerContext _immediate;
    private final Handler b;
    private final String c;
    private final boolean d;
    private final HandlerContext e;

    public HandlerContext(Handler handler, String str) {
        this(handler, str, false);
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    private HandlerContext(Handler handler, String str, boolean z) {
        super(null);
        this.b = handler;
        this.c = str;
        this.d = z;
        this._immediate = z ? this : null;
        HandlerContext handlerContext = this._immediate;
        HandlerContext handlerContext2 = handlerContext;
        if (handlerContext == null) {
            handlerContext2 = new HandlerContext(this.b, this.c, true);
            this._immediate = handlerContext2;
            Unit unit = Unit.a;
        }
        this.e = handlerContext2;
    }

    @Override // kotlinx.coroutines.android.HandlerDispatcher, kotlinx.coroutines.Delay
    public DisposableHandle a(long j, final Runnable runnable, CoroutineContext coroutineContext) {
        this.b.postDelayed(runnable, RangesKt.b(j, 4611686018427387903L));
        return new DisposableHandle() { // from class: kotlinx.coroutines.android.HandlerContext$invokeOnTimeout$1
            @Override // kotlinx.coroutines.DisposableHandle
            public void dispose() {
                Handler handler;
                handler = HandlerContext.this.b;
                handler.removeCallbacks(runnable);
            }
        };
    }

    @Override // kotlinx.coroutines.Delay
    public void a(long j, final CancellableContinuation<? super Unit> cancellableContinuation) {
        final Runnable runnable = new Runnable() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                CancellableContinuation.this.a((CoroutineDispatcher) this, (HandlerContext) Unit.a);
            }
        };
        this.b.postDelayed(runnable, RangesKt.b(j, 4611686018427387903L));
        cancellableContinuation.a((Function1<? super Throwable, Unit>) new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.android.HandlerContext$scheduleResumeAfterDelay$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void a(Throwable th) {
                Handler handler;
                handler = HandlerContext.this.b;
                handler.removeCallbacks(runnable);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(Throwable th) {
                a(th);
                return Unit.a;
            }
        });
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    /* renamed from: c */
    public HandlerContext a() {
        return this.e;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        this.b.post(runnable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof HandlerContext) && ((HandlerContext) obj).b == this.b;
    }

    public int hashCode() {
        return System.identityHashCode(this.b);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return (this.d && Intrinsics.a(Looper.myLooper(), this.b.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String b = b();
        String str = b;
        if (b == null) {
            HandlerContext handlerContext = this;
            String str2 = handlerContext.c;
            str = str2;
            if (str2 == null) {
                str = handlerContext.b.toString();
            }
            if (handlerContext.d) {
                return Intrinsics.a(str, (Object) ".immediate");
            }
        }
        return str;
    }
}
