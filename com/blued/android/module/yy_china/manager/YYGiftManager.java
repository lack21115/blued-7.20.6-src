package com.blued.android.module.yy_china.manager;

import android.os.Build;
import android.text.TextUtils;
import com.anythink.china.common.a.a;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.net.FileHttpResponseHandler;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.pool.ThreadExecutor;
import com.blued.android.framework.pool.ThreadManager;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.external_sense_library.manager.StickerDataManager;
import com.blued.android.module.external_sense_library.model.StickerBaseModel;
import com.blued.android.module.yy_china.model.YYGiftModel;
import com.blued.android.module.yy_china.model.YYGiftPackageModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/manager/YYGiftManager.class */
public class YYGiftManager {

    /* renamed from: a  reason: collision with root package name */
    private static YYGiftManager f17541a = new YYGiftManager();
    private Set<String> b = new HashSet();

    private YYGiftManager() {
    }

    public static YYGiftManager a() {
        return f17541a;
    }

    private void b(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ImageFileLoader.a((IRequestHost) null).b(str).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.yy_china.manager.YYGiftManager.2
            @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
            public void onUIFinish(File file, Exception exc) {
                if (file == null || !file.exists()) {
                    synchronized (YYGiftManager.this.b) {
                        if (YYGiftManager.this.b.contains(str)) {
                            return;
                        }
                        YYGiftManager.this.b.add(str);
                        ImageFileLoader.a((IRequestHost) null).a(str).a();
                    }
                }
            }
        }).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<YYGiftPackageModel> list) {
        Collection<YYGiftModel> collection;
        Logger.a("drb", "downLoadStickerRecourse");
        if (list != null) {
            for (YYGiftPackageModel yYGiftPackageModel : list) {
                if (yYGiftPackageModel != null && yYGiftPackageModel.type_name.equals("ar_goods") && (collection = yYGiftPackageModel.goods) != null) {
                    Logger.a("drb", "网络列表个数为： ", Integer.valueOf(collection.size()));
                    ArrayList arrayList = new ArrayList();
                    for (YYGiftModel yYGiftModel : collection) {
                        StickerBaseModel stickerBaseModel = new StickerBaseModel();
                        stickerBaseModel.name = yYGiftModel.anim_code;
                        stickerBaseModel.path = yYGiftModel.resource_url;
                        arrayList.add(stickerBaseModel);
                    }
                    StickerDataManager.init(arrayList, null);
                }
            }
        }
    }

    private void c(String str) {
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
        FileDownloader.a(str, str2, new FileHttpResponseHandler() { // from class: com.blued.android.module.yy_china.manager.YYGiftManager.3
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
    public void c(List<YYGiftPackageModel> list) {
        if (list != null) {
            for (YYGiftPackageModel yYGiftPackageModel : list) {
                if (yYGiftPackageModel != null && TextUtils.equals(yYGiftPackageModel.type_name, "normal_goods")) {
                    List<T> list2 = yYGiftPackageModel.goods;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (list2 != 0 && i2 < list2.size()) {
                            YYGiftModel yYGiftModel = (YYGiftModel) list2.get(i2);
                            b(yYGiftModel.images_static);
                            if (Build.VERSION.SDK_INT <= 18) {
                                b(yYGiftModel.images_gif);
                            } else if (!TextUtils.isEmpty(yYGiftModel.images_mp4)) {
                                c(yYGiftModel.images_mp4);
                            } else if (TextUtils.isEmpty(yYGiftModel.images_apng2)) {
                                b(yYGiftModel.images_gif);
                            } else {
                                b(yYGiftModel.images_apng2);
                            }
                            i = i2 + 1;
                        }
                    }
                }
            }
        }
    }

    public void a(String str) {
        ArrayList arrayList = new ArrayList();
        YYGiftPackageModel yYGiftPackageModel = new YYGiftPackageModel();
        yYGiftPackageModel.type_name = "normal_goods";
        YYGiftModel yYGiftModel = new YYGiftModel();
        yYGiftModel.images_mp4 = str;
        yYGiftPackageModel.goods.add(yYGiftModel);
        arrayList.add(yYGiftPackageModel);
        a(arrayList);
    }

    public void a(List<YYGiftPackageModel> list) {
        a(list, false);
    }

    public void a(final List<YYGiftPackageModel> list, final boolean z) {
        Logger.a("drb", "downloadGiftRes");
        ThreadManager.a().a(new ThreadExecutor("downloadGiftRes") { // from class: com.blued.android.module.yy_china.manager.YYGiftManager.1
            @Override // com.blued.android.framework.pool.ThreadExecutor
            public void execute() {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                YYGiftManager.this.c(arrayList);
                if (z) {
                    YYGiftManager.this.b(arrayList);
                }
            }
        });
    }
}
