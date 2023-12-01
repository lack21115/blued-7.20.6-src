package com.blued.android.module.common.db;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.module.common.db.model.ChattingModelDB;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/db/ChattingDao.class */
public class ChattingDao {
    private static ChattingDao b;
    private String a = ChattingDao.class.getSimpleName();
    private Dao<ChattingModelDB, Integer> c;

    public static ChattingDao a() {
        if (b == null) {
            synchronized (ChattingDao.class) {
                try {
                    if (b == null) {
                        b = new ChattingDao();
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
            this.c.create(DataTransform.a((ChattingModel) it.next()));
        }
        return null;
    }

    public int a(int i, long j) {
        UpdateBuilder updateBuilder = b().updateBuilder();
        try {
            updateBuilder.updateColumnValue("msgTextTranslateIsShow", 0);
            updateBuilder.updateColumnValue("msgTextTranslateContent", "");
            updateBuilder.updateColumnValue("msgTextTranslateStatus", 0);
            Where where = updateBuilder.where();
            where.and(where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), where.eq("sessionType", Integer.valueOf(i)), new Where[]{where.eq("sessionId", Long.valueOf(j)), where.eq("msgTextTranslateStatus", (short) 1)});
            return updateBuilder.update();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int a(long j, int i, long j2, long j3) {
        try {
            return b().executeRaw("update ChattingModel set msgId='" + j + "' where loadName='" + ChatManager.userInfo.uid + "' and sessionType='" + i + "' and sessionId='" + j2 + "' and msgStateCode='1' and msgLocalId>'" + j3 + "'", new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int a(ChattingModelDB chattingModelDB) {
        try {
            return b().update(chattingModelDB);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int a(ChattingModelDB chattingModelDB, boolean z) {
        try {
            chattingModelDB.getMsgExtra();
            if (z && a(chattingModelDB.sessionType, chattingModelDB.sessionId, chattingModelDB.msgId)) {
                return -1;
            }
            return b().create(chattingModelDB);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int a(final List<ChattingModel> list) {
        try {
            this.c.callBatchTasks(new Callable() { // from class: com.blued.android.module.common.db.-$$Lambda$ChattingDao$KEGlb_uz_BTUzl4b7Ax4KVcxiLQ
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Void b2;
                    b2 = ChattingDao.this.b(list);
                    return b2;
                }
            });
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int a(short s, long j) {
        int i;
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            Where where = queryBuilder.where();
            where.and(where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), where.eq("sessionType", Short.valueOf(s)), new Where[]{where.eq("sessionId", Long.valueOf(j))});
            List<ChattingModelDB> query = queryBuilder.query();
            i = 0;
            if (query != null) {
                i = 0;
                if (query.size() > 0) {
                    i = 0;
                    for (ChattingModelDB chattingModelDB : query) {
                        try {
                            Log.d("xxx", "msgModel =" + chattingModelDB);
                            if (chattingModelDB.isMatchMsg == 1) {
                                chattingModelDB.isMatchMsg = 0;
                                if (chattingModelDB.sessionId < 0) {
                                    chattingModelDB.sessionId = -chattingModelDB.sessionId;
                                }
                                try {
                                    if (!TextUtils.isEmpty(chattingModelDB.getMsgExtra())) {
                                        JsonObject asJsonObject = JsonParser.parseString(chattingModelDB.getMsgExtra()).getAsJsonObject();
                                        asJsonObject.remove("is_match_msg");
                                        chattingModelDB.setMsgExtra(asJsonObject.entrySet().isEmpty() ? "" : asJsonObject.toString());
                                    }
                                } catch (Exception e) {
                                    Log.e("xxx", e.toString());
                                }
                                Log.i("xxx", " --> msgModel =" + chattingModelDB);
                                if (b().update(chattingModelDB) > -1) {
                                    i++;
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return i;
                        }
                    }
                    return i;
                }
            }
        } catch (Exception e3) {
            e = e3;
            i = 0;
        }
        return i;
    }

    public int a(short s, short s2) {
        try {
            return b().executeRaw("update ChattingModel set msgType ='" + ((int) s2) + "' where loadName='" + ChatManager.userInfo.uid + "' and msgType='" + ((int) s) + "'", new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Cursor a(String str, long j, short s) {
        return BluedBaseDataHelper.a().getReadableDatabase().rawQuery("select chat.msgTimestamp, chat.msgContent, chat.msgStateCode, chat.msgId, chat.msgLocalId, chat.avatar, chat.nickName, chat.fromId, chat.vBadge, chat.fromHideVipLook, chat.fromVipAnnual,chat.fromVipExpLvl, chat.fromVipGrade, chat.id from ChattingModel chat where (chat.sessionId = " + j + " and chat.msgContent like '%" + str + "%' and chat.msgType = 1 and chat.sessionType = " + ((int) s) + " and chat.msgIsDelete = 0) order by chat.msgTimestamp desc", null);
    }

    public ChattingModelDB a(long j, short s, long j2) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            Where where = queryBuilder.where();
            where.and(where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), where.eq("msgLocalId", Long.valueOf(j)), new Where[]{where.eq("sessionType", Short.valueOf(s)), where.eq("sessionId", Long.valueOf(j2))});
            List query = queryBuilder.query();
            ChattingModelDB chattingModelDB = null;
            if (query != null) {
                chattingModelDB = null;
                if (query.size() > 0) {
                    chattingModelDB = (ChattingModelDB) query.get(0);
                }
            }
            return chattingModelDB;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ChattingModelDB a(short s, long j, long j2, long j3) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            Where where = queryBuilder.where();
            where.and(where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), where.eq("sessionType", Short.valueOf(s)), new Where[]{where.eq("sessionId", Long.valueOf(j)), where.eq("msgId", Long.valueOf(j2)), where.eq("msgLocalId", Long.valueOf(j3))});
            List query = queryBuilder.query();
            ChattingModelDB chattingModelDB = null;
            if (query != null) {
                chattingModelDB = null;
                if (query.size() > 0) {
                    chattingModelDB = (ChattingModelDB) query.get(0);
                }
            }
            return chattingModelDB;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ChattingModelDB> a(int i, long j, long j2, long j3, long j4, long j5) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            Where where = queryBuilder.where();
            if (j2 == 0 && j3 == 0 && j4 == 0) {
                where.and(where.eq("sessionType", Integer.valueOf(i)), where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), new Where[]{where.eq("sessionId", Long.valueOf(j))});
            } else {
                where.and(where.eq("sessionType", Integer.valueOf(i)), where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), new Where[]{where.eq("sessionId", Long.valueOf(j)), where.or(where.lt("msgId", Long.valueOf(j2)), where.and(where.eq("msgId", Long.valueOf(j2)), where.lt("msgLocalId", Long.valueOf(j3)), new Where[0]), new Where[]{where.and(where.eq("msgId", 0), where.lt("msgLocalId", Long.valueOf(j3)), new Where[0]), where.and(where.eq("msgId", 0), where.eq("msgLocalId", 0), new Where[]{where.lt("msgTimestamp", Long.valueOf(j4))})})});
            }
            queryBuilder.orderBy("msgId", false);
            queryBuilder.orderBy("msgLocalId", false);
            queryBuilder.orderBy("msgTimestamp", false);
            queryBuilder.orderBy("id", false);
            queryBuilder.limit(Long.valueOf(j5));
            return queryBuilder.query();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ChattingModelDB> a(int i, String str, long j, long j2, long j3) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            Where where = queryBuilder.where();
            if (j == 0 || j2 == 0) {
                where.and(where.eq("sessionType", Integer.valueOf(i)), where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), new Where[]{where.in("sessionId", new Object[]{str}), where.in("msgType", new Object[]{"1,68"}), where.ne("fromId", Long.valueOf(ChatManager.userInfo.uid))});
            } else {
                where.and(where.eq("sessionType", Integer.valueOf(i)), where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), new Where[]{where.ne("fromId", Long.valueOf(ChatManager.userInfo.uid)), where.in("sessionId", new Object[]{str}), where.in("msgType", new Object[]{"1,68"}), where.le("msgTimestamp", Long.valueOf(j2))});
            }
            queryBuilder.orderBy("msgTimestamp", false);
            queryBuilder.limit(Long.valueOf(j3));
            return queryBuilder.query();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public Set<Long> a(int i, long j, long j2) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            Where where = queryBuilder.where();
            where.and(where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), where.eq("sessionType", Integer.valueOf(i)), new Where[]{where.eq("sessionId", Long.valueOf(j)), where.notIn("fromId", new Object[]{Long.valueOf(ChatManager.userInfo.uid)}), where.eq("msgStateCode", (short) 4)});
            queryBuilder.limit(Long.valueOf(j2));
            List<ChattingModelDB> query = queryBuilder.query();
            HashSet hashSet = new HashSet();
            for (ChattingModelDB chattingModelDB : query) {
                hashSet.add(Long.valueOf(chattingModelDB.msgId));
            }
            return hashSet;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean a(short s, long j, long j2) {
        if (j2 == 0) {
            return false;
        }
        try {
            List query = b().queryBuilder().where().eq("loadName", Long.valueOf(ChatManager.userInfo.uid)).and().eq("sessionType", Short.valueOf(s)).and().eq("sessionId", Long.valueOf(j)).and().eq("msgId", Long.valueOf(j2)).query();
            boolean z = false;
            if (query != null) {
                z = false;
                if (query.size() > 0) {
                    z = true;
                }
            }
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int b(int i, long j) {
        try {
            return b().executeRaw("delete from ChattingModel  where sessionType='" + i + "' and loadName='" + ChatManager.userInfo.uid + "' and sessionId='" + j + "'", new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Dao<ChattingModelDB, Integer> b() {
        try {
            if (this.c == null) {
                this.c = BluedBaseDataHelper.a().getDao(ChattingModelDB.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.c;
    }

    public List<ChattingModelDB> b(int i, long j, long j2, long j3, long j4, long j5) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            Where where = queryBuilder.where();
            if (j2 == 0 && j3 == 0 && j4 == 0) {
                where.and(where.eq("sessionType", Integer.valueOf(i)), where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), new Where[]{where.eq("sessionId", Long.valueOf(j))});
            } else {
                where.and(where.eq("sessionType", Integer.valueOf(i)), where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), new Where[]{where.eq("sessionId", Long.valueOf(j)), where.or(where.ge("msgId", Long.valueOf(j2)), where.and(where.eq("msgId", 0), where.ge("msgLocalId", Long.valueOf(j3)), new Where[0]), new Where[]{where.and(where.eq("msgId", 0), where.eq("msgLocalId", 0), new Where[]{where.ge("msgTimestamp", Long.valueOf(j4))})})});
            }
            queryBuilder.orderBy("msgId", true);
            queryBuilder.orderBy("msgLocalId", true);
            queryBuilder.orderBy("msgTimestamp", true);
            queryBuilder.limit(Long.valueOf(j5));
            return queryBuilder.query();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fc, code lost:
        if (r11 == null) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<java.lang.Long> b(short r6, long r7, long r9) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.db.ChattingDao.b(short, long, long):java.util.List");
    }

    public int c() {
        try {
            return b().executeRaw("update ChattingModel set msgStateCode ='6' where loadName='" + ChatManager.userInfo.uid + "' and msgStateCode='1' and fromId='" + ChatManager.userInfo.uid + "'", new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int c(short s, long j, long j2) {
        try {
            return b().executeRaw("update ChattingModel set msgStateCode='3' where loadName='" + ChatManager.userInfo.uid + "' and sessionType='" + ((int) s) + "' and sessionId='" + j + "' and msgId<='" + j2 + "' and msgStateCode='2' and msgType<>'24' and msgType<>'25' and msgType<>'3' and identifyYellow<>'1'", new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public ChattingModelDB c(int i, long j) {
        QueryBuilder queryBuilder = b().queryBuilder();
        Where where = queryBuilder.where();
        try {
            where.and(where.eq("sessionType", Integer.valueOf(i)), where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), new Where[]{where.eq("sessionId", Long.valueOf(j))});
            queryBuilder.orderBy("msgId", false);
            queryBuilder.orderBy("msgLocalId", false);
            queryBuilder.orderBy("msgTimestamp", false);
            queryBuilder.orderBy("id", false);
            queryBuilder.limit(1L);
            List query = queryBuilder.query();
            if (query == null || query.size() <= 0) {
                return null;
            }
            return (ChattingModelDB) query.get(0);
        } catch (Throwable th) {
            return null;
        }
    }

    public int d() {
        try {
            return b().executeRaw("delete from ChattingModel  where loadName='" + ChatManager.userInfo.uid + "'", new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int d(short s, long j, long j2) {
        try {
            return b().executeRaw("update ChattingModel set msgStateCode='3' where loadName='" + ChatManager.userInfo.uid + "' and sessionType='" + ((int) s) + "' and sessionId='" + j + "' and msgId='" + j2 + "' and msgStateCode='2'", new String[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public boolean d(int i, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = BluedBaseDataHelper.a().getReadableDatabase().rawQuery("select id from ChattingModel where sessionType='" + i + "' and fromId='" + ChatManager.userInfo.uid + "' and sessionId='" + j + "' limit 1", null);
            boolean z = false;
            if (rawQuery != null) {
                cursor = rawQuery;
                z = false;
                if (rawQuery.getCount() > 0) {
                    z = true;
                }
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return z;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
                return false;
            }
            return false;
        }
    }

    public ChattingModelDB e(int i, long j) {
        QueryBuilder queryBuilder = b().queryBuilder();
        Where where = queryBuilder.where();
        try {
            where.and(where.eq("sessionType", Integer.valueOf(i)), where.eq("loadName", Long.valueOf(ChatManager.userInfo.uid)), new Where[]{where.eq("sessionId", Long.valueOf(j)), where.and(where.ne("msgType", (short) 24), where.ne("msgType", (short) 25), new Where[]{where.ne("msgType", (short) 3), where.ne("identifyYellow", 1)})});
            queryBuilder.orderBy("msgId", false);
            queryBuilder.orderBy("msgLocalId", false);
            queryBuilder.orderBy("msgTimestamp", false);
            queryBuilder.orderBy("id", false);
            queryBuilder.limit(1L);
            List query = queryBuilder.query();
            if (query == null || query.size() <= 0) {
                return null;
            }
            return (ChattingModelDB) query.get(0);
        } catch (Throwable th) {
            return null;
        }
    }
}
