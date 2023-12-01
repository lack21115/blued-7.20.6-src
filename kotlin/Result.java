package kotlin;

import java.io.Serializable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@JvmInline
/* loaded from: source-3503164-dex2jar.jar:kotlin/Result.class */
public final class Result<T> implements Serializable {
    public static final Companion a = new Companion(null);
    private final Object b;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/Result$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/Result$Failure.class */
    public static final class Failure implements Serializable {
        public final Throwable a;

        public Failure(Throwable exception) {
            Intrinsics.e(exception, "exception");
            this.a = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && Intrinsics.a(this.a, ((Failure) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.a + ')';
        }
    }

    private /* synthetic */ Result(Object obj) {
        this.b = obj;
    }

    public static final boolean a(Object obj) {
        return !(obj instanceof Failure);
    }

    public static boolean a(Object obj, Object obj2) {
        return (obj2 instanceof Result) && Intrinsics.a(obj, ((Result) obj2).a());
    }

    public static final boolean b(Object obj) {
        return obj instanceof Failure;
    }

    public static final Throwable c(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).a;
        }
        return null;
    }

    public static String d(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static <T> Object f(Object obj) {
        return obj;
    }

    public static final /* synthetic */ Result g(Object obj) {
        return new Result(obj);
    }

    public final /* synthetic */ Object a() {
        return this.b;
    }

    public boolean equals(Object obj) {
        return a(this.b, obj);
    }

    public int hashCode() {
        return e(this.b);
    }

    public String toString() {
        return d(this.b);
    }
}
