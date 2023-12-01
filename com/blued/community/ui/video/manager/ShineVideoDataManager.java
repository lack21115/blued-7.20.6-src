package com.blued.community.ui.video.manager;

import android.text.TextUtils;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.Logger;
import com.blued.community.http.FlashVideoHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/manager/ShineVideoDataManager.class */
public class ShineVideoDataManager {

    /* renamed from: a  reason: collision with root package name */
    private static ShineVideoDataManager f6815a;
    private List<IShineVideoDataDownloadListner> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<BluedIngSelfFeed> f6816c = new ArrayList();
    private Set<String> d = new HashSet();
    private int e = 1;
    private int f = 30;
    private int h = -1;
    private boolean i = true;
    private boolean j = true;
    private BluedIngSelfFeed k = new BluedIngSelfFeed();
    private boolean l = false;
    private boolean m = false;
    private IRequestHost g;
    private BluedUIHttpResponse n = new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>("shineVideoList", this.g) { // from class: com.blued.community.ui.video.manager.ShineVideoDataManager.1

        /* renamed from: a  reason: collision with root package name */
        public boolean f6817a = false;

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void onUICache(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
            super.onUICache(bluedEntityA);
            if (ShineVideoDataManager.this.e == 1) {
                ShineVideoDataManager.this.d.clear();
                ShineVideoDataManager.this.f6816c.clear();
                if (ShineVideoDataManager.this.l && ShineVideoDataManager.this.k != null) {
                    ShineVideoDataManager.this.f6816c.add(ShineVideoDataManager.this.k);
                }
            }
            List<BluedIngSelfFeed> a2 = ShineVideoDataManager.this.a(bluedEntityA);
            ShineVideoDataManager.this.f6816c.addAll(a2);
            if (ShineVideoDataManager.this.b == null || ShineVideoDataManager.this.b.size() <= 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ShineVideoDataManager.this.b.size()) {
                    return;
                }
                ((IShineVideoDataDownloadListner) ShineVideoDataManager.this.b.get(i2)).b(a2);
                i = i2 + 1;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: b */
        public void onUIUpdate(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
            if (ShineVideoDataManager.this.e == 1) {
                ShineVideoDataManager.this.d.clear();
                ShineVideoDataManager.this.f6816c.clear();
                if (ShineVideoDataManager.this.l && ShineVideoDataManager.this.k != null) {
                    ShineVideoDataManager.this.f6816c.add(ShineVideoDataManager.this.k);
                }
            }
            Logger.b("ShineVideoDataManager", new Object[]{"onUIUpdate:", Integer.valueOf(ShineVideoDataManager.this.e)});
            if (bluedEntityA != null) {
                ShineVideoDataManager.this.j = bluedEntityA.hasMore();
                List<BluedIngSelfFeed> a2 = ShineVideoDataManager.this.a(bluedEntityA);
                ShineVideoDataManager.this.f6816c.addAll(a2);
                if (ShineVideoDataManager.this.b == null || ShineVideoDataManager.this.b.size() <= 0) {
                    return;
                }
                for (int i = 0; i < ShineVideoDataManager.this.b.size(); i++) {
                    ((IShineVideoDataDownloadListner) ShineVideoDataManager.this.b.get(i)).a(bluedEntityA.hasMore(), a2);
                }
            }
        }

        public void onSuccess(String str) {
            super.onSuccess(str);
        }

        public boolean onUIFailure(int i, String str) {
            this.f6817a = true;
            if (ShineVideoDataManager.this.e > 1) {
                ShineVideoDataManager.g(ShineVideoDataManager.this);
            }
            Logger.b("ShineVideoDataManager", new Object[]{"onHandleError:", Integer.valueOf(ShineVideoDataManager.this.e)});
            return super.onUIFailure(i, str);
        }

        public void onUIFinish() {
            super.onUIFinish();
            ShineVideoDataManager.this.i = true;
            if (ShineVideoDataManager.this.b == null || ShineVideoDataManager.this.b.size() <= 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= ShineVideoDataManager.this.b.size()) {
                    return;
                }
                ((IShineVideoDataDownloadListner) ShineVideoDataManager.this.b.get(i2)).a(this.f6817a);
                i = i2 + 1;
            }
        }

        public void onUIStart() {
            this.f6817a = false;
            ShineVideoDataManager.this.i = false;
            if (ShineVideoDataManager.this.b != null && ShineVideoDataManager.this.b.size() > 0) {
                for (int i = 0; i < ShineVideoDataManager.this.b.size(); i++) {
                    ((IShineVideoDataDownloadListner) ShineVideoDataManager.this.b.get(i)).onStart();
                }
            }
            super.onUIStart();
        }
    };

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/manager/ShineVideoDataManager$IShineVideoDataDownloadListner.class */
    public interface IShineVideoDataDownloadListner {
        void a(BluedIngSelfFeed bluedIngSelfFeed);

        void a(boolean z);

        void a(boolean z, List<BluedIngSelfFeed> list);

        void b(BluedIngSelfFeed bluedIngSelfFeed);

        void b(List<BluedIngSelfFeed> list);

        void c(List<BluedIngSelfFeed> list);

        void onStart();
    }

    private ShineVideoDataManager() {
    }

