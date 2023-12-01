package com.blued.android.module.live_china.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.MemoryRequest;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.view.badgeview.DisplayUtil;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.LiveBaseDialogFragment;
import com.blued.android.module.live_china.live_info.LiveRoomInfo;
import com.blued.android.module.live_china.model.LiveMakeLoverFansModel;
import com.blued.android.module.live_china.same.Logger;
import com.bytedance.applog.tracker.Tracker;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.io.File;
import java.util.ArrayList;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/adapter/LiveShowPhotoAdapter.class */
public class LiveShowPhotoAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private BaseFragment a;
    private int b;
    private int c;
    private int d;

    public LiveShowPhotoAdapter(BaseFragment baseFragment) {
        super(R.layout.item_live_show_photo_layout, new ArrayList());
        this.d = 0;
        this.a = baseFragment;
        this.c = DisplayUtil.a(AppInfo.d(), 3.0f);
        this.b = (AppInfo.l - (this.c * 2)) / 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap a(String str, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i2 = options.outWidth / i;
        int i3 = options.outHeight / i;
        if (i2 > 1 || i3 > 1) {
            if (i2 > i3) {
                options.inSampleSize = i2;
            } else {
                options.inSampleSize = i3;
            }
        }
        options.inJustDecodeBounds = false;
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            MemoryRequest.a().b();
            return null;
        }
    }

    public void a() {
        getData().clear();
        notifyDataSetChanged();
    }

    public void a(int i) {
        this.d = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, final String str) {
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_photo);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.weight = this.b;
        layoutParams.height = this.b;
        imageView.setLayoutParams(layoutParams);
        ImageLoader.a(this.a.getFragmentActive(), str).b(R.drawable.icon_live_show_photo_def).a(imageView);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.blued.android.module.live_china.adapter.LiveShowPhotoAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Tracker.onClick(view);
                ImageFileLoader.a(LiveShowPhotoAdapter.this.a.getFragmentActive()).b(str).a(new ImageFileLoader.OnLoadFileListener() { // from class: com.blued.android.module.live_china.adapter.LiveShowPhotoAdapter.1.1
                    @Override // com.blued.android.core.image.ImageFileLoader.OnLoadFileListener
                    public void onUIFinish(File file, Exception exc) {
                        if (file == null || !file.exists()) {
                            return;
                        }
                        String str2 = LiveShowPhotoAdapter.TAG;
                        Logger.d(str2, "file size = " + file.length());
                        Bitmap a = LiveShowPhotoAdapter.this.a(file.getPath(), 1080);
                        int width = a.getWidth();
                        int height = a.getHeight();
                        if (LiveShowPhotoAdapter.this.d != 0 && width >= 300 && height >= 300) {
                            Logger.d(LiveShowPhotoAdapter.TAG, "photoType = SHOW_FEED ... ");
                            LiveRoomInfo.a().a(LiveShowPhotoAdapter.this.a, str, file.getPath(), 100);
                            return;
                        }
                        Logger.d(LiveShowPhotoAdapter.TAG, "photoType = SHOW_ALBUM ... ");
                        if (LiveShowPhotoAdapter.this.a == null || LiveShowPhotoAdapter.this.a.getParentFragment() == null || !(LiveShowPhotoAdapter.this.a.getParentFragment() instanceof LiveBaseDialogFragment)) {
                            return;
                        }
                        LiveMakeLoverFansModel liveMakeLoverFansModel = new LiveMakeLoverFansModel();
                        liveMakeLoverFansModel.avatar = str;
                        liveMakeLoverFansModel.pic = file.getPath();
                        LiveShowPhotoAdapter.this.a.getParentFragment().a((LiveBaseDialogFragment) liveMakeLoverFansModel);
                    }
                }).a();
            }
        });
    }
}
