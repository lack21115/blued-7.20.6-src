package com.blued.community.ui.send.vm;

import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.das.client.feed.FeedProtos;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/vm/FeedPostViewModel.class */
public final class FeedPostViewModel extends BaseViewModel {
    private final MutableLiveData<Integer> a = new MutableLiveData<>();
    private final MutableLiveData<Integer> b = new MutableLiveData<>();
    private FeedProtos.FeedType c = FeedProtos.FeedType.UNKNOWN_FEED_TYPE;
    private int d;

    public FeedPostViewModel() {
        this.a.setValue(0);
        this.b.setValue(0);
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(FeedProtos.FeedType feedType) {
        Intrinsics.e(feedType, "<set-?>");
        this.c = feedType;
    }

    public final MutableLiveData<Integer> d() {
        return this.a;
    }

    public final MutableLiveData<Integer> e() {
        return this.b;
    }

    public final FeedProtos.FeedType f() {
        return this.c;
    }

    public final int g() {
        int i = this.d;
        return i > 0 ? i : AppInfo.m - StatusBarHelper.a(AppInfo.d());
    }
}
