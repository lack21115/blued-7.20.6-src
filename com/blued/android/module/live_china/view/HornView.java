package com.blued.android.module.live_china.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.model.LiveHornModel;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.ScrollTextView;
import com.blued.das.live.LiveProtos;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/HornView.class */
public class HornView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f14310a;
    private LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private View f14311c;
    private ScrollTextView d;
    private View e;
    private ScrollTextView f;
    private List<LiveHornModel> g;
    private boolean h;

    public HornView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new ArrayList();
        this.f14310a = context;
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final LiveHornModel liveHornModel) {
        Animation loadAnimation = AnimationUtils.loadAnimation(AppInfo.d(), R.anim.hornview_in_from_right);
        loadAnimation.setDuration(500L);
        final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.HornView.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.HornView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HornView.this.d.a();
                    }
                }, 4000L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.d.setOnScrollListener(new ScrollTextView.OnScrollListener() { // from class: com.blued.android.module.live_china.view.HornView.3
            @Override // com.blued.android.module.live_china.view.ScrollTextView.OnScrollListener
            public void a() {
                HornView.this.g.remove(liveHornModel);
                if (HornView.this.g.size() <= 0) {
                    HornView.this.d.setVisibility(4);
                    HornView.this.f14311c.startAnimation(alphaAnimation);
                    return;
                }
                LiveHornModel liveHornModel2 = (LiveHornModel) HornView.this.g.get(0);
                HornView.this.setScrollText(liveHornModel2);
                if (liveHornModel2.type == 1) {
                    HornView.this.a(liveHornModel2);
                } else if (liveHornModel2.type == 2) {
                    HornView.this.d.setVisibility(4);
                    HornView.this.f14311c.startAnimation(alphaAnimation);
                }
            }
        });
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.HornView.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                HornView.this.f14311c.setVisibility(4);
                HornView.this.h = false;
                HornView.this.a();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.d.startAnimation(loadAnimation);
        this.d.setVisibility(0);
    }

    private void b() {
        LayoutInflater from = LayoutInflater.from(this.f14310a);
        this.b = from;
        View inflate = from.inflate(R.layout.live_horn_layout, (ViewGroup) this, true);
        this.f14311c = inflate.findViewById(R.id.big_horn_layout);
        this.d = (ScrollTextView) inflate.findViewById(R.id.big_horn_text);
        this.e = inflate.findViewById(R.id.small_horn_layout);
        this.f = (ScrollTextView) inflate.findViewById(R.id.small_horn_text);
        this.f14311c.setVisibility(4);
        this.d.setVisibility(4);
        this.e.setVisibility(4);
        this.f.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final LiveHornModel liveHornModel) {
        Animation loadAnimation = AnimationUtils.loadAnimation(AppInfo.d(), R.anim.hornview_in_from_right);
        loadAnimation.setDuration(500L);
        final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(500L);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.HornView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.HornView.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        HornView.this.f.a();
                    }
                }, 4000L);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.f.setOnScrollListener(new ScrollTextView.OnScrollListener() { // from class: com.blued.android.module.live_china.view.HornView.6
            @Override // com.blued.android.module.live_china.view.ScrollTextView.OnScrollListener
            public void a() {
                HornView.this.g.remove(liveHornModel);
                if (HornView.this.g.size() <= 0) {
                    HornView.this.f.setVisibility(4);
                    HornView.this.e.startAnimation(alphaAnimation);
                    return;
                }
                LiveHornModel liveHornModel2 = (LiveHornModel) HornView.this.g.get(0);
                HornView.this.setScrollText(liveHornModel2);
                if (liveHornModel2.type == 1) {
                    HornView.this.f.setVisibility(4);
                    HornView.this.e.startAnimation(alphaAnimation);
                } else if (liveHornModel2.type == 2) {
                    HornView.this.b(liveHornModel2);
                }
            }
        });
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.HornView.7
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                HornView.this.e.setVisibility(4);
                HornView.this.h = false;
                HornView.this.a();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.f.startAnimation(loadAnimation);
        this.f.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollText(LiveHornModel liveHornModel) {
        if (liveHornModel.type == 1) {
            this.d.a(liveHornModel);
        } else if (liveHornModel.type == 2) {
            this.f.a(liveHornModel);
        }
    }

    public void a() {
        if (this.g.size() <= 0 || this.h) {
            return;
        }
        this.h = true;
        final LiveHornModel liveHornModel = this.g.get(0);
        setScrollText(liveHornModel);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500L);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.HornView.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (liveHornModel.type == 1) {
                    HornView.this.a(liveHornModel);
                } else if (liveHornModel.type == 2) {
                    HornView.this.b(liveHornModel);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        if (liveHornModel.type == 1) {
            this.f14311c.setVisibility(0);
            this.f14311c.startAnimation(alphaAnimation);
        } else if (liveHornModel.type == 2) {
            this.e.setVisibility(0);
            this.e.startAnimation(alphaAnimation);
        }
        if (liveHornModel.is_win_streak) {
            if (liveHornModel.type == 1) {
                EventTrackLive.a(LiveProtos.Event.LIVE_PK_WIN_SYSTEM_BROADCAST_SHOW, liveHornModel.lid, liveHornModel.uid);
            } else if (liveHornModel.type == 2) {
                EventTrackLive.a(LiveProtos.Event.LIVE_PK_WIN_LIVE_BROADCAST_SHOW, liveHornModel.lid, liveHornModel.uid);
            }
        }
        if (liveHornModel.type == 1) {
            EventTrackLive.a(LiveProtos.Event.LIVE_HORN_SHOW, liveHornModel.lid, liveHornModel.uid);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
