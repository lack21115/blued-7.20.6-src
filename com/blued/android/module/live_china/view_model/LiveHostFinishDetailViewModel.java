package com.blued.android.module.live_china.view_model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.live_china.model.LiveCloseInfoModel;
import com.blued.android.module.live_china.model.LiveFinishData;
import com.blued.android.module.live_china.model.LiveFinishPageData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view_model/LiveHostFinishDetailViewModel.class */
public final class LiveHostFinishDetailViewModel extends BaseViewModel {
    private final MutableLiveData<List<LiveFinishData>> a = new MutableLiveData<>();
    private final MutableLiveData<LiveCloseInfoModel> b = new MutableLiveData<>();
    private LiveFinishPageData c = new LiveFinishPageData(1, true);
    private ArrayList<LiveFinishData> d = new ArrayList<>();

    @Metadata
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view_model/LiveHostFinishDetailViewModel$ApiState.class */
    public static abstract class ApiState implements Serializable {

        @Metadata
        /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view_model/LiveHostFinishDetailViewModel$ApiState$ApiAudienceFrom.class */
        public static final class ApiAudienceFrom extends ApiState {
            public static final ApiAudienceFrom a = new ApiAudienceFrom();

            private ApiAudienceFrom() {
                super(null);
            }
        }

        @Metadata
        /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view_model/LiveHostFinishDetailViewModel$ApiState$ApiAudiences.class */
        public static final class ApiAudiences extends ApiState {
            public static final ApiAudiences a = new ApiAudiences();

            private ApiAudiences() {
                super(null);
            }
        }

        @Metadata
        /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view_model/LiveHostFinishDetailViewModel$ApiState$ApiComments.class */
        public static final class ApiComments extends ApiState {
            public static final ApiComments a = new ApiComments();

            private ApiComments() {
                super(null);
            }
        }

        @Metadata
        /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view_model/LiveHostFinishDetailViewModel$ApiState$ApiContributors.class */
        public static final class ApiContributors extends ApiState {
            public static final ApiContributors a = new ApiContributors();

            private ApiContributors() {
                super(null);
            }
        }

        @Metadata
        /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view_model/LiveHostFinishDetailViewModel$ApiState$ApiGiverFrom.class */
        public static final class ApiGiverFrom extends ApiState {
            public static final ApiGiverFrom a = new ApiGiverFrom();

            private ApiGiverFrom() {
                super(null);
            }
        }

        @Metadata
        /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view_model/LiveHostFinishDetailViewModel$ApiState$ApiLikes.class */
        public static final class ApiLikes extends ApiState {
            public static final ApiLikes a = new ApiLikes();

            private ApiLikes() {
                super(null);
            }
        }

        @Metadata
        /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view_model/LiveHostFinishDetailViewModel$ApiState$ApiNewFans.class */
        public static final class ApiNewFans extends ApiState {
            public static final ApiNewFans a = new ApiNewFans();

            private ApiNewFans() {
                super(null);
            }
        }

        @Metadata
        /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view_model/LiveHostFinishDetailViewModel$ApiState$ApiNewFollowers.class */
        public static final class ApiNewFollowers extends ApiState {
            public static final ApiNewFollowers a = new ApiNewFollowers();

            private ApiNewFollowers() {
                super(null);
            }
        }

        @Metadata
        /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/view_model/LiveHostFinishDetailViewModel$ApiState$ApiStateInfo.class */
        public static final class ApiStateInfo extends ApiState {
            public static final ApiStateInfo a = new ApiStateInfo();

            private ApiStateInfo() {
                super(null);
            }
        }

        private ApiState() {
        }

        public /* synthetic */ ApiState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void a(ApiState apiState, int i) {
        BuildersKt__Builders_commonKt.a(ViewModelKt.getViewModelScope(this), null, null, new LiveHostFinishDetailViewModel$getInfo$1(apiState, i, this, null), 3, null);
    }

    public final void a(ApiState apiState) {
        Intrinsics.e(apiState, "apiState");
        a(apiState, h());
    }

    public final void a(List<LiveFinishData> data, boolean z) {
        Intrinsics.e(data, "data");
        c(z);
        if (this.c.getPage() == 1) {
            this.d.clear();
        }
        this.d.addAll(data);
        this.a.setValue(this.d);
    }

    public final void b(ApiState apiState) {
        Intrinsics.e(apiState, "apiState");
        a(apiState, i());
    }

    public final boolean c(boolean z) {
        this.c.setHasMore(z);
        return z;
    }

    public final MutableLiveData<LiveCloseInfoModel> d() {
        return this.b;
    }

    public final LiveFinishPageData e() {
        return this.c;
    }

    public final void f() {
        j();
        this.a.setValue(this.d);
    }

    public final MutableLiveData<List<LiveFinishData>> g() {
        return this.a;
    }

    public final int h() {
        this.c.setPage(1);
        this.c.setHasMore(true);
        return this.c.getPage();
    }

    public final int i() {
        LiveFinishPageData liveFinishPageData = this.c;
        liveFinishPageData.setPage(liveFinishPageData.getPage() + 1);
        return this.c.getPage();
    }

    public final int j() {
        LiveFinishPageData liveFinishPageData = this.c;
        liveFinishPageData.setPage(liveFinishPageData.getPage() - 1);
        if (this.c.getPage() < 1) {
            this.c.setPage(1);
        }
        return this.c.getPage();
    }
}
