package com.soft.blued.ui.search.presenter;

import android.database.Cursor;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.chat.ChatManager;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.db.BluedBaseDataHelper;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.ui.circle.model.MyCircleModel;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.das.guy.GuyProtos;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.soft.blued.http.UserHttpUtils;
import com.soft.blued.log.track.EventTrackGuy;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.search.model.SearchSessionModel;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/presenter/SearchAllPresenter.class */
public class SearchAllPresenter extends MvpPresenter {
    private Cursor n;
    private boolean m = false;
    public boolean h = false;
    public int i = 0;
    BluedUIHttpResponse j = new BluedUIHttpResponse<BluedEntityA<UserFindResult>>(g()) { // from class: com.soft.blued.ui.search.presenter.SearchAllPresenter.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public BluedEntityA<UserFindResult> parseData(String str) {
            return (BluedEntityA) super.parseData(str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<UserFindResult> bluedEntityA) {
            if (bluedEntityA == null) {
                SearchAllPresenter.this.m = false;
                return;
            }
            SearchAllPresenter.this.a("PERSON_LIST", (String) bluedEntityA.data);
            SearchAllPresenter.this.m = bluedEntityA.hasMore();
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            SearchAllPresenter.this.m = false;
            return super.onUIFailure(i, str);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish(boolean z) {
            super.onUIFinish(z);
            Log.v("drb", "onUIFinish hasMore:" + SearchAllPresenter.this.m);
            SearchAllPresenter searchAllPresenter = SearchAllPresenter.this;
            searchAllPresenter.b("PERSON_LOADING", searchAllPresenter.m);
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            SearchAllPresenter.this.d_("PERSON_LOADING");
        }
    };
    public boolean k = false;
    public boolean l = false;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, boolean z) {
        if (this.n == null || i < 0) {
            f_("MESSAGE_LIST");
            return;
        }
        ArrayList arrayList = new ArrayList();
        while (this.n != null && this.n.moveToNext()) {
            try {
                SearchSessionModel searchSessionModel = new SearchSessionModel();
                searchSessionModel.lastMsgTime = this.n.getLong(this.n.getColumnIndexOrThrow("msgTimestamp"));
                searchSessionModel.dbId = this.n.getInt(this.n.getColumnIndexOrThrow("id"));
                searchSessionModel.lastMsgContent = this.n.getString(this.n.getColumnIndexOrThrow(RemoteMessageConst.MessageBody.MSG_CONTENT));
                searchSessionModel.avatar = this.n.getString(this.n.getColumnIndexOrThrow("sessionAvatar"));
                searchSessionModel.nickName = this.n.getString(this.n.getColumnIndexOrThrow("sessionNickName"));
                searchSessionModel.vBadge = this.n.getInt(this.n.getColumnIndexOrThrow("vBadge"));
                searchSessionModel.vipAnnual = this.n.getInt(this.n.getColumnIndexOrThrow("vipAnnual"));
                searchSessionModel.vipExpLvl = this.n.getInt(this.n.getColumnIndexOrThrow("vipExpLvl"));
                searchSessionModel.vipGrade = this.n.getInt(this.n.getColumnIndexOrThrow("vipGrade"));
                searchSessionModel.hideVipLook = this.n.getInt(this.n.getColumnIndexOrThrow("hideVipLook"));
                searchSessionModel.lastMsgStateCode = this.n.getShort(this.n.getColumnIndexOrThrow("lastMsgStateCode"));
                searchSessionModel.sessionType = this.n.getShort(this.n.getColumnIndexOrThrow("sessionType"));
                searchSessionModel.f33162a = this.n.getInt(this.n.getColumnIndexOrThrow("msgCount"));
                searchSessionModel.lastMsgId = this.n.getLong(this.n.getColumnIndexOrThrow(RemoteMessageConst.MSGID));
                searchSessionModel.lastMsgLocalId = this.n.getLong(this.n.getColumnIndexOrThrow("msgLocalId"));
                searchSessionModel.f33163c = this.n.getLong(this.n.getColumnIndexOrThrow("chatDbId"));
                searchSessionModel.b = this.n.getString(this.n.getColumnIndexOrThrow("sessinoNote"));
                long j = this.n.getLong(this.n.getColumnIndexOrThrow(TextToSpeech.Engine.KEY_PARAM_SESSION_ID));
                searchSessionModel.sessionId = j;
                searchSessionModel.sessionSettingModel = ChatManager.dbOperImpl.getSessionSetting(searchSessionModel.sessionType, j);
                arrayList.add(searchSessionModel);
            } catch (Exception e) {
            }
        }
        a("MESSAGE_LIST", (String) arrayList);
        Cursor cursor = this.n;
        if (cursor == null || i2 < cursor.getCount()) {
            f_("MESSAGE_Has_MORE");
        } else {
            f_("MESSAGE_No_MORE");
        }
        m();
        b("MESSAGE_LIST", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e(String str) {
        String str2 = str;
        try {
            String replace = str.replace(BridgeUtil.SPLIT_MARK, "//").replace("'", "''").replace("[", "/[").replace("]", "/]").replace("%", "/%").replace("&", "/&").replace(BridgeUtil.UNDERLINE_STR, "/_").replace("(", "/(");
            str2 = replace;
            return replace.replace(")", "/)");
        } catch (Exception e) {
            return str2;
        }
    }

    private void f(String str) {
        FeedHttpUtils.a(str, new BluedUIHttpResponse<BluedEntityA<MyCircleModel>>(g()) { // from class: com.soft.blued.ui.search.presenter.SearchAllPresenter.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<MyCircleModel> bluedEntityA) {
                if (bluedEntityA != null) {
                    SearchAllPresenter.this.k = bluedEntityA.hasMore();
                } else {
                    SearchAllPresenter.this.k = false;
                }
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    SearchAllPresenter.this.a("CIRCLE_LIST", (String) null);
                } else {
                    SearchAllPresenter.this.a("CIRCLE_LIST", (String) bluedEntityA.data);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                SearchAllPresenter.this.k = false;
                SearchAllPresenter.this.a("CIRCLE_LIST", (String) null);
            }
        }, g());
    }

    private void g(String str) {
        FeedHttpUtils.b(str, new BluedUIHttpResponse<BluedEntityA<BluedTopic>>(g()) { // from class: com.soft.blued.ui.search.presenter.SearchAllPresenter.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedTopic> bluedEntityA) {
                if (bluedEntityA != null) {
                    SearchAllPresenter.this.l = bluedEntityA.hasMore();
                } else {
                    SearchAllPresenter.this.l = false;
                }
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    SearchAllPresenter.this.a("SUBJECT_LIST", (String) null);
                } else {
                    SearchAllPresenter.this.a("SUBJECT_LIST", (String) bluedEntityA.data);
                }
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (z) {
                    return;
                }
                SearchAllPresenter.this.l = false;
                SearchAllPresenter.this.a("SUBJECT_LIST", (String) null);
            }
        }, g());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        int i = bundle.getInt("from");
        this.i = i;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        this.h = z;
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void a(IFetchDataListener iFetchDataListener) {
    }

