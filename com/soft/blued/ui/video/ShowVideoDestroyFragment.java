package com.soft.blued.ui.video;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.module.common.utils.ActivityChangeAnimationUtils;
import com.blued.android.module.common.view.CircleProgressView;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.video.SurfaceVideoView;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.VideoLoadController;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/ShowVideoDestroyFragment.class */
public class ShowVideoDestroyFragment extends BaseFragment {

    /* renamed from: a  reason: collision with root package name */
    final Handler f20735a = new Handler();
    Runnable b = new Runnable() { // from class: com.soft.blued.ui.video.ShowVideoDestroyFragment.5
        @Override // java.lang.Runnable
        public void run() {
            try {
                MediaPlayer mediaPlayer = ShowVideoDestroyFragment.this.f.getMediaPlayer();
                if (!mediaPlayer.isPlaying()) {
                    ShowVideoDestroyFragment.this.o.setProgress(mediaPlayer.getDuration());
                    ShowVideoDestroyFragment.this.a(true);
                    return;
                }
                ShowVideoDestroyFragment.this.o.setProgress(mediaPlayer.getCurrentPosition());
                ShowVideoDestroyFragment.this.f20735a.postDelayed(this, 100L);
            } catch (IllegalStateException e) {
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private Context f20736c;
    private View d;
    private LayoutInflater e;
    private SurfaceVideoView f;
    private ImageView g;
    private CircleProgressView h;
    private String i;
    private VideoLoadController.IVideoController j;
    private LinearLayout k;
    private TextView l;
    private TextView m;
    private LinearLayout n;
    private ProgressBar o;
    private ProgressBar p;
    private int q;
    private boolean r;
    private short s;
    private long t;
    private long u;

    public static void a(BaseFragment baseFragment, short s, long j, long j2, String str, int i, int i2) {
        LiveFloatManager.a().l();
        Bundle bundle = new Bundle();
        bundle.putShort("passby_session_type", s);
        bundle.putLong("passby_session_id", j);
        bundle.putLong("PASSBY_MSG_ID", j2);
        bundle.putInt("msg_burn_after_reading_position", i);
        bundle.putString("video_path", str);
        TerminalActivity.a(baseFragment, ShowVideoDestroyFragment.class, bundle, i2);
        ActivityChangeAnimationUtils.i(baseFragment.getActivity());
    }

    private void b() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.s = arguments.getShort("passby_session_type");
            this.t = arguments.getLong("passby_session_id");
            this.u = arguments.getLong("PASSBY_MSG_ID");
            this.i = arguments.getString("video_path");
            this.q = arguments.getInt("msg_burn_after_reading_position", -1);
        }
        this.r = false;
    }

    private void c() {
        this.e = LayoutInflater.from(this.f20736c);
        View findViewById = this.d.findViewById(2131370507);
        this.f = (SurfaceVideoView) findViewById.findViewById(R.id.textureview);
        this.g = (ImageView) findViewById.findViewById(2131373089);
        this.h = findViewById.findViewById(R.id.progressbar);
        this.k = (LinearLayout) this.d.findViewById(2131369468);
        this.l = (TextView) this.d.findViewById(R.id.first_text);
        this.m = (TextView) this.d.findViewById(R.id.second_text);
        this.n = (LinearLayout) this.d.findViewById(R.id.video_layout);
        this.o = (ProgressBar) this.d.findViewById(R.id.video_progress);
        this.p = (ProgressBar) this.d.findViewById(R.id.loading_view);
        this.h.setVisibility(8);
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.video.ShowVideoDestroyFragment.1
            @Override // java.lang.Runnable
            public void run() {
                ShowVideoDestroyFragment.this.h.setVisibility(0);
                ShowVideoDestroyFragment.this.a();
            }
        }, 500L);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.video.ShowVideoDestroyFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                LiveFloatManager.a().k();
                ShowVideoDestroyFragment.this.getActivity().finish();
            }
        });
    }

    public void a() {
        VideoLoadController.a(this.i);
        this.h.setVisibility(0);
        this.g.setVisibility(8);
        VideoLoadController.a(this.i, new VideoLoadController.IVideoController() { // from class: com.soft.blued.ui.video.ShowVideoDestroyFragment.3
            @Override // com.soft.blued.utils.VideoLoadController.IVideoController
            public void a(String str) {
                ShowVideoDestroyFragment.this.g.setImageResource(R.drawable.video_failed_icon);
                ShowVideoDestroyFragment.this.g.setVisibility(0);
                ShowVideoDestroyFragment.this.h.setVisibility(8);
                ShowVideoDestroyFragment.this.p.setVisibility(8);
                AppMethods.a(AppInfo.d().getResources().getString(2131891037));
                ShowVideoDestroyFragment.this.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.video.ShowVideoDestroyFragment.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ShowVideoDestroyFragment.this.a(false);
                    }
                }, 1000L);
            }

            @Override // com.soft.blued.utils.VideoLoadController.IVideoController
            public void a(String str, int i) {
                ShowVideoDestroyFragment.this.h.setVisibility(0);
                ShowVideoDestroyFragment.this.p.setVisibility(0);
                ShowVideoDestroyFragment.this.g.setVisibility(8);
                ShowVideoDestroyFragment.this.h.c();
                ShowVideoDestroyFragment.this.h.a(i, 100L);
                Logger.a("ddrb", "onDownloading = ", Integer.valueOf(i));
            }

            @Override // com.soft.blued.utils.VideoLoadController.IVideoController
            public void a(String str, final String str2) {
                ShowVideoDestroyFragment.this.h.d();
                ShowVideoDestroyFragment.this.l.setVisibility(0);
                ShowVideoDestroyFragment.this.m.setVisibility(0);
                ShowVideoDestroyFragment.this.p.setVisibility(8);
                ShowVideoDestroyFragment.this.k.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.video.ShowVideoDestroyFragment.3.1
                    @Override // android.view.View.OnTouchListener
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            ShowVideoDestroyFragment.this.n.setVisibility(0);
                            ShowVideoDestroyFragment.this.f.a(str2, false);
                            ShowVideoDestroyFragment.this.r = true;
                            return true;
                        } else if (action == 1) {
                            ShowVideoDestroyFragment.this.a(true);
                            return true;
                        } else if (action != 3) {
                            return true;
                        } else {
                            ShowVideoDestroyFragment.this.a(true);
                            return true;
                        }
                    }
                });
            }
        });
        this.f.setOnStateChangeListener(new SurfaceVideoView.OnStateChangeListener() { // from class: com.soft.blued.ui.video.ShowVideoDestroyFragment.4
            @Override // com.soft.blued.ui.video.SurfaceVideoView.OnStateChangeListener
            public void a() {
                Logger.a("ddrb", "onSurfaceTextureDestroyed");
                ShowVideoDestroyFragment.this.f.b();
                ShowVideoDestroyFragment.this.h.setVisibility(0);
                ShowVideoDestroyFragment.this.g.setVisibility(8);
                VideoLoadController.b(ShowVideoDestroyFragment.this.i, ShowVideoDestroyFragment.this.j);
            }

            @Override // com.soft.blued.ui.video.SurfaceVideoView.OnStateChangeListener
            public void a(int i, int i2) {
                Logger.a("ddrb", "max = ", Integer.valueOf(i), "--", "progress = ", Integer.valueOf(i2));
            }

            @Override // com.soft.blued.ui.video.SurfaceVideoView.OnStateChangeListener
            public void b() {
                ShowVideoDestroyFragment.this.h.setVisibility(8);
                ShowVideoDestroyFragment.this.g.setVisibility(8);
                ShowVideoDestroyFragment.this.o.setMax(ShowVideoDestroyFragment.this.f.getMediaPlayer().getDuration());
                ShowVideoDestroyFragment.this.f20735a.post(ShowVideoDestroyFragment.this.b);
            }

            @Override // com.soft.blued.ui.video.SurfaceVideoView.OnStateChangeListener
            public void c() {
                ShowVideoDestroyFragment.this.h.d();
                ShowVideoDestroyFragment.this.g.setVisibility(8);
                Logger.a("ddrb", "onBuffering");
            }

            @Override // com.soft.blued.ui.video.SurfaceVideoView.OnStateChangeListener
            public void d() {
                ShowVideoDestroyFragment.this.postSafeRunOnUiThread(new Runnable() { // from class: com.soft.blued.ui.video.ShowVideoDestroyFragment.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ShowVideoDestroyFragment.this.h.setVisibility(8);
                        ShowVideoDestroyFragment.this.g.setVisibility(0);
                    }
                });
            }

            @Override // com.soft.blued.ui.video.SurfaceVideoView.OnStateChangeListener
            public void e() {
                Logger.a("ddrb", "onError---");
                ShowVideoDestroyFragment.this.g.setImageResource(R.drawable.video_failed_icon);
                ShowVideoDestroyFragment.this.g.setVisibility(0);
                ShowVideoDestroyFragment.this.h.setVisibility(8);
            }
        });
    }

    public void a(boolean z) {
        if (getActivity() != null) {
            ActivityChangeAnimationUtils.j(getActivity());
            if (z) {
                ChatManager.getInstance().sendReadReceipt(this.s, this.t, this.u);
                Intent intent = new Intent();
                intent.putExtra("msg_burn_after_reading_position", this.q);
                getActivity().setResult(-1, intent);
            }
            getActivity().finish();
        }
    }

    public boolean onBackPressed() {
        LiveFloatManager.a().k();
        a(this.r);
        return super.onBackPressed();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20736c = getActivity();
        getActivity().getWindow().addFlags(8192);
        View view = this.d;
        if (view == null) {
            this.d = layoutInflater.inflate(R.layout.fragment_show_video_destroy, viewGroup, false);
            b();
            c();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.d.getParent()).removeView(this.d);
        }
        return this.d;
    }
}
