package com.blued.android.module.live_china.fragment;

import android.graphics.drawable.ColorDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.module.live_china.databinding.LiveGiftSetTaskItemBinding;
import com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan;
import com.blued.android.module.live_china.model.LiveGiftSetTaskModel;
import com.blued.android.module.live_china.utils.dslspannable.DslSpannableStringBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/fragment/LiveGiftSetItemFragment$addTask$1$2.class */
public final class LiveGiftSetItemFragment$addTask$1$2 extends Lambda implements Function1<DslSpannableStringBuilder, Unit> {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ Ref.ObjectRef<LiveGiftSetTaskItemBinding> d;
    final /* synthetic */ LiveGiftSetItemFragment e;
    final /* synthetic */ LiveGiftSetTaskModel f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveGiftSetItemFragment$addTask$1$2(int i, int i2, int i3, Ref.ObjectRef<LiveGiftSetTaskItemBinding> objectRef, LiveGiftSetItemFragment liveGiftSetItemFragment, LiveGiftSetTaskModel liveGiftSetTaskModel) {
        super(1);
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = objectRef;
        this.e = liveGiftSetItemFragment;
        this.f = liveGiftSetTaskModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Ref.ObjectRef taskVB, int i, int i2, LiveGiftSetItemFragment this$0, LiveGiftSetTaskModel info, int i3, int i4) {
        Intrinsics.e(taskVB, "$taskVB");
        Intrinsics.e(this$0, "this$0");
        Intrinsics.e(info, "$info");
        ImageView imageView = ((LiveGiftSetTaskItemBinding) taskVB.a).a;
        if (imageView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i2);
        layoutParams.leftMargin = i3;
        layoutParams.topMargin = i4;
        imageView.setLayoutParams(layoutParams);
        ImageLoader.a(this$0.getFragmentActive(), info.getIcon()).g().g(-1).a(((LiveGiftSetTaskItemBinding) taskVB.a).a);
    }

    public final void a(DslSpannableStringBuilder buildSpannableString) {
        Intrinsics.e(buildSpannableString, "$this$buildSpannableString");
        ColorDrawable colorDrawable = new ColorDrawable();
        int i = this.a;
        final int i2 = this.b;
        final int i3 = this.c;
        final Ref.ObjectRef<LiveGiftSetTaskItemBinding> objectRef = this.d;
        final LiveGiftSetItemFragment liveGiftSetItemFragment = this.e;
        final LiveGiftSetTaskModel liveGiftSetTaskModel = this.f;
        buildSpannableString.a(colorDrawable, i, 0, i2, i3, new VerticalCenterImageSpan.SpanDrawCallback() { // from class: com.blued.android.module.live_china.fragment.-$$Lambda$LiveGiftSetItemFragment$addTask$1$2$jOXzaHqdcA_nEjdV6ZzLGh9_2is
            @Override // com.blued.android.module.live_china.liveForMsg.ui.VerticalCenterImageSpan.SpanDrawCallback
            public final void drawFinish(int i4, int i5) {
                LiveGiftSetItemFragment$addTask$1$2.a(Ref.ObjectRef.this, i2, i3, liveGiftSetItemFragment, liveGiftSetTaskModel, i4, i5);
            }
        });
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(DslSpannableStringBuilder dslSpannableStringBuilder) {
        a(dslSpannableStringBuilder);
        return Unit.a;
    }
}
