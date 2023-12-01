package com.blued.android.framework.http.parser;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/http/parser/BluedEntity.class */
public class BluedEntity<T, S extends BluedEntityBaseExtra> {
    public int code;
    public List<T> data;
    public S extra;
    public String message;
    public String request_id;
    public String request_time;
    public String response_time;

    public int getAssemblyTotal() {
        S s = this.extra;
        if (s == null || s.total == 0) {
            return 0;
        }
        return this.extra.total;
    }

    public T getSingleData() {
        List<T> list = this.data;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.data.get(0);
    }

    public boolean hasData() {
        List<T> list = this.data;
        return list != null && list.size() > 0;
    }

    public boolean hasMore() {
        S s = this.extra;
        return (s == null || s.hasmore == -1 || this.extra.hasmore == 0 || this.extra.hasmore != 1) ? false : true;
    }
}
