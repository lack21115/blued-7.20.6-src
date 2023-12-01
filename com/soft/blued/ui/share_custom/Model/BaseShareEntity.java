package com.soft.blued.ui.share_custom.Model;

import android.graphics.Bitmap;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.utils.ShareCoreUtils;
import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/share_custom/Model/BaseShareEntity.class */
public class BaseShareEntity implements Serializable {
    public int flag;
    public ShareCoreUtils.ShareBackLister shareBackLister;
    public int shareFrom;
    public int shareType;
    public String netImgUrl = "";
    public String fileUrl = "";
    public String linkUrl = "";
    public String title = "";
    public String content = "";
    public String mainBody = "";
    public String platFormName = "";
    public boolean ifHideShareToFeed = true;
    public boolean ifHideShareToPeopleAndGroup = false;
    public boolean ifHideRepostToFeed = true;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/share_custom/Model/BaseShareEntity$ShareLiveData.class */
    public static class ShareLiveData {

        /* renamed from: a  reason: collision with root package name */
        public String f33710a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f33711c;
        public String d;
        public Bitmap e;
        public String f;
        public String g;
        public String h;
        public boolean i;
        public String j;
        public ShareCoreUtils.ShareBackLister k;
        public ShareOptionRecyclerAdapter.ShareOptionsItemClickListener l;
    }
}
