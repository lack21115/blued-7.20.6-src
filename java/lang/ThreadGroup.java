package java.lang;

import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import libcore.util.CollectionUtils;

/* loaded from: source-2895416-dex2jar.jar:java/lang/ThreadGroup.class */
public class ThreadGroup implements Thread.UncaughtExceptionHandler {
    private final List<ThreadGroup> groups;
    private boolean isDaemon;
    private boolean isDestroyed;
    private int maxPriority;
    private String name;
    final ThreadGroup parent;
    private final List<WeakReference<Thread>> threadRefs;
    private final Iterable<Thread> threads;
    static final ThreadGroup systemThreadGroup = new ThreadGroup();
    static final ThreadGroup mainThreadGroup = new ThreadGroup(systemThreadGroup, "main");

    private ThreadGroup() {
        this.maxPriority = 10;
        this.threadRefs = new ArrayList(5);
        this.threads = CollectionUtils.dereferenceIterable(this.threadRefs, true);
        this.groups = new ArrayList(3);
        this.name = "system";
        this.parent = null;
    }

    public ThreadGroup(String str) {
        this(Thread.currentThread().getThreadGroup(), str);
    }

    public ThreadGroup(ThreadGroup threadGroup, String str) {
        this.maxPriority = 10;
        this.threadRefs = new ArrayList(5);
        this.threads = CollectionUtils.dereferenceIterable(this.threadRefs, true);
        this.groups = new ArrayList(3);
        if (threadGroup == null) {
            throw new NullPointerException("parent == null");
        }
        this.name = str;
        this.parent = threadGroup;
        if (threadGroup != null) {
            threadGroup.add(this);
            setMaxPriority(threadGroup.getMaxPriority());
            if (threadGroup.isDaemon()) {
                setDaemon(true);
            }
        }
    }

    private void add(ThreadGroup threadGroup) throws IllegalThreadStateException {
        synchronized (this.groups) {
            if (this.isDestroyed) {
                throw new IllegalThreadStateException();
            }
            this.groups.add(threadGroup);
        }
    }

    private void destroyIfEmptyDaemon() {
        synchronized (this.threadRefs) {
            if (this.isDaemon && !this.isDestroyed && !this.threads.iterator().hasNext()) {
                synchronized (this.groups) {
                    if (this.groups.isEmpty()) {
                        destroy();
                    }
                }
            }
        }
    }

