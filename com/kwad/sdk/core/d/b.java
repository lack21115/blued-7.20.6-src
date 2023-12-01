package com.kwad.sdk.core.d;

import android.util.Log;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/d/b.class */
public final class b {
    public static boolean afV = true;
    private static boolean afW = com.kwad.kwai.kwai.a.bI.booleanValue();
    private static final com.kwad.sdk.core.d.kwai.b afX = new com.kwad.sdk.core.d.a();
    private static final List<com.kwad.sdk.core.d.kwai.b> afY = new CopyOnWriteArrayList();
    private static com.kwad.sdk.core.d.kwai.a afZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/d/b$a.class */
    public interface a {
        void b(com.kwad.sdk.core.d.kwai.b bVar);
    }

    private static void a(a aVar) {
        for (com.kwad.sdk.core.d.kwai.b bVar : afY) {
            if (bVar != null) {
                try {
                    aVar.b(bVar);
                } catch (Exception e) {
                }
            }
        }
    }

    public static void a(com.kwad.sdk.core.d.kwai.b bVar) {
        if (afY.contains(bVar)) {
            return;
        }
        afY.add(bVar);
    }

    public static void a(boolean z, com.kwad.sdk.core.d.kwai.a aVar) {
        afV = z;
        afY.clear();
        afY.add(afX);
        afZ = aVar;
    }

    static /* synthetic */ String access$000() {
        return vZ();
    }

    public static void cb(final String str) {
        a(new a() { // from class: com.kwad.sdk.core.d.b.6
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.v(b.access$000(), String.this, true);
            }
        });
    }

    public static void d(String str, String str2) {
        y(vZ(), u(str, str2));
    }

    public static void e(String str, String str2) {
        final String u = u(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.d.b.11
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.e(b.access$000(), String.this);
            }
        });
        com.kwad.sdk.core.d.kwai.a aVar = afZ;
        if (aVar != null) {
            aVar.m(str2, str);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        String stackTraceString = Log.getStackTraceString(th);
        final String u = u(str, str2 + '\n' + stackTraceString);
        a(new a() { // from class: com.kwad.sdk.core.d.b.2
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.e(b.access$000(), String.this);
            }
        });
        com.kwad.sdk.core.d.kwai.a aVar = afZ;
        if (aVar != null) {
            aVar.m(stackTraceString, str);
        }
    }

    public static void i(String str, String str2) {
        final String u = u(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.d.b.8
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.i(b.access$000(), String.this);
            }
        });
    }

    public static void printStackTrace(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.b.3
                @Override // com.kwad.sdk.core.d.b.a
                public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                    bVar.printStackTraceOnly(Throwable.this);
                }
            });
        }
        if (com.kwad.kwai.kwai.a.bI.booleanValue()) {
            throw new RuntimeException(th);
        }
    }

    public static void printStackTraceOnly(final Throwable th) {
        if (th != null) {
            a(new a() { // from class: com.kwad.sdk.core.d.b.4
                @Override // com.kwad.sdk.core.d.b.a
                public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                    bVar.printStackTraceOnly(Throwable.this);
                }
            });
        }
    }

    private static String u(String str, String str2) {
        return "[" + str + "]: " + str2 + " " + wa();
    }

    public static void v(String str, String str2) {
        final String u = u(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.d.b.5
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.v(b.access$000(), String.this);
            }
        });
    }

    private static String vZ() {
        return "KSAdSDK";
    }

    public static void w(String str, String str2) {
        final String u = u(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.d.b.9
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.w(b.access$000(), String.this);
            }
        });
    }

    public static void w(String str, Throwable th) {
        final String u = u(str, Log.getStackTraceString(th));
        a(new a() { // from class: com.kwad.sdk.core.d.b.10
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.w(b.access$000(), String.this, com.kwad.kwai.kwai.a.bI.booleanValue());
            }
        });
    }

    private static String wa() {
        String str;
        int i;
        if (afW) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 3) {
                str = stackTrace[3].getFileName();
                i = stackTrace[3].getLineNumber();
            } else {
                str = "unknown";
                i = -1;
            }
            return "(" + str + ':' + i + ')';
        }
        return "";
    }

    private static void x(final String str, final String str2) {
        a(new a() { // from class: com.kwad.sdk.core.d.b.1
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.d(String.this, str2);
            }
        });
    }

    private static void y(String str, String str2) {
        if (str2.length() <= 4000) {
            x(str, str2);
            return;
        }
        x(str, str2.substring(0, 4000));
        y(str, str2.substring(4000));
    }

    public static void z(String str, String str2) {
        final String u = u(str, str2);
        a(new a() { // from class: com.kwad.sdk.core.d.b.7
            @Override // com.kwad.sdk.core.d.b.a
            public final void b(com.kwad.sdk.core.d.kwai.b bVar) {
                bVar.v(b.access$000(), String.this, true);
            }
        });
    }
}
