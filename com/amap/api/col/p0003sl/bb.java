package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.bb  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/bb.class */
public final class bb {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<OfflineMapProvince> f4771a = new ArrayList<>();
    private bm b;

    /* renamed from: c  reason: collision with root package name */
    private Context f4772c;

    public bb(Context context) {
        this.f4772c = context;
        this.b = bm.a(context);
    }

    private void a(aw awVar, OfflineMapCity offlineMapCity) {
        int b = awVar.c().b();
        if (awVar.c().equals(awVar.f4756a)) {
            b(awVar.t());
        } else {
            if (awVar.c().equals(awVar.f)) {
                new StringBuilder("saveJSONObjectToFile  CITY ").append(awVar.getCity());
                b(awVar);
                awVar.t().b();
            }
            if (a(awVar.getcompleteCode(), awVar.c().b())) {
                a(awVar.t());
            }
        }
        offlineMapCity.setState(b);
        offlineMapCity.setCompleteCode(awVar.getcompleteCode());
    }

    private void a(aw awVar, OfflineMapProvince offlineMapProvince) {
        bh bhVar;
        int b = awVar.c().b();
        if (b == 6) {
            offlineMapProvince.setState(b);
            offlineMapProvince.setCompleteCode(0);
            b(new bh(offlineMapProvince, this.f4772c));
            try {
                bu.b(offlineMapProvince.getProvinceCode(), this.f4772c);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (a(b) && a(offlineMapProvince)) {
            if (awVar.getPinyin().equals(offlineMapProvince.getPinyin())) {
                offlineMapProvince.setState(b);
                offlineMapProvince.setCompleteCode(awVar.getcompleteCode());
                offlineMapProvince.setVersion(awVar.getVersion());
                offlineMapProvince.setUrl(awVar.getUrl());
                bh bhVar2 = new bh(offlineMapProvince, this.f4772c);
                bhVar2.a(awVar.a());
                bhVar2.d(awVar.getCode());
                bhVar = bhVar2;
            } else {
                offlineMapProvince.setState(b);
                offlineMapProvince.setCompleteCode(100);
                bhVar = new bh(offlineMapProvince, this.f4772c);
            }
            bhVar.b();
            a(bhVar);
            new StringBuilder("saveJSONObjectToFile  province ").append(bhVar.c());
        }
    }

    private void a(bh bhVar) {
        bm bmVar = this.b;
        if (bmVar == null || bhVar == null) {
            return;
        }
        bmVar.a(bhVar);
    }

    private static void a(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
        offlineMapCity.setUrl(offlineMapCity2.getUrl());
        offlineMapCity.setVersion(offlineMapCity2.getVersion());
        offlineMapCity.setSize(offlineMapCity2.getSize());
        offlineMapCity.setCode(offlineMapCity2.getCode());
        offlineMapCity.setPinyin(offlineMapCity2.getPinyin());
        offlineMapCity.setJianpin(offlineMapCity2.getJianpin());
    }

    private static void a(OfflineMapProvince offlineMapProvince, OfflineMapProvince offlineMapProvince2) {
        offlineMapProvince.setUrl(offlineMapProvince2.getUrl());
        offlineMapProvince.setVersion(offlineMapProvince2.getVersion());
        offlineMapProvince.setSize(offlineMapProvince2.getSize());
        offlineMapProvince.setPinyin(offlineMapProvince2.getPinyin());
        offlineMapProvince.setJianpin(offlineMapProvince2.getJianpin());
    }

    private static boolean a(int i) {
        return i == 4;
    }

    private static boolean a(int i, int i2) {
        return i2 != 1 || i <= 2 || i >= 98;
    }

    private static boolean a(OfflineMapProvince offlineMapProvince) {
        if (offlineMapProvince == null) {
            return false;
        }
        Iterator<OfflineMapCity> it = offlineMapProvince.getCityList().iterator();
        while (it.hasNext()) {
            if (it.next().getState() != 4) {
                return false;
            }
        }
        return true;
    }

    private void b(aw awVar) {
        File[] listFiles = new File(dw.c(this.f4772c)).listFiles();
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            File file = listFiles[i2];
            if (file.isFile() && file.exists() && file.getName().contains(awVar.getAdcode()) && file.getName().endsWith(".zip.tmp.dt")) {
                file.delete();
            }
            i = i2 + 1;
        }
    }

    private void b(bh bhVar) {
        bm bmVar = this.b;
        if (bmVar != null) {
            bmVar.b(bhVar);
        }
    }

    private static boolean b(int i) {
        return i == 0 || i == 2 || i == 3 || i == 1 || i == 102 || i == 101 || i == 103 || i == -1;
    }

    private void h() {
        ArrayList<OfflineMapProvince> arrayList = this.f4771a;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f4771a.clear();
            }
        }
    }

    public final OfflineMapCity a(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f4771a) {
            Iterator<OfflineMapProvince> it = this.f4771a.iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    OfflineMapCity next = it2.next();
                    if (next.getCode().equals(str)) {
                        return next;
                    }
                }
            }
            return null;
        }
    }

    public final ArrayList<OfflineMapProvince> a() {
        ArrayList<OfflineMapProvince> arrayList = new ArrayList<>();
        synchronized (this.f4771a) {
            Iterator<OfflineMapProvince> it = this.f4771a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList;
    }

    public final void a(aw awVar) {
        String pinyin = awVar.getPinyin();
        synchronized (this.f4771a) {
            Iterator<OfflineMapProvince> it = this.f4771a.iterator();
            loop0: while (true) {
                if (!it.hasNext()) {
                    break;
                }
                OfflineMapProvince next = it.next();
                if (next != null) {
                    for (OfflineMapCity offlineMapCity : next.getCityList()) {
                        if (offlineMapCity.getPinyin().trim().equals(pinyin.trim())) {
                            a(awVar, offlineMapCity);
                            a(awVar, next);
                            break loop0;
                        }
                    }
                    continue;
                }
            }
        }
    }

    public final void a(List<OfflineMapProvince> list) {
        OfflineMapProvince offlineMapProvince;
        OfflineMapCity offlineMapCity;
        synchronized (this.f4771a) {
            if (this.f4771a.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.f4771a.size()) {
                        break;
                    }
                    OfflineMapProvince offlineMapProvince2 = this.f4771a.get(i2);
                    Iterator<OfflineMapProvince> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            offlineMapProvince = null;
                            break;
                        }
                        offlineMapProvince = it.next();
                        if (offlineMapProvince2.getPinyin().equals(offlineMapProvince.getPinyin())) {
                            break;
                        } else if (offlineMapProvince2.getPinyin().equals("quanguogaiyaotu") || offlineMapProvince2.getProvinceCode().equals("000001") || offlineMapProvince2.getProvinceCode().equals("100000")) {
                            if (offlineMapProvince.getPinyin().equals("quanguogaiyaotu")) {
                                break;
                            }
                        }
                    }
                    if (offlineMapProvince != null) {
                        a(offlineMapProvince2, offlineMapProvince);
                        ArrayList<OfflineMapCity> cityList = offlineMapProvince2.getCityList();
                        ArrayList<OfflineMapCity> cityList2 = offlineMapProvince.getCityList();
                        int i3 = 0;
                        while (true) {
                            int i4 = i3;
                            if (i4 < cityList.size()) {
                                OfflineMapCity offlineMapCity2 = cityList.get(i4);
                                Iterator<OfflineMapCity> it2 = cityList2.iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        offlineMapCity = null;
                                        break;
                                    }
                                    offlineMapCity = it2.next();
                                    if (offlineMapCity2.getPinyin().equals(offlineMapCity.getPinyin())) {
                                        break;
                                    }
                                }
                                if (offlineMapCity != null) {
                                    a(offlineMapCity2, offlineMapCity);
                                }
                                i3 = i4 + 1;
                            }
                        }
                    }
                    i = i2 + 1;
                }
            } else {
                for (OfflineMapProvince offlineMapProvince3 : list) {
                    this.f4771a.add(offlineMapProvince3);
                }
            }
        }
    }

    public final OfflineMapCity b(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f4771a) {
            Iterator<OfflineMapProvince> it = this.f4771a.iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    OfflineMapCity next = it2.next();
                    if (next.getCity().trim().equalsIgnoreCase(str.trim())) {
                        return next;
                    }
                }
            }
            return null;
        }
    }

    public final ArrayList<OfflineMapCity> b() {
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        synchronized (this.f4771a) {
            Iterator<OfflineMapProvince> it = this.f4771a.iterator();
            while (it.hasNext()) {
                Iterator<OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            }
        }
        return arrayList;
    }

    public final OfflineMapProvince c(String str) {
        OfflineMapProvince next;
        if (str == null || "".equals(str)) {
            return null;
        }
        synchronized (this.f4771a) {
            Iterator<OfflineMapProvince> it = this.f4771a.iterator();
            do {
                if (!it.hasNext()) {
                    return null;
                }
                next = it.next();
            } while (!next.getProvinceName().trim().equalsIgnoreCase(str.trim()));
            return next;
        }
    }

    public final ArrayList<OfflineMapCity> c() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f4771a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.f4771a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null) {
                    for (OfflineMapCity offlineMapCity : next.getCityList()) {
                        if (offlineMapCity.getState() == 4 || offlineMapCity.getState() == 7) {
                            arrayList.add(offlineMapCity);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapProvince> d() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f4771a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.f4771a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null && (next.getState() == 4 || next.getState() == 7)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapCity> e() {
        ArrayList<OfflineMapCity> arrayList;
        synchronized (this.f4771a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.f4771a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null) {
                    for (OfflineMapCity offlineMapCity : next.getCityList()) {
                        if (b(offlineMapCity.getState())) {
                            arrayList.add(offlineMapCity);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList<OfflineMapProvince> f() {
        ArrayList<OfflineMapProvince> arrayList;
        synchronized (this.f4771a) {
            arrayList = new ArrayList<>();
            Iterator<OfflineMapProvince> it = this.f4771a.iterator();
            while (it.hasNext()) {
                OfflineMapProvince next = it.next();
                if (next != null && b(next.getState())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public final void g() {
        h();
        this.b = null;
        this.f4772c = null;
    }
}
