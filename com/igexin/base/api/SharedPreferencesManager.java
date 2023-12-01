package com.igexin.base.api;

import android.content.Context;
import com.igexin.base.b.a;
import com.igexin.base.b.b;
import com.igexin.base.util.InvokeUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/base/api/SharedPreferencesManager.class */
public class SharedPreferencesManager implements a {
    private static Context mContext;
    private static final Map<String, SharedPreferencesManager> spMap = new ConcurrentHashMap();
    private a mBase;

    private SharedPreferencesManager(String str) {
        checkContext();
        this.mBase = new b(mContext, str);
    }

    private void checkContext() {
        if (mContext == null) {
            Context findAppContext = InvokeUtil.findAppContext();
            mContext = findAppContext;
            if (findAppContext == null) {
                throw null;
            }
        }
    }

    public static SharedPreferencesManager get(String str) {
        if (spMap.get(str) == null) {
            spMap.put(str, new SharedPreferencesManager(str));
        }
        return spMap.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void init(Context context) {
        mContext = context.getApplicationContext();
    }

    @Override // com.igexin.base.b.a
    public Object getParam(String str, Object obj) {
        return this.mBase.getParam(str, obj);
    }

    @Override // com.igexin.base.b.a
    public boolean remove(String str) {
        return this.mBase.remove(str);
    }

    @Override // com.igexin.base.b.a
    public boolean saveParam(String str, Object obj) {
        return this.mBase.saveParam(str, obj);
    }
}
