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
import com.soft.blued.ui.msg.model.DateTodayFunctionEvaluationModel;
import com.soft.blued.utils.BluedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/DateTodayFunctionalEvaluationPop.class */
public final class DateTodayFunctionalEvaluationPop extends BottomPopupView {
    private final List<DateTodayFunctionEvaluationModel> b;

    /* renamed from: c  reason: collision with root package name */
    private final IRequestHost f32468c;
    private TextView d;
    private Evaluation e;
    private Set<Integer> f;
    private final List<Evaluation> g;
    private final List<View> h;
    private final List<Integer> i;
    private final List<Integer> j;
    private final List<Integer> k;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/DateTodayFunctionalEvaluationPop$Evaluation.class */
    public static final class Evaluation {

        /* renamed from: a  reason: collision with root package name */
        private final String f32469a;
        private final int b;

        /* renamed from: c  reason: collision with root package name */
        private final int f32470c;
        private final List<String> d;
        private boolean e;

        public Evaluation(String title, int i, int i2, List<String> tags, boolean z) {
            Intrinsics.e(title, "title");
            Intrinsics.e(tags, "tags");
            this.f32469a = title;
            this.b = i;
            this.f32470c = i2;
            this.d = tags;
            this.e = z;
        }

        public /* synthetic */ Evaluation(String str, int i, int i2, List list, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, i2, list, (i3 & 16) != 0 ? false : z);
        }

        public final String a() {
            return this.f32469a;
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.f32470c;
        }

