package com.anythink.expressad.exoplayer.k;

import android.graphics.Color;
import android.hardware.Camera;
import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.liteav.TXLiteAVCode;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/e.class */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4808a = "rgb";
    private static final String b = "rgba";

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f4809c = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern d = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
    private static final Pattern e = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
    private static final Map<String, Integer> f;

    static {
        HashMap hashMap = new HashMap();
        f = hashMap;
        hashMap.put("aliceblue", -984833);
        f.put("antiquewhite", -332841);
        Map<String, Integer> map = f;
        Integer valueOf = Integer.valueOf((int) Color.CYAN);
        map.put(Camera.Parameters.EFFECT_AQUA, valueOf);
        f.put("aquamarine", -8388652);
        f.put("azure", -983041);
        f.put("beige", -657956);
        f.put("bisque", -6972);
        f.put(WbCloudFaceContant.BLACK, -16777216);
        f.put("blanchedalmond", -5171);
        f.put("blue", Integer.valueOf((int) Color.BLUE));
        f.put("blueviolet", -7722014);
        f.put("brown", -5952982);
        f.put("burlywood", -2180985);
        f.put("cadetblue", -10510688);
        f.put("chartreuse", -8388864);
        f.put("chocolate", -2987746);
        f.put("coral", -32944);
        f.put("cornflowerblue", -10185235);
        f.put("cornsilk", -1828);
        f.put("crimson", -2354116);
        f.put("cyan", valueOf);
        f.put("darkblue", -16777077);
        f.put("darkcyan", -16741493);
        f.put("darkgoldenrod", -4684277);
        f.put("darkgray", -5658199);
        f.put("darkgreen", -16751616);
        f.put("darkgrey", -5658199);
        f.put("darkkhaki", -4343957);
        f.put("darkmagenta", -7667573);
        f.put("darkolivegreen", -11179217);
        f.put("darkorange", -29696);
        f.put("darkorchid", -6737204);
        f.put("darkred", -7667712);
        f.put("darksalmon", -1468806);
        f.put("darkseagreen", -7357297);
        f.put("darkslateblue", -12042869);
        f.put("darkslategray", -13676721);
        f.put("darkslategrey", -13676721);
        f.put("darkturquoise", -16724271);
        f.put("darkviolet", -7077677);
        f.put("deeppink", -60269);
        f.put("deepskyblue", -16728065);
        f.put("dimgray", -9868951);
        f.put("dimgrey", -9868951);
        f.put("dodgerblue", -14774017);
        f.put("firebrick", -5103070);
        f.put("floralwhite", -1296);
        f.put("forestgreen", -14513374);
        Map<String, Integer> map2 = f;
        Integer valueOf2 = Integer.valueOf((int) Color.MAGENTA);
        map2.put("fuchsia", valueOf2);
        f.put("gainsboro", -2302756);
        f.put("ghostwhite", -460545);
        f.put("gold", -10496);
        f.put("goldenrod", -2448096);
        f.put("gray", -8355712);
        f.put("green", -16744448);
        f.put("greenyellow", -5374161);
        f.put("grey", -8355712);
        f.put("honeydew", -983056);
        f.put("hotpink", -38476);
        f.put("indianred", -3318692);
        f.put("indigo", -11861886);
        f.put("ivory", -16);
        f.put("khaki", -989556);
        f.put("lavender", -1644806);
        f.put("lavenderblush", -3851);
        f.put("lawngreen", -8586240);
        f.put("lemonchiffon", Integer.valueOf((int) TXLiteAVCode.ERR_AUDIO_PLUGIN_INSTALL_NOT_AUTHORIZED));
        f.put("lightblue", -5383962);
        f.put("lightcoral", -1015680);
        f.put("lightcyan", -2031617);
        f.put("lightgoldenrodyellow", -329006);
        f.put("lightgray", -2894893);
        f.put("lightgreen", -7278960);
        f.put("lightgrey", -2894893);
        f.put("lightpink", -18751);
        f.put("lightsalmon", -24454);
        f.put("lightseagreen", -14634326);
        f.put("lightskyblue", -7876870);
        f.put("lightslategray", -8943463);
        f.put("lightslategrey", -8943463);
        f.put("lightsteelblue", -5192482);
        f.put("lightyellow", -32);
        f.put("lime", Integer.valueOf((int) Color.GREEN));
        f.put("limegreen", -13447886);
        f.put("linen", -331546);
        f.put("magenta", valueOf2);
        f.put("maroon", -8388608);
        f.put("mediumaquamarine", -10039894);
        f.put("mediumblue", -16777011);
        f.put("mediumorchid", -4565549);
        f.put("mediumpurple", -7114533);
        f.put("mediumseagreen", -12799119);
        f.put("mediumslateblue", -8689426);
        f.put("mediumspringgreen", -16713062);
        f.put("mediumturquoise", -12004916);
        f.put("mediumvioletred", -3730043);
        f.put("midnightblue", -15132304);
        f.put("mintcream", -655366);
        f.put("mistyrose", -6943);
        f.put("moccasin", -6987);
        f.put("navajowhite", -8531);
        f.put("navy", -16777088);
        f.put("oldlace", -133658);
        f.put("olive", -8355840);
        f.put("olivedrab", -9728477);
        f.put("orange", -23296);
        f.put("orangered", -47872);
        f.put("orchid", -2461482);
        f.put("palegoldenrod", -1120086);
        f.put("palegreen", -6751336);
        f.put("paleturquoise", -5247250);
        f.put("palevioletred", -2396013);
        f.put("papayawhip", -4139);
        f.put("peachpuff", -9543);
        f.put("peru", -3308225);
        f.put("pink", -16181);
        f.put("plum", -2252579);
        f.put("powderblue", -5185306);
        f.put("purple", -8388480);
        f.put("rebeccapurple", -10079335);
        f.put("red", -65536);
        f.put("rosybrown", -4419697);
        f.put("royalblue", -12490271);
        f.put("saddlebrown", -7650029);
        f.put("salmon", -360334);
        f.put("sandybrown", -744352);
        f.put("seagreen", -13726889);
        f.put("seashell", -2578);
        f.put("sienna", -6270419);
        f.put("silver", -4144960);
        f.put("skyblue", -7876885);
        f.put("slateblue", -9807155);
        f.put("slategray", -9404272);
        f.put("slategrey", -9404272);
        f.put(Camera.Parameters.SCENE_MODE_SNOW, -1286);
        f.put("springgreen", -16711809);
        f.put("steelblue", -12156236);
        f.put("tan", -2968436);
        f.put("teal", -16744320);
        f.put("thistle", -2572328);
        f.put("tomato", -40121);
        f.put("transparent", 0);
        f.put("turquoise", -12525360);
        f.put("violet", -1146130);
        f.put("wheat", -663885);
        f.put(WbCloudFaceContant.WHITE, -1);
        f.put("whitesmoke", -657931);
        f.put("yellow", -256);
        f.put("yellowgreen", -6632142);
    }

    private e() {
    }

    private static int a(int i, int i2, int i3) {
        return a(255, i, i2, i3);
    }

    private static int a(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    private static int a(String str) {
        return a(str, false);
    }

    private static int a(String str, boolean z) {
        a.a(!TextUtils.isEmpty(str));
        String replace = str.replace(" ", "");
        if (replace.charAt(0) == '#') {
            int parseLong = (int) Long.parseLong(replace.substring(1), 16);
            if (replace.length() == 7) {
                return (-16777216) | parseLong;
            }
            if (replace.length() == 9) {
                return ((parseLong & 255) << 24) | (parseLong >>> 8);
            }
            throw new IllegalArgumentException();
        }
        if (replace.startsWith(b)) {
            Matcher matcher = (z ? e : d).matcher(replace);
            if (matcher.matches()) {
                return a(z ? (int) (Float.parseFloat(matcher.group(4)) * 255.0f) : Integer.parseInt(matcher.group(4), 10), Integer.parseInt(matcher.group(1), 10), Integer.parseInt(matcher.group(2), 10), Integer.parseInt(matcher.group(3), 10));
            }
        } else if (replace.startsWith(f4808a)) {
            Matcher matcher2 = f4809c.matcher(replace);
            if (matcher2.matches()) {
                return a(Integer.parseInt(matcher2.group(1), 10), Integer.parseInt(matcher2.group(2), 10), Integer.parseInt(matcher2.group(3), 10));
            }
        } else {
            Integer num = f.get(af.d(replace));
            if (num != null) {
                return num.intValue();
            }
        }
        throw new IllegalArgumentException();
    }

    private static int b(String str) {
        return a(str, true);
    }
}
