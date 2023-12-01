package com.soft.blued.ui.qr_scan;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.expressad.d.a.b;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseActivity;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.permission.PermissionCallbacks;
import com.blued.android.framework.qrcode.ImageReader;
import com.blued.android.framework.qrcode.camera.CameraManager;
import com.blued.android.framework.qrcode.decoding.CaptureActivityHandler;
import com.blued.android.framework.qrcode.decoding.InactivityTimer;
import com.blued.android.framework.qrcode.decoding.OnCaptureHandlerListener;
import com.blued.android.framework.urlroute.BluedUrlUtils;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.utils.PermissionUtils;
import com.bytedance.applog.tracker.Tracker;
import com.google.common.base.Charsets;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.soft.blued.R;
import com.soft.blued.ui.feed.fragment.PhotoSelectFragment;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.fragment.UserQrFragment;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Vector;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/qr_scan/CaptureActivity.class */
public class CaptureActivity extends BaseActivity implements SurfaceHolder.Callback, OnCaptureHandlerListener {
    private CaptureActivityHandler f;
    private ImageView g;
    private boolean h;
    private Vector<BarcodeFormat> i;
    private String j;
    private InactivityTimer k;
    private MediaPlayer l;
    private boolean m;
    private boolean n;
    private String o;
    private RelativeLayout p;
    private ImageView r;
    private Rect q = null;
    boolean e = true;
    private final MediaPlayer.OnCompletionListener s = new MediaPlayer.OnCompletionListener() { // from class: com.soft.blued.ui.qr_scan.CaptureActivity.6
        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo(0);
        }
    };

    private void a(SurfaceHolder surfaceHolder) {
        try {
            CameraManager.a().a(surfaceHolder);
            e();
            if (this.f == null) {
                this.f = new CaptureActivityHandler(this, this.i, this.j);
            }
        } catch (IOException | RuntimeException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(String str) {
        if (!StringUtils.h(str)) {
            Bundle bundle = new Bundle();
            bundle.putString(ScanResultFragment.f19439a, str);
            TerminalActivity.d(this, ScanResultFragment.class, bundle);
        } else if (str.contains(BluedHttpUrl.a())) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(ScanLoginFragment.f19434a, str);
            TerminalActivity.d(this, ScanLoginFragment.class, bundle2);
        } else {
            if (str.contains("https://app.blued.cn/user") || str.contains("https://common.blued.com/user")) {
                Map a2 = BluedUrlUtils.a(str);
                String str2 = null;
                if (a2 != null) {
                    str2 = (String) a2.get("id");
                }
                String str3 = str2;
                if (!TextUtils.isEmpty(str2)) {
                    str3 = EncryptTool.a(str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    UserInfoFragmentNew.a((Context) this, str3, "");
                    return;
                }
            }
            WebViewShowInfoFragment.show(this, str, 7);
        }
    }

    private String b(String str) {
        try {
            if (Charset.forName("ISO-8859-1").newEncoder().canEncode(str)) {
                str = new String(str.getBytes(Charsets.ISO_8859_1), "GB2312");
                try {
                    Logger.b("1234      ISO8859-1", str);
                    return str;
                } catch (UnsupportedEncodingException e) {
                    e = e;
                }
            } else {
                try {
                    Logger.b("1234      stringExtra", str);
                    return str;
                } catch (UnsupportedEncodingException e2) {
                    e = e2;
                }
            }
        } catch (UnsupportedEncodingException e3) {
            e = e3;
            str = "";
        }
        e.printStackTrace();
        return str;
    }

    private void d() {
        findViewById(R.id.mo_scanner_back).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.qr_scan.CaptureActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CaptureActivity.this.finish();
            }
        });
        findViewById(R.id.mo_scanner_photo).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.qr_scan.CaptureActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CaptureActivity.this.f();
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.mo_scanner_light);
        this.g = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.qr_scan.CaptureActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                CaptureActivity.this.c();
            }
        });
        findViewById(R.id.my_qrcode).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.qr_scan.CaptureActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                TerminalActivity.d(CaptureActivity.this, UserQrFragment.class, (Bundle) null);
            }
        });
        this.p = (RelativeLayout) findViewById(R.id.capture_crop_view);
        this.r = (ImageView) findViewById(R.id.capture_scan_line);
    }

    private void e() {
        int i = CameraManager.a().c().y;
        int i2 = CameraManager.a().c().x;
        int[] iArr = new int[2];
        this.p.getLocationInWindow(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        int width = this.p.getWidth();
        int height = this.p.getHeight();
        Display defaultDisplay = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width2 = defaultDisplay.getWidth();
        int height2 = defaultDisplay.getHeight();
        int i5 = (i3 * i) / width2;
        int i6 = (i4 * i2) / height2;
        this.q = new Rect(i5, i6, ((width * i) / width2) + i5, ((height * i2) / height2) + i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void f() {
        PhotoSelectFragment.a((Context) this, 6, 6, false);
    }

    private void g() {
        if (this.m && this.l == null) {
            setVolumeControlStream(3);
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.l = mediaPlayer;
            mediaPlayer.setAudioStreamType(3);
            this.l.setOnCompletionListener(this.s);
            AssetFileDescriptor openRawResourceFd = getResources().openRawResourceFd(R.raw.mo_scanner_beep);
            try {
                this.l.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                this.l.setVolume(0.1f, 0.1f);
                this.l.prepare();
            } catch (IOException e) {
                this.l = null;
            }
        }
    }

    private void h() {
        MediaPlayer mediaPlayer;
        if (this.m && (mediaPlayer = this.l) != null) {
            mediaPlayer.start();
        }
        if (this.n) {
            ((Vibrator) getSystemService(Context.VIBRATOR_SERVICE)).vibrate(200L);
        }
    }

    @Override // com.blued.android.framework.qrcode.decoding.OnCaptureHandlerListener
    public void a(int i, Intent intent) {
        setResult(i, intent);
        finish();
    }

    @Override // com.blued.android.framework.qrcode.decoding.OnCaptureHandlerListener
    public void a(Intent intent) {
        startActivity(intent);
    }

    @Override // com.blued.android.framework.qrcode.decoding.OnCaptureHandlerListener
    public void a(Result result, Bitmap bitmap) {
        this.k.a();
        h();
        a(b(result.toString()));
        finish();
    }

    @Override // com.blued.android.framework.qrcode.decoding.OnCaptureHandlerListener
    public Rect ap_() {
        return this.q;
    }

    @Override // com.blued.android.framework.qrcode.decoding.OnCaptureHandlerListener
    public Handler aq_() {
        return this.f;
    }

    protected void c() {
        if (this.e) {
            this.e = false;
            CameraManager.a().f();
            this.g.setImageResource(R.drawable.icon_scan_flashlight_on);
            return;
        }
        this.e = true;
        CameraManager.a().g();
        this.g.setImageResource(R.drawable.icon_scan_flashlight_off);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 6 && intent != null) {
            String stringExtra = intent.getStringExtra("photo_path");
            this.o = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            new ImageReader().a(this.o, new ImageReader.OnReadFinishListener() { // from class: com.soft.blued.ui.qr_scan.CaptureActivity.5
                @Override // com.blued.android.framework.qrcode.ImageReader.OnReadFinishListener
                public void a(String str, String str2) {
                    if (TextUtils.isEmpty(str2)) {
                        AppMethods.d((int) R.string.scan_fail);
                        return;
                    }
                    CaptureActivity.this.a(str2);
                    CaptureActivity.this.finish();
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StatusBarHelper.a(this, false);
        setContentView(R.layout.mo_scanner_main);
        CameraManager.a(getApplication());
        d();
        this.h = false;
        this.k = new InactivityTimer(this);
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, -1.0f, 2, 0.2f);
        translateAnimation.setDuration(b.aC);
        translateAnimation.setRepeatCount(-1);
        translateAnimation.setRepeatMode(1);
        this.r.startAnimation(translateAnimation);
        PermissionUtils.b((PermissionCallbacks) null);
    }

    public void onDestroy() {
        this.k.b();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        CaptureActivityHandler captureActivityHandler = this.f;
        if (captureActivityHandler != null) {
            captureActivityHandler.a();
            this.f = null;
        }
        CameraManager.a().b();
    }

    public void onResume() {
        super.onResume();
        SurfaceHolder holder = ((SurfaceView) findViewById(R.id.mo_scanner_preview_view)).getHolder();
        if (this.h) {
            a(holder);
        } else {
            holder.addCallback(this);
            holder.setType(3);
        }
        this.i = null;
        this.j = null;
        this.m = true;
        if (((AudioManager) getSystemService("audio")).getRingerMode() != 2) {
            this.m = false;
        }
        g();
        this.n = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (this.h) {
            return;
        }
        this.h = true;
        a(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.h = false;
    }
}
