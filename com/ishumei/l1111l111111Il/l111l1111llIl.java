package com.ishumei.l1111l111111Il;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.openalliance.ad.constant.t;
import com.ishumei.l111l1111l1Il.l111l11111I1l;
import com.ishumei.smantifraud.SmAntiFraud;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l111l1111llIl.class */
public class l111l1111llIl implements l1111l111111Il.InterfaceC0282l1111l111111Il, l1111l111111Il.l111l11111lIl {
    private static final int l1111l111111Il = -1;
    private static final int l111l11111I1l = -3;
    private static int l111l11111Il = -4;
    private static final int l111l11111lIl = -2;
    private static final String l111l1111l1Il = "sm";
    private com.ishumei.l111l11111I1l.l111l11111lIl l111l1111lI1l;
    private l111l11111I1l.l1111l111111Il l111l1111lIl;
    private AtomicInteger l111l1111llIl;
    private l1111l111111Il l11l1111lIIl;

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l111l1111llIl$l1111l111111Il.class */
    public static class l1111l111111Il {
        public static Context l111l11111Il;
        public static String l111l1111l1Il;
        public static String l111l1111llIl;
        boolean l1111l111111Il;
        l111l11111I1l.l1111l111111Il<?> l111l11111I1l;
        int l111l11111lIl;
        private String l111l1111lI1l;
        private String l111l1111lIl;
        private l111l11111lIl l11l1111I11l;
        private String l11l1111I1l;
        private InterfaceC0282l1111l111111Il l11l1111lIIl;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.ishumei.l1111l111111Il.l111l1111llIl$l1111l111111Il$1  reason: invalid class name */
        /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l111l1111llIl$l1111l111111Il$1.class */
        public final class AnonymousClass1 extends com.ishumei.l111l11111I1l.l111l11111lIl {
            AnonymousClass1(boolean z, int i, boolean z2, long j, boolean z3) {
                super(z, i, false, 0L, false);
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (l1111l111111Il.this.l11l1111lIIl != null) {
                        l1111l111111Il.this.l111l1111lI1l = l1111l111111Il.this.l11l1111lIIl.l111l11111Il();
                    }
                    if (l1111l111111Il.this.l11l1111I11l != null) {
                        l1111l111111Il.this.l111l1111lIl = l1111l111111Il.this.l11l1111I11l.l111l1111l1Il();
                    }
                    com.ishumei.l111l1111l1Il.l1111l111111Il l1111l111111Il = com.ishumei.l111l1111l1Il.l1111l111111Il.l1111l111111Il(l1111l111111Il.this.l111l1111lIl, SmAntiFraud.option.l111l1111l1Il(), SmAntiFraud.option.l111l11111Il());
                    new com.ishumei.l111l1111l1Il.l111l11111I1l().l1111l111111Il(l1111l111111Il).l1111l111111Il(l1111l111111Il.this.l111l1111lI1l.getBytes("utf-8"), l1111l111111Il.this.l111l1111lI1l.contains("\"encode\":1"), (Map<String, String>) null, l1111l111111Il.this.l111l11111I1l);
                } catch (Exception e) {
                }
            }
        }

        /* renamed from: com.ishumei.l1111l111111Il.l111l1111llIl$l1111l111111Il$l1111l111111Il  reason: collision with other inner class name */
        /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l111l1111llIl$l1111l111111Il$l1111l111111Il.class */
        public interface InterfaceC0282l1111l111111Il {
            String l111l11111Il();
        }

        /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l111l1111llIl$l1111l111111Il$l111l11111lIl.class */
        public interface l111l11111lIl {
            String l111l1111l1Il();
        }

        public l1111l111111Il() {
        }

        l1111l111111Il(InterfaceC0282l1111l111111Il interfaceC0282l1111l111111Il, l111l11111lIl l111l11111lil, boolean z, int i, l111l11111I1l.l1111l111111Il<?> l1111l111111il, String str) {
            this.l111l1111lI1l = null;
            this.l111l1111lIl = null;
            this.l11l1111I11l = null;
            this.l111l11111I1l = null;
            this.l11l1111lIIl = interfaceC0282l1111l111111Il;
            this.l11l1111I11l = l111l11111lil;
            this.l1111l111111Il = true;
            this.l111l11111lIl = 1;
            this.l111l11111I1l = l1111l111111il;
            this.l11l1111I1l = str;
        }

        private void l1111l111111Il(boolean z) {
            if (SmAntiFraud.option.l11l1111I1l()) {
                new AnonymousClass1(z, this.l111l11111lIl, false, 0L, false).l1111l111111Il();
            }
        }

