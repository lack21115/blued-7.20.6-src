package com.tencent.mapsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.map.sdk.comps.offlinemap.OfflineCity;
import com.tencent.map.sdk.comps.offlinemap.OfflineItem;
import com.tencent.map.sdk.comps.offlinemap.OfflineItemController;
import com.tencent.map.sdk.comps.offlinemap.OfflineMapComponent;
import com.tencent.map.sdk.comps.offlinemap.OfflineMapSyncedListener;
import com.tencent.map.sdk.comps.offlinemap.OfflineNation;
import com.tencent.map.sdk.comps.offlinemap.OfflineProvince;
import com.tencent.map.sdk.comps.offlinemap.OfflineStatusChangedListener;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateRsp;
import com.tencent.mapsdk.core.components.protocol.jce.conf.SCFileUpdateRsp;
import com.tencent.mapsdk.internal.b2;
import com.tencent.mapsdk.internal.ca;
import com.tencent.mapsdk.internal.v3;
import com.tencent.mapsdk.internal.w3;
import com.tencent.mapsdk.internal.x3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d2.class */
public class d2 extends p1 implements OfflineMapComponent, b2.d {
    public static final String q = "key_offline_map_opened_cities";
    public static final String r = "key_offline_map_config_version";
    public static final String s = "key_offline_map_config_md5";
    public static final String t = "key_offline_map_config_url";
    private static final String u = "key_offline_map_items_state";
    public static final String v = "sdk_offline_city_ver.json";
    public static final String w = "offline_city_list.json";

    /* renamed from: c  reason: collision with root package name */
    private ic f37384c;
    private boolean d;
    private List<OfflineItem> e = new ArrayList();
    private List<OfflineItem> f = new ArrayList();
    private Map<String, c> g = new HashMap();
    private File h;
    private File i;
    private String j;
    private e2 k;
    private Map<c2, b2> l;
    private volatile Callback<List<OfflineItem>> m;
    private OfflineMapSyncedListener n;
    private volatile boolean o;
    private boolean p;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d2$a.class */
    public class a extends ca.c<Object> {
        public a() {
        }

