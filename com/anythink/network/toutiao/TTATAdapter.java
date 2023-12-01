package com.anythink.network.toutiao;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ATBiddingListener;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import com.anythink.network.toutiao.TTATNativeExpressHandler;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTClientBidding;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.igexin.assist.sdk.AssistPushConsts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATAdapter.class */
public class TTATAdapter extends CustomNativeAdapter {

    /* renamed from: a  reason: collision with root package name */
    String f6226a;
    String b;

    /* renamed from: c  reason: collision with root package name */
    String f6227c;
    private final String g = getClass().getSimpleName();
    int d = 0;
    String e = "";
    boolean f = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.toutiao.TTATAdapter$2  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATAdapter$2.class */
    public final class AnonymousClass2 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f6230a;
        final /* synthetic */ Map b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Map f6231c;
        final /* synthetic */ int d;

        AnonymousClass2(Context context, Map map, Map map2, int i) {
            this.f6230a = context;
            this.b = map;
            this.f6231c = map2;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            int i;
            Bitmap bitmap;
            int i2;
            TTAdManager adManager = TTAdSdk.getAdManager();
            int i3 = this.f6230a.getResources().getDisplayMetrics().widthPixels;
            int i4 = this.f6230a.getResources().getDisplayMetrics().heightPixels;
            Map map = this.b;
            if (map != null) {
                Object obj = map.containsKey("key_width") ? this.b.get("key_width") : null;
                Object obj2 = this.b.containsKey(TTATConst.NATIVE_AD_IMAGE_HEIGHT) ? this.b.get(TTATConst.NATIVE_AD_IMAGE_HEIGHT) : this.b.containsKey("key_height") ? this.b.get("key_height") : null;
                Object obj3 = this.b.get(TTATConst.NATIVE_AD_INTERRUPT_VIDEOPLAY);
                Object obj4 = this.b.get(TTATConst.NATIVE_AD_VIDEOPLAY_BTN_BITMAP);
                Object obj5 = this.b.get(TTATConst.NATIVE_AD_VIDEOPLAY_BTN_SIZE);
                if (obj != null && obj2 != null) {
                    try {
                        i3 = (int) Double.parseDouble(obj.toString());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    try {
                        i2 = (int) Double.parseDouble(obj2.toString());
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        i2 = i4;
                    }
                } else if (TTATAdapter.this.d == 1) {
                    i3 = 690;
                    i2 = 388;
                } else if (TTATAdapter.this.d == 2) {
                    i3 = 228;
                    i2 = 150;
                } else if (TTATAdapter.this.d == 3) {
                    i3 = 1280;
                    i2 = 720;
                } else if (TTATAdapter.this.d == 4) {
                    i3 = 1200;
                    i2 = 628;
                } else {
                    i2 = i4;
                    if (TTATAdapter.this.d == 5) {
                        i3 = 640;
                        i2 = 640;
                    }
                }
                z = obj3 instanceof Boolean ? Boolean.parseBoolean(obj3.toString()) : true;
                bitmap = obj4 instanceof Bitmap ? (Bitmap) obj4 : null;
                if (obj5 instanceof Integer) {
                    i4 = i2;
                    i = Integer.parseInt(obj5.toString());
                } else {
                    i4 = i2;
                    i = 0;
                }
            } else {
                z = true;
                i = 0;
                bitmap = null;
            }
            TTAdNative createAdNative = adManager.createAdNative(this.f6230a);
            TTATCustomAdSlotBuilder tTATCustomAdSlotBuilder = new TTATCustomAdSlotBuilder(TTATAdapter.this.f6226a, this.f6231c, this.b);
            tTATCustomAdSlotBuilder.setAdCount(Math.min(this.d, 3));
            tTATCustomAdSlotBuilder.setSupportDeepLink(true);
            if (TextUtils.equals("0", TTATAdapter.this.f6227c) && TextUtils.equals("0", TTATAdapter.this.b)) {
                Log.i(TTATAdapter.this.g, "load Native Express Ad");
                tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(TTATAdapter.a(this.f6230a, i3), TTATAdapter.a(this.f6230a, i4));
                final boolean z2 = z;
                createAdNative.loadNativeExpressAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.NativeExpressAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.1
                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                    public final void onError(int i5, String str) {
                        TTATAdapter.this.notifyATLoadFail(String.valueOf(i5), str);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
                    public final void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                        TTATAdapter.a(TTATAdapter.this, AnonymousClass2.this.f6230a, (List) list, z2, false);
                    }
                });
            } else if (TextUtils.equals("1", TTATAdapter.this.f6227c) && TextUtils.equals("0", TTATAdapter.this.b)) {
                Log.i(TTATAdapter.this.g, "load Native Express Video");
                tTATCustomAdSlotBuilder.setExpressViewAcceptedSize(TTATAdapter.a(this.f6230a, i3), TTATAdapter.a(this.f6230a, i4));
                final boolean z3 = z;
                createAdNative.loadExpressDrawFeedAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.NativeExpressAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.2
                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                    public final void onError(int i5, String str) {
                        TTATAdapter.this.notifyATLoadFail(String.valueOf(i5), str);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
                    public final void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
                        TTATAdapter.a(TTATAdapter.this, AnonymousClass2.this.f6230a, (List) list, z3, true);
                    }
                });
            } else {
                if (i3 <= 0 || i4 <= 0) {
                    tTATCustomAdSlotBuilder.setImageAcceptedSize(640, 320);
                } else {
                    tTATCustomAdSlotBuilder.setImageAcceptedSize(i3, i4);
                }
                String str = TTATAdapter.this.f6227c;
                boolean z4 = true;
                switch (str.hashCode()) {
                    case 48:
                        if (str.equals("0")) {
                            z4 = false;
                            break;
                        }
                        break;
                    case 49:
                        if (str.equals("1")) {
                            z4 = true;
                            break;
                        }
                        break;
                    case 50:
                        if (str.equals("2")) {
                            z4 = true;
                            break;
                        }
                        break;
                    case 51:
                        if (str.equals("3")) {
                            z4 = true;
                            break;
                        }
                        break;
                    case 52:
                        if (str.equals("4")) {
                            z4 = true;
                            break;
                        }
                        break;
                }
                if (!z4) {
                    final boolean z5 = z;
                    final Bitmap bitmap2 = bitmap;
                    final int i5 = i;
                    createAdNative.loadFeedAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.FeedAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.3
                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                        public final void onError(int i6, String str2) {
                            TTATAdapter.this.notifyATLoadFail(String.valueOf(i6), str2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
                        public final void onFeedAdLoad(List<TTFeedAd> list) {
                            ArrayList arrayList = new ArrayList();
                            for (TTFeedAd tTFeedAd : list) {
                                arrayList.add(new TTATNativeAd(AnonymousClass2.this.f6230a, TTATAdapter.this.f6226a, tTFeedAd, z5, bitmap2, i5));
                            }
                            TTATAdapter.a(TTATAdapter.this, list, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
                        }
                    });
                } else if (z4) {
                    final boolean z6 = z;
                    final Bitmap bitmap3 = bitmap;
                    final int i6 = i;
                    createAdNative.loadDrawFeedAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.DrawFeedAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.4
                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener
                        public final void onDrawFeedAdLoad(List<TTDrawFeedAd> list) {
                            ArrayList arrayList = new ArrayList();
                            for (TTDrawFeedAd tTDrawFeedAd : list) {
                                arrayList.add(new TTATNativeAd(AnonymousClass2.this.f6230a, TTATAdapter.this.f6226a, tTDrawFeedAd, z6, bitmap3, i6));
                            }
                            TTATAdapter.a(TTATAdapter.this, list, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.DrawFeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                        public final void onError(int i7, String str2) {
                            TTATAdapter.this.notifyATLoadFail(String.valueOf(i7), str2);
                        }
                    });
                } else if (z4) {
                    tTATCustomAdSlotBuilder.setNativeAdType(1);
                    final boolean z7 = z;
                    final Bitmap bitmap4 = bitmap;
                    final int i7 = i;
                    createAdNative.loadNativeAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.NativeAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.5
                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                        public final void onError(int i8, String str2) {
                            TTATAdapter.this.notifyATLoadFail(String.valueOf(i8), str2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
                        public final void onNativeAdLoad(List<TTNativeAd> list) {
                            ArrayList arrayList = new ArrayList();
                            for (TTNativeAd tTNativeAd : list) {
                                arrayList.add(new TTATNativeAd(AnonymousClass2.this.f6230a, TTATAdapter.this.f6226a, tTNativeAd, z7, bitmap4, i7));
                            }
                            TTATAdapter.a(TTATAdapter.this, list, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
                        }
                    });
                } else if (z4) {
                    tTATCustomAdSlotBuilder.setNativeAdType(2);
                    final boolean z8 = z;
                    final Bitmap bitmap5 = bitmap;
                    final int i8 = i;
                    createAdNative.loadNativeAd(tTATCustomAdSlotBuilder.build(), new TTAdNative.NativeAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.6
                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                        public final void onError(int i9, String str2) {
                            TTATAdapter.this.notifyATLoadFail(String.valueOf(i9), str2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
                        public final void onNativeAdLoad(List<TTNativeAd> list) {
                            ArrayList arrayList = new ArrayList();
                            for (TTNativeAd tTNativeAd : list) {
                                arrayList.add(new TTATNativeAd(AnonymousClass2.this.f6230a, TTATAdapter.this.f6226a, tTNativeAd, z8, bitmap5, i8));
                            }
                            TTATAdapter.a(TTATAdapter.this, list, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
                        }
                    });
                } else if (!z4) {
                    TTATAdapter.this.notifyATLoadFail("", "The Native type is not exit.");
                } else {
                    final boolean z9 = z;
                    final Bitmap bitmap6 = bitmap;
                    final int i9 = i;
                    createAdNative.loadStream(tTATCustomAdSlotBuilder.build(), new TTAdNative.FeedAdListener() { // from class: com.anythink.network.toutiao.TTATAdapter.2.7
                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
                        public final void onError(int i10, String str2) {
                            TTATAdapter.this.notifyATLoadFail(String.valueOf(i10), str2);
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
                        public final void onFeedAdLoad(List<TTFeedAd> list) {
                            if (list == null || list.isEmpty()) {
                                TTATAdapter.this.notifyATLoadFail("", "Ad list is empty.");
                                return;
                            }
                            ArrayList arrayList = new ArrayList();
                            for (TTFeedAd tTFeedAd : list) {
                                arrayList.add(new TTATNativePatchAd(AnonymousClass2.this.f6230a, TTATAdapter.this.f6226a, tTFeedAd, z9, bitmap6, i9));
                            }
                            TTATAdapter.a(TTATAdapter.this, list, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.network.toutiao.TTATAdapter$3  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/network/toutiao/TTATAdapter$3.class */
    public final class AnonymousClass3 implements TTATNativeExpressHandler.RenderCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f6244a;
        final /* synthetic */ boolean b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f6245c;

        AnonymousClass3(Context context, boolean z, boolean z2) {
            this.f6244a = context;
            this.b = z;
            this.f6245c = z2;
        }

        @Override // com.anythink.network.toutiao.TTATNativeExpressHandler.RenderCallback
        public final void onRenderFail(String str, int i) {
            TTATAdapter.this.notifyATLoadFail(String.valueOf(i), str);
        }

        @Override // com.anythink.network.toutiao.TTATNativeExpressHandler.RenderCallback
        public final void onRenderSuccess(List<TTNativeExpressAd> list) {
            ArrayList arrayList = new ArrayList();
            for (TTNativeExpressAd tTNativeExpressAd : list) {
                arrayList.add(new TTATNativeExpressAd(this.f6244a, TTATAdapter.this.f6226a, tTNativeExpressAd, this.b, this.f6245c));
            }
            TTATAdapter.a(TTATAdapter.this, list, (CustomNativeAd[]) arrayList.toArray(new CustomNativeAd[arrayList.size()]));
        }
    }

    static /* synthetic */ int a(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        float f3 = f2;
        if (f2 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f / f3) + 0.5f);
    }

    private void a(Context context, List<TTNativeExpressAd> list, boolean z, boolean z2) {
        new TTATNativeExpressHandler(list).startRender(new AnonymousClass3(context, z, z2));
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2, int i) {
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(this.f6227c)) {
            notifyATLoadFail("", "nativeType is empty");
        } else {
            runOnNetworkRequestThread(new AnonymousClass2(applicationContext, map2, map, i));
        }
    }

    static /* synthetic */ void a(TTATAdapter tTATAdapter, Context context, List list, boolean z, boolean z2) {
        new TTATNativeExpressHandler(list).startRender(new AnonymousClass3(context, z, z2));
    }

    static /* synthetic */ void a(TTATAdapter tTATAdapter, Context context, Map map, Map map2, int i) {
        Context applicationContext = context.getApplicationContext();
        if (TextUtils.isEmpty(tTATAdapter.f6227c)) {
            tTATAdapter.notifyATLoadFail("", "nativeType is empty");
        } else {
            tTATAdapter.runOnNetworkRequestThread(new AnonymousClass2(applicationContext, map2, map, i));
        }
    }

    static /* synthetic */ void a(TTATAdapter tTATAdapter, List list, CustomNativeAd[] customNativeAdArr) {
        if (list.size() == 0 || customNativeAdArr.length == 0) {
            tTATAdapter.notifyATLoadFail("", "Ad list is empty.");
            return;
        }
        Object obj = list.get(0);
        HashMap hashMap = new HashMap(3);
        if (obj instanceof TTNativeAd) {
            try {
                Map<String, Object> mediaExtraInfo = ((TTNativeAd) obj).getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    hashMap.putAll(mediaExtraInfo);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (obj instanceof TTNativeExpressAd) {
            try {
                Map<String, Object> mediaExtraInfo2 = ((TTNativeExpressAd) obj).getMediaExtraInfo();
                if (mediaExtraInfo2 != null) {
                    hashMap.putAll(mediaExtraInfo2);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (!tTATAdapter.f) {
            if (tTATAdapter.mLoadListener != null) {
                tTATAdapter.mLoadListener.onAdCacheLoaded(customNativeAdArr);
            }
        } else if (tTATAdapter.mBiddingListener != null) {
            TTATInitManager.getInstance().a(hashMap, customNativeAdArr[0], (TTClientBidding) list.get(0), tTATAdapter.mBiddingListener);
            tTATAdapter.mBiddingListener = null;
        }
    }

    private void a(List<? extends TTClientBidding> list, CustomNativeAd... customNativeAdArr) {
        if (list.size() == 0 || customNativeAdArr.length == 0) {
            notifyATLoadFail("", "Ad list is empty.");
            return;
        }
        TTClientBidding tTClientBidding = list.get(0);
        HashMap hashMap = new HashMap(3);
        if (tTClientBidding instanceof TTNativeAd) {
            try {
                Map<String, Object> mediaExtraInfo = ((TTNativeAd) tTClientBidding).getMediaExtraInfo();
                if (mediaExtraInfo != null) {
                    hashMap.putAll(mediaExtraInfo);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        if (tTClientBidding instanceof TTNativeExpressAd) {
            try {
                Map<String, Object> mediaExtraInfo2 = ((TTNativeExpressAd) tTClientBidding).getMediaExtraInfo();
                if (mediaExtraInfo2 != null) {
                    hashMap.putAll(mediaExtraInfo2);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        if (!this.f) {
            if (this.mLoadListener != null) {
                this.mLoadListener.onAdCacheLoaded(customNativeAdArr);
            }
        } else if (this.mBiddingListener != null) {
            TTATInitManager.getInstance().a(hashMap, customNativeAdArr[0], list.get(0), this.mBiddingListener);
            this.mBiddingListener = null;
        }
    }

    private boolean a(Map<String, Object> map) {
        this.f6226a = (String) map.get("slot_id");
        if (TextUtils.isEmpty((String) map.get("app_id")) || TextUtils.isEmpty(this.f6226a)) {
            return false;
        }
        this.b = "1";
        if (map.containsKey("layout_type")) {
            this.b = (String) map.get("layout_type");
        } else {
            this.b = "0";
        }
        if (map.containsKey("is_video")) {
            this.f6227c = map.get("is_video").toString();
        }
        try {
            if (map.containsKey("media_size")) {
                this.d = Integer.parseInt(map.get("media_size").toString());
            }
        } catch (Exception e) {
        }
        if (map.containsKey(AssistPushConsts.MSG_TYPE_PAYLOAD)) {
            this.e = map.get(AssistPushConsts.MSG_TYPE_PAYLOAD).toString();
            return true;
        }
        return true;
    }

    private static int b(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        float f3 = f2;
        if (f2 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f / f3) + 0.5f);
    }

    public void destory() {
    }

    public String getNetworkName() {
        return TTATInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        return this.f6226a;
    }

    public String getNetworkSDKVersion() {
        return TTATInitManager.getInstance().getNetworkVersion();
    }

    public void loadCustomNetworkAd(final Context context, final Map<String, Object> map, final Map<String, Object> map2) {
        if (a(map)) {
            TTATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.toutiao.TTATAdapter.1
                public final void onFail(String str) {
                    TTATAdapter.this.notifyATLoadFail("", str);
                }

                public final void onSuccess() {
                    TTATAdapter tTATAdapter = TTATAdapter.this;
                    TTATAdapter.a(tTATAdapter, context, map, map2, tTATAdapter.f ? 1 : TTATAdapter.this.mRequestNum);
                }
            });
        } else {
            notifyATLoadFail("", "app_id or slot_id is empty!");
        }
    }

    public boolean startBiddingRequest(Context context, Map<String, Object> map, Map<String, Object> map2, ATBiddingListener aTBiddingListener) {
        this.f = true;
        loadCustomNetworkAd(context, map, map2);
        return true;
    }
}
