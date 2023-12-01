package a.a.a.a.a.l;

import a.a.a.a.a.e.e;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.qiniu.pili.droid.streaming.ScreenCaptureSessionListener;
import com.qiniu.pili.droid.streaming.screen.ScreenCaptureRequestActivity;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/l/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f1391a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f1392c;
    public VirtualDisplay d;
    public MediaProjection e;
    public c f;
    public ScreenCaptureSessionListener g;
    public int h;
    public Intent i;
    public int j;
    public int k;
    public int l;
    public Surface m;
    public final Handler n = new Handler(Looper.getMainLooper());
    public Runnable o = new RunnableC0017a();
    public BroadcastReceiver p = new b();

    /* renamed from: a.a.a.a.a.l.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/l/a$a.class */
    public class RunnableC0017a implements Runnable {
        public RunnableC0017a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.n.postDelayed(a.this.o, 10L);
            if (a.this.f != null) {
                a.this.f.a(false);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/l/a$b.class */
    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            e.g.c("ScreenCapturer", "receive broadcase handle screen capturer");
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
            a.this.h = intent.getIntExtra(ScreenCaptureRequestActivity.KEY_RESULT_CODE, 0);
            a.this.i = (Intent) intent.getParcelableExtra(ScreenCaptureRequestActivity.KEY_RESULT_DATA);
            a aVar = a.this;
            aVar.b = aVar.h == -1;
            if (a.this.f != null) {
                a.this.f.b(a.this.b);
            }
            a.this.f1392c = false;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/l/a$c.class */
    public interface c {
        void a(boolean z);

        void b(boolean z);
    }

    public static a a() {
        e.g.c("ScreenCapturer", "get screenCapturer instance");
        if (f1391a == null) {
            f1391a = new a();
        }
        return f1391a;
    }

    public void a(c cVar) {
        e eVar = e.g;
        StringBuilder sb = new StringBuilder();
        sb.append("setOnScreenCaptureListener ");
        sb.append(cVar != null);
        eVar.c("ScreenCapturer", sb.toString());
        this.f = cVar;
    }

    public void a(Context context, c cVar) {
        if (this.f1392c || this.b) {
            if (this.b && cVar != null) {
                e.f1313c.d("ScreenCapturer", "already inited");
                cVar.b(true);
            }
            e.f1313c.d("ScreenCapturer", "initing or inited");
            return;
        }
        this.f1392c = true;
        this.f = cVar;
        LocalBroadcastManager.getInstance(context).registerReceiver(this.p, new IntentFilter(ScreenCaptureRequestActivity.ACTION_REQUEST_SCREEN_CAPTURE_RESULT));
        ScreenCaptureSessionListener screenCaptureSessionListener = this.g;
        if (screenCaptureSessionListener == null || !screenCaptureSessionListener.onRequestScreenCapture(ScreenCaptureRequestActivity.ACTION_REQUEST_SCREEN_CAPTURE_RESULT, ScreenCaptureRequestActivity.KEY_RESULT_CODE, ScreenCaptureRequestActivity.KEY_RESULT_DATA)) {
            Intent intent = new Intent(context, ScreenCaptureRequestActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
        e.f1313c.c("ScreenCapturer", "init to request permission for screen capturer");
    }

    public void a(ScreenCaptureSessionListener screenCaptureSessionListener) {
        this.g = screenCaptureSessionListener;
    }

    public boolean a(Context context, int i, int i2, int i3, Surface surface) {
        if (this.d != null && this.e != null) {
            if (this.j == i && this.k == i2 && this.l == i3 && this.m == surface) {
                e.f1313c.d("ScreenCapturer", "Capturing is ongoing!!!");
                return false;
            }
            e.f1313c.d("ScreenCapturer", "Stopping the previous capturing...");
            b();
        }
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = surface;
        MediaProjection mediaProjection = ((MediaProjectionManager) context.getSystemService(Context.MEDIA_PROJECTION_SERVICE)).getMediaProjection(this.h, this.i);
        this.e = mediaProjection;
        if (mediaProjection == null) {
            e.g.d("ScreenCapturer", "Get MediaProjection failed");
            return false;
        }
        this.d = mediaProjection.createVirtualDisplay("ScreenCapturer-display", i, i2, i3, 16, surface, (VirtualDisplay.Callback) null, (Handler) null);
        this.n.post(this.o);
        e eVar = e.f1313c;
        eVar.c("ScreenCapturer", "Capturing for width:" + i + " height:" + i2 + " dpi:" + i3);
        return true;
    }

    public void b() {
        e.g.c("ScreenCapturer", "stopCapturing");
        this.n.removeCallbacks(this.o);
        VirtualDisplay virtualDisplay = this.d;
        if (virtualDisplay != null) {
            virtualDisplay.release();
            this.d = null;
        }
        MediaProjection mediaProjection = this.e;
        if (mediaProjection != null) {
            mediaProjection.stop();
            this.e = null;
        }
        c cVar = this.f;
        if (cVar != null) {
            cVar.a(true);
            this.f = null;
        }
    }
}
