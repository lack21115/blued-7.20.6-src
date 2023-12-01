package com.blued.android.module.common.db;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.blued.android.chat.data.SessionHeader;
import com.blued.android.chat.model.SessionSettingBaseModel;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.user.model.UserInfo;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/db/SessionSettingDao.class */
public class SessionSettingDao {
    public static String a = "SessionSettingDao";
    private static SessionSettingDao b;
    private Dao<SessionSettingModel, Integer> c;

    public static SessionSettingDao a() {
        if (b == null) {
            synchronized (SessionSettingDao.class) {
                try {
                    if (b == null) {
                        b = new SessionSettingDao();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void b(List list) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            this.c.update((SessionSettingModel) ((SessionSettingBaseModel) it.next()));
        }
        return null;
    }

    public int a(final List<SessionSettingBaseModel> list) {
        int i;
        if (AppInfo.m()) {
            Logger.c("SessionSettingDao", "settingModels===" + list.size());
        }
        try {
            this.c.callBatchTasks(new Callable() { // from class: com.blued.android.module.common.db.-$$Lambda$SessionSettingDao$PS-8bCbAdE5F2ia28p5-dbGiGbI
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Void b2;
                    b2 = SessionSettingDao.this.b(list);
                    return b2;
                }
            });
            i = 1;
        } catch (Exception e) {
            e.printStackTrace();
            if (AppInfo.m()) {
                Logger.e(a, "updateSessionSettingList-ERROR: " + e.toString());
            }
            i = -1;
        }
        if (AppInfo.m()) {
            Logger.a(a, "updateSessionSettingList result: " + i);
        }
        return i;
    }

    public int a(Map<String, Object> map) {
        if (map != null) {
            try {
                UpdateBuilder updateBuilder = b().updateBuilder();
                updateBuilder.where().and().eq("loadName", UserInfo.getInstance().getLoginUserInfo().getUid());
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        updateBuilder.updateColumnValue(key, entry.getValue());
                    }
                }
                return updateBuilder.update();
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    public int a(short s, long j) {
        try {
            DeleteBuilder deleteBuilder = b().deleteBuilder();
            deleteBuilder.where().eq("loadName", UserInfo.getInstance().getLoginUserInfo().getUid()).and().eq("sessionId", Long.valueOf(j)).and().eq("sessionType", Short.valueOf(s)).and().ne("sessionType", (short) 3).and().ne("sessionType", (short) 1).and().ne("sessionId", 2).and().isNull("chatBgUri");
            return deleteBuilder.delete();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int a(short s, long j, Map<String, Object> map) {
        if (map != null) {
            try {
                if (a((int) s, j) == null) {
                    SessionSettingModel sessionSettingModel = new SessionSettingModel();
                    sessionSettingModel.setSessionType(s);
                    sessionSettingModel.setSessionId(j);
                    sessionSettingModel.updateValues(map);
                    return a(sessionSettingModel) != null ? 1 : -1;
                }
                UpdateBuilder updateBuilder = b().updateBuilder();
                updateBuilder.where().eq("sessionType", Short.valueOf(s)).and().eq("sessionId", Long.valueOf(j)).and().eq("loadName", UserInfo.getInstance().getLoginUserInfo().getUid());
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    String key = entry.getKey();
                    if (!TextUtils.isEmpty(key)) {
                        updateBuilder.updateColumnValue(key, entry.getValue());
                    }
                }
                return updateBuilder.update();
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    public SessionSettingModel a(int i, long j) {
        try {
            List query = b().queryBuilder().where().eq("sessionType", Integer.valueOf(i)).and().eq("sessionId", Long.valueOf(j)).and().eq("loadName", UserInfo.getInstance().getLoginUserInfo().getUid()).query();
            if (query.size() > 0) {
                return (SessionSettingModel) query.get(0);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public SessionSettingModel a(SessionSettingModel sessionSettingModel) {
        if (sessionSettingModel != null) {
            try {
                sessionSettingModel.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
                b().create(sessionSettingModel);
                return sessionSettingModel;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public int b(SessionSettingModel sessionSettingModel) {
        if (sessionSettingModel != null) {
            try {
                sessionSettingModel.setLoadName(Long.valueOf(UserInfo.getInstance().getLoginUserInfo().getUid()).longValue());
                return b().update(sessionSettingModel);
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return -1;
    }

    public int b(short s, long j) {
        try {
            DeleteBuilder deleteBuilder = b().deleteBuilder();
            deleteBuilder.where().eq("loadName", UserInfo.getInstance().getLoginUserInfo().getUid()).and().eq("sessionId", Long.valueOf(j)).and().eq("sessionType", Short.valueOf(s)).and().isNull("chatBgUri");
            return deleteBuilder.delete();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Dao<SessionSettingModel, Integer> b() {
        try {
            if (this.c == null) {
                this.c = BluedBaseDataHelper.a().getDao(SessionSettingModel.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.c;
    }

    public Map<String, SessionSettingModel> c() {
        try {
            ArrayMap arrayMap = new ArrayMap();
            List<SessionSettingModel> query = b().queryBuilder().where().eq("loadName", UserInfo.getInstance().getLoginUserInfo().getUid()).query();
            if (query != null) {
                if (query.size() > 0) {
                    for (SessionSettingModel sessionSettingModel : query) {
                        arrayMap.put(SessionHeader.getSessionKey(sessionSettingModel.getSessionType(), sessionSettingModel.getSessionId()), sessionSettingModel);
                    }
                }
                return arrayMap;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int d() {
        try {
            DeleteBuilder deleteBuilder = b().deleteBuilder();
            deleteBuilder.where().eq("loadName", UserInfo.getInstance().getLoginUserInfo().getUid()).and().ne("sessionType", (short) 3).and().ne("sessionType", (short) 1).and().ne("sessionId", 2).and().isNull("chatBgUri");
            return deleteBuilder.delete();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
