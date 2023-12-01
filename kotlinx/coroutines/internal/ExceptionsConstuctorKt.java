package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlinx/coroutines/internal/ExceptionsConstuctorKt.class */
public final class ExceptionsConstuctorKt {
    private static final int a = a(Throwable.class, -1);
    private static final ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> c = new WeakHashMap<>();

    private static final int a(Class<?> cls, int i) {
        Object f;
        JvmClassMappingKt.a(cls);
        try {
            Result.Companion companion = Result.a;
            f = Result.f(Integer.valueOf(a(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.a;
            f = Result.f(ResultKt.a(th));
        }
        Integer num = f;
        if (Result.b(f)) {
            num = Integer.valueOf(i);
        }
        return ((Number) num).intValue();
    }

    static /* synthetic */ int a(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return b(cls, i);
    }

    public static final <E extends Throwable> E a(E e) {
        Object f;
        if (e instanceof CopyableThrowable) {
            try {
                Result.Companion companion = Result.a;
                f = Result.f(((CopyableThrowable) e).a());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.a;
                f = Result.f(ResultKt.a(th));
            }
            if (Result.b(f)) {
                f = null;
            }
            return (E) f;
        }
        ReentrantReadWriteLock.ReadLock readLock = b.readLock();
        readLock.lock();
        try {
            Function1<Throwable, Throwable> function1 = c.get(e.getClass());
            if (function1 != null) {
                return (E) function1.invoke(e);
            }
            if (a == a(e.getClass(), 0)) {
                Iterator it = ArraysKt.c((Object[]) e.getClass().getConstructors(), new Comparator<T>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.a(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
                    }
                }).iterator();
                Function1<Throwable, Throwable> function12 = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Function1<Throwable, Throwable> a2 = a((Constructor) it.next());
                    function12 = a2;
                    if (a2 != null) {
                        function12 = a2;
                        break;
                    }
                }
                ReentrantReadWriteLock reentrantReadWriteLock = b;
                ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
                int readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= readHoldCount) {
                        break;
                    }
                    readLock2.unlock();
                    i = i2 + 1;
                }
                ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    c.put(e.getClass(), function12 == null ? new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$5$1
                        @Override // kotlin.jvm.functions.Function1
                        /* renamed from: a */
                        public final Void invoke(Throwable th2) {
                            return null;
                        }
                    } : function12);
                    Unit unit = Unit.a;
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= readHoldCount) {
                            break;
                        }
                        readLock2.lock();
                        i3 = i4 + 1;
                    }
                    writeLock.unlock();
                    if (function12 == null) {
                        return null;
                    }
                    return (E) function12.invoke(e);
                } catch (Throwable th2) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 >= readHoldCount) {
                            break;
                        }
                        readLock2.lock();
                        i5 = i6 + 1;
                    }
                    writeLock.unlock();
                    throw th2;
                }
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = b;
            ReentrantReadWriteLock.ReadLock readLock3 = reentrantReadWriteLock2.readLock();
            int readHoldCount2 = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= readHoldCount2) {
                    break;
                }
                readLock3.unlock();
                i7 = i8 + 1;
            }
            ReentrantReadWriteLock.WriteLock writeLock2 = reentrantReadWriteLock2.writeLock();
            writeLock2.lock();
            try {
                c.put(e.getClass(), new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1
                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: a */
                    public final Void invoke(Throwable th3) {
                        return null;
                    }
                });
                Unit unit2 = Unit.a;
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 >= readHoldCount2) {
                        writeLock2.unlock();
                        return null;
                    }
                    readLock3.lock();
                    i9 = i10 + 1;
                }
            } catch (Throwable th3) {
                int i11 = 0;
                while (true) {
                    int i12 = i11;
                    if (i12 >= readHoldCount2) {
                        break;
                    }
                    readLock3.lock();
                    i11 = i12 + 1;
                }
                writeLock2.unlock();
                throw th3;
            }
        } finally {
            readLock.unlock();
        }
    }

    private static final Function1<Throwable, Throwable> a(final Constructor<?> constructor) {
        Function1<Throwable, Throwable> function1;
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            function1 = new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: a */
                public final Throwable invoke(Throwable th) {
                    Object f;
                    Object newInstance;
                    try {
                        Result.Companion companion = Result.a;
                        newInstance = Constructor.this.newInstance(new Object[0]);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.a;
                        f = Result.f(ResultKt.a(th2));
                    }
                    if (newInstance != null) {
                        Throwable th3 = (Throwable) newInstance;
                        th3.initCause(th);
                        f = Result.f(th3);
                        Object obj = f;
                        if (Result.b(f)) {
                            obj = null;
                        }
                        return (Throwable) obj;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
            };
        } else if (length == 1) {
            Class<?> cls = parameterTypes[0];
            if (Intrinsics.a(cls, Throwable.class)) {
                return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: a */
                    public final Throwable invoke(Throwable th) {
                        Object f;
                        Object newInstance;
                        try {
                            Result.Companion companion = Result.a;
                            newInstance = Constructor.this.newInstance(th);
                        } catch (Throwable th2) {
                            Result.Companion companion2 = Result.a;
                            f = Result.f(ResultKt.a(th2));
                        }
                        if (newInstance != null) {
                            f = Result.f((Throwable) newInstance);
                            Object obj = f;
                            if (Result.b(f)) {
                                obj = null;
                            }
                            return (Throwable) obj;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                };
            }
            function1 = null;
            if (Intrinsics.a(cls, String.class)) {
                return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    /* renamed from: a */
                    public final Throwable invoke(Throwable th) {
                        Object f;
                        Object newInstance;
                        try {
                            Result.Companion companion = Result.a;
                            newInstance = Constructor.this.newInstance(th.getMessage());
                        } catch (Throwable th2) {
                            Result.Companion companion2 = Result.a;
                            f = Result.f(ResultKt.a(th2));
                        }
                        if (newInstance != null) {
                            Throwable th3 = (Throwable) newInstance;
                            th3.initCause(th);
                            f = Result.f(th3);
                            Object obj = f;
                            if (Result.b(f)) {
                                obj = null;
                            }
                            return (Throwable) obj;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                };
            }
        } else if (length != 2) {
            return null;
        } else {
            function1 = null;
            if (Intrinsics.a(parameterTypes[0], String.class)) {
                function1 = null;
                if (Intrinsics.a(parameterTypes[1], Throwable.class)) {
                    return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        /* renamed from: a */
                        public final Throwable invoke(Throwable th) {
                            Object f;
                            Object newInstance;
                            try {
                                Result.Companion companion = Result.a;
                                newInstance = Constructor.this.newInstance(th.getMessage(), th);
                            } catch (Throwable th2) {
                                Result.Companion companion2 = Result.a;
                                f = Result.f(ResultKt.a(th2));
                            }
                            if (newInstance != null) {
                                f = Result.f((Throwable) newInstance);
                                Object obj = f;
                                if (Result.b(f)) {
                                    obj = null;
                                }
                                return (Throwable) obj;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                        }
                    };
                }
            }
        }
        return function1;
    }

    private static final int b(Class<?> cls, int i) {
        Field[] declaredFields;
        int i2;
        Class<? super Object> superclass;
        do {
            int length = cls.getDeclaredFields().length;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i3 < length) {
                    int i6 = i5;
                    if (!Modifier.isStatic(declaredFields[i3].getModifiers())) {
                        i6 = i5 + 1;
                    }
                    i3++;
                    i4 = i6;
                } else {
                    i2 = i + i5;
                    superclass = cls.getSuperclass();
                    cls = superclass;
                    i = i2;
                }
            }
        } while (superclass != null);
        return i2;
    }
}
