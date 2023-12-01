package java.util.concurrent.atomic;

import dalvik.system.VMStack;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicIntegerFieldUpdater.class */
public abstract class AtomicIntegerFieldUpdater<T> {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicIntegerFieldUpdater$AtomicIntegerFieldUpdaterImpl.class */
    public static class AtomicIntegerFieldUpdaterImpl<T> extends AtomicIntegerFieldUpdater<T> {
        private static final Unsafe unsafe = Unsafe.getUnsafe();
        private final Class<?> cclass;
        private final long offset;
        private final Class<T> tclass;

        AtomicIntegerFieldUpdaterImpl(Class<T> cls, String str) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                Class<?> stackClass2 = VMStack.getStackClass2();
                int modifiers = declaredField.getModifiers();
                if (declaredField.getType() != Integer.TYPE) {
                    throw new IllegalArgumentException("Must be integer type");
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

        @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
        public boolean compareAndSet(T t, int i, int i2) {
            if (t == null || t.getClass() != this.tclass || this.cclass != null) {
                fullCheck(t);
            }
            return unsafe.compareAndSwapInt(t, this.offset, i, i2);
        }

        @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
        public final int get(T t) {
            if (t == null || t.getClass() != this.tclass || this.cclass != null) {
                fullCheck(t);
            }
            return unsafe.getIntVolatile(t, this.offset);
        }

        @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
        public void lazySet(T t, int i) {
            if (t == null || t.getClass() != this.tclass || this.cclass != null) {
                fullCheck(t);
            }
            unsafe.putOrderedInt(t, this.offset, i);
        }

        @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
        public void set(T t, int i) {
            if (t == null || t.getClass() != this.tclass || this.cclass != null) {
                fullCheck(t);
            }
            unsafe.putIntVolatile(t, this.offset, i);
        }

        @Override // java.util.concurrent.atomic.AtomicIntegerFieldUpdater
        public boolean weakCompareAndSet(T t, int i, int i2) {
            if (t == null || t.getClass() != this.tclass || this.cclass != null) {
                fullCheck(t);
            }
            return unsafe.compareAndSwapInt(t, this.offset, i, i2);
        }
    }

    protected AtomicIntegerFieldUpdater() {
    }

    public static <U> AtomicIntegerFieldUpdater<U> newUpdater(Class<U> cls, String str) {
        return new AtomicIntegerFieldUpdaterImpl(cls, str);
    }

    public int addAndGet(T t, int i) {
        int i2;
        int i3;
        do {
            i2 = get(t);
            i3 = i2 + i;
        } while (!compareAndSet(t, i2, i3));
        return i3;
    }

    public abstract boolean compareAndSet(T t, int i, int i2);

    public int decrementAndGet(T t) {
        int i;
        int i2;
        do {
            i = get(t);
            i2 = i - 1;
        } while (!compareAndSet(t, i, i2));
        return i2;
    }

    public abstract int get(T t);

    public int getAndAdd(T t, int i) {
        int i2;
        do {
            i2 = get(t);
        } while (!compareAndSet(t, i2, i2 + i));
        return i2;
    }

    public int getAndDecrement(T t) {
        int i;
        do {
            i = get(t);
        } while (!compareAndSet(t, i, i - 1));
        return i;
    }

    public int getAndIncrement(T t) {
        int i;
        do {
            i = get(t);
        } while (!compareAndSet(t, i, i + 1));
        return i;
    }

    public int getAndSet(T t, int i) {
        int i2;
        do {
            i2 = get(t);
        } while (!compareAndSet(t, i2, i));
        return i2;
    }

    public int incrementAndGet(T t) {
        int i;
        int i2;
        do {
            i = get(t);
            i2 = i + 1;
        } while (!compareAndSet(t, i, i2));
        return i2;
    }

    public abstract void lazySet(T t, int i);

    public abstract void set(T t, int i);

    public abstract boolean weakCompareAndSet(T t, int i, int i2);
}
