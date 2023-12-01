package java.util.concurrent.atomic;

import dalvik.system.VMStack;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicReferenceFieldUpdater.class */
public abstract class AtomicReferenceFieldUpdater<T, V> {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/atomic/AtomicReferenceFieldUpdater$AtomicReferenceFieldUpdaterImpl.class */
    public static final class AtomicReferenceFieldUpdaterImpl<T, V> extends AtomicReferenceFieldUpdater<T, V> {
        private static final Unsafe unsafe = Unsafe.getUnsafe();
        private final Class<?> cclass;
        private final long offset;
        private final Class<T> tclass;
        private final Class<V> vclass;

        AtomicReferenceFieldUpdaterImpl(Class<T> cls, Class<V> cls2, String str) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                Class<?> stackClass2 = VMStack.getStackClass2();
                int modifiers = declaredField.getModifiers();
                if (cls2 != declaredField.getType()) {
                    throw new ClassCastException();
                }
                if (!Modifier.isVolatile(modifiers)) {
                    throw new IllegalArgumentException("Must be volatile type");
                }
                this.cclass = (!Modifier.isProtected(modifiers) || stackClass2 == cls) ? null : stackClass2;
                this.tclass = cls;
                if (cls2 == Object.class) {
                    this.vclass = null;
                } else {
                    this.vclass = cls2;
                }
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

        @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
        public boolean compareAndSet(T t, V v, V v2) {
            if (t == null || t.getClass() != this.tclass || this.cclass != null || (v2 != null && this.vclass != null && this.vclass != v2.getClass())) {
                updateCheck(t, v2);
            }
            return unsafe.compareAndSwapObject(t, this.offset, v, v2);
        }

        @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
        public V get(T t) {
            if (t == null || t.getClass() != this.tclass || this.cclass != null) {
                targetCheck(t);
            }
            return (V) unsafe.getObjectVolatile(t, this.offset);
        }

        @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
        public void lazySet(T t, V v) {
            if (t == null || t.getClass() != this.tclass || this.cclass != null || (v != null && this.vclass != null && this.vclass != v.getClass())) {
                updateCheck(t, v);
            }
            unsafe.putOrderedObject(t, this.offset, v);
        }

        @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
        public void set(T t, V v) {
            if (t == null || t.getClass() != this.tclass || this.cclass != null || (v != null && this.vclass != null && this.vclass != v.getClass())) {
                updateCheck(t, v);
            }
            unsafe.putObjectVolatile(t, this.offset, v);
        }

        void targetCheck(T t) {
            if (!this.tclass.isInstance(t)) {
                throw new ClassCastException();
            }
            if (this.cclass != null) {
                ensureProtectedAccess(t);
            }
        }

        void updateCheck(T t, V v) {
            if (!this.tclass.isInstance(t) || (v != null && this.vclass != null && !this.vclass.isInstance(v))) {
                throw new ClassCastException();
            }
            if (this.cclass != null) {
                ensureProtectedAccess(t);
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReferenceFieldUpdater
        public boolean weakCompareAndSet(T t, V v, V v2) {
            if (t == null || t.getClass() != this.tclass || this.cclass != null || (v2 != null && this.vclass != null && this.vclass != v2.getClass())) {
                updateCheck(t, v2);
            }
            return unsafe.compareAndSwapObject(t, this.offset, v, v2);
        }
    }

    protected AtomicReferenceFieldUpdater() {
    }

    public static <U, W> AtomicReferenceFieldUpdater<U, W> newUpdater(Class<U> cls, Class<W> cls2, String str) {
        return new AtomicReferenceFieldUpdaterImpl(cls, cls2, str);
    }

    public abstract boolean compareAndSet(T t, V v, V v2);

    public abstract V get(T t);

    public V getAndSet(T t, V v) {
        V v2;
        do {
            v2 = get(t);
        } while (!compareAndSet(t, v2, v));
        return v2;
    }

    public abstract void lazySet(T t, V v);

    public abstract void set(T t, V v);

    public abstract boolean weakCompareAndSet(T t, V v, V v2);
}
