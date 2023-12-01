package com.youzan.spiderman.html;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/spiderman/html/i.class */
public class i {
    @SerializedName("html_data_pref")

    /* renamed from: a  reason: collision with root package name */
    private Map<String, g> f41840a = new HashMap();

    public final g a(String str) {
        return this.f41840a.get(str);
    }

    public final void a(String str, g gVar) {
        this.f41840a.put(str, gVar);
    }

    public final g b(String str) {
        return this.f41840a.remove(str);
    }
}
