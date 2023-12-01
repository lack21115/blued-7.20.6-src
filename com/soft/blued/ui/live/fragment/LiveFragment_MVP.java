package com.soft.blued.ui.live.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveFragment_MVP.class */
public final class LiveFragment_MVP implements MvpDispatcher {
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
        if (r5.equals("LIVE_STATE") != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.framework.ui.mvp.MvpFragment r4, java.lang.String r5, java.util.List r6) {
        /*
            r3 = this;
            r0 = r4
            com.soft.blued.ui.live.fragment.LiveFragment r0 = (com.soft.blued.ui.live.fragment.LiveFragment) r0
            r4 = r0
            r0 = r6
            if (r0 == 0) goto Lb3
            r0 = r6
            int r0 = r0.size()
            if (r0 <= 0) goto Lb3
            r0 = 0
            r7 = r0
            r0 = r6
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            r6 = r0
            r0 = r6
            if (r0 == 0) goto Lb3
            r0 = r5
            int r0 = r0.hashCode()
            r8 = r0
            r0 = r8
            r1 = -2132422740(0xffffffff80e5cfac, float:-2.1104827E-38)
            if (r0 == r1) goto L5a
            r0 = r8
            r1 = -1680246946(0xffffffff9bd9775e, float:-3.5976778E-22)
            if (r0 == r1) goto L4e
            r0 = r8
            r1 = -1325707744(0xffffffffb0fb4e20, float:-1.8284858E-9)
            if (r0 == r1) goto L3f
            goto L69
        L3f:
            r0 = r5
            java.lang.String r1 = "LIVE_TAB_SETTINGS"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L69
            r0 = 2
            r7 = r0
            goto L6c
        L4e:
            r0 = r5
            java.lang.String r1 = "LIVE_STATE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L69
            goto L6c
        L5a:
            r0 = r5
            java.lang.String r1 = "REQUEST_LIVE_COUNT"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L69
            r0 = 1
            r7 = r0
            goto L6c
        L69:
            r0 = -1
            r7 = r0
        L6c:
            r0 = r7
            if (r0 == 0) goto La2
            r0 = r7
            r1 = 1
            if (r0 == r1) goto L90
            r0 = r7
            r1 = 2
            if (r0 == r1) goto L7e
            return
        L7e:
            java.lang.Class<com.soft.blued.ui.home.model.LiveBubble> r0 = com.soft.blued.ui.home.model.LiveBubble.class
            r1 = r6
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lb3
            r0 = r4
            r1 = r6
            com.soft.blued.ui.home.model.LiveBubble r1 = (com.soft.blued.ui.home.model.LiveBubble) r1
            r0.a(r1)
            return
        L90:
            java.lang.Class<com.blued.android.module.common.model.CountModel> r0 = com.blued.android.module.common.model.CountModel.class
            r1 = r6
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lb3
            r0 = r4
            r1 = r6
            com.blued.android.module.common.model.CountModel r1 = (com.blued.android.module.common.model.CountModel) r1
            r0.a(r1)
            return
        La2:
            java.lang.Class<com.blued.android.module.live_china.model.BluedLiveState> r0 = com.blued.android.module.live_china.model.BluedLiveState.class
            r1 = r6
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lb3
            r0 = r4
            r1 = r6
            com.blued.android.module.live_china.model.BluedLiveState r1 = (com.blued.android.module.live_china.model.BluedLiveState) r1
            r0.a(r1)
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.live.fragment.LiveFragment_MVP.a(com.blued.android.framework.ui.mvp.MvpFragment, java.lang.String, java.util.List):void");
    }
}
