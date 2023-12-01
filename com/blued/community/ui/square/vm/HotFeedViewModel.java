package com.blued.community.ui.square.vm;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.model.BluedIngSelfFeed;
import com.blued.community.model.FeedParse;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/square/vm/HotFeedViewModel.class */
public final class HotFeedViewModel extends BaseViewModel {
    private int b;
    private final MutableLiveData<List<BluedIngSelfFeed>> a = new MutableLiveData<>();
    private final int c = 12;
    private boolean d = true;

    private final void d(ActivityFragmentActive activityFragmentActive) {
        FeedHttpUtils.a(e(activityFragmentActive), String.valueOf(this.b), String.valueOf(this.c), activityFragmentActive);
    }

    private final BluedUIHttpResponse<?> e(final ActivityFragmentActive activityFragmentActive) {
        return new BluedUIHttpResponse<BluedEntityA<BluedIngSelfFeed>>(this) { // from class: com.blued.community.ui.square.vm.HotFeedViewModel$getCallBack$1
            final /* synthetic */ HotFeedViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super("hot_feed", ActivityFragmentActive.this);
                this.b = this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public BluedEntityA<BluedIngSelfFeed> parseData(String response) {
                Intrinsics.e(response, "response");
                BluedEntityA<BluedIngSelfFeed> bluedEntityA = (BluedEntityA) super.parseData(response);
                if (bluedEntityA != null) {
                    if (!bluedEntityA.hasData()) {
                        return bluedEntityA;
                    }
                    for (BluedIngSelfFeed bluedIngSelfFeed : bluedEntityA.data) {
                        if (bluedIngSelfFeed != null) {
                            bluedIngSelfFeed.feedParse = new FeedParse(AppInfo.d(), bluedIngSelfFeed, 18);
                        }
                    }
                }
                return bluedEntityA;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUICache(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
                super.onUICache(bluedEntityA);
                if (bluedEntityA != null) {
                    this.b.d().setValue(bluedEntityA.data);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: b */
            public void onUIUpdate(BluedEntityA<BluedIngSelfFeed> bluedEntityA) {
                if (bluedEntityA == null || !bluedEntityA.hasData()) {
                    this.b.c(false);
                } else {
                    this.b.d().setValue(bluedEntityA.data);
                    this.b.c(bluedEntityA.hasMore());
                }
                HotFeedViewModel hotFeedViewModel = this.b;
                hotFeedViewModel.b(hotFeedViewModel.f());
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                if (!z) {
                    HotFeedViewModel hotFeedViewModel = this.b;
                    hotFeedViewModel.a(hotFeedViewModel.e() - 1);
                }
                this.b.a(z);
            }
        };
    }

    public final void a(int i) {
        this.b = i;
    }

    @Override // com.blued.android.module.common.base.mvvm.BaseViewModel
    public void a(Bundle bundle) {
    }

    public final void a(ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        e(fragmentActive).refresh();
    }

    public final void b(ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.b = 1;
        d(fragmentActive);
    }

    public final void c(ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.b++;
        d(fragmentActive);
    }

    public final void c(boolean z) {
        this.d = z;
    }

    public final MutableLiveData<List<BluedIngSelfFeed>> d() {
        return this.a;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        return this.d;
    }
}
