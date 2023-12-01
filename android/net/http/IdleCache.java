package android.net.http;

import android.os.Process;
import android.os.SystemClock;
import org.apache.http.HttpHost;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-9557208-dex2jar.jar:android/net/http/IdleCache.class */
public class IdleCache {
    private static final int CHECK_INTERVAL = 2000;
    private static final int EMPTY_CHECK_MAX = 5;
    private static final int IDLE_CACHE_MAX = 8;
    private static final int TIMEOUT = 6000;
    private Entry[] mEntries = new Entry[8];
    private int mCount = 0;
    private IdleReaper mThread = null;
    private int mCached = 0;
    private int mReused = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/http/IdleCache$Entry.class */
    public class Entry {
        Connection mConnection;
        HttpHost mHost;
        long mTimeout;

        Entry() {
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/http/IdleCache$IdleReaper.class */
    private class IdleReaper extends Thread {
        private IdleReaper() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            int i = 0;
            setName("IdleReaper");
            Process.setThreadPriority(10);
            synchronized (IdleCache.this) {
                while (i < 5) {
                    try {
                        IdleCache.this.wait(2000L);
                    } catch (InterruptedException e) {
                    }
                    if (IdleCache.this.mCount == 0) {
                        i++;
                    } else {
                        i = 0;
                        IdleCache.this.clearIdle();
                    }
                }
                IdleCache.this.mThread = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IdleCache() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 8) {
                return;
            }
            this.mEntries[i2] = new Entry();
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearIdle() {
        synchronized (this) {
            if (this.mCount > 0) {
                long uptimeMillis = SystemClock.uptimeMillis();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= 8) {
                        break;
                    }
                    Entry entry = this.mEntries[i2];
                    if (entry.mHost != null && uptimeMillis > entry.mTimeout) {
                        entry.mHost = null;
                        entry.mConnection.closeConnection();
                        entry.mConnection = null;
                        this.mCount--;
                    }
                    i = i2 + 1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
        r0.mHost = r7;
        r0.mConnection = r8;
        r0.mTimeout = 6000 + r0;
        r6.mCount++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0055, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005f, code lost:
        if (r6.mThread != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0062, code lost:
        r6.mThread = new android.net.http.IdleCache.IdleReaper(r6, null);
        r6.mThread.start();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0078, code lost:
        r10 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean cacheConnection(org.apache.http.HttpHost r7, android.net.http.Connection r8) {
        /*
            r6 = this;
            r0 = r6
            monitor-enter(r0)
            r0 = 0
            r11 = r0
            r0 = r11
            r10 = r0
            r0 = r6
            int r0 = r0.mCount     // Catch: java.lang.Throwable -> L86
            r1 = 8
            if (r0 >= r1) goto L7a
            long r0 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L86
            r12 = r0
            r0 = 0
            r9 = r0
        L19:
            r0 = r11
            r10 = r0
            r0 = r9
            r1 = 8
            if (r0 >= r1) goto L7a
            r0 = r6
            android.net.http.IdleCache$Entry[] r0 = r0.mEntries     // Catch: java.lang.Throwable -> L86
            r1 = r9
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L86
            r14 = r0
            r0 = r14
            org.apache.http.HttpHost r0 = r0.mHost     // Catch: java.lang.Throwable -> L86
            if (r0 != 0) goto L7f
            r0 = r14
            r1 = r7
            r0.mHost = r1     // Catch: java.lang.Throwable -> L86
            r0 = r14
            r1 = r8
            r0.mConnection = r1     // Catch: java.lang.Throwable -> L86
            r0 = r14
            r1 = 6000(0x1770, double:2.9644E-320)
            r2 = r12
            long r1 = r1 + r2
            r0.mTimeout = r1     // Catch: java.lang.Throwable -> L86
            r0 = r6
            r1 = r6
            int r1 = r1.mCount     // Catch: java.lang.Throwable -> L86
            r2 = 1
            int r1 = r1 + r2
            r0.mCount = r1     // Catch: java.lang.Throwable -> L86
            r0 = 1
            r11 = r0
            r0 = r11
            r10 = r0
            r0 = r6
            android.net.http.IdleCache$IdleReaper r0 = r0.mThread     // Catch: java.lang.Throwable -> L86
            if (r0 != 0) goto L7a
            r0 = r6
            android.net.http.IdleCache$IdleReaper r1 = new android.net.http.IdleCache$IdleReaper     // Catch: java.lang.Throwable -> L86
            r2 = r1
            r3 = r6
            r4 = 0
            r2.<init>()     // Catch: java.lang.Throwable -> L86
            r0.mThread = r1     // Catch: java.lang.Throwable -> L86
            r0 = r6
            android.net.http.IdleCache$IdleReaper r0 = r0.mThread     // Catch: java.lang.Throwable -> L86
            r0.start()     // Catch: java.lang.Throwable -> L86
            r0 = r11
            r10 = r0
        L7a:
            r0 = r6
            monitor-exit(r0)
            r0 = r10
            return r0
        L7f:
            r0 = r9
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            goto L19
        L86:
            r7 = move-exception
            r0 = r6
            monitor-exit(r0)
            r0 = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.net.http.IdleCache.cacheConnection(org.apache.http.HttpHost, android.net.http.Connection):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        synchronized (this) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (this.mCount <= 0 || i2 >= 8) {
                    break;
                }
                Entry entry = this.mEntries[i2];
                if (entry.mHost != null) {
                    entry.mHost = null;
                    entry.mConnection.closeConnection();
                    entry.mConnection = null;
                    this.mCount--;
                }
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
        r7 = r0.mConnection;
        r0.mHost = null;
        r0.mConnection = null;
        r4.mCount--;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.net.http.Connection getConnection(org.apache.http.HttpHost r5) {
        /*
            r4 = this;
            r0 = r4
            monitor-enter(r0)
            r0 = 0
            r8 = r0
            r0 = r8
            r7 = r0
            r0 = r4
            int r0 = r0.mCount     // Catch: java.lang.Throwable -> L5b
            if (r0 <= 0) goto L50
            r0 = 0
            r6 = r0
        L11:
            r0 = r8
            r7 = r0
            r0 = r6
            r1 = 8
            if (r0 >= r1) goto L50
            r0 = r4
            android.net.http.IdleCache$Entry[] r0 = r0.mEntries     // Catch: java.lang.Throwable -> L5b
            r1 = r6
            r0 = r0[r1]     // Catch: java.lang.Throwable -> L5b
            r9 = r0
            r0 = r9
            org.apache.http.HttpHost r0 = r0.mHost     // Catch: java.lang.Throwable -> L5b
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L54
            r0 = r7
            r1 = r5
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Throwable -> L5b
            if (r0 == 0) goto L54
            r0 = r9
            android.net.http.Connection r0 = r0.mConnection     // Catch: java.lang.Throwable -> L5b
            r7 = r0
            r0 = r9
            r1 = 0
            r0.mHost = r1     // Catch: java.lang.Throwable -> L5b
            r0 = r9
            r1 = 0
            r0.mConnection = r1     // Catch: java.lang.Throwable -> L5b
            r0 = r4
            r1 = r4
            int r1 = r1.mCount     // Catch: java.lang.Throwable -> L5b
            r2 = 1
            int r1 = r1 - r2
            r0.mCount = r1     // Catch: java.lang.Throwable -> L5b
        L50:
            r0 = r4
            monitor-exit(r0)
            r0 = r7
            return r0
        L54:
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            goto L11
        L5b:
            r5 = move-exception
            r0 = r4
            monitor-exit(r0)
            r0 = r5
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.net.http.IdleCache.getConnection(org.apache.http.HttpHost):android.net.http.Connection");
    }
}
