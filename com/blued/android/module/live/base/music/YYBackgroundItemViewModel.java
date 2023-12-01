package com.blued.android.module.live.base.music;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.ui.ActivityFragmentActive;
import com.blued.android.framework.http.BluedHttpTools;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.base.mvvm.BaseViewModel;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.blued.android.module.live.base.manager.YYMusicManager;
import com.blued.android.module.live.base.music.model.YYKtvMusicExtra;
import com.blued.android.module.live.base.music.model.YYKtvMusicModel;
import com.tencent.txcopyrightedmedia.TXCopyrightedMedia;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/music/YYBackgroundItemViewModel.class */
public final class YYBackgroundItemViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    private String f11434a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f11435c;
    private boolean d;
    private String e;
    private String f;
    private final MutableLiveData<List<YYKtvMusicModel>> g = new MutableLiveData<>();
    private final MutableLiveData<List<YYKtvMusicModel>> h = new MutableLiveData<>();
    private final MutableLiveData<Boolean> i = new MutableLiveData<>();
    private final MutableLiveData<Boolean> j = new MutableLiveData<>();
    private final MutableLiveData<Boolean> k = new MutableLiveData<>();
    private final MutableLiveData<Boolean> l = new MutableLiveData<>();
    private final MutableLiveData<Boolean> m = new MutableLiveData<>();
    private final MutableLiveData<Boolean> n = new MutableLiveData<>();
    private String o = "";

    private final void a(boolean z, final ActivityFragmentActive activityFragmentActive) {
        BluedUIHttpResponse<BluedEntity<YYKtvMusicModel, YYKtvMusicExtra>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntity<YYKtvMusicModel, YYKtvMusicExtra>>(this) { // from class: com.blued.android.module.live.base.music.YYBackgroundItemViewModel$getSheetSong$response$1
            final /* synthetic */ YYBackgroundItemViewModel b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(ActivityFragmentActive.this);
                this.b = this;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public boolean onUIFailure(int i, String errorMessage) {
                Intrinsics.e(errorMessage, "errorMessage");
                AppMethods.a((CharSequence) errorMessage);
                this.b.n().postValue(false);
                return true;
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIStart() {
                super.onUIStart();
                this.b.i().postValue(false);
            }

            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            public void onUIUpdate(BluedEntity<YYKtvMusicModel, YYKtvMusicExtra> parseData) {
                Intrinsics.e(parseData, "parseData");
                if (!parseData.hasData()) {
                    this.b.j().postValue(false);
                    return;
                }
                if (StringUtils.b(this.b.o())) {
                    this.b.g().postValue(parseData.data);
                } else {
                    this.b.h().postValue(parseData.data);
                }
                if (StringUtils.b(parseData.extra.ScrollToken)) {
                    this.b.l().postValue(false);
                } else {
                    YYBackgroundItemViewModel yYBackgroundItemViewModel = this.b;
                    String str = parseData.extra.ScrollToken;
                    Intrinsics.c(str, "parseData.extra.ScrollToken");
                    yYBackgroundItemViewModel.c(str);
                    this.b.k().postValue(false);
                }
                Logger.e("music", "response page = " + this.b.o() + "; sheetid = " + ((Object) this.b.d()));
                this.b.m().postValue(false);
            }
        };
        if (z) {
            String str = this.e;
            if (str == null) {
                return;
            }
            a(str, o(), bluedUIHttpResponse, activityFragmentActive);
            return;
        }
        String str2 = this.f11434a;
        if (str2 == null) {
            return;
        }
        String o = o();
        String f = f();
        Intrinsics.a((Object) f);
        a(str2, o, f, bluedUIHttpResponse, activityFragmentActive);
    }

    @Override // com.blued.android.module.common.base.mvvm.BaseViewModel
    public void a(Bundle bundle) {
        super.a(bundle);
        if (bundle == null) {
            return;
        }
        a(bundle.getString("sheetId", "0"));
        this.b = bundle.getString("collectId", "");
        this.f11435c = bundle.getInt("isPersonal", 0);
        c(bundle.getBoolean("searchPage", false));
        b(bundle.getString("roomId", ""));
    }

    public final void a(ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        if (this.d && !TextUtils.isEmpty(this.e)) {
            a(true, fragmentActive);
        } else if (TextUtils.isEmpty(this.f11434a)) {
        } else {
            a(false, fragmentActive);
        }
    }

    public final void a(String str) {
        this.f11434a = str;
    }

    public final void a(String str, ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.e = str;
        if (TextUtils.isEmpty(str)) {
            this.g.postValue(new ArrayList());
        } else {
            b(fragmentActive);
        }
    }

    public final void a(String keyword, String token, BluedUIHttpResponse<?> bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Intrinsics.e(keyword, "keyword");
        Intrinsics.e(token, "token");
        String a2 = Intrinsics.a(BluedHttpUrl.q(), (Object) "/users/chatroom/ktv/search");
        Map<String, String> params = BluedHttpTools.a();
        Intrinsics.c(params, "params");
        params.put("KeyWord", keyword);
        params.put("ScrollToken", token);
        params.put("is_background", "1");
        if (YYMusicManager.f11418a.c().c()) {
            params.put("source_type", "1");
            params.put("live_submitted_uid", YYMusicManager.f11418a.c().d());
            params.put("live_submitted_room_id", YYMusicManager.f11418a.c().e());
        }
        HttpManager.a(a2, bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(params).h();
    }

    public final void a(String PlaylistId, String token, String RoomId, BluedUIHttpResponse<?> bluedUIHttpResponse, ActivityFragmentActive activityFragmentActive) {
        Intrinsics.e(PlaylistId, "PlaylistId");
        Intrinsics.e(token, "token");
        Intrinsics.e(RoomId, "RoomId");
        String a2 = Intrinsics.a(BluedHttpUrl.q(), (Object) "/users/chatroom/ktv/musiclist");
        Map<String, String> params = BluedHttpTools.a();
        Intrinsics.c(params, "params");
        params.put("PlaylistId", PlaylistId);
        params.put("ScrollToken", token);
        params.put(TXCopyrightedMedia.EXT_INFO_ROOM_ID, RoomId);
        params.put("is_background", "1");
        if (YYMusicManager.f11418a.c().c()) {
            params.put("source_type", "1");
            params.put("live_submitted_uid", YYMusicManager.f11418a.c().d());
            params.put("live_submitted_room_id", YYMusicManager.f11418a.c().e());
        }
        HttpManager.a(a2, bluedUIHttpResponse, activityFragmentActive).b(BluedHttpTools.a(true)).a(params).h();
    }

    public final void b(ActivityFragmentActive fragmentActive) {
        Intrinsics.e(fragmentActive, "fragmentActive");
        this.o = "";
        if (this.d && !TextUtils.isEmpty(this.e)) {
            a(true, fragmentActive);
        } else if (TextUtils.isEmpty(this.f11434a)) {
        } else {
            a(false, fragmentActive);
        }
    }

    public final void b(String str) {
        this.f = str;
    }

    public final void c(String str) {
        Intrinsics.e(str, "<set-?>");
        this.o = str;
    }

    public final void c(boolean z) {
        this.d = z;
    }

    public final String d() {
        return this.f11434a;
    }

    public final boolean e() {
        return this.d;
    }

    public final String f() {
        return this.f;
    }

    public final MutableLiveData<List<YYKtvMusicModel>> g() {
        return this.g;
    }

    public final MutableLiveData<List<YYKtvMusicModel>> h() {
        return this.h;
    }

    public final MutableLiveData<Boolean> i() {
        return this.i;
    }

    public final MutableLiveData<Boolean> j() {
        return this.j;
    }

    public final MutableLiveData<Boolean> k() {
        return this.k;
    }

    public final MutableLiveData<Boolean> l() {
        return this.l;
    }

    public final MutableLiveData<Boolean> m() {
        return this.m;
    }

    public final MutableLiveData<Boolean> n() {
        return this.n;
    }

    public final String o() {
        return this.o;
    }
}
