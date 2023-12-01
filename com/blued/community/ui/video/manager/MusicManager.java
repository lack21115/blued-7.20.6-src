package com.blued.community.ui.video.manager;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.util.Log;
import com.anythink.expressad.video.module.a.a.m;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.module.player.audio.IAudioPlayer;
import com.blued.android.module.shortvideo.utils.DialogUtils;
import java.io.File;
import java.net.URLEncoder;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/manager/MusicManager.class */
public class MusicManager {

    /* renamed from: a  reason: collision with root package name */
    public static String f6806a = "";

    /* renamed from: com.blued.community.ui.video.manager.MusicManager$3  reason: invalid class name */
    /* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/manager/MusicManager$3.class */
    class AnonymousClass3 extends FileHttpResponseHandler {

        /* renamed from: a  reason: collision with root package name */
        boolean f6809a = false;
        boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseFragment f6810c;
        final /* synthetic */ ProgressDialog d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ ICallBack g;

        AnonymousClass3(BaseFragment baseFragment, ProgressDialog progressDialog, String str, String str2, ICallBack iCallBack) {
            this.f6810c = baseFragment;
            this.d = progressDialog;
            this.e = str;
            this.f = str2;
            this.g = iCallBack;
        }

        /* renamed from: a */
        public void onSuccess(File file) {
            Log.d("chenjiemei", "onSuccess file" + file.getName());
        }

        /* renamed from: a */
        public void onFailure(Throwable th, int i, File file) {
            this.f6809a = true;
            super.onFailure(th, i, file);
        }

        public void onFinish() {
            super.onFinish();
            this.b = true;
            this.f6810c.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.video.manager.MusicManager.3.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!AnonymousClass3.this.f6809a) {
                        String str = MusicManager.f6806a;
                        if (!str.equalsIgnoreCase(AnonymousClass3.this.e + "/" + AnonymousClass3.this.f)) {
                            MusicManager.f6806a = "";
                            ICallBack iCallBack = AnonymousClass3.this.g;
                            iCallBack.a(AnonymousClass3.this.e + "/" + AnonymousClass3.this.f);
                        }
                    }
                    DialogUtils.b(AnonymousClass3.this.d);
                }
            });
        }

        public void onProgress(final int i, int i2) {
            this.f6810c.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.video.manager.MusicManager.3.2
                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass3.this.d.setProgress(i);
                    if (i == 100) {
                        AnonymousClass3.this.f6810c.postDelaySafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.video.manager.MusicManager.3.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (AnonymousClass3.this.b || AnonymousClass3.this.f6809a) {
                                    return;
                                }
                                String str = MusicManager.f6806a;
                                if (str.equalsIgnoreCase(AnonymousClass3.this.e + "/" + AnonymousClass3.this.f)) {
                                    return;
                                }
                                MusicManager.f6806a = "";
                                DialogUtils.b(AnonymousClass3.this.d);
                                ICallBack iCallBack = AnonymousClass3.this.g;
                                iCallBack.a(AnonymousClass3.this.e + "/" + AnonymousClass3.this.f);
                            }
                        }, (long) m.ag);
                    }
                }
            });
            super.onProgress(i, i2);
        }

        public void onStart() {
            this.f6809a = false;
            this.b = false;
            this.f6810c.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.video.manager.MusicManager.3.1
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
        f6806a = "";
        if (file.exists()) {
            iCallBack.a(a2 + "/" + a3);
            return false;
        }
        progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.blued.community.ui.video.manager.MusicManager.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MusicManager.f6806a = a2 + "/" + a3;
            }
        });
        baseFragment.postSafeRunOnUiThread(new Runnable() { // from class: com.blued.community.ui.video.manager.MusicManager.2
            @Override // java.lang.Runnable
            public void run() {
                DialogUtils.a(ProgressDialog.this);
            }
        });
        FileDownloader.a(str, a2 + "/" + a3, new AnonymousClass3(baseFragment, progressDialog, a2, a3, iCallBack), (IRequestHost) null);
        return true;
    }
}
