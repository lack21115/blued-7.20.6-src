package a.a.a.a.a.k.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import com.cdo.oaps.ad.OapsWrapper;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/d/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static Context f1361a;
    public f b;

    /* renamed from: c  reason: collision with root package name */
    public Object f1362c;
    public boolean d;
    public BroadcastReceiver e;
    public BroadcastReceiver f;

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/d/d$a.class */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("pldroid-qos-filter".equals(intent.getAction())) {
                d.this.a(intent);
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/d/d$b.class */
    public class b extends BroadcastReceiver {

        /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/d/d$b$a.class */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.b.e();
            }
        }

        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                AsyncTask.execute(new a());
            }
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/k/d/d$c.class */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final d f1366a = new d(null);
    }

    public d() {
        this.f1362c = new Object();
        this.d = false;
        this.e = new a();
        this.f = new b();
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d a() {
        return c.f1366a;
    }

    public void a(Context context) {
        synchronized (this.f1362c) {
            if (this.d || context == null) {
                return;
            }
            f1361a = context.getApplicationContext();
            f fVar = new f();
            this.b = fVar;
            fVar.a(context);
            a.a.a.a.a.k.a.a().a(this.e, new IntentFilter("pldroid-qos-filter"));
            f1361a.registerReceiver(this.f, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.d = true;
        }
    }

    public final boolean a(Intent intent) {
        int intExtra = intent.getIntExtra("pldroid-qos-msg-type", -1);
        if (intExtra == 4) {
            this.b.d().a(intent.getStringExtra("scheme"), intent.getStringExtra("domain"), intent.getStringExtra("remoteIp"), intent.getStringExtra(OapsWrapper.KEY_PATH), intent.getStringExtra("reqid"));
            this.b.f();
            a.a.a.a.a.k.c.a.f();
            return true;
        }
        switch (intExtra) {
            case 161:
                b(intent);
                return true;
            case 162:
                this.b.f();
                return true;
            case 163:
                this.b.a(intent);
                return true;
            case 164:
                this.b.b(intent);
                return true;
            default:
                return true;
        }
    }

    public void b(Context context) {
        synchronized (this.f1362c) {
            if (f1361a != null && this.d) {
                f1361a.unregisterReceiver(this.f);
                f1361a = null;
                a.a.a.a.a.k.a.a().a(this.e);
                this.b.c();
                this.d = false;
            }
        }
    }

    public final void b(Intent intent) {
        long longExtra = intent.getLongExtra("beginAt", 0L);
        long longExtra2 = intent.getLongExtra("endAt", 0L);
        int intExtra = intent.getIntExtra("videoSourceFps", 0);
        int longExtra3 = (int) intent.getLongExtra("dropVideoFrameNum", 0L);
        int intExtra2 = intent.getIntExtra("audioSourceFps", 0);
        int longExtra4 = (int) intent.getLongExtra("dropAudioFrameNum", 0L);
        int i = (int) (longExtra2 - longExtra);
        this.b.g().a(longExtra, longExtra2, intExtra, longExtra3, intExtra2, i == 0 ? intExtra : intExtra - ((longExtra3 * 1000) / i), i == 0 ? intExtra2 : intExtra2 - ((longExtra4 * 1000) / i), intent.getIntExtra("sentVideoFps", 0), (int) intent.getLongExtra("video_buffer_dropped_frames", 0L), intent.getIntExtra("sentAudioFps", 0), intent.getIntExtra("audioBitrate", 0), intent.getIntExtra("videoBitrate", 0), intent.getIntExtra("videoFilterTime", 0));
        this.b.h();
    }
}
