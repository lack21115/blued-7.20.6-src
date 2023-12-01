package com.blued.android.module.live_china.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageFileWrapper;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.image.util.ImageSize;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.adapter.CommonRecycleAdapter;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.databinding.FragmentLiveGiftSetItemViewBinding;
import com.blued.android.module.live_china.databinding.LiveGiftSetTaskItemBinding;
import com.blued.android.module.live_china.fragment.LiveGiftSetItemFragment;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveGiftSetBuyModel;
import com.blued.android.module.live_china.model.LiveGiftSetDesModel;
import com.blued.android.module.live_china.model.LiveGiftSetItemModel;
import com.blued.android.module.live_china.model.LiveGiftSetModel;
import com.blued.android.module.live_china.model.LiveGiftSetTaskModel;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import com.blued.android.module.live_china.utils.dslspannable.DslSpanBuilder;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder;
import com.blued.android.module.live_china.utils.log.EventTrackLive;
import com.blued.android.module.live_china.view.LiveTextSpanExKt;
import com.blued.das.live.LiveProtos;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGiftSetItemFragment.class */
public final class LiveGiftSetItemFragment extends BaseFragment {
    private LiveGiftSetCardAdapter b;

    /* renamed from: c  reason: collision with root package name */
    private LiveGiftSetDesAdapter f12914c;
    private boolean d;
    private LiveGiftSetModel e;
    private CountDownTimer g;

