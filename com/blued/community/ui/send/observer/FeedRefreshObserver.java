package com.blued.community.ui.send.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/observer/FeedRefreshObserver.class */
public class FeedRefreshObserver {

    /* renamed from: a  reason: collision with root package name */
    private static FeedRefreshObserver f20078a = new FeedRefreshObserver();
    private ArrayList<IFeedRefreshObserver> b = new ArrayList<>();

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/observer/FeedRefreshObserver$IFeedRefreshObserver.class */
    public interface IFeedRefreshObserver {
        void a(Object obj, int i);
    }

    private FeedRefreshObserver() {
    }

    public static FeedRefreshObserver a() {
        return f20078a;
    }

    public void a(IFeedRefreshObserver iFeedRefreshObserver) {
        synchronized (this) {
            if (iFeedRefreshObserver != null) {
                if (!this.b.contains(iFeedRefreshObserver)) {
                    this.b.add(iFeedRefreshObserver);
                }
            }
        }
    }

    public void a(Object obj, int i) {
        synchronized (this) {
            Iterator<IFeedRefreshObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IFeedRefreshObserver next = it.next();
                if (next != null) {
                    next.a(obj, i);
                }
            }
        }
    }

    public void b(IFeedRefreshObserver iFeedRefreshObserver) {
        synchronized (this) {
            if (iFeedRefreshObserver != null) {
                this.b.remove(iFeedRefreshObserver);
            }
        }
    }
}
