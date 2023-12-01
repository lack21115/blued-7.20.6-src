package com.google.type;

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
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/google/type/PostalAddress.class */
public final class PostalAddress extends GeneratedMessageV3 implements PostalAddressOrBuilder {
    public static final int ADDRESS_LINES_FIELD_NUMBER = 9;
    public static final int ADMINISTRATIVE_AREA_FIELD_NUMBER = 6;
    public static final int LANGUAGE_CODE_FIELD_NUMBER = 3;
    public static final int LOCALITY_FIELD_NUMBER = 7;
    public static final int ORGANIZATION_FIELD_NUMBER = 11;
    public static final int POSTAL_CODE_FIELD_NUMBER = 4;
    public static final int RECIPIENTS_FIELD_NUMBER = 10;
    public static final int REGION_CODE_FIELD_NUMBER = 2;
    public static final int REVISION_FIELD_NUMBER = 1;
    public static final int SORTING_CODE_FIELD_NUMBER = 5;
    public static final int SUBLOCALITY_FIELD_NUMBER = 8;
    private static final long serialVersionUID = 0;
    private LazyStringList addressLines_;
    private volatile Object administrativeArea_;
    private int bitField0_;
    private volatile Object languageCode_;
    private volatile Object locality_;
    private byte memoizedIsInitialized;
    private volatile Object organization_;
    private volatile Object postalCode_;
    private LazyStringList recipients_;
    private volatile Object regionCode_;
    private int revision_;
    private volatile Object sortingCode_;
    private volatile Object sublocality_;
    private static final PostalAddress DEFAULT_INSTANCE = new PostalAddress();
    private static final Parser<PostalAddress> PARSER = new AbstractParser<PostalAddress>() { // from class: com.google.type.PostalAddress.1
        @Override // com.google.protobuf.Parser
        public PostalAddress parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new PostalAddress(codedInputStream, extensionRegistryLite);
        }
    };

    /* loaded from: source-7994992-dex2jar.jar:com/google/type/PostalAddress$Builder.class */
    public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PostalAddressOrBuilder {
        private LazyStringList addressLines_;
        private Object administrativeArea_;
        private int bitField0_;
        private Object languageCode_;
        private Object locality_;
        private Object organization_;
        private Object postalCode_;
        private LazyStringList recipients_;
        private Object regionCode_;
        private int revision_;
        private Object sortingCode_;
        private Object sublocality_;

        private Builder() {
            this.regionCode_ = "";
            this.languageCode_ = "";
            this.postalCode_ = "";
            this.sortingCode_ = "";
            this.administrativeArea_ = "";
            this.locality_ = "";
            this.sublocality_ = "";
            this.addressLines_ = LazyStringArrayList.EMPTY;
            this.recipients_ = LazyStringArrayList.EMPTY;
            this.organization_ = "";
            maybeForceBuilderInitialization();
        }

        private Builder(GeneratedMessageV3.BuilderParent builderParent) {
            super(builderParent);
            this.regionCode_ = "";
            this.languageCode_ = "";
            this.postalCode_ = "";
            this.sortingCode_ = "";
            this.administrativeArea_ = "";
            this.locality_ = "";
            this.sublocality_ = "";
            this.addressLines_ = LazyStringArrayList.EMPTY;
            this.recipients_ = LazyStringArrayList.EMPTY;
            this.organization_ = "";
            maybeForceBuilderInitialization();
        }

        private void ensureAddressLinesIsMutable() {
            if ((this.bitField0_ & 256) == 0) {
                this.addressLines_ = new LazyStringArrayList(this.addressLines_);
                this.bitField0_ |= 256;
            }
        }

        private void ensureRecipientsIsMutable() {
            if ((this.bitField0_ & 512) == 0) {
                this.recipients_ = new LazyStringArrayList(this.recipients_);
                this.bitField0_ |= 512;
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PostalAddressProto.internal_static_google_type_PostalAddress_descriptor;
        }

        private void maybeForceBuilderInitialization() {
            boolean unused = PostalAddress.alwaysUseFieldBuilders;
        }

        public Builder addAddressLines(String str) {
            if (str != null) {
                ensureAddressLinesIsMutable();
                this.addressLines_.add(str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addAddressLinesBytes(ByteString byteString) {
            if (byteString != null) {
                PostalAddress.checkByteStringIsUtf8(byteString);
                ensureAddressLinesIsMutable();
                this.addressLines_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addAllAddressLines(Iterable<String> iterable) {
            ensureAddressLinesIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.addressLines_);
            onChanged();
            return this;
        }

        public Builder addAllRecipients(Iterable<String> iterable) {
            ensureRecipientsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.recipients_);
            onChanged();
            return this;
        }

        public Builder addRecipients(String str) {
            if (str != null) {
                ensureRecipientsIsMutable();
                this.recipients_.add(str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder addRecipientsBytes(ByteString byteString) {
            if (byteString != null) {
                PostalAddress.checkByteStringIsUtf8(byteString);
                ensureRecipientsIsMutable();
                this.recipients_.add(byteString);
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.addRepeatedField(fieldDescriptor, obj);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PostalAddress build() {
            PostalAddress buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw newUninitializedMessageException((Message) buildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public PostalAddress buildPartial() {
            PostalAddress postalAddress = new PostalAddress(this);
            postalAddress.revision_ = this.revision_;
            postalAddress.regionCode_ = this.regionCode_;
            postalAddress.languageCode_ = this.languageCode_;
            postalAddress.postalCode_ = this.postalCode_;
            postalAddress.sortingCode_ = this.sortingCode_;
            postalAddress.administrativeArea_ = this.administrativeArea_;
            postalAddress.locality_ = this.locality_;
            postalAddress.sublocality_ = this.sublocality_;
            if ((this.bitField0_ & 256) != 0) {
                this.addressLines_ = this.addressLines_.getUnmodifiableView();
                this.bitField0_ &= -257;
            }
            postalAddress.addressLines_ = this.addressLines_;
            if ((this.bitField0_ & 512) != 0) {
                this.recipients_ = this.recipients_.getUnmodifiableView();
                this.bitField0_ &= -513;
            }
            postalAddress.recipients_ = this.recipients_;
            postalAddress.organization_ = this.organization_;
            postalAddress.bitField0_ = 0;
            onBuilt();
            return postalAddress;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.revision_ = 0;
            this.regionCode_ = "";
            this.languageCode_ = "";
            this.postalCode_ = "";
            this.sortingCode_ = "";
            this.administrativeArea_ = "";
            this.locality_ = "";
            this.sublocality_ = "";
            this.addressLines_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -257;
            this.recipients_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -513;
            this.organization_ = "";
            return this;
        }

        public Builder clearAddressLines() {
            this.addressLines_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -257;
            onChanged();
            return this;
        }

        public Builder clearAdministrativeArea() {
            this.administrativeArea_ = PostalAddress.getDefaultInstance().getAdministrativeArea();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder clearField(Descriptors.FieldDescriptor fieldDescriptor) {
            return (Builder) super.clearField(fieldDescriptor);
        }

        public Builder clearLanguageCode() {
            this.languageCode_ = PostalAddress.getDefaultInstance().getLanguageCode();
            onChanged();
            return this;
        }

        public Builder clearLocality() {
            this.locality_ = PostalAddress.getDefaultInstance().getLocality();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder clearOneof(Descriptors.OneofDescriptor oneofDescriptor) {
            return (Builder) super.clearOneof(oneofDescriptor);
        }

        public Builder clearOrganization() {
            this.organization_ = PostalAddress.getDefaultInstance().getOrganization();
            onChanged();
            return this;
        }

        public Builder clearPostalCode() {
            this.postalCode_ = PostalAddress.getDefaultInstance().getPostalCode();
            onChanged();
            return this;
        }

        public Builder clearRecipients() {
            this.recipients_ = LazyStringArrayList.EMPTY;
            this.bitField0_ &= -513;
            onChanged();
            return this;
        }

        public Builder clearRegionCode() {
            this.regionCode_ = PostalAddress.getDefaultInstance().getRegionCode();
            onChanged();
            return this;
        }

        public Builder clearRevision() {
            this.revision_ = 0;
            onChanged();
            return this;
        }

        public Builder clearSortingCode() {
            this.sortingCode_ = PostalAddress.getDefaultInstance().getSortingCode();
            onChanged();
            return this;
        }

        public Builder clearSublocality() {
            this.sublocality_ = PostalAddress.getDefaultInstance().getSublocality();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo2030clone() {
            return (Builder) super.mo2030clone();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getAddressLines(int i) {
            return (String) this.addressLines_.get(i);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getAddressLinesBytes(int i) {
            return this.addressLines_.getByteString(i);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public int getAddressLinesCount() {
            return this.addressLines_.size();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ProtocolStringList getAddressLinesList() {
            return this.addressLines_.getUnmodifiableView();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getAdministrativeArea() {
            Object obj = this.administrativeArea_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.administrativeArea_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getAdministrativeAreaBytes() {
            Object obj = this.administrativeArea_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.administrativeArea_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PostalAddress getDefaultInstanceForType() {
            return PostalAddress.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return PostalAddressProto.internal_static_google_type_PostalAddress_descriptor;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getLanguageCode() {
            Object obj = this.languageCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.languageCode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getLanguageCodeBytes() {
            Object obj = this.languageCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.languageCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getLocality() {
            Object obj = this.locality_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.locality_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getLocalityBytes() {
            Object obj = this.locality_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.locality_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getOrganization() {
            Object obj = this.organization_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.organization_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getOrganizationBytes() {
            Object obj = this.organization_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.organization_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getPostalCode() {
            Object obj = this.postalCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.postalCode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getPostalCodeBytes() {
            Object obj = this.postalCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.postalCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getRecipients(int i) {
            return (String) this.recipients_.get(i);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getRecipientsBytes(int i) {
            return this.recipients_.getByteString(i);
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public int getRecipientsCount() {
            return this.recipients_.size();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ProtocolStringList getRecipientsList() {
            return this.recipients_.getUnmodifiableView();
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getRegionCode() {
            Object obj = this.regionCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.regionCode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getRegionCodeBytes() {
            Object obj = this.regionCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.regionCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public int getRevision() {
            return this.revision_;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getSortingCode() {
            Object obj = this.sortingCode_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.sortingCode_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getSortingCodeBytes() {
            Object obj = this.sortingCode_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sortingCode_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public String getSublocality() {
            Object obj = this.sublocality_;
            if (obj instanceof String) {
                return (String) obj;
            }
            String stringUtf8 = ((ByteString) obj).toStringUtf8();
            this.sublocality_ = stringUtf8;
            return stringUtf8;
        }

        @Override // com.google.type.PostalAddressOrBuilder
        public ByteString getSublocalityBytes() {
            Object obj = this.sublocality_;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.sublocality_ = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder
        public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PostalAddressProto.internal_static_google_type_PostalAddress_fieldAccessorTable.ensureFieldAccessorsInitialized(PostalAddress.class, Builder.class);
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.google.type.PostalAddress.Builder mergeFrom(com.google.protobuf.CodedInputStream r5, com.google.protobuf.ExtensionRegistryLite r6) throws java.io.IOException {
            /*
                r4 = this;
                r0 = 0
                r7 = r0
                com.google.protobuf.Parser r0 = com.google.type.PostalAddress.access$1700()     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r1 = r5
                r2 = r6
                java.lang.Object r0 = r0.parsePartialFrom(r1, r2)     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                com.google.type.PostalAddress r0 = (com.google.type.PostalAddress) r0     // Catch: java.lang.Throwable -> L1c com.google.protobuf.InvalidProtocolBufferException -> L22
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L1a
                r0 = r4
                r1 = r5
                com.google.type.PostalAddress$Builder r0 = r0.mergeFrom(r1)
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
                com.google.type.PostalAddress r0 = (com.google.type.PostalAddress) r0     // Catch: java.lang.Throwable -> L1c
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
                com.google.type.PostalAddress$Builder r0 = r0.mergeFrom(r1)
            L3b:
                r0 = r6
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.type.PostalAddress.Builder.mergeFrom(com.google.protobuf.CodedInputStream, com.google.protobuf.ExtensionRegistryLite):com.google.type.PostalAddress$Builder");
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(Message message) {
            if (message instanceof PostalAddress) {
                return mergeFrom((PostalAddress) message);
            }
            super.mergeFrom(message);
            return this;
        }

        public Builder mergeFrom(PostalAddress postalAddress) {
            if (postalAddress == PostalAddress.getDefaultInstance()) {
                return this;
            }
            if (postalAddress.getRevision() != 0) {
                setRevision(postalAddress.getRevision());
            }
            if (!postalAddress.getRegionCode().isEmpty()) {
                this.regionCode_ = postalAddress.regionCode_;
                onChanged();
            }
            if (!postalAddress.getLanguageCode().isEmpty()) {
                this.languageCode_ = postalAddress.languageCode_;
                onChanged();
            }
            if (!postalAddress.getPostalCode().isEmpty()) {
                this.postalCode_ = postalAddress.postalCode_;
                onChanged();
            }
            if (!postalAddress.getSortingCode().isEmpty()) {
                this.sortingCode_ = postalAddress.sortingCode_;
                onChanged();
            }
            if (!postalAddress.getAdministrativeArea().isEmpty()) {
                this.administrativeArea_ = postalAddress.administrativeArea_;
                onChanged();
            }
            if (!postalAddress.getLocality().isEmpty()) {
                this.locality_ = postalAddress.locality_;
                onChanged();
            }
            if (!postalAddress.getSublocality().isEmpty()) {
                this.sublocality_ = postalAddress.sublocality_;
                onChanged();
            }
            if (!postalAddress.addressLines_.isEmpty()) {
                if (this.addressLines_.isEmpty()) {
                    this.addressLines_ = postalAddress.addressLines_;
                    this.bitField0_ &= -257;
                } else {
                    ensureAddressLinesIsMutable();
                    this.addressLines_.addAll(postalAddress.addressLines_);
                }
                onChanged();
            }
            if (!postalAddress.recipients_.isEmpty()) {
                if (this.recipients_.isEmpty()) {
                    this.recipients_ = postalAddress.recipients_;
                    this.bitField0_ &= -513;
                } else {
                    ensureRecipientsIsMutable();
                    this.recipients_.addAll(postalAddress.recipients_);
                }
                onChanged();
            }
            if (!postalAddress.getOrganization().isEmpty()) {
                this.organization_ = postalAddress.organization_;
                onChanged();
            }
            mergeUnknownFields(postalAddress.unknownFields);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public final Builder mergeUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.mergeUnknownFields(unknownFieldSet);
        }

        public Builder setAddressLines(int i, String str) {
            if (str != null) {
                ensureAddressLinesIsMutable();
                this.addressLines_.set(i, str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAdministrativeArea(String str) {
            if (str != null) {
                this.administrativeArea_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setAdministrativeAreaBytes(ByteString byteString) {
            if (byteString != null) {
                PostalAddress.checkByteStringIsUtf8(byteString);
                this.administrativeArea_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj) {
            return (Builder) super.setField(fieldDescriptor, obj);
        }

        public Builder setLanguageCode(String str) {
            if (str != null) {
                this.languageCode_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLanguageCodeBytes(ByteString byteString) {
            if (byteString != null) {
                PostalAddress.checkByteStringIsUtf8(byteString);
                this.languageCode_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLocality(String str) {
            if (str != null) {
                this.locality_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setLocalityBytes(ByteString byteString) {
            if (byteString != null) {
                PostalAddress.checkByteStringIsUtf8(byteString);
                this.locality_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setOrganization(String str) {
            if (str != null) {
                this.organization_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setOrganizationBytes(ByteString byteString) {
            if (byteString != null) {
                PostalAddress.checkByteStringIsUtf8(byteString);
                this.organization_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPostalCode(String str) {
            if (str != null) {
                this.postalCode_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setPostalCodeBytes(ByteString byteString) {
            if (byteString != null) {
                PostalAddress.checkByteStringIsUtf8(byteString);
                this.postalCode_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRecipients(int i, String str) {
            if (str != null) {
                ensureRecipientsIsMutable();
                this.recipients_.set(i, str);
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRegionCode(String str) {
            if (str != null) {
                this.regionCode_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setRegionCodeBytes(ByteString byteString) {
            if (byteString != null) {
                PostalAddress.checkByteStringIsUtf8(byteString);
                this.regionCode_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public Builder setRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, int i, Object obj) {
            return (Builder) super.setRepeatedField(fieldDescriptor, i, obj);
        }

        public Builder setRevision(int i) {
            this.revision_ = i;
            onChanged();
            return this;
        }

        public Builder setSortingCode(String str) {
            if (str != null) {
                this.sortingCode_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setSortingCodeBytes(ByteString byteString) {
            if (byteString != null) {
                PostalAddress.checkByteStringIsUtf8(byteString);
                this.sortingCode_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setSublocality(String str) {
            if (str != null) {
                this.sublocality_ = str;
                onChanged();
                return this;
            }
            throw null;
        }

        public Builder setSublocalityBytes(ByteString byteString) {
            if (byteString != null) {
                PostalAddress.checkByteStringIsUtf8(byteString);
                this.sublocality_ = byteString;
                onChanged();
                return this;
            }
            throw null;
        }

        @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
        public final Builder setUnknownFields(UnknownFieldSet unknownFieldSet) {
            return (Builder) super.setUnknownFields(unknownFieldSet);
        }
    }

    private PostalAddress() {
        this.memoizedIsInitialized = (byte) -1;
        this.regionCode_ = "";
        this.languageCode_ = "";
        this.postalCode_ = "";
        this.sortingCode_ = "";
        this.administrativeArea_ = "";
        this.locality_ = "";
        this.sublocality_ = "";
        this.addressLines_ = LazyStringArrayList.EMPTY;
        this.recipients_ = LazyStringArrayList.EMPTY;
        this.organization_ = "";
    }

    private PostalAddress(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                    switch (readTag) {
                        case 0:
                            break;
                        case 8:
                            this.revision_ = codedInputStream.readInt32();
                            continue;
                        case 18:
                            this.regionCode_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 26:
                            this.languageCode_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 34:
                            this.postalCode_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 42:
                            this.sortingCode_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 50:
                            this.administrativeArea_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 58:
                            this.locality_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 66:
                            this.sublocality_ = codedInputStream.readStringRequireUtf8();
                            continue;
                        case 74:
                            String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                            boolean z4 = z2;
                            if (!(z2 & true)) {
                                this.addressLines_ = new LazyStringArrayList();
                                z4 = z2 | true;
                            }
                            this.addressLines_.add(readStringRequireUtf8);
                            z2 = z4;
                            continue;
                        case 82:
                            String readStringRequireUtf82 = codedInputStream.readStringRequireUtf8();
                            boolean z5 = z2;
                            if (!(z2 & true)) {
                                this.recipients_ = new LazyStringArrayList();
                                z5 = z2 | true;
                            }
                            this.recipients_.add(readStringRequireUtf82);
                            z2 = z5;
                            continue;
                        case 90:
                            this.organization_ = codedInputStream.readStringRequireUtf8();
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
            } catch (Throwable th) {
                if (z3 & true) {
                    this.addressLines_ = this.addressLines_.getUnmodifiableView();
                }
                if (z3 & true) {
                    this.recipients_ = this.recipients_.getUnmodifiableView();
                }
                this.unknownFields = newBuilder.build();
                makeExtensionsImmutable();
                throw th;
            }
        }
        if (z2 & true) {
            this.addressLines_ = this.addressLines_.getUnmodifiableView();
        }
        if (z2 & true) {
            this.recipients_ = this.recipients_.getUnmodifiableView();
        }
        this.unknownFields = newBuilder.build();
        makeExtensionsImmutable();
    }

    private PostalAddress(GeneratedMessageV3.Builder<?> builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
    }

    public static PostalAddress getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return PostalAddressProto.internal_static_google_type_PostalAddress_descriptor;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(PostalAddress postalAddress) {
        return DEFAULT_INSTANCE.toBuilder().mergeFrom(postalAddress);
    }

    public static PostalAddress parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (PostalAddress) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static PostalAddress parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static PostalAddress parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (PostalAddress) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream);
    }

    public static PostalAddress parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) GeneratedMessageV3.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(InputStream inputStream) throws IOException {
        return (PostalAddress) GeneratedMessageV3.parseWithIOException(PARSER, inputStream);
    }

    public static PostalAddress parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (PostalAddress) GeneratedMessageV3.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static PostalAddress parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static PostalAddress parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static PostalAddress parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Parser<PostalAddress> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PostalAddress) {
            PostalAddress postalAddress = (PostalAddress) obj;
            return getRevision() == postalAddress.getRevision() && getRegionCode().equals(postalAddress.getRegionCode()) && getLanguageCode().equals(postalAddress.getLanguageCode()) && getPostalCode().equals(postalAddress.getPostalCode()) && getSortingCode().equals(postalAddress.getSortingCode()) && getAdministrativeArea().equals(postalAddress.getAdministrativeArea()) && getLocality().equals(postalAddress.getLocality()) && getSublocality().equals(postalAddress.getSublocality()) && getAddressLinesList().equals(postalAddress.getAddressLinesList()) && getRecipientsList().equals(postalAddress.getRecipientsList()) && getOrganization().equals(postalAddress.getOrganization()) && this.unknownFields.equals(postalAddress.unknownFields);
        }
        return super.equals(obj);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getAddressLines(int i) {
        return (String) this.addressLines_.get(i);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getAddressLinesBytes(int i) {
        return this.addressLines_.getByteString(i);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public int getAddressLinesCount() {
        return this.addressLines_.size();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ProtocolStringList getAddressLinesList() {
        return this.addressLines_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getAdministrativeArea() {
        Object obj = this.administrativeArea_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.administrativeArea_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getAdministrativeAreaBytes() {
        Object obj = this.administrativeArea_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.administrativeArea_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public PostalAddress getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getLanguageCode() {
        Object obj = this.languageCode_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.languageCode_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getLanguageCodeBytes() {
        Object obj = this.languageCode_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.languageCode_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getLocality() {
        Object obj = this.locality_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.locality_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getLocalityBytes() {
        Object obj = this.locality_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.locality_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getOrganization() {
        Object obj = this.organization_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.organization_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getOrganizationBytes() {
        Object obj = this.organization_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.organization_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<PostalAddress> getParserForType() {
        return PARSER;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getPostalCode() {
        Object obj = this.postalCode_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.postalCode_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getPostalCodeBytes() {
        Object obj = this.postalCode_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.postalCode_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getRecipients(int i) {
        return (String) this.recipients_.get(i);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getRecipientsBytes(int i) {
        return this.recipients_.getByteString(i);
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public int getRecipientsCount() {
        return this.recipients_.size();
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ProtocolStringList getRecipientsList() {
        return this.recipients_;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getRegionCode() {
        Object obj = this.regionCode_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.regionCode_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getRegionCodeBytes() {
        Object obj = this.regionCode_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.regionCode_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public int getRevision() {
        return this.revision_;
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSize;
        if (i != -1) {
            return i;
        }
        int i2 = this.revision_;
        int computeInt32Size = i2 != 0 ? CodedOutputStream.computeInt32Size(1, i2) + 0 : 0;
        int i3 = computeInt32Size;
        if (!getRegionCodeBytes().isEmpty()) {
            i3 = computeInt32Size + GeneratedMessageV3.computeStringSize(2, this.regionCode_);
        }
        int i4 = i3;
        if (!getLanguageCodeBytes().isEmpty()) {
            i4 = i3 + GeneratedMessageV3.computeStringSize(3, this.languageCode_);
        }
        int i5 = i4;
        if (!getPostalCodeBytes().isEmpty()) {
            i5 = i4 + GeneratedMessageV3.computeStringSize(4, this.postalCode_);
        }
        int i6 = i5;
        if (!getSortingCodeBytes().isEmpty()) {
            i6 = i5 + GeneratedMessageV3.computeStringSize(5, this.sortingCode_);
        }
        int i7 = i6;
        if (!getAdministrativeAreaBytes().isEmpty()) {
            i7 = i6 + GeneratedMessageV3.computeStringSize(6, this.administrativeArea_);
        }
        int i8 = i7;
        if (!getLocalityBytes().isEmpty()) {
            i8 = i7 + GeneratedMessageV3.computeStringSize(7, this.locality_);
        }
        int i9 = i8;
        if (!getSublocalityBytes().isEmpty()) {
            i9 = i8 + GeneratedMessageV3.computeStringSize(8, this.sublocality_);
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.addressLines_.size(); i11++) {
            i10 += computeStringSizeNoTag(this.addressLines_.getRaw(i11));
        }
        int size = getAddressLinesList().size();
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int i14 = i13;
            if (i14 >= this.recipients_.size()) {
                break;
            }
            i12 += computeStringSizeNoTag(this.recipients_.getRaw(i14));
            i13 = i14 + 1;
        }
        int size2 = i9 + i10 + (size * 1) + i12 + (getRecipientsList().size() * 1);
        int i15 = size2;
        if (!getOrganizationBytes().isEmpty()) {
            i15 = size2 + GeneratedMessageV3.computeStringSize(11, this.organization_);
        }
        int serializedSize = i15 + this.unknownFields.getSerializedSize();
        this.memoizedSize = serializedSize;
        return serializedSize;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getSortingCode() {
        Object obj = this.sortingCode_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.sortingCode_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getSortingCodeBytes() {
        Object obj = this.sortingCode_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.sortingCode_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public String getSublocality() {
        Object obj = this.sublocality_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.sublocality_ = stringUtf8;
        return stringUtf8;
    }

    @Override // com.google.type.PostalAddressOrBuilder
    public ByteString getSublocalityBytes() {
        Object obj = this.sublocality_;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.sublocality_ = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
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
        int hashCode = ((((((((((((((((((((((((((((((((779 + getDescriptor().hashCode()) * 37) + 1) * 53) + getRevision()) * 37) + 2) * 53) + getRegionCode().hashCode()) * 37) + 3) * 53) + getLanguageCode().hashCode()) * 37) + 4) * 53) + getPostalCode().hashCode()) * 37) + 5) * 53) + getSortingCode().hashCode()) * 37) + 6) * 53) + getAdministrativeArea().hashCode()) * 37) + 7) * 53) + getLocality().hashCode()) * 37) + 8) * 53) + getSublocality().hashCode();
        int i = hashCode;
        if (getAddressLinesCount() > 0) {
            i = (((hashCode * 37) + 9) * 53) + getAddressLinesList().hashCode();
        }
        int i2 = i;
        if (getRecipientsCount() > 0) {
            i2 = (((i * 37) + 10) * 53) + getRecipientsList().hashCode();
        }
        int hashCode2 = (((((i2 * 37) + 11) * 53) + getOrganization().hashCode()) * 29) + this.unknownFields.hashCode();
        this.memoizedHashCode = hashCode2;
        return hashCode2;
    }

    @Override // com.google.protobuf.GeneratedMessageV3
    public GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return PostalAddressProto.internal_static_google_type_PostalAddress_fieldAccessorTable.ensureFieldAccessorsInitialized(PostalAddress.class, Builder.class);
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

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
    }

    @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        int i;
        int i2 = this.revision_;
        if (i2 != 0) {
            codedOutputStream.writeInt32(1, i2);
        }
        if (!getRegionCodeBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 2, this.regionCode_);
        }
        if (!getLanguageCodeBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 3, this.languageCode_);
        }
        if (!getPostalCodeBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 4, this.postalCode_);
        }
        if (!getSortingCodeBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 5, this.sortingCode_);
        }
        if (!getAdministrativeAreaBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 6, this.administrativeArea_);
        }
        if (!getLocalityBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 7, this.locality_);
        }
        if (!getSublocalityBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 8, this.sublocality_);
        }
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.addressLines_.size()) {
                break;
            }
            GeneratedMessageV3.writeString(codedOutputStream, 9, this.addressLines_.getRaw(i4));
            i3 = i4 + 1;
        }
        for (i = 0; i < this.recipients_.size(); i++) {
            GeneratedMessageV3.writeString(codedOutputStream, 10, this.recipients_.getRaw(i));
        }
        if (!getOrganizationBytes().isEmpty()) {
            GeneratedMessageV3.writeString(codedOutputStream, 11, this.organization_);
        }
        this.unknownFields.writeTo(codedOutputStream);
    }
}
