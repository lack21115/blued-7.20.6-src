package com.amap.api.services.route;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.util.i;
import com.amap.api.col.p0003sl.fe;
import com.amap.api.col.p0003sl.hc;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.IRouteSearchV2;
import com.anythink.core.common.c.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/RouteSearchV2.class */
public class RouteSearchV2 {
    private IRouteSearchV2 a;

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/RouteSearchV2$CurveCost.class */
    public static class CurveCost {
        private float a;
        private float b;

        public float getAccess() {
            return this.a;
        }

        public float getValue() {
            return this.b;
        }

        public void setAccess(float f) {
            this.a = f;
        }

        public void setValue(float f) {
            this.b = f;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/RouteSearchV2$CustomCostMode.class */
    public static class CustomCostMode {
        private List<SpeedCost> a;
        private CurveCost b;
        private SlopeCost c;
        private float d;
        private TransCost e;
        private float f;
        private PowerTrainLoss g;

        public float getAuxCost() {
            return this.d;
        }

        public CurveCost getCurveCost() {
            return this.b;
        }

        public float getFerryCost() {
            return this.f;
        }

        public PowerTrainLoss getPowerTrainLosses() {
            return this.g;
        }

        public SlopeCost getSlopeCost() {
            return this.c;
        }

        public List<SpeedCost> getSpeedCosts() {
            return this.a;
        }

        public TransCost getTransCost() {
            return this.e;
        }

        public void setAuxCost(float f) {
            this.d = f;
        }

        public void setCurveCost(CurveCost curveCost) {
            this.b = curveCost;
        }

        public void setFerryCost(float f) {
            this.f = f;
        }

        public void setPowerTrainLosses(PowerTrainLoss powerTrainLoss) {
            this.g = powerTrainLoss;
        }

        public void setSlopeCost(SlopeCost slopeCost) {
            this.c = slopeCost;
        }

        public void setSpeedCosts(List<SpeedCost> list) {
            this.a = list;
        }

        public void setTransCost(TransCost transCost) {
            this.e = transCost;
        }

        public String toJson() {
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                if (this.a != null) {
                    for (SpeedCost speedCost : this.a) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("speed", speedCost.getSpeed());
                        jSONObject2.put(d.a.d, speedCost.getValue());
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("speed_cost", jSONArray);
                }
                if (this.b != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("access", this.b.getAccess());
                    jSONObject3.put(d.a.d, this.b.getValue());
                    jSONObject.put("curve_cost", jSONObject3);
                }
                if (this.c != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("up", this.c.getUp());
                    jSONObject4.put("down", this.c.getDown());
                    jSONObject.put("slope_cost", jSONObject4);
                }
                jSONObject.put("aux_cost", this.d);
                if (this.e != null) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("access", this.e.getAccess());
                    jSONObject5.put("decess", this.e.getDecess());
                    jSONObject.put("trans_cost", jSONObject5);
                }
                jSONObject.put("ferry_cost", this.f);
                if (this.g != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("powerdemand", this.g.getPowerDemand());
                    jSONObject6.put(d.a.d, this.g.getPowerDemandValue());
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("speed", this.g.getSpeed());
                    jSONObject7.put(d.a.d, this.g.getSpeedValue());
                    jSONArray2.put(jSONObject6);
                    jSONArray2.put(jSONObject7);
                    jSONObject.put("powertrain_loss", jSONArray2);
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/RouteSearchV2$DriveRouteQuery.class */
    public static class DriveRouteQuery implements Parcelable, Cloneable {
        public static final Parcelable.Creator<DriveRouteQuery> CREATOR = new Parcelable.Creator<DriveRouteQuery>() { // from class: com.amap.api.services.route.RouteSearchV2.DriveRouteQuery.1
            private static DriveRouteQuery a(Parcel parcel) {
                return new DriveRouteQuery(parcel);
            }

            private static DriveRouteQuery[] a(int i) {
                return new DriveRouteQuery[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DriveRouteQuery createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DriveRouteQuery[] newArray(int i) {
                return a(i);
            }
        };
        private FromAndTo a;
        private NewEnergy b;
        private int c;
        private List<LatLonPoint> d;
        private List<List<LatLonPoint>> e;
        private String f;
        private boolean g;
        private int h;
        private String i;
        private int j;

        public DriveRouteQuery() {
            this.c = DrivingStrategy.DEFAULT.getValue();
            this.g = true;
            this.h = 0;
            this.i = null;
            this.j = 1;
        }

        public DriveRouteQuery(Parcel parcel) {
            this.c = DrivingStrategy.DEFAULT.getValue();
            boolean z = true;
            this.g = true;
            this.h = 0;
            this.i = null;
            this.j = 1;
            this.a = (FromAndTo) parcel.readParcelable(FromAndTo.class.getClassLoader());
            this.c = parcel.readInt();
            this.d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
            int readInt = parcel.readInt();
            if (readInt == 0) {
                this.e = null;
            } else {
                this.e = new ArrayList();
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= readInt) {
                    break;
                }
                this.e.add(parcel.createTypedArrayList(LatLonPoint.CREATOR));
                i = i2 + 1;
            }
            this.f = parcel.readString();
            this.g = parcel.readInt() != 1 ? false : z;
            this.h = parcel.readInt();
            this.i = parcel.readString();
            this.j = parcel.readInt();
        }

        public DriveRouteQuery(FromAndTo fromAndTo, DrivingStrategy drivingStrategy, List<LatLonPoint> list, List<List<LatLonPoint>> list2, String str) {
            this.c = DrivingStrategy.DEFAULT.getValue();
            this.g = true;
            this.h = 0;
            this.i = null;
            this.j = 1;
            this.a = fromAndTo;
            this.c = drivingStrategy.getValue();
            this.d = list;
            this.e = list2;
            this.f = str;
        }

        /* renamed from: clone */
        public DriveRouteQuery m8962clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                fe.a(e, "RouteSearchV2", "DriveRouteQueryclone");
            }
            DriveRouteQuery driveRouteQuery = new DriveRouteQuery(this.a, DrivingStrategy.fromValue(this.c), this.d, this.e, this.f);
            driveRouteQuery.setUseFerry(this.g);
            driveRouteQuery.setCarType(this.h);
            driveRouteQuery.setExclude(this.i);
            driveRouteQuery.setShowFields(this.j);
            driveRouteQuery.setNewEnergy(this.b);
            return driveRouteQuery;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                DriveRouteQuery driveRouteQuery = (DriveRouteQuery) obj;
                String str = this.f;
                if (str == null) {
                    if (driveRouteQuery.f != null) {
                        return false;
                    }
                } else if (!str.equals(driveRouteQuery.f)) {
                    return false;
                }
                List<List<LatLonPoint>> list = this.e;
                if (list == null) {
                    if (driveRouteQuery.e != null) {
                        return false;
                    }
                } else if (!list.equals(driveRouteQuery.e)) {
                    return false;
                }
                FromAndTo fromAndTo = this.a;
                if (fromAndTo == null) {
                    if (driveRouteQuery.a != null) {
                        return false;
                    }
                } else if (!fromAndTo.equals(driveRouteQuery.a)) {
                    return false;
                }
                if (this.c != driveRouteQuery.c) {
                    return false;
                }
                List<LatLonPoint> list2 = this.d;
                return list2 == null ? driveRouteQuery.d == null : list2.equals(driveRouteQuery.d) && this.g == driveRouteQuery.isUseFerry() && this.h == driveRouteQuery.h && this.j == driveRouteQuery.j;
            }
            return false;
        }

        public String getAvoidRoad() {
            return this.f;
        }

        public List<List<LatLonPoint>> getAvoidpolygons() {
            return this.e;
        }

        public String getAvoidpolygonsStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<List<LatLonPoint>> list = this.e;
            if (list == null || list.size() == 0) {
                return null;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.e.size()) {
                    return stringBuffer.toString();
                }
                List<LatLonPoint> list2 = this.e.get(i2);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= list2.size()) {
                        break;
                    }
                    LatLonPoint latLonPoint = list2.get(i4);
                    stringBuffer.append(latLonPoint.getLongitude());
                    stringBuffer.append(",");
                    stringBuffer.append(latLonPoint.getLatitude());
                    if (i4 < list2.size() - 1) {
                        stringBuffer.append(i.b);
                    }
                    i3 = i4 + 1;
                }
                if (i2 < this.e.size() - 1) {
                    stringBuffer.append("|");
                }
                i = i2 + 1;
            }
        }

        public int getCarType() {
            return this.h;
        }

        public String getExclude() {
            return this.i;
        }

        public FromAndTo getFromAndTo() {
            return this.a;
        }

        public DrivingStrategy getMode() {
            return DrivingStrategy.fromValue(this.c);
        }

        public NewEnergy getNewEnergy() {
            return this.b;
        }

        public List<LatLonPoint> getPassedByPoints() {
            return this.d;
        }

        public String getPassedPointStr() {
            StringBuffer stringBuffer = new StringBuffer();
            List<LatLonPoint> list = this.d;
            if (list == null || list.size() == 0) {
                return null;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.d.size()) {
                    return stringBuffer.toString();
                }
                LatLonPoint latLonPoint = this.d.get(i2);
                stringBuffer.append(latLonPoint.getLongitude());
                stringBuffer.append(",");
                stringBuffer.append(latLonPoint.getLatitude());
                if (i2 < this.d.size() - 1) {
                    stringBuffer.append(i.b);
                }
                i = i2 + 1;
            }
        }

        public int getShowFields() {
            return this.j;
        }

        public boolean hasAvoidRoad() {
            return !fe.a(getAvoidRoad());
        }

        public boolean hasAvoidpolygons() {
            return !fe.a(getAvoidpolygonsStr());
        }

        public boolean hasPassPoint() {
            return !fe.a(getPassedPointStr());
        }

        public int hashCode() {
            String str = this.f;
            int i = 0;
            int hashCode = str == null ? 0 : str.hashCode();
            List<List<LatLonPoint>> list = this.e;
            int hashCode2 = list == null ? 0 : list.hashCode();
            FromAndTo fromAndTo = this.a;
            int hashCode3 = fromAndTo == null ? 0 : fromAndTo.hashCode();
            int i2 = this.c;
            List<LatLonPoint> list2 = this.d;
            if (list2 != null) {
                i = list2.hashCode();
            }
            return ((((((((((hashCode + 31) * 31) + hashCode2) * 31) + hashCode3) * 31) + i2) * 31) + i) * 31) + this.h;
        }

        public boolean isUseFerry() {
            return this.g;
        }

        public void setCarType(int i) {
            this.h = i;
        }

        public void setExclude(String str) {
            this.i = str;
        }

        public void setNewEnergy(NewEnergy newEnergy) {
            this.b = newEnergy;
        }

        public void setShowFields(int i) {
            this.j = i;
        }

        public void setUseFerry(boolean z) {
            this.g = z;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/RouteSearchV2$DrivingStrategy.class */
    public enum DrivingStrategy {
        DEFAULT(32),
        AVOID_CONGESTION(33),
        HIGHWAY_PRIORITY(34),
        AVOID_HIGHWAY(35),
        LESS_CHARGE(36),
        ROAD_PRIORITY(37),
        SPEED_PRIORITY(38),
        AVOID_CONGESTION_HIGHWAY_PRIORITY(39),
        AVOID_CONGESTION_AVOID_HIGHWAY(40),
        AVOID_CONGESTION_LESS_CHARGE(41),
        LESS_CHARGE_AVOID_HIGHWAY(42),
        AVOID_CONGESTION_LESS_CHARGE_AVOID_HIGHWAY(43),
        AVOID_CONGESTION_ROAD_PRIORITY(44),
        AVOID_CONGESTION_SPEED_PRIORITY(45);
        
        int a;

        DrivingStrategy(int i) {
            this.a = i;
        }

        public static DrivingStrategy fromValue(int i) {
            return values()[i - 32];
        }

        public final int getValue() {
            return this.a;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/RouteSearchV2$FromAndTo.class */
    public static class FromAndTo implements Parcelable, Cloneable {
        public static final Parcelable.Creator<FromAndTo> CREATOR = new Parcelable.Creator<FromAndTo>() { // from class: com.amap.api.services.route.RouteSearchV2.FromAndTo.1
            private static FromAndTo a(Parcel parcel) {
                return new FromAndTo(parcel);
            }

            private static FromAndTo[] a(int i) {
                return new FromAndTo[i];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FromAndTo createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ FromAndTo[] newArray(int i) {
                return a(i);
            }
        };
        private LatLonPoint a;
        private LatLonPoint b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;

        public FromAndTo() {
        }

        public FromAndTo(Parcel parcel) {
            this.a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
            this.c = parcel.readString();
            this.d = parcel.readString();
            this.e = parcel.readString();
            this.f = parcel.readString();
        }

        public FromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.a = latLonPoint;
            this.b = latLonPoint2;
        }

        /* renamed from: clone */
        public FromAndTo m8965clone() {
            try {
                super.clone();
            } catch (CloneNotSupportedException e) {
                fe.a(e, "RouteSearchV2", "FromAndToclone");
            }
            FromAndTo fromAndTo = new FromAndTo(this.a, this.b);
            fromAndTo.setStartPoiID(this.c);
            fromAndTo.setDestinationPoiID(this.d);
            fromAndTo.setOriginType(this.e);
            fromAndTo.setDestinationType(this.f);
            return fromAndTo;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                FromAndTo fromAndTo = (FromAndTo) obj;
                String str = this.d;
                if (str == null) {
                    if (fromAndTo.d != null) {
                        return false;
                    }
                } else if (!str.equals(fromAndTo.d)) {
                    return false;
                }
                LatLonPoint latLonPoint = this.a;
                if (latLonPoint == null) {
                    if (fromAndTo.a != null) {
                        return false;
                    }
                } else if (!latLonPoint.equals(fromAndTo.a)) {
                    return false;
                }
                String str2 = this.c;
                if (str2 == null) {
                    if (fromAndTo.c != null) {
                        return false;
                    }
                } else if (!str2.equals(fromAndTo.c)) {
                    return false;
                }
                LatLonPoint latLonPoint2 = this.b;
                if (latLonPoint2 == null) {
                    if (fromAndTo.b != null) {
                        return false;
                    }
                } else if (!latLonPoint2.equals(fromAndTo.b)) {
                    return false;
                }
                String str3 = this.e;
                if (str3 == null) {
                    if (fromAndTo.e != null) {
                        return false;
                    }
                } else if (!str3.equals(fromAndTo.e)) {
                    return false;
                }
                String str4 = this.f;
                return str4 == null ? fromAndTo.f == null : str4.equals(fromAndTo.f);
            }
            return false;
        }

        public String getDestinationPoiID() {
            return this.d;
        }

        public String getDestinationType() {
            return this.f;
        }

        public LatLonPoint getFrom() {
            return this.a;
        }

        public String getOriginType() {
            return this.e;
        }

        public String getPlateNumber() {
            return this.g;
        }

        public String getStartPoiID() {
            return this.c;
        }

        public LatLonPoint getTo() {
            return this.b;
        }

        public int hashCode() {
            String str = this.d;
            int i = 0;
            int hashCode = str == null ? 0 : str.hashCode();
            LatLonPoint latLonPoint = this.a;
            int hashCode2 = latLonPoint == null ? 0 : latLonPoint.hashCode();
            String str2 = this.c;
            int hashCode3 = str2 == null ? 0 : str2.hashCode();
            LatLonPoint latLonPoint2 = this.b;
            int hashCode4 = latLonPoint2 == null ? 0 : latLonPoint2.hashCode();
            String str3 = this.e;
            int hashCode5 = str3 == null ? 0 : str3.hashCode();
            String str4 = this.f;
            if (str4 != null) {
                i = str4.hashCode();
            }
            return ((((((((((hashCode + 31) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + i;
        }

        public void setDestinationPoiID(String str) {
            this.d = str;
        }

        public void setDestinationType(String str) {
            this.f = str;
        }

        public void setOriginType(String str) {
            this.e = str;
        }

        public void setPlateNumber(String str) {
            this.g = str;
        }

        public void setStartPoiID(String str) {
            this.c = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.a, i);
            parcel.writeParcelable(this.b, i);
            parcel.writeString(this.c);
            parcel.writeString(this.d);
            parcel.writeString(this.e);
            parcel.writeString(this.f);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/RouteSearchV2$NewEnergy.class */
    public static class NewEnergy {
        private String a;
        private CustomCostMode b;
        private float c = -1.0f;
        private float d = -1.0f;
        private float e = 1.5f;
        private float f = 100.0f;
        private float g = 0.0f;

        public String buildParam() {
            StringBuilder sb = new StringBuilder();
            if (this.a != null) {
                sb.append("&key=");
                sb.append(this.a);
            }
            if (this.b != null) {
                sb.append("&custom_cost_mode=");
                sb.append(this.b.toJson());
            }
            if (this.c > 0.0f) {
                sb.append("&max_vehicle_charge=");
                sb.append(this.c);
            }
            if (this.d > 0.0f) {
                sb.append("&vehicle_charge=");
                sb.append(this.d);
            }
            sb.append("&load=");
            sb.append(this.e);
            sb.append("&leaving_percent=");
            sb.append(this.f);
            sb.append("&arriving_percent=");
            sb.append(this.g);
            return sb.toString();
        }

        public float getArrivingPercent() {
            return this.g;
        }

        public CustomCostMode getCustomCostMode() {
            return this.b;
        }

        public String getKey() {
            return this.a;
        }

        public float getLeavingPercent() {
            return this.f;
        }

        public float getLoad() {
            return this.e;
        }

        public float getMaxVehicleCharge() {
            return this.c;
        }

        public float getVehicleCharge() {
            return this.d;
        }

        public void setArrivingPercent(float f) {
            this.g = f;
        }

        public void setCustomCostMode(CustomCostMode customCostMode) {
            this.b = customCostMode;
        }

        public void setKey(String str) {
            this.a = str;
        }

        public void setLeavingPercent(float f) {
            this.f = f;
        }

        public void setLoad(float f) {
            this.e = f;
        }

        public void setMaxVehicleCharge(float f) {
            this.c = f;
        }

        public void setVehicleCharge(float f) {
            this.d = f;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/RouteSearchV2$OnRoutePlanSearchListener.class */
    public interface OnRoutePlanSearchListener {
        void onDriveRoutePlanSearched(DriveRoutePlanResult driveRoutePlanResult, int i);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/RouteSearchV2$OnRouteSearchListener.class */
    public interface OnRouteSearchListener {
        void onDriveRouteSearched(DriveRouteResultV2 driveRouteResultV2, int i);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/RouteSearchV2$OnTruckRouteSearchListener.class */
    public interface OnTruckRouteSearchListener {
        void onTruckRouteSearched(TruckRouteRestult truckRouteRestult, int i);
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/RouteSearchV2$PowerTrainLoss.class */
    public static class PowerTrainLoss {
        private int a;
        private float b;
        private int c;
        private int d;

        public int getPowerDemand() {
            return this.a;
        }

        public float getPowerDemandValue() {
            return this.b;
        }

        public int getSpeed() {
            return this.c;
        }

        public int getSpeedValue() {
            return this.d;
        }

        public void setPowerDemand(int i) {
            this.a = i;
        }

        public void setPowerDemandValue(float f) {
            this.b = f;
        }

        public void setSpeed(int i) {
            this.c = i;
        }

        public void setSpeedValue(int i) {
            this.d = i;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/RouteSearchV2$ShowFields.class */
    public static class ShowFields {
        public static final int ALL = -1;
        public static final int CHARGE_STATION_INFO = 64;
        public static final int CITIES = 8;
        public static final int COST = 1;
        public static final int ELEC_COSUME_INFO = 32;
        public static final int NAVI = 4;
        public static final int POLINE = 16;
        public static final int TMCS = 2;
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/RouteSearchV2$SlopeCost.class */
    public static class SlopeCost {
        private float a;
        private float b;

        public float getDown() {
            return this.b;
        }

        public float getUp() {
            return this.a;
        }

        public void setDown(float f) {
            this.b = f;
        }

        public void setUp(float f) {
            this.a = f;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/RouteSearchV2$SpeedCost.class */
    public static class SpeedCost {
        private int a;
        private float b;

        public int getSpeed() {
            return this.a;
        }

        public float getValue() {
            return this.b;
        }

        public void setSpeed(int i) {
            this.a = i;
        }

        public void setValue(float f) {
            this.b = f;
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/services/route/RouteSearchV2$TransCost.class */
    public static class TransCost {
        private float a;
        private float b;

        public float getAccess() {
            return this.a;
        }

        public float getDecess() {
            return this.b;
        }

        public void setAccess(float f) {
            this.a = f;
        }

        public void setDecess(float f) {
            this.b = f;
        }
    }

    public RouteSearchV2(Context context) throws AMapException {
        if (this.a == null) {
            try {
                this.a = new hc(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    public DriveRouteResultV2 calculateDriveRoute(DriveRouteQuery driveRouteQuery) throws AMapException {
        IRouteSearchV2 iRouteSearchV2 = this.a;
        if (iRouteSearchV2 != null) {
            return iRouteSearchV2.calculateDriveRoute(driveRouteQuery);
        }
        return null;
    }

    public void calculateDriveRouteAsyn(DriveRouteQuery driveRouteQuery) {
        IRouteSearchV2 iRouteSearchV2 = this.a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.calculateDriveRouteAsyn(driveRouteQuery);
        }
    }

    public void setRouteSearchListener(OnRouteSearchListener onRouteSearchListener) {
        IRouteSearchV2 iRouteSearchV2 = this.a;
        if (iRouteSearchV2 != null) {
            iRouteSearchV2.setRouteSearchListener(onRouteSearchListener);
        }
    }
}
