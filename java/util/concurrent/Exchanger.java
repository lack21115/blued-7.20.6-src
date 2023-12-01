package java.util.concurrent;

import com.android.internal.telephony.PhoneConstants;
import dalvik.bytecode.Opcodes;
import sun.misc.Unsafe;

/* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Exchanger.class */
public class Exchanger<V> {
    private static final int ABASE;
    private static final int ASHIFT = 7;
    private static final long BLOCKER;
    private static final long BOUND;
    static final int FULL;
    private static final long MATCH;
    private static final int MMASK = 255;
    private static final int NCPU = Runtime.getRuntime().availableProcessors();
    private static final Object NULL_ITEM;
    private static final int SEQ = 256;
    private static final long SLOT;
    private static final int SPINS = 1024;
    private static final Object TIMED_OUT;
    private static final Unsafe U;
    private volatile Node[] arena;
    private volatile int bound;
    private final Participant participant = new Participant();
    private volatile Node slot;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Exchanger$Node.class */
    public static final class Node {
        int bound;
        int collides;
        int hash;
        int index;
        Object item;
        volatile Object match;
        Object p0;
        Object p1;
        Object p2;
        Object p3;
        Object p4;
        Object p5;
        Object p6;
        Object p7;
        Object p8;
        Object p9;
        Object pa;
        volatile Thread parked;
        Object pb;
        Object pc;
        Object pd;
        Object pe;
        Object pf;
        Object q0;
        Object q1;
        Object q2;
        Object q3;
        Object q4;
        Object q5;
        Object q6;
        Object q7;
        Object q8;
        Object q9;
        Object qa;
        Object qb;
        Object qc;
        Object qd;
        Object qe;
        Object qf;

        Node() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-2895416-dex2jar.jar:java/util/concurrent/Exchanger$Participant.class */
    public static final class Participant extends ThreadLocal<Node> {
        Participant() {
        }

        @Override // java.lang.ThreadLocal
        public Node initialValue() {
            return new Node();
        }
    }

