package com.blued.community.ui.feed.observer;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/observer/LikeListDataObserver.class */
public class LikeListDataObserver {

    /* renamed from: a  reason: collision with root package name */
    private static LikeListDataObserver f19866a = new LikeListDataObserver();
    private List<ILikeListDataObserver> b = new ArrayList();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/observer/LikeListDataObserver$ILikeListDataObserver.class */
    public interface ILikeListDataObserver {
        void a(String str, int i);
    }

    private LikeListDataObserver() {
    }

    public static LikeListDataObserver a() {
        return f19866a;
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
