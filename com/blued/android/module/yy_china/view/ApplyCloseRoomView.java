package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.DialogApplyCloseRoomLayoutBinding;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import java.lang.ref.WeakReference;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ApplyCloseRoomView.class */
public class ApplyCloseRoomView extends FrameLayout implements View.OnClickListener {
    public final int a;
    private DialogApplyCloseRoomLayoutBinding b;
    private View.OnClickListener c;
    private int d;
    private int e;
    private BaseYYStudioFragment f;
    private TimeHandler g;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ApplyCloseRoomView$TimeHandler.class */
    public static class TimeHandler extends Handler {
        private WeakReference<ApplyCloseRoomView> a;

        public TimeHandler(ApplyCloseRoomView applyCloseRoomView) {
            this.a = new WeakReference<>(applyCloseRoomView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what != 1 || this.a.get() == null) {
                return;
            }
            this.a.get().a();
        }
    }

    public ApplyCloseRoomView(Context context) {
        this(context, null);
    }

    public ApplyCloseRoomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ApplyCloseRoomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 1;
        this.e = 0;
        DialogApplyCloseRoomLayoutBinding a = DialogApplyCloseRoomLayoutBinding.a(LayoutInflater.from(context), this, true);
        this.b = a;
        a.c.setOnClickListener(this);
        this.b.a.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int i = this.d - 1;
        this.d = i;
        if (i < 0) {
            View.OnClickListener onClickListener = this.c;
            if (onClickListener != null) {
                onClickListener.onClick(null);
                return;
            }
            return;
        }
        TextView textView = this.b.b;
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.d);
        sb.append("S)");
        textView.setText(sb);
        getmHandler().removeCallbacksAndMessages(null);
        getmHandler().sendEmptyMessageDelayed(1, 1000L);
    }

    private TimeHandler getmHandler() {
        if (this.g == null) {
            this.g = new TimeHandler(this);
        }
        return this.g;
    }

    public void a(int i) {
        this.d = i;
        getmHandler().removeCallbacksAndMessages(null);
        getmHandler().sendEmptyMessage(1);
    }

    public void a(View.OnClickListener onClickListener, BaseYYStudioFragment baseYYStudioFragment) {
        this.c = onClickListener;
        this.f = baseYYStudioFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        int id = view.getId();
        if (id == R.id.ok) {
            this.e = 1;
            View.OnClickListener onClickListener = this.c;
            if (onClickListener != null) {
                onClickListener.onClick(null);
            }
        } else if (id == R.id.cancle) {
            this.e = 0;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && this.e != 0) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_HANG_WARN_CLOSE_CLICK, b.room_id, b.uid);
        }
        BaseYYStudioFragment baseYYStudioFragment = this.f;
        if (baseYYStudioFragment != null) {
            baseYYStudioFragment.y();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        TimeHandler timeHandler = this.g;
        if (timeHandler != null) {
            timeHandler.removeCallbacksAndMessages(null);
            this.g = null;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            String str = b.room_id;
            YYRoomHttpUtils.b(str, this.e + "", new BluedUIHttpResponse<BluedEntityA<Object>>(null) { // from class: com.blued.android.module.yy_china.view.ApplyCloseRoomView.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                }
            }, (IRequestHost) null);
        }
    }
}