        final void l1111l111111Il() {
            l1111l111111Il(this.l1111l111111Il);
        }
    }

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l1111l111111Il/l111l1111llIl$l111l11111lIl.class */
    static final class l111l11111lIl {
        private static final l111l1111llIl l1111l111111Il = new l111l1111llIl((byte) 0);

        private l111l11111lIl() {
        }
    }

    private l111l1111llIl() {
        this.l111l1111llIl = new AtomicInteger(0);
        this.l111l1111lI1l = new com.ishumei.l111l11111I1l.l111l11111lIl(true, 1) { // from class: com.ishumei.l1111l111111Il.l111l1111llIl.1
            {
                super(true, 1);
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.ishumei.l111l11111lIl.l111l11111lIl l111l11111lIl2 = com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il().l111l11111lIl();
                    if (l111l11111lIl2 != null && l111l11111lIl2.l111l11111Il() > 0 && !com.ishumei.l111l11111Il.l111l1111lIl.l111l1111lI1l() && l111l1111llIl.this.l111l1111llIl.incrementAndGet() <= l111l11111lIl2.l111l11111Il()) {
                        com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111lIl().l1111l111111Il(this, 1, 1000L, false);
                        return;
                    }
                    l111l1111llIl.this.l111l1111llIl.set(0);
                    if (SmAntiFraud.option.l11l1111I11l()) {
                        com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il().l111l11111I1l();
                    }
                    l1111l111111Il l1111l111111il = l111l1111llIl.this.l11l1111lIIl;
                    boolean z = l1111l111111il.l1111l111111Il;
                    if (SmAntiFraud.option.l11l1111I1l()) {
                        new l1111l111111Il.AnonymousClass1(z, l1111l111111il.l111l11111lIl, false, 0L, false).l1111l111111Il();
                    }
                } catch (Exception e) {
                }
            }
        };
        l111l11111I1l.l1111l111111Il<Object> l1111l111111il = new l111l11111I1l.l1111l111111Il<Object>(true, 2) { // from class: com.ishumei.l1111l111111Il.l111l1111llIl.3
            {
                super(true, 2);
            }

            @Override // com.ishumei.l111l1111l1Il.l111l11111I1l.l1111l111111Il
            public final void l1111l111111Il(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    int i = jSONObject.getInt("code");
                    if (i != 1100) {
                        l1111l111111Il("", i);
                    } else if (this.l111l11111lIl.l11l1111I1ll) {
                        SmAntiFraud.getServerIdCallback().onError(-3);
                    } else if (l111l1111llIl.this.l1111l111111Il(jSONObject)) {
                    } else {
                        l1111l111111Il("", i);
                    }
                } catch (Exception e) {
                }
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
            @Override // com.ishumei.l111l1111l1Il.l111l11111I1l.l1111l111111Il
            public final boolean l1111l111111Il(String str, int i) {
                throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
            }
        };
        this.l111l1111lIl = l1111l111111il;
        this.l11l1111lIIl = new l1111l111111Il(this, this, true, 1, l1111l111111il, "");
    }

    /* synthetic */ l111l1111llIl(byte b) {
        this();
    }

    public static l111l1111llIl l1111l111111Il() {
        return l111l11111lIl.l1111l111111Il;
    }

    public static String l1111l111111Il(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "fp-it.fengkongcloud.com";
        }
        if (str2.startsWith("http")) {
            return str2;
        }
        if (str.startsWith("http")) {
            return str + str2;
        }
        if (str.equals(str2)) {
            str = "fp-it.fengkongcloud.com";
        }
        if (z) {
            return "https://" + str + str2;
        }
        return "http://" + str + str2;
    }

    private static void l111l11111lIl(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("c", -1);
        int optInt2 = jSONObject.optInt("t", -1);
        if (optInt < 0 || optInt2 < 0) {
            return;
        }
        com.ishumei.l111l11111lIl.l111l11111lIl.l1111l111111Il.l1111l111111Il().l1111l111111Il(optInt2, optInt);
    }

    public final void l1111l111111Il(final SmAntiFraud.IDeviceIdCallback iDeviceIdCallback, final boolean z) {
        new Thread(new Runnable() { // from class: com.ishumei.l1111l111111Il.l111l1111llIl.2
            @Override // java.lang.Runnable
            public final void run() {
                final String l111l11111I1l2 = l111l1111llIl.this.l111l11111I1l();
                if (z) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ishumei.l1111l111111Il.l111l1111llIl.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            iDeviceIdCallback.onResult(l111l11111I1l2);
                        }
                    });
                } else {
                    iDeviceIdCallback.onResult(l111l11111I1l2);
                }
            }
        }).start();
    }

    public final boolean l1111l111111Il(JSONObject jSONObject) {
        boolean z = false;
        boolean z2 = false;
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9b9a8b9e9693"));
            String optString = jSONObject2.optString(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9b9a89969c9ab69b"));
            int optInt = jSONObject2.optInt("c", -1);
            int optInt2 = jSONObject2.optInt("t", -1);
            if (optInt >= 0 && optInt2 >= 0) {
                com.ishumei.l111l11111lIl.l111l11111lIl.l1111l111111Il.l1111l111111Il().l1111l111111Il(optInt2, optInt);
            }
            if (!TextUtils.isEmpty(optString)) {
                z = true;
                l11l1111I1l.l1111l111111Il().l1111l111111Il(optString);
                if (SmAntiFraud.getServerIdCallback() != null) {
                    l1111l111111Il.l111l1111llIl = optString;
                    SmAntiFraud.IServerSmidCallback serverIdCallback = SmAntiFraud.getServerIdCallback();
                    StringBuilder sb = new StringBuilder("B");
                    sb.append(optString);
                    serverIdCallback.onSuccess(sb.toString());
                }
                z2 = true;
                com.ishumei.l111l11111I1l.l1111l111111Il.l111l11111I1l();
            }
            return z;
        } catch (Exception e) {
            return z2;
        }
    }

    public final String l111l11111I1l() {
        synchronized (this) {
            if (!TextUtils.isEmpty(l1111l111111Il.l111l1111llIl)) {
                return "B" + l1111l111111Il.l111l1111llIl;
            }
            String l111l11111lIl2 = l11l1111I1l.l1111l111111Il().l111l11111lIl();
            if (!TextUtils.isEmpty(l111l11111lIl2)) {
                l1111l111111Il.l111l1111llIl = l111l11111lIl2;
                return "B" + l1111l111111Il.l111l1111llIl;
            }
            String l111l11111lIl3 = com.ishumei.l1111l111111Il.l1111l111111Il.l1111l111111Il().l111l11111lIl();
            if (!TextUtils.isEmpty(l111l11111lIl3)) {
                return "D" + l111l11111lIl3;
            }
            if (SmAntiFraud.option == null) {
                String l111l11111Il2 = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9c9e9393df989a8bbb9a89969c9ab69bdf9d8a8bdf91908bdf9c8d9a9e8b9a");
                try {
                    return "D" + com.ishumei.l111l1111llIl.l111l1111lIl.l111l11111lIl(com.ishumei.l111l11111lIl.l111l11111I1l.l1111l111111Il().l1111l111111Il(new IllegalAccessException(l111l11111Il2)).getBytes());
                } catch (Exception e) {
                    return "D" + Base64.encodeToString((l111l11111Il2 + t.aE + e).getBytes(), 0);
                }
            }
            String l1111l111111Il2 = com.ishumei.l1111l111111Il.l1111l111111Il.l1111l111111Il().l1111l111111Il(SmAntiFraud.option.l11l1111lIIl() ? 1 : 0);
            if (TextUtils.isEmpty(l1111l111111Il2)) {
                try {
                    return "D" + com.ishumei.l111l1111llIl.l111l1111lIl.l111l11111lIl(com.ishumei.l111l11111lIl.l111l11111I1l.l1111l111111Il().l1111l111111Il(new IllegalStateException()).getBytes());
                } catch (IOException e2) {
                    return "D" + Base64.encodeToString(e2.toString().getBytes(), 0);
                }
            }
            try {
                return "D" + com.ishumei.l111l1111llIl.l111l1111lIl.l111l11111lIl(l1111l111111Il2.getBytes());
            } catch (Exception e3) {
                try {
                    return "D" + com.ishumei.l111l1111llIl.l111l1111lIl.l111l11111lIl(com.ishumei.l111l11111lIl.l111l11111I1l.l1111l111111Il().l1111l111111Il(e3).getBytes());
                } catch (Exception e4) {
                    return "D" + Base64.encodeToString(e4.toString().getBytes(), 0);
                }
            }
        }
    }

    @Override // com.ishumei.l1111l111111Il.l111l1111llIl.l1111l111111Il.InterfaceC0282l1111l111111Il
    public String l111l11111Il() {
        com.ishumei.l111l11111lIl.l111l11111lIl l111l11111lIl2 = com.ishumei.l111l11111lIl.l1111l111111Il.l1111l111111Il().l111l11111lIl();
        int i = 0;
        boolean z = l111l11111lIl2 == null || l111l11111lIl2.l11l1111Il();
        boolean l11l1111lIIl = SmAntiFraud.option.l11l1111lIIl();
        if (z) {
            i = 2;
        }
        return com.ishumei.l1111l111111Il.l1111l111111Il.l1111l111111Il().l1111l111111Il(l11l1111lIIl | i);
    }

    public final void l111l11111lIl() {
        this.l111l1111lI1l.l1111l111111Il();
    }

    @Override // com.ishumei.l1111l111111Il.l111l1111llIl.l1111l111111Il.l111l11111lIl
    public String l111l1111l1Il() {
        return SmAntiFraud.option.l11l1111Il1l();
    }
}
