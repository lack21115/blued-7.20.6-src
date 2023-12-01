package com.blued.community.ui.video.manager;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.util.Log;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.blued.android.module.player.audio.IAudioPlayer;
import com.blued.android.module.shortvideo.utils.DialogUtils;
import java.io.File;
import java.net.URLEncoder;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/manager/MusicManager.class */
public class MusicManager {

    /* renamed from: a  reason: collision with root package name */
    public static String f20412a = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.community.ui.video.manager.MusicManager$3  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/manager/MusicManager$3.class */
    public class AnonymousClass3 extends FileHttpResponseHandler {

        /* renamed from: a  reason: collision with root package name */
        boolean f20415a = false;
        boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseFragment f20416c;
        final /* synthetic */ ProgressDialog d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ ICallBack g;

        AnonymousClass3(BaseFragment baseFragment, ProgressDialog progressDialog, String str, String str2, ICallBack iCallBack) {
            this.f20416c = baseFragment;
            this.d = progressDialog;
            this.e = str;
            this.f = str2;
            this.g = iCallBack;
        }

        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        /* renamed from: a */
        public void onSuccess(File file) {
            Log.d("chenjiemei", "onSuccess file" + file.getName());
        }

        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        /* renamed from: a */
        public void onFailure(Throwable th, int i, File file) {
            this.f20415a = true;
            super.onFailure(th, i, file);
        }

        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onFinish() {
            super.onFinish();
            this.b = true;
            this.f20416c.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.video.manager.MusicManager.3.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!AnonymousClass3.this.f20415a) {
                        String str = MusicManager.f20412a;
                        if (!str.equalsIgnoreCase(AnonymousClass3.this.e + BridgeUtil.SPLIT_MARK + AnonymousClass3.this.f)) {
                            MusicManager.f20412a = "";
                            ICallBack iCallBack = AnonymousClass3.this.g;
                            iCallBack.a(AnonymousClass3.this.e + BridgeUtil.SPLIT_MARK + AnonymousClass3.this.f);
                        }
                    }
                    DialogUtils.b(AnonymousClass3.this.d);
                }
            });
        }

        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onProgress(final int i, int i2) {
            this.f20416c.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.video.manager.MusicManager.3.2
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass3.this.d.setProgress(i);
                    if (i == 100) {
                        AnonymousClass3.this.f20416c.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.video.manager.MusicManager.3.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AnonymousClass3.this.b || AnonymousClass3.this.f20415a) {
                                    return;
                                }
                                String str = MusicManager.f20412a;
                                if (str.equalsIgnoreCase(AnonymousClass3.this.e + BridgeUtil.SPLIT_MARK + AnonymousClass3.this.f)) {
                                    return;
                                }
                                MusicManager.f20412a = "";
                                DialogUtils.b(AnonymousClass3.this.d);
                                ICallBack iCallBack = AnonymousClass3.this.g;
                                iCallBack.a(AnonymousClass3.this.e + BridgeUtil.SPLIT_MARK + AnonymousClass3.this.f);
                            }
                        }, m.ag);
                    }
                }
            });
            super.onProgress(i, i2);
        }

        @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
        public void onStart() {
            this.f20415a = false;
            this.b = false;
            this.f20416c.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.video.manager.MusicManager.3.1
                @Override // java.lang.Runnable
                public void run() {
                    DialogUtils.a(AnonymousClass3.this.d);
                }
            });
            super.onStart();
        }
    }

    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/manager/MusicManager$ICallBack.class */
    public interface ICallBack {
        void a(String str);
    }

    public static String a() {
        return AppMethods.b("ShortVideoMusic");
    }

    public static String a(String str) {
        return URLEncoder.encode(str.toLowerCase().trim()) + ".mp3";
    }

    public static void a(IAudioPlayer iAudioPlayer) {
        iAudioPlayer.b();
    }

    public static void a(IAudioPlayer iAudioPlayer, String str, String str2) {
        File file;
        if (new File(a(), a(str2)).exists()) {
            str = "file:/" + file.getAbsolutePath();
        }
        iAudioPlayer.a(str).a(true).a();
    }

    public static boolean a(final ProgressDialog progressDialog, BaseFragment baseFragment, String str, String str2, ICallBack iCallBack) {
        final String a2 = a();
        final String a3 = a(str2);
        File file = new File(a2, a3);
        f20412a = "";
        if (file.exists()) {
            iCallBack.a(a2 + BridgeUtil.SPLIT_MARK + a3);
            return false;
        }
        progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.blued.community.ui.video.manager.MusicManager.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MusicManager.f20412a = String.this + BridgeUtil.SPLIT_MARK + a3;
            }
        });
        baseFragment.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.video.manager.MusicManager.2
            @Override // java.lang.Runnable
            public void run() {
                DialogUtils.a(ProgressDialog.this);
            }
        });
        FileDownloader.a(str, a2 + BridgeUtil.SPLIT_MARK + a3, new AnonymousClass3(baseFragment, progressDialog, a2, a3, iCallBack), null);
        return true;
    }
}
