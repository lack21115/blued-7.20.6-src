package com.blued.android.module.yy_china.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.common.utils.click.SingleClickProxy;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.FragmentYyDailyTaskBinding;
import com.blued.android.module.yy_china.fragment.YYDailyTaskFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYDailyModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYTaskModel;
import com.blued.android.module.yy_china.model.YYTaskRewardModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.DailyPrizeView;
import com.blued.android.module.yy_china.view.WeeklyPrizeView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYDailyTaskFragment.class */
public final class YYDailyTaskFragment extends BaseFullScreenDialog implements View.OnClickListener {
    private BaseFragment a;
    private FragmentYyDailyTaskBinding b;
    private DailyAdapter c;
    private YYRoomModel d;
    private View e;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/fragment/YYDailyTaskFragment$DailyAdapter.class */
    public final class DailyAdapter extends BaseQuickAdapter<YYDailyModel, BaseViewHolder> {
        final /* synthetic */ YYDailyTaskFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DailyAdapter(YYDailyTaskFragment this$0) {
            super(R.layout.item_daily_task);
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
        }

        private final String a(int i) {
            if (this.a.getDialog() == null) {
                return "";
            }
            Resources resources = this.a.getResources();
            if (resources == null) {
                return null;
            }
            return resources.getString(i);
        }

