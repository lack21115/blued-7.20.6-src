package com.tencent.tmsqmsp.oaid2;

import android.content.Context;
import android.os.Build;
import com.android.internal.util.cm.QSConstants;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/VendorManager.class */
public class VendorManager implements IVendorCallback {
    public b vendorInfo = null;
    public IVendorCallback userCallback = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/VendorManager$a.class */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39614a;

        static {
            d.values();
            int[] iArr = new int[17];
            f39614a = iArr;
            try {
                d dVar = d.XIAOMI;
                iArr[2] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f39614a;
                d dVar2 = d.BLACKSHARK;
                iArr2[14] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = f39614a;
                d dVar3 = d.VIVO;
                iArr3[3] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                int[] iArr4 = f39614a;
                d dVar4 = d.HUA_WEI;
                iArr4[1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                int[] iArr5 = f39614a;
                d dVar5 = d.OPPO;
                iArr5[4] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                int[] iArr6 = f39614a;
                d dVar6 = d.ONEPLUS;
                iArr6[13] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                int[] iArr7 = f39614a;
                d dVar7 = d.MOTO;
                iArr7[5] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                int[] iArr8 = f39614a;
                d dVar8 = d.LENOVO;
                iArr8[6] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                int[] iArr9 = f39614a;
                d dVar9 = d.ASUS;
                iArr9[7] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                int[] iArr10 = f39614a;
                d dVar10 = d.SAMSUNG;
                iArr10[8] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                int[] iArr11 = f39614a;
                d dVar11 = d.MEIZU;
                iArr11[9] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                int[] iArr12 = f39614a;
                d dVar12 = d.ALPS;
                iArr12[10] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                int[] iArr13 = f39614a;
                d dVar13 = d.NUBIA;
                iArr13[11] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                int[] iArr14 = f39614a;
                d dVar14 = d.ZTE;
                iArr14[12] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                int[] iArr15 = f39614a;
                d dVar15 = d.FREEMEOS;
                iArr15[15] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                int[] iArr16 = f39614a;
                d dVar16 = d.SSUIOS;
                iArr16[16] = 16;
            } catch (NoSuchFieldError e16) {
            }
        }
    }

    public int getVendorInfo(Context context, IVendorCallback iVendorCallback) {
        this.userCallback = iVendorCallback;
        d a2 = d.a(Build.MANUFACTURER);
        if (a2 == d.UNSUPPORT) {
            onResult(false, com.igexin.push.core.b.l, com.igexin.push.core.b.l);
            return com.tencent.tmsqmsp.oaid2.a.f39615a;
        }
        switch (a.f39614a[a2.ordinal()]) {
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
            return com.tencent.tmsqmsp.oaid2.a.b;
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
                    return com.tencent.tmsqmsp.oaid2.a.f39616c;
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
            return com.tencent.tmsqmsp.oaid2.a.f39616c;
        }
    }

    @Override // com.tencent.tmsqmsp.oaid2.IVendorCallback
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
