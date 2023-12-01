package com.blued.android.module.yy_china.lrc;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.databinding.ViewYyLyricLayoutBinding;
import com.blued.android.module.yy_china.lrc.model.LineInfo;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/lrc/BluedLyricView.class */
public final class BluedLyricView extends FrameLayout {
    private ViewYyLyricLayoutBinding a;
    private WordsAdapter b;

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/lrc/BluedLyricView$WordsAdapter.class */
    public final class WordsAdapter extends BaseQuickAdapter<LineInfo, BaseViewHolder> {
        final /* synthetic */ BluedLyricView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WordsAdapter(BluedLyricView this$0) {
            super(R.layout.item_yy_lyric);
            Intrinsics.e(this$0, "this$0");
            this.a = this$0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: a */
        public void convert(BaseViewHolder baseViewHolder, LineInfo lineInfo) {
            TextView textView = baseViewHolder == null ? null : (TextView) baseViewHolder.getView(R.id.tv_words);
            if (textView == null) {
                return;
            }
            textView.setText(lineInfo == null ? null : lineInfo.getContent());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BluedLyricView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.e(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BluedLyricView(final Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.e(context, "context");
        ViewYyLyricLayoutBinding a = ViewYyLyricLayoutBinding.a(LayoutInflater.from(getContext()), this, true);
        Intrinsics.c(a, "inflate(LayoutInflater.from(context), this, true)");
        this.a = a;
        this.b = new WordsAdapter(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context) { // from class: com.blued.android.module.yy_china.lrc.BluedLyricView$lrcManager$1
            final /* synthetic */ Context a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(context);
                this.a = context;
            }

            public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
                final Context context2 = recyclerView == null ? null : recyclerView.getContext();
                RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(context2) { // from class: com.blued.android.module.yy_china.lrc.BluedLyricView$lrcManager$1$smoothScrollToPosition$smoothScroller$1
                    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                        Integer valueOf = displayMetrics == null ? null : Integer.valueOf(displayMetrics.densityDpi);
                        Intrinsics.a(valueOf);
                        return 150.0f / valueOf.intValue();
                    }
                };
                if (i2 != -1) {
                    smoothScroller.setTargetPosition(i2);
                    startSmoothScroll(smoothScroller);
                }
            }
        };
        layoutManager.setOrientation(1);
        this.a.a.setLayoutManager(layoutManager);
        this.a.a.setAdapter(this.b);
        WordsAdapter wordsAdapter = this.b;
        if (wordsAdapter == null) {
            return;
        }
        wordsAdapter.bindToRecyclerView(this.a.a);
    }

    private final View a(int i) {
        WordsAdapter wordsAdapter = this.b;
        if (wordsAdapter == null) {
            return null;
        }
        return wordsAdapter.getViewByPosition(i, R.id.tv_words);
    }

    public final List<LineInfo> getAdapterData() {
        WordsAdapter wordsAdapter = this.b;
        if (wordsAdapter == null) {
            return null;
        }
        return wordsAdapter.getData();
    }

    public final ViewYyLyricLayoutBinding getBinding() {
        return this.a;
    }

    public final void setBinding(ViewYyLyricLayoutBinding viewYyLyricLayoutBinding) {
        Intrinsics.e(viewYyLyricLayoutBinding, "<set-?>");
        this.a = viewYyLyricLayoutBinding;
    }

    public final void setHighlightWord(long j) {
        int i;
        List data;
        WordsAdapter wordsAdapter = this.b;
        int i2 = 0;
        if (wordsAdapter == null || (data = wordsAdapter.getData()) == null) {
            i = 0;
        } else {
            int size = data.size() - 1;
            int size2 = data.size();
            i2 = 0;
            for (int i3 = 0; i3 < size2; i3++) {
                LineInfo lineInfo = (LineInfo) data.get(i3);
                Long valueOf = lineInfo == null ? null : Long.valueOf(lineInfo.getStart());
                Intrinsics.a(valueOf);
                if (valueOf.longValue() > j) {
                    break;
                }
                View a = a(i3);
                if (a != null) {
                    TextView textView = (TextView) a;
                    textView.setAlpha(0.4f);
                    textView.setTextSize(14.0f);
                }
                i2 = i3;
            }
            i = size;
        }
        View a2 = a(i2);
        if (a2 != null) {
            TextView textView2 = (TextView) a2;
            textView2.setAlpha(1.0f);
            textView2.setTextSize(16.0f);
        }
        int i4 = i2 + 1;
        if (i4 <= i) {
            i = i4;
        }
        this.a.a.smoothScrollToPosition(i);
    }

    public final void setWords(List<LineInfo> list) {
        WordsAdapter wordsAdapter = this.b;
        if (wordsAdapter == null) {
            return;
        }
        wordsAdapter.setNewData(list);
    }
}
