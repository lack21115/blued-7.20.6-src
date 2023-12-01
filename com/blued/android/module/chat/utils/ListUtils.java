package com.blued.android.module.chat.utils;

import com.blued.android.chat.model.SessionModel;
import com.blued.android.module.chat.tools.SessionModelComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/chat/utils/ListUtils.class */
public class ListUtils {
    public static List<SessionModel> sortSessionModelList(List<SessionModel> list) {
        if (list != null && list.size() > 0) {
            Collections.sort(list, new SessionModelComparator());
        }
        return list;
    }

    public static List<Long[]> splitList(List<Long> list, int i) {
        int size = list.size();
        int i2 = ((size + i) - 1) / i;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= i2) {
                return arrayList;
            }
            int i5 = i4 + 1;
            int i6 = i5 * i;
            if (i6 >= size) {
                i6 = size;
            }
            List<Long> subList = list.subList(i4 * i, i6);
            Long[] lArr = new Long[subList.size()];
            subList.toArray(lArr);
            arrayList.add(lArr);
            i3 = i5;
        }
    }
}
