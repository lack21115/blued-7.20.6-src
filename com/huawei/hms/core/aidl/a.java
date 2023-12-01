package com.huawei.hms.core.aidl;

import android.os.Bundle;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/core/aidl/a.class */
public class a extends MessageCodec {
    @Override // com.huawei.hms.core.aidl.MessageCodec
    protected List<Object> readList(Type type, Bundle bundle) throws InstantiationException, IllegalAccessException {
        int i = bundle.getInt("_list_size_");
        ArrayList arrayList = new ArrayList(i);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return arrayList;
            }
            Object obj = bundle.get("_list_item_" + i3);
            if (obj.getClass().isPrimitive() || (obj instanceof String) || (obj instanceof Serializable)) {
                arrayList.add(obj);
            } else if (obj instanceof Bundle) {
                Bundle bundle2 = (Bundle) obj;
                int i4 = bundle2.getInt("_val_type_", -1);
                if (i4 == 1) {
                    throw new InstantiationException("Nested List can not be supported");
                }
                if (i4 != 0) {
                    throw new InstantiationException("Unknown type can not be supported");
                }
                arrayList.add(decode(bundle2, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
            } else {
                continue;
            }
            i2 = i3 + 1;
        }
    }

    @Override // com.huawei.hms.core.aidl.MessageCodec
    protected void writeList(String str, List list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt("_val_type_", 1);
        bundle2.putInt("_list_size_", list.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                bundle.putBundle(str, bundle2);
                return;
            }
            writeValue("_list_item_" + i2, list.get(i2), bundle2);
            i = i2 + 1;
        }
    }
}
