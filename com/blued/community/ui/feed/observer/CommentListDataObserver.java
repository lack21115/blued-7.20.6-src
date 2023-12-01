package com.blued.community.ui.feed.observer;

import com.blued.community.ui.comment.model.FeedComment;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/observer/CommentListDataObserver.class */
public class CommentListDataObserver {

    /* renamed from: a  reason: collision with root package name */
    private static CommentListDataObserver f19865a = new CommentListDataObserver();
    private ArrayList<ICommentDataObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/observer/CommentListDataObserver$ICommentDataObserver.class */
    public interface ICommentDataObserver {
        void a(FeedComment feedComment, String str);

        void a(String str);

        void a(String str, int i);
    }

    public static CommentListDataObserver a() {
        return f19865a;
    }

    public void a(FeedComment feedComment, String str) {
        synchronized (this) {
            Iterator<ICommentDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ICommentDataObserver next = it.next();
                if (next != null) {
                    next.a(feedComment, str);
                }
            }
        }
    }

    public void a(ICommentDataObserver iCommentDataObserver) {
        synchronized (this) {
            if (iCommentDataObserver != null) {
                this.b.add(iCommentDataObserver);
            }
        }
    }

    public void a(String str) {
        synchronized (this) {
            Iterator<ICommentDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ICommentDataObserver next = it.next();
                if (next != null) {
                    next.a(str);
                }
            }
        }
    }

    public void a(String str, int i) {
        synchronized (this) {
            Iterator<ICommentDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ICommentDataObserver next = it.next();
                if (next != null) {
                    next.a(str, i);
                }
            }
        }
    }

    public void b(ICommentDataObserver iCommentDataObserver) {
        synchronized (this) {
            if (iCommentDataObserver != null) {
                this.b.remove(iCommentDataObserver);
            }
        }
    }
}
