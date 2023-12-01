package com.soft.blued.ui.video;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.module.common.view.CircleProgressView;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.photo.fragment.BasePhotoFragment;
import com.soft.blued.ui.video.TextureVideoView;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.VideoLoadController;
import java.lang.ref.WeakReference;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/SuperVideoView.class */
public class SuperVideoView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public static WeakReference<SuperVideoView> f34436a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f34437c;
    private View d;
    private ImageView e;
    private TextureVideoView f;
    private ImageView g;
    private TextView h;
    private CircleProgressView i;
    private LoadOptions j;
    private String k;
    private VideoLoadController.IVideoController l;

    /* renamed from: com.soft.blued.ui.video.SuperVideoView$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/SuperVideoView$1.class */
    class AnonymousClass1 implements VideoLoadController.IVideoController {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SuperVideoView f34438a;

        @Override // com.soft.blued.utils.VideoLoadController.IVideoController
        public void a(String str) {
            this.f34438a.g.setImageResource(R.drawable.video_failed_icon);
            this.f34438a.g.setVisibility(0);
            this.f34438a.e.setVisibility(0);
            this.f34438a.i.setVisibility(8);
            Logger.a("ddrb", "onDownloadFailed");
        }

        @Override // com.soft.blued.utils.VideoLoadController.IVideoController
        public void a(String str, int i) {
            this.f34438a.i.setVisibility(0);
            this.f34438a.g.setImageResource(2131233691);
            this.f34438a.g.setVisibility(8);
            this.f34438a.i.c();
            this.f34438a.i.a(i, 100L);
        }

        @Override // com.soft.blued.utils.VideoLoadController.IVideoController
        public void a(String str, String str2) {
            this.f34438a.f.a(str2);
            this.f34438a.i.d();
            Logger.a("ddrb", "onDownloadFinish end");
        }
    }

    /* renamed from: com.soft.blued.ui.video.SuperVideoView$2  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/SuperVideoView$2.class */
    class AnonymousClass2 implements TextureVideoView.OnStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f34439a;
        final /* synthetic */ SuperVideoView b;

        @Override // com.soft.blued.ui.video.TextureVideoView.OnStateChangeListener
        public void a() {
            Logger.a("ddrb", "onSurfaceTextureDestroyed");
            this.b.f.b();
            this.b.i.setVisibility(8);
            this.b.e.setVisibility(0);
            this.b.g.setImageResource(2131233691);
            this.b.g.setVisibility(0);
            VideoLoadController.b(this.b.k, this.b.l);
        }

        @Override // com.soft.blued.ui.video.TextureVideoView.OnStateChangeListener
        public void a(int i, int i2) {
            if (i2 > 0) {
                this.b.i.setVisibility(8);
                this.b.e.setVisibility(8);
                this.b.g.setVisibility(8);
            }
            Logger.a("ddrb", "progress = ", Integer.valueOf(i2));
        }

        @Override // com.soft.blued.ui.video.TextureVideoView.OnStateChangeListener
        public void b() {
            Logger.a("ddrb", "onPlaying");
            this.b.i.setVisibility(8);
            this.b.e.setVisibility(8);
            this.b.g.setVisibility(8);
        }

        @Override // com.soft.blued.ui.video.TextureVideoView.OnStateChangeListener
        public void c() {
            this.b.i.d();
            this.b.e.setVisibility(0);
            this.b.g.setVisibility(8);
            Logger.a("ddrb", "onBuffering");
        }

        @Override // com.soft.blued.ui.video.TextureVideoView.OnStateChangeListener
        public void d() {
            AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.video.SuperVideoView.2.1
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass2.this.b.i.setVisibility(8);
                    AnonymousClass2.this.b.e.setVisibility(0);
                    AnonymousClass2.this.b.g.setVisibility(0);
                    Logger.a("ddrb", "onStop");
                }
            });
        }

        @Override // com.soft.blued.ui.video.TextureVideoView.OnStateChangeListener
        public void e() {
            Logger.a("ddrb", "onError");
            this.b.g.setImageResource(R.drawable.video_failed_icon);
            this.b.g.setVisibility(0);
            this.b.e.setVisibility(0);
            this.b.i.setVisibility(8);
            VideoLoadController.b(this.f34439a[1]);
        }
    }

    /* renamed from: com.soft.blued.ui.video.SuperVideoView$3  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/SuperVideoView$3.class */
    class AnonymousClass3 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f34441a;
        final /* synthetic */ VideoLoadController.IVideoController b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SuperVideoView f34442c;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            Logger.a("ddrb", "android.os.Build.VERSION.SDK_INT = ", Integer.valueOf(Build.VERSION.SDK_INT));
            if (SuperVideoView.f34436a == null) {
                SuperVideoView.f34436a = new WeakReference<>(this.f34442c);
            } else {
                SuperVideoView superVideoView = SuperVideoView.f34436a.get();
                if (superVideoView != null && !this.f34442c.equals(superVideoView)) {
                    superVideoView.a();
                    superVideoView.b();
                }
                SuperVideoView.f34436a = new WeakReference<>(this.f34442c);
            }
            this.f34442c.i.setVisibility(0);
            this.f34442c.g.setImageResource(2131233691);
            this.f34442c.g.setVisibility(8);
            VideoLoadController.a(this.f34441a[1], this.b);
            VideoLoadController.a(this.f34441a[1]);
            Logger.a("ddrb", "loadVideo urls[0] = ", this.f34441a[0]);
            Logger.a("ddrb", "loadVideo urls[1] = ", this.f34441a[1]);
            this.f34442c.k = this.f34441a[1];
            this.f34442c.l = this.b;
        }
    }

    /* renamed from: com.soft.blued.ui.video.SuperVideoView$4  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/SuperVideoView$4.class */
    class AnonymousClass4 implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f34443a;
        final /* synthetic */ String b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f34444c;
        final /* synthetic */ int d;
        final /* synthetic */ int e;
        final /* synthetic */ SuperVideoView f;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            Context context = this.f.b;
            String[] strArr = this.f34443a;
            BasePhotoFragment.a(context, strArr[0], strArr[1], this.b, this.f34444c, this.d, this.e, 0L);
        }
    }

    public SuperVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public SuperVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.b = context;
        LoadOptions loadOptions = new LoadOptions();
        this.j = loadOptions;
        loadOptions.j = true;
        this.j.l = false;
        this.j.d = 2131231620;
        this.j.b = 2131231620;
    }

    public void a() {
        this.f.b();
    }

    public void b() {
        this.e.setVisibility(0);
        this.i.setVisibility(8);
        this.g.setImageResource(2131233691);
        this.g.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        VideoLoadController.b(this.k, this.l);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater from = LayoutInflater.from(this.b);
        this.f34437c = from;
        View inflate = from.inflate(R.layout.video_view, (ViewGroup) null);
        this.d = inflate;
        this.e = (ImageView) inflate.findViewById(2131368940);
        this.f = (TextureVideoView) this.d.findViewById(R.id.textureview);
        this.g = (ImageView) this.d.findViewById(2131373089);
        this.h = (TextView) this.d.findViewById(R.id.video_state_text);
        this.i = (CircleProgressView) this.d.findViewById(R.id.progressbar);
        addView(this.d);
    }
}
