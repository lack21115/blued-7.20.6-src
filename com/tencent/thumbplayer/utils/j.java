package com.tencent.thumbplayer.utils;

import com.tencent.thumbplayer.api.TPAudioAttributes;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPJitterBufferConfig;
import com.tencent.thumbplayer.api.TPSubtitleRenderModel;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/utils/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<Integer, Class> f25747a;

    static {
        HashMap<Integer, Class> hashMap = new HashMap<>();
        f25747a = hashMap;
        hashMap.put(414, TPAudioAttributes.class);
        f25747a.put(507, TPSubtitleRenderModel.class);
        f25747a.put(140, TPJitterBufferConfig.class);
    }

    public static boolean a(@TPCommonEnum.TPOptionalId int i, Object obj) {
        Class cls;
        return (obj == null || (cls = f25747a.get(Integer.valueOf(i))) == null || obj.getClass() != cls) ? false : true;
    }
}
