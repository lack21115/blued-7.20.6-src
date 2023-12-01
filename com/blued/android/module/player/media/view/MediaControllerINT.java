package com.blued.android.module.player.media.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.blued.android.module.player.media.R;
import com.bytedance.applog.tracker.Tracker;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/view/MediaControllerINT.class */
public class MediaControllerINT extends RelativeLayout {
    public long a;
    public long b;
    private final SimpleDateFormat c;
    private SeekBar d;
    private TextView e;
    private TextView f;
    private long g;
    private ImageView h;
    private AbBaseVideoView i;
    private View.OnClickListener j;
    private SeekBar.OnSeekBarChangeListener k;

    public MediaControllerINT(Context context) {
        super(context);
        this.c = new SimpleDateFormat("mm:ss");
        this.a = 0L;
        this.b = 0L;
        this.j = new View.OnClickListener() { // from class: com.blued.android.module.player.media.view.MediaControllerINT.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                MediaControllerINT.this.a();
            }
        };
        this.k = new SeekBar.OnSeekBarChangeListener() { // from class: com.blued.android.module.player.media.view.MediaControllerINT.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    MediaControllerINT.this.a(seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                Tracker.onStopTrackingTouch(seekBar);
                MediaControllerINT.this.b(seekBar.getProgress());
            }
        };
        a(context);
    }

    public MediaControllerINT(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = new SimpleDateFormat("mm:ss");
        this.a = 0L;
        this.b = 0L;
        this.j = new View.OnClickListener() { // from class: com.blued.android.module.player.media.view.MediaControllerINT.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                MediaControllerINT.this.a();
            }
        };
        this.k = new SeekBar.OnSeekBarChangeListener() { // from class: com.blued.android.module.player.media.view.MediaControllerINT.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z) {
                    MediaControllerINT.this.a(seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                Tracker.onStopTrackingTouch(seekBar);
                MediaControllerINT.this.b(seekBar.getProgress());
            }
        };
        a(context);
    }

    public MediaControllerINT(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new SimpleDateFormat("mm:ss");
        this.a = 0L;
        this.b = 0L;
        this.j = new View.OnClickListener() { // from class: com.blued.android.module.player.media.view.MediaControllerINT.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                MediaControllerINT.this.a();
            }
        };
        this.k = new SeekBar.OnSeekBarChangeListener() { // from class: com.blued.android.module.player.media.view.MediaControllerINT.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
                if (z) {
                    MediaControllerINT.this.a(seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                Tracker.onStopTrackingTouch(seekBar);
                MediaControllerINT.this.b(seekBar.getProgress());
            }
        };
        a(context);
    }

    public MediaControllerINT(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.c = new SimpleDateFormat("mm:ss");
        this.a = 0L;
        this.b = 0L;
        this.j = new View.OnClickListener() { // from class: com.blued.android.module.player.media.view.MediaControllerINT.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                MediaControllerINT.this.a();
            }
        };
        this.k = new SeekBar.OnSeekBarChangeListener() { // from class: com.blued.android.module.player.media.view.MediaControllerINT.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i22, boolean z) {
                if (z) {
                    MediaControllerINT.this.a(seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                Tracker.onStopTrackingTouch(seekBar);
                MediaControllerINT.this.b(seekBar.getProgress());
            }
        };
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        AbBaseVideoView abBaseVideoView = this.i;
        if (abBaseVideoView == null) {
            return;
        }
        if (abBaseVideoView.e()) {
            this.i.d();
        } else {
            this.i.b();
        }
        b();
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.media_controller_int, this);
        this.d = (SeekBar) findViewById(R.id.seek_bar_view);
        this.e = (TextView) findViewById(R.id.tv_seek_cur);
        this.f = (TextView) findViewById(R.id.tv_seek_total);
        ImageView imageView = (ImageView) findViewById(R.id.player);
        this.h = imageView;
        if (imageView != null) {
            imageView.requestFocus();
            this.h.setOnClickListener(this.j);
        }
        this.d.setMax(1000);
        this.d.setOnSeekBarChangeListener(this.k);
    }

    private void b() {
        AbBaseVideoView abBaseVideoView;
        if (this.h == null || (abBaseVideoView = this.i) == null) {
            return;
        }
        if (abBaseVideoView.e()) {
            this.h.setImageResource(R.drawable.video_international_controller_pause_icon);
        } else {
            this.h.setImageResource(R.drawable.video_international_controller_play_icon);
        }
    }

    public void a(int i) {
        long j = this.b;
        b(((float) j) * (i / 1000.0f), j, i);
    }

    public void a(long j, long j2) {
        this.a = j;
        this.b = j2;
        SeekBar seekBar = this.d;
        if (seekBar == null || seekBar.getVisibility() != 0 || j2 <= 0) {
            return;
        }
        long j3 = (((float) j) / ((float) j2)) * 1000.0f;
        long j4 = this.g;
        long j5 = j3;
        if (j4 > j3) {
            j5 = j3;
            if (j4 != 1000) {
                j5 = j3;
                if (j4 > 900) {
                    j5 = 1000;
                }
            }
        }
        this.d.setProgress((int) j5);
        this.e.setText(this.c.format(new Date(this.a)));
        this.f.setText(this.c.format(new Date(this.b)));
        this.g = j5;
    }

    public void a(long j, long j2, int i) {
        this.e.setText(this.c.format(new Date(j)));
        this.f.setText(this.c.format(new Date(j2)));
        AbBaseVideoView abBaseVideoView = this.i;
        if (abBaseVideoView != null) {
            abBaseVideoView.a(j);
        }
    }

    public void b(int i) {
        long j = this.b;
        a(((float) j) * (i / 1000.0f), j, i);
    }

    public void b(long j, long j2, int i) {
        this.e.setText(this.c.format(new Date(j)));
        this.f.setText(this.c.format(new Date(j2)));
        if (this.e.getVisibility() != 0) {
            this.e.setVisibility(0);
        }
        if (this.f.getVisibility() != 0) {
            this.f.setVisibility(0);
        }
        this.d.setProgress(i);
    }

    public void setAncherView(AbBaseVideoView abBaseVideoView) {
        this.i = abBaseVideoView;
    }
}
