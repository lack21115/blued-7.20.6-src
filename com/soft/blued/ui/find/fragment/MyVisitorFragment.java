package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.ImageWrapper;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.common.url.H5Url;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.common.view.NoDataAndLoadFailView;
import com.blued.das.guy.GuyProtos;
import com.blued.das.vip.VipProtos;
import com.bytedance.applog.tracker.Tracker;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.soft.blued.R;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.log.track.EventTrackVIP;
import com.soft.blued.ui.find.adapter.VisitorListAdapter;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.model.BluedMyVisitorList;
import com.soft.blued.ui.find.model.BluedVisitorExtra;
import com.soft.blued.ui.find.model.VisitorCountExtra;
import com.soft.blued.ui.find.view.ImageLineChartRenderer;
import com.soft.blued.ui.find.view.VisitorChartMarkerView;
import com.soft.blued.ui.setting.fragment.ModifyUserInfoFragment;
import com.soft.blued.ui.user.fragment.PrivilegeBuyDialogFragment;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.user.observer.VIPBuyResultObserver;
import com.soft.blued.ui.user.presenter.PayUtils;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.PopMenuUtils;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/fragment/MyVisitorFragment.class */
public class MyVisitorFragment extends PreloadFragment implements VIPBuyResultObserver.IVIPBuyResultObserver {
    private int A;
    private int B;
    private NoDataAndLoadFailView D;
    private LineChart F;
    private View G;
    private View H;
    private View I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private TextView N;
    private TextView O;
    private ConstraintLayout P;
    private LinearLayout Q;
    private TextView R;
    private View S;
    private View T;
    private ImageView U;
    private TextView V;
    private ImageView W;
    private Context l;
    private View m;
    private RenrenPullToRefreshListView n;
    private ListView o;
    private View p;
    private View q;
    private ImageView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private View v;
    private View w;
    private View x;
    private LayoutInflater y;
    private VisitorListAdapter z;
    private boolean C = true;
    private boolean E = false;
    BluedUIHttpResponse j = new BluedUIHttpResponse<BluedEntityA<VisitorCountExtra>>(getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.MyVisitorFragment.9
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<VisitorCountExtra> bluedEntityA) {
            if (bluedEntityA == null || bluedEntityA.data == null || bluedEntityA.data.size() == 0) {
                return;
            }
            if (MyVisitorFragment.this.H.getVisibility() == 0) {
                MyVisitorFragment.this.a(bluedEntityA.getSingleData());
            }
            if (bluedEntityA.getSingleData().new_user == 1) {
                MyVisitorFragment.this.v.setVisibility(8);
            }
            if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0) {
                MyVisitorFragment.this.s.setText(DistanceUtils.a(MyVisitorFragment.this.l, Long.valueOf(bluedEntityA.getSingleData().history)));
            }
            if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
                MyVisitorFragment.this.t.setVisibility(8);
            } else if (bluedEntityA.getSingleData().increase == 0) {
                MyVisitorFragment.this.t.setVisibility(8);
            } else {
                String a2 = DistanceUtils.a(MyVisitorFragment.this.l, Long.valueOf(bluedEntityA.getSingleData().increase));
                if (!StringUtils.d(a2)) {
                    MyVisitorFragment.this.t.setText("+" + a2);
                    MyVisitorFragment.this.t.setVisibility(0);
                }
            }
            final VisitorCountExtra singleData = bluedEntityA.getSingleData();
            if (BluedConfig.a().T() != 1 || singleData.often_see_you == null || singleData.seen_each_other == null) {
                MyVisitorFragment.this.P.setVisibility(0);
                MyVisitorFragment.this.Q.setVisibility(8);
            } else {
                MyVisitorFragment.this.P.setVisibility(8);
                MyVisitorFragment.this.Q.setVisibility(0);
                TextView textView = MyVisitorFragment.this.R;
                textView.setText(DistanceUtils.a(MyVisitorFragment.this.l, Long.valueOf(singleData.today)) + MyVisitorFragment.this.l.getString(R.string.times));
                ImageWrapper b = ImageLoader.a(MyVisitorFragment.this.getFragmentActive(), singleData.often_see_you.avatar).c().d(R.drawable.icon_default_user_avatar).b(R.drawable.icon_default_user_avatar);
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
                    b.d();
                }
                b.a(MyVisitorFragment.this.U);
                MyVisitorFragment.this.S.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.MyVisitorFragment.9.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        EventTrackVIP.a(VipProtos.Event.VISIT_PAGE_OFTEN_CLICK, EventTrackVIP.b(UserInfo.getInstance().getLoginUserInfo().vip_grade));
                        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
                            PayUtils.a(MyVisitorFragment.this.getActivity(), 12, "nearby_visit_often", VipProtos.FromType.VISIT_OFTEN);
                        } else if (TextUtils.isEmpty(singleData.often_see_you.uid) || TextUtils.equals(singleData.often_see_you.uid, "0")) {
                            AppMethods.d((int) R.string.visitor_no_people_to_you);
                        } else {
                            UserInfoFragmentNew.a(MyVisitorFragment.this.l, singleData.often_see_you.uid, "my_visitor");
                        }
                    }
                });
                if (TextUtils.isEmpty(singleData.often_see_you.times)) {
                    TextView textView2 = MyVisitorFragment.this.V;
                    textView2.setText("0" + MyVisitorFragment.this.l.getString(R.string.times));
                } else {
                    TextView textView3 = MyVisitorFragment.this.V;
                    textView3.setText(singleData.often_see_you.times + MyVisitorFragment.this.l.getString(R.string.times));
                }
                ImageWrapper b2 = ImageLoader.a(MyVisitorFragment.this.getFragmentActive(), singleData.seen_each_other.avatar).d(R.drawable.icon_default_user_avatar).c().b(R.drawable.icon_default_user_avatar);
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
                    b2.d();
                }
                b2.a(MyVisitorFragment.this.W);
                MyVisitorFragment.this.T.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.MyVisitorFragment.9.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        EventTrackVIP.a(VipProtos.Event.VISIT_PAGE_EACH_CLICK, EventTrackVIP.b(UserInfo.getInstance().getLoginUserInfo().vip_grade));
                        if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0) {
                            PayUtils.a(MyVisitorFragment.this.getActivity(), 12, "nearby_visit_each", VipProtos.FromType.VISIT_EACH);
                        } else if (TextUtils.isEmpty(singleData.often_see_you.uid) || TextUtils.equals(singleData.often_see_you.uid, "0")) {
                            AppMethods.d((int) R.string.visitor_no_people_to_you);
                        } else {
                            UserInfoFragmentNew.a(MyVisitorFragment.this.l, singleData.seen_each_other.uid, "my_visitor");
                        }
                    }
                });
            }
            MyVisitorFragment.this.u.setText(DistanceUtils.a(MyVisitorFragment.this.l, Long.valueOf(bluedEntityA.getSingleData().today)));
            if (!MyVisitorFragment.this.E) {
                MyVisitorFragment.this.E = true;
                MyVisitorFragment.this.o.addHeaderView(MyVisitorFragment.this.p);
                MyVisitorFragment.this.z.notifyDataSetChanged();
            }
            if (bluedEntityA.getSingleData().visitors_is_complete_rate == 1) {
                MyVisitorFragment.this.l();
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
        }
    };
    BluedUIHttpResponse k = new BluedUIHttpResponse<BluedEntity<BluedMyVisitorList, BluedVisitorExtra>>(getFragmentActive()) { // from class: com.soft.blued.ui.find.fragment.MyVisitorFragment.10

        /* renamed from: a  reason: collision with root package name */
        boolean f30374a;

        @Override // com.blued.android.framework.http.BluedUIHttpResponse, com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onSuccess(String str) {
            Logger.a("drb", "content:" + str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            this.f30374a = true;
            if (MyVisitorFragment.this.A != 1) {
                MyVisitorFragment.w(MyVisitorFragment.this);
            }
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            MyVisitorFragment.this.n.j();
            MyVisitorFragment.this.n.q();
            if (MyVisitorFragment.this.z.getCount() != 0) {
                MyVisitorFragment.this.D.d();
            } else if (this.f30374a) {
                MyVisitorFragment.this.D.b();
            } else {
                MyVisitorFragment.this.D.a();
            }
            MyVisitorFragment.this.z.notifyDataSetChanged();
            this.f30374a = false;
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<BluedMyVisitorList, BluedVisitorExtra> bluedEntity) {
            if (bluedEntity != null) {
                try {
                    if (bluedEntity.data != null && bluedEntity.data.size() > 0) {
                        if (bluedEntity.hasMore()) {
                            MyVisitorFragment.this.C = true;
                            MyVisitorFragment.this.n.o();
                        } else {
                            MyVisitorFragment.this.C = false;
                            MyVisitorFragment.this.n.p();
                        }
                        if (MyVisitorFragment.this.A != 1) {
                            MyVisitorFragment.this.z.b(bluedEntity.data, 1);
                            return;
                        }
                        MyVisitorFragment.this.z.a(bluedEntity.data, 1);
                        MyVisitorFragment.this.z.a(bluedEntity.extra.last_visit_time);
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    AppMethods.a((CharSequence) MyVisitorFragment.this.l.getResources().getString(2131887272));
                    if (MyVisitorFragment.this.A != 1) {
                        MyVisitorFragment.w(MyVisitorFragment.this);
                        return;
                    }
                    return;
                }
            }
            if (MyVisitorFragment.this.A == 1) {
                MyVisitorFragment.this.z.a(bluedEntity.data, 1);
            }
            MyVisitorFragment.this.n.p();
            if (MyVisitorFragment.this.A != 1) {
                MyVisitorFragment.w(MyVisitorFragment.this);
                MyVisitorFragment.this.C = false;
            }
            AppMethods.a((CharSequence) MyVisitorFragment.this.l.getResources().getString(2131887275));
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public BluedEntity<BluedMyVisitorList, BluedVisitorExtra> parseData(String str) {
            return super.parseData(str);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ float a(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
        return this.F.getAxisLeft().t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, long j) {
        this.w.setVisibility(8);
        BluedPreferences.q(i + 1);
        BluedPreferences.k(j);
        if (PopMenuUtils.a(this.l)) {
            return;
        }
        ModifyUserInfoFragment.a(this.l, 0, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(VisitorCountExtra visitorCountExtra) {
        float f;
        if (BluedConfig.a().m() == 1) {
            this.M.setText(this.l.getResources().getString(R.string.open_hello_while_helloing));
        } else {
            this.M.setText(this.l.getResources().getString(R.string.open_hello_to_get_more_show));
        }
        if (visitorCountExtra.ratio <= 0 || ((UserInfo.getInstance().getLoginUserInfo().vip_grade == 0 && BluedConfig.a().g().is_advanced_recently_view != 1) || !BluedConfig.a().l())) {
            this.G.setVisibility(8);
            this.M.setVisibility(8);
            if (visitorCountExtra.show_shadow_btn == 1) {
                EventTrackVIP.a(VipProtos.Event.VISIT_PAGE_SHADOW_BTN_SHOW);
                this.O.setVisibility(0);
                this.M.setVisibility(4);
            } else {
                this.O.setVisibility(8);
            }
        } else {
            this.G.setVisibility(0);
            this.M.setVisibility(0);
            this.K.setText(visitorCountExtra.label);
            this.J.setText("↓" + visitorCountExtra.ratio + "%");
        }
        ArrayList arrayList = new ArrayList();
        if (visitorCountExtra.history_track != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= visitorCountExtra.history_track.size()) {
                    break;
                }
                arrayList.add(new Entry(i2, (float) visitorCountExtra.history_track.get(i2).count, visitorCountExtra.history_track.get(i2)));
                i = i2 + 1;
            }
        }
        if (arrayList.size() > 0) {
            int i3 = 0;
            float f2 = 0.0f;
            while (true) {
                f = f2;
                if (i3 >= arrayList.size()) {
                    break;
                }
                float f3 = f;
                if (((Entry) arrayList.get(i3)).b() >= f) {
                    f3 = ((Entry) arrayList.get(i3)).b();
                }
                i3++;
                f2 = f3;
            }
            float f4 = f * 1.5f;
            YAxis axisLeft = this.F.getAxisLeft();
            if (f4 > 0.0f) {
                axisLeft.b(f4);
            }
        }
        if (arrayList.size() == 0) {
            this.G.setVisibility(8);
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            this.M.setVisibility(8);
        } else if (this.F.getData() != null && ((LineData) this.F.getData()).d() > 0) {
            ((LineDataSet) ((LineData) this.F.getData()).a(0)).a(arrayList);
            ((LineData) this.F.getData()).b();
            this.F.h();
        } else {
            LineDataSet lineDataSet = new LineDataSet(arrayList, "");
            lineDataSet.d(7.0f);
            lineDataSet.a(LineDataSet.Mode.CUBIC_BEZIER);
            lineDataSet.c(0.2f);
            if (Build.VERSION.SDK_INT >= 18) {
                lineDataSet.d(true);
            }
            lineDataSet.c(false);
            lineDataSet.e(1.8f);
            lineDataSet.a(true);
            lineDataSet.f(true);
            lineDataSet.c(this.l.getResources().getColor(2131102416));
            lineDataSet.a(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{this.l.getResources().getColor(2131102416), this.l.getResources().getColor(2131101191)}));
            lineDataSet.g(100);
            lineDataSet.e(false);
            lineDataSet.a(new IFillFormatter() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$MyVisitorFragment$ClNYvCaxuGQdXg0JTbYwYd8vWEs
                @Override // com.github.mikephil.charting.formatter.IFillFormatter
                public final float getFillLinePosition(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
                    float a2;
                    a2 = MyVisitorFragment.this.a(iLineDataSet, lineDataProvider);
                    return a2;
                }
            });
            LineData lineData = new LineData(lineDataSet);
            lineData.a(9.0f);
            lineData.a(false);
            this.F.setData(lineData);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.A = 1;
            if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0 && BluedConfig.a().g().is_advanced_recently_view == 0) {
                this.v.setVisibility(0);
                this.v.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.MyVisitorFragment.8
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                    }
                });
                this.F.setVisibility(0);
                this.G.setVisibility(0);
                this.I.setVisibility(0);
                this.N.setVisibility(0);
                this.H.setVisibility(0);
            } else {
                this.v.setVisibility(8);
                this.F.setVisibility(0);
                this.G.setVisibility(0);
                this.I.setVisibility(0);
                this.N.setVisibility(0);
                this.H.setVisibility(0);
            }
        }
        if (this.A == 1) {
            this.C = true;
        }
        if (!this.C) {
            this.A--;
            AppMethods.a((CharSequence) this.l.getResources().getString(2131887275));
            this.n.j();
            this.n.q();
            return;
        }
        MineHttpUtils.a(this.l, this.k, UserInfo.getInstance().getLoginUserInfo().getUid(), this.A + "", BaseWrapper.ENTER_ID_SYSTEM_HELPER, getFragmentActive());
        if (z) {
            MineHttpUtils.a(this.l, this.j, UserInfo.getInstance().getLoginUserInfo().getUid(), getFragmentActive());
            if (UserInfo.getInstance().getLoginUserInfo() == null || UserInfo.getInstance().getLoginUserInfo().vip_grade != 0) {
                this.s.setVisibility(0);
                this.r.setVisibility(8);
                return;
            }
            this.s.setVisibility(4);
            this.r.setVisibility(0);
        }
    }

    static /* synthetic */ int b(MyVisitorFragment myVisitorFragment) {
        int i = myVisitorFragment.A;
        myVisitorFragment.A = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        Tracker.onClick(view);
        if (BluedConfig.a().m() == 1 || BluedConfig.a().m() == 3 || BluedConfig.a().n() > 0) {
            CallHelloManager.a().a(getContext(), getFragmentActive(), 7, new CallHelloManager.ToOpenListener() { // from class: com.soft.blued.ui.find.fragment.MyVisitorFragment.7
                @Override // com.soft.blued.ui.find.manager.CallHelloManager.ToOpenListener
                public void done(boolean z) {
                    if (z) {
                        CallHelloManager.a().a(MyVisitorFragment.this.getContext(), (IRequestHost) MyVisitorFragment.this.getFragmentActive(), false, 7);
                    }
                }
            });
            EventTrackVIP.a(VipProtos.Event.VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_CLICK, VipProtos.VocativeType.HAVE_TIMES);
            return;
        }
        EventTrackVIP.a(VipProtos.Event.VOCATIVE_OPEN_GET_MORE_EXPOSURE_BTN_CLICK, VipProtos.VocativeType.NO_TIMES);
        PrivilegeBuyDialogFragment.a(this.l, 7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        Tracker.onClick(view);
        EventTrackVIP.a(VipProtos.Event.VISIT_PAGE_SHADOW_BTN_CLICK);
        WebViewShowInfoFragment.show(this.l, H5Url.a(46, "", "visit_shadow"), -1);
    }

    private void j() {
        this.B = UserInfo.getInstance().getLoginUserInfo().vip_grade;
    }

    private void k() {
        this.y = LayoutInflater.from(this.l);
        RenrenPullToRefreshListView renrenPullToRefreshListView = (RenrenPullToRefreshListView) this.m.findViewById(2131366898);
        this.n = renrenPullToRefreshListView;
        renrenPullToRefreshListView.setRefreshEnabled(true);
        this.o = (ListView) this.n.getRefreshableView();
        VisitorListAdapter visitorListAdapter = new VisitorListAdapter(this.l, getFragmentActive());
        this.z = visitorListAdapter;
        this.o.setAdapter((ListAdapter) visitorListAdapter);
        this.o.setClipToPadding(false);
        this.o.setScrollBarStyle(33554432);
        this.o.setHeaderDividersEnabled(false);
        this.o.setDividerHeight(0);
        NoDataAndLoadFailView noDataAndLoadFailView = new NoDataAndLoadFailView(this.l);
        this.D = noDataAndLoadFailView;
        noDataAndLoadFailView.setNoDataImg(2131233632);
        this.D.setNoDataStr(R.string.no_data_for_my_visitor);
        this.o.setEmptyView(this.D);
        this.n.postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.fragment.MyVisitorFragment.1
            @Override // java.lang.Runnable
            public void run() {
                MyVisitorFragment.this.n.k();
            }
        }, 100L);
        this.n.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener() { // from class: com.soft.blued.ui.find.fragment.MyVisitorFragment.2
            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void a() {
                MyVisitorFragment.this.A = 1;
                MyVisitorFragment.this.a(true);
            }

            @Override // com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView.OnPullDownListener
            public void b() {
                MyVisitorFragment.b(MyVisitorFragment.this);
                MyVisitorFragment.this.a(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        final int cC = BluedPreferences.cC();
        if (cC >= 2) {
            return;
        }
        final long time = new Date().getTime();
        if (time - BluedPreferences.cD() < 604800000) {
            return;
        }
        this.w = this.m.findViewById(R.id.tv_edit_tip);
        this.x = this.p.findViewById(R.id.show_edit);
        this.w.setVisibility(0);
        this.w.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.MyVisitorFragment.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_OLD_VISITED_CLICK);
                MyVisitorFragment.this.a(cC, time);
            }
        });
        this.x.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.MyVisitorFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackGuy.b(GuyProtos.Event.COMPLETE_PROFILE_OLD_VISITED_CLICK);
                MyVisitorFragment.this.a(cC, time);
            }
        });
    }

    static /* synthetic */ int w(MyVisitorFragment myVisitorFragment) {
        int i = myVisitorFragment.A;
        myVisitorFragment.A = i - 1;
        return i;
    }

    @Override // com.soft.blued.ui.user.observer.VIPBuyResultObserver.IVIPBuyResultObserver
    public void a(int i, boolean z) {
        if (z) {
            a(true);
        }
    }

    @Override // com.blued.android.framework.activity.PreloadFragment
    public void a(View view) {
        FragmentActivity activity = getActivity();
        this.l = activity;
        this.m = view;
        LayoutInflater from = LayoutInflater.from(activity);
        this.y = from;
        ((ViewGroup) view).addView(from.inflate(R.layout.fragment_visit_list, (ViewGroup) null));
        k();
        h();
        j();
        VIPBuyResultObserver.a().a(this, getLifecycle());
        EventTrackGuy.b(GuyProtos.Event.NEARBY_VISIT_PAGE_SHOW);
    }

    public void h() {
        View inflate = this.y.inflate(R.layout.fragment_visitor_head, (ViewGroup) null);
        this.p = inflate;
        this.v = inflate.findViewById(R.id.layout_chart_cover);
        i();
        this.q = this.p.findViewById(R.id.show_vip);
        this.r = (ImageView) this.p.findViewById(R.id.iv_eye);
        this.s = (TextView) this.p.findViewById(R.id.tv_history);
        this.t = (TextView) this.p.findViewById(R.id.tv_increase);
        this.u = (TextView) this.p.findViewById(R.id.tv_today);
        this.P = (ConstraintLayout) this.p.findViewById(R.id.layout_part1);
        this.Q = (LinearLayout) this.p.findViewById(R.id.layout_part2);
        this.R = (TextView) this.p.findViewById(R.id.tv_count_times);
        this.S = this.p.findViewById(R.id.often_view);
        this.T = this.p.findViewById(R.id.each_view);
        this.U = (ImageView) this.p.findViewById(R.id.iv_often_avatar);
        this.V = (TextView) this.p.findViewById(R.id.tv_often_times);
        this.W = (ImageView) this.p.findViewById(R.id.iv_each_avatar);
        this.q.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.MyVisitorFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (UserInfo.getInstance().getLoginUserInfo().vip_grade == 0 && BluedConfig.a().g().is_advanced_recently_view == 0) {
                    PayUtils.a(MyVisitorFragment.this.getActivity(), 12, "nearby_visit_history", VipProtos.FromType.HISTORY);
                }
            }
        });
    }

    public void i() {
        this.F = (LineChart) this.p.findViewById(R.id.linechart);
        if (Build.VERSION.SDK_INT >= 18) {
            this.F.setVisibility(0);
        } else {
            this.F.setVisibility(4);
        }
        this.F.setPinchZoom(false);
        this.F.getLegend().d(false);
        this.F.getAxisRight().d(false);
        this.F.setDoubleTapToZoomEnabled(false);
        Description description = new Description();
        description.d(false);
        this.F.setDescription(description);
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.icon_visitor_chart_marker_circle);
        if (UserInfo.getInstance().getLoginUserInfo().vip_grade != 0 || BluedConfig.a().g().is_advanced_recently_view != 0) {
            LineChart lineChart = this.F;
            lineChart.setRenderer(new ImageLineChartRenderer(lineChart, lineChart.getAnimator(), this.F.getViewPortHandler(), decodeResource));
            VisitorChartMarkerView visitorChartMarkerView = new VisitorChartMarkerView(this.l, R.layout.item_visitor_chart_marker);
            visitorChartMarkerView.setChartView(this.F);
            this.F.setMarker(visitorChartMarkerView);
        }
        XAxis xAxis = this.F.getXAxis();
        xAxis.d(true);
        xAxis.a(XAxis.XAxisPosition.BOTTOM);
        xAxis.c(false);
        xAxis.b(true);
        xAxis.a(this.l.getResources().getColor(2131101211));
        xAxis.a(1.0f);
        xAxis.a(false);
        YAxis axisLeft = this.F.getAxisLeft();
        axisLeft.d(false);
        axisLeft.c(false);
        axisLeft.a(false);
        this.G = this.p.findViewById(R.id.ll_trend_data);
        this.H = this.p.findViewById(R.id.fl_chart);
        this.I = this.p.findViewById(R.id.ll_date_desc);
        this.J = (TextView) this.p.findViewById(R.id.tv_trend_data);
        this.K = (TextView) this.p.findViewById(R.id.tv_trend_data_desc);
        TextView textView = (TextView) this.p.findViewById(R.id.btn_get_vip);
        this.L = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.MyVisitorFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                PayUtils.a(MyVisitorFragment.this.l, 12, "nearby_visit_fifteen_trend", VipProtos.FromType.FIFTEEN_VISIT_TREND);
            }
        });
        this.M = (TextView) this.p.findViewById(R.id.tv_open_hello);
        this.O = (TextView) this.p.findViewById(R.id.tv_open_shadow);
        this.N = (TextView) this.p.findViewById(R.id.tv_lines);
        this.O.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$MyVisitorFragment$TpO2IF1JFZEddZ2wkQw77O5HCwQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyVisitorFragment.this.e(view);
            }
        });
        this.M.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.fragment.-$$Lambda$MyVisitorFragment$A6o6ZWassH6uUGNgMtVt_Jrel9E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyVisitorFragment.this.d(view);
            }
        });
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (UserInfo.getInstance().getLoginUserInfo() == null || UserInfo.getInstance().getLoginUserInfo().vip_grade == this.B || this.m == null) {
            return;
        }
        this.B = UserInfo.getInstance().getLoginUserInfo().vip_grade;
        a(true);
    }

    @Override // com.blued.android.framework.activity.HomeTabFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
