package com.sobot.chat.widget.html;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.UnderlineSpan;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.constant.t;
import com.sobot.chat.utils.ScreenUtils;
import com.sobot.chat.utils.StringUtils;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.xml.sax.XMLReader;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/html/SobotCustomTagHandler.class */
public class SobotCustomTagHandler implements Html.TagHandler {
    public static final String HTML_FONT = "font";
    public static final String HTML_SPAN = "span";
    public static final String NEW_FONT = "myfont";
    public static final String NEW_SPAN = "sobotspan";
    private Context mContext;
    private ColorStateList mOriginColors;
    private final String TAG = "CustomTagHandler";
    private List<SobotHtmlLabelBean> labelBeanList = new ArrayList();
    private List<SobotHtmlLabelBean> tempRemoveLabelList = new ArrayList();
    final HashMap<String, String> attributes = new HashMap<>();

    public SobotCustomTagHandler(Context context, ColorStateList colorStateList) {
        this.mContext = context;
        this.mOriginColors = colorStateList;
    }

    private void analysisStyle(SobotHtmlLabelBean sobotHtmlLabelBean, String str) {
        String[] split = str.split(t.aE);
        HashMap hashMap = new HashMap();
        if (split != null) {
            int length = split.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                String[] split2 = split[i2].split(":");
                if (split2 != null && split2.length == 2) {
                    hashMap.put(split2[0].trim(), split2[1].trim());
                }
                i = i2 + 1;
            }
        }
        sobotHtmlLabelBean.color = (String) hashMap.get("color");
        sobotHtmlLabelBean.fontSize = (String) hashMap.get("font-size");
        sobotHtmlLabelBean.textdecoration = (String) hashMap.get("text-decoration");
        sobotHtmlLabelBean.textdecorationline = (String) hashMap.get("text-decoration-line");
        sobotHtmlLabelBean.backgroundColor = (String) hashMap.get("background-color");
        sobotHtmlLabelBean.background = (String) hashMap.get("background");
        sobotHtmlLabelBean.fontweight = (String) hashMap.get("font-weight");
        sobotHtmlLabelBean.fontstyle = (String) hashMap.get("font-style");
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int getLastLabelByTag(String str) {
        int size = this.labelBeanList.size();
        while (true) {
            int i = size - 1;
            if (i < 0) {
                return -1;
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.labelBeanList.get(i).tag) && this.labelBeanList.get(i).tag.equals(str)) {
                return i;
            }
            size = i;
        }
    }

    private void optBeanRange(SobotHtmlLabelBean sobotHtmlLabelBean) {
        int i;
        if (sobotHtmlLabelBean.ranges == null) {
            sobotHtmlLabelBean.ranges = new ArrayList();
        }
        if (this.tempRemoveLabelList.size() == 0) {
            SobotHtmlLabelRangeBean sobotHtmlLabelRangeBean = new SobotHtmlLabelRangeBean();
            sobotHtmlLabelRangeBean.start = sobotHtmlLabelBean.startIndex;
            sobotHtmlLabelRangeBean.end = sobotHtmlLabelBean.endIndex;
            sobotHtmlLabelBean.ranges.add(sobotHtmlLabelRangeBean);
            return;
        }
        int size = this.tempRemoveLabelList.size() - 1;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            i = i3;
            if (size < 0) {
                break;
            }
            SobotHtmlLabelBean sobotHtmlLabelBean2 = this.tempRemoveLabelList.get(size);
            int i4 = i;
            if (sobotHtmlLabelBean2.endIndex <= sobotHtmlLabelBean.endIndex) {
                i4 = i;
                if (i == -1) {
                    i4 = size;
                }
            }
            if (sobotHtmlLabelBean2.startIndex >= sobotHtmlLabelBean.startIndex) {
                i2 = size;
            }
            size--;
            i3 = i4;
        }
        if (i2 == -1 || i == -1) {
            SobotHtmlLabelRangeBean sobotHtmlLabelRangeBean2 = new SobotHtmlLabelRangeBean();
            sobotHtmlLabelRangeBean2.start = sobotHtmlLabelBean.startIndex;
            sobotHtmlLabelRangeBean2.end = sobotHtmlLabelBean.endIndex;
            sobotHtmlLabelBean.ranges.add(sobotHtmlLabelRangeBean2);
            return;
        }
        SobotHtmlLabelBean sobotHtmlLabelBean3 = null;
        int i5 = i2;
        while (true) {
            int i6 = i5;
            if (i6 > i) {
                SobotHtmlLabelRangeBean sobotHtmlLabelRangeBean3 = new SobotHtmlLabelRangeBean();
                sobotHtmlLabelRangeBean3.start = sobotHtmlLabelBean3.endIndex;
                sobotHtmlLabelRangeBean3.end = sobotHtmlLabelBean.endIndex;
                sobotHtmlLabelBean.ranges.add(sobotHtmlLabelRangeBean3);
                return;
            }
            sobotHtmlLabelBean3 = this.tempRemoveLabelList.get(i6);
            if (i6 == i2) {
                SobotHtmlLabelRangeBean sobotHtmlLabelRangeBean4 = new SobotHtmlLabelRangeBean();
                sobotHtmlLabelRangeBean4.start = sobotHtmlLabelBean.startIndex;
                sobotHtmlLabelRangeBean4.end = sobotHtmlLabelBean3.startIndex;
                sobotHtmlLabelBean.ranges.add(sobotHtmlLabelRangeBean4);
            } else {
                SobotHtmlLabelRangeBean sobotHtmlLabelRangeBean5 = new SobotHtmlLabelRangeBean();
                sobotHtmlLabelRangeBean5.start = this.tempRemoveLabelList.get(i6 - 1).endIndex;
                sobotHtmlLabelRangeBean5.end = sobotHtmlLabelBean3.startIndex;
                sobotHtmlLabelBean.ranges.add(sobotHtmlLabelRangeBean5);
            }
            i5 = i6 + 1;
        }
    }

    private void optRemoveByAddBean(SobotHtmlLabelBean sobotHtmlLabelBean) {
        boolean z;
        int size = this.tempRemoveLabelList.size() - 1;
        boolean z2 = false;
        while (true) {
            z = z2;
            if (size < 0) {
                break;
            }
            SobotHtmlLabelBean sobotHtmlLabelBean2 = this.tempRemoveLabelList.get(size);
            boolean z3 = z;
            if (sobotHtmlLabelBean.startIndex <= sobotHtmlLabelBean2.startIndex) {
                z3 = z;
                if (sobotHtmlLabelBean.endIndex >= sobotHtmlLabelBean2.endIndex) {
                    if (z) {
                        this.tempRemoveLabelList.remove(size);
                        z3 = z;
                    } else {
                        this.tempRemoveLabelList.set(size, sobotHtmlLabelBean);
                        z3 = true;
                    }
                }
            }
            size--;
            z2 = z3;
        }
        if (z) {
            return;
        }
        this.tempRemoveLabelList.add(sobotHtmlLabelBean);
    }

    public static int parseHtmlColor(String str) {
        if (str.charAt(0) == '#') {
            String str2 = str;
            if (str.length() == 4) {
                StringBuilder sb = new StringBuilder("#");
                int i = 1;
                while (true) {
                    int i2 = i;
                    if (i2 >= str.length()) {
                        break;
                    }
                    char charAt = str.charAt(i2);
                    sb.append(charAt);
                    sb.append(charAt);
                    i = i2 + 1;
                }
                str2 = sb.toString();
            }
            long parseLong = Long.parseLong(str2.substring(1), 16);
            if (str2.length() == 7) {
                parseLong |= -16777216;
            } else if (str2.length() != 9) {
                return 0;
            }
            return (int) parseLong;
        } else if ((str.startsWith("rgb(") || str.startsWith("rgba(")) && str.endsWith(")")) {
            String[] split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).replaceAll(" ", "").split(",");
            if (split.length == 3) {
                return Color.argb(255, Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            }
            if (split.length == 4) {
                return Color.argb(Integer.parseInt(split[3]), Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            }
            return 0;
        } else if ("red".equalsIgnoreCase(str.trim())) {
            return -65536;
        } else {
            if ("blue".equalsIgnoreCase(str.trim())) {
                return Color.BLUE;
            }
            if (WbCloudFaceContant.BLACK.equalsIgnoreCase(str.trim())) {
                return -16777216;
            }
            if ("gray".equalsIgnoreCase(str.trim())) {
                return Color.GRAY;
            }
            if ("green".equalsIgnoreCase(str.trim())) {
                return Color.GREEN;
            }
            if ("yellow".equalsIgnoreCase(str.trim())) {
                return -256;
            }
            return WbCloudFaceContant.WHITE.equalsIgnoreCase(str.trim()) ? -1 : 0;
        }
    }

    private void processAttributes(XMLReader xMLReader) {
        try {
            Field declaredField = xMLReader.getClass().getDeclaredField("theNewElement");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(xMLReader);
            Field declaredField2 = obj.getClass().getDeclaredField("theAtts");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Field declaredField3 = obj2.getClass().getDeclaredField("data");
            declaredField3.setAccessible(true);
            String[] strArr = (String[]) declaredField3.get(obj2);
            Field declaredField4 = obj2.getClass().getDeclaredField("length");
            declaredField4.setAccessible(true);
            int intValue = ((Integer) declaredField4.get(obj2)).intValue();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= intValue) {
                    return;
                }
                int i3 = i2 * 5;
                this.attributes.put(strArr[i3 + 1], strArr[i3 + 4]);
                i = i2 + 1;
            }
        } catch (Exception e) {
        }
    }

    public static int px2dip(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void reductionFontColor(int i, int i2, Editable editable) {
        if (this.mOriginColors != null) {
            editable.setSpan(new TextAppearanceSpan(null, 0, 0, this.mOriginColors, null), i, i2, 33);
        } else {
            editable.setSpan(new ForegroundColorSpan(-13948117), i, i2, 33);
        }
    }

    public static int sp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public void endFont(String str, Editable editable, XMLReader xMLReader) {
        int length = editable.length();
        int lastLabelByTag = getLastLabelByTag(str);
        if (lastLabelByTag != -1) {
            SobotHtmlLabelBean sobotHtmlLabelBean = this.labelBeanList.get(lastLabelByTag);
            sobotHtmlLabelBean.endIndex = length;
            optBeanRange(sobotHtmlLabelBean);
            for (SobotHtmlLabelRangeBean sobotHtmlLabelRangeBean : sobotHtmlLabelBean.ranges) {
                String str2 = sobotHtmlLabelBean.color;
                String str3 = sobotHtmlLabelBean.fontSize;
                String str4 = sobotHtmlLabelBean.textdecoration;
                String str5 = sobotHtmlLabelBean.textdecorationline;
                String str6 = sobotHtmlLabelBean.backgroundColor;
                String str7 = sobotHtmlLabelBean.background;
                String str8 = sobotHtmlLabelBean.fontweight;
                String str9 = sobotHtmlLabelBean.fontstyle;
                if (!TextUtils.isEmpty(str9) && ("italic".equalsIgnoreCase(str9) || "oblique".equalsIgnoreCase(str9))) {
                    editable.setSpan(new StyleSpan(2), sobotHtmlLabelRangeBean.start, sobotHtmlLabelRangeBean.end, 33);
                }
                if (!TextUtils.isEmpty(str8) && StringUtils.isNumber(str8) && Integer.parseInt(str8) >= 700) {
                    editable.setSpan(new StyleSpan(1), sobotHtmlLabelRangeBean.start, sobotHtmlLabelRangeBean.end, 33);
                }
                if (!TextUtils.isEmpty(str8) && "bold".equalsIgnoreCase(str8)) {
                    editable.setSpan(new StyleSpan(1), sobotHtmlLabelRangeBean.start, sobotHtmlLabelRangeBean.end, 33);
                }
                String str10 = str3;
                if (!TextUtils.isEmpty(str3)) {
                    str10 = str3.split("px")[0];
                }
                if (!TextUtils.isEmpty(str10)) {
                    Context context = this.mContext;
                    editable.setSpan(new AbsoluteSizeSpan(context != null ? ScreenUtils.sp2px(context, Integer.parseInt(str10)) : 16), sobotHtmlLabelRangeBean.start, sobotHtmlLabelRangeBean.end, 33);
                }
                if (!TextUtils.isEmpty(str4) && !str4.equalsIgnoreCase("none") && !str4.equalsIgnoreCase("overline") && !str4.equalsIgnoreCase("blink")) {
                    if (str4.equalsIgnoreCase("line-through")) {
                        editable.setSpan(new StrikethroughSpan(), sobotHtmlLabelRangeBean.start, sobotHtmlLabelRangeBean.end, 33);
                    } else {
                        editable.setSpan(new UnderlineSpan(), sobotHtmlLabelRangeBean.start, sobotHtmlLabelRangeBean.end, 33);
                    }
                }
                if (!TextUtils.isEmpty(str5) && !str5.equalsIgnoreCase("none") && !str5.equalsIgnoreCase("overline") && !str5.equalsIgnoreCase("blink")) {
                    if (str5.equalsIgnoreCase("line-through")) {
                        editable.setSpan(new StrikethroughSpan(), sobotHtmlLabelRangeBean.start, sobotHtmlLabelRangeBean.end, 33);
                    } else {
                        editable.setSpan(new UnderlineSpan(), sobotHtmlLabelRangeBean.start, sobotHtmlLabelRangeBean.end, 33);
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    if (str2.startsWith("@")) {
                        int identifier = Resources.getSystem().getIdentifier(str2.substring(1), "color", "android");
                        if (identifier != 0) {
                            editable.setSpan(new ForegroundColorSpan(identifier), sobotHtmlLabelRangeBean.start, sobotHtmlLabelRangeBean.end, 33);
                        }
                    } else {
                        try {
                            editable.setSpan(new ForegroundColorSpan(parseHtmlColor(str2)), sobotHtmlLabelRangeBean.start, sobotHtmlLabelRangeBean.end, 33);
                        } catch (Exception e) {
                            e.printStackTrace();
                            reductionFontColor(sobotHtmlLabelRangeBean.start, length, editable);
                        }
                    }
                }
                if (!TextUtils.isEmpty(str6)) {
                    editable.setSpan(new BackgroundColorSpan(parseHtmlColor(str6)), sobotHtmlLabelRangeBean.start, sobotHtmlLabelRangeBean.end, 33);
                }
                if (!TextUtils.isEmpty(str7)) {
                    editable.setSpan(new BackgroundColorSpan(parseHtmlColor(str7)), sobotHtmlLabelRangeBean.start, sobotHtmlLabelRangeBean.end, 33);
                }
            }
            this.labelBeanList.remove(lastLabelByTag);
            optRemoveByAddBean(sobotHtmlLabelBean);
        }
    }

    @Override // android.text.Html.TagHandler
    public void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        try {
            processAttributes(xMLReader);
            if (str.equalsIgnoreCase(NEW_SPAN) || str.equalsIgnoreCase(NEW_FONT)) {
                if (z) {
                    startFont(str, editable, xMLReader);
                    return;
                }
                endFont(str, editable, xMLReader);
                this.attributes.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void startFont(String str, Editable editable, XMLReader xMLReader) {
        int length = editable.length();
        SobotHtmlLabelBean sobotHtmlLabelBean = new SobotHtmlLabelBean();
        sobotHtmlLabelBean.startIndex = length;
        sobotHtmlLabelBean.tag = str;
        if (NEW_FONT.equals(str)) {
            this.attributes.get("color");
            this.attributes.get(OapsKey.KEY_SIZE);
        } else if (NEW_SPAN.equals(str)) {
            TextUtils.isEmpty(this.attributes.get("color"));
            TextUtils.isEmpty(this.attributes.get(OapsKey.KEY_SIZE));
            String str2 = this.attributes.get("style");
            if (!TextUtils.isEmpty(str2)) {
                analysisStyle(sobotHtmlLabelBean, str2);
            }
        }
        this.labelBeanList.add(sobotHtmlLabelBean);
    }
}
