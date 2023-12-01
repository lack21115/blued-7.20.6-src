package com.soft.blued.ui.find.observer;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/NearbyFindSetSelectedTab.class */
public class NearbyFindSetSelectedTab {

    /* renamed from: a  reason: collision with root package name */
    private static NearbyFindSetSelectedTab f30621a = new NearbyFindSetSelectedTab();
    private List<INearbyFindSetSelectedTab> b = new ArrayList();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/NearbyFindSetSelectedTab$INearbyFindSetSelectedTab.class */
    public interface INearbyFindSetSelectedTab {
        void a(int i);
    }

    public static NearbyFindSetSelectedTab a() {
        return f30621a;
    }

    public void a(int i) {
        synchronized (this) {
            for (INearbyFindSetSelectedTab iNearbyFindSetSelectedTab : this.b) {
                if (iNearbyFindSetSelectedTab != null) {
                    iNearbyFindSetSelectedTab.a(i);
                }
            }
        }
    }

    public void a(INearbyFindSetSelectedTab iNearbyFindSetSelectedTab) {
        synchronized (this) {
            if (iNearbyFindSetSelectedTab != null) {
                this.b.add(iNearbyFindSetSelectedTab);
            }
        }
    }

    public void b(INearbyFindSetSelectedTab iNearbyFindSetSelectedTab) {
        synchronized (this) {
            if (iNearbyFindSetSelectedTab != null) {
                this.b.remove(iNearbyFindSetSelectedTab);
            }
        }
    }
}
