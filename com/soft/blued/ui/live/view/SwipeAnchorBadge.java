package com.soft.blued.ui.live.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.live_china.model.AnchorMedal;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.customview.swipecard.SwipeFlingAdapterView;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/view/SwipeAnchorBadge.class */
public class SwipeAnchorBadge implements SwipeFlingAdapterView.onFlingListener {

    /* renamed from: a  reason: collision with root package name */
    private View f17628a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private Context f17629c;
    private MyPopupWindow d;
    private LayoutInflater e;
    private LinearLayout g;
    private String h;
    private IRequestHost i;
    private SwipeFlingAdapterView k;
    private SwipeAnchorBadgeCardAdapter l;
    private ArrayList<AnchorMedal> f = new ArrayList<>();
    private int j = 0;
    private boolean m = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/view/SwipeAnchorBadge$MyPopupWindow.class */
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
                SwipeAnchorBadge.this.c();
            } catch (Exception e) {
                a();
            }
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/view/SwipeAnchorBadge$SwipeAnchorBadgeCardAdapter.class */
    public class SwipeAnchorBadgeCardAdapter extends BaseAdapter {
        private List<AnchorMedal> b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private List<AnchorMedal> f17638c = new ArrayList();
        private int d = 0;
        private Context e;
        private int f;
        private SwipeFlingAdapterView g;

        /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/view/SwipeAnchorBadge$SwipeAnchorBadgeCardAdapter$ViewHolder.class */
        class ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            public ImageView f17640a;
            public TextView b;

            /* renamed from: c  reason: collision with root package name */
            public TextView f17641c;
            public TextView d;
            public TextView e;
            public TextView f;

            private ViewHolder() {
            }
        }

        public SwipeAnchorBadgeCardAdapter(Context context, SwipeFlingAdapterView swipeFlingAdapterView) {
            this.f = 0;
            this.e = context;
            this.g = swipeFlingAdapterView;
            this.f = swipeFlingAdapterView.getVisibleCount();
        }

        public void a() {
            int i = this.d - 1;
            this.d = i;
            a(i);
        }

        public void a(int i) {
            int i2;
            int i3;
            SwipeAnchorBadge.this.k.f14973a = null;
            this.d = i;
            if (i < 0 || i >= this.b.size()) {
                return;
            }
            this.f17638c.clear();
            this.f17638c.add(this.b.get(this.d));
            int i4 = this.d;
            while (true) {
                int i5 = i4 + 1;
                i2 = this.d;
                if (i5 > (this.f / 2) + i2) {
                    break;
                }
                i4 = i5;
                if (i5 < this.b.size()) {
                    this.f17638c.add(this.b.get(i5));
                    i4 = i5;
                }
            }
            while (true) {
                i2--;
                i3 = this.d;
                if (i2 < i3 - (this.f / 2)) {
                    break;
                } else if (i2 >= 0) {
                    this.f17638c.add(this.b.get(i2));
                }
            }
            SwipeFlingAdapterView swipeFlingAdapterView = this.g;
            if (swipeFlingAdapterView != null) {
                swipeFlingAdapterView.setTag(R.id.current_index, Integer.valueOf(i3));
                this.g.setTag(R.id.total_szie, Integer.valueOf(this.b.size()));
            }
            notifyDataSetChanged();
        }

        public void a(List<AnchorMedal> list) {
            this.b.clear();
            if (list != null && list.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    this.b.add(list.get(i2));
                    i = i2 + 1;
                }
            }
            this.g.setTag(R.id.current_index, Integer.valueOf(this.d));
            this.g.setTag(R.id.total_szie, Integer.valueOf(this.b.size()));
            a(this.d);
        }

        @Override // android.widget.Adapter
        /* renamed from: b */
        public AnchorMedal getItem(int i) {
            List<AnchorMedal> list = this.f17638c;
            if (list == null || list.size() == 0) {
                return null;
            }
            return this.f17638c.get(i);
        }

        public void b() {
            int i = this.d + 1;
            this.d = i;
            Logger.b("swipecard", "pointerForward", Integer.valueOf(i));
            a(this.d);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f17638c.size();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                ViewHolder viewHolder2 = new ViewHolder();
                View inflate = LayoutInflater.from(this.e).inflate(R.layout.item_anchor_badge_swipe, viewGroup, false);
                viewHolder2.f17640a = (ImageView) inflate.findViewById(R.id.img_badge);
                viewHolder2.b = (TextView) inflate.findViewById(R.id.tv_badge_name);
                viewHolder2.f17641c = (TextView) inflate.findViewById(R.id.tv_gained_cond);
                viewHolder2.e = (TextView) inflate.findViewById(R.id.tv_lvlup_cond);
                viewHolder2.d = (TextView) inflate.findViewById(R.id.tv_valid_date);
                viewHolder2.f = (TextView) inflate.findViewById(R.id.tv_score);
                viewHolder = viewHolder2;
                view = inflate;
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            AnchorMedal anchorMedal = this.f17638c.get(i);
            if (!StringUtils.d(anchorMedal.pic)) {
                ImageLoader.a(SwipeAnchorBadge.this.i, anchorMedal.pic).a(viewHolder.f17640a);
            }
            viewHolder.b.setText(anchorMedal.name);
            viewHolder.f17641c.setText(anchorMedal.title);
            if (StringUtils.d(anchorMedal.upgrade_description)) {
                viewHolder.e.setVisibility(4);
            } else {
                viewHolder.e.setVisibility(0);
                viewHolder.e.setText(anchorMedal.upgrade_description);
            }
            if (anchorMedal.score > 0) {
                TextView textView = viewHolder.f;
                textView.setText(anchorMedal.score + this.e.getResources().getString(2131891562));
            } else {
                viewHolder.f.setText(" ? ");
            }
            viewHolder.f.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.view.SwipeAnchorBadge.SwipeAnchorBadgeCardAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Tracker.onClick(view2);
                    WebViewShowInfoFragment.show(SwipeAnchorBadgeCardAdapter.this.e, H5Url.a(11), 7);
                }
            });
            String c2 = TimeAndDateUtils.c(TimeAndDateUtils.c(anchorMedal.end_time + ""));
            if (StringUtils.d(c2) || anchorMedal.end_time == 0) {
                viewHolder.d.setVisibility(4);
                return view;
            }
            viewHolder.d.setVisibility(0);
            TextView textView2 = viewHolder.d;
            textView2.setText(this.e.getResources().getString(R.string.valid_to) + c2);
            return view;
        }
    }

    public SwipeAnchorBadge(Context context, String str, IRequestHost iRequestHost) {
        this.f17629c = context;
        this.h = str;
        this.i = iRequestHost;
        d();
    }

    public static void a(Context context, String str, int i, IRequestHost iRequestHost) {
        new SwipeAnchorBadge(context, str, iRequestHost).b(i);
    }

    private void d() {
        LayoutInflater from = LayoutInflater.from(this.f17629c);
        this.e = from;
        View inflate = from.inflate(R.layout.anchor_badge_swipe, (ViewGroup) null);
        this.f17628a = inflate.findViewById(2131370973);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ll_loading);
        this.g = linearLayout;
        linearLayout.setVisibility(8);
        SwipeFlingAdapterView swipeFlingAdapterView = (SwipeFlingAdapterView) inflate.findViewById(R.id.swipe_view);
        this.k = swipeFlingAdapterView;
        swipeFlingAdapterView.setFlingListener(this);
        SwipeAnchorBadgeCardAdapter swipeAnchorBadgeCardAdapter = new SwipeAnchorBadgeCardAdapter(this.f17629c, this.k);
        this.l = swipeAnchorBadgeCardAdapter;
        this.k.setAdapter(swipeAnchorBadgeCardAdapter);
        this.k.setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.live.view.SwipeAnchorBadge.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if ((motionEvent.getRawY() < SwipeAnchorBadge.this.k.b || motionEvent.getRawY() > SwipeAnchorBadge.this.k.e) && SwipeAnchorBadge.this.k.f14973a != null && SwipeAnchorBadge.this.k.f14973a.getX() == SwipeAnchorBadge.this.k.f14974c) {
                    SwipeAnchorBadge.this.c();
                    return true;
                }
                return true;
            }
        });
        this.f17628a.setBackgroundColor(Color.parseColor("#CC000000"));
        this.f17628a.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.view.SwipeAnchorBadge.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        View findViewById = inflate.findViewById(2131367715);
        this.b = findViewById;
        findViewById.setBackgroundColor(this.f17629c.getResources().getColor(2131102388));
        this.b.setVisibility(8);
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.live.view.SwipeAnchorBadge.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        MyPopupWindow myPopupWindow = new MyPopupWindow(inflate, -1, -1, true);
        this.d = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.f17629c.getResources().getDrawable(android.R.color.transparent));
        this.d.setTouchable(true);
        this.d.setOutsideTouchable(true);
        this.d.setFocusable(true);
        this.d.update();
        b();
    }

    @Override // com.soft.blued.customview.swipecard.SwipeFlingAdapterView.onFlingListener
    public void a() {
    }

    @Override // com.soft.blued.customview.swipecard.SwipeFlingAdapterView.onFlingListener
    public void a(float f, float f2) {
    }

    @Override // com.soft.blued.customview.swipecard.SwipeFlingAdapterView.onFlingListener
    public void a(int i) {
    }

    @Override // com.soft.blued.customview.swipecard.SwipeFlingAdapterView.onFlingListener
    public void a(Object obj) {
        this.l.b();
    }

    public void b() {
        LiveRoomHttpUtils.d(this.h, new BluedUIHttpResponse<BluedEntityA<AnchorMedal>>() { // from class: com.soft.blued.ui.live.view.SwipeAnchorBadge.5

            /* renamed from: a  reason: collision with root package name */
            boolean f17634a = false;

            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<AnchorMedal> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.data.size() <= 0) {
                    return;
                }
                if (bluedEntityA.data.get(0) != null) {
                    SwipeAnchorBadge.this.f.clear();
                    for (int i = 0; i < bluedEntityA.data.size(); i++) {
                        SwipeAnchorBadge.this.f.add((AnchorMedal) bluedEntityA.data.get(i));
                        if (bluedEntityA.data.get(i) != null) {
                            String str = ((AnchorMedal) bluedEntityA.data.get(i)).pic;
                            if (!StringUtils.d(str)) {
                                ImageFileLoader.a(SwipeAnchorBadge.this.i).a(str).a();
                            }
                        }
                    }
                    SwipeAnchorBadge.this.l.a(SwipeAnchorBadge.this.f);
                    SwipeAnchorBadge.this.l.a(SwipeAnchorBadge.this.j);
                }
            }

            public boolean onUIFailure(int i, String str) {
                this.f17634a = true;
                return super.onUIFailure(i, str);
            }

            public void onUIFinish() {
                SwipeAnchorBadge.this.g.setVisibility(8);
                SwipeAnchorBadge.this.k.setVisibility(0);
                if (this.f17634a) {
                    this.f17634a = false;
                    SwipeAnchorBadge.this.c();
                }
            }

            public void onUIStart() {
            }
        }, this.i);
    }

    public void b(int i) {
        this.j = i;
        this.k.setVisibility(4);
        this.g.setVisibility(0);
        this.f17628a.clearAnimation();
        this.b.clearAnimation();
        if (this.d.isShowing()) {
            this.d.a();
        }
        this.d.showAtLocation(this.b, 81, 0, 0);
        this.b.setVisibility(0);
        this.b.startAnimation(AnimationUtils.loadAnimation(this.f17629c, 2130772112));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.5f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.soft.blued.ui.live.view.SwipeAnchorBadge.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SwipeAnchorBadge.this.b();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
        this.f17628a.startAnimation(alphaAnimation);
    }

    @Override // com.soft.blued.customview.swipecard.SwipeFlingAdapterView.onFlingListener
    public void b(Object obj) {
        this.l.a();
    }

    public void c() {
        if (this.m) {
            return;
        }
        this.m = true;
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.f17628a.startAnimation(alphaAnimation);
        this.b.setVisibility(8);
        this.b.startAnimation(AnimationUtils.loadAnimation(this.f17629c, 2130772113));
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.live.view.SwipeAnchorBadge.6
            @Override // java.lang.Runnable
            public void run() {
                SwipeAnchorBadge.this.d.a();
                SwipeAnchorBadge.this.m = false;
            }
        }, 320L);
    }
}
