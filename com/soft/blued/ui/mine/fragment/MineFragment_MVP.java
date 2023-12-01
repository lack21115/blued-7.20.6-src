package com.soft.blued.ui.mine.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/fragment/MineFragment_MVP.class */
public final class MineFragment_MVP implements MvpDispatcher {
    private void a(MineFragment mineFragment, String str) {
        boolean z;
        int hashCode = str.hashCode();
        if (hashCode != 403484520) {
            if (hashCode == 1340885022 && str.equals("TAB_CLICK")) {
                z = false;
            }
            z = true;
        } else {
            if (str.equals("PRIVACY")) {
                z = true;
            }
            z = true;
        }
        if (!z) {
            mineFragment.b();
        } else if (!z) {
        } else {
            mineFragment.c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
        if (r6.equals("PRIVACY") == false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.framework.ui.mvp.MvpFragment r5, java.lang.String r6, java.util.List r7) {
        /*
            r4 = this;
            r0 = r5
            com.soft.blued.ui.mine.fragment.MineFragment r0 = (com.soft.blued.ui.mine.fragment.MineFragment) r0
            r5 = r0
            r0 = r7
            if (r0 == 0) goto L88
            r0 = r7
            int r0 = r0.size()
            if (r0 <= 0) goto L88
            r0 = 0
            r8 = r0
            r0 = r7
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L88
            r0 = r6
            int r0 = r0.hashCode()
            r9 = r0
            r0 = r9
            r1 = -2038483646(0xffffffff867f3542, float:-4.7999297E-35)
            if (r0 == r1) goto L44
            r0 = r9
            r1 = 403484520(0x180caf68, float:1.8183133E-24)
            if (r0 == r1) goto L38
            goto L53
        L38:
            r0 = r6
            java.lang.String r1 = "PRIVACY"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L53
            goto L56
        L44:
            r0 = r6
            java.lang.String r1 = "MY_PAGE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L53
            r0 = 1
            r8 = r0
            goto L56
        L53:
            r0 = -1
            r8 = r0
        L56:
            r0 = r8
            if (r0 == 0) goto L76
            r0 = r8
            r1 = 1
            if (r0 == r1) goto L64
            goto L88
        L64:
            java.lang.Class<com.soft.blued.ui.mine.model.MineEntryInfo> r0 = com.soft.blued.ui.mine.model.MineEntryInfo.class
            r1 = r7
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto L88
            r0 = r5
            r1 = r7
            com.soft.blued.ui.mine.model.MineEntryInfo r1 = (com.soft.blued.ui.mine.model.MineEntryInfo) r1
            r0.a(r1)
            return
        L76:
            java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
            r1 = r7
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto L88
            r0 = r5
            r1 = r7
            java.lang.Integer r1 = (java.lang.Integer) r1
            r0.a(r1)
            return
        L88:
            r0 = r4
            r1 = r5
            r2 = r6
            r0.a(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.mine.fragment.MineFragment_MVP.a(com.blued.android.framework.ui.mvp.MvpFragment, java.lang.String, java.util.List):void");
    }
}
