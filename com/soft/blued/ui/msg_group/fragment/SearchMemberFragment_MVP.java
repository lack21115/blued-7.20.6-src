package com.soft.blued.ui.msg_group.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg_group/fragment/SearchMemberFragment_MVP.class */
public final class SearchMemberFragment_MVP implements MvpDispatcher {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0077, code lost:
        if (r5.equals("data_search") != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.framework.ui.mvp.MvpFragment r4, java.lang.String r5, java.util.List r6) {
        /*
            r3 = this;
            r0 = r4
            com.soft.blued.ui.msg_group.fragment.SearchMemberFragment r0 = (com.soft.blued.ui.msg_group.fragment.SearchMemberFragment) r0
            r4 = r0
            r0 = r6
            if (r0 == 0) goto Lee
            r0 = r6
            int r0 = r0.size()
            if (r0 <= 0) goto Lee
            r0 = 0
            r7 = r0
            r0 = r6
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            r8 = r0
            r0 = r8
            if (r0 == 0) goto Lee
            r0 = r5
            int r0 = r0.hashCode()
            switch(r0) {
                case -1515158321: goto L7d;
                case -1343725603: goto L71;
                case -1091221294: goto L62;
                case -314568773: goto L53;
                default: goto L50;
            }
        L50:
            goto L8c
        L53:
            r0 = r5
            java.lang.String r1 = "data_set_manager"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L8c
            r0 = 2
            r7 = r0
            goto L8f
        L62:
            r0 = r5
            java.lang.String r1 = "update_no_data_view"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L8c
            r0 = 1
            r7 = r0
            goto L8f
        L71:
            r0 = r5
            java.lang.String r1 = "data_search"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L8c
            goto L8f
        L7d:
            r0 = r5
            java.lang.String r1 = "data_member"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L8c
            r0 = 3
            r7 = r0
            goto L8f
        L8c:
            r0 = -1
            r7 = r0
        L8f:
            r0 = r7
            if (r0 == 0) goto Ldf
            r0 = r7
            r1 = 1
            if (r0 == r1) goto Lcb
            r0 = r7
            r1 = 2
            if (r0 == r1) goto Lb7
            r0 = r7
            r1 = 3
            if (r0 == r1) goto La7
            return
        La7:
            java.lang.Class<com.blued.android.module.common.group.GroupMemberModel> r0 = com.blued.android.module.common.group.GroupMemberModel.class
            r1 = r8
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lee
            r0 = r4
            r1 = r6
            r0.b(r1)
            return
        Lb7:
            java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
            r1 = r8
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lee
            r0 = r4
            r1 = r8
            java.lang.Integer r1 = (java.lang.Integer) r1
            r0.a(r1)
            return
        Lcb:
            java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
            r1 = r8
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lee
            r0 = r4
            r1 = r8
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            r0.a(r1)
            return
        Ldf:
            java.lang.Class<com.blued.android.module.common.group.GroupMemberModel> r0 = com.blued.android.module.common.group.GroupMemberModel.class
            r1 = r8
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lee
            r0 = r4
            r1 = r6
            r0.a(r1)
        Lee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg_group.fragment.SearchMemberFragment_MVP.a(com.blued.android.framework.ui.mvp.MvpFragment, java.lang.String, java.util.List):void");
    }
}
