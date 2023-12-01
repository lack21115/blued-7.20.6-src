package com.blued.community.ui.video.manager;

import android.text.TextUtils;
import android.util.Log;
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

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/manager/UserInfoVideoDataManager.class */
public class UserInfoVideoDataManager {
    private static UserInfoVideoDataManager b;

    /* renamed from: c  reason: collision with root package name */
    private List<IShineVideoDataDownloadListner> f20425c = new ArrayList();
    private List<BluedIngSelfFeed> d = new ArrayList();
    private List<BluedIngSelfFeed> e = new ArrayList();
    private Set<String> f = new HashSet();
    private int g = 0;
    private int h = 0;
    private int i = 30;
    private int j = 30;
    private int l = -1;
    private boolean m = true;
    private boolean n = true;
    private BluedIngSelfFeed o = new BluedIngSelfFeed();

    /* renamed from: a  reason: collision with root package name */
    public boolean f20424a = true;
    private IRequestHost k;
    private BluedUIHttpResponse p = new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>("shineVideoList", this.k) { // from class: com.blued.community.ui.video.manager.UserInfoVideoDataManager.1

        /* renamed from: a  reason: collision with root package name */
        public boolean f20426a = false;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
            if (UserInfoVideoDataManager.this.h == 1) {
                UserInfoVideoDataManager.this.f.clear();
                UserInfoVideoDataManager.this.d.clear();
            }
            if (bluedEntityA != null) {
                UserInfoVideoDataManager.this.n = bluedEntityA.hasMore();
                List<BluedIngSelfFeed> a2 = UserInfoVideoDataManager.this.a(bluedEntityA);
                UserInfoVideoDataManager.this.d.addAll(a2);
                Log.v("drb", "user下载成功：" + UserInfoVideoDataManager.this.d.size() + " -- isHasMore:" + UserInfoVideoDataManager.this.n);
                if (UserInfoVideoDataManager.this.f20425c != null && UserInfoVideoDataManager.this.f20425c.size() > 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= UserInfoVideoDataManager.this.f20425c.size()) {
                            break;
                        }
                        ((IShineVideoDataDownloadListner) UserInfoVideoDataManager.this.f20425c.get(i2)).a(bluedEntityA.hasMore(), a2);
                        i = i2 + 1;
                    }
                }
                if (UserInfoVideoDataManager.this.n) {
                    UserInfoVideoDataManager.this.f20424a = true;
                    return;
                }
                UserInfoVideoDataManager.this.f20424a = false;
                UserInfoVideoDataManager userInfoVideoDataManager = UserInfoVideoDataManager.this;
                userInfoVideoDataManager.c(userInfoVideoDataManager.k);
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            this.f20426a = true;
            if (UserInfoVideoDataManager.this.h > 1) {
                UserInfoVideoDataManager.g(UserInfoVideoDataManager.this);
            }
            Log.v("drb", "getUserInfoVideoCallBack onUIFailure");
            return true;
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            UserInfoVideoDataManager.this.m = true;
            if (UserInfoVideoDataManager.this.f20425c == null || UserInfoVideoDataManager.this.f20425c.size() <= 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= UserInfoVideoDataManager.this.f20425c.size()) {
                    return;
                }
                ((IShineVideoDataDownloadListner) UserInfoVideoDataManager.this.f20425c.get(i2)).a(this.f20426a);
                i = i2 + 1;
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            UserInfoVideoDataManager.this.m = false;
        }
    };
    private BluedUIHttpResponse q = new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>("shineVideoList", this.k) { // from class: com.blued.community.ui.video.manager.UserInfoVideoDataManager.2

        /* renamed from: a  reason: collision with root package name */
        public boolean f20427a = false;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        /* renamed from: a */
        public void onUIUpdate(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
            if (bluedEntityA == null) {
                return;
            }
            UserInfoVideoDataManager.this.n = bluedEntityA.hasMore();
            List<BluedIngSelfFeed> a2 = UserInfoVideoDataManager.this.a(bluedEntityA);
            Log.v("drb", "ai下载成功：" + bluedEntityA.data.size());
            UserInfoVideoDataManager.this.d.addAll(a2);
            if (UserInfoVideoDataManager.this.f20425c == null || UserInfoVideoDataManager.this.f20425c.size() <= 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= UserInfoVideoDataManager.this.f20425c.size()) {
                    return;
                }
                ((IShineVideoDataDownloadListner) UserInfoVideoDataManager.this.f20425c.get(i2)).a(bluedEntityA.hasMore(), a2);
                i = i2 + 1;
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public boolean onUIFailure(int i, String str) {
            this.f20427a = true;
            if (UserInfoVideoDataManager.this.g > 1) {
                UserInfoVideoDataManager.i(UserInfoVideoDataManager.this);
            }
            Log.v("drb", "getAiVideoCallBack onUIFailure");
            return true;
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish() {
            super.onUIFinish();
            UserInfoVideoDataManager.this.m = true;
            if (UserInfoVideoDataManager.this.f20425c == null || UserInfoVideoDataManager.this.f20425c.size() <= 0) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= UserInfoVideoDataManager.this.f20425c.size()) {
                    return;
                }
                ((IShineVideoDataDownloadListner) UserInfoVideoDataManager.this.f20425c.get(i2)).a(this.f20427a);
                i = i2 + 1;
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIStart() {
            super.onUIStart();
            UserInfoVideoDataManager.this.m = false;
        }
    };

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/manager/UserInfoVideoDataManager$IShineVideoDataDownloadListner.class */
    public interface IShineVideoDataDownloadListner {
        void a(BluedIngSelfFeed bluedIngSelfFeed);

        void a(boolean z);

        void a(boolean z, List<BluedIngSelfFeed> list);

        void b(BluedIngSelfFeed bluedIngSelfFeed);

        void b(List<BluedIngSelfFeed> list);
    }

    private UserInfoVideoDataManager() {
    }

    public static UserInfoVideoDataManager a() {
        if (b == null) {
            b = new UserInfoVideoDataManager();
        }
        return b;
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
                BluedIngSelfFeed bluedIngSelfFeed = bluedEntityA.data.get(i2);
                if (!this.f.contains(bluedIngSelfFeed.feed_id)) {
                    if (bluedIngSelfFeed.isRepost()) {
                        arrayList.add(bluedIngSelfFeed.repost);
                    } else {
                        arrayList.add(bluedIngSelfFeed);
                    }
                    this.f.add(bluedIngSelfFeed.feed_id);
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(IRequestHost iRequestHost) {
        this.k = iRequestHost;
        int i = this.g + 1;
        this.g = i;
        FlashVideoHttpUtils.a(this.q, i, this.i, "", iRequestHost);
    }

    static /* synthetic */ int g(UserInfoVideoDataManager userInfoVideoDataManager) {
        int i = userInfoVideoDataManager.h;
        userInfoVideoDataManager.h = i - 1;
        return i;
    }

    static /* synthetic */ int i(UserInfoVideoDataManager userInfoVideoDataManager) {
        int i = userInfoVideoDataManager.g;
        userInfoVideoDataManager.g = i - 1;
        return i;
    }

    public void a(int i) {
        Log.v("drb", "setCurrentViewedPosition:" + this.l);
        this.l = i;
    }

    public void a(IRequestHost iRequestHost) {
        Log.v("drb", "startDownloadForUser");
        this.k = iRequestHost;
        int i = this.h + 1;
        this.h = i;
        FlashVideoHttpUtils.a(this.p, i, this.j, this.o.feed_uid, this.o.feed_id, iRequestHost);
    }

    public void a(BluedIngSelfFeed bluedIngSelfFeed) {
        if (bluedIngSelfFeed == null) {
            return;
        }
        d();
        Log.v("drb", "id:" + bluedIngSelfFeed.feed_uid + "currentViewedPosition:" + this.l);
        this.d.clear();
        this.l = 0;
        this.o = bluedIngSelfFeed;
        this.d.add(bluedIngSelfFeed);
        this.f.add(this.o.feed_id);
        b(this.k);
    }

    public void a(IShineVideoDataDownloadListner iShineVideoDataDownloadListner) {
        this.f20425c.add(iShineVideoDataDownloadListner);
    }

    public void a(String str, String str2) {
        Logger.b("UserInfoVideoDataManager", "notifyAttentionChanged:", str);
        List<BluedIngSelfFeed> list = this.d;
        if (list == null) {
            return;
        }
        for (BluedIngSelfFeed bluedIngSelfFeed : list) {
            if (TextUtils.equals(bluedIngSelfFeed.feed_id, str)) {
                bluedIngSelfFeed.relationship = str2;
                b(bluedIngSelfFeed);
                return;
            }
        }
    }

    public List<BluedIngSelfFeed> b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.d.size()) {
                return this.d;
            }
            Log.v("drb", "getData:" + i2 + " -- " + this.d.get(i2).feed_content);
            i = i2 + 1;
        }
    }

    public void b(IRequestHost iRequestHost) {
        Log.v("drb", "startDownload hasUserInfoData:" + this.f20424a);
        if (this.f20424a) {
            a(iRequestHost);
        } else {
            c(iRequestHost);
        }
    }

    public void b(BluedIngSelfFeed bluedIngSelfFeed) {
        Logger.b("UserInfoVideoDataManager", "notifyDataHasChanged");
        List<IShineVideoDataDownloadListner> list = this.f20425c;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.f20425c.size(); i++) {
            this.f20425c.get(i).b(this.d);
            this.f20425c.get(i).a(bluedIngSelfFeed);
        }
    }

    public void b(IShineVideoDataDownloadListner iShineVideoDataDownloadListner) {
        this.f20425c.remove(iShineVideoDataDownloadListner);
    }

    public BluedIngSelfFeed c() {
        return this.o;
    }

    public void c(BluedIngSelfFeed bluedIngSelfFeed) {
        BluedIngSelfFeed bluedIngSelfFeed2;
        Logger.b("UserInfoVideoDataManager", "notifyDataHasRemove");
        List<BluedIngSelfFeed> list = this.d;
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
            this.d.remove(bluedIngSelfFeed2);
        }
        List<IShineVideoDataDownloadListner> list2 = this.f20425c;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.f20425c.size(); i++) {
            this.f20425c.get(i).b(bluedIngSelfFeed);
        }
    }

    public void d() {
        this.f20424a = true;
        this.n = true;
        this.g = 0;
        this.h = 0;
    }

    public boolean e() {
        return this.m;
    }

    public boolean f() {
        return this.n;
    }

    public int g() {
        Log.v("drb", "getCurrentViewdPosition:" + this.l);
        return this.l;
    }
}
