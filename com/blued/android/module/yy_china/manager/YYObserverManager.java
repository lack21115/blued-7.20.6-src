package com.blued.android.module.yy_china.manager;

import com.blued.android.module.yy_china.model.YYAudienceModel;
import com.blued.android.module.yy_china.model.YYGiftBeansModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.observer.AudienceCountObserver;
import com.blued.android.module.yy_china.observer.AudiencesChangedObserver;
import com.blued.android.module.yy_china.observer.FollowStatusObserver;
import com.blued.android.module.yy_china.observer.GiftBeansObserver;
import com.blued.android.module.yy_china.observer.GiftObserver;
import com.blued.android.module.yy_china.observer.IMMessageObserver;
import com.blued.android.module.yy_china.observer.NewGiftComesObserver;
import com.blued.android.module.yy_china.observer.RoleStatusObserver;
import com.blued.android.module.yy_china.observer.SeatChangedObserver;
import com.blued.android.module.yy_china.observer.WaittingCountObserver;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYObserverManager.class */
public class YYObserverManager {
    private List<AudienceCountObserver> a;
    private List<FollowStatusObserver> b;
    private List<IMMessageObserver> c;
    private List<WaittingCountObserver> d;
    private List<RoleStatusObserver> e;
    private List<AudiencesChangedObserver> f;
    private List<SeatChangedObserver> g;
    private List<GiftBeansObserver> h;
    private List<GiftObserver> i;
    private List<NewGiftComesObserver> j;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYObserverManager$Manager.class */
    public static class Manager {
        public static YYObserverManager a = new YYObserverManager();
    }

    private YYObserverManager() {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
    }

    public static YYObserverManager a() {
        return Manager.a;
    }

    public void a(int i) {
        List<AudienceCountObserver> list = this.a;
        if (list == null) {
            return;
        }
        for (AudienceCountObserver audienceCountObserver : list) {
            audienceCountObserver.a(i);
        }
    }

    public void a(int i, int i2) {
        List<SeatChangedObserver> list = this.g;
        if (list == null) {
            return;
        }
        for (SeatChangedObserver seatChangedObserver : list) {
            seatChangedObserver.a(i, i2);
        }
    }

    public void a(YYGiftBeansModel yYGiftBeansModel) {
        if (this.i == null) {
            return;
        }
        for (NewGiftComesObserver newGiftComesObserver : this.j) {
            newGiftComesObserver.a(yYGiftBeansModel);
        }
    }

    public void a(YYImModel yYImModel) {
        List<IMMessageObserver> list = this.c;
        if (list == null) {
            return;
        }
        for (IMMessageObserver iMMessageObserver : list) {
            iMMessageObserver.a(yYImModel);
        }
    }

    public void a(YYImModel yYImModel, boolean z) {
        List<GiftObserver> list = this.i;
        if (list == null) {
            return;
        }
        for (GiftObserver giftObserver : list) {
            giftObserver.a(yYImModel, z);
        }
    }

    public void a(AudienceCountObserver audienceCountObserver) {
        List<AudienceCountObserver> list = this.a;
        if (list == null) {
            return;
        }
        list.add(audienceCountObserver);
    }

    public void a(AudiencesChangedObserver audiencesChangedObserver) {
        List<AudiencesChangedObserver> list = this.f;
        if (list == null) {
            return;
        }
        list.add(audiencesChangedObserver);
    }

    public void a(FollowStatusObserver followStatusObserver) {
        List<FollowStatusObserver> list = this.b;
        if (list == null) {
            return;
        }
        list.add(followStatusObserver);
    }

    public void a(GiftBeansObserver giftBeansObserver) {
        List<GiftBeansObserver> list = this.h;
        if (list == null) {
            return;
        }
        list.add(giftBeansObserver);
    }

    public void a(GiftObserver giftObserver) {
        List<GiftObserver> list = this.i;
        if (list == null) {
            return;
        }
        list.add(giftObserver);
    }

    public void a(IMMessageObserver iMMessageObserver) {
        List<IMMessageObserver> list = this.c;
        if (list == null) {
            return;
        }
        list.add(iMMessageObserver);
    }

    public void a(NewGiftComesObserver newGiftComesObserver) {
        List<NewGiftComesObserver> list = this.j;
        if (list == null) {
            return;
        }
        list.add(newGiftComesObserver);
    }

