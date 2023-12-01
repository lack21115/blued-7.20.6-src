package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.amap.api.services.district.DistrictSearchQuery;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.module.common.view.CustomViewPager;
import com.blued.android.module.external_sense_library.config.BluedBeautifyKey;
import com.blued.android.module.external_sense_library.config.BluedFilterType;
import com.blued.android.module.external_sense_library.manager.FilterDataManager;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.manager.RecordingOnliveManager;
import com.blued.android.module.live_china.model.BeautyModel;
import com.blued.android.module.live_china.utils.LiveRoomPreferences;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveBeautyToolBarView;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopBeautyNewView.class */
public class PopBeautyNewView {
    private LayoutInflater a;
    private Context b;
    private View c;
    private View d;
    private MyPopupWindow e;
    private TextView f;
    private SeekBar g;
    private LinearLayout h;
    private CustomViewPager i;
    private LiveBeautyToolBarView j;
    private BeautyPagerAdapter k;
    private RecordingOnliveFragment l;
    private RecordingOnliveManager m;
    private BeautyModel n;
    private BeautyAdapter o;
    private BeautyAdapter p;
    private BeautyAdapter q;
    private BeautyAdapter r;
    private List<View> s = new ArrayList();
    private List<String> t = new ArrayList();
    private List<BeautyModel> u = new ArrayList();
    private List<BeautyModel> v = new ArrayList();
    private List<BeautyModel> w = new ArrayList();
    private List<BeautyModel> x = new ArrayList();
    private ViewPager.OnPageChangeListener y = new ViewPager.OnPageChangeListener() { // from class: com.blued.android.module.live_china.view.PopBeautyNewView.7
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            PopBeautyNewView.this.j.setToolBtnSelect(i);
            PopBeautyNewView popBeautyNewView = PopBeautyNewView.this;
            popBeautyNewView.n = popBeautyNewView.d(i);
            if (PopBeautyNewView.this.n != null) {
                PopBeautyNewView popBeautyNewView2 = PopBeautyNewView.this;
                popBeautyNewView2.c(popBeautyNewView2.n.progress);
                if (PopBeautyNewView.this.n.isFilter) {
                    PopBeautyNewView popBeautyNewView3 = PopBeautyNewView.this;
                    if (popBeautyNewView3.a(popBeautyNewView3.n.id)) {
                        PopBeautyNewView.this.h();
                        return;
                    }
                }
                PopBeautyNewView.this.g();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopBeautyNewView$BeautyAdapter.class */
    public class BeautyAdapter extends BaseQuickAdapter<BeautyModel, BaseViewHolder> {
        private ImageView b;
        private ImageView c;

        public BeautyAdapter() {
            super(R.layout.beauty_view_item_new, (List) null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, final BeautyModel beautyModel) {
            if (baseViewHolder != null) {
                this.b = (ImageView) baseViewHolder.getView(R.id.beauty_image_bg);
                this.c = (ImageView) baseViewHolder.getView(R.id.beauty_image);
                this.b = (ImageView) baseViewHolder.getView(R.id.beauty_image_bg);
                baseViewHolder.setImageResource(R.id.beauty_image, beautyModel.resource);
                baseViewHolder.setText(R.id.beauty_text, beautyModel.customName);
                if (beautyModel.isSelect) {
                    this.b.setVisibility(0);
                } else {
                    this.b.setVisibility(8);
                }
                baseViewHolder.setOnClickListener(R.id.beauty_root_layout, new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopBeautyNewView.BeautyAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (!beautyModel.isSelect) {
                            EventTrackLive.a(LiveProtos.Event.LIVE_FILTER_USE, PopBeautyNewView.this.e(), LiveProtos.Status.END);
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= BeautyAdapter.this.mData.size()) {
                                    break;
                                }
                                ((BeautyModel) BeautyAdapter.this.mData.get(i2)).isSelect = false;
                                i = i2 + 1;
                            }
                            beautyModel.isSelect = true;
                            PopBeautyNewView.this.n = beautyModel;
                            PopBeautyNewView.this.c(beautyModel.progress);
                            if (beautyModel.isFilter) {
                                if (PopBeautyNewView.this.a(beautyModel.id)) {
                                    PopBeautyNewView.this.m.a((BluedFilterType.FILER) null);
                                    PopBeautyNewView.this.h();
                                } else {
                                    PopBeautyNewView.this.m.a(beautyModel.filer);
                                    PopBeautyNewView.this.a(beautyModel.progress);
                                    PopBeautyNewView.this.g();
                                }
                                LiveRoomPreferences.w(beautyModel.id);
                                EventTrackLive.a(LiveProtos.Event.LIVE_FILTER_USE, beautyModel.eventName, LiveProtos.Status.START);
                            }
                        }
                        BeautyAdapter.this.notifyDataSetChanged();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopBeautyNewView$BeautyPagerAdapter.class */
    public class BeautyPagerAdapter extends PagerAdapter {
        BeautyPagerAdapter() {
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return PopBeautyNewView.this.t.size();
        }

        public int getItemPosition(Object obj) {
            return -2;
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            while (PopBeautyNewView.this.s.size() < PopBeautyNewView.this.t.size()) {
                PopBeautyNewView.this.s.add(LayoutInflater.from(PopBeautyNewView.this.b).inflate(R.layout.live_beauty_pager, viewGroup, false));
            }
            View view = (View) PopBeautyNewView.this.s.get(i);
            RecyclerView refreshableView = ((PullToRefreshRecyclerView) view.findViewById(R.id.live_beauty_recycler_view)).getRefreshableView();
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(PopBeautyNewView.this.b);
            linearLayoutManager.setOrientation(0);
            refreshableView.setLayoutManager(linearLayoutManager);
            if (i == 0) {
                PopBeautyNewView popBeautyNewView = PopBeautyNewView.this;
                popBeautyNewView.o = new BeautyAdapter();
                PopBeautyNewView.this.o.addData(PopBeautyNewView.this.u);
                refreshableView.setAdapter(PopBeautyNewView.this.o);
            } else if (i == 1) {
                PopBeautyNewView popBeautyNewView2 = PopBeautyNewView.this;
                popBeautyNewView2.p = new BeautyAdapter();
                PopBeautyNewView.this.p.addData(PopBeautyNewView.this.v);
                refreshableView.setAdapter(PopBeautyNewView.this.p);
            } else if (i == 2) {
                PopBeautyNewView popBeautyNewView3 = PopBeautyNewView.this;
                popBeautyNewView3.q = new BeautyAdapter();
                PopBeautyNewView.this.q.addData(PopBeautyNewView.this.w);
                refreshableView.setAdapter(PopBeautyNewView.this.q);
            } else if (i == 3) {
                PopBeautyNewView popBeautyNewView4 = PopBeautyNewView.this;
                popBeautyNewView4.r = new BeautyAdapter();
                PopBeautyNewView.this.r.addData(PopBeautyNewView.this.x);
                refreshableView.setAdapter(PopBeautyNewView.this.r);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView((View) PopBeautyNewView.this.s.get(i));
            return view;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/PopBeautyNewView$MyPopupWindow.class */
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
                PopBeautyNewView.this.b();
            } catch (Exception e) {
                a();
            }
        }
    }

    public PopBeautyNewView(RecordingOnliveFragment recordingOnliveFragment, RecordingOnliveManager recordingOnliveManager) {
        this.m = recordingOnliveManager;
        this.l = recordingOnliveFragment;
        this.b = recordingOnliveFragment.getContext();
        c();
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        return TextUtils.equals(this.n.id, "filter_none");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i) {
        BeautyModel beautyModel = this.n;
        if (beautyModel != null) {
            if (TextUtils.equals(beautyModel.id, "white")) {
                LiveRoomPreferences.a(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "ruddy")) {
                LiveRoomPreferences.b(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "grinding")) {
                LiveRoomPreferences.c(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "highlight")) {
                LiveRoomPreferences.d(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "face_1")) {
                LiveRoomPreferences.e(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "face_2")) {
                LiveRoomPreferences.f(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "face_3")) {
                LiveRoomPreferences.g(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "face_4")) {
                LiveRoomPreferences.h(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "face_5")) {
                LiveRoomPreferences.i(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "face_6")) {
                LiveRoomPreferences.j(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "face_7")) {
                LiveRoomPreferences.k(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "face_8")) {
                LiveRoomPreferences.l(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "contrast")) {
                LiveRoomPreferences.m(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "saturation")) {
                LiveRoomPreferences.n(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "filter_ruby")) {
                LiveRoomPreferences.o(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "filter_pansy")) {
                LiveRoomPreferences.p(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "filter_morden")) {
                LiveRoomPreferences.q(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "filter_city")) {
                LiveRoomPreferences.r(this.n.id, i);
            } else if (TextUtils.equals(this.n.id, "filter_babypink")) {
                LiveRoomPreferences.s(this.n.id, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i) {
        TextView textView = this.f;
        textView.setText(i + "%");
        this.g.setProgress(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BeautyModel d(int i) {
        BeautyAdapter beautyAdapter;
        if (i == 0) {
            BeautyAdapter beautyAdapter2 = this.o;
            if (beautyAdapter2 != null) {
                for (BeautyModel beautyModel : beautyAdapter2.getData()) {
                    if (beautyModel.isSelect) {
                        return beautyModel;
                    }
                }
                return null;
            }
            return null;
        } else if (i == 1) {
            BeautyAdapter beautyAdapter3 = this.p;
            if (beautyAdapter3 != null) {
                for (BeautyModel beautyModel2 : beautyAdapter3.getData()) {
                    if (beautyModel2.isSelect) {
                        return beautyModel2;
                    }
                }
                return null;
            }
            return null;
        } else if (i != 2) {
            if (i == 3 && (beautyAdapter = this.r) != null) {
                for (BeautyModel beautyModel3 : beautyAdapter.getData()) {
                    if (beautyModel3.isSelect) {
                        return beautyModel3;
                    }
                }
                return null;
            }
            return null;
        } else {
            BeautyAdapter beautyAdapter4 = this.q;
            if (beautyAdapter4 != null) {
                for (BeautyModel beautyModel4 : beautyAdapter4.getData()) {
                    if (beautyModel4.isSelect) {
                        return beautyModel4;
                    }
                }
                return null;
            }
            return null;
        }
    }

    private void f() {
        LayoutInflater from = LayoutInflater.from(this.b);
        this.a = from;
        View inflate = from.inflate(R.layout.pop_window_beauty_new, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.tv_bg);
        this.c = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopBeautyNewView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PopBeautyNewView.this.b();
            }
        });
        View findViewById2 = inflate.findViewById(R.id.ll_content);
        this.d = findViewById2;
        findViewById2.setVisibility(8);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopBeautyNewView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
            }
        });
        this.f = (TextView) inflate.findViewById(R.id.live_beauty_progress);
        this.g = (SeekBar) inflate.findViewById(R.id.filter_seekbar);
        this.h = (LinearLayout) inflate.findViewById(R.id.live_beauty_reset_btn);
        this.i = (CustomViewPager) inflate.findViewById(R.id.live_beauty_viewpager);
        this.j = (LiveBeautyToolBarView) inflate.findViewById(R.id.live_beauty_tool_bar);
        this.i.setOnPageChangeListener(this.y);
        this.j.setOnToolBarItemClickListener(new LiveBeautyToolBarView.OnToolBarItemClickListener() { // from class: com.blued.android.module.live_china.view.PopBeautyNewView.3
            @Override // com.blued.android.module.live_china.view.LiveBeautyToolBarView.OnToolBarItemClickListener
            public void a(int i) {
                PopBeautyNewView.this.i.setCurrentItem(i);
            }
        });
        this.g.setMax(100);
        this.g.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.blued.android.module.live_china.view.PopBeautyNewView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (PopBeautyNewView.this.n != null) {
                    if (PopBeautyNewView.this.n.isFilter) {
                        PopBeautyNewView.this.a(i);
                    } else if (TextUtils.equals(PopBeautyNewView.this.n.id, "face_6") || TextUtils.equals(PopBeautyNewView.this.n.id, "face_7")) {
                        PopBeautyNewView.this.m.a(PopBeautyNewView.this.n.beautifyKey, (float) ((i - 50) * 2 * 0.01d));
                    } else {
                        PopBeautyNewView.this.m.a(PopBeautyNewView.this.n.beautifyKey, (float) (i * 0.01d));
                    }
                    PopBeautyNewView.this.c(i);
                    PopBeautyNewView.this.n.progress = i;
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                Tracker.onStopTrackingTouch(seekBar);
                PopBeautyNewView.this.b(seekBar.getProgress());
            }
        });
        BeautyPagerAdapter beautyPagerAdapter = new BeautyPagerAdapter();
        this.k = beautyPagerAdapter;
        this.i.setAdapter(beautyPagerAdapter);
        BeautyModel beautyModel = this.n;
        if (beautyModel != null) {
            c(beautyModel.progress);
        }
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.PopBeautyNewView.5
            /* JADX WARN: Code restructure failed: missing block: B:23:0x00b2, code lost:
                if (android.text.TextUtils.equals(r7.a.n.id, "face_3") != false) goto L26;
             */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onClick(android.view.View r8) {
                /*
                    Method dump skipped, instructions count: 313
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.view.PopBeautyNewView.AnonymousClass5.onClick(android.view.View):void");
            }
        });
        MyPopupWindow myPopupWindow = new MyPopupWindow(inflate, -1, -1, true);
        this.e = myPopupWindow;
        myPopupWindow.setBackgroundDrawable(this.b.getResources().getDrawable(com.android.internal.R.color.transparent));
        this.e.setTouchable(true);
        this.e.setOutsideTouchable(true);
        this.e.setFocusable(true);
        this.e.update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.f.setVisibility(0);
        this.g.setVisibility(0);
        this.h.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.f.setVisibility(8);
        this.g.setVisibility(8);
        this.h.setVisibility(8);
    }

    public void a() {
        RecordingOnliveFragment recordingOnliveFragment = this.l;
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
        this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_in));
    }

    public void a(int i) {
        this.m.a((float) (i * 0.01d));
    }

    public void b() {
        RecordingOnliveFragment recordingOnliveFragment = this.l;
        if (recordingOnliveFragment != null) {
            recordingOnliveFragment.P();
        }
        this.d.setVisibility(8);
        this.d.startAnimation(AnimationUtils.loadAnimation(this.b, R.anim.push_bottom_out));
        AppInfo.n().postDelayed(new Runnable() { // from class: com.blued.android.module.live_china.view.PopBeautyNewView.6
            @Override // java.lang.Runnable
            public void run() {
                PopBeautyNewView.this.e.a();
            }
        }, 300L);
    }

    public void c() {
        BluedBeautifyKey.KEY key;
        String str;
        int i;
        int q;
        String str2;
        int i2;
        String str3;
        String str4;
        BluedFilterType.FILER filer;
        int i3;
        BluedBeautifyKey.KEY key2;
        String str5;
        int i4;
        int i5;
        String str6;
        BluedBeautifyKey.KEY key3;
        String str7;
        BluedBeautifyKey.KEY key4;
        String str8;
        BluedBeautifyKey.KEY key5;
        String str9;
        int i6;
        int e;
        this.t.clear();
        this.u.clear();
        this.v.clear();
        this.w.clear();
        this.x.clear();
        String[] stringArray = this.b.getResources().getStringArray(R.array.live_beauty_title);
        String[] stringArray2 = this.b.getResources().getStringArray(R.array.live_beauty_skin);
        String[] stringArray3 = this.b.getResources().getStringArray(R.array.live_beauty_face);
        FilterDataManager.getInstance().getFilters();
        String[] stringArray4 = this.b.getResources().getStringArray(R.array.live_beauty_filter);
        String[] stringArray5 = this.b.getResources().getStringArray(R.array.live_beauty_frame);
        int length = stringArray.length;
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= length) {
                break;
            }
            this.t.add(stringArray[i8]);
            i7 = i8 + 1;
        }
        int i9 = 0;
        while (true) {
            int i10 = i9;
            String str10 = "";
            if (i10 >= stringArray2.length) {
                break;
            }
            boolean z = i10 == 0;
            if (i10 == 0) {
                key5 = BluedBeautifyKey.KEY.ST_BEAUTIFY_WHITEN_STRENGTH;
                str9 = "white";
                i6 = R.drawable.live_beauty_white;
                e = LiveRoomPreferences.e("white");
                str10 = "Skin";
            } else if (i10 == 1) {
                key5 = BluedBeautifyKey.KEY.ST_BEAUTIFY_REDDEN_STRENGTH;
                str9 = "ruddy";
                i6 = R.drawable.live_beauty_ruddy;
                e = LiveRoomPreferences.f("ruddy");
                str10 = "Ruddy";
            } else if (i10 == 2) {
                key5 = BluedBeautifyKey.KEY.ST_BEAUTIFY_SMOOTH_STRENGTH;
                str9 = "grinding";
                i6 = R.drawable.live_beauty_grinding;
                e = LiveRoomPreferences.g("grinding");
                str10 = "Smooth";
            } else if (i10 != 3) {
                str9 = "";
                i6 = 0;
                e = 0;
                key5 = null;
            } else {
                key5 = BluedBeautifyKey.KEY.ST_BEAUTIFY_WHITEN_STRENGTH;
                str9 = "highlight";
                i6 = R.drawable.live_beauty_hightlight;
                e = LiveRoomPreferences.h("highlight");
                str10 = "Matte";
            }
            BeautyModel beautyModel = new BeautyModel(key5, str9, stringArray2[i10], 0, z, e);
            beautyModel.resource = i6;
            beautyModel.eventName = str10;
            if (i10 == 0) {
                this.n = beautyModel;
            }
            this.u.add(beautyModel);
            this.m.a(beautyModel.beautifyKey, (float) (e * 0.01d));
            i9 = i10 + 1;
        }
        int i11 = 0;
        while (true) {
            int i12 = i11;
            if (i12 < stringArray3.length) {
                boolean z2 = i12 == 0;
                switch (i12) {
                    case 0:
                        key2 = BluedBeautifyKey.KEY.ST_BEAUTIFY_SHRINK_FACE_RATIO;
                        str5 = "face_1";
                        i4 = R.drawable.live_beauty_face1;
                        i5 = LiveRoomPreferences.i("face_1");
                        str6 = "Slim";
                        String str11 = str6;
                        key3 = key2;
                        str7 = str11;
                        BluedBeautifyKey.KEY key6 = key3;
                        str8 = str5;
                        key4 = key6;
                        break;
                    case 1:
                        key2 = BluedBeautifyKey.KEY.ST_BEAUTIFY_ENLARGE_EYE_RATIO;
                        str5 = "face_2";
                        i4 = R.drawable.live_beauty_face2;
                        i5 = LiveRoomPreferences.j("face_2");
                        str6 = "Enlarge";
                        String str112 = str6;
                        key3 = key2;
                        str7 = str112;
                        BluedBeautifyKey.KEY key62 = key3;
                        str8 = str5;
                        key4 = key62;
                        break;
                    case 2:
                        key2 = BluedBeautifyKey.KEY.ST_BEAUTIFY_SHRINK_JAW_RATIO;
                        str5 = "face_3";
                        i4 = R.drawable.live_beauty_face3;
                        i5 = LiveRoomPreferences.k("face_3");
                        str6 = "Face Length";
                        String str1122 = str6;
                        key3 = key2;
                        str7 = str1122;
                        BluedBeautifyKey.KEY key622 = key3;
                        str8 = str5;
                        key4 = key622;
                        break;
                    case 3:
                        key2 = BluedBeautifyKey.KEY.ST_BEAUTIFY_NARROW_FACE_STRENGTH;
                        str5 = "face_4";
                        i4 = R.drawable.live_beauty_face4;
                        i5 = LiveRoomPreferences.l("face_4");
                        str6 = "Face width";
                        String str11222 = str6;
                        key3 = key2;
                        str7 = str11222;
                        BluedBeautifyKey.KEY key6222 = key3;
                        str8 = str5;
                        key4 = key6222;
                        break;
                    case 4:
                        key3 = BluedBeautifyKey.KEY.ST_BEAUTIFY_SHRINK_FACE_RATIO;
                        str5 = "face_5";
                        i4 = R.drawable.live_beauty_face5;
                        i5 = LiveRoomPreferences.m("face_5");
                        str7 = "";
                        BluedBeautifyKey.KEY key62222 = key3;
                        str8 = str5;
                        key4 = key62222;
                        break;
                    case 5:
                        key4 = BluedBeautifyKey.KEY.ST_BEAUTIFY_3D_CHIN_LENGTH_RATIO;
                        i4 = R.drawable.live_beauty_face6;
                        i5 = LiveRoomPreferences.n("face_6");
                        str7 = "";
                        str8 = "face_6";
                        break;
                    case 6:
                        key4 = BluedBeautifyKey.KEY.ST_BEAUTIFY_3D_HAIRLINE_HEIGHT_RATIO;
                        i4 = R.drawable.live_beauty_face7;
                        i5 = LiveRoomPreferences.o("face_7");
                        str7 = "";
                        str8 = "face_7";
                        break;
                    case 7:
                        key3 = BluedBeautifyKey.KEY.ST_BEAUTIFY_3D_APPLE_MUSLE_RATIO;
                        str5 = "face_8";
                        i4 = R.drawable.live_beauty_face8;
                        i5 = LiveRoomPreferences.p("face_8");
                        str7 = "";
                        BluedBeautifyKey.KEY key622222 = key3;
                        str8 = str5;
                        key4 = key622222;
                        break;
                    default:
                        str7 = "";
                        str8 = str7;
                        i4 = 0;
                        key4 = null;
                        i5 = 0;
                        break;
                }
                BeautyModel beautyModel2 = new BeautyModel(key4, str8, stringArray3[i12], 0, z2, i5);
                beautyModel2.resource = i4;
                beautyModel2.eventName = str7;
                this.v.add(beautyModel2);
                if (TextUtils.equals(beautyModel2.id, "face_6") || TextUtils.equals(beautyModel2.id, "face_7")) {
                    this.m.a(beautyModel2.beautifyKey, (float) ((i5 - 50) * 2 * 0.01d));
                } else {
                    this.m.a(beautyModel2.beautifyKey, (float) (i5 * 0.01d));
                }
                i11 = i12 + 1;
            } else {
                int i13 = 0;
                while (true) {
                    int i14 = i13;
                    if (i14 < stringArray4.length) {
                        if (i14 != 0) {
                            if (i14 == 1) {
                                filer = BluedFilterType.FILER.RUBY;
                                str3 = "filter_ruby";
                                i2 = R.drawable.live_beauty_filter_ruby;
                                i3 = LiveRoomPreferences.f("filter_ruby");
                                str4 = "ruby";
                            } else if (i14 == 2) {
                                filer = BluedFilterType.FILER.PANSY;
                                str3 = "filter_pansy";
                                i2 = R.drawable.live_beauty_filter_pansy;
                                i3 = LiveRoomPreferences.s("filter_pansy");
                                str4 = "pansy";
                            } else if (i14 == 3) {
                                filer = BluedFilterType.FILER.MODERN;
                                str3 = "filter_morden";
                                i2 = R.drawable.live_beauty_filter_morden;
                                i3 = LiveRoomPreferences.t("filter_morden");
                                str4 = "morden";
                            } else if (i14 == 4) {
                                filer = BluedFilterType.FILER.CITY;
                                str3 = "filter_city";
                                i2 = R.drawable.live_beauty_filter_city;
                                i3 = LiveRoomPreferences.u("filter_city");
                                str4 = DistrictSearchQuery.KEYWORDS_CITY;
                            } else if (i14 != 5) {
                                str3 = "";
                                str4 = str3;
                                i2 = 0;
                            } else {
                                filer = BluedFilterType.FILER.BABYPINK;
                                str3 = "filter_babypink";
                                i2 = R.drawable.live_beauty_filter_babypink;
                                i3 = LiveRoomPreferences.v("filter_babypink");
                                str4 = "babypink";
                            }
                            BeautyModel beautyModel3 = new BeautyModel(str3, stringArray4[i14], 0, false);
                            beautyModel3.resource = i2;
                            beautyModel3.filer = filer;
                            beautyModel3.progress = i3;
                            beautyModel3.isFilter = true;
                            beautyModel3.eventName = str4;
                            this.w.add(beautyModel3);
                            i13 = i14 + 1;
                        } else {
                            i2 = R.drawable.live_beauty_filter_none;
                            str3 = "filter_none";
                            str4 = "off";
                        }
                        filer = null;
                        i3 = 0;
                        BeautyModel beautyModel32 = new BeautyModel(str3, stringArray4[i14], 0, false);
                        beautyModel32.resource = i2;
                        beautyModel32.filer = filer;
                        beautyModel32.progress = i3;
                        beautyModel32.isFilter = true;
                        beautyModel32.eventName = str4;
                        this.w.add(beautyModel32);
                        i13 = i14 + 1;
                    } else {
                        String o = LiveRoomPreferences.o();
                        if (TextUtils.isEmpty(o)) {
                            List<BeautyModel> list = this.w;
                            if (list != null && list.size() > 0) {
                                BeautyModel beautyModel4 = this.w.get(1);
                                beautyModel4.isSelect = true;
                                this.m.a(beautyModel4.filer);
                                a(beautyModel4.progress);
                                LiveRoomPreferences.w(beautyModel4.id);
                                EventTrackLive.a(LiveProtos.Event.LIVE_FILTER_USE, beautyModel4.eventName, LiveProtos.Status.START);
                            }
                        } else if (a(o)) {
                            this.m.a((BluedFilterType.FILER) null);
                        } else {
                            int i15 = 0;
                            while (true) {
                                int i16 = i15;
                                if (i16 < this.w.size()) {
                                    BeautyModel beautyModel5 = this.w.get(i16);
                                    if (o.equals(beautyModel5.id)) {
                                        beautyModel5.isSelect = true;
                                        this.m.a(beautyModel5.filer);
                                        a(beautyModel5.progress);
                                    } else {
                                        i15 = i16 + 1;
                                    }
                                }
                            }
                        }
                        int i17 = 0;
                        while (true) {
                            int i18 = i17;
                            if (i18 >= stringArray5.length) {
                                BeautyPagerAdapter beautyPagerAdapter = this.k;
                                if (beautyPagerAdapter != null) {
                                    beautyPagerAdapter.notifyDataSetChanged();
                                    return;
                                }
                                return;
                            }
                            boolean z3 = i18 == 0;
                            if (i18 == 0) {
                                key = BluedBeautifyKey.KEY.ST_BEAUTIFY_CONSTRACT_STRENGTH;
                                str = "contrast";
                                i = R.drawable.live_beauty_contrast;
                                q = LiveRoomPreferences.q("contrast");
                                str2 = "Contrast";
                            } else if (i18 != 1) {
                                key = null;
                                str2 = "";
                                str = str2;
                                i = 0;
                                q = 0;
                            } else {
                                key = BluedBeautifyKey.KEY.ST_BEAUTIFY_SATURATION_STRENGTH;
                                str = "saturation";
                                i = R.drawable.live_beauty_saturation;
                                q = LiveRoomPreferences.r("saturation");
                                str2 = "Saturation";
                            }
                            BeautyModel beautyModel6 = new BeautyModel(key, str, stringArray5[i18], 0, z3, q);
                            beautyModel6.resource = i;
                            beautyModel6.eventName = str2;
                            this.x.add(beautyModel6);
                            this.m.a(beautyModel6.beautifyKey, (float) (q * 0.01d));
                            i17 = i18 + 1;
                        }
                    }
                }
            }
        }
    }

    public boolean d() {
        return TextUtils.isEmpty(LiveRoomPreferences.o());
    }

    public String e() {
        BeautyModel d = d(2);
        return d != null ? d.eventName : "";
    }
}
