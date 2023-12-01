package com.soft.blued.ui.find.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.soft.blued.constant.EventBusConstant;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/NearbyHomeFragment_MVP.class */
public final class NearbyHomeFragment_MVP implements MvpDispatcher {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(NearbyHomeFragment nearbyHomeFragment, String str) {
        boolean z;
        switch (str.hashCode()) {
            case -2051683292:
                if (str.equals("show_gold_guide_animation")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case -1818789622:
                if (str.equals("filter_state")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1073522738:
                if (str.equals(EventBusConstant.KEY_EVENT_IS_SHOW_TIP)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -308528461:
                if (str.equals(EventBusConstant.KEY_EVENT_SET_TIP_VISIBILITY)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1276056036:
                if (str.equals("home_city_title")) {
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
            nearbyHomeFragment.y();
        } else if (z) {
            nearbyHomeFragment.v();
        } else if (z) {
            nearbyHomeFragment.d();
        } else if (z) {
            nearbyHomeFragment.w();
        } else if (!z) {
        } else {
            nearbyHomeFragment.e();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00a5, code lost:
        if (r6.equals(com.soft.blued.constant.EventBusConstant.KEY_EVENT_NEARBY_ACTIVITY) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.framework.ui.mvp.MvpFragment r5, java.lang.String r6, java.util.List r7) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.find.fragment.NearbyHomeFragment_MVP.a(com.blued.android.framework.ui.mvp.MvpFragment, java.lang.String, java.util.List):void");
    }
}
