package kotlinx.coroutines;

import $r8;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CoroutineId.class */
public final class CoroutineId extends AbstractCoroutineContextElement implements ThreadContextElement<String> {
    public static final Key a = new Key(null);
    private final long b;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/CoroutineId$Key.class */
    public static final class Key implements CoroutineContext.Key<CoroutineId> {
        private Key() {
        }

        public /* synthetic */ Key(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CoroutineId(long j) {
        super(a);
        this.b = j;
    }

    public final long a() {
        return this.b;
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    /* renamed from: a */
    public String b(CoroutineContext coroutineContext) {
        String a2;
        CoroutineName coroutineName = (CoroutineName) coroutineContext.get(CoroutineName.a);
        String str = "coroutine";
        if (coroutineName != null && (a2 = coroutineName.a()) != null) {
            str = a2;
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        int b = StringsKt.b((CharSequence) name, " @", 0, false, 6, (Object) null);
        int i = b;
        if (b < 0) {
            i = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + i + 10);
        if (name != null) {
            String substring = name.substring(0, i);
            Intrinsics.c(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append(" @");
            sb.append(str);
            sb.append('#');
            sb.append(a());
            Unit unit = Unit.a;
            String sb2 = sb.toString();
            Intrinsics.c(sb2, "StringBuilder(capacity).…builderAction).toString()");
            currentThread.setName(sb2);
            return name;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    public void a(CoroutineContext coroutineContext, String str) {
        Thread.currentThread().setName(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CoroutineId) && this.b == ((CoroutineId) obj).b;
    }

    public int hashCode() {
        return $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.b);
    }

    public String toString() {
        return "CoroutineId(" + this.b + ')';
    }
}
