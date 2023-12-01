package com.tencent.tinker.loader.hotplug;

import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tinker/loader/hotplug/ActivityStubManager.class */
public class ActivityStubManager {
    private static final int NOTRANSPARENT_SLOT_INDEX = 0;
    private static final String TAG = "Tinker.ActivityStubManager";
    private static final int TRANSPARENT_SLOT_INDEX = 1;
    private static Map<String, String> sTargetToStubClassNameMap = new HashMap();
    private static final int[] STANDARD_STUB_COUNT_SLOTS = {10, 3};
    private static final int[] SINGLETOP_STUB_COUNT_SLOTS = {10, 3};
    private static final int[] SINGLETASK_STUB_COUNT_SLOTS = {10, 3};
    private static final int[] SINGLEINSTANCE_STUB_COUNT_SLOTS = {10, 3};
    private static final int[] NEXT_STANDARD_STUB_IDX_SLOTS = {0, 0};
    private static final int[] NEXT_SINGLETOP_STUB_IDX_SLOTS = {0, 0};
    private static final int[] NEXT_SINGLETASK_STUB_IDX_SLOTS = {0, 0};
    private static final int[] NEXT_SINGLEINSTANCE_STUB_IDX_SLOTS = {0, 0};

    private ActivityStubManager() {
        throw new UnsupportedOperationException();
    }

    public static String assignStub(String str, int i, boolean z) {
        String str2;
        int[] iArr;
        int[] iArr2;
        char c2;
        String str3 = sTargetToStubClassNameMap.get(str);
        if (str3 != null) {
            return str3;
        }
        if (i == 1) {
            str2 = ActivityStubs.SINGLETOP_STUB_CLASSNAME_FORMAT;
            iArr = NEXT_SINGLETOP_STUB_IDX_SLOTS;
            iArr2 = SINGLETOP_STUB_COUNT_SLOTS;
        } else if (i == 2) {
            str2 = ActivityStubs.SINGLETASK_STUB_CLASSNAME_FORMAT;
            iArr = NEXT_SINGLETASK_STUB_IDX_SLOTS;
            iArr2 = SINGLETASK_STUB_COUNT_SLOTS;
        } else if (i != 3) {
            str2 = ActivityStubs.STARDARD_STUB_CLASSNAME_FORMAT;
            iArr = NEXT_STANDARD_STUB_IDX_SLOTS;
            iArr2 = STANDARD_STUB_COUNT_SLOTS;
        } else {
            str2 = ActivityStubs.SINGLEINSTANCE_STUB_CLASSNAME_FORMAT;
            iArr = NEXT_SINGLEINSTANCE_STUB_IDX_SLOTS;
            iArr2 = SINGLEINSTANCE_STUB_COUNT_SLOTS;
        }
        if (z) {
            str2 = str2 + "_T";
            c2 = 1;
        } else {
            c2 = 0;
        }
        int i2 = iArr[c2];
        iArr[c2] = i2 + 1;
        int i3 = i2;
        if (i2 >= iArr2[c2]) {
            iArr[c2] = 0;
            i3 = 0;
        }
        String format = String.format(str2, Integer.valueOf(i3));
        sTargetToStubClassNameMap.put(str, format);
        return format;
    }
}
