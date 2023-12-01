package com.tencent.thumbplayer.adapter.strategy.utils;

import com.tencent.thumbplayer.adapter.b;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap;
import com.tencent.thumbplayer.core.common.TPNativeLibraryException;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.utils.TPLogUtil;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPStrategyUtils.class */
public class TPStrategyUtils {
    private static final String TAG = "TPStrategyUtils";

    public static boolean enablePlayBySystemPlayer(b bVar) {
        if (bVar.m() == 0) {
            return true;
        }
        return isSupportMediaCodec(bVar);
    }

    public static boolean enablePlayByThumbPlayer(b bVar) {
        return bVar == null || bVar.m() == 0 || isSupportFFmpegCodec(bVar) || isSupportMediaCodec(bVar);
    }

    public static boolean isSupportFFmpegCodec(b bVar) {
        try {
            return TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(101, TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapCodecType.class, bVar.m()), (int) bVar.a(), (int) bVar.b(), bVar.e(), bVar.g());
        } catch (TPNativeLibraryException e) {
            TPLogUtil.e(TAG, e);
            return false;
        }
    }

    public static boolean isSupportMediaCodec(b bVar) {
        try {
            return TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(102, TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapCodecType.class, bVar.m()), (int) bVar.a(), (int) bVar.b(), bVar.e(), bVar.g());
        } catch (TPNativeLibraryException e) {
            TPLogUtil.e(TAG, e);
            return false;
        }
    }

    public static boolean isSystemPlayerEnable() {
        return true;
    }

    public static boolean isTVPlatform() {
        return false;
    }

    public static boolean isThumbPlayerEnable() {
        return TPNativeLibraryLoader.isLibLoaded();
    }
}
