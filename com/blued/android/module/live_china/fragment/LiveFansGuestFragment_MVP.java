package com.blued.android.module.live_china.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansGuestFragment_MVP.class */
public final class LiveFansGuestFragment_MVP implements MvpDispatcher {
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
        if (r5.equals("LIVE_FANS_INFO") != false) goto L16;
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
            com.blued.android.module.live_china.fragment.LiveFansGuestFragment r0 = (com.blued.android.module.live_china.fragment.LiveFansGuestFragment) r0
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
            r1 = 198150714(0xbcf8a3a, float:7.994148E-32)
            if (r0 == r1) goto L5d
            r0 = r8
            r1 = 1754487192(0x68935998, float:5.5667247E24)
            if (r0 == r1) goto L4e
            r0 = r8
            r1 = 1840016596(0x6dac6cd4, float:6.6703734E27)
            if (r0 == r1) goto L3f
            goto L69
        L3f:
            r0 = r5
            java.lang.String r1 = "LIVE_FANS_ADDED"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L69
            r0 = 1
            r7 = r0
            goto L6c
        L4e:
            r0 = r5
            java.lang.String r1 = "LIVE_FANS_TICKET"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L69
            r0 = 2
            r7 = r0
            goto L6c
        L5d:
            r0 = r5
            java.lang.String r1 = "LIVE_FANS_INFO"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L69
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
            java.lang.Class<com.blued.android.module.live_china.model.LiveGiftModel> r0 = com.blued.android.module.live_china.model.LiveGiftModel.class
            r1 = r6
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lb3
            r0 = r4
            r1 = r6
            com.blued.android.module.live_china.model.LiveGiftModel r1 = (com.blued.android.module.live_china.model.LiveGiftModel) r1
            r0.b(r1)
            return
        L90:
            java.lang.Class<com.blued.android.module.live_china.model.LiveGiftModel> r0 = com.blued.android.module.live_china.model.LiveGiftModel.class
            r1 = r6
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lb3
            r0 = r4
            r1 = r6
            com.blued.android.module.live_china.model.LiveGiftModel r1 = (com.blued.android.module.live_china.model.LiveGiftModel) r1
            r0.a(r1)
            return
        La2:
            java.lang.Class<com.blued.android.module.live_china.model.LiveFansInfoModel> r0 = com.blued.android.module.live_china.model.LiveFansInfoModel.class
            r1 = r6
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lb3
            r0 = r4
            r1 = r6
            com.blued.android.module.live_china.model.LiveFansInfoModel r1 = (com.blued.android.module.live_china.model.LiveFansInfoModel) r1
            r0.a(r1)
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveFansGuestFragment_MVP.a(com.blued.android.framework.ui.mvp.MvpFragment, java.lang.String, java.util.List):void");
    }
}
