package com.uc.crashsdk;

import android.os.Bundle;
import android.webkit.ValueCallback;
import com.tencent.tendinsv.a.b;
import com.uc.crashsdk.export.ICrashClient;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/uc/crashsdk/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static ICrashClient f40577a;
    private static int b = 3;

    /* renamed from: c  reason: collision with root package name */
    private static volatile List<ValueCallback<Bundle>> f40578c;
    private static volatile List<ValueCallback<Bundle>> d;
    private static volatile List<ValueCallback<Bundle>> e;
    private static volatile List<ValueCallback<Bundle>> f;
    private static final Object g = new Object();

    public static File a(File file) {
        ICrashClient iCrashClient = f40577a;
        if (iCrashClient != null) {
            try {
                return iCrashClient.onBeforeUploadLog(file);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        return file;
    }

    public static String a(String str, boolean z) {
        ICrashClient iCrashClient = f40577a;
        return iCrashClient != null ? iCrashClient.onGetCallbackInfo(str, z) : "";
    }

    public static void a(ICrashClient iCrashClient) {
        f40577a = iCrashClient;
    }

    public static void a(String str, int i, int i2) {
        ICrashClient iCrashClient = f40577a;
        if (iCrashClient != null) {
            iCrashClient.onAddCrashStats(str, i, i2);
        }
        if (f != null) {
            synchronized (f) {
                for (ValueCallback<Bundle> valueCallback : f) {
                    Bundle bundle = new Bundle();
                    bundle.putString(b.a.u, str);
                    bundle.putInt("key", i);
                    bundle.putInt("count", i2);
                    valueCallback.onReceiveValue(bundle);
                }
            }
        }
    }

    public static void a(String str, String str2, String str3) {
        if (com.uc.crashsdk.a.g.a(str)) {
            com.uc.crashsdk.a.a.a("crashsdk", "onLogGenerated file name is null!", null);
            return;
        }
        boolean equals = e.h().equals(str2);
        if (f40577a != null) {
            File file = new File(str);
            try {
                if (equals) {
                    f40577a.onLogGenerated(file, str3);
                } else {
                    f40577a.onClientProcessLogGenerated(str2, file, str3);
                }
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        List<ValueCallback<Bundle>> list = f40578c;
        if (!equals) {
            list = d;
        }
        if (list != null) {
            synchronized (list) {
                try {
                    for (ValueCallback<Bundle> valueCallback : list) {
                        Bundle bundle = new Bundle();
                        bundle.putString("filePathName", str);
                        if (!equals) {
                            bundle.putString(b.a.u, str2);
                        }
                        bundle.putString("logType", str3);
                        valueCallback.onReceiveValue(bundle);
                    }
                } finally {
                    List<ValueCallback<Bundle>> list2 = list;
                }
            }
        }
    }

    public static void a(boolean z) {
        ICrashClient iCrashClient = f40577a;
        if (iCrashClient != null) {
            try {
                iCrashClient.onCrashRestarting(z);
            } catch (Throwable th) {
                com.uc.crashsdk.a.g.a(th);
            }
        }
        if (e != null) {
            synchronized (e) {
                for (ValueCallback<Bundle> valueCallback : e) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isJava", z);
                    valueCallback.onReceiveValue(bundle);
                }
            }
        }
    }

    public static boolean a(ValueCallback<Bundle> valueCallback) {
        if (f40578c == null) {
            synchronized (g) {
                if (f40578c == null) {
                    f40578c = new ArrayList();
                }
            }
        }
        synchronized (f40578c) {
            if (f40578c.size() >= b) {
                return false;
            }
            f40578c.add(valueCallback);
            return true;
        }
    }

    public static boolean b(ValueCallback<Bundle> valueCallback) {
        if (d == null) {
            synchronized (g) {
                if (d == null) {
                    d = new ArrayList();
                }
            }
        }
        synchronized (d) {
            if (d.size() >= b) {
                return false;
            }
            d.add(valueCallback);
            return true;
        }
    }

    public static boolean c(ValueCallback<Bundle> valueCallback) {
        if (e == null) {
            synchronized (g) {
                if (e == null) {
                    e = new ArrayList();
                }
            }
        }
        synchronized (e) {
            if (e.size() >= b) {
                return false;
            }
            e.add(valueCallback);
            return true;
        }
    }

    public static boolean d(ValueCallback<Bundle> valueCallback) {
        if (f == null) {
            synchronized (g) {
                if (f == null) {
                    f = new ArrayList();
                }
            }
        }
        synchronized (f) {
            if (f.size() >= b) {
                return false;
            }
            f.add(valueCallback);
            return true;
        }
    }
}
