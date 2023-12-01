package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.api.TPCommonEnum;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPOptionalParam.class */
public class TPOptionalParam {
    public static final int TP_OPTIONAL_PARAM_TYPE_BOOLEAN = 1;
    public static final int TP_OPTIONAL_PARAM_TYPE_FLOAT = 6;
    public static final int TP_OPTIONAL_PARAM_TYPE_LONG = 2;
    public static final int TP_OPTIONAL_PARAM_TYPE_OBJECT = 7;
    public static final int TP_OPTIONAL_PARAM_TYPE_QUEUE_INT = 4;
    public static final int TP_OPTIONAL_PARAM_TYPE_QUEUE_STRING = 5;
    public static final int TP_OPTIONAL_PARAM_TYPE_STRING = 3;
    public static final int TP_OPTIONAL_PARAM_TYPE_UNKNOWN = -1;
    @TPCommonEnum.TPOptionalId
    private int key;
    private OptionalParamBoolean paramBoolean;
    private OptionalParamFloat paramFloat;
    private OptionalParamLong paramLong;
    private OptionalParamObject paramObject;
    private OptionalParamQueueInt paramQueueInt;
    private OptionalParamQueueString paramQueueString;
    private OptionalParamString paramString;
    private int paramType = -1;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPOptionalParam$OptionalParamBoolean.class */
    public static class OptionalParamBoolean {
        public boolean value;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPOptionalParam$OptionalParamFloat.class */
    public static class OptionalParamFloat {
        public float param1;
        public float param2;
        public float value;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPOptionalParam$OptionalParamLong.class */
    public static class OptionalParamLong {
        public long param1;
        public long param2;
        public long value;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPOptionalParam$OptionalParamObject.class */
    public static class OptionalParamObject {
        public Object objectValue;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPOptionalParam$OptionalParamQueueInt.class */
    public static class OptionalParamQueueInt {
        public int[] queueValue;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPOptionalParam$OptionalParamQueueString.class */
    public static class OptionalParamQueueString {
        public String[] queueValue;
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPOptionalParam$OptionalParamString.class */
    public static class OptionalParamString {
        public String param1;
        public String param2;
        public String value;
    }

    public TPOptionalParam buildBoolean(@TPCommonEnum.TPOptionalId int i, boolean z) {
        this.paramType = 1;
        this.key = i;
        OptionalParamBoolean optionalParamBoolean = new OptionalParamBoolean();
        this.paramBoolean = optionalParamBoolean;
        optionalParamBoolean.value = z;
        return this;
    }

    public TPOptionalParam buildFloat(@TPCommonEnum.TPOptionalId int i, float f) {
        this.paramType = 6;
        this.key = i;
        OptionalParamFloat optionalParamFloat = new OptionalParamFloat();
        this.paramFloat = optionalParamFloat;
        optionalParamFloat.value = f;
        return this;
    }

    public TPOptionalParam buildFloat(@TPCommonEnum.TPOptionalId int i, float f, float f2, float f3) {
        this.paramType = 6;
        this.key = i;
        OptionalParamFloat optionalParamFloat = new OptionalParamFloat();
        this.paramFloat = optionalParamFloat;
        optionalParamFloat.value = f;
        this.paramFloat.param1 = f2;
        this.paramFloat.param2 = f3;
        return this;
    }

    public TPOptionalParam buildLong(@TPCommonEnum.TPOptionalId int i, long j) {
        this.paramType = 2;
        this.key = i;
        OptionalParamLong optionalParamLong = new OptionalParamLong();
        this.paramLong = optionalParamLong;
        optionalParamLong.value = j;
        return this;
    }

    public TPOptionalParam buildLong(@TPCommonEnum.TPOptionalId int i, long j, long j2, long j3) {
        this.paramType = 2;
        this.key = i;
        OptionalParamLong optionalParamLong = new OptionalParamLong();
        this.paramLong = optionalParamLong;
        optionalParamLong.value = j;
        this.paramLong.param1 = j2;
        this.paramLong.param2 = j3;
        return this;
    }

    public TPOptionalParam buildObject(int i, Object obj) {
        this.paramType = 7;
        this.key = i;
        OptionalParamObject optionalParamObject = new OptionalParamObject();
        this.paramObject = optionalParamObject;
        optionalParamObject.objectValue = obj;
        return this;
    }

    public TPOptionalParam buildQueueInt(@TPCommonEnum.TPOptionalId int i, int[] iArr) {
        this.paramType = 4;
        this.key = i;
        OptionalParamQueueInt optionalParamQueueInt = new OptionalParamQueueInt();
        this.paramQueueInt = optionalParamQueueInt;
        optionalParamQueueInt.queueValue = iArr;
        return this;
    }

