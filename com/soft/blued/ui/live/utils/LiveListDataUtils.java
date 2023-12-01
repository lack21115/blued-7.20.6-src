package com.soft.blued.ui.live.utils;

import com.blued.android.module.live_china.model.BluedLiveListData;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/utils/LiveListDataUtils.class */
public class LiveListDataUtils {

    /* renamed from: a  reason: collision with root package name */
    private static List<BluedLiveListData> f17613a;
    private static List<BluedLiveListData> b;

    /* renamed from: c  reason: collision with root package name */
    private static List<BluedLiveListData> f17614c;
    private static List<List<BluedLiveListData>> d;
    private static List<List<BluedLiveListData>> e;
    private static List<List<BluedLiveListData>> f;

    public static int a(long j, List<BluedLiveListData> list) {
        if (list == null) {
            return 0;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return 0;
            }
            BluedLiveListData bluedLiveListData = list.get(i2);
            if (bluedLiveListData != null && String.valueOf(j).equals(bluedLiveListData.lid)) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public static int a(BluedLiveListData bluedLiveListData) {
        if (bluedLiveListData.liveType == 1) {
            return 1;
        }
        if (bluedLiveListData.liveType == 2) {
            return 2;
        }
        if (bluedLiveListData.liveType == 7) {
            return 7;
        }
        return bluedLiveListData.liveType == 10 ? 10 : 0;
    }

    public static List<BluedLiveListData> a(List<BluedLiveListData> list) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return arrayList;
            }
            BluedLiveListData bluedLiveListData = list.get(i2);
            if (bluedLiveListData.liveType != 7) {
                arrayList.add(bluedLiveListData);
            } else if (bluedLiveListData != null && bluedLiveListData.hotpk_list != null) {
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < bluedLiveListData.hotpk_list.size()) {
                        arrayList.add((BluedLiveListData) bluedLiveListData.hotpk_list.get(i4));
                        i3 = i4 + 1;
                    }
                }
            }
            i = i2 + 1;
        }
    }

    public static List<BluedLiveListData> a(List<BluedLiveListData> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        f17613a = new ArrayList();
        b = new ArrayList();
        e = new ArrayList();
        f = new ArrayList();
        d = new ArrayList();
        f17614c = new ArrayList();
        BluedLiveListData bluedLiveListData = null;
        BluedLiveListData bluedLiveListData2 = null;
        if (list != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                bluedLiveListData = bluedLiveListData2;
                try {
                    if (i2 >= list.size()) {
                        break;
                    }
                    int a2 = a(list.get(i2));
                    if (a2 == 0) {
                        d(list.get(i2));
                    } else if (a2 == 1) {
                        c(list.get(i2));
                    } else if (a2 == 2) {
                        b(list.get(i2));
                    } else if (a2 == 7) {
                        bluedLiveListData2 = list.get(i2);
                    } else if (a2 == 10) {
                        e(list.get(i2));
                    }
                    i = i2 + 1;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    bluedLiveListData = bluedLiveListData2;
                }
            }
        }
        if (d.size() > 0) {
            List<List<BluedLiveListData>> list2 = d;
            if (a(list2.get(list2.size() - 1), 2)) {
                List<List<BluedLiveListData>> list3 = d;
                list3.remove(list3.size() - 1);
            }
            if (d.size() > 0) {
                BluedLiveListData bluedLiveListData3 = new BluedLiveListData();
                bluedLiveListData3.liveType = 4;
                arrayList.add(bluedLiveListData3);
                int i3 = 0;
                for (int i4 = 0; i4 < d.size(); i4++) {
                    List<BluedLiveListData> list4 = d.get(i4);
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 < list4.size()) {
                            BluedLiveListData bluedLiveListData4 = list4.get(i6);
                            bluedLiveListData4.position = i6;
                            bluedLiveListData4.positionReal = i3;
                            arrayList.add(bluedLiveListData4);
                            i3++;
                            i5 = i6 + 1;
                        }
                    }
                }
            }
        }
        if (e.size() > 0) {
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= e.size()) {
                    break;
                }
                List<BluedLiveListData> list5 = e.get(i8);
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 < list5.size()) {
                        arrayList.add(list5.get(i10));
                        i9 = i10 + 1;
                    }
                }
                i7 = i8 + 1;
            }
        }
        if (bluedLiveListData != null) {
            arrayList.add(bluedLiveListData);
        }
        if (f.size() > 0) {
            List<List<BluedLiveListData>> list6 = f;
            if (a(list6.get(list6.size() - 1), 0)) {
                List<List<BluedLiveListData>> list7 = f;
                list7.remove(list7.size() - 1);
            }
            if (f.size() > 0) {
                if (z) {
                    BluedLiveListData bluedLiveListData5 = new BluedLiveListData();
                    bluedLiveListData5.liveType = 5;
                    if (e.size() > 0) {
                        bluedLiveListData5.hasOfficialList = true;
                    } else {
                        bluedLiveListData5.hasOfficialList = false;
                    }
                    if (d.size() > 0) {
                        bluedLiveListData5.hasRedList = true;
                    } else {
                        bluedLiveListData5.hasRedList = false;
                    }
                    if (bluedLiveListData != null) {
                        bluedLiveListData5.hasPKList = true;
                    } else {
                        bluedLiveListData5.hasPKList = false;
                    }
                    arrayList.add(bluedLiveListData5);
                }
                int i11 = 0;
                for (int i12 = 0; i12 < f.size(); i12++) {
                    List<BluedLiveListData> list8 = f.get(i12);
                    int i13 = 0;
                    while (true) {
                        int i14 = i13;
                        if (i14 < list8.size()) {
                            BluedLiveListData bluedLiveListData6 = list8.get(i14);
                            bluedLiveListData6.position = i14;
                            bluedLiveListData6.positionReal = i11;
                            arrayList.add(bluedLiveListData6);
                            i11++;
                            i13 = i14 + 1;
                        }
                    }
                }
            }
        }
        if (f17614c.size() > 1) {
            int i15 = 0;
            if (b(f17614c)) {
                List<BluedLiveListData> list9 = f17614c;
                list9.remove(list9.size() - 1);
                i15 = 0;
            }
            while (i15 < f17614c.size()) {
                f17614c.get(i15).position = i15 % 2;
                i15++;
            }
            if (f.size() == 0) {
                BluedLiveListData bluedLiveListData7 = new BluedLiveListData();
                bluedLiveListData7.liveType = 9;
                arrayList.add(bluedLiveListData7);
            }
            BluedLiveListData bluedLiveListData8 = new BluedLiveListData();
            bluedLiveListData8.liveType = 8;
            arrayList.add(bluedLiveListData8);
            arrayList.addAll(f17614c);
        }
        return arrayList;
    }

    public static boolean a(List<BluedLiveListData> list, int i) {
        int i2 = 2;
        if (i != 0) {
            i2 = i != 2 ? 0 : 3;
        }
        return list == null || list.size() < i2;
    }

    private static void b(BluedLiveListData bluedLiveListData) {
        if (f17613a.size() != 3 && f17613a.size() != 0) {
            f17613a.add(bluedLiveListData);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f17613a = arrayList;
        arrayList.add(bluedLiveListData);
        d.add(f17613a);
    }

    public static boolean b(List<BluedLiveListData> list) {
        return list != null && list.size() % 2 == 1;
    }

    private static void c(BluedLiveListData bluedLiveListData) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(bluedLiveListData);
        e.add(arrayList);
    }

    private static void d(BluedLiveListData bluedLiveListData) {
        if (b.size() != 2 && b.size() != 0) {
            b.add(bluedLiveListData);
            return;
        }
        ArrayList arrayList = new ArrayList();
        b = arrayList;
        arrayList.add(bluedLiveListData);
        f.add(b);
    }

    private static void e(BluedLiveListData bluedLiveListData) {
        f17614c.add(bluedLiveListData);
    }
}
