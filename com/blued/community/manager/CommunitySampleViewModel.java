package com.blued.community.manager;

import androidx.lifecycle.ViewModelKt;
import com.amap.api.services.district.DistrictSearchQuery;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.common.base.mvi.BaseListViewModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.blued.android.module.common.utils.ReflectionUtils;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.ui.square.model.SignFeedExtra;
import com.blued.community.utils.CityHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/manager/CommunitySampleViewModel.class */
public final class CommunitySampleViewModel extends BaseListViewModel<BluedIngSelfFeed> {
    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(Continuation<? super BluedEntity<BluedIngSelfFeed, SignFeedExtra>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.a(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        LogUtils.c(Intrinsics.a("getSignFeedSet start, ", (Object) Boxing.a(Thread.currentThread().getId())));
        if (getMPage() > 1) {
            Result.Companion companion = Result.f42293a;
            safeContinuation2.resumeWith(Result.f(null));
        }
        FeedHttpUtils.a(new BluedUIHttpResponse<BluedEntity<BluedIngSelfFeed, SignFeedExtra>>() { // from class: com.blued.community.manager.CommunitySampleViewModel$getSignFeedSet$2$1
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                if (!z) {
                    Continuation<BluedEntity<BluedIngSelfFeed, SignFeedExtra>> continuation2 = safeContinuation2;
                    Result.Companion companion2 = Result.f42293a;
                    continuation2.resumeWith(Result.f(null));
                }
                LogUtils.c(Intrinsics.a("getSignFeedSet end, ", (Object) Long.valueOf(Thread.currentThread().getId())));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<BluedIngSelfFeed, SignFeedExtra> parseData) {
                Intrinsics.e(parseData, "parseData");
                if (parseData.extra != null) {
                    Continuation<BluedEntity<BluedIngSelfFeed, SignFeedExtra>> continuation2 = safeContinuation2;
                    Result.Companion companion2 = Result.f42293a;
                    continuation2.resumeWith(Result.f(parseData));
                    return;
                }
                Continuation<BluedEntity<BluedIngSelfFeed, SignFeedExtra>> continuation3 = safeContinuation2;
                Result.Companion companion3 = Result.f42293a;
                continuation3.resumeWith(Result.f(null));
            }
        }, 1, DistrictSearchQuery.KEYWORDS_CITY, CityHelper.a().c(), CityHelper.a().e(), "", "", (IRequestHost) null);
        Object a2 = safeContinuation.a();
        if (a2 == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return a2;
    }

    private final void a() {
        LogUtils.c("使用 requestDataWithContext");
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new CommunitySampleViewModel$requestDataWithContext$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(List<BluedIngSelfFeed> list, BluedEntity<BluedIngSelfFeed, SignFeedExtra> bluedEntity) {
        if (bluedEntity == null) {
            return;
        }
        SignFeedExtra signFeedExtra = bluedEntity.extra;
        int i = signFeedExtra == null ? 0 : signFeedExtra.insert_floor;
        BluedIngSelfFeed bluedIngSelfFeed = new BluedIngSelfFeed();
        ReflectionUtils.a(bluedEntity.getSingleData(), bluedIngSelfFeed);
        bluedIngSelfFeed.signStateList = new ArrayList();
        long j = 0;
        int d = RangesKt.d(5, bluedEntity.data.size());
        for (int i2 = 0; i2 < d; i2++) {
            bluedIngSelfFeed.signStateList.add(bluedEntity.data.get(i2));
            BluedIngSelfFeed bluedIngSelfFeed2 = bluedEntity.data.get(i2);
            j = RangesKt.a(j, CommonStringUtils.c(bluedIngSelfFeed2 == null ? null : bluedIngSelfFeed2.feed_timestamp));
        }
        bluedIngSelfFeed.feed_timestamp = String.valueOf(j);
        if (list == null) {
            return;
        }
        list.add(i, bluedIngSelfFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object b(Continuation<? super BluedEntityA<BluedIngSelfFeed>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.a(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        LogUtils.c(Intrinsics.a("getFeedList start, ", (Object) Boxing.a(Thread.currentThread().getId())));
        FeedHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>() { // from class: com.blued.community.manager.CommunitySampleViewModel$getFeedList$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(null);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
                Continuation<BluedEntityA<BluedIngSelfFeed>> continuation2 = safeContinuation2;
                Result.Companion companion = Result.f42293a;
                continuation2.resumeWith(Result.f(bluedEntityA));
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                if (!z) {
                    Continuation<BluedEntityA<BluedIngSelfFeed>> continuation2 = safeContinuation2;
                    Result.Companion companion = Result.f42293a;
                    continuation2.resumeWith(Result.f(null));
                }
                LogUtils.c(Intrinsics.a("getFeedList end, ", (Object) Long.valueOf(Thread.currentThread().getId())));
            }
        }, String.valueOf(getMPage()), String.valueOf(getMPageSize()), null);
        Object a2 = safeContinuation.a();
        if (a2 == IntrinsicsKt.a()) {
            DebugProbesKt.c(continuation);
        }
        return a2;
    }

    @Override // com.blued.android.module.common.base.mvi.BaseListViewModel
    public void requestData() {
        a();
    }
}
