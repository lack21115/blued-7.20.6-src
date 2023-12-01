package com.blued.android.module.live_china.observer;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveTagsSetSelectedTab.class */
public class LiveTagsSetSelectedTab {
    private static LiveTagsSetSelectedTab a = new LiveTagsSetSelectedTab();
    private List<iLiveTagsSetSelectedTab> b = new ArrayList();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveTagsSetSelectedTab$iLiveTagsSetSelectedTab.class */
    public interface iLiveTagsSetSelectedTab {
        void b(String str);
    }

    public static LiveTagsSetSelectedTab a() {
        return a;
    }

    public void a(iLiveTagsSetSelectedTab ilivetagssetselectedtab) {
        synchronized (this) {
            if (ilivetagssetselectedtab != null) {
                this.b.add(ilivetagssetselectedtab);
            }
        }
    }

    public void a(String str) {
        synchronized (this) {
            for (iLiveTagsSetSelectedTab ilivetagssetselectedtab : this.b) {
                if (ilivetagssetselectedtab != null) {
                    ilivetagssetselectedtab.b(str);
                }
            }
        }
    }

    public void b(iLiveTagsSetSelectedTab ilivetagssetselectedtab) {
        synchronized (this) {
            if (ilivetagssetselectedtab != null) {
                this.b.remove(ilivetagssetselectedtab);
            }
        }
    }
}
