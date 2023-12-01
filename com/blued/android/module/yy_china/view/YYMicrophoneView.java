package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.utils.toast.ToastUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.YYConstants;
import com.blued.android.module.yy_china.databinding.ViewYyMicrophoneLayoutBinding;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYClickApplyEvent;
import com.blued.android.module.yy_china.model.YYMuteStatusModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYUserInfo;
import com.blued.android.module.yy_china.trtc_audio.manager.AudioChannelManager;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.jeremyliao.liveeventbus.LiveEventBus;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/YYMicrophoneView.class */
public class YYMicrophoneView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewYyMicrophoneLayoutBinding f18323a;
    private YYRoomModel b;

    /* renamed from: c  reason: collision with root package name */
    private ActivityFragmentActive f18324c;

    public YYMicrophoneView(Context context) {
        this(context, null);
    }

    public YYMicrophoneView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YYMicrophoneView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        this.b = YYRoomInfoManager.e().b();
        ViewYyMicrophoneLayoutBinding a2 = ViewYyMicrophoneLayoutBinding.a(LayoutInflater.from(getContext()), this, true);
        this.f18323a = a2;
        a2.b.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYMicrophoneView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                if (YYMicrophoneView.this.b == null || YYRoomInfoManager.e().c().a(YYMicrophoneView.this.getContext(), (View.OnClickListener) null)) {
                    return;
                }
                LiveLogUtils.a("YYMicrophoneView 点击上麦申请 ... ");
                EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_MIKE_CLICK, YYMicrophoneView.this.b.room_id, YYMicrophoneView.this.b.uid);
                if (TextUtils.equals(YYMicrophoneView.this.b.chat_type, "5")) {
                    LiveEventBus.get("common_apply_seat").post(new YYClickApplyEvent(YYConstants.ApplyFromSource.BottomView, "3"));
                } else if (TextUtils.equals(YYMicrophoneView.this.b.chat_type, "4")) {
                    LiveEventBus.get("common_apply_seat").post(new YYClickApplyEvent(YYConstants.ApplyFromSource.BottomView, "2"));
                } else {
                    LiveEventBus.get("common_apply_seat").post(new YYClickApplyEvent(YYConstants.ApplyFromSource.BottomView, "0"));
                }
            }
        }));
        this.f18323a.f16939a.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.YYMicrophoneView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                YYUserInfo yYUserInfo = YYRoomInfoManager.e().f17578a;
                if (yYUserInfo == null || yYUserInfo.is_open_mic != 0) {
                    YYMicrophoneView.this.a(0);
                } else {
                    YYMicrophoneView.this.a(1);
                }
            }
        }));
    }

    protected void a(int i) {
        LiveLogUtils.a("YYMicrophoneView 关麦/开麦操作 ... status: " + i);
        if (YYRoomInfoManager.e().b() == null) {
            return;
        }
        YYRoomHttpUtils.b(YYRoomInfoManager.e().b().room_id, YYRoomInfoManager.e().k(), i, new BluedUIHttpResponse<BluedEntityA<YYMuteStatusModel>>(this.f18324c) { // from class: com.blued.android.module.yy_china.view.YYMicrophoneView.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYMuteStatusModel> bluedEntityA) {
                if (bluedEntityA == null || bluedEntityA.getSingleData() == null) {
                    return;
                }
                LiveLogUtils.a("YYMicrophoneView 关麦/开麦接口请求成功 ... status: " + bluedEntityA.getSingleData().mic_status);
                ToastUtils.a(bluedEntityA.getSingleData().mic_status == 0 ? "已关麦" : "已开麦", 0);
                if (bluedEntityA.getSingleData().mic_status == 0) {
                    AudioChannelManager.j().a(true);
                } else {
                    AudioChannelManager.j().a(false);
                }
                YYObserverManager.a().c(bluedEntityA.getSingleData().mic_status);
            }
        }, this.f18324c);
    }

    public void a(boolean z) {
        this.f18323a.b.setVisibility(z ? 0 : 8);
        ImageView imageView = this.f18323a.f16939a;
        int i = 0;
        if (z) {
            i = 8;
        }
        imageView.setVisibility(i);
    }

    public void b(int i) {
        if (i == 0) {
            AudioChannelManager.j().a(true);
            this.f18323a.f16939a.setImageResource(R.drawable.icon_microphone_disable);
        } else {
            AudioChannelManager.j().a(false);
            this.f18323a.f16939a.setImageResource(R.drawable.icon_microphone);
        }
        YYUserInfo yYUserInfo = YYRoomInfoManager.e().f17578a;
        if (yYUserInfo != null) {
            yYUserInfo.is_open_mic = i;
        }
    }

    public void setFragmentActive(ActivityFragmentActive activityFragmentActive) {
        this.f18324c = activityFragmentActive;
    }
}