        @Override // com.tencent.mapsdk.internal.ca.c, com.tencent.map.tools.Callback
        public void callback(Object obj) {
            if (d2.this.m != null) {
                d2.this.m.callback(d2.this.getOfflineItemList());
                d2.this.m = null;
            }
            d2.this.o = false;
            if (d2.this.n != null) {
                d2.this.n.onSynced(d2.this.p);
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d2$b.class */
    public class b extends ca.i<Object> {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ q1 f37385c;

        public b(q1 q1Var) {
            this.f37385c = q1Var;
        }

        @Override // java.util.concurrent.Callable
        public Object call() throws Exception {
            d2.this.p = false;
            if (!d2.this.d) {
                d2.this.d(this.f37385c);
                return null;
            }
            d2 d2Var = d2.this;
            d2Var.p = d2Var.j();
            d2 d2Var2 = d2.this;
            d2Var2.p = d2Var2.i();
            return null;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/d2$c.class */
    public static class c extends JsonComposer {

        /* renamed from: a  reason: collision with root package name */
        public String f37386a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f37387c;

        private c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    private b2 a(OfflineItem offlineItem, OfflineStatusChangedListener offlineStatusChangedListener) {
        List<OfflineItem> list;
        boolean z;
        q1 mapContext = getMapContext();
        if (offlineItem == null || (list = this.e) == null || this.k == null || mapContext == null) {
            na.g(ma.u, "无效配置 config:" + this.k + "|item:" + offlineItem);
            return null;
        }
        Iterator<OfflineItem> it = list.iterator();
        while (true) {
            z = false;
            if (!it.hasNext()) {
                break;
            } else if (it.next() == offlineItem) {
                z = true;
                break;
            }
        }
        if (!z) {
            na.g(ma.u, "无效城市：" + offlineItem);
            return null;
        }
        c2 a2 = this.k.a(offlineItem);
        if (a2 != null) {
            b2 b2Var = this.l.get(a2);
            b2 b2Var2 = b2Var;
            if (b2Var == null) {
                b2Var2 = new b2(mapContext, this.j, offlineItem, a2, this.f37384c, offlineStatusChangedListener);
                this.l.put(a2, b2Var2);
            }
            b2Var2.a(offlineStatusChangedListener);
            b2Var2.a(this);
            na.c(ma.u, "获得离线城市[" + offlineItem.getName() + "]的配置成功！");
            return b2Var2;
        }
        return null;
    }

    private void c(q1 q1Var) {
        String a2 = this.f37384c.a(q, "");
        if (this.d || !TextUtils.isEmpty(a2)) {
            w6 w2 = q1Var.w();
            if (w2 != null) {
                w2.m().b();
            }
            if (this.o) {
                return;
            }
            this.o = true;
            ca.a((ca.i) new b(q1Var)).a((ca.d.b) null, (ca.c<ca.d.b>) new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(q1 q1Var) {
        for (OfflineItem offlineItem : g()) {
            b2 a2 = a(offlineItem, (OfflineStatusChangedListener) null);
            if (a2 != null) {
                a2.a(q1Var);
            }
        }
    }

    private List<OfflineItem> g() {
        List<OfflineItem> list;
        ArrayList arrayList = new ArrayList();
        String[] split = this.f37384c.a(q, "").split(",");
        if (split.length != 0 && (list = this.e) != null) {
            for (OfflineItem offlineItem : list) {
                if (Arrays.binarySearch(split, offlineItem.getPinyin()) >= 0) {
                    arrayList.add(offlineItem);
                }
            }
        }
        return arrayList;
    }

    private void g(String str) throws JSONException {
        synchronized (this) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Object nextValue = new JSONTokener(str).nextValue();
            if (nextValue instanceof JSONArray) {
                List<a2> parseToList = JsonUtils.parseToList((JSONArray) nextValue, a2.class, new Object[0]);
                if (!parseToList.isEmpty()) {
                    this.e = new ArrayList();
                    this.f = new ArrayList();
                    for (a2 a2Var : parseToList) {
                        if (a2Var.b.startsWith(th.i)) {
                            OfflineNation a2 = a2Var.a();
                            this.f.add(a2);
                            this.e.add(a2);
                        } else {
                            List<a2> list = a2Var.f37286c;
                            if (list == null || list.isEmpty()) {
                                OfflineCity a3 = a2Var.a((OfflineProvince) null);
                                this.f.add(a3);
                                this.e.add(a3);
                            } else {
                                ArrayList arrayList = new ArrayList();
                                OfflineProvince a4 = a2Var.a(arrayList);
                                this.f.add(a4);
                                for (a2 a2Var2 : a2Var.f37286c) {
                                    OfflineCity a5 = a2Var2.a(a4);
                                    this.e.add(a5);
                                    arrayList.add(a5);
                                }
                            }
                        }
                    }
                    h();
                }
            }
        }
    }

    private void h() {
        e2 e2Var = this.k;
        if (e2Var == null || e2Var.e == null || this.e.isEmpty()) {
            return;
        }
        na.c(ma.u, "添加item的数据状态");
        Set<String> keySet = this.g.keySet();
        for (OfflineItem offlineItem : this.e) {
            Iterator<c2> it = this.k.e.iterator();
            while (true) {
                if (it.hasNext()) {
                    c2 next = it.next();
                    if (offlineItem.getPinyin().equals(next.f37338c)) {
                        offlineItem.setSize(next.d);
                        Iterator<String> it2 = keySet.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (offlineItem.getPinyin().equals(it2.next())) {
                                    b2 a2 = a(offlineItem, (OfflineStatusChangedListener) null);
                                    if (a2 != null) {
                                        offlineItem.setUpgrade(a2.checkInvalidate());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        na.c(ma.u, "添加item的数据状态完成！！");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() throws JSONException {
        if (this.i.exists()) {
            g(new String(ga.h(this.i)));
            na.c(ma.u, "离线城市列表使用缓存");
        } else {
            na.c(ma.u, "请求离线城市列表...");
            v3.a downloadOfflineMapCityList = ((z2) ((n3) n2.a(n3.class)).d()).downloadOfflineMapCityList(this.j);
            downloadOfflineMapCityList.charset = "utf-8";
            if (downloadOfflineMapCityList.available()) {
                na.c(ma.u, "离线城市列表下载成功");
                x3.a aVar = new x3.a(downloadOfflineMapCityList);
                if (aVar.available()) {
                    g(aVar.a());
                    na.c(ma.u, "离线城市列表解析成功");
                }
            }
        }
        if (this.e != null) {
            na.c(ma.u, "获得离线城市列表成功！");
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j() throws FileNotFoundException {
        q1 mapContext = getMapContext();
        if (mapContext == null) {
            return false;
        }
        int b2 = this.f37384c.b(r);
        String d = this.f37384c.d(s);
        na.c(ma.u, "检查离线配置更新, 当前v:" + b2 + "|md5:" + d + "obj:" + this);
        n3 n3Var = (n3) n2.a(n3.class);
        ArrayList<FileUpdateReq> arrayList = new ArrayList<>();
        FileUpdateReq fileUpdateReq = new FileUpdateReq(v, b2, d);
        arrayList.add(fileUpdateReq);
        w3.a<SCFileUpdateRsp> checkUpdate = ((z2) n3Var.d()).checkUpdate(c7.F(), c7.A(), c7.N(), c7.G(), mapContext.q().b(), arrayList, mapContext.q().b(), mapContext.y(), "", mapContext.n(), "");
        na.c(ma.u, "离线配置请求更新结束：" + checkUpdate.toHumanString());
        if (checkUpdate.available()) {
            FileUpdateRsp fileUpdateRsp = checkUpdate.a().vItems.get(0);
            String a2 = this.h.exists() ? wa.a(this.h) : null;
            if (this.h.exists() && (fileUpdateRsp == null || !v.equals(fileUpdateRsp.sName) || fileUpdateRsp.iVersion == fileUpdateReq.iVersion || TextUtils.isEmpty(fileUpdateRsp.sUpdateUrl) || fileUpdateRsp.iFileSize == 0 || fileUpdateRsp.iFileUpdated == 0 || TextUtils.isEmpty(fileUpdateRsp.sMd5) || fileUpdateRsp.sMd5.equals(a2))) {
                na.c(ma.u, "跳过更新");
            } else {
                String str = fileUpdateRsp.sUpdateUrl;
                String str2 = fileUpdateRsp.sMd5;
                int i = fileUpdateRsp.iVersion;
                String str3 = str;
                String str4 = str2;
                int i2 = i;
                if (fileUpdateRsp.iFileUpdated == 0) {
                    str3 = str;
                    str4 = str2;
                    i2 = i;
                    if (!this.h.exists()) {
                        str3 = this.f37384c.a(t, "");
                        str4 = this.f37384c.a(s, "");
                        i2 = this.f37384c.a(r, 0);
                    }
                }
                if (TextUtils.isEmpty(str3)) {
                    na.g(ma.u, "离线配置文件的请求链接为空！");
                    return false;
                } else if (NetManager.getInstance().builder().url(str3).downloadTo(this.h).available()) {
                    if (wa.a(this.h).equals(str4)) {
                        na.c(ma.u, "离线配置文件下载成功");
                        this.f37384c.b(r, i2);
                        this.f37384c.b(s, str4);
                        this.f37384c.b(t, str3);
                    } else {
                        na.c(ma.u, "离线配置文件MD5校验失败");
                        ga.d(this.h);
                    }
                }
            }
        } else {
            na.c(ma.u, "离线地图配置请求错误：" + checkUpdate.toHumanString());
        }
        if (this.h.exists()) {
            try {
                Object nextValue = new JSONTokener(new String(ga.h(this.h))).nextValue();
                if (nextValue instanceof JSONObject) {
                    this.k = (e2) JsonUtils.parseToModel((JSONObject) nextValue, e2.class, new Object[0]);
                    na.c(ma.u, "创建离线配置文件对象数据：" + this.k);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            na.g(ma.u, "离线配置文件不存在！");
        }
        if (this.k != null) {
            na.c(ma.u, "获得离线配置成功！");
            return true;
        }
        return false;
    }

    @Override // com.tencent.mapsdk.internal.p1
    public void a(Context context) {
        super.a(context);
        this.j = mc.b(context).e();
        this.h = new File(this.j, v);
        this.i = new File(this.j, w);
        this.l = new HashMap();
    }

    @Override // com.tencent.mapsdk.internal.b2.d
    public void a(OfflineItem offlineItem, int i) {
        if (offlineItem == null) {
            return;
        }
        String pinyin = offlineItem.getPinyin();
        c cVar = this.g.get(pinyin);
        c cVar2 = cVar;
        if (cVar == null) {
            cVar2 = new c(null);
            this.g.put(pinyin, cVar2);
        }
        cVar2.f37386a = pinyin;
        cVar2.b = i;
        offlineItem.setPercentage(i);
    }

    @Override // com.tencent.mapsdk.internal.b2.d
    public void a(OfflineItem offlineItem, boolean z) {
        String a2 = this.f37384c.a(q, "");
        na.c(ma.u, "当前开启城市IDS：" + a2);
        String[] split = a2.split(",");
        int binarySearch = Arrays.binarySearch(split, offlineItem.getPinyin());
        if (z) {
            if (binarySearch < 0) {
                String str = a2 + offlineItem.getPinyin() + ",";
                na.c(ma.u, "新增开启城市IDS：" + str);
                this.f37384c.b(q, str);
            }
        } else if (binarySearch < 0) {
        } else {
            StringBuilder sb = new StringBuilder();
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    String sb2 = sb.toString();
                    na.c(ma.u, "剩余开启城市IDS：" + sb2);
                    this.f37384c.b(q, sb2);
                    return;
                }
                String str2 = split[i2];
                if (!str2.equals(offlineItem.getPinyin())) {
                    sb.append(str2);
                    sb.append(",");
                }
                i = i2 + 1;
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.p1
    public void a(q1 q1Var) {
        super.a(q1Var);
        this.d = q1Var.r().isOfflineMapEnable();
        ic a2 = kc.a(e(), q1Var.q().j());
        this.f37384c = a2;
        String a3 = a2.a(u, "");
        na.c(ma.u, "获取持久化状态, json：" + a3);
        if (!TextUtils.isEmpty(a3)) {
            try {
                for (c cVar : JsonUtils.parseToList(new JSONArray(a3), c.class, new Object[0])) {
                    this.g.put(cVar.f37386a, cVar);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        c(q1Var);
    }

    @Override // com.tencent.mapsdk.internal.b2.d
    public void b(OfflineItem offlineItem, boolean z) {
        if (offlineItem == null) {
            return;
        }
        String pinyin = offlineItem.getPinyin();
        c cVar = this.g.get(pinyin);
        c cVar2 = cVar;
        if (cVar == null) {
            cVar2 = new c(null);
            this.g.put(pinyin, cVar2);
        }
        cVar2.f37386a = pinyin;
        cVar2.f37387c = z;
        offlineItem.setUpgrade(z);
    }

    @Override // com.tencent.mapsdk.internal.p1
    public void b(q1 q1Var) {
        super.b(q1Var);
        if (this.o) {
            this.m = null;
            this.o = false;
        }
        if (this.g.isEmpty()) {
            return;
        }
        String collectionToJson = JsonUtils.collectionToJson(this.g.values());
        na.c(ma.u, "保存持久化状态, json：" + collectionToJson);
        this.f37384c.b(u, collectionToJson);
    }

    @Override // com.tencent.mapsdk.internal.p1
    public void f() {
        super.f();
        for (Map.Entry<c2, b2> entry : this.l.entrySet()) {
            b2 value = entry.getValue();
            if (value != null) {
                value.a();
            }
            entry.setValue(null);
        }
        this.l.clear();
        this.m = null;
        this.n = null;
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineMapComponent
    public OfflineItemController getOfflineItemController(OfflineItem offlineItem, OfflineStatusChangedListener offlineStatusChangedListener) {
        if (this.d) {
            return a(offlineItem, offlineStatusChangedListener);
        }
        return null;
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineMapComponent
    public List<OfflineItem> getOfflineItemList() {
        List<OfflineItem> list;
        synchronized (this) {
            for (OfflineItem offlineItem : this.e) {
                c cVar = this.g.get(offlineItem.getPinyin());
                if (cVar != null) {
                    offlineItem.setPercentage(cVar.b);
                    offlineItem.setUpgrade(cVar.f37387c);
                }
            }
            list = this.f;
        }
        return list;
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineMapComponent
    public void getOfflineItemList(Callback<List<OfflineItem>> callback) {
        this.m = callback;
        if (this.o) {
            return;
        }
        c(getMapContext());
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineMapComponent
    public boolean isOfflineMapEnable() {
        return this.d;
    }

    @Override // com.tencent.map.sdk.comps.offlinemap.OfflineMapComponent
    public void syncLatestData(OfflineMapSyncedListener offlineMapSyncedListener) {
        this.n = offlineMapSyncedListener;
        if (this.o) {
            return;
        }
        c(getMapContext());
    }
}
