package com.blued.community.ui.send.vm;

import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.StatusBarHelper;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.player.media.model.MediaInfo;
import com.blued.community.R;
import com.blued.community.auto.CommunityServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/vm/SelectAlbumViewModel.class */
public final class SelectAlbumViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private int f20098a;
    private final MutableLiveData<Integer> b = new MutableLiveData<>();

    /* renamed from: c  reason: collision with root package name */
    private final MutableLiveData<AlbumSelectInfo> f20099c = new MutableLiveData<>();
    private final MutableLiveData<Intent> d = new MutableLiveData<>();
    private final MutableLiveData<String> e = new MutableLiveData<>();
    private boolean f = true;
    private final MutableLiveData<Boolean> g = new MutableLiveData<>();

    public final void a(int i) {
        this.f20098a = i;
    }

    public final void a(String imagePath) {
        Intrinsics.e(imagePath, "imagePath");
        if (this.f20099c.getValue() == null) {
            this.f20099c.setValue(new AlbumSelectInfo());
        }
        MediaInfo mediaInfo = new MediaInfo();
        mediaInfo.imagePath = imagePath;
        AlbumSelectInfo value = this.f20099c.getValue();
        Intrinsics.a(value);
        value.b(mediaInfo);
    }

    public final void c(boolean z) {
        this.f = z;
    }

    public final int d() {
        int i = this.f20098a;
        return i > 0 ? i : AppInfo.m - StatusBarHelper.a(AppInfo.d());
    }

    public final MutableLiveData<Integer> e() {
        return this.b;
    }

    public final MutableLiveData<AlbumSelectInfo> f() {
        return this.f20099c;
    }

    public final MutableLiveData<Intent> g() {
        return this.d;
    }

    public final MutableLiveData<String> h() {
        return this.e;
    }

    public final boolean i() {
        return this.f;
    }

    public final MutableLiveData<Boolean> j() {
        return this.g;
    }

    public final String k() {
        List<MediaInfo> c2;
        StringBuilder sb = new StringBuilder();
        AlbumSelectInfo value = this.f20099c.getValue();
        if (value != null && (c2 = value.c()) != null) {
            for (MediaInfo mediaInfo : c2) {
                if (!TextUtils.isEmpty(mediaInfo.imagePath)) {
                    sb.append(mediaInfo.imagePath);
                    sb.append(",");
                }
            }
        }
        String sb2 = sb.toString();
        Intrinsics.c(sb2, "stringBuilder.toString()");
        return sb2;
    }

    public final boolean l() {
        return CommunityServiceManager.a().n() || CommunityServiceManager.a().l();
    }

    public final void m() {
        if (l()) {
            AppMethods.d(R.string.feed_post_is_audio_occupy_tip);
        }
    }
}
