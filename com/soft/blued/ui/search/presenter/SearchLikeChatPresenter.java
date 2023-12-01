package com.soft.blued.ui.search.presenter;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.blued.android.module.common.db.ChattingDao;
import com.blued.android.module.common.user.model.UserInfo;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.soft.blued.ui.search.model.SearchSessionModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/presenter/SearchLikeChatPresenter.class */
public class SearchLikeChatPresenter extends MvpPresenter {
    private long h;
    private short i;
    private String j;
    private String k;
    private Cursor l;
    private int m = 0;
    private int n = 20;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        synchronized (this) {
            if (this.l == null) {
                this.l = ChattingDao.a().a(this.j, this.h, this.i);
            }
            if (this.l == null || i < 0) {
                f_("empty_list");
                o();
                return;
            }
            List<SearchSessionModel> arrayList = new ArrayList<>();
            this.l.moveToPosition(i);
            int i3 = i2;
            if (i2 < 0) {
                i3 = this.l.getCount();
            }
            while (this.l.getPosition() < i3 && !this.l.isAfterLast()) {
                SearchSessionModel searchSessionModel = new SearchSessionModel();
                searchSessionModel.dbId = this.l.getInt(this.l.getColumnIndexOrThrow("id"));
                searchSessionModel.lastMsgTime = this.l.getLong(this.l.getColumnIndexOrThrow("msgTimestamp"));
                searchSessionModel.lastMsgContent = this.l.getString(this.l.getColumnIndexOrThrow(RemoteMessageConst.MessageBody.MSG_CONTENT));
                searchSessionModel.lastMsgStateCode = this.l.getShort(this.l.getColumnIndexOrThrow("msgStateCode"));
                searchSessionModel.lastMsgId = this.l.getLong(this.l.getColumnIndexOrThrow(RemoteMessageConst.MSGID));
                searchSessionModel.lastMsgLocalId = this.l.getLong(this.l.getColumnIndexOrThrow("msgLocalId"));
                searchSessionModel.avatar = this.l.getString(this.l.getColumnIndexOrThrow("avatar"));
                searchSessionModel.vBadge = this.l.getInt(this.l.getColumnIndexOrThrow("vBadge"));
                searchSessionModel.vipAnnual = this.l.getInt(this.l.getColumnIndexOrThrow("fromVipAnnual"));
                searchSessionModel.vipExpLvl = this.l.getInt(this.l.getColumnIndexOrThrow("fromVipExpLvl"));
                searchSessionModel.vipGrade = this.l.getInt(this.l.getColumnIndexOrThrow("fromVipGrade"));
                searchSessionModel.hideVipLook = this.l.getInt(this.l.getColumnIndexOrThrow("fromHideVipLook"));
                searchSessionModel.f19471a = 1;
                if (TextUtils.equals(String.valueOf(this.l.getLong(this.l.getColumnIndexOrThrow("fromId"))), UserInfo.getInstance().getLoginUserInfo().uid)) {
                    searchSessionModel.nickName = UserInfo.getInstance().getLoginUserInfo().getName();
                } else {
                    searchSessionModel.nickName = this.k;
                }
                searchSessionModel.sessionId = this.h;
                searchSessionModel.sessionType = this.i;
                arrayList.add(searchSessionModel);
                this.l.moveToNext();
            }
            a(arrayList);
            a("notify_list", arrayList);
            if (i3 >= this.l.getCount()) {
                f_("no_more_list");
                o();
            } else {
                f_("has_more_list");
                this.m++;
            }
        }
    }

    private void a(List<SearchSessionModel> list) {
        ArrayList arrayList = new ArrayList();
        SearchSessionModel searchSessionModel = null;
        for (SearchSessionModel searchSessionModel2 : list) {
            if (a(searchSessionModel, searchSessionModel2) != 0) {
                arrayList.add(searchSessionModel2);
            } else if (searchSessionModel2.dbId > searchSessionModel.dbId) {
                arrayList.remove(searchSessionModel);
                arrayList.add(searchSessionModel2);
            }
            searchSessionModel = searchSessionModel2;
        }
        list.clear();
        list.addAll(arrayList);
    }

    public int a(SearchSessionModel searchSessionModel, SearchSessionModel searchSessionModel2) {
        int i;
        if (searchSessionModel == null && searchSessionModel2 == null) {
            return 0;
        }
        int i2 = -1;
        if (searchSessionModel == null) {
            return -1;
        }
        if (searchSessionModel2 == null) {
            return 1;
        }
        int i3 = ((searchSessionModel.lastMsgId - searchSessionModel2.lastMsgId) > 0L ? 1 : ((searchSessionModel.lastMsgId - searchSessionModel2.lastMsgId) == 0L ? 0 : -1));
        if (i3 != 0) {
            if (i3 > 0) {
                i2 = 1;
            }
            return i2;
        }
        int i4 = ((searchSessionModel.lastMsgLocalId - searchSessionModel2.lastMsgLocalId) > 0L ? 1 : ((searchSessionModel.lastMsgLocalId - searchSessionModel2.lastMsgLocalId) == 0L ? 0 : -1));
        if (i4 != 0) {
            if (i4 > 0) {
                i2 = 1;
            }
            return i2;
        } else if (searchSessionModel.lastMsgId == 0 && searchSessionModel.lastMsgLocalId == 0 && searchSessionModel.lastMsgTime - searchSessionModel2.lastMsgTime != 0) {
            if (i > 0) {
                i2 = 1;
            }
            return i2;
        } else {
            return 0;
        }
    }

    public void a(FragmentActivity fragmentActivity, Bundle bundle, Bundle bundle2) {
        super.a(fragmentActivity, bundle, bundle2);
        this.j = bundle.getString(UserDictionary.Words.WORD);
        this.h = bundle.getLong("passby_session_id");
        this.i = bundle.getShort("passby_session_type");
        this.k = bundle.getString("passby_nick_name");
    }

    public void a(IFetchDataListener iFetchDataListener) {
    }

    public void b(IFetchDataListener iFetchDataListener) {
    }

    public void m() {
        ThreadManager.a().a(new Runnable() { // from class: com.soft.blued.ui.search.presenter.SearchLikeChatPresenter.1
            @Override // java.lang.Runnable
            public void run() {
                SearchLikeChatPresenter searchLikeChatPresenter = SearchLikeChatPresenter.this;
                searchLikeChatPresenter.a(0, searchLikeChatPresenter.n);
            }
        });
    }

    public void n() {
        ThreadManager.a().a(new Runnable() { // from class: com.soft.blued.ui.search.presenter.SearchLikeChatPresenter.2
            @Override // java.lang.Runnable
            public void run() {
                int i = SearchLikeChatPresenter.this.m * SearchLikeChatPresenter.this.n;
                SearchLikeChatPresenter.this.a(i, SearchLikeChatPresenter.this.n + i);
            }
        });
    }

    public void o() {
        Cursor cursor = this.l;
        if (cursor == null || cursor.isClosed()) {
            return;
        }
        this.l.close();
        this.l = null;
    }

    public String p() {
        return this.k;
    }

    public String q() {
        return this.j;
    }
}
