package com.blued.android.module.yy_china.presenter;

import android.os.Handler;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYMsgKtvMusic;
import com.blued.android.module.yy_china.model.YYRoomModel;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/presenter/YYKtvPresenter$downloadMidi$1.class */
public final class YYKtvPresenter$downloadMidi$1 extends FileHttpResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ YYKtvPresenter f17767a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public YYKtvPresenter$downloadMidi$1(YYKtvPresenter yYKtvPresenter) {
        this.f17767a = yYKtvPresenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(File file, YYKtvPresenter this$0) {
        YYMsgKtvMusic yYMsgKtvMusic;
        Intrinsics.e(file, "$file");
        Intrinsics.e(this$0, "this$0");
        LiveLogUtils.a(Intrinsics.a("Midi --> ", (Object) file.getName()));
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (yYMsgKtvMusic = b.music) != null) {
            yYMsgKtvMusic.completedMidi = true;
        }
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Throwable th) {
        YYMsgKtvMusic yYMsgKtvMusic;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (yYMsgKtvMusic = b.music) != null) {
            yYMsgKtvMusic.completedMidi = false;
        }
        Logger.e("download", "download Midi error: " + th + ".message");
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    /* renamed from: a */
    public void onSuccess(final File file) {
        Intrinsics.e(file, "file");
        Handler n = AppInfo.n();
        final YYKtvPresenter yYKtvPresenter = this.f17767a;
        n.post(new Runnable() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$downloadMidi$1$dmq01uLYV6SvxgOe6R9m7ODkkNQ
            @Override // java.lang.Runnable
            public final void run() {
                YYKtvPresenter$downloadMidi$1.a(File.this, yYKtvPresenter);
            }
        });
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    /* renamed from: a */
    public void onFailure(final Throwable th, int i, File file) {
        super.onFailure(th, i, file);
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.yy_china.presenter.-$$Lambda$YYKtvPresenter$downloadMidi$1$cdmHdiTcFklXyijMIDYwOm9x26k
            @Override // java.lang.Runnable
            public final void run() {
                YYKtvPresenter$downloadMidi$1.a(Throwable.this);
            }
        });
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    public void onFinish() {
    }
}
