package com.tencent.smtt.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/utils/k.class */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public static String f38965a = "TBSFileLock";
    private static Object f = new Object();
    private static Object g = new Object();
    private static HashMap<k, Object> h = null;
    private static Handler i = null;
    File b;

    /* renamed from: c  reason: collision with root package name */
    RandomAccessFile f38966c = null;
    FileLock d = null;
    long e = 0;

    public k(File file, String str) {
        this.b = null;
        this.b = new File(file, "." + str + ".lock");
    }

    Handler a() {
        if (i == null) {
            synchronized (k.class) {
                try {
                    if (i == null) {
                        HandlerThread handlerThread = new HandlerThread("QBFileLock.Thread");
                        handlerThread.start();
                        i = new Handler(handlerThread.getLooper());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return i;
    }

    public void a(boolean z) {
        synchronized (this) {
            String str = f38965a;
            Log.d(str, ">>> release lock: " + this.b.getName());
            if (this.d != null) {
                try {
                    this.d.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.d = null;
            }
            if (this.f38966c != null) {
                try {
                    this.f38966c.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.f38966c = null;
            }
            if (i != null && this.e > 0) {
                i.removeCallbacks(this);
            }
            if (z) {
                d();
            }
        }
    }

    public void b() {
        FileChannel channel;
        FileLock fileLock;
        synchronized (this) {
            try {
                this.f38966c = new RandomAccessFile(this.b, "rw");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.f38966c != null && (channel = this.f38966c.getChannel()) != null) {
                if (this.e > 0) {
                    a().postDelayed(this, this.e);
                }
                FileLock fileLock2 = null;
                long currentTimeMillis = System.currentTimeMillis();
                while (true) {
                    try {
                        FileLock lock = channel.lock();
                        fileLock = lock;
                        if (lock != null) {
                            fileLock = lock;
                            break;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        Log.d(f38965a, ">>> lock failed, sleep...");
                        fileLock = fileLock2;
                    }
                    try {
                        Thread.sleep(50L);
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                    }
                    fileLock2 = fileLock;
                    if (Math.abs(System.currentTimeMillis() - currentTimeMillis) >= 1000) {
                        Log.d(f38965a, ">>> lock timeout, quit...");
                        break;
                    }
                }
                this.d = fileLock;
                Log.d(f38965a, ">>> lock [" + this.b.getName() + "] cost: " + (System.currentTimeMillis() - currentTimeMillis));
            }
            if (this.d != null) {
                c();
            }
        }
    }

    void c() {
        synchronized (g) {
            if (h == null) {
                h = new HashMap<>();
            }
            h.put(this, f);
        }
    }

    void d() {
        synchronized (g) {
            if (h == null) {
                return;
            }
            h.remove(this);
        }
    }

    public void e() {
        a(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        Log.d(f38965a, ">>> releaseLock on TimeOut");
        e();
    }
}
