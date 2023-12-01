package com.soft.blued.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.blued.ad.ADConstants;
import com.blued.android.core.AppInfo;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.utils.ToastUtils;
import com.soft.blued.customview.BannerADView;
import com.soft.blued.ui.ab_test.models.BannerAdExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/AdTestManager.class */
public final class AdTestManager {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f34713a = new Companion(null);
    private static final AdTestManager w = new AdTestManager();
    private static boolean x;

    /* renamed from: c  reason: collision with root package name */
    private boolean f34714c;
    private boolean d;
    private boolean e;
    private AdTestObserve i;
    private boolean j;
    private String r;
    private boolean v;
    private final H b = new H();
    private String f = "aviap;kasnda;lsv;sjb;lwenn:Ajfwao[av*_)jasnevn;sajhb;as&po1-0UH_()&bi13iv9ash(*&nnzhfJPj)jnbajnasjndlnefajlvlsaeg;ajsviasdnv;las;aslv!sdiomvaopsqw;asdjlasn ;aiajFLVAS;LNAivn;ljf;lab63fdc074733caviapao[av*_)&po1-0UH_()&bi13iv9ash(*&nnz zhfajaslv!sdiomvaopsJPj)J&YQmfd9sopzxb7968798n8uiqkIJDS;AIJF;IFJ;AFAS'JJ&YQmfd9sopzxb7968798n8uiqkfuvhldkjshgubnalkjbhaskngjklxjnzbaks-qf98";
    private String g = "aviapao[av*_)&po1-0UH_()&bi13iv9ash(*&nnzhfajaslv!sdiomvaopsJPj)jnbajnasjndjasn;kasnda;lsv;sjb;lwenn:Ajfwevn;sajhb;aslnefqw;lvlsaeg;ajsviasdnv;las;asdjlasn ;aiajFLVAS;LNAivn;ljf;lab63c528972baebviapao[av*_)&po1-0UH_()&bi13iv9ash(*&nnz zhfajaslv!sdiomvaopsJPj)J&YQmfd9sopzxb7968798n8uiqkIJDS;AIJF;IFJ;AFAS'JJ&YQmfd9sopzxb7968798n8uiqkfuvhldkjshgubnalkjbhaskngjklxjnzbaks-qf98";
    private String h = "ahuivavhse143l";
    private final HashMap<String, ArrayList<AdTestDataMode>> k = new HashMap<>();
    private final HashMap<String, Integer> l = new HashMap<>();
    private final String m = "TRYP_BANNER_1";
    private final String n = "TRYP_BANNER_2";
    private final HashSet<AdBannerTestObserve> o = new HashSet<>();
    private final HashSet<AdBannerTestObserve> p = new HashSet<>();
    private int q = -1;
    private final String s = "{\"connect_type\":2,\"data\":[{\"adPosition\":0,\"adm_type\":4,\"adm_type_source\":\"6\",\"adms_mark\":\"banner\",\"adms_type\":\"6\",\"ads_id\":17453,\"ads_pics\":\"\",\"bannerWidthUnitDP\":0,\"base_price\":0,\"bubble_frequency_time\":0,\"bubble_frequency_type\":0,\"bubble_stay_time\":0,\"can_close\":1,\"click_url\":[\"https://argo.blued.cn/blued/adms/17453?is_click=1&type=template&groups=0&position_code=1001&__=LDeNPJ&conn_type=__CONN_TYPE__&purpose=0\"],\"close_time\":-1,\"deep_link_url\":\"\",\"download_type\":0,\"extra_json\":{},\"hasMaterial\":false,\"hidden_url\":[\"https://argo.blued.cn/blued/adms/17453?is_hidden=1&type=template&groups=0&position_code=1001&__=LDeNPJ&conn_type=__CONN_TYPE__&purpose=0\"],\"hot_area_limit_type\":0,\"hot_dynamic\":0,\"interval\":0,\"isAdxTimeout\":false,\"isIs_unliked_users_url_visited\":false,\"isShowAdVisited\":false,\"isShowUrlVisited\":false,\"is_ads\":1,\"is_bidding\":0,\"is_show_adm_icon\":1,\"is_unliked_url_visited\":false,\"local_closed_time\":0,\"material_type\":0,\"operating_time\":0,\"position_code\":\"1001\",\"price\":0,\"purpose\":0,\"ranking_banner_one\":99,\"request_time_out\":0,\"security\":0,\"settlement_price\":0,\"show_time_limit\":0,\"show_url\":[\"https://argo.blued.cn/blued/adms/17453?is_show=1&type=template&groups=0&position_code=1001&__=LDeNPJ&conn_type=__CONN_TYPE__&purpose=0\"],\"speed\":0,\"style_view\":0,\"target_url\":\"\",\"third_id\":\"\",\"third_style_view\":2,\"timeout\":0,\"topRequestSet\":[],\"topShowSet\":[],\"transparency\":0,\"triggered\":false,\"ttShowSet\":[],\"turn_angle\":0,\"hasmore\":-1,\"total\":0},{\"adPosition\":0,\"adm_type\":1,\"adm_type_source\":\"0\",\"adms_mark\":\"banner\",\"adms_type\":\"0\",\"ads_id\":18580,\"ads_pics\":\"https://www.bldimg.com/banners/4294dc610f3dfb97d1a3e71c20b8286e-1681984525-46550.png\",\"bannerWidthUnitDP\":0,\"base_price\":0,\"bubble_frequency_time\":0,\"bubble_frequency_type\":0,\"bubble_stay_time\":0,\"can_close\":1,\"click_url\":[\"https://argo.blued.cn/blued/adms/18580?is_click=1&type=banner&groups=0&position_code=1001&__=LDeNPJ&conn_type=__CONN_TYPE__&purpose=1\"],\"close_time\":-1,\"deep_link_url\":\"\",\"download_type\":0,\"hasMaterial\":false,\"hidden_url\":[\"https://argo.blued.cn/blued/adms/18580?is_hidden=1&type=banner&groups=0&position_code=1001&__=LDeNPJ&conn_type=__CONN_TYPE__&purpose=1\"],\"hot_area_limit_type\":0,\"hot_dynamic\":0,\"interval\":0,\"isAdxTimeout\":false,\"isIs_unliked_users_url_visited\":false,\"isShowAdVisited\":false,\"isShowUrlVisited\":false,\"is_ads\":1,\"is_bidding\":0,\"is_show_adm_icon\":0,\"is_unliked_url_visited\":false,\"local_closed_time\":0,\"material_type\":0,\"operating_time\":0,\"position_code\":\"1001\",\"price\":0,\"purpose\":0,\"ranking_banner_one\":0,\"request_time_out\":0,\"security\":0,\"settlement_price\":0,\"show_time_limit\":0,\"show_url\":[\"https://argo.blued.cn/blued/adms/18580?is_show=1&type=banner&groups=0&position_code=1001&__=LDeNPJ&conn_type=__CONN_TYPE__&purpose=1\"],\"speed\":0,\"style_view\":0,\"target_url\":\"https://app.blued.cn/home/fans/feed?detail=ad_banner1\",\"third_id\":\"\",\"third_style_view\":1,\"timeout\":0,\"topRequestSet\":[],\"topShowSet\":[],\"transparency\":0,\"triggered\":false,\"ttShowSet\":[],\"turn_angle\":0,\"hasmore\":-1,\"total\":0}],\"position_code\":1001,\"serial_parallel\":{\"parallel_num\":2,\"type\":2},\"timeout\":8000}";
    private final String t = "{\"layer\":2,\"avatar\":\"\",\"call_tip\":0,\"call_type\":0,\"description\":\"\",\"expire_type\":0,\"game_type\":0,\"is_call\":0,\"is_filter_ads\":0,\"is_find_on_map\":0,\"is_global_view_secretly\":0,\"is_hide_city_settled\":0,\"is_hide_distance\":0,\"is_hide_last_operate\":0,\"is_hide_vip_look\":0,\"is_invisible_all\":0,\"is_invisible_half\":0,\"is_official\":0,\"is_quietly\":0,\"is_reactive_recommend\":0,\"is_recommend\":0,\"is_shadow\":0,\"is_show_vip_page\":0,\"is_traceless_access\":0,\"is_vip_annual\":0,\"name\":\"\",\"online_state\":0,\"photos_count\":0,\"super_call_status\":0,\"theme_pendant\":0,\"vbadge\":0,\"vip_exp_lvl\":0,\"vip_expire_state\":0,\"vip_grade\":0,\"adPosition\":0,\"adm_type\":5,\"adm_type_source\":\"6\",\"adms_mark\":\"user\",\"adms_type\":\"6\",\"ads_id\":-200,\"ads_pics\":\"\",\"bannerWidthUnitDP\":0,\"base_price\":0.0,\"bidding_type\":0,\"bubble_frequency_time\":0,\"bubble_frequency_type\":0,\"bubble_stay_time\":0,\"can_close\":1,\"click_url\":[\"https://argo.blued.cn/blued/adms/16302?show_layer\\u003d2\\u0026is_click\\u003d1\\u0026type\\u003drender\\u0026groups\\u003d7\\u0026position_code\\u003d1004\\u0026__\\u003dLDeNPJ\\u0026conn_type\\u003d__CONN_TYPE__\\u0026purpose\\u003d0\"],\"close_time\":-1,\"deep_link_url\":\"\",\"download_type\":0,\"hasMaterial\":false,\"hidden_url\":[\"https://argo.blued.cn/blued/adms/16302?show_layer\\u003d2\\u0026is_hidden\\u003d1\\u0026type\\u003drender\\u0026groups\\u003d7\\u0026position_code\\u003d1004\\u0026__\\u003dLDeNPJ\\u0026conn_type\\u003d__CONN_TYPE__\\u0026purpose\\u003d0\"],\"hot_area_limit_type\":0,\"hot_dynamic\":0,\"interval\":0.0,\"isAdxTimeout\":false,\"isIs_unliked_users_url_visited\":false,\"isShowAdVisited\":false,\"isShowOperateVisited\":false,\"isShowUrlVisited\":false,\"is_ads\":1,\"is_bidding\":0,\"is_show_adm_icon\":1,\"is_unliked_url_visited\":false,\"local_closed_time\":0,\"material_type\":0,\"operating_time\":0.0,\"price\":0.0,\"purpose\":0,\"ranking_banner_one\":0,\"request_time_out\":0,\"security\":0,\"settlement_price\":0,\"show_time_limit\":0,\"show_url\":[\"https://argo.blued.cn/blued/adms/16302?show_layer\\u003d2\\u0026is_show\\u003d1\\u0026type\\u003drender\\u0026groups\\u003d7\\u0026position_code\\u003d1004\\u0026__\\u003dldenpj\\u0026conn_type\\u003d__conn_type__\\u0026purpose\\u003d0\\u0026is_cache\\u003d1\"],\"speed\":0,\"style_material\":\"\",\"style_view\":2,\"target_url\":\"\",\"third_id\":\"\",\"third_style_view\":0,\"timeout\":0,\"topRequestSet\":[],\"topShowSet\":[],\"transparency\":0,\"triggered\":false,\"ttAdxShowSet\":[],\"ttShowSet\":[],\"turn_angle\":0,\"hasmore\":-1,\"total\":0}";
    private String u = "-200";

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/AdTestManager$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(boolean z) {
            AdTestManager.x = z;
        }

