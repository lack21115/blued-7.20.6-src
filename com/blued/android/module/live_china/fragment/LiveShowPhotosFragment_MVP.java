package com.blued.android.module.live_china.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveShowPhotosFragment_MVP.class */
public final class LiveShowPhotosFragment_MVP implements MvpDispatcher {
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0056, code lost:
        if (r5.equals("album_data_list") != false) goto L16;
     */
    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.framework.ui.mvp.MvpFragment r4, java.lang.String r5, java.util.List r6) {
        /*
            r3 = this;
            r0 = r4
            com.blued.android.module.live_china.fragment.LiveShowPhotosFragment r0 = (com.blued.android.module.live_china.fragment.LiveShowPhotosFragment) r0
            r4 = r0
            r0 = r6
            if (r0 == 0) goto Laf
            r0 = r6
            int r0 = r0.size()
            if (r0 <= 0) goto Laf
            r0 = 0
            r7 = r0
            r0 = r6
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            r9 = r0
            r0 = r9
            if (r0 == 0) goto Laf
            r0 = r5
            int r0 = r0.hashCode()
            r8 = r0
            r0 = r8
            r1 = -602888526(0xffffffffdc10a6b2, float:-1.6286272E17)
            if (r0 == r1) goto L5c
            r0 = r8
            r1 = 520236611(0x1f022e43, float:2.7566838E-20)
            if (r0 == r1) goto L50
            r0 = r8
            r1 = 833420977(0x31acfeb1, float:5.034814E-9)
            if (r0 == r1) goto L41
            goto L6b
        L41:
            r0 = r5
            java.lang.String r1 = "changed_folder_name"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6b
            r0 = 2
            r7 = r0
            goto L6e
        L50:
            r0 = r5
            java.lang.String r1 = "album_data_list"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6b
            goto L6e
        L5c:
            r0 = r5
            java.lang.String r1 = "feed_data_list"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6b
            r0 = 1
            r7 = r0
            goto L6e
        L6b:
            r0 = -1
            r7 = r0
        L6e:
            r0 = r7
            if (r0 == 0) goto La0
            r0 = r7
            r1 = 1
            if (r0 == r1) goto L90
            r0 = r7
            r1 = 2
            if (r0 == r1) goto L80
            return
        L80:
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r1 = r9
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Laf
            r0 = r4
            r1 = r6
            r0.c(r1)
            return
        L90:
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r1 = r9
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Laf
            r0 = r4
            r1 = r6
            r0.b(r1)
            return
        La0:
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r1 = r9
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Laf
            r0 = r4
            r1 = r6
            r0.a(r1)
        Laf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveShowPhotosFragment_MVP.a(com.blued.android.framework.ui.mvp.MvpFragment, java.lang.String, java.util.List):void");
    }
}
