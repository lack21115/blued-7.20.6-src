package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.R;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.ui.msg.manager.DateTodayManager;
import com.soft.blued.ui.msg.model.DateTodayPurposeModel;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.StringUtils;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/DateTodayPurposePop.class */
public final class DateTodayPurposePop extends BottomPopupView {
    private final IRequestHost b;

    /* renamed from: c  reason: collision with root package name */
    private final List<DateTodayPurposeModel> f32471c;
    private TextView d;
    private Set<String> e;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/DateTodayPurposePop$PurposeAdapter.class */
    public final class PurposeAdapter extends BaseQuickAdapter<DateTodayPurposeModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DateTodayPurposePop f32472a;
        private final IRequestHost b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PurposeAdapter(DateTodayPurposePop this$0, IRequestHost iRequestHost) {
            super((int) R.layout.item_date_today_purpose);
            Intrinsics.e(this$0, "this$0");
            this.f32472a = this$0;
            this.b = iRequestHost;
        }

        public final IRequestHost a() {
            return this.b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, DateTodayPurposeModel dateTodayPurposeModel) {
            if (baseViewHolder == null) {
                return;
            }
            DateTodayPurposePop dateTodayPurposePop = this.f32472a;
            if (dateTodayPurposeModel == null) {
                return;
            }
            ImageLoader.a(a(), dateTodayPurposeModel.getIcon()).a((ImageView) baseViewHolder.getView(R.id.iv_item_icon));
            ((TextView) baseViewHolder.getView(2131371752)).setText(dateTodayPurposeModel.getTitle());
            ((LinearLayout) baseViewHolder.getView(2131367942)).setBackgroundResource(dateTodayPurposePop.e.contains(dateTodayPurposeModel.getTitle()) ? 2131236425 : 2131236424);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateTodayPurposePop(Context context, IRequestHost iRequestHost, List<DateTodayPurposeModel> data) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(data, "data");
        this.b = iRequestHost;
        this.f32471c = data;
        this.e = new LinkedHashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DateTodayPurposePop this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        DateTodayManager.f32404a.c(System.currentTimeMillis());
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DateTodayPurposePop this$0, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(this$0, "this$0");
        String title = this$0.f32471c.get(i).getTitle();
        if (this$0.e.contains(title)) {
            this$0.e.remove(title);
        } else {
            this$0.e.add(title);
        }
        baseQuickAdapter.notifyItemChanged(i);
        if (this$0.e.size() > 0) {
            TextView textView = this$0.d;
            if (textView != null) {
                textView.setBackgroundResource(R.drawable.shape_date_today_done);
            }
            TextView textView2 = this$0.d;
            if (textView2 == null) {
                return;
            }
            textView2.setTextColor(this$0.getContext().getResources().getColor(BluedPreferences.cK() ? 2131102254 : 2131101780));
            return;
        }
        TextView textView3 = this$0.d;
        if (textView3 != null) {
            textView3.setBackgroundResource(R.drawable.shape_date_today_cancel);
        }
        TextView textView4 = this$0.d;
        if (textView4 == null) {
            return;
        }
        textView4.setTextColor(BluedSkinUtils.a(this$0.getContext(), 2131102264));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DateTodayPurposePop this$0, View view) {
        Tracker.onClick(view);
        Intrinsics.e(this$0, "this$0");
        DateTodayManager.f32404a.p();
        this$0.p();
        if (!this$0.e.isEmpty()) {
            this$0.d();
            ChatHttpUtils.a(CollectionsKt.f(this$0.e), this$0.b);
        }
    }

    private final void c() {
        String v = DateTodayManager.f32404a.v();
        if (v == null || v.length() == 0) {
            return;
        }
        List b = StringsKt.b((CharSequence) v, new String[]{","}, false, 0, 6, (Object) null);
        if (true ^ b.isEmpty()) {
            this.e = CollectionsKt.k((Iterable) b);
        }
    }

    private final void d() {
        if (this.e.size() > 0) {
            String text = StringUtils.a(CollectionsKt.f(this.e));
            String str = text;
            if (str == null || str.length() == 0) {
                return;
            }
            DateTodayManager dateTodayManager = DateTodayManager.f32404a;
            Intrinsics.c(text, "text");
            dateTodayManager.e(text);
        }
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public void b() {
        super.b();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_content);
        PurposeAdapter purposeAdapter = new PurposeAdapter(this, this.b);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(purposeAdapter);
        c();
        purposeAdapter.setNewData(this.f32471c);
        purposeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$DateTodayPurposePop$ERnon-zNn2eqgv7FHE370EpmFd4
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                DateTodayPurposePop.a(DateTodayPurposePop.this, baseQuickAdapter, view, i);
            }
        });
        ((ImageView) findViewById(2131365207)).setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$DateTodayPurposePop$84qUfZLo97mwg-PSCtiNbNesSEY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DateTodayPurposePop.a(DateTodayPurposePop.this, view);
            }
        });
        TextView textView = (TextView) findViewById(2131371293);
        this.d = textView;
        if (textView == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.soft.blued.ui.msg.pop.-$$Lambda$DateTodayPurposePop$zJtrRufbCAvVoczdDXBPZ5bIoaU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DateTodayPurposePop.b(DateTodayPurposePop.this, view);
            }
        });
    }

    @Override // com.blued.android.framework.ui.xpop.core.BottomPopupView, com.blued.android.framework.ui.xpop.core.BasePopupView
    public int getImplLayoutId() {
        return R.layout.pop_date_today_purpose;
    }
}
