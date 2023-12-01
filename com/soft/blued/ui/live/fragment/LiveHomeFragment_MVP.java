package com.soft.blued.ui.live.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveHomeFragment_MVP.class */
public final class LiveHomeFragment_MVP implements MvpDispatcher {
    private void a(LiveHomeFragment liveHomeFragment, String str) {
        boolean z;
        int hashCode = str.hashCode();
        if (hashCode == -311231599) {
            if (str.equals("TWO_LEVEL")) {
                z = false;
            }
            z = true;
        } else if (hashCode != 275365345) {
            if (hashCode == 2129566804 && str.equals("LIST_TAB")) {
                z = true;
            }
            z = true;
        } else {
            if (str.equals("BANNER_INFO")) {
                z = true;
            }
            z = true;
        }
        if (!z) {
            liveHomeFragment.x();
        } else if (z) {
            liveHomeFragment.w();
        } else if (!z) {
        } else {
            liveHomeFragment.v();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0078, code lost:
        if (r6.equals("GET_LIVE_STATE") != false) goto L12;
     */
    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.framework.ui.mvp.MvpFragment r5, java.lang.String r6, java.util.List r7) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.live.fragment.LiveHomeFragment_MVP.a(com.blued.android.framework.ui.mvp.MvpFragment, java.lang.String, java.util.List):void");
    }
}
