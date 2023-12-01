package com.tencent.thumbplayer.g.f;

import android.media.MediaFormat;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.g.b.e;
import com.tencent.thumbplayer.g.b.f;
import com.tencent.thumbplayer.g.b.g;
import com.tencent.thumbplayer.g.h.c;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/f/a.class */
public final class a {

    /* renamed from: com.tencent.thumbplayer.g.f.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/f/a$a.class */
    public enum EnumC1024a {
        ADAPTATION_WORKAROUND_MODE_NEVER,
        ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION,
        ADAPTATION_WORKAROUND_MODE_ALWAYS
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/g/f/a$b.class */
    public enum b {
        KEEP_CODEC_RESULT_NO,
        KEEP_CODEC_RESULT_YES_WITH_FLUSH,
        KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION,
        KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION
    }

    public static EnumC1024a a(String str) {
        return (Build.VERSION.SDK_INT <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (TPSystemInfo.getDeviceName().startsWith("SM-T585") || TPSystemInfo.getDeviceName().startsWith("SM-A510") || TPSystemInfo.getDeviceName().startsWith("SM-A520") || TPSystemInfo.getDeviceName().startsWith("SM-J700"))) ? EnumC1024a.ADAPTATION_WORKAROUND_MODE_ALWAYS : (Build.VERSION.SDK_INT >= 24 || !(("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) && ("flounder".equals(Build.DEVICE) || "flounder_lte".equals(Build.DEVICE) || "grouper".equals(Build.DEVICE) || "tilapia".equals(Build.DEVICE)))) ? EnumC1024a.ADAPTATION_WORKAROUND_MODE_NEVER : EnumC1024a.ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION;
    }

    public static void a(e eVar, MediaFormat mediaFormat) {
        com.tencent.thumbplayer.g.f.b d = com.tencent.thumbplayer.g.a.a().d();
        int max = Math.max(d.b, eVar.b);
        int max2 = Math.max(d.f39353c, eVar.f39327c);
        if (d.f39352a) {
            d.b = max;
            d.f39353c = max2;
        }
        int max3 = Math.max(0, c.a(eVar.j, max, max2, false));
        if (com.tencent.thumbplayer.g.h.b.a()) {
            com.tencent.thumbplayer.g.h.b.b("ReuseHelper", "initFormatWrapper initWidth:" + max + " initHeight:" + max2 + " initMaxInputSize:" + max3 + " reusePolicy:" + d);
        }
        eVar.g = max;
        eVar.h = max2;
        eVar.i = max3;
        mediaFormat.setInteger(MediaFormat.KEY_MAX_INPUT_SIZE, Math.max(max3, 0));
        if (!eVar.a() || Build.VERSION.SDK_INT < 19) {
            return;
        }
        mediaFormat.setInteger(MediaFormat.KEY_MAX_WIDTH, max);
        mediaFormat.setInteger(MediaFormat.KEY_MAX_HEIGHT, max2);
    }

    public static boolean a(f fVar, e eVar) {
        return a(fVar, eVar, false);
    }

    public static boolean a(f fVar, e eVar, boolean z) {
        e eVar2 = fVar.e;
        if (fVar instanceof g) {
            if (TextUtils.equals(eVar2.j, eVar.j) && eVar2.d == eVar.d) {
                if (fVar.f39329c) {
                    return true;
                }
                return eVar2.b == eVar.b && eVar2.f39327c == eVar.f39327c;
            }
            return false;
        } else if (fVar instanceof com.tencent.thumbplayer.g.b.a) {
            if (!TextUtils.equals("audio/mp4a-latm", eVar2.j) || !TextUtils.equals(eVar2.j, eVar.j) || eVar2.e != eVar.e || eVar2.f != eVar.f) {
            }
            return false;
        } else {
            return true;
        }
    }
}
