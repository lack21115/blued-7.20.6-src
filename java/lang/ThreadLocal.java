package java.lang;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-2895416-dex2jar.jar:java/lang/ThreadLocal.class */
public class ThreadLocal<T> {
    private static AtomicInteger hashCounter = new AtomicInteger(0);
    private final Reference<ThreadLocal<T>> reference = new WeakReference(this);
    private final int hash = hashCounter.getAndAdd(-1013904242);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/lang/ThreadLocal$Values.class */
    public static class Values {
        private static final int INITIAL_SIZE = 16;
        private static final Object TOMBSTONE = new Object();
        private int clean;
        private int mask;
        private int maximumLoad;
        private int size;
        private Object[] table;
        private int tombstones;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Values() {
            initializeTable(16);
            this.size = 0;
            this.tombstones = 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Values(Values values) {
            this.table = (Object[]) values.table.clone();
            this.mask = values.mask;
            this.size = values.size;
            this.tombstones = values.tombstones;
            this.maximumLoad = values.maximumLoad;
            this.clean = values.clean;
            inheritValues(values);
        }

        private void cleanUp() {
            if (rehash() || this.size == 0) {
                return;
            }
            int i = this.clean;
            Object[] objArr = this.table;
            int length = objArr.length;
            while (length > 0) {
                Object obj = objArr[i];
                if (obj != TOMBSTONE && obj != null && ((Reference) obj).get() == null) {
                    objArr[i] = TOMBSTONE;
                    objArr[i + 1] = null;
                    this.tombstones++;
                    this.size--;
                }
                length >>= 1;
                i = next(i);
            }
            this.clean = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void inheritValues(Values values) {
            Object[] objArr = this.table;
            int length = objArr.length;
            while (true) {
                int i = length - 2;
                if (i < 0) {
                    return;
                }
                Object obj = objArr[i];
                if (obj != null && obj != TOMBSTONE) {
                    InheritableThreadLocal inheritableThreadLocal = (InheritableThreadLocal) ((Reference) obj).get();
                    if (inheritableThreadLocal != 0) {
                        objArr[i + 1] = inheritableThreadLocal.childValue(values.table[i + 1]);
                    } else {
                        objArr[i] = TOMBSTONE;
                        objArr[i + 1] = null;
                        values.table[i] = TOMBSTONE;
                        values.table[i + 1] = null;
                        this.tombstones++;
                        values.tombstones++;
                        this.size--;
                        values.size--;
                    }
                }
                length = i;
            }
        }

        private void initializeTable(int i) {
            this.table = new Object[i * 2];
            this.mask = this.table.length - 1;
            this.clean = 0;
            this.maximumLoad = (i * 2) / 3;
        }

        private int next(int i) {
            return (i + 2) & this.mask;
        }

        private boolean rehash() {
            if (this.tombstones + this.size < this.maximumLoad) {
                return false;
            }
            int length = this.table.length >> 1;
            int i = length;
            if (this.size > (length >> 1)) {
                i = length * 2;
            }
            Object[] objArr = this.table;
            initializeTable(i);
            this.tombstones = 0;
            if (this.size == 0) {
                return true;
            }
            int length2 = objArr.length;
            while (true) {
                int i2 = length2 - 2;
                if (i2 < 0) {
                    return true;
                }
                Object obj = objArr[i2];
                if (obj != null && obj != TOMBSTONE) {
                    ThreadLocal<?> threadLocal = (ThreadLocal) ((Reference) obj).get();
                    if (threadLocal != null) {
                        add(threadLocal, objArr[i2 + 1]);
                    } else {
                        this.size--;
                    }
                }
                length2 = i2;
            }
        }

        void add(ThreadLocal<?> threadLocal, Object obj) {
            int i = ((ThreadLocal) threadLocal).hash & this.mask;
            while (true) {
                int i2 = i;
                if (this.table[i2] == null) {
                    this.table[i2] = ((ThreadLocal) threadLocal).reference;
                    this.table[i2 + 1] = obj;
                    return;
                }
                i = next(i2);
            }
        }

        Object getAfterMiss(ThreadLocal<?> threadLocal) {
            Object[] objArr = this.table;
            int i = ((ThreadLocal) threadLocal).hash & this.mask;
            if (objArr[i] == null) {
                Object initialValue = threadLocal.initialValue();
                if (this.table != objArr || objArr[i] != null) {
                    put(threadLocal, initialValue);
                    return initialValue;
                }
                objArr[i] = ((ThreadLocal) threadLocal).reference;
                objArr[i + 1] = initialValue;
                this.size++;
                cleanUp();
                return initialValue;
            }
            int i2 = -1;
            int next = next(i);
            while (true) {
                Object obj = objArr[next];
                if (obj == ((ThreadLocal) threadLocal).reference) {
                    return objArr[next + 1];
                }
                if (obj == null) {
                    Object initialValue2 = threadLocal.initialValue();
                    if (this.table == objArr) {
                        if (i2 > -1 && objArr[i2] == TOMBSTONE) {
                            objArr[i2] = ((ThreadLocal) threadLocal).reference;
                            objArr[i2 + 1] = initialValue2;
                            this.tombstones--;
                            this.size++;
                            return initialValue2;
                        } else if (objArr[next] == null) {
                            objArr[next] = ((ThreadLocal) threadLocal).reference;
                            objArr[next + 1] = initialValue2;
                            this.size++;
                            cleanUp();
                            return initialValue2;
                        }
                    }
                    put(threadLocal, initialValue2);
                    return initialValue2;
                }
                int i3 = i2;
                if (i2 == -1) {
                    i3 = i2;
                    if (obj == TOMBSTONE) {
                        i3 = next;
                    }
                }
                next = next(next);
                i2 = i3;
            }
        }

        void put(ThreadLocal<?> threadLocal, Object obj) {
            cleanUp();
            int i = -1;
            int i2 = ((ThreadLocal) threadLocal).hash & this.mask;
            while (true) {
                Object obj2 = this.table[i2];
                if (obj2 == ((ThreadLocal) threadLocal).reference) {
                    this.table[i2 + 1] = obj;
                    return;
                } else if (obj2 == null) {
                    if (i == -1) {
                        this.table[i2] = ((ThreadLocal) threadLocal).reference;
                        this.table[i2 + 1] = obj;
                        this.size++;
                        return;
                    }
                    this.table[i] = ((ThreadLocal) threadLocal).reference;
                    this.table[i + 1] = obj;
                    this.tombstones--;
                    this.size++;
                    return;
                } else {
                    int i3 = i;
                    if (i == -1) {
                        i3 = i;
                        if (obj2 == TOMBSTONE) {
                            i3 = i2;
                        }
                    }
                    i2 = next(i2);
                    i = i3;
                }
            }
        }

        void remove(ThreadLocal<?> threadLocal) {
            cleanUp();
            int i = ((ThreadLocal) threadLocal).hash & this.mask;
            while (true) {
                int i2 = i;
                Object obj = this.table[i2];
                if (obj == ((ThreadLocal) threadLocal).reference) {
                    this.table[i2] = TOMBSTONE;
                    this.table[i2 + 1] = null;
                    this.tombstones++;
                    this.size--;
                    return;
                } else if (obj == null) {
                    return;
                } else {
                    i = next(i2);
                }
            }
        }
    }

    public T get() {
        Thread currentThread = Thread.currentThread();
        Values values = values(currentThread);
        if (values != null) {
            Object[] objArr = values.table;
            int i = this.hash & values.mask;
            if (this.reference == objArr[i]) {
                return (T) objArr[i + 1];
            }
        } else {
            values = initializeValues(currentThread);
        }
        return (T) values.getAfterMiss(this);
    }

    protected T initialValue() {
        return null;
    }

    Values initializeValues(Thread thread) {
        Values values = new Values();
        thread.localValues = values;
        return values;
    }

    public void remove() {
        Values values = values(Thread.currentThread());
        if (values != null) {
            values.remove(this);
        }
    }

    public void set(T t) {
        Thread currentThread = Thread.currentThread();
        Values values = values(currentThread);
        Values values2 = values;
        if (values == null) {
            values2 = initializeValues(currentThread);
        }
        values2.put(this, t);
    }

    Values values(Thread thread) {
        return thread.localValues;
    }
}
