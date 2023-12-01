package com.blued.android.module.live_china.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PointF;
import android.os.BatteryManager;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import com.blued.android.chat.core.pack.ReqAckPackage;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.common.utils.freedom.FreedomAdapter;
import com.blued.android.module.live.base.view.subscaleview.ImageSource;
import com.blued.android.module.live.base.view.subscaleview.ImageViewState;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.FragmentLiveBattleShopBinding;
import com.blued.android.module.live_china.databinding.LiveBattleAdvanceBinding;
import com.blued.android.module.live_china.databinding.LiveBattleAdvanceOneLineBinding;
import com.blued.android.module.live_china.databinding.LiveBattleAdvanceOnlyBinding;
import com.blued.android.module.live_china.databinding.LiveBattleBuyDialogBinding;
import com.blued.android.module.live_china.databinding.LiveBattleBuyReceiveBinding;
import com.blued.android.module.live_china.databinding.LiveBattleBuyTipBinding;
import com.blued.android.module.live_china.databinding.LiveBattleReceiveBinding;
import com.blued.android.module.live_china.fitem.FitemBattlePassAward;
import com.blued.android.module.live_china.fragment.LiveBattleShopDialog;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveBattleGiftExtra;
import com.blued.android.module.live_china.model.LiveBattleGiftModel;
import com.blued.android.module.live_china.model.LiveBattleGiftReceiveModel;
import com.blued.android.module.live_china.model.LiveBattleUnlockExtra;
import com.blued.android.module.live_china.msg.LiveEventBusUtil;
import com.blued.android.module.live_china.same.tip.CommonAlertDialog;
import com.blued.android.module.live_china.utils.LiveGiftPayTools;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.log.EventTrackLive;
import com.blued.android.module.live_china.view.BluedViewExKt;
import com.blued.android.module.live_china.view.LiveFrameLayoutExKt;
import com.blued.android.module.live_china.view.SpacesItemDecoration;
import com.blued.android.module.svgaplayer.SVGAImageView;
import com.blued.android.module.svgaplayer.SVGAParser;
import com.blued.android.module.svgaplayer.SVGAVideoEntity;
import com.blued.das.live.LiveProtos;
import com.igexin.push.config.c;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBattleShopDialog.class */
public final class LiveBattleShopDialog extends BaseFullScreenDialog {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f12741a = new Companion(null);
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f12742c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private boolean t;
    private boolean u;
    private boolean v;
    private String i = "";
    private final Lazy j = LazyKt.a(new Function0<FragmentLiveBattleShopBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final FragmentLiveBattleShopBinding invoke() {
            return FragmentLiveBattleShopBinding.a(LayoutInflater.from(LiveBattleShopDialog.this.getContext()), null, false);
        }
    });
    private final Lazy k = LazyKt.a(new Function0<LiveBattleBuyDialogBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$tag1VB$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveBattleBuyDialogBinding invoke() {
            return LiveBattleBuyDialogBinding.a(LayoutInflater.from(LiveBattleShopDialog.this.getContext()), null, false);
        }
    });
    private final Lazy l = LazyKt.a(new Function0<LiveBattleBuyReceiveBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$tag2VB$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveBattleBuyReceiveBinding invoke() {
            return LiveBattleBuyReceiveBinding.a(LayoutInflater.from(LiveBattleShopDialog.this.getContext()), null, false);
        }
    });
    private final Lazy m = LazyKt.a(new Function0<LiveBattleReceiveBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$tag3VB$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveBattleReceiveBinding invoke() {
            return LiveBattleReceiveBinding.a(LayoutInflater.from(LiveBattleShopDialog.this.getContext()), null, false);
        }
    });
    private final Lazy n = LazyKt.a(new Function0<LiveBattleAdvanceBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$tag4VB$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveBattleAdvanceBinding invoke() {
            return LiveBattleAdvanceBinding.a(LayoutInflater.from(LiveBattleShopDialog.this.getContext()), null, false);
        }
    });
    private final Lazy o = LazyKt.a(new Function0<LiveBattleAdvanceOneLineBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$tag4_1VB$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveBattleAdvanceOneLineBinding invoke() {
            return LiveBattleAdvanceOneLineBinding.a(LayoutInflater.from(LiveBattleShopDialog.this.getContext()), null, false);
        }
    });
    private final Lazy p = LazyKt.a(new Function0<LiveBattleAdvanceOnlyBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$tag5VB$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveBattleAdvanceOnlyBinding invoke() {
            return LiveBattleAdvanceOnlyBinding.a(LayoutInflater.from(LiveBattleShopDialog.this.getContext()), null, false);
        }
    });
    private final Lazy q = LazyKt.a(new Function0<LiveBattleBuyTipBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$tag6VB$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final LiveBattleBuyTipBinding invoke() {
            return LiveBattleBuyTipBinding.a(LayoutInflater.from(LiveBattleShopDialog.this.getContext()), null, false);
        }
    });
    private int r = 4;
    private long s = c.j;
    private Runnable w = new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$LRMrYtYQNE0uDYKuCBjfImKduxw
        @Override // java.lang.Runnable
        public final void run() {
            LiveBattleShopDialog.k(LiveBattleShopDialog.this);
        }
    };
    private final String x = "@\\(word:([\\s\\S]*?)\\)";
    private Pattern y = Pattern.compile("@\\(word:([\\s\\S]*?)\\)");

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBattleShopDialog$BannerPagerAdapter.class */
    public final class BannerPagerAdapter extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveBattleShopDialog f12743a;
        private Context b;

        /* renamed from: c  reason: collision with root package name */
        private List<View> f12744c;
        private List<List<LiveBattleGiftModel>> d;
        private IRequestHost e;

        public BannerPagerAdapter(LiveBattleShopDialog this$0) {
            Intrinsics.e(this$0, "this$0");
            this.f12743a = this$0;
            this.f12744c = new ArrayList();
            this.d = new ArrayList();
        }

        public final List<List<LiveBattleGiftModel>> a() {
            return this.d;
        }

        public final void a(Context context, IRequestHost iRequestHost, List<LiveBattleGiftModel> list) {
            this.b = context;
            this.e = iRequestHost;
            this.d.clear();
            if (list != null) {
                int i = 0;
                int i2 = -1;
                for (LiveBattleGiftModel liveBattleGiftModel : list) {
                    if (i % 4 == 0) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(liveBattleGiftModel);
                        a().add(arrayList);
                    } else {
                        List<LiveBattleGiftModel> list2 = i2 < a().size() ? a().get(i2) : null;
                        if (list2 == null) {
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(liveBattleGiftModel);
                            a().add(arrayList2);
                        } else {
                            list2.add(liveBattleGiftModel);
                            i++;
                        }
                    }
                    i2++;
                    i++;
                }
            }
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int i, Object object) {
            Intrinsics.e(container, "container");
            Intrinsics.e(object, "object");
            container.removeView((View) object);
        }

        public final Context getContext() {
            return this.b;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            List<List<LiveBattleGiftModel>> list = this.d;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object object) {
            Intrinsics.e(object, "object");
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int i) {
            Intrinsics.e(container, "container");
            List<LiveBattleGiftModel> list = this.d.get(i);
            while (this.f12744c.size() < this.d.size()) {
                View inflate = LayoutInflater.from(AppInfo.d()).inflate(R.layout.live_battle_view_pager_item_view, container, false);
                Intrinsics.c(inflate, "from(AppInfo.getAppConte…m_view, container, false)");
                this.f12744c.add(inflate);
            }
            View view = this.f12744c.get(i);
            if (view == null) {
                return view;
            }
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.b);
            linearLayoutManager.setOrientation(0);
            recyclerView.setLayoutManager(linearLayoutManager);
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            layoutParams.width = DensityUtils.a(this.b, list.size() * 57.0f);
            layoutParams.height = -1;
            recyclerView.setLayoutParams(layoutParams);
            LiveBattleGiftItemAdapter liveBattleGiftItemAdapter = new LiveBattleGiftItemAdapter(this.f12743a);
            liveBattleGiftItemAdapter.a(list, 2);
            recyclerView.setAdapter(liveBattleGiftItemAdapter);
            if (view.getParent() != null) {
                ((ViewGroup) view).removeView(view);
            }
            container.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            Intrinsics.e(view, "view");
            Intrinsics.e(object, "object");
            return view == object;
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBattleShopDialog$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Fragment fragment) {
            Intrinsics.e(fragment, "fragment");
            LiveBattleShopDialog liveBattleShopDialog = new LiveBattleShopDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("flag", 2);
            liveBattleShopDialog.setArguments(bundle);
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "fragment.getChildFragmentManager()");
            liveBattleShopDialog.show(childFragmentManager, "LiveBattleDialog");
        }

        public final void a(Fragment fragment, int i) {
            Intrinsics.e(fragment, "fragment");
            LiveBattleShopDialog liveBattleShopDialog = new LiveBattleShopDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("flag", 4);
            bundle.putInt(DBDefinition.TASK_ID, i);
            liveBattleShopDialog.setArguments(bundle);
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "fragment.getChildFragmentManager()");
            liveBattleShopDialog.show(childFragmentManager, "LiveBattleDialog");
        }

        public final void a(Fragment fragment, int i, int i2) {
            Intrinsics.e(fragment, "fragment");
            LiveBattleShopDialog liveBattleShopDialog = new LiveBattleShopDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("flag", 2);
            bundle.putInt("step", i);
            bundle.putInt(BatteryManager.EXTRA_LEVEL, i2);
            liveBattleShopDialog.setArguments(bundle);
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "fragment.getChildFragmentManager()");
            liveBattleShopDialog.show(childFragmentManager, "LiveBattleDialog");
        }

        public final void a(Fragment fragment, String picUrl) {
            Intrinsics.e(fragment, "fragment");
            Intrinsics.e(picUrl, "picUrl");
            LiveBattleShopDialog liveBattleShopDialog = new LiveBattleShopDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("flag", 5);
            bundle.putString("picUrl", picUrl);
            liveBattleShopDialog.setArguments(bundle);
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "fragment.getChildFragmentManager()");
            liveBattleShopDialog.show(childFragmentManager, "LiveBattleDialog");
        }

        public final void b(Fragment fragment) {
            Intrinsics.e(fragment, "fragment");
            LiveBattleShopDialog liveBattleShopDialog = new LiveBattleShopDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("flag", 3);
            liveBattleShopDialog.setArguments(bundle);
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "fragment.getChildFragmentManager()");
            liveBattleShopDialog.show(childFragmentManager, "LiveBattleDialog");
        }

        public final void b(Fragment fragment, int i, int i2) {
            Intrinsics.e(fragment, "fragment");
            LiveBattleShopDialog liveBattleShopDialog = new LiveBattleShopDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("flag", 1);
            bundle.putInt("type", i);
            bundle.putInt(ReqAckPackage.REQ_RESPONSE_KEY.BEANS, i2);
            liveBattleShopDialog.setArguments(bundle);
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.c(childFragmentManager, "fragment.getChildFragmentManager()");
            liveBattleShopDialog.show(childFragmentManager, "LiveBattleDialog");
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveBattleShopDialog$LiveBattleGiftItemAdapter.class */
    public final class LiveBattleGiftItemAdapter extends CommonRecycleAdapter<LiveBattleGiftModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveBattleShopDialog f12745a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f12746c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LiveBattleGiftItemAdapter(LiveBattleShopDialog this$0) {
            super(this$0.getContext());
            Intrinsics.e(this$0, "this$0");
            this.f12745a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a4, code lost:
            if (r0.length() == 0) goto L25;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static final void a(com.blued.android.module.live_china.model.LiveBattleGiftModel r5, com.blued.android.module.live_china.fragment.LiveBattleShopDialog r6, kotlin.jvm.internal.Ref.ObjectRef r7, kotlin.jvm.internal.Ref.ObjectRef r8, android.view.View r9) {
            /*
                r0 = r5
                java.lang.String r1 = "$item"
                kotlin.jvm.internal.Intrinsics.e(r0, r1)
                r0 = r6
                java.lang.String r1 = "this$0"
                kotlin.jvm.internal.Intrinsics.e(r0, r1)
                r0 = r7
                java.lang.String r1 = "$rootView"
                kotlin.jvm.internal.Intrinsics.e(r0, r1)
                r0 = r8
                java.lang.String r1 = "$from"
                kotlin.jvm.internal.Intrinsics.e(r0, r1)
                com.blued.android.module.live_china.model.BattlePassLevelAwardDataModel r0 = new com.blued.android.module.live_china.model.BattlePassLevelAwardDataModel
                r1 = r0
                r1.<init>()
                r9 = r0
                r0 = r9
                r1 = r5
                java.lang.String r1 = r1.getBubble_title()
                r0.setBubble_title(r1)
                r0 = r9
                r1 = r5
                java.lang.String r1 = r1.getBubble_desc()
                r0.setBubble_desc(r1)
                r0 = r9
                r1 = r5
                java.lang.String r1 = r1.getBubble_url()
                r0.setBubble_url(r1)
                r0 = r9
                java.lang.String r0 = r0.getBubble_url()
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r5 = r0
                r0 = 0
                r11 = r0
                r0 = r5
                if (r0 == 0) goto L5e
                r0 = r5
                int r0 = r0.length()
                if (r0 != 0) goto L58
                goto L5e
            L58:
                r0 = 0
                r10 = r0
                goto L61
            L5e:
                r0 = 1
                r10 = r0
            L61:
                r0 = r10
                if (r0 != 0) goto Ld9
                r0 = r9
                java.lang.String r0 = r0.getBubble_title()
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L85
                r0 = r5
                int r0 = r0.length()
                if (r0 != 0) goto L7f
                goto L85
            L7f:
                r0 = 0
                r10 = r0
                goto L88
            L85:
                r0 = 1
                r10 = r0
            L88:
                r0 = r10
                if (r0 != 0) goto Ld9
                r0 = r9
                java.lang.String r0 = r0.getBubble_desc()
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r5 = r0
                r0 = r5
                if (r0 == 0) goto La7
                r0 = r11
                r10 = r0
                r0 = r5
                int r0 = r0.length()
                if (r0 != 0) goto Laa
            La7:
                r0 = 1
                r10 = r0
            Laa:
                r0 = r10
                if (r0 != 0) goto Ld9
                r0 = r6
                android.content.Context r0 = r0.getContext()
                r5 = r0
                r0 = r5
                kotlin.jvm.internal.Intrinsics.a(r0)
                r0 = r5
                java.lang.String r1 = "context!!"
                kotlin.jvm.internal.Intrinsics.c(r0, r1)
                com.blued.android.module.live_china.pop.LiveBattlePassAwardTipPop r0 = new com.blued.android.module.live_china.pop.LiveBattlePassAwardTipPop
                r1 = r0
                r2 = r5
                r3 = r9
                r1.<init>(r2, r3)
                r1 = r7
                T r1 = r1.f42545a
                android.view.View r1 = (android.view.View) r1
                r2 = r8
                T r2 = r2.f42545a
                java.lang.String r2 = (java.lang.String) r2
                r0.a(r1, r2)
            Ld9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveBattleShopDialog.LiveBattleGiftItemAdapter.a(com.blued.android.module.live_china.model.LiveBattleGiftModel, com.blued.android.module.live_china.fragment.LiveBattleShopDialog, kotlin.jvm.internal.Ref$ObjectRef, kotlin.jvm.internal.Ref$ObjectRef, android.view.View):void");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v131, types: [T, android.view.View] */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(final LiveBattleGiftModel item, int i, CommonRecycleAdapter.CommonAdapterHolder helper) {
            Intrinsics.e(item, "item");
            Intrinsics.e(helper, "helper");
            ViewGroup.LayoutParams layoutParams = helper.a(R.id.fl_main).getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.f42545a = "";
            int i2 = this.b;
            if (i2 == 0) {
                objectRef.f42545a = this.f12746c ? "extra" : "top_pop";
                marginLayoutParams.width = DensityUtils.a(this.f12745a.getContext(), 54.0f);
                marginLayoutParams.height = DensityUtils.a(this.f12745a.getContext(), 54.0f);
                marginLayoutParams.rightMargin = DensityUtils.a(this.f12745a.getContext(), 0.0f);
                helper.a(R.id.fl_main).setBackgroundResource(R.drawable.live_battle_gift_item_bg);
                helper.a(R.id.iv_lock).setVisibility(8);
                ViewGroup.LayoutParams layoutParams2 = helper.a(R.id.ll_root).getLayoutParams();
                if (layoutParams2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.width = DensityUtils.a(this.f12745a.getContext(), 63.0f);
                marginLayoutParams2.height = DensityUtils.a(this.f12745a.getContext(), 63.0f);
                helper.a(R.id.ll_root).setLayoutParams(marginLayoutParams2);
            } else if (i2 == 1) {
                objectRef.f42545a = "basic_pop_done";
                marginLayoutParams.width = DensityUtils.a(this.f12745a.getContext(), 54.0f);
                marginLayoutParams.height = DensityUtils.a(this.f12745a.getContext(), 54.0f);
                marginLayoutParams.rightMargin = DensityUtils.a(this.f12745a.getContext(), 0.0f);
                helper.a(R.id.fl_main).setBackgroundResource(R.drawable.live_battle_gift_item_blue_bg);
                helper.a(R.id.iv_lock).setVisibility(8);
            } else if (i2 == 2) {
                objectRef.f42545a = "basic_pop_top";
                marginLayoutParams.width = DensityUtils.a(this.f12745a.getContext(), 48.0f);
                marginLayoutParams.height = DensityUtils.a(this.f12745a.getContext(), 48.0f);
                helper.a(R.id.fl_main).setBackgroundResource(R.drawable.live_battle_gift_item_advance_bg);
                helper.a(R.id.iv_lock).setVisibility(0);
                ViewGroup.LayoutParams layoutParams3 = helper.a(R.id.ll_root).getLayoutParams();
                if (layoutParams3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                }
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                marginLayoutParams3.width = marginLayoutParams.width + DensityUtils.a(this.f12745a.getContext(), 9.0f);
                marginLayoutParams3.height = marginLayoutParams.height;
                helper.a(R.id.ll_root).setLayoutParams(marginLayoutParams3);
            } else if (i2 == 3) {
                objectRef.f42545a = "top_done";
                marginLayoutParams.width = DensityUtils.a(this.f12745a.getContext(), 54.0f);
                marginLayoutParams.height = DensityUtils.a(this.f12745a.getContext(), 54.0f);
                marginLayoutParams.rightMargin = DensityUtils.a(this.f12745a.getContext(), 0.0f);
                helper.a(R.id.fl_main).setBackgroundResource(R.drawable.live_battle_gift_item_yellow_bg);
                helper.a(R.id.iv_lock).setVisibility(8);
            } else if (i2 == 4) {
                objectRef.f42545a = "top_todo";
                marginLayoutParams.width = DensityUtils.a(this.f12745a.getContext(), 48.0f);
                marginLayoutParams.height = DensityUtils.a(this.f12745a.getContext(), 48.0f);
                marginLayoutParams.rightMargin = DensityUtils.a(this.f12745a.getContext(), 0.0f);
                helper.a(R.id.fl_main).setBackgroundResource(R.drawable.live_battle_gift_item_advance_bg);
                helper.a(R.id.iv_lock).setVisibility(0);
            } else if (i2 == 5) {
                objectRef.f42545a = "top_todo";
                marginLayoutParams.width = DensityUtils.a(this.f12745a.getContext(), 48.0f);
                marginLayoutParams.height = DensityUtils.a(this.f12745a.getContext(), 48.0f);
                marginLayoutParams.rightMargin = DensityUtils.a(this.f12745a.getContext(), 0.0f);
                helper.a(R.id.fl_main).setBackgroundResource(R.drawable.live_battle_gift_item_yellow_bg);
                helper.a(R.id.iv_lock).setVisibility(8);
            }
            if (item.getBonus() == 1) {
                helper.a(R.id.iv_extra).setVisibility(0);
            } else {
                helper.a(R.id.iv_extra).setVisibility(8);
            }
            helper.a(R.id.fl_main).setLayoutParams(marginLayoutParams);
            ImageView imageView = (ImageView) helper.a(R.id.iv_pic);
            ViewGroup.LayoutParams layoutParams4 = imageView.getLayoutParams();
            layoutParams4.width = marginLayoutParams.width - DensityUtils.a(this.f12745a.getContext(), 4.0f);
            layoutParams4.height = marginLayoutParams.height - DensityUtils.a(this.f12745a.getContext(), 4.0f);
            imageView.setLayoutParams(layoutParams4);
            ImageLoader.a(this.f12745a.a(), item.getIcon()).a((ImageView) helper.a(R.id.iv_pic));
            String label = item.getLabel();
            boolean z = true;
            if (label != null) {
                z = label.length() == 0;
            }
            if (z) {
                TextView textView = (TextView) helper.a(R.id.tv_num);
                Intrinsics.c(textView, "helper?.getView<TextView>(R.id.tv_num)");
                BluedViewExKt.a(textView);
                View a2 = helper.a(R.id.iv_num_background);
                Intrinsics.c(a2, "helper?.getView<View>(R.id.iv_num_background)");
                BluedViewExKt.a(a2);
            } else {
                TextView textView2 = (TextView) helper.a(R.id.tv_num);
                Intrinsics.c(textView2, "helper?.getView<TextView>(R.id.tv_num)");
                BluedViewExKt.b(textView2);
                ((TextView) helper.a(R.id.tv_num)).setText(item.getLabel());
                View a3 = helper.a(R.id.iv_num_background);
                Intrinsics.c(a3, "helper?.getView<View>(R.id.iv_num_background)");
                BluedViewExKt.b(a3);
            }
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            objectRef2.f42545a = helper.a(R.id.ll_root);
            final LiveBattleShopDialog liveBattleShopDialog = this.f12745a;
            ((View) objectRef2.f42545a).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$LiveBattleGiftItemAdapter$ZuHJksI4A6SbXpnP2qkbjx0qXTg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveBattleShopDialog.LiveBattleGiftItemAdapter.a(LiveBattleGiftModel.this, liveBattleShopDialog, objectRef2, objectRef, view);
                }
            });
        }

        public final void a(List<LiveBattleGiftModel> datas, int i) {
            Intrinsics.e(datas, "datas");
            this.b = i;
            setDataAndNotify(datas);
        }

        public final void a(boolean z) {
            this.f12746c = z;
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return R.layout.live_battle_gift_item;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private final CharSequence a(CharSequence charSequence, String str, boolean z) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, String str) {
        if (i == 4221008) {
            l();
            return;
        }
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        AppMethods.a((CharSequence) str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveBattleShopDialog this$0, DialogInterface dialogInterface) {
        Intrinsics.e(this$0, "this$0");
        this$0.v = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveBattleShopDialog this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.v = false;
        LiveRoomInfo.a().a(this$0.getContext(), this$0.getChildFragmentManager(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveBattleShopDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(String.valueOf(this$0.f12742c));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveBattleShopDialog this$0, Ref.ObjectRef bannerPagerAdapter, View view) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(bannerPagerAdapter, "$bannerPagerAdapter");
        LiveBattleReceiveBinding s = this$0.s();
        int currentItem = (s == null ? null : s.h).getCurrentItem() + 1;
        int i = currentItem;
        if (currentItem > ((BannerPagerAdapter) bannerPagerAdapter.f42545a).getCount() - 1) {
            i = ((BannerPagerAdapter) bannerPagerAdapter.f42545a).getCount() - 1;
        }
        LiveBattleReceiveBinding s2 = this$0.s();
        (s2 == null ? null : s2.h).setCurrentItem(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ref.ObjectRef type, int i, Ref.BooleanRef isHasExtraAward, LiveBattleShopDialog this$0, View view) {
        Intrinsics.e(type, "$type");
        Intrinsics.e(isHasExtraAward, "$isHasExtraAward");
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.a(LiveProtos.Event.LIVE_BATTLE_PASS_TOP_POP_YES_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), (String) type.f42545a, i == 1, isHasExtraAward.f42538a);
        this$0.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ref.ObjectRef type, LiveBattleShopDialog this$0, View view) {
        Intrinsics.e(type, "$type");
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.c(LiveProtos.Event.LIVE_BATTLE_PASS_BASIC_POP_YES_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), (String) type.f42545a);
        this$0.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveBattleShopDialog this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.e(this$0, "this$0");
        this$0.v = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveBattleShopDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Ref.ObjectRef type, LiveBattleShopDialog this$0, View view) {
        Intrinsics.e(type, "$type");
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.c(LiveProtos.Event.LIVE_BATTLE_PASS_BASIC_POP_BUY_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), (String) type.f42545a);
        this$0.c(false);
        this$0.b = 3;
        this$0.j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(LiveBattleShopDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        LiveBattleReceiveBinding s = this$0.s();
        int currentItem = (s == null ? null : s.h).getCurrentItem() - 1;
        int i = currentItem;
        if (currentItem < 0) {
            i = 0;
        }
        LiveBattleReceiveBinding s2 = this$0.s();
        (s2 == null ? null : s2.h).setCurrentItem(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(LiveBattleShopDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(LiveBattleShopDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(LiveBattleShopDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(LiveBattleShopDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(final LiveBattleShopDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        SVGAParser.a(SVGAParser.f15958a.b(), "live_battle_backlight.svga", new SVGAParser.ParseCompletion() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$setTag2Data$4$1
            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onComplete(SVGAVideoEntity videoItem) {
                LiveBattleBuyReceiveBinding r;
                LiveBattleBuyReceiveBinding r2;
                Intrinsics.e(videoItem, "videoItem");
                r = LiveBattleShopDialog.this.r();
                r.g.setVideoItem(videoItem);
                r2 = LiveBattleShopDialog.this.r();
                r2.g.a(0, true);
            }

            @Override // com.blued.android.module.svgaplayer.SVGAParser.ParseCompletion
            public void onError() {
            }
        }, (SVGAParser.PlayCallback) null, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(LiveBattleShopDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(LiveBattleShopDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        ImageLoader.c(this$0.a(), "live_battle_scatter_flower.png").g().g(-1).a(this$0.r().b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(LiveBattleShopDialog this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(final LiveBattleShopDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.f42543a = this$0.v().b.getWidth();
        final ImageSize imageSize = new ImageSize();
        ImageFileLoader.a(this$0.a()).a(this$0.i).a(imageSize).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$setTag7Data$2$1
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public void onUIFinish(File file, Exception exc) {
                LiveBattleBuyTipBinding v;
                LiveBattleBuyTipBinding v2;
                if (file == null || !file.exists()) {
                    return;
                }
                v = LiveBattleShopDialog.this.v();
                v.b.setZoomEnabled(false);
                float a2 = imageSize.a();
                float f = 1.0f;
                if (intRef.f42543a > 0) {
                    f = 1.0f;
                    if (a2 > 0.0f) {
                        f = (intRef.f42543a * 1.0f) / a2;
                    }
                }
                v2 = LiveBattleShopDialog.this.v();
                v2.b.a(ImageSource.b(file.getAbsolutePath()), new ImageViewState(f, new PointF(0.0f, 0.0f), 0));
            }
        }).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(LiveBattleShopDialog this$0) {
        Intrinsics.e(this$0, "this$0");
        this$0.p().f11918a.setVisibility(0);
    }

    private final void o() {
        int i = this.b;
        if (i == 1) {
            x();
        } else if (i == 2) {
            a(String.valueOf(this.e), String.valueOf(this.d));
        } else if (i == 3) {
            j();
        } else if (i == 4) {
            b(String.valueOf(this.g));
        } else if (i == 5) {
            f();
        }
    }

    private final FragmentLiveBattleShopBinding p() {
        return (FragmentLiveBattleShopBinding) this.j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveBattleBuyDialogBinding q() {
        return (LiveBattleBuyDialogBinding) this.k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveBattleBuyReceiveBinding r() {
        return (LiveBattleBuyReceiveBinding) this.l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveBattleReceiveBinding s() {
        return (LiveBattleReceiveBinding) this.m.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveBattleAdvanceBinding t() {
        return (LiveBattleAdvanceBinding) this.n.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveBattleAdvanceOnlyBinding u() {
        return (LiveBattleAdvanceOnlyBinding) this.p.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveBattleBuyTipBinding v() {
        return (LiveBattleBuyTipBinding) this.q.getValue();
    }

    private final void w() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return;
        }
        this.b = arguments.getInt("flag", 0);
        this.f12742c = arguments.getInt("type", 0);
        this.e = arguments.getInt("step", 0);
        this.d = arguments.getInt(BatteryManager.EXTRA_LEVEL, 0);
        this.f = arguments.getInt(ReqAckPackage.REQ_RESPONSE_KEY.BEANS, 0);
        this.g = arguments.getInt(DBDefinition.TASK_ID, 0);
        String string = arguments.getString("picUrl", "");
        Intrinsics.c(string, "it.getString(\"picUrl\", \"\")");
        this.i = string;
        if (this.d == 0 && this.e == 0) {
            b(true);
        } else {
            b(false);
        }
    }

    private final void x() {
        boolean z = true;
        if (this.f12742c != 1) {
            z = false;
        }
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.a(z, new BluedUIHttpResponse<BluedEntity<LiveBattleGiftModel, LiveBattleUnlockExtra>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$getUnlockLevelData$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveBattleGiftModel, LiveBattleUnlockExtra> bluedEntity) {
                Intrinsics.e(bluedEntity, "bluedEntity");
                LiveBattleShopDialog.this.f = bluedEntity.extra.getUnlock_price();
                LiveBattleShopDialog.this.a(bluedEntity.data);
            }
        }, a());
    }

    public final View a(View view) {
        Intrinsics.e(view, "view");
        if (view.getParent() instanceof ViewGroup) {
            ViewParent parent = view.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(view);
                return view;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        return view;
    }

    public final void a(RecyclerView view, float f, float f2, int i, int i2, int i3) {
        Intrinsics.e(view, "view");
        if (i == 0) {
            return;
        }
        float f3 = f2 / 2;
        SpacesItemDecoration spacesItemDecoration = new SpacesItemDecoration(DensityUtils.a(getContext(), f3), DensityUtils.a(getContext(), f3), DensityUtils.a(getContext(), f3), DensityUtils.a(getContext(), f3));
        spacesItemDecoration.a(true, true, true, true);
        spacesItemDecoration.a(5);
        view.addItemDecoration(spacesItemDecoration);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            int i4 = this.r;
            if (i <= i4) {
                i4 = i;
            }
            if (i4 > 0) {
                float f4 = i4;
                layoutParams.width = DensityUtils.a(AppInfo.d(), f * f4) + DensityUtils.a(AppInfo.d(), f2 * f4);
            }
            view.setLayoutManager(new GridLayoutManager(getContext(), i4));
            if (i <= i2) {
                layoutParams.height = -2;
            } else if (i3 == 0) {
                layoutParams.height = -1;
            } else {
                layoutParams.height = i3;
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public final void a(LiveBattleGiftModel liveBattleGiftModel) {
        LiveBattleGiftModel liveBattleGiftModel2 = liveBattleGiftModel;
        if (liveBattleGiftModel == null) {
            liveBattleGiftModel2 = new LiveBattleGiftModel();
        }
        FrameLayout frameLayout = p().b;
        Intrinsics.c(frameLayout, "vb.contentView");
        LiveFrameLayoutExKt.a(frameLayout, new Function1<FrameLayout, Unit>() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$setTag6Data$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(FrameLayout toAddView) {
                LiveBattleBuyReceiveBinding r;
                Intrinsics.e(toAddView, "$this$toAddView");
                LiveBattleShopDialog liveBattleShopDialog = LiveBattleShopDialog.this;
                r = liveBattleShopDialog.r();
                RelativeLayout relativeLayout = r.e;
                Intrinsics.c(relativeLayout, "tag2VB.root");
                toAddView.addView(liveBattleShopDialog.a(relativeLayout), -2, -2);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(FrameLayout frameLayout2) {
                a(frameLayout2);
                return Unit.f42314a;
            }
        });
        r().f.setVisibility(8);
        r().d.setVisibility(0);
        TextView textView = r().h;
        textView.setText(liveBattleGiftModel2.getExp() + AppInfo.d().getString(R.string.live_battle_experience));
        r().i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$XFytnZE4wyuOe8GDcBRB4SAMock
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattleShopDialog.h(LiveBattleShopDialog.this, view);
            }
        });
    }

    public final void a(String type) {
        Intrinsics.e(type, "type");
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.o(type, new BluedUIHttpResponse<BluedEntityA<LiveBattleGiftModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$unlock$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveBattleGiftModel> bluedEntity) {
                int i;
                Intrinsics.e(bluedEntity, "bluedEntity");
                if (bluedEntity.getSingleData() != null) {
                    LiveBattleShopDialog.this.h = bluedEntity.getSingleData().getExp();
                    i = LiveBattleShopDialog.this.h;
                    LiveEventBusUtil.d(i);
                }
                LiveBattleShopDialog.this.h();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                LiveBattleShopDialog.this.a(i, errorMessage);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveBattleShopDialog.this.n();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveBattleShopDialog.this.m();
            }
        }, a());
    }

    public final void a(String step, String level) {
        Intrinsics.e(step, "step");
        Intrinsics.e(level, "level");
        boolean z = this.u;
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.b(step, level, z, new BluedUIHttpResponse<BluedEntity<LiveBattleGiftReceiveModel, LiveBattleGiftExtra>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$receiveBattle$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                LiveBattleShopDialog.this.h();
                String str = errorMessage;
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                AppMethods.a((CharSequence) str);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveBattleShopDialog.this.n();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveBattleShopDialog.this.m();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveBattleGiftReceiveModel, LiveBattleGiftExtra> bluedEntity) {
                Intrinsics.e(bluedEntity, "bluedEntity");
                LiveBattleShopDialog.this.a(true);
                if (bluedEntity.getSingleData() == null) {
                    LiveBattleShopDialog.this.h();
                    return;
                }
                if (bluedEntity.getSingleData().getIncomming() != null) {
                    List<LiveBattleGiftModel> incomming = bluedEntity.getSingleData().getIncomming();
                    Intrinsics.a(incomming);
                    if (incomming.size() > 0) {
                        LiveBattleShopDialog.this.a(bluedEntity.getSingleData().getCurrent(), bluedEntity.getSingleData().getIncomming());
                        return;
                    }
                }
                LiveBattleShopDialog.this.a(bluedEntity.getSingleData().getCurrent(), bluedEntity.extra.getHas_bonus());
            }
        }, a());
    }

    public final void a(List<LiveBattleGiftModel> list) {
        FrameLayout frameLayout = p().b;
        Intrinsics.c(frameLayout, "vb.contentView");
        LiveFrameLayoutExKt.a(frameLayout, new Function1<FrameLayout, Unit>() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$setTag1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(FrameLayout toAddView) {
                LiveBattleBuyDialogBinding q;
                Intrinsics.e(toAddView, "$this$toAddView");
                LiveBattleShopDialog liveBattleShopDialog = LiveBattleShopDialog.this;
                q = liveBattleShopDialog.q();
                FrameLayout frameLayout2 = q.f12134c;
                Intrinsics.c(frameLayout2, "tag1VB.root");
                toAddView.addView(liveBattleShopDialog.a(frameLayout2), -2, -2);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(FrameLayout frameLayout2) {
                a(frameLayout2);
                return Unit.f42314a;
            }
        });
        String string = AppInfo.d().getString(R.string.live_battle_unlock_beans_1);
        Intrinsics.c(string, "getAppContext().getStrin…ve_battle_unlock_beans_1)");
        String string2 = AppInfo.d().getString(R.string.live_battle_unlock_beans_2);
        Intrinsics.c(string2, "getAppContext().getStrin…ve_battle_unlock_beans_2)");
        String string3 = AppInfo.d().getString(R.string.live_battle_unlock_beans_3);
        Intrinsics.c(string3, "getAppContext().getStrin…ve_battle_unlock_beans_3)");
        String string4 = AppInfo.d().getString(R.string.live_battle_unlock_beans_4);
        Intrinsics.c(string4, "getAppContext().getStrin…ve_battle_unlock_beans_4)");
        String valueOf = String.valueOf(this.f);
        if (this.f12742c == 1) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + valueOf + string2 + string3);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(AppInfo.d().getResources().getColor(R.color.syc_dark_ffef5f)), string.length(), string.length() + valueOf.length() + string2.length(), 33);
            q().e.setText(spannableStringBuilder);
            q().g.setText(AppInfo.d().getString(R.string.live_battle_unlock_one));
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(string + valueOf + string2 + string4);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(AppInfo.d().getResources().getColor(R.color.syc_dark_ffef5f)), string.length(), string.length() + valueOf.length() + string2.length(), 33);
            q().e.setText(spannableStringBuilder2);
            q().g.setText(AppInfo.d().getString(R.string.live_battle_unlock_all));
        }
        q().g.getPaint().setFakeBoldText(true);
        q().e.getPaint().setFakeBoldText(true);
        q().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$2oV3fR605jbd9cCLLOOIThGIfI4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattleShopDialog.a(LiveBattleShopDialog.this, view);
            }
        });
        q().f12133a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$0a0qdrmfhuRMFygyFwop_JeBn0k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattleShopDialog.b(LiveBattleShopDialog.this, view);
            }
        });
        List<LiveBattleGiftModel> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        ImageView imageView = q().h;
        Intrinsics.c(imageView, "tag1VB.viewLine");
        BluedViewExKt.b(imageView);
        TextView textView = q().f;
        Intrinsics.c(textView, "tag1VB.tvGiftTitle");
        BluedViewExKt.b(textView);
        q().f.getPaint().setFakeBoldText(true);
        RecyclerView recyclerView = q().d;
        Intrinsics.c(recyclerView, "tag1VB.rvList");
        BluedViewExKt.b(recyclerView);
        if (this.f12742c == 1) {
            q().f.setText("解锁下一等级可得奖励");
        }
        if (list.size() > 8) {
            q().d.getLayoutParams().height = DensityUtils.a(getContext(), 150.5f);
        }
        final ArrayList arrayList = new ArrayList();
        for (LiveBattleGiftModel liveBattleGiftModel : list) {
            arrayList.add(new FitemBattlePassAward(liveBattleGiftModel, this.f12742c == 1));
        }
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), list.size() < 4 ? list.size() : 4);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$setTag1$5
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                return arrayList.get(i).a(gridLayoutManager.getSpanCount());
            }
        });
        q().d.setLayoutManager(gridLayoutManager);
        q().d.setAdapter(new FreedomAdapter(getContext(), a(), arrayList));
    }

    public final void a(List<LiveBattleGiftModel> list, final int i) {
        WindowManager windowManager;
        Display defaultDisplay;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f42545a = "";
        if (this.u) {
            objectRef.f42545a = "all";
        } else {
            objectRef.f42545a = "one";
        }
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        for (LiveBattleGiftModel liveBattleGiftModel : arrayList) {
            if (liveBattleGiftModel.getBonus() == 1) {
                booleanRef.f42538a = true;
            }
        }
        EventTrackLive.a(LiveProtos.Event.LIVE_BATTLE_PASS_TOP_POP_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), (String) objectRef.f42545a, i == 1, booleanRef.f42538a);
        FrameLayout frameLayout = p().b;
        Intrinsics.c(frameLayout, "vb.contentView");
        LiveFrameLayoutExKt.a(frameLayout, new Function1<FrameLayout, Unit>() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$setTag2Data$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(FrameLayout toAddView) {
                LiveBattleBuyReceiveBinding r;
                Intrinsics.e(toAddView, "$this$toAddView");
                LiveBattleShopDialog liveBattleShopDialog = LiveBattleShopDialog.this;
                r = liveBattleShopDialog.r();
                RelativeLayout relativeLayout = r.e;
                Intrinsics.c(relativeLayout, "tag2VB.root");
                toAddView.addView(liveBattleShopDialog.a(relativeLayout), -2, -2);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(FrameLayout frameLayout2) {
                a(frameLayout2);
                return Unit.f42314a;
            }
        });
        LiveBattleGiftItemAdapter liveBattleGiftItemAdapter = new LiveBattleGiftItemAdapter(this);
        liveBattleGiftItemAdapter.a(booleanRef.f42538a);
        r().f.setAdapter(liveBattleGiftItemAdapter);
        RecyclerView recyclerView = r().f;
        Intrinsics.c(recyclerView, "tag2VB.rvList");
        a(recyclerView, 63.0f, 0.0f, arrayList.size(), 16, DensityUtils.a(AppInfo.d(), 270.0f));
        liveBattleGiftItemAdapter.setDataAndNotify(arrayList);
        r().i.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$MUOHCHYsFIYU15WU5DrB7VBth2c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattleShopDialog.a(Ref.ObjectRef.this, i, booleanRef, this, view);
            }
        });
        if (booleanRef.f42538a) {
            r().f12135a.setBackgroundResource(0);
            r().f12136c.setImageResource(R.drawable.live_battle_congrats_title);
            SVGAImageView sVGAImageView = r().g;
            Intrinsics.c(sVGAImageView, "tag2VB.svgBacklight");
            BluedViewExKt.b(sVGAImageView);
            r().g.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$BXVYDRNKt9H2HO8xXq5KHr9Y7ZA
                @Override // java.lang.Runnable
                public final void run() {
                    LiveBattleShopDialog.h(LiveBattleShopDialog.this);
                }
            });
            ImageView imageView = r().b;
            Intrinsics.c(imageView, "tag2VB.ivScatterFlower");
            BluedViewExKt.b(imageView);
            FragmentActivity activity = getActivity();
            Integer num = null;
            if (activity != null && (windowManager = activity.getWindowManager()) != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
                num = Integer.valueOf(defaultDisplay.getWidth());
            }
            Intrinsics.a(num);
            r().b.getLayoutParams().height = (int) ((num.intValue() / 375.0f) * 265.0f);
            r().b.setLayoutParams(r().b.getLayoutParams());
            r().b.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$j6tl3Y50cI6C4Wzo560Xs6tY60U
                @Override // java.lang.Runnable
                public final void run() {
                    LiveBattleShopDialog.i(LiveBattleShopDialog.this);
                }
            });
        }
    }

    public final void a(List<LiveBattleGiftModel> list, String title, String desc, String beans, boolean z) {
        Intrinsics.e(title, "title");
        Intrinsics.e(desc, "desc");
        Intrinsics.e(beans, "beans");
        EventTrackLive.a(LiveProtos.Event.LIVE_BATTLE_PASS_TOP_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
        }
        FrameLayout frameLayout = p().b;
        Intrinsics.c(frameLayout, "vb.contentView");
        LiveFrameLayoutExKt.a(frameLayout, new Function1<FrameLayout, Unit>() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$setTag5Data$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(FrameLayout toAddView) {
                LiveBattleAdvanceOnlyBinding u;
                Intrinsics.e(toAddView, "$this$toAddView");
                LiveBattleShopDialog liveBattleShopDialog = LiveBattleShopDialog.this;
                u = liveBattleShopDialog.u();
                FrameLayout frameLayout2 = u.d;
                Intrinsics.c(frameLayout2, "tag5VB.root");
                toAddView.addView(liveBattleShopDialog.a(frameLayout2), -2, -2);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(FrameLayout frameLayout2) {
                a(frameLayout2);
                return Unit.f42314a;
            }
        });
        RecyclerView recyclerView = u().e;
        Intrinsics.c(recyclerView, "tag5VB.rvListAdvance");
        a(recyclerView, 48.0f, 9.0f, arrayList.size(), 12, DensityUtils.a(AppInfo.d(), 0.0f));
        LiveBattleGiftItemAdapter liveBattleGiftItemAdapter = new LiveBattleGiftItemAdapter(this);
        u().e.setAdapter(liveBattleGiftItemAdapter);
        if (z) {
            liveBattleGiftItemAdapter.a(arrayList, 4);
            u().f12131c.setImageResource(R.drawable.live_battle_advance_to_get);
        } else {
            liveBattleGiftItemAdapter.a(arrayList, 5);
            u().f12131c.setImageResource(R.drawable.live_battle_advance_get);
        }
        u().h.setText(title);
        u().g.setText(desc);
        TextView textView = u().g;
        CharSequence text = u().g.getText();
        Intrinsics.c(text, "tag5VB.tvDesc.text");
        textView.setText(a(text, "#FFEF5F", true));
        u().f.setText(beans);
        u().b.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$BnHJpz0F4WOuzXJzu7zVmMoysG4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattleShopDialog.f(LiveBattleShopDialog.this, view);
            }
        });
        u().f12130a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$mSA-RQKO1_5hOTbo2WdkI8ET3Xs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattleShopDialog.g(LiveBattleShopDialog.this, view);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r1v15, types: [T, com.blued.android.module.live_china.fragment.LiveBattleShopDialog$BannerPagerAdapter] */
    public final void a(List<LiveBattleGiftModel> list, List<LiveBattleGiftModel> list2) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f42545a = "";
        if (this.u) {
            objectRef.f42545a = "all";
        } else {
            objectRef.f42545a = "one";
        }
        EventTrackLive.c(LiveProtos.Event.LIVE_BATTLE_PASS_BASIC_POP_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g(), (String) objectRef.f42545a);
        ArrayList arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
        }
        ArrayList arrayList2 = list2;
        if (list2 == null) {
            arrayList2 = new ArrayList();
        }
        FrameLayout frameLayout = p().b;
        Intrinsics.c(frameLayout, "vb.contentView");
        LiveFrameLayoutExKt.a(frameLayout, new Function1<FrameLayout, Unit>() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$setTag3Data$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(FrameLayout toAddView) {
                LiveBattleReceiveBinding s;
                Intrinsics.e(toAddView, "$this$toAddView");
                LiveBattleShopDialog liveBattleShopDialog = LiveBattleShopDialog.this;
                s = liveBattleShopDialog.s();
                FrameLayout frameLayout2 = s.f;
                Intrinsics.c(frameLayout2, "tag3VB.root");
                toAddView.addView(liveBattleShopDialog.a(frameLayout2), -2, -2);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(FrameLayout frameLayout2) {
                a(frameLayout2);
                return Unit.f42314a;
            }
        });
        LiveBattleGiftItemAdapter liveBattleGiftItemAdapter = new LiveBattleGiftItemAdapter(this);
        s().g.setAdapter(liveBattleGiftItemAdapter);
        RecyclerView recyclerView = s().g;
        Intrinsics.c(recyclerView, "tag3VB.rvList");
        a(recyclerView, 54.0f, 9.0f, arrayList.size(), 8, DensityUtils.a(AppInfo.d(), 146.0f));
        liveBattleGiftItemAdapter.a(arrayList, 1);
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.f42545a = new BannerPagerAdapter(this);
        LiveBattleReceiveBinding s = s();
        (s == null ? null : s.h).setAdapter((PagerAdapter) objectRef2.f42545a);
        ((BannerPagerAdapter) objectRef2.f42545a).a(getContext(), a(), arrayList2);
        ImageLoader.c(a(), "live_battle_box.png").g().g(-1).a(s().b);
        LiveBattleReceiveBinding s2 = s();
        (s2 == null ? null : s2.f12146c).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$9hUJvmI2WJKGa5_8WTYSm_oBOwg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattleShopDialog.c(LiveBattleShopDialog.this, view);
            }
        });
        LiveBattleReceiveBinding s3 = s();
        (s3 == null ? null : s3.e).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$irkYdSX-mwoN0XCoZXM1V0xNYGg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattleShopDialog.a(LiveBattleShopDialog.this, objectRef2, view);
            }
        });
        s().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$fZp_xuSzSb3mLIOdU1BYaJUndPo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattleShopDialog.a(Ref.ObjectRef.this, this, view);
            }
        });
        s().f12145a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$COh1zYQGu1mrFF2VNMs6kMhcC_s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattleShopDialog.b(Ref.ObjectRef.this, this, view);
            }
        });
    }

    public final void a(List<LiveBattleGiftModel> list, List<LiveBattleGiftModel> list2, String title, String desc, String beans) {
        Intrinsics.e(title, "title");
        Intrinsics.e(desc, "desc");
        Intrinsics.e(beans, "beans");
        EventTrackLive.a(LiveProtos.Event.LIVE_BATTLE_PASS_TOP_PAGE_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        if (list == null) {
            list = new ArrayList();
        }
        if (list2 == null) {
            list2 = new ArrayList();
        }
        FrameLayout frameLayout = p().b;
        Intrinsics.c(frameLayout, "vb.contentView");
        LiveFrameLayoutExKt.a(frameLayout, new Function1<FrameLayout, Unit>() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$setTag4Data$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(FrameLayout toAddView) {
                LiveBattleAdvanceBinding t;
                Intrinsics.e(toAddView, "$this$toAddView");
                LiveBattleShopDialog liveBattleShopDialog = LiveBattleShopDialog.this;
                t = liveBattleShopDialog.t();
                FrameLayout root = t.getRoot();
                Intrinsics.c(root, "tag4VB.root");
                toAddView.addView(liveBattleShopDialog.a(root), -2, -2);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(FrameLayout frameLayout2) {
                a(frameLayout2);
                return Unit.f42314a;
            }
        });
        ViewGroup.LayoutParams layoutParams = t().f12127c.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = t().b.getLayoutParams();
        ViewGroup.LayoutParams layoutParams3 = t().k.getLayoutParams();
        ViewGroup.LayoutParams layoutParams4 = t().e.getLayoutParams();
        ViewGroup.LayoutParams layoutParams5 = t().f.getLayoutParams();
        if (list.size() <= 4) {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                layoutParams.height = DensityUtils.a(getContext(), 186.0f);
            }
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                layoutParams2.height = DensityUtils.a(getContext(), 162.0f);
            }
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = DensityUtils.a(getContext(), 174.0f);
            }
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = DensityUtils.a(getContext(), 174.0f);
            }
            if (layoutParams5 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = DensityUtils.a(getContext(), 12.0f);
            }
        } else {
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                layoutParams.height = DensityUtils.a(getContext(), 250.0f);
            }
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                layoutParams2.height = DensityUtils.a(getContext(), 226.0f);
            }
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = DensityUtils.a(getContext(), 238.0f);
            }
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = DensityUtils.a(getContext(), 238.0f);
            }
            if (layoutParams5 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams5).topMargin = DensityUtils.a(getContext(), 10.0f);
            }
        }
        t().f12127c.setLayoutParams(layoutParams);
        t().b.setLayoutParams(layoutParams2);
        t().k.setLayoutParams(layoutParams3);
        t().e.setLayoutParams(layoutParams4);
        t().f.setLayoutParams(layoutParams5);
        RecyclerView recyclerView = t().f;
        Intrinsics.c(recyclerView, "tag4VB.rvList");
        a(recyclerView, 54.0f, 9.0f, list.size(), 8, DensityUtils.a(AppInfo.d(), 0.0f));
        LiveBattleGiftItemAdapter liveBattleGiftItemAdapter = new LiveBattleGiftItemAdapter(this);
        t().f.setAdapter(liveBattleGiftItemAdapter);
        liveBattleGiftItemAdapter.a(list, 3);
        RecyclerView recyclerView2 = t().g;
        Intrinsics.c(recyclerView2, "tag4VB.rvListAdvance");
        a(recyclerView2, 48.0f, 9.0f, list2.size(), 12, DensityUtils.a(AppInfo.d(), 0.0f));
        LiveBattleGiftItemAdapter liveBattleGiftItemAdapter2 = new LiveBattleGiftItemAdapter(this);
        t().g.setAdapter(liveBattleGiftItemAdapter2);
        liveBattleGiftItemAdapter2.a(list2, 4);
        t().j.setText(title);
        t().i.setText(desc);
        TextView textView = t().i;
        CharSequence text = t().i.getText();
        Intrinsics.c(text, "tag4VB.tvDesc.text");
        textView.setText(a(text, "#FFEF5F", true));
        t().h.setText(beans);
        t().d.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$tu5dMr5TXM9IkmgCH7R8PBtddIw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattleShopDialog.d(LiveBattleShopDialog.this, view);
            }
        });
        t().f12126a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$m6WwNcypCYBDVIx6IDy-xHEcCBI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattleShopDialog.e(LiveBattleShopDialog.this, view);
            }
        });
    }

    public final void a(boolean z) {
        this.t = z;
    }

    public final void b(String id) {
        Intrinsics.e(id, "id");
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.p(id, new BluedUIHttpResponse<BluedEntityA<LiveBattleGiftModel>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$receiveExp$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveBattleGiftModel> bluedEntity) {
                Intrinsics.e(bluedEntity, "bluedEntity");
                if (bluedEntity.getSingleData() == null) {
                    LiveBattleShopDialog.this.h();
                    return;
                }
                LiveBattleShopDialog.this.h = bluedEntity.getSingleData().getExp();
                LiveBattleShopDialog.this.a(bluedEntity.getSingleData());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                LiveBattleShopDialog.this.h();
                String str = errorMessage;
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                AppMethods.a((CharSequence) str);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveBattleShopDialog.this.n();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveBattleShopDialog.this.m();
            }
        }, a());
    }

    public final void b(boolean z) {
        this.u = z;
    }

    public final void c(boolean z) {
        int i;
        int i2 = this.b;
        if (i2 == 1) {
            int i3 = this.h;
            if (i3 > 0) {
                LiveEventBusUtil.d(i3);
            }
        } else if (i2 == 2) {
            if (this.t) {
                int i4 = this.d;
                if (i4 == 0) {
                    LiveEventBusUtil.f();
                } else {
                    LiveEventBusUtil.b(i4, this.e);
                }
            }
        } else if (i2 == 3) {
            if (this.t) {
                LiveEventBusUtil.f();
            }
        } else if (i2 == 4 && (i = this.h) > 0) {
            LiveEventBusUtil.d(i);
            LiveEventBusUtil.e(this.g);
        }
        if (z) {
            h();
        }
    }

    public final void f() {
        EventTrackLive.a(LiveProtos.Event.LIVE_BATTLE_PASS_EXPLAIN_SHOW, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        FrameLayout frameLayout = p().b;
        Intrinsics.c(frameLayout, "vb.contentView");
        LiveFrameLayoutExKt.a(frameLayout, new Function1<FrameLayout, Unit>() { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$setTag7Data$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public final void a(FrameLayout toAddView) {
                LiveBattleBuyTipBinding v;
                Intrinsics.e(toAddView, "$this$toAddView");
                LiveBattleShopDialog liveBattleShopDialog = LiveBattleShopDialog.this;
                v = liveBattleShopDialog.v();
                FrameLayout frameLayout2 = v.f12138c;
                Intrinsics.c(frameLayout2, "tag6VB.root");
                toAddView.addView(liveBattleShopDialog.a(frameLayout2), -2, -2);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(FrameLayout frameLayout2) {
                a(frameLayout2);
                return Unit.f42314a;
            }
        });
        v().b.post(new Runnable() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$pR7qdrP4tVpzI5R7xL2QvkRNKHc
            @Override // java.lang.Runnable
            public final void run() {
                LiveBattleShopDialog.j(LiveBattleShopDialog.this);
            }
        });
        v().f12137a.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$JhB7Mrj6_cqo2vITpauepKdmYSs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBattleShopDialog.i(LiveBattleShopDialog.this, view);
            }
        });
    }

    public final boolean g() {
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            Intrinsics.a(dialog);
            return dialog.isShowing();
        }
        return false;
    }

    public final void h() {
        if (g()) {
            dismissAllowingStateLoss();
        }
        n();
    }

    public final void i() {
        c(true);
    }

    public final void j() {
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.y(new BluedUIHttpResponse<BluedEntity<LiveBattleGiftReceiveModel, LiveBattleGiftExtra>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$getAdvance$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                LiveBattleShopDialog.this.h();
                String str = errorMessage;
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                AppMethods.a((CharSequence) str);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveBattleShopDialog.this.n();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveBattleShopDialog.this.m();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveBattleGiftReceiveModel, LiveBattleGiftExtra> bluedEntity) {
                String str;
                String str2;
                Intrinsics.e(bluedEntity, "bluedEntity");
                String str3 = "";
                if (bluedEntity.extra != null) {
                    str3 = bluedEntity.extra.getDuration_desc();
                    str = bluedEntity.extra.getReward_desc();
                    str2 = bluedEntity.extra.getUnlock_price();
                } else {
                    str = "";
                    str2 = str;
                }
                if (bluedEntity.getSingleData() == null) {
                    LiveBattleShopDialog.this.h();
                    return;
                }
                if (bluedEntity.getSingleData().getCurrent() != null) {
                    List<LiveBattleGiftModel> current = bluedEntity.getSingleData().getCurrent();
                    Intrinsics.a(current);
                    if (current.size() > 0 && bluedEntity.getSingleData().getIncomming() != null) {
                        List<LiveBattleGiftModel> incomming = bluedEntity.getSingleData().getIncomming();
                        Intrinsics.a(incomming);
                        if (incomming.size() > 0) {
                            LiveBattleShopDialog.this.a(bluedEntity.getSingleData().getCurrent(), bluedEntity.getSingleData().getIncomming(), str3, str, str2);
                            return;
                        }
                    }
                }
                if (bluedEntity.getSingleData().getCurrent() != null) {
                    List<LiveBattleGiftModel> current2 = bluedEntity.getSingleData().getCurrent();
                    Intrinsics.a(current2);
                    if (current2.size() > 0) {
                        LiveBattleShopDialog.this.a(bluedEntity.getSingleData().getCurrent(), str3, str, str2, false);
                        return;
                    }
                }
                LiveBattleShopDialog.this.a(bluedEntity.getSingleData().getIncomming(), str3, str, str2, true);
            }
        }, a());
    }

    public final void k() {
        EventTrackLive.a(LiveProtos.Event.LIVE_BATTLE_PASS_TOP_PAGE_BUY_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g());
        final ActivityFragmentActive a2 = a();
        LiveRoomHttpUtils.z(new BluedUIHttpResponse<BluedEntity<LiveBattleGiftModel, LiveBattleGiftExtra>>(a2) { // from class: com.blued.android.module.live_china.fragment.LiveBattleShopDialog$buyAdvance$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                LiveBattleShopDialog.this.a(i, errorMessage);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
                LiveBattleShopDialog.this.n();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                LiveBattleShopDialog.this.m();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<LiveBattleGiftModel, LiveBattleGiftExtra> bluedEntity) {
                Intrinsics.e(bluedEntity, "bluedEntity");
                LiveBattleShopDialog.this.a(true);
                LiveEventBusUtil.e();
                if (bluedEntity.data != null && bluedEntity.data.size() > 0) {
                    LiveBattleShopDialog.this.a(bluedEntity.data, bluedEntity.extra.getHas_bonus());
                    return;
                }
                AppMethods.d(R.string.live_battle_advance_buy);
                LiveBattleShopDialog.this.i();
            }
        }, a());
    }

    public final void l() {
        LiveGiftPayTools.b();
        if (this.v) {
            return;
        }
        if (!g()) {
            h();
            return;
        }
        String string = AppInfo.d().getString(R.string.live_id_charge_tip);
        Intrinsics.c(string, "getAppContext().getStrin…tring.live_id_charge_tip)");
        this.v = true;
        CommonAlertDialog.a(getContext(), (View) null, "", string, getString(R.string.cancel), getString(R.string.Live_SendPresent_recharge), new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$-eNTVaxMkBYZNYf8RnwUiEdNEto
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveBattleShopDialog.a(LiveBattleShopDialog.this, dialogInterface, i);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$s_hMQDA3kTw1ngxmI7jSzTA80Mo
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                LiveBattleShopDialog.b(LiveBattleShopDialog.this, dialogInterface, i);
            }
        }, new DialogInterface.OnCancelListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveBattleShopDialog$v9My4Q1kBw3MTDJwnRDoBQnsxhM
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                LiveBattleShopDialog.a(LiveBattleShopDialog.this, dialogInterface);
            }
        }, true);
    }

    public final void m() {
        AppInfo.n().postDelayed(this.w, this.s);
    }

    public final void n() {
        p().f11918a.setVisibility(8);
        AppInfo.n().removeCallbacks(this.w);
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, com.blued.android.core.ui.BaseFragmentActivity.IOnBackPressedListener
    public boolean onBackPressed() {
        i();
        return true;
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        if (p().f11919c.getParent() != null) {
            ViewParent parent = p().f11919c.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ((ViewGroup) parent).removeView(p().f11919c);
        }
        w();
        o();
        return p().f11919c;
    }
}
