package com.blued.android.module.live_china.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.utils.UiUtils;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.LayoutLiveCurHotBinding;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.BluedLiveListData;
import com.blued.android.module.live_china.model.LiveRoomData;
import com.blued.android.module.live_china.utils.LiveRoomUtils;
import com.blued.android.module.live_china.utils.log.trackUtils.EventTrackLive;
import com.blued.das.live.LiveProtos;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveCurHotRedView.class */
public final class LiveCurHotRedView extends FrameLayout implements LiveListAutoPlay {
    private final Lazy a;
    private String b;
    private String c;
    private List<BluedLiveListData> d;
    private BluedLiveListData e;
    private boolean f;
    private int g;
    private int h;
    private LiveAutoPlayView i;
    private LiveRedPlayView j;
    private Runnable k;
    private EventCallback l;

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view/LiveCurHotRedView$EventCallback.class */
    public interface EventCallback {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveCurHotRedView(Context context) {
        this(context, null);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveCurHotRedView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveCurHotRedView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        this.a = LazyKt.a(new Function0<LayoutLiveCurHotBinding>() { // from class: com.blued.android.module.live_china.view.LiveCurHotRedView$binding$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: a */
            public final LayoutLiveCurHotBinding invoke() {
                LayoutLiveCurHotBinding a = LayoutLiveCurHotBinding.a(LayoutInflater.from(LiveCurHotRedView.this.getContext()), LiveCurHotRedView.this, true);
                Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
                return a;
            }
        });
        this.h = 4;
        this.k = new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveCurHotRedView$Ub2uiPmmseHaad7ai-rkD0YhF30
            @Override // java.lang.Runnable
            public final void run() {
                LiveCurHotRedView.a(LiveCurHotRedView.this);
            }
        };
        a();
    }

