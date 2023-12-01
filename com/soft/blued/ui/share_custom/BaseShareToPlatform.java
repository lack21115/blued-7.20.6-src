package com.soft.blued.ui.share_custom;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.module_share_china.R;
import com.blued.android.share.CallbackListener;
import com.blued.android.share.Constants;
import com.blued.android.share.ShareProvider;
import com.blued.android.share.msg.MsgImage;
import com.blued.android.share.msg.MsgImageText;
import com.blued.android.share.msg.MsgWeixinVideoText;
import com.blued.android.share.qq.QQActivity;
import com.blued.android.share.sina.SinaShareActivity;
import com.soft.blued.customview.PopMenuFromBottom;
import com.soft.blued.customview.PopMenuFromCenter;
import com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter;
import com.soft.blued.ui.share_custom.Model.BaseShareEntity;
import com.soft.blued.ui.share_custom.Model.ShareOption;
import com.soft.blued.utils.HttpUtils;
import com.soft.blued.utils.ShareCoreUtils;
import com.soft.blued.wxapi.WXEntryActivity;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.ArrayList;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/share_custom/BaseShareToPlatform.class */
public class BaseShareToPlatform {

    /* renamed from: c  reason: collision with root package name */
    private static final String f33703c = BaseShareToPlatform.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    protected Context f33704a;
    ShareCoreUtils.ShareBackLister b;
    private PopMenuFromBottom d;
    private View e;
    private RecyclerView f;
    private RecyclerView g;
    private ShareOptionRecyclerAdapter h;
    private ShareOptionRecyclerAdapter i;
    private BaseShareEntity j;
    private String k = "blued";
    private ShareOptionRecyclerAdapter.ShareOptionsItemClickListener l;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/share_custom/BaseShareToPlatform$PopWindowSetting.class */
    public static class PopWindowSetting {

        /* renamed from: a  reason: collision with root package name */
        public boolean f33708a = false;
        public boolean b = false;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/share_custom/BaseShareToPlatform$ShareCallbackListener.class */
    public class ShareCallbackListener implements CallbackListener {
        public ShareCallbackListener() {
        }

        @Override // com.blued.android.share.CallbackListener
        public void onCancel(String str) {
            if (BaseShareToPlatform.this.b != null) {
                BaseShareToPlatform.this.b.c(str);
            }
        }

        @Override // com.blued.android.share.CallbackListener
        public void onFailure(String str) {
            if (BaseShareToPlatform.this.b != null) {
                BaseShareToPlatform.this.b.b(str);
            }
            if (TextUtils.equals(str, Constants.SinaWeiboNAME) || TextUtils.equals(str, Constants.QQNAME) || TextUtils.equals(str, Constants.WechatNAME) || TextUtils.equals(str, Constants.WechatMomentsNAME)) {
                AppMethods.d(R.string.ssdk_oks_share_failed);
            }
        }

        @Override // com.blued.android.share.CallbackListener
        public void onResume(String str) {
            if (BaseShareToPlatform.this.b != null) {
                BaseShareToPlatform.this.b.d(str);
            }
        }

        @Override // com.blued.android.share.CallbackListener
        public void onSuccess(String str) {
            BaseShareToPlatform.this.a(str);
        }
    }

