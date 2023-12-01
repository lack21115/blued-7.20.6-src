package com.blued.android.module.media.selector.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.media.selector.R;
import com.blued.android.module.media.selector.utils.ThreadPoolHelper;
import com.blued.android.module.player.media.model.MediaInfo;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/utils/ThumbLoader.class */
public class ThumbLoader {
    public static String a;
    private static final String d = ThumbLoader.class.getSimpleName();
    private static ThumbLoader e;
    protected ConcurrentMap<Long, Future> b = new ConcurrentHashMap();
    protected HashMap<ImageView, Long> c = new HashMap<>();

    /* renamed from: com.blued.android.module.media.selector.utils.ThumbLoader$2  reason: invalid class name */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/utils/ThumbLoader$2.class */
    class AnonymousClass2 extends ImageLoadResult {
        final /* synthetic */ ImageView a;
        final /* synthetic */ MediaInfo b;
        final /* synthetic */ LoadOptions c;
        final /* synthetic */ ThumbLoader d;

        @Override // com.blued.android.core.image.ImageLoadResult
        public void a() {
            this.d.a(this.a);
        }

        @Override // com.blued.android.core.image.ImageLoadResult
        public void a(int i, Exception exc) {
            this.d.a(this.a, this.b.id);
            if (this.d.b(this.b.id)) {
                return;
            }
            this.d.a(this.b.id, this.a, new CreateVideoThumsAsynctack(this.b, this.a, this.c));
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/utils/ThumbLoader$CreateVideoThumsAsynctack.class */
    class CreateVideoThumsAsynctack extends ThreadPoolHelper.AlbumThread {
        ImageView c;
        MediaInfo d;
        LoadOptions e;

        public CreateVideoThumsAsynctack(MediaInfo mediaInfo, ImageView imageView, LoadOptions loadOptions) {
            this.d = mediaInfo;
            this.c = imageView;
            this.e = loadOptions;
        }

        /* JADX WARN: Can't wrap try/catch for region: R(16:(19:13|14|15|16|(1:18)|19|20|21|(6:23|24|25|26|27|28)|63|(3:119|120|(3:122|123|124))(41:68|69|70|(5:72|73|74|75|76)|77|78|79|80|81|82|83|84|85|86|87|88|89|90|91|92|93|94|95|96|97|98|99|100|101|102|103|104|105|106|107|108|109|110|111|112|113)|114|(1:116)|117|118|44|45|46|47)|21|(0)|63|(2:65|66)|119|120|(0)|114|(0)|117|118|44|45|46|47) */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:26:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x029a  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x02b5 A[Catch: RuntimeException -> 0x034b, TRY_ENTER, TryCatch #6 {RuntimeException -> 0x034b, blocks: (B:108:0x030b, B:110:0x0311, B:98:0x02c6, B:94:0x02b5, B:96:0x02bb), top: B:132:0x008c }] */
        @Override // com.blued.android.module.media.selector.utils.ThreadPoolHelper.AlbumThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 851
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.media.selector.utils.ThumbLoader.CreateVideoThumsAsynctack.run():void");
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/utils/ThumbLoader$GetVideoThumsAsynctack.class */
    public static class GetVideoThumsAsynctack extends ThreadPoolHelper.AlbumThread {
        OnGetVideoThumsListener c;
        HashMap<String, MediaInfo> d = new HashMap<>();
        List<MediaInfo> e;

        public GetVideoThumsAsynctack(OnGetVideoThumsListener onGetVideoThumsListener, List<MediaInfo> list) {
            this.c = onGetVideoThumsListener;
            this.e = list;
        }

        /* JADX WARN: Code restructure failed: missing block: B:54:0x01bf, code lost:
            if (r0 != null) goto L75;
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x01d3, code lost:
            if (r0 == null) goto L69;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x01d6, code lost:
            r0.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x01dc, code lost:
            r0 = r7.c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:0x01e2, code lost:
            if (r0 == null) goto L72;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x01e5, code lost:
            r0.a(r7.e);
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x01ef, code lost:
            r7.b = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x01f4, code lost:
            return;
         */
        @Override // com.blued.android.module.media.selector.utils.ThreadPoolHelper.AlbumThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 530
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.media.selector.utils.ThumbLoader.GetVideoThumsAsynctack.run():void");
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/utils/ThumbLoader$OnGetVideoThumsListener.class */
    public interface OnGetVideoThumsListener<T> {
        void a(List<T> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ThreadPoolHelper.AlbumThread a(long j, ImageView imageView, ThreadPoolHelper.AlbumThread albumThread) {
        this.b.put(Long.valueOf(j), ThreadPoolHelper.a().b(albumThread));
        return albumThread;
    }

    public static ThumbLoader a() {
        if (e == null) {
            e = new ThumbLoader();
        }
        return e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        Future remove;
        ConcurrentMap<Long, Future> concurrentMap = this.b;
        if (concurrentMap == null || (remove = concurrentMap.remove(Long.valueOf(j))) == null) {
            return;
        }
        remove.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, Bitmap bitmap) {
        for (Map.Entry<ImageView, Long> entry : this.c.entrySet()) {
            if (entry.getValue().longValue() == j) {
                ImageView key = entry.getKey();
                try {
                    if (j == ((Long) key.getTag()).longValue()) {
                        key.setImageBitmap(bitmap);
                    }
                } catch (Exception e2) {
                }
                a(key);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView) {
        this.c.remove(imageView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImageView imageView, long j) {
        this.c.put(imageView, Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || !new File(str2).exists()) {
            return;
        }
        ImageFileLoader.a((IRequestHost) null).a(str, str2).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(long j) {
        return this.b.containsKey(Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(ImageView imageView, long j) {
        Long l = this.c.get(imageView);
        return l != null && l.longValue() == j;
    }

    public void a(final MediaInfo mediaInfo, final ImageView imageView, final LoadOptions loadOptions) {
        if (!TextUtils.isEmpty(mediaInfo.path)) {
            ImageLoader.d(null, mediaInfo.path).b(R.drawable.defaultpicture).a(new ImageLoadResult(null) { // from class: com.blued.android.module.media.selector.utils.ThumbLoader.1
                @Override // com.blued.android.core.image.ImageLoadResult
                public void a() {
                    ThumbLoader.this.a(imageView);
                }

                @Override // com.blued.android.core.image.ImageLoadResult
                public void a(int i, Exception exc) {
                    ThumbLoader.this.a(imageView, mediaInfo.id);
                    if (ThumbLoader.this.b(mediaInfo.id)) {
                        return;
                    }
                    ThumbLoader.this.a(mediaInfo.id, imageView, new CreateVideoThumsAsynctack(mediaInfo, imageView, loadOptions));
                }
            }).a(imageView);
        } else if (!TextUtils.isEmpty(mediaInfo.imgUri)) {
            ImageLoader.b(null, mediaInfo.imgUri).b(loadOptions.b).a(imageView);
            a(imageView);
        } else if (TextUtils.isEmpty(mediaInfo.imagePath)) {
            imageView.setImageResource(R.drawable.defaultpicture);
        } else {
            ImageLoader.d(null, mediaInfo.imagePath).b(loadOptions.b).a(imageView);
            a(imageView);
        }
    }

    public void b() {
        ConcurrentMap<Long, Future> concurrentMap = this.b;
        if (concurrentMap != null) {
            for (Future future : concurrentMap.values()) {
                future.cancel(true);
            }
        }
    }
}
