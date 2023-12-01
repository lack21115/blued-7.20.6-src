package com.soft.blued.utils;

import androidx.collection.ArrayMap;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.FileHttpResponseHandler;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/VideoLoadController.class */
public class VideoLoadController {
    private static VideoLoadController b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, IVideoController> f21121c = new ArrayMap();

    /* renamed from: a  reason: collision with root package name */
    protected final Set<String> f21120a = new HashSet();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/VideoLoadController$IVideoController.class */
    public interface IVideoController {
        void a(String str);

        void a(String str, int i);

        void a(String str, String str2);
    }

    public static VideoLoadController a() {
        VideoLoadController videoLoadController;
        synchronized (VideoLoadController.class) {
            try {
                if (b == null) {
                    b = new VideoLoadController();
                }
                videoLoadController = b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return videoLoadController;
    }

    public static void a(final String str) {
        Logger.a("VideoLoadController", "loadVideo(), videoUrl:", str);
        if (a().f21120a.contains(str)) {
            return;
        }
        File c2 = FileUtils.c(str);
        if (c2 != null) {
            a().a(str, c2.getAbsolutePath());
            return;
        }
        a().f21120a.add(str);
        FileUtils.a(str, new FileHttpResponseHandler() { // from class: com.soft.blued.utils.VideoLoadController.1
            /* renamed from: a */
            public void onSuccess(File file) {
                VideoLoadController.a().a(str, file.getAbsolutePath());
            }

            /* renamed from: a */
            public void onFailure(Throwable th, int i, File file) {
                super.onFailure(th, i, file);
                VideoLoadController.a().c(str);
            }

            public void onProgress(int i, int i2) {
                super.onProgress(i, i2);
                VideoLoadController.a().a(str, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final int i) {
        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.utils.VideoLoadController.3
            @Override // java.lang.Runnable
            public void run() {
                Logger.a("VideoLoadController", "notifyVideoDownloadProgress(), percent:", Integer.valueOf(i), ", videoUrl:", str);
                IVideoController iVideoController = (IVideoController) VideoLoadController.a().f21121c.get(str);
                if (iVideoController != null) {
                    iVideoController.a(str, i);
                } else {
                    Logger.a("VideoLoadController", "notifyVideoDownloadProgress(), can't find controller");
                }
            }
        });
    }

    public static void a(String str, IVideoController iVideoController) {
        Logger.a("VideoLoadController", "registerVideoController(), videoUrl:", str);
        a().f21121c.put(str, iVideoController);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final String str2) {
        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.utils.VideoLoadController.2
            @Override // java.lang.Runnable
            public void run() {
                Logger.a("VideoLoadController", "notifyVideoDownloadFinished(), videoUrl:", str);
                VideoLoadController a2 = VideoLoadController.a();
                a2.f21120a.remove(str);
                IVideoController iVideoController = (IVideoController) a2.f21121c.get(str);
                if (iVideoController != null) {
                    iVideoController.a(str, str2);
                } else {
                    Logger.a("VideoLoadController", "notifyVideoDownloadFinished(), can't find controller");
                }
            }
        });
    }

    public static void b(String str) {
        File c2 = FileUtils.c(str);
        if (c2 == null || !c2.exists()) {
            return;
        }
        c2.delete();
    }

    public static void b(String str, IVideoController iVideoController) {
        Logger.a("VideoLoadController", "unregisterVideoController(), videoUrl:", str);
        VideoLoadController a2 = a();
        if (a2.f21121c.get(str) == iVideoController) {
            a2.f21121c.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final String str) {
        AppInfo.n().post(new Runnable() { // from class: com.soft.blued.utils.VideoLoadController.4
            @Override // java.lang.Runnable
            public void run() {
                Logger.a("VideoLoadController", "notifyVideoDownloadFailed(), videoUrl:", str);
                VideoLoadController a2 = VideoLoadController.a();
                a2.f21120a.remove(str);
                File c2 = FileUtils.c(str);
                if (c2 != null) {
                    c2.delete();
                }
                IVideoController iVideoController = (IVideoController) a2.f21121c.get(str);
                if (iVideoController != null) {
                    iVideoController.a(str);
                } else {
                    Logger.a("VideoLoadController", "notifyVideoDownloadFailed(), can't find controller");
                }
            }
        });
    }
}
