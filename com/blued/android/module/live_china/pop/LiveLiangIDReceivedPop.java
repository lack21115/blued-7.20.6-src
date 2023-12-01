package com.blued.android.module.live_china.pop;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.CenterPopupView;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/pop/LiveLiangIDReceivedPop.class */
public class LiveLiangIDReceivedPop extends CenterPopupView {

    /* renamed from: c  reason: collision with root package name */
    public Context f13976c;
    public final String d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private String i;
    private IRequestHost j;

    public LiveLiangIDReceivedPop(Context context) {
        super(context);
        this.d = "LiveIDReceivedPop";
        this.f13976c = context;
    }

    public static LiveLiangIDReceivedPop a(Context context, String str, IRequestHost iRequestHost) {
        LiveLiangIDReceivedPop liveLiangIDReceivedPop = new LiveLiangIDReceivedPop(context);
        liveLiangIDReceivedPop.i = str;
        liveLiangIDReceivedPop.j = iRequestHost;
        new XPopup.Builder(context).a((BasePopupView) liveLiangIDReceivedPop).h();
        return liveLiangIDReceivedPop;
    }

    private void e() {
        this.e = (ImageView) findViewById(R.id.iv_close);
        TextView textView = (TextView) findViewById(R.id.tv_id);
        this.f = textView;
        textView.setText(this.i);
        this.g = (TextView) findViewById(R.id.tv_select_id);
        this.h = (TextView) findViewById(R.id.tv_see_id);
        this.e.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.LiveLiangIDReceivedPop.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLive.d(LiveProtos.Event.BETTER_ID_POP_CLOSE_CLICK, LiveLiangIDReceivedPop.this.i);
                LiveLiangIDReceivedPop.this.p();
            }
        });
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.LiveLiangIDReceivedPop.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLive.d(LiveProtos.Event.BETTER_ID_POP_CHOOSE_CLICK, LiveLiangIDReceivedPop.this.i);
                LiveLiangIDReceivedPop.this.c();
            }
        });
        this.h.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.pop.LiveLiangIDReceivedPop.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                EventTrackLive.d(LiveProtos.Event.BETTER_ID_POP_LOOK_CLICK, LiveLiangIDReceivedPop.this.i);
                LiveLiangIDReceivedPop.this.d();
            }
        });
        EventTrackLive.b(LiveProtos.Event.BETTER_ID_POP_SHOW, this.i);
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        e();
    }

    public void c() {
        LiveRoomInfo.a().a(this.f13976c, LiveRoomInfo.a().E());
    }

    public void d() {
        LiveUserCardPop.a(this.f13976c, this.j, LiveRoomInfo.a().f());
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.live_pop_receive_id;
    }

    @Override // com.blued.android.framework.ui.xpop.core.CenterPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getMaxWidth() {
        return XPopupUtils.a(getContext());
    }
}
