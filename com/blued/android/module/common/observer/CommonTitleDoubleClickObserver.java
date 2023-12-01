package com.blued.android.module.common.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/observer/CommonTitleDoubleClickObserver.class */
public class CommonTitleDoubleClickObserver {
    private static CommonTitleDoubleClickObserver a = new CommonTitleDoubleClickObserver();
    private ArrayList<ITitleClickObserver> b = new ArrayList<>();

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/observer/CommonTitleDoubleClickObserver$ITitleClickObserver.class */
    public interface ITitleClickObserver {
        void a();
    }

    private CommonTitleDoubleClickObserver() {
    }

    public static CommonTitleDoubleClickObserver a() {
        return a;
    }

    public void a(ITitleClickObserver iTitleClickObserver) {
        synchronized (this) {
            if (iTitleClickObserver != null) {
                this.b.add(iTitleClickObserver);
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<ITitleClickObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ITitleClickObserver next = it.next();
                if (next != null) {
                    next.a();
                }
            }
        }
    }

    public void b(ITitleClickObserver iTitleClickObserver) {
        synchronized (this) {
            if (iTitleClickObserver != null) {
                this.b.remove(iTitleClickObserver);
            }
        }
    }
}
