package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
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
    private final List<String> f18782c;
    private final IRequestHost d;
    private final Set<Integer> e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateTodayUserEvaluationPop(Context context, long j, List<String> list, IRequestHost iRequestHost) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(list, "evaluation");
        this.b = j;
        this.f18782c = list;
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
    public static final void a(DateTodayUserEvaluationPop dateTodayUserEvaluationPop, View view) {
        Tracker.onClick(view);
        Intrinsics.e(dateTodayUserEvaluationPop, "this$0");
        if (dateTodayUserEvaluationPop.e.size() > 0) {
            dateTodayUserEvaluationPop.p();
            ArrayList arrayList = new ArrayList();
            for (Number number : dateTodayUserEvaluationPop.e) {
                arrayList.add(dateTodayUserEvaluationPop.f18782c.get(number.intValue()));
            }
            if (!arrayList.isEmpty()) {
                ChatHttpUtils.a(dateTodayUserEvaluationPop.b, arrayList, dateTodayUserEvaluationPop.d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DateTodayUserEvaluationPop dateTodayUserEvaluationPop, TextView textView, View view, int i) {
        Intrinsics.e(dateTodayUserEvaluationPop, "this$0");
        Intrinsics.c(view, "tagView");
        dateTodayUserEvaluationPop.a(view, i);
        if (dateTodayUserEvaluationPop.e.size() > 0) {
            textView.setBackgroundResource(R.drawable.shape_date_today_done);
            textView.setTextColor(dateTodayUserEvaluationPop.getContext().getResources().getColor(BluedPreferences.cK() ? 2131102254 : 2131101780));
            return;
        }
        textView.setBackgroundResource(R.drawable.shape_date_today_cancel);
        textView.setTextColor(BluedSkinUtils.a(dateTodayUserEvaluationPop.getContext(), 2131102264));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DateTodayUserEvaluationPop dateTodayUserEvaluationPop, View view) {
        Tracker.onClick(view);
        Intrinsics.e(dateTodayUserEvaluationPop, "this$0");
        dateTodayUserEvaluationPop.p();
    }

    public void b() {
        super.b();
        FlowLayout findViewById = findViewById(R.id.fl_user_impression);
        findViewById.removeAllViews();
        int size = this.f18782c.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                final TextView textView = (TextView) findViewById(R.id.tv_done);
                findViewById.setOnItemClickListener(new FlowLayout.OnItemClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$DateTodayUserEvaluationPop$wSMZlEqi0Np7neDPg6VhgzxkW-0
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
            View inflate = BottomPopupView.inflate(getContext(), (int) R.layout.item_date_today_evaluation, (ViewGroup) null);
            ((TextView) inflate.findViewById(R.id.tv_evaluation_text)).setText(this.f18782c.get(i2));
            findViewById.addView(inflate);
            i = i2 + 1;
        }
    }

    public int getImplLayoutId() {
        return R.layout.pop_date_today_user_evaluation;
    }

    public final long getTargetUid() {
        return this.b;
    }
}
