package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYFloatVoteView.class */
public class YYFloatVoteView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private BaseYYStudioFragment f18159a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f18160c;

    public YYFloatVoteView(Context context) {
        super(context);
        a();
    }

    public YYFloatVoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public YYFloatVoteView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_yy_float_vote, (ViewGroup) this, true);
        this.b = (TextView) findViewById(R.id.tv_vote_time);
        ImageView imageView = (ImageView) findViewById(R.id.to_vote);
        this.f18160c = imageView;
        imageView.setEnabled(true);
        this.f18160c.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYFloatVoteView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b != null) {
                    EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_VOTE_WINDOW_CLICK, b.room_id, b.uid);
                }
                LiveEventBus.get("show_vote_details").post("");
            }
        });
    }

    public void a(BaseYYStudioFragment baseYYStudioFragment) {
        this.f18159a = baseYYStudioFragment;
        LiveEventBus.get("show_vote_time", String.class).observe(baseYYStudioFragment, new Observer<String>() { // from class: com.blued.android.module.yy_china.view.YYFloatVoteView.2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                if (TextUtils.isEmpty(str)) {
                    YYFloatVoteView.this.b.setText("00:00");
                    YYFloatVoteView.this.setVisibility(8);
                    return;
                }
                if (YYFloatVoteView.this.getVisibility() != 0) {
                    YYFloatVoteView.this.setVisibility(0);
                }
                YYFloatVoteView.this.b.setText(str);
            }
        });
    }
}
