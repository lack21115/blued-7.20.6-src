package com.blued.community.ui.comment.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/comment/fragment/CommentFragment_MVP.class */
public final class CommentFragment_MVP implements MvpDispatcher {
    private void a(CommentFragment commentFragment, String str) {
        boolean z;
        int hashCode = str.hashCode();
        if (hashCode != -2055076317) {
            if (hashCode == -1106079055 && str.equals("comment_state")) {
                z = true;
            }
            z = true;
        } else {
            if (str.equals("comment_success")) {
                z = false;
            }
            z = true;
        }
        if (!z) {
            commentFragment.w();
        } else if (!z) {
        } else {
            commentFragment.v();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0065, code lost:
        if (r6.equals("comments") != false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00aa  */
    @Override // com.blued.android.framework.ui.mvp.MvpDispatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.blued.android.framework.ui.mvp.MvpFragment r5, java.lang.String r6, java.util.List r7) {
        /*
            r4 = this;
            r0 = r5
            com.blued.community.ui.comment.fragment.CommentFragment r0 = (com.blued.community.ui.comment.fragment.CommentFragment) r0
            r5 = r0
            r0 = r7
            if (r0 == 0) goto Lba
            r0 = r7
            int r0 = r0.size()
            if (r0 <= 0) goto Lba
            r0 = 0
            r8 = r0
            r0 = r7
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            r10 = r0
            r0 = r10
            if (r0 == 0) goto Lba
            r0 = r6
            int r0 = r0.hashCode()
            r9 = r0
            r0 = r9
            r1 = -602415628(0xffffffffdc17ddf4, float:-1.70987046E17)
            if (r0 == r1) goto L5f
            r0 = r9
            r1 = 3321751(0x32af97, float:4.654765E-39)
            if (r0 == r1) goto L50
            r0 = r9
            r1 = 950398559(0x38a5ee5f, float:7.912213E-5)
            if (r0 == r1) goto L41
            goto L6b
        L41:
            r0 = r6
            java.lang.String r1 = "comment"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6b
            r0 = 2
            r8 = r0
            goto L6e
        L50:
            r0 = r6
            java.lang.String r1 = "like"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6b
            r0 = 1
            r8 = r0
            goto L6e
        L5f:
            r0 = r6
            java.lang.String r1 = "comments"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L6b
            goto L6e
        L6b:
            r0 = -1
            r8 = r0
        L6e:
            r0 = r8
            if (r0 == 0) goto Laa
            r0 = r8
            r1 = 1
            if (r0 == r1) goto L96
            r0 = r8
            r1 = 2
            if (r0 == r1) goto L82
            goto Lba
        L82:
            java.lang.Class<com.blued.community.ui.comment.model.FeedComment> r0 = com.blued.community.ui.comment.model.FeedComment.class
            r1 = r10
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lba
            r0 = r5
            r1 = r10
            com.blued.community.ui.comment.model.FeedComment r1 = (com.blued.community.ui.comment.model.FeedComment) r1
            r0.a(r1)
            return
        L96:
            java.lang.Class<com.blued.community.ui.comment.model.FeedComment> r0 = com.blued.community.ui.comment.model.FeedComment.class
            r1 = r10
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lba
            r0 = r5
            r1 = r10
            com.blued.community.ui.comment.model.FeedComment r1 = (com.blued.community.ui.comment.model.FeedComment) r1
            r0.b(r1)
            return
        Laa:
            java.lang.Class<com.blued.community.ui.comment.model.FeedComment> r0 = com.blued.community.ui.comment.model.FeedComment.class
            r1 = r10
            boolean r0 = r0.isInstance(r1)
            if (r0 == 0) goto Lba
            r0 = r5
            r1 = r7
            r0.a(r1)
            return
        Lba:
            r0 = r4
            r1 = r5
            r2 = r6
            r0.a(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.community.ui.comment.fragment.CommentFragment_MVP.a(com.blued.android.framework.ui.mvp.MvpFragment, java.lang.String, java.util.List):void");
    }
}