    private int enumerateGeneric(Object[] objArr, boolean z, int i, boolean z2) {
        if (z2) {
            synchronized (this.threadRefs) {
                try {
                    int size = this.threadRefs.size();
                    while (true) {
                        int i2 = size - 1;
                        if (i2 < 0) {
                            break;
                        }
                        try {
                            Thread thread = this.threadRefs.get(i2).get();
                            if (thread != null && thread.isAlive()) {
                                if (i >= objArr.length) {
                                    return i;
                                }
                                objArr[i] = thread;
                                i++;
                            }
                            size = i2;
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } else {
            synchronized (this.groups) {
                try {
                    int size2 = this.groups.size() - 1;
                    while (size2 >= 0) {
                        try {
                            if (i >= objArr.length) {
                                return i;
                            }
                            objArr[i] = this.groups.get(size2);
                            size2--;
                            i++;
                        } catch (Throwable th3) {
                            th = th3;
                            throw th;
                        }
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
        int i3 = i;
        if (z) {
            synchronized (this.groups) {
                for (ThreadGroup threadGroup : this.groups) {
                    if (i >= objArr.length) {
                        return i;
                    }
                    i = threadGroup.enumerateGeneric(objArr, z, i, z2);
                }
                i3 = i;
            }
        }
        return i3;
    }

    private void indent(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return;
            }
            System.out.print("    ");
            i2 = i3 + 1;
        }
    }

    private void list(int i) {
        indent(i);
        System.out.println(toString());
        int i2 = i + 1;
        synchronized (this.threadRefs) {
            for (Thread thread : this.threads) {
                indent(i2);
                System.out.println(thread);
            }
        }
        synchronized (this.groups) {
            for (ThreadGroup threadGroup : this.groups) {
                threadGroup.list(i2);
            }
        }
    }

    private void remove(ThreadGroup threadGroup) {
        synchronized (this.groups) {
            Iterator<ThreadGroup> it = this.groups.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(threadGroup)) {
                    it.remove();
                    break;
                }
            }
        }
        destroyIfEmptyDaemon();
    }

    private boolean stopHelper() {
        boolean z = false;
        synchronized (this.threadRefs) {
            Thread currentThread = Thread.currentThread();
            for (Thread thread : this.threads) {
                if (thread == currentThread) {
                    z = true;
                } else {
                    thread.stop();
                }
            }
        }
        synchronized (this.groups) {
            for (ThreadGroup threadGroup : this.groups) {
                z |= threadGroup.stopHelper();
            }
        }
        return z;
    }

    private boolean suspendHelper() {
        boolean z = false;
        synchronized (this.threadRefs) {
            Thread currentThread = Thread.currentThread();
            for (Thread thread : this.threads) {
                if (thread == currentThread) {
                    z = true;
                } else {
                    thread.suspend();
                }
            }
        }
        synchronized (this.groups) {
            for (ThreadGroup threadGroup : this.groups) {
                z |= threadGroup.suspendHelper();
            }
        }
        return z;
    }

    public int activeCount() {
        int i = 0;
        synchronized (this.threadRefs) {
            for (Thread thread : this.threads) {
                if (thread.isAlive()) {
                    i++;
                }
            }
        }
        synchronized (this.groups) {
            for (ThreadGroup threadGroup : this.groups) {
                i += threadGroup.activeCount();
            }
        }
        return i;
    }

    public int activeGroupCount() {
        int i = 0;
        synchronized (this.groups) {
            for (ThreadGroup threadGroup : this.groups) {
                i += threadGroup.activeGroupCount() + 1;
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void addThread(Thread thread) throws IllegalThreadStateException {
        synchronized (this.threadRefs) {
            if (this.isDestroyed) {
                throw new IllegalThreadStateException();
            }
            this.threadRefs.add(new WeakReference<>(thread));
        }
    }

    @Deprecated
    public boolean allowThreadSuspension(boolean z) {
        return true;
    }

    public final void checkAccess() {
    }

    public final void destroy() {
        synchronized (this.threadRefs) {
            synchronized (this.groups) {
                if (this.isDestroyed) {
                    throw new IllegalThreadStateException("Thread group was already destroyed: " + (this.name != null ? this.name : "n/a"));
                } else if (this.threads.iterator().hasNext()) {
                    throw new IllegalThreadStateException("Thread group still contains threads: " + (this.name != null ? this.name : "n/a"));
                } else {
                    while (!this.groups.isEmpty()) {
                        this.groups.get(0).destroy();
                    }
                    if (this.parent != null) {
                        this.parent.remove(this);
                    }
                    this.isDestroyed = true;
                }
            }
        }
    }

    public int enumerate(Thread[] threadArr) {
        return enumerate(threadArr, true);
    }

    public int enumerate(Thread[] threadArr, boolean z) {
        return enumerateGeneric(threadArr, z, 0, true);
    }

    public int enumerate(ThreadGroup[] threadGroupArr) {
        return enumerate(threadGroupArr, true);
    }

    public int enumerate(ThreadGroup[] threadGroupArr, boolean z) {
        return enumerateGeneric(threadGroupArr, z, 0, false);
    }

    public final int getMaxPriority() {
        return this.maxPriority;
    }

    public final String getName() {
        return this.name;
    }

    public final ThreadGroup getParent() {
        return this.parent;
    }

    public final void interrupt() {
        synchronized (this.threadRefs) {
            for (Thread thread : this.threads) {
                thread.interrupt();
            }
        }
        synchronized (this.groups) {
            for (ThreadGroup threadGroup : this.groups) {
                threadGroup.interrupt();
            }
        }
    }

    public final boolean isDaemon() {
        return this.isDaemon;
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this) {
            z = this.isDestroyed;
        }
        return z;
    }

    public void list() {
        System.out.println();
        list(0);
    }

    public final boolean parentOf(ThreadGroup threadGroup) {
        while (threadGroup != null) {
            if (this == threadGroup) {
                return true;
            }
            threadGroup = threadGroup.parent;
        }
        return false;
    }

    final void removeThread(Thread thread) throws IllegalThreadStateException {
        synchronized (this.threadRefs) {
            Iterator<Thread> it = this.threads.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().equals(thread)) {
                    it.remove();
                    break;
                }
            }
        }
        destroyIfEmptyDaemon();
    }

    @Deprecated
    public final void resume() {
        synchronized (this.threadRefs) {
            for (Thread thread : this.threads) {
                thread.resume();
            }
        }
        synchronized (this.groups) {
            for (ThreadGroup threadGroup : this.groups) {
                threadGroup.resume();
            }
        }
    }

    public final void setDaemon(boolean z) {
        this.isDaemon = z;
    }

    public final void setMaxPriority(int i) {
        if (i <= this.maxPriority) {
            int i2 = i;
            if (i < 1) {
                i2 = 1;
            }
            int maxPriority = this.parent == null ? i2 : this.parent.getMaxPriority();
            if (maxPriority > i2) {
                maxPriority = i2;
            }
            this.maxPriority = maxPriority;
            synchronized (this.groups) {
                for (ThreadGroup threadGroup : this.groups) {
                    threadGroup.setMaxPriority(i2);
                }
            }
        }
    }

    @Deprecated
    public final void stop() {
        if (stopHelper()) {
            Thread.currentThread().stop();
        }
    }

    @Deprecated
    public final void suspend() {
        if (suspendHelper()) {
            Thread.currentThread().suspend();
        }
    }

    public String toString() {
        return getClass().getName() + "[name=" + getName() + ",maxPriority=" + getMaxPriority() + "]";
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (this.parent != null) {
            this.parent.uncaughtException(thread, th);
        } else if (Thread.getDefaultUncaughtExceptionHandler() != null) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(thread, th);
        } else if (th instanceof ThreadDeath) {
        } else {
            th.printStackTrace(System.err);
        }
    }
}
