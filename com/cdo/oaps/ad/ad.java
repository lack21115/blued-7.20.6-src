package com.cdo.oaps.ad;

import android.content.Context;
import com.cdo.oaps.ad.Launcher;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.cdo.oaps.ad.wrapper.PreDownWrapper;
import com.cdo.oaps.ad.wrapper.ResourceWrapper;
import com.cdo.oaps.ad.wrapper.SearchWrapper;
import com.cdo.oaps.ad.wrapper.WebWrapper;
import java.util.Map;

/* loaded from: source-7206380-dex2jar.jar:com/cdo/oaps/ad/ad.class */
public class ad {

    /* renamed from: a  reason: collision with root package name */
    private static final int f7909a = 0;
    private static final int b = 1;

    private static int a(String str) {
        if ("4".equals(str)) {
            return 1607;
        }
        if ("6".equals(str)) {
            return 1609;
        }
        if ("8".equals(str)) {
            return 1611;
        }
        if ("7".equals(str)) {
            return 1610;
        }
        return "5".equals(str) ? 1608 : 1607;
    }

    public static String a(Context context, BaseWrapper baseWrapper) {
        boolean equals = "1".equals(baseWrapper.getGoBack());
        String enterId = baseWrapper.getEnterId();
        String enterModule = baseWrapper.getEnterModule();
        return af.a(context, 4600) ? z.a(context, enterId, enterModule, equals) : af.a(context, 4550) ? t.a(context, enterId, enterModule, equals) : "";
    }

    public static String a(Context context, PreDownWrapper preDownWrapper) {
        if (af.a(context, 4600)) {
            long id = preDownWrapper.getId();
            String pkgName = preDownWrapper.getPkgName();
            int type = preDownWrapper.getType();
            String enterId = preDownWrapper.getEnterId();
            return z.a(context, id, pkgName, type == 0 ? 0 : 1, enterId, preDownWrapper.getEnterModule(), preDownWrapper.getEnterModule2(), a(enterId));
        }
        return "";
    }

    public static String a(Context context, ResourceWrapper resourceWrapper) {
        long id = resourceWrapper.getId();
        String pkgName = resourceWrapper.getPkgName();
        boolean autoDown = resourceWrapper.getAutoDown();
        boolean equals = "1".equals(resourceWrapper.getGoBack());
        String enterId = resourceWrapper.getEnterId();
        String enterModule = resourceWrapper.getEnterModule();
        String enterModule2 = resourceWrapper.getEnterModule2();
        int a2 = a(enterId);
        return af.a(context, 4600) ? z.a(context, id, pkgName, autoDown, equals, enterId, enterModule, enterModule2, a2, resourceWrapper.getExtModule()) : af.a(context, 4550) ? t.a(context, id, pkgName, autoDown, equals, enterId, enterModule, a2, enterModule2) : "";
    }

    public static String a(Context context, SearchWrapper searchWrapper) {
        String keyword = searchWrapper.getKeyword();
        String pkgName = searchWrapper.getPkgName();
        boolean autoDown = searchWrapper.getAutoDown();
        boolean equals = "1".equals(searchWrapper.getGoBack());
        String enterId = searchWrapper.getEnterId();
        String enterModule = searchWrapper.getEnterModule();
        String enterModule2 = searchWrapper.getEnterModule2();
        int a2 = a(enterId);
        return af.a(context, 4600) ? z.a(context, keyword, pkgName, autoDown, equals, enterId, enterModule, enterModule2, a2) : af.a(context, 4550) ? t.a(context, keyword, pkgName, autoDown, equals, enterId, enterModule, enterModule2, a2) : "";
    }

    public static String a(Context context, WebWrapper webWrapper) {
        boolean equals = "1".equals(webWrapper.getGoBack());
        String url = webWrapper.getUrl();
        String enterId = webWrapper.getEnterId();
        String enterModule = webWrapper.getEnterModule();
        String enterModule2 = webWrapper.getEnterModule2();
        int a2 = a(enterId);
        return af.a(context, 4600) ? z.a(context, url, equals, enterId, enterModule, enterModule2, a2, webWrapper.getExtModule()) : af.a(context, 4550) ? t.a(context, url, equals, enterId, enterModule, a2, enterModule2) : "";
    }

