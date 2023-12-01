package com.tencent.liteav.txcvodplayer.renderer;

import android.view.Surface;
import android.view.View;
import com.tencent.liteav.txcplayer.ITXVCubePlayer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/a.class */
public interface a {

    /* renamed from: com.tencent.liteav.txcvodplayer.renderer.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/a$a.class */
    public interface InterfaceC0765a {
        void a(b bVar);

        void a(b bVar, int i, int i2);

        void b(b bVar);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/txcvodplayer/renderer/a$b.class */
    public interface b {
        a a();

        void a(ITXVCubePlayer iTXVCubePlayer);

        Surface b();

        Surface c();
    }

    void a(int i, int i2);

    void a(InterfaceC0765a interfaceC0765a);

    boolean a();

    void b(int i, int i2);

    void b(InterfaceC0765a interfaceC0765a);

    View getView();

    void setAspectRatio(int i);

    void setVideoRotation(int i);
}
