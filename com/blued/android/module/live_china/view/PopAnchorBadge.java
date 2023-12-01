package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live.base.utils.LiveTimeAndDateUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.AnchorMedal;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.same.CirclePageIndicator;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopAnchorBadge.class */
public class PopAnchorBadge {
    public View a;
    public View b;
    public View c;
    public Context d;
    public LayoutInflater e;
    public ViewPager f;
    public CirclePageIndicator g;
    public View h;
    public LinearLayout i;
    private MyPopupWindow j;
    private MyPagerAdapter l;
    private String m;
    private IRequestHost n;
    private DismissLisnter p;
    private String q;
    private ArrayList<AnchorMedal> k = new ArrayList<>();
    private String o = "0";

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopAnchorBadge$ANCHOR_MEDAL.class */
    public interface ANCHOR_MEDAL {
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopAnchorBadge$DismissLisnter.class */
    public interface DismissLisnter {
        void a();

        void b();
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopAnchorBadge$MyPagerAdapter.class */
    public class MyPagerAdapter extends PagerAdapter {
        public MyPagerAdapter() {
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            if (PopAnchorBadge.this.k == null) {
                return 0;
            }
            return PopAnchorBadge.this.k.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            AnchorMedal anchorMedal = (AnchorMedal) PopAnchorBadge.this.k.get(i);
            View b = PopAnchorBadge.this.b();
            ImageView imageView = (ImageView) b.findViewById(R.id.img_badge);
            TextView textView = (TextView) b.findViewById(R.id.tv_badge_name);
            TextView textView2 = (TextView) b.findViewById(R.id.tv_gained_cond);
            TextView textView3 = (TextView) b.findViewById(R.id.tv_valid_date);
            TextView textView4 = (TextView) b.findViewById(R.id.tv_lvlup_cond);
            TextView textView5 = (TextView) b.findViewById(R.id.tv_score);
            if (anchorMedal.score > 0) {
                textView5.setText(anchorMedal.score + PopAnchorBadge.this.d.getResources().getString(R.string.score_point));
            } else {
                textView5.setText("?");
            }
            if (LiveRoomInfo.a().f().equals(PopAnchorBadge.this.q)) {
                textView5.setBackground(null);
            } else {
                textView5.setBackgroundResource(R.drawable.shape_popmedal_point_bg);
                textView5.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopAnchorBadge.MyPagerAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (LiveRefreshUIObserver.a().f()) {
                            LiveRoomInfo.a().a(PopAnchorBadge.this.d, LiveRoomInfo.a().y());
                            PopAnchorBadge.this.p.b();
                        }
                    }
                });
            }
            if (!TextUtils.isEmpty(anchorMedal.pic)) {
                ImageLoader.a(PopAnchorBadge.this.n, anchorMedal.pic).a(imageView);
            }
            textView.setText(anchorMedal.name);
            textView2.setText(anchorMedal.title);
            if (TextUtils.isEmpty(anchorMedal.upgrade_description)) {
                textView4.setVisibility(4);
            } else {
                textView4.setVisibility(0);
                textView4.setText(anchorMedal.upgrade_description);
            }
            String a = LiveTimeAndDateUtils.a(LiveTimeAndDateUtils.a(anchorMedal.end_time + ""));
            if (TextUtils.isEmpty(a) || anchorMedal.end_time == 0) {
                textView3.setVisibility(4);
            } else {
                textView3.setVisibility(0);
                textView3.setText(PopAnchorBadge.this.d.getResources().getString(R.string.valid_to) + a);
            }
            viewGroup.addView(b);
            return b;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopAnchorBadge$MyPopupWindow.class */
    public class MyPopupWindow extends PopupWindow {
        public MyPopupWindow(View view, int i, int i2, boolean z) {
            super(view, i, i2, z);
        }

        public void a() {
            super.dismiss();
        }

        @Override // android.widget.PopupWindow
        public void dismiss() {
            try {
                PopAnchorBadge.this.e();
            } catch (Exception e) {
                a();
            }
        }
    }

    public PopAnchorBadge(Context context, String str, IRequestHost iRequestHost, DismissLisnter dismissLisnter) {
        this.q = "";
        this.d = context;
        this.n = iRequestHost;
        this.p = dismissLisnter;
        this.q = str;
        g();
    }

    public static void a(Context context, String str, String str2, String str3, DismissLisnter dismissLisnter, IRequestHost iRequestHost) {
        new PopAnchorBadge(context, str2, iRequestHost, dismissLisnter).a(str3, str);
    }

