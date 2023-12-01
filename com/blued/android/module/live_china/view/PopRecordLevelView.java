package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.model.LiveRecordLevelExtra;
import com.blued.android.module.live_china.model.LiveRecordLevelModel;
import com.blued.android.module.live_china.model.LiveRecordLevelPrivilegeModel;
import com.blued.android.module.live_china.model.LiveRecordLevelTaskModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.view.LiveRecordLevelToolBarView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRecordLevelView.class */
public class PopRecordLevelView {
    private LayoutInflater a;
    private Context b;
    private View c;
    private View d;
    private MyPopupWindow e;
    private CustomViewPager f;
    private LiveRecordLevelToolBarView g;
    private RecordLevelPagerAdapter h;
    private RecordingOnliveFragment i;
    private View j;
    private TaskAdapter m;
    private PrivilegeAdapter n;
    private ViewPager.OnPageChangeListener k = new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.view.PopRecordLevelView.4
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            PopRecordLevelView.this.g.setToolBtnSelect(i);
        }
    };
    private List<String> l = new ArrayList();
    private List<View> o = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRecordLevelView$MyPopupWindow.class */
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
                PopRecordLevelView.this.c();
            } catch (Exception e) {
                a();
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRecordLevelView$PrivilegeAdapter.class */
    class PrivilegeAdapter extends BaseQuickAdapter<LiveRecordLevelPrivilegeModel, BaseViewHolder> {
        private ImageView b;
        private TextView c;

        public PrivilegeAdapter() {
            super(R.layout.item_live_record_level_privilege, (List) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, LiveRecordLevelPrivilegeModel liveRecordLevelPrivilegeModel) {
            if (baseViewHolder != null) {
                this.b = (ImageView) baseViewHolder.getView(R.id.live_privilege_icon);
                this.c = (TextView) baseViewHolder.getView(R.id.live_privilege_name);
                baseViewHolder.setText(R.id.live_privilege_name, liveRecordLevelPrivilegeModel.title);
                baseViewHolder.setText(R.id.live_privilege_level, liveRecordLevelPrivilegeModel.message);
                ImageLoader.a((IRequestHost) null, liveRecordLevelPrivilegeModel.status == 1 ? liveRecordLevelPrivilegeModel.icon : liveRecordLevelPrivilegeModel.icon_disable).a(this.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRecordLevelView$RecordLevelPagerAdapter.class */
    public class RecordLevelPagerAdapter extends PagerAdapter {
        private String b = "";
        private String c = "";

        RecordLevelPagerAdapter() {
        }

        public void a(String str, String str2) {
            this.b = str;
            this.c = str2;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return PopRecordLevelView.this.l.size();
        }

        public int getItemPosition(Object obj) {
            return -2;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            while (PopRecordLevelView.this.o.size() < PopRecordLevelView.this.l.size()) {
                PopRecordLevelView.this.o.add(LayoutInflater.from(PopRecordLevelView.this.b).inflate(R.layout.live_beauty_pager, viewGroup, false));
            }
            View view = (View) PopRecordLevelView.this.o.get(i);
            PullToRefreshRecyclerView pullToRefreshRecyclerView = (PullToRefreshRecyclerView) view.findViewById(R.id.live_beauty_recycler_view);
            RecyclerView refreshableView = pullToRefreshRecyclerView.getRefreshableView();
            pullToRefreshRecyclerView.setRefreshEnabled(false);
            view.findViewById(R.id.ll_more).setVisibility(0);
            View findViewById = view.findViewById(R.id.live_task_more);
            if (i == 0) {
                ((LinearLayout.LayoutParams) pullToRefreshRecyclerView.getLayoutParams()).topMargin = DensityUtils.a(PopRecordLevelView.this.b, 15.0f);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PopRecordLevelView.this.b);
                linearLayoutManager.setOrientation(1);
                refreshableView.setLayoutManager(linearLayoutManager);
                PopRecordLevelView popRecordLevelView = PopRecordLevelView.this;
                popRecordLevelView.m = new TaskAdapter();
                refreshableView.setAdapter(PopRecordLevelView.this.m);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopRecordLevelView.RecordLevelPagerAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        if (TextUtils.isEmpty(RecordLevelPagerAdapter.this.b)) {
                            return;
                        }
                        PopRecordLevelView.this.c();
                        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopRecordLevelView.RecordLevelPagerAdapter.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PopRecordLevelView.this.e.a();
                                PopRecordLevelView.this.i.p(RecordLevelPagerAdapter.this.b);
                            }
                        }, 300L);
                    }
                });
            } else if (i == 1) {
                ((LinearLayout.LayoutParams) pullToRefreshRecyclerView.getLayoutParams()).topMargin = DensityUtils.a(PopRecordLevelView.this.b, 5.0f);
                refreshableView.setLayoutManager(new GridLayoutManager(PopRecordLevelView.this.b, 4));
                PopRecordLevelView popRecordLevelView2 = PopRecordLevelView.this;
                popRecordLevelView2.n = new PrivilegeAdapter();
                refreshableView.setAdapter(PopRecordLevelView.this.n);
                findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopRecordLevelView.RecordLevelPagerAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        Tracker.onClick(view2);
                        if (TextUtils.isEmpty(RecordLevelPagerAdapter.this.c)) {
                            return;
                        }
                        PopRecordLevelView.this.c();
                        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopRecordLevelView.RecordLevelPagerAdapter.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                PopRecordLevelView.this.e.a();
                                PopRecordLevelView.this.i.p(RecordLevelPagerAdapter.this.c);
                            }
                        }, 300L);
                    }
                });
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView((View) PopRecordLevelView.this.o.get(i));
            return view;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopRecordLevelView$TaskAdapter.class */
    class TaskAdapter extends BaseQuickAdapter<LiveRecordLevelTaskModel, BaseViewHolder> {
        private ImageView b;
        private TextView c;
        private TextView d;
        private ImageView e;

        public TaskAdapter() {
            super(R.layout.item_live_record_level_task, (List) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, LiveRecordLevelTaskModel liveRecordLevelTaskModel) {
            if (baseViewHolder != null) {
                this.b = (ImageView) baseViewHolder.getView(R.id.live_task_icon);
                this.c = (TextView) baseViewHolder.getView(R.id.live_task_name);
                this.d = (TextView) baseViewHolder.getView(R.id.live_task_details);
                this.e = (ImageView) baseViewHolder.getView(R.id.live_task_status_icon);
                baseViewHolder.setText(R.id.live_task_name, liveRecordLevelTaskModel.title);
                ImageLoader.a((IRequestHost) null, liveRecordLevelTaskModel.icon).a(this.b);
                ImageLoader.a((IRequestHost) null, liveRecordLevelTaskModel.status_image).a(this.e);
                String str = liveRecordLevelTaskModel.message;
                String str2 = liveRecordLevelTaskModel.highlight;
                StringBuilder sb = new StringBuilder(str);
                Log.v("pk", "message.indexOf(highlight) = " + sb.indexOf(str2));
                Log.v("pk", "message.lastIndexOf(highlight) = " + sb.indexOf(str2) + str2.length());
                sb.insert(sb.indexOf(str2), " ");
                sb.insert(sb.indexOf(str2) + str2.length(), " ");
                Log.v("pk", "sb.toString() = " + sb.toString());
                SpannableString spannableString = new SpannableString(sb.toString());
                this.d.setMovementMethod(LinkMovementMethod.getInstance());
                spannableString.setSpan(new ClickableSpan() { // from class: com.blued.android.module.live_china.view.PopRecordLevelView.TaskAdapter.1
                    @Override // android.text.style.ClickableSpan
                    public void onClick(View view) {
                    }

                    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                    public void updateDrawState(TextPaint textPaint) {
                        textPaint.setColor(TaskAdapter.this.mContext.getResources().getColor(R.color.nafio_f));
                        textPaint.setUnderlineText(false);
                    }
                }, spannableString.toString().indexOf(str2), spannableString.toString().indexOf(str2) + str2.length(), 33);
                this.d.setText(spannableString);
            }
        }
    }

    public PopRecordLevelView(RecordingOnliveFragment recordingOnliveFragment) {
        this.i = recordingOnliveFragment;
        this.b = recordingOnliveFragment.getContext();
        e();
        d();
    }

    private void d() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.a = from;
        View inflate = from.inflate(R.layout.pop_window_record_level_task, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.tv_bg);
        this.c = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopRecordLevelView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PopRecordLevelView.this.c();
            }
        });
        View findViewById2 = inflate.findViewById(R.id.ll_content);
        this.d = findViewById2;
        findViewById2.setVisibility(8);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopRecordLevelView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        this.j = inflate.findViewById(R.id.ll_loading);
        this.f = (CustomViewPager) inflate.findViewById(R.id.live_record_level_viewpager);
        LiveRecordLevelToolBarView liveRecordLevelToolBarView = (LiveRecordLevelToolBarView) inflate.findViewById(R.id.live_record_level_tool_bar);
        this.g = liveRecordLevelToolBarView;
        liveRecordLevelToolBarView.a(this.b.getResources().getStringArray(R.array.live_record_level_title));
        this.g.setOnToolBarItemClickListener(new LiveRecordLevelToolBarView.OnToolBarItemClickListener() { // from class: com.blued.android.module.live_china.view.PopRecordLevelView.3
            @Override // com.blued.android.module.live_china.view.LiveRecordLevelToolBarView.OnToolBarItemClickListener
            public void a(int i) {
                PopRecordLevelView.this.f.setCurrentItem(i);
            }
        });
        RecordLevelPagerAdapter recordLevelPagerAdapter = new RecordLevelPagerAdapter();
        this.h = recordLevelPagerAdapter;
        this.f.setAdapter(recordLevelPagerAdapter);
        this.f.addOnPageChangeListener(this.k);
        MyPopupWindow myPopupWindow = new MyPopupWindow(inflate, -1, -1, true);
        this.e = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.b.getResources().getDrawable(com.android.internal.R.color.transparent));
        this.e.setTouchable(true);
        this.e.setOutsideTouchable(true);
        this.e.setFocusable(true);
        this.e.update();
    }

    private void e() {
        String[] stringArray = this.b.getResources().getStringArray(R.array.live_record_level_title);
        int length = stringArray.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            this.l.add(stringArray[i2]);
            i = i2 + 1;
        }
    }

    public void a() {
        RecordingOnliveFragment recordingOnliveFragment = this.i;
        if (recordingOnliveFragment != null) {
            recordingOnliveFragment.O();
        }
        this.c.clearAnimation();
        this.d.clearAnimation();
        if (this.e.isShowing()) {
            this.e.a();
        }
        this.e.showAtLocation(this.d, 81, 0, 0);
        this.d.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in);
        this.d.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.blued.android.module.live_china.view.PopRecordLevelView.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PopRecordLevelView.this.b();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        });
    }

    public void b() {
        BluedUIHttpResponse<BluedEntity<LiveRecordLevelModel, LiveRecordLevelExtra>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<LiveRecordLevelModel, LiveRecordLevelExtra>>(this.i.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.PopRecordLevelView.6
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                PopRecordLevelView.this.j.setVisibility(8);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                PopRecordLevelView.this.j.setVisibility(0);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveRecordLevelModel, LiveRecordLevelExtra> bluedEntity) {
                LiveRecordLevelModel liveRecordLevelModel;
                if (bluedEntity != null && bluedEntity.data != null && bluedEntity.data.size() > 0 && (liveRecordLevelModel = bluedEntity.data.get(0)) != null) {
                    if (liveRecordLevelModel.missions != null && PopRecordLevelView.this.m != null) {
                        PopRecordLevelView.this.m.addData(liveRecordLevelModel.missions);
                    }
                    if (liveRecordLevelModel.features != null && PopRecordLevelView.this.n != null) {
                        PopRecordLevelView.this.n.addData(liveRecordLevelModel.features);
                    }
                }
                if (bluedEntity == null || bluedEntity.extra == null || PopRecordLevelView.this.h == null) {
                    return;
                }
                PopRecordLevelView.this.h.a(bluedEntity.extra.mission_more_url, bluedEntity.extra.feature_more_url);
            }
        };
        LiveRoomHttpUtils.s(bluedUIHttpResponse, this.i.t + "");
    }

    public void c() {
        RecordingOnliveFragment recordingOnliveFragment = this.i;
        if (recordingOnliveFragment != null) {
            recordingOnliveFragment.P();
        }
        this.d.setVisibility(8);
        this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out));
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopRecordLevelView.7
            @Override // java.lang.Runnable
            public void run() {
                PopRecordLevelView.this.e.a();
            }
        }, 300L);
    }
}