    private final void a(BluedLiveListData bluedLiveListData, int i) {
        String str;
        String str2;
        int i2;
        EventTrackLive.a(LiveProtos.Event.LIVE_ROOM_CLICK, this.c, bluedLiveListData.lid, bluedLiveListData.uid, false, i, "0");
        int i3 = bluedLiveListData.screen_pattern;
        String str3 = bluedLiveListData.pic_url;
        String str4 = bluedLiveListData.lid;
        String str5 = bluedLiveListData.uid;
        UserBasicModel userBasicModel = bluedLiveListData.anchor;
        if (userBasicModel == null) {
            str2 = "";
            str = str2;
            i2 = 0;
        } else {
            str = userBasicModel.avatar;
            Intrinsics.c(str, "it.avatar");
            str2 = userBasicModel.name;
            Intrinsics.c(str2, "it.name");
            i2 = userBasicModel.vbadge;
        }
        LiveRoomData liveRoomData = new LiveRoomData(StringUtils.a(str4, 0L), i3, this.b, str5, str2, str, i2);
        liveRoomData.live_url = bluedLiveListData.live_play;
        Bundle bundle = new Bundle();
        bundle.putInt("live_prop", bluedLiveListData.recommended_prop);
        BluedLiveListData bluedLiveListData2 = this.e;
        if (bluedLiveListData2 != null) {
            Intrinsics.a(bluedLiveListData2);
            bluedLiveListData2.lid = bluedLiveListData.lid;
            BluedLiveListData bluedLiveListData3 = this.e;
            Intrinsics.a(bluedLiveListData3);
            bluedLiveListData3.anchor = bluedLiveListData.anchor;
            BluedLiveListData bluedLiveListData4 = this.e;
            Intrinsics.a(bluedLiveListData4);
            bluedLiveListData4.live_play = bluedLiveListData.live_play;
            BluedLiveListData bluedLiveListData5 = this.e;
            Intrinsics.a(bluedLiveListData5);
            bluedLiveListData5.pic_url = bluedLiveListData.pic_url;
            BluedLiveListData bluedLiveListData6 = this.e;
            Intrinsics.a(bluedLiveListData6);
            bluedLiveListData6.uid = bluedLiveListData.uid;
        }
        LiveRoomInfo.a().a(getContext(), liveRoomData, -1, LiveRoomUtils.a(this.d, this.b), bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BluedLiveListData model, Ref.ObjectRef bigView, BluedLiveListData nextModel, LiveCurHotRedView this$0) {
        Intrinsics.e(model, "$model");
        Intrinsics.e(bigView, "$bigView");
        Intrinsics.e(nextModel, "$nextModel");
        Intrinsics.e(this$0, "this$0");
        long a = StringUtils.a(model.lid, 0L);
        ViewGroup.LayoutParams layoutParams = ((View) bigView.a).getLayoutParams();
        model.positionReal = 0;
        nextModel.positionReal = 0;
        LiveAutoPlayView liveAutoPlayView = this$0.i;
        Intrinsics.a(liveAutoPlayView);
        if (liveAutoPlayView.getSessionId() == a) {
            LiveAutoPlayView liveAutoPlayView2 = this$0.i;
            Intrinsics.a(liveAutoPlayView2);
            LiveCurHotRedView liveCurHotRedView = this$0;
            liveAutoPlayView2.a(liveCurHotRedView, model, this$0.b, layoutParams.width, layoutParams.height);
            LiveRedPlayView liveRedPlayView = this$0.j;
            Intrinsics.a(liveRedPlayView);
            liveRedPlayView.a(liveCurHotRedView, nextModel, this$0.b, layoutParams.width, layoutParams.height);
            LiveAutoPlayView liveAutoPlayView3 = this$0.i;
            Intrinsics.a(liveAutoPlayView3);
            liveAutoPlayView3.setAlpha(1.0f);
            LiveRedPlayView liveRedPlayView2 = this$0.j;
            Intrinsics.a(liveRedPlayView2);
            liveRedPlayView2.setAlpha(0.0f);
        } else {
            LiveRedPlayView liveRedPlayView3 = this$0.j;
            Intrinsics.a(liveRedPlayView3);
            if (liveRedPlayView3.getSessionId() == a) {
                LiveAutoPlayView liveAutoPlayView4 = this$0.i;
                Intrinsics.a(liveAutoPlayView4);
                LiveCurHotRedView liveCurHotRedView2 = this$0;
                liveAutoPlayView4.a(liveCurHotRedView2, nextModel, this$0.b, layoutParams.width, layoutParams.height);
                LiveRedPlayView liveRedPlayView4 = this$0.j;
                Intrinsics.a(liveRedPlayView4);
                liveRedPlayView4.a(liveCurHotRedView2, model, this$0.b, layoutParams.width, layoutParams.height);
                LiveAutoPlayView liveAutoPlayView5 = this$0.i;
                Intrinsics.a(liveAutoPlayView5);
                liveAutoPlayView5.setAlpha(0.0f);
                LiveRedPlayView liveRedPlayView5 = this$0.j;
                Intrinsics.a(liveRedPlayView5);
                liveRedPlayView5.setAlpha(1.0f);
            } else {
                LiveAutoPlayView liveAutoPlayView6 = this$0.i;
                Intrinsics.a(liveAutoPlayView6);
                LiveCurHotRedView liveCurHotRedView3 = this$0;
                liveAutoPlayView6.a(liveCurHotRedView3, model, this$0.b, layoutParams.width, layoutParams.height);
                LiveRedPlayView liveRedPlayView6 = this$0.j;
                Intrinsics.a(liveRedPlayView6);
                liveRedPlayView6.a(liveCurHotRedView3, nextModel, this$0.b, layoutParams.width, layoutParams.height);
                LiveAutoPlayView liveAutoPlayView7 = this$0.i;
                Intrinsics.a(liveAutoPlayView7);
                liveAutoPlayView7.setAlpha(1.0f);
                LiveRedPlayView liveRedPlayView7 = this$0.j;
                Intrinsics.a(liveRedPlayView7);
                liveRedPlayView7.setAlpha(0.0f);
            }
        }
        this$0.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveCurHotRedView this$0) {
        Intrinsics.e(this$0, "this$0");
        int i = this$0.g + 1;
        this$0.g = i;
        this$0.g = i % this$0.h;
        this$0.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveCurHotRedView this$0, BluedLiveListData model, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        this$0.a(model, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveCurHotRedView this$0, Ref.ObjectRef model, int i, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(model, "$model");
        T model2 = model.a;
        Intrinsics.c(model2, "model");
        this$0.a((BluedLiveListData) model2, i + 1);
    }

    public final void a() {
        LayoutLiveCurHotBinding binding = getBinding();
        int a = AppInfo.l - AppMethods.a(24);
        int a2 = AppMethods.a(4);
        int a3 = AppMethods.a(2);
        int i = a2 * 2;
        int i2 = (a - i) / 2;
        int i3 = (i2 - (a3 * 2)) / 2;
        int i4 = (i3 * 2) + a3;
        ViewGroup.LayoutParams layoutParams = binding.b.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.width = a;
        layoutParams2.height = i + i4;
        binding.b.setLayoutParams(layoutParams2);
        binding.a.removeAllViews();
        ViewGroup.LayoutParams layoutParams3 = binding.a.getLayoutParams();
        if (layoutParams3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        layoutParams4.width = i2 * 2;
        layoutParams4.height = i4;
        layoutParams4.leftMargin = a2;
        layoutParams4.topMargin = a2;
        layoutParams4.rightMargin = a2;
        layoutParams4.bottomMargin = a2;
        binding.a.setLayoutParams(layoutParams4);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_live_cur_hot_big_item, (ViewGroup) null);
        inflate.setId(R.id.live_hot_left);
        binding.a.addView(inflate, new FrameLayout.LayoutParams(i2, i4));
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setId(R.id.live_hot_right);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(i2, i4);
        layoutParams5.leftMargin = i2;
        binding.a.addView(frameLayout, layoutParams5);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= 4) {
                return;
            }
            View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.layout_live_cur_hot_item, (ViewGroup) null);
            FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(i3, i3);
            if (i6 == 0) {
                layoutParams6.leftMargin = a3;
            } else if (i6 == 1) {
                layoutParams6.leftMargin = i3 + a3 + a3;
            } else if (i6 == 2) {
                int i7 = i3 + a3;
                layoutParams6.leftMargin = i7 + a3;
                layoutParams6.topMargin = i7;
            } else if (i6 == 3) {
                layoutParams6.leftMargin = a3;
                layoutParams6.topMargin = i3 + a3;
            }
            frameLayout.addView(inflate2, layoutParams6);
            i5 = i6 + 1;
        }
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [T, android.view.View] */
    public final void a(final BluedLiveListData model, final BluedLiveListData nextModel) {
        Intrinsics.e(model, "model");
        Intrinsics.e(nextModel, "nextModel");
        EventTrackLive.a(LiveProtos.Event.LIVE_ROOM_SHOW, "red", model.lid, model.uid, false, -1, "0");
        LayoutLiveCurHotBinding binding = getBinding();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.a = binding.a.findViewById(R.id.live_hot_left);
        ImageView imageView = (ImageView) ((View) objectRef.a).findViewById(R.id.iv_avatar);
        setPlayView((LiveAutoPlayView) ((View) objectRef.a).findViewById(R.id.fl_video_view));
        setSecondPlayView((LiveRedPlayView) ((View) objectRef.a).findViewById(R.id.fl_video_sec_view));
        TextView textView = (TextView) ((View) objectRef.a).findViewById(R.id.tv_username);
        TextView textView2 = (TextView) ((View) objectRef.a).findViewById(R.id.tv_audience_count);
        ImageLoader.a((IRequestHost) null, model.pic_url).a(UiUtils.a(getContext(), 172.0f), UiUtils.a(getContext(), 172.0f)).a(imageView);
        ((View) objectRef.a).post(new Runnable() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveCurHotRedView$6RBXmZYpPamJ1_GvW5_KynFHOKo
            @Override // java.lang.Runnable
            public final void run() {
                LiveCurHotRedView.a(BluedLiveListData.this, objectRef, nextModel, this);
            }
        });
        if (TextUtils.isEmpty(model.realtime_count)) {
            textView2.setText("");
        } else {
            Long valueOf = Long.valueOf(model.realtime_count);
            Intrinsics.c(valueOf, "valueOf(model.realtime_count)");
            String a = LiveRoomUtils.a(valueOf.longValue());
            Intrinsics.c(a, "formatPriceForLiveList(j…Of(model.realtime_count))");
            textView2.setText(a);
        }
        if (!TextUtils.isEmpty(model.title)) {
            textView.setText(model.title);
        } else if (TextUtils.isEmpty(model.anchor.name)) {
            textView.setText("");
        } else {
            textView.setText(model.anchor.name);
        }
        ((View) objectRef.a).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveCurHotRedView$MCQGfbrF7eEAoiD6Lq3BRWR5VjM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveCurHotRedView.a(LiveCurHotRedView.this, model, view);
            }
        });
    }

    public final void a(BluedLiveListData bluedLiveListData, String str, String str2, List<BluedLiveListData> listData) {
        List<BluedLiveListData> list;
        Intrinsics.e(listData, "listData");
        Integer num = null;
        if (bluedLiveListData != null && (list = bluedLiveListData.carousel) != null) {
            num = Integer.valueOf(list.size());
        }
        LogUtils.d("bLog", Intrinsics.a("======= initLiveHotView ", (Object) num));
        this.b = str;
        this.c = str2;
        this.d = listData;
        this.e = bluedLiveListData;
        d();
    }

    public final void a(boolean z) {
        LiveAutoPlayView liveAutoPlayView = this.i;
        if (liveAutoPlayView != null) {
            Intrinsics.a(liveAutoPlayView);
            liveAutoPlayView.a(z);
        }
        LiveRedPlayView liveRedPlayView = this.j;
        if (liveRedPlayView != null) {
            Intrinsics.a(liveRedPlayView);
            liveRedPlayView.a(z);
        }
    }

    /* JADX WARN: Type inference failed for: r1v14, types: [T, java.lang.Object] */
    public final void b() {
        BluedLiveListData bluedLiveListData;
        LayoutLiveCurHotBinding binding = getBinding();
        int index = getIndex();
        ViewGroup viewGroup = (ViewGroup) binding.a.findViewById(R.id.live_hot_right);
        int childCount = viewGroup.getChildCount();
        int i = index;
        if (index >= childCount) {
            i = childCount - 1;
        }
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        int i3 = 0;
        while (true) {
            final int i4 = i3;
            if (i4 >= childCount) {
                return;
            }
            int i5 = i4 + 1;
            View childAt = viewGroup.getChildAt(i4);
            ImageView imageView = (ImageView) childAt.findViewById(R.id.iv_avatar);
            ImageView imageView2 = (ImageView) childAt.findViewById(R.id.iv_cover);
            ImageView imageView3 = (ImageView) childAt.findViewById(R.id.iv_lable);
            if (getData() != null) {
                BluedLiveListData data = getData();
                Intrinsics.a(data);
                if (data.carousel != null) {
                    BluedLiveListData data2 = getData();
                    Intrinsics.a(data2);
                    if (i4 < data2.carousel.size()) {
                        BluedLiveListData data3 = getData();
                        Intrinsics.a(data3);
                        if (data3.carousel.size() > 0) {
                            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                            BluedLiveListData data4 = getData();
                            Intrinsics.a(data4);
                            objectRef.a = data4.carousel.get(i4);
                            if (objectRef.a != 0) {
                                EventTrackLive.a(LiveProtos.Event.LIVE_ROOM_SHOW, getTabId(), ((BluedLiveListData) objectRef.a).lid, ((BluedLiveListData) objectRef.a).uid, false, i5, "0");
                                T t = objectRef.a;
                                Intrinsics.a(t);
                                ImageLoader.a((IRequestHost) null, ((BluedLiveListData) t).pic_url).a(UiUtils.a(getContext(), 85.0f), UiUtils.a(getContext(), 85.0f)).a(imageView);
                                if (i4 == i2) {
                                    imageView2.setVisibility(0);
                                    ImageLoader.c(null, "live_hot_view_anim.png").g().g(-1).a(imageView2);
                                    imageView3.setVisibility(0);
                                    int i6 = i5 < 0 ? 0 : i5;
                                    BluedLiveListData data5 = getData();
                                    Intrinsics.a(data5);
                                    if (i6 >= data5.carousel.size()) {
                                        BluedLiveListData data6 = getData();
                                        Intrinsics.a(data6);
                                        bluedLiveListData = data6.carousel.get(0);
                                    } else {
                                        BluedLiveListData data7 = getData();
                                        Intrinsics.a(data7);
                                        bluedLiveListData = data7.carousel.get(i6);
                                    }
                                    T model = objectRef.a;
                                    Intrinsics.c(model, "model");
                                    a((BluedLiveListData) model, bluedLiveListData);
                                } else {
                                    imageView2.setVisibility(8);
                                    imageView3.setVisibility(8);
                                }
                                childAt.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.view.-$$Lambda$LiveCurHotRedView$YXzGaDOdBGCRNTRMmU6f1lUz0nU
                                    @Override // android.view.View.OnClickListener
                                    public final void onClick(View view) {
                                        LiveCurHotRedView.a(LiveCurHotRedView.this, objectRef, i4, view);
                                    }
                                });
                            }
                        }
                    }
                }
            }
            i3 = i5;
        }
    }

    @Override // com.blued.android.module.live_china.view.LiveListAutoPlay
    public boolean c() {
        EventCallback eventCallback = this.l;
        if (eventCallback != null) {
            Intrinsics.a(eventCallback);
            eventCallback.a();
            return true;
        }
        return true;
    }

    public final void d() {
        Log.i("==xpmm", "startScroll");
        b();
        AppInfo.n().removeCallbacks(this.k);
        if (this.f) {
            AppInfo.n().postDelayed(this.k, 5000L);
        }
    }

    public final void e() {
        Log.i("==xpmm", "stopScroll");
        this.f = false;
        AppInfo.n().removeCallbacks(this.k);
    }

    public final void f() {
        LiveAutoPlayView liveAutoPlayView = this.i;
        if (liveAutoPlayView != null) {
            Intrinsics.a(liveAutoPlayView);
            liveAutoPlayView.b();
        }
        LiveRedPlayView liveRedPlayView = this.j;
        if (liveRedPlayView != null) {
            Intrinsics.a(liveRedPlayView);
            liveRedPlayView.b();
        }
    }

    public final void g() {
        LiveAutoPlayView liveAutoPlayView = this.i;
        if (liveAutoPlayView != null) {
            Intrinsics.a(liveAutoPlayView);
            liveAutoPlayView.c();
        }
        LiveRedPlayView liveRedPlayView = this.j;
        if (liveRedPlayView != null) {
            Intrinsics.a(liveRedPlayView);
            liveRedPlayView.c();
        }
    }

    public final LayoutLiveCurHotBinding getBinding() {
        return (LayoutLiveCurHotBinding) this.a.getValue();
    }

    public final boolean getCanPlay() {
        return this.f;
    }

    public final String getComeCode() {
        return this.b;
    }

    public final BluedLiveListData getData() {
        return this.e;
    }

    public final int getIndex() {
        return this.g;
    }

    public final List<BluedLiveListData> getListData() {
        return this.d;
    }

    public final LiveAutoPlayView getPlayView() {
        return this.i;
    }

    public final Runnable getRunnable() {
        return this.k;
    }

    public final LiveRedPlayView getSecondPlayView() {
        return this.j;
    }

    public final int getTOTAL_COUNT() {
        return this.h;
    }

    public final String getTabId() {
        return this.c;
    }

    public final boolean h() {
        LiveAutoPlayView liveAutoPlayView = this.i;
        if (liveAutoPlayView != null) {
            Intrinsics.a(liveAutoPlayView);
            return liveAutoPlayView.e();
        }
        LiveRedPlayView liveRedPlayView = this.j;
        if (liveRedPlayView != null) {
            Intrinsics.a(liveRedPlayView);
            return liveRedPlayView.e();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setEventCallback(null);
        e();
    }

    public final void setCanPlay(boolean z) {
        this.f = z;
    }

    public final void setComeCode(String str) {
        this.b = str;
    }

    public final void setData(BluedLiveListData bluedLiveListData) {
        this.e = bluedLiveListData;
    }

    public final void setEventCallback(EventCallback eventCallback) {
        this.l = eventCallback;
    }

    public final void setIndex(int i) {
        this.g = i;
    }

    public final void setListData(List<BluedLiveListData> list) {
        this.d = list;
    }

    public final void setPlayEnable(boolean z) {
        this.f = z;
        if (z) {
            d();
        } else {
            e();
        }
    }

    public final void setPlayView(LiveAutoPlayView liveAutoPlayView) {
        this.i = liveAutoPlayView;
    }

    public final void setRunnable(Runnable runnable) {
        Intrinsics.e(runnable, "<set-?>");
        this.k = runnable;
    }

    public final void setSecondPlayView(LiveRedPlayView liveRedPlayView) {
        this.j = liveRedPlayView;
    }

    public final void setTOTAL_COUNT(int i) {
        this.h = i;
    }

    public final void setTabId(String str) {
        this.c = str;
    }
}
