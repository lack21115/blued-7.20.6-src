package com.tencent.qmsp.oaid2;

import android.content.Context;
import android.os.Build;
import com.android.internal.util.cm.QSConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/VendorManager.class */
public class VendorManager implements IVendorCallback {
    public b vendorInfo = null;
    public IVendorCallback userCallback = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/VendorManager$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38455a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00c5 -> B:73:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00c9 -> B:69:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00cd -> B:81:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00d1 -> B:77:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00d5 -> B:89:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00d9 -> B:85:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00dd -> B:97:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00e1 -> B:91:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00e5 -> B:71:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00e9 -> B:67:0x007c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00ed -> B:79:0x0088). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00f1 -> B:75:0x0094). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00f5 -> B:87:0x00a0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x00f9 -> B:83:0x00ac). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x00fd -> B:95:0x00b8). Please submit an issue!!! */
        static {
            int[] iArr = new int[d.values().length];
            f38455a = iArr;
            try {
                iArr[d.XIAOMI.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f38455a[d.BLACKSHARK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f38455a[d.VIVO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f38455a[d.HUA_WEI.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f38455a[d.OPPO.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f38455a[d.ONEPLUS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f38455a[d.MOTO.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f38455a[d.LENOVO.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f38455a[d.ASUS.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f38455a[d.SAMSUNG.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f38455a[d.MEIZU.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f38455a[d.ALPS.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f38455a[d.NUBIA.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f38455a[d.ZTE.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f38455a[d.FREEMEOS.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f38455a[d.SSUIOS.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    public int getVendorInfo(Context context, IVendorCallback iVendorCallback) {
        this.userCallback = iVendorCallback;
        d a2 = d.a(Build.MANUFACTURER);
        if (a2 == d.UNSUPPORT) {
            onResult(false, com.igexin.push.core.b.l, com.igexin.push.core.b.l);
            return com.tencent.qmsp.oaid2.a.f38456a;
        }
        switch (a.f38455a[a2.ordinal()]) {
            case 1:
            case 2:
                this.vendorInfo = new n0();
                break;
            case 3:
                this.vendorInfo = new m0();
                break;
            case 4:
                this.vendorInfo = new l();
                break;
            case 5:
            case 6:
                this.vendorInfo = new f0();
                break;
            case 7:
            case 8:
                this.vendorInfo = new o();
                break;
            case 9:
                this.vendorInfo = new h();
                break;
            case 10:
                this.vendorInfo = new k0();
                break;
            case 11:
            case 12:
                this.vendorInfo = new a0();
                break;
            case 13:
                this.vendorInfo = new b0();
                break;
            case 14:
            case 15:
            case 16:
                this.vendorInfo = new u();
                break;
        }
        if (this.vendorInfo == null) {
            onResult(false, com.igexin.push.core.b.l, com.igexin.push.core.b.l);
            return com.tencent.qmsp.oaid2.a.b;
        }
        c.b("init");
        try {
            this.vendorInfo.a(context, this);
            if (!this.vendorInfo.k()) {
                try {
                    this.vendorInfo.j();
                    return 0;
                } catch (Exception e) {
                    onResult(false, com.igexin.push.core.b.l, com.igexin.push.core.b.l);
                    return com.tencent.qmsp.oaid2.a.f38457c;
                }
            }
            c.b(QSConstants.TILE_SYNC);
            try {
                onResult(this.vendorInfo.e(), this.vendorInfo.d(), this.vendorInfo.a());
                return 0;
            } catch (Exception e2) {
                onResult(false, com.igexin.push.core.b.l, com.igexin.push.core.b.l);
                return 0;
            }
        } catch (Exception e3) {
            onResult(false, com.igexin.push.core.b.l, com.igexin.push.core.b.l);
            return com.tencent.qmsp.oaid2.a.f38457c;
        }
    }

    @Override // com.tencent.qmsp.oaid2.IVendorCallback
    public void onResult(boolean z, String str, String str2) {
        c.c("vm onResult " + z);
        IVendorCallback iVendorCallback = this.userCallback;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(z, str, str2);
        }
        b bVar = this.vendorInfo;
        if (bVar != null) {
            bVar.l();
        }
    }
}
