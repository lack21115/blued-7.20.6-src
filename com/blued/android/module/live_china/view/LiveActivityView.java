package com.blued.android.module.live_china.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alipay.sdk.sys.a;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.urlroute.BluedUrlParser;
import com.blued.android.framework.urlroute.BluedUrlUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.TypeUtils;
import com.blued.android.framework.web.BluedWebView;
import com.blued.android.module.common.web.LoaderConstants;
import com.blued.android.module.common.web.jsbridge.BridgeHandler;
import com.blued.android.module.common.web.jsbridge.BridgeManager;
import com.blued.android.module.common.web.jsbridge.CallBackFunction;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.adapter.LiveActivityDotAdapter;
import com.blued.android.module.live_china.fragment.LiveBaseFragment;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;
import com.blued.android.module.live_china.fragment.RecordingOnliveFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveActivityItemModel;
import com.blued.android.module.live_china.model.LiveRoomFunctionItemModel;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.observer.LiveSetDataObserver;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.android.module.live_china.view.LiveActivityView;
import com.blued.android.module.live_china.web.LiveWebCallBack;
import com.blued.das.live.LiveProtos;
import com.bytedance.applog.tracker.Tracker;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveActivityView.class */
public class LiveActivityView extends FrameLayout implements View.OnClickListener {
    public LiveBaseFragment a;
    private View b;
    private Context c;
    private LayoutInflater d;
    private View e;
    private LiveActiivtyRecycleView f;
    private LiveActivityViewPager g;
    private PicAdapter h;
    private LiveActivityDotAdapter i;
    private boolean j;
    private List<LiveActivityItemModel> k;
    private List<View> l;
    private List<View> m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.live_china.view.LiveActivityView$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveActivityView$2.class */
    public class AnonymousClass2 implements ViewPager.OnPageChangeListener {
        AnonymousClass2() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str) {
            LogUtils.c("bridgeManager callback: " + str);
        }

        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            if (i < 0 || i >= LiveActivityView.this.k.size() || i >= LiveActivityView.this.l.size()) {
                return;
            }
            if (i < LiveActivityView.this.i.getData().size()) {
                LiveActivityView.this.i.a(i);
            }
            EventTrackLive.b(LiveProtos.Event.LIVE_ACTIVITY_RESOURCE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), ((LiveActivityItemModel) LiveActivityView.this.k.get(i)).url, ((LiveActivityItemModel) LiveActivityView.this.k.get(i)).display_url != null ? "h5" : "image");
            BridgeManager bridgeManager = (BridgeManager) ((View) LiveActivityView.this.l.get(i)).getTag(LiveActivityView.this.getBridgeManagerKey());
            if (bridgeManager != null) {
                bridgeManager.callHandler(LoaderConstants.NATIVE_TO_JS, ((LiveActivityItemModel) LiveActivityView.this.k.get(i)).jsData, new CallBackFunction() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveActivityView$2$E4pGctp94ZTD1e09kXqAS9YvrtA
                    @Override // com.blued.android.module.common.web.jsbridge.CallBackFunction
                    public final void onCallBack(String str) {
                        LiveActivityView.AnonymousClass2.a(str);
                    }
                });
            }
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveActivityView$PicAdapter.class */
    public class PicAdapter extends PagerAdapter implements View.OnClickListener {
        private LayoutInflater b;
        private ViewPager c;
        private Context d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.blued.android.module.live_china.view.LiveActivityView$PicAdapter$2  reason: invalid class name */
        /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveActivityView$PicAdapter$2.class */
        public class AnonymousClass2 extends LiveWebCallBack {
            final /* synthetic */ BridgeManager a;
            final /* synthetic */ LiveActivityItemModel b;

            AnonymousClass2(BridgeManager bridgeManager, LiveActivityItemModel liveActivityItemModel) {
                this.a = bridgeManager;
                this.b = liveActivityItemModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void d(String str) {
                LogUtils.c("bridgeManager callback: " + str);
            }

            @Override // com.blued.android.module.live_china.web.LiveWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(BluedWebView bluedWebView, int i) {
            }

            @Override // com.blued.android.module.live_china.web.LiveWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(BluedWebView bluedWebView, int i, String str, String str2) {
            }

            @Override // com.blued.android.module.live_china.web.LiveWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(BluedWebView bluedWebView, String str) {
            }

            @Override // com.blued.android.module.live_china.web.LiveWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
            public void a(BluedWebView bluedWebView, String str, boolean z) {
                BridgeManager bridgeManager = this.a;
                if (bridgeManager != null) {
                    bridgeManager.onLoadPageOverrideLoad(bluedWebView, str, z);
                }
            }

            @Override // com.blued.android.module.live_china.web.LiveWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
            public boolean a(BluedWebView bluedWebView, BluedUrlParser bluedUrlParser) {
                return false;
            }

            @Override // com.blued.android.module.live_china.web.LiveWebCallBack, com.blued.android.framework.web.BluedWebView.WebCallback
            public void b(BluedWebView bluedWebView, String str, boolean z) {
                bluedWebView.c().clearHistory();
                BridgeManager bridgeManager = this.a;
                if (bridgeManager != null) {
                    bridgeManager.onLoadPageFinished(bluedWebView, str);
                    LogUtils.c("onLoadPageFinished set JsData: " + this.b.jsData);
                    this.a.callHandler(LoaderConstants.NATIVE_TO_JS, this.b.jsData, new CallBackFunction() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveActivityView$PicAdapter$2$6GQgZvY50j6sZXjX_s34s-RtEqY
                        @Override // com.blued.android.module.common.web.jsbridge.CallBackFunction
                        public final void onCallBack(String str2) {
                            LiveActivityView.PicAdapter.AnonymousClass2.d(str2);
                        }
                    });
                }
            }
        }

        public PicAdapter(Context context, ViewPager viewPager) {
            this.d = context;
            this.c = viewPager;
            this.b = LayoutInflater.from(context);
        }

        private View a(final LiveActivityItemModel liveActivityItemModel) {
            View inflate = this.b.inflate(R.layout.live_activity_web_item, (ViewGroup) null);
            WebView webView = (WebView) inflate.findViewById(R.id.live_activity_web_item_wv);
            View findViewById = inflate.findViewById(R.id.iv_click);
            BridgeManager bridgeManager = new BridgeManager();
            BluedWebView bluedWebView = new BluedWebView(LiveActivityView.this.a, webView, null, new AnonymousClass2(bridgeManager, liveActivityItemModel));
            webView.setBackgroundColor(0);
            webView.getBackground().setAlpha(0);
            webView.clearCache(true);
            bridgeManager.registerHandler(LoaderConstants.LIVE_ACTIVITY_ACTION, new BridgeHandler() { // from class: com.blued.android.module.live_china.view.LiveActivityView.PicAdapter.3
                @Override // com.blued.android.module.common.web.jsbridge.BridgeHandler
                public void handler(String str, CallBackFunction callBackFunction) {
                    LiveEventBusUtil.a((LiveRoomFunctionItemModel) AppInfo.f().fromJson(str, LiveRoomFunctionItemModel.class));
                }
            });
            bridgeManager.setBluedWebView(bluedWebView);
            String a = LiveActivityView.this.a(liveActivityItemModel.display_url);
            bluedWebView.a(a);
            LogUtils.c("createView origin url: " + liveActivityItemModel.display_url);
            LogUtils.c("createView new url: " + a);
            inflate.setTag(R.id.tag_net_url, liveActivityItemModel.display_url);
            inflate.setTag(LiveActivityView.this.getBridgeManagerKey(), bridgeManager);
            boolean z = true;
            if (!TextUtils.isEmpty(liveActivityItemModel.display_url)) {
                Map<String, String> a2 = BluedUrlUtils.a(liveActivityItemModel.display_url);
                z = true;
                if (a2 != null) {
                    z = true;
                    if (a2.size() > 0) {
                        String str = a2.get("proxy");
                        z = true;
                        if (str != null) {
                            z = true;
                            if (StringUtils.a(str, 0) == 1) {
                                z = false;
                            }
                        }
                    }
                }
            }
            LogUtils.c("setClick: " + z);
            if (!z) {
                findViewById.setVisibility(8);
                return inflate;
            }
            findViewById.setVisibility(0);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveActivityView.PicAdapter.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Tracker.onClick(view);
                    LiveActivityView.this.c(liveActivityItemModel);
                }
            });
            return inflate;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void a(String str) {
            LogUtils.c("bridgeManager callback: " + str);
        }

        public void a(List<LiveActivityItemModel> list) {
            boolean z;
            if (list == null) {
                return;
            }
            LiveActivityView.this.m.clear();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= LiveActivityView.this.l.size()) {
                    break;
                }
                if (((View) LiveActivityView.this.l.get(i2)).getTag(R.id.tag_net_url) != null) {
                    LiveActivityView.this.m.add((View) LiveActivityView.this.l.get(i2));
                }
                i = i2 + 1;
            }
            LiveActivityView.this.l.clear();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= list.size()) {
                    notifyDataSetChanged();
                    return;
                }
                final LiveActivityItemModel liveActivityItemModel = list.get(i4);
                if (liveActivityItemModel != null) {
                    View view = null;
                    if (TextUtils.isEmpty(liveActivityItemModel.display_url)) {
                        view = this.b.inflate(R.layout.live_activity_item, (ViewGroup) null);
                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_grab);
                        ImageLoader.a((IRequestHost) null, liveActivityItemModel.icon).a(imageView);
                        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveActivityView.PicAdapter.1
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view2) {
                                Tracker.onClick(view2);
                                LiveActivityView.this.c(liveActivityItemModel);
                            }
                        });
                    } else {
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 >= LiveActivityView.this.m.size()) {
                                z = false;
                                break;
                            } else if (LiveActivityView.this.m.get(i6) == null || !liveActivityItemModel.display_url.equalsIgnoreCase((String) ((View) LiveActivityView.this.m.get(i6)).getTag(R.id.tag_net_url))) {
                                i5 = i6 + 1;
                            } else {
                                view = (View) LiveActivityView.this.m.get(i6);
                                BridgeManager bridgeManager = (BridgeManager) view.getTag(LiveActivityView.this.getBridgeManagerKey());
                                if (bridgeManager != null) {
                                    LogUtils.c("set JsData: " + liveActivityItemModel.jsData);
                                    bridgeManager.callHandler(LoaderConstants.NATIVE_TO_JS, liveActivityItemModel.jsData, new CallBackFunction() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveActivityView$PicAdapter$u8kGNDSHB15lib0uAQ2g-b9Y6hY
                                        @Override // com.blued.android.module.common.web.jsbridge.CallBackFunction
                                        public final void onCallBack(String str) {
                                            LiveActivityView.PicAdapter.a(str);
                                        }
                                    });
                                }
                                LiveActivityView.this.m.remove(i6);
                                LogUtils.c(liveActivityItemModel.display_url + " use old");
                                z = true;
                            }
                        }
                        if (!z) {
                            view = a(liveActivityItemModel);
                        }
                    }
                    if (view != null) {
                        view.setTag(R.id.tag_activity_id, Long.valueOf(liveActivityItemModel.id));
                        LiveActivityView.this.l.add(view);
                    }
                }
                i3 = i4 + 1;
            }
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public int getCount() {
            return LiveActivityView.this.l.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            Log.i("==ppp", "instantiateItem:" + i);
            View view = (View) LiveActivityView.this.l.get(i);
            view.setTag(Integer.valueOf(i));
            view.setOnClickListener(this);
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view);
            return view;
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Tracker.onClick(view);
        }
    }

    public LiveActivityView(Context context) {
        this(context, null);
    }

    public LiveActivityView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.j = false;
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.c = context;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        String str2;
        String str3;
        String sb;
        if (StringUtils.b(str)) {
            return str;
        }
        if (str.contains("#") && str.split("#").length == 2) {
            str3 = str.split("#")[0];
            str2 = str.split("#")[1];
        } else {
            str2 = "";
            str3 = str;
        }
        String str4 = str3;
        try {
            if (str3.contains("?")) {
                String str5 = str3;
                StringBuilder sb2 = new StringBuilder();
                String str6 = str3;
                sb2.append(str3);
                String str7 = str3;
                sb2.append(a.b);
                String str8 = str3;
                sb = sb2.toString();
            } else {
                StringBuilder sb3 = new StringBuilder();
                String str9 = str3;
                sb3.append(str3);
                String str10 = str3;
                sb3.append("?");
                String str11 = str3;
                sb = sb3.toString();
            }
            String str12 = sb;
            String str13 = LiveRoomManager.a().f() == LiveRoomInfo.a().g() ? "1" : "0";
            StringBuilder sb4 = new StringBuilder();
            String str14 = sb;
            sb4.append(sb);
            String str15 = sb;
            sb4.append("identity=");
            String str16 = sb;
            sb4.append(str13);
            str4 = sb;
            str4 = sb4.toString();
        } catch (Exception e) {
        }
        if (StringUtils.b(str2)) {
            return str4;
        }
        return str4 + "#" + str2;
    }

    private List<LiveActivityItemModel> b(LiveActivityItemModel liveActivityItemModel) {
        ArrayList arrayList = new ArrayList();
        if (liveActivityItemModel != null && !TypeUtils.a((List<?>) liveActivityItemModel.display_urls)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= liveActivityItemModel.display_urls.size()) {
                    break;
                }
                LiveActivityItemModel liveActivityItemModel2 = new LiveActivityItemModel();
                liveActivityItemModel2.url = liveActivityItemModel.url;
                liveActivityItemModel2.icon = liveActivityItemModel.icon;
                liveActivityItemModel2.id = liveActivityItemModel.id;
                liveActivityItemModel2.page = liveActivityItemModel.page;
                liveActivityItemModel2.sort = liveActivityItemModel.sort;
                liveActivityItemModel2.status = liveActivityItemModel.status;
                liveActivityItemModel2.display_url = liveActivityItemModel.display_urls.get(i2).url;
                liveActivityItemModel2.jsData = liveActivityItemModel.display_urls.get(i2).data;
                arrayList.add(liveActivityItemModel2);
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(String str) {
        LogUtils.c("bridgeManager callback: " + str);
    }

    private void c() {
        LayoutInflater from = LayoutInflater.from(this.c);
        this.d = from;
        View inflate = from.inflate(R.layout.live_activity_layout, (ViewGroup) this, true);
        this.b = inflate;
        this.e = inflate.findViewById(R.id.fl_box);
        LiveActiivtyRecycleView liveActiivtyRecycleView = (LiveActiivtyRecycleView) this.b.findViewById(R.id.box_rv);
        this.f = liveActiivtyRecycleView;
        liveActiivtyRecycleView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false) { // from class: com.blued.android.module.live_china.view.LiveActivityView.1
            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
                LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.blued.android.module.live_china.view.LiveActivityView.1.1
                    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        return 600.0f / displayMetrics.densityDpi;
                    }
                };
                linearSmoothScroller.setTargetPosition(i);
                startSmoothScroll(linearSmoothScroller);
            }
        });
        this.g = (LiveActivityViewPager) this.b.findViewById(R.id.box_view_pager);
        PicAdapter picAdapter = new PicAdapter(getContext(), this.g);
        this.h = picAdapter;
        this.g.setAdapter(picAdapter);
        this.g.setInterval(3000L);
        RecyclerView.Adapter liveActivityDotAdapter = new LiveActivityDotAdapter(getContext(), new ArrayList(), this.f);
        this.i = liveActivityDotAdapter;
        this.f.setAdapter(liveActivityDotAdapter);
        setVisibility(8);
        this.g.addOnPageChangeListener(new AnonymousClass2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(LiveActivityItemModel liveActivityItemModel) {
        LogUtils.c("onClickModel: " + liveActivityItemModel.url);
        EventTrackLive.b(LiveProtos.Event.LIVE_ACTIVITY_RESOURCE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), liveActivityItemModel.url, liveActivityItemModel.display_url != null ? "h5" : "image");
        LiveBaseFragment liveBaseFragment = this.a;
        if (!(liveBaseFragment instanceof PlayingOnliveFragment)) {
            if (liveBaseFragment instanceof RecordingOnliveFragment) {
                ((RecordingOnliveFragment) liveBaseFragment).d(liveActivityItemModel.url, 0);
            }
        } else if (liveActivityItemModel.page == 0) {
            LiveRoomInfo.a().a(this.c, liveActivityItemModel.url);
            ((PlayingOnliveFragment) this.a).b(true);
        } else if (BluedWebView.a(this.c, liveActivityItemModel.url, new LiveWebCallBack())) {
        } else {
            ((PlayingOnliveFragment) this.a).a(liveActivityItemModel.url, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBridgeManagerKey() {
        return R.id.attach_img_view;
    }

    public void a(LiveBaseFragment liveBaseFragment) {
        this.a = liveBaseFragment;
    }

    public void a(final LiveActivityItemModel liveActivityItemModel) {
        ImageView imageView;
        BridgeManager bridgeManager;
        if (TypeUtils.a((List<?>) liveActivityItemModel.display_urls)) {
            if (TextUtils.isEmpty(liveActivityItemModel.icon)) {
                return;
            }
            for (int i = 0; i < this.l.size(); i++) {
                Object tag = this.l.get(i).getTag(R.id.tag_activity_id);
                if (liveActivityItemModel.id != 0 && tag != null && (tag instanceof Long) && ((Long) tag).longValue() == liveActivityItemModel.id && (imageView = (ImageView) this.l.get(i).findViewById(R.id.iv_grab)) != null) {
                    LogUtils.c("updateData icon:" + liveActivityItemModel.icon);
                    ImageLoader.a((IRequestHost) null, liveActivityItemModel.icon).a(imageView);
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.LiveActivityView.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            Tracker.onClick(view);
                            LiveActivityView.this.c(liveActivityItemModel);
                        }
                    });
                }
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(b(liveActivityItemModel));
        ArrayList<LiveActivityItemModel> arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= arrayList.size()) {
                break;
            }
            LiveActivityItemModel liveActivityItemModel2 = (LiveActivityItemModel) arrayList.get(i3);
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= this.k.size()) {
                    break;
                }
                if (TextUtils.equals(this.k.get(i5).display_url, liveActivityItemModel2.display_url) && !hashMap.containsKey(String.valueOf(i5))) {
                    this.k.set(i5, liveActivityItemModel2);
                    hashMap.put(String.valueOf(i5), String.valueOf(i5));
                    arrayList2.add(liveActivityItemModel2);
                    break;
                }
                i4 = i5 + 1;
            }
            i2 = i3 + 1;
        }
        ArrayList arrayList3 = new ArrayList();
        int i6 = 0;
        while (true) {
            int i7 = i6;
            if (i7 >= this.l.size()) {
                break;
            }
            if (this.l.get(i7).getTag(R.id.tag_net_url) != null) {
                arrayList3.add(this.l.get(i7));
            }
            i6 = i7 + 1;
        }
        for (LiveActivityItemModel liveActivityItemModel3 : arrayList2) {
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= arrayList3.size()) {
                    break;
                }
                Object tag2 = ((View) arrayList3.get(i9)).getTag(R.id.tag_net_url);
                if (tag2 != null && (tag2 instanceof String) && liveActivityItemModel3.display_url.equalsIgnoreCase((String) tag2)) {
                    Object tag3 = ((View) arrayList3.get(i9)).getTag(getBridgeManagerKey());
                    if ((tag3 instanceof BridgeManager) && (bridgeManager = (BridgeManager) tag3) != null) {
                        LogUtils.c("updateData url:" + liveActivityItemModel3.display_url);
                        bridgeManager.callHandler(LoaderConstants.NATIVE_TO_JS, liveActivityItemModel3.jsData, new CallBackFunction() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveActivityView$uO5zSbESIwCdyjZI00pOhSa3C7E
                            @Override // com.blued.android.module.common.web.jsbridge.CallBackFunction
                            public final void onCallBack(String str) {
                                LiveActivityView.b(str);
                            }
                        });
                    }
                    arrayList3.remove(i9);
                } else {
                    i8 = i9 + 1;
                }
            }
        }
    }

    public boolean a() {
        return this.j;
    }

    public void b() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.l.size()) {
                this.g.b();
                this.l.clear();
                this.h.notifyDataSetChanged();
                return;
            }
            this.l.get(i2).setTag(getBridgeManagerKey(), null);
            i = i2 + 1;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Tracker.onClick(view);
    }

    public void setData(List<LiveActivityItemModel> list) {
        if (list == null || list.size() <= 0) {
            this.j = false;
            LiveSetDataObserver.a().a(false);
            return;
        }
        this.j = true;
        this.k.clear();
        int currentItem = this.g.getCurrentItem();
        int i = 0;
        for (LiveActivityItemModel liveActivityItemModel : list) {
            i++;
            if (TypeUtils.a((List<?>) liveActivityItemModel.display_urls)) {
                this.k.add(liveActivityItemModel);
            } else {
                this.k.addAll(b(liveActivityItemModel));
            }
            LogUtils.c("set Rank[" + i + "] data:" + AppInfo.f().toJson(liveActivityItemModel));
        }
        this.g.b();
        this.h.a(this.k);
        this.g.setAdapter(this.h);
        if (this.k.size() == 1) {
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
        }
        int i2 = currentItem;
        if (this.k.size() > 1) {
            this.g.a();
            i2 = currentItem;
            if (this.k.size() <= currentItem) {
                i2 = 0;
            }
            this.g.setCurrentItem(i2, false);
        }
        this.i.a(this.k, i2 == 0 ? 0 : this.i.a());
        LiveSetDataObserver.a().a(true);
    }
}