    static {
        FULL = NCPU >= 510 ? 255 : NCPU >>> 1;
        NULL_ITEM = new Object();
        TIMED_OUT = new Object();
        try {
            U = Unsafe.getUnsafe();
            BOUND = U.objectFieldOffset(Exchanger.class.getDeclaredField("bound"));
            SLOT = U.objectFieldOffset(Exchanger.class.getDeclaredField(PhoneConstants.SLOT_KEY));
            MATCH = U.objectFieldOffset(Node.class.getDeclaredField("match"));
            BLOCKER = U.objectFieldOffset(Thread.class.getDeclaredField("parkBlocker"));
            int arrayIndexScale = U.arrayIndexScale(Node[].class);
            ABASE = U.arrayBaseOffset(Node[].class) + 128;
            if (((arrayIndexScale - 1) & arrayIndexScale) != 0 || arrayIndexScale > 128) {
                throw new Error("Unsupported array scale");
            }
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private final Object arenaExchange(Object obj, boolean z, long j) {
        int i;
        Node[] nodeArr = this.arena;
        Node node = this.participant.get();
        int i2 = node.index;
        while (true) {
            Unsafe unsafe = U;
            long j2 = (i2 << 7) + ABASE;
            Node node2 = (Node) unsafe.getObjectVolatile(nodeArr, j2);
            if (node2 != null && U.compareAndSwapObject(nodeArr, j2, node2, null)) {
                Object obj2 = node2.item;
                node2.match = obj;
                Thread thread = node2.parked;
                if (thread != null) {
                    U.unpark(thread);
                }
                return obj2;
            }
            int i3 = this.bound;
            int i4 = i3 & 255;
            if (i2 > i4 || node2 != null) {
                if (node.bound != i3) {
                    node.bound = i3;
                    node.collides = 0;
                    i = (i2 != i4 || i4 == 0) ? i4 : i4 - 1;
                } else {
                    int i5 = node.collides;
                    if (i5 < i4 || i4 == FULL || !U.compareAndSwapInt(this, BOUND, i3, i3 + 256 + 1)) {
                        node.collides = i5 + 1;
                        i = i2 == 0 ? i4 : i2 - 1;
                    } else {
                        i = i4 + 1;
                    }
                }
                i2 = i;
                node.index = i2;
            } else {
                node.item = obj;
                if (U.compareAndSwapObject(nodeArr, j2, null, node)) {
                    long nanoTime = (z && i4 == 0) ? System.nanoTime() + j : 0L;
                    Thread currentThread = Thread.currentThread();
                    int i6 = node.hash;
                    int i7 = 1024;
                    while (true) {
                        Object obj3 = node.match;
                        if (obj3 != null) {
                            U.putOrderedObject(node, MATCH, null);
                            node.item = null;
                            node.hash = i6;
                            return obj3;
                        } else if (i7 > 0) {
                            int i8 = i6 ^ (i6 << 1);
                            int i9 = i8 ^ (i8 >>> 3);
                            int i10 = i9 ^ (i9 << 10);
                            if (i10 == 0) {
                                i6 = ((int) currentThread.getId()) | 1024;
                            } else {
                                i6 = i10;
                                if (i10 < 0) {
                                    int i11 = i7 - 1;
                                    i6 = i10;
                                    i7 = i11;
                                    if ((i11 & Opcodes.OP_CHECK_CAST_JUMBO) == 0) {
                                        Thread.yield();
                                        i6 = i10;
                                        i7 = i11;
                                    }
                                }
                            }
                        } else if (U.getObjectVolatile(nodeArr, j2) != node) {
                            i7 = 1024;
                        } else {
                            long j3 = j;
                            if (!currentThread.isInterrupted()) {
                                j3 = j;
                                if (i4 == 0) {
                                    if (z) {
                                        j = nanoTime - System.nanoTime();
                                        j3 = j;
                                        if (j > 0) {
                                        }
                                    }
                                    U.putObject(currentThread, BLOCKER, this);
                                    node.parked = currentThread;
                                    if (U.getObjectVolatile(nodeArr, j2) == node) {
                                        U.park(false, j);
                                    }
                                    node.parked = null;
                                    U.putObject(currentThread, BLOCKER, null);
                                }
                            }
                            j = j3;
                            if (U.getObjectVolatile(nodeArr, j2) == node) {
                                j = j3;
                                if (U.compareAndSwapObject(nodeArr, j2, node, null)) {
                                    if (i4 != 0) {
                                        U.compareAndSwapInt(this, BOUND, i3, (i3 + 256) - 1);
                                    }
                                    node.item = null;
                                    node.hash = i6;
                                    int i12 = node.index >>> 1;
                                    node.index = i12;
                                    if (Thread.interrupted()) {
                                        return null;
                                    }
                                    i2 = i12;
                                    j = j3;
                                    if (z) {
                                        i2 = i12;
                                        j = j3;
                                        if (i4 == 0) {
                                            i2 = i12;
                                            j = j3;
                                            if (j3 <= 0) {
                                                return TIMED_OUT;
                                            }
                                        } else {
                                            continue;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                } else {
                    node.item = null;
                }
            }
        }
    }

    private final Object slotExchange(Object obj, boolean z, long j) {
        Object obj2;
        Object obj3;
        Node node = this.participant.get();
        Thread currentThread = Thread.currentThread();
        if (currentThread.isInterrupted()) {
            obj2 = null;
        } else {
            while (true) {
                Node node2 = this.slot;
                if (node2 != null) {
                    if (U.compareAndSwapObject(this, SLOT, node2, null)) {
                        Object obj4 = node2.item;
                        node2.match = obj;
                        Thread thread = node2.parked;
                        obj2 = obj4;
                        if (thread != null) {
                            U.unpark(thread);
                            return obj4;
                        }
                    } else if (NCPU > 1 && this.bound == 0 && U.compareAndSwapInt(this, BOUND, 0, 256)) {
                        this.arena = new Node[(FULL + 2) << 7];
                    }
                } else if (this.arena != null) {
                    return null;
                } else {
                    node.item = obj;
                    if (U.compareAndSwapObject(this, SLOT, null, node)) {
                        int i = node.hash;
                        long nanoTime = z ? System.nanoTime() + j : 0L;
                        int i2 = NCPU > 1 ? 1024 : 1;
                        while (true) {
                            Object obj5 = node.match;
                            obj3 = obj5;
                            if (obj5 != null) {
                                break;
                            } else if (i2 > 0) {
                                int i3 = i ^ (i << 1);
                                int i4 = i3 ^ (i3 >>> 3);
                                int i5 = i4 ^ (i4 << 10);
                                if (i5 == 0) {
                                    i = ((int) currentThread.getId()) | 1024;
                                } else {
                                    i = i5;
                                    if (i5 < 0) {
                                        int i6 = i2 - 1;
                                        i = i5;
                                        i2 = i6;
                                        if ((i6 & Opcodes.OP_CHECK_CAST_JUMBO) == 0) {
                                            Thread.yield();
                                            i = i5;
                                            i2 = i6;
                                        }
                                    }
                                }
                            } else if (this.slot != node) {
                                i2 = 1024;
                            } else {
                                long j2 = j;
                                if (!currentThread.isInterrupted()) {
                                    j2 = j;
                                    if (this.arena == null) {
                                        if (z) {
                                            j = nanoTime - System.nanoTime();
                                            j2 = j;
                                            if (j > 0) {
                                            }
                                        }
                                        U.putObject(currentThread, BLOCKER, this);
                                        node.parked = currentThread;
                                        if (this.slot == node) {
                                            U.park(false, j);
                                        }
                                        node.parked = null;
                                        U.putObject(currentThread, BLOCKER, null);
                                    }
                                }
                                j = j2;
                                if (U.compareAndSwapObject(this, SLOT, node, null)) {
                                    obj3 = (!z || j2 > 0 || currentThread.isInterrupted()) ? null : TIMED_OUT;
                                }
                            }
                        }
                        U.putOrderedObject(node, MATCH, null);
                        node.item = null;
                        node.hash = i;
                        return obj3;
                    }
                    node.item = null;
                }
            }
        }
        return obj2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        if (r7 != java.util.concurrent.Exchanger.NULL_ITEM) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0047, code lost:
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
        return (V) r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
        if (r0 == null) goto L14;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V exchange(V r7) throws java.lang.InterruptedException {
        /*
            r6 = this;
            r0 = r7
            if (r0 != 0) goto L39
            java.lang.Object r0 = java.util.concurrent.Exchanger.NULL_ITEM
            r8 = r0
        L8:
            r0 = r6
            java.util.concurrent.Exchanger$Node[] r0 = r0.arena
            if (r0 != 0) goto L1d
            r0 = r6
            r1 = r8
            r2 = 0
            r3 = 0
            java.lang.Object r0 = r0.slotExchange(r1, r2, r3)
            r9 = r0
            r0 = r9
            r7 = r0
            r0 = r9
            if (r0 != 0) goto L3e
        L1d:
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 != 0) goto L31
            r0 = r6
            r1 = r8
            r2 = 0
            r3 = 0
            java.lang.Object r0 = r0.arenaExchange(r1, r2, r3)
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r8
            if (r0 != 0) goto L3e
        L31:
            java.lang.InterruptedException r0 = new java.lang.InterruptedException
            r1 = r0
            r1.<init>()
            throw r0
        L39:
            r0 = r7
            r8 = r0
            goto L8
        L3e:
            r0 = r7
            r8 = r0
            r0 = r7
            java.lang.Object r1 = java.util.concurrent.Exchanger.NULL_ITEM
            if (r0 != r1) goto L49
            r0 = 0
            r8 = r0
        L49:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.Exchanger.exchange(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
        if (r0 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (r7 != java.util.concurrent.Exchanger.TIMED_OUT) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005d, code lost:
        throw new java.util.concurrent.TimeoutException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005e, code lost:
        r10 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0065, code lost:
        if (r7 != java.util.concurrent.Exchanger.NULL_ITEM) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
        r10 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006d, code lost:
        return (V) r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V exchange(V r7, long r8, java.util.concurrent.TimeUnit r10) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r6 = this;
            r0 = r7
            if (r0 != 0) goto L49
            java.lang.Object r0 = java.util.concurrent.Exchanger.NULL_ITEM
            r11 = r0
        L9:
            r0 = r10
            r1 = r8
            long r0 = r0.toNanos(r1)
            r8 = r0
            r0 = r6
            java.util.concurrent.Exchanger$Node[] r0 = r0.arena
            if (r0 != 0) goto L29
            r0 = r6
            r1 = r11
            r2 = 1
            r3 = r8
            java.lang.Object r0 = r0.slotExchange(r1, r2, r3)
            r10 = r0
            r0 = r10
            r7 = r0
            r0 = r10
            if (r0 != 0) goto L4f
        L29:
            boolean r0 = java.lang.Thread.interrupted()
            if (r0 != 0) goto L41
            r0 = r6
            r1 = r11
            r2 = 1
            r3 = r8
            java.lang.Object r0 = r0.arenaExchange(r1, r2, r3)
            r10 = r0
            r0 = r10
            r7 = r0
            r0 = r10
            if (r0 != 0) goto L4f
        L41:
            java.lang.InterruptedException r0 = new java.lang.InterruptedException
            r1 = r0
            r1.<init>()
            throw r0
        L49:
            r0 = r7
            r11 = r0
            goto L9
        L4f:
            r0 = r7
            java.lang.Object r1 = java.util.concurrent.Exchanger.TIMED_OUT
            if (r0 != r1) goto L5e
            java.util.concurrent.TimeoutException r0 = new java.util.concurrent.TimeoutException
            r1 = r0
            r1.<init>()
            throw r0
        L5e:
            r0 = r7
            r10 = r0
            r0 = r7
            java.lang.Object r1 = java.util.concurrent.Exchanger.NULL_ITEM
            if (r0 != r1) goto L6b
            r0 = 0
            r10 = r0
        L6b:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.concurrent.Exchanger.exchange(java.lang.Object, long, java.util.concurrent.TimeUnit):java.lang.Object");
    }
}