        private final void a(YYDailyModel yYDailyModel, int i) {
            String str = yYDailyModel == null ? null : yYDailyModel.task_type;
            String str2 = yYDailyModel == null ? null : yYDailyModel.current_level;
            final ActivityFragmentActive a = this.a.a();
            final YYDailyTaskFragment yYDailyTaskFragment = this.a;
            YYRoomHttpUtils.h(str, str2, (BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<Object>>(a) { // from class: com.blued.android.module.yy_china.fragment.YYDailyTaskFragment$DailyAdapter$getDailyPrize$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(a);
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                /* renamed from: a */
                public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                    YYDailyTaskFragment.this.g();
                }

                @Override // com.blued.android.framework.http.BluedUIHttpResponse
                public boolean onUIFailure(int i2, String str3) {
                    YYDailyTaskFragment.this.g();
                    return super.onUIFailure(i2, str3);
                }
            }, this.a.a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(YYDailyModel yYDailyModel, BaseViewHolder baseViewHolder, YYDailyTaskFragment this$0, DailyAdapter this$1, View view) {
            Intrinsics.e(this$0, "this$0");
            Intrinsics.e(this$1, "this$1");
            boolean z = false;
            if (yYDailyModel != null && yYDailyModel.status == 1) {
                z = true;
            }
            if (!z) {
                this$0.dismissAllowingStateLoss();
                return;
            }
            YYRoomModel b = YYRoomInfoManager.e().b();
            if (b != null) {
                EventTrackYY.k(ChatRoomProtos.Event.CHAT_ROOM_TASK_REWARD_CLICK, b.room_id, b.uid, yYDailyModel.task_type);
            }
            if (baseViewHolder == null) {
                return;
            }
            this$1.a(yYDailyModel, baseViewHolder.getAdapterPosition());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(final BaseViewHolder baseViewHolder, final YYDailyModel yYDailyModel) {
            ImageView imageView = baseViewHolder == null ? null : (ImageView) baseViewHolder.getView(R.id.item_image);
            ShapeTextView shapeTextView = baseViewHolder == null ? null : (ShapeTextView) baseViewHolder.getView(R.id.item_action);
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.item_title);
            TextView textView2 = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.item_value);
            if (yYDailyModel != null) {
                ImageLoader.a(this.a.a(), yYDailyModel.icon).b(R.drawable.gift_default_icon).a(imageView);
                if (textView != null) {
                    textView.setText(yYDailyModel.name);
                }
                if (textView2 != null) {
                    textView2.setText(Intrinsics.a("+", (Object) Integer.valueOf(yYDailyModel.reward)));
                }
                if (shapeTextView != null) {
                    shapeTextView.setClickable(true);
                }
                if (shapeTextView != null) {
                    shapeTextView.setEnabled(true);
                }
                if (shapeTextView != null) {
                    shapeTextView.setTextColor((shapeTextView == null ? null : shapeTextView.getContext()).getResources().getColor(R.color.white));
                }
                int i = yYDailyModel.status;
                if (i == 0) {
                    if (shapeTextView != null) {
                        shapeTextView.setText(a(R.string.yy_daily_to_complete));
                    }
                    ShapeTextView shapeTextView2 = shapeTextView;
                    ShapeHelper.a(shapeTextView2, R.color.transparent, R.color.transparent);
                    ShapeHelper.a((ShapeHelper.ShapeView) shapeTextView2, R.color.syc_00E0AB);
                    if (shapeTextView != null) {
                        shapeTextView.setBackgroundResource(R.drawable.shape_hollowed_background_);
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        if (shapeTextView != null) {
                            shapeTextView.setText(a(R.string.yy_daily_has_got));
                        }
                        ShapeHelper.a(shapeTextView, R.color.syc_1B1B1B, R.color.syc_1B1B1B);
                        if (shapeTextView != null) {
                            shapeTextView.setTextColor(shapeTextView.getContext().getResources().getColor(R.color.syc_989898));
                        }
                        if (shapeTextView != null) {
                            shapeTextView.setClickable(false);
                        }
                        if (shapeTextView != null) {
                            shapeTextView.setEnabled(false);
                        }
                    }
                } else if (shapeTextView != null) {
                    shapeTextView.setText(a(R.string.yy_daily_take_prize));
                }
            }
            if (shapeTextView == null) {
                return;
            }
            final YYDailyTaskFragment yYDailyTaskFragment = this.a;
            shapeTextView.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDailyTaskFragment$DailyAdapter$r7GLUNH9_x5KplL4gq1BKuw_yiU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    YYDailyTaskFragment.DailyAdapter.a(YYDailyModel.this, baseViewHolder, yYDailyTaskFragment, this, view);
                }
            }, 1500L, null));
        }
    }

    public YYDailyTaskFragment(BaseFragment fragment) {
        Intrinsics.e(fragment, "fragment");
        this.a = fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i, List<? extends YYTaskRewardModel> list) {
        ShapeTextView shapeTextView;
        DailyPrizeView dailyPrizeView;
        DailyPrizeView dailyPrizeView2;
        ShapeTextView shapeTextView2;
        DailyPrizeView dailyPrizeView3;
        DailyPrizeView dailyPrizeView4;
        ShapeTextView shapeTextView3;
        DailyPrizeView dailyPrizeView5;
        DailyPrizeView dailyPrizeView6;
        ShapeTextView shapeTextView4;
        DailyPrizeView dailyPrizeView7;
        DailyPrizeView dailyPrizeView8;
        List<? extends YYTaskRewardModel> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding = this.b;
        if (fragmentYyDailyTaskBinding != null) {
            fragmentYyDailyTaskBinding.l.setRootView(fragmentYyDailyTaskBinding.o);
            fragmentYyDailyTaskBinding.n.setRootView(fragmentYyDailyTaskBinding.o);
            fragmentYyDailyTaskBinding.m.setRootView(fragmentYyDailyTaskBinding.o);
            fragmentYyDailyTaskBinding.k.setRootView(fragmentYyDailyTaskBinding.o);
            fragmentYyDailyTaskBinding.l.setDV(fragmentYyDailyTaskBinding.s);
            fragmentYyDailyTaskBinding.n.setDV(fragmentYyDailyTaskBinding.s);
            fragmentYyDailyTaskBinding.m.setDV(fragmentYyDailyTaskBinding.s);
            fragmentYyDailyTaskBinding.k.setDV(fragmentYyDailyTaskBinding.s);
        }
        int i2 = list.get(CollectionsKt.b((List) list)).condition;
        int i3 = i2 / 4;
        int size = list.size();
        int i4 = 0;
        float f = 0.0f;
        while (true) {
            ShapeTextView shapeTextView5 = null;
            if (i4 >= size) {
                break;
            }
            YYTaskRewardModel yYTaskRewardModel = list.get(i4);
            if (i >= yYTaskRewardModel.condition) {
                f = i4 + 1.0f;
            }
            int i5 = 8;
            if (i4 == 0) {
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding2 = this.b;
                if (fragmentYyDailyTaskBinding2 != null && (dailyPrizeView2 = fragmentYyDailyTaskBinding2.l) != null) {
                    dailyPrizeView2.a(yYTaskRewardModel, 1);
                }
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding3 = this.b;
                if (fragmentYyDailyTaskBinding3 != null && (dailyPrizeView = fragmentYyDailyTaskBinding3.l) != null) {
                    dailyPrizeView.a(this.a);
                }
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding4 = this.b;
                ShapeTextView shapeTextView6 = fragmentYyDailyTaskBinding4 == null ? null : fragmentYyDailyTaskBinding4.b;
                if (shapeTextView6 != null) {
                    if (yYTaskRewardModel.status == 1) {
                        i5 = 0;
                    }
                    shapeTextView6.setVisibility(i5);
                }
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding5 = this.b;
                DailyPrizeView dailyPrizeView9 = fragmentYyDailyTaskBinding5 == null ? null : fragmentYyDailyTaskBinding5.l;
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding6 = this.b;
                a(dailyPrizeView9, fragmentYyDailyTaskBinding6 == null ? null : fragmentYyDailyTaskBinding6.b);
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding7 = this.b;
                if (fragmentYyDailyTaskBinding7 != null && (shapeTextView = fragmentYyDailyTaskBinding7.b) != null) {
                    shapeTextView.setOnClickListener(this);
                }
            } else if (i4 == 1) {
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding8 = this.b;
                if (fragmentYyDailyTaskBinding8 != null && (dailyPrizeView4 = fragmentYyDailyTaskBinding8.n) != null) {
                    dailyPrizeView4.a(yYTaskRewardModel, 1);
                }
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding9 = this.b;
                if (fragmentYyDailyTaskBinding9 != null && (dailyPrizeView3 = fragmentYyDailyTaskBinding9.n) != null) {
                    dailyPrizeView3.a(this.a);
                }
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding10 = this.b;
                ShapeTextView shapeTextView7 = fragmentYyDailyTaskBinding10 == null ? null : fragmentYyDailyTaskBinding10.d;
                if (shapeTextView7 != null) {
                    if (yYTaskRewardModel.status == 1) {
                        i5 = 0;
                    }
                    shapeTextView7.setVisibility(i5);
                }
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding11 = this.b;
                DailyPrizeView dailyPrizeView10 = fragmentYyDailyTaskBinding11 == null ? null : fragmentYyDailyTaskBinding11.n;
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding12 = this.b;
                a(dailyPrizeView10, fragmentYyDailyTaskBinding12 == null ? null : fragmentYyDailyTaskBinding12.d);
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding13 = this.b;
                if (fragmentYyDailyTaskBinding13 != null && (shapeTextView2 = fragmentYyDailyTaskBinding13.d) != null) {
                    shapeTextView2.setOnClickListener(this);
                }
            } else if (i4 == 2) {
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding14 = this.b;
                if (fragmentYyDailyTaskBinding14 != null && (dailyPrizeView6 = fragmentYyDailyTaskBinding14.m) != null) {
                    dailyPrizeView6.a(yYTaskRewardModel, 1);
                }
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding15 = this.b;
                if (fragmentYyDailyTaskBinding15 != null && (dailyPrizeView5 = fragmentYyDailyTaskBinding15.m) != null) {
                    dailyPrizeView5.a(this.a);
                }
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding16 = this.b;
                ShapeTextView shapeTextView8 = fragmentYyDailyTaskBinding16 == null ? null : fragmentYyDailyTaskBinding16.c;
                if (shapeTextView8 != null) {
                    if (yYTaskRewardModel.status == 1) {
                        i5 = 0;
                    }
                    shapeTextView8.setVisibility(i5);
                }
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding17 = this.b;
                DailyPrizeView dailyPrizeView11 = fragmentYyDailyTaskBinding17 == null ? null : fragmentYyDailyTaskBinding17.m;
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding18 = this.b;
                a(dailyPrizeView11, fragmentYyDailyTaskBinding18 == null ? null : fragmentYyDailyTaskBinding18.c);
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding19 = this.b;
                if (fragmentYyDailyTaskBinding19 != null && (shapeTextView3 = fragmentYyDailyTaskBinding19.c) != null) {
                    shapeTextView3.setOnClickListener(this);
                }
            } else if (i4 == 3) {
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding20 = this.b;
                if (fragmentYyDailyTaskBinding20 != null && (dailyPrizeView8 = fragmentYyDailyTaskBinding20.k) != null) {
                    dailyPrizeView8.a(yYTaskRewardModel, 1);
                }
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding21 = this.b;
                if (fragmentYyDailyTaskBinding21 != null && (dailyPrizeView7 = fragmentYyDailyTaskBinding21.k) != null) {
                    dailyPrizeView7.a(this.a);
                }
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding22 = this.b;
                ShapeTextView shapeTextView9 = fragmentYyDailyTaskBinding22 == null ? null : fragmentYyDailyTaskBinding22.a;
                if (shapeTextView9 != null) {
                    if (yYTaskRewardModel.status == 1) {
                        i5 = 0;
                    }
                    shapeTextView9.setVisibility(i5);
                }
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding23 = this.b;
                DailyPrizeView dailyPrizeView12 = fragmentYyDailyTaskBinding23 == null ? null : fragmentYyDailyTaskBinding23.k;
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding24 = this.b;
                if (fragmentYyDailyTaskBinding24 != null) {
                    shapeTextView5 = fragmentYyDailyTaskBinding24.a;
                }
                a(dailyPrizeView12, shapeTextView5);
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding25 = this.b;
                if (fragmentYyDailyTaskBinding25 != null && (shapeTextView4 = fragmentYyDailyTaskBinding25.a) != null) {
                    shapeTextView4.setOnClickListener(this);
                }
            }
            i4++;
        }
        FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding26 = this.b;
        ProgressBar progressBar = fragmentYyDailyTaskBinding26 == null ? null : fragmentYyDailyTaskBinding26.f;
        if (progressBar != null) {
            progressBar.setMax(i2);
        }
        boolean z = false;
        if (f == 0.0f) {
            z = true;
        }
        float f2 = f;
        if (z) {
            f2 = f;
            if (i > 0) {
                f2 = 0.25f;
            }
        }
        FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding27 = this.b;
        ProgressBar progressBar2 = fragmentYyDailyTaskBinding27 == null ? null : fragmentYyDailyTaskBinding27.f;
        if (progressBar2 == null) {
            return;
        }
        progressBar2.setProgress((int) (f2 * i3));
    }

    private final void a(DailyPrizeView dailyPrizeView, final ShapeTextView shapeTextView) {
        if (dailyPrizeView == null) {
            return;
        }
        dailyPrizeView.setOpenPrizeListener(new DailyPrizeView.OpenPrizeListener() { // from class: com.blued.android.module.yy_china.fragment.YYDailyTaskFragment$setPrizeListener$1
            @Override // com.blued.android.module.yy_china.view.DailyPrizeView.OpenPrizeListener
            public void a(YYTaskRewardModel yYTaskRewardModel) {
                ShapeTextView shapeTextView2 = ShapeTextView.this;
                if (shapeTextView2 != null) {
                    boolean z = true;
                    if (yYTaskRewardModel == null || yYTaskRewardModel.status != 1) {
                        z = false;
                    }
                    shapeTextView2.setVisibility(z ? 0 : 8);
                }
                YYRoomModel b = YYRoomInfoManager.e().b();
                if (b == null) {
                    return;
                }
                EventTrackYY.k(ChatRoomProtos.Event.CHAT_ROOM_TASK_REWARD_CLICK, b.room_id, b.uid, String.valueOf(yYTaskRewardModel == null ? null : Integer.valueOf(yYTaskRewardModel.condition)));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View b(int i, List<? extends YYTaskRewardModel> list) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_yy_weekly_task, (ViewGroup) null);
        List<? extends YYTaskRewardModel> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return inflate;
        }
        View findViewById = inflate.findViewById(R.id.ll_weekly_list);
        Intrinsics.c(findViewById, "headerView.findViewById(R.id.ll_weekly_list)");
        LinearLayout linearLayout = (LinearLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.tv_week_title);
        Intrinsics.c(findViewById2, "headerView.findViewById(R.id.tv_week_title)");
        TextView textView = (TextView) findViewById2;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String string = getResources().getString(R.string.yy_task_week_title);
        Intrinsics.c(string, "resources.getString(R.string.yy_task_week_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.c(format, "format(format, *args)");
        textView.setText(format);
        int size = list.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return inflate;
            }
            YYTaskRewardModel yYTaskRewardModel = list.get(i3);
            WeeklyPrizeView weeklyPrizeView = new WeeklyPrizeView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
            layoutParams.weight = 1.0f;
            layoutParams.topMargin = DensityUtils.a(getContext(), 5.0f);
            if (i3 < CollectionsKt.b((List) list)) {
                layoutParams.rightMargin = DensityUtils.a(getContext(), 6.0f);
            }
            weeklyPrizeView.setLayoutParams(layoutParams);
            BaseFragment baseFragment = this.a;
            FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding = this.b;
            ShapeConstraintLayout shapeConstraintLayout = fragmentYyDailyTaskBinding == null ? null : fragmentYyDailyTaskBinding.o;
            FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding2 = this.b;
            weeklyPrizeView.a(yYTaskRewardModel, baseFragment, shapeConstraintLayout, fragmentYyDailyTaskBinding2 == null ? null : fragmentYyDailyTaskBinding2.s);
            weeklyPrizeView.setCurrentScore(String.valueOf(i));
            linearLayout.addView(weeklyPrizeView);
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(YYDailyTaskFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(YYDailyTaskFragment this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        YYWebViewDialogFragment a = new YYWebViewDialogFragment().a(this$0.a, "https://activity.blued.cn/activityblued/work/7hsNIZlb");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.c(childFragmentManager, "childFragmentManager");
        a.show(childFragmentManager, "yy_daily_task_guide");
    }

    private final void h() {
        ImageView imageView;
        View view;
        FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding = this.b;
        if (fragmentYyDailyTaskBinding != null && (view = fragmentYyDailyTaskBinding.e) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDailyTaskFragment$Is9UKjUgjnzzPilKoXzddzNgZCM
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYDailyTaskFragment.b(YYDailyTaskFragment.this, view2);
                }
            });
        }
        FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding2 = this.b;
        if (fragmentYyDailyTaskBinding2 != null && (imageView = fragmentYyDailyTaskBinding2.i) != null) {
            imageView.setOnClickListener(new SingleClickProxy(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.fragment.-$$Lambda$YYDailyTaskFragment$QtJa3G6JPDaBqhzAibw8i3FMoKQ
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    YYDailyTaskFragment.c(YYDailyTaskFragment.this, view2);
                }
            }));
        }
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        this.c = new DailyAdapter(this);
        FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding3 = this.b;
        RecyclerView recyclerView = fragmentYyDailyTaskBinding3 == null ? null : fragmentYyDailyTaskBinding3.q;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
        }
        FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding4 = this.b;
        RecyclerView recyclerView2 = fragmentYyDailyTaskBinding4 == null ? null : fragmentYyDailyTaskBinding4.q;
        if (recyclerView2 == null) {
            return;
        }
        recyclerView2.setAdapter(this.c);
    }

    public final DailyAdapter f() {
        return this.c;
    }

    public final void g() {
        final ActivityFragmentActive a = a();
        YYRoomHttpUtils.a((BluedUIHttpResponse) new BluedUIHttpResponse<BluedEntityA<YYTaskModel>>(a) { // from class: com.blued.android.module.yy_china.fragment.YYDailyTaskFragment$loadData$1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<YYTaskModel> bluedEntityA) {
                YYTaskModel singleData;
                FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding;
                View view;
                View b;
                View view2;
                YYDailyTaskFragment.DailyAdapter f;
                View view3;
                if (bluedEntityA == null || (singleData = bluedEntityA.getSingleData()) == null) {
                    return;
                }
                YYDailyTaskFragment yYDailyTaskFragment = YYDailyTaskFragment.this;
                fragmentYyDailyTaskBinding = yYDailyTaskFragment.b;
                TextView textView = fragmentYyDailyTaskBinding == null ? null : fragmentYyDailyTaskBinding.g;
                if (textView != null) {
                    textView.setText(String.valueOf(singleData.day_score));
                }
                yYDailyTaskFragment.a(singleData.day_score, singleData.day_reward);
                view = yYDailyTaskFragment.e;
                if (view != null && (f = yYDailyTaskFragment.f()) != null) {
                    view3 = yYDailyTaskFragment.e;
                    f.removeHeaderView(view3);
                }
                YYDailyTaskFragment.DailyAdapter f2 = yYDailyTaskFragment.f();
                if (f2 != null) {
                    f2.setNewData(singleData.tasks);
                }
                b = yYDailyTaskFragment.b(singleData.week_score, singleData.week_reward);
                yYDailyTaskFragment.e = b;
                YYDailyTaskFragment.DailyAdapter f3 = yYDailyTaskFragment.f();
                if (f3 == null) {
                    return;
                }
                view2 = yYDailyTaskFragment.e;
                f3.addHeaderView(view2);
            }
        }, a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding;
        DailyPrizeView dailyPrizeView;
        DailyPrizeView dailyPrizeView2;
        DailyPrizeView dailyPrizeView3;
        DailyPrizeView dailyPrizeView4;
        Tracker.onClick(view);
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i = R.id.btn_get_one;
        if (valueOf != null && valueOf.intValue() == i) {
            FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding2 = this.b;
            if (fragmentYyDailyTaskBinding2 == null || (dailyPrizeView4 = fragmentYyDailyTaskBinding2.l) == null) {
                return;
            }
            dailyPrizeView4.a();
            return;
        }
        int i2 = R.id.btn_get_two;
        if (valueOf != null && valueOf.intValue() == i2) {
            FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding3 = this.b;
            if (fragmentYyDailyTaskBinding3 == null || (dailyPrizeView3 = fragmentYyDailyTaskBinding3.n) == null) {
                return;
            }
            dailyPrizeView3.a();
            return;
        }
        int i3 = R.id.btn_get_three;
        if (valueOf != null && valueOf.intValue() == i3) {
            FragmentYyDailyTaskBinding fragmentYyDailyTaskBinding4 = this.b;
            if (fragmentYyDailyTaskBinding4 == null || (dailyPrizeView2 = fragmentYyDailyTaskBinding4.m) == null) {
                return;
            }
            dailyPrizeView2.a();
            return;
        }
        int i4 = R.id.btn_get_four;
        if (valueOf == null || valueOf.intValue() != i4 || (fragmentYyDailyTaskBinding = this.b) == null || (dailyPrizeView = fragmentYyDailyTaskBinding.k) == null) {
            return;
        }
        dailyPrizeView.a();
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = YYRoomInfoManager.e().b();
    }

    @Override // com.blued.android.core.ui.BaseDialogFragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.e(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fragment_yy_daily_task, viewGroup, true);
        Intrinsics.c(inflate, "inflater.inflate(R.layou…ly_task, container, true)");
        this.b = FragmentYyDailyTaskBinding.a(inflate);
        h();
        return inflate;
    }

    @Override // com.blued.android.module.yy_china.fragment.BaseFullScreenDialog, com.blued.android.core.ui.BaseDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.e(view, "view");
        super.onViewCreated(view, bundle);
        g();
    }
}
