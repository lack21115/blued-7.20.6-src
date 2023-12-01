package com.blued.android.module.yy_china.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYMsgKickInfoExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.YYHostEndView;
import com.blued.android.module.yy_china.view.YYOtherEndView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYRoomEndCloseFragment.class */
public class YYRoomEndCloseFragment extends MvpFragment<MvpPresenter> {
    protected YYHostEndView a;
    protected YYOtherEndView b;
    private String c;
    private boolean d;
    private boolean e;
    private YYMsgKickInfoExtra f;

    private void b(final YYMsgKickInfoExtra yYMsgKickInfoExtra) {
        if (yYMsgKickInfoExtra == null || TextUtils.isEmpty(yYMsgKickInfoExtra.message)) {
            return;
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null) {
            EventTrackYY.d(ChatRoomProtos.Event.CHAT_ROOM_OWNER_OUT_MIKE_TOAST_SHOW, b.room_id, b.uid);
        }
        postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.android.module.yy_china.fragment.YYRoomEndCloseFragment.1
            @Override // java.lang.Runnable
            public void run() {
                View inflate = LayoutInflater.from(YYRoomEndCloseFragment.this.getContext()).inflate(R.layout.dialog_warning_layout, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_warn_title);
                ((TextView) inflate.findViewById(R.id.tv_warn)).setText(yYMsgKickInfoExtra.message);
                if (TextUtils.isEmpty(yYMsgKickInfoExtra.title)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(yYMsgKickInfoExtra.title);
                }
                LiveAlterDialog.a(YYRoomEndCloseFragment.this.getContext(), inflate, (View.OnClickListener) null, new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.YYRoomEndCloseFragment.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Tracker.onClick(view);
                        if (YYRoomEndCloseFragment.this.getActivity() != null) {
                            YYRoomEndCloseFragment.this.getActivity().finish();
                        }
                    }
                }, false, false);
            }
        }, 300L);
    }

    public YYRoomEndCloseFragment a(YYMsgKickInfoExtra yYMsgKickInfoExtra) {
        this.f = yYMsgKickInfoExtra;
        return this;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public void a(Bundle bundle) {
        super.a(bundle);
        this.a = (YYHostEndView) this.i.findViewById(R.id.ll_end_view);
        this.b = (YYOtherEndView) this.i.findViewById(R.id.ll_other_end_view);
        LiveLogUtils.a("YYRoomEndCloseFragment --> leaveRoom --> 显示关播页面 ");
        if (!this.d) {
            this.b.a(this);
            this.b.setVisibility(0);
            return;
        }
        this.a.a(this, this.c, this.e);
        this.a.setVisibility(0);
        YYMsgKickInfoExtra yYMsgKickInfoExtra = this.f;
        if (yYMsgKickInfoExtra == null || this.e) {
            return;
        }
        b(yYMsgKickInfoExtra);
    }

    public YYRoomEndCloseFragment b(boolean z) {
        this.d = z;
        return this;
    }

    public YYRoomEndCloseFragment c(String str) {
        this.c = str;
        return this;
    }

    public YYRoomEndCloseFragment c(boolean z) {
        this.e = z;
        return this;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpFragment
    public int g() {
        return R.layout.fragment_yy_room_end_close;
    }
}
