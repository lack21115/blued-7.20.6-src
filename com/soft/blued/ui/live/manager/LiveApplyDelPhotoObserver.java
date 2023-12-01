package com.soft.blued.ui.live.manager;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/manager/LiveApplyDelPhotoObserver.class */
public class LiveApplyDelPhotoObserver {

    /* renamed from: a  reason: collision with root package name */
    private static LiveApplyDelPhotoObserver f31242a = new LiveApplyDelPhotoObserver();
    private ArrayList<IDelPhotoObserver> b = new ArrayList<>();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/manager/LiveApplyDelPhotoObserver$IDelPhotoObserver.class */
    public interface IDelPhotoObserver {
        void a();
    }

    private LiveApplyDelPhotoObserver() {
    }

    public static LiveApplyDelPhotoObserver a() {
        return f31242a;
    }

    public void a(IDelPhotoObserver iDelPhotoObserver) {
        synchronized (this) {
            if (iDelPhotoObserver != null) {
                this.b.add(iDelPhotoObserver);
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<IDelPhotoObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IDelPhotoObserver next = it.next();
                if (next != null) {
                    next.a();
                }
            }
        }
    }

    public void b(IDelPhotoObserver iDelPhotoObserver) {
        synchronized (this) {
            if (iDelPhotoObserver != null) {
                this.b.remove(iDelPhotoObserver);
            }
        }
    }
}
