package com.soft.blued.ui.setting.Contract;

import com.blued.android.framework.mvp_similarity.BasePresenter;
import com.blued.android.framework.mvp_similarity.BaseView;
import com.soft.blued.ui.find.model.UserFindResult;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/PrivacyPhotoAlbumContract.class */
public class PrivacyPhotoAlbumContract {

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/PrivacyPhotoAlbumContract$IPresenter.class */
    public interface IPresenter extends BasePresenter {
        void a(int i, int i2);

        void a(String str);

        void a(String str, int i);

        void a(boolean z);

        void b();

        boolean c();
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/Contract/PrivacyPhotoAlbumContract$IView.class */
    public interface IView extends BaseView<IPresenter> {
        void a();

        void a(int i);

        void a(String str);

        void a(List<UserFindResult> list);

        void b();

        void c();

        void d();
    }
}
