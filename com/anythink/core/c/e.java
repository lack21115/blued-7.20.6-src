package com.anythink.core.c;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.AdError;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.s;
import com.anythink.core.common.g.i;
import com.anythink.core.common.g.j;
import com.anythink.core.common.k.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/c/e.class */
public class e {
    public static final String a = e.class.getSimpleName();
    private static volatile e b = null;
    private Context c;
    private ConcurrentHashMap<String, d> d = new ConcurrentHashMap<>();

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/c/e$a.class */
    public interface a {
        void a(AdError adError);

        void a(d dVar);

        void b(d dVar);
    }

    private e(Context context) {
        this.c = context;
    }

    public static e a(Context context) {
        if (b == null) {
            synchronized (e.class) {
                try {
                    if (b == null) {
                        b = new e(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    static /* synthetic */ void a(Context context, d dVar) {
        int d = dVar.d();
        n.a().c(d);
        p.a(context, g.o, g.o.o, d);
    }

    private void b() {
        this.d.clear();
    }

    private static void b(Context context, d dVar) {
        int d = dVar.d();
        n.a().c(d);
        p.a(context, g.o, g.o.o, d);
    }

    private List<s> c(String str) {
        List<s> E;
        if (this.d == null) {
            return null;
        }
        ArrayList<d> arrayList = new ArrayList();
        arrayList.addAll(this.d.values());
        ArrayList arrayList2 = new ArrayList();
        for (d dVar : arrayList) {
            if (TextUtils.equals(String.valueOf(dVar.X()), str) && (E = dVar.E()) != null) {
                arrayList2.addAll(E);
            }
        }
        return arrayList2;
    }

    public final d a(String str) {
        String p = n.a().p();
        if (p == null) {
            p = "";
        }
        ConcurrentHashMap<String, d> concurrentHashMap = this.d;
        if (concurrentHashMap.containsKey(p + str)) {
            ConcurrentHashMap<String, d> concurrentHashMap2 = this.d;
            return concurrentHashMap2.get(p + str);
        }
        Context context = this.c;
        String b2 = p.b(context, g.o, p + str + "_PL_SY", "");
        if (TextUtils.isEmpty(b2)) {
            StringBuilder sb = new StringBuilder("no key[");
            sb.append(p);
            sb.append(str);
            sb.append("]");
            return null;
        }
        d b3 = d.b(b2);
        if (b3 != null) {
            ConcurrentHashMap<String, d> concurrentHashMap3 = this.d;
            concurrentHashMap3.put(p + str, b3);
        }
        return b3;
    }

    public final void a() {
        Context context = this.c;
        if (context != null) {
            try {
                context.getSharedPreferences(g.A, 0).edit().clear().apply();
            } catch (Error | Exception e) {
            }
        }
    }

    public final void a(Context context, String str, d dVar, String str2) {
        String p = n.a().p();
        if (p == null) {
            p = "";
        }
        synchronized (this) {
            ConcurrentHashMap<String, d> concurrentHashMap = this.d;
            concurrentHashMap.put(p + str, dVar);
        }
        if (dVar.h() == 1) {
            if (n.a().I()) {
                Log.e(g.n, "PreInitNetwork may affect DebuggerMode.It is recommended to disable PreInitNetwork first and then setDebuggerMode.");
                return;
            }
            return;
        }
        String str3 = str2;
        if (TextUtils.isEmpty(str2)) {
            str3 = "";
        }
        p.a(context, g.o, p + str + "_PL_SY", str3);
    }

    public final void a(final d dVar, final String str, final String str2, final String str3, final Map<String, Object> map, final a aVar) {
        n.a().a(new Runnable() { // from class: com.anythink.core.c.e.1
            @Override // java.lang.Runnable
            public final void run() {
                d dVar2 = dVar;
                String P = dVar2 != null ? dVar2.P() : null;
                Map<String, Object> d = n.a().d(str3);
                d dVar3 = dVar;
                if (dVar3 == null) {
                    new j(e.this.c, str, str2, str3, P, d, map).a(0, new i() { // from class: com.anythink.core.c.e.1.3
                        @Override // com.anythink.core.common.g.i
                        public final void onLoadCanceled(int i) {
                            if (aVar != null) {
                                aVar.a(ErrorCode.getErrorCode(ErrorCode.exception, "", "by canceled"));
                            }
                        }

                        @Override // com.anythink.core.common.g.i
                        public final void onLoadError(int i, String str4, AdError adError) {
                            String str5 = e.a;
                            if (ErrorCode.statuError.equals(adError.getCode()) && (ErrorCode.placementIdError.equals(adError.getPlatformCode()) || ErrorCode.appIdError.equals(adError.getPlatformCode()) || "10001".equals(adError.getPlatformCode()))) {
                                String str6 = str + str3 + str2;
                                String str7 = e.a;
                                StringBuilder sb = new StringBuilder("code: ");
                                sb.append(adError.getPlatformCode());
                                sb.append("msg: ");
                                sb.append(adError.getPlatformMSG());
                                sb.append(", key -> ");
                                sb.append(str6);
                                p.a(e.this.c, g.A, str6, System.currentTimeMillis());
                                if (n.a().A()) {
                                    Log.e(g.n, "Please check these params in your code (AppId: " + str + ", AppKey: " + str2 + ", PlacementId: " + str3 + ")");
                                }
                            }
                            if (aVar != null) {
                                aVar.a(adError);
                            }
                        }

                        @Override // com.anythink.core.common.g.i
                        public final void onLoadFinish(int i, Object obj) {
                            String str4 = (String) obj;
                            try {
                                JSONObject jSONObject = new JSONObject(str4);
                                jSONObject.put("updateTime", System.currentTimeMillis());
                                str4 = jSONObject.toString();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            d b2 = d.b(str4);
                            if (b2 == null) {
                                if (aVar != null) {
                                    aVar.a(ErrorCode.getErrorCode(ErrorCode.placeStrategyError, "", "Placement Service error."));
                                    return;
                                }
                                return;
                            }
                            e eVar = e.this;
                            Context context = e.this.c;
                            String str5 = str3;
                            if (b2.Z() != 1) {
                                str4 = "";
                            }
                            eVar.a(context, str5, b2, str4);
                            e.a(e.this.c, b2);
                            if (b2.N() == 1) {
                                com.anythink.core.common.s.a().a(e.this.c, str3);
                            }
                            if (aVar != null) {
                                aVar.a(b2);
                            }
                        }

                        @Override // com.anythink.core.common.g.i
                        public final void onLoadStart(int i) {
                        }
                    });
                } else if (!(!d.equals(dVar3.M())) && !dVar.ax() && !com.anythink.core.common.s.a().c(e.this.c, str3)) {
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(dVar);
                    }
                } else {
                    String str4 = e.a;
                    final boolean[] zArr = new boolean[1];
                    long Y = dVar.Y();
                    final CountDownTimer countDownTimer = new CountDownTimer(Y, Y) { // from class: com.anythink.core.c.e.1.1
                        @Override // android.os.CountDownTimer
                        public final void onFinish() {
                            String str5 = e.a;
                            zArr[0] = true;
                            if (aVar != null) {
                                aVar.a(dVar);
                            }
                        }

                        @Override // android.os.CountDownTimer
                        public final void onTick(long j) {
                        }
                    };
                    if (Y == 0) {
                        zArr[0] = true;
                        a aVar3 = aVar;
                        if (aVar3 != null) {
                            aVar3.a(dVar);
                        }
                    } else {
                        String str5 = e.a;
                        countDownTimer.start();
                    }
                    new j(e.this.c, str, str2, str3, P, d, map).a(0, new i() { // from class: com.anythink.core.c.e.1.2
                        @Override // com.anythink.core.common.g.i
                        public final void onLoadCanceled(int i) {
                            if (zArr[0] || aVar == null) {
                                return;
                            }
                            aVar.a(dVar);
                        }

                        @Override // com.anythink.core.common.g.i
                        public final void onLoadError(int i, String str6, AdError adError) {
                            String str7 = e.a;
                            if (ErrorCode.statuError.equals(adError.getCode()) && (ErrorCode.placementIdError.equals(adError.getPlatformCode()) || ErrorCode.appIdError.equals(adError.getPlatformCode()) || "10001".equals(adError.getPlatformCode()))) {
                                String str8 = str + str3 + str2;
                                String str9 = e.a;
                                StringBuilder sb = new StringBuilder("code: ");
                                sb.append(adError.getPlatformCode());
                                sb.append("msg: ");
                                sb.append(adError.getPlatformMSG());
                                sb.append(", key -> ");
                                sb.append(str8);
                                p.a(e.this.c, g.A, str8, System.currentTimeMillis());
                            }
                            n.a().a(new Runnable() { // from class: com.anythink.core.c.e.1.2.2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    String str10 = e.a;
                                    if (countDownTimer != null) {
                                        countDownTimer.cancel();
                                    }
                                }
                            });
                            if (zArr[0] || aVar == null) {
                                return;
                            }
                            aVar.a(dVar);
                        }

                        @Override // com.anythink.core.common.g.i
                        public final void onLoadFinish(int i, Object obj) {
                            String str6 = (String) obj;
                            try {
                                JSONObject jSONObject = new JSONObject(str6);
                                jSONObject.put("updateTime", System.currentTimeMillis());
                                str6 = jSONObject.toString();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            d b2 = d.b(str6);
                            if (b2 != null) {
                                e eVar = e.this;
                                Context context = e.this.c;
                                String str7 = str3;
                                if (b2.Z() != 1) {
                                    str6 = "";
                                }
                                eVar.a(context, str7, b2, str6);
                                e.a(e.this.c, b2);
                                if (b2.N() == 1) {
                                    com.anythink.core.common.s.a().a(e.this.c, str3);
                                }
                            }
                            n.a().a(new Runnable() { // from class: com.anythink.core.c.e.1.2.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    String str8 = e.a;
                                    if (countDownTimer != null) {
                                        countDownTimer.cancel();
                                    }
                                }
                            });
                            if (zArr[0]) {
                                if (aVar == null || b2 == null) {
                                    return;
                                }
                                aVar.b(b2);
                            } else if (b2 != null) {
                                if (aVar != null) {
                                    aVar.a(b2);
                                }
                            } else if (aVar != null) {
                                aVar.a(ErrorCode.getErrorCode(ErrorCode.placeStrategyError, "", "Placement Service error."));
                            }
                        }

                        @Override // com.anythink.core.common.g.i
                        public final void onLoadStart(int i) {
                        }
                    });
                }
            }
        });
    }

    public final d b(String str) {
        String p = n.a().p();
        ConcurrentHashMap<String, d> concurrentHashMap = this.d;
        return concurrentHashMap.get(p + str);
    }
}
