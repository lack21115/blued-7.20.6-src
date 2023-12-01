package com.soft.blued.ui.live.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/fragment/LiveListFollowFragmentNew_MVP.class */
public final class LiveListFollowFragmentNew_MVP implements MvpDispatcher {
    private void a(LiveListFollowFragmentNew liveListFollowFragmentNew, String str) {
        boolean z;
        int hashCode = str.hashCode();
        if (hashCode != -390669347) {
            if (hashCode == -73333168 && str.equals("recommend_list_user_has_more")) {
                z = false;
            }
            z = true;
        } else {
            if (str.equals("recommend_list_user_no_more")) {
                z = true;
            }
            z = true;
        }
        if (!z) {
            liveListFollowFragmentNew.b();
        } else if (!z) {
        } else {
            liveListFollowFragmentNew.c();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0059, code lost:
        if (r6.equals("more_recommend_list_new_user") != false) goto L11;
     */
    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.framework.ui.mvp.MvpFragment r5, java.lang.String r6, java.util.List r7) {
        /*
            r4 = this;
            r0 = r5
            com.soft.blued.ui.live.fragment.LiveListFollowFragmentNew r0 = (com.soft.blued.ui.live.fragment.LiveListFollowFragmentNew) r0
            r5 = r0
            r0 = r7
            if (r0 == 0) goto Led
            r0 = r7
            int r0 = r0.size()
            if (r0 <= 0) goto Led
            r0 = 0
            r8 = r0
            r0 = r7
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            r9 = r0
            r0 = r9
            if (r0 == 0) goto Led
            r0 = r6
            int r0 = r0.hashCode()
            switch(r0) {
                case -2132740343: goto L7d;
                case -1447382082: goto L6e;
                case -390669347: goto L5f;
                case -306246562: goto L53;
                default: goto L50;
            }
        L50:
            goto L8c
        L53:
            r0 = r6
            java.lang.String r1 = "more_recommend_list_new_user"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L8c
            goto L8f
        L5f:
            r0 = r6
            java.lang.String r1 = "recommend_list_user_no_more"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L8c
            r0 = 3
            r8 = r0
            goto L8f
        L6e:
            r0 = r6
            java.lang.String r1 = "follow_list_user"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L8c
            r0 = 1
            r8 = r0
            goto L8f
        L7d:
            r0 = r6
            java.lang.String r1 = "recommend_list_user"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L8c
            r0 = 2
            r8 = r0
            goto L8f
        L8c:
            r0 = -1
            r8 = r0
        L8f:
            r0 = r8
            if (r0 == 0) goto Ldd
            r0 = r8
            r1 = 1
            if (r0 == r1) goto Lcd
            r0 = r8
            r1 = 2
            if (r0 == r1) goto Lbd
            r0 = r8
            r1 = 3
            if (r0 == r1) goto La9
            goto Led
        La9:
            java.lang.Class<com.blued.android.module.live_china.model.BluedLiveListData> r0 = com.blued.android.module.live_china.model.BluedLiveListData.class
            r1 = r9
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Led
            r0 = r5
            r1 = r9
            com.blued.android.module.live_china.model.BluedLiveListData r1 = (com.blued.android.module.live_china.model.BluedLiveListData) r1
            r0.a(r1)
            return
        Lbd:
            java.lang.Class<com.blued.android.module.live_china.model.LiveRecommendModel> r0 = com.blued.android.module.live_china.model.LiveRecommendModel.class
            r1 = r9
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Led
            r0 = r5
            r1 = r7
            r0.b(r1)
            return
        Lcd:
            java.lang.Class<com.blued.android.module.live_china.model.BluedLiveListData> r0 = com.blued.android.module.live_china.model.BluedLiveListData.class
            r1 = r9
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Led
            r0 = r5
            r1 = r7
            r0.a(r1)
            return
        Ldd:
            java.lang.Class<com.blued.android.module.live_china.model.LiveRecommendModel> r0 = com.blued.android.module.live_china.model.LiveRecommendModel.class
            r1 = r9
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Led
            r0 = r5
            r1 = r7
            r0.c(r1)
            return
        Led:
            r0 = r4
            r1 = r5
            r2 = r6
            r0.a(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.live.fragment.LiveListFollowFragmentNew_MVP.a(com.blued.android.framework.ui.mvp.MvpFragment, java.lang.String, java.util.List):void");
    }
}
