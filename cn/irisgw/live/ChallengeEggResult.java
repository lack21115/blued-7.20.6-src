package cn.irisgw.live;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeEggResult.class */
public final class ChallengeEggResult extends GeneratedMessageV3 implements ChallengeEggResultOrBuilder {
    public static final int COUNTDOWN_FIELD_NUMBER = 4;
    public static final int HIDE_FIELD_NUMBER = 8;
    public static final int KILL_ALERT_COUNTDOWN_FIELD_NUMBER = 7;
    public static final int KILL_ALERT_DELAY_FIELD_NUMBER = 5;
    public static final int KILL_DELAY_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int PROP_ICON_FIELD_NUMBER = 10;
    public static final int PROP_NAME_FIELD_NUMBER = 11;
    public static final int PROP_RESULT_DISPLAY_COUNTDOWN_FIELD_NUMBER = 12;
    public static final int RESULT_PROP_FIELD_NUMBER = 1;
    public static final int TYPE_FIELD_NUMBER = 3;
    public static final int UID_FIELD_NUMBER = 9;
    private static final long serialVersionUID = 0;
    private int countdown_;
    private boolean hide_;
    private int killAlertCountdown_;
    private int killAlertDelay_;
    private int killDelay_;
    private byte memoizedIsInitialized;
    private volatile Object name_;
    private volatile Object propIcon_;
    private volatile Object propName_;
    private int propResultDisplayCountdown_;
    private int resultProp_;
    private int type_;
    private int uid_;
    private static final ChallengeEggResult DEFAULT_INSTANCE = new ChallengeEggResult();
    private static final Parser<ChallengeEggResult> PARSER = new AbstractParser<ChallengeEggResult>() { // from class: cn.irisgw.live.ChallengeEggResult.1
        @Override // com.google.protobuf.Parser
        public ChallengeEggResult parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new ChallengeEggResult(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeEggResult$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChallengeEggResultOrBuilder {
        private int countdown_;
        private boolean hide_;
        private int killAlertCountdown_;
        private int killAlertDelay_;
        private int killDelay_;
        private Object name_;
        private Object propIcon_;
        private Object propName_;
        private int propResultDisplayCountdown_;
        private int resultProp_;
        private int type_;
        private int uid_;

        private Builder() {
            this.resultProp_ = 0;
            this.name_ = "";
            this.type_ = 0;
            this.propIcon_ = "";
            this.propName_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.resultProp_ = 0;
            this.name_ = "";
            this.type_ = 0;
            this.propIcon_ = "";
            this.propName_ = "";
            maybeForceBuilderInitialization();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeEggResult_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = ChallengeEggResult.alwaysUseFieldBuilders;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ChallengeEggResult build() {
            ChallengeEggResult buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public ChallengeEggResult buildPartial() {
            ChallengeEggResult challengeEggResult = new ChallengeEggResult(this);
            challengeEggResult.resultProp_ = this.resultProp_;
            challengeEggResult.name_ = this.name_;
            challengeEggResult.type_ = this.type_;
            challengeEggResult.countdown_ = this.countdown_;
            challengeEggResult.killAlertDelay_ = this.killAlertDelay_;
            challengeEggResult.killDelay_ = this.killDelay_;
            challengeEggResult.killAlertCountdown_ = this.killAlertCountdown_;
            challengeEggResult.hide_ = this.hide_;
            challengeEggResult.uid_ = this.uid_;
            challengeEggResult.propIcon_ = this.propIcon_;
            challengeEggResult.propName_ = this.propName_;
            challengeEggResult.propResultDisplayCountdown_ = this.propResultDisplayCountdown_;
            onBuilt();
            return challengeEggResult;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.resultProp_ = 0;
            this.name_ = "";
            this.type_ = 0;
            this.countdown_ = 0;
            this.killAlertDelay_ = 0;
            this.killDelay_ = 0;
            this.killAlertCountdown_ = 0;
            this.hide_ = false;
            this.uid_ = 0;
            this.propIcon_ = "";
            this.propName_ = "";
            this.propResultDisplayCountdown_ = 0;
            return this;
        }

        public Builder clearCountdown() {
            this.countdown_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearHide() {
            this.hide_ = false;
            onChanged();
            return this;
        }

        public Builder clearKillAlertCountdown() {
            this.killAlertCountdown_ = 0;
            onChanged();
            return this;
        }

        public Builder clearKillAlertDelay() {
            this.killAlertDelay_ = 0;
            onChanged();
            return this;
        }

        public Builder clearKillDelay() {
            this.killDelay_ = 0;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = ChallengeEggResult.getDefaultInstance().getName();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearPropIcon() {
            this.propIcon_ = ChallengeEggResult.getDefaultInstance().getPropIcon();
            onChanged();
            return this;
        }

        public Builder clearPropName() {
            this.propName_ = ChallengeEggResult.getDefaultInstance().getPropName();
            onChanged();
            return this;
        }

        public Builder clearPropResultDisplayCountdown() {
            this.propResultDisplayCountdown_ = 0;
            onChanged();
            return this;
        }

        public Builder clearResultProp() {
            this.resultProp_ = 0;
            onChanged();
            return this;
        }

        public Builder clearType() {
            this.type_ = 0;
            onChanged();
            return this;
        }

        public Builder clearUid() {
            this.uid_ = 0;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo1800clone() {
            return (Builder) super.mo1800clone();
        }

        @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
        public int getCountdown() {
            return this.countdown_;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChallengeEggResult getDefaultInstanceForType() {
            return ChallengeEggResult.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeEggResult_descriptor;
        }

        @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
        public boolean getHide() {
            return this.hide_;
        }

        @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
        public int getKillAlertCountdown() {
            return this.killAlertCountdown_;
        }

        @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
        public int getKillAlertDelay() {
            return this.killAlertDelay_;
        }

        @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
        public int getKillDelay() {
            return this.killDelay_;
        }

        @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.name_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
        public String getPropIcon() {
            Object obj = this.propIcon_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.propIcon_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
        public ByteString getPropIconBytes() {
            Object obj = this.propIcon_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.propIcon_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
        public String getPropName() {
            Object obj = this.propName_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.propName_ = stringUtf8;
            return stringUtf8;
        }

        @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
        public ByteString getPropNameBytes() {
            Object obj = this.propName_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.propName_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
        public int getPropResultDisplayCountdown() {
            return this.propResultDisplayCountdown_;
        }

        @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
        public Prop getResultProp() {
            Prop valueOf = Prop.valueOf(this.resultProp_);
            Prop prop = valueOf;
            if (valueOf == null) {
                prop = Prop.UNRECOGNIZED;
            }
            return prop;
        }

        @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
        public int getResultPropValue() {
            return this.resultProp_;
        }

        @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
        public ChallengeEggResultType getType() {
            ChallengeEggResultType valueOf = ChallengeEggResultType.valueOf(this.type_);
            ChallengeEggResultType challengeEggResultType = valueOf;
            if (valueOf == null) {
                challengeEggResultType = ChallengeEggResultType.UNRECOGNIZED;
            }
            return challengeEggResultType;
        }

        @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_ChallengeEggResult_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeEggResult.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(ChallengeEggResult challengeEggResult) {
            if (challengeEggResult == ChallengeEggResult.getDefaultInstance()) {
                return this;
            }
            if (challengeEggResult.resultProp_ != 0) {
                setResultPropValue(challengeEggResult.getResultPropValue());
            }
            if (!challengeEggResult.getName().isEmpty()) {
                this.name_ = challengeEggResult.name_;
                onChanged();
            }
            if (challengeEggResult.type_ != 0) {
                setTypeValue(challengeEggResult.getTypeValue());
            }
            if (challengeEggResult.getCountdown() != 0) {
                setCountdown(challengeEggResult.getCountdown());
            }
            if (challengeEggResult.getKillAlertDelay() != 0) {
                setKillAlertDelay(challengeEggResult.getKillAlertDelay());
            }
            if (challengeEggResult.getKillDelay() != 0) {
                setKillDelay(challengeEggResult.getKillDelay());
            }
            if (challengeEggResult.getKillAlertCountdown() != 0) {
                setKillAlertCountdown(challengeEggResult.getKillAlertCountdown());
            }
            if (challengeEggResult.getHide()) {
                setHide(challengeEggResult.getHide());
            }
            if (challengeEggResult.getUid() != 0) {
                setUid(challengeEggResult.getUid());
            }
            if (!challengeEggResult.getPropIcon().isEmpty()) {
                this.propIcon_ = challengeEggResult.propIcon_;
                onChanged();
            }
            if (!challengeEggResult.getPropName().isEmpty()) {
                this.propName_ = challengeEggResult.propName_;
                onChanged();
            }
            if (challengeEggResult.getPropResultDisplayCountdown() != 0) {
                setPropResultDisplayCountdown(challengeEggResult.getPropResultDisplayCountdown());
            }
            mergeUnknownFields(challengeEggResult.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.ChallengeEggResult.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.ChallengeEggResult.access$1700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.ChallengeEggResult r0 = (cn.irisgw.live.ChallengeEggResult) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.ChallengeEggResult$Builder r0 = r0.mergeFrom(r1)
            L1a:
                r0 = r4
                return r0
            L1c:
                r6 = move-exception
                r0 = r7
                r5 = r0
                goto L31
            L22:
                r6 = move-exception
                r0 = r6
                com.google.protobuf.MessageLite r0 = r0.getUnfinishedMessage()     // Catch: java.lang.Throwable -> L1c
                cn.irisgw.live.ChallengeEggResult r0 = (cn.irisgw.live.ChallengeEggResult) r0     // Catch: java.lang.Throwable -> L1c
                r5 = r0
                r0 = r6
                java.io.IOException r0 = r0.unwrapIOException()     // Catch: java.lang.Throwable -> L30
                throw r0     // Catch: java.lang.Throwable -> L30
            L30:
                r6 = move-exception
            L31:
                r0 = r5
                if (r0 == 0) goto L3b
                r0 = r4
                r1 = r5
                cn.irisgw.live.ChallengeEggResult$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.ChallengeEggResult.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.ChallengeEggResult$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof ChallengeEggResult) {
                return mergeFrom((ChallengeEggResult) message);
            }
            super.mergeFrom(message);
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setCountdown(int i) {
            this.countdown_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setHide(boolean z) {
            this.hide_ = z;
            onChanged();
            return this;
        }

        public Builder setKillAlertCountdown(int i) {
            this.killAlertCountdown_ = i;
            onChanged();
            return this;
        }

        public Builder setKillAlertDelay(int i) {
            this.killAlertDelay_ = i;
            onChanged();
            return this;
        }

        public Builder setKillDelay(int i) {
            this.killDelay_ = i;
            onChanged();
            return this;
        }

        public Builder setName(String str) {
            if (str != null) {
                this.name_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setNameBytes(ByteString byteString) {
            if (byteString != null) {
                ChallengeEggResult.checkByteStringIsUtf8(byteString);
                this.name_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPropIcon(String str) {
            if (str != null) {
                this.propIcon_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPropIconBytes(ByteString byteString) {
            if (byteString != null) {
                ChallengeEggResult.checkByteStringIsUtf8(byteString);
                this.propIcon_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPropName(String str) {
            if (str != null) {
                this.propName_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPropNameBytes(ByteString byteString) {
            if (byteString != null) {
                ChallengeEggResult.checkByteStringIsUtf8(byteString);
                this.propName_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPropResultDisplayCountdown(int i) {
            this.propResultDisplayCountdown_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setResultProp(Prop prop) {
            if (prop != null) {
                this.resultProp_ = prop.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setResultPropValue(int i) {
            this.resultProp_ = i;
            onChanged();
            return this;
        }

        public Builder setType(ChallengeEggResultType challengeEggResultType) {
            if (challengeEggResultType != null) {
                this.type_ = challengeEggResultType.getNumber();
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setTypeValue(int i) {
            this.type_ = i;
            onChanged();
            return this;
        }

        public Builder setUid(int i) {
            this.uid_ = i;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/ChallengeEggResult$ChallengeEggResultType.class */
    public enum ChallengeEggResultType implements ProtocolMessageEnum {
        None(0),
        Self(1),
        Target(2),
        UNRECOGNIZED(-1);
        
        public static final int None_VALUE = 0;
        public static final int Self_VALUE = 1;
        public static final int Target_VALUE = 2;
        private final int value;
        private static final Internal.EnumLiteMap<ChallengeEggResultType> internalValueMap = new Internal.EnumLiteMap<ChallengeEggResultType>() { // from class: cn.irisgw.live.ChallengeEggResult.ChallengeEggResultType.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public ChallengeEggResultType findValueByNumber(int i) {
                return ChallengeEggResultType.forNumber(i);
            }
        };
        private static final ChallengeEggResultType[] VALUES = values();

        ChallengeEggResultType(int i) {
            this.value = i;
        }

        public static ChallengeEggResultType forNumber(int i) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return null;
                    }
                    return Target;
                }
                return Self;
            }
            return None;
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return ChallengeEggResult.getDescriptor().getEnumTypes().get(0);
        }

        public static Internal.EnumLiteMap<ChallengeEggResultType> internalGetValueMap() {
            return internalValueMap;
        }

        @Deprecated
        public static ChallengeEggResultType valueOf(int i) {
            return forNumber(i);
        }

        public static ChallengeEggResultType valueOf(Descriptors.EnumValueDescriptor enumValueDescriptor) {
            if (enumValueDescriptor.getType() == getDescriptor()) {
                return enumValueDescriptor.getIndex() == -1 ? UNRECOGNIZED : VALUES[enumValueDescriptor.getIndex()];
            }
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }
    }

    private ChallengeEggResult() {
        this.memoizedIsInitialized = (byte) -1;
        this.resultProp_ = 0;
        this.name_ = "";
        this.type_ = 0;
        this.propIcon_ = "";
        this.propName_ = "";
    }

    private ChallengeEggResult(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        if (extensionRegistryLite == null) {
            throw null;
        }
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.resultProp_ = codedInputStream.readEnum();
                            continue;
                        case 18:
                            this.name_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 24:
                            this.type_ = codedInputStream.readEnum();
                            continue;
                        case 32:
                            this.countdown_ = codedInputStream.readUInt32();
                            continue;
                        case 40:
                            this.killAlertDelay_ = codedInputStream.readUInt32();
                            continue;
                        case 48:
                            this.killDelay_ = codedInputStream.readUInt32();
                            continue;
                        case 56:
                            this.killAlertCountdown_ = codedInputStream.readUInt32();
                            continue;
                        case 64:
                            this.hide_ = codedInputStream.readBool();
                            continue;
                        case 72:
                            this.uid_ = codedInputStream.readUInt32();
                            continue;
                        case 82:
                            this.propIcon_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 90:
                            this.propName_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 96:
                            this.propResultDisplayCountdown_ = codedInputStream.readUInt32();
                            continue;
                        default:
                            if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                                break;
                            } else {
                                continue;
                            }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } finally {
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
            }
        }
    }

    private ChallengeEggResult(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static ChallengeEggResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_ChallengeEggResult_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(ChallengeEggResult challengeEggResult) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(challengeEggResult);
    }

    public static ChallengeEggResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ChallengeEggResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static ChallengeEggResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeEggResult) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChallengeEggResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static ChallengeEggResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static ChallengeEggResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ChallengeEggResult) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static ChallengeEggResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeEggResult) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static ChallengeEggResult parseFrom(InputStream inputStream) throws IOException {
        return (ChallengeEggResult) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static ChallengeEggResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ChallengeEggResult) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static ChallengeEggResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static ChallengeEggResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static ChallengeEggResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static ChallengeEggResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<ChallengeEggResult> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ChallengeEggResult) {
            ChallengeEggResult challengeEggResult = (ChallengeEggResult) obj;
            return this.resultProp_ == challengeEggResult.resultProp_ && getName().equals(challengeEggResult.getName()) && this.type_ == challengeEggResult.type_ && getCountdown() == challengeEggResult.getCountdown() && getKillAlertDelay() == challengeEggResult.getKillAlertDelay() && getKillDelay() == challengeEggResult.getKillDelay() && getKillAlertCountdown() == challengeEggResult.getKillAlertCountdown() && getHide() == challengeEggResult.getHide() && getUid() == challengeEggResult.getUid() && getPropIcon().equals(challengeEggResult.getPropIcon()) && getPropName().equals(challengeEggResult.getPropName()) && getPropResultDisplayCountdown() == challengeEggResult.getPropResultDisplayCountdown() && this.unknownFields.equals(challengeEggResult.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
    public int getCountdown() {
        return this.countdown_;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public ChallengeEggResult getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
    public boolean getHide() {
        return this.hide_;
    }

    @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
    public int getKillAlertCountdown() {
        return this.killAlertCountdown_;
    }

    @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
    public int getKillAlertDelay() {
        return this.killAlertDelay_;
    }

    @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
    public int getKillDelay() {
        return this.killDelay_;
    }

    @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<ChallengeEggResult> getParserForType() {
        return PARSER;
    }

    @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
    public String getPropIcon() {
        Object obj = this.propIcon_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.propIcon_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
    public ByteString getPropIconBytes() {
        Object obj = this.propIcon_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.propIcon_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
    public String getPropName() {
        Object obj = this.propName_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.propName_ = stringUtf8;
        return stringUtf8;
    }

    @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
    public ByteString getPropNameBytes() {
        Object obj = this.propName_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.propName_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
    public int getPropResultDisplayCountdown() {
        return this.propResultDisplayCountdown_;
    }

    @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
    public Prop getResultProp() {
        Prop valueOf = Prop.valueOf(this.resultProp_);
        Prop prop = valueOf;
        if (valueOf == null) {
            prop = Prop.UNRECOGNIZED;
        }
        return prop;
    }

    @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
    public int getResultPropValue() {
        return this.resultProp_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        if (this.resultProp_ != Prop.NONE_PROP.getNumber()) {
            i2 = 0 + CodedOutputStream.computeEnumSize(1, this.resultProp_);
        }
        int i3 = i2;
        if (!getNameBytes().isEmpty()) {
            i3 = i2 + GeneratedMessageV3.computeStringSize(2, this.name_);
        }
        int i4 = i3;
        if (this.type_ != ChallengeEggResultType.None.getNumber()) {
            i4 = i3 + CodedOutputStream.computeEnumSize(3, this.type_);
        }
        int i5 = this.countdown_;
        int i6 = i4;
        if (i5 != 0) {
            i6 = i4 + CodedOutputStream.computeUInt32Size(4, i5);
        }
        int i7 = this.killAlertDelay_;
        int i8 = i6;
        if (i7 != 0) {
            i8 = i6 + CodedOutputStream.computeUInt32Size(5, i7);
        }
        int i9 = this.killDelay_;
        int i10 = i8;
        if (i9 != 0) {
            i10 = i8 + CodedOutputStream.computeUInt32Size(6, i9);
        }
        int i11 = this.killAlertCountdown_;
        int i12 = i10;
        if (i11 != 0) {
            i12 = i10 + CodedOutputStream.computeUInt32Size(7, i11);
        }
        boolean z = this.hide_;
        int i13 = i12;
        if (z) {
            i13 = i12 + CodedOutputStream.computeBoolSize(8, z);
        }
        int i14 = this.uid_;
        int i15 = i13;
        if (i14 != 0) {
            i15 = i13 + CodedOutputStream.computeUInt32Size(9, i14);
        }
        int i16 = i15;
        if (!getPropIconBytes().isEmpty()) {
            i16 = i15 + GeneratedMessageV3.computeStringSize(10, this.propIcon_);
        }
        int i17 = i16;
        if (!getPropNameBytes().isEmpty()) {
            i17 = i16 + GeneratedMessageV3.computeStringSize(11, this.propName_);
        }
        int i18 = this.propResultDisplayCountdown_;
        int i19 = i17;
        if (i18 != 0) {
            i19 = i17 + CodedOutputStream.computeUInt32Size(12, i18);
        }
        int serializedSize = i19 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
    public ChallengeEggResultType getType() {
        ChallengeEggResultType valueOf = ChallengeEggResultType.valueOf(this.type_);
        ChallengeEggResultType challengeEggResultType = valueOf;
        if (valueOf == null) {
            challengeEggResultType = ChallengeEggResultType.UNRECOGNIZED;
        }
        return challengeEggResultType;
    }

    @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
    public int getTypeValue() {
        return this.type_;
    }

    @Override // cn.irisgw.live.ChallengeEggResultOrBuilder
    public int getUid() {
        return this.uid_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + this.resultProp_) * 37) + 2) * 53) + getName().hashCode()) * 37) + 3) * 53) + this.type_) * 37) + 4) * 53) + getCountdown()) * 37) + 5) * 53) + getKillAlertDelay()) * 37) + 6) * 53) + getKillDelay()) * 37) + 7) * 53) + getKillAlertCountdown()) * 37) + 8) * 53) + Internal.hashBoolean(getHide())) * 37) + 9) * 53) + getUid()) * 37) + 10) * 53) + getPropIcon().hashCode()) * 37) + 11) * 53) + getPropName().hashCode()) * 37) + 12) * 53) + getPropResultDisplayCountdown()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_ChallengeEggResult_fieldAccessorTable.ensureFieldAccessorsInitialized(ChallengeEggResult.class, Builder.class);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.memoizedIsInitialized;
        if (b == 1) {
            return true;
        }
        if (b == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.GeneratedMessageV3
    public Builder newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new ChallengeEggResult();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        if (this.resultProp_ != Prop.NONE_PROP.getNumber()) {
            codedOutputStream.writeEnum(1, this.resultProp_);
        }
        if (!getNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.name_);
        }
        if (this.type_ != ChallengeEggResultType.None.getNumber()) {
            codedOutputStream.writeEnum(3, this.type_);
        }
        int i = this.countdown_;
        if (i != 0) {
            codedOutputStream.writeUInt32(4, i);
        }
        int i2 = this.killAlertDelay_;
        if (i2 != 0) {
            codedOutputStream.writeUInt32(5, i2);
        }
        int i3 = this.killDelay_;
        if (i3 != 0) {
            codedOutputStream.writeUInt32(6, i3);
        }
        int i4 = this.killAlertCountdown_;
        if (i4 != 0) {
            codedOutputStream.writeUInt32(7, i4);
        }
        boolean z = this.hide_;
        if (z) {
            codedOutputStream.writeBool(8, z);
        }
        int i5 = this.uid_;
        if (i5 != 0) {
            codedOutputStream.writeUInt32(9, i5);
        }
        if (!getPropIconBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 10, this.propIcon_);
        }
        if (!getPropNameBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 11, this.propName_);
        }
        int i6 = this.propResultDisplayCountdown_;
        if (i6 != 0) {
            codedOutputStream.writeUInt32(12, i6);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
