package android.service.notification;

import android.content.ComponentName;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.nfc.cardemulation.CardEmulation;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.Contacts;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Slog;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.tencent.ugc.UGCTransitionRules;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* loaded from: source-9557208-dex2jar.jar:android/service/notification/ZenModeConfig.class */
public class ZenModeConfig implements Parcelable {
    private static final String ALLOW_ATT_CALLS = "calls";
    private static final String ALLOW_ATT_EVENTS = "events";
    private static final String ALLOW_ATT_FROM = "from";
    private static final String ALLOW_ATT_MESSAGES = "messages";
    private static final String ALLOW_TAG = "allow";
    private static final String CONDITION_ATT_COMPONENT = "component";
    private static final String CONDITION_ATT_FLAGS = "flags";
    private static final String CONDITION_ATT_ICON = "icon";
    private static final String CONDITION_ATT_ID = "id";
    private static final String CONDITION_ATT_LINE1 = "line1";
    private static final String CONDITION_ATT_LINE2 = "line2";
    private static final String CONDITION_ATT_STATE = "state";
    private static final String CONDITION_ATT_SUMMARY = "summary";
    private static final String CONDITION_TAG = "condition";
    public static final String COUNTDOWN_PATH = "countdown";
    private static final boolean DEFAULT_ALLOW_EVENTS = true;
    public static final String DOWNTIME_PATH = "downtime";
    private static final String EXIT_CONDITION_ATT_COMPONENT = "component";
    private static final String EXIT_CONDITION_TAG = "exitCondition";
    public static final int MAX_SOURCE = 2;
    private static final int MINUTES_MS = 60000;
    public static final String NEXT_ALARM_PATH = "next_alarm";
    private static final int SECONDS_MS = 1000;
    private static final String SLEEP_ATT_END_HR = "endHour";
    private static final String SLEEP_ATT_END_MIN = "endMin";
    private static final String SLEEP_ATT_MODE = "mode";
    private static final String SLEEP_ATT_NONE = "none";
    private static final String SLEEP_ATT_START_HR = "startHour";
    private static final String SLEEP_ATT_START_MIN = "startMin";
    public static final String SLEEP_MODE_DAYS_PREFIX = "days:";
    public static final String SLEEP_MODE_NIGHTS = "nights";
    public static final String SLEEP_MODE_WEEKNIGHTS = "weeknights";
    private static final String SLEEP_TAG = "sleep";
    public static final int SOURCE_ANYONE = 0;
    public static final int SOURCE_CONTACT = 1;
    public static final int SOURCE_STAR = 2;
    public static final String SYSTEM_AUTHORITY = "android";
    private static final int XML_VERSION = 1;
    private static final String ZEN_ATT_VERSION = "version";
    private static final String ZEN_TAG = "zen";
    private static final int ZERO_VALUE_MS = 10000;
    public boolean allowCalls;
    public boolean allowEvents;
    public int allowFrom;
    public boolean allowMessages;
    public ComponentName[] conditionComponents;
    public Uri[] conditionIds;
    public Condition exitCondition;
    public ComponentName exitConditionComponent;
    public int sleepEndHour;
    public int sleepEndMinute;
    public String sleepMode;
    public boolean sleepNone;
    public int sleepStartHour;
    public int sleepStartMinute;
    private static String TAG = "ZenModeConfig";
    public static final int[] ALL_DAYS = {1, 2, 3, 4, 5, 6, 7};
    public static final int[] WEEKNIGHT_DAYS = {1, 2, 3, 4, 5};
    public static final int[] MINUTE_BUCKETS = {15, 30, 45, 60, 120, 180, 240, 480, 600, UGCTransitionRules.DEFAULT_IMAGE_WIDTH};
    public static final Parcelable.Creator<ZenModeConfig> CREATOR = new Parcelable.Creator<ZenModeConfig>() { // from class: android.service.notification.ZenModeConfig.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ZenModeConfig createFromParcel(Parcel parcel) {
            return new ZenModeConfig(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ZenModeConfig[] newArray(int i) {
            return new ZenModeConfig[i];
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/service/notification/ZenModeConfig$DowntimeInfo.class */
    public static class DowntimeInfo {
        public int endHour;
        public int endMinute;
        public String mode;
        public boolean none;
        public int startHour;
        public int startMinute;

        public boolean equals(Object obj) {
            if (obj instanceof DowntimeInfo) {
                DowntimeInfo downtimeInfo = (DowntimeInfo) obj;
                return this.startHour == downtimeInfo.startHour && this.startMinute == downtimeInfo.startMinute && this.endHour == downtimeInfo.endHour && this.endMinute == downtimeInfo.endMinute && Objects.equals(this.mode, downtimeInfo.mode) && this.none == downtimeInfo.none;
            }
            return false;
        }

        public int hashCode() {
            return 0;
        }
    }

    public ZenModeConfig() {
        this.allowEvents = true;
        this.allowFrom = 0;
    }

    public ZenModeConfig(Parcel parcel) {
        this.allowEvents = true;
        this.allowFrom = 0;
        this.allowCalls = parcel.readInt() == 1;
        this.allowMessages = parcel.readInt() == 1;
        this.allowEvents = parcel.readInt() == 1;
        if (parcel.readInt() == 1) {
            this.sleepMode = parcel.readString();
        }
        this.sleepStartHour = parcel.readInt();
        this.sleepStartMinute = parcel.readInt();
        this.sleepEndHour = parcel.readInt();
        this.sleepEndMinute = parcel.readInt();
        this.sleepNone = parcel.readInt() == 1;
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.conditionComponents = new ComponentName[readInt];
            parcel.readTypedArray(this.conditionComponents, ComponentName.CREATOR);
        }
        int readInt2 = parcel.readInt();
        if (readInt2 > 0) {
            this.conditionIds = new Uri[readInt2];
            parcel.readTypedArray(this.conditionIds, Uri.CREATOR);
        }
        this.allowFrom = parcel.readInt();
        this.exitCondition = (Condition) parcel.readParcelable(null);
        this.exitConditionComponent = (ComponentName) parcel.readParcelable(null);
    }

    public static boolean isValidCountdownConditionId(Uri uri) {
        return tryParseCountdownConditionId(uri) != 0;
    }

    public static boolean isValidDowntimeConditionId(Uri uri) {
        return tryParseDowntimeConditionId(uri) != null;
    }

    public static boolean isValidHour(int i) {
        return i >= 0 && i < 24;
    }

    public static boolean isValidMinute(int i) {
        return i >= 0 && i < 60;
    }

    public static boolean isValidSleepMode(String str) {
        return str == null || str.equals(SLEEP_MODE_NIGHTS) || str.equals(SLEEP_MODE_WEEKNIGHTS) || tryParseDays(str) != null;
    }

    public static Condition readConditionXml(XmlPullParser xmlPullParser) {
        try {
            return new Condition(safeUri(xmlPullParser, "id"), xmlPullParser.getAttributeValue(null, "summary"), xmlPullParser.getAttributeValue(null, CONDITION_ATT_LINE1), xmlPullParser.getAttributeValue(null, CONDITION_ATT_LINE2), safeInt(xmlPullParser, "icon", -1), safeInt(xmlPullParser, "state", -1), safeInt(xmlPullParser, "flags", -1));
        } catch (IllegalArgumentException e) {
            Slog.w(TAG, "Unable to read condition xml", e);
            return null;
        }
    }

    public static ZenModeConfig readXml(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ZenModeConfig zenModeConfig;
        if (xmlPullParser.getEventType() == 2) {
            if (ZEN_TAG.equals(xmlPullParser.getName())) {
                ZenModeConfig zenModeConfig2 = new ZenModeConfig();
                safeInt(xmlPullParser, "version", 1);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    int next = xmlPullParser.next();
                    if (next == 1) {
                        throw new IllegalStateException("Failed to reach END_DOCUMENT");
                    }
                    String name = xmlPullParser.getName();
                    if (next == 3 && ZEN_TAG.equals(name)) {
                        zenModeConfig = zenModeConfig2;
                        if (!arrayList.isEmpty()) {
                            zenModeConfig2.conditionComponents = (ComponentName[]) arrayList.toArray(new ComponentName[arrayList.size()]);
                            zenModeConfig2.conditionIds = (Uri[]) arrayList2.toArray(new Uri[arrayList2.size()]);
                            return zenModeConfig2;
                        }
                    } else if (next == 2) {
                        if (ALLOW_TAG.equals(name)) {
                            zenModeConfig2.allowCalls = safeBoolean(xmlPullParser, ALLOW_ATT_CALLS, false);
                            zenModeConfig2.allowMessages = safeBoolean(xmlPullParser, ALLOW_ATT_MESSAGES, false);
                            zenModeConfig2.allowEvents = safeBoolean(xmlPullParser, "events", true);
                            zenModeConfig2.allowFrom = safeInt(xmlPullParser, "from", 0);
                            if (zenModeConfig2.allowFrom < 0 || zenModeConfig2.allowFrom > 2) {
                                break;
                            }
                        } else if (SLEEP_TAG.equals(name)) {
                            String attributeValue = xmlPullParser.getAttributeValue(null, "mode");
                            if (!isValidSleepMode(attributeValue)) {
                                attributeValue = null;
                            }
                            zenModeConfig2.sleepMode = attributeValue;
                            zenModeConfig2.sleepNone = safeBoolean(xmlPullParser, "none", false);
                            int safeInt = safeInt(xmlPullParser, SLEEP_ATT_START_HR, 0);
                            int safeInt2 = safeInt(xmlPullParser, SLEEP_ATT_START_MIN, 0);
                            int safeInt3 = safeInt(xmlPullParser, SLEEP_ATT_END_HR, 0);
                            int safeInt4 = safeInt(xmlPullParser, SLEEP_ATT_END_MIN, 0);
                            if (!isValidHour(safeInt)) {
                                safeInt = 0;
                            }
                            zenModeConfig2.sleepStartHour = safeInt;
                            zenModeConfig2.sleepStartMinute = isValidMinute(safeInt2) ? safeInt2 : 0;
                            zenModeConfig2.sleepEndHour = isValidHour(safeInt3) ? safeInt3 : 0;
                            zenModeConfig2.sleepEndMinute = isValidMinute(safeInt4) ? safeInt4 : 0;
                        } else if ("condition".equals(name)) {
                            ComponentName safeComponentName = safeComponentName(xmlPullParser, CardEmulation.EXTRA_SERVICE_COMPONENT);
                            Uri safeUri = safeUri(xmlPullParser, "id");
                            if (safeComponentName != null && safeUri != null) {
                                arrayList.add(safeComponentName);
                                arrayList2.add(safeUri);
                            }
                        } else if (EXIT_CONDITION_TAG.equals(name)) {
                            zenModeConfig2.exitCondition = readConditionXml(xmlPullParser);
                            if (zenModeConfig2.exitCondition != null) {
                                zenModeConfig2.exitConditionComponent = safeComponentName(xmlPullParser, CardEmulation.EXTRA_SERVICE_COMPONENT);
                            }
                        }
                    }
                }
                throw new IndexOutOfBoundsException("bad source in config:" + zenModeConfig2.allowFrom);
            }
            return null;
        }
        zenModeConfig = null;
        return zenModeConfig;
    }

    private static boolean safeBoolean(XmlPullParser xmlPullParser, String str, boolean z) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return TextUtils.isEmpty(attributeValue) ? z : Boolean.valueOf(attributeValue).booleanValue();
    }

