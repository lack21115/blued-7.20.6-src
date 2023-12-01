package kotlin.coroutines;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/CombinedContext.class */
public final class CombinedContext implements Serializable, CoroutineContext {

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineContext f42449a;
    private final CoroutineContext.Element b;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/CombinedContext$Serialized.class */
    static final class Serialized implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f42450a = new Companion(null);
        private static final long serialVersionUID = 0;
        private final CoroutineContext[] b;

        @Metadata
        /* loaded from: source-3503164-dex2jar.jar:kotlin/coroutines/CombinedContext$Serialized$Companion.class */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Serialized(CoroutineContext[] elements) {
            Intrinsics.e(elements, "elements");
            this.b = elements;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.b;
            EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f42457a;
            int length = coroutineContextArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return emptyCoroutineContext;
                }
                emptyCoroutineContext = emptyCoroutineContext.plus(coroutineContextArr[i2]);
                i = i2 + 1;
            }
        }
    }

    public CombinedContext(CoroutineContext left, CoroutineContext.Element element) {
        Intrinsics.e(left, "left");
        Intrinsics.e(element, "element");
        this.f42449a = left;
        this.b = element;
    }

    private final int a() {
        int i = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.f42449a;
            combinedContext = coroutineContext instanceof CombinedContext ? (CombinedContext) coroutineContext : null;
            if (combinedContext == null) {
                return i;
            }
            i++;
        }
    }

    private final boolean a(CombinedContext combinedContext) {
        while (a(combinedContext.b)) {
            CoroutineContext coroutineContext = combinedContext.f42449a;
            if (!(coroutineContext instanceof CombinedContext)) {
                return a((CoroutineContext.Element) coroutineContext);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
        return false;
    }

    private final boolean a(CoroutineContext.Element element) {
        return Intrinsics.a(get(element.getKey()), element);
    }

    private final Object writeReplace() {
        int a2 = a();
        final CoroutineContext[] coroutineContextArr = new CoroutineContext[a2];
        final Ref.IntRef intRef = new Ref.IntRef();
        fold(Unit.f42314a, new Function2<Unit, CoroutineContext.Element, Unit>() { // from class: kotlin.coroutines.CombinedContext$writeReplace$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final void a(Unit unit, CoroutineContext.Element element) {
                Intrinsics.e(unit, "<anonymous parameter 0>");
                Intrinsics.e(element, "element");
                CoroutineContext[] coroutineContextArr2 = coroutineContextArr;
                int i = intRef.f42543a;
                intRef.f42543a = i + 1;
                coroutineContextArr2[i] = element;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Unit invoke(Unit unit, CoroutineContext.Element element) {
                a(unit, element);
                return Unit.f42314a;
            }
        });
        if (intRef.f42543a == a2) {
            return new Serialized(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) obj;
                return combinedContext.a() == a() && combinedContext.a(this);
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        Intrinsics.e(operation, "operation");
        return operation.invoke((Object) this.f42449a.fold(r, operation), this.b);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        Intrinsics.e(key, "key");
        CombinedContext combinedContext = this;
        while (true) {
            CombinedContext combinedContext2 = combinedContext;
            E e = (E) combinedContext2.b.get(key);
            if (e != null) {
                return e;
            }
            CoroutineContext coroutineContext = combinedContext2.f42449a;
            if (!(coroutineContext instanceof CombinedContext)) {
                return (E) coroutineContext.get(key);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
    }

    public int hashCode() {
        return this.f42449a.hashCode() + this.b.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        Intrinsics.e(key, "key");
        if (this.b.get(key) != null) {
            return this.f42449a;
        }
        CoroutineContext minusKey = this.f42449a.minusKey(key);
        return minusKey == this.f42449a ? this : minusKey == EmptyCoroutineContext.f42457a ? this.b : new CombinedContext(minusKey, this.b);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.DefaultImpls.a(this, coroutineContext);
    }

    public String toString() {
        return '[' + ((String) fold("", new Function2<String, CoroutineContext.Element, String>() { // from class: kotlin.coroutines.CombinedContext$toString$1
            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a */
            public final String invoke(String acc, CoroutineContext.Element element) {
                Intrinsics.e(acc, "acc");
                Intrinsics.e(element, "element");
                if (acc.length() == 0) {
                    return element.toString();
                }
                return acc + ", " + element;
            }
        })) + ']';
    }
}
