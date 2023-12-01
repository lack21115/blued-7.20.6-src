package com.soft.blued.ui.photo.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/observer/PhotoListPositionObserver.class */
public class PhotoListPositionObserver {

    /* renamed from: a  reason: collision with root package name */
    private static PhotoListPositionObserver f19427a = new PhotoListPositionObserver();
    private ArrayList<IPhotoListPositionObserver> b = new ArrayList<>();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/observer/PhotoListPositionObserver$IPhotoListPositionObserver.class */
    public interface IPhotoListPositionObserver {
        void a(int i);
    }

    private PhotoListPositionObserver() {
    }

    public static PhotoListPositionObserver a() {
        return f19427a;
    }

    public void a(int i) {
        synchronized (this) {
            Iterator<IPhotoListPositionObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPhotoListPositionObserver next = it.next();
                if (next != null) {
                    next.a(i);
                }
            }
        }
    }

    public void a(IPhotoListPositionObserver iPhotoListPositionObserver) {
        synchronized (this) {
            if (iPhotoListPositionObserver != null) {
                this.b.add(iPhotoListPositionObserver);
            }
        }
    }

    public void b(IPhotoListPositionObserver iPhotoListPositionObserver) {
        synchronized (this) {
            if (iPhotoListPositionObserver != null) {
                this.b.remove(iPhotoListPositionObserver);
            }
        }
    }
}
