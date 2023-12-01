package com.opos.mobad.h;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/f.class */
public final class f {

    /* renamed from: com.opos.mobad.h.f$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/f$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12518a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0041 -> B:27:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0045 -> B:25:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0049 -> B:23:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004d -> B:29:0x0035). Please submit an issue!!! */
        static {
            int[] iArr = new int[com.opos.mobad.cmn.a.b.a.values().length];
            f12518a = iArr;
            try {
                iArr[com.opos.mobad.cmn.a.b.a.NonClickBt.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12518a[com.opos.mobad.cmn.a.b.a.ClickBt.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f12518a[com.opos.mobad.cmn.a.b.a.Video.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f12518a[com.opos.mobad.cmn.a.b.a.FloatLayerClickBt.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f12518a[com.opos.mobad.cmn.a.b.a.FloatLayerNonClickBt.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static Bitmap a(String str, int i, int i2) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return null;
        }
        try {
            return com.opos.cmn.an.d.c.a.a(str, i, i2);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("Utils", "", th);
            return null;
        }
    }

    public static boolean a(View view, View view2) {
        if (view == null || view2 == null) {
            return false;
        }
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null) {
            return false;
        }
        if (viewGroup.indexOfChild(view2) >= 0) {
            return true;
        }
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return false;
            }
            if (viewGroup.getChildAt(i2) != null && (viewGroup.getChildAt(i2) instanceof ViewGroup) && a(viewGroup.getChildAt(i2), view2)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
        if (r0.W() != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
        if (r0.V() != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
        if (r0.K() != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0075, code lost:
        if (r0.e() != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0082, code lost:
        if (r0.J() != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
        r6 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(com.opos.mobad.model.data.AdItemData r3, com.opos.mobad.cmn.a.b.a r4) {
        /*
            r0 = 0
            r7 = r0
            r0 = r7
            r6 = r0
            r0 = r3
            if (r0 == 0) goto L87
            r0 = r3
            java.util.List r0 = r0.i()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            com.opos.mobad.model.data.MaterialData r0 = (com.opos.mobad.model.data.MaterialData) r0
            r3 = r0
            r0 = r7
            r6 = r0
            r0 = r3
            if (r0 == 0) goto L87
            int[] r0 = com.opos.mobad.h.f.AnonymousClass1.f12518a
            r1 = r4
            int r1 = r1.ordinal()
            r0 = r0[r1]
            r5 = r0
            r0 = r5
            r1 = 1
            if (r0 == r1) goto L7b
            r0 = r5
            r1 = 2
            if (r0 == r1) goto L6e
            r0 = r5
            r1 = 3
            if (r0 == r1) goto L61
            r0 = r5
            r1 = 4
            if (r0 == r1) goto L54
            r0 = r5
            r1 = 5
            if (r0 == r1) goto L47
            r0 = r7
            r6 = r0
            goto L87
        L47:
            r0 = r7
            r6 = r0
            r0 = r3
            int r0 = r0.W()
            if (r0 == 0) goto L87
            goto L85
        L54:
            r0 = r7
            r6 = r0
            r0 = r3
            int r0 = r0.V()
            if (r0 == 0) goto L87
            goto L85
        L61:
            r0 = r7
            r6 = r0
            r0 = r3
            int r0 = r0.K()
            if (r0 == 0) goto L87
            goto L85
        L6e:
            r0 = r7
            r6 = r0
            r0 = r3
            int r0 = r0.e()
            if (r0 == 0) goto L87
            goto L85
        L7b:
            r0 = r7
            r6 = r0
            r0 = r3
            int r0 = r0.J()
            if (r0 == 0) goto L87
        L85:
            r0 = 1
            r6 = r0
        L87:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r3 = r0
            r0 = r3
            java.lang.String r1 = "isValidClickWithInteraction result ="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r3
            r1 = r6
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = "Utils"
            r1 = r3
            java.lang.String r1 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.h.f.a(com.opos.mobad.model.data.AdItemData, com.opos.mobad.cmn.a.b.a):boolean");
    }
}
