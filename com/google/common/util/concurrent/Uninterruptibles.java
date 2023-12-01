package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/util/concurrent/Uninterruptibles.class */
public final class Uninterruptibles {
    private Uninterruptibles() {
    }

    public static void awaitUninterruptibly(CountDownLatch countDownLatch) {
        boolean z;
        boolean z2 = false;
        while (true) {
            try {
                z = z2;
                countDownLatch.await();
                break;
            } catch (InterruptedException e) {
                z2 = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long j, TimeUnit timeUnit) {
        boolean await;
        boolean z = false;
        boolean z2 = false;
        try {
            long nanos = timeUnit.toNanos(j);
            long nanoTime = System.nanoTime();
            long j2 = nanos;
            while (true) {
                z2 = z;
                try {
                    await = countDownLatch.await(j2, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException e) {
                    z = true;
                    j2 = (nanoTime + nanos) - System.nanoTime();
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return await;
        } catch (Throwable th) {
            if (z2) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    public static boolean awaitUninterruptibly(Condition condition, long j, TimeUnit timeUnit) {
        boolean await;
        boolean z = false;
        boolean z2 = false;
        try {
            long nanos = timeUnit.toNanos(j);
            long nanoTime = System.nanoTime();
            long j2 = nanos;
            while (true) {
                z2 = z;
                try {
                    await = condition.await(j2, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException e) {
                    z = true;
                    j2 = (nanoTime + nanos) - System.nanoTime();
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return await;
        } catch (Throwable th) {
            if (z2) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    public static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        boolean z;
        V v;
        boolean z2 = false;
        while (true) {
            try {
                z = z2;
                v = future.get();
                break;
            } catch (InterruptedException e) {
                z2 = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return v;
    }

    public static <V> V getUninterruptibly(Future<V> future, long j, TimeUnit timeUnit) throws ExecutionException, TimeoutException {
        V v;
        boolean z = false;
        boolean z2 = false;
        try {
            long nanos = timeUnit.toNanos(j);
            long nanoTime = System.nanoTime();
            long j2 = nanos;
            while (true) {
                z2 = z;
                try {
                    v = future.get(j2, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException e) {
                    z = true;
                    j2 = (nanoTime + nanos) - System.nanoTime();
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return v;
        } catch (Throwable th) {
            if (z2) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    public static void joinUninterruptibly(Thread thread) {
        boolean z;
        boolean z2 = false;
        while (true) {
            try {
                z = z2;
                thread.join();
                break;
            } catch (InterruptedException e) {
                z2 = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static void joinUninterruptibly(Thread thread, long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(thread);
        boolean z = false;
        boolean z2 = false;
        try {
            long nanos = timeUnit.toNanos(j);
            long nanoTime = System.nanoTime();
            long j2 = nanos;
            while (true) {
                z2 = z;
                try {
                    TimeUnit.NANOSECONDS.timedJoin(thread, j2);
                    break;
                } catch (InterruptedException e) {
                    z = true;
                    j2 = (nanoTime + nanos) - System.nanoTime();
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        } catch (Throwable th) {
            if (z2) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    public static <E> void putUninterruptibly(BlockingQueue<E> blockingQueue, E e) {
        boolean z;
        boolean z2 = false;
        while (true) {
            try {
                z = z2;
                blockingQueue.put(e);
                break;
            } catch (InterruptedException e2) {
                z2 = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static void sleepUninterruptibly(long j, TimeUnit timeUnit) {
        boolean z = false;
        boolean z2 = false;
        try {
            long nanos = timeUnit.toNanos(j);
            long nanoTime = System.nanoTime();
            long j2 = nanos;
            while (true) {
                z2 = z;
                try {
                    TimeUnit.NANOSECONDS.sleep(j2);
                    break;
                } catch (InterruptedException e) {
                    z = true;
                    j2 = (nanoTime + nanos) - System.nanoTime();
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        } catch (Throwable th) {
            if (z2) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    public static <E> E takeUninterruptibly(BlockingQueue<E> blockingQueue) {
        boolean z;
        E take;
        boolean z2 = false;
        while (true) {
            try {
                z = z2;
                take = blockingQueue.take();
                break;
            } catch (InterruptedException e) {
                z2 = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return take;
    }

    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, int i, long j, TimeUnit timeUnit) {
        boolean tryAcquire;
        boolean z = false;
        boolean z2 = false;
        try {
            long nanos = timeUnit.toNanos(j);
            long nanoTime = System.nanoTime();
            long j2 = nanos;
            while (true) {
                z2 = z;
                try {
                    tryAcquire = semaphore.tryAcquire(i, j2, TimeUnit.NANOSECONDS);
                    break;
                } catch (InterruptedException e) {
                    z = true;
                    j2 = (nanoTime + nanos) - System.nanoTime();
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            return tryAcquire;
        } catch (Throwable th) {
            if (z2) {
                Thread.currentThread().interrupt();
            }
            throw th;
        }
    }

    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, long j, TimeUnit timeUnit) {
        return tryAcquireUninterruptibly(semaphore, 1, j, timeUnit);
    }
}
