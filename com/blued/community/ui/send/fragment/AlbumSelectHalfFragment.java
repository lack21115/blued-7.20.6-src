package com.blued.community.ui.send.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.framework.utils.AppUtils;
import com.blued.android.framework.utils.FileUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.media.selector.model.AlbumDataManager;
import com.blued.android.module.media.selector.model.AlbumSelectInfo;
import com.blued.android.module.media.selector.present.AlbumBasePresenter;
import com.blued.android.module.player.media.model.MediaInfo;
import com.blued.community.R;
import com.blued.community.track.EventTrackFeed;
import com.blued.community.ui.send.adapter.AlbumSelectHalfAdapter;
import com.blued.community.ui.send.manager.SelectPhotoManager;
import com.blued.community.ui.send.model.ChildImageInfo;
import com.blued.community.ui.send.presenter.AlbumSelectHalfPresenter;
import com.blued.community.ui.send.vm.SelectAlbumViewModel;
import com.blued.community.utils.StorageUtils;
import com.blued.das.client.feed.FeedProtos;
import java.util.List;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/AlbumSelectHalfFragment.class */
public class AlbumSelectHalfFragment extends AlbumSelectFragment {
    private SelectAlbumViewModel d;
    private OnClosePageListener e;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/fragment/AlbumSelectHalfFragment$OnClosePageListener.class */
    public interface OnClosePageListener {
        void onClosePage();
    }

    private void F() {
        View findViewById = r().findViewById(R.id.title_bar_line);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    public void a(float f) {
        if (r() == null) {
            return;
        }
        r().setAlpha(f);
        if (f <= 0.0f) {
            r().setVisibility(4);
        } else {
            r().setVisibility(0);
        }
    }

    @Override // com.blued.community.ui.send.fragment.AlbumSelectFragment
    protected void a(int i) {
        AlbumSelectPreviewFragment.b(b(), this.f19947a, i, 1);
    }

    public void a(OnClosePageListener onClosePageListener) {
        this.e = onClosePageListener;
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment, com.blued.android.module.media.selector.contract.IAlbumBaseView, com.blued.android.module.media.selector.contract.IBaseView
    public void a(boolean z) {
    }

    @Override // com.blued.community.ui.send.fragment.AlbumSelectFragment, com.blued.android.module.media.selector.fragment.AlbumBaseFragment, com.blued.android.module.media.selector.contract.IAlbumBaseView
    public boolean a(Activity activity, int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i != 1) {
                switch (i) {
                    case 1000:
                    case 1001:
                    case 1002:
                        break;
                    default:
                        return false;
                }
            }
            if (intent == null || !intent.getBooleanExtra("close_page", false)) {
                return false;
            }
            getActivity().setResult(-1, intent);
            return true;
        }
        return false;
    }

    @Override // com.blued.community.ui.send.fragment.AlbumSelectFragment, com.blued.android.module.media.selector.contract.IAlbumBaseView
    public boolean a(AlbumSelectInfo albumSelectInfo) {
        b(albumSelectInfo);
        c();
        return true;
    }

