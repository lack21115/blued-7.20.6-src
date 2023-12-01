package com.tencent.mapsdk.internal;

import com.tencent.mapsdk.core.components.protocol.jce.trafficevent.Detail;
import com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/fh.class */
public class fh implements TrafficEvent {
    private static final String b = "yyyy/MM/dd HH时";

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f37448c = {"交通事故", "交通管制", "道路施工", "路上障碍物", "活动", "恶劣天气", "灾害", "拥堵", "检查", "一般事故", "积水", "其他事件"};
    private static final String[] d = {"发生", "出现", "有", "有", "有", "出现", "有", "出现", "有", "发生", "有", "有"};

    /* renamed from: a  reason: collision with root package name */
    private Detail f37449a;

    public fh(Detail detail) {
        this.f37449a = detail;
    }

    public Detail a() {
        return this.f37449a;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent
    public String getDescription() {
        int i = this.f37449a.basic.type;
        String[] strArr = f37448c;
        String str = i > strArr.length ? d[strArr.length - 1] : d[i - 1];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(b, Locale.US);
        return simpleDateFormat.format(new Date(this.f37449a.basic.start_time * 1000)) + " - " + simpleDateFormat.format(new Date(this.f37449a.basic.end_time * 1000)) + (char) 65292 + getRoadName() + str + getType();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent
    public int getEndTime() {
        return this.f37449a.basic.end_time;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent
    public String getMessage() {
        return this.f37449a.basic.message;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent
    public String getRoadName() {
        return this.f37449a.basic.roadname;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent
    public String getSource() {
        return this.f37449a.basic.source;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent
    public int getStartTime() {
        return this.f37449a.basic.start_time;
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent
    public String getType() {
        int i = this.f37449a.basic.type;
        String[] strArr = f37448c;
        return i > strArr.length ? strArr[strArr.length - 1] : strArr[i - 1];
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.model.TrafficEvent
    public int getUpdateTime() {
        return this.f37449a.basic.update_time;
    }
}
