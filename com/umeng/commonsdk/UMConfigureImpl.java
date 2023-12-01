package com.umeng.commonsdk;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.at;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.utils.onMessageSendListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/commonsdk/UMConfigureImpl.class */
public class UMConfigureImpl {
    private static final int e = 1000;
    private static ScheduledExecutorService f;
    private static Context g;

    /* renamed from: a  reason: collision with root package name */
    private static String f27143a = at.b().b(at.o);
    private static CopyOnWriteArrayList<onMessageSendListener> b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private static int f27144c = 0;
    private static boolean d = false;
    private static int h = 0;
    private static Runnable i = new Runnable() { // from class: com.umeng.commonsdk.UMConfigureImpl.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (UMConfigureImpl.f27144c == 0 || UMConfigureImpl.h >= 10) {
                    if (!UMConfigureImpl.d) {
                        boolean unused = UMConfigureImpl.d = true;
                        UMConfigureImpl.b(UMConfigureImpl.g);
                    }
                    if (UMConfigureImpl.f != null) {
                        UMConfigureImpl.f.shutdown();
                        ScheduledExecutorService unused2 = UMConfigureImpl.f = null;
                    }
                }
                UMConfigureImpl.f();
            } catch (Exception e2) {
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context) {
        synchronized (UMConfigureImpl.class) {
            try {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
                if (b != null && b.size() > 0) {
                    Iterator<onMessageSendListener> it = b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception e2) {
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void c(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f27143a, 0);
            if (sharedPreferences == null || sharedPreferences == null) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(f27143a, true);
            edit.commit();
        } catch (Throwable th) {
        }
    }

    private static boolean d(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(f27143a, 0);
            boolean z = false;
            if (sharedPreferences != null) {
                z = false;
                if (sharedPreferences != null) {
                    z = sharedPreferences.getBoolean(f27143a, false);
                }
            }
            return z;
        } catch (Throwable th) {
            return false;
        }
    }

    static /* synthetic */ int f() {
        int i2 = h;
        h = i2 + 1;
        return i2;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        g = context;
        try {
            if (f27144c < 1) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else if (d(context)) {
                UMEnvelopeBuild.setTransmissionSendFlag(true);
            } else {
                UMEnvelopeBuild.setTransmissionSendFlag(false);
                c(context);
                if (f == null) {
                    ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
                    f = newScheduledThreadPool;
                    newScheduledThreadPool.scheduleAtFixedRate(i, 0L, 100L, TimeUnit.MILLISECONDS);
                }
            }
        } catch (Exception e2) {
        }
    }

    public static void registerInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f27144c++;
            } catch (Exception e2) {
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void registerMessageSendListener(onMessageSendListener onmessagesendlistener) {
        synchronized (UMConfigureImpl.class) {
            try {
                if (b != null) {
                    b.add(onmessagesendlistener);
                }
                if (UMEnvelopeBuild.getTransmissionSendFlag() && b != null && b.size() > 0) {
                    Iterator<onMessageSendListener> it = b.iterator();
                    while (it.hasNext()) {
                        it.next().onMessageSend();
                    }
                }
            } catch (Exception e2) {
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void removeInterruptFlag() {
        synchronized (UMConfigureImpl.class) {
            try {
                f27144c--;
            } catch (Exception e2) {
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void removeMessageSendListener(onMessageSendListener onmessagesendlistener) {
        synchronized (UMConfigureImpl.class) {
            try {
                if (b != null) {
                    b.remove(onmessagesendlistener);
                }
            } catch (Exception e2) {
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