    private void g() {
        this.e = LayoutInflater.from(this.d);
        a();
        this.l = new MyPagerAdapter();
        this.b = this.a.findViewById(R.id.tv_bg);
        this.f = this.a.findViewById(R.id.vp_badge);
        this.g = (CirclePageIndicator) this.a.findViewById(R.id.indicator);
        this.i = (LinearLayout) this.a.findViewById(R.id.ll_loading);
        View findViewById = this.a.findViewById(R.id.tv_close);
        this.h = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopAnchorBadge.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PopAnchorBadge.this.e();
            }
        });
        this.f.setAdapter(this.l);
        this.g.setViewPager(this.f);
        this.g.setRadius(DensityUtils.a(this.d, 3.5f));
        this.g.setInterval(DensityUtils.a(this.d, 5.5f));
        this.b.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopAnchorBadge.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PopAnchorBadge.this.e();
            }
        });
        View findViewById2 = this.a.findViewById(R.id.ll_content);
        this.c = findViewById2;
        findViewById2.setBackgroundColor(this.d.getResources().getColor(R.color.transparent));
        this.c.setVisibility(8);
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopAnchorBadge.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        MyPopupWindow myPopupWindow = new MyPopupWindow(this.a, -1, -1, true);
        this.j = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.d.getResources().getDrawable(com.android.internal.R.color.transparent));
        this.j.setTouchable(true);
        this.j.setOutsideTouchable(true);
        this.j.setFocusable(true);
        this.j.update();
    }

    public void a() {
        this.a = this.e.inflate(R.layout.anchor_badge_bottom, (ViewGroup) null);
    }

    public void a(String str, String str2) {
        this.o = str;
        this.m = str2;
        this.i.setVisibility(0);
        this.f.setVisibility(4);
        this.b.clearAnimation();
        this.c.clearAnimation();
        if (this.j.isShowing()) {
            this.j.a();
        }
        this.j.showAtLocation(this.c, 81, 0, 0);
        this.c.setVisibility(0);
        c();
    }

    public View b() {
        return this.e.inflate(R.layout.item_anchor_badge, (ViewGroup) null);
    }

    public void c() {
        this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_in));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.PopAnchorBadge.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PopAnchorBadge.this.d();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.b.startAnimation(alphaAnimation);
    }

    public void d() {
        LiveRoomHttpUtils.d(this.m, true, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<AnchorMedal>>() { // from class: com.blued.android.module.live_china.view.PopAnchorBadge.5
            boolean a = false;

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<AnchorMedal> bluedEntityA) {
                if (bluedEntityA != null && bluedEntityA.data.size() > 0 && bluedEntityA.data.get(0) != null) {
                    PopAnchorBadge.this.k.clear();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= bluedEntityA.data.size()) {
                            break;
                        }
                        PopAnchorBadge.this.k.add(bluedEntityA.data.get(i2));
                        if (bluedEntityA.data.get(i2) != null) {
                            String str = bluedEntityA.data.get(i2).pic;
                            if (!TextUtils.isEmpty(str)) {
                                ImageFileLoader.a(PopAnchorBadge.this.n).a(str).a();
                            }
                        }
                        i = i2 + 1;
                    }
                }
                if (PopAnchorBadge.this.l.getCount() > 1) {
                    PopAnchorBadge.this.g.setVisibility(0);
                } else {
                    PopAnchorBadge.this.g.setVisibility(8);
                }
                PopAnchorBadge.this.l.notifyDataSetChanged();
                PopAnchorBadge.this.g.a();
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= PopAnchorBadge.this.k.size()) {
                        return;
                    }
                    if (!TextUtils.isEmpty(PopAnchorBadge.this.o) && PopAnchorBadge.this.o.equals(((AnchorMedal) PopAnchorBadge.this.k.get(i4)).bid)) {
                        PopAnchorBadge.this.f.setCurrentItem(i4);
                        return;
                    }
                    i3 = i4 + 1;
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String str) {
                this.a = true;
                return super.onUIFailure(i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                PopAnchorBadge.this.i.setVisibility(8);
                PopAnchorBadge.this.f.setVisibility(0);
                if (this.a) {
                    this.a = false;
                    PopAnchorBadge.this.e();
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
            }
        }, this.n);
    }

    public void e() {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopAnchorBadge.6
            @Override // java.lang.Runnable
            public void run() {
                PopAnchorBadge.this.j.a();
                if (PopAnchorBadge.this.p != null) {
                    PopAnchorBadge.this.p.a();
                }
            }
        }, 320L);
        f();
        this.c.setVisibility(8);
    }

    public void f() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.b.startAnimation(alphaAnimation);
        this.c.startAnimation(AnimationUtils.loadAnimation(this.d, R.anim.push_bottom_out));
    }
}
