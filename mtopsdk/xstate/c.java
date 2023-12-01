package mtopsdk.xstate;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mtopsdk.common.util.TBSdkLog;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/xstate/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap f43797a;
    private static Context b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f43798c = false;
    private static Lock d = new ReentrantLock();

    public static String a(String str) {
        ConcurrentHashMap concurrentHashMap = f43797a;
        if (concurrentHashMap == null || str == null) {
            return null;
        }
        return (String) concurrentHashMap.get(str);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x006a -> B:13:0x0031). Please submit an issue!!! */
    public static void a() {
        if (f43798c) {
            d.lock();
            try {
                try {
                    if (f43798c) {
                        if (f43797a != null) {
                            f43797a.clear();
                            f43797a = null;
                        }
                        if (b == null) {
                            TBSdkLog.d("mtopsdk.XStateDelegate", "[unInit]static field context in Class XState is null.");
                        } else {
                            f43798c = false;
                            if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
                                TBSdkLog.b("mtopsdk.XStateDelegate", "[unInit] uninit XState OK,isInit=" + f43798c);
                            }
                        }
                    }
                } catch (Exception e) {
                    TBSdkLog.d("mtopsdk.XStateDelegate", "[unInit] unInit error --" + e.toString());
                }
                d.unlock();
            } catch (Throwable th) {
                d.unlock();
                throw th;
            }
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:10:0x001f). Please submit an issue!!! */
    public static void a(Context context) {
        if (f43798c) {
            return;
        }
        d.lock();
        try {
            if (!f43798c) {
                if (context == null) {
                    TBSdkLog.d("mtopsdk.XStateDelegate", "[checkInit]parameter context for init(Context context) is null.");
                } else {
                    if (f43797a == null) {
                        f43797a = new ConcurrentHashMap();
                    }
                    b = context;
                    f43798c = true;
                    if (TBSdkLog.a(TBSdkLog.LogEnable.InfoEnable)) {
                        TBSdkLog.b("mtopsdk.XStateDelegate", "[checkInit] init XState OK,isInit=" + f43798c);
                    }
                }
            }
        } catch (Throwable th) {
            try {
                TBSdkLog.d("mtopsdk.XStateDelegate", "[checkInit] checkInit error --" + th.toString());
            } catch (Throwable th2) {
                d.unlock();
                throw th2;
            }
        }
        d.unlock();
    }

    public static void a(String str, String str2) {
        ConcurrentHashMap concurrentHashMap = f43797a;
        if (concurrentHashMap == null || str == null || str2 == null) {
            if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.a("mtopsdk.XStateDelegate", "[setValue]set  XstateID failed,key=" + str + ",value=" + str2);
                return;
            }
            return;
        }
        concurrentHashMap.put(str, str2);
        if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.a("mtopsdk.XStateDelegate", "[setValue]set  XstateID succeed," + str + "=" + str2);
        }
    }

    public static String b(String str) {
        if (f43797a == null || str == null) {
            return null;
        }
        if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.a("mtopsdk.XStateDelegate", "remove Xstate key=" + str);
        }
        return (String) f43797a.remove(str);
    }
}
