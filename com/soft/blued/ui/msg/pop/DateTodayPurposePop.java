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
    private final List<DateTodayPurposeModel> f18780c;
    private TextView d;
    private Set<String> e;

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/pop/DateTodayPurposePop$PurposeAdapter.class */
    public final class PurposeAdapter extends BaseQuickAdapter<DateTodayPurposeModel, BaseViewHolder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DateTodayPurposePop f18781a;
        private final IRequestHost b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PurposeAdapter(DateTodayPurposePop dateTodayPurposePop, IRequestHost iRequestHost) {
            super((int) R.layout.item_date_today_purpose);
            Intrinsics.e(dateTodayPurposePop, "this$0");
            this.f18781a = dateTodayPurposePop;
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
            DateTodayPurposePop dateTodayPurposePop = this.f18781a;
            if (dateTodayPurposeModel == null) {
                return;
            }
            ImageLoader.a(a(), dateTodayPurposeModel.getIcon()).a((ImageView) baseViewHolder.getView(R.id.iv_item_icon));
            ((TextView) baseViewHolder.getView(R.id.tv_item_text)).setText(dateTodayPurposeModel.getTitle());
            ((LinearLayout) baseViewHolder.getView(R.id.ll_item_root)).setBackgroundResource(dateTodayPurposePop.e.contains(dateTodayPurposeModel.getTitle()) ? 2131236425 : 2131236424);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateTodayPurposePop(Context context, IRequestHost iRequestHost, List<DateTodayPurposeModel> list) {
        super(context);
        Intrinsics.e(context, "context");
        Intrinsics.e(list, "data");
        this.b = iRequestHost;
        this.f18780c = list;
        this.e = new LinkedHashSet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DateTodayPurposePop dateTodayPurposePop, View view) {
        Tracker.onClick(view);
        Intrinsics.e(dateTodayPurposePop, "this$0");
        DateTodayManager.f18714a.c(System.currentTimeMillis());
        dateTodayPurposePop.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(DateTodayPurposePop dateTodayPurposePop, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.e(dateTodayPurposePop, "this$0");
        String title = dateTodayPurposePop.f18780c.get(i).getTitle();
        if (dateTodayPurposePop.e.contains(title)) {
            dateTodayPurposePop.e.remove(title);
        } else {
            dateTodayPurposePop.e.add(title);
        }
        baseQuickAdapter.notifyItemChanged(i);
        if (dateTodayPurposePop.e.size() > 0) {
            TextView textView = dateTodayPurposePop.d;
            if (textView != null) {
                textView.setBackgroundResource(R.drawable.shape_date_today_done);
            }
            TextView textView2 = dateTodayPurposePop.d;
            if (textView2 == null) {
                return;
            }
            textView2.setTextColor(dateTodayPurposePop.getContext().getResources().getColor(BluedPreferences.cK() ? 2131102254 : 2131101780));
            return;
        }
        TextView textView3 = dateTodayPurposePop.d;
        if (textView3 != null) {
            textView3.setBackgroundResource(R.drawable.shape_date_today_cancel);
        }
        TextView textView4 = dateTodayPurposePop.d;
        if (textView4 == null) {
            return;
        }
        textView4.setTextColor(BluedSkinUtils.a(dateTodayPurposePop.getContext(), 2131102264));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DateTodayPurposePop dateTodayPurposePop, View view) {
        Tracker.onClick(view);
        Intrinsics.e(dateTodayPurposePop, "this$0");
        DateTodayManager.f18714a.p();
        dateTodayPurposePop.p();
        if (!dateTodayPurposePop.e.isEmpty()) {
            dateTodayPurposePop.d();
            ChatHttpUtils.a(CollectionsKt.f(dateTodayPurposePop.e), dateTodayPurposePop.b);
        }
    }

    private final void c() {
        String v = DateTodayManager.f18714a.v();
        if (v == null || v.length() == 0) {
            return;
        }
        List b = StringsKt.b(v, new String[]{","}, false, 0, 6, (Object) null);
        if (true ^ b.isEmpty()) {
            this.e = CollectionsKt.k(b);
        }
    }

    private final void d() {
        if (this.e.size() > 0) {
            String a2 = StringUtils.a(CollectionsKt.f(this.e));
            String str = a2;
            if (str == null || str.length() == 0) {
                return;
            }
            DateTodayManager dateTodayManager = DateTodayManager.f18714a;
            Intrinsics.c(a2, "text");
            dateTodayManager.e(a2);
        }
    }

    public void b() {
        super.b();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_content);
        PurposeAdapter purposeAdapter = new PurposeAdapter(this, this.b);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(purposeAdapter);
        c();
        purposeAdapter.setNewData(this.f18780c);
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
        TextView textView = (TextView) findViewById(R.id.tv_done);
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

    public int getImplLayoutId() {
        return R.layout.pop_date_today_purpose;
    }
}
