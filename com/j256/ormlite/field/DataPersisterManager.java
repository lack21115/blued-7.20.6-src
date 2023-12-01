package com.j256.ormlite.field;

import com.j256.ormlite.field.types.EnumStringType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/j256/ormlite/field/DataPersisterManager.class */
public class DataPersisterManager {
    private static final DataPersister DEFAULT_ENUM_PERSISTER = EnumStringType.getSingleton();
    private static List<DataPersister> registeredPersisters = null;
    private static final Map<String, DataPersister> builtInMap = new HashMap();

    static {
        DataType[] values = DataType.values();
        int length = values.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            DataPersister dataPersister = values[i2].getDataPersister();
            if (dataPersister != null) {
                Class<?>[] associatedClasses = dataPersister.getAssociatedClasses();
                int length2 = associatedClasses.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= length2) {
                        break;
                    }
                    builtInMap.put(associatedClasses[i4].getName(), dataPersister);
                    i3 = i4 + 1;
                }
                if (dataPersister.getAssociatedClassNames() != null) {
                    String[] associatedClassNames = dataPersister.getAssociatedClassNames();
                    int length3 = associatedClassNames.length;
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 < length3) {
                            builtInMap.put(associatedClassNames[i6], dataPersister);
                            i5 = i6 + 1;
                        }
                    }
                }
            }
            i = i2 + 1;
        }
    }

    private DataPersisterManager() {
    }

    public static void clear() {
        registeredPersisters = null;
    }

    public static DataPersister lookupForField(Field field) {
        List<DataPersister> list = registeredPersisters;
        if (list != null) {
            for (DataPersister dataPersister : list) {
                if (dataPersister.isValidForField(field)) {
                    return dataPersister;
                }
                Class<?>[] associatedClasses = dataPersister.getAssociatedClasses();
                int length = associatedClasses.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < length) {
                        if (field.getType() == associatedClasses[i2]) {
                            return dataPersister;
                        }
                        i = i2 + 1;
                    }
                }
            }
        }
        DataPersister dataPersister2 = builtInMap.get(field.getType().getName());
        if (dataPersister2 != null) {
            return dataPersister2;
        }
        if (field.getType().isEnum()) {
            return DEFAULT_ENUM_PERSISTER;
        }
        return null;
    }

    public static void registerDataPersisters(DataPersister... dataPersisterArr) {
        ArrayList arrayList = new ArrayList();
        List<DataPersister> list = registeredPersisters;
        if (list != null) {
            arrayList.addAll(list);
        }
        int length = dataPersisterArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                registeredPersisters = arrayList;
                return;
            } else {
                arrayList.add(dataPersisterArr[i2]);
                i = i2 + 1;
            }
        }
    }
}
