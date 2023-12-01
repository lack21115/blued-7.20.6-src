package com.huawei.openalliance.ad.utils;

import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.AdTimeStatistics;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.ContentExt;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.beans.metadata.InstallConfig;
import com.huawei.openalliance.ad.beans.metadata.InteractCfg;
import com.huawei.openalliance.ad.beans.metadata.MediaFile;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.Om;
import com.huawei.openalliance.ad.beans.metadata.Permission;
import com.huawei.openalliance.ad.beans.metadata.TextState;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.ad.beans.metadata.v3.Asset;
import com.huawei.openalliance.ad.beans.metadata.v3.MotionData;
import com.huawei.openalliance.ad.beans.metadata.v3.TemplateData;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Data;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Image;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.ImageExt;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Title;
import com.huawei.openalliance.ad.beans.metadata.v3.openrtb.Video;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.inter.data.PermissionEntity;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/utils/ao.class */
public class ao extends ObjectInputStream {
    private static final Class[] Code = {String.class, ArrayList.class, CopyOnWriteArrayList.class, LinkedList.class, HashMap.class, HashSet.class, Integer.class, Float.class, Boolean.class, Long.class, Byte.class, Character.class, Short.class, Double.class, Number.class, ImageInfo.class, VideoInfo.class, AppInfo.class, Permission.class, PermissionEntity.class, VideoInfo.class, ApkInfo.class, MetaData.class, AdContentData.class, InstallConfig.class, Om.class, ImpEX.class, DelayInfo.class, MediaFile.class, AdTimeStatistics.class, TextState.class, InteractCfg.class, ContentExt.class, FeedbackInfo.class, AdSource.class, com.huawei.openalliance.ad.beans.metadata.a.class, TemplateData.class, MotionData.class, Asset.class, Image.class, ImageExt.class, Video.class, Title.class, Data.class, AdvertiserInfo.class};

    public ao(InputStream inputStream) {
        super(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // java.io.ObjectInputStream
    public Class<?> resolveClass(ObjectStreamClass objectStreamClass) {
        boolean z;
        Class[] clsArr = Code;
        int length = clsArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            z = false;
            if (i2 >= length) {
                break;
            } else if (clsArr[i2].getName().equals(objectStreamClass.getName())) {
                z = true;
                break;
            } else {
                i = i2 + 1;
            }
        }
        if (z) {
            return super.resolveClass(objectStreamClass);
        }
        throw new ClassNotFoundException("Class " + objectStreamClass.getName() + " is not allowed!");
    }
}
