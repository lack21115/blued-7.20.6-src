package com.blued.android.module.live_china.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.live_china.R;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveMusicFloatView.class */
public class LiveMusicFloatView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f14687a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private View f14688c;
    private TextView d;
    private View e;
    private ImageView f;
    private ObjectAnimator g;
    private LiveMusicModel h;

    public LiveMusicFloatView(Context context) {
        super(context);
        this.h = new LiveMusicModel();
        this.f14687a = context;
        d();
    }

    public LiveMusicFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = new LiveMusicModel();
        this.f14687a = context;
        d();
    }

    private void d() {
        LayoutInflater from = LayoutInflater.from(this.f14687a);
        this.b = from;
        View inflate = from.inflate(R.layout.live_music_float_view, (ViewGroup) this, true);
        this.f14688c = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.tv_music_name);
        this.d = textView;
        textView.setSingleLine(true);
        this.d.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.d.setHorizontallyScrolling(true);
        this.d.setMarqueeRepeatLimit(-1);
        this.d.requestFocus();
        this.d.setSelected(true);
        this.e = this.f14688c.findViewById(R.id.fl_music_avatar);
        this.f = (ImageView) this.f14688c.findViewById(R.id.iv_music_avatar);
    }

    private void e() {
        if (this.g == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.e, "rotation", 0.0f, 360.0f);
            this.g = ofFloat;
            ofFloat.setDuration(10000L);
            this.g.setInterpolator(new LinearInterpolator());
            this.g.setRepeatCount(-1);
            this.g.setRepeatMode(1);
            this.g.start();
        }
    }

    public void a() {
        c();
        setVisibility(8);
    }

    public void b() {
        c();
    }

    public void c() {
        ObjectAnimator objectAnimator = this.g;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.g = null;
        }
        this.e.animate().rotation(0.0f).setDuration(60L).start();
    }

    public void setData(LiveMusicModel liveMusicModel) {
        if (this.h == null) {
            return;
        }
        this.h = liveMusicModel;
        if (TextUtils.isEmpty(liveMusicModel.name)) {
            this.d.setText(getResources().getString(R.string.live_music_no_name));
        } else {
            this.d.setText(this.h.name);
        }
        ImageLoader.a((IRequestHost) null, this.h.cover).c().a(this.f);
        setPlaying(true);
    }

    public void setPlaying(boolean z) {
        e();
        if (z) {
            if (Build.VERSION.SDK_INT >= 19) {
                this.g.resume();
            } else {
                this.g.start();
            }
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.g.pause();
        } else {
            this.g.cancel();
        }
    }
}