    /* renamed from: a  reason: collision with root package name */
    private final Lazy f12913a = LazyKt.a(new Function0<FragmentLiveGiftSetItemViewBinding>() { // from class: com.blued.android.module.live_china.fragment.LiveGiftSetItemFragment$vb$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public final FragmentLiveGiftSetItemViewBinding invoke() {
            return FragmentLiveGiftSetItemViewBinding.a(LayoutInflater.from(LiveGiftSetItemFragment.this.getContext()));
        }
    });
    private String f = "";

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGiftSetItemFragment$LiveGiftSetCardAdapter.class */
    public final class LiveGiftSetCardAdapter extends CommonRecycleAdapter<LiveGiftSetItemModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveGiftSetItemFragment f12915a;
        private float b;

        /* renamed from: c  reason: collision with root package name */
        private int f12916c;
        private int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LiveGiftSetCardAdapter(LiveGiftSetItemFragment this$0) {
            super(this$0.getContext());
            Intrinsics.e(this$0, "this$0");
            this.f12915a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(LiveGiftSetItemFragment this$0, LiveGiftSetItemModel item, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(item, "$item");
            EventTrackLive.a(LiveProtos.Event.LIVE_SET_GIFT_PAGE_SEND_ONE_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this$0.b(), item.getGoods_id());
            LiveGiftSetDialogFragment e = this$0.e();
            if (e != null) {
                String goods_id = item.getGoods_id();
                if (goods_id == null || goods_id.length() == 0) {
                    return;
                }
                String b = this$0.b();
                String goods_id2 = item.getGoods_id();
                Intrinsics.a((Object) goods_id2);
                e.a(b, goods_id2);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(final LiveGiftSetItemModel item, int i, CommonRecycleAdapter.CommonAdapterHolder helper) {
            Intrinsics.e(item, "item");
            Intrinsics.e(helper, "helper");
            ViewGroup.LayoutParams layoutParams = helper.a(R.id.view_root).getLayoutParams();
            if (layoutParams == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.width = (int) this.b;
            if (getItemCount() == 1) {
                marginLayoutParams.leftMargin = (int) ((this.f12916c - this.b) / 2);
                marginLayoutParams.rightMargin = 0;
            } else if (getItemCount() == 2) {
                if (i == 0) {
                    float f = 2;
                    marginLayoutParams.leftMargin = (int) ((this.f12916c - ((this.b * f) + this.d)) / f);
                } else {
                    marginLayoutParams.leftMargin = this.d;
                }
                marginLayoutParams.rightMargin = 0;
            } else if (getItemCount() == 3) {
                if (i == 0) {
                    marginLayoutParams.leftMargin = (int) ((this.f12916c - ((this.b * 3) + (this.d * 2))) / 2);
                } else {
                    marginLayoutParams.leftMargin = this.d;
                }
                marginLayoutParams.rightMargin = 0;
            } else if (i == 0) {
                marginLayoutParams.leftMargin = DensityUtils.a(this.f12915a.getContext(), 16.0f);
                marginLayoutParams.rightMargin = 0;
            } else if (i < getItemCount() - 1) {
                marginLayoutParams.leftMargin = this.d;
                marginLayoutParams.rightMargin = 0;
            } else {
                marginLayoutParams.leftMargin = this.d;
                marginLayoutParams.rightMargin = DensityUtils.a(this.f12915a.getContext(), 16.0f);
            }
            helper.a(R.id.view_root).setLayoutParams(marginLayoutParams);
            ImageLoader.a(this.f12915a.getFragmentActive(), item.getImage()).e(-1).a((ImageView) helper.a(R.id.iv_icon));
            ((TextView) helper.a(R.id.tv_name)).setText(item.getName());
            ((TextView) helper.a(R.id.tv_num)).setText(Intrinsics.a("X", (Object) Integer.valueOf(item.getTotal())));
            ((TextView) helper.a(R.id.tv_beans)).setText(String.valueOf(item.getBeans()));
            final LiveGiftSetItemFragment liveGiftSetItemFragment = this.f12915a;
            ((TextView) helper.a(R.id.tv_send)).setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGiftSetItemFragment$LiveGiftSetCardAdapter$XMLc2Uz3IAnCrbriGOl2u2NYo_k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveGiftSetItemFragment.LiveGiftSetCardAdapter.a(LiveGiftSetItemFragment.this, item, view);
                }
            });
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return R.layout.live_gift_set_card_item;
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public void setDataAndNotify(List<LiveGiftSetItemModel> list) {
            this.d = DensityUtils.a(this.f12915a.getContext(), 4.5f);
            this.b = (AppInfo.l - DensityUtils.a(this.f12915a.getContext(), (this.d * 3) + 32.0f)) / 3.5f;
            this.f12916c = AppInfo.l - DensityUtils.a(this.f12915a.getContext(), 32.0f);
            super.setDataAndNotify(list);
        }
    }

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGiftSetItemFragment$LiveGiftSetDesAdapter.class */
    public final class LiveGiftSetDesAdapter extends CommonRecycleAdapter<LiveGiftSetDesModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LiveGiftSetItemFragment f12917a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LiveGiftSetDesAdapter(LiveGiftSetItemFragment this$0) {
            super(this$0.getContext());
            Intrinsics.e(this$0, "this$0");
            this.f12917a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r1v4, types: [T, android.view.View] */
        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        /* renamed from: a */
        public void onBindViewHolderData(final LiveGiftSetDesModel item, int i, CommonRecycleAdapter.CommonAdapterHolder helper) {
            Intrinsics.e(item, "item");
            Intrinsics.e(helper, "helper");
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.f42545a = helper.a(R.id.iv_icon);
            final ImageSize imageSize = new ImageSize();
            ImageFileWrapper a2 = ImageFileLoader.a(this.f12917a.getFragmentActive()).a(item.getImage()).a(imageSize);
            final LiveGiftSetItemFragment liveGiftSetItemFragment = this.f12917a;
            a2.a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.fragment.LiveGiftSetItemFragment$LiveGiftSetDesAdapter$onBindViewHolderData$1
                @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                public void onUIFinish(File file, Exception exc) {
                    if (file == null || !file.exists()) {
                        return;
                    }
                    float a3 = ImageSize.this.a();
                    float b = ImageSize.this.b();
                    int a4 = AppInfo.l - DensityUtils.a(AppInfo.d(), 100.0f);
                    if (a3 > 0.0f && b > 0.0f) {
                        int i2 = (int) ((b / a3) * a4);
                        ViewGroup.LayoutParams layoutParams = objectRef.f42545a.getLayoutParams();
                        if (layoutParams == null) {
                            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
                        }
                        layoutParams.width = a4;
                        layoutParams.height = i2;
                        objectRef.f42545a.setLayoutParams(layoutParams);
                    }
                    ImageLoader.a(liveGiftSetItemFragment.getFragmentActive(), item.getImage()).a(8.0f).e(-1).a(objectRef.f42545a);
                }
            }).a();
            ((TextView) helper.a(R.id.tv_name)).setText(item.getText());
        }

        @Override // com.blued.android.module.common.adapter.CommonRecycleAdapter
        public int getLayoutId(int i) {
            return R.layout.live_gift_set_extra_item;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftSetItemFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        EventTrackLive.b(LiveProtos.Event.LIVE_SET_GIFT_PAGE_SEND_ALL_CLICK, LiveRoomManager.a().e(), LiveRoomManager.a().g(), this$0.f);
        LiveGiftSetDialogFragment e = this$0.e();
        if (e != null) {
            e.a(this$0.f, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveGiftSetItemFragment this$0, LiveGiftSetBuyModel liveGiftSetBuyModel) {
        Intrinsics.e(this$0, "this$0");
        this$0.a(liveGiftSetBuyModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentLiveGiftSetItemViewBinding g() {
        return (FragmentLiveGiftSetItemViewBinding) this.f12913a.getValue();
    }

    private final void h() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("id", "");
            Intrinsics.c(string, "it.getString(\"id\", \"\")");
            a(string);
            if (arguments.getSerializable("data") instanceof LiveGiftSetModel) {
                Serializable serializable = arguments.getSerializable("data");
                if (serializable == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.model.LiveGiftSetModel");
                }
                a((LiveGiftSetModel) serializable);
            }
        }
        g().e.setVisibility(0);
        g().f11937c.setVisibility(8);
        LiveEventBus.get("live_gift_set_buy_success", LiveGiftSetBuyModel.class).observe(this, new Observer() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGiftSetItemFragment$5AvDVzpxuyZZuC-J3XdabVW-8Rc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                LiveGiftSetItemFragment.a(LiveGiftSetItemFragment.this, (LiveGiftSetBuyModel) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0180  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i() {
        /*
            Method dump skipped, instructions count: 469
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live_china.fragment.LiveGiftSetItemFragment.i():void");
    }

    public final LiveGiftSetModel a() {
        return this.e;
    }

    public final void a(int i) {
        f();
        final long j = i * 1000;
        this.g = new CountDownTimer(j) { // from class: com.blued.android.module.live_china.fragment.LiveGiftSetItemFragment$startPunishTimer$1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                FragmentLiveGiftSetItemViewBinding g;
                FragmentLiveGiftSetItemViewBinding g2;
                if (LiveGiftSetItemFragment.this.getContext() == null) {
                    return;
                }
                LiveGiftSetDialogFragment e = LiveGiftSetItemFragment.this.e();
                if (e != null) {
                    e.f();
                }
                g = LiveGiftSetItemFragment.this.g();
                g.b.setImageResource(R.drawable.live_gift_set_count_down);
                g2 = LiveGiftSetItemFragment.this.g();
                g2.j.setVisibility(8);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                FragmentLiveGiftSetItemViewBinding g;
                if (LiveGiftSetItemFragment.this.getContext() == null) {
                    return;
                }
                g = LiveGiftSetItemFragment.this.g();
                ShapeTextView shapeTextView = g.j;
                StringBuilder sb = new StringBuilder();
                sb.append((j2 / 1000) + 1);
                sb.append('s');
                shapeTextView.setText(sb.toString());
            }
        }.start();
    }

    public final void a(LiveGiftSetBuyModel liveGiftSetBuyModel) {
        if (this.e == null || liveGiftSetBuyModel == null || StringUtils.a(this.f, 0) != liveGiftSetBuyModel.getId()) {
            return;
        }
        LiveGiftSetModel liveGiftSetModel = this.e;
        if (liveGiftSetModel != null) {
            liveGiftSetModel.setId(StringUtils.a(this.f, 0));
        }
        LiveGiftSetModel liveGiftSetModel2 = this.e;
        if (liveGiftSetModel2 != null) {
            liveGiftSetModel2.setTask_info(liveGiftSetBuyModel.getTask_info());
        }
        LiveGiftSetModel liveGiftSetModel3 = this.e;
        if (liveGiftSetModel3 != null) {
            liveGiftSetModel3.setProgress(liveGiftSetBuyModel.getProgress());
        }
        LiveGiftSetModel liveGiftSetModel4 = this.e;
        if (liveGiftSetModel4 != null) {
            liveGiftSetModel4.setExpire_time(liveGiftSetBuyModel.getExpire_time());
        }
        i();
    }

    public final void a(LiveGiftSetModel liveGiftSetModel) {
        this.e = liveGiftSetModel;
    }

    public final void a(String str) {
        Intrinsics.e(str, "<set-?>");
        this.f = str;
    }

    public final String b() {
        return this.f;
    }

    /* JADX WARN: Type inference failed for: r0v41, types: [T, java.lang.Object, com.blued.android.module.live_china.databinding.LiveGiftSetTaskItemBinding] */
    public final void c() {
        ArrayList<LiveGiftSetTaskModel> task_info;
        LiveGiftSetModel liveGiftSetModel = this.e;
        if (liveGiftSetModel != null) {
            Intrinsics.a(liveGiftSetModel);
            if (liveGiftSetModel.getTask_info() != null) {
                LiveGiftSetModel liveGiftSetModel2 = this.e;
                Intrinsics.a(liveGiftSetModel2);
                ArrayList<LiveGiftSetTaskModel> task_info2 = liveGiftSetModel2.getTask_info();
                Intrinsics.a(task_info2);
                if (task_info2.size() > 0) {
                    g().h.setVisibility(0);
                    g().d.removeAllViews();
                    LiveGiftSetModel liveGiftSetModel3 = this.e;
                    if (liveGiftSetModel3 == null || (task_info = liveGiftSetModel3.getTask_info()) == null) {
                        return;
                    }
                    for (final LiveGiftSetTaskModel liveGiftSetTaskModel : task_info) {
                        Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        ?? a2 = LiveGiftSetTaskItemBinding.a(LayoutInflater.from(getContext()));
                        Intrinsics.c(a2, "inflate(LayoutInflater.from(context))");
                        objectRef.f42545a = a2;
                        g().d.addView(((LiveGiftSetTaskItemBinding) objectRef.f42545a).getRoot());
                        TextView textView = ((LiveGiftSetTaskItemBinding) objectRef.f42545a).f12232c;
                        Intrinsics.c(textView, "taskVB.tvName");
                        LiveTextSpanExKt.a(textView, new Function1<DslSpannableStringBuilder, Unit>() { // from class: com.blued.android.module.live_china.fragment.LiveGiftSetItemFragment$addTask$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                super(1);
                            }

                            public final void a(DslSpannableStringBuilder buildSpannableString) {
                                Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
                                buildSpannableString.a(LiveGiftSetTaskModel.this.getText(), new Function1<DslSpanBuilder, Unit>() { // from class: com.blued.android.module.live_china.fragment.LiveGiftSetItemFragment$addTask$1$1.1
                                    public final void a(DslSpanBuilder addText) {
                                        Intrinsics.e(addText, "$this$addText");
                                        Context d = AppInfo.d();
                                        Intrinsics.c(d, "getAppContext()");
                                        addText.a(d, R.color.syc_dark_FFE6BC);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* synthetic */ Unit invoke(DslSpanBuilder dslSpanBuilder) {
                                        a(dslSpanBuilder);
                                        return Unit.f42314a;
                                    }
                                });
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
                                a(dslSpannableStringBuilder);
                                return Unit.f42314a;
                            }
                        });
                        String icon = liveGiftSetTaskModel.getIcon();
                        if (icon == null || icon.length() == 0) {
                            ((LiveGiftSetTaskItemBinding) objectRef.f42545a).f12231a.setVisibility(8);
                        } else {
                            ((LiveGiftSetTaskItemBinding) objectRef.f42545a).f12231a.setVisibility(0);
                            int a3 = DensityUtils.a(AppInfo.d(), 50.0f);
                            int a4 = DensityUtils.a(AppInfo.d(), 19.0f);
                            int a5 = AppMethods.a(4.5f);
                            TextView textView2 = ((LiveGiftSetTaskItemBinding) objectRef.f42545a).f12232c;
                            Intrinsics.c(textView2, "taskVB.tvName");
                            LiveTextSpanExKt.a(textView2, new LiveGiftSetItemFragment$addTask$1$2(a5, a3, a4, objectRef, this, liveGiftSetTaskModel));
                        }
                        if (liveGiftSetTaskModel.getCount().compareTo(liveGiftSetTaskModel.getTotal()) < 0) {
                            ((LiveGiftSetTaskItemBinding) objectRef.f42545a).d.setAlpha(0.4f);
                            ((LiveGiftSetTaskItemBinding) objectRef.f42545a).d.setTextColor(getResources().getColor(R.color.syc_dark_b));
                            TextView textView3 = ((LiveGiftSetTaskItemBinding) objectRef.f42545a).d;
                            textView3.setText(AppInfo.d().getString(R.string.live_gift_set_task_un_complete) + '(' + liveGiftSetTaskModel.getCount() + '/' + liveGiftSetTaskModel.getTotal() + ')');
                        } else {
                            ((LiveGiftSetTaskItemBinding) objectRef.f42545a).d.setAlpha(1.0f);
                            ((LiveGiftSetTaskItemBinding) objectRef.f42545a).d.setTextColor(getResources().getColor(R.color.syc_dark_FFE6BC));
                            TextView textView4 = ((LiveGiftSetTaskItemBinding) objectRef.f42545a).d;
                            textView4.setText(AppInfo.d().getString(R.string.live_gift_set_task_complete) + '(' + liveGiftSetTaskModel.getCount() + '/' + liveGiftSetTaskModel.getTotal() + ')');
                        }
                    }
                    return;
                }
            }
        }
        g().h.setVisibility(8);
    }

    public final void d() {
        String str = this.f;
        final ActivityFragmentActive fragmentActive = getFragmentActive();
        LiveRoomHttpUtils.q(str, new BluedUIHttpResponse<BluedEntityA<LiveGiftSetModel>>(fragmentActive) { // from class: com.blued.android.module.live_china.fragment.LiveGiftSetItemFragment$getAll$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveGiftSetModel> bluedEntity) {
                Intrinsics.e(bluedEntity, "bluedEntity");
                if (bluedEntity.data == null || bluedEntity.data.size() <= 0) {
                    return;
                }
                LiveGiftSetItemFragment.this.a(bluedEntity.data.get(0));
                LiveGiftSetModel a2 = LiveGiftSetItemFragment.this.a();
                if (a2 != null) {
                    a2.setId(StringUtils.a(LiveGiftSetItemFragment.this.b(), 0));
                }
                LiveGiftSetItemFragment.this.i();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish() {
                super.onUIFinish();
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
            }
        }, getFragmentActive());
    }

    public final LiveGiftSetDialogFragment e() {
        if (getParentFragment() instanceof LiveGiftSetDialogFragment) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                return (LiveGiftSetDialogFragment) parentFragment;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.live_china.fragment.LiveGiftSetDialogFragment");
        }
        return null;
    }

    public final void f() {
        CountDownTimer countDownTimer = this.g;
        if (countDownTimer == null || countDownTimer == null) {
            return;
        }
        countDownTimer.cancel();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        NestedScrollView root;
        NestedScrollView root2;
        Intrinsics.e(inflater, "inflater");
        FragmentLiveGiftSetItemViewBinding g = g();
        if (((g == null || (root = g.getRoot()) == null) ? null : root.getParent()) != null) {
            FragmentLiveGiftSetItemViewBinding g2 = g();
            ViewParent parent = (g2 == null || (root2 = g2.getRoot()) == null) ? null : root2.getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            ViewGroup viewGroup2 = (ViewGroup) parent;
            FragmentLiveGiftSetItemViewBinding g3 = g();
            viewGroup2.removeView(g3 == null ? null : g3.getRoot());
        }
        h();
        if (this.e != null) {
            i();
        }
        FragmentLiveGiftSetItemViewBinding g4 = g();
        return g4 == null ? null : g4.getRoot();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        f();
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.d = false;
    }

    @Override // com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.d = true;
        if (this.e == null) {
            d();
            return;
        }
        LiveGiftSetDialogFragment e = e();
        if (e != null) {
            LiveGiftSetModel liveGiftSetModel = this.e;
            Intrinsics.a(liveGiftSetModel);
            e.a(liveGiftSetModel);
        }
    }
}
