package pl.droidsonroids.gif;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/GifRenderingExecutor.class */
final class GifRenderingExecutor extends ScheduledThreadPoolExecutor {

    /* loaded from: source-3503164-dex2jar.jar:pl/droidsonroids/gif/GifRenderingExecutor$InstanceHolder.class */
    static final class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        private static final GifRenderingExecutor f44142a = new GifRenderingExecutor();

        private InstanceHolder() {
        }
    }

    private GifRenderingExecutor() {
        super(1, new ThreadPoolExecutor.DiscardPolicy());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GifRenderingExecutor a() {
        return InstanceHolder.f44142a;
    }
}
