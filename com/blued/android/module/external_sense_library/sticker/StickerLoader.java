package com.blued.android.module.external_sense_library.sticker;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.external_sense_library.contract.IGetStickerListener;
import com.blued.android.module.external_sense_library.model.ErrorCode;
import com.blued.android.module.external_sense_library.model.StickerBaseModel;
import com.blued.android.module.external_sense_library.model.StickerDataModel;
import com.blued.android.module.external_sense_library.utils.LogUtils;
import com.blued.android.module.external_sense_library.utils.StickerConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/sticker/StickerLoader.class */
public class StickerLoader {

    /* renamed from: a  reason: collision with root package name */
    private static final String f11269a = "Blued_Sense_" + StickerLoader.class.getSimpleName();
    private Map<String, Integer> b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, IGetStickerListener> f11270c;
    private volatile Hashtable<String, StickerBaseModel> d;
    private volatile StickerDataModel e;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/external_sense_library/sticker/StickerLoader$Builder.class */
    public static class Builder {
        public StickerLoader a() {
            return new StickerLoader();
        }
    }

    private StickerLoader() {
        this.b = new HashMap();
        this.f11270c = new HashMap<>();
        this.d = new Hashtable<>();
        this.e = StickerUtils.a();
        if (this.e.f11265a == null || this.e.f11265a.isEmpty()) {
            return;
        }
        ArrayList<StickerBaseModel> arrayList = new ArrayList();
        for (StickerBaseModel stickerBaseModel : this.e.f11265a) {
            if (stickerBaseModel != null && !TextUtils.isEmpty(stickerBaseModel.name)) {
                if (this.d.containsKey(stickerBaseModel.name)) {
                    arrayList.add(stickerBaseModel);
                } else {
                    this.d.put(stickerBaseModel.name, stickerBaseModel);
                    this.b.put(stickerBaseModel.name, Integer.valueOf(stickerBaseModel.stickerState));
                }
            }
        }
        if (arrayList.size() > 0) {
            for (StickerBaseModel stickerBaseModel2 : arrayList) {
                this.e.f11265a.remove(stickerBaseModel2);
            }
            StickerUtils.a(this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, int i) {
        if (this.b.get(str).intValue() != 2) {
            this.b.put(str, Integer.valueOf(i));
            StickerBaseModel stickerBaseModel = this.d.get(str);
            StickerBaseModel stickerBaseModel2 = stickerBaseModel;
            if (stickerBaseModel == null) {
                stickerBaseModel2 = new StickerBaseModel();
            }
            stickerBaseModel2.name = str;
            stickerBaseModel2.path = str2;
            String str4 = f11269a;
            LogUtils.b(str4, str + " | 1 localPath:" + str3, new Object[0]);
            stickerBaseModel2.localPath = str3;
            stickerBaseModel2.stickerState = i;
            this.d.put(str, stickerBaseModel2);
            StickerUtils.a(str, str2, str3, i);
        }
    }

    public Map<String, Integer> a() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(this.b);
        return hashMap;
    }

    public void a(final String str, final String str2, IGetStickerListener iGetStickerListener, IRequestHost iRequestHost) {
        if (iGetStickerListener != null) {
            this.f11270c.put(str, iGetStickerListener);
        }
        if (!StickerDownLoader.a(str)) {
            StickerDownLoader.a(str, str2, new IGetStickerListener() { // from class: com.blued.android.module.external_sense_library.sticker.StickerLoader.1
                @Override // com.blued.android.module.external_sense_library.contract.IGetStickerListener
                public void onFailed(final ErrorCode.PlayStickerCode playStickerCode, final String str3) {
                    StickerLoader stickerLoader = StickerLoader.this;
                    String str4 = str;
                    stickerLoader.a(str4, str2, StickerConfig.a(str4), 0);
                    AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.external_sense_library.sticker.StickerLoader.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (StickerLoader.this.f11270c.get(str) != null) {
                                ((IGetStickerListener) StickerLoader.this.f11270c.get(str)).onFailed(playStickerCode, str3);
                            }
                        }
                    });
                }

                @Override // com.blued.android.module.external_sense_library.contract.IGetStickerListener
                public void onSuccess(final String str3, final String str4) {
                    StickerLoader.this.a(str3, str2, str4, 2);
                    AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.external_sense_library.sticker.StickerLoader.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (StickerLoader.this.f11270c.get(str3) != null) {
                                ((IGetStickerListener) StickerLoader.this.f11270c.get(str3)).onSuccess(str3, str4);
                            }
                        }
                    });
                }

                @Override // com.blued.android.module.external_sense_library.contract.IGetStickerListener
                public void onSyncStart() {
                    StickerLoader stickerLoader = StickerLoader.this;
                    String str3 = str;
                    stickerLoader.a(str3, str2, StickerConfig.a(str3), 1);
                    AppInfo.n().post(new Runnable() { // from class: com.blued.android.module.external_sense_library.sticker.StickerLoader.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (StickerLoader.this.f11270c.get(str) != null) {
                                ((IGetStickerListener) StickerLoader.this.f11270c.get(str)).onSyncStart();
                            }
                        }
                    });
                }
            }, iRequestHost);
            return;
        }
        a(str, str2, "", 1);
        String str3 = f11269a;
        LogUtils.d(str3, str + " _贴纸正在下载...", new Object[0]);
    }

    public void a(List<StickerBaseModel> list) {
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (StickerBaseModel stickerBaseModel : list) {
                if (stickerBaseModel != null && !TextUtils.isEmpty(stickerBaseModel.name) && !TextUtils.isEmpty(stickerBaseModel.path) && !this.d.containsKey(stickerBaseModel.name)) {
                    this.d.put(stickerBaseModel.name, stickerBaseModel);
                    this.b.put(stickerBaseModel.name, Integer.valueOf(stickerBaseModel.stickerState));
                    arrayList.add(stickerBaseModel);
                }
            }
            if ((this.e.f11265a == null || this.e.f11265a.size() <= 0) && arrayList.size() > 0) {
                this.e.f11265a.addAll(arrayList);
                StickerUtils.a(this.e);
            }
        }
    }

    public boolean a(String str) {
        StickerBaseModel stickerBaseModel;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        boolean z = this.d.containsKey(str) && (stickerBaseModel = this.d.get(str)) != null && !TextUtils.isEmpty(stickerBaseModel.localPath) && new File(stickerBaseModel.localPath).exists();
        if (z) {
            this.b.put(str, 2);
            return z;
        }
        this.b.put(str, 0);
        return z;
    }
}
