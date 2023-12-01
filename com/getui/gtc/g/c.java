package com.getui.gtc.g;

import android.text.TextUtils;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.getui.gtc.api.SdkInfo;
import com.getui.gtc.base.GtcProvider;
import com.getui.gtc.base.util.ScheduleQueue;
import com.getui.gtc.e.c;
import com.getui.gtc.entity.a;
import com.getui.gtc.f.b;
import com.getui.gtc.f.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/g/c.class */
public final class c {

    /* renamed from: a */
    String f22017a;
    String b;

    /* renamed from: c */
    volatile Map<String, a.C0351a> f22018c;

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/g/c$a.class */
    public static final class a {

        /* renamed from: a */
        private static c f22025a = new c((byte) 0);

        public static /* synthetic */ c a() {
            return f22025a;
        }
    }

    private c() {
        com.getui.gtc.e.c cVar;
        com.getui.gtc.e.c cVar2;
        this.f22018c = new HashMap();
        try {
            this.f22017a = GtcProvider.context().getFilesDir().getAbsolutePath();
            File file = new File(this.f22017a);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.b = this.f22017a + File.separator + "libs";
            File file2 = new File(this.b);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            cVar = c.a.f21997a;
            HashSet<String> hashSet = new HashSet(cVar.f21995a.l);
            for (String str : hashSet) {
                if (a(str)) {
                    cVar2 = c.a.f21997a;
                    cVar2.f21995a.e(str);
                    com.getui.gtc.i.c.a.a("remove: ".concat(String.valueOf(hashSet)));
                }
            }
            com.getui.gtc.dyc.b.a.a(GtcProvider.context(), new d() { // from class: com.getui.gtc.g.c.1
                {
                    c.this = this;
                }

                @Override // com.getui.gtc.f.d
                public final void a(String str2) {
                }

                @Override // com.getui.gtc.f.d
                public final void a(Map<String, String> map, Map<String, String> map2) {
                    com.getui.gtc.e.c cVar3;
                    if (map == null || map2 == null) {
                        return;
                    }
                    com.getui.gtc.entity.a a2 = com.getui.gtc.entity.a.a(map2);
                    com.getui.gtc.entity.a a3 = com.getui.gtc.entity.a.a(map);
                    if (a3 != null) {
                        int size = a3.f22001a.size();
                        HashSet hashSet2 = new HashSet();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 >= size) {
                                break;
                            }
                            a.C0351a a4 = a3.a(i2);
                            if (a2 == null || a2.b(a4.f22002a) == null || !a2.b(a4.f22002a).b.equalsIgnoreCase(a4.b) || !a2.b(a4.f22002a).f22003c.equalsIgnoreCase(a4.f22003c)) {
                                hashSet2.add(a4.f22003c);
                            }
                            i = i2 + 1;
                        }
                        com.getui.gtc.i.c.a.a("wait remove: ".concat(String.valueOf(hashSet2)));
                        cVar3 = c.a.f21997a;
                        cVar3.f21995a.a(hashSet2);
                    }
                    if (a2 == null) {
                        return;
                    }
                    int size2 = a2.f22001a.size();
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= size2) {
                            return;
                        }
                        a.C0351a a5 = a2.a(i4);
                        if (!c.this.a(a5)) {
                            try {
                                com.getui.gtc.h.b.a(a5, c.this.b + File.separator + a5.f22003c);
                            } catch (Exception e) {
                                com.getui.gtc.i.c.a.a(e);
                            }
                        }
                        i3 = i4 + 1;
                    }
                }
            }.f22008c);
        } catch (Throwable th) {
            com.getui.gtc.i.c.a.b(th);
        }
    }

    /* synthetic */ c(byte b) {
        this();
    }

    private void b(SdkInfo sdkInfo) {
        List<a.C0351a> stubs = sdkInfo.getStubs();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= stubs.size()) {
                return;
            }
            final a.C0351a c0351a = stubs.get(i2);
            if (!b(c0351a)) {
                this.f22018c.put(c0351a.d, c0351a);
                if (c0351a.j) {
                    b.a(GtcProvider.context(), null, null, c0351a.d, sdkInfo.getAppid(), sdkInfo.getCid(), new com.getui.gtc.g.a.b() { // from class: com.getui.gtc.g.c.2
                        {
                            c.this = this;
                        }

                        @Override // com.getui.gtc.g.a.b
                        public final void a(boolean z) {
                            if (z) {
                                return;
                            }
                            c.this.f22018c.remove(c0351a.d);
                        }
                    });
                } else {
                    try {
                        b.a(GtcProvider.context(), c0351a.d, sdkInfo.getAppid(), sdkInfo.getCid());
                    } catch (Throwable th) {
                        this.f22018c.remove(c0351a.d);
                        com.getui.gtc.i.c.a.b("local gtcFile failed: ".concat(String.valueOf(th)));
                    }
                }
            }
            i = i2 + 1;
        }
    }

    private boolean b(a.C0351a c0351a) {
        if (this.f22018c == null) {
            return false;
        }
        return this.f22018c.containsKey(c0351a.d);
    }

    private com.getui.gtc.entity.a c(final SdkInfo sdkInfo) {
        Map<String, String> a2 = com.getui.gtc.f.b.a(sdkInfo, new b.a() { // from class: com.getui.gtc.g.c.3
            {
                c.this = this;
            }

            @Override // com.getui.gtc.f.b.a
            public final void a(Map<String, String> map) {
                c.this.a(sdkInfo, com.getui.gtc.entity.a.a(map));
            }
        });
        if (a2 == null) {
            return null;
        }
        return com.getui.gtc.entity.a.a(a2);
    }

    final String a(SdkInfo sdkInfo, a.C0351a c0351a) {
        com.getui.gtc.entity.a a2;
        a.C0351a b;
        File file = new File(this.b + File.separator + c0351a.f22003c);
        if (a(c0351a)) {
            return file.getAbsolutePath();
        }
        try {
            Map<String, String> a3 = com.getui.gtc.dyc.b.a.a(GtcProvider.context(), sdkInfo.getModuleName());
            if (a3 == null || (a2 = com.getui.gtc.entity.a.a(a3)) == null || (b = a2.b(c0351a.f22002a)) == null || !b.e.equals(c0351a.e)) {
                return null;
            }
            com.getui.gtc.h.b.a(c0351a, file.getAbsolutePath());
            if (com.getui.gtc.i.b.a.a(file.getAbsolutePath()).equals(c0351a.e)) {
                return file.getAbsolutePath();
            }
            com.getui.gtc.i.b.a.a(file);
            throw new Exception("The net gtcFile save failed or has a wrong checksum");
        } catch (Exception e) {
            com.getui.gtc.i.c.a.a(e);
            return null;
        }
    }

    public final void a(SdkInfo sdkInfo) {
        b(sdkInfo);
        a(sdkInfo, c(sdkInfo));
    }

    final void a(final SdkInfo sdkInfo, com.getui.gtc.entity.a aVar) {
        com.getui.gtc.e.c cVar;
        if (aVar == null) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= aVar.f22001a.size()) {
                break;
            }
            final a.C0351a a2 = aVar.a(i2);
            cVar = c.a.f21997a;
            final long a3 = cVar.b.a(a2.f22002a);
            if (!b(a2)) {
                if ((a2.g <= 0 || a3 <= 0 || System.currentTimeMillis() - a3 <= a2.g) && (a3 <= 0 || !a2.i)) {
                    this.f22018c.put(a2.d, a2);
                    ScheduleQueue.getInstance().addSchedule(new Runnable() { // from class: com.getui.gtc.g.c.4
                        {
                            c.this = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            com.getui.gtc.e.c cVar2;
                            String a4 = c.this.a(sdkInfo, a2);
                            if (a4 == null) {
                                c.this.f22018c.remove(a2.d);
                                return;
                            }
                            File file = new File(a4);
                            final File file2 = new File(a4 + com.getui.gtc.c.a.b);
                            com.getui.gtc.i.a.a.a(file, file2, a2.f);
                            if (a2.j) {
                                b.a(GtcProvider.context(), file2.getAbsolutePath(), c.this.f22017a, a2.d, sdkInfo.getAppid(), sdkInfo.getCid(), new com.getui.gtc.g.a.b() { // from class: com.getui.gtc.g.c.4.1
                                    {
                                        AnonymousClass4.this = this;
                                    }

                                    @Override // com.getui.gtc.g.a.b
                                    public final void a(boolean z) {
                                        com.getui.gtc.e.c cVar3;
                                        com.getui.gtc.i.b.a.a(file2);
                                        if (!z) {
                                            c.this.f22018c.remove(a2.d);
                                        } else if (a3 == 0) {
                                            cVar3 = c.a.f21997a;
                                            cVar3.b.a(a2.f22002a, System.currentTimeMillis());
                                        }
                                    }
                                });
                                return;
                            }
                            try {
                                b.a(GtcProvider.context(), file2.getAbsolutePath(), c.this.f22017a, a2.d, sdkInfo.getAppid(), sdkInfo.getCid());
                                if (a3 == 0) {
                                    cVar2 = c.a.f21997a;
                                    cVar2.b.a(a2.f22002a, System.currentTimeMillis());
                                }
                            } catch (Throwable th) {
                                try {
                                    c.this.f22018c.remove(a2.d);
                                    com.getui.gtc.i.c.a.b("net gtcFile filed: ".concat(String.valueOf(th)));
                                } finally {
                                    com.getui.gtc.i.b.a.a(file2);
                                }
                            }
                        }
                    });
                } else {
                    arrayList.add(Integer.valueOf(i2));
                }
            }
            i = i2 + 1;
        }
        for (Integer num : arrayList) {
            a(aVar.a(num.intValue()).f22003c);
            aVar.c(num.intValue());
        }
    }

    final boolean a(a.C0351a c0351a) {
        File file = new File(this.b + File.separator + c0351a.f22003c);
        if (file.exists() && file.isFile()) {
            return com.getui.gtc.i.b.a.a(file.getAbsolutePath()).equals(c0351a.e);
        }
        return false;
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            com.getui.gtc.i.b.a.a(this.f22017a, str);
            String a2 = com.getui.gtc.g.a.a(str);
            if (TextUtils.isEmpty(a2)) {
                return true;
            }
            com.getui.gtc.i.b.a.a(new File(this.f22017a + BridgeUtil.SPLIT_MARK + a2));
            return true;
        } catch (Exception e) {
            com.getui.gtc.i.c.a.b(e);
            return false;
        }
    }
}
