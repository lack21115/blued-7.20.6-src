package com.soft.blued.ui.msg.fragment;

import android.text.TextUtils;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.common.widget.emoticon.manager.EmotionManager;
import com.soft.blued.ui.msg.model.EmotionListItemModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/fragment/EmotionDataManager.class */
public class EmotionDataManager {

    /* renamed from: a  reason: collision with root package name */
    private static volatile EmotionDataManager f18652a;
    private List<String> b;

    /* renamed from: c  reason: collision with root package name */
    private List<EmotionListItemModel> f18653c;

    private EmotionDataManager() {
    }

    public static EmotionDataManager a() {
        if (f18652a == null) {
            synchronized (EmotionDataManager.class) {
                try {
                    if (f18652a == null) {
                        f18652a = new EmotionDataManager();
                        f18652a.b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f18652a;
    }

    public void a(List<EmotionListItemModel> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        c().clear();
        c().addAll(list);
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return b().contains(str);
    }

    public List<String> b() {
        if (this.b == null) {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.addAll(EmotionManager.d());
        }
        return this.b;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!b().contains(str)) {
            b().add(str);
            for (EmotionListItemModel emotionListItemModel : c()) {
                if (StringUtils.a(emotionListItemModel.code, str)) {
                    emotionListItemModel.downloadState = 3;
                }
            }
        }
        LogUtils.c("addLocalEmotionId: " + str + ", size=" + b().size());
    }

    public List<EmotionListItemModel> c() {
        if (this.f18653c == null) {
            this.f18653c = new ArrayList();
        }
        return this.f18653c;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (b().contains(str)) {
            b().remove(str);
        }
        Iterator<EmotionListItemModel> it = c().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            EmotionListItemModel next = it.next();
            if (StringUtils.a(next.code, str)) {
                next.downloadState = 0;
                break;
            }
        }
        LogUtils.c("removeLocalEmotionId: " + str + ", size=" + b().size());
    }

    public void d() {
        c().clear();
    }
}
