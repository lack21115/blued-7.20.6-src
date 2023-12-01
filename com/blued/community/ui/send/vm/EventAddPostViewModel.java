package com.blued.community.ui.send.vm;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.community.http.EventHttpUtils;
import com.blued.community.ui.event.model.EventPostModel;
import com.blued.community.ui.send.model.EventAddPostTypeExtra;
import com.blued.community.ui.send.model.EventAddPostTypeModel;
import com.blued.das.client.feed.FeedProtos;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/vm/EventAddPostViewModel.class */
public final class EventAddPostViewModel extends BaseViewModel {
    public static final Companion a = new Companion(null);
    private String f;
    private String g;
    private FeedProtos.SourcePage b = FeedProtos.SourcePage.UNKNOWN_SOURCE_PAGE;
    private final MutableLiveData<EventPostModel> c = new MutableLiveData<>(new EventPostModel());
    private final MutableLiveData<List<EventAddPostTypeModel>> d = new MutableLiveData<>();
    private final MutableLiveData<String> e = new MutableLiveData<>();
    private final MutableLiveData<EventAddPostTypeExtra> h = new MutableLiveData<>();

    @Metadata
    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/vm/EventAddPostViewModel$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.blued.android.module.common.base.mvvm.BaseViewModel
    public void a(Bundle bundle) {
        super.a(bundle);
        Serializable serializable = bundle == null ? null : bundle.getSerializable("event_from_page");
        if (serializable == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.blued.das.client.feed.FeedProtos.SourcePage");
        }
        this.b = serializable;
    }

    public final void a(final IRequestHost fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        EventHttpUtils.a.a(new BluedUIHttpResponse<BluedEntity<EventAddPostTypeModel, EventAddPostTypeExtra>>(this) { // from class: com.blued.community.ui.send.vm.EventAddPostViewModel$getEventType$1
            final /* synthetic */ EventAddPostViewModel b;
            private List<EventAddPostTypeModel> c;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(IRequestHost.this);
                this.b = this;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIFinish(boolean z) {
                super.onUIFinish(z);
                this.b.g().setValue(this.c);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<EventAddPostTypeModel, EventAddPostTypeExtra> bluedEntity) {
                this.c = bluedEntity == null ? null : bluedEntity.data;
                this.b.k().setValue(bluedEntity == null ? null : bluedEntity.extra);
            }
        }, fragmentActive);
    }

    public final void a(String str) {
        int f = f();
        if (f == 1) {
            this.g = str;
        } else if (f != 2) {
        } else {
            this.f = str;
        }
    }

    public final FeedProtos.SourcePage d() {
        return this.b;
    }

    public final EventPostModel e() {
        MutableLiveData<EventPostModel> mutableLiveData = this.c;
        if (mutableLiveData.getValue() == null) {
            mutableLiveData.setValue(new EventPostModel());
        }
        Object value = mutableLiveData.getValue();
        Intrinsics.a(value);
        EventPostModel eventPostModel = (EventPostModel) value;
        Intrinsics.c(eventPostModel, "eventPost.let {\n        … it.value!!\n            }");
        return eventPostModel;
    }

    public final int f() {
        return e().mode_id;
    }

    public final MutableLiveData<List<EventAddPostTypeModel>> g() {
        return this.d;
    }

    public final MutableLiveData<String> h() {
        return this.e;
    }

    public final String i() {
        return this.f;
    }

    public final String j() {
        return this.g;
    }

    public final MutableLiveData<EventAddPostTypeExtra> k() {
        return this.h;
    }

    public final int l() {
        Integer offline_limit_day;
        int intValue;
        EventAddPostTypeExtra eventAddPostTypeExtra;
        Integer online_limit_day;
        int i = e().mode_id;
        if (i != 1) {
            if (i == 2 && (eventAddPostTypeExtra = (EventAddPostTypeExtra) this.h.getValue()) != null && (online_limit_day = eventAddPostTypeExtra.getOnline_limit_day()) != null) {
                intValue = online_limit_day.intValue();
            }
            intValue = 60;
        } else {
            EventAddPostTypeExtra eventAddPostTypeExtra2 = (EventAddPostTypeExtra) this.h.getValue();
            if (eventAddPostTypeExtra2 != null && (offline_limit_day = eventAddPostTypeExtra2.getOffline_limit_day()) != null) {
                intValue = offline_limit_day.intValue();
            }
            intValue = 60;
        }
        if (intValue <= 0) {
            return 60;
        }
        return intValue;
    }

    public final int m() {
        Integer offline_limit_num;
        Integer online_limit_num;
        int i = e().mode_id;
        if (i == 1) {
            EventAddPostTypeExtra eventAddPostTypeExtra = (EventAddPostTypeExtra) this.h.getValue();
            if (eventAddPostTypeExtra == null || (offline_limit_num = eventAddPostTypeExtra.getOffline_limit_num()) == null) {
                return 100;
            }
            return offline_limit_num.intValue();
        } else if (i != 2) {
            return Math.min(100, 100);
        } else {
            EventAddPostTypeExtra eventAddPostTypeExtra2 = (EventAddPostTypeExtra) this.h.getValue();
            if (eventAddPostTypeExtra2 == null || (online_limit_num = eventAddPostTypeExtra2.getOnline_limit_num()) == null) {
                return 100;
            }
            return online_limit_num.intValue();
        }
    }

    public final void n() {
        int f = f();
        if (f == 1) {
            this.e.setValue(this.g);
        } else if (f != 2) {
        } else {
            this.e.setValue(this.f);
        }
    }
}
