package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.xiaomi.push.ch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/cc.class */
public class cc extends ch.b<Long> {

    /* renamed from: a  reason: collision with root package name */
    private long f27608a;

    /* renamed from: a  reason: collision with other field name */
    private String f192a;

    public cc(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i, String str6) {
        super(str, list, str2, strArr, str3, str4, str5, i);
        this.f27608a = 0L;
        this.f192a = str6;
    }

    public static cc a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("count(*)");
        return new cc(str, arrayList, null, null, null, null, null, 0, "job to get count of all message");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaomi.push.ch.b
    public Long a(Context context, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    @Override // com.xiaomi.push.ch.a
    /* renamed from: a */
    public Object mo8532a() {
        return Long.valueOf(this.f27608a);
    }

    @Override // com.xiaomi.push.ch.b
    public void a(Context context, List<Long> list) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        this.f27608a = list.get(0).longValue();
    }
}
