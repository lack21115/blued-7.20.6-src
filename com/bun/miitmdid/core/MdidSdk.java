package com.bun.miitmdid.core;

import android.content.Context;
import com.bun.miitmdid.a.b;
import com.bun.supplier.IIdentifierListener;
import com.bun.supplier.IdSupplier;
import com.bun.supplier.SupplierListener;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/core/MdidSdk.class */
public class MdidSdk implements SupplierListener {
    private IIdentifierListener _InnerListener;
    private b _setting;

    /* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/core/MdidSdk$a.class */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21160a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00b9 -> B:79:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00bd -> B:91:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00c1 -> B:87:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00c5 -> B:69:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00c9 -> B:65:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00cd -> B:75:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00d1 -> B:71:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00d5 -> B:81:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00d9 -> B:77:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00dd -> B:89:0x007c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x00e1 -> B:85:0x0088). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x00e5 -> B:67:0x0094). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00e9 -> B:63:0x00a0). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x00ed -> B:73:0x00ac). Please submit an issue!!! */
        static {
            int[] iArr = new int[com.bun.miitmdid.c.a.values().length];
            f21160a = iArr;
            try {
                iArr[com.bun.miitmdid.c.a.XIAOMI.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21160a[com.bun.miitmdid.c.a.BLACKSHARK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21160a[com.bun.miitmdid.c.a.VIVO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f21160a[com.bun.miitmdid.c.a.HUA_WEI.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f21160a[com.bun.miitmdid.c.a.OPPO.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f21160a[com.bun.miitmdid.c.a.ONEPLUS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f21160a[com.bun.miitmdid.c.a.MOTO.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f21160a[com.bun.miitmdid.c.a.LENOVO.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f21160a[com.bun.miitmdid.c.a.ASUS.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f21160a[com.bun.miitmdid.c.a.SAMSUNG.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f21160a[com.bun.miitmdid.c.a.MEIZU.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f21160a[com.bun.miitmdid.c.a.NUBIA.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f21160a[com.bun.miitmdid.c.a.ZTE.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f21160a[com.bun.miitmdid.c.a.FREEMEOS.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f21160a[com.bun.miitmdid.c.a.SSUIOS.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
        }
    }

    public MdidSdk() {
        try {
            com.bun.lib.a.a(true);
        } catch (Exception e) {
            com.bun.lib.a.b("mdidsdk", "extractor exception!", e);
        }
    }

    public MdidSdk(boolean z) {
        try {
            com.bun.lib.a.a(z);
        } catch (Exception e) {
            com.bun.lib.a.b("mdidsdk", "extractor exception!", e);
        }
    }

    private native int _InnerFailed(int i, IdSupplier idSupplier);

    public native int InitSdk(Context context, IIdentifierListener iIdentifierListener);

    @Override // com.bun.supplier.SupplierListener
    public native void OnSupport(boolean z, IdSupplier idSupplier);

    public native void UnInitSdk();
}
