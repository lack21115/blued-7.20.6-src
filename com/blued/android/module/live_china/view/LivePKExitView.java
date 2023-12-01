package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.CustomDialog;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LivePKPlayerModel;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LivePKExitView.class */
public class LivePKExitView extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f14719a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private View f14720c;
    private View d;
    private View e;
    private View f;
    private TextView g;
    private TextView h;
    private TextView i;
    private ImageView j;
    private ImageView k;
    private List<LivePKPlayerModel> l;

    public LivePKExitView(Context context) {
        this(context, null);
    }

    public LivePKExitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LivePKExitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14719a = context;
        d();
    }

    private void b(final ILiveConnectionAnimListener iLiveConnectionAnimListener) {
        if (this.d.getVisibility() == 8) {
            return;
        }
        this.d.setVisibility(8);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f14719a, R.anim.push_bottom_out);
        this.d.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LivePKExitView.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                ILiveConnectionAnimListener iLiveConnectionAnimListener2 = iLiveConnectionAnimListener;
                if (iLiveConnectionAnimListener2 != null) {
                    iLiveConnectionAnimListener2.onAnimationEnd();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    private void d() {
        LayoutInflater from = LayoutInflater.from(this.f14719a);
        this.b = from;
        View inflate = from.inflate(R.layout.live_pking_exit, this);
        this.f14720c = inflate;
        this.d = inflate.findViewById(R.id.content_layout);
        this.e = this.f14720c.findViewById(R.id.live_pk_invite_layer);
        this.g = (TextView) this.f14720c.findViewById(R.id.tv_tip);
        this.h = (TextView) this.f14720c.findViewById(R.id.tv_left);
        this.i = (TextView) this.f14720c.findViewById(R.id.tv_right);
        this.j = (ImageView) this.f14720c.findViewById(R.id.iv_left);
        this.k = (ImageView) this.f14720c.findViewById(R.id.iv_right);
        this.f = this.f14720c.findViewById(R.id.live_invite_cancel);
        this.e.setOnClickListener(this);
        this.f.setOnClickListener(this);
    }

    private void e() {
        List<LivePKPlayerModel> list = this.l;
        if (list == null || list.size() < 2) {
            return;
        }
        int i = 0;
        for (LivePKPlayerModel livePKPlayerModel : this.l) {
            if (livePKPlayerModel != null) {
                if (i == 0) {
                    this.h.setText(livePKPlayerModel.name);
                    ImageLoader.a((IRequestHost) null, livePKPlayerModel.avatar).b(R.drawable.user_bg_round).c().a(this.j);
                } else if (i == 1) {
                    this.i.setText(livePKPlayerModel.name);
                    ImageLoader.a((IRequestHost) null, livePKPlayerModel.avatar).b(R.drawable.user_bg_round).c().a(this.k);
                }
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Logger.b("pk", "stopPK --------------");
    }

    public void a() {
        a((ILiveConnectionAnimListener) null);
    }

    public void a(int i) {
        LiveRoomHttpUtils.d(new BluedUIHttpResponse() { // from class: com.blued.android.module.live_china.view.LivePKExitView.6
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
            }
        }, i);
    }

    public void a(ILiveConnectionAnimListener iLiveConnectionAnimListener) {
        if (b()) {
            b(new ILiveConnectionAnimListener() { // from class: com.blued.android.module.live_china.view.LivePKExitView.2
                @Override // com.blued.android.module.live_china.view.ILiveConnectionAnimListener
                public void onAnimationEnd() {
                    LivePKExitView.this.setVisibility(8);
                }
            });
        } else {
            setVisibility(8);
        }
        if (iLiveConnectionAnimListener != null) {
            iLiveConnectionAnimListener.onAnimationEnd();
        }
    }

    public void a(List<LivePKPlayerModel> list) {
        this.l = list;
        setVisibility(0);
        this.d.setVisibility(0);
        this.d.clearAnimation();
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f14719a, R.anim.push_bottom_in);
        this.d.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.LivePKExitView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        e();
    }

    public boolean b() {
        return getVisibility() == 0;
    }

    public void c() {
        View inflate = LayoutInflater.from(this.f14719a).inflate(R.layout.live_exit_pk_tips, (ViewGroup) null);
        final CustomDialog customDialog = new CustomDialog(this.f14719a);
        customDialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
        customDialog.a(inflate, null);
        TextView textView = (TextView) inflate.findViewById(R.id.tips_message);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tips_confirm);
        textView.setText(R.string.live_pk_exit_confirm_tip);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LivePKExitView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                customDialog.dismiss();
                LivePKExitView.this.a(0);
                LivePKExitView.this.f();
                LivePKExitView.this.a((ILiveConnectionAnimListener) null);
            }
        });
        ((TextView) inflate.findViewById(R.id.tips_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LivePKExitView.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                customDialog.dismiss();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_invite_cancel) {
            c();
        } else if (view.getId() == R.id.live_pk_invite_layer) {
            a((ILiveConnectionAnimListener) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
