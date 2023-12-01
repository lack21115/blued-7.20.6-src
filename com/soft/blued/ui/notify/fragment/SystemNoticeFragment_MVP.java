package com.soft.blued.ui.notify.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/notify/fragment/SystemNoticeFragment_MVP.class */
public final class SystemNoticeFragment_MVP implements MvpDispatcher {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(SystemNoticeFragment systemNoticeFragment, String str) {
        boolean z;
        switch (str.hashCode()) {
            case 176778244:
                if (str.equals("VIEW_POINT_CLEAR")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 632941979:
                if (str.equals("CLEAR_NOTIFY")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 698704871:
                if (str.equals("VIEW_POINT_LIST")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 1803427515:
                if (str.equals("REFRESH")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        if (!z) {
            systemNoticeFragment.b();
        } else if (z) {
            systemNoticeFragment.e();
        } else if (z) {
            systemNoticeFragment.d();
        } else if (!z) {
        } else {
            systemNoticeFragment.c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004f, code lost:
        if (r6.equals("VIEW_POINT") != false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.framework.ui.mvp.MvpFragment r5, java.lang.String r6, java.util.List r7) {
        /*
            r4 = this;
            r0 = r5
            com.soft.blued.ui.notify.fragment.SystemNoticeFragment r0 = (com.soft.blued.ui.notify.fragment.SystemNoticeFragment) r0
            r5 = r0
            r0 = r7
            if (r0 == 0) goto L8a
            r0 = r7
            int r0 = r0.size()
            if (r0 <= 0) goto L8a
            r0 = 0
            r8 = r0
            r0 = r7
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L8a
            r0 = r6
            int r0 = r0.hashCode()
            r9 = r0
            r0 = r9
            r1 = -121134250(0xfffffffff8c7a356, float:-3.2393123E34)
            if (r0 == r1) goto L49
            r0 = r9
            r1 = 698704871(0x29a563e7, float:7.344802E-14)
            if (r0 == r1) goto L3a
            goto L55
        L3a:
            r0 = r6
            java.lang.String r1 = "VIEW_POINT_LIST"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L55
            r0 = 1
            r8 = r0
            goto L58
        L49:
            r0 = r6
            java.lang.String r1 = "VIEW_POINT"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L55
            goto L58
        L55:
            r0 = -1
            r8 = r0
        L58:
            r0 = r8
            if (r0 == 0) goto L76
            r0 = r8
            r1 = 1
            if (r0 == r1) goto L66
            goto L8a
        L66:
            java.lang.Class<com.blued.community.model.FeedNotice> r0 = com.blued.community.model.FeedNotice.class
            r1 = r10
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto L8a
            r0 = r5
            r1 = r7
            r0.a(r1)
            return
        L76:
            java.lang.Class<com.soft.blued.ui.notify.model.ViewpointNoticeCount> r0 = com.soft.blued.ui.notify.model.ViewpointNoticeCount.class
            r1 = r10
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto L8a
            r0 = r5
            r1 = r10
            com.soft.blued.ui.notify.model.ViewpointNoticeCount r1 = (com.soft.blued.ui.notify.model.ViewpointNoticeCount) r1
            r0.a(r1)
            return
        L8a:
            r0 = r4
            r1 = r5
            r2 = r6
            r0.a(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.notify.fragment.SystemNoticeFragment_MVP.a(com.blued.android.framework.ui.mvp.MvpFragment, java.lang.String, java.util.List):void");
    }
}
