package im.zego.internal.screencapture;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.bytedance.applog.tracker.Tracker;
import com.zego.zegoavkit2.screencapture.ZegoScreenCaptureFactory;

/* loaded from: source-8829756-dex2jar.jar:im/zego/internal/screencapture/ZegoScreenCaptureManager.class */
public class ZegoScreenCaptureManager {

    /* renamed from: a  reason: collision with root package name */
    private static final ZegoScreenCaptureManager f42238a = new ZegoScreenCaptureManager();
    private ZegoScreenCaptureService b;

    /* renamed from: c  reason: collision with root package name */
    private Context f42239c;
    private ZegoScreenCaptureFactory d;
    private Display e;
    private IZegoScreenCaptureManagerEventHandler f;
    private int g = -1;
    private int h = -1;

    /* renamed from: im.zego.internal.screencapture.ZegoScreenCaptureManager$1  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:im/zego/internal/screencapture/ZegoScreenCaptureManager$1.class */
    class AnonymousClass1 implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZegoScreenCaptureManager f42240a;

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Intent intent = new Intent(this.f42240a.f42239c, ZegoScreenCaptureAssistantActivity.class);
            intent.addFlags(268435456);
            this.f42240a.f42239c.startActivity(intent);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            this.f42240a.b = null;
        }
    }

    /* renamed from: im.zego.internal.screencapture.ZegoScreenCaptureManager$2  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:im/zego/internal/screencapture/ZegoScreenCaptureManager$2.class */
    class AnonymousClass2 implements ComponentCallbacks {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ZegoScreenCaptureManager f42241a;

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
            int rotation = this.f42241a.e.getRotation();
            if (rotation == this.f42241a.g) {
                return;
            }
            this.f42241a.g = rotation;
            this.f42241a.b();
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:im/zego/internal/screencapture/ZegoScreenCaptureManager$ZegoScreenCaptureAssistantActivity.class */
    public static class ZegoScreenCaptureAssistantActivity extends Activity {

        /* renamed from: a  reason: collision with root package name */
        private MediaProjectionManager f42242a;

        @Override // android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            Tracker.dispatchTouchEvent(motionEvent);
            return super.dispatchTouchEvent(motionEvent);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.app.Activity
        public void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (i == 1001 && i2 == -1) {
                ZegoScreenCaptureManager.f42238a.a(this.f42242a.getMediaProjection(i2, intent));
            } else {
                ZegoScreenCaptureManager.f42238a.f.a(-2);
            }
            finish();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.app.Activity
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            requestWindowFeature(1);
            MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getSystemService(Context.MEDIA_PROJECTION_SERVICE);
            this.f42242a = mediaProjectionManager;
            startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 1001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MediaProjection mediaProjection) {
        ZegoScreenCaptureFactory zegoScreenCaptureFactory = this.d;
        if (zegoScreenCaptureFactory != null) {
            zegoScreenCaptureFactory.setMediaProjection(mediaProjection);
            return;
        }
        IZegoScreenCaptureManagerEventHandler iZegoScreenCaptureManagerEventHandler = f42238a.f;
        if (iZegoScreenCaptureManagerEventHandler != null) {
            iZegoScreenCaptureManagerEventHandler.a(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (this.e == null) {
            this.e = ((WindowManager) this.f42239c.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        }
        this.e.getRealMetrics(displayMetrics);
        setCaptureResolution(displayMetrics.widthPixels, displayMetrics.heightPixels, this.h);
    }

    private static native void setCaptureResolution(int i, int i2, int i3);
}
