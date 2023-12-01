package com.blued.android.module.live_china.rank;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.live_china.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/rank/LiveRankToolBarView.class */
public final class LiveRankToolBarView extends LinearLayout {
    private final Context a;
    private final LayoutInflater b;
    private LinearLayout c;
    private Function1<? super Integer, Unit> d;
    private List<View> e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveRankToolBarView(Context mContext) {
        this(mContext, null, 0, 6, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LiveRankToolBarView(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 0, 4, null);
        Intrinsics.e(mContext, "mContext");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveRankToolBarView(Context mContext, AttributeSet attributeSet, int i) {
        super(mContext, attributeSet, i);
        Intrinsics.e(mContext, "mContext");
        this.a = mContext;
        LayoutInflater from = LayoutInflater.from(mContext);
        Intrinsics.c(from, "from(mContext)");
        this.b = from;
        this.e = new ArrayList();
    }

    public /* synthetic */ LiveRankToolBarView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LiveRankToolBarView this$0, int i, View view) {
        Intrinsics.e(this$0, "this$0");
        Function1<? super Integer, Unit> function1 = this$0.d;
        Function1<? super Integer, Unit> function12 = function1;
        if (function1 == null) {
            Intrinsics.c("listener");
            function12 = null;
        }
        function12.invoke(Integer.valueOf(i));
    }

    public final void a(String[] titleArray) {
        Intrinsics.e(titleArray, "titleArray");
        this.b.inflate(R.layout.live_rank_list_all_tool_bar_view, this);
        View findViewById = findViewById(R.id.root_view);
        if (findViewById == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
        }
        this.c = (LinearLayout) findViewById;
        int length = titleArray.length;
        int i = 0;
        while (true) {
            final int i2 = i;
            if (i2 >= length) {
                setToolBtnSelect(0);
                return;
            }
            LinearLayout linearLayout = null;
            View singleBar = LayoutInflater.from(this.a).inflate(R.layout.live_tool_bar_component, (ViewGroup) null);
            singleBar.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
            ((TextView) singleBar.findViewById(R.id.text1)).setText(titleArray[i2]);
            singleBar.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.rank.-$$Lambda$LiveRankToolBarView$F4gzDRYelLu2QM965Uv-69X_fnU
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveRankToolBarView.a(LiveRankToolBarView.this, i2, view);
                }
            });
            List<View> list = this.e;
            Intrinsics.c(singleBar, "singleBar");
            list.add(i2, singleBar);
            LinearLayout linearLayout2 = this.c;
            if (linearLayout2 == null) {
                Intrinsics.c("mRootView");
            } else {
                linearLayout = linearLayout2;
            }
            linearLayout.addView(singleBar);
            i = i2 + 1;
        }
    }

    public final void setClickListener(Function1<? super Integer, Unit> listener) {
        Intrinsics.e(listener, "listener");
        this.d = listener;
    }

    public final void setToolBtnSelect(int i) {
        Iterator<View> it = this.e.iterator();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                return;
            }
            View next = it.next();
            if (i3 < 0) {
                CollectionsKt.c();
            }
            View view = next;
            if (i == i3) {
                ((TextView) view.findViewById(R.id.text1)).setAlpha(1.0f);
            } else {
                ((TextView) view.findViewById(R.id.text1)).setAlpha(0.4f);
            }
            i2 = i3 + 1;
        }
    }
}
