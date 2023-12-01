package com.soft.blued.ui.find.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/PeopleDataObserver.class */
public class PeopleDataObserver {

    /* renamed from: a  reason: collision with root package name */
    private static PeopleDataObserver f30627a = new PeopleDataObserver();
    private ArrayList<IFriendsDataRefreshObserver> b = new ArrayList<>();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/PeopleDataObserver$IFriendsDataRefreshObserver.class */
    public interface IFriendsDataRefreshObserver {
        void ac_();

        void ad_();
    }

    private PeopleDataObserver() {
    }

    public static PeopleDataObserver a() {
        return f30627a;
    }

    public void a(IFriendsDataRefreshObserver iFriendsDataRefreshObserver) {
        synchronized (this) {
            if (iFriendsDataRefreshObserver != null) {
                this.b.add(iFriendsDataRefreshObserver);
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<IFriendsDataRefreshObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IFriendsDataRefreshObserver next = it.next();
                if (next != null) {
                    next.ac_();
                }
            }
        }
    }

    public void b(IFriendsDataRefreshObserver iFriendsDataRefreshObserver) {
        synchronized (this) {
            if (iFriendsDataRefreshObserver != null) {
                this.b.remove(iFriendsDataRefreshObserver);
            }
        }
    }

    public void c() {
        synchronized (this) {
            Iterator<IFriendsDataRefreshObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IFriendsDataRefreshObserver next = it.next();
                if (next != null) {
                    next.ad_();
                }
            }
        }
    }
}
