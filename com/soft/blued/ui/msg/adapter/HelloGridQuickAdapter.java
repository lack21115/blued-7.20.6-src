package com.soft.blued.ui.msg.adapter;

import android.content.Context;
import android.view.View;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.common.log.oldtrack.LogData;
import com.blued.das.message.MessageProtos;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.log.InstantLog;
import com.soft.blued.log.bytedance.GuyEventUtils;
import com.soft.blued.log.track.EventTrackMessage;
import com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.msg.fragment.HelloFragment;
import com.soft.blued.ui.msg.model.MsgSourceEntity;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/adapter/HelloGridQuickAdapter.class */
public class HelloGridQuickAdapter extends PeopleGridQuickAdapter {
    public HelloFragment A;
    private int B;
    private HashSet<String> C;
    private String D;
    private MessageProtos.SortType E;
    public Context v;
    public String w;
    public int x;
    public int y;
    protected IRequestHost z;

    private void a(List<UserFindResult> list) {
        if (list != null) {
            Iterator<UserFindResult> it = list.iterator();
            while (it.hasNext()) {
                UserFindResult next = it.next();
                if (c(next)) {
                    it.remove();
                } else {
                    this.C.add(next.uid);
                }
            }
        }
    }

    private boolean c(UserFindResult userFindResult) {
        if (userFindResult == null) {
            return true;
        }
        return this.C.contains(userFindResult.uid);
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void addData(int i, UserFindResult userFindResult) {
        if (c(userFindResult)) {
            return;
        }
        super.addData(i, userFindResult);
        this.C.add(userFindResult.uid);
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
        logData2.nearby_sortby = this.w;
        logData2.distance = StringUtils.d(userFindResult.distanceStr) ? userFindResult.distance : userFindResult.distanceStr;
        logData2.online_time = StringUtils.d(userFindResult.last_operate_str) ? userFindResult.last_operate : userFindResult.last_operate_str;
        logData2.type = "0";
        userFindResult.is_call = 1;
        UserInfoFragmentNew.a(this.v, userFindResult, this.w, userFindResult.live > 0, view, logData2, new MsgSourceEntity(MessageProtos.StrangerSource.APPRECIATE_CALL_TOTAL, ""));
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void a(MessageProtos.SortType sortType) {
        this.E = sortType;
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, UserFindResult userFindResult) {
        if (baseViewHolder != null) {
            baseViewHolder.getItemViewType();
            b(baseViewHolder, userFindResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(UserFindResult userFindResult, int i) {
        EventTrackMessage.a(MessageProtos.Event.CALL_PAGE_USER_CLICK, userFindResult.uid, this.E, this.A.a(), userFindResult.call_type == 2 ? MessageProtos.CallType.CALL_SUPER : MessageProtos.CallType.CALL_COMMON);
        GuyEventUtils.a("CALL_PAGE_USER_CLICK", userFindResult.uid);
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void a(String str) {
        this.D = str;
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public void addData(Collection<? extends UserFindResult> collection) {
        List<UserFindResult> arrayList = new ArrayList<>(collection);
        a(arrayList);
        super.addData((Collection<? extends UserFindResult>) arrayList);
        notifyDataSetChanged();
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public String b() {
        return this.D;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0297, code lost:
        if (r0.equals(com.soft.blued.ui.find.model.UserFindResult.USER_SORT_BY.NEARBY) != false) goto L21;
     */
    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(final com.chad.library.adapter.base.BaseViewHolder r11, final com.soft.blued.ui.find.model.UserFindResult r12) {
        /*
            Method dump skipped, instructions count: 914
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.ui.msg.adapter.HelloGridQuickAdapter.b(com.chad.library.adapter.base.BaseViewHolder, com.soft.blued.ui.find.model.UserFindResult):void");
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void b(String str) {
        this.w = str;
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter
    public void d() {
        addItemType(10, R.layout.hello_grid_single_item);
    }

    public void f(BaseViewHolder baseViewHolder, UserFindResult userFindResult) {
        if (userFindResult.isShowUrlVisited || StringUtils.d(userFindResult.uid)) {
            return;
        }
        EventTrackMessage.a(MessageProtos.Event.CALL_PAGE_USER_SHOW, userFindResult.uid, this.E, this.A.a(), userFindResult.call_type == 2 ? MessageProtos.CallType.CALL_SUPER : MessageProtos.CallType.CALL_COMMON);
        GuyEventUtils.a("CALL_PAGE_USER_SHOW", userFindResult.uid);
        userFindResult.isShowUrlVisited = true;
    }

    @Override // com.soft.blued.ui.find.adapter.PeopleGridQuickAdapter, com.chad.library.adapter.base.BaseQuickAdapter
    public void setNewData(List<UserFindResult> list) {
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
        }
        this.C.clear();
        a(arrayList);
        if (this.mData == null || this.mData.size() <= 0) {
            this.mData = new ArrayList();
            this.mData.addAll(arrayList);
        } else {
            this.mData.clear();
            this.mData.addAll(arrayList);
        }
        int i = 0;
        for (UserFindResult userFindResult : arrayList) {
            if (userFindResult.getItemType() == 10 && userFindResult.live > 0) {
                userFindResult.positionReal = i;
                i++;
            }
        }
        setEnableLoadMore(true);
        notifyDataSetChanged();
    }
}
