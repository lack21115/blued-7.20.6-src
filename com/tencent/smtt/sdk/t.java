package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import com.tencent.smtt.export.external.DexLoader;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/t.class */
class t extends FrameLayout implements MediaPlayer.OnErrorListener {

    /* renamed from: a  reason: collision with root package name */
    private Object f38885a;
    private v b;

    /* renamed from: c  reason: collision with root package name */
    private VideoView f38886c;
    private Context d;
    private String e;

    public t(Context context) {
        super(context.getApplicationContext());
        this.d = null;
        this.d = context;
    }

    private void b(Bundle bundle, Object obj) {
        boolean z;
        a();
        if (b()) {
            bundle.putInt("callMode", bundle.getInt("callMode"));
            z = this.b.a(this.f38885a, bundle, this, obj);
        } else {
            z = false;
        }
        if (z) {
            return;
        }
        VideoView videoView = this.f38886c;
        if (videoView != null) {
            videoView.stopPlayback();
        }
        if (this.f38886c == null) {
            this.f38886c = new VideoView(getContext());
        }
        String string = bundle.getString("videoUrl");
        this.e = string;
        this.f38886c.setVideoURI(Uri.parse(string));
        this.f38886c.setOnErrorListener(this);
        Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
        intent.addFlags(268435456);
        Context applicationContext = getContext().getApplicationContext();
        intent.setPackage(applicationContext.getPackageName());
        applicationContext.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        setBackgroundColor(-16777216);
        if (this.b == null) {
            f.a(true).a(getContext().getApplicationContext(), false, false);
            u a2 = f.a(true).a();
            DexLoader dexLoader = null;
            if (a2 != null) {
                dexLoader = a2.b();
            }
            if (dexLoader != null && QbSdk.canLoadVideo(getContext())) {
                this.b = new v(dexLoader);
            }
        }
        v vVar = this.b;
        if (vVar == null || this.f38885a != null) {
            return;
        }
        this.f38885a = vVar.a(getContext().getApplicationContext());
    }

    public void a(Activity activity) {
        VideoView videoView;
        if (b() || (videoView = this.f38886c) == null) {
            return;
        }
        if (videoView.getParent() == null) {
            Window window = activity.getWindow();
            FrameLayout frameLayout = (FrameLayout) window.getDecorView();
            window.addFlags(1024);
            window.addFlags(128);
            frameLayout.setBackgroundColor(-16777216);
            MediaController mediaController = new MediaController(activity);
            mediaController.setMediaPlayer(this.f38886c);
            this.f38886c.setMediaController(mediaController);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            frameLayout.addView(this.f38886c, layoutParams);
        }
        if (Build.VERSION.SDK_INT >= 8) {
            this.f38886c.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Activity activity, int i) {
        VideoView videoView;
        VideoView videoView2;
        if (i == 3 && !b() && (videoView2 = this.f38886c) != null) {
            videoView2.pause();
        }
        if (i == 4) {
            this.d = null;
            if (!b() && (videoView = this.f38886c) != null) {
                videoView.stopPlayback();
                this.f38886c = null;
            }
        }
        if (i == 2 && !b()) {
            this.d = activity;
            a(activity);
        }
        if (b()) {
            this.b.a(this.f38885a, activity, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Bundle bundle, Object obj) {
        b(bundle, obj);
    }

    public boolean b() {
        return (this.b == null || this.f38885a == null) ? false : true;
    }

    public void c() {
        if (b()) {
            this.b.a(this.f38885a);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            if (this.d instanceof Activity) {
                Activity activity = (Activity) this.d;
                if (!activity.isFinishing()) {
                    activity.finish();
                }
            }
            Context context = getContext();
            if (context != null) {
                Toast.makeText(context, "播放失败，请选择其它播放器播放", 1).show();
                Context applicationContext = context.getApplicationContext();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setDataAndType(Uri.parse(this.e), "video/*");
                applicationContext.startActivity(intent);
                return true;
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