        public final boolean a() {
            return AdTestManager.x;
        }

        public final AdTestManager b() {
            return AdTestManager.w;
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/AdTestManager$H.class */
    public static final class H extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f34715a = new Companion(null);

        @Metadata
        /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/AdTestManager$H$Companion.class */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public H() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.e(msg, "msg");
            int i = msg.what;
            if (i == 1) {
                AdTestManager.w.b(msg);
            } else if (i == 2) {
                AdTestManager.w.c(msg);
            } else if (i == 3) {
                AdTestManager.w.d(msg);
            } else if (i == 4) {
                AdTestManager.w.a(msg);
            } else if (i != 5) {
            } else {
                AdTestManager.w.e(msg);
            }
        }
    }

    public AdTestManager() {
        BannerAdExtra banner1Mode = (BannerAdExtra) AppInfo.f().fromJson(this.s, (Class<Object>) BannerAdExtra.class);
        this.k.put(this.m, new ArrayList<>());
        this.k.put(this.n, new ArrayList<>());
        this.l.put(this.m, 0);
        this.l.put(this.n, 0);
        List<BluedADExtra> list = banner1Mode.data;
        Intrinsics.c(list, "banner1Mode.data");
        for (BluedADExtra bluedADExtra : list) {
            bluedADExtra.third_id = a(e(), d());
        }
        String str = this.m;
        Intrinsics.c(banner1Mode, "banner1Mode");
        a(str, banner1Mode);
    }

    private final void a(ArrayList<AdTestDataMode> arrayList, Message message) {
        a(false, arrayList, message);
    }

    private final void a(boolean z, ArrayList<AdTestDataMode> arrayList, Message message) {
        double random;
        int i;
        long j;
        double random2;
        if (x) {
            int size = (message.arg1 + 1) % arrayList.size();
            AdTestDataMode adTestDataMode = arrayList.get(size);
            Intrinsics.c(adTestDataMode, "mDos[n]");
            AdTestDataMode adTestDataMode2 = adTestDataMode;
            Message obtain = Message.obtain();
            obtain.obj = arrayList;
            obtain.what = adTestDataMode2.getType();
            obtain.arg1 = size;
            if (z) {
                this.b.sendMessage(obtain);
                return;
            }
            int type = adTestDataMode2.getType();
            if (type == 1) {
                random = Math.random();
            } else if (type != 2) {
                if (type == 3) {
                    random2 = Math.random();
                } else if (type == 4) {
                    random2 = Math.random();
                } else if (type != 5) {
                    j = 1000;
                    this.b.sendMessageDelayed(obtain, j);
                } else {
                    random2 = Math.random();
                }
                i = (int) (random2 * 1000);
                j = i + 5000;
                this.b.sendMessageDelayed(obtain, j);
            } else {
                random = Math.random();
            }
            i = (int) (random * 4000);
            j = i + 5000;
            this.b.sendMessageDelayed(obtain, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Message message) {
        UserFindResult l = l();
        if (l == null) {
            Object obj = message.obj;
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.soft.blued.utils.AdTestDataMode>{ kotlin.collections.TypeAliasesKt.ArrayList<com.soft.blued.utils.AdTestDataMode> }");
            }
            a((ArrayList) obj, message);
            return;
        }
        AdTestObserve adTestObserve = this.i;
        if (adTestObserve != null) {
            adTestObserve.a(l);
        }
        ToastUtils.b("刷新原生广告");
        Object obj2 = message.obj;
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.soft.blued.utils.AdTestDataMode>{ kotlin.collections.TypeAliasesKt.ArrayList<com.soft.blued.utils.AdTestDataMode> }");
        }
        a((ArrayList) obj2, message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(Message message) {
        HashSet<Long> hashSet;
        ToastUtils.b("刷新banner2");
        Iterator<AdBannerTestObserve> it = this.p.iterator();
        Intrinsics.c(it, "banner2Obs.iterator()");
        while (it.hasNext()) {
            AdTestDataMode b = b(this.n);
            if (b == null) {
                Object obj = message.obj;
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.soft.blued.utils.AdTestDataMode>{ kotlin.collections.TypeAliasesKt.ArrayList<com.soft.blued.utils.AdTestDataMode> }");
                }
                a((ArrayList) obj, message);
                return;
            }
            BluedADExtra b2 = b.b();
            if (b2 != null && (hashSet = b2.topShowSet) != null) {
                hashSet.clear();
            }
            BluedADExtra b3 = b.b();
            if (b3 != null) {
                b3.nativeAd = null;
            }
            BluedADExtra b4 = b.b();
            if (b4 != null) {
                b4.nativeAdList = null;
            }
            BluedADExtra b5 = b.b();
            if (b5 != null) {
                b5.nativeAdGrid = null;
            }
            AdBannerTestObserve next = it.next();
            Intrinsics.c(next, "iterator.next()");
            AdBannerTestObserve adBannerTestObserve = next;
            BluedADExtra b6 = b.b();
            AdTestObserve adTestObserve = this.i;
            adBannerTestObserve.a(b6, adTestObserve == null ? true : adTestObserve.c() ? ADConstants.AD_POSITION.NEARBY_HOME_LIST_BANNER : ADConstants.AD_POSITION.NEARBY_HOME_GRID_BANNER, new BannerADView.ADListener() { // from class: com.soft.blued.utils.AdTestManager$showAD$1
                @Override // com.soft.blued.customview.BannerADView.ADListener
                public void a() {
                }

                @Override // com.soft.blued.customview.BannerADView.ADListener
                public void b() {
                }
            });
        }
        Object obj2 = message.obj;
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.soft.blued.utils.AdTestDataMode>{ kotlin.collections.TypeAliasesKt.ArrayList<com.soft.blued.utils.AdTestDataMode> }");
        }
        a((ArrayList) obj2, message);
    }

    public final String a(String secret_key, String it_origin) {
        Intrinsics.e(secret_key, "secret_key");
        Intrinsics.e(it_origin, "it_origin");
        int length = it_origin.length() / 2;
        String substring = it_origin.substring(length - (secret_key.length() / 2), length + (secret_key.length() / 2));
        Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public final void a(int i) {
        this.q = i;
    }

    public final void a(Message msg) {
        List<BluedADExtra> list;
        List<BluedADExtra> list2;
        Intrinsics.e(msg, "msg");
        ToastUtils.b("刷新banner1");
        AdTestDataMode b = b(this.m);
        if (b == null) {
            Object obj = msg.obj;
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.soft.blued.utils.AdTestDataMode>{ kotlin.collections.TypeAliasesKt.ArrayList<com.soft.blued.utils.AdTestDataMode> }");
            }
            a((ArrayList) obj, msg);
            return;
        }
        BannerAdExtra a2 = b.a();
        if (a2 != null && (list2 = a2.data) != null) {
            list2.clear();
        }
        ArrayList<BluedADExtra> c2 = b.c();
        if (c2 != null) {
            for (BluedADExtra bluedADExtra : c2) {
                bluedADExtra.topShowSet.clear();
                bluedADExtra.nativeAd = null;
                BannerAdExtra a3 = b.a();
                if (a3 != null && (list = a3.data) != null) {
                    list.add(bluedADExtra);
                }
            }
        }
        Iterator<AdBannerTestObserve> it = this.o.iterator();
        Intrinsics.c(it, "banner1Obs.iterator()");
        while (it.hasNext()) {
            AdBannerTestObserve next = it.next();
            Intrinsics.c(next, "iterator.next()");
            AdBannerTestObserve adBannerTestObserve = next;
            BannerAdExtra a4 = b.a();
            Intrinsics.a(a4);
            adBannerTestObserve.a(a4, new BannerADView.ADListener() { // from class: com.soft.blued.utils.AdTestManager$showADlist$2
                @Override // com.soft.blued.customview.BannerADView.ADListener
                public void a() {
                }

                @Override // com.soft.blued.customview.BannerADView.ADListener
                public void b() {
                }
            });
        }
        Object obj2 = msg.obj;
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.soft.blued.utils.AdTestDataMode>{ kotlin.collections.TypeAliasesKt.ArrayList<com.soft.blued.utils.AdTestDataMode> }");
        }
        a((ArrayList) obj2, msg);
    }

    public final void a(AdTestObserve adTestObserve) {
        this.i = adTestObserve;
    }

    public final void a(String str) {
        this.r = str;
    }

    public final void a(String type, BluedADExtra da) {
        Intrinsics.e(type, "type");
        Intrinsics.e(da, "da");
        ArrayList<AdTestDataMode> arrayList = this.k.get(type);
        if (arrayList != null && arrayList.size() <= 50) {
            AdTestDataMode adTestDataMode = new AdTestDataMode(5);
            adTestDataMode.a(da);
            arrayList.add(adTestDataMode);
        }
    }

    public final void a(String type, BannerAdExtra da) {
        Intrinsics.e(type, "type");
        Intrinsics.e(da, "da");
        ArrayList<AdTestDataMode> arrayList = this.k.get(type);
        if (arrayList != null && arrayList.size() <= 50) {
            AdTestDataMode adTestDataMode = new AdTestDataMode(5);
            adTestDataMode.a(da);
            List<BluedADExtra> list = da.data;
            Intrinsics.c(list, "da.data");
            for (BluedADExtra bluedADExtra : list) {
                ArrayList<BluedADExtra> c2 = adTestDataMode.c();
                if (c2 != null) {
                    c2.add(bluedADExtra);
                }
            }
            arrayList.add(adTestDataMode);
        }
    }

    public final void a(ArrayList<AdTestDataMode> mDos) {
        Intrinsics.e(mDos, "mDos");
        Message msg = Message.obtain();
        msg.arg1 = 0;
        msg.obj = mDos;
        Intrinsics.c(msg, "msg");
        b(msg);
    }

    public final void a(boolean z) {
        this.f34714c = z;
    }

    public final boolean a() {
        return this.f34714c;
    }

    public final boolean a(AdBannerTestObserve ban) {
        Intrinsics.e(ban, "ban");
        HashSet<AdBannerTestObserve> hashSet = this.o;
        return (hashSet == null ? null : Boolean.valueOf(hashSet.add(ban))).booleanValue();
    }

    public final AdTestDataMode b(String type) {
        AdTestDataMode adTestDataMode;
        Intrinsics.e(type, "type");
        synchronized (this.k) {
            ArrayList<AdTestDataMode> arrayList = g().get(type);
            Intrinsics.a(arrayList);
            Intrinsics.c(arrayList, "aDs.get(type)!!");
            ArrayList<AdTestDataMode> arrayList2 = arrayList;
            Integer num = this.l.get(type);
            Intrinsics.a(num);
            Intrinsics.c(num, "aDnum.get(type)!!");
            int intValue = num.intValue();
            int i = intValue >= arrayList2.size() - 1 ? 0 : intValue + 1;
            AdTestDataMode adTestDataMode2 = arrayList2.get(i);
            Intrinsics.c(adTestDataMode2, "dataMode.get(get)");
            adTestDataMode = adTestDataMode2;
            this.l.put(type, Integer.valueOf(i));
        }
        return adTestDataMode;
    }

    public final void b(Message msg) {
        Intrinsics.e(msg, "msg");
        ToastUtils.b("刷新列表");
        AdTestObserve adTestObserve = this.i;
        if (adTestObserve != null) {
            adTestObserve.b();
        }
        Object obj = msg.obj;
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.soft.blued.utils.AdTestDataMode>{ kotlin.collections.TypeAliasesKt.ArrayList<com.soft.blued.utils.AdTestDataMode> }");
        }
        a((ArrayList) obj, msg);
    }

    public final void b(boolean z) {
        this.d = z;
    }

    public final boolean b() {
        return this.d;
    }

    public final boolean b(AdBannerTestObserve ban) {
        Intrinsics.e(ban, "ban");
        HashSet<AdBannerTestObserve> hashSet = this.o;
        return (hashSet == null ? null : Boolean.valueOf(hashSet.remove(ban))).booleanValue();
    }

    public final void c(Message msg) {
        Object valueOf;
        Intrinsics.e(msg, "msg");
        int i = msg.arg1 % 5;
        if (i == 0) {
            double d = 5000;
            valueOf = Double.valueOf(d + (Math.random() * d));
        } else if (i != 1) {
            valueOf = i != 2 ? i != 3 ? 0 : Double.valueOf(15000 * Math.random()) : Double.valueOf(1000 + (5000 * Math.random()));
        } else {
            double d2 = 5000;
            valueOf = Double.valueOf(d2 - (Math.random() * d2));
        }
        int intValue = ((Number) valueOf).intValue();
        ToastUtils.b(Intrinsics.a("滑动到  ", (Object) Integer.valueOf(intValue)));
        AdTestObserve adTestObserve = this.i;
        if (adTestObserve != null) {
            adTestObserve.a(intValue);
        }
        Object obj = msg.obj;
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.soft.blued.utils.AdTestDataMode>{ kotlin.collections.TypeAliasesKt.ArrayList<com.soft.blued.utils.AdTestDataMode> }");
        }
        a((ArrayList) obj, msg);
    }

    public final void c(boolean z) {
        this.e = z;
    }

    public final boolean c() {
        return this.e;
    }

    public final boolean c(AdBannerTestObserve ban) {
        Intrinsics.e(ban, "ban");
        HashSet<AdBannerTestObserve> hashSet = this.p;
        return (hashSet == null ? null : Boolean.valueOf(hashSet.add(ban))).booleanValue();
    }

    public final String d() {
        return this.f;
    }

    public final void d(boolean z) {
        this.j = z;
    }

    public final boolean d(AdBannerTestObserve ban) {
        Intrinsics.e(ban, "ban");
        HashSet<AdBannerTestObserve> hashSet = this.p;
        return (hashSet == null ? null : Boolean.valueOf(hashSet.remove(ban))).booleanValue();
    }

    public final String e() {
        return this.h;
    }

    public final void e(boolean z) {
        this.v = z;
    }

    public final boolean f() {
        return this.j;
    }

    public final HashMap<String, ArrayList<AdTestDataMode>> g() {
        return this.k;
    }

    public final int h() {
        return this.q;
    }

    public final String i() {
        return this.r;
    }

    public final String j() {
        return this.u;
    }

    public final boolean k() {
        return this.v;
    }

    public final UserFindResult l() {
        UserFindResult findResult = (UserFindResult) AppInfo.f().fromJson(this.t, (Class<Object>) UserFindResult.class);
        findResult.third_id = a(this.h, this.g);
        Intrinsics.c(findResult, "findResult");
        return findResult;
    }

    public final void m() {
        this.b.removeCallbacksAndMessages(null);
        x = false;
        this.o.clear();
        this.p.clear();
        ArrayList<AdTestDataMode> arrayList = this.k.get(this.n);
        if (arrayList == null) {
            return;
        }
        arrayList.clear();
    }
}