    public void a(final String str, final int i, final int i2, final boolean z) {
        synchronized (this) {
            ThreadManager.a().a(new Runnable() { // from class: com.soft.blued.ui.search.presenter.SearchAllPresenter.2
                @Override // java.lang.Runnable
                public void run() {
                    SearchAllPresenter.this.d_("MESSAGE_LIST");
                    if (SearchAllPresenter.this.n == null) {
                        SearchAllPresenter.this.n = BluedBaseDataHelper.a().getReadableDatabase().rawQuery("SELECT session.*, chat.msgContent, chat.msgTimestamp, chat.msgId, chat.msgLocalId, chat.id as chatDbId, chat.msgCount, setting.sessinoNote FROM  SessionModel as session INNER JOIN SessionSettingModel as setting ON session.sessionId = setting.sessionId LEFT JOIN ( SELECT sessionId, msgContent, msgTimestamp, msgId, msgLocalId, id, count(distinct msgId||msgLocalId) as msgCount FROM ChattingModel WHERE msgContent LIKE '%" + SearchAllPresenter.this.e(str) + "%' and sessionId > 0 and msgType = 1 and msgIsDelete = 0 GROUP BY sessionId) as chat ON chat.sessionId = session.sessionId WHERE (session.sessionNickName LIKE '%" + SearchAllPresenter.this.e(str) + "%' OR setting.sessinoNote LIKE '%" + SearchAllPresenter.this.e(str) + "%' OR chat.msgCount>0) and session.sessionId > 0 and session.loadName = " + ChatManager.userInfo.uid + " and (session.sessionType = 2 or session.sessionType = 3)  and setting.loadName = " + ChatManager.userInfo.uid + " ORDER BY chat.msgTimestamp DESC", null);
                    }
                    SearchAllPresenter.this.a(i, i2, z);
                }
            });
        }
    }

    public void a(String str, String str2) {
        EventTrackGuy.b(GuyProtos.Event.NEARBY_FRIEND_FILTER_SEARCH);
        UserHttpUtils.a(h(), this.j, str, str2, g());
    }

    @Override // com.blued.android.framework.ui.mvp.MvpPresenter
    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void d(String str) {
        a(str, "1");
        a(str, 0, 4, true);
        f(str);
        g(str);
    }

    public void m() {
        Cursor cursor = this.n;
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        this.n.close();
        this.n = null;
    }
}
