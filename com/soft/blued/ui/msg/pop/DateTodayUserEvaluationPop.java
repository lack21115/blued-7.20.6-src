package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.module.common.view.FlowLayout;
import com.bytedance.applog.tracker.Tracker;
import com.soft.blued.R;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/DateTodayUserEvaluationPop.class */
public final class DateTodayUserEvaluationPop extends BottomPopupView {
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f32473c;
    private final IRequestHost d;
    private final Set<Integer> e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateTodayUserEvaluationPop(Context context, long j, List<String> evaluation, IRequestHost iRequestHost) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(evaluation, "evaluation");
        this.b = j;
        this.f32473c = evaluation;
        this.d = iRequestHost;
        this.e = new LinkedHashSet();
    }

    private final void a(View view, int i) {
        TextView textView = (TextView) view.findViewById(R.id.tv_evaluation_text);
        if (this.e.contains(Integer.valueOf(i))) {
            textView.setBackgroundResource(R.drawable.shape_date_today_search_purpose_item);
            textView.setTextColor(getContext().getResources().getColor(BluedPreferences.cK() ? 2131102177 : 2131102263));
            this.e.remove(Integer.valueOf(i));
            return;
        }
        this.e.add(Integer.valueOf(i));
        textView.setBackgroundResource(R.drawable.shape_date_today_evaluation_item_selected);
        textView.setTextColor(getContext().getResources().getColor(BluedPreferences.cK() ? 2131102073 : 2131102254));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DateTodayUserEvaluationPop this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        if (this$0.e.size() > 0) {
            this$0.p();
            ArrayList arrayList = new ArrayList();
            for (Integer num : this$0.e) {
                arrayList.add(this$0.f32473c.get(num.intValue()));
            }
            if (!arrayList.isEmpty()) {
                ChatHttpUtils.a(this$0.b, arrayList, this$0.d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DateTodayUserEvaluationPop this$0, TextView textView, View tagView, int i) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.c(tagView, "tagView");
        this$0.a(tagView, i);
        if (this$0.e.size() > 0) {
            textView.setBackgroundResource(R.drawable.shape_date_today_done);
            textView.setTextColor(this$0.getContext().getResources().getColor(BluedPreferences.cK() ? 2131102254 : 2131101780));
            return;
        }
        textView.setBackgroundResource(R.drawable.shape_date_today_cancel);
        textView.setTextColor(BluedSkinUtils.a(this$0.getContext(), 2131102264));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DateTodayUserEvaluationPop this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.p();
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        FlowLayout flowLayout = (FlowLayout) findViewById(R.id.fl_user_impression);
        flowLayout.removeAllViews();
        int size = this.f32473c.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                final TextView textView = (TextView) findViewById(2131371293);
                flowLayout.setOnItemClickListener(new FlowLayout.OnItemClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$DateTodayUserEvaluationPop$wSMZlEqi0Np7neDPg6VhgzxkW-0
                    @Override // com.blued.android.module.common.view.FlowLayout.OnItemClickListener
                    public final void onItemClick(View view, int i3) {
                        DateTodayUserEvaluationPop.a(DateTodayUserEvaluationPop.this, textView, view, i3);
                    }
                });
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$DateTodayUserEvaluationPop$KR7dqpeUVirv1tWXZtZs9qLk_1c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DateTodayUserEvaluationPop.a(DateTodayUserEvaluationPop.this, view);
                    }
                });
                ((ImageView) findViewById(2131365207)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$DateTodayUserEvaluationPop$4Yk-crtGLJYDHCh3h-Wu8oQyOY4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DateTodayUserEvaluationPop.b(DateTodayUserEvaluationPop.this, view);
                    }
                });
                return;
            }
            View inflate = BottomPopupView.inflate(getContext(), R.layout.item_date_today_evaluation, null);
            ((TextView) inflate.findViewById(R.id.tv_evaluation_text)).setText(this.f32473c.get(i2));
            flowLayout.addView(inflate);
            i = i2 + 1;
        }
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_date_today_user_evaluation;
    }

    public final long getTargetUid() {
        return this.b;
    }
}
