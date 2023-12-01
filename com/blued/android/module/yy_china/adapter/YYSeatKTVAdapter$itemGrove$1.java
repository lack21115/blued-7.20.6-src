package com.blued.android.module.yy_china.adapter;

import android.widget.LinearLayout;
import com.amap.api.services.core.AMapException;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.module.live.base.music.model.YYUserSongScoreNoteItem;
import com.blued.android.module.yy_china.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
@DebugMetadata(b = "YYSeatKTVAdapter.kt", c = {}, d = "invokeSuspend", e = "com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter$itemGrove$1")
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/adapter/YYSeatKTVAdapter$itemGrove$1.class */
public final class YYSeatKTVAdapter$itemGrove$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int a;
    final /* synthetic */ YYUserSongScoreNoteItem b;
    final /* synthetic */ YYSeatKTVAdapter c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YYSeatKTVAdapter$itemGrove$1(YYUserSongScoreNoteItem yYUserSongScoreNoteItem, YYSeatKTVAdapter yYSeatKTVAdapter, Continuation<? super YYSeatKTVAdapter$itemGrove$1> continuation) {
        super(2, continuation);
        this.b = yYUserSongScoreNoteItem;
        this.c = yYSeatKTVAdapter;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: a */
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((YYSeatKTVAdapter$itemGrove$1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new YYSeatKTVAdapter$itemGrove$1(this.b, this.c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        IntrinsicsKt.a();
        if (this.a == 0) {
            ResultKt.a(obj);
            if (this.b.b() <= this.c.j() - 5000 || this.b.b() >= this.c.j()) {
                linearLayout = this.c.J;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
            } else {
                linearLayout2 = this.c.J;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                if (this.b.b() + 2000 < this.c.j()) {
                    arrayList6 = this.c.K;
                    ShapeHelper.b((ShapeHelper.ShapeView) arrayList6.get(1), R.color.white);
                } else {
                    arrayList = this.c.K;
                    ShapeHelper.b((ShapeHelper.ShapeView) arrayList.get(1), R.color.white_alpha30);
                }
                if (this.b.b() + ((float) AMapException.CODE_AMAP_ROUTE_OUT_OF_SERVICE) < this.c.j()) {
                    arrayList5 = this.c.K;
                    ShapeHelper.b((ShapeHelper.ShapeView) arrayList5.get(2), R.color.white);
                } else {
                    arrayList2 = this.c.K;
                    ShapeHelper.b((ShapeHelper.ShapeView) arrayList2.get(2), R.color.white_alpha30);
                }
                if (this.b.b() + 4000 < this.c.j()) {
                    arrayList4 = this.c.K;
                    ShapeHelper.b((ShapeHelper.ShapeView) arrayList4.get(3), R.color.white);
                } else {
                    arrayList3 = this.c.K;
                    ShapeHelper.b((ShapeHelper.ShapeView) arrayList3.get(3), R.color.white_alpha30);
                }
            }
            return Unit.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