        public final List<String> d() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Evaluation) {
                Evaluation evaluation = (Evaluation) obj;
                return Intrinsics.a((Object) this.f32469a, (Object) evaluation.f32469a) && this.b == evaluation.b && this.f32470c == evaluation.f32470c && Intrinsics.a(this.d, evaluation.d) && this.e == evaluation.e;
            }
            return false;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        public int hashCode() {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }

        public String toString() {
            return "Evaluation(title=" + this.f32469a + ", iconNormal=" + this.b + ", iconSelected=" + this.f32470c + ", tags=" + this.d + ", selected=" + this.e + ')';
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateTodayFunctionalEvaluationPop(Context context, List<DateTodayFunctionEvaluationModel> evaluation, IRequestHost iRequestHost) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(evaluation, "evaluation");
        this.b = evaluation;
        this.f32468c = iRequestHost;
        this.f = new LinkedHashSet();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = CollectionsKt.b(Integer.valueOf((int) R.string.date_today_evaluation_a), Integer.valueOf((int) R.string.date_today_evaluation_b), Integer.valueOf((int) R.string.date_today_evaluation_c), Integer.valueOf((int) R.string.date_today_evaluation_d), Integer.valueOf((int) R.string.date_today_evaluation_e));
        this.j = CollectionsKt.b(Integer.valueOf((int) R.drawable.icon_date_today_a_normal), Integer.valueOf((int) R.drawable.icon_date_today_b_normal), Integer.valueOf((int) R.drawable.icon_date_today_c_normal), Integer.valueOf((int) R.drawable.icon_date_today_d_normal), Integer.valueOf((int) R.drawable.icon_date_today_e_normal));
        this.k = CollectionsKt.b(Integer.valueOf((int) R.drawable.icon_date_today_a_selected), Integer.valueOf((int) R.drawable.icon_date_today_b_selected), Integer.valueOf((int) R.drawable.icon_date_today_c_selected), Integer.valueOf((int) R.drawable.icon_date_today_d_selected), Integer.valueOf((int) R.drawable.icon_date_today_e_selected));
    }

    private final void a(View view, int i) {
        TextView textView = (TextView) view.findViewById(R.id.tv_evaluation_text);
        if (this.f.contains(Integer.valueOf(i))) {
            textView.setBackgroundResource(R.drawable.shape_date_today_search_purpose_item);
            textView.setTextColor(getContext().getResources().getColor(BluedPreferences.cK() ? 2131102177 : 2131102263));
            this.f.remove(Integer.valueOf(i));
        } else {
            this.f.add(Integer.valueOf(i));
            textView.setBackgroundResource(R.drawable.shape_date_today_evaluation_item_selected);
            textView.setTextColor(getContext().getResources().getColor(BluedPreferences.cK() ? 2131102073 : 2131102254));
        }
        if (this.f.size() > 0) {
            TextView textView2 = this.d;
            if (textView2 != null) {
                textView2.setBackgroundResource(R.drawable.shape_date_today_done);
            }
            TextView textView3 = this.d;
            if (textView3 == null) {
                return;
            }
            textView3.setTextColor(getContext().getResources().getColor(BluedPreferences.cK() ? 2131102254 : 2131101780));
            return;
        }
        TextView textView4 = this.d;
        if (textView4 != null) {
            textView4.setBackgroundResource(R.drawable.shape_date_today_cancel);
        }
        TextView textView5 = this.d;
        if (textView5 == null) {
            return;
        }
        textView5.setTextColor(BluedSkinUtils.a(getContext(), 2131102264));
    }

    private final void a(View view, Evaluation evaluation, boolean z) {
        TextView textView = (TextView) view.findViewById(R.id.tv_functional_evaluation_text);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_functional_evaluation_icon);
        textView.setText(evaluation.a());
        if (z) {
            textView.setTextColor(getContext().getResources().getColor(BluedPreferences.cK() ? 2131102073 : 2131102203));
            imageView.setImageResource(evaluation.c());
            return;
        }
        textView.setTextColor(getContext().getResources().getColor(2131102006));
        imageView.setImageResource(evaluation.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DateTodayFunctionalEvaluationPop this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        if (this$0.f.size() > 0) {
            this$0.p();
            Evaluation evaluation = this$0.e;
            if (evaluation == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Integer num : this$0.f) {
                arrayList.add(evaluation.d().get(num.intValue()));
            }
            if (!arrayList.isEmpty()) {
                ChatHttpUtils.a(evaluation.a(), arrayList, this$0.f32468c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DateTodayFunctionalEvaluationPop this$0, View tagView, int i) {
        Intrinsics.e(this$0, "this$0");
        Intrinsics.c(tagView, "tagView");
        this$0.a(tagView, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final DateTodayFunctionalEvaluationPop this$0, FlowLayout flowLayout, View itemView, int i) {
        Intrinsics.e(this$0, "this$0");
        Evaluation evaluation = this$0.g.get(i);
        if (Intrinsics.a(this$0.e, evaluation)) {
            this$0.e = null;
            Intrinsics.c(itemView, "itemView");
            this$0.a(itemView, evaluation, false);
            flowLayout.setVisibility(8);
            flowLayout.removeAllViews();
            TextView textView = this$0.d;
            if (textView != null) {
                textView.setBackgroundResource(R.drawable.shape_date_today_cancel);
            }
            TextView textView2 = this$0.d;
            if (textView2 == null) {
                return;
            }
            textView2.setTextColor(BluedSkinUtils.a(this$0.getContext(), 2131102264));
            return;
        }
        this$0.e = evaluation;
        Iterator<View> it = this$0.h.iterator();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                break;
            }
            View next = it.next();
            if (i3 < 0) {
                CollectionsKt.c();
            }
            this$0.a(next, this$0.g.get(i3), false);
            i2 = i3 + 1;
        }
        Intrinsics.c(itemView, "itemView");
        this$0.a(itemView, evaluation, true);
        this$0.f.clear();
        flowLayout.setVisibility(0);
        flowLayout.removeAllViews();
        for (String str : evaluation.d()) {
            View inflate = BottomPopupView.inflate(this$0.getContext(), R.layout.item_date_today_evaluation, null);
            ((TextView) inflate.findViewById(R.id.tv_evaluation_text)).setText(str);
            flowLayout.addView(inflate);
        }
        flowLayout.setOnItemClickListener(new FlowLayout.OnItemClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$DateTodayFunctionalEvaluationPop$E2lj-TMTxnRXwLq2g6CC1waxkfA
            @Override // com.blued.android.module.common.view.FlowLayout.OnItemClickListener
            public final void onItemClick(View view, int i4) {
                DateTodayFunctionalEvaluationPop.a(DateTodayFunctionalEvaluationPop.this, view, i4);
            }
        });
        TextView textView3 = this$0.d;
        if (textView3 != null) {
            textView3.setBackgroundResource(R.drawable.shape_date_today_done);
        }
        TextView textView4 = this$0.d;
        if (textView4 == null) {
            return;
        }
        textView4.setTextColor(this$0.getContext().getResources().getColor(BluedPreferences.cK() ? 2131102254 : 2131101780));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DateTodayFunctionalEvaluationPop this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        this$0.p();
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        List<String> tags;
        super.b();
        Iterator<DateTodayFunctionEvaluationModel> it = this.b.iterator();
        int i = 0;
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                break;
            }
            DateTodayFunctionEvaluationModel next = it.next();
            if (i2 <= this.i.size() && (tags = next.getTags()) != null) {
                List<Evaluation> list = this.g;
                String string = getContext().getResources().getString(this.i.get(i2).intValue());
                Intrinsics.c(string, "context.resources.getString(titles[index])");
                list.add(new Evaluation(string, this.j.get(i2).intValue(), this.k.get(i2).intValue(), tags, false, 16, null));
            }
            i = i2 + 1;
        }
        FlowLayout flowLayout = (FlowLayout) findViewById(R.id.fl_user_satisfaction);
        final FlowLayout flowLayout2 = (FlowLayout) findViewById(R.id.fl_user_impression);
        flowLayout2.setVisibility(8);
        flowLayout.removeAllViews();
        for (Evaluation evaluation : this.g) {
            View view = BottomPopupView.inflate(getContext(), R.layout.item_date_today_functional_evaluation, null);
            List<View> list2 = this.h;
            Intrinsics.c(view, "view");
            list2.add(view);
        }
        Iterator<View> it2 = this.h.iterator();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (!it2.hasNext()) {
                break;
            }
            View next2 = it2.next();
            if (i4 < 0) {
                CollectionsKt.c();
            }
            View view2 = next2;
            a(view2, this.g.get(i4), false);
            flowLayout.addView(view2);
            i3 = i4 + 1;
        }
        flowLayout.setOnItemClickListener(new FlowLayout.OnItemClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$DateTodayFunctionalEvaluationPop$XDDaVoLHIs5330bYZFHMN9hkWzA
            @Override // com.blued.android.module.common.view.FlowLayout.OnItemClickListener
            public final void onItemClick(View view3, int i5) {
                DateTodayFunctionalEvaluationPop.a(DateTodayFunctionalEvaluationPop.this, flowLayout2, view3, i5);
            }
        });
        TextView textView = (TextView) findViewById(2131371293);
        this.d = textView;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$DateTodayFunctionalEvaluationPop$3OW8RoP-MMcGj7P48r-AlPnSMu0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    DateTodayFunctionalEvaluationPop.a(DateTodayFunctionalEvaluationPop.this, view3);
                }
            });
        }
        ((ImageView) findViewById(2131365207)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$DateTodayFunctionalEvaluationPop$VFSa2G2h4O2MEz9JecWx_l21zmI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                DateTodayFunctionalEvaluationPop.b(DateTodayFunctionalEvaluationPop.this, view3);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_date_today_functional_evaluation;
    }
}
