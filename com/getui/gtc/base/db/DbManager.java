package com.getui.gtc.base.db;

import android.content.Context;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/base/db/DbManager.class */
public class DbManager {
    private static Map<Class<? extends AbstractDb>, AbstractDb> dbMap = new ConcurrentHashMap();

    public static <T extends AbstractTable> T getTable(Class<? extends AbstractDb> cls, Class<T> cls2) {
        AbstractDb abstractDb = dbMap.get(cls);
        if (abstractDb != null) {
            return (T) abstractDb.getTable(cls2);
        }
        throw new RuntimeException("db " + cls.getSimpleName() + " has not been initialized");
    }

    public static Collection<AbstractTable> getTables(Class<? extends AbstractDb> cls) {
        AbstractDb abstractDb = dbMap.get(cls);
        if (abstractDb != null) {
            return abstractDb.getTables();
        }
        throw new RuntimeException("db " + cls.getSimpleName() + "has not been initialized");
    }

    public static void init(Context context, Class<? extends AbstractDb> cls, Class<? extends AbstractTable>... clsArr) throws IllegalAccessException, InstantiationException {
        Context applicationContext = context.getApplicationContext();
        AbstractDb abstractDb = dbMap.get(cls);
        AbstractDb abstractDb2 = abstractDb;
        if (abstractDb == null) {
            abstractDb2 = cls.newInstance();
            dbMap.put(cls, abstractDb2);
        }
        int length = clsArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                abstractDb2.init(applicationContext);
                return;
            } else {
                abstractDb2.addTable(clsArr[i2]);
                i = i2 + 1;
            }
        }
    }
}
