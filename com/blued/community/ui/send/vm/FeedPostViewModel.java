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

    /* renamed from: a  reason: collision with root package name */
    private final MutableLiveData<Integer> f20096a = new MutableLiveData<>();
    private final MutableLiveData<Integer> b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private FeedProtos.FeedType f20097c = FeedProtos.FeedType.UNKNOWN_FEED_TYPE;
    private int d;

    public FeedPostViewModel() {
        this.f20096a.setValue(0);
        this.b.setValue(0);
    }

    public final void a(int i) {
        this.d = i;
    }

    public final void a(FeedProtos.FeedType feedType) {
        Intrinsics.e(feedType, "<set-?>");
        this.f20097c = feedType;
    }

    public final MutableLiveData<Integer> d() {
        return this.f20096a;
    }

    public final MutableLiveData<Integer> e() {
        return this.b;
    }

    public final FeedProtos.FeedType f() {
        return this.f20097c;
    }

    public final int g() {
        int i = this.d;
        return i > 0 ? i : AppInfo.m - StatusBarHelper.a(AppInfo.d());
    }
}
