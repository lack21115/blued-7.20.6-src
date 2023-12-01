package com.blued.android.module.live_china.manager;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/MakeLoverBaseManager.class */
public class MakeLoverBaseManager {
    public List<LiveMakeLoverFansModel> a = new ArrayList();

    public LiveMakeLoverFansModel a(int i) {
        List<LiveMakeLoverFansModel> list = this.a;
        if (list != null && i >= 0 && i < list.size()) {
            return this.a.get(i);
        }
        return null;
    }

    public LiveMakeLoverFansModel a(String str) {
        List<LiveMakeLoverFansModel> list = this.a;
        if (list == null) {
            return null;
        }
        for (LiveMakeLoverFansModel liveMakeLoverFansModel : list) {
            if (TextUtils.equals(liveMakeLoverFansModel.uid, str)) {
                return liveMakeLoverFansModel;
            }
        }
        return null;
    }

    public List<LiveMakeLoverFansModel> a() {
        return this.a;
    }

    public void a(String str, String str2) {
        LiveMakeLoverFansModel a = a(str);
        if (a != null) {
            a.pic = str2;
            Log.i("==makelover===", "baozhao:" + str2);
        }
    }

    public void a(List<LiveMakeLoverFansModel> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (LiveMakeLoverFansModel liveMakeLoverFansModel : list) {
            boolean z = false;
            if (!liveMakeLoverFansModel.isEmpty()) {
                Iterator<LiveMakeLoverFansModel> it = this.a.iterator();
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    LiveMakeLoverFansModel next = it.next();
                    if (TextUtils.equals(next.uid, liveMakeLoverFansModel.uid)) {
                        liveMakeLoverFansModel.lamp = next.lamp;
                        liveMakeLoverFansModel.pic = next.pic;
                        liveMakeLoverFansModel.voice = next.voice;
                        z = true;
                        break;
                    }
                }
            }
            if (!z) {
                liveMakeLoverFansModel.lamp = 1;
            }
            arrayList.add(liveMakeLoverFansModel);
        }
        this.a.clear();
        this.a.addAll(arrayList);
    }

    public int b(String str) {
        LiveMakeLoverFansModel liveMakeLoverFansModel;
        List<LiveMakeLoverFansModel> list = this.a;
        if (list == null) {
            return -1;
        }
        int i = 0;
        Iterator<LiveMakeLoverFansModel> it = list.iterator();
        while (true) {
            liveMakeLoverFansModel = null;
            if (!it.hasNext()) {
                break;
            }
            liveMakeLoverFansModel = it.next();
            if (TextUtils.equals(liveMakeLoverFansModel.uid, str)) {
                break;
            }
            i++;
        }
        if (liveMakeLoverFansModel != null) {
            this.a.set(i, new LiveMakeLoverFansModel());
            return i;
        }
        return -1;
    }

    public void b() {
        for (LiveMakeLoverFansModel liveMakeLoverFansModel : this.a) {
            liveMakeLoverFansModel.lamp = 1;
        }
    }

    public void c(String str) {
        LiveMakeLoverFansModel a = a(str);
        if (a != null) {
            a.lamp = 0;
        }
    }

    public boolean c() {
        boolean z;
        List<LiveMakeLoverFansModel> list = this.a;
        if (list == null) {
            return false;
        }
        boolean z2 = list.size() > 0 && !this.a.get(0).isEmpty();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.size()) {
                z = false;
                break;
            } else if (i2 != 0 && !this.a.get(i2).isEmpty()) {
                z = true;
                break;
            } else {
                i = i2 + 1;
            }
        }
        boolean z3 = false;
        if (z2) {
            z3 = false;
            if (z) {
                z3 = true;
            }
        }
        return z3;
    }

    public boolean d() {
        boolean z;
        List<LiveMakeLoverFansModel> list = this.a;
        if (list == null) {
            return false;
        }
        Iterator<LiveMakeLoverFansModel> it = list.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            }
            LiveMakeLoverFansModel next = it.next();
            if (TextUtils.equals(next.uid, LiveRoomInfo.a().f())) {
                z = false;
                if (next.lamp != 1) {
                    z = true;
                }
            }
        }
        return z;
    }

    public boolean e() {
        boolean z;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.size()) {
                z = false;
                break;
            } else if (i2 != 0 && !this.a.get(i2).isEmpty() && this.a.get(i2).lamp == 1) {
                z = true;
                break;
            } else {
                i = i2 + 1;
            }
        }
        boolean z2 = false;
        if (z) {
            z2 = false;
            if (c()) {
                z2 = true;
            }
        }
        return z2;
    }
}