    public void b(AlbumSelectInfo albumSelectInfo) {
        AlbumSelectInfo albumSelectInfo2 = new AlbumSelectInfo();
        albumSelectInfo2.a(albumSelectInfo);
        this.d.f().setValue(albumSelectInfo2);
        SelectPhotoManager.a().d();
        for (MediaInfo mediaInfo : albumSelectInfo2.c()) {
            ChildImageInfo childImageInfo = new ChildImageInfo();
            if (!AppUtils.b() || TextUtils.isEmpty(mediaInfo.imgUri) || StorageUtils.a(mediaInfo.imagePath)) {
                childImageInfo.mImagePath = mediaInfo.imagePath;
            } else {
                String e = RecyclingUtils.e("photo");
                boolean a2 = FileUtils.a(mediaInfo.imgUri, e);
                childImageInfo.mImagePath = e;
                LogUtils.c("SaveSelectPhoto: " + e + " " + a2);
            }
            childImageInfo.width = mediaInfo.width;
            childImageInfo.height = mediaInfo.height;
            SelectPhotoManager.a().a(childImageInfo);
        }
        this.d.j().setValue(true);
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment, com.blued.android.module.media.selector.contract.IAlbumBaseView
    public void c() {
        OnClosePageListener onClosePageListener = this.e;
        if (onClosePageListener != null) {
            onClosePageListener.onClosePage();
        } else {
            super.c();
        }
    }

    public void c(Bundle bundle) {
        setArguments(bundle);
        j();
        if (this.b != 0) {
            Bundle bundle2 = new Bundle();
            AlbumSelectInfo albumSelectInfo = new AlbumSelectInfo();
            albumSelectInfo.a(this.d.f().getValue());
            bundle2.putSerializable("serializeble_data", albumSelectInfo);
            ((AlbumBasePresenter) this.b).a(bundle2);
        }
        y();
        F();
        AlbumDataManager.setMaxSelectNum(f());
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment, com.blued.android.module.media.selector.contract.IAlbumBaseView
    public void e() {
        super.e();
        if (!(SelectPhotoManager.a().b() == 0 && AlbumDataManager.getAlbumSelectInfo().c().size() == 0) && this.d.i()) {
            EventTrackFeed.a(FeedProtos.Event.FEED_PUBLISH_HALF_SCREEN_PHOTO_CLICK);
            b(AlbumDataManager.getAlbumSelectInfo());
        }
    }

    @Override // com.blued.community.ui.send.fragment.AlbumSelectFragment, com.blued.android.module.media.selector.fragment.AlbumBaseFragment
    public CharSequence n() {
        return null;
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment, com.blued.android.module.media.selector.fragment.MediaBaseFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            AlbumSelectInfo albumSelectInfo = (AlbumSelectInfo) intent.getSerializableExtra("album_result_model");
            if (albumSelectInfo != null) {
                b(albumSelectInfo);
            }
            if (intent.getSerializableExtra("result_model") != null) {
                this.d.g().setValue(intent);
            } else {
                this.d.g().setValue(null);
            }
            c();
        }
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment, com.blued.android.module.media.selector.fragment.MediaBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = (SelectAlbumViewModel) new ViewModelProvider(getActivity().getViewModelStore(), new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(SelectAlbumViewModel.class);
    }

    @Override // com.blued.community.ui.send.fragment.AlbumSelectFragment, com.blued.android.module.media.selector.fragment.AlbumBaseFragment, com.blued.android.module.media.selector.fragment.MediaBaseFragment, com.blued.android.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.d.h().observe(getViewLifecycleOwner(), new Observer<String>() { // from class: com.blued.community.ui.send.fragment.AlbumSelectHalfFragment.1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a */
            public void onChanged(String str) {
                try {
                    AlbumSelectHalfAdapter albumSelectHalfAdapter = (AlbumSelectHalfAdapter) ((RecyclerView) AlbumSelectHalfFragment.this.getView().findViewById(R.id.vr_gird_view)).getAdapter();
                    List<MediaInfo> currentList = AlbumDataManager.getCurrentList();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= currentList.size()) {
                            return;
                        }
                        MediaInfo mediaInfo = currentList.get(i2);
                        if (TextUtils.equals(mediaInfo.imagePath, str)) {
                            AlbumDataManager.removeFromPath(str);
                            mediaInfo.isSelected = false;
                            albumSelectHalfAdapter.notifyItemChanged(i2);
                            return;
                        }
                        i = i2 + 1;
                    }
                } catch (Exception e) {
                }
            }
        });
        return onCreateView;
    }

    @Override // com.blued.community.ui.send.fragment.AlbumSelectFragment, com.blued.android.module.media.selector.fragment.AlbumBaseFragment
    public View p() {
        return null;
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment
    public View q() {
        return super.q();
    }

    @Override // com.blued.android.module.media.selector.fragment.AlbumBaseFragment, com.blued.android.module.media.selector.fragment.MediaBaseFragment
    /* renamed from: z */
    public AlbumBasePresenter B() {
        return new AlbumSelectHalfPresenter();
    }
}