    public static ShineVideoDataManager a() {
        if (f6815a == null) {
            f6815a = new ShineVideoDataManager();
        }
        return f6815a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<BluedIngSelfFeed> a(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
        ArrayList arrayList = new ArrayList();
        if (bluedEntityA != null && bluedEntityA.data != null && bluedEntityA.data.size() > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= bluedEntityA.data.size()) {
                    break;
                }
                Set<String> set = this.d;
                if (!set.contains(((BluedIngSelfFeed) bluedEntityA.data.get(i2)).feed_id + ((BluedIngSelfFeed) bluedEntityA.data.get(i2)).is_ads)) {
                    arrayList.add((BluedIngSelfFeed) bluedEntityA.data.get(i2));
                    Set<String> set2 = this.d;
                    set2.add(((BluedIngSelfFeed) bluedEntityA.data.get(i2)).feed_id + ((BluedIngSelfFeed) bluedEntityA.data.get(i2)).is_ads);
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    static /* synthetic */ int g(ShineVideoDataManager shineVideoDataManager) {
        int i = shineVideoDataManager.e;
        shineVideoDataManager.e = i - 1;
        return i;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed == null) {
            return;
        }
        int i = 0;
        this.l = false;
        this.m = false;
        Iterator<BluedIngSelfFeed> it = this.f6816c.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (TextUtils.equals(it.next().feed_id, bluedIngSelfFeed.feed_id)) {
                this.h = i;
                break;
            } else {
                i++;
            }
        }
        this.k = bluedIngSelfFeed;
    }

    public void a(BluedIngSelfFeed bluedIngSelfFeed, boolean z, boolean z2) {
        if (bluedIngSelfFeed == null) {
            return;
        }
        this.l = true;
        this.m = z2;
        if (z) {
            this.h = 0;
        }
        if (z2) {
            this.k = bluedIngSelfFeed;
            return;
        }
        if (this.f6816c.size() > 0 && TextUtils.equals(bluedIngSelfFeed.feed_id, this.f6816c.get(0).feed_id)) {
            this.f6816c.remove(0);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(bluedIngSelfFeed);
        this.f6816c.addAll(0, arrayList);
        this.k = this.f6816c.get(0);
    }

    public void a(IShineVideoDataDownloadListner iShineVideoDataDownloadListner) {
        this.b.add(iShineVideoDataDownloadListner);
    }

    public void a(String str, String str2) {
        Logger.b("ShineVideoDataManager", new Object[]{"notifyAttentionChanged:", str});
        List<BluedIngSelfFeed> list = this.f6816c;
        if (list == null) {
            return;
        }
        for (BluedIngSelfFeed bluedIngSelfFeed : list) {
            if (TextUtils.equals(bluedIngSelfFeed.feed_id, str)) {
                bluedIngSelfFeed.relationship = str2;
                c(bluedIngSelfFeed);
                return;
            }
        }
    }

    public void a(boolean z, IRequestHost iRequestHost) {
        if (this.m) {
            return;
        }
        this.g = iRequestHost;
        if (z) {
            this.e = 1;
        } else {
            this.e++;
        }
        FlashVideoHttpUtils.a(this.n, this.e, this.f, "", iRequestHost);
    }

    public List<BluedIngSelfFeed> b() {
        if (this.m) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.k);
            return arrayList;
        }
        return this.f6816c;
    }

    public void b(BluedIngSelfFeed bluedIngSelfFeed) {
        a(bluedIngSelfFeed, false, this.m);
    }

    public void b(IShineVideoDataDownloadListner iShineVideoDataDownloadListner) {
        this.b.remove(iShineVideoDataDownloadListner);
    }

    public BluedIngSelfFeed c() {
        return this.k;
    }

    public void c(BluedIngSelfFeed bluedIngSelfFeed) {
        Logger.b("ShineVideoDataManager", new Object[]{"notifyDataHasChanged"});
        List<IShineVideoDataDownloadListner> list = this.b;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.b.size(); i++) {
            this.b.get(i).c(this.f6816c);
            this.b.get(i).a(bluedIngSelfFeed);
        }
    }

    public void c(IShineVideoDataDownloadListner iShineVideoDataDownloadListner) {
        b(iShineVideoDataDownloadListner);
        if (this.l && !this.m) {
            if (this.f6816c.size() > 0) {
                this.f6816c.remove(0);
            }
            List<IShineVideoDataDownloadListner> list = this.b;
            if (list != null && list.size() > 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.b.size()) {
                        break;
                    }
                    this.b.get(i2).a(this.j, this.f6816c);
                    i = i2 + 1;
                }
            }
        }
        this.l = false;
        this.m = false;
    }

    public void d() {
        if (!this.l || this.m) {
            return;
        }
        this.f6816c.clear();
        this.f6816c.add(this.k);
        a(true, (IRequestHost) null);
    }

    public void d(BluedIngSelfFeed bluedIngSelfFeed) {
        BluedIngSelfFeed bluedIngSelfFeed2;
        Logger.b("ShineVideoDataManager", new Object[]{"notifyDataHasRemove"});
        List<BluedIngSelfFeed> list = this.f6816c;
        if (list == null || bluedIngSelfFeed == null) {
            return;
        }
        Iterator<BluedIngSelfFeed> it = list.iterator();
        do {
            bluedIngSelfFeed2 = null;
            if (!it.hasNext()) {
                break;
            }
            bluedIngSelfFeed2 = it.next();
        } while (!TextUtils.equals(bluedIngSelfFeed2.feed_id, bluedIngSelfFeed.feed_id));
        if (bluedIngSelfFeed2 != null) {
            this.f6816c.remove(bluedIngSelfFeed2);
        }
        List<IShineVideoDataDownloadListner> list2 = this.b;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.b.size(); i++) {
            this.b.get(i).b(bluedIngSelfFeed);
        }
    }

    public boolean e() {
        return this.l;
    }

    public int f() {
        return this.e;
    }

    public boolean g() {
        return this.i;
    }

    public boolean h() {
        return this.j;
    }

    public BluedUIHttpResponse i() {
        return this.n;
    }

    public int j() {
        return this.h;
    }
}
