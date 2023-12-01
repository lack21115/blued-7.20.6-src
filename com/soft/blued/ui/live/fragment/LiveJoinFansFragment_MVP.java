package com.soft.blued.ui.live.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveJoinFansFragment_MVP.class */
public final class LiveJoinFansFragment_MVP implements MvpDispatcher {
    private void a(LiveJoinFansFragment liveJoinFansFragment, String str) {
        if ((str.hashCode() == -97990110 && str.equals("LIVE_JOIN_FANS")) ? false : true) {
            return;
        }
        liveJoinFansFragment.b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
        if (r6.equals("LIVE_JOIN_RECOMMEND") == false) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.framework.ui.mvp.MvpFragment r5, java.lang.String r6, java.util.List r7) {
        /*
            r4 = this;
            r0 = r5
            com.soft.blued.ui.live.fragment.LiveJoinFansFragment r0 = (com.soft.blued.ui.live.fragment.LiveJoinFansFragment) r0
            r5 = r0
            r0 = r7
            if (r0 == 0) goto Lb6
            r0 = r7
            int r0 = r0.size()
            if (r0 <= 0) goto Lb6
            r0 = 0
            r8 = r0
            r0 = r7
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            r10 = r0
            r0 = r10
            if (r0 == 0) goto Lb6
            r0 = r6
            int r0 = r0.hashCode()
            r9 = r0
            r0 = r9
            r1 = -97990110(0xfffffffffa28ca22, float:-2.191014E35)
            if (r0 == r1) goto L5c
            r0 = r9
            r1 = 288034380(0x112b0e4c, float:1.3493927E-28)
            if (r0 == r1) goto L4d
            r0 = r9
            r1 = 1445811066(0x562d537a, float:4.764351E13)
            if (r0 == r1) goto L41
            goto L6b
        L41:
            r0 = r6
            java.lang.String r1 = "LIVE_JOIN_RECOMMEND"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6b
            goto L6e
        L4d:
            r0 = r6
            java.lang.String r1 = "LIVE_JOIN_FANS_QUIT"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6b
            r0 = 1
            r8 = r0
            goto L6e
        L5c:
            r0 = r6
            java.lang.String r1 = "LIVE_JOIN_FANS"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6b
            r0 = 2
            r8 = r0
            goto L6e
        L6b:
            r0 = -1
            r8 = r0
        L6e:
            r0 = r8
            if (r0 == 0) goto La6
            r0 = r8
            r1 = 1
            if (r0 == r1) goto L92
            r0 = r8
            r1 = 2
            if (r0 == r1) goto L82
            goto Lb6
        L82:
            java.lang.Class<com.soft.blued.ui.live.model.LiveJoinFansModel> r0 = com.soft.blued.ui.live.model.LiveJoinFansModel.class
            r1 = r10
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lb6
            r0 = r5
            r1 = r7
            r0.a(r1)
            return
        L92:
            java.lang.Class<com.blued.android.module.live_china.model.LiveFansQuitModel> r0 = com.blued.android.module.live_china.model.LiveFansQuitModel.class
            r1 = r10
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lb6
            r0 = r5
            r1 = r10
            com.blued.android.module.live_china.model.LiveFansQuitModel r1 = (com.blued.android.module.live_china.model.LiveFansQuitModel) r1
            r0.a(r1)
            return
        La6:
            java.lang.Class<com.blued.android.module.live_china.model.LiveFansRecommendModel> r0 = com.blued.android.module.live_china.model.LiveFansRecommendModel.class
            r1 = r10
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lb6
            r0 = r5
            r1 = r7
            r0.b(r1)
            return
        Lb6:
            r0 = r4
            r1 = r5
            r2 = r6
            r0.a(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.live.fragment.LiveJoinFansFragment_MVP.a(com.blued.android.framework.ui.mvp.MvpFragment, java.lang.String, java.util.List):void");
    }
}
