package com.soft.blued.ui.find.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppInfo;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.utils.NinePatchUtils;
import com.blued.android.module.common.utils.TimeAndDateUtils;
import com.blued.android.module.common.widget.dialog.CommonAlertDialog;
import com.blued.android.module.common.widget.pop.BluedPopupWindow;
import com.blued.das.guy.GuyProtos;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.find.adapter.RecommendMixedInNearbyAdapter;
import com.soft.blued.ui.find.fragment.HelloOpenDialogFragment;
import com.soft.blued.ui.find.fragment.HelloStateDialogFragment;
import com.soft.blued.ui.find.manager.CallHelloManager;
import com.soft.blued.ui.find.model.CallMeStatusData;
import com.soft.blued.ui.find.model.FindRecommendData;
import com.soft.blued.ui.find.model.FindRecommendExtra;
import com.soft.blued.ui.find.model.UsersNewCallBubbleModel;
import com.soft.blued.ui.find.observer.NearbyViewModel;
import com.soft.blued.ui.home.HomeActivity;
import com.soft.blued.ui.login_register.model.AppConfigModel;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.user.BluedConfig;
import com.soft.blued.utils.BluedPreferences;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/RecommendViewMixedInNearby.class */
public class RecommendViewMixedInNearby extends FrameLayout implements View.OnClickListener {
    private static int B;
    private static int C;
    private BluedPopupWindow A;
    private BluedPopupWindow D;
    private boolean E;
    private BluedPopupWindow F;

    /* renamed from: a  reason: collision with root package name */
    private Context f17022a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f17023c;
    private TextView d;
    private RecyclerView e;
    private TextView f;
    private IRequestHost g;
    private ConstraintLayout h;
    private ImageView i;
    private ImageView j;
    private RecommendMixedInNearbyAdapter k;
    private boolean l;
    private int m;
    private View n;
    private ImageView o;
    private TextView p;
    private View q;
    private ImageView r;
    private TextView s;
    private View t;
    private View u;
    private ImageView v;
    private NearbyViewModel w;
    private boolean x;
    private View y;
    private BluedPopupWindow z;

    /* renamed from: com.soft.blued.ui.find.view.RecommendViewMixedInNearby$2  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/RecommendViewMixedInNearby$2.class */
    class AnonymousClass2 extends BluedUIHttpResponse<BluedEntity<FindRecommendData, FindRecommendExtra>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecommendViewMixedInNearby f17032a;

        public boolean onUIFailure(int i, String str) {
            Log.v("drb", "onUIFailure GONE");
            this.f17032a.setVisibility(8);
            if (this.f17032a.w != null) {
                this.f17032a.w.f16935a.postValue(null);
                return true;
            }
            return true;
        }

