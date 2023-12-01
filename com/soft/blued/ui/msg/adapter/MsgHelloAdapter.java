package com.soft.blued.ui.msg.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.android.module.common.user.UserInfoHelper;
import com.blued.das.message.MessageProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.bytedance.GuyEventUtils;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/MsgHelloAdapter.class */
public class MsgHelloAdapter extends BaseQuickAdapter<UserFindResult, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private Context f32174a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private IRequestHost f32175c;

    public MsgHelloAdapter(IRequestHost iRequestHost, Context context) {
        super(R.layout.item_msg_hello, null);
        this.b = "";
        this.f32174a = context;
        this.f32175c = iRequestHost;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(UserFindResult userFindResult, ImageView imageView, View view) {
        Tracker.onClick(view);
        EventTrackMessage.a(MessageProtos.Event.MSG_VOCATIV_USER_CLICK, MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, userFindResult.uid, false, userFindResult.call_type == 2 ? MessageProtos.CallType.CALL_SUPER : MessageProtos.CallType.CALL_COMMON);
        GuyEventUtils.a("MSG_VOCATIV_USER_CLICK", userFindResult.uid);
        LogData logData = new LogData();
        logData.logService = "msg_rec_chat_click";
        logData.position = "0";
        logData.uid = userFindResult.uid;
        InstantLog.a(logData);
        LogData logData2 = new LogData();
        logData2.from = "msg_recommend";
        logData2.is_hello = "1";
        logData2.target_uid = userFindResult.uid;
        UserInfoFragmentNew.a(this.f32174a, userFindResult, "msg_hello", userFindResult.live > 0, imageView, logData2, new MsgSourceEntity(MessageProtos.StrangerSource.APPRECIATE_CALL_SHORT, ""));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final UserFindResult userFindResult) {
        if (baseViewHolder != null) {
            final ImageView imageView = (ImageView) baseViewHolder.getView(2131364232);
            ImageView imageView2 = (ImageView) baseViewHolder.getView(2131364720);
            userFindResult.is_call = 1;
            ImageLoader.a(this.f32175c, userFindResult.avatar).b(2131237310).c().a(imageView);
            UserInfoHelper.a(imageView2, userFindResult.vbadge, 3, 1, this.f32174a.getResources().getColor(2131101191));
            baseViewHolder.setText(2131372046, userFindResult.name);
            View view = baseViewHolder.getView(2131369318);
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
            if (getHeaderLayoutCount() <= 1 || baseViewHolder.getAdapterPosition() != 0) {
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = DensityUtils.a(this.f32174a, 9.0f);
            }
            view.setLayoutParams(layoutParams);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.adapter.-$$Lambda$MsgHelloAdapter$TOqt7UAhPgrthrkw8tFvDUDUlsw
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MsgHelloAdapter.this.a(userFindResult, imageView, view2);
                }
            });
            if (userFindResult.isShowUrlVisited) {
                EventTrackMessage.a(MessageProtos.Event.MSG_VOCATIV_USER_SHOW, MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, userFindResult.uid, false, userFindResult.call_type == 2 ? MessageProtos.CallType.CALL_SUPER : MessageProtos.CallType.CALL_COMMON);
            } else {
                EventTrackMessage.a(MessageProtos.Event.MSG_VOCATIV_USER_SHOW, MessageProtos.StrangerSource.UNKNOWN_STRANGER_SOURCE, userFindResult.uid, true, userFindResult.call_type == 2 ? MessageProtos.CallType.CALL_SUPER : MessageProtos.CallType.CALL_COMMON);
                userFindResult.isShowUrlVisited = true;
            }
            GuyEventUtils.a("MSG_VOCATIV_USER_SHOW", userFindResult.uid);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<UserFindResult> list) {
        super.setNewData(list);
        this.b = "";
        if (this.mData == null || this.mData.size() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mData.size()) {
                LogData logData = new LogData();
                logData.logService = "msg_rec_chat_show";
                logData.uid = this.b;
                logData.position = "0";
                InstantLog.a(logData);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.b);
            sb.append(StringUtils.d(this.b) ? "" : "-");
            sb.append(((UserFindResult) this.mData.get(i2)).uid);
            this.b = sb.toString();
            i = i2 + 1;
        }
    }
}
