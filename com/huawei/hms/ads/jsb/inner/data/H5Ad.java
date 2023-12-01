package com.huawei.hms.ads.jsb.inner.data;

import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.km;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.RewardItem;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.au;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/jsb/inner/data/H5Ad.class */
public class H5Ad {
    private String adChoiceUrl;
    private int adType;
    private List<AdvertiserInfo> advertiserInfos;
    private App app;
    private String bannerRefSetting;
    private String clickBtnTxt;
    private String contentId;
    private int creativeType;
    private String desc;
    private String dspLogo;
    private String dspName;
    private long endTime;
    private Map<String, String> ext;
    private ImageInfo icon;
    private List<ImageInfo> imgList;
    private int interactionType;
    private boolean isGaussianBlur;
    private boolean isSilentReserve;
    private List<String> keywords;
    private String logo2Text;
    private MediaFile mediaFile;
    private int minEffectiveShowRatio;
    private long minEffectiveShowTime;
    private String requestId;
    private RewardItem rewardItem;
    private int sequence;
    private String showId;
    private String slotId;
    private String source;
    private String taskId;
    private String title;
    private String uniqueId;
    private Video video;

    public H5Ad() {
    }

    public H5Ad(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        this.isSilentReserve = km.b(adContentData.r());
        this.requestId = adContentData.E();
        this.uniqueId = adContentData.T();
        this.showId = adContentData.B();
        this.slotId = adContentData.C();
        this.contentId = adContentData.S();
        this.taskId = adContentData.F();
        this.adType = adContentData.Code();
        this.creativeType = adContentData.h();
        this.interactionType = adContentData.f();
        this.endTime = adContentData.L();
        this.sequence = adContentData.A();
        this.adChoiceUrl = adContentData.X();
        if (!aa.Code(adContentData.k())) {
            ArrayList arrayList = new ArrayList();
            for (String str : adContentData.k()) {
                arrayList.add(au.S(str));
            }
            this.keywords = arrayList;
        }
        this.isGaussianBlur = adContentData.ag() != 1 ? false : true;
        this.bannerRefSetting = adContentData.aj();
        this.logo2Text = adContentData.n();
        MetaData Z = adContentData.Z();
        if (Z != null) {
            this.minEffectiveShowRatio = Z.S();
            this.minEffectiveShowTime = Z.C();
            this.desc = Z.Z();
            List<com.huawei.openalliance.ad.beans.metadata.ImageInfo> B = Z.B();
            if (B != null && !B.isEmpty()) {
                this.icon = new ImageInfo(B.get(0));
            }
            this.imgList = V(Z.b());
            AdSource Code = AdSource.Code(Z.i());
            if (Code != null) {
                this.dspName = Code.Code();
                this.dspLogo = Code.V();
            }
            this.source = Z.F();
            this.clickBtnTxt = Z.Code();
            this.title = Z.I();
            this.mediaFile = new MediaFile(Z.e(), Z.h());
        }
        if (adContentData.p() != null) {
            this.video = new Video(adContentData.p());
        }
        if (adContentData.H() > 0 && adContentData.G() != null) {
            this.rewardItem = new RewardItem(adContentData.G(), adContentData.H());
        }
        if (adContentData.u() != null) {
            this.app = new App(adContentData.u());
        }
        List<ImpEX> at = adContentData.at();
        HashMap hashMap = new HashMap();
        if (!aa.Code(at)) {
            for (ImpEX impEX : at) {
                hashMap.put(impEX.Code(), impEX.V());
            }
        }
        this.ext = hashMap;
        if (aa.Code(adContentData.aG())) {
            return;
        }
        this.advertiserInfos = adContentData.aG();
    }

    private List<ImageInfo> V(List<com.huawei.openalliance.ad.beans.metadata.ImageInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (com.huawei.openalliance.ad.beans.metadata.ImageInfo imageInfo : list) {
                arrayList.add(new ImageInfo(imageInfo));
            }
        }
        return arrayList;
    }

    public String B() {
        return this.slotId;
    }

    public String C() {
        return this.taskId;
    }

    public String Code() {
        return this.uniqueId;
    }

    public void Code(List<AdvertiserInfo> list) {
        this.advertiserInfos = list;
    }

    public String D() {
        return this.desc;
    }

    public String F() {
        return this.title;
    }

    public String I() {
        return this.requestId;
    }

    public String L() {
        return this.source;
    }

    public int S() {
        return this.adType;
    }

    public String V() {
        return this.showId;
    }

    public String Z() {
        return this.contentId;
    }

    public ImageInfo a() {
        return this.icon;
    }

    public List<ImageInfo> b() {
        return this.imgList;
    }

    public Video c() {
        return this.video;
    }

    public App d() {
        return this.app;
    }

    public String e() {
        return this.clickBtnTxt;
    }

    public int f() {
        return this.creativeType;
    }

    public int g() {
        return this.interactionType;
    }

    public long h() {
        return this.endTime;
    }

    public long i() {
        return this.minEffectiveShowTime;
    }

    public int j() {
        return this.minEffectiveShowRatio;
    }

    public int k() {
        return this.sequence;
    }

    public String l() {
        return this.dspName;
    }

    public String m() {
        return this.dspLogo;
    }

    public String n() {
        return this.logo2Text;
    }

    public List<AdvertiserInfo> o() {
        return this.advertiserInfos;
    }
}
