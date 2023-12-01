package com.opos.mobad.o.e;

import android.content.Context;
import com.opos.mobad.c.a;
import com.opos.mobad.d.d;
import com.opos.mobad.n.a;
import com.opos.mobad.n.a.m;
import com.opos.mobad.n.g.aj;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/o/e/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f27106a;
    private com.opos.mobad.n.b b;

    /* renamed from: c  reason: collision with root package name */
    private com.opos.mobad.c.a f27107c = new com.opos.mobad.c.a() { // from class: com.opos.mobad.o.e.b.1
        @Override // com.opos.mobad.c.a
        public void a(String str, String str2, int i, int i2, a.InterfaceC0676a interfaceC0676a) {
            d.a().a(str, str2, i, i2, interfaceC0676a);
        }
    };

    private b() {
    }

    private static aj a(Context context) {
        int b = com.opos.cmn.an.h.f.a.b(context);
        return new aj(b, (int) (b * 0.6d));
    }

    public static final b a() {
        b bVar;
        b bVar2 = f27106a;
        if (bVar2 != null) {
            return bVar2;
        }
        synchronized (b.class) {
            try {
                b bVar3 = f27106a;
                bVar = bVar3;
                if (bVar3 == null) {
                    bVar = new b();
                    f27106a = bVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public static final boolean a(int i) {
        if (i == 5 || i == 48 || i == 7 || i == 8 || i == 9) {
            return true;
        }
        switch (i) {
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            default:
                switch (i) {
                    case 50:
                    case 51:
                    case 52:
                        return true;
                    default:
                        return false;
                }
        }
    }

    private static final m b(int i) {
        switch (i) {
            case 54:
            case 57:
            case 60:
            case 63:
            case 66:
            case 69:
            case 72:
            case 75:
                return m.SPLASH;
            case 55:
            case 58:
            case 61:
            case 64:
            case 67:
            case 70:
            case 73:
            case 76:
                return m.BREATH;
            case 56:
            case 59:
            case 62:
            case 65:
            case 68:
            case 71:
            case 74:
            case 77:
                return m.SHAKE;
            default:
                return m.NONE;
        }
    }

    private int c(int i) {
        int i2 = 3;
        if (i != 2) {
            if (i != 3) {
                return 1;
            }
            i2 = 2;
        }
        return i2;
    }

    public final com.opos.mobad.n.a a(Context context, int i, int i2, a.InterfaceC0708a interfaceC0708a) {
        return a(context, i, i2, interfaceC0708a, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0723  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0735  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x05a7  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x05bc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x05f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.opos.mobad.n.a a(android.content.Context r7, int r8, int r9, com.opos.mobad.n.a.InterfaceC0708a r10, int r11) {
        /*
            Method dump skipped, instructions count: 1847
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.o.e.b.a(android.content.Context, int, int, com.opos.mobad.n.a$a, int):com.opos.mobad.n.a");
    }

    public void a(com.opos.mobad.n.b bVar) {
        this.b = bVar;
    }

    public final com.opos.mobad.n.a b(Context context, int i, int i2, a.InterfaceC0708a interfaceC0708a) {
        return a(context, i, i2, interfaceC0708a, 1);
    }
}