    public TPOptionalParam buildQueueString(@TPCommonEnum.TPOptionalId int i, String[] strArr) {
        this.paramType = 5;
        this.key = i;
        OptionalParamQueueString optionalParamQueueString = new OptionalParamQueueString();
        this.paramQueueString = optionalParamQueueString;
        optionalParamQueueString.queueValue = strArr;
        return this;
    }

    public TPOptionalParam buildString(@TPCommonEnum.TPOptionalId int i, String str) {
        this.paramType = 3;
        this.key = i;
        OptionalParamString optionalParamString = new OptionalParamString();
        this.paramString = optionalParamString;
        optionalParamString.value = str;
        return this;
    }

    public TPOptionalParam buildString(@TPCommonEnum.TPOptionalId int i, String str, String str2, String str3) {
        this.paramType = 3;
        this.key = i;
        OptionalParamString optionalParamString = new OptionalParamString();
        this.paramString = optionalParamString;
        optionalParamString.value = str;
        this.paramString.param1 = str2;
        this.paramString.param2 = str3;
        return this;
    }

    @TPCommonEnum.TPOptionalId
    public int getKey() {
        return this.key;
    }

    public OptionalParamBoolean getParamBoolean() {
        return this.paramBoolean;
    }

    public OptionalParamFloat getParamFloat() {
        return this.paramFloat;
    }

    public OptionalParamLong getParamLong() {
        return this.paramLong;
    }

    public OptionalParamObject getParamObject() {
        return this.paramObject;
    }

    public OptionalParamQueueInt getParamQueueInt() {
        return this.paramQueueInt;
    }

    public OptionalParamQueueString getParamQueueString() {
        return this.paramQueueString;
    }

    public OptionalParamString getParamString() {
        return this.paramString;
    }

    public int getParamType() {
        return this.paramType;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        switch (this.paramType) {
            case 1:
                sb.append("type:long, key:");
                sb.append(this.key);
                sb.append(", \nname:");
                sb.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
                sb.append(", value:");
                sb.append(this.paramBoolean.value);
                break;
            case 2:
                sb.append("type:long, key:");
                sb.append(this.key);
                sb.append(", \nname:");
                sb.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
                sb.append(", value:");
                sb.append(this.paramLong.value);
                sb.append(", param1:");
                sb.append(this.paramLong.param1);
                sb.append(", param2:");
                sb.append(this.paramLong.param2);
                break;
            case 3:
                sb.append("type:string, key:");
                sb.append(this.key);
                sb.append(", \nname:");
                sb.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
                sb.append(", value:");
                sb.append(this.paramString.value);
                sb.append(", param1:");
                sb.append(this.paramString.param1);
                sb.append(", param2:");
                str = this.paramString.param2;
                sb.append(str);
                break;
            case 4:
                sb.append("type:quint_int, key:");
                sb.append(this.key);
                sb.append(", \nname:");
                sb.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
                sb.append(", value:");
                if (this.paramQueueInt.queueValue != null) {
                    int[] iArr = this.paramQueueInt.queueValue;
                    int length = iArr.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= length) {
                            break;
                        } else {
                            sb.append(iArr[i2]);
                            sb.append(", ");
                            i = i2 + 1;
                        }
                    }
                }
                break;
            case 5:
                sb.append("type:quint_string, key:");
                sb.append(this.key);
                sb.append(", \nname:");
                sb.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
                sb.append(", value:");
                if (this.paramQueueString.queueValue != null) {
                    for (String str2 : this.paramQueueString.queueValue) {
                        sb.append(str2);
                        sb.append(", ");
                    }
                    break;
                }
                break;
            case 6:
                sb.append("type:float, key:");
                sb.append(this.key);
                sb.append(", \nname:");
                sb.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
                sb.append(", value:");
                sb.append(this.paramFloat.value);
                sb.append(", param1:");
                sb.append(this.paramFloat.param1);
                sb.append(", param2:");
                sb.append(this.paramFloat.param2);
                break;
            case 7:
                sb.append("type:object, key:");
                sb.append(this.key);
                sb.append(", \nname:");
                sb.append(TPNativeKeyMapUtil.getOptionalIdName(this.key));
                sb.append(", value:");
                sb.append(this.paramObject.objectValue);
                break;
            default:
                str = "type:unknown";
                sb.append(str);
                break;
        }
        return sb.toString();
    }
}
