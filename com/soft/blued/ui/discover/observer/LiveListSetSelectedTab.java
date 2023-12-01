package com.soft.blued.ui.discover.observer;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/observer/LiveListSetSelectedTab.class */
public class LiveListSetSelectedTab {

    /* renamed from: a  reason: collision with root package name */
    private static LiveListSetSelectedTab f29845a = new LiveListSetSelectedTab();
    private List<iLiveListSetSelectedTab> b = new ArrayList();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/discover/observer/LiveListSetSelectedTab$iLiveListSetSelectedTab.class */
    public interface iLiveListSetSelectedTab {
        void a(int i);
    }

    public static LiveListSetSelectedTab a() {
        return f29845a;
    }

    public void a(int i) {
        synchronized (this) {
            for (iLiveListSetSelectedTab ilivelistsetselectedtab : this.b) {
                if (ilivelistsetselectedtab != null) {
                    ilivelistsetselectedtab.a(i);
                }
            }
        }
    }

    public void a(iLiveListSetSelectedTab ilivelistsetselectedtab) {
        synchronized (this) {
            if (ilivelistsetselectedtab != null) {
                this.b.add(ilivelistsetselectedtab);
            }
        }
    }

    public void b(iLiveListSetSelectedTab ilivelistsetselectedtab) {
        synchronized (this) {
            if (ilivelistsetselectedtab != null) {
                this.b.remove(ilivelistsetselectedtab);
            }
        }
    }
}
