package com.soft.blued.ui.user.observer;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/observer/UserinfoFeedScrollObserver.class */
public class UserinfoFeedScrollObserver {

    /* renamed from: a  reason: collision with root package name */
    private static UserinfoFeedScrollObserver f34245a = new UserinfoFeedScrollObserver();
    private ArrayList<IUserinFeedScrollObserver> b = new ArrayList<>();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/observer/UserinfoFeedScrollObserver$IUserinFeedScrollObserver.class */
    public interface IUserinFeedScrollObserver {
        void a(RecyclerView recyclerView, int i, int i2);
    }

    private UserinfoFeedScrollObserver() {
    }

    public static UserinfoFeedScrollObserver a() {
        return f34245a;
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        synchronized (this) {
            Iterator<IUserinFeedScrollObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IUserinFeedScrollObserver next = it.next();
                if (next != null) {
                    next.a(recyclerView, i, i2);
                }
            }
        }
    }

    public void a(IUserinFeedScrollObserver iUserinFeedScrollObserver) {
        synchronized (this) {
            if (iUserinFeedScrollObserver != null) {
                this.b.add(iUserinFeedScrollObserver);
            }
        }
    }

    public void b(IUserinFeedScrollObserver iUserinFeedScrollObserver) {
        synchronized (this) {
            if (iUserinFeedScrollObserver != null) {
                this.b.remove(iUserinFeedScrollObserver);
            }
        }
    }
}
