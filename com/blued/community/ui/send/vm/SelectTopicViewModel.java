package com.blued.community.ui.send.vm;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import com.blued.community.http.FeedHttpUtils;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.topic.adapter.SuperTopicAdapter;
import com.blued.community.ui.topic.model.BluedTopic;
import com.blued.community.ui.topic.model.BluedTopicExtra;
import com.blued.das.client.feed.FeedProtos;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/vm/SelectTopicViewModel.class */
public final class SelectTopicViewModel extends BaseViewModel {
    private int a;
    private String c;
    private int d;
    private int e;
    private boolean b = true;
    private int f = 1;
    private final int g = 20;
    private boolean h = true;
    private List<BluedTopic> i = new ArrayList();
    private final MutableLiveData<List<BluedTopic>> j = new MutableLiveData<>();
    private final MutableLiveData<String> k = new MutableLiveData<>();
    private final MutableLiveData<Boolean> l = new MutableLiveData<>();
    private final MutableLiveData<Boolean> m = new MutableLiveData<>();
    private final BluedUIHttpResponse<?> n = new BluedUIHttpResponse<BluedEntity<BluedTopic, BluedTopicExtra>>() { // from class: com.blued.community.ui.send.vm.SelectTopicViewModel$topicHotCallBack$1
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish(boolean z) {
            int i;
            int i2;
            super.onUIFinish();
            SelectTopicViewModel.this.l().setValue(Boolean.valueOf(z));
            SelectTopicViewModel.this.m().setValue(Boolean.valueOf(z));
            if (z) {
                return;
            }
            i = SelectTopicViewModel.this.f;
            if (i != 1) {
                SelectTopicViewModel selectTopicViewModel = SelectTopicViewModel.this;
                i2 = selectTopicViewModel.f;
                selectTopicViewModel.f = i2 - 1;
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<BluedTopic, BluedTopicExtra> bluedEntity) {
            int i;
            List list;
            List list2;
            List list3;
            if (bluedEntity == null || !bluedEntity.hasData()) {
                return;
            }
            SelectTopicViewModel.this.d(bluedEntity.hasMore());
            i = SelectTopicViewModel.this.f;
            if (i == 1) {
                SelectTopicViewModel selectTopicViewModel = SelectTopicViewModel.this;
                List<BluedTopic> list4 = bluedEntity.data;
                Intrinsics.c(list4, "parseData.data");
                selectTopicViewModel.i = list4;
                MutableLiveData<List<BluedTopic>> j = SelectTopicViewModel.this.j();
                list3 = SelectTopicViewModel.this.i;
                j.setValue(list3);
                return;
            }
            list = SelectTopicViewModel.this.i;
            List<BluedTopic> list5 = bluedEntity.data;
            Intrinsics.c(list5, "parseData.data");
            list.addAll(list5);
            MutableLiveData<List<BluedTopic>> j2 = SelectTopicViewModel.this.j();
            list2 = SelectTopicViewModel.this.i;
            j2.setValue(list2);
        }
    };
    private final BluedUIHttpResponse<?> o = new BluedUIHttpResponse<BluedEntity<BluedTopic, BluedTopicExtra>>() { // from class: com.blued.community.ui.send.vm.SelectTopicViewModel$topicSearchCallBack$1
        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIFinish(boolean z) {
            int i;
            int i2;
            super.onUIFinish();
            SelectTopicViewModel.this.l().setValue(Boolean.valueOf(z));
            SelectTopicViewModel.this.m().setValue(Boolean.valueOf(z));
            if (z) {
                return;
            }
            i = SelectTopicViewModel.this.f;
            if (i != 1) {
                SelectTopicViewModel selectTopicViewModel = SelectTopicViewModel.this;
                i2 = selectTopicViewModel.f;
                selectTopicViewModel.f = i2 - 1;
            }
        }

        @Override // com.blued.android.framework.http.BluedUIHttpResponse
        public void onUIUpdate(BluedEntity<BluedTopic, BluedTopicExtra> bluedEntity) {
            int i;
            List list;
            List list2;
            List list3;
            int i2;
            List list4;
            List list5;
            List list6;
            List list7;
            if (bluedEntity != null) {
                BluedTopicExtra bluedTopicExtra = bluedEntity.extra;
                if (bluedTopicExtra != null && bluedTopicExtra.super_topics_exist == 0) {
                    SelectTopicViewModel.this.l().setValue(true);
                }
                SelectTopicViewModel.this.d(bluedEntity.hasMore());
                if (!bluedEntity.hasData()) {
                    i = SelectTopicViewModel.this.f;
                    if (i == 1) {
                        list = SelectTopicViewModel.this.i;
                        list.clear();
                        if (CommunityServiceManager.a().B()) {
                            BluedTopic bluedTopic = new BluedTopic();
                            bluedTopic.name = bluedTopicExtra.q;
                            bluedTopic.is_local_2b_created = true;
                            bluedTopic.topics_msg = bluedTopicExtra.topics_msg;
                            list3 = SelectTopicViewModel.this.i;
                            list3.add(0, bluedTopic);
                        }
                        MutableLiveData<List<BluedTopic>> j = SelectTopicViewModel.this.j();
                        list2 = SelectTopicViewModel.this.i;
                        j.setValue(list2);
                        return;
                    }
                    return;
                }
                i2 = SelectTopicViewModel.this.f;
                if (i2 != 1 || bluedTopicExtra == null || TextUtils.isEmpty(bluedTopicExtra.q)) {
                    list4 = SelectTopicViewModel.this.i;
                    List<BluedTopic> list8 = bluedEntity.data;
                    Intrinsics.c(list8, "parseData.data");
                    list4.addAll(list8);
                    MutableLiveData<List<BluedTopic>> j2 = SelectTopicViewModel.this.j();
                    list5 = SelectTopicViewModel.this.i;
                    j2.setValue(list5);
                    return;
                }
                SelectTopicViewModel.this.k().setValue(bluedTopicExtra.q);
                SelectTopicViewModel selectTopicViewModel = SelectTopicViewModel.this;
                List<BluedTopic> list9 = bluedEntity.data;
                Intrinsics.c(list9, "parseData.data");
                selectTopicViewModel.i = list9;
                MutableLiveData<List<BluedTopic>> j3 = SelectTopicViewModel.this.j();
                list6 = SelectTopicViewModel.this.i;
                j3.setValue(list6);
                if (bluedTopicExtra.super_topics_exist == 0 && CommunityServiceManager.a().B()) {
                    BluedTopic bluedTopic2 = new BluedTopic();
                    bluedTopic2.name = bluedTopicExtra.q;
                    bluedTopic2.is_local_2b_created = true;
                    bluedTopic2.topics_msg = bluedTopicExtra.topics_msg;
                    list7 = SelectTopicViewModel.this.i;
                    list7.add(0, bluedTopic2);
                }
            }
        }
    };

    public final void a(int i) {
        this.a = i;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void a(boolean z, SuperTopicAdapter superTopicAdapter) {
        int i;
        Intrinsics.e(superTopicAdapter, "superTopicAdapter");
        if (z) {
            this.f = 1;
        } else {
            this.f++;
        }
        if (this.f == 1) {
            this.h = true;
        }
        if (this.h || (i = this.f) == 1) {
            this.k.setValue("");
            FeedHttpUtils.a(AppInfo.d(), this.n, this.f, this.g, (IRequestHost) null);
            return;
        }
        this.f = i - 1;
        AppMethods.a((CharSequence) AppInfo.d().getString(R.string.common_nomore_data));
        superTopicAdapter.loadMoreEnd();
    }

    public final void a(boolean z, String searchKeyWord, SuperTopicAdapter superTopicAdapter) {
        int i;
        Intrinsics.e(searchKeyWord, "searchKeyWord");
        Intrinsics.e(superTopicAdapter, "superTopicAdapter");
        if (z) {
            this.f = 1;
        } else {
            this.f++;
        }
        if (this.f == 1) {
            this.h = true;
        }
        if (this.h || (i = this.f) == 1) {
            EventTrackFeed.g(FeedProtos.Event.SUPER_TOPIC_SEARCH_KEYWORD, searchKeyWord);
            FeedHttpUtils.a(this.o, this.f, this.g, searchKeyWord, (IRequestHost) null);
            return;
        }
        this.f = i - 1;
        AppMethods.d(R.string.common_nomore_data);
        superTopicAdapter.loadMoreEnd();
    }

    public final void b(int i) {
        this.d = i;
    }

    public final void c(int i) {
        this.e = i;
    }

    public final void c(boolean z) {
        this.b = z;
    }

    public final int d() {
        int i = this.a;
        return i > 0 ? i : AppInfo.m - StatusBarHelper.a(AppInfo.d());
    }

    public final void d(boolean z) {
        this.h = z;
    }

    public final boolean e() {
        return this.b;
    }

    public final String f() {
        return this.c;
    }

    public final int g() {
        return this.d;
    }

    public final int h() {
        return this.e;
    }

    public final boolean i() {
        return this.h;
    }

    public final MutableLiveData<List<BluedTopic>> j() {
        return this.j;
    }

    public final MutableLiveData<String> k() {
        return this.k;
    }

    public final MutableLiveData<Boolean> l() {
        return this.l;
    }

    public final MutableLiveData<Boolean> m() {
        return this.m;
    }
}
