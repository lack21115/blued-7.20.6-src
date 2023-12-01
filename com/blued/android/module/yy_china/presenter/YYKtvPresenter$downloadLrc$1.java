package com.blued.android.module.yy_china.presenter;

import android.os.Handler;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.adapter.BaseConnectingAdapter;
import com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYMsgKtvMusic;
import com.blued.android.module.yy_china.model.YYRoomModel;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYKtvPresenter$downloadLrc$1.class */
public final class YYKtvPresenter$downloadLrc$1 extends FileHttpResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ YYKtvPresenter f17766a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public YYKtvPresenter$downloadLrc$1(YYKtvPresenter yYKtvPresenter) {
        this.f17766a = yYKtvPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(File file, YYKtvPresenter this$0) {
        YYMsgKtvMusic yYMsgKtvMusic;
        Intrinsics.e(file, "$file");
        Intrinsics.e(this$0, "this$0");
        LiveLogUtils.a(Intrinsics.a("Lrc --> 歌词下载成功：", (Object) file.getName()));
        BaseYYStudioFragment baseYYStudioFragment = this$0.f17634a;
        if (baseYYStudioFragment != null) {
            BaseConnectingAdapter baseConnectingAdapter = baseYYStudioFragment.E;
            if (baseConnectingAdapter == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.blued.android.module.yy_china.adapter.YYSeatKTVAdapter");
            }
            ((YYSeatKTVAdapter) baseConnectingAdapter).a(file);
        }
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (yYMsgKtvMusic = b.music) != null) {
            yYMsgKtvMusic.completedLrc = true;
        }
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Throwable th) {
        YYMsgKtvMusic yYMsgKtvMusic;
        LiveLogUtils.a(Intrinsics.a("Lrc --> 歌词下载失败：", (Object) (th == null ? null : th.getMessage())));
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (yYMsgKtvMusic = b.music) != null) {
            yYMsgKtvMusic.completedMidi = false;
        }
        Logger.e("download", "download lrc error: " + th + ".message");
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    /* renamed from: a */
    public void onSuccess(final File file) {
        Intrinsics.e(file, "file");
        Handler n = AppInfo.n();
        final YYKtvPresenter yYKtvPresenter = this.f17766a;
        n.post(new Runnable() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$downloadLrc$1$ak-DxYGm6xMhgaXwe7vc2Sh6R5o
            @Override // java.lang.Runnable
            public final void run() {
                YYKtvPresenter$downloadLrc$1.a(File.this, yYKtvPresenter);
            }
        });
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    /* renamed from: a */
    public void onFailure(final Throwable th, int i, File file) {
        super.onFailure(th, i, file);
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$downloadLrc$1$gZYDLtFdta77YtvtbIzEgFXl2vc
            @Override // java.lang.Runnable
            public final void run() {
                YYKtvPresenter$downloadLrc$1.a(Throwable.this);
            }
        });
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    public void onFinish() {
    }
}
