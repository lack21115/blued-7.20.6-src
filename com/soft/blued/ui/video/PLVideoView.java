package com.soft.blued.ui.video;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.VideoView;
import com.soft.blued.R;
import com.soft.blued.utils.Logger;
import java.lang.ref.WeakReference;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/PLVideoView.class */
public class PLVideoView extends LinearLayout implements PLViewInterface {
    public static WeakReference<PLVideoView> b;

    /* renamed from: a  reason: collision with root package name */
    public String f20732a;

    /* renamed from: c  reason: collision with root package name */
    private Context f20733c;
    private LayoutInflater d;
    private View e;
    private VideoView f;

    /* renamed from: com.soft.blued.ui.video.PLVideoView$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/PLVideoView$1.class */
    class AnonymousClass1 implements MediaPlayer.OnCompletionListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PLVideoView f20734a;

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            this.f20734a.a();
            Logger.b(this.f20734a.f20732a, "onCompletion:");
        }
    }

    public PLVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20732a = "PLVideoView";
        this.f20733c = context;
        b();
    }

    private void b() {
        LayoutInflater from = LayoutInflater.from(this.f20733c);
        this.d = from;
        View inflate = from.inflate(R.layout.pl_video_view, this);
        this.e = inflate;
        this.f = (VideoView) inflate.findViewById(R.id.pl_surface);
    }

    public void a() {
        Logger.b(this.f20732a, "start");
        VideoView videoView = this.f;
        if (videoView != null) {
            videoView.start();
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    public void setAutoPlay(boolean z) {
    }

    public void setPauseDrop(boolean z) {
    }

    public void setVolumeProgress(int i) {
    }
}
