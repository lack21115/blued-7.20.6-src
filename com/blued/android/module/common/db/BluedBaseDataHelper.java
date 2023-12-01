package com.blued.android.module.common.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.common.db.model.ChattingModelDB;
import com.blued.android.module.common.db.model.NewFeedModel;
import com.blued.android.module.common.db.model.SessionModelDB;
import com.blued.android.module.common.db.model.SessionSettingModel;
import com.blued.android.module.common.db.model.UserAccountsModel;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.misc.TransactionManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.concurrent.Callable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/db/BluedBaseDataHelper.class */
public class BluedBaseDataHelper extends OrmLiteSqliteOpenHelper {
    public static final Class[] a = {UserAccountsModel.class, SessionModelDB.class, ChattingModelDB.class, SessionSettingModel.class, NewFeedModel.class};
    public static BluedBaseDataHelper b;
    private String c;

    /* renamed from: com.blued.android.module.common.db.BluedBaseDataHelper$4  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/db/BluedBaseDataHelper$4.class */
    class AnonymousClass4 implements Callable<Void> {
        final /* synthetic */ BluedBaseDataHelper a;

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            TableUtils.clearTable(this.a.connectionSource, UserAccountsModel.class);
            TableUtils.clearTable(this.a.connectionSource, SessionModelDB.class);
            TableUtils.clearTable(this.a.connectionSource, ChattingModelDB.class);
            TableUtils.clearTable(this.a.connectionSource, SessionSettingModel.class);
            TableUtils.clearTable(this.a.connectionSource, NewFeedModel.class);
            return null;
        }
    }

    public BluedBaseDataHelper(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 40052);
        this.c = BluedBaseDataHelper.class.getName();
    }

    private void A(SQLiteDatabase sQLiteDatabase) {
        try {
            a(1, "hasReply", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(1);
        }
    }

    private void B(SQLiteDatabase sQLiteDatabase) {
        try {
            a(1, "secretLookStatus", "INTEGER");
            a(1, "vipExpLvl", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(1);
        }
        try {
            a(2, "fromVipExpLvl", "INTEGER");
        } catch (Exception e2) {
            e2.printStackTrace();
            a(2);
        }
    }

    private void C(SQLiteDatabase sQLiteDatabase) {
        try {
            a(4, "videoTaskID", "TEXT");
            a(4, "music_id", "TEXT");
        } catch (Exception e) {
            e.printStackTrace();
            a(4);
        }
    }

    private void D(SQLiteDatabase sQLiteDatabase) {
        try {
            a(4, "is_anonym", "INTEGER");
            a(4, "anonym_comment", "INTEGER");
            a(4, "anonym_avatar", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(4);
        }
    }

    private void E(SQLiteDatabase sQLiteDatabase) {
        try {
            a(4, "is_join_circle", "INTEGER");
            a(4, "join_circle_id", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(4);
        }
    }

    private void F(SQLiteDatabase sQLiteDatabase) {
        try {
            a(4, "repost_also_comment", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(4);
        }
    }

    private void G(SQLiteDatabase sQLiteDatabase) {
        try {
            a(4, "join_circle_title", "TEXT");
        } catch (Exception e) {
            e.printStackTrace();
            a(4);
        }
    }

    private void H(SQLiteDatabase sQLiteDatabase) {
        try {
            a(4, "circle_header", "TEXT");
        } catch (Exception e) {
            e.printStackTrace();
            a(4);
        }
    }

    private void I(SQLiteDatabase sQLiteDatabase) {
        try {
            a(4, "is_draft", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(4);
        }
    }

    private void J(SQLiteDatabase sQLiteDatabase) {
        try {
            a(4, "is_share_circle", "INTEGER");
            a(4, "share_circle_id", "TEXT");
        } catch (Exception e) {
            e.printStackTrace();
            a(4);
        }
    }

    private void K(SQLiteDatabase sQLiteDatabase) {
        try {
            a(3, "is_super", "INTEGER");
            a(3, "group_status", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(3);
        }
    }

    private void L(SQLiteDatabase sQLiteDatabase) {
        if (a(sQLiteDatabase, 1, "atMessageId")) {
            return;
        }
        try {
            a(1, "atMessageId", "LONG");
            a(1, "evaluationMsgId", "LONG");
        } catch (Exception e) {
            e.printStackTrace();
            a(1);
        }
    }

    private void M(SQLiteDatabase sQLiteDatabase) {
        if (a(sQLiteDatabase, 4, "is_share_activity")) {
            return;
        }
        try {
            a(4, "is_share_activity", "INTEGER");
            a(4, "share_activity_id", "TEXT");
            a(4, "share_activity_time", "TEXT");
            a(4, "share_activity_location", "TEXT");
            a(4, "share_activity_mode_id", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(4);
        }
    }

    private void N(SQLiteDatabase sQLiteDatabase) {
        if (a(sQLiteDatabase, 4, "is_share_activity")) {
            return;
        }
        try {
            a(4, "super_topics_anonym", "INTEGER");
            a(4, "share_super_topics_anonym", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(4);
        }
    }

    private void O(SQLiteDatabase sQLiteDatabase) {
        try {
            a(4, "event_score", "INTEGER");
            a(4, "event_evaluate", "TEXT");
            a(4, "activity_id", "TEXT");
            a(4, "is_evaluate_activity", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(4);
        }
    }

    private void P(SQLiteDatabase sQLiteDatabase) {
        try {
            a(4, "feed_pics_height", "TEXT");
            a(4, "feed_pics_width", "TEXT");
            a(4, "sign_state_id", "TEXT");
        } catch (Exception e) {
            e.printStackTrace();
            a(4);
        }
    }

    public static BluedBaseDataHelper a() {
        if (b == null) {
            synchronized (BluedBaseDataHelper.class) {
                try {
                    if (b == null) {
                        b = new BluedBaseDataHelper(AppInfo.d(), "blued2015.db");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private void a(final int i) {
        try {
            TransactionManager.callInTransaction(this.connectionSource, new Callable<Void>() { // from class: com.blued.android.module.common.db.BluedBaseDataHelper.2
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    TableUtils.dropTable(BluedBaseDataHelper.this.connectionSource, BluedBaseDataHelper.a[i], true);
                    TableUtils.createTable(BluedBaseDataHelper.this.connectionSource, BluedBaseDataHelper.a[i]);
                    return null;
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void a(int i, String str, String str2) throws SQLException {
        a().getDao(a[i]).executeRawNoArgs(String.format("ALTER TABLE %s ADD COLUMN %s %s;", b(i), str, str2));
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            TableUtils.createTable(this.connectionSource, NewFeedModel.class);
            SessionDao.a().b().executeRawNoArgs("ALTER TABLE SessionModel ADD COLUMN vBadge INTEGER;");
        } catch (Exception e) {
            e.printStackTrace();
            a(sQLiteDatabase, this.connectionSource);
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, final ConnectionSource connectionSource) {
        try {
            TransactionManager.callInTransaction(connectionSource, new Callable<Void>() { // from class: com.blued.android.module.common.db.BluedBaseDataHelper.3
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= BluedBaseDataHelper.a.length) {
                            return null;
                        }
                        TableUtils.dropTable(connectionSource, BluedBaseDataHelper.a[i2], true);
                        i = i2 + 1;
                    }
                }
            });
            onCreate(sQLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
        if (r0.getColumnIndex(r11) != (-1)) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(android.database.sqlite.SQLiteDatabase r9, int r10, java.lang.String r11) {
        /*
            r8 = this;
            r0 = 0
            r14 = r0
            r0 = 0
            r13 = r0
            r0 = 1
            r12 = r0
            r0 = r9
            java.lang.String r1 = "SELECT * FROM %s LIMIT 0"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L57
            r3 = r2
            r4 = 0
            r5 = r8
            r6 = r10
            java.lang.String r5 = r5.b(r6)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L57
            r3[r4] = r5     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L57
            java.lang.String r1 = java.lang.String.format(r1, r2)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L57
            r2 = 0
            android.database.Cursor r0 = r0.rawQuery(r1, r2)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L57
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L3a
            r0 = r9
            r13 = r0
            r0 = r9
            r14 = r0
            r0 = r9
            r1 = r11
            int r0 = r0.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L57
            r10 = r0
            r0 = r10
            r1 = -1
            if (r0 == r1) goto L3a
            goto L3d
        L3a:
            r0 = 0
            r12 = r0
        L3d:
            r0 = r9
            if (r0 == 0) goto L50
            r0 = r9
            boolean r0 = r0.isClosed()
            if (r0 != 0) goto L50
            r0 = r9
            r0.close()
        L50:
            r0 = r12
            return r0
        L53:
            r9 = move-exception
            goto L89
        L57:
            r9 = move-exception
            r0 = r14
            r13 = r0
            r0 = r8
            java.lang.String r0 = r0.c     // Catch: java.lang.Throwable -> L53
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L53
            r2 = r1
            r3 = 0
            java.lang.String r4 = "checkColumnExists1..."
            r2[r3] = r4     // Catch: java.lang.Throwable -> L53
            r2 = r1
            r3 = 1
            r4 = r9
            r2[r3] = r4     // Catch: java.lang.Throwable -> L53
            com.blued.android.framework.utils.Logger.e(r0, r1)     // Catch: java.lang.Throwable -> L53
            r0 = r14
            if (r0 == 0) goto L87
            r0 = r14
            boolean r0 = r0.isClosed()
            if (r0 != 0) goto L87
            r0 = r14
            r0.close()
        L87:
            r0 = 0
            return r0
        L89:
            r0 = r13
            if (r0 == 0) goto L9f
            r0 = r13
            boolean r0 = r0.isClosed()
            if (r0 != 0) goto L9f
            r0 = r13
            r0.close()
        L9f:
            r0 = r9
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.db.BluedBaseDataHelper.a(android.database.sqlite.SQLiteDatabase, int, java.lang.String):boolean");
    }

    private String b(int i) throws SQLException {
        return DatabaseTableConfig.fromClass(this.connectionSource, a[i]).getTableName();
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            Dao<UserAccountsModel, Integer> b2 = UserAccountsVDao.a().b();
            b2.executeRawNoArgs("ALTER TABLE UserAccountsModel ADD COLUMN loginType INTEGER;");
            b2.executeRawNoArgs("ALTER TABLE UserAccountsModel ADD COLUMN accessToken TEXT;");
        } catch (Exception e) {
            e.printStackTrace();
            a(sQLiteDatabase, this.connectionSource);
        }
    }

    private void c() {
        try {
            a(4, "h5_topic_id", "TEXT");
            a(4, "h5_topic_name", "TEXT");
        } catch (Exception e) {
            e.printStackTrace();
            a(4);
        }
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            ChattingDao.a().b().executeRawNoArgs("ALTER TABLE ChattingModel ADD COLUMN vBadge INTEGER;");
        } catch (Exception e) {
            e.printStackTrace();
            a(sQLiteDatabase, this.connectionSource);
        }
    }

    private void d() {
        try {
            a(1, "viSayHello", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(1);
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            Dao<ChattingModelDB, Integer> b2 = ChattingDao.a().b();
            b2.executeRawNoArgs("ALTER TABLE ChattingModel ADD COLUMN msgVideoCoverUrlLocal TEXT;");
            b2.executeRawNoArgs("ALTER TABLE ChattingModel ADD COLUMN msgTextTranslateIsShow INTEGER;");
            b2.executeRawNoArgs("ALTER TABLE ChattingModel ADD COLUMN msgTextTranslateContent TEXT;");
            b2.executeRawNoArgs("ALTER TABLE ChattingModel ADD COLUMN msgTextTranslateStatus INTEGER;");
            SessionDao.a().b().executeRawNoArgs("ALTER TABLE SessionModel ADD COLUMN maxRcvOppMsgId LONG;");
        } catch (Exception e) {
            e.printStackTrace();
            a(sQLiteDatabase, this.connectionSource);
        }
    }

    private void e() {
        try {
            a(4, "videoWidth", "INTEGER");
            a(4, "videoHeight", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(4);
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        try {
            SessionDao.a().b().executeRawNoArgs("ALTER TABLE SessionModel ADD COLUMN lastMsgExtra TEXT;");
        } catch (Exception e) {
            e.printStackTrace();
            a(sQLiteDatabase, this.connectionSource);
        }
    }

    private void f() {
        try {
            a(2, "promptType", "TEXT");
        } catch (Exception e) {
            e.printStackTrace();
            a(2);
        }
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        try {
            Dao<SessionModelDB, Integer> b2 = SessionDao.a().b();
            b2.executeRawNoArgs("ALTER TABLE SessionModel ADD COLUMN online INTEGER;");
            b2.executeRawNoArgs("ALTER TABLE SessionModel ADD COLUMN lastMsgOnline INTEGER;");
            ChattingDao.a().b().executeRawNoArgs("ALTER TABLE ChattingModel ADD COLUMN online INTEGER;");
        } catch (Exception e) {
            e.printStackTrace();
            a(sQLiteDatabase, this.connectionSource);
        }
    }

    private void g() {
        try {
            a(3, "sessionCommonStatus", "TEXT");
        } catch (Exception e) {
            e.printStackTrace();
            a(3);
        }
    }

    private void g(SQLiteDatabase sQLiteDatabase) {
        try {
            Dao<SessionModelDB, Integer> b2 = SessionDao.a().b();
            b2.executeRawNoArgs("ALTER TABLE SessionModel ADD COLUMN draft TEXT;");
            b2.executeRawNoArgs("ALTER TABLE SessionModel ADD COLUMN sessionStatus INTEGER;");
        } catch (Exception e) {
            e.printStackTrace();
            a(sQLiteDatabase, this.connectionSource);
        }
    }

    private void h() {
        try {
            a(1, "noReadRedDot", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(1);
        }
    }

    private void h(SQLiteDatabase sQLiteDatabase) {
        Dao<NewFeedModel, Integer> b2 = NewFeedDao.a().b();
        try {
            b2.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN isForwardHeader INTEGER;");
        } catch (Exception e) {
            e.printStackTrace();
            a(sQLiteDatabase, this.connectionSource);
        }
        try {
            b2.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN isAds INTEGER;");
            b2.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN allowComments INTEGER;");
            b2.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN isRepost INTEGER;");
            b2.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN forwardContent TEXT;");
            b2.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN forwardName TEXT;");
            b2.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN forwardImage TEXT;");
            b2.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN feedId TEXT;");
            b2.executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN framesData TEXT;");
        } catch (SQLException e2) {
            e2.printStackTrace();
        }
    }

    private void i() {
        try {
            a(4, "is_questionnaire", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(4);
        }
    }

    private void i(SQLiteDatabase sQLiteDatabase) {
        try {
            NewFeedDao.a().b().executeRawNoArgs("ALTER TABLE NewFeedModel ADD COLUMN address TEXT;");
        } catch (Exception e) {
            e.printStackTrace();
            a(sQLiteDatabase, this.connectionSource);
        }
    }

    private void j() {
        try {
            a(4, "tt_type", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(4);
        }
    }

    private void j(SQLiteDatabase sQLiteDatabase) {
        try {
            SessionDao.a().b().executeRawNoArgs("ALTER TABLE SessionModel ADD COLUMN lastMsgFromApp INTEGER;");
            ChattingDao.a().b().executeRawNoArgs("ALTER TABLE ChattingModel ADD COLUMN app INTEGER;");
        } catch (Exception e) {
            e.printStackTrace();
            a(sQLiteDatabase, this.connectionSource);
        }
    }

    private void k() {
        try {
            a(2, "isMatchMsg", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(2);
        }
    }

    private void k(SQLiteDatabase sQLiteDatabase) {
        try {
            if (a(sQLiteDatabase, 4, "extraJSON")) {
                return;
            }
            a(4, "extraJSON", "TEXT");
            a(4, "is_url", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(4);
        }
    }

    private void l() {
        try {
            a(2, "identifyYellow", "INTEGER");
        } catch (Exception e) {
            e.printStackTrace();
            a(2);
        }
    }

    private void l(SQLiteDatabase sQLiteDatabase) {
        try {
            a(1, "vipGrade", "INTEGER");
            a(1, "vipAnnual", "INTEGER");
        } catch (Exception e) {
            a(1);
        }
        try {
            a(2, "fromVipGrade", "INTEGER");
            a(2, "fromVipAnnual", "INTEGER");
        } catch (Exception e2) {
            e2.printStackTrace();
            a(2);
        }
    }

    private void m(SQLiteDatabase sQLiteDatabase) {
        try {
            a(4, "duration", "REAL");
        } catch (Exception e) {
            a(4);
        }
    }

    private void n(SQLiteDatabase sQLiteDatabase) {
        try {
            a(4, "reading_scope", "INTEGER");
        } catch (Exception e) {
            a(4);
        }
    }

    private void o(SQLiteDatabase sQLiteDatabase) {
        try {
            a(3, "chatBgUri", "TEXT");
        } catch (Exception e) {
            a(3);
        }
    }

    private void p(SQLiteDatabase sQLiteDatabase) {
        try {
            a(3, "nearby", "INTEGER");
            a(3, "online", "INTEGER");
            a(3, "follower", "INTEGER");
            a(3, "initiator", "INTEGER");
        } catch (Exception e) {
            a(3);
        }
    }

    private void q(SQLiteDatabase sQLiteDatabase) {
        try {
            a(1, "hideVipLook", "INTEGER");
        } catch (Exception e) {
            a(1);
        }
        try {
            a(2, "fromHideVipLook", "INTEGER");
        } catch (Exception e2) {
            a(2);
        }
    }

    private void r(SQLiteDatabase sQLiteDatabase) {
        try {
            a(4, "is_vote", "INTEGER");
        } catch (Exception e) {
            a(4);
        }
    }

    private void s(SQLiteDatabase sQLiteDatabase) {
        try {
            a(4, "is_super_topics", "INTEGER");
        } catch (Exception e) {
            a(4);
        }
        try {
            a(4, "super_did", "TEXT");
        } catch (Exception e2) {
            a(4);
        }
        try {
            a(4, "super_topics_avatar", "TEXT");
        } catch (Exception e3) {
            a(4);
        }
        try {
            a(4, "super_topics_name", "TEXT");
        } catch (Exception e4) {
            a(4);
        }
        try {
            a(1, "sourceFrom", "INTEGER");
        } catch (Exception e5) {
            a(1);
        }
    }

    private void t(SQLiteDatabase sQLiteDatabase) {
        try {
            a(1, "lieTop", "INTEGER");
        } catch (Exception e) {
            a(1);
        }
    }

    private void u(SQLiteDatabase sQLiteDatabase) {
        try {
            a(0, "aliasUserId", "TEXT");
            a(1, "unreadGiftCnt", "INTEGER");
            a(1, "lastGiftMsgId", "LONG");
        } catch (Exception e) {
            e.printStackTrace();
            a(0);
        }
    }

    private void v(SQLiteDatabase sQLiteDatabase) {
        if (a(sQLiteDatabase, 0, "aliasUserId")) {
            return;
        }
        try {
            a(0, "aliasUserId", "TEXT");
        } catch (Exception e) {
            e.printStackTrace();
            a(0);
        }
        try {
            a(1, "unreadGiftCnt", "INTEGER");
            a(1, "lastGiftMsgId", "LONG");
        } catch (Exception e2) {
            e2.printStackTrace();
            a(1);
        }
    }

    private void w(SQLiteDatabase sQLiteDatabase) {
        try {
            a(4, "circle_id", "TEXT");
        } catch (Exception e) {
            a(4);
        }
        try {
            a(4, "circle_title", "TEXT");
        } catch (Exception e2) {
            a(4);
        }
        try {
            a(1, "friend", "INTEGER");
        } catch (Exception e3) {
            a(1);
        }
    }

    private void x(SQLiteDatabase sQLiteDatabase) {
        if (a(sQLiteDatabase, 1, "expireTime")) {
            return;
        }
        try {
            a(1, "expireTime", "LONG");
            a(1, "totalMoney", "FLOAT");
        } catch (Exception e) {
            a(1);
        }
        try {
            a(4, "is_circle_comment", "INTEGER");
        } catch (Exception e2) {
            a(4);
        }
    }

    private void y(SQLiteDatabase sQLiteDatabase) {
        try {
            a(4, "is_attention_show_dot", "INTEGER");
        } catch (Exception e) {
            a(4);
        }
        try {
            a(1, "maxMsgId", "LONG");
        } catch (Exception e2) {
            a(1);
        }
        try {
            sQLiteDatabase.execSQL(String.format("UPDATE " + b(1) + " SET maxMsgId = lastMsgId", new Object[0]));
        } catch (SQLException e3) {
            e3.printStackTrace();
        }
        Logger.e("maxMsgId", "updateDB25");
    }

    private void z(SQLiteDatabase sQLiteDatabase) {
        try {
            a(4, "is_posts_vote", "INTEGER");
            a(4, "posts_vote_title", "TEXT");
            a(4, "option", "TEXT");
            a(4, "share_posting_id", "TEXT");
        } catch (Exception e) {
            a(4);
        }
        Logger.e("maxMsgId", "updateDB26");
    }

    public String b() {
        return AppInfo.d().getDatabasePath("blued2015.db").getPath();
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase, final ConnectionSource connectionSource) {
        try {
            TransactionManager.callInTransaction(connectionSource, new Callable<Void>() { // from class: com.blued.android.module.common.db.BluedBaseDataHelper.1
                @Override // java.util.concurrent.Callable
                public Void call() throws Exception {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= BluedBaseDataHelper.a.length) {
                            return null;
                        }
                        TableUtils.createTable(connectionSource, BluedBaseDataHelper.a[i2]);
                        i = i2 + 1;
                    }
                }
            });
        } catch (SQLException e) {
            Logger.e(BluedBaseDataHelper.class.getName(), "Unable to create datbases", e);
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, ConnectionSource connectionSource, int i, int i2) {
        Logger.b(this.c, "数据库升级: oldVersion==", Integer.valueOf(i), "，newVersion==", Integer.valueOf(i2));
        switch (i) {
            case 40000:
                a(sQLiteDatabase);
            case 40001:
                b(sQLiteDatabase);
            case 40002:
                c(sQLiteDatabase);
            case 40003:
                d(sQLiteDatabase);
            case 40004:
                e(sQLiteDatabase);
            case 40005:
                f(sQLiteDatabase);
            case 40006:
                g(sQLiteDatabase);
            case 40007:
                h(sQLiteDatabase);
            case 40008:
                i(sQLiteDatabase);
            case 40009:
                j(sQLiteDatabase);
            case 40010:
                k(sQLiteDatabase);
                l(sQLiteDatabase);
            case 40011:
                m(sQLiteDatabase);
            case 40012:
                n(sQLiteDatabase);
            case 40013:
                o(sQLiteDatabase);
            case 40014:
                p(sQLiteDatabase);
            case 40015:
                q(sQLiteDatabase);
            case 40016:
                r(sQLiteDatabase);
            case 40017:
                s(sQLiteDatabase);
            case 40018:
                t(sQLiteDatabase);
            case 40019:
                u(sQLiteDatabase);
            case 40020:
                v(sQLiteDatabase);
            case 40021:
                w(sQLiteDatabase);
            case 40022:
            case 40023:
                x(sQLiteDatabase);
            case 40024:
                y(sQLiteDatabase);
            case 40025:
                z(sQLiteDatabase);
            case 40026:
                A(sQLiteDatabase);
            case 40027:
                B(sQLiteDatabase);
            case 40028:
                C(sQLiteDatabase);
            case 40029:
                D(sQLiteDatabase);
            case 40030:
                E(sQLiteDatabase);
            case 40031:
                F(sQLiteDatabase);
            case 40032:
                G(sQLiteDatabase);
            case 40033:
                H(sQLiteDatabase);
            case 40034:
                I(sQLiteDatabase);
            case 40035:
                J(sQLiteDatabase);
            case 40036:
                K(sQLiteDatabase);
            case 40037:
                L(sQLiteDatabase);
            case 40038:
                M(sQLiteDatabase);
            case 40039:
                N(sQLiteDatabase);
            case 40040:
                O(sQLiteDatabase);
            case 40041:
                P(sQLiteDatabase);
            case 40042:
                c();
            case 40043:
                d();
            case 40044:
                e();
            case 40045:
                f();
            case 40046:
                g();
            case 40047:
                h();
            case 40048:
                i();
            case 40049:
                j();
            case 40050:
                k();
                break;
            case 40051:
                break;
            default:
                return;
        }
        l();
    }
}
