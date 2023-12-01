package com.opos.mobad.q.a.e;

import com.opos.mobad.model.data.AdItemData;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/e/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f27175a = true;

    public static void a(boolean z) {
        f27175a = z;
    }

    public static boolean a(AdItemData adItemData) {
        com.opos.cmn.an.f.a.b("WifiPlayUtils", "sPlayRemindAtCellular=" + f27175a);
        boolean z = false;
        try {
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("WifiPlayUtils", "", (Throwable) e);
        }
        if (f27175a) {
            if (adItemData != null && !adItemData.t()) {
                f27175a = false;
            }
            z = true;
        }
        com.opos.cmn.an.f.a.b("WifiPlayUtils", "checkPlayConfirm=" + z);
        return z;
    }
}
