package com.soft.blued.ui.user.utils;

import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewGroupKt;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.net.http.FileDownloader;
import com.blued.android.core.utils.Md5;
import com.blued.android.framework.utils.NetworkUtils;
import com.soft.blued.ui.user.model.VirtualImageModel;
import com.soft.blued.ui.user.utils.VirtualImageUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/utils/VirtualImageUtils.class */
public final class VirtualImageUtils {
    private static final int MaxDownloadingCount = 4;
    public static final Companion Companion = new Companion(null);
    private static final AtomicInteger downloadingIndex = new AtomicInteger(0);
    private static final List<String> downloadFileList = new ArrayList();
    private String TAG = VirtualImageUtils.class.getSimpleName();
    private final ArrayList<VirtualImageModel.ImageGoodsModel> mCurrentImageLayer = new ArrayList<>();
    private final HashSet<Integer> rawGoodIds = new HashSet<>();
    private HashMap<Integer, Integer> dynamicCategoryMap = new HashMap<>();
    private final HashSet<Integer> useGoodsInCatSet = new HashSet<>();

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/utils/VirtualImageUtils$Companion.class */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(final File file) {
            int andIncrement = VirtualImageUtils.downloadingIndex.getAndIncrement();
            if (andIncrement >= VirtualImageUtils.downloadFileList.size()) {
                return;
            }
            final String str = (String) VirtualImageUtils.downloadFileList.get(andIncrement);
            if (str.length() == 0) {
                b(file);
                return;
            }
            final String path = new File(file, Md5.a(str)).getPath();
            ImageFileLoader.a((IRequestHost) null).b(str).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.soft.blued.ui.user.utils.-$$Lambda$VirtualImageUtils$Companion$VY0Vct7JlYW83rNfSll-OI3gtL4
                public final void onUIFinish(File file2, Exception exc) {
                    VirtualImageUtils.Companion.a(file, str, path, file2, exc);
                }
            }).a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(File file, String str, String str2, File file2, Exception exc) {
            Intrinsics.e(file, "$dir");
            Intrinsics.e(str, "$url");
            if (file2 == null || !file2.exists()) {
                FileDownloader.a(str, str2, new VirtualImageUtils$Companion$downloadResources$2$1(str2, str, file), (IRequestHost) null);
            } else {
                VirtualImageUtils.Companion.b(file);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(final File file) {
            AppInfo.n().post(new Runnable() { // from class: com.soft.blued.ui.user.utils.-$$Lambda$VirtualImageUtils$Companion$BdpQDzLbsli3PvABcS67Qb70pMM
                @Override // java.lang.Runnable
                public final void run() {
                    VirtualImageUtils.Companion.c(file);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(List<VirtualImageModel.CategoryModel> list) {
            for (VirtualImageModel.CategoryModel categoryModel : list) {
                List<VirtualImageModel.ImageGoodsModel> goods_list = categoryModel.getGoods_list();
                if (goods_list != null) {
                    for (VirtualImageModel.ImageGoodsModel imageGoodsModel : goods_list) {
                        List<VirtualImageModel.Resource> resource = imageGoodsModel.getResource();
                        if (resource != null) {
                            for (VirtualImageModel.Resource resource2 : resource) {
                                VirtualImageUtils.downloadFileList.add(resource2.getStatic());
                            }
                        }
                    }
                }
            }
            a(VirtualImageUtils.downloadFileList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(File file) {
            Intrinsics.e(file, "$dir");
            VirtualImageUtils.Companion.a(file);
        }

        public final void a() {
            if (NetworkUtils.a()) {
                return;
            }
            CoroutineScope a2 = CoroutineScopeKt.a(JobKt.a((Job) null, 1, (Object) null).plus(Dispatchers.b()));
            BuildersKt.a(a2, (CoroutineContext) null, (CoroutineStart) null, new VirtualImageUtils$Companion$preLoadImages$1(a2, null), 3, (Object) null);
        }

        public final void a(List<String> list) {
            File externalFilesDir;
            Intrinsics.e(list, "downloadFileList");
            if (list.size() <= 0 || (externalFilesDir = AppInfo.d().getExternalFilesDir("vi_res")) == null) {
                return;
            }
            int i = 1;
            while (i < 5) {
                i++;
                VirtualImageUtils.Companion.a(externalFilesDir);
            }
        }
    }

    @Metadata
    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/utils/VirtualImageUtils$PostModel.class */
    static final class PostModel {
        private int goods_id;

        public final int getGoods_id() {
            return this.goods_id;
        }

        public final void setGoods_id(int i) {
            this.goods_id = i;
        }
    }

    private final VirtualImageModel.Resource findImageUrlByBodyId(VirtualImageModel.ImageGoodsModel imageGoodsModel) {
        int[] dynamicCategoryIds = getDynamicCategoryIds();
        List<VirtualImageModel.Resource> resource = imageGoodsModel.getResource();
        if (resource != null && (!resource.isEmpty())) {
            if (resource.size() == 1) {
                return resource.get(0);
            }
            for (VirtualImageModel.Resource resource2 : resource) {
                int length = dynamicCategoryIds.length;
                int i = 0;
                while (i < length) {
                    int i2 = dynamicCategoryIds[i];
                    i++;
                    if (i2 == resource2.getParent_id()) {
                        imageGoodsModel.setCResourceId(resource2.getId());
                        return resource2;
                    }
                }
            }
            return null;
        }
        return null;
    }

    private final int[] getDynamicCategoryIds() {
        Collection<Integer> values = this.dynamicCategoryMap.values();
        Intrinsics.c(values, "dynamicCategoryMap.values");
        return CollectionsKt.b(values);
    }

    private final void loadImage(ImageView imageView, VirtualImageModel.ImageGoodsModel imageGoodsModel, IRequestHost iRequestHost) {
        VirtualImageModel.Resource findImageUrlByBodyId = findImageUrlByBodyId(imageGoodsModel);
        if (findImageUrlByBodyId == null) {
            return;
        }
        if (findImageUrlByBodyId.getDynamic().length() > 0) {
            ImageLoader.a(iRequestHost, findImageUrlByBodyId.getDynamic()).g().g(-1).a(imageView);
        } else {
            ImageLoader.a(iRequestHost, findImageUrlByBodyId.getStatic()).a(imageView);
        }
    }

    public final void filterDynamicCategory(List<VirtualImageModel.CategoryModel> list) {
        Intrinsics.e(list, "categoryList");
        for (VirtualImageModel.CategoryModel categoryModel : list) {
            if (categoryModel.getParent_id() != 0 && !this.dynamicCategoryMap.containsKey(Integer.valueOf(categoryModel.getParent_id()))) {
                this.dynamicCategoryMap.put(Integer.valueOf(categoryModel.getParent_id()), 0);
            }
        }
    }

    public final String getAllGoodIdsString() {
        StringBuilder sb = new StringBuilder();
        Iterator<VirtualImageModel.ImageGoodsModel> it = this.mCurrentImageLayer.iterator();
        while (it.hasNext()) {
            VirtualImageModel.ImageGoodsModel next = it.next();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(next.getCResourceId());
            sb2.append(',');
            sb.append(sb2.toString());
        }
        String sb3 = sb.toString();
        Intrinsics.c(sb3, "sb.toString()");
        return sb3;
    }

    public final String getChangeGoodIdsString() {
        StringBuilder sb = new StringBuilder();
        Iterator<VirtualImageModel.ImageGoodsModel> it = this.mCurrentImageLayer.iterator();
        while (it.hasNext()) {
            VirtualImageModel.ImageGoodsModel next = it.next();
            if (!this.rawGoodIds.contains(Integer.valueOf(next.getCResourceId()))) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(next.getCResourceId());
                sb2.append(',');
                sb.append(sb2.toString());
            }
        }
        String sb3 = sb.toString();
        Intrinsics.c(sb3, "sb.toString()");
        return sb3;
    }

    public final String getSelectedGoodsJsonString() {
        ArrayList arrayList = new ArrayList();
        Iterator<VirtualImageModel.ImageGoodsModel> it = this.mCurrentImageLayer.iterator();
        while (it.hasNext()) {
            VirtualImageModel.ImageGoodsModel next = it.next();
            PostModel postModel = new PostModel();
            postModel.setGoods_id(next.getCResourceId());
            arrayList.add(postModel);
        }
        String json = AppInfo.f().toJson(arrayList);
        Intrinsics.c(json, "getGson().toJson(ids)");
        return json;
    }

    public final HashSet<Integer> getUseGoodsInCatSet() {
        return this.useGoodsInCatSet;
    }

    public final void initGuestImage(FrameLayout frameLayout, List<VirtualImageModel.GuestImageGoodsModel> list, IRequestHost iRequestHost) {
        Intrinsics.e(frameLayout, "parentView");
        Intrinsics.e(list, "data");
        Intrinsics.e(iRequestHost, "requestHost");
        frameLayout.removeAllViews();
        for (VirtualImageModel.GuestImageGoodsModel guestImageGoodsModel : CollectionsKt.a(list, new Comparator() { // from class: com.soft.blued.ui.user.utils.VirtualImageUtils$initGuestImage$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.a(Float.valueOf(((VirtualImageModel.GuestImageGoodsModel) t).getBlock_code()), Float.valueOf(((VirtualImageModel.GuestImageGoodsModel) t2).getBlock_code()));
            }
        })) {
            String str = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("initGuestImage : ");
            sb.append(guestImageGoodsModel.getBlock_code());
            sb.append("  url ");
            VirtualImageModel.Resource resource = guestImageGoodsModel.getResource();
            sb.append((Object) (resource == null ? null : resource.getStatic()));
            Log.d(str, sb.toString());
            ImageView imageView = new ImageView(frameLayout.getContext());
            VirtualImageModel.ImageGoodsModel imageGoodsModel = new VirtualImageModel.ImageGoodsModel();
            VirtualImageModel.Resource resource2 = guestImageGoodsModel.getResource();
            if (resource2 != null) {
                imageGoodsModel.setResource(CollectionsKt.d(new VirtualImageModel.Resource[]{resource2}));
            }
            Unit unit = Unit.a;
            loadImage(imageView, imageGoodsModel, iRequestHost);
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void initImage(FrameLayout frameLayout, List<VirtualImageModel.ImageGoodsModel> list, IRequestHost iRequestHost) {
        Intrinsics.e(frameLayout, "parentView");
        Intrinsics.e(list, "data");
        Intrinsics.e(iRequestHost, "requestHost");
        frameLayout.removeAllViews();
        this.mCurrentImageLayer.clear();
        this.mCurrentImageLayer.addAll(list);
        for (VirtualImageModel.ImageGoodsModel imageGoodsModel : list) {
            if (this.dynamicCategoryMap.containsKey(Integer.valueOf(imageGoodsModel.getCategory_id()))) {
                this.dynamicCategoryMap.put(Integer.valueOf(imageGoodsModel.getCategory_id()), Integer.valueOf(imageGoodsModel.getCResourceId()));
            }
        }
        for (VirtualImageModel.ImageGoodsModel imageGoodsModel2 : CollectionsKt.a(list, new Comparator() { // from class: com.soft.blued.ui.user.utils.VirtualImageUtils$initImage$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.a(Float.valueOf(((VirtualImageModel.ImageGoodsModel) t).getBlock_code()), Float.valueOf(((VirtualImageModel.ImageGoodsModel) t2).getBlock_code()));
            }
        })) {
            ImageView imageView = new ImageView(frameLayout.getContext());
            imageView.setTag(Float.valueOf(imageGoodsModel2.getBlock_code()));
            loadImage(imageView, imageGoodsModel2, iRequestHost);
            frameLayout.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        }
        updateRawGoodsIds();
    }

    public final void loadGoodIcon(ImageView imageView, VirtualImageModel.ImageGoodsModel imageGoodsModel, IRequestHost iRequestHost) {
        Intrinsics.e(imageView, "imageView");
        Intrinsics.e(imageGoodsModel, "good");
        Intrinsics.e(iRequestHost, "requestHost");
        VirtualImageModel.Resource findImageUrlByBodyId = findImageUrlByBodyId(imageGoodsModel);
        if (findImageUrlByBodyId == null) {
            return;
        }
        ImageLoader.a(iRequestHost, findImageUrlByBodyId.getIcon()).a(imageView);
    }

    public final void selectedGood(VirtualImageModel.ImageGoodsModel imageGoodsModel, FrameLayout frameLayout, IRequestHost iRequestHost) {
        int i;
        List<VirtualImageModel.Resource> resource;
        Intrinsics.e(imageGoodsModel, "good");
        Intrinsics.e(frameLayout, "parentView");
        Intrinsics.e(iRequestHost, "requestHost");
        if (this.dynamicCategoryMap.containsKey(Integer.valueOf(imageGoodsModel.getCategory_id()))) {
            this.dynamicCategoryMap.put(Integer.valueOf(imageGoodsModel.getCategory_id()), Integer.valueOf(imageGoodsModel.getCResourceId()));
        }
        int i2 = 0;
        if (this.mCurrentImageLayer.contains(imageGoodsModel)) {
            int indexOf = this.mCurrentImageLayer.indexOf(imageGoodsModel);
            VirtualImageModel.ImageGoodsModel imageGoodsModel2 = this.mCurrentImageLayer.get(indexOf);
            Intrinsics.c(imageGoodsModel2, "mCurrentImageLayer[index]");
            imageGoodsModel2.setCurrent_use(0);
            this.mCurrentImageLayer.set(indexOf, imageGoodsModel);
            for (View view : ViewGroupKt.getChildren(frameLayout)) {
                Object tag = view.getTag();
                if (tag == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
                }
                if (((Float) tag).floatValue() == imageGoodsModel.getBlock_code()) {
                    loadImage((ImageView) view, imageGoodsModel, iRequestHost);
                }
            }
        } else {
            int size = this.mCurrentImageLayer.size();
            int size2 = this.mCurrentImageLayer.size();
            while (true) {
                i = size;
                if (i2 >= size2) {
                    break;
                } else if (imageGoodsModel.getBlock_code() < this.mCurrentImageLayer.get(i2).getBlock_code()) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            this.mCurrentImageLayer.add(i, imageGoodsModel);
            ImageView imageView = new ImageView(frameLayout.getContext());
            imageView.setTag(Float.valueOf(imageGoodsModel.getBlock_code()));
            loadImage(imageView, imageGoodsModel, iRequestHost);
            frameLayout.addView(imageView, i, new FrameLayout.LayoutParams(-1, -1));
        }
        imageGoodsModel.setCurrent_use(1);
        if (this.dynamicCategoryMap.containsKey(Integer.valueOf(imageGoodsModel.getCategory_id()))) {
            Iterator<VirtualImageModel.ImageGoodsModel> it = this.mCurrentImageLayer.iterator();
            while (it.hasNext()) {
                VirtualImageModel.ImageGoodsModel next = it.next();
                if (!this.dynamicCategoryMap.containsKey(Integer.valueOf(next.getCategory_id())) && (resource = next.getResource()) != null && resource.size() > 1) {
                    Intrinsics.c(next, "layer");
                    selectedGood(next, frameLayout, iRequestHost);
                }
            }
        }
    }

    public final void updateCurrentUseIds() {
        Iterator<VirtualImageModel.ImageGoodsModel> it = this.mCurrentImageLayer.iterator();
        while (it.hasNext()) {
            this.useGoodsInCatSet.add(Integer.valueOf(it.next().getId()));
        }
    }

    public final void updateRawGoodsIds() {
        this.rawGoodIds.clear();
        Iterator<VirtualImageModel.ImageGoodsModel> it = this.mCurrentImageLayer.iterator();
        while (it.hasNext()) {
            this.rawGoodIds.add(Integer.valueOf(it.next().getCResourceId()));
        }
    }
}
