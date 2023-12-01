package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CompletedContinuation.class */
public final class CompletedContinuation {

    /* renamed from: a  reason: collision with root package name */
    public final Object f42789a;
    public final CancelHandler b;

    /* renamed from: c  reason: collision with root package name */
    public final Function1<Throwable, Unit> f42790c;
    public final Object d;
    public final Throwable e;

    /* JADX WARN: Multi-variable type inference failed */
    public CompletedContinuation(Object obj, CancelHandler cancelHandler, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        this.f42789a = obj;
        this.b = cancelHandler;
        this.f42790c = function1;
        this.d = obj2;
        this.e = th;
    }

    public /* synthetic */ CompletedContinuation(Object obj, CancelHandler cancelHandler, Function1 function1, Object obj2, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? null : cancelHandler, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : obj2, (i & 16) != 0 ? null : th);
    }

    public static /* synthetic */ CompletedContinuation a(CompletedContinuation completedContinuation, Object obj, CancelHandler cancelHandler, Function1 function1, Object obj2, Throwable th, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = completedContinuation.f42789a;
        }
        if ((i & 2) != 0) {
            cancelHandler = completedContinuation.b;
        }
        if ((i & 4) != 0) {
            function1 = completedContinuation.f42790c;
        }
        if ((i & 8) != 0) {
            obj2 = completedContinuation.d;
        }
        if ((i & 16) != 0) {
            th = completedContinuation.e;
        }
        return completedContinuation.a(obj, cancelHandler, function1, obj2, th);
    }

    public final CompletedContinuation a(Object obj, CancelHandler cancelHandler, Function1<? super Throwable, Unit> function1, Object obj2, Throwable th) {
        return new CompletedContinuation(obj, cancelHandler, function1, obj2, th);
    }

    public final void a(CancellableContinuationImpl<?> cancellableContinuationImpl, Throwable th) {
        CancelHandler cancelHandler = this.b;
        if (cancelHandler != null) {
            cancellableContinuationImpl.a(cancelHandler, th);
        }
        Function1<Throwable, Unit> function1 = this.f42790c;
        if (function1 == null) {
            return;
        }
        cancellableContinuationImpl.a((Function1<? super Throwable, Unit>) function1, th);
    }

    public final boolean a() {
        return this.e != null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CompletedContinuation) {
            CompletedContinuation completedContinuation = (CompletedContinuation) obj;
            return Intrinsics.a(this.f42789a, completedContinuation.f42789a) && Intrinsics.a(this.b, completedContinuation.b) && Intrinsics.a(this.f42790c, completedContinuation.f42790c) && Intrinsics.a(this.d, completedContinuation.d) && Intrinsics.a(this.e, completedContinuation.e);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f42789a;
        int i = 0;
        int hashCode = obj == null ? 0 : obj.hashCode();
        CancelHandler cancelHandler = this.b;
        int hashCode2 = cancelHandler == null ? 0 : cancelHandler.hashCode();
        Function1<Throwable, Unit> function1 = this.f42790c;
        int hashCode3 = function1 == null ? 0 : function1.hashCode();
        Object obj2 = this.d;
        int hashCode4 = obj2 == null ? 0 : obj2.hashCode();
        Throwable th = this.e;
        if (th != null) {
            i = th.hashCode();
        }
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + i;
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f42789a + ", cancelHandler=" + this.b + ", onCancellation=" + this.f42790c + ", idempotentResume=" + this.d + ", cancelCause=" + this.e + ')';
    }
}
