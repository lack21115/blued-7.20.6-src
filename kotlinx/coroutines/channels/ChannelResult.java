package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@JvmInline
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelResult.class */
public final class ChannelResult<T> {
    public static final Companion a = new Companion(null);
    private static final Failed c = new Failed();
    private final Object b;

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelResult$Closed.class */
    public static final class Closed extends Failed {
        public final Throwable a;

        public Closed(Throwable th) {
            this.a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Closed) && Intrinsics.a(this.a, ((Closed) obj).a);
        }

        public int hashCode() {
            Throwable th = this.a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.ChannelResult.Failed
        public String toString() {
            return "Closed(" + this.a + ')';
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelResult$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <E> Object a() {
            return ChannelResult.g(ChannelResult.c);
        }

        public final <E> Object a(E e) {
            return ChannelResult.g(e);
        }

        public final <E> Object a(Throwable th) {
            return ChannelResult.g(new Closed(th));
        }
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/channels/ChannelResult$Failed.class */
    public static class Failed {
        public String toString() {
            return "Failed";
        }
    }

    private /* synthetic */ ChannelResult(Object obj) {
        this.b = obj;
    }

    public static final boolean a(Object obj) {
        return obj instanceof Closed;
    }

    public static boolean a(Object obj, Object obj2) {
        return (obj2 instanceof ChannelResult) && Intrinsics.a(obj, ((ChannelResult) obj2).a());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T b(Object obj) {
        if (obj instanceof Failed) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final T c(Object obj) {
        if (obj instanceof Failed) {
            if (obj instanceof Closed) {
                Closed closed = (Closed) obj;
                if (closed.a != null) {
                    throw closed.a;
                }
            }
            throw new IllegalStateException(Intrinsics.a("Trying to call 'getOrThrow' on a failed channel result: ", obj).toString());
        }
        return obj;
    }

    public static final Throwable d(Object obj) {
        Closed closed = obj instanceof Closed ? (Closed) obj : null;
        if (closed == null) {
            return null;
        }
        return closed.a;
    }

    public static String e(Object obj) {
        if (obj instanceof Closed) {
            return obj.toString();
        }
        return "Value(" + obj + ')';
    }

    public static int f(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static <T> Object g(Object obj) {
        return obj;
    }

    public static final /* synthetic */ ChannelResult h(Object obj) {
        return new ChannelResult(obj);
    }

    public final /* synthetic */ Object a() {
        return this.b;
    }

    public boolean equals(Object obj) {
        return a(a(), obj);
    }

    public int hashCode() {
        return f(a());
    }

    public String toString() {
        return e(a());
    }
}
