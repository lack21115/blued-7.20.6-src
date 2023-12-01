package com.blued.android.module.live_china.view.pkdared;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.observer.LiveRefreshUIObserver;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/pkdared/PkDaredTextBarView.class */
public class PkDaredTextBarView extends FrameLayout {
    private RelativeLayout a;
    private TextView b;
    private String c;
    private String d;

    public PkDaredTextBarView(Context context) {
        super(context);
        a(context);
    }

    public PkDaredTextBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public PkDaredTextBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public PkDaredTextBarView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        String str = this.d;
        if (str == null || str.isEmpty()) {
            return;
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_CHALLENGE_PK_EXPLAIN_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().p().profile.uid);
        LiveRefreshUIObserver.a().b(this.d, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        animate().alpha(1.0f).setDuration(200L);
    }

    public void a() {
        this.c = "";
        this.d = "";
        this.b.setText("");
        setTranslationY(0.0f);
        setAlpha(1.0f);
        setVisibility(8);
    }

    protected void a(Context context) {
        LayoutInflater.from(getContext()).inflate(R.layout.live_pk_dared_text_bar, this);
        this.a = (RelativeLayout) findViewById(R.id.rl_text_root);
        this.b = (TextView) findViewById(R.id.tv_text);
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredTextBarView$dJ_HTJ5GNgBOatx7pU-ix5iF48w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PkDaredTextBarView.this.a(view);
            }
        });
    }

    public void a(String str, String str2) {
        if (LiveRoomInfo.a().g() == LiveRoomManager.a().f()) {
            this.c = null;
            this.d = null;
            setVisibility(8);
            return;
        }
        this.c = str;
        this.d = str2;
        this.b.setText(str);
        EventTrackLive.a(LiveProtos.Event.LIVE_CHALLENGE_PK_EXPLAIN_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().p().profile.uid);
        if (getVisibility() != 0) {
            setAlpha(0.0f);
            setVisibility(0);
            post(new Runnable() { // from class: com.blued.android.module.live_china.view.pkdared.-$$Lambda$PkDaredTextBarView$zUD7gqrhLHpV_1eTppoVP6UwmiE
                @Override // java.lang.Runnable
                public final void run() {
                    PkDaredTextBarView.this.c();
                }
            });
        }
    }

    public boolean b() {
        return !TextUtils.isEmpty(this.c);
    }
}
