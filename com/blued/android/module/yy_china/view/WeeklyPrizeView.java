package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeConstraintLayout;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewWeeklyPrizeBinding;
import com.blued.android.module.yy_china.fragment.YYTaskRewardDialog;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYTaskRewardModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.android.module.yy_china.view.DailyPrizeView;
import com.blued.das.client.chatroom.ChatRoomProtos;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/WeeklyPrizeView.class */
public final class WeeklyPrizeView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ViewWeeklyPrizeBinding f18030a;
    private YYTaskRewardModel b;

    /* renamed from: c  reason: collision with root package name */
    private BaseFragment f18031c;
    private YYTaskRewardDialog d;
    private ShapeConstraintLayout e;

    public WeeklyPrizeView(Context context) {
        this(context, null);
    }

    public WeeklyPrizeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WeeklyPrizeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ViewWeeklyPrizeBinding a2 = ViewWeeklyPrizeBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a2, "inflate(LayoutInflater.from(context), this, true)");
        this.f18030a = a2;
        DailyPrizeView dailyPrizeView = a2.f16886a;
        if (dailyPrizeView != null) {
            dailyPrizeView.setCirclePointVisible(8);
        }
        DailyPrizeView dailyPrizeView2 = this.f18030a.f16886a;
        if (dailyPrizeView2 != null) {
            dailyPrizeView2.setPrizeValueVisible(false);
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.yy_china.view.-$$Lambda$WeeklyPrizeView$6eqy5gplkRbdabPvPiPYi7boiEI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WeeklyPrizeView.a(WeeklyPrizeView.this, view);
            }
        });
    }

    private final String a(int i, String str) {
        if (i == 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f42549a;
            String string = getResources().getString(R.string.yy_weekly_task_title);
            Intrinsics.c(string, "resources.getString(R.string.yy_weekly_task_title)");
            String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.c(format, "format(format, *args)");
            return format;
        } else if (i == 1) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.f42549a;
            String string2 = getResources().getString(R.string.yy_weekly_task_complete_title);
            Intrinsics.c(string2, "resources.getString(R.st…ekly_task_complete_title)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.c(format2, "format(format, *args)");
            return format2;
        } else if (i != 2) {
            StringCompanionObject stringCompanionObject3 = StringCompanionObject.f42549a;
            String string3 = getResources().getString(R.string.yy_weekly_task_title);
            Intrinsics.c(string3, "resources.getString(R.string.yy_weekly_task_title)");
            String format3 = String.format(string3, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.c(format3, "format(format, *args)");
            return format3;
        } else {
            return getResources().getString(R.string.yy_weekly_task_got_title);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a() {
        ShapeConstraintLayout shapeConstraintLayout = this.e;
        if (shapeConstraintLayout != null) {
            shapeConstraintLayout.setVisibility(0);
        }
        YYTaskRewardDialog yYTaskRewardDialog = this.d;
        if (yYTaskRewardDialog == null) {
            return;
        }
        yYTaskRewardDialog.a(this.f18031c, this.e, this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(YYTaskRewardModel yYTaskRewardModel) {
        YYTaskRewardModel yYTaskRewardModel2 = this.b;
        if (yYTaskRewardModel2 != null) {
            yYTaskRewardModel2.status = 2;
        }
        TextView textView = this.f18030a.e;
        YYTaskRewardModel yYTaskRewardModel3 = this.b;
        Integer valueOf = yYTaskRewardModel3 == null ? null : Integer.valueOf(yYTaskRewardModel3.status);
        Intrinsics.a(valueOf);
        int intValue = valueOf.intValue();
        YYTaskRewardModel yYTaskRewardModel4 = this.b;
        textView.setText(a(intValue, String.valueOf(yYTaskRewardModel4 == null ? null : Integer.valueOf(yYTaskRewardModel4.condition))));
        TextView textView2 = this.f18030a.b;
        YYTaskRewardModel yYTaskRewardModel5 = this.b;
        boolean z = true;
        if (yYTaskRewardModel5 == null || yYTaskRewardModel5.status != 1) {
            z = false;
        }
        textView2.setVisibility(z ? 0 : 8);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b == null) {
            return;
        }
        EventTrackYY.k(ChatRoomProtos.Event.CHAT_ROOM_TASK_REWARD_CLICK, b.room_id, b.uid, String.valueOf(yYTaskRewardModel == null ? null : Integer.valueOf(yYTaskRewardModel.condition)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final WeeklyPrizeView this$0, View view) {
        Intrinsics.e(this$0, "this$0");
        final YYTaskRewardModel yYTaskRewardModel = this$0.b;
        if (yYTaskRewardModel == null) {
            return;
        }
        if (yYTaskRewardModel.status != 1) {
            this$0.a();
            return;
        }
        int i = yYTaskRewardModel.level;
        BaseFragment baseFragment = this$0.f18031c;
        final ActivityFragmentActive fragmentActive = baseFragment == null ? null : baseFragment.getFragmentActive();
        BluedUIHttpResponse<BluedEntityA<Object>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<Object>>(this$0, fragmentActive) { // from class: com.blued.android.module.yy_china.view.WeeklyPrizeView$1$1$1
            final /* synthetic */ WeeklyPrizeView b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(fragmentActive);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<Object> bluedEntityA) {
                YYTaskRewardModel yYTaskRewardModel2;
                YYTaskRewardModel.this.status = 2;
                this.b.getBinding().f16886a.a(true);
                WeeklyPrizeView weeklyPrizeView = this.b;
                yYTaskRewardModel2 = weeklyPrizeView.b;
                weeklyPrizeView.a(yYTaskRewardModel2);
                this.b.a();
            }
        };
        BaseFragment baseFragment2 = this$0.f18031c;
        YYRoomHttpUtils.i("2", String.valueOf(i), (BluedUIHttpResponse) bluedUIHttpResponse, baseFragment2 == null ? null : baseFragment2.getFragmentActive());
    }

    public final void a(YYTaskRewardModel yYTaskRewardModel, BaseFragment baseFragment, ShapeConstraintLayout shapeConstraintLayout, YYTaskRewardDialog yYTaskRewardDialog) {
        this.b = yYTaskRewardModel;
        this.f18031c = baseFragment;
        this.e = shapeConstraintLayout;
        this.d = yYTaskRewardDialog;
        if (yYTaskRewardModel != null) {
            getBinding().e.setText(a(yYTaskRewardModel.status, String.valueOf(yYTaskRewardModel.condition)));
            getBinding().d.setText(Intrinsics.a(BridgeUtil.SPLIT_MARK, (Object) Integer.valueOf(yYTaskRewardModel.condition)));
            int i = 0;
            getBinding().f16886a.a(yYTaskRewardModel.status == 2);
            TextView textView = getBinding().b;
            if (yYTaskRewardModel.status != 1) {
                i = 8;
            }
            textView.setVisibility(i);
        }
        this.f18030a.f16886a.setRootView(shapeConstraintLayout);
        this.f18030a.f16886a.setDV(yYTaskRewardDialog);
        this.f18030a.f16886a.a(yYTaskRewardModel, 2);
        this.f18030a.f16886a.a(baseFragment);
        this.f18030a.f16886a.setOpenPrizeListener(new DailyPrizeView.OpenPrizeListener() { // from class: com.blued.android.module.yy_china.view.WeeklyPrizeView$setTaskReward$2
            @Override // com.blued.android.module.yy_china.view.DailyPrizeView.OpenPrizeListener
            public void a(YYTaskRewardModel yYTaskRewardModel2) {
                WeeklyPrizeView.this.a(yYTaskRewardModel2);
            }
        });
    }

    public final ViewWeeklyPrizeBinding getBinding() {
        return this.f18030a;
    }

    public final void setBinding(ViewWeeklyPrizeBinding viewWeeklyPrizeBinding) {
        Intrinsics.e(viewWeeklyPrizeBinding, "<set-?>");
        this.f18030a = viewWeeklyPrizeBinding;
    }

    public final void setCurrentScore(String str) {
        this.f18030a.f16887c.setText(str);
    }
}
