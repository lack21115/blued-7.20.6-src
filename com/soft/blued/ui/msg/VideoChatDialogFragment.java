package com.soft.blued.ui.msg;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.chat.VideoChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.module.common.base.dialog.bottomsheet.BottomSheetDialogFragment;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.ui.msg.model.ChannelModel;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/VideoChatDialogFragment.class */
public class VideoChatDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener, VideoChatHelper.CallInfoListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f31955a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f31956c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private long j;
    private VideoChatHelper k;
    private View.OnClickListener l;

    private void h() {
        this.f31956c = (LinearLayout) this.b.findViewById(R.id.layout_try_again);
        this.d = (TextView) this.b.findViewById(R.id.tv_chat_count);
        this.e = (TextView) this.b.findViewById(R.id.tv_chat_tip);
        this.f = (TextView) this.b.findViewById(R.id.tv_try_again);
        this.g = (TextView) this.b.findViewById(R.id.tv_video_chat);
        this.h = (TextView) this.b.findViewById(R.id.tv_voice_chat);
        this.i = (TextView) this.b.findViewById(2131371051);
        this.f31956c.setOnClickListener(this);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.i.setOnClickListener(this);
    }

    private void i() {
        ThreadManager.a().a(new ThreadExecutor("startConnect") { // from class: com.soft.blued.ui.msg.VideoChatDialogFragment.1
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                if (VideoChatDialogFragment.this.k != null) {
                    VideoChatDialogFragment.this.k.getLeftTimeAndCount();
                }
            }
        });
    }

    public void a(long j) {
        this.j = j;
    }

    public void a(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    @Override // com.blued.android.chat.VideoChatHelper.CallInfoListener
    public void onCallClose(int i) {
    }

    @Override // com.blued.android.chat.VideoChatHelper.CallInfoListener
    public void onCallLeftTime(final int i, final int i2) {
        this.b.post(new Runnable() { // from class: com.soft.blued.ui.msg.VideoChatDialogFragment.2
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (i <= 0 || i2 <= 0) {
                    VideoChatDialogFragment.this.d.setVisibility(8);
                    VideoChatDialogFragment.this.f.setVisibility(8);
                    VideoChatDialogFragment.this.e.setVisibility(0);
                    VideoChatDialogFragment.this.e.setText(R.string.chat_today_count_used_up);
                    return;
                }
                VideoChatDialogFragment.this.f.setVisibility(8);
                VideoChatDialogFragment.this.e.setVisibility(8);
                VideoChatDialogFragment.this.d.setVisibility(0);
                if (i < 60) {
                    str = String.format(VideoChatDialogFragment.this.f31955a.getString(R.string.chat_today_count_call), String.valueOf(i2)) + BridgeUtil.SPLIT_MARK + String.format(VideoChatDialogFragment.this.f31955a.getString(R.string.chat_today_count_sec), String.valueOf(i));
                } else {
                    str = String.format(VideoChatDialogFragment.this.f31955a.getString(R.string.chat_today_count_call), String.valueOf(i2)) + BridgeUtil.SPLIT_MARK + String.format(VideoChatDialogFragment.this.f31955a.getString(R.string.chat_today_count_min), String.valueOf(i / 60));
                }
                VideoChatDialogFragment.this.d.setText(str);
            }
        });
    }

    @Override // com.blued.android.chat.VideoChatHelper.CallInfoListener
    public void onCallLeftTimeFail() {
        this.b.post(new Runnable() { // from class: com.soft.blued.ui.msg.VideoChatDialogFragment.3
            @Override // java.lang.Runnable
            public void run() {
                VideoChatDialogFragment.this.d.setVisibility(8);
                VideoChatDialogFragment.this.f.setVisibility(0);
                VideoChatDialogFragment.this.e.setVisibility(0);
                VideoChatDialogFragment.this.e.setText(R.string.chat_today_count_network_failed);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
        switch (view.getId()) {
            case R.id.layout_try_again /* 2131366833 */:
                i();
                return;
            case 2131371051:
                dismiss();
                return;
            case R.id.tv_video_chat /* 2131372909 */:
                View.OnClickListener onClickListener = this.l;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                ChannelModel channelModel = new ChannelModel();
                channelModel.callType = 0;
                channelModel.remoteUid = (int) this.j;
                channelModel.chat_sdk_type = UserInfo.getInstance().getLoginUserInfo().chat_sdk_type;
                DialogSkipFragment.a(AppInfo.d(), channelModel);
                dismiss();
                return;
            case R.id.tv_voice_chat /* 2131372936 */:
                View.OnClickListener onClickListener2 = this.l;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                }
                ChannelModel channelModel2 = new ChannelModel();
                channelModel2.callType = 1;
                channelModel2.remoteUid = (int) this.j;
                channelModel2.chat_sdk_type = UserInfo.getInstance().getLoginUserInfo().chat_sdk_type;
                DialogSkipFragment.a(AppInfo.d(), channelModel2);
                dismiss();
                return;
            default:
                return;
        }
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f31955a = getActivity();
        View view = this.b;
        if (view == null) {
            this.b = layoutInflater.inflate(R.layout.dialog_video_chat, viewGroup, false);
            h();
        } else if (view.getParent() != null) {
            ((ViewGroup) this.b.getParent()).removeView(this.b);
        }
        this.k = new VideoChatHelper(VideoChatHelper.ROLE.CALLER, 0L, "", 2, UserInfo.getInstance().getLoginUserInfo().chat_sdk_type, this, null);
        i();
        return this.b;
    }

    @Override // com.blued.android.chat.VideoChatHelper.CallInfoListener
    public void onSwitchToAudio() {
    }
}
