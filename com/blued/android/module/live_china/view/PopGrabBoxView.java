package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.GrabBoxDetailModel;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.InstantLog;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopGrabBoxView.class */
public class PopGrabBoxView {
    public View a;
    public View b;
    public Context c;
    public BaseFragment d;
    public LinearLayout e;
    public LinearLayout f;
    public LinearLayout g;
    private MyPopupWindow h;
    private String i;
    private String j;
    private IRequestHost k;
    private DismissLisnter l;
    private ImageView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private TextView r;
    private View s;
    private LinearLayout t;

    /* renamed from: com.blued.android.module.live_china.view.PopGrabBoxView$1  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopGrabBoxView$1.class */
    class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ PopGrabBoxView a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            this.a.b();
        }
    }

    /* renamed from: com.blued.android.module.live_china.view.PopGrabBoxView$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopGrabBoxView$2.class */
    class AnonymousClass2 implements View.OnClickListener {
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
        }
    }

    /* renamed from: com.blued.android.module.live_china.view.PopGrabBoxView$3  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopGrabBoxView$3.class */
    class AnonymousClass3 implements Animation.AnimationListener {
        final /* synthetic */ PopGrabBoxView a;

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.a.c();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopGrabBoxView$DismissLisnter.class */
    public interface DismissLisnter {
        void a();
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopGrabBoxView$MyPopupWindow.class */
    class MyPopupWindow extends PopupWindow {
        final /* synthetic */ PopGrabBoxView a;

        public void a() {
            super.dismiss();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            try {
                this.a.b();
            } catch (Exception e) {
                a();
            }
        }
    }

    public void a() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.a.startAnimation(alphaAnimation);
        this.b.startAnimation(AnimationUtils.loadAnimation(this.c, R.anim.push_bottom_out));
    }

    public void b() {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopGrabBoxView.4
            @Override // java.lang.Runnable
            public void run() {
                PopGrabBoxView.this.h.a();
                if (PopGrabBoxView.this.l != null) {
                    PopGrabBoxView.this.l.a();
                }
            }
        }, 320L);
        a();
        this.b.setVisibility(8);
    }

    public void c() {
        LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<GrabBoxDetailModel, GrabBoxDetailModel>>(this.k) { // from class: com.blued.android.module.live_china.view.PopGrabBoxView.5
            boolean a = false;

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                this.a = true;
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                PopGrabBoxView.this.e.setVisibility(8);
                PopGrabBoxView.this.t.setVisibility(0);
                if (this.a) {
                    this.a = false;
                    PopGrabBoxView.this.b();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<GrabBoxDetailModel, GrabBoxDetailModel> bluedEntity) {
                if (bluedEntity == null || bluedEntity.extra == null) {
                    return;
                }
                final GrabBoxDetailModel grabBoxDetailModel = bluedEntity.extra;
                ImageLoader.a(PopGrabBoxView.this.k, grabBoxDetailModel.start_image).a(PopGrabBoxView.this.m);
                PopGrabBoxView.this.q.setText(grabBoxDetailModel.name);
                PopGrabBoxView.this.r.setText(grabBoxDetailModel.comment);
                PopGrabBoxView.this.n.setText(grabBoxDetailModel.wish);
                PopGrabBoxView.this.o.setText(grabBoxDetailModel.top_wish);
                PopGrabBoxView.this.p.setText(CommonStringUtils.a(grabBoxDetailModel.total_wish));
                if (TextUtils.equals(LiveRoomInfo.a().f(), PopGrabBoxView.this.i)) {
                    PopGrabBoxView.this.s.setVisibility(8);
                    PopGrabBoxView.this.f.setPadding(PopGrabBoxView.this.f.getPaddingLeft(), DensityUtils.a(PopGrabBoxView.this.c, 14.0f), PopGrabBoxView.this.f.getPaddingRight(), DensityUtils.a(PopGrabBoxView.this.c, 14.0f));
                    PopGrabBoxView.this.g.setPadding(PopGrabBoxView.this.g.getPaddingLeft(), DensityUtils.a(PopGrabBoxView.this.c, 14.0f), PopGrabBoxView.this.g.getPaddingRight(), PopGrabBoxView.this.g.getPaddingBottom());
                } else {
                    PopGrabBoxView.this.s.setVisibility(0);
                    PopGrabBoxView.this.f.setPadding(PopGrabBoxView.this.f.getPaddingLeft(), DensityUtils.a(PopGrabBoxView.this.c, 30.0f), PopGrabBoxView.this.f.getPaddingRight(), DensityUtils.a(PopGrabBoxView.this.c, 30.0f));
                    PopGrabBoxView.this.g.setPadding(PopGrabBoxView.this.g.getPaddingLeft(), DensityUtils.a(PopGrabBoxView.this.c, 30.0f), PopGrabBoxView.this.g.getPaddingRight(), PopGrabBoxView.this.g.getPaddingBottom());
                }
                PopGrabBoxView.this.s.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopGrabBoxView.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (LiveRefreshUIObserver.a().f()) {
                            if (!TextUtils.equals(LiveRoomInfo.a().f(), PopGrabBoxView.this.i)) {
                                InstantLog.a("live_activity_link_click");
                                LiveRoomInfo.a().a(PopGrabBoxView.this.c, grabBoxDetailModel.url);
                            }
                            if (PopGrabBoxView.this.d instanceof PlayingOnliveFragment) {
                                LiveRefreshUIObserver.a().b(true);
                            }
                        }
                    }
                });
            }
        }, this.i, this.j, this.k);
    }
}
