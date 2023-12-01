package a.a.a.a.a.a.h;

import android.view.Surface;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/h/h.class */
public class h extends e {
    public Surface g;
    public boolean h;

    public h(d dVar, Surface surface, boolean z) {
        super(dVar);
        a(surface);
        this.g = surface;
        this.h = z;
    }

    public void g() {
        c();
        Surface surface = this.g;
        if (surface != null) {
            if (this.h) {
                surface.release();
            }
            this.g = null;
        }
    }
}
