package com.ishumei.l111l11111Il;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.CellLocation;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.ishumei.l1111l111111Il.l111l1111llIl;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111Il/l11l1111I1ll.class */
public final class l11l1111I1ll {
    private Object l1111l111111Il;
    private Context l111l11111lIl;

    public l11l1111I1ll() {
        this.l1111l111111Il = null;
        this.l111l11111lIl = null;
        try {
            if (l111l1111llIl.l1111l111111Il.l111l11111Il != null) {
                this.l111l11111lIl = l111l1111llIl.l1111l111111Il.l111l11111Il;
                this.l1111l111111Il = com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(l111l1111llIl.l1111l111111Il.l111l11111Il, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bac868c8b9a92ac9a8d89969c9a"), new Class[]{String.class}, new Object[]{com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8f9790919a")});
            }
        } catch (Exception e) {
        }
    }

    private static int l1111l111111Il(Object obj, String str, Object... objArr) {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, new Class[0]);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return ((Integer) declaredMethod.invoke(obj, objArr)).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v61 */
    private CellLocation l1111l111111Il(List<?> list) {
        CdmaCellLocation cdmaCellLocation;
        boolean z;
        int l1111l111111Il;
        int i;
        GsmCellLocation gsmCellLocation = null;
        GsmCellLocation gsmCellLocation2 = null;
        if (list != null) {
            if (list.isEmpty()) {
                return null;
            }
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            CdmaCellLocation cdmaCellLocation2 = null;
            int i2 = 0;
            boolean z2 = false;
            while (true) {
                boolean z3 = z2;
                gsmCellLocation = gsmCellLocation2;
                cdmaCellLocation = cdmaCellLocation2;
                z = z3;
                if (i2 >= list.size()) {
                    break;
                }
                Object obj = list.get(i2);
                gsmCellLocation = gsmCellLocation2;
                CdmaCellLocation cdmaCellLocation3 = cdmaCellLocation2;
                boolean z4 = z3;
                if (obj != null) {
                    z4 = z3;
                    try {
                        Class<?> loadClass = systemClassLoader.loadClass(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd18b9a939a8f97909186d1bc9a9393b6919990b88c92"));
                        Class<?> loadClass2 = systemClassLoader.loadClass(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd18b9a939a8f97909186d1bc9a9393b6919990a89c9b929e"));
                        Class<?> loadClass3 = systemClassLoader.loadClass(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd18b9a939a8f97909186d1bc9a9393b6919990b38b9a"));
                        Class<?> loadClass4 = systemClassLoader.loadClass(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd18b9a939a8f97909186d1bc9a9393b6919990bc9b929e"));
                        boolean z5 = loadClass.isInstance(obj) ? true : loadClass2.isInstance(obj) ? true : loadClass3.isInstance(obj) ? true : loadClass4.isInstance(obj) ? true : false;
                        gsmCellLocation = gsmCellLocation2;
                        cdmaCellLocation3 = cdmaCellLocation2;
                        z4 = z5;
                        if (z5 <= 0) {
                            continue;
                        } else {
                            Object cast = z5 ? loadClass.cast(obj) : z5 ? loadClass2.cast(obj) : z5 ? loadClass3.cast(obj) : loadClass4.cast(obj);
                            boolean z6 = z5;
                            Object l111l11111lIl = l111l11111lIl(cast, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bbc9a9393b69b9a918b968b86"), new Object[0]);
                            if (l111l11111lIl == null) {
                                gsmCellLocation = gsmCellLocation2;
                                cdmaCellLocation3 = cdmaCellLocation2;
                                z4 = z5;
                            } else if (z5) {
                                z4 = z5;
                                CdmaCellLocation cdmaCellLocation4 = new CdmaCellLocation();
                                try {
                                    cdmaCellLocation4.setCellLocationData(l1111l111111Il(l111l11111lIl, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bbd9e8c9a8c8b9e8b969091b69b"), new Object[0]), l1111l111111Il(l111l11111lIl, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bb39e8b968b8a9b9a"), new Object[0]), l1111l111111Il(l111l11111lIl, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bb3909198968b8a9b9a"), new Object[0]), l1111l111111Il(l111l11111lIl, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bac868c8b9a92b69b"), new Object[0]), l1111l111111Il(l111l11111lIl, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bb19a8b88908d94b69b"), new Object[0]));
                                    cdmaCellLocation = cdmaCellLocation4;
                                    gsmCellLocation = gsmCellLocation2;
                                    z = z5;
                                    break;
                                } catch (Exception e) {
                                    cdmaCellLocation3 = cdmaCellLocation4;
                                    gsmCellLocation = gsmCellLocation2;
                                    z4 = z5;
                                }
                            } else {
                                if (z5) {
                                    l1111l111111Il = l1111l111111Il(l111l11111lIl, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bab9e9c"), new Object[0]);
                                    boolean z7 = z5;
                                    int l1111l111111Il2 = l1111l111111Il(l111l11111lIl, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bbc96"), new Object[0]);
                                    boolean z8 = z5;
                                    gsmCellLocation = new GsmCellLocation();
                                    i = l1111l111111Il2;
                                } else {
                                    l1111l111111Il = l1111l111111Il(l111l11111lIl, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bb39e9c"), new Object[0]);
                                    boolean z9 = z5;
                                    int l1111l111111Il3 = l1111l111111Il(l111l11111lIl, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bbc969b"), new Object[0]);
                                    boolean z10 = z5;
                                    gsmCellLocation = new GsmCellLocation();
                                    i = l1111l111111Il3;
                                }
                                try {
                                    gsmCellLocation.setLacAndCid(l1111l111111Il, i);
                                    cdmaCellLocation = cdmaCellLocation2;
                                    z = z5;
                                    break;
                                } catch (Exception e2) {
                                    z4 = z5;
                                    cdmaCellLocation3 = cdmaCellLocation2;
                                }
                            }
                        }
                    } catch (Exception e3) {
                        gsmCellLocation = gsmCellLocation2;
                        cdmaCellLocation3 = cdmaCellLocation2;
                    }
                }
                i2++;
                gsmCellLocation2 = gsmCellLocation;
                cdmaCellLocation2 = cdmaCellLocation3;
                z2 = z4;
            }
            if (z) {
                return cdmaCellLocation;
            }
        }
        return gsmCellLocation;
    }

    private Object l1111l111111Il(String str) {
        Object obj = null;
        try {
            if (this.l111l11111lIl != null) {
                obj = com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(this.l111l11111lIl.getApplicationContext(), com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bac868c8b9a92ac9a8d89969c9a"), new Class[]{String.class}, new Object[]{str});
            }
            return obj;
        } catch (Exception e) {
            return null;
        }
    }

    private static Object l111l11111lIl(Object obj, String str, Object... objArr) {
        Class<?> cls = obj.getClass();
        Class<?>[] clsArr = new Class[objArr.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= objArr.length) {
                break;
            }
            clsArr[i2] = objArr[i2].getClass();
            if (clsArr[i2] == Integer.class) {
                clsArr[i2] = Integer.TYPE;
            }
            i = i2 + 1;
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod.invoke(obj, objArr);
    }

    private static int l111l1111lI1l() {
        try {
            Class.forName(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd18b9a939a8f97909186d1b2ac9692ab9a939a8f97909186b29e919e989a8d"));
            return 1;
        } catch (Exception e) {
            try {
                Class.forName(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9e919b8d90969bd18b9a939a8f97909186d1ab9a939a8f97909186b29e919e989a8dcd"));
                return 2;
            } catch (SecurityException e2) {
                return -1001;
            } catch (Exception e3) {
                return 0;
            }
        }
    }

    private Object l111l1111lIl() {
        String str;
        int l111l1111lI1l = l111l1111lI1l();
        if (l111l1111lI1l == 0) {
            str = "8f9790919a";
        } else if (l111l1111lI1l == 1) {
            str = "8f9790919aa0928c9692";
        } else if (l111l1111lI1l != 2) {
            return null;
        } else {
            str = "8f9790919acd";
        }
        return l1111l111111Il(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il(str));
    }

    private int l111l1111llIl() {
        try {
            if (this.l1111l111111Il != null) {
                return ((Integer) com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(this.l1111l111111Il, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bac9692ac8b9e8b9a"))).intValue();
            }
            return 0;
        } catch (SecurityException e) {
            return -1001;
        } catch (Exception e2) {
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0026 A[Catch: Exception -> 0x00e4, TRY_ENTER, TryCatch #4 {Exception -> 0x00e4, blocks: (B:3:0x0003, B:11:0x0026, B:13:0x0033, B:28:0x0093, B:33:0x00b4, B:37:0x00cd, B:40:0x00dd, B:10:0x001a), top: B:70:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.telephony.CellLocation l11l1111I11l() {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.l111l11111Il.l11l1111I1ll.l11l1111I11l():android.telephony.CellLocation");
    }

    private static boolean l11l1111I1l() {
        Context context = l111l1111llIl.l1111l111111Il.l111l11111Il;
        if (context == null) {
            return false;
        }
        return Build.VERSION.SDK_INT < 23 || context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0;
    }

    private Class<?> l11l1111lIIl() {
        String str;
        String l111l11111Il;
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        int l111l1111lI1l = l111l1111lI1l();
        try {
            if (l111l1111lI1l == 0) {
                str = "9e919b8d90969bd18b9a939a8f97909186d1ab9a939a8f97909186b29e919e989a8d";
            } else if (l111l1111lI1l == 1) {
                str = "9e919b8d90969bd18b9a939a8f97909186d1b2ac9692ab9a939a8f97909186b29e919e989a8d";
            } else if (l111l1111lI1l != 2) {
                l111l11111Il = null;
                return systemClassLoader.loadClass(l111l11111Il);
            } else {
                str = "9e919b8d90969bd18b9a939a8f97909186d1ab9a939a8f97909186b29e919e989a8dcd";
            }
            return systemClassLoader.loadClass(l111l11111Il);
        } catch (Exception e) {
            return null;
        }
        l111l11111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il(str);
    }

    public final String l1111l111111Il() {
        String str = "";
        try {
            if (l11l1111I1l()) {
                if (this.l1111l111111Il != null) {
                    str = (String) com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(this.l1111l111111Il, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bbb9a89969c9ab69b"));
                    if (str == null) {
                        return "";
                    }
                }
                return str;
            }
            return "";
        } catch (SecurityException | Exception e) {
            return "";
        }
    }

    public final String l111l11111I1l() {
        String str = "";
        try {
            if (l11l1111I1l()) {
                if (this.l1111l111111Il != null) {
                    str = (String) com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(this.l1111l111111Il, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bac8a9d8c9c8d969d9a8db69b"));
                    if (str == null) {
                        return "";
                    }
                }
                return str;
            }
            return "";
        } catch (SecurityException | Exception e) {
            return "";
        }
    }

    public final String l111l11111Il() {
        String str = "";
        try {
            if (l11l1111I1l()) {
                if (this.l1111l111111Il != null) {
                    str = (String) com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(this.l1111l111111Il, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bac9692ac9a8d969e93b18a929d9a8d"));
                    if (str == null) {
                        return "";
                    }
                }
                return str;
            }
            return "";
        } catch (SecurityException | Exception e) {
            return "";
        }
    }

    public final String l111l11111lIl() {
        String str = "";
        try {
            if (l11l1111I1l()) {
                if (this.l1111l111111Il != null) {
                    String str2 = (String) com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(this.l1111l111111Il, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bac9692b08f9a8d9e8b908d"));
                    if (str2 != null) {
                        try {
                            if (str2.isEmpty()) {
                            }
                        } catch (Exception e) {
                        }
                        return str2;
                    }
                    str = (String) com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(this.l1111l111111Il, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bb19a8b88908d94b08f9a8d9e8b908db19e929a"));
                    if (str == null) {
                        return "";
                    }
                }
                return str;
            }
            return "";
        } catch (Exception e2) {
            return "";
        }
    }

    public final HashMap<String, String> l111l1111l1Il() {
        String str;
        int checkPermission;
        int checkPermission2;
        String l111l11111Il;
        int baseStationLongitude;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            PackageManager packageManager = this.l111l11111lIl.getPackageManager();
            checkPermission = packageManager.checkPermission("android.permission.ACCESS_FINE_LOCATION", this.l111l11111lIl.getPackageName());
            checkPermission2 = packageManager.checkPermission("android.permission.ACCESS_COARSE_LOCATION", this.l111l11111lIl.getPackageName());
        } catch (Exception e) {
            str = "";
        }
        if (checkPermission == 0 || checkPermission2 == 0) {
            String l111l11111Il2 = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("b1b0afbaadb2");
            try {
                CellLocation l11l1111I11l = l11l1111I11l();
                CellLocation cellLocation = l11l1111I11l;
                if (l11l1111I11l == null) {
                    cellLocation = l11l1111I11l;
                    if (this.l1111l111111Il != null) {
                        cellLocation = (CellLocation) com.ishumei.l111l1111llIl.l111l1111l1Il.l1111l111111Il(this.l1111l111111Il, com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("989a8bbc9a9393b3909c9e8b969091"));
                    }
                }
                if (cellLocation != null) {
                    if (cellLocation instanceof GsmCellLocation) {
                        hashMap.put("type", com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("988c92"));
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        hashMap.put(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9c969b"), String.valueOf(gsmCellLocation.getCid()));
                        l111l11111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("939e9c");
                        baseStationLongitude = gsmCellLocation.getLac();
                    } else if (cellLocation instanceof CdmaCellLocation) {
                        hashMap.put("type", com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9c9b929e"));
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        hashMap.put(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("9d969b"), String.valueOf(cdmaCellLocation.getBaseStationId()));
                        hashMap.put(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("91969b"), String.valueOf(cdmaCellLocation.getNetworkId()));
                        hashMap.put(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("8c969b"), String.valueOf(cdmaCellLocation.getSystemId()));
                        hashMap.put(com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("939e8b"), String.valueOf(cdmaCellLocation.getBaseStationLatitude()));
                        l111l11111Il = com.ishumei.l111l1111llIl.l111l1111lI1l.l111l11111Il("939198");
                        baseStationLongitude = cdmaCellLocation.getBaseStationLongitude();
                    }
                    hashMap.put(l111l11111Il, String.valueOf(baseStationLongitude));
                    return hashMap;
                }
            } catch (Exception e2) {
                str = l111l11111Il2;
                hashMap.put("type", str);
                return hashMap;
            }
            return hashMap;
        }
        return hashMap;
    }
}
