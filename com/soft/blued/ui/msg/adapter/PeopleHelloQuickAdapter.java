package com.soft.blued.ui.msg.adapter;

import android.app.Activity;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.das.guy.GuyProtos;
import com.blued.das.message.MessageProtos;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.bytedance.GuyEventUtils;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.msg.fragment.HelloCallNewFragment;
import com.soft.blued.ui.msg.fragment.HelloFragment;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.StringUtils;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/PeopleHelloQuickAdapter.class */
public class PeopleHelloQuickAdapter extends PeopleGridQuickAdapter {
    private MessageProtos.SortType v;
    private HelloFragment w;
    private HelloCallNewFragment x;
    private int y;

    public PeopleHelloQuickAdapter(List<UserFindResult> list, Activity activity, IRequestHost iRequestHost, String str, RecyclerView recyclerView, HelloCallNewFragment helloCallNewFragment, int i) {
        super(list, activity, iRequestHost, str, recyclerView, 1);
        this.v = MessageProtos.SortType.UNKNOWN_SORT_TYPE;
        this.x = helloCallNewFragment;
        this.w = null;
        this.y = i;
    }

    public PeopleHelloQuickAdapter(List<UserFindResult> list, Activity activity, IRequestHost iRequestHost, String str, RecyclerView recyclerView, HelloFragment helloFragment) {
        super(list, activity, iRequestHost, str, recyclerView);
        this.v = MessageProtos.SortType.UNKNOWN_SORT_TYPE;
        this.w = helloFragment;
        this.x = null;
        this.y = 2;
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void a(View view, UserFindResult userFindResult) {
        LogData logData = new LogData();
        logData.logService = "msg_rec_chat_click";
        logData.position = "1";
        logData.uid = userFindResult.uid;
        InstantLog.a(logData);
        LogData logData2 = new LogData();
        logData2.from = "msg_recommend_more";
        logData2.is_hello = "1";
        logData2.target_uid = userFindResult.uid;
        logData2.nearby_sortby = this.b;
        logData2.distance = StringUtils.d(userFindResult.distanceStr) ? userFindResult.distance : userFindResult.distanceStr;
        logData2.online_time = StringUtils.d(userFindResult.last_operate_str) ? userFindResult.last_operate : userFindResult.last_operate_str;
        logData2.type = "0";
        userFindResult.is_call = 1;
        UserInfoFragmentNew.a(this.f16394a, userFindResult, this.b, userFindResult.live > 0, view, logData2, new MsgSourceEntity(MessageProtos.StrangerSource.APPRECIATE_CALL_TOTAL, ""));
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void a(MessageProtos.SortType sortType) {
        this.v = sortType;
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void b(BaseViewHolder baseViewHolder, UserFindResult userFindResult) {
        super.b(baseViewHolder, userFindResult);
        f(baseViewHolder, userFindResult);
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void c(BaseViewHolder baseViewHolder, UserFindResult userFindResult) {
        String a2;
        HelloFragment helloFragment = this.w;
        if (helloFragment != null) {
            a2 = helloFragment.a();
        } else {
            HelloCallNewFragment helloCallNewFragment = this.x;
            a2 = helloCallNewFragment != null ? helloCallNewFragment.a() : "";
        }
        if (this.y != 2) {
            EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_MAYBE_LIKE_USER_CLICK, userFindResult.uid);
            return;
        }
        EventTrackMessage.a(MessageProtos.Event.CALL_PAGE_USER_CLICK, userFindResult.uid, this.v, a2, userFindResult.call_type == 2 ? MessageProtos.CallType.CALL_SUPER : MessageProtos.CallType.CALL_COMMON);
        GuyEventUtils.a("CALL_PAGE_USER_CLICK", userFindResult.uid);
    }

    public void f(BaseViewHolder baseViewHolder, UserFindResult userFindResult) {
        String a2;
        HelloFragment helloFragment = this.w;
        if (helloFragment != null) {
            a2 = helloFragment.a();
        } else {
            HelloCallNewFragment helloCallNewFragment = this.x;
            a2 = helloCallNewFragment != null ? helloCallNewFragment.a() : "";
        }
        if (this.y != 2) {
            EventTrackGuy.a(GuyProtos.Event.VOCATIVE_SECOND_MAYBE_LIKE_USER_SHOW, userFindResult.uid);
        } else if (userFindResult.isShowUrlVisited || StringUtils.d(userFindResult.uid)) {
        } else {
            EventTrackMessage.a(MessageProtos.Event.CALL_PAGE_USER_SHOW, userFindResult.uid, this.v, a2, userFindResult.call_type == 2 ? MessageProtos.CallType.CALL_SUPER : MessageProtos.CallType.CALL_COMMON);
            GuyEventUtils.a("CALL_PAGE_USER_SHOW", userFindResult.uid);
            userFindResult.isShowUrlVisited = true;
        }
    }
}
