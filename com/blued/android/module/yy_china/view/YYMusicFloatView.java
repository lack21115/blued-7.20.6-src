package com.blued.android.module.yy_china.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.utils.ToastUtils;
import com.blued.android.module.live.base.music.model.LiveMusicModel;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMusicFloatView.class */
public class YYMusicFloatView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public LiveMusicModel f18333a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f18334c;
    private View d;
    private View e;
    private ImageView f;
    private ObjectAnimator g;

    public YYMusicFloatView(Context context) {
        super(context);
        this.f18333a = new LiveMusicModel();
        this.b = context;
        d();
    }

    public YYMusicFloatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18333a = new LiveMusicModel();
        this.b = context;
        d();
    }

    private void d() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.f18334c = from;
        View inflate = from.inflate(R.layout.view_yy_music_float, (ViewGroup) this, true);
        this.d = inflate;
        this.e = inflate.findViewById(R.id.fl_music_avatar);
        this.f = (ImageView) this.d.findViewById(R.id.iv_music_avatar);
        setVisibility(8);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYMusicFloatView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (!YYRoomInfoManager.e().i()) {
                    ToastUtils.a("上麦才能播放音乐！");
                } else if (YYRoomInfoManager.e().j() || YYRoomInfoManager.e().y()) {
                    LiveEventBus.get("show_music").post("");
                }
            }
        });
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
        this.f.setVisibility(8);
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
        if (this.f18333a == null) {
            return;
        }
        this.f18333a = liveMusicModel;
        this.f.setVisibility(0);
        ImageLoader.a((IRequestHost) null, this.f18333a.cover).c().a(this.f);
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

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }
}
