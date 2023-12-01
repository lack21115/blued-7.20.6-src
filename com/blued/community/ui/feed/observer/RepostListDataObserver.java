package com.blued.community.ui.feed.observer;

import com.blued.community.ui.feed.model.FeedRepost;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/observer/RepostListDataObserver.class */
public class RepostListDataObserver extends CommentListDataObserver {
    private static RepostListDataObserver a = new RepostListDataObserver();
    private List<IRepostListDataObserver> b = new ArrayList();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/observer/RepostListDataObserver$IRepostListDataObserver.class */
    public interface IRepostListDataObserver {
        void a(FeedRepost feedRepost);
    }

    private RepostListDataObserver() {
    }

    public static RepostListDataObserver b() {
        return a;
    }

    public void a(FeedRepost feedRepost) {
        synchronized (this) {
            for (IRepostListDataObserver iRepostListDataObserver : this.b) {
                if (iRepostListDataObserver != null) {
                    iRepostListDataObserver.a(feedRepost);
                }
            }
        }
    }

    public void a(IRepostListDataObserver iRepostListDataObserver) {
        synchronized (this) {
            if (iRepostListDataObserver != null) {
                this.b.add(iRepostListDataObserver);
            }
        }
    }

    public void b(IRepostListDataObserver iRepostListDataObserver) {
        synchronized (this) {
            if (iRepostListDataObserver != null) {
                this.b.remove(iRepostListDataObserver);
            }
        }
    }
}
