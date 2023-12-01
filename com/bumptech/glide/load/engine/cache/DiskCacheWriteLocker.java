package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.util.Preconditions;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker.class */
final class DiskCacheWriteLocker {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, WriteLock> f7215a = new HashMap();
    private final WriteLockPool b = new WriteLockPool();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLock.class */
    public static class WriteLock {

        /* renamed from: a  reason: collision with root package name */
        final Lock f7216a = new ReentrantLock();
        int b;

        WriteLock() {
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/cache/DiskCacheWriteLocker$WriteLockPool.class */
    static class WriteLockPool {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<WriteLock> f7217a = new ArrayDeque();

        WriteLockPool() {
        }

        WriteLock a() {
            WriteLock poll;
            synchronized (this.f7217a) {
                poll = this.f7217a.poll();
            }
            WriteLock writeLock = poll;
            if (poll == null) {
                writeLock = new WriteLock();
            }
            return writeLock;
        }

        void a(WriteLock writeLock) {
            synchronized (this.f7217a) {
                if (this.f7217a.size() < 10) {
                    this.f7217a.offer(writeLock);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        WriteLock writeLock;
        synchronized (this) {
            WriteLock writeLock2 = this.f7215a.get(str);
            writeLock = writeLock2;
            if (writeLock2 == null) {
                writeLock = this.b.a();
                this.f7215a.put(str, writeLock);
            }
            writeLock.b++;
        }
        writeLock.f7216a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        WriteLock writeLock;
        synchronized (this) {
            writeLock = (WriteLock) Preconditions.a(this.f7215a.get(str));
            if (writeLock.b < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + writeLock.b);
            }
            writeLock.b--;
            if (writeLock.b == 0) {
                WriteLock remove = this.f7215a.remove(str);
                if (!remove.equals(writeLock)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + writeLock + ", but actually removed: " + remove + ", safeKey: " + str);
                }
                this.b.a(remove);
            }
        }
        writeLock.f7216a.unlock();
    }
}
