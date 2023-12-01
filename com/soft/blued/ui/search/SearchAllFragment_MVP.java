package com.soft.blued.ui.search;

import com.blued.android.framework.ui.mvp.MvpDispatcher;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/SearchAllFragment_MVP.class */
public final class SearchAllFragment_MVP implements MvpDispatcher {
    private void a(SearchAllFragment searchAllFragment, String str) {
        boolean z;
        int hashCode = str.hashCode();
        if (hashCode != 1060515318) {
            if (hashCode == 1756700488 && str.equals("PERSON_LIST")) {
                z = true;
            }
            z = true;
        } else {
            if (str.equals("MESSAGE_LIST")) {
                z = false;
            }
            z = true;
        }
        if (!z) {
            searchAllFragment.c();
        } else if (!z) {
        } else {
            searchAllFragment.b();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0077, code lost:
        if (r6.equals("MESSAGE_LIST") != false) goto L12;
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
            com.soft.blued.ui.search.SearchAllFragment r0 = (com.soft.blued.ui.search.SearchAllFragment) r0
            r5 = r0
            r0 = r7
            if (r0 == 0) goto Le9
            r0 = r7
            int r0 = r0.size()
            if (r0 <= 0) goto Le9
            r0 = 0
            r8 = r0
            r0 = r7
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            r9 = r0
            r0 = r9
            if (r0 == 0) goto Le9
            r0 = r6
            int r0 = r0.hashCode()
            switch(r0) {
                case 837240817: goto L7d;
                case 1060515318: goto L71;
                case 1756700488: goto L62;
                case 2115809965: goto L53;
                default: goto L50;
            }
        L50:
            goto L8c
        L53:
            r0 = r6
            java.lang.String r1 = "CIRCLE_LIST"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L8c
            r0 = 1
            r8 = r0
            goto L8f
        L62:
            r0 = r6
            java.lang.String r1 = "PERSON_LIST"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L8c
            r0 = 3
            r8 = r0
            goto L8f
        L71:
            r0 = r6
            java.lang.String r1 = "MESSAGE_LIST"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L8c
            goto L8f
        L7d:
            r0 = r6
            java.lang.String r1 = "SUBJECT_LIST"
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
            if (r0 == 0) goto Ld9
            r0 = r8
            r1 = 1
            if (r0 == r1) goto Lc9
            r0 = r8
            r1 = 2
            if (r0 == r1) goto Lb9
            r0 = r8
            r1 = 3
            if (r0 == r1) goto La9
            goto Le9
        La9:
            java.lang.Class<com.soft.blued.ui.find.model.UserFindResult> r0 = com.soft.blued.ui.find.model.UserFindResult.class
            r1 = r9
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Le9
            r0 = r5
            r1 = r7
            r0.c(r1)
            return
        Lb9:
            java.lang.Class<com.blued.community.ui.topic.model.BluedTopic> r0 = com.blued.community.ui.topic.model.BluedTopic.class
            r1 = r9
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Le9
            r0 = r5
            r1 = r7
            r0.b(r1)
            return
        Lc9:
            java.lang.Class<com.blued.community.ui.circle.model.MyCircleModel> r0 = com.blued.community.ui.circle.model.MyCircleModel.class
            r1 = r9
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Le9
            r0 = r5
            r1 = r7
            r0.a(r1)
            return
        Ld9:
            java.lang.Class<com.soft.blued.ui.search.model.SearchSessionModel> r0 = com.soft.blued.ui.search.model.SearchSessionModel.class
            r1 = r9
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Le9
            r0 = r5
            r1 = r7
            r0.d(r1)
            return
        Le9:
            r0 = r4
            r1 = r5
            r2 = r6
            r0.a(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.search.SearchAllFragment_MVP.a(com.blued.android.framework.ui.mvp.MvpFragment, java.lang.String, java.util.List):void");
    }
}
