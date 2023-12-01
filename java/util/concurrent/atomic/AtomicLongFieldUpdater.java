package java.util.concurrent.atomic;

import dalvik.system.VMStack;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicLongFieldUpdater.class */
public abstract class AtomicLongFieldUpdater<T> {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicLongFieldUpdater$CASUpdater.class */
    public static class CASUpdater<T> extends AtomicLongFieldUpdater<T> {
        private static final Unsafe unsafe = Unsafe.getUnsafe();
        private final Class<?> cclass;
        private final long offset;
        private final Class<T> tclass;

        CASUpdater(Class<T> cls, String str) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                Class<?> stackClass2 = VMStack.getStackClass2();
                int modifiers = declaredField.getModifiers();
                if (declaredField.getType() != Long.TYPE) {
                    throw new IllegalArgumentException("Must be long type");
                }
                if (!Modifier.isVolatile(modifiers)) {
                    throw new IllegalArgumentException("Must be volatile type");
                }
                this.cclass = (!Modifier.isProtected(modifiers) || stackClass2 == cls) ? null : stackClass2;
                this.tclass = cls;
                this.offset = unsafe.objectFieldOffset(declaredField);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private void ensureProtectedAccess(T t) {
            if (!this.cclass.isInstance(t)) {
                throw new RuntimeException(new IllegalAccessException("Class " + this.cclass.getName() + " can not access a protected member of class " + this.tclass.getName() + " using an instance of " + t.getClass().getName()));
            }
        }

        private void fullCheck(T t) {
            if (!this.tclass.isInstance(t)) {
                throw new ClassCastException();
            }
            if (this.cclass != null) {
                ensureProtectedAccess(t);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public boolean compareAndSet(T t, long j, long j2) {
            if (t == null || t.getClass() != this.tclass || this.cclass != null) {
                fullCheck(t);
            }
            return unsafe.compareAndSwapLong(t, this.offset, j, j2);
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public long get(T t) {
            if (t == null || t.getClass() != this.tclass || this.cclass != null) {
                fullCheck(t);
            }
            return unsafe.getLongVolatile(t, this.offset);
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public void lazySet(T t, long j) {
            if (t == null || t.getClass() != this.tclass || this.cclass != null) {
                fullCheck(t);
            }
            unsafe.putOrderedLong(t, this.offset, j);
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public void set(T t, long j) {
            if (t == null || t.getClass() != this.tclass || this.cclass != null) {
                fullCheck(t);
            }
            unsafe.putLongVolatile(t, this.offset, j);
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public boolean weakCompareAndSet(T t, long j, long j2) {
            if (t == null || t.getClass() != this.tclass || this.cclass != null) {
                fullCheck(t);
            }
            return unsafe.compareAndSwapLong(t, this.offset, j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicLongFieldUpdater$LockedUpdater.class */
    public static class LockedUpdater<T> extends AtomicLongFieldUpdater<T> {
        private static final Unsafe unsafe = Unsafe.getUnsafe();
        private final Class<?> cclass;
        private final long offset;
        private final Class<T> tclass;

        LockedUpdater(Class<T> cls, String str) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                Class<?> stackClass2 = VMStack.getStackClass2();
                int modifiers = declaredField.getModifiers();
                if (declaredField.getType() != Long.TYPE) {
                    throw new IllegalArgumentException("Must be long type");
                }
                if (!Modifier.isVolatile(modifiers)) {
                    throw new IllegalArgumentException("Must be volatile type");
                }
                this.cclass = (!Modifier.isProtected(modifiers) || stackClass2 == cls) ? null : stackClass2;
                this.tclass = cls;
                this.offset = unsafe.objectFieldOffset(declaredField);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private void ensureProtectedAccess(T t) {
            if (!this.cclass.isInstance(t)) {
                throw new RuntimeException(new IllegalAccessException("Class " + this.cclass.getName() + " can not access a protected member of class " + this.tclass.getName() + " using an instance of " + t.getClass().getName()));
            }
        }

        private void fullCheck(T t) {
            if (!this.tclass.isInstance(t)) {
                throw new ClassCastException();
            }
            if (this.cclass != null) {
                ensureProtectedAccess(t);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public boolean compareAndSet(T t, long j, long j2) {
            if (t == null || t.getClass() != this.tclass || this.cclass != null) {
                fullCheck(t);
            }
            synchronized (this) {
                if (unsafe.getLong(t, this.offset) != j) {
                    return false;
                }
                unsafe.putLong(t, this.offset, j2);
                return true;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public long get(T t) {
            long j;
            if (t == null || t.getClass() != this.tclass || this.cclass != null) {
                fullCheck(t);
            }
            synchronized (this) {
                j = unsafe.getLong(t, this.offset);
            }
            return j;
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public void lazySet(T t, long j) {
            set(t, j);
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public void set(T t, long j) {
            if (t == null || t.getClass() != this.tclass || this.cclass != null) {
                fullCheck(t);
            }
            synchronized (this) {
                unsafe.putLong(t, this.offset, j);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLongFieldUpdater
        public boolean weakCompareAndSet(T t, long j, long j2) {
            return compareAndSet(t, j, j2);
        }
    }

    protected AtomicLongFieldUpdater() {
    }

    public static <U> AtomicLongFieldUpdater<U> newUpdater(Class<U> cls, String str) {
        return AtomicLong.VM_SUPPORTS_LONG_CAS ? new CASUpdater(cls, str) : new LockedUpdater(cls, str);
    }

    public long addAndGet(T t, long j) {
        long j2;
        long j3;
        do {
            j2 = get(t);
            j3 = j2 + j;
        } while (!compareAndSet(t, j2, j3));
        return j3;
    }

    public abstract boolean compareAndSet(T t, long j, long j2);

    public long decrementAndGet(T t) {
        long j;
        long j2;
        do {
            j = get(t);
            j2 = j - 1;
        } while (!compareAndSet(t, j, j2));
        return j2;
    }

    public abstract long get(T t);

    public long getAndAdd(T t, long j) {
        long j2;
        do {
            j2 = get(t);
        } while (!compareAndSet(t, j2, j2 + j));
        return j2;
    }

    public long getAndDecrement(T t) {
        long j;
        do {
            j = get(t);
        } while (!compareAndSet(t, j, j - 1));
        return j;
    }

    public long getAndIncrement(T t) {
        long j;
        do {
            j = get(t);
        } while (!compareAndSet(t, j, j + 1));
        return j;
    }

    public long getAndSet(T t, long j) {
        long j2;
        do {
            j2 = get(t);
        } while (!compareAndSet(t, j2, j));
        return j2;
    }

    public long incrementAndGet(T t) {
        long j;
        long j2;
        do {
            j = get(t);
            j2 = j + 1;
        } while (!compareAndSet(t, j, j2));
        return j2;
    }

    public abstract void lazySet(T t, long j);

    public abstract void set(T t, long j);

    public abstract boolean weakCompareAndSet(T t, long j, long j2);
}
