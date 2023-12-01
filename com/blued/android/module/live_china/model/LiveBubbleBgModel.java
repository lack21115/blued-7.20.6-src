package com.blued.android.module.live_china.model;

import android.graphics.Color;
import com.blued.android.core.AppInfo;
import com.blued.android.framework.utils.TypeUtils;
import com.igexin.push.core.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveBubbleBgModel.class */
public class LiveBubbleBgModel implements Serializable {
    public String chat_frame;
    public List<String> chat_frame_border_color;
    public List<String> chat_frame_frame_color;
    public int chat_frame_gradient_type;
    public String chat_frame_icon;
    public int chat_frame_icon_src;
    public int chat_frame_id;
    public String chat_frame_name;
    public long create_time;
    public int days;
    public String expire_time;
    public int[] frameColors;
    public int is_hide_expire_time = 0;
    public int status;
    public int[] stokeColors;
    public long update_time;
    public int wear;

    public LiveBubbleBgModel() {
    }

    public LiveBubbleBgModel(String str, String str2, int i, List<String> list, List<String> list2) {
        this.chat_frame = str;
        this.chat_frame_icon = str2;
        this.chat_frame_gradient_type = i;
        this.chat_frame_frame_color = list;
        this.chat_frame_border_color = list2;
        convertColors();
    }

    public void convertColors() {
        if (TypeUtils.a((List<?>) this.chat_frame_frame_color)) {
            this.frameColors = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (String str : this.chat_frame_frame_color) {
                if (str != null) {
                    try {
                        if (str.startsWith("#") && (str.length() == 7 || str.length() == 9)) {
                            arrayList.add(Integer.valueOf(str.length() == 9 ? Color.parseColor("#" + str.substring(str.length() - 2) + str.substring(1, 7)) : Color.parseColor(str)));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.frameColors = new int[arrayList.size()];
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= arrayList.size()) {
                        break;
                    }
                    this.frameColors[i2] = ((Integer) arrayList.get(i2)).intValue();
                    i = i2 + 1;
                }
            } else {
                this.frameColors = null;
            }
        }
        if (TypeUtils.a((List<?>) this.chat_frame_border_color)) {
            this.stokeColors = null;
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (String str2 : this.chat_frame_border_color) {
            if (str2 != null) {
                try {
                    if (str2.startsWith("#") && (str2.length() == 7 || str2.length() == 9)) {
                        arrayList2.add(Integer.valueOf(str2.length() == 9 ? Color.parseColor("#" + str2.substring(str2.length() - 2) + str2.substring(1, 7)) : Color.parseColor(str2)));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (arrayList2.size() <= 0) {
            this.stokeColors = null;
            return;
        }
        this.stokeColors = new int[arrayList2.size()];
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= arrayList2.size()) {
                return;
            }
            this.stokeColors[i4] = ((Integer) arrayList2.get(i4)).intValue();
            i3 = i4 + 1;
        }
    }

    public boolean isValid() {
        return (TypeUtils.a((List<?>) this.chat_frame_frame_color) && TypeUtils.a((List<?>) this.chat_frame_border_color)) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LiveBubbleBgModel{chat_frame_frame_color=");
        sb.append(this.chat_frame_frame_color == null ? b.l : AppInfo.f().toJson(this.chat_frame_frame_color));
        sb.append(", chat_frame_border_color=");
        sb.append(this.chat_frame_border_color == null ? b.l : AppInfo.f().toJson(this.chat_frame_border_color));
        sb.append('}');
        return sb.toString();
    }
}
