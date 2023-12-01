package kotlinx.coroutines.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/MissingMainCoroutineDispatcher.class */
public final class MissingMainCoroutineDispatcher extends MainCoroutineDispatcher implements Delay {
    private final Throwable b;
    private final String c;

    public MissingMainCoroutineDispatcher(Throwable th, String str) {
        this.b = th;
        this.c = str;
    }

    public /* synthetic */ MissingMainCoroutineDispatcher(Throwable th, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(th, (i & 2) != 0 ? null : str);
    }

    private final Void c() {
        if (this.b == null) {
            MainDispatchersKt.a();
            throw new KotlinNothingValueException();
        }
        String str = this.c;
        String str2 = "";
        if (str != null) {
            str2 = Intrinsics.a(". ", (Object) str);
            if (str2 == null) {
                str2 = "";
            }
        }
        throw new IllegalStateException(Intrinsics.a("Module with the Main dispatcher had failed to initialize", (Object) str2), this.b);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: a */
    public Void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        c();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.Delay
    public DisposableHandle a(long j, Runnable runnable, CoroutineContext coroutineContext) {
        c();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    public MainCoroutineDispatcher a() {
        return this;
    }

    @Override // kotlinx.coroutines.Delay
    /* renamed from: b */
    public Void a(long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        c();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        c();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        Throwable th = this.b;
        sb.append(th != null ? Intrinsics.a(", cause=", (Object) th) : "");
        sb.append(']');
        return sb.toString();
    }
}
