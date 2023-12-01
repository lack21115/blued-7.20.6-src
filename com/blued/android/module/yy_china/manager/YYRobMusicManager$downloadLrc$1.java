package com.blued.android.module.yy_china.manager;

import android.os.Handler;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.live.base.utils.LiveLogUtils;
import com.blued.android.module.yy_china.model.RobMusicMode;
import com.blued.android.module.yy_china.model.YYBorImJsonBodyInfoMode;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.jeremyliao.liveeventbus.LiveEventBus;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYRobMusicManager$downloadLrc$1.class */
public final class YYRobMusicManager$downloadLrc$1 extends FileHttpResponseHandler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f17571a;
    final /* synthetic */ boolean b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ YYRobMusicManager f17572c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public YYRobMusicManager$downloadLrc$1(String str, boolean z, YYRobMusicManager yYRobMusicManager) {
        this.f17571a = str;
        this.b = z;
        this.f17572c = yYRobMusicManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(File file, String filePath, boolean z, YYRobMusicManager this$0) {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        Intrinsics.e(file, "$file");
        Intrinsics.e(filePath, "$filePath");
        Intrinsics.e(this$0, "this$0");
        LiveLogUtils.a(Intrinsics.a("Lrc --> 抢唱歌词下载成功：", (Object) file.getName()));
        Logger.e("download", Intrinsics.a("lrc fileSucces: ", (Object) filePath));
        RobMusicMode robMusicMode = new RobMusicMode();
        robMusicMode.setFile(file.getAbsolutePath());
        robMusicMode.setHostPlay(z);
        LiveEventBus.get("bor_music_ims_load_lrc").post(robMusicMode);
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (yYBorImJsonBodyInfoMode = b.robMus) != null) {
            yYBorImJsonBodyInfoMode.setCompletedLrc(true);
        }
        if (z) {
            return;
        }
        this$0.m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Throwable th) {
        YYBorImJsonBodyInfoMode yYBorImJsonBodyInfoMode;
        LiveLogUtils.a(Intrinsics.a("Lrc --> 抢唱歌词下载失败：", (Object) (th == null ? null : th.getMessage())));
        YYRoomModel b = YYRoomInfoManager.e().b();
        if (b != null && (yYBorImJsonBodyInfoMode = b.robMus) != null) {
            yYBorImJsonBodyInfoMode.setCompletedMidi(false);
        }
        Logger.e("download", "download lrc error: " + th + ".message");
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    /* renamed from: a */
    public void onSuccess(final File file) {
        Intrinsics.e(file, "file");
        Handler n = AppInfo.n();
        final String str = this.f17571a;
        final boolean z = this.b;
        final YYRobMusicManager yYRobMusicManager = this.f17572c;
        n.post(new Runnable() { // from class: com.blued.android.module.yy_china.manager.-$$Lambda$YYRobMusicManager$downloadLrc$1$aUd4SMAN4Nc9Xj1wYYNvQ_SarpA
            @Override // java.lang.Runnable
            public final void run() {
                YYRobMusicManager$downloadLrc$1.a(File.this, str, z, yYRobMusicManager);
            }
        });
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    /* renamed from: a */
    public void onFailure(final Throwable th, int i, File file) {
        super.onFailure(th, i, file);
        AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.yy_china.manager.-$$Lambda$YYRobMusicManager$downloadLrc$1$NjLWzZTl02u8n6_fyLlOVrT6fAE
            @Override // java.lang.Runnable
            public final void run() {
                YYRobMusicManager$downloadLrc$1.a(Throwable.this);
            }
        });
    }

    @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
    public void onFinish() {
    }
}
