package com.blued.android.module.common.adx.base;

import android.text.TextUtils;
import android.util.Log;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.trace.EventTrackSettings;
import com.blued.das.login.LoginAndRegisterProtos;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/AdxBaseManager.class */
public abstract class AdxBaseManager {
    public static final Companion a = new Companion(null);
    private Deferred<Unit> g;
    private ArrayList<BluedADExtra> b = new ArrayList<>();
    private ArrayList<BluedADExtra> c = new ArrayList<>();
    private final ArrayList<BluedADExtra> d = new ArrayList<>();
    private final ArrayList<BluedADExtra> e = new ArrayList<>();
    private final ArrayList<BluedADExtra> f = new ArrayList<>();
    private final Comparator<BluedADExtra> h = new Comparator() { // from class: com.blued.android.module.common.adx.base.-$$Lambda$AdxBaseManager$gshw09h6jxgO8cnR4AfjvpFZ8bI
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int a2;
            a2 = AdxBaseManager.a((BluedADExtra) obj, (BluedADExtra) obj2);
            return a2;
        }
    };

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/adx/base/AdxBaseManager$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int a(BluedADExtra bluedADExtra, BluedADExtra bluedADExtra2) {
        if (bluedADExtra.price > bluedADExtra2.price) {
            return -1;
        }
        if (bluedADExtra.price < bluedADExtra2.price) {
            return 1;
        }
        if (bluedADExtra.getHash() > bluedADExtra2.getHash()) {
            return -1;
        }
        return bluedADExtra.getHash() < bluedADExtra2.getHash() ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0522, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x04c4, code lost:
        r7 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0636  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0639  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x065f  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0698  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0701  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0723  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0776  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x087e  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x08a4  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x08b6  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0895 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:217:0x06f5 A[EDGE_INSN: B:217:0x06f5->B:151:0x06f5 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x04d1  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:127:0x0639 -> B:128:0x063d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            Method dump skipped, instructions count: 2246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.adx.base.AdxBaseManager.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x03c3, code lost:
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x041f, code lost:
        r12 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x04df  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0562  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x05b0  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x06ad  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x06cd  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x06dd  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x06c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0539 A[EDGE_INSN: B:188:0x0539->B:128:0x0539 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x03cf  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:103:0x047e -> B:106:0x0484). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlinx.coroutines.CoroutineScope r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instructions count: 1773
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.adx.base.AdxBaseManager.a(kotlinx.coroutines.CoroutineScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(BluedADExtra bluedADExtra, BaseNativeExpressAd baseNativeExpressAd, List<? extends BluedADExtra> list) {
        c(bluedADExtra);
        for (BluedADExtra bluedADExtra2 : list) {
            if (TextUtils.equals(bluedADExtra.ads_id_sub, bluedADExtra2.ads_id_sub)) {
                bluedADExtra2.baseNativeExpressAd = baseNativeExpressAd;
                bluedADExtra2.hasMaterial = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(BluedADExtra bluedADExtra, BaseNativeExpressAd baseNativeExpressAd, List<? extends BluedADExtra> list, boolean z) {
        for (BluedADExtra bluedADExtra2 : list) {
            if (TextUtils.equals(bluedADExtra.ads_id_sub, bluedADExtra2.ads_id_sub)) {
                bluedADExtra2.baseNativeExpressAd = baseNativeExpressAd;
                bluedADExtra2.hasMaterial = true;
                if (z) {
                    bluedADExtra2.price = baseNativeExpressAd.c() / 100;
                }
                if (!bluedADExtra.is_bidding() || baseNativeExpressAd.c() > 0) {
                    b(bluedADExtra2);
                    return;
                }
                bluedADExtra2.hasMaterial = false;
                a("**因竞价广告获取到的价格小于0，那么它不参与本次竞价，广告id:" + ((Object) bluedADExtra.ads_id_sub) + " 广告源：" + ((Object) bluedADExtra.adm_type_source) + " 广告位id:" + ((Object) bluedADExtra.third_id) + ' ');
                c(bluedADExtra2);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, BluedADExtra bluedADExtra) {
        a(str + " -- " + bluedADExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str, List<? extends BluedADExtra> list) {
        a(str);
        for (BluedADExtra bluedADExtra : list) {
            a(String.valueOf(bluedADExtra));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x018d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.adx.base.AdxBaseManager.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        a("---- 任务超时 ----");
        a("现在要找到一个价格最高且有物料的广告进行展示");
        a("结算二价");
        BluedADExtra c = c();
        if (c != null) {
            a("最后展示的广告：", c);
            d(c);
            return;
        }
        a("最后没有广告可以展示");
        BluedADExtra bluedADExtra = new BluedADExtra();
        bluedADExtra.isAdxTimeout = true;
        d(bluedADExtra);
    }

    private final void b(BluedADExtra bluedADExtra) {
        a("===「埋点」广告_子返回成功/询价响应成功 资源位id：" + h() + " blued父广告id：" + bluedADExtra.ads_id + " blued子广告id:" + ((Object) bluedADExtra.ads_id_sub) + " 广告位id:" + ((Object) bluedADExtra.third_id) + " 询价价格:" + bluedADExtra.price + " 广告源：" + ((Object) bluedADExtra.adm_type_source));
        EventTrackSettings.a(LoginAndRegisterProtos.Event.AD_RETURN_SUCCESS_SUB, h(), String.valueOf(bluedADExtra.ads_id), bluedADExtra.ads_id_sub.toString(), bluedADExtra.third_id.toString(), Double.parseDouble(String.valueOf(bluedADExtra.price)), bluedADExtra.adm_type_source);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(List<? extends BluedADExtra> list) {
        for (BluedADExtra bluedADExtra : list) {
            a("===「埋点」广告_子请求/询价 资源位id：" + h() + " blued父广告id：" + bluedADExtra.ads_id + " blued子广告id:" + ((Object) bluedADExtra.ads_id_sub) + " 广告位id:" + ((Object) bluedADExtra.third_id) + " 广告源：" + ((Object) bluedADExtra.adm_type_source));
            EventTrackSettings.a(LoginAndRegisterProtos.Event.AD_REQUEST_SUB, h(), String.valueOf(bluedADExtra.ads_id), bluedADExtra.ads_id_sub.toString(), bluedADExtra.third_id.toString(), bluedADExtra.adm_type_source);
        }
    }

    private final BluedADExtra c() {
        BluedADExtra bluedADExtra;
        BluedADExtra bluedADExtra2;
        float a2;
        BluedADExtra bluedADExtra3;
        boolean z;
        boolean z2;
        a("「二价广告列表」价格排序---");
        CollectionsKt.a((List) this.f, (Comparator) this.h);
        a("「二价广告列表」排序结果为：", this.f);
        Iterator<BluedADExtra> it = this.f.iterator();
        while (true) {
            if (!it.hasNext()) {
                bluedADExtra = null;
                break;
            }
            bluedADExtra = it.next();
            if (bluedADExtra.hasMaterial) {
                break;
            }
        }
        BluedADExtra bluedADExtra4 = bluedADExtra;
        if (bluedADExtra4 != null) {
            this.f.remove(bluedADExtra4);
            Iterator<BluedADExtra> it2 = this.f.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    bluedADExtra2 = null;
                    break;
                }
                bluedADExtra2 = it2.next();
                if (bluedADExtra2.hasMaterial) {
                    break;
                }
            }
            BluedADExtra bluedADExtra5 = bluedADExtra2;
            if (bluedADExtra5 == null) {
                bluedADExtra5 = new BluedADExtra();
                bluedADExtra5.price = 0.01f;
            } else {
                if (bluedADExtra4.price == bluedADExtra5.price) {
                    a("此时竞胜和最高竞败方价格相等，二价不加0.01");
                    a2 = bluedADExtra5.price;
                } else {
                    a("二价广告价格需要加上0.01");
                    a(Intrinsics.a("二价计算前：", (Object) Float.valueOf(bluedADExtra5.price)));
                    a2 = a(bluedADExtra5.price, 0.01f);
                    a(Intrinsics.a("二价计算后：", (Object) Float.valueOf(a2)));
                }
                bluedADExtra5.price = a2;
            }
            a("胜利方广告数据为：", bluedADExtra4);
            a("二价方广告数据为：", bluedADExtra5);
            Map<String, ? extends BluedADExtra> b = MapsKt.b(TuplesKt.a("win_data", bluedADExtra4), TuplesKt.a("loss_data", bluedADExtra5));
            if (bluedADExtra4.is_bidding()) {
                a(b);
            }
            a("===「埋点」广告_子竞价成功 资源位id：" + h() + " blued父广告id：" + bluedADExtra4.ads_id + " blued子广告id：" + ((Object) bluedADExtra4.ads_id_sub) + " 广告位id:" + ((Object) bluedADExtra4.third_id) + " 竞价价格:" + bluedADExtra4.price + " 二价价格：" + bluedADExtra5.price + " 广告源：" + ((Object) bluedADExtra4.adm_type_source));
            EventTrackSettings.a(LoginAndRegisterProtos.Event.AD_BIDDING_SUCCESS_SUB, h(), String.valueOf(bluedADExtra4.ads_id), bluedADExtra4.ads_id_sub.toString(), bluedADExtra4.third_id.toString(), Double.parseDouble(String.valueOf(bluedADExtra4.price)), Double.parseDouble(String.valueOf(bluedADExtra5.price)), bluedADExtra4.adm_type_source);
            StringBuilder sb = new StringBuilder();
            sb.append("===「埋点」广告_父竞价成功 资源位id：");
            sb.append(h());
            sb.append(" blued父广告id：");
            sb.append(bluedADExtra4.ads_id);
            sb.append("  广告位id:");
            sb.append((Object) bluedADExtra4.third_id);
            sb.append(" 一价价格:");
            sb.append(bluedADExtra4.price);
            sb.append(" 二价价格：");
            sb.append(bluedADExtra5.price);
            sb.append(" 广告源：");
            sb.append((Object) bluedADExtra4.adm_type_source);
            a(sb.toString());
            EventTrackSettings.a(LoginAndRegisterProtos.Event.AD_BIDDING_SUCCESS_ALL, h(), String.valueOf(bluedADExtra4.ads_id), bluedADExtra4.third_id.toString(), Double.parseDouble(String.valueOf(bluedADExtra4.price)), Double.parseDouble(String.valueOf(bluedADExtra5.price)), bluedADExtra4.adm_type_source);
            try {
                for (BluedADExtra bluedADExtra6 : this.f) {
                    if (bluedADExtra6.is_bidding() && bluedADExtra6.hasMaterial) {
                        if (Intrinsics.a((Object) bluedADExtra6.adm_type_source, (Object) "3")) {
                            a("当前广点通竞败对象 广告id:" + ((Object) bluedADExtra6.ads_id_sub) + " 广告位id:" + ((Object) bluedADExtra6.third_id));
                        }
                        b.put("current_data", bluedADExtra6);
                        b(b);
                    }
                    if (bluedADExtra6.hasMaterial) {
                        a("===「埋点」广告_子竞价失败 资源位id：" + h() + " blued父广告id：" + bluedADExtra6.ads_id + " blued子广告id:" + ((Object) bluedADExtra6.ads_id_sub) + " 广告位id:" + ((Object) bluedADExtra6.third_id) + " 广告源：" + ((Object) bluedADExtra6.adm_type_source));
                        EventTrackSettings.a(LoginAndRegisterProtos.Event.AD_BIDDING_FAIL_SUB, h(), String.valueOf(bluedADExtra6.ads_id), bluedADExtra6.ads_id_sub.toString(), bluedADExtra6.third_id, bluedADExtra6.adm_type_source);
                    }
                }
            } catch (Exception e) {
                a(Intrinsics.a("异常：", (Object) e));
            }
            Iterator<BluedADExtra> it3 = this.c.iterator();
            do {
                bluedADExtra3 = null;
                if (!it3.hasNext()) {
                    break;
                }
                bluedADExtra3 = it3.next();
            } while (!bluedADExtra3.hasMaterial);
            if (bluedADExtra3 != null && !bluedADExtra4.is_bidding()) {
                a("「父竞价失败」说明所有「竞价广告」全都竞价失败，我的理解是「竞价广告」中最起码得有一个广告询价成功了才存在竞价失败，如果竞价广告全都询价失败了，就没有竞价资格了，也不会存在「父竞价失败」");
                a(Intrinsics.a("===「埋点」广告_父竞价失败 资源位id：", (Object) h()));
                EventTrackSettings.a(LoginAndRegisterProtos.Event.AD_BIDDING_FAIL_ALL, h());
            }
            ArrayList<BluedADExtra> arrayList = this.c;
            if (!(arrayList instanceof Collection) || !arrayList.isEmpty()) {
                for (BluedADExtra bluedADExtra7 : arrayList) {
                    if (!(bluedADExtra7.hasMaterial && bluedADExtra7.price <= 0.0f)) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            boolean z3 = false;
            if (this.d.size() > 0) {
                ArrayList<BluedADExtra> arrayList2 = this.d;
                if (!(arrayList2 instanceof Collection) || !arrayList2.isEmpty()) {
                    for (BluedADExtra bluedADExtra8 : arrayList2) {
                        if (!(!bluedADExtra8.hasMaterial)) {
                            z2 = false;
                            break;
                        }
                    }
                }
                z2 = true;
                z3 = false;
                if (z2) {
                    z3 = true;
                }
            }
            if (z || z3) {
                a(Intrinsics.a("===「埋点」广告_父竞价失败 资源位id：", (Object) h()));
                a("产品定义：父竞价/比价失败指所有类型广告有返回但无最高价(非竞价均无返回或竞价均返回价格为0)");
                EventTrackSettings.a(LoginAndRegisterProtos.Event.AD_BIDDING_FAIL_ALL, h());
            }
        }
        return bluedADExtra4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0189  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object c(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.adx.base.AdxBaseManager.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void c(BluedADExtra bluedADExtra) {
        a("===「埋点」广告_子返回失败/询价失败 资源位id：" + h() + " blued父广告id：" + bluedADExtra.ads_id + " blued子广告id:" + ((Object) bluedADExtra.ads_id_sub) + " 广告位id:" + ((Object) bluedADExtra.third_id) + " 广告源：" + ((Object) bluedADExtra.adm_type_source) + " 错误码：" + ((Object) bluedADExtra.errorMsg));
        EventTrackSettings.a(LoginAndRegisterProtos.Event.AD_RETURN_FAIL_SUB, h(), String.valueOf(bluedADExtra.ads_id), bluedADExtra.ads_id_sub.toString(), bluedADExtra.third_id.toString(), bluedADExtra.adm_type_source, bluedADExtra.errorMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean c(List<? extends BluedADExtra> list) {
        List<? extends BluedADExtra> list2 = list;
        for (BluedADExtra bluedADExtra : list2) {
            if (Intrinsics.a((Object) bluedADExtra.adm_type_source, (Object) "0")) {
                bluedADExtra.hasMaterial = true;
                for (BluedADExtra bluedADExtra2 : this.d) {
                    if (Intrinsics.a((Object) bluedADExtra.ads_id_sub, (Object) bluedADExtra2.ads_id_sub)) {
                        bluedADExtra2.hasMaterial = true;
                        for (BluedADExtra bluedADExtra3 : this.f) {
                            if (Intrinsics.a((Object) bluedADExtra.ads_id_sub, (Object) bluedADExtra3.ads_id_sub)) {
                                bluedADExtra3.hasMaterial = true;
                                for (BluedADExtra bluedADExtra4 : list2) {
                                    if (Intrinsics.a((Object) bluedADExtra.ads_id_sub, (Object) bluedADExtra4.ads_id_sub)) {
                                        bluedADExtra4.hasMaterial = true;
                                        return true;
                                    }
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a0 A[EDGE_INSN: B:82:0x01a0->B:52:0x01a0 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            Method dump skipped, instructions count: 594
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.adx.base.AdxBaseManager.d(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        a("*****初始广告列表*****");
        Iterator<BluedADExtra> it = this.b.iterator();
        while (it.hasNext()) {
            BluedADExtra next = it.next();
            if (next.is_bidding()) {
                this.c.add(next);
            } else {
                this.d.add(next);
            }
            a(String.valueOf(next));
        }
        a("*****竞价广告列表*****");
        Iterator<BluedADExtra> it2 = this.c.iterator();
        while (it2.hasNext()) {
            a(String.valueOf(it2.next()));
        }
        a("*****非竞价广告列表*****");
        Iterator<BluedADExtra> it3 = this.d.iterator();
        while (it3.hasNext()) {
            a(String.valueOf(it3.next()));
        }
        this.f.addAll(this.b);
    }

    private final void d(BluedADExtra bluedADExtra) {
        if (bluedADExtra == null) {
            a(Intrinsics.a("===「埋点」广告_父返回失败/询价失败 资源位id：", (Object) h()));
            EventTrackSettings.a(LoginAndRegisterProtos.Event.AD_RETURN_FAIL_ALL, h());
        } else if (bluedADExtra.isAdxTimeout) {
            a(Intrinsics.a("===「埋点」广告_超时（在超时时间内没有拿到任何物料，不需要报子广告超时） 资源位id：", (Object) h()));
            EventTrackSettings.a(LoginAndRegisterProtos.Event.AD_TIMEOUT, h());
        } else {
            a("===「埋点」广告_父返回成功 资源位id：" + h() + " 广告位id:" + ((Object) bluedADExtra.third_id) + " 询价价格:" + bluedADExtra.price + " 广告源:" + ((Object) bluedADExtra.adm_type_source));
            EventTrackSettings.a(LoginAndRegisterProtos.Event.AD_RETURN_SUCCESS_ALL, h(), bluedADExtra.third_id, Double.parseDouble(String.valueOf(bluedADExtra.price)), bluedADExtra.adm_type_source);
        }
        a(bluedADExtra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00de A[EDGE_INSN: B:57:0x00de->B:31:0x00de ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x01d2 -> B:15:0x0064). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.common.adx.base.AdxBaseManager.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public float a(float f, float f2) {
        return new BigDecimal(String.valueOf(f)).add(new BigDecimal(String.valueOf(f2))).floatValue();
    }

    public abstract Object a(List<? extends BluedADExtra> list, Continuation<? super Flow<? extends IBaseAd>> continuation);

    /* JADX WARN: Multi-variable type inference failed */
    public final List<BluedADExtra> a(List<?> list) {
        boolean z;
        Intrinsics.e(list, "list");
        List<?> list2 = list;
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            if (!(it.next() instanceof BluedADExtra)) {
                return null;
            }
        }
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator it2 = list2.iterator();
            while (true) {
                z = true;
                if (!it2.hasNext()) {
                    break;
                } else if (!(it2.next() instanceof BluedADExtra)) {
                    z = false;
                    break;
                }
            }
        } else {
            z = true;
        }
        if (z) {
            return list;
        }
        return null;
    }

    public abstract void a(BluedADExtra bluedADExtra);

    public final void a(String log) {
        Intrinsics.e(log, "log");
        Log.v("adx", hashCode() + " - " + log);
    }

    public final void a(ArrayList<?> arrayList) {
        Deferred<Unit> b;
        Deferred<Unit> deferred = this.g;
        a(Intrinsics.a("当前协程状态 deferred.isActive: ", (Object) (deferred == null ? null : Boolean.valueOf(deferred.a()))));
        Deferred<Unit> deferred2 = this.g;
        boolean z = false;
        if (deferred2 != null && deferred2.a()) {
            z = true;
        }
        if (z) {
            a("当前协程正在运行中------------");
        } else if (arrayList == null) {
            a("没有广告数据，直接返回");
            d((BluedADExtra) null);
        } else if (arrayList.size() == 0) {
            a("没有广告数据，直接返回");
            d((BluedADExtra) null);
        } else {
            List<BluedADExtra> a2 = a((List<?>) arrayList);
            if (a2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.blued.android.module.common.login.model.BluedADExtra>{ kotlin.collections.TypeAliasesKt.ArrayList<com.blued.android.module.common.login.model.BluedADExtra> }");
            }
            this.b = (ArrayList) a2;
            b = BuildersKt__Builders_commonKt.b(CoroutineScopeKt.a(), Dispatchers.b(), null, new AdxBaseManager$start$1(this, null), 2, null);
            this.g = b;
        }
    }

    public abstract void a(Map<String, ? extends BluedADExtra> map);

    public abstract void b(Map<String, ? extends BluedADExtra> map);

    public abstract long e();

    public abstract int f();

    public abstract int g();

    public abstract String h();

    public final Comparator<BluedADExtra> i() {
        return this.h;
    }
}
