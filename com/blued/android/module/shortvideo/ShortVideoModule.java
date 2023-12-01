package com.blued.android.module.shortvideo;

import android.os.Bundle;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.Logger;
import com.blued.android.module.base.shortvideo.DeleteAutoCheckedListener;
import com.blued.android.module.base.shortvideo.ISaveInterface;
import com.blued.android.module.base.shortvideo.IShortVideo;
import com.blued.android.module.base.shortvideo.ITranscodingVideoListener;
import com.blued.android.module.base.shortvideo.ShortVideoProxy;
import com.blued.android.module.shortvideo.fragment.AuthRecorderFragment;
import com.blued.android.module.shortvideo.fragment.EditFragment;
import com.blued.android.module.shortvideo.fragment.EditPreViewFragment;
import com.blued.android.module.shortvideo.fragment.SaveVideoFragment;
import com.blued.android.module.shortvideo.fragment.ShineFragment;
import com.blued.android.module.shortvideo.fragment.TrimFragment;
import com.blued.android.module.shortvideo.manager.StvFragmentManager;
import com.blued.android.module.shortvideo.model.CommonModel;
import com.blued.android.module.shortvideo.model.EditDataModel;
import com.blued.android.module.shortvideo.utils.StvMediaUtils;
import com.qiniu.pili.droid.shortvideo.PLShortVideoEnv;
import java.io.File;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/ShortVideoModule.class */
public class ShortVideoModule {
    protected static IShortVideo a = new IShortVideo() { // from class: com.blued.android.module.shortvideo.ShortVideoModule.1
        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public void a(Bundle bundle, int i, ISaveInterface iSaveInterface) {
            ShortVideoModule.c();
            if (bundle == null) {
                return;
            }
            CommonModel commonModel = (CommonModel) bundle.getSerializable("commont_model");
            EditDataModel.SerializableData serializableData = (EditDataModel.SerializableData) bundle.getSerializable("serializeble_data");
            if ((serializableData == null || TextUtils.isEmpty(serializableData.getVideoPath())) && (commonModel == null || TextUtils.isEmpty(commonModel.getVideoPath()))) {
                return;
            }
            StvMediaUtils.a(AppInfo.d(), commonModel, serializableData, i, serializableData.getPrePageType(), iSaveInterface);
        }

        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public void a(Object obj, int i, int i2) {
            ShortVideoModule.c();
            AuthRecorderFragment.a(obj, i, i2);
        }

        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public void a(Object obj, int i, int i2, int i3) {
            ShortVideoModule.c();
            ShineFragment.a(obj, i, i2, i3, "", 0, null);
        }

        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public void a(Object obj, int i, int i2, String str, int i3, DeleteAutoCheckedListener deleteAutoCheckedListener) {
            ShortVideoModule.c();
            ShineFragment.a(obj, i, 0, i2, str, i3, deleteAutoCheckedListener);
        }

        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public void a(Object obj, int i, String str, String str2, int i2) {
            ShortVideoModule.c();
            ShineFragment.a(obj, i, str, str2, i2);
        }

        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public void a(Object obj, Bundle bundle, int i) {
            ShortVideoModule.c();
            EditPreViewFragment.a(obj, bundle, i);
        }

        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public void a(Object obj, Bundle bundle, int i, int i2) {
            ShortVideoModule.c();
            if (bundle == null) {
                return;
            }
            SaveVideoFragment.a(obj, bundle, i, i2);
        }

        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public void a(Object obj, String str, int i, int i2) {
            ShortVideoModule.c();
            TrimFragment.a(obj, str, i, i2, "", 0, null);
        }

        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public void a(Object obj, String str, int i, int i2, String str2, int i3, DeleteAutoCheckedListener deleteAutoCheckedListener) {
            ShortVideoModule.c();
            TrimFragment.a(obj, str, i, i2, str2, i3, deleteAutoCheckedListener);
        }

        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public void a(Object obj, String str, String str2, int i) {
            ShortVideoModule.c();
            EditFragment.a(obj, str, str2, i);
        }

        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public void a(String str) {
            ShortVideoModule.c();
            StvFragmentManager.a().a(str);
        }

        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public void a(String str, ITranscodingVideoListener iTranscodingVideoListener) {
            ShortVideoModule.c();
            if (iTranscodingVideoListener == null) {
                return;
            }
            if (TextUtils.isEmpty(str) || !new File(str).exists()) {
                iTranscodingVideoListener.a(false, str, null);
                return;
            }
            EditDataModel a2 = StvMediaUtils.a(str);
            if (a2 == null || !a2.isTranscode()) {
                Logger.b("StvMediaUtils", "no need Transcode");
                iTranscodingVideoListener.a(str, false);
                return;
            }
            Logger.b("StvMediaUtils", "need Transcode");
            StvMediaUtils.a(a2, iTranscodingVideoListener);
        }

        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public boolean a() {
            ShortVideoModule.c();
            return StvFragmentManager.a().c();
        }

        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public void b(Object obj, int i, int i2) {
            ShortVideoModule.c();
            a(obj, i, 0, i2);
        }

        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public void b(String str) {
            ShortVideoModule.c();
            StvFragmentManager.a().b(str);
        }

        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public boolean b() {
            ShortVideoModule.c();
            return StvFragmentManager.a().d();
        }

        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public void c() {
            ShortVideoModule.c();
            StvFragmentManager.a().b();
        }

        @Override // com.blued.android.module.base.shortvideo.IShortVideo
        public void d() {
            ShortVideoModule.c();
            StvMediaUtils.a();
        }
    };
    private static boolean b = false;

    public static void a() {
        ShortVideoProxy.e().a((ShortVideoProxy) a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c() {
        if (b) {
            PLShortVideoEnv.init(AppInfo.d());
            b = true;
        }
    }
}
