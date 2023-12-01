package com.soft.blued.ui.user.observer;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/observer/FollowAndFansSelectedTabObserver.class */
public class FollowAndFansSelectedTabObserver {

    /* renamed from: a  reason: collision with root package name */
    private static FollowAndFansSelectedTabObserver f20550a = new FollowAndFansSelectedTabObserver();
    private List<IFollowAndFansSelectedTabObserver> b = new ArrayList();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/observer/FollowAndFansSelectedTabObserver$IFollowAndFansSelectedTabObserver.class */
    public interface IFollowAndFansSelectedTabObserver {
        void a(int i);

        void b(int i);
    }

    private FollowAndFansSelectedTabObserver() {
    }

    public static FollowAndFansSelectedTabObserver a() {
        return f20550a;
    }

    public void a(int i) {
        synchronized (this) {
            for (IFollowAndFansSelectedTabObserver iFollowAndFansSelectedTabObserver : this.b) {
                if (iFollowAndFansSelectedTabObserver != null) {
                    iFollowAndFansSelectedTabObserver.a(i);
                }
            }
        }
    }

    public void a(IFollowAndFansSelectedTabObserver iFollowAndFansSelectedTabObserver) {
        synchronized (this) {
            if (iFollowAndFansSelectedTabObserver != null) {
                this.b.add(iFollowAndFansSelectedTabObserver);
            }
        }
    }

    public void b(int i) {
        synchronized (this) {
            for (IFollowAndFansSelectedTabObserver iFollowAndFansSelectedTabObserver : this.b) {
                if (iFollowAndFansSelectedTabObserver != null) {
                    iFollowAndFansSelectedTabObserver.b(i);
                }
            }
        }
    }

    public void b(IFollowAndFansSelectedTabObserver iFollowAndFansSelectedTabObserver) {
        synchronized (this) {
            if (iFollowAndFansSelectedTabObserver != null) {
                this.b.remove(iFollowAndFansSelectedTabObserver);
            }
        }
    }
}
