package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CompletedWithCancellation.class */
public final class CompletedWithCancellation {

    /* renamed from: a  reason: collision with root package name */
    public final Object f42792a;
    public final Function1<Throwable, Unit> b;

    /* JADX WARN: Multi-variable type inference failed */
    public CompletedWithCancellation(Object obj, Function1<? super Throwable, Unit> function1) {
        this.f42792a = obj;
        this.b = function1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CompletedWithCancellation) {
            CompletedWithCancellation completedWithCancellation = (CompletedWithCancellation) obj;
            return Intrinsics.a(this.f42792a, completedWithCancellation.f42792a) && Intrinsics.a(this.b, completedWithCancellation.b);
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f42792a;
        return ((obj == null ? 0 : obj.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f42792a + ", onCancellation=" + this.b + ')';
    }
}
