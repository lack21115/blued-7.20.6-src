package com.blued.android.module.live_china.manager;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.china.common.a.a;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.net.http.QueueFileDownloader;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.module.external_sense_library.manager.StickerDataManager;
import com.blued.android.module.external_sense_library.model.StickerBaseModel;
import com.blued.android.module.live_china.model.LiveGiftModel;
import com.blued.android.module.live_china.model.LiveGiftPackageModel;
import com.blued.android.module.live_china.same.Logger;
import com.blued.android.module.live_china.utils.LiveRoomHttpUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/LiveGiftManager.class */
public class LiveGiftManager {
    private static LiveGiftManager a = new LiveGiftManager();

    private LiveGiftManager() {
    }

    public static LiveGiftManager a() {
        return a;
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String d = RecyclingUtils.d(str);
        if (TextUtils.isEmpty(d)) {
            return;
        }
        if (!new File(d).exists()) {
            Log.i("===xpp", "downloadFilesAsync url:" + str + "  filePath:" + d);
        }
        QueueFileDownloader.a(new String[]{str}, new String[]{RecyclingUtils.d(str)}, new QueueFileDownloader.QueueFileListener() { // from class: com.blued.android.module.live_china.manager.LiveGiftManager.4
            @Override // com.blued.android.core.net.http.QueueFileDownloader.QueueFileListener
            public void a(int i, int i2, String str2, String str3) {
                ImageFileLoader.a((IRequestHost) null).a(str3, str2).a();
            }
        }, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<LiveGiftPackageModel> list) {
        Collection<LiveGiftModel> collection;
        Logger.a("drb", "downLoadStickerRecourse");
        if (list != null) {
            for (LiveGiftPackageModel liveGiftPackageModel : list) {
                if (liveGiftPackageModel != null && liveGiftPackageModel.packageType == 1 && (collection = liveGiftPackageModel.goods) != null) {
                    Logger.a("drb", "网络列表个数为： ", Integer.valueOf(collection.size()));
                    final ArrayList arrayList = new ArrayList();
                    for (LiveGiftModel liveGiftModel : collection) {
                        StickerBaseModel stickerBaseModel = new StickerBaseModel();
                        stickerBaseModel.name = liveGiftModel.anim_code;
                        stickerBaseModel.path = liveGiftModel.resource_url;
                        arrayList.add(stickerBaseModel);
                    }
                    AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.live_china.manager.LiveGiftManager.3
                        @Override // java.lang.Runnable
                        public void run() {
                            StickerDataManager.init(arrayList, null);
                        }
                    });
                }
            }
        }
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(AppInfo.d().getExternalCacheDir(), "gift");
        if (!file.exists()) {
            file.mkdirs();
        }
        final File file2 = new File(file, Md5.a(str));
        if (file2.exists()) {
            return;
        }
        final String str2 = file2.getPath() + a.e;
        FileDownloader.a(str, str2, new FileHttpResponseHandler() { // from class: com.blued.android.module.live_china.manager.LiveGiftManager.5
            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            /* renamed from: a */
            public void onSuccess(File file3) {
                if (file3 == null || !file3.exists()) {
                    return;
                }
                file3.renameTo(file2);
            }

            @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
            public void onFinish() {
                new File(str2).deleteOnExit();
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<LiveGiftPackageModel> list) {
        if (list != null) {
            for (LiveGiftPackageModel liveGiftPackageModel : list) {
                if (liveGiftPackageModel != null && liveGiftPackageModel.packageType == 1) {
                    List<T> list2 = liveGiftPackageModel.goods;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (list2 != 0 && i2 < list2.size()) {
                            LiveGiftModel liveGiftModel = (LiveGiftModel) list2.get(i2);
                            a(liveGiftModel.images_static);
                            if (Build.VERSION.SDK_INT <= 18) {
                                a(liveGiftModel.images_gif);
                            } else if (!TextUtils.isEmpty(liveGiftModel.images_mp4)) {
                                b(liveGiftModel.images_mp4);
                            } else if (TextUtils.isEmpty(liveGiftModel.images_apng2)) {
                                a(liveGiftModel.images_gif);
                            } else {
                                a(liveGiftModel.images_apng2);
                            }
                            i = i2 + 1;
                        }
                    }
                }
            }
        }
    }

    public void a(final List<LiveGiftPackageModel> list, final boolean z) {
        Logger.a("drb", "downloadGiftRes");
        ThreadManager.a().a(new ThreadExecutor("downloadGiftRes") { // from class: com.blued.android.module.live_china.manager.LiveGiftManager.2
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                LiveGiftManager.this.b(arrayList);
                if (z) {
                    LiveGiftManager.this.a(arrayList);
                }
            }
        });
    }

    public void a(final boolean z) {
        LiveRoomHttpUtils.f(new BluedUIHttpResponse<BluedEntityA<LiveGiftPackageModel>>() { // from class: com.blued.android.module.live_china.manager.LiveGiftManager.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blued.android.framework.http.BluedUIHttpResponse
            /* renamed from: a */
            public void onUIUpdate(BluedEntityA<LiveGiftPackageModel> bluedEntityA) {
                LiveGiftManager.a().a(bluedEntityA.data, z);
            }
        });
    }
}
