package com.soft.blued.ui.photo.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/observer/AlbumDownLoadObserver.class */
public class AlbumDownLoadObserver {

    /* renamed from: a  reason: collision with root package name */
    private static AlbumDownLoadObserver f33117a = new AlbumDownLoadObserver();
    private ArrayList<IAlbumDownLoadObserver> b = new ArrayList<>();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/observer/AlbumDownLoadObserver$IAlbumDownLoadObserver.class */
    public interface IAlbumDownLoadObserver {
        void a();
    }

    private AlbumDownLoadObserver() {
    }

    public static AlbumDownLoadObserver a() {
        return f33117a;
    }

    public void a(IAlbumDownLoadObserver iAlbumDownLoadObserver) {
        synchronized (this) {
            if (iAlbumDownLoadObserver != null) {
                this.b.add(iAlbumDownLoadObserver);
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<IAlbumDownLoadObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IAlbumDownLoadObserver next = it.next();
                if (next != null) {
                    next.a();
                }
            }
        }
    }

    public void b(IAlbumDownLoadObserver iAlbumDownLoadObserver) {
        synchronized (this) {
            if (iAlbumDownLoadObserver != null) {
                this.b.remove(iAlbumDownLoadObserver);
            }
        }
    }
}
