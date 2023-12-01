package com.soft.blued.ui.feed.observer;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/observer/AlbumViewObserver.class */
public class AlbumViewObserver {

    /* renamed from: a  reason: collision with root package name */
    private static AlbumViewObserver f16347a = new AlbumViewObserver();
    private List<IAblumViewObserver> b = new ArrayList();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/observer/AlbumViewObserver$IAblumViewObserver.class */
    public interface IAblumViewObserver {
        void a();
    }

    private AlbumViewObserver() {
    }

    public static AlbumViewObserver a() {
        return f16347a;
    }

    public void a(IAblumViewObserver iAblumViewObserver) {
        synchronized (this) {
            if (iAblumViewObserver != null) {
                this.b.add(iAblumViewObserver);
            }
        }
    }

    public void b() {
        synchronized (this) {
            for (IAblumViewObserver iAblumViewObserver : this.b) {
                if (iAblumViewObserver != null) {
                    iAblumViewObserver.a();
                }
            }
        }
    }

    public void b(IAblumViewObserver iAblumViewObserver) {
        synchronized (this) {
            if (iAblumViewObserver != null) {
                this.b.remove(iAblumViewObserver);
            }
        }
    }
}
