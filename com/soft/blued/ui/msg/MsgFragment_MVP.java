package com.soft.blued.ui.msg;

import com.blued.android.framework.ui.mvp.MvpDispatcher;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/MsgFragment_MVP.class */
public final class MsgFragment_MVP implements MvpDispatcher {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(MsgFragment msgFragment, String str) {
        boolean z;
        switch (str.hashCode()) {
            case -735794347:
                if (str.equals("showMsgBoxGuide")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 749411636:
                if (str.equals("refreshComplete")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 857162668:
                if (str.equals("showDeletedMsgHint")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1445862261:
                if (str.equals("hideHelloView")) {
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
            msgFragment.c();
        } else if (z) {
            msgFragment.d();
        } else if (z) {
            msgFragment.v();
        } else if (!z) {
        } else {
            msgFragment.e();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0088, code lost:
        if (r6.equals("addHelloListData") != false) goto L12;
     */
    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.framework.ui.mvp.MvpFragment r5, java.lang.String r6, java.util.List r7) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.MsgFragment_MVP.a(com.blued.android.framework.ui.mvp.MvpFragment, java.lang.String, java.util.List):void");
    }
}