        public void onUIUpdate(final BluedEntity<FindRecommendData, FindRecommendExtra> bluedEntity) {
            this.f17032a.setVisibility(0);
            if (bluedEntity.data == null || bluedEntity.data.size() == 0) {
                Log.v("drb", "onUIUpdate bluedEntity.data == null GONE");
                this.f17032a.setVisibility(8);
            }
            if (bluedEntity.data.size() < 5) {
                this.f17032a.f17023c.setVisibility(8);
            } else {
                this.f17032a.f17023c.setVisibility(0);
            }
            if (bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                if (bluedEntity.extra == null || TextUtils.isEmpty(((FindRecommendExtra) bluedEntity.extra).default_bg)) {
                    this.f17032a.v.setImageDrawable(new ColorDrawable(0));
                } else {
                    ImageLoader.a(this.f17032a.g, ((FindRecommendExtra) bluedEntity.extra).default_bg).a(this.f17032a.v);
                }
                this.f17032a.u.setVisibility(0);
                if (this.f17032a.w != null) {
                    this.f17032a.w.f16935a.postValue(null);
                }
            } else {
                this.f17032a.u.setVisibility(8);
                this.f17032a.a(0);
            }
            if (this.f17032a.k == null) {
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f17032a.getContext());
                linearLayoutManager.setOrientation(0);
                this.f17032a.e.setLayoutManager(linearLayoutManager);
                this.f17032a.k = new RecommendMixedInNearbyAdapter(this.f17032a.getContext(), this.f17032a.g, this.f17032a.e);
                this.f17032a.k.setHeaderAndEmpty(true);
                this.f17032a.k.addHeaderView(this.f17032a.t, -1, 0);
                this.f17032a.k.bindToRecyclerView(this.f17032a.e);
                this.f17032a.e.setAdapter(this.f17032a.k);
            }
            if (bluedEntity != null && bluedEntity.extra != null) {
                this.f17032a.m = ((FindRecommendExtra) bluedEntity.extra).show_call;
                this.f17032a.f();
                this.f17032a.f17023c.setText(((FindRecommendExtra) bluedEntity.extra).more_title);
                this.f17032a.b.setText(((FindRecommendExtra) bluedEntity.extra).title);
                this.f17032a.f17023c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (TextUtils.isEmpty(((FindRecommendExtra) bluedEntity.extra).more_link)) {
                            return;
                        }
                        WebViewShowInfoFragment.show(AnonymousClass2.this.f17032a.getContext(), ((FindRecommendExtra) bluedEntity.extra).more_link, -1);
                    }
                });
            }
            if (bluedEntity.data != null) {
                this.f17032a.k.setNewData(bluedEntity.data);
                CallHelloManager.a().a(this.f17032a.getContext(), this.f17032a.g, this.f17032a.getFromPage(), (CallHelloManager.ToOpenListener) null);
            }
        }
    }

    /* renamed from: com.soft.blued.ui.find.view.RecommendViewMixedInNearby$7  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/RecommendViewMixedInNearby$7.class */
    class AnonymousClass7 implements View.OnClickListener {
        AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
            EventTrackGuy.b(GuyProtos.Event.NEARBY_FRIEND_VOCATIVE_BUBBLE_CLICK);
            CallMeStatusData b = CallHelloManager.a().b();
            if (b == null || (b.free_count == 0 && b.pay_count == 0)) {
                CallHelloManager.a().a(RecommendViewMixedInNearby.this.f17022a, RecommendViewMixedInNearby.this.g, 11, new CallHelloManager.ToOpenListener() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.7.2
                    @Override // com.soft.blued.ui.find.manager.CallHelloManager.ToOpenListener
                    public void done(boolean z) {
                        if (z) {
                            CallHelloManager.a().a(RecommendViewMixedInNearby.this.getContext(), RecommendViewMixedInNearby.this.g, false, 11);
                        }
                    }
                });
            } else {
                CommonAlertDialog.a(RecommendViewMixedInNearby.this.f17022a, (String) null, RecommendViewMixedInNearby.this.f17022a.getResources().getString(R.string.call_open_tip), RecommendViewMixedInNearby.this.f17022a.getResources().getString(R.string.call_open), new DialogInterface.OnClickListener() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.7.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Tracker.onClick(dialogInterface, i);
                        EventTrackGuy.b(GuyProtos.Event.NEARBY_FRIEND_VOCATIVE_BUBBLE_OPEN_CLICK);
                        CallHelloManager.a().a(RecommendViewMixedInNearby.this.f17022a, RecommendViewMixedInNearby.this.g, 11, new CallHelloManager.ToOpenListener() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.7.1.1
                            @Override // com.soft.blued.ui.find.manager.CallHelloManager.ToOpenListener
                            public void done(boolean z) {
                                if (z) {
                                    CallHelloManager.a().a(RecommendViewMixedInNearby.this.getContext(), RecommendViewMixedInNearby.this.g, false, 11);
                                }
                            }
                        });
                    }
                }, RecommendViewMixedInNearby.this.f17022a.getResources().getString(R.string.call_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
            }
            RecommendViewMixedInNearby.this.A.dismiss();
        }
    }

    public RecommendViewMixedInNearby(Context context) {
        super(context, null);
        this.l = true;
        this.m = 0;
        this.x = false;
    }

    public RecommendViewMixedInNearby(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecommendViewMixedInNearby(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = true;
        this.m = 0;
        this.x = false;
        this.f17022a = getContext();
        a(context);
    }

    private void a(Context context) {
        View inflate = View.inflate(context, R.layout.view_home_recommend, null);
        this.t = View.inflate(context, R.layout.layout_recommend_header, null);
        this.b = (TextView) inflate.findViewById(2131372754);
        this.f17023c = (TextView) inflate.findViewById(R.id.tv_more);
        this.e = (RecyclerView) inflate.findViewById(R.id.recycler_view_recommend);
        this.i = (ImageView) inflate.findViewById(R.id.iv_title);
        this.u = inflate.findViewById(R.id.rl_empty);
        this.v = (ImageView) inflate.findViewById(R.id.iv_empty);
        this.d = (TextView) this.t.findViewById(R.id.tv_call_me_btn);
        ConstraintLayout constraintLayout = (ConstraintLayout) this.t.findViewById(R.id.cl_btn);
        this.h = constraintLayout;
        constraintLayout.setVisibility(8);
        this.j = (ImageView) this.t.findViewById(R.id.iv_call_default);
        this.f = (TextView) this.t.findViewById(2131371675);
        addView(inflate, new FrameLayout.LayoutParams(-1, -2));
        setVisibility(4);
        this.d.setOnClickListener(this);
        if (HomeActivity.f17295c != null) {
            this.w = (NearbyViewModel) ViewModelProviders.of((FragmentActivity) HomeActivity.f17295c).get(NearbyViewModel.class);
        }
    }

    private void c(final int i) {
        CallMeStatusData callData = getCallData();
        if (callData == null || callData.call_status != 5) {
            CallHelloManager.a().a(getContext(), this.g, i, new CallHelloManager.ToOpenListener() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.13
                @Override // com.soft.blued.ui.find.manager.CallHelloManager.ToOpenListener
                public void done(boolean z) {
                    if (z) {
                        CallHelloManager.a().a(RecommendViewMixedInNearby.this.getContext(), RecommendViewMixedInNearby.this.g, false, i);
                    }
                }
            });
            return;
        }
        HelloStateDialogFragment.a(getContext(), callData);
        CallHelloManager.a().a(getContext(), this.g, i, (CallHelloManager.ToOpenListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        Log.v("drb", "updateBtnVisible show_call_btn:" + this.m);
        int i = this.m;
        if (i == 0) {
            this.h.setVisibility(8);
            View view = this.n;
            if (view != null) {
                view.setVisibility(8);
            }
            View view2 = this.q;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        } else if (i == 1) {
            this.h.setVisibility(8);
            View view3 = this.n;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            View view4 = this.q;
            if (view4 != null) {
                view4.setVisibility(8);
            }
            EventTrackGuy.b(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_BTN_SHOW);
        } else if (i != 2) {
        } else {
            this.h.setVisibility(8);
            View view5 = this.n;
            if (view5 != null) {
                view5.setVisibility(8);
            }
            View view6 = this.q;
            if (view6 != null) {
                view6.setVisibility(0);
            }
            EventTrackGuy.b(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_BTN_SHOW);
        }
    }

    private void g() {
        if (this.m == 0) {
            return;
        }
        CallHelloManager.a().d();
    }

    private CallMeStatusData getCallData() {
        return CallHelloManager.a().b();
    }

    private void h() {
        ImageLoader.c(this.g, BlueAppLocal.d() ? "CN".equals(BlueAppLocal.c().getCountry().toUpperCase()) ? "call_default_ch.png" : "call_default_tw.png" : "call_default_en.png").f().g(-1).a(this.r);
    }

    private void i() {
        ImageLoader.c(this.g, BlueAppLocal.d() ? "CN".equals(BlueAppLocal.c().getCountry().toUpperCase()) ? CallHelloManager.a().g() ? "super_call_anim.png" : "call_open_ch.png" : CallHelloManager.a().g() ? "super_call_anim_tw.png" : "call_open_tw.png" : "call_open_en.png").f().g(-1).a(this.r);
    }

    private boolean j() {
        View view = this.q;
        boolean z = false;
        if (view != null) {
            z = false;
            if (view.getVisibility() == 0) {
                int[] iArr = new int[2];
                this.q.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                z = false;
                if (i != 0) {
                    z = false;
                    if (i2 != 0) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    private void k() {
        int i = this.m;
        if (i == 1) {
            this.d.setBackgroundResource(R.drawable.icon_call_me_default);
            this.j.setVisibility(0);
            this.d.setText("");
        } else if (i == 2) {
            this.p.setText("");
            this.o.setVisibility(0);
            this.o.setImageResource(R.drawable.icon_call_default_h);
            this.n.setBackgroundResource(R.drawable.icon_call_outside_bg);
            this.q.setVisibility(0);
            this.y.setVisibility(8);
            this.r.setVisibility(0);
            h();
        }
        CallHelloManager.a().c();
        CallHelloManager.a().e();
    }

    public void a() {
        setVisibility(8);
        NearbyViewModel nearbyViewModel = this.w;
        if (nearbyViewModel != null) {
            nearbyViewModel.f16935a.postValue(null);
        }
    }

    public void a(int i) {
        Rect rect = new Rect();
        getHitRect(rect);
        rect.top -= i;
        rect.bottom -= i;
        if (rect.top < 0) {
            rect.top = 0;
        }
        if (rect.bottom < 0) {
            rect.bottom = 0;
        }
        NearbyViewModel nearbyViewModel = this.w;
        if (nearbyViewModel != null) {
            nearbyViewModel.f16935a.postValue(rect);
        }
    }

    public void a(View view, View view2) {
        this.n = view;
        this.q = view2;
        this.y = view2.findViewById(R.id.rl_call_btn_loop);
        this.s = (TextView) view2.findViewById(R.id.tv_call_btn_loop);
        this.r = (ImageView) view2.findViewById(R.id.iv_call_btn_anim);
        this.o = (ImageView) view.findViewById(R.id.iv_call_icon);
        this.p = (TextView) view.findViewById(R.id.tv_call_text);
        this.n.setOnClickListener(this);
        this.q.setOnClickListener(this);
    }

    public void a(IRequestHost iRequestHost) {
        this.g = iRequestHost;
    }

    public void a(CallMeStatusData callMeStatusData) {
        if (this.m == 0 || callMeStatusData == null) {
            RecommendMixedInNearbyAdapter recommendMixedInNearbyAdapter = this.k;
            if (recommendMixedInNearbyAdapter == null || recommendMixedInNearbyAdapter.getData().size() != 0) {
                return;
            }
            Log.v("drb", "隐藏弹窗");
            setVisibility(8);
            return;
        }
        CallHelloManager.a().a(callMeStatusData);
        k();
        TextView textView = this.m == 1 ? this.d : this.p;
        ImageView imageView = this.m == 1 ? this.j : this.o;
        Log.v("drb", "notifySetCallDataUpdate data.call_status:" + callMeStatusData.call_status);
        int i = callMeStatusData.call_status;
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    Log.v("drb", "CALL_STATUS_VERIFY");
                    imageView.setVisibility(8);
                    textView.setText("");
                    if (this.m == 1) {
                        this.d.setBackgroundResource(R.drawable.icon_call_verify);
                        this.f.setText(getResources().getString(R.string.call_under_review));
                    } else {
                        this.n.setBackgroundResource(R.drawable.icon_call_verify);
                    }
                    this.y.setVisibility(0);
                    this.r.setVisibility(8);
                    this.s.setText(this.f17022a.getString(R.string.call_under_review));
                } else if (i != 4) {
                    if (i == 5) {
                        Log.v("drb", "CALL_STATUS_COMPLETE");
                        imageView.setVisibility(8);
                        textView.setText("");
                        if (this.m == 1) {
                            this.d.setBackgroundResource(R.drawable.icon_call_me_complete);
                            this.f.setText(getResources().getString(R.string.finish_call));
                        } else {
                            this.n.setBackgroundResource(R.drawable.icon_call_outside_complete);
                        }
                        this.y.setVisibility(0);
                        this.r.setVisibility(8);
                        this.s.setText(this.f17022a.getString(R.string.call_finished));
                    }
                }
            }
            Log.v("drb", "CALL_STATUS_RUNNING");
            imageView.setVisibility(8);
            if (callMeStatusData.multiples >= 10.0f) {
                textView.setText("10x");
            } else {
                float floatValue = new BigDecimal(callMeStatusData.multiples).setScale(1, 1).floatValue();
                textView.setText(floatValue + "x");
            }
            if (this.m == 1) {
                this.d.setBackgroundResource(R.drawable.icon_call_me_default);
            } else {
                textView.setTextSize(10.0f);
                this.y.setVisibility(8);
                this.r.setVisibility(0);
                i();
            }
            CallHelloManager.a().a(getContext(), this.g, getFromPage());
        } else if (callMeStatusData.free_count != 0) {
            imageView.setVisibility(0);
            textView.setText("");
            if (this.m == 1) {
                this.f.setText(getResources().getString(R.string.free_call));
            } else {
                imageView.setImageResource(R.drawable.icon_call_default_h);
                textView.setTextSize(16.0f);
            }
            this.y.setVisibility(0);
            this.r.setVisibility(8);
            this.s.setText(this.f17022a.getString(R.string.call_free));
        } else if (callMeStatusData.pay_count != 0) {
            imageView.setVisibility(8);
            textView.setText(callMeStatusData.pay_count + "");
            if (this.m == 1) {
                this.f.setText(getResources().getString(R.string.open_call));
            } else {
                textView.setTextSize(16.0f);
            }
            g();
            this.y.setVisibility(0);
            this.r.setVisibility(8);
            if (callMeStatusData.pay_count > 99) {
                TextView textView2 = this.s;
                textView2.setText("99+" + this.f17022a.getString(R.string.call_count));
            } else if (BlueAppLocal.d() || callMeStatusData.pay_count != 1) {
                TextView textView3 = this.s;
                textView3.setText(callMeStatusData.pay_count + " " + this.f17022a.getString(R.string.call_count));
            } else {
                TextView textView4 = this.s;
                textView4.setText(callMeStatusData.pay_count + " use");
            }
        } else if (this.m == 1) {
            this.f.setText(getResources().getString(R.string.open_call));
        }
        b();
    }

    public void a(final UsersNewCallBubbleModel usersNewCallBubbleModel) {
        if (usersNewCallBubbleModel.bubble_id != 0) {
            if (TextUtils.equals(usersNewCallBubbleModel.bubble_id + "", BluedPreferences.fI())) {
                return;
            }
            BluedPreferences.aA(usersNewCallBubbleModel.bubble_id + "");
            View inflate = View.inflate(getContext(), R.layout.pop_call_open_cnt_guide, null);
            BluedPopupWindow a2 = BluedPopupWindow.Builder.a((Activity) getContext(), inflate).a(true).a();
            this.F = a2;
            a2.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.14
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    RecommendViewMixedInNearby.this.F = null;
                }
            });
            TextView textView = (TextView) inflate.findViewById(R.id.tv_cnt);
            textView.setBackground(NinePatchUtils.a(NinePatchUtils.GuideArrowPosition.c, new int[0]));
            textView.setText(usersNewCallBubbleModel.text);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    EventTrackGuy.b(GuyProtos.Event.VOCATIVE_SETTINGS_POP_CLICK, usersNewCallBubbleModel.text);
                    RecommendViewMixedInNearby.this.F.dismiss();
                }
            });
            EventTrackGuy.b(GuyProtos.Event.VOCATIVE_SETTINGS_POP_SHOW, usersNewCallBubbleModel.text);
            BluedPopupWindow bluedPopupWindow = this.F;
            View view = this.q;
            bluedPopupWindow.a(view, 2, 1, view.getWidth(), DensityUtils.a(getContext(), 5.0f));
            inflate.postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.16
                @Override // java.lang.Runnable
                public void run() {
                    if (RecommendViewMixedInNearby.this.F == null || !RecommendViewMixedInNearby.this.F.isShowing()) {
                        return;
                    }
                    RecommendViewMixedInNearby.this.F.dismiss();
                }
            }, m.ag);
        }
    }

    public void a(boolean z) {
        View view;
        AppConfigModel.CallBubbleTest w;
        View view2;
        BluedPopupWindow bluedPopupWindow = this.z;
        if ((bluedPopupWindow == null || !bluedPopupWindow.isShowing()) && HomeActivity.f17295c != null && "find".equals(HomeActivity.f17295c.f()) && (view = this.q) != null && view.getGlobalVisibleRect(new Rect()) && j() && (w = BluedConfig.a().w()) != null && w.group >= 1 && w.group <= 3 && !TextUtils.isEmpty(w.text) && w.group != 3) {
            boolean z2 = w.group == 1 && B >= 100 && !z;
            boolean z3 = z2;
            if (w.group == 2) {
                z3 = z2;
                if (C >= 3) {
                    z3 = z2;
                    if (z) {
                        z3 = true;
                    }
                }
            }
            if (z3) {
                String str = UserInfo.getInstance().getLoginUserInfo().uid;
                String cF = BluedPreferences.cF();
                long time = new Date().getTime();
                long cE = BluedPreferences.cE();
                if (!cF.equals(str) || time - cE >= 86400000) {
                    String eN = BluedPreferences.eN();
                    long eM = BluedPreferences.eM();
                    if ((!eN.equals(str) || time - eM >= 86400000) && this.A == null && CallHelloManager.a().b() != null && (view2 = this.q) != null && view2.getVisibility() == 0) {
                        View inflate = View.inflate(getContext(), R.layout.pop_call_open_cnt_guide, null);
                        BluedPopupWindow a2 = BluedPopupWindow.Builder.a((Activity) getContext(), inflate).a(true).a();
                        this.A = a2;
                        a2.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.6
                            @Override // android.widget.PopupWindow.OnDismissListener
                            public void onDismiss() {
                                RecommendViewMixedInNearby.this.A = null;
                            }
                        });
                        TextView textView = (TextView) inflate.findViewById(R.id.tv_cnt);
                        textView.setBackground(NinePatchUtils.a(NinePatchUtils.GuideArrowPosition.c, new int[0]));
                        textView.setText(w.text);
                        inflate.setOnClickListener(new AnonymousClass7());
                        BluedPopupWindow bluedPopupWindow2 = this.A;
                        View view3 = this.q;
                        bluedPopupWindow2.a(view3, 2, 1, view3.getWidth(), DensityUtils.a(getContext(), 5.0f));
                        inflate.postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.8
                            @Override // java.lang.Runnable
                            public void run() {
                                if (RecommendViewMixedInNearby.this.A == null || !RecommendViewMixedInNearby.this.A.isShowing()) {
                                    return;
                                }
                                RecommendViewMixedInNearby.this.A.dismiss();
                            }
                        }, 5000L);
                        BluedPreferences.l(time);
                        BluedPreferences.S(str);
                        EventTrackGuy.b(GuyProtos.Event.NEARBY_FRIEND_VOCATIVE_BUBBLE_SHOW);
                    }
                }
            }
        }
    }

    public void a(boolean z, String str) {
        int i = this.m;
        if (i == 0) {
            return;
        }
        ImageView imageView = i == 1 ? this.j : this.o;
        TextView textView = this.m == 1 ? this.d : this.p;
        if (imageView != null && textView != null) {
            if (z) {
                imageView.setVisibility(8);
                textView.setText(str);
            } else {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.icon_call_default_h);
                textView.setText("");
            }
        }
        if (this.m == 2) {
            this.y.setVisibility(0);
            this.r.setVisibility(8);
            if (!z) {
                this.s.setText(this.f17022a.getString(R.string.call_name));
            } else if (Integer.valueOf(str).intValue() > 99) {
                TextView textView2 = this.s;
                textView2.setText("99+" + this.f17022a.getString(R.string.call_count));
            } else if (!BlueAppLocal.d() && TextUtils.equals(str, "1")) {
                TextView textView3 = this.s;
                textView3.setText(str + " use");
            } else {
                TextView textView4 = this.s;
                textView4.setText(str + " " + this.f17022a.getString(R.string.call_count));
            }
        }
    }

    public void b() {
        View view;
        View view2;
        if (!BluedConfig.a().C() || BluedPreferences.db()) {
            return;
        }
        BluedPopupWindow bluedPopupWindow = this.A;
        if ((bluedPopupWindow == null || !bluedPopupWindow.isShowing()) && HomeActivity.f17295c != null && "find".equals(HomeActivity.f17295c.f()) && (view = this.q) != null && view.getGlobalVisibleRect(new Rect()) && j() && this.z == null && CallHelloManager.a().b() != null && (view2 = this.q) != null && view2.getVisibility() == 0) {
            View inflate = View.inflate(getContext(), R.layout.pop_call_open_cnt_guide, null);
            BluedPopupWindow a2 = BluedPopupWindow.Builder.a((Activity) getContext(), inflate).a(true).a();
            this.z = a2;
            a2.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    RecommendViewMixedInNearby.this.z = null;
                }
            });
            TextView textView = (TextView) inflate.findViewById(R.id.tv_cnt);
            textView.setBackground(NinePatchUtils.a(NinePatchUtils.GuideArrowPosition.c, new int[0]));
            textView.setText(R.string.call_try_secret);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    Tracker.onClick(view3);
                    HelloOpenDialogFragment.a(RecommendViewMixedInNearby.this.f17022a, RecommendViewMixedInNearby.this.getFromPage());
                    RecommendViewMixedInNearby.this.z.dismiss();
                }
            });
            BluedPopupWindow bluedPopupWindow2 = this.z;
            View view3 = this.q;
            bluedPopupWindow2.a(view3, 2, 1, view3.getWidth(), DensityUtils.a(getContext(), 5.0f));
            inflate.postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.5
                @Override // java.lang.Runnable
                public void run() {
                    if (RecommendViewMixedInNearby.this.z == null || !RecommendViewMixedInNearby.this.z.isShowing()) {
                        return;
                    }
                    RecommendViewMixedInNearby.this.z.dismiss();
                }
            }, m.ag);
            BluedPreferences.dc();
        }
    }

    public void b(int i) {
        this.f.setText(TimeAndDateUtils.a(i, false));
    }

    public void b(CallMeStatusData callMeStatusData) {
        a(callMeStatusData);
    }

    public void b(boolean z) {
        View view;
        int i;
        View view2;
        BluedPopupWindow bluedPopupWindow = this.D;
        if (bluedPopupWindow == null || !bluedPopupWindow.isShowing()) {
            BluedPopupWindow bluedPopupWindow2 = this.z;
            if ((bluedPopupWindow2 == null || !bluedPopupWindow2.isShowing()) && HomeActivity.f17295c != null && "find".equals(HomeActivity.f17295c.f()) && (view = this.q) != null && view.getGlobalVisibleRect(new Rect()) && j() && z) {
                String str = UserInfo.getInstance().getLoginUserInfo().uid;
                String cF = BluedPreferences.cF();
                long time = new Date().getTime();
                long cE = BluedPreferences.cE();
                if (!cF.equals(str) || time - cE >= 86400000) {
                    String eN = BluedPreferences.eN();
                    long eM = BluedPreferences.eM();
                    if ((!eN.equals(str) || time - eM >= 604800000) && (i = BluedConfig.a().b().call_count) >= 4 && BluedConfig.a().b().open_call_seven_day != 1 && this.D == null && CallHelloManager.a().b() != null && (view2 = this.q) != null && view2.getVisibility() == 0) {
                        View inflate = View.inflate(getContext(), R.layout.pop_call_open_cnt_guide, null);
                        BluedPopupWindow a2 = BluedPopupWindow.Builder.a((Activity) getContext(), inflate).a(true).a();
                        this.D = a2;
                        a2.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.9
                            @Override // android.widget.PopupWindow.OnDismissListener
                            public void onDismiss() {
                                RecommendViewMixedInNearby.this.D = null;
                            }
                        });
                        TextView textView = (TextView) inflate.findViewById(R.id.tv_cnt);
                        textView.setBackground(NinePatchUtils.a(NinePatchUtils.GuideArrowPosition.c, new int[]{2131232900}));
                        String string = getContext().getString(R.string.call_stock_tip);
                        textView.setText(String.format(string, i + ""));
                        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.10
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view3) {
                                Tracker.onClick(view3);
                                EventTrackGuy.b(GuyProtos.Event.VOCATIVE_STOCK_GUIDE_POP_CLICK);
                                RecommendViewMixedInNearby.this.D.dismiss();
                            }
                        });
                        BluedPopupWindow bluedPopupWindow3 = this.D;
                        View view3 = this.q;
                        bluedPopupWindow3.a(view3, 2, 1, view3.getWidth(), DensityUtils.a(getContext(), 5.0f));
                        inflate.postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.11
                            @Override // java.lang.Runnable
                            public void run() {
                                if (RecommendViewMixedInNearby.this.D == null || !RecommendViewMixedInNearby.this.D.isShowing()) {
                                    return;
                                }
                                RecommendViewMixedInNearby.this.D.dismiss();
                            }
                        }, m.ag);
                        BluedPreferences.A(time);
                        BluedPreferences.ao(str);
                        EventTrackGuy.b(GuyProtos.Event.VOCATIVE_STOCK_GUIDE_POP_SHOW);
                    }
                }
            }
        }
    }

    public void c() {
        B++;
    }

    public void d() {
        C++;
    }

    public void e() {
        BluedPopupWindow bluedPopupWindow = this.z;
        if (bluedPopupWindow != null) {
            bluedPopupWindow.dismiss();
        }
        BluedPopupWindow bluedPopupWindow2 = this.A;
        if (bluedPopupWindow2 != null) {
            bluedPopupWindow2.dismiss();
        }
    }

    public int getFromPage() {
        return this.m == 2 ? 3 : 1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (this.E) {
            return;
        }
        CallMeStatusData callData = getCallData();
        int id = view.getId();
        if (id == 2131369245) {
            c(3);
            EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_BTN_CLICK, (callData == null || callData.call_status != 1) ? GuyProtos.VocativeStatus.VOCATIVE_CLOSE : GuyProtos.VocativeStatus.VOCATIVE_OPEN);
            EventTrackGuy.a(GuyProtos.Event.NEARBY_FRIEND_FILTER_BTN_CLICK);
        } else if (id == 2131369247) {
            this.n.performClick();
        } else if (id == 2131371043) {
            c(1);
            EventTrackGuy.a(GuyProtos.Event.HOME_GUY_PAGE_VOCATIVE_BTN_CLICK, (callData == null || callData.call_status != 1) ? GuyProtos.VocativeStatus.VOCATIVE_CLOSE : GuyProtos.VocativeStatus.VOCATIVE_OPEN);
        }
        this.E = true;
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.12
            @Override // java.lang.Runnable
            public void run() {
                RecommendViewMixedInNearby.this.E = false;
            }
        }, 1000L);
    }

    public void setEnable(boolean z) {
        this.l = z;
        setVisibility(z ? 0 : 8);
    }

    public void setMakeFriendRecommend(List<FindRecommendData> list) {
        setVisibility(0);
        if (list.size() < 5) {
            this.f17023c.setVisibility(8);
        } else {
            this.f17023c.setVisibility(0);
        }
        this.u.setVisibility(8);
        a(0);
        if (this.k == null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(0);
            this.e.setLayoutManager(linearLayoutManager);
            RecommendMixedInNearbyAdapter recommendMixedInNearbyAdapter = new RecommendMixedInNearbyAdapter(getContext(), this.g, this.e);
            this.k = recommendMixedInNearbyAdapter;
            recommendMixedInNearbyAdapter.setHeaderAndEmpty(true);
            this.k.addHeaderView(this.t, -1, 0);
            this.k.bindToRecyclerView(this.e);
            this.e.setAdapter(this.k);
        }
        this.k.setNewData(list);
    }

    public void setMakeFriendRecommendExtra(final FindRecommendExtra findRecommendExtra) {
        if (findRecommendExtra != null) {
            this.m = findRecommendExtra.show_call;
            f();
            this.f17023c.setText(findRecommendExtra.more_title);
            this.b.setText(findRecommendExtra.title);
            this.f17023c.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.find.view.RecommendViewMixedInNearby.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    if (TextUtils.isEmpty(findRecommendExtra.more_link)) {
                        return;
                    }
                    WebViewShowInfoFragment.show(RecommendViewMixedInNearby.this.getContext(), findRecommendExtra.more_link, -1);
                }
            });
        }
    }

    public void setMakeFriendRecommendNoData(FindRecommendExtra findRecommendExtra) {
        setVisibility(8);
        if (findRecommendExtra == null || TextUtils.isEmpty(findRecommendExtra.default_bg)) {
            this.v.setImageDrawable(new ColorDrawable(0));
        } else {
            ImageLoader.a(this.g, findRecommendExtra.default_bg).a(this.v);
        }
        this.u.setVisibility(0);
        NearbyViewModel nearbyViewModel = this.w;
        if (nearbyViewModel != null) {
            nearbyViewModel.f16935a.postValue(null);
        }
    }
}
