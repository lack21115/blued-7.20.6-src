package com.blued.android.module.live_china.view;

import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveConnectionInviteView.class */
public class LiveConnectionInviteView extends FrameLayout implements View.OnClickListener {
    private Context a;
    private LayoutInflater b;
    private View c;
    private LinearLayout d;
    private ImageView e;
    private TextView f;
    private RecordingOnliveFragment g;

    public LiveConnectionInviteView(Context context) {
        this(context, null);
    }

    public LiveConnectionInviteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveConnectionInviteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        c();
    }

    private void c() {
        LayoutInflater from = LayoutInflater.from(this.a);
        this.b = from;
        View inflate = from.inflate(R.layout.live_connection_invite_loading, this);
        this.c = inflate;
        this.d = (LinearLayout) inflate.findViewById(R.id.live_connection_invite_layout);
        this.e = (ImageView) this.c.findViewById(R.id.live_connection_invite_header);
        TextView textView = (TextView) this.c.findViewById(R.id.live_connection_retraction_btn);
        this.f = textView;
        textView.setOnClickListener(this);
    }

    public void a() {
        if (this.d.getVisibility() == 8) {
            return;
        }
        setVisibility(8);
        this.d.setVisibility(8);
        this.d.startAnimation(AnimationUtils.loadAnimation(this.a, R.anim.push_center_out));
        RecordingOnliveFragment recordingOnliveFragment = this.g;
        if (recordingOnliveFragment != null) {
            recordingOnliveFragment.d_(0);
        }
    }

    public void a(RecordingOnliveFragment recordingOnliveFragment) {
        this.g = recordingOnliveFragment;
    }

    public void a(String str) {
        setVisibility(0);
        this.d.clearAnimation();
        this.d.setVisibility(0);
        ImageLoader.a((IRequestHost) null, str).b(R.drawable.user_bg_round).c().a(this.e);
        this.d.startAnimation(AnimationUtils.loadAnimation(this.a, R.anim.push_center_in));
        this.g.d_(3);
    }

    public void b() {
        LiveRoomHttpUtils.o(new BluedUIHttpResponse(this.g.getFragmentActive()) { // from class: com.blued.android.module.live_china.view.LiveConnectionInviteView.2
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onFailure(Throwable th, int i, String str) {
                super.onFailure(th, i, str);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity bluedEntity) {
                LiveConnectionInviteView.this.a();
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        if (view.getId() == R.id.live_connection_retraction_btn) {
            Context context = this.a;
            CommonAlertDialog.a(context, "", context.getString(R.string.live_connection_cancel_this_invitation), this.a.getString(R.string.biao_v4_ok), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveConnectionInviteView.1
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    Tracker.onClick(dialogInterface, i);
                    LiveConnectionInviteView.this.b();
                }
            }, this.a.getString(R.string.live_window_permisson_cancel), (DialogInterface.OnClickListener) null, (DialogInterface.OnDismissListener) null);
        }
    }
}
