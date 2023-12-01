package com.blued.android.module.media.selector.present;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.module.media.selector.R;
import com.blued.android.module.media.selector.adapter.AlbumBaseAdapter;
import com.blued.android.module.media.selector.contract.IAlbumBaseCallback;
import com.blued.android.module.media.selector.contract.IAlbumBaseView;
import com.blued.android.module.media.selector.fragment.AlbumPreviewBaseFragment;
import com.blued.android.module.media.selector.model.AlbumDataManager;
import com.blued.android.module.media.selector.model.AlbumLoadDataModel;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.media.selector.model.GroupImageInfo;
import com.blued.android.module.media.selector.utils.ThumbLoader;
import com.blued.android.module.player.media.model.MediaInfo;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/present/AlbumBasePresenter.class */
public class AlbumBasePresenter extends MediaBasePresent<IAlbumBaseView> implements IAlbumBaseCallback, AlbumLoadDataModel.IAlbumLoadDataCallback {
    private static final String c = AlbumBasePresenter.class.getSimpleName();
    protected AlbumLoadDataModel a;

    public static List<MediaInfo> a(String str) {
        return AlbumDataManager.getGroupFileList(str);
    }

    public static void a(String str, List<MediaInfo> list) {
        AlbumDataManager.setCurrentList(str, list);
    }

    public static int b(MediaInfo mediaInfo) {
        return AlbumDataManager.removeSelectImage(mediaInfo);
    }

    public static int b(MediaInfo mediaInfo, int i) {
        return AlbumDataManager.addSelectImage(mediaInfo, i);
    }

    public static GroupImageInfo b(int i) {
        return AlbumDataManager.getGroupListFileInfo(i);
    }

    public static int k() {
        return AlbumDataManager.getMediaTypeVideo();
    }

    public static int l() {
        return AlbumDataManager.getGroupListSize();
    }

    public static void m() {
        AlbumDataManager.clearSelectImageList();
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseCallback
    public int a() {
        return AlbumDataManager.getCurrentListSize();
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseCallback
    public int a(MediaInfo mediaInfo) {
        int b = b(mediaInfo);
        n().e();
        return b;
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseCallback
    public MediaInfo a(int i) {
        return AlbumDataManager.getVRChildImageInfo(i);
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseCallback
    public void a(int i, MediaInfo mediaInfo) {
        if (n() == null || mediaInfo == null || n().a(i, mediaInfo)) {
            return;
        }
        if (mediaInfo.media_type != k()) {
            AlbumPreviewBaseFragment.a(n().b(), (Bundle) null, i, 1);
        } else if (AlbumDataManager.getSelectImageSize() <= 0) {
            AlbumPreviewBaseFragment.a(n().b(), (Bundle) null, i, 1);
        }
    }

    @Override // com.blued.android.module.media.selector.present.MediaBasePresent
    public void a(Activity activity, int i, int i2, Intent intent) {
        if (n() == null || n().a(activity, i, i2, intent) || i != 1) {
            return;
        }
        if (i2 == -1) {
            a(intent);
        } else if (n() != null) {
            n().d();
        }
    }

    public void a(Intent intent) {
        AlbumSelectInfo albumSelectInfo = new AlbumSelectInfo();
        albumSelectInfo.a(AlbumDataManager.getAlbumSelectInfo());
        AlbumDataManager.clearAlbumSelectData();
        if (n().a(albumSelectInfo)) {
            return;
        }
        Intent intent2 = intent;
        if (intent == null) {
            intent2 = new Intent();
        }
        intent2.putExtra("album_result_model", albumSelectInfo);
        n().getActivity().setResult(-1, intent2);
        n().c();
    }

    @Override // com.blued.android.module.media.selector.present.MediaBasePresent
    public void a(Bundle bundle) {
        AlbumDataManager.clear();
        AlbumDataManager.setMaxSelectNum(n().f());
        this.a = new AlbumLoadDataModel(n().getContext(), bundle, this);
    }

    @Override // com.blued.android.module.media.selector.model.AlbumLoadDataModel.IAlbumLoadDataCallback
    public void a(boolean z, String str) {
        if (n() == null || n().b() == null) {
            return;
        }
        n().a(false);
        n().a(z, str);
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseCallback
    public boolean a(MediaInfo mediaInfo, int i) {
        if (b() >= n().f()) {
            AppMethods.a((CharSequence) String.format(n().getActivity().getResources().getString(R.string.foudation_media_max_select_num), Integer.valueOf(n().f())));
            return false;
        }
        b(mediaInfo, i);
        n().e();
        return true;
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseCallback
    public int b() {
        return AlbumDataManager.getSelectImageSize();
    }

    @Override // com.blued.android.module.media.selector.present.MediaBasePresent
    public void b(Bundle bundle) {
        Bundle bundle2 = bundle;
        if (bundle == null) {
            bundle2 = new Bundle();
        }
        bundle2.putSerializable("serializeble_data", AlbumDataManager.getAlbumSelectInfo());
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseCallback
    public boolean c() {
        return b() >= n().f();
    }

    @Override // com.blued.android.module.media.selector.model.AlbumLoadDataModel.IAlbumLoadDataCallback
    public void d() {
        if (n() != null) {
            n().a(true);
        }
    }

    @Override // com.blued.android.module.media.selector.model.AlbumLoadDataModel.IAlbumLoadDataCallback
    public int e() {
        if (n() != null) {
            return n().i();
        }
        return 3;
    }

    @Override // com.blued.android.module.media.selector.model.AlbumLoadDataModel.IAlbumLoadDataCallback
    public long f() {
        if (n() != null) {
            return n().g();
        }
        return 2950L;
    }

    @Override // com.blued.android.module.media.selector.model.AlbumLoadDataModel.IAlbumLoadDataCallback
    public long g() {
        if (n() != null) {
            return n().h();
        }
        return 60000L;
    }

    @Override // com.blued.android.module.media.selector.model.AlbumLoadDataModel.IAlbumLoadDataCallback
    public Activity getActivity() {
        if (n() != null) {
            return n().getActivity();
        }
        return null;
    }

    @Override // com.blued.android.module.media.selector.contract.IAlbumBaseCallback
    public Context getContext() {
        return n().getContext();
    }

    @Override // com.blued.android.module.media.selector.present.MediaBasePresent
    public void h() {
        AlbumLoadDataModel albumLoadDataModel = this.a;
        if (albumLoadDataModel != null) {
            albumLoadDataModel.d();
        }
        AlbumDataManager.clear();
        ThumbLoader.a().b();
    }

    public RecyclerView.Adapter i() {
        return new AlbumBaseAdapter(this);
    }

    public void j() {
    }
}
