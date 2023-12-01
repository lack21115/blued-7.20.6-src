package com.soft.blued.ui.search.utils;

import android.database.Cursor;
import android.speech.tts.TextToSpeech;
import com.blued.android.chat.ChatManager;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.module.common.db.BluedBaseDataHelper;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.google.gson.reflect.TypeToken;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.soft.blued.ui.search.model.SearchSessionModel;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/search/utils/SearchGlobalUtil.class */
public final class SearchGlobalUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final SearchGlobalUtil f33175a = new SearchGlobalUtil();
    private static ArrayList<String> b;

    private SearchGlobalUtil() {
    }

    private final List<SearchSessionModel> a(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            SearchSessionModel searchSessionModel = new SearchSessionModel();
            searchSessionModel.lastMsgTime = cursor.getLong(cursor.getColumnIndexOrThrow("msgTimestamp"));
            searchSessionModel.dbId = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
            searchSessionModel.lastMsgContent = cursor.getString(cursor.getColumnIndexOrThrow(RemoteMessageConst.MessageBody.MSG_CONTENT));
            searchSessionModel.avatar = cursor.getString(cursor.getColumnIndexOrThrow("sessionAvatar"));
            searchSessionModel.nickName = cursor.getString(cursor.getColumnIndexOrThrow("sessionNickName"));
            searchSessionModel.vBadge = cursor.getInt(cursor.getColumnIndexOrThrow("vBadge"));
            searchSessionModel.vipAnnual = cursor.getInt(cursor.getColumnIndexOrThrow("vipAnnual"));
            searchSessionModel.vipExpLvl = cursor.getInt(cursor.getColumnIndexOrThrow("vipExpLvl"));
            searchSessionModel.vipGrade = cursor.getInt(cursor.getColumnIndexOrThrow("vipGrade"));
            searchSessionModel.hideVipLook = cursor.getInt(cursor.getColumnIndexOrThrow("hideVipLook"));
            searchSessionModel.lastMsgStateCode = cursor.getShort(cursor.getColumnIndexOrThrow("lastMsgStateCode"));
            searchSessionModel.sessionType = cursor.getShort(cursor.getColumnIndexOrThrow("sessionType"));
            searchSessionModel.f33162a = cursor.getInt(cursor.getColumnIndexOrThrow("msgCount"));
            searchSessionModel.lastMsgId = cursor.getLong(cursor.getColumnIndexOrThrow(RemoteMessageConst.MSGID));
            searchSessionModel.lastMsgLocalId = cursor.getLong(cursor.getColumnIndexOrThrow("msgLocalId"));
            searchSessionModel.f33163c = cursor.getLong(cursor.getColumnIndexOrThrow("chatDbId"));
            searchSessionModel.b = cursor.getString(cursor.getColumnIndexOrThrow("sessinoNote"));
            long j = cursor.getLong(cursor.getColumnIndexOrThrow(TextToSpeech.Engine.KEY_PARAM_SESSION_ID));
            searchSessionModel.sessionId = j;
            searchSessionModel.sessionSettingModel = ChatManager.dbOperImpl.getSessionSetting(searchSessionModel.sessionType, j);
            arrayList.add(searchSessionModel);
        }
        if (!cursor.isClosed()) {
            cursor.close();
        }
        return arrayList;
    }

    private final String c(String str) {
        String str2 = str;
        try {
            String a2 = StringsKt.a(StringsKt.a(StringsKt.a(StringsKt.a(StringsKt.a(StringsKt.a(StringsKt.a(StringsKt.a(str, BridgeUtil.SPLIT_MARK, "//", false, 4, (Object) null), "'", "''", false, 4, (Object) null), "[", "/[", false, 4, (Object) null), "]", "/]", false, 4, (Object) null), "%", "/%", false, 4, (Object) null), "&", "/&", false, 4, (Object) null), BridgeUtil.UNDERLINE_STR, "/_", false, 4, (Object) null), "(", "/(", false, 4, (Object) null);
            str2 = a2;
            return StringsKt.a(a2, ")", "/)", false, 4, (Object) null);
        } catch (Exception e) {
            return str2;
        }
    }

    public final List<String> a() {
        if (b == null) {
            String fd = BluedPreferences.fd();
            String str = fd;
            if (!(str == null || str.length() == 0)) {
                List list = (List) AppInfo.f().fromJson(fd, new TypeToken<ArrayList<String>>() { // from class: com.soft.blued.ui.search.utils.SearchGlobalUtil$findSearchRecent$recentList$1
                }.getType());
                ArrayList<String> arrayList = new ArrayList<>();
                b = arrayList;
                if (arrayList != null) {
                    arrayList.addAll(list);
                }
            }
        }
        ArrayList<String> arrayList2 = b;
        if (arrayList2 == null) {
            return null;
        }
        return CollectionsKt.c((Collection) arrayList2);
    }

    public final List<SearchSessionModel> a(String word) {
        Intrinsics.e(word, "word");
        Cursor cursor = BluedBaseDataHelper.a().getReadableDatabase().rawQuery("SELECT session.*, chat.msgContent, chat.msgTimestamp, chat.msgId, chat.msgLocalId, chat.id as chatDbId, chat.msgCount, setting.sessinoNote FROM  SessionModel as session INNER JOIN SessionSettingModel as setting ON session.sessionId = setting.sessionId LEFT JOIN ( SELECT sessionId, msgContent, msgTimestamp, msgId, msgLocalId, id, count(distinct msgId||msgLocalId) as msgCount FROM ChattingModel WHERE msgContent LIKE '%" + c(word) + "%' and msgType = 1 and msgIsDelete = 0 GROUP BY sessionId) as chat ON chat.sessionId = session.sessionId WHERE (chat.msgCount > 0) and session.loadName = " + ChatManager.userInfo.uid + " and (session.sessionType = 2 or session.sessionType = 3)  and setting.loadName = " + ChatManager.userInfo.uid + " ORDER BY chat.msgTimestamp DESC", null);
        if (cursor.getCount() <= 0) {
            return CollectionsKt.b();
        }
        Intrinsics.c(cursor, "cursor");
        return a(cursor);
    }

    public final void a(BluedUIHttpResponse<?> bluedUIHttpResponse, String keyword, IRequestHost iRequestHost) {
        Intrinsics.e(keyword, "keyword");
        String a2 = Intrinsics.a(BluedHttpUrl.q(), (Object) "/users/quick_entry/search");
        Map<String, String> params = BluedHttpTools.a();
        Intrinsics.c(params, "params");
        params.put("keyword", keyword);
        HttpManager.a(a2, bluedUIHttpResponse, iRequestHost).b(BluedHttpTools.a(true)).a(params).h();
    }

    public final void b() {
        b = null;
    }

    public final void b(String keywords) {
        Intrinsics.e(keywords, "keywords");
        if (b == null) {
            b = new ArrayList<>();
        }
        ArrayList<String> arrayList = b;
        if (arrayList == null) {
            return;
        }
        if (arrayList.contains(keywords)) {
            arrayList.remove(keywords);
        }
        arrayList.add(0, keywords);
        if (arrayList.size() > 10) {
            List b2 = CollectionsKt.b((Iterable) arrayList, 10);
            arrayList.clear();
            arrayList.addAll(b2);
        }
        BluedPreferences.as(AppInfo.f().toJson(arrayList));
    }

    public final void c() {
        ArrayList<String> arrayList = b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        b = null;
        BluedPreferences.as("");
    }
}
