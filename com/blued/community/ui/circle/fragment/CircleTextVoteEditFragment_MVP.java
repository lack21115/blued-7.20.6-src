package com.blued.community.ui.circle.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/circle/fragment/CircleTextVoteEditFragment_MVP.class */
public final class CircleTextVoteEditFragment_MVP implements MvpDispatcher {
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004f, code lost:
        if (r5.equals("title") != false) goto L14;
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
            com.blued.community.ui.circle.fragment.CircleTextVoteEditFragment r0 = (com.blued.community.ui.circle.fragment.CircleTextVoteEditFragment) r0
            r4 = r0
            r0 = r6
            if (r0 == 0) goto L87
            r0 = r6
            int r0 = r0.size()
            if (r0 <= 0) goto L87
            r0 = 0
            r7 = r0
            r0 = r6
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L87
            r0 = r5
            int r0 = r0.hashCode()
            r8 = r0
            r0 = r8
            r1 = 110371416(0x6942258, float:5.5721876E-35)
            if (r0 == r1) goto L49
            r0 = r8
            r1 = 951530617(0x38b73479, float:8.735894E-5)
            if (r0 == r1) goto L3a
            goto L55
        L3a:
            r0 = r5
            java.lang.String r1 = "content"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L55
            r0 = 1
            r7 = r0
            goto L58
        L49:
            r0 = r5
            java.lang.String r1 = "title"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L55
            goto L58
        L55:
            r0 = -1
            r7 = r0
        L58:
            r0 = r7
            if (r0 == 0) goto L74
            r0 = r7
            r1 = 1
            if (r0 == r1) goto L64
            return
        L64:
            java.lang.Class<com.blued.community.widget.vote.text.model.CircleTextVote> r0 = com.blued.community.widget.vote.text.model.CircleTextVote.class
            r1 = r9
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto L87
            r0 = r4
            r1 = r6
            r0.a(r1)
            return
        L74:
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            r1 = r9
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto L87
            r0 = r4
            r1 = r9
            java.lang.String r1 = (java.lang.String) r1
            r0.c(r1)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.circle.fragment.CircleTextVoteEditFragment_MVP.a(com.blued.android.framework.ui.mvp.MvpFragment, java.lang.String, java.util.List):void");
    }
}
