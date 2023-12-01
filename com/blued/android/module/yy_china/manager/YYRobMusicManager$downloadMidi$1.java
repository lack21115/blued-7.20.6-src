package com.blued.android.module.yy_china.manager;

import android.os.Handler;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.model.YYBorImJsonBodyInfoMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYRobMusicManager$downloadMidi$1.class */
public final class YYRobMusicManager$downloadMidi$1 extends FileHttpResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ YYRobMusicManager f17573a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public YYRobMusicManager$downloadMidi$1(YYRobMusicManager yYRobMusicManager) {
        this.f17573a = yYRobMusicManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(File file, YYRobMusicManager this$0) {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        Intrinsics.e(file, "$file");
        Intrinsics.e(this$0, "this$0");
        LiveLogUtils.a(Intrinsics.a("Midi --> 抢唱 ", (Object) file.getName()));
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (yYBorImJsonBodyInfoMode = b.robMus) != null) {
            yYBorImJsonBodyInfoMode.setCompletedMidi(true);
        }
        this$0.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Throwable th) {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (yYBorImJsonBodyInfoMode = b.robMus) != null) {
            yYBorImJsonBodyInfoMode.setCompletedMidi(false);
        }
        LiveLogUtils.a("Midi --> 抢唱 Midi error: " + th + ".message");
        Logger.e("download", "download Midi error: " + th + ".message");
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    /* renamed from: a */
    public void onSuccess(final File file) {
        Intrinsics.e(file, "file");
        Handler n = AppInfo.n();
        final YYRobMusicManager yYRobMusicManager = this.f17573a;
        n.post(new Runnable() { // from class: com.blued.android.module.yy_china.manager.-$$Lambda$YYRobMusicManager$downloadMidi$1$N0UPqpb44j8wqYszO9PTm88GHm0
            @Override // java.lang.Runnable
            public final void run() {
                YYRobMusicManager$downloadMidi$1.a(File.this, yYRobMusicManager);
            }
        });
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    /* renamed from: a */
    public void onFailure(final Throwable th, int i, File file) {
        super.onFailure(th, i, file);
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.yy_china.manager.-$$Lambda$YYRobMusicManager$downloadMidi$1$ux7hcDs6Y2kSTvG4PtMH0LIjEz0
            @Override // java.lang.Runnable
            public final void run() {
                YYRobMusicManager$downloadMidi$1.a(Throwable.this);
            }
        });
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    public void onFinish() {
    }
}