    public static boolean a(Context context, String str) {
        boolean z;
        if (!af.a(context, 5100)) {
            if (af.a(context, 4600)) {
                String[] strArr = af.h;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    z = false;
                    if (i2 < length) {
                        if (strArr[i2].equals(str)) {
                            break;
                        }
                        i = i2 + 1;
                    } else {
                        break;
                    }
                }
            } else if (af.a(context, 4550)) {
                String[] strArr2 = af.g;
                int length2 = strArr2.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    z = false;
                    if (i4 < length2) {
                        if (strArr2[i4].equals(str)) {
                            break;
                        }
                        i3 = i4 + 1;
                    } else {
                        break;
                    }
                }
            } else {
                z = false;
                if (af.a(context, 390)) {
                    String[] strArr3 = af.f;
                    int length3 = strArr3.length;
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        z = false;
                        if (i6 < length3) {
                            if (strArr3[i6].equals(str)) {
                                break;
                            }
                            i5 = i6 + 1;
                        } else {
                            break;
                        }
                    }
                }
            }
            return z;
        }
        z = true;
        return z;
    }

    public static boolean a(Context context, Map<String, Object> map) {
        return a(context, map, 0);
    }

    private static boolean a(Context context, Map<String, Object> map, int i) {
        OapsWrapper wrapper = OapsWrapper.wrapper(map);
        if (wrapper.getPath().equals("/dt")) {
            ResourceWrapper wrapper2 = ResourceWrapper.wrapper(wrapper.getParams());
            String a2 = a(context, wrapper2);
            if (i == 0) {
                if (ab.a(context, a2)) {
                    return true;
                }
            } else if (ab.b(context, a2)) {
                return true;
            }
            if (af.a(context, 390)) {
                long id = wrapper2.getId();
                String pkgName = wrapper2.getPkgName();
                boolean autoDown = wrapper2.getAutoDown();
                boolean equals = "1".equals(wrapper2.getGoBack());
                int a3 = a(wrapper2.getEnterId());
                if (id > 0) {
                    return aa.a(context, id, autoDown, equals, a3);
                }
                if (!ab.a(pkgName)) {
                    return aa.a(context, pkgName, autoDown, equals, a3);
                }
            }
        }
        if (wrapper.getPath().equals("/search")) {
            SearchWrapper wrapper3 = SearchWrapper.wrapper(wrapper.getParams());
            String a4 = a(context, wrapper3);
            if (i == 0) {
                if (ab.a(context, a4)) {
                    return true;
                }
            } else if (ab.b(context, a4)) {
                return true;
            }
            if (af.a(context, 390)) {
                return aa.a(context, wrapper3.getKeyword(), wrapper3.getPkgName(), a(wrapper3.getEnterId()));
            }
        }
        if (wrapper.getPath().equals("/home")) {
            String a5 = a(context, BaseWrapper.wrapper(wrapper.getParams()));
            if (i == 0) {
                if (ab.a(context, a5)) {
                    return true;
                }
            } else if (ab.b(context, a5)) {
                return true;
            }
            if (af.a(context, 390)) {
                return aa.a(context);
            }
        }
        if (wrapper.getPath().equals(Launcher.Path.PREDOWN)) {
            PreDownWrapper wrapper4 = PreDownWrapper.wrapper(wrapper.getParams());
            String a6 = a(context, wrapper4);
            if (ab.a(a6) || i != 0) {
                if (ab.b(context, a6)) {
                    return true;
                }
            } else if (ab.a(context, a6)) {
                return true;
            }
            if (af.a(context, 4550)) {
                long id2 = wrapper4.getId();
                String pkgName2 = wrapper4.getPkgName();
                int type = wrapper4.getType();
                String enterId = wrapper4.getEnterId();
                if (t.a(context, id2, pkgName2, wrapper4.getEnterModule(), a(enterId), enterId, wrapper4.getEnterModule2(), a.b(type == 0 ? "Y29tLm9wcG8ubWFya2V0LnNlcnZpY2UucHJlX2Rvd25sb2FkLnN0YXJ0" : "Y29tLm9wcG8ubWFya2V0LnNlcnZpY2UucHJlX2Rvd25sb2FkLmNhbmNlbA=="))) {
                    return true;
                }
            }
        }
        if (wrapper.getPath().equals("/web")) {
            String a7 = a(context, WebWrapper.wrapper(wrapper.getParams()));
            return (ab.a(a7) || i != 0) ? ab.b(context, a7) : ab.a(context, a7);
        }
        return false;
    }

    public static boolean b(Context context, Map<String, Object> map) {
        return a(context, map, 1);
    }
}
