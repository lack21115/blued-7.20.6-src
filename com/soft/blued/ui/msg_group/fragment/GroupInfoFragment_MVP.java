package com.soft.blued.ui.msg_group.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/GroupInfoFragment_MVP.class */
public final class GroupInfoFragment_MVP implements MvpDispatcher {
    private void a(GroupInfoFragment groupInfoFragment, String str) {
        if ((str.hashCode() == 570759793 && str.equals("apply_succeed")) ? false : true) {
            return;
        }
        groupInfoFragment.v();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
        if (r6.equals(com.umeng.analytics.pro.d.K) == false) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a4  */
    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.framework.ui.mvp.MvpFragment r5, java.lang.String r6, java.util.List r7) {
        /*
            r4 = this;
            r0 = r5
            com.soft.blued.ui.msg_group.fragment.GroupInfoFragment r0 = (com.soft.blued.ui.msg_group.fragment.GroupInfoFragment) r0
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
            r7 = r0
            r0 = r7
            if (r0 == 0) goto Lb6
            r0 = r6
            int r0 = r0.hashCode()
            r9 = r0
            r0 = r9
            r1 = -889473228(0xffffffffcafbb734, float:-8248218.0)
            if (r0 == r1) goto L5a
            r0 = r9
            r1 = -346952246(0xffffffffeb51edca, float:-2.5378842E26)
            if (r0 == r1) goto L4b
            r0 = r9
            r1 = 1282170478(0x4c6c5e6e, float:6.196268E7)
            if (r0 == r1) goto L3f
            goto L69
        L3f:
            r0 = r6
            java.lang.String r1 = "group_info"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L69
            goto L6c
        L4b:
            r0 = r6
            java.lang.String r1 = "switch_top"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L69
            r0 = 1
            r8 = r0
            goto L6c
        L5a:
            r0 = r6
            java.lang.String r1 = "switch"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L69
            r0 = 2
            r8 = r0
            goto L6c
        L69:
            r0 = -1
            r8 = r0
        L6c:
            r0 = r8
            if (r0 == 0) goto La4
            r0 = r8
            r1 = 1
            if (r0 == r1) goto L92
            r0 = r8
            r1 = 2
            if (r0 == r1) goto L80
            goto Lb6
        L80:
            java.lang.Class<com.blued.android.module.common.group.GroupInfoModel> r0 = com.blued.android.module.common.group.GroupInfoModel.class
            r1 = r7
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lb6
            r0 = r5
            r1 = r7
            com.blued.android.module.common.group.GroupInfoModel r1 = (com.blued.android.module.common.group.GroupInfoModel) r1
            r0.b(r1)
            return
        L92:
            java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
            r1 = r7
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lb6
            r0 = r5
            r1 = r7
            java.lang.Integer r1 = (java.lang.Integer) r1
            r0.a(r1)
            return
        La4:
            java.lang.Class<com.blued.android.module.common.group.GroupInfoModel> r0 = com.blued.android.module.common.group.GroupInfoModel.class
            r1 = r7
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lb6
            r0 = r5
            r1 = r7
            com.blued.android.module.common.group.GroupInfoModel r1 = (com.blued.android.module.common.group.GroupInfoModel) r1
            r0.a(r1)
            return
        Lb6:
            r0 = r4
            r1 = r5
            r2 = r6
            r0.a(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg_group.fragment.GroupInfoFragment_MVP.a(com.blued.android.framework.ui.mvp.MvpFragment, java.lang.String, java.util.List):void");
    }
}
