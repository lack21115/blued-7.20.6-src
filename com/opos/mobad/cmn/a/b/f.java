package com.opos.mobad.cmn.a.b;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.wrapper.download.RedirectReqWrapper;
import com.oplus.instant.router.callback.Callback;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.umeng.analytics.pro.bh;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/b/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile com.opos.cmn.an.d.d.a f12200a;
    private static WeakReference<b.InterfaceC0517b> d;
    private static final byte[] b = new byte[0];

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f12201c = new byte[0];
    private static final String e = com.opos.cmn.an.a.b.a("aGV5dGFwX3VuaW9uX3Rva2Vu");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.cmn.a.b.f$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/b/f$1.class */
    public static final class AnonymousClass1 implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f12202a;
        final /* synthetic */ View b;

        /* renamed from: c  reason: collision with root package name */
        private com.opos.cmn.e.a.b.a f12203c;

        AnonymousClass1(Context context, View view) {
            this.f12202a = context;
            this.b = view;
        }

        @Override // com.opos.mobad.cmn.a.a.b
        public void a() {
            com.opos.cmn.e.a.b.a aVar = this.f12203c;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.opos.mobad.cmn.a.a.b
        public void a(final a.InterfaceC0509a interfaceC0509a) {
            com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.cmn.a.b.f.1.1
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    anonymousClass1.f12203c = f.c(anonymousClass1.f12202a, AnonymousClass1.this.b);
                    if (AnonymousClass1.this.f12203c == null) {
                        interfaceC0509a.a();
                    } else {
                        AnonymousClass1.this.f12203c.a("当前为非Wi-Fi环境，\n是否继续下载？", "下载", "取消", new com.opos.cmn.e.a.b.c.a() { // from class: com.opos.mobad.cmn.a.b.f.1.1.1
                            @Override // com.opos.cmn.e.a.b.c.a
                            public void a(View view, int[] iArr) {
                                interfaceC0509a.a();
                                AnonymousClass1.this.f12203c.a();
                            }

                            @Override // com.opos.cmn.e.a.b.c.a
                            public void b(View view, int[] iArr) {
                                interfaceC0509a.b();
                                AnonymousClass1.this.f12203c.a();
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.cmn.a.b.f$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/cmn/a/b/f$2.class */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12206a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[a.values().length];
            f12206a = iArr;
            try {
                iArr[a.Video.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12206a[a.ClickBt.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f12206a[a.NonClickBt.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f12206a[a.FloatLayerClickBt.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f12206a[a.FloatLayerNonClickBt.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static int a(Context context) {
        int i = 0;
        if (context != null) {
            String e2 = com.opos.cmn.an.h.e.a.e(context);
            boolean z = true;
            int hashCode = e2.hashCode();
            if (hashCode != -1429363305) {
                if (hashCode != -1068855134) {
                    if (hashCode == -840542575 && e2.equals("unicom")) {
                        z = true;
                    }
                } else if (e2.equals("mobile")) {
                    z = false;
                }
            } else if (e2.equals("telecom")) {
                z = true;
            }
            if (z) {
                if (!z) {
                    return !z ? 0 : 2;
                }
                return 3;
            }
            i = 1;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(java.io.File r4) {
        /*
            r0 = r4
            if (r0 == 0) goto L23
            r0 = r4
            boolean r0 = r0.isDirectory()     // Catch: java.lang.Exception -> L1a
            if (r0 == 0) goto L23
            r0 = r4
            java.io.File[] r0 = r0.listFiles()     // Catch: java.lang.Exception -> L1a
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L23
            r0 = r6
            int r0 = r0.length     // Catch: java.lang.Exception -> L1a
            r5 = r0
            goto L25
        L1a:
            r6 = move-exception
            java.lang.String r0 = "Utils"
            java.lang.String r1 = ""
            r2 = r6
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L23:
            r0 = 0
            r5 = r0
        L25:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            java.lang.String r1 = "getFolderFilesCount folderFile="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            if (r0 == 0) goto L40
            r0 = r4
            java.lang.String r0 = r0.getAbsolutePath()
            r4 = r0
            goto L43
        L40:
            java.lang.String r0 = "null"
            r4 = r0
        L43:
            r0 = r6
            r1 = r4
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            java.lang.String r1 = ",count="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "Utils"
            r1 = r6
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.a(java.io.File):int");
    }

    private static Activity a(View view) {
        if (view != null) {
            Context context = view.getContext();
            while (true) {
                Context context2 = context;
                if (!(context2 instanceof ContextWrapper)) {
                    break;
                }
                com.opos.cmn.an.f.a.b("Utils", "context instanceof ContextWrapper");
                if (context2 instanceof Activity) {
                    com.opos.cmn.an.f.a.b("Utils", "context instanceof Activity");
                    return (Activity) context2;
                }
                context = ((ContextWrapper) context2).getBaseContext();
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "getActivity = null");
        return null;
    }

    public static final ActivityInfo a(Context context, Class cls) {
        if (context == null || cls == null) {
            return null;
        }
        try {
            return context.getPackageManager().getActivityInfo(new ComponentName(context, cls), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            com.opos.cmn.an.f.a.c("Utils", "", e2);
            return null;
        }
    }

    public static a.b a(Context context, View view) {
        return new AnonymousClass1(context, view);
    }

    public static com.opos.mobad.model.b.c a(Context context, String str, int i, String str2) {
        if (context == null || com.opos.cmn.an.c.a.a(str)) {
            return null;
        }
        com.opos.mobad.model.b.c cVar = new com.opos.mobad.model.b.c();
        cVar.b(a());
        cVar.c(str);
        cVar.c(i);
        int[] a2 = a(context, i);
        cVar.d(a2[1]);
        cVar.e(a2[0]);
        cVar.a(str2);
        cVar.b(f());
        cVar.d(com.opos.mobad.service.f.a.a().v());
        return cVar;
    }

    public static MaterialFileData a(AdItemData adItemData) {
        List<MaterialData> i;
        MaterialData materialData;
        List<MaterialFileData> F;
        if (adItemData == null || (i = adItemData.i()) == null || i.size() <= 0 || (materialData = i.get(0)) == null || (F = materialData.F()) == null || F.size() <= 0) {
            return null;
        }
        return F.get(0);
    }

    public static String a() {
        return b.f12150a;
    }

    public static String a(int i) {
        switch (i) {
            case 10402:
                return "no video to play.";
            case 10403:
                return "no net,can't play video.";
            case 10404:
                return "video has expired.";
            case 10405:
                return "reward video only can play on 4.1 android version and above";
            case 10406:
                return "stream video only can be played in wifi net.";
            case 10407:
                return "unsupported play mode.";
            case 10408:
                return "video not cached.";
            case 10409:
                return "unknown creative.";
            case 10410:
                return "source exception.";
            case 10411:
                return "renderer exception.";
            case 10412:
                return "unexcepted exception.";
            default:
                return "";
        }
    }

    public static String a(Context context, String str, int[] iArr, long j) {
        int indexOf;
        StringBuilder sb = new StringBuilder();
        sb.append("handleMacroInMonitorLinkUrl before=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        String str2 = str;
        if (context != null) {
            str2 = str;
            if (!com.opos.cmn.an.c.a.a(str)) {
                str2 = str;
                if (str.length() > 0) {
                    int indexOf2 = str.indexOf("$");
                    StringBuilder sb2 = new StringBuilder();
                    str2 = str;
                    if (-1 != indexOf2) {
                        int i = 0;
                        sb2.append(str.substring(0, indexOf2));
                        String substring = str.substring(indexOf2);
                        do {
                            int i2 = i + 1;
                            indexOf = substring.indexOf("$", i2);
                            if (-1 != indexOf) {
                                String b2 = b(context, substring.substring(i2, indexOf), iArr, j);
                                if (com.opos.cmn.an.c.a.a(b2)) {
                                    b2 = substring.substring(i, indexOf + 1);
                                }
                                sb2.append(b2);
                                int i3 = indexOf + 1;
                                i = substring.indexOf("$", i3);
                                sb2.append((-1 == i || i < indexOf) ? substring.substring(i3) : substring.substring(i3, i));
                            } else {
                                sb2.append(substring);
                            }
                            if (-1 == i) {
                                break;
                            }
                        } while (-1 != indexOf);
                        str2 = sb2.toString();
                    }
                }
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "handleMacroInMonitorLinkUrl after=" + str2);
        return str2;
    }

    public static final String a(AdItemData adItemData, String str, String str2) {
        String str3 = "";
        if (adItemData != null) {
            str3 = "";
            if (!com.opos.cmn.an.c.a.a(str)) {
                str3 = "";
                if (adItemData.i() != null) {
                    str3 = "";
                    if (adItemData.i().size() > 0) {
                        try {
                            String d2 = d(str);
                            StringBuilder sb = new StringBuilder();
                            sb.append(com.opos.mobad.service.e.a.a().k());
                            sb.append(com.opos.cmn.an.a.d.a(d2));
                            sb.append(str2);
                            sb.append(adItemData.f() != null ? adItemData.f() : "");
                            sb.append(adItemData.i().get(0).c() != null ? adItemData.i().get(0).c() : "");
                            str3 = com.opos.cmn.an.a.c.a(sb.toString());
                        } catch (Exception e2) {
                            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
                            str3 = "";
                        }
                    }
                }
            }
        }
        com.opos.cmn.an.f.a.b("Utils", "jsSign=" + str3);
        return str3;
    }

    public static void a(Context context, String str, long j) {
        if (context != null) {
            try {
                if (com.opos.cmn.an.c.a.a(str)) {
                    return;
                }
                h(context).a(str, Long.valueOf(j));
                com.opos.cmn.an.f.a.b("Utils", "putRewardTime pkgName=" + str + ",timestamp=" + j);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, Callback callback, String str4) {
        try {
            c.a(context, str, str2, str3, callback, "10001", str4);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4) {
        c.a(context, str, str2, str3, "10001", str4);
    }

    public static void a(b.InterfaceC0517b interfaceC0517b) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("setCacheInterBaseAd=");
            sb.append(interfaceC0517b != null ? interfaceC0517b : com.igexin.push.core.b.l);
            com.opos.cmn.an.f.a.b("Utils", sb.toString());
            if (interfaceC0517b != null) {
                d = new WeakReference<>(interfaceC0517b);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
    }

    public static void a(String str) {
        b.f12150a = str;
        StringBuilder sb = new StringBuilder();
        sb.append("setAppId=");
        if (str == null) {
            str = "";
        }
        sb.append(str);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
    }

    public static void a(boolean z) {
        b.e = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
        if (c(r4).equals(d(r4)) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.app.Activity r4) {
        /*
            r0 = r4
            if (r0 == 0) goto L2e
            java.lang.String r0 = ""
            r1 = r4
            java.lang.String r1 = d(r1)     // Catch: java.lang.Exception -> L25
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L25
            if (r0 != 0) goto L20
            r0 = r4
            java.lang.String r0 = c(r0)     // Catch: java.lang.Exception -> L25
            r1 = r4
            java.lang.String r1 = d(r1)     // Catch: java.lang.Exception -> L25
            boolean r0 = r0.equals(r1)     // Catch: java.lang.Exception -> L25
            r5 = r0
            r0 = r5
            if (r0 == 0) goto L2e
        L20:
            r0 = 1
            r5 = r0
            goto L30
        L25:
            r4 = move-exception
            java.lang.String r0 = "Utils"
            java.lang.String r1 = ""
            r2 = r4
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L2e:
            r0 = 0
            r5 = r0
        L30:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            java.lang.String r1 = "isCurrentActivity="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "Utils"
            r1 = r4
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.a(android.app.Activity):boolean");
    }

    public static boolean a(Context context, AdItemData adItemData, a aVar) {
        return a(adItemData, aVar) && !"WIFI".equalsIgnoreCase(com.opos.cmn.an.h.c.a.f(context)) && j();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r8, com.opos.mobad.model.data.AdItemData r9, com.opos.mobad.model.data.MaterialData r10, int[] r11) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.a(android.content.Context, com.opos.mobad.model.data.AdItemData, com.opos.mobad.model.data.MaterialData, int[]):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = r4
            if (r0 == 0) goto L25
            r0 = r5
            boolean r0 = com.opos.cmn.an.c.a.a(r0)     // Catch: java.lang.Exception -> L1c
            if (r0 != 0) goto L25
            r0 = r4
            r1 = r5
            boolean r0 = com.opos.cmn.an.h.d.a.d(r0, r1)     // Catch: java.lang.Exception -> L1c
            if (r0 == 0) goto L25
            r0 = r4
            r1 = r5
            boolean r0 = com.opos.cmn.an.h.d.a.e(r0, r1)     // Catch: java.lang.Exception -> L1c
            r6 = r0
            goto L27
        L1c:
            r4 = move-exception
            java.lang.String r0 = "Utils"
            java.lang.String r1 = ""
            r2 = r4
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L25:
            r0 = 0
            r6 = r0
        L27:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            java.lang.String r1 = "launchAppHomePage pkgName="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            if (r0 == 0) goto L3e
            goto L41
        L3e:
            java.lang.String r0 = "null"
            r5 = r0
        L41:
            r0 = r4
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r1 = ",result="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "Utils"
            r1 = r4
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.a(r0, r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.a(android.content.Context, java.lang.String):boolean");
    }

    public static boolean a(AdItemData adItemData, a aVar) {
        int i;
        boolean z = true;
        if (adItemData == null || adItemData.i() == null || adItemData.i().size() <= 0 || ((i = AnonymousClass2.f12206a[aVar.ordinal()]) == 1 ? 2 != adItemData.i().get(0).K() || 2 != adItemData.i().get(0).L() : i == 2 ? 2 != adItemData.i().get(0).e() || 2 != adItemData.i().get(0).L() : i == 3 ? 2 != adItemData.i().get(0).J() || 2 != adItemData.i().get(0).L() : i == 4 ? 2 != adItemData.i().get(0).V() || 2 != adItemData.i().get(0).L() : i != 5 || 2 != adItemData.i().get(0).W() || 2 != adItemData.i().get(0).L())) {
            z = false;
        }
        com.opos.cmn.an.f.a.b("Utils", "isDownloaderTypeAd=" + z);
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0033, code lost:
        if (2 == r4.L()) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.opos.mobad.model.data.MaterialData r4) {
        /*
            r0 = r4
            if (r0 == 0) goto L44
            r0 = 3
            r1 = r4
            int r1 = r1.J()     // Catch: java.lang.Exception -> L3b
            if (r0 != r1) goto L14
            r0 = 2
            r1 = r4
            int r1 = r1.L()     // Catch: java.lang.Exception -> L3b
            if (r0 == r1) goto L36
        L14:
            r0 = 3
            r1 = r4
            int r1 = r1.K()     // Catch: java.lang.Exception -> L3b
            if (r0 != r1) goto L24
            r0 = 2
            r1 = r4
            int r1 = r1.L()     // Catch: java.lang.Exception -> L3b
            if (r0 == r1) goto L36
        L24:
            r0 = 3
            r1 = r4
            int r1 = r1.e()     // Catch: java.lang.Exception -> L3b
            if (r0 != r1) goto L44
            r0 = r4
            int r0 = r0.L()     // Catch: java.lang.Exception -> L3b
            r5 = r0
            r0 = 2
            r1 = r5
            if (r0 != r1) goto L44
        L36:
            r0 = 1
            r6 = r0
            goto L46
        L3b:
            r4 = move-exception
            java.lang.String r0 = "Utils"
            java.lang.String r1 = ""
            r2 = r4
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L44:
            r0 = 0
            r6 = r0
        L46:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            java.lang.String r1 = "isMiddleDownloader result:"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "Utils"
            r1 = r4
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.a(com.opos.mobad.model.data.MaterialData):boolean");
    }

    private static int[] a(Context context, int i) {
        int[] iArr = {0, 0};
        if (i == 1) {
            iArr[0] = 1080;
            iArr[1] = 171;
            return iArr;
        } else if (i == 2) {
            iArr[0] = 720;
            iArr[1] = 600;
            return iArr;
        } else {
            if (i != 3) {
                if (i == 5) {
                    iArr[0] = com.opos.cmn.an.h.f.a.b(context);
                    iArr[1] = com.opos.cmn.an.h.f.a.c(context);
                    return iArr;
                } else if (i != 6) {
                    return iArr;
                }
            }
            iArr[0] = 1080;
            iArr[1] = c(context);
            return iArr;
        }
    }

    public static int b(String str) {
        try {
            if (com.opos.cmn.an.c.a.a(str)) {
                return 0;
            }
            return a(new File(str));
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            return 0;
        }
    }

    public static a.b b(Activity activity) {
        return a(activity, (View) null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static String b(Context context, String str, int[] iArr, long j) {
        String str2;
        boolean z;
        String str3;
        StringBuilder sb;
        StringBuilder sb2;
        String str4 = null;
        if (context != null) {
            str4 = null;
            str2 = null;
            try {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    switch (str.hashCode()) {
                        case -1001078227:
                            if (str.equals("progress")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 99:
                            if (str.equals("c")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 104:
                            if (str.equals("h")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 109:
                            if (str.equals("m")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 119:
                            if (str.equals(IAdInterListener.AdReqParam.WIDTH)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 3125:
                            if (str.equals("av")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 3138:
                            if (str.equals(com.anythink.expressad.foundation.g.a.L)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 3166:
                            if (str.equals(com.igexin.push.core.b.Y)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 3185:
                            if (str.equals(com.anythink.expressad.d.a.b.dx)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 3220:
                            if (str.equals("dx")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 3221:
                            if (str.equals("dy")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 3526:
                            if (str.equals("nt")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 3556:
                            if (str.equals(bh.x)) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        case 3559:
                            if (str.equals(com.anythink.expressad.foundation.g.a.F)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 3636:
                            if (str.equals(RedirectReqWrapper.KEY_REFER)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 3724:
                            if (str.equals("ua")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 3747:
                            if (str.equals("ux")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 3748:
                            if (str.equals("uy")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 106905:
                            if (str.equals("lan")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 111052:
                            if (str.equals("pkg")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        default:
                            z = true;
                            break;
                    }
                    switch (z) {
                        case false:
                            str3 = "android";
                            str4 = str3;
                            break;
                        case true:
                            str3 = com.opos.cmn.an.b.c.c();
                            str4 = str3;
                            break;
                        case true:
                            str3 = com.opos.cmn.an.b.c.a();
                            str4 = str3;
                            break;
                        case true:
                            str3 = com.opos.cmn.an.b.b.a();
                            str4 = str3;
                            break;
                        case true:
                            str3 = com.opos.cmn.an.b.b.b();
                            str4 = str3;
                            break;
                        case true:
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(com.opos.cmn.an.h.f.a.b(context));
                            sb3.append("");
                            sb = sb3;
                            str3 = sb.toString();
                            str4 = str3;
                            break;
                        case true:
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(com.opos.cmn.an.h.f.a.c(context));
                            sb4.append("");
                            sb = sb4;
                            str3 = sb.toString();
                            str4 = str3;
                            break;
                        case true:
                            str3 = context.getPackageName();
                            str4 = str3;
                            break;
                        case true:
                            str3 = com.opos.cmn.an.h.d.a.c(context, context.getPackageName());
                            str4 = str3;
                            break;
                        case true:
                            str3 = com.opos.cmn.an.h.c.a.h(context);
                            str4 = str3;
                            break;
                        case true:
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(a(context));
                            sb5.append("");
                            sb = sb5;
                            str3 = sb.toString();
                            str4 = str3;
                            break;
                        case true:
                            str3 = i();
                            str4 = str3;
                            break;
                        case true:
                        case true:
                            str4 = "";
                            break;
                        case true:
                            sb2 = new StringBuilder();
                            sb2.append(j);
                            sb2.append("");
                            str3 = sb2.toString();
                            str4 = str3;
                            break;
                        case true:
                            if (iArr != null && iArr.length == 4) {
                                sb2 = new StringBuilder();
                                sb2.append(iArr[0]);
                                sb2.append("");
                                str3 = sb2.toString();
                                str4 = str3;
                                break;
                            }
                            str4 = "-999";
                            break;
                        case true:
                            if (iArr != null && iArr.length == 4) {
                                sb2 = new StringBuilder();
                                sb2.append(iArr[1]);
                                sb2.append("");
                                str3 = sb2.toString();
                                str4 = str3;
                                break;
                            }
                            str4 = "-999";
                            break;
                        case true:
                            if (iArr != null && iArr.length == 4) {
                                sb2 = new StringBuilder();
                                sb2.append(iArr[2]);
                                sb2.append("");
                                str3 = sb2.toString();
                                str4 = str3;
                                break;
                            }
                            str4 = "-999";
                            break;
                        case true:
                            if (iArr != null && iArr.length == 4) {
                                sb2 = new StringBuilder();
                                sb2.append(iArr[3]);
                                sb2.append("");
                                str3 = sb2.toString();
                                str4 = str3;
                                break;
                            }
                            str4 = "-999";
                            break;
                        case true:
                            str3 = com.opos.cmn.an.b.a.a(context);
                            str4 = str3;
                            break;
                        default:
                            str4 = null;
                            break;
                    }
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
                str4 = str2;
            }
        }
        StringBuilder sb6 = new StringBuilder();
        String str5 = str4;
        sb6.append("key=");
        String str6 = com.igexin.push.core.b.l;
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb6.append(str);
        String str7 = str4;
        sb6.append(",value=");
        if (str4 != null) {
            str6 = str4;
        }
        sb6.append(str6);
        str2 = str4;
        com.opos.cmn.an.f.a.b("Utils", sb6.toString());
        return str4 != null ? str4 : "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.Long> b(android.content.Context r4) {
        /*
            r0 = r4
            if (r0 == 0) goto L18
            r0 = r4
            com.opos.cmn.an.d.d.a r0 = h(r0)     // Catch: java.lang.Exception -> Lf
            java.util.Map r0 = r0.a()     // Catch: java.lang.Exception -> Lf
            r4 = r0
            goto L1a
        Lf:
            r4 = move-exception
            java.lang.String r0 = "Utils"
            java.lang.String r1 = ""
            r2 = r4
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L18:
            r0 = 0
            r4 = r0
        L1a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            java.lang.String r1 = "getAllRewardTime size="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            if (r0 == 0) goto L3b
            r0 = r4
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r5 = r0
            goto L3e
        L3b:
            java.lang.String r0 = "null"
            r5 = r0
        L3e:
            r0 = r6
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "Utils"
            r1 = r6
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.b(android.content.Context):java.util.Map");
    }

    public static void b() {
        b.b = true;
        com.opos.cmn.an.f.a.b("Utils", "setSdkInitSuccess");
    }

    public static boolean b(Context context, Class cls) {
        ActivityInfo a2 = a(context, cls);
        if (a2 == null) {
            return false;
        }
        com.opos.cmn.an.f.a.b("Utils", "is standard launch mode" + a2.launchMode);
        return a2.launchMode == 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r5, java.lang.String r6) {
        /*
            r0 = r5
            if (r0 == 0) goto L4b
            r0 = r6
            boolean r0 = com.opos.cmn.an.c.a.a(r0)
            if (r0 != 0) goto L4b
            android.content.Intent r0 = new android.content.Intent     // Catch: java.lang.Exception -> L42
            r1 = r0
            java.lang.String r2 = "android.intent.action.VIEW"
            r3 = r6
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.lang.Exception -> L42
            r1.<init>(r2, r3)     // Catch: java.lang.Exception -> L42
            r8 = r0
            r0 = r8
            java.lang.String r1 = "android.intent.category.BROWSABLE"
            android.content.Intent r0 = r0.addCategory(r1)     // Catch: java.lang.Exception -> L42
            r0 = r8
            r1 = 0
            android.content.Intent r0 = r0.setComponent(r1)     // Catch: java.lang.Exception -> L42
            r0 = r8
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            android.content.Intent r0 = r0.addFlags(r1)     // Catch: java.lang.Exception -> L42
            r0 = r5
            r1 = r8
            boolean r0 = com.opos.cmn.an.h.d.a.a(r0, r1)     // Catch: java.lang.Exception -> L42
            if (r0 == 0) goto L4b
            r0 = r5
            r1 = r8
            r0.startActivity(r1)     // Catch: java.lang.Exception -> L42
            r0 = 1
            r7 = r0
            goto L4d
        L42:
            r5 = move-exception
            java.lang.String r0 = "Utils"
            java.lang.String r1 = ""
            r2 = r5
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L4b:
            r0 = 0
            r7 = r0
        L4d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r5 = r0
            r0 = r5
            java.lang.String r1 = "launchAppDetailPage url="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r6
            if (r0 == 0) goto L64
            goto L67
        L64:
            java.lang.String r0 = "null"
            r6 = r0
        L67:
            r0 = r5
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            java.lang.String r1 = "result="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r5
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "Utils"
            r1 = r5
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.a(r0, r1)
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.b(android.content.Context, java.lang.String):boolean");
    }

    private static int c(Context context) {
        com.opos.cmn.an.h.f.a.l(context);
        if (f(context) || e(context)) {
            return 1872;
        }
        return g(context) ? 1752 : 1512;
    }

    public static final int c(String str) {
        int i;
        try {
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        if (!com.opos.cmn.an.c.a.a(str)) {
            i = str.lastIndexOf(e);
            com.opos.cmn.an.f.a.b("Utils", "getJsSignParamIndex=" + i);
            return i;
        }
        i = -1;
        com.opos.cmn.an.f.a.b("Utils", "getJsSignParamIndex=" + i);
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.opos.cmn.e.a.b.a c(Context context, View view) {
        Activity a2 = context instanceof Activity ? (Activity) context : view != null ? a(view.getRootView().findViewById(R.id.content)) : null;
        if (a2 == null) {
            return null;
        }
        return new com.opos.cmn.e.a.b.a(a2);
    }

    private static String c(Activity activity) {
        String str;
        try {
            str = activity.getClass().getName();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getActivityClassName=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a8, code lost:
        if ((-1) == r0) goto L82;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(android.content.Context r5, java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.c(android.content.Context, java.lang.String):java.lang.String");
    }

    public static boolean c() {
        return b.b;
    }

    public static long d(Context context, String str) {
        long j = 0;
        if (context != null) {
            j = 0;
            try {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    j = h(context).a(str, 0L);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
                j = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getRewardTime pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(",timestamp=");
        sb.append(j);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        return j;
    }

    private static String d(Context context) {
        String str;
        try {
            str = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getCurrentActivityName=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        return str;
    }

    private static final String d(String str) {
        String str2;
        try {
            int c2 = c(str);
            str2 = str;
            if (-1 != c2) {
                str2 = str.substring(0, c2 - 1);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            str2 = str;
        }
        com.opos.cmn.an.f.a.b("Utils", "result=" + str2);
        return str2;
    }

    public static boolean d() {
        return com.opos.cmn.an.b.c.b() >= 19;
    }

    public static void e(Context context, String str) {
        if (context != null) {
            try {
                if (com.opos.cmn.an.c.a.a(str)) {
                    return;
                }
                h(context).a(str);
                com.opos.cmn.an.f.a.b("Utils", "removeRewardTime pkgName=" + str);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
        }
    }

    public static boolean e() {
        String str;
        if (!d()) {
            str = "sdk not support android sdk version <19";
        } else if (c()) {
            return true;
        } else {
            str = "init sdk failed!do nothing.";
        }
        com.opos.cmn.an.f.a.d("Utils", str);
        return false;
    }

    private static boolean e(Context context) {
        boolean z = 2.1666667f <= com.opos.cmn.an.h.f.a.l(context);
        com.opos.cmn.an.f.a.b("Utils", "isCurvedScreenAspectRatio=" + z);
        return z;
    }

    public static int f() {
        return 253;
    }

    private static boolean f(Context context) {
        boolean z = 2.1111112f == com.opos.cmn.an.h.f.a.l(context);
        com.opos.cmn.an.f.a.b("Utils", "isShapedScreenAspectRatio=" + z);
        return z;
    }

    public static boolean f(Context context, String str) {
        boolean z = false;
        if (context != null) {
            z = false;
            if (!TextUtils.isEmpty(str)) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    String a2 = com.opos.cmn.biz.a.c.a(context);
                    com.opos.cmn.an.f.a.b("Utils", "getMarketName=" + a2);
                    if (!g(context, a2)) {
                        com.opos.cmn.an.f.a.a("Utils", " unsupport Market");
                        return false;
                    }
                    intent.setPackage(a2);
                    if (context instanceof Activity) {
                        ((Activity) context).startActivity(intent);
                    } else {
                        intent.addFlags(268435456);
                        context.startActivity(intent);
                    }
                    z = true;
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
                    z = false;
                }
            }
        }
        com.opos.cmn.an.f.a.a("Utils", "executeDeeplinkDownloadApp result = " + z);
        return z;
    }

    public static String g() {
        return "opos_mobad_v481004_2022_09_22_release";
    }

    private static boolean g(Context context) {
        float l = com.opos.cmn.an.h.f.a.l(context);
        boolean z = 2.0f == l || 2.0370371f == l;
        com.opos.cmn.an.f.a.b("Utils", "isFullScreenAspectRatio=" + z);
        return z;
    }

    private static boolean g(Context context, String str) {
        boolean z;
        if (context != null) {
            try {
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
            }
            if (com.opos.cmn.an.h.d.a.d(context, str)) {
                if (h(context, str)) {
                    z = true;
                    com.opos.cmn.an.f.a.b("Utils", "supportMarket=" + z);
                    return z;
                }
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("Utils", "supportMarket=" + z);
        return z;
    }

    public static int h() {
        return 481004;
    }

    private static com.opos.cmn.an.d.d.a h(Context context) {
        com.opos.cmn.an.d.d.a aVar;
        com.opos.cmn.an.d.d.a aVar2 = f12200a;
        if (aVar2 == null) {
            synchronized (b) {
                com.opos.cmn.an.d.d.a aVar3 = f12200a;
                aVar = aVar3;
                if (aVar3 == null) {
                    aVar = new com.opos.cmn.an.d.d.a(context, "mobad.reward.prefs", 0);
                    f12200a = aVar;
                }
            }
            return aVar;
        }
        return aVar2;
    }

    private static boolean h(Context context, String str) {
        boolean z;
        try {
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        if (com.opos.cmn.an.h.d.a.h(context, str) != null) {
            if (com.opos.cmn.an.h.d.a.h(context, str).enabled) {
                z = true;
                com.opos.cmn.an.f.a.b("Utils", "isPkgEnabled=" + z);
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("Utils", "isPkgEnabled=" + z);
        return z;
    }

    public static String i() {
        String str = "";
        try {
            str = System.getProperty("http.agent");
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getUserAgent=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("Utils", sb.toString());
        return str;
    }

    public static boolean j() {
        com.opos.cmn.an.f.a.b("Utils", "sWifiRemindAtCellular before=" + b.e);
        boolean z = false;
        try {
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("Utils", "", (Throwable) e2);
        }
        if (b.e) {
            if (!com.opos.mobad.service.f.b().f()) {
                b.e = false;
            }
            z = true;
        }
        com.opos.cmn.an.f.a.b("Utils", "sWifiRemindAtCellular=" + z);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0517b k() {
        /*
            java.lang.ref.WeakReference<com.opos.mobad.cmn.service.pkginstall.b$b> r0 = com.opos.mobad.cmn.a.b.f.d     // Catch: java.lang.Exception -> L1c
            if (r0 == 0) goto L25
            java.lang.ref.WeakReference<com.opos.mobad.cmn.service.pkginstall.b$b> r0 = com.opos.mobad.cmn.a.b.f.d     // Catch: java.lang.Exception -> L1c
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Exception -> L1c
            if (r0 == 0) goto L25
            java.lang.ref.WeakReference<com.opos.mobad.cmn.service.pkginstall.b$b> r0 = com.opos.mobad.cmn.a.b.f.d     // Catch: java.lang.Exception -> L1c
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Exception -> L1c
            com.opos.mobad.cmn.service.pkginstall.b$b r0 = (com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0517b) r0     // Catch: java.lang.Exception -> L1c
            r4 = r0
            goto L27
        L1c:
            r4 = move-exception
            java.lang.String r0 = "Utils"
            java.lang.String r1 = ""
            r2 = r4
            com.opos.cmn.an.f.a.a(r0, r1, r2)
        L25:
            r0 = 0
            r4 = r0
        L27:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            java.lang.String r1 = "getCacheInterBaseAd="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            if (r0 == 0) goto L40
            r0 = r4
            r5 = r0
            goto L43
        L40:
            java.lang.String r0 = "null"
            r5 = r0
        L43:
            r0 = r6
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "Utils"
            r1 = r6
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.cmn.a.b.f.k():com.opos.mobad.cmn.service.pkginstall.b$b");
    }

    public static boolean l() {
        return Build.VERSION.SDK_INT <= 29;
    }
}
