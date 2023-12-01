package kotlinx.coroutines.internal;

import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/StackTraceRecoveryKt.class */
public final class StackTraceRecoveryKt {
    private static final String a;
    private static final String b;

    static {
        Object f;
        Object f2;
        try {
            Result.Companion companion = Result.a;
            f = Result.f(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.a;
            f = Result.f(ResultKt.a(th));
        }
        a = Result.c(f) == null ? f : "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        try {
            Result.Companion companion3 = Result.a;
            f2 = Result.f(Class.forName("kotlinx.coroutines.internal.StackTraceRecoveryKt").getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.a;
            f2 = Result.f(ResultKt.a(th2));
        }
        b = Result.c(f2) == null ? f2 : "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    }

    private static final int a(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return -1;
            }
            if (Intrinsics.a((Object) str, (Object) stackTraceElementArr[i2].getClassName())) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static final StackTraceElement a(String str) {
        return new StackTraceElement(Intrinsics.a("\b\b\b(", (Object) str), "\b", "\b", -1);
    }

    public static final <E extends Throwable> E a(E e) {
        Throwable a2;
        if (DebugKt.c() && (a2 = ExceptionsConstuctorKt.a(e)) != null) {
            return (E) c(a2);
        }
        return e;
    }

    private static final <E extends Throwable> E a(E e, E e2, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(a("Coroutine boundary"));
        StackTraceElement[] stackTrace = e.getStackTrace();
        int a2 = a(stackTrace, a);
        if (a2 == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            if (array != null) {
                e2.setStackTrace((StackTraceElement[]) array);
                return e2;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + a2];
        if (a2 > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                int i3 = i2 + 1;
                stackTraceElementArr[i2] = stackTrace[i2];
                if (i3 >= a2) {
                    break;
                }
                i = i3;
            }
        }
        Iterator<StackTraceElement> it = arrayDeque.iterator();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (!it.hasNext()) {
                e2.setStackTrace(stackTraceElementArr);
                return e2;
            }
            stackTraceElementArr[i5 + a2] = it.next();
            i4 = i5 + 1;
        }
    }

    public static final /* synthetic */ Throwable a(Throwable th, CoroutineStackFrame coroutineStackFrame) {
        return b(th, coroutineStackFrame);
    }

    private static final ArrayDeque<StackTraceElement> a(CoroutineStackFrame coroutineStackFrame) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            if (!(coroutineStackFrame instanceof CoroutineStackFrame)) {
                coroutineStackFrame = null;
            }
            coroutineStackFrame = coroutineStackFrame == null ? null : coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
    }

    private static final void a(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int i;
        int length = stackTraceElementArr.length;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= length) {
                i = -1;
                break;
            } else if (a(stackTraceElementArr[i])) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        int i3 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i3 > length2) {
            return;
        }
        while (true) {
            if (a(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i3) {
                return;
            }
            length2--;
        }
    }

    public static final boolean a(StackTraceElement stackTraceElement) {
        return StringsKt.a(stackTraceElement.getClassName(), "\b\b\b", false, 2, (Object) null);
    }

    private static final boolean a(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && Intrinsics.a((Object) stackTraceElement.getMethodName(), (Object) stackTraceElement2.getMethodName()) && Intrinsics.a((Object) stackTraceElement.getFileName(), (Object) stackTraceElement2.getFileName()) && Intrinsics.a((Object) stackTraceElement.getClassName(), (Object) stackTraceElement2.getClassName());
    }

    public static final <E extends Throwable> E b(E e) {
        boolean z;
        E e2 = (E) e.getCause();
        if (e2 != null) {
            if (!Intrinsics.a(e2.getClass(), e.getClass())) {
                return e;
            }
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                int i2 = i;
                z = false;
                if (i2 >= length) {
                    break;
                } else if (a(stackTrace[i2])) {
                    z = true;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (z) {
                return e2;
            }
        }
        return e;
    }

    public static final <E extends Throwable> E b(E e, CoroutineStackFrame coroutineStackFrame) {
        Pair d = d(e);
        Throwable th = (Throwable) d.c();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) d.d();
        Throwable a2 = ExceptionsConstuctorKt.a(th);
        if (a2 != null && Intrinsics.a((Object) a2.getMessage(), (Object) th.getMessage())) {
            ArrayDeque<StackTraceElement> a3 = a(coroutineStackFrame);
            if (a3.isEmpty()) {
                return e;
            }
            if (th != e) {
                a(stackTraceElementArr, a3);
            }
            return (E) a(th, a2, a3);
        }
        return e;
    }

    private static final <E extends Throwable> E c(E e) {
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int a2 = a(stackTrace, b);
        int a3 = a(stackTrace, a);
        int i = (length - a2) - (a3 == -1 ? 0 : length - a3);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                e.setStackTrace(stackTraceElementArr);
                return e;
            }
            stackTraceElementArr[i3] = i3 == 0 ? a("Coroutine boundary") : stackTrace[((a2 + 1) + i3) - 1];
            i2 = i3 + 1;
        }
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> d(E e) {
        boolean z;
        Throwable cause = e.getCause();
        if (cause == null || !Intrinsics.a(cause.getClass(), e.getClass())) {
            return TuplesKt.a(e, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                z = false;
                break;
            } else if (a(stackTrace[i2])) {
                z = true;
                break;
            } else {
                i = i2 + 1;
            }
        }
        return z ? TuplesKt.a(cause, stackTrace) : TuplesKt.a(e, new StackTraceElement[0]);
    }
}
