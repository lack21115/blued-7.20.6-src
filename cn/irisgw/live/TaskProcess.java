package cn.irisgw.live;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.ProtocolStringList;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/TaskProcess.class */
public final class TaskProcess extends GeneratedMessageV3 implements TaskProcessOrBuilder {
    private static final TaskProcess DEFAULT_INSTANCE = new TaskProcess();
    private static final Parser<TaskProcess> PARSER = new AbstractParser<TaskProcess>() { // from class: cn.irisgw.live.TaskProcess.1
        /* renamed from: parsePartialFrom */
        public TaskProcess m7595parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new TaskProcess(codedInputStream, extensionRegistryLite);
        }
    };
    public static final int TASK_LIST_FIELD_NUMBER = 1;
    private static final long serialVersionUID = 0;
    private byte memoizedIsInitialized;
    private LazyStringList taskList_;

    /* loaded from: source-6737240-dex2jar.jar:cn/irisgw/live/TaskProcess$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TaskProcessOrBuilder {
        private int bitField0_;
        private LazyStringList taskList_;

        private Builder() {
            this.taskList_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.taskList_ = LazyStringArrayList.EMPTY;
            maybeForceBuilderInitialization();
        }

        private void ensureTaskListIsMutable() {
            if ((this.bitField0_ & 1) == 0) {
                this.taskList_ = new LazyStringArrayList(this.taskList_);
                this.bitField0_ |= 1;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LiveConstants.internal_static_cn_irisgw_live_TaskProcess_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = TaskProcess.alwaysUseFieldBuilders;
        }

        public Builder addAllTaskList(Iterable<String> iterable) {
            ensureTaskListIsMutable();
            AbstractMessageLite.Builder.addAll(iterable, this.taskList_);
            onChanged();
            return this;
        }

        /* renamed from: addRepeatedField */
        public Builder m7597addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        public Builder addTaskList(String str) {
            if (str != null) {
                ensureTaskListIsMutable();
                this.taskList_.add(str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addTaskListBytes(ByteString byteString) {
            if (byteString != null) {
                TaskProcess.checkByteStringIsUtf8(byteString);
                ensureTaskListIsMutable();
                this.taskList_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: build */
        public TaskProcess m7599build() {
            TaskProcess m7601buildPartial = m7601buildPartial();
            if (m7601buildPartial.isInitialized()) {
                return m7601buildPartial;
            }
            throw newUninitializedMessageException(m7601buildPartial);
        }

        /* renamed from: buildPartial */
        public TaskProcess m7601buildPartial() {
            TaskProcess taskProcess = new TaskProcess(this);
            if ((this.bitField0_ & 1) != 0) {
                this.taskList_ = this.taskList_.getUnmodifiableView();
                this.bitField0_ &= -2;
            }
            taskProcess.taskList_ = this.taskList_;
            onBuilt();
            return taskProcess;
        }

        /* renamed from: clear */
        public Builder m7605clear() {
            super.clear();
            this.taskList_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            return this;
        }

        /* renamed from: clearField */
        public Builder m7607clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        /* renamed from: clearOneof */
        public Builder m7610clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearTaskList() {
            this.taskList_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -2;
            onChanged();
            return this;
        }

        /* renamed from: clone */
        public Builder m7616clone() {
            return (Builder) super.clone();
        }

        /* renamed from: getDefaultInstanceForType */
        public TaskProcess m7618getDefaultInstanceForType() {
            return TaskProcess.getDefaultInstance();
        }

        public Descriptors.Descriptor getDescriptorForType() {
            return LiveConstants.internal_static_cn_irisgw_live_TaskProcess_descriptor;
        }

        @Override // cn.irisgw.live.TaskProcessOrBuilder
        public String getTaskList(int i) {
            return (String) this.taskList_.get(i);
        }

        @Override // cn.irisgw.live.TaskProcessOrBuilder
        public ByteString getTaskListBytes(int i) {
            return this.taskList_.getByteString(i);
        }

        @Override // cn.irisgw.live.TaskProcessOrBuilder
        public int getTaskListCount() {
            return this.taskList_.size();
        }

        @Override // cn.irisgw.live.TaskProcessOrBuilder
        /* renamed from: getTaskListList */
        public ProtocolStringList mo7589getTaskListList() {
            return this.taskList_.getUnmodifiableView();
        }

        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LiveConstants.internal_static_cn_irisgw_live_TaskProcess_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskProcess.class, Builder.class);
        }

        public final boolean isInitialized() {
            return true;
        }

        public Builder mergeFrom(TaskProcess taskProcess) {
            if (taskProcess == TaskProcess.getDefaultInstance()) {
                return this;
            }
            if (!taskProcess.taskList_.isEmpty()) {
                if (this.taskList_.isEmpty()) {
                    this.taskList_ = taskProcess.taskList_;
                    this.bitField0_ &= -2;
                } else {
                    ensureTaskListIsMutable();
                    this.taskList_.addAll(taskProcess.taskList_);
                }
                onChanged();
            }
            m7627mergeUnknownFields(taskProcess.unknownFields);
            onChanged();
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        /* renamed from: mergeFrom */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public cn.irisgw.live.TaskProcess.Builder m7624mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = cn.irisgw.live.TaskProcess.access$600()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                cn.irisgw.live.TaskProcess r0 = (cn.irisgw.live.TaskProcess) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                cn.irisgw.live.TaskProcess$Builder r0 = r0.mergeFrom(r1)
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
                cn.irisgw.live.TaskProcess r0 = (cn.irisgw.live.TaskProcess) r0     // Catch: java.lang.Throwable -> L1c
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
                cn.irisgw.live.TaskProcess$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: cn.irisgw.live.TaskProcess.Builder.m7624mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):cn.irisgw.live.TaskProcess$Builder");
        }

        /* renamed from: mergeFrom */
        public Builder m7623mergeFrom(Message message) {
            if (message instanceof TaskProcess) {
                return mergeFrom((TaskProcess) message);
            }
            super.mergeFrom(message);
            return this;
        }

        /* renamed from: mergeUnknownFields */
        public final Builder m7627mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        /* renamed from: setField */
        public Builder m7629setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        /* renamed from: setRepeatedField */
        public Builder m7631setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setTaskList(int i, String str) {
            if (str != null) {
                ensureTaskListIsMutable();
                this.taskList_.set(i, str);
                onChanged();
                return this;
            }
            throw null;
        }

        /* renamed from: setUnknownFields */
        public final Builder m7633setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private TaskProcess() {
        this.memoizedIsInitialized = (byte) -1;
        this.taskList_ = LazyStringArrayList.EMPTY;
    }

    private TaskProcess(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this();
        if (extensionRegistryLite == null) {
            throw null;
        }
        UnknownFieldSet.Builder newBuilder = UnknownFieldSet.newBuilder();
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            boolean z3 = z2;
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 10) {
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.taskList_ = new LazyStringArrayList();
                                z4 = z2 | true;
                            }
                            this.taskList_.add(readStringRequireUtf8);
                            z2 = z4;
                        } else if (!parseUnknownField(codedInputStream, newBuilder, extensionRegistryLite, readTag)) {
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z3 & true) {
                    this.taskList_ = this.taskList_.getUnmodifiableView();
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.taskList_ = this.taskList_.getUnmodifiableView();
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private TaskProcess(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static TaskProcess getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return LiveConstants.internal_static_cn_irisgw_live_TaskProcess_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.m7594toBuilder();
    }

    public static Builder newBuilder(TaskProcess taskProcess) {
        return DEFAULT_INSTANCE.m7594toBuilder().mergeFrom(taskProcess);
    }

    public static TaskProcess parseDelimitedFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static TaskProcess parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TaskProcess parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (TaskProcess) PARSER.parseFrom(byteString);
    }

    public static TaskProcess parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TaskProcess) PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static TaskProcess parseFrom(CodedInputStream codedInputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static TaskProcess parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static TaskProcess parseFrom(InputStream inputStream) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static TaskProcess parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static TaskProcess parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (TaskProcess) PARSER.parseFrom(byteBuffer);
    }

    public static TaskProcess parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TaskProcess) PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static TaskProcess parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (TaskProcess) PARSER.parseFrom(bArr);
    }

    public static TaskProcess parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (TaskProcess) PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<TaskProcess> parser() {
        return PARSER;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TaskProcess) {
            TaskProcess taskProcess = (TaskProcess) obj;
            return mo7589getTaskListList().equals(taskProcess.mo7589getTaskListList()) && this.unknownFields.equals(taskProcess.unknownFields);
        }
        return super.equals(obj);
    }

    /* renamed from: getDefaultInstanceForType */
    public TaskProcess m7588getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    public Parser<TaskProcess> getParserForType() {
        return PARSER;
    }

    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.taskList_.size(); i3++) {
            i2 += computeStringSizeNoTag(this.taskList_.getRaw(i3));
        }
        int size = 0 + i2 + (mo7589getTaskListList().size() * 1) + this.unknownFields.getSerializedSize();
        this.memoizedSize = size;
        return size;
    }

    @Override // cn.irisgw.live.TaskProcessOrBuilder
    public String getTaskList(int i) {
        return (String) this.taskList_.get(i);
    }

    @Override // cn.irisgw.live.TaskProcessOrBuilder
    public ByteString getTaskListBytes(int i) {
        return this.taskList_.getByteString(i);
    }

    @Override // cn.irisgw.live.TaskProcessOrBuilder
    public int getTaskListCount() {
        return this.taskList_.size();
    }

    @Override // cn.irisgw.live.TaskProcessOrBuilder
    /* renamed from: getTaskListList */
    public ProtocolStringList mo7589getTaskListList() {
        return this.taskList_;
    }

    public final UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public int hashCode() {
        if (this.memoizedHashCode != 0) {
            return this.memoizedHashCode;
        }
        int hashCode = 779 + getDescriptor().hashCode();
        int i = hashCode;
        if (getTaskListCount() > 0) {
            i = (((hashCode * 37) + 1) * 53) + mo7589getTaskListList().hashCode();
        }
        int hashCode2 = (i * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return LiveConstants.internal_static_cn_irisgw_live_TaskProcess_fieldAccessorTable.ensureFieldAccessorsInitialized(TaskProcess.class, Builder.class);
    }

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

    /* renamed from: newBuilderForType */
    public Builder m7592newBuilderForType() {
        return newBuilder();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: newBuilderForType */
    public Builder m7591newBuilderForType(GeneratedMessageV3.BuilderParent builderParent) {
        return new Builder(builderParent);
    }

    public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unusedPrivateParameter) {
        return new TaskProcess();
    }

    /* renamed from: toBuilder */
    public Builder m7594toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.taskList_.size()) {
                this.unknownFields.writeTo(codedOutputStream);
                return;
            } else {
                GeneratedMessageV3.writeString(codedOutputStream, 1, this.taskList_.getRaw(i2));
                i = i2 + 1;
            }
        }
    }
}