    private static ComponentName safeComponentName(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (TextUtils.isEmpty(attributeValue)) {
            return null;
        }
        return ComponentName.unflattenFromString(attributeValue);
    }

    private static int safeInt(XmlPullParser xmlPullParser, String str, int i) {
        return tryParseInt(xmlPullParser.getAttributeValue(null, str), i);
    }

    private static Uri safeUri(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        if (TextUtils.isEmpty(attributeValue)) {
            return null;
        }
        return Uri.parse(attributeValue);
    }

    public static String sourceToString(int i) {
        switch (i) {
            case 0:
                return "anyone";
            case 1:
                return Contacts.AUTHORITY;
            case 2:
                return "stars";
            default:
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
    }

    public static Uri toCountdownConditionId(long j) {
        return new Uri.Builder().scheme("condition").authority("android").appendPath("countdown").appendPath(Long.toString(j)).build();
    }

    public static Uri toDowntimeConditionId(DowntimeInfo downtimeInfo) {
        return new Uri.Builder().scheme("condition").authority("android").appendPath(DOWNTIME_PATH).appendQueryParameter("start", downtimeInfo.startHour + "." + downtimeInfo.startMinute).appendQueryParameter("end", downtimeInfo.endHour + "." + downtimeInfo.endMinute).appendQueryParameter("mode", downtimeInfo.mode).appendQueryParameter("none", Boolean.toString(downtimeInfo.none)).build();
    }

    public static Condition toTimeCondition(Context context, int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        return toTimeCondition(context, currentTimeMillis + (i == 0 ? 10000L : 60000 * i), i, currentTimeMillis, i2);
    }

    public static Condition toTimeCondition(Context context, long j, int i, long j2, int i2) {
        int round;
        int i3;
        int i4;
        if (i < 60) {
            i3 = 18087961;
            round = i;
            i4 = 18087963;
        } else {
            round = Math.round(i / 60.0f);
            i3 = 18087962;
            i4 = 18087964;
        }
        CharSequence format = DateFormat.format(DateFormat.getBestDateTimePattern(Locale.getDefault(), DateFormat.is24HourFormat(context, i2) ? "Hm" : "hma"), j);
        Resources resources = context.getResources();
        return new Condition(toCountdownConditionId(j), resources.getQuantityString(i3, round, Integer.valueOf(round), format), resources.getQuantityString(i4, round, Integer.valueOf(round), format), resources.getString(17041256, format), 0, 1, 1);
    }

    public static long tryParseCountdownConditionId(Uri uri) {
        if (Condition.isValidId(uri, "android") && uri.getPathSegments().size() == 2 && "countdown".equals(uri.getPathSegments().get(0))) {
            try {
                return Long.parseLong(uri.getPathSegments().get(1));
            } catch (RuntimeException e) {
                Slog.w(TAG, "Error parsing countdown condition: " + uri, e);
                return 0L;
            }
        }
        return 0L;
    }

    public static int[] tryParseDays(String str) {
        int[] iArr;
        if (str == null) {
            iArr = null;
        } else {
            String trim = str.trim();
            if (SLEEP_MODE_NIGHTS.equals(trim)) {
                return ALL_DAYS;
            }
            if (SLEEP_MODE_WEEKNIGHTS.equals(trim)) {
                return WEEKNIGHT_DAYS;
            }
            if (!trim.startsWith(SLEEP_MODE_DAYS_PREFIX) || trim.equals(SLEEP_MODE_DAYS_PREFIX)) {
                return null;
            }
            String[] split = trim.substring(SLEEP_MODE_DAYS_PREFIX.length()).split(",");
            if (split.length != 0) {
                int[] iArr2 = new int[split.length];
                int i = 0;
                while (true) {
                    int i2 = i;
                    iArr = iArr2;
                    if (i2 >= split.length) {
                        break;
                    }
                    int tryParseInt = tryParseInt(split[i2], -1);
                    if (tryParseInt == -1) {
                        return null;
                    }
                    iArr2[i2] = tryParseInt;
                    i = i2 + 1;
                }
            } else {
                return null;
            }
        }
        return iArr;
    }

    public static DowntimeInfo tryParseDowntimeConditionId(Uri uri) {
        if (Condition.isValidId(uri, "android") && uri.getPathSegments().size() == 1 && DOWNTIME_PATH.equals(uri.getPathSegments().get(0))) {
            int[] tryParseHourAndMinute = tryParseHourAndMinute(uri.getQueryParameter("start"));
            int[] tryParseHourAndMinute2 = tryParseHourAndMinute(uri.getQueryParameter("end"));
            if (tryParseHourAndMinute == null || tryParseHourAndMinute2 == null) {
                return null;
            }
            DowntimeInfo downtimeInfo = new DowntimeInfo();
            downtimeInfo.startHour = tryParseHourAndMinute[0];
            downtimeInfo.startMinute = tryParseHourAndMinute[1];
            downtimeInfo.endHour = tryParseHourAndMinute2[0];
            downtimeInfo.endMinute = tryParseHourAndMinute2[1];
            downtimeInfo.mode = uri.getQueryParameter("mode");
            downtimeInfo.none = Boolean.toString(true).equals(uri.getQueryParameter("none"));
            return downtimeInfo;
        }
        return null;
    }

    private static int[] tryParseHourAndMinute(String str) {
        int indexOf;
        if (!TextUtils.isEmpty(str) && (indexOf = str.indexOf(46)) >= 1 && indexOf < str.length() - 1) {
            int tryParseInt = tryParseInt(str.substring(0, indexOf), -1);
            int tryParseInt2 = tryParseInt(str.substring(indexOf + 1), -1);
            if (isValidHour(tryParseInt) && isValidMinute(tryParseInt2)) {
                return new int[]{tryParseInt, tryParseInt2};
            }
            return null;
        }
        return null;
    }

    private static int tryParseInt(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.valueOf(str).intValue();
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public static void writeConditionXml(Condition condition, XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.attribute(null, "id", condition.id.toString());
        xmlSerializer.attribute(null, "summary", condition.summary);
        xmlSerializer.attribute(null, CONDITION_ATT_LINE1, condition.line1);
        xmlSerializer.attribute(null, CONDITION_ATT_LINE2, condition.line2);
        xmlSerializer.attribute(null, "icon", Integer.toString(condition.icon));
        xmlSerializer.attribute(null, "state", Integer.toString(condition.state));
        xmlSerializer.attribute(null, "flags", Integer.toString(condition.flags));
    }

    public ZenModeConfig copy() {
        Parcel obtain = Parcel.obtain();
        try {
            writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            return new ZenModeConfig(obtain);
        } finally {
            obtain.recycle();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (obj instanceof ZenModeConfig) {
            z = true;
            if (obj != this) {
                ZenModeConfig zenModeConfig = (ZenModeConfig) obj;
                if (zenModeConfig.allowCalls != this.allowCalls || zenModeConfig.allowMessages != this.allowMessages || zenModeConfig.allowFrom != this.allowFrom || zenModeConfig.allowEvents != this.allowEvents || !Objects.equals(zenModeConfig.sleepMode, this.sleepMode) || zenModeConfig.sleepNone != this.sleepNone || zenModeConfig.sleepStartHour != this.sleepStartHour || zenModeConfig.sleepStartMinute != this.sleepStartMinute || zenModeConfig.sleepEndHour != this.sleepEndHour || zenModeConfig.sleepEndMinute != this.sleepEndMinute || !Objects.deepEquals(zenModeConfig.conditionComponents, this.conditionComponents) || !Objects.deepEquals(zenModeConfig.conditionIds, this.conditionIds) || !Objects.equals(zenModeConfig.exitCondition, this.exitCondition)) {
                    return false;
                }
                z = true;
                if (!Objects.equals(zenModeConfig.exitConditionComponent, this.exitConditionComponent)) {
                    return false;
                }
            }
        } else {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.allowCalls), Boolean.valueOf(this.allowMessages), Integer.valueOf(this.allowFrom), Boolean.valueOf(this.allowEvents), this.sleepMode, Boolean.valueOf(this.sleepNone), Integer.valueOf(this.sleepStartHour), Integer.valueOf(this.sleepStartMinute), Integer.valueOf(this.sleepEndHour), Integer.valueOf(this.sleepEndMinute), Integer.valueOf(Arrays.hashCode(this.conditionComponents)), Integer.valueOf(Arrays.hashCode(this.conditionIds)), this.exitCondition, this.exitConditionComponent);
    }

    public boolean isValid() {
        return isValidHour(this.sleepStartHour) && isValidMinute(this.sleepStartMinute) && isValidHour(this.sleepEndHour) && isValidMinute(this.sleepEndMinute) && isValidSleepMode(this.sleepMode);
    }

    public DowntimeInfo toDowntimeInfo() {
        DowntimeInfo downtimeInfo = new DowntimeInfo();
        downtimeInfo.startHour = this.sleepStartHour;
        downtimeInfo.startMinute = this.sleepStartMinute;
        downtimeInfo.endHour = this.sleepEndHour;
        downtimeInfo.endMinute = this.sleepEndMinute;
        downtimeInfo.mode = this.sleepMode;
        downtimeInfo.none = this.sleepNone;
        return downtimeInfo;
    }

    public String toString() {
        return ZenModeConfig.class.getSimpleName() + "[allowCalls=" + this.allowCalls + ",allowMessages=" + this.allowMessages + ",allowFrom=" + sourceToString(this.allowFrom) + ",allowEvents=" + this.allowEvents + ",sleepMode=" + this.sleepMode + ",sleepStart=" + this.sleepStartHour + '.' + this.sleepStartMinute + ",sleepEnd=" + this.sleepEndHour + '.' + this.sleepEndMinute + ",sleepNone=" + this.sleepNone + ",conditionComponents=" + (this.conditionComponents == null ? null : TextUtils.join(",", this.conditionComponents)) + ",conditionIds=" + (this.conditionIds == null ? null : TextUtils.join(",", this.conditionIds)) + ",exitCondition=" + this.exitCondition + ",exitConditionComponent=" + this.exitConditionComponent + ']';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.allowCalls ? 1 : 0);
        parcel.writeInt(this.allowMessages ? 1 : 0);
        parcel.writeInt(this.allowEvents ? 1 : 0);
        if (this.sleepMode != null) {
            parcel.writeInt(1);
            parcel.writeString(this.sleepMode);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.sleepStartHour);
        parcel.writeInt(this.sleepStartMinute);
        parcel.writeInt(this.sleepEndHour);
        parcel.writeInt(this.sleepEndMinute);
        parcel.writeInt(this.sleepNone ? 1 : 0);
        if (this.conditionComponents == null || this.conditionComponents.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.conditionComponents.length);
            parcel.writeTypedArray(this.conditionComponents, 0);
        }
        if (this.conditionIds == null || this.conditionIds.length <= 0) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(this.conditionIds.length);
            parcel.writeTypedArray(this.conditionIds, 0);
        }
        parcel.writeInt(this.allowFrom);
        parcel.writeParcelable(this.exitCondition, 0);
        parcel.writeParcelable(this.exitConditionComponent, 0);
    }

    public void writeXml(XmlSerializer xmlSerializer) throws IOException {
        xmlSerializer.startTag(null, ZEN_TAG);
        xmlSerializer.attribute(null, "version", Integer.toString(1));
        xmlSerializer.startTag(null, ALLOW_TAG);
        xmlSerializer.attribute(null, ALLOW_ATT_CALLS, Boolean.toString(this.allowCalls));
        xmlSerializer.attribute(null, ALLOW_ATT_MESSAGES, Boolean.toString(this.allowMessages));
        xmlSerializer.attribute(null, "events", Boolean.toString(this.allowEvents));
        xmlSerializer.attribute(null, "from", Integer.toString(this.allowFrom));
        xmlSerializer.endTag(null, ALLOW_TAG);
        xmlSerializer.startTag(null, SLEEP_TAG);
        if (this.sleepMode != null) {
            xmlSerializer.attribute(null, "mode", this.sleepMode);
        }
        xmlSerializer.attribute(null, "none", Boolean.toString(this.sleepNone));
        xmlSerializer.attribute(null, SLEEP_ATT_START_HR, Integer.toString(this.sleepStartHour));
        xmlSerializer.attribute(null, SLEEP_ATT_START_MIN, Integer.toString(this.sleepStartMinute));
        xmlSerializer.attribute(null, SLEEP_ATT_END_HR, Integer.toString(this.sleepEndHour));
        xmlSerializer.attribute(null, SLEEP_ATT_END_MIN, Integer.toString(this.sleepEndMinute));
        xmlSerializer.endTag(null, SLEEP_TAG);
        if (this.conditionComponents != null && this.conditionIds != null && this.conditionComponents.length == this.conditionIds.length) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.conditionComponents.length) {
                    break;
                }
                xmlSerializer.startTag(null, "condition");
                xmlSerializer.attribute(null, CardEmulation.EXTRA_SERVICE_COMPONENT, this.conditionComponents[i2].flattenToString());
                xmlSerializer.attribute(null, "id", this.conditionIds[i2].toString());
                xmlSerializer.endTag(null, "condition");
                i = i2 + 1;
            }
        }
        if (this.exitCondition != null && this.exitConditionComponent != null) {
            xmlSerializer.startTag(null, EXIT_CONDITION_TAG);
            xmlSerializer.attribute(null, CardEmulation.EXTRA_SERVICE_COMPONENT, this.exitConditionComponent.flattenToString());
            writeConditionXml(this.exitCondition, xmlSerializer);
            xmlSerializer.endTag(null, EXIT_CONDITION_TAG);
        }
        xmlSerializer.endTag(null, ZEN_TAG);
    }
}
