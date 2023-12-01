package com.blued.android.module.common.db;

import com.blued.android.chat.ChatManager;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.module.common.db.model.SessionModelDB;
import com.blued.android.module.common.user.model.UserInfo;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.biz.Event;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/db/SessionDao.class */
public class SessionDao {
    private static SessionDao a;
    private Dao<SessionModelDB, Integer> b;

    private SessionDao() {
    }

    public static SessionDao a() {
        if (a == null) {
            synchronized (SessionDao.class) {
                try {
                    if (a == null) {
                        a = new SessionDao();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void b(List list) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.b.create(DataTransform.a((SessionModel) it.next()));
        }
        return null;
    }

    public int a(int i, long j) {
        try {
            return b().executeRaw("delete from SessionModel  where sessionType='" + i + "' and sessionId='" + j + "' and loadName='" + ChatManager.userInfo.uid + "'", new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int a(SessionModelDB sessionModelDB) {
        try {
            return b().create(sessionModelDB);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public int a(final List<SessionModel> list) {
        try {
            this.b.callBatchTasks(new Callable() { // from class: com.blued.android.module.common.db.-$$Lambda$SessionDao$We3mr_ScHBHmlZ0jzEYBhQfRAI8
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Void b;
                    b = SessionDao.this.b(list);
                    return b;
                }
            });
            return 1;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public int a(short s, short s2) {
        try {
            return b().executeRaw("update SessionModel set lastMsgType ='" + ((int) s2) + "' where loadName='" + ChatManager.userInfo.uid + "' and lastMsgType='" + ((int) s) + "'", new String[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public int b(SessionModelDB sessionModelDB) {
        try {
            return b().update(sessionModelDB);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public Dao<SessionModelDB, Integer> b() {
        try {
            if (this.b == null) {
                this.b = BluedBaseDataHelper.a().getDao(SessionModelDB.class);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.b;
    }

    public List<SessionModelDB> c() {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            String uid = UserInfo.getInstance().getLoginUserInfo().getUid();
            if (!uid.equals(ChatManager.userInfo.uid + "")) {
                Event c = BluedStatistics.c();
                c.a("loadSessionError", 0L, 0, "userInfo: " + UserInfo.getInstance().getLoginUserInfo().getUid() + "   chat: " + ChatManager.userInfo.uid);
            }
            queryBuilder.where().eq("loadName", Long.valueOf(ChatManager.userInfo.uid));
            queryBuilder.orderBy("lastMsgTime", false);
            return queryBuilder.query();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public int d() {
        try {
            return b().executeRaw("delete from SessionModel where loadName='" + ChatManager.userInfo.uid + "'", new String[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public int e() {
        try {
            return b().executeRaw("update SessionModel set lastMsgStateCode='6' where loadName='" + ChatManager.userInfo.uid + "' and lastMsgStateCode='1'", new String[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public void f() {
        UpdateBuilder updateBuilder = b().updateBuilder();
        try {
            updateBuilder.updateColumnValue("noReadMsgCount", 0);
            updateBuilder.updateColumnValue("lastMsgId", 0);
            updateBuilder.updateColumnValue("lastMsgType", 0);
            updateBuilder.updateColumnValue("lastMsgLocalId", 0);
            updateBuilder.updateColumnValue("lastMsgContent", "");
            updateBuilder.updateColumnValue("lastMsgStateCode", (short) 0);
            updateBuilder.updateColumnValue("lastMsgFromId", 0);
            updateBuilder.updateColumnValue("lastMsgFromNickname", "");
            updateBuilder.updateColumnValue("lastMsgFromAvatar", "");
            updateBuilder.updateColumnValue("lastMsgDistance", "");
            updateBuilder.where().eq("loadName", Long.valueOf(ChatManager.userInfo.uid));
            updateBuilder.update();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void g() {
        try {
            b().executeRaw("update SessionModel set noReadMsgCount='0' where loadName='" + ChatManager.userInfo.uid + "'", new String[0]);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
