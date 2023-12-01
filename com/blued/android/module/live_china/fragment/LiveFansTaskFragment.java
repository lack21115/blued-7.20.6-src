package com.blued.android.module.live_china.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveFansGoodsModel;
import com.blued.android.module.live_china.model.LiveFansInfoModel;
import com.blued.android.module.live_china.observer.LiveFansObserver;
import com.blued.android.module.live_china.presenter.LiveFansTaskPresent;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.constant.EventBusConstant;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveFansTaskFragment.class */
public class LiveFansTaskFragment extends MvpFragment<LiveFansTaskPresent> implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    View f12877a;
    TextView b;

    /* renamed from: c  reason: collision with root package name */
    TextView f12878c;
    View d;
    TextView e;
    TextView f;
    View g;
    TextView k;
    TextView l;
    View m;
    TextView n;
    TextView o;
    View p;
    TextView q;
    TextView r;
    View s;
    TextView t;
    TextView u;
    private LiveFansInfoModel v;
    private String w;
    private long x;

    private void c() {
        if (this.v.is_take_gift == 1) {
            this.u.setText(getString(R.string.live_fans_has_get));
            this.u.setTextColor(getResources().getColor(R.color.syc_dark_BABABA));
            this.u.setBackgroundResource(R.drawable.shape_fans_bg_c);
            return;
        }
        this.u.setText(getString(R.string.live_fans_to_get));
        this.u.setTextColor(getResources().getColor(R.color.syc_dark_b));
        this.u.setBackgroundResource(R.drawable.shape_fans_bg_b);
    }

    private LiveFansGuestFragment d() {
        if (getParentFragment() instanceof LiveFansGuestFragment) {
            return (LiveFansGuestFragment) getParentFragment();
        }
        return null;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        b();
    }

    public void a(LiveFansGoodsModel liveFansGoodsModel) {
        Log.i("ddrb", "setLiveFansGoodsReceived");
        this.v.is_take_gift = 1;
        c();
        LiveEventBus.get(EventBusConstant.KEY_EVENT_LIVE_REFRESH_GIFT_LIST).post(true);
    }

    public void b() {
        this.f12877a = this.i.findViewById(R.id.ll_to_wandou);
        this.b = (TextView) this.i.findViewById(R.id.tv_get_wandou);
        this.f12878c = (TextView) this.i.findViewById(R.id.tv_to_wandou);
        this.d = this.i.findViewById(R.id.ll_to_look);
        this.e = (TextView) this.i.findViewById(R.id.tv_get_look);
        this.f = (TextView) this.i.findViewById(R.id.tv_to_look);
        this.g = this.i.findViewById(R.id.ll_to_yingguang);
        this.k = (TextView) this.i.findViewById(R.id.tv_get_yingguang);
        this.l = (TextView) this.i.findViewById(R.id.tv_to_yingguang);
        this.m = this.i.findViewById(R.id.ll_to_share);
        this.n = (TextView) this.i.findViewById(R.id.tv_get_share);
        this.o = (TextView) this.i.findViewById(R.id.tv_to_share);
        this.p = this.i.findViewById(R.id.ll_to_gift);
        this.q = (TextView) this.i.findViewById(R.id.tv_get_gift);
        this.r = (TextView) this.i.findViewById(R.id.tv_to_gift);
        this.s = this.i.findViewById(R.id.ll_receive_yingguang);
        this.t = (TextView) this.i.findViewById(R.id.tv_receive_yingguang);
        this.u = (TextView) this.i.findViewById(R.id.tv_to_receive_yingguang);
        this.f12878c.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.f.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.u.setOnClickListener(this);
        if (this.v.level < 6) {
            this.p.setVisibility(8);
        } else {
            this.p.setVisibility(0);
        }
        this.b.setText(String.format(getString(R.string.live_fans_add_toady_get), Integer.valueOf(this.v.normal_gift_relation)));
        this.e.setText(String.format(getString(R.string.live_fans_add_toady_get), Integer.valueOf(this.v.watch_relation)));
        this.k.setText(String.format(getString(R.string.live_fans_add_toady_get), Integer.valueOf(this.v.gift_relation)));
        TextView textView = this.n;
        textView.setText(this.v.share_relation + "/20");
        this.q.setText(String.format(getString(R.string.live_fans_add_toady_get), Integer.valueOf(this.v.ar_gift_relation)));
        this.t.setText(String.format(getString(R.string.live_fans_add_tip_6), Integer.valueOf(this.v.gift_count)));
        c();
        EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_SHOW, LiveProtos.BtnType.SEND_WANDOU, String.valueOf(this.x), LiveRoomInfo.a().f(), LiveProtos.Status.TODO);
        EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_SHOW, LiveProtos.BtnType.LOOK_LIVE, String.valueOf(this.x), LiveRoomInfo.a().f(), LiveProtos.Status.TODO);
        EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_SHOW, LiveProtos.BtnType.SEND_GLOW_STICK, String.valueOf(this.x), LiveRoomInfo.a().f(), LiveProtos.Status.TODO);
        EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_SHOW, LiveProtos.BtnType.SHARE_LIVE, String.valueOf(this.x), LiveRoomInfo.a().f(), LiveProtos.Status.DOING);
        EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_SHOW, LiveProtos.BtnType.SEND_CLUB_GIFT, String.valueOf(this.x), LiveRoomInfo.a().f(), LiveProtos.Status.TODO);
        EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_SHOW, LiveProtos.BtnType.GET_GLOW_STICK, String.valueOf(this.x), LiveRoomInfo.a().f(), LiveProtos.Status.TODO);
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.live_fans_task;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.tv_to_wandou) {
            EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK, LiveProtos.BtnType.SEND_WANDOU, String.valueOf(this.x), LiveRoomInfo.a().f(), LiveProtos.Status.TODO);
            if (d() != null) {
                d().c();
            }
            LiveFansObserver.a().c();
        } else if (id == R.id.tv_to_look) {
            EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK, LiveProtos.BtnType.LOOK_LIVE, String.valueOf(this.x), LiveRoomInfo.a().f(), LiveProtos.Status.TODO);
            if (d() != null) {
                d().c();
            }
        } else if (id == R.id.tv_to_yingguang) {
            EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK, LiveProtos.BtnType.SEND_GLOW_STICK, String.valueOf(this.x), LiveRoomInfo.a().f(), LiveProtos.Status.TODO);
            if (d() != null) {
                d().c();
            }
            LiveFansObserver.a().c();
        } else if (id == R.id.tv_to_share) {
            EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK, LiveProtos.BtnType.SHARE_LIVE, String.valueOf(this.x), LiveRoomInfo.a().f(), LiveProtos.Status.DOING);
            if (d() != null) {
                d().c();
            }
            LiveFansObserver.a().b();
        } else if (id == R.id.tv_to_gift) {
            EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK, LiveProtos.BtnType.SEND_CLUB_GIFT, String.valueOf(this.x), LiveRoomInfo.a().f(), LiveProtos.Status.TODO);
            if (d() != null) {
                d().c();
            }
            LiveFansObserver.a().c();
        } else if (id == R.id.tv_to_receive_yingguang) {
            EventTrackLive.a(LiveProtos.Event.FANS_CLUB_PAGE_JOIN_PAGE_BTN_CLICK, LiveProtos.BtnType.GET_GLOW_STICK, String.valueOf(this.x), LiveRoomInfo.a().f(), LiveProtos.Status.TODO);
            LiveFansInfoModel liveFansInfoModel = this.v;
            if (liveFansInfoModel == null || liveFansInfoModel.is_take_gift != 0) {
                return;
            }
            j().d(this.w);
        }
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            if (getArguments().getSerializable("liveFansInfo") instanceof LiveFansInfoModel) {
                this.v = (LiveFansInfoModel) getArguments().getSerializable("liveFansInfo");
            }
            if (this.v == null) {
                this.v = new LiveFansInfoModel();
            }
            this.w = getArguments().getString("uid");
            this.x = getArguments().getLong("lid");
        }
    }
}