    public void a(RoleStatusObserver roleStatusObserver) {
        List<RoleStatusObserver> list = this.e;
        if (list == null) {
            return;
        }
        list.add(roleStatusObserver);
    }

    public void a(SeatChangedObserver seatChangedObserver) {
        List<SeatChangedObserver> list = this.g;
        if (list == null) {
            return;
        }
        list.add(seatChangedObserver);
    }

    public void a(WaittingCountObserver waittingCountObserver) {
        List<WaittingCountObserver> list = this.d;
        if (list == null) {
            return;
        }
        list.add(waittingCountObserver);
    }

    public void a(String str) {
        List<RoleStatusObserver> list = this.e;
        if (list == null) {
            return;
        }
        for (RoleStatusObserver roleStatusObserver : list) {
            roleStatusObserver.a(str);
        }
    }

    public void a(String str, String str2) {
        List<FollowStatusObserver> list = this.b;
        if (list == null) {
            return;
        }
        for (FollowStatusObserver followStatusObserver : list) {
            followStatusObserver.a_(str, str2);
        }
    }

    public void a(List<YYAudienceModel> list) {
        List<AudiencesChangedObserver> list2 = this.f;
        if (list2 == null) {
            return;
        }
        for (AudiencesChangedObserver audiencesChangedObserver : list2) {
            audiencesChangedObserver.a(list);
        }
    }

    public void b() {
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.h.clear();
        this.i.clear();
        this.j.clear();
    }

    public void b(int i) {
        List<WaittingCountObserver> list = this.d;
        if (list == null) {
            return;
        }
        for (WaittingCountObserver waittingCountObserver : list) {
            waittingCountObserver.a(i);
        }
    }

    public void b(AudienceCountObserver audienceCountObserver) {
        List<AudienceCountObserver> list = this.a;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.a.remove(audienceCountObserver);
    }

    public void b(AudiencesChangedObserver audiencesChangedObserver) {
        List<AudiencesChangedObserver> list = this.f;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f.remove(audiencesChangedObserver);
    }

    public void b(FollowStatusObserver followStatusObserver) {
        List<FollowStatusObserver> list = this.b;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.b.remove(followStatusObserver);
    }

    public void b(GiftBeansObserver giftBeansObserver) {
        List<GiftBeansObserver> list = this.h;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.h.remove(giftBeansObserver);
    }

    public void b(IMMessageObserver iMMessageObserver) {
        List<IMMessageObserver> list = this.c;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.c.remove(iMMessageObserver);
    }

    public void b(NewGiftComesObserver newGiftComesObserver) {
        List<NewGiftComesObserver> list = this.j;
        if (list == null) {
            return;
        }
        list.remove(newGiftComesObserver);
    }

    public void b(RoleStatusObserver roleStatusObserver) {
        List<RoleStatusObserver> list = this.e;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.e.remove(roleStatusObserver);
    }

    public void b(SeatChangedObserver seatChangedObserver) {
        List<SeatChangedObserver> list = this.g;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.g.remove(seatChangedObserver);
    }

    public void b(WaittingCountObserver waittingCountObserver) {
        List<WaittingCountObserver> list = this.d;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.d.remove(waittingCountObserver);
    }

    public void b(String str) {
        List<GiftBeansObserver> list = this.h;
        if (list == null) {
            return;
        }
        for (GiftBeansObserver giftBeansObserver : list) {
            giftBeansObserver.b(str);
        }
    }

    public void b(List<YYSeatMemberModel> list) {
        List<SeatChangedObserver> list2 = this.g;
        if (list2 == null) {
            return;
        }
        for (SeatChangedObserver seatChangedObserver : list2) {
            seatChangedObserver.b(list);
        }
    }

    public void c(int i) {
        List<RoleStatusObserver> list = this.e;
        if (list == null) {
            return;
        }
        for (RoleStatusObserver roleStatusObserver : list) {
            roleStatusObserver.a(i);
        }
    }

    public boolean c(FollowStatusObserver followStatusObserver) {
        List<FollowStatusObserver> list = this.b;
        if (list == null) {
            return false;
        }
        return list.contains(followStatusObserver);
    }
}
