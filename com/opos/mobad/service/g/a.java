package com.opos.mobad.service.g;

import android.content.Context;
import com.opos.cmn.biz.monitor.MonitorEvent;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/g/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private EnumC0736a f27365a;
    private b b;

    /* renamed from: c  reason: collision with root package name */
    private String f27366c;
    private List<String> d;
    private int[] e;
    private long f = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.service.g.a$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/g/a$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27367a;
        static final /* synthetic */ int[] b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00b1 -> B:66:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00b5 -> B:78:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00b9 -> B:74:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00bd -> B:86:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00c1 -> B:82:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00c5 -> B:62:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00c9 -> B:60:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00cd -> B:18:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00d1 -> B:64:0x0078). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00d5 -> B:76:0x0083). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x00d9 -> B:72:0x008e). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x00dd -> B:84:0x0099). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x00e1 -> B:80:0x00a4). Please submit an issue!!! */
        static {
            int[] iArr = new int[b.values().length];
            b = iArr;
            try {
                iArr[b.MARKET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[b.WEB_VIEW.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[b.BROWSER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[b.INSTANT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                b[b.APP_HOME.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                b[b.DEEP_LINK.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                b[b.DOWNLOADER.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                b[b.MINI_PROGRAM.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            int[] iArr2 = new int[EnumC0736a.values().length];
            f27367a = iArr2;
            try {
                iArr2[EnumC0736a.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f27367a[EnumC0736a.EXTRA.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f27367a[EnumC0736a.FLOATLAYER_EXTRA.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f27367a[EnumC0736a.BUTTON.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f27367a[EnumC0736a.FLOATLAYER_BUTTON.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f27367a[EnumC0736a.PENDANT.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    /* renamed from: com.opos.mobad.service.g.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/g/a$a.class */
    public enum EnumC0736a {
        BUTTON,
        EXTRA,
        VIDEO,
        FLOATLAYER_BUTTON,
        FLOATLAYER_EXTRA,
        PENDANT
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/g/a$b.class */
    public enum b {
        APP_HOME,
        DEEP_LINK,
        WEB_VIEW,
        BROWSER,
        INSTANT,
        MARKET,
        DOWNLOADER,
        MINI_PROGRAM
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MonitorEvent a() {
        MonitorEvent.d dVar;
        MonitorEvent.c cVar;
        MonitorEvent.b bVar = new MonitorEvent.b();
        if (this.f27365a != null) {
            switch (AnonymousClass1.f27367a[this.f27365a.ordinal()]) {
                case 1:
                case 2:
                case 3:
                    bVar.a(MonitorEvent.a.EXTRA);
                    cVar = MonitorEvent.c.OTHER;
                    bVar.a(cVar);
                    break;
                case 4:
                case 5:
                case 6:
                    bVar.a(MonitorEvent.a.BTN);
                    cVar = MonitorEvent.c.CLICK_BUTTON;
                    bVar.a(cVar);
                    break;
            }
        }
        if (this.b != null) {
            switch (AnonymousClass1.b[this.b.ordinal()]) {
                case 1:
                    dVar = MonitorEvent.d.APP_SHOP;
                    bVar.a(dVar);
                    break;
                case 2:
                case 3:
                    dVar = MonitorEvent.d.WEB_URL;
                    bVar.a(dVar);
                    break;
                case 4:
                    dVar = MonitorEvent.d.QA;
                    bVar.a(dVar);
                    break;
                case 5:
                    dVar = MonitorEvent.d.APP_HOME;
                    bVar.a(dVar);
                    break;
                case 6:
                    dVar = MonitorEvent.d.DEEP_LINK;
                    bVar.a(dVar);
                    break;
                case 7:
                    dVar = MonitorEvent.d.DOWNLOADER;
                    bVar.a(dVar);
                    break;
                case 8:
                    dVar = MonitorEvent.d.MINI_PROGRAM;
                    bVar.a(dVar);
                    break;
            }
        }
        String str = this.f27366c;
        if (str != null) {
            bVar.a(str);
        }
        int[] iArr = this.e;
        if (iArr != null && iArr.length > 0) {
            bVar.a(iArr[0], iArr[1], iArr[2], iArr[3]);
        }
        long j = this.f;
        if (j >= 0) {
            bVar.a((int) j);
        }
        return bVar.a();
    }

    public a a(long j) {
        this.f = j;
        return this;
    }

    public a a(EnumC0736a enumC0736a) {
        this.f27365a = enumC0736a;
        return this;
    }

    public a a(b bVar) {
        this.b = bVar;
        return this;
    }

    public a a(String str) {
        this.f27366c = str;
        return this;
    }

    public a a(List<String> list) {
        this.d = list;
        return this;
    }

    public a a(int[] iArr) {
        this.e = iArr;
        return this;
    }

    public void a(Context context) {
        List<String> list = this.d;
        if (list == null || list.size() <= 0) {
            com.opos.cmn.an.f.a.a("", "report with url null or length 0");
            return;
        }
        com.opos.mobad.service.g.b.a(context, this.d, a());
    }
}
