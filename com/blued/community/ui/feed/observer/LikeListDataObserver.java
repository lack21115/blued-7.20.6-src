package com.blued.community.ui.feed.observer;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/observer/LikeListDataObserver.class */
public class LikeListDataObserver {
    private static LikeListDataObserver a = new LikeListDataObserver();
    private List<ILikeListDataObserver> b = new ArrayList();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/observer/LikeListDataObserver$ILikeListDataObserver.class */
    public interface ILikeListDataObserver {
        void a(String str, int i);
    }

    private LikeListDataObserver() {
    }

    public static LikeListDataObserver a() {
        return a;
    }

    public void a(ILikeListDataObserver iLikeListDataObserver) {
        synchronized (this) {
            if (iLikeListDataObserver != null) {
                this.b.add(iLikeListDataObserver);
            }
        }
    }

    public void a(String str, int i) {
        synchronized (this) {
            for (ILikeListDataObserver iLikeListDataObserver : this.b) {
                if (iLikeListDataObserver != null) {
                    iLikeListDataObserver.a(str, i);
                }
            }
        }
    }

    public void b(ILikeListDataObserver iLikeListDataObserver) {
        synchronized (this) {
            if (iLikeListDataObserver != null) {
                this.b.remove(iLikeListDataObserver);
            }
        }
    }
}
