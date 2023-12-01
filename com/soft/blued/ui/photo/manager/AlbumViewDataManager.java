package com.soft.blued.ui.photo.manager;

import com.blued.community.model.AlbumFlow;
import com.soft.blued.ui.feed.observer.AlbumViewObserver;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/manager/AlbumViewDataManager.class */
public class AlbumViewDataManager {

    /* renamed from: a  reason: collision with root package name */
    private static AlbumViewDataManager f33115a = new AlbumViewDataManager();
    private IAlbumDataListener b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f33116c;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/photo/manager/AlbumViewDataManager$IAlbumDataListener.class */
    public interface IAlbumDataListener {
        void a();

        void a(boolean z, List<AlbumFlow> list);
    }

    private AlbumViewDataManager() {
    }

    public static AlbumViewDataManager a() {
        return f33115a;
    }

    public void a(IAlbumDataListener iAlbumDataListener) {
        this.b = iAlbumDataListener;
    }

    public void a(boolean z) {
        this.f33116c = z;
    }

    public void a(boolean z, List<AlbumFlow> list) {
        this.f33116c = z;
        IAlbumDataListener iAlbumDataListener = this.b;
        if (iAlbumDataListener != null) {
            iAlbumDataListener.a(z, list);
        }
    }

    public void b() {
        this.b = null;
    }

    public void c() {
        IAlbumDataListener iAlbumDataListener = this.b;
        if (iAlbumDataListener != null) {
            iAlbumDataListener.a();
        }
    }

    public boolean d() {
        return this.f33116c;
    }

    public void e() {
        AlbumViewObserver.a().b();
    }
}