    public BaseShareToPlatform(Context context, final ShareCoreUtils.ShareBackLister shareBackLister, PopWindowSetting popWindowSetting, final ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener) {
        PopWindowSetting popWindowSetting2 = popWindowSetting == null ? new PopWindowSetting() : popWindowSetting;
        this.f33704a = context;
        this.e = LayoutInflater.from(context).inflate(R.layout.share_common_layout, (ViewGroup) null);
        a(popWindowSetting2.f33708a);
        this.f = (RecyclerView) this.e.findViewById(R.id.lv_platforms);
        this.g = (RecyclerView) this.e.findViewById(R.id.lv_blued);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.e.findViewById(R.id.ll_all).getLayoutParams();
        if (popWindowSetting2.b) {
            layoutParams.width = DensityUtils.a(this.f33704a, 355.0f);
        }
        this.e.findViewById(R.id.ll_all).setLayoutParams(layoutParams);
        ArrayList arrayList = new ArrayList();
        if (popWindowSetting2.f33708a) {
            arrayList.add(new ShareOption(R.drawable.icon_share_to_people_dark, R.string.share_to_friends));
            arrayList.add(new ShareOption(R.drawable.icon_share_to_feed_dark, R.string.common_main_feed));
            arrayList.add(new ShareOption(R.drawable.icon_share_repost_to_feed_dark, R.string.feed_repost));
        } else {
            arrayList.add(new ShareOption(R.drawable.icon_share_to_people, R.string.share_to_friends));
            arrayList.add(new ShareOption(R.drawable.icon_share_to_feed, R.string.common_main_feed));
            arrayList.add(new ShareOption(R.drawable.icon_share_repost_to_feed, R.string.feed_repost));
        }
        this.i = new ShareOptionRecyclerAdapter(context, arrayList, popWindowSetting2.f33708a);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f33704a);
        linearLayoutManager.setStackFromEnd(true);
        linearLayoutManager.setOrientation(0);
        linearLayoutManager.scrollToPosition(0);
        this.g.setLayoutManager(linearLayoutManager);
        this.g.setHasFixedSize(true);
        this.g.setAdapter(this.i);
        this.i.notifyDataSetChanged();
        ArrayList arrayList2 = new ArrayList();
        if (popWindowSetting2.f33708a) {
            arrayList2.add(new ShareOption(R.drawable.icon_share_to_wechat_dark, R.string.ssdk_wechat));
            arrayList2.add(new ShareOption(R.drawable.icon_share_to_wechat_moment_dark, R.string.ssdk_wechatmoments));
            arrayList2.add(new ShareOption(R.drawable.icon_share_to_qq_dark, R.string.ssdk_qq));
            arrayList2.add(new ShareOption(R.drawable.icon_share_to_sina_weibo_dark, R.string.ssdk_sinaweibo));
        } else {
            arrayList2.add(new ShareOption(R.drawable.icon_share_to_wechat, R.string.ssdk_wechat));
            arrayList2.add(new ShareOption(R.drawable.icon_share_to_wechat_moment, R.string.ssdk_wechatmoments));
            arrayList2.add(new ShareOption(R.drawable.icon_share_to_qq, R.string.ssdk_qq));
            arrayList2.add(new ShareOption(R.drawable.icon_share_to_sina_weibo, R.string.ssdk_sinaweibo));
        }
        this.h = new ShareOptionRecyclerAdapter(context, arrayList2, popWindowSetting2.f33708a);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this.f33704a);
        linearLayoutManager2.setStackFromEnd(true);
        linearLayoutManager2.setOrientation(0);
        linearLayoutManager2.scrollToPosition(0);
        this.f.setLayoutManager(linearLayoutManager2);
        this.f.setHasFixedSize(true);
        this.f.setAdapter(this.h);
        this.h.notifyDataSetChanged();
        final PopWindowSetting popWindowSetting3 = popWindowSetting2;
        ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener2 = new ShareOptionRecyclerAdapter.ShareOptionsItemClickListener() { // from class: com.soft.blued.ui.share_custom.BaseShareToPlatform.1
            @Override // com.soft.blued.ui.share_custom.Adapter.ShareOptionRecyclerAdapter.ShareOptionsItemClickListener
            public void onItemClick(int i) {
                ShareOptionRecyclerAdapter.ShareOptionsItemClickListener shareOptionsItemClickListener3 = shareOptionsItemClickListener;
                if (shareOptionsItemClickListener3 != null) {
                    shareOptionsItemClickListener3.onItemClick(i);
                }
                BaseShareToPlatform.this.a(i, shareBackLister, popWindowSetting3);
            }
        };
        this.l = shareOptionsItemClickListener2;
        this.h.a(shareOptionsItemClickListener2);
        this.i.a(this.l);
        this.b = shareBackLister;
        if (popWindowSetting2.b) {
            this.d = new PopMenuFromCenter(this.f33704a, this.e);
        } else {
            this.d = new PopMenuFromBottom(this.f33704a, this.e);
        }
    }

    private void a() {
        if (this.j.shareFrom == 8) {
            BaseShareEntity baseShareEntity = this.j;
            baseShareEntity.content = this.j.content + " " + String.format(this.f33704a.getResources().getString(R.string.live_share_enterToPersionPage), "");
            this.j.netImgUrl = "";
        }
        Intent intent = new Intent(this.f33704a, SinaShareActivity.class);
        if (this.j.shareFrom == 6) {
            intent.putExtra("title", "");
            intent.putExtra("des", this.j.title);
        } else if (this.j.shareFrom == 13) {
            intent.putExtra("title", this.j.title + "--来自Blued APP");
            intent.putExtra("des", " ");
        } else if (this.j.shareFrom == 14) {
            intent.putExtra("title", this.j.title);
            intent.putExtra("des", " ");
        } else {
            intent.putExtra("title", this.j.title);
            intent.putExtra("des", this.j.content);
        }
        intent.putExtra("flag", this.j.flag);
        intent.putExtra("imgUrl", this.j.netImgUrl);
        intent.putExtra("linkUrl", this.j.linkUrl);
        intent.putExtra("fileUrl", this.j.fileUrl);
        ShareProvider.getInstance().registerCallback(new ShareCallbackListener());
        this.f33704a.startActivity(intent);
    }

    private void a(int i) {
        MsgImageText msgImageText = new MsgImageText();
        msgImageText.pType = 2;
        msgImageText.appName = this.k;
        msgImageText.title = this.j.title;
        msgImageText.summary = this.j.mainBody;
        if (this.j.flag == 1) {
            msgImageText.imageUrl = this.j.netImgUrl;
        } else {
            msgImageText.imageUrl = this.j.fileUrl;
        }
        msgImageText.targetUrl = this.j.linkUrl;
        Intent intent = new Intent(this.f33704a, QQActivity.class);
        intent.putExtra(Constants.BUNDLE_SHOW, msgImageText);
        if (i == 1) {
            intent.putExtra("type", 1);
        } else {
            intent.putExtra("type", 0);
        }
        intent.putExtra("flag", this.j.flag);
        ShareProvider.getInstance().registerCallback(new ShareCallbackListener());
        this.f33704a.startActivity(intent);
    }

    private void a(int i, int i2) {
        String str;
        Intent intent = new Intent(this.f33704a, WXEntryActivity.class);
        if (i2 == 2) {
            MsgWeixinVideoText msgWeixinVideoText = new MsgWeixinVideoText();
            msgWeixinVideoText.pType = i;
            msgWeixinVideoText.title = i == 8 ? this.j.title : this.j.content;
            msgWeixinVideoText.summary = this.j.content;
            if (this.j.flag == 1) {
                msgWeixinVideoText.imageUrl = this.j.netImgUrl;
            } else {
                msgWeixinVideoText.imageUrl = this.j.fileUrl;
            }
            msgWeixinVideoText.targetUrl = this.j.linkUrl;
            intent.putExtra("WXEnetry_jrj_show", msgWeixinVideoText);
        } else if (i2 == 1) {
            MsgImage msgImage = new MsgImage();
            if (this.j.flag == 1) {
                msgImage.imageUrl = this.j.netImgUrl;
            } else {
                msgImage.imageUrl = this.j.fileUrl;
            }
            msgImage.pType = i;
            intent.putExtra("WXEnetry_jrj_show", msgImage);
        } else {
            MsgImageText msgImageText = new MsgImageText();
            msgImageText.pType = i;
            if (this.j.shareFrom == 6) {
                msgImageText.title = this.j.title;
            } else if (this.j.shareFrom == 13) {
                if (i == 8) {
                    str = this.j.title;
                } else {
                    str = this.j.title + "-" + this.j.content;
                }
                msgImageText.title = str;
            } else if (this.j.shareFrom == 14) {
                msgImageText.title = this.j.title;
            } else {
                msgImageText.title = i == 8 ? this.j.title : this.j.content;
            }
            msgImageText.summary = this.j.content;
            if (this.j.flag == 1) {
                msgImageText.imageUrl = this.j.netImgUrl;
            } else {
                msgImageText.imageUrl = this.j.fileUrl;
            }
            msgImageText.targetUrl = this.j.linkUrl;
            intent.putExtra("WXEnetry_jrj_show", msgImageText);
        }
        intent.putExtra("intent_mode", "intent_mode_share");
        ShareProvider.getInstance().registerCallback(new ShareCallbackListener());
        this.f33704a.startActivity(intent);
    }

    public void a(int i, ShareCoreUtils.ShareBackLister shareBackLister, PopWindowSetting popWindowSetting) {
        AppInfo.n().postDelayed(new Runnable() { // from class: com.soft.blued.ui.share_custom.BaseShareToPlatform.2
            @Override // java.lang.Runnable
            public void run() {
                BaseShareToPlatform.this.d.d();
            }
        }, 300L);
        ArrayMap arrayMap = new ArrayMap();
        if (i == R.string.ssdk_sinaweibo) {
            arrayMap.put("af_adset", "weibo");
            BaseShareEntity baseShareEntity = this.j;
            baseShareEntity.linkUrl = HttpUtils.a(arrayMap, baseShareEntity.linkUrl);
            a();
        } else if (i == R.string.ssdk_wechat) {
            arrayMap.put("af_adset", ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE);
            BaseShareEntity baseShareEntity2 = this.j;
            baseShareEntity2.linkUrl = HttpUtils.a(arrayMap, baseShareEntity2.linkUrl);
            a(8, this.j.shareType);
        } else if (i == R.string.ssdk_wechatmoments) {
            arrayMap.put("af_adset", "wechatmoment");
            BaseShareEntity baseShareEntity3 = this.j;
            baseShareEntity3.linkUrl = HttpUtils.a(arrayMap, baseShareEntity3.linkUrl);
            a(16, this.j.shareType);
        } else if (i == R.string.ssdk_qq) {
            arrayMap.put("af_adset", "qq");
            BaseShareEntity baseShareEntity4 = this.j;
            baseShareEntity4.linkUrl = HttpUtils.a(arrayMap, baseShareEntity4.linkUrl);
            a(this.j.shareType);
        }
        Logger.c(f33703c, "mShareEntity.linkUrl platform", this.j.linkUrl);
    }

    public void a(BaseShareEntity baseShareEntity) {
        this.j = baseShareEntity;
        if (baseShareEntity.netImgUrl == null) {
            this.j.netImgUrl = "";
        }
        if (baseShareEntity.fileUrl == null) {
            this.j.fileUrl = "";
        }
        if (baseShareEntity.ifHideShareToFeed) {
            this.i.a(R.string.common_main_feed);
        }
        if (baseShareEntity.ifHideShareToPeopleAndGroup) {
            this.i.a(R.string.share_to_friends);
        }
        if (baseShareEntity.ifHideRepostToFeed) {
            this.i.a(R.string.feed_repost);
        }
        PopMenuFromBottom popMenuFromBottom = this.d;
        if (popMenuFromBottom != null) {
            popMenuFromBottom.e();
        }
    }

    public void a(String str) {
        ShareCoreUtils.ShareBackLister shareBackLister = this.b;
        if (shareBackLister != null) {
            shareBackLister.a(str);
        }
        if (TextUtils.equals(str, Constants.SinaWeiboNAME) || TextUtils.equals(str, Constants.QQNAME)) {
            AppMethods.d(R.string.ssdk_oks_share_completed);
        }
    }

    public void a(boolean z) {
        ShapeLinearLayout shapeLinearLayout = (ShapeLinearLayout) this.e.findViewById(R.id.ll_all);
        TextView textView = (TextView) this.e.findViewById(R.id.tv_cancel);
        if (z) {
            ShapeHelper.b(shapeLinearLayout, R.color.share_dark_bg);
            textView.setTextColor(this.f33704a.getResources().getColor(R.color.share_dark_text));
            textView.setBackgroundColor(this.f33704a.getResources().getColor(R.color.share_dark_btn));
        }
    }

    public void b(BaseShareEntity baseShareEntity) {
        this.j = baseShareEntity;
        if (baseShareEntity.netImgUrl == null) {
            this.j.netImgUrl = "";
        }
        if (this.j.fileUrl == null) {
            this.j.fileUrl = "";
        }
        ArrayMap arrayMap = new ArrayMap();
        if (!TextUtils.isEmpty(this.j.platFormName) && this.j.platFormName.equals(Constants.SinaWeiboNAME)) {
            arrayMap.put("af_adset", "weibo");
            BaseShareEntity baseShareEntity2 = this.j;
            baseShareEntity2.linkUrl = HttpUtils.a(arrayMap, baseShareEntity2.linkUrl);
            a();
        } else if (!TextUtils.isEmpty(this.j.platFormName) && this.j.platFormName.equals(Constants.WechatNAME)) {
            arrayMap.put("af_adset", ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE);
            BaseShareEntity baseShareEntity3 = this.j;
            baseShareEntity3.linkUrl = HttpUtils.a(arrayMap, baseShareEntity3.linkUrl);
            a(8, this.j.shareType);
        } else if (!TextUtils.isEmpty(this.j.platFormName) && this.j.platFormName.equals(Constants.WechatMomentsNAME)) {
            arrayMap.put("af_adset", "wechatmoment");
            BaseShareEntity baseShareEntity4 = this.j;
            baseShareEntity4.linkUrl = HttpUtils.a(arrayMap, baseShareEntity4.linkUrl);
            a(16, this.j.shareType);
        } else if (TextUtils.isEmpty(this.j.platFormName) || !this.j.platFormName.equals(Constants.QQNAME)) {
        } else {
            arrayMap.put("af_adset", "qq");
            BaseShareEntity baseShareEntity5 = this.j;
            baseShareEntity5.linkUrl = HttpUtils.a(arrayMap, baseShareEntity5.linkUrl);
            a(this.j.shareType);
        }
    }
}
