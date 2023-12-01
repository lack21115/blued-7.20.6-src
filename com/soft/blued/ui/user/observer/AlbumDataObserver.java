package com.soft.blued.ui.user.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/observer/AlbumDataObserver.class */
public class AlbumDataObserver {

    /* renamed from: a  reason: collision with root package name */
    private static AlbumDataObserver f20549a = new AlbumDataObserver();
    private ArrayList<IAlbumObserver> b = new ArrayList<>();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/observer/AlbumDataObserver$IAlbumObserver.class */
    public interface IAlbumObserver {
        void a(boolean z, String str);
    }

    private AlbumDataObserver() {
    }

    public static AlbumDataObserver a() {
        return f20549a;
    }

    public void a(IAlbumObserver iAlbumObserver) {
        synchronized (this) {
            if (iAlbumObserver != null) {
                this.b.add(iAlbumObserver);
            }
        }
    }

    public void a(boolean z, String str) {
        synchronized (this) {
            Iterator<IAlbumObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IAlbumObserver next = it.next();
                if (next != null) {
                    next.a(z, str);
                }
            }
        }
    }

    public void b(IAlbumObserver iAlbumObserver) {
        synchronized (this) {
            if (iAlbumObserver != null) {
                this.b.remove(iAlbumObserver);
            }
        }
    }
}
