package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYTopicDataModel.class */
public final class YYTopicDataModel {
    private boolean isClick;
    private float left;
    private float lenght;
    private float right;
    private final TopicTypeListMode topic;

    public YYTopicDataModel(TopicTypeListMode topic, boolean z, float f, float f2, float f3) {
        Intrinsics.e(topic, "topic");
        this.topic = topic;
        this.isClick = z;
        this.lenght = f;
        this.left = f2;
        this.right = f3;
    }

    public /* synthetic */ YYTopicDataModel(TopicTypeListMode topicTypeListMode, boolean z, float f, float f2, float f3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(topicTypeListMode, (i & 2) != 0 ? false : z, f, f2, f3);
    }

    public static /* synthetic */ YYTopicDataModel copy$default(YYTopicDataModel yYTopicDataModel, TopicTypeListMode topicTypeListMode, boolean z, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            topicTypeListMode = yYTopicDataModel.topic;
        }
        if ((i & 2) != 0) {
            z = yYTopicDataModel.isClick;
        }
        if ((i & 4) != 0) {
            f = yYTopicDataModel.lenght;
        }
        if ((i & 8) != 0) {
            f2 = yYTopicDataModel.left;
        }
        if ((i & 16) != 0) {
            f3 = yYTopicDataModel.right;
        }
        return yYTopicDataModel.copy(topicTypeListMode, z, f, f2, f3);
    }

    public final TopicTypeListMode component1() {
        return this.topic;
    }

    public final boolean component2() {
        return this.isClick;
    }

    public final float component3() {
        return this.lenght;
    }

    public final float component4() {
        return this.left;
    }

    public final float component5() {
        return this.right;
    }

    public final YYTopicDataModel copy(TopicTypeListMode topic, boolean z, float f, float f2, float f3) {
        Intrinsics.e(topic, "topic");
        return new YYTopicDataModel(topic, z, f, f2, f3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYTopicDataModel) {
            YYTopicDataModel yYTopicDataModel = (YYTopicDataModel) obj;
            return Intrinsics.a(this.topic, yYTopicDataModel.topic) && this.isClick == yYTopicDataModel.isClick && Intrinsics.a(Float.valueOf(this.lenght), Float.valueOf(yYTopicDataModel.lenght)) && Intrinsics.a(Float.valueOf(this.left), Float.valueOf(yYTopicDataModel.left)) && Intrinsics.a(Float.valueOf(this.right), Float.valueOf(yYTopicDataModel.right));
        }
        return false;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getLenght() {
        return this.lenght;
    }

    public final float getRight() {
        return this.right;
    }

    public final TopicTypeListMode getTopic() {
        return this.topic;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    public int hashCode() {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public final boolean isClick() {
        return this.isClick;
    }

    public final void setClick(boolean z) {
        this.isClick = z;
    }

    public final void setLeft(float f) {
        this.left = f;
    }

    public final void setLenght(float f) {
        this.lenght = f;
    }

    public final void setRight(float f) {
        this.right = f;
    }

    public String toString() {
        return "YYTopicDataModel(topic=" + this.topic + ", isClick=" + this.isClick + ", lenght=" + this.lenght + ", left=" + this.left + ", right=" + this.right + ')';
    }
}
