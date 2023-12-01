package android.net;

import android.content.ContentResolver;
import android.os.Environment;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.StrictMode;
import android.telecom.PhoneAccount;
import android.util.Log;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.RandomAccess;
import libcore.net.UriCodec;

/* loaded from: source-9557208-dex2jar.jar:android/net/Uri.class */
public abstract class Uri implements Parcelable, Comparable<Uri> {
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final int NOT_CALCULATED = -2;
    private static final int NOT_FOUND = -1;
    private static final String NOT_HIERARCHICAL = "This isn't a hierarchical URI.";
    private static final int NULL_TYPE_ID = 0;
    private static final String LOG = Uri.class.getSimpleName();
    private static final String NOT_CACHED = new String("NOT CACHED");
    public static final Uri EMPTY = new HierarchicalUri(null, Part.NULL, PathPart.EMPTY, Part.NULL, Part.NULL);
    public static final Parcelable.Creator<Uri> CREATOR = new Parcelable.Creator<Uri>() { // from class: android.net.Uri.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Uri createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            switch (readInt) {
                case 0:
                    return null;
                case 1:
                    return StringUri.readFrom(parcel);
                case 2:
                    return OpaqueUri.readFrom(parcel);
                case 3:
                    return HierarchicalUri.readFrom(parcel);
                default:
                    throw new IllegalArgumentException("Unknown URI type: " + readInt);
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Uri[] newArray(int i) {
            return new Uri[i];
        }
    };
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    /* loaded from: source-9557208-dex2jar.jar:android/net/Uri$AbstractHierarchicalUri.class */
    private static abstract class AbstractHierarchicalUri extends Uri {
        private volatile String host;
        private volatile int port;
        private Part userInfo;

        private AbstractHierarchicalUri() {
            super();
            this.host = Uri.NOT_CACHED;
            this.port = -2;
        }

        private Part getUserInfoPart() {
            if (this.userInfo == null) {
                Part fromEncoded = Part.fromEncoded(parseUserInfo());
                this.userInfo = fromEncoded;
                return fromEncoded;
            }
            return this.userInfo;
        }

        private String parseHost() {
            String encodedAuthority = getEncodedAuthority();
            if (encodedAuthority == null) {
                return null;
            }
            int indexOf = encodedAuthority.indexOf(64);
            int indexOf2 = encodedAuthority.indexOf(58, indexOf);
            return decode(indexOf2 == -1 ? encodedAuthority.substring(indexOf + 1) : encodedAuthority.substring(indexOf + 1, indexOf2));
        }

        private int parsePort() {
            int indexOf;
            String encodedAuthority = getEncodedAuthority();
            if (encodedAuthority == null || (indexOf = encodedAuthority.indexOf(58, encodedAuthority.indexOf(64))) == -1) {
                return -1;
            }
            try {
                return Integer.parseInt(decode(encodedAuthority.substring(indexOf + 1)));
            } catch (NumberFormatException e) {
                Log.w(Uri.LOG, "Error parsing port string.", e);
                return -1;
            }
        }

        private String parseUserInfo() {
            int indexOf;
            String encodedAuthority = getEncodedAuthority();
            if (encodedAuthority == null || (indexOf = encodedAuthority.indexOf(64)) == -1) {
                return null;
            }
            return encodedAuthority.substring(0, indexOf);
        }

        @Override // android.net.Uri, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Uri uri) {
            return super.compareTo(uri);
        }

        @Override // android.net.Uri
        public final String getEncodedUserInfo() {
            return getUserInfoPart().getEncoded();
        }

        @Override // android.net.Uri
        public String getHost() {
            if (this.host != Uri.NOT_CACHED) {
                return this.host;
            }
            String parseHost = parseHost();
            this.host = parseHost;
            return parseHost;
        }

        @Override // android.net.Uri
        public String getLastPathSegment() {
            List<String> pathSegments = getPathSegments();
            int size = pathSegments.size();
            if (size == 0) {
                return null;
            }
            return pathSegments.get(size - 1);
        }

        @Override // android.net.Uri
        public int getPort() {
            if (this.port == -2) {
                int parsePort = parsePort();
                this.port = parsePort;
                return parsePort;
            }
            return this.port;
        }

        @Override // android.net.Uri
        public String getUserInfo() {
            return getUserInfoPart().getDecoded();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/Uri$AbstractPart.class */
    public static abstract class AbstractPart {
        volatile String decoded;
        volatile String encoded;

        /* loaded from: source-9557208-dex2jar.jar:android/net/Uri$AbstractPart$Representation.class */
        static class Representation {
            static final int BOTH = 0;
            static final int DECODED = 2;
            static final int ENCODED = 1;

            Representation() {
            }
        }

        AbstractPart(String str, String str2) {
            this.encoded = str;
            this.decoded = str2;
        }

        final String getDecoded() {
            if (this.decoded != Uri.NOT_CACHED) {
                return this.decoded;
            }
            String decode = Uri.decode(this.encoded);
            this.decoded = decode;
            return decode;
        }

        abstract String getEncoded();

        final void writeTo(Parcel parcel) {
            boolean z = this.encoded != Uri.NOT_CACHED;
            boolean z2 = this.decoded != Uri.NOT_CACHED;
            if (z && z2) {
                parcel.writeInt(0);
                parcel.writeString(this.encoded);
                parcel.writeString(this.decoded);
            } else if (z) {
                parcel.writeInt(1);
                parcel.writeString(this.encoded);
            } else if (!z2) {
                throw new IllegalArgumentException("Neither encoded nor decoded");
            } else {
                parcel.writeInt(2);
                parcel.writeString(this.decoded);
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/net/Uri$Builder.class */
    public static final class Builder {
        private Part authority;
        private Part fragment;
        private Part opaquePart;
        private PathPart path;
        private Part query;
        private String scheme;

        private boolean hasSchemeOrAuthority() {
            if (this.scheme == null) {
                return (this.authority == null || this.authority == Part.NULL) ? false : true;
            }
            return true;
        }

        public Builder appendEncodedPath(String str) {
            return path(PathPart.appendEncodedSegment(this.path, str));
        }

        public Builder appendPath(String str) {
            return path(PathPart.appendDecodedSegment(this.path, str));
        }

        public Builder appendQueryParameter(String str, String str2) {
            this.opaquePart = null;
            String str3 = Uri.encode(str, null) + "=" + Uri.encode(str2, null);
            if (this.query == null) {
                this.query = Part.fromEncoded(str3);
                return this;
            }
            String encoded = this.query.getEncoded();
            if (encoded == null || encoded.length() == 0) {
                this.query = Part.fromEncoded(str3);
                return this;
            }
            this.query = Part.fromEncoded(encoded + "&" + str3);
            return this;
        }

        Builder authority(Part part) {
            this.opaquePart = null;
            this.authority = part;
            return this;
        }

        public Builder authority(String str) {
            return authority(Part.fromDecoded(str));
        }

        public Uri build() {
            PathPart pathPart;
            if (this.opaquePart != null) {
                if (this.scheme == null) {
                    throw new UnsupportedOperationException("An opaque URI must have a scheme.");
                }
                return new OpaqueUri(this.scheme, this.opaquePart, this.fragment);
            }
            PathPart pathPart2 = this.path;
            if (pathPart2 == null || pathPart2 == PathPart.NULL) {
                pathPart = PathPart.EMPTY;
            } else {
                pathPart = pathPart2;
                if (hasSchemeOrAuthority()) {
                    pathPart = PathPart.makeAbsolute(pathPart2);
                }
            }
            return new HierarchicalUri(this.scheme, this.authority, pathPart, this.query, this.fragment);
        }

        public Builder clearQuery() {
            return query((Part) null);
        }

        public Builder encodedAuthority(String str) {
            return authority(Part.fromEncoded(str));
        }

        public Builder encodedFragment(String str) {
            return fragment(Part.fromEncoded(str));
        }

        public Builder encodedOpaquePart(String str) {
            return opaquePart(Part.fromEncoded(str));
        }

        public Builder encodedPath(String str) {
            return path(PathPart.fromEncoded(str));
        }

        public Builder encodedQuery(String str) {
            return query(Part.fromEncoded(str));
        }

        Builder fragment(Part part) {
            this.fragment = part;
            return this;
        }

        public Builder fragment(String str) {
            return fragment(Part.fromDecoded(str));
        }

        Builder opaquePart(Part part) {
            this.opaquePart = part;
            return this;
        }

        public Builder opaquePart(String str) {
            return opaquePart(Part.fromDecoded(str));
        }

        Builder path(PathPart pathPart) {
            this.opaquePart = null;
            this.path = pathPart;
            return this;
        }

        public Builder path(String str) {
            return path(PathPart.fromDecoded(str));
        }

        Builder query(Part part) {
            this.opaquePart = null;
            this.query = part;
            return this;
        }

        public Builder query(String str) {
            return query(Part.fromDecoded(str));
        }

        public Builder scheme(String str) {
            this.scheme = str;
            return this;
        }

        public String toString() {
            return build().toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/Uri$HierarchicalUri.class */
    public static class HierarchicalUri extends AbstractHierarchicalUri {
        static final int TYPE_ID = 3;
        private final Part authority;
        private final Part fragment;
        private final PathPart path;
        private final Part query;
        private final String scheme;
        private Part ssp;
        private volatile String uriString;

        private HierarchicalUri(String str, Part part, PathPart pathPart, Part part2, Part part3) {
            super();
            this.uriString = Uri.NOT_CACHED;
            this.scheme = str;
            this.authority = Part.nonNull(part);
            this.path = pathPart == null ? PathPart.NULL : pathPart;
            this.query = Part.nonNull(part2);
            this.fragment = Part.nonNull(part3);
        }

        private void appendSspTo(StringBuilder sb) {
            String encoded = this.authority.getEncoded();
            if (encoded != null) {
                sb.append("//").append(encoded);
            }
            String encoded2 = this.path.getEncoded();
            if (encoded2 != null) {
                sb.append(encoded2);
            }
            if (this.query.isEmpty()) {
                return;
            }
            sb.append('?').append(this.query.getEncoded());
        }

        private Part getSsp() {
            if (this.ssp == null) {
                Part fromEncoded = Part.fromEncoded(makeSchemeSpecificPart());
                this.ssp = fromEncoded;
                return fromEncoded;
            }
            return this.ssp;
        }

        private String makeSchemeSpecificPart() {
            StringBuilder sb = new StringBuilder();
            appendSspTo(sb);
            return sb.toString();
        }

        private String makeUriString() {
            StringBuilder sb = new StringBuilder();
            if (this.scheme != null) {
                sb.append(this.scheme).append(':');
            }
            appendSspTo(sb);
            if (!this.fragment.isEmpty()) {
                sb.append('#').append(this.fragment.getEncoded());
            }
            return sb.toString();
        }

        static Uri readFrom(Parcel parcel) {
            return new HierarchicalUri(parcel.readString(), Part.readFrom(parcel), PathPart.readFrom(parcel), Part.readFrom(parcel), Part.readFrom(parcel));
        }

        @Override // android.net.Uri
        public Builder buildUpon() {
            return new Builder().scheme(this.scheme).authority(this.authority).path(this.path).query(this.query).fragment(this.fragment);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.net.Uri
        public String getAuthority() {
            return this.authority.getDecoded();
        }

        @Override // android.net.Uri
        public String getEncodedAuthority() {
            return this.authority.getEncoded();
        }

        @Override // android.net.Uri
        public String getEncodedFragment() {
            return this.fragment.getEncoded();
        }

        @Override // android.net.Uri
        public String getEncodedPath() {
            return this.path.getEncoded();
        }

        @Override // android.net.Uri
        public String getEncodedQuery() {
            return this.query.getEncoded();
        }

        @Override // android.net.Uri
        public String getEncodedSchemeSpecificPart() {
            return getSsp().getEncoded();
        }

        @Override // android.net.Uri
        public String getFragment() {
            return this.fragment.getDecoded();
        }

        @Override // android.net.Uri
        public String getPath() {
            return this.path.getDecoded();
        }

        @Override // android.net.Uri
        public List<String> getPathSegments() {
            return this.path.getPathSegments();
        }

        @Override // android.net.Uri
        public String getQuery() {
            return this.query.getDecoded();
        }

        @Override // android.net.Uri
        public String getScheme() {
            return this.scheme;
        }

        @Override // android.net.Uri
        public String getSchemeSpecificPart() {
            return getSsp().getDecoded();
        }

        @Override // android.net.Uri
        public boolean isHierarchical() {
            return true;
        }

        @Override // android.net.Uri
        public boolean isRelative() {
            return this.scheme == null;
        }

        @Override // android.net.Uri
        public String toString() {
            if (this.uriString != Uri.NOT_CACHED) {
                return this.uriString;
            }
            String makeUriString = makeUriString();
            this.uriString = makeUriString;
            return makeUriString;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(3);
            parcel.writeString(this.scheme);
            this.authority.writeTo(parcel);
            this.path.writeTo(parcel);
            this.query.writeTo(parcel);
            this.fragment.writeTo(parcel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/Uri$OpaqueUri.class */
    public static class OpaqueUri extends Uri {
        static final int TYPE_ID = 2;
        private volatile String cachedString;
        private final Part fragment;
        private final String scheme;
        private final Part ssp;

        private OpaqueUri(String str, Part part, Part part2) {
            super();
            this.cachedString = Uri.NOT_CACHED;
            this.scheme = str;
            this.ssp = part;
            this.fragment = part2 == null ? Part.NULL : part2;
        }

        static Uri readFrom(Parcel parcel) {
            return new OpaqueUri(parcel.readString(), Part.readFrom(parcel), Part.readFrom(parcel));
        }

        @Override // android.net.Uri
        public Builder buildUpon() {
            return new Builder().scheme(this.scheme).opaquePart(this.ssp).fragment(this.fragment);
        }

        @Override // android.net.Uri, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Uri uri) {
            return super.compareTo(uri);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.net.Uri
        public String getAuthority() {
            return null;
        }

        @Override // android.net.Uri
        public String getEncodedAuthority() {
            return null;
        }

        @Override // android.net.Uri
        public String getEncodedFragment() {
            return this.fragment.getEncoded();
        }

        @Override // android.net.Uri
        public String getEncodedPath() {
            return null;
        }

        @Override // android.net.Uri
        public String getEncodedQuery() {
            return null;
        }

        @Override // android.net.Uri
        public String getEncodedSchemeSpecificPart() {
            return this.ssp.getEncoded();
        }

        @Override // android.net.Uri
        public String getEncodedUserInfo() {
            return null;
        }

        @Override // android.net.Uri
        public String getFragment() {
            return this.fragment.getDecoded();
        }

        @Override // android.net.Uri
        public String getHost() {
            return null;
        }

        @Override // android.net.Uri
        public String getLastPathSegment() {
            return null;
        }

        @Override // android.net.Uri
        public String getPath() {
            return null;
        }

        @Override // android.net.Uri
        public List<String> getPathSegments() {
            return Collections.emptyList();
        }

        @Override // android.net.Uri
        public int getPort() {
            return -1;
        }

        @Override // android.net.Uri
        public String getQuery() {
            return null;
        }

        @Override // android.net.Uri
        public String getScheme() {
            return this.scheme;
        }

        @Override // android.net.Uri
        public String getSchemeSpecificPart() {
            return this.ssp.getDecoded();
        }

        @Override // android.net.Uri
        public String getUserInfo() {
            return null;
        }

        @Override // android.net.Uri
        public boolean isHierarchical() {
            return false;
        }

        @Override // android.net.Uri
        public boolean isRelative() {
            return this.scheme == null;
        }

        @Override // android.net.Uri
        public String toString() {
            if (this.cachedString != Uri.NOT_CACHED) {
                return this.cachedString;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.scheme).append(':');
            sb.append(getEncodedSchemeSpecificPart());
            if (!this.fragment.isEmpty()) {
                sb.append('#').append(this.fragment.getEncoded());
            }
            String sb2 = sb.toString();
            this.cachedString = sb2;
            return sb2;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(2);
            parcel.writeString(this.scheme);
            this.ssp.writeTo(parcel);
            this.fragment.writeTo(parcel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/Uri$Part.class */
    public static class Part extends AbstractPart {
        static final Part NULL = new EmptyPart(null);
        static final Part EMPTY = new EmptyPart("");

        /* loaded from: source-9557208-dex2jar.jar:android/net/Uri$Part$EmptyPart.class */
        private static class EmptyPart extends Part {
            public EmptyPart(String str) {
                super(str, str);
            }

            @Override // android.net.Uri.Part
            boolean isEmpty() {
                return true;
            }
        }

        private Part(String str, String str2) {
            super(str, str2);
        }

        static Part from(String str, String str2) {
            return str == null ? NULL : str.length() == 0 ? EMPTY : str2 == null ? NULL : str2.length() == 0 ? EMPTY : new Part(str, str2);
        }

        static Part fromDecoded(String str) {
            return from(Uri.NOT_CACHED, str);
        }

        static Part fromEncoded(String str) {
            return from(str, Uri.NOT_CACHED);
        }

        static Part nonNull(Part part) {
            Part part2 = part;
            if (part == null) {
                part2 = NULL;
            }
            return part2;
        }

        static Part readFrom(Parcel parcel) {
            int readInt = parcel.readInt();
            switch (readInt) {
                case 0:
                    return from(parcel.readString(), parcel.readString());
                case 1:
                    return fromEncoded(parcel.readString());
                case 2:
                    return fromDecoded(parcel.readString());
                default:
                    throw new IllegalArgumentException("Unknown representation: " + readInt);
            }
        }

        @Override // android.net.Uri.AbstractPart
        String getEncoded() {
            if (this.encoded != Uri.NOT_CACHED) {
                return this.encoded;
            }
            String encode = Uri.encode(this.decoded);
            this.encoded = encode;
            return encode;
        }

        boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/Uri$PathPart.class */
    public static class PathPart extends AbstractPart {
        private PathSegments pathSegments;
        static final PathPart NULL = new PathPart(null, null);
        static final PathPart EMPTY = new PathPart("", "");

        private PathPart(String str, String str2) {
            super(str, str2);
        }

        static PathPart appendDecodedSegment(PathPart pathPart, String str) {
            return appendEncodedSegment(pathPart, Uri.encode(str));
        }

        static PathPart appendEncodedSegment(PathPart pathPart, String str) {
            if (pathPart == null) {
                return fromEncoded(BridgeUtil.SPLIT_MARK + str);
            }
            String encoded = pathPart.getEncoded();
            String str2 = encoded;
            if (encoded == null) {
                str2 = "";
            }
            int length = str2.length();
            return fromEncoded(length == 0 ? BridgeUtil.SPLIT_MARK + str : str2.charAt(length - 1) == '/' ? str2 + str : str2 + BridgeUtil.SPLIT_MARK + str);
        }

        static PathPart from(String str, String str2) {
            return str == null ? NULL : str.length() == 0 ? EMPTY : new PathPart(str, str2);
        }

        static PathPart fromDecoded(String str) {
            return from(Uri.NOT_CACHED, str);
        }

        static PathPart fromEncoded(String str) {
            return from(str, Uri.NOT_CACHED);
        }

        static PathPart makeAbsolute(PathPart pathPart) {
            boolean z = pathPart.encoded != Uri.NOT_CACHED;
            String str = z ? pathPart.encoded : pathPart.decoded;
            if (str == null || str.length() == 0 || str.startsWith(BridgeUtil.SPLIT_MARK)) {
                return pathPart;
            }
            return new PathPart(z ? BridgeUtil.SPLIT_MARK + pathPart.encoded : Uri.NOT_CACHED, pathPart.decoded != Uri.NOT_CACHED ? BridgeUtil.SPLIT_MARK + pathPart.decoded : Uri.NOT_CACHED);
        }

        static PathPart readFrom(Parcel parcel) {
            int readInt = parcel.readInt();
            switch (readInt) {
                case 0:
                    return from(parcel.readString(), parcel.readString());
                case 1:
                    return fromEncoded(parcel.readString());
                case 2:
                    return fromDecoded(parcel.readString());
                default:
                    throw new IllegalArgumentException("Bad representation: " + readInt);
            }
        }

        @Override // android.net.Uri.AbstractPart
        String getEncoded() {
            if (this.encoded != Uri.NOT_CACHED) {
                return this.encoded;
            }
            String encode = Uri.encode(this.decoded, BridgeUtil.SPLIT_MARK);
            this.encoded = encode;
            return encode;
        }

        PathSegments getPathSegments() {
            int i;
            if (this.pathSegments != null) {
                return this.pathSegments;
            }
            String encoded = getEncoded();
            if (encoded == null) {
                PathSegments pathSegments = PathSegments.EMPTY;
                this.pathSegments = pathSegments;
                return pathSegments;
            }
            PathSegmentsBuilder pathSegmentsBuilder = new PathSegmentsBuilder();
            int i2 = 0;
            while (true) {
                i = i2;
                int indexOf = encoded.indexOf(47, i);
                if (indexOf <= -1) {
                    break;
                }
                if (i < indexOf) {
                    pathSegmentsBuilder.add(Uri.decode(encoded.substring(i, indexOf)));
                }
                i2 = indexOf + 1;
            }
            if (i < encoded.length()) {
                pathSegmentsBuilder.add(Uri.decode(encoded.substring(i)));
            }
            PathSegments build = pathSegmentsBuilder.build();
            this.pathSegments = build;
            return build;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/Uri$PathSegments.class */
    public static class PathSegments extends AbstractList<String> implements RandomAccess {
        static final PathSegments EMPTY = new PathSegments(null, 0);
        final String[] segments;
        final int size;

        PathSegments(String[] strArr, int i) {
            this.segments = strArr;
            this.size = i;
        }

        @Override // java.util.AbstractList, java.util.List
        public String get(int i) {
            if (i >= this.size) {
                throw new IndexOutOfBoundsException();
            }
            return this.segments[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/Uri$PathSegmentsBuilder.class */
    public static class PathSegmentsBuilder {
        String[] segments;
        int size = 0;

        PathSegmentsBuilder() {
        }

        void add(String str) {
            if (this.segments == null) {
                this.segments = new String[4];
            } else if (this.size + 1 == this.segments.length) {
                String[] strArr = new String[this.segments.length * 2];
                System.arraycopy(this.segments, 0, strArr, 0, this.segments.length);
                this.segments = strArr;
            }
            String[] strArr2 = this.segments;
            int i = this.size;
            this.size = i + 1;
            strArr2[i] = str;
        }

        PathSegments build() {
            if (this.segments == null) {
                return PathSegments.EMPTY;
            }
            try {
                return new PathSegments(this.segments, this.size);
            } finally {
                this.segments = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/net/Uri$StringUri.class */
    public static class StringUri extends AbstractHierarchicalUri {
        static final int TYPE_ID = 1;
        private Part authority;
        private volatile int cachedFsi;
        private volatile int cachedSsi;
        private Part fragment;
        private PathPart path;
        private Part query;
        private volatile String scheme;
        private Part ssp;
        private final String uriString;

        private StringUri(String str) {
            super();
            this.cachedSsi = -2;
            this.cachedFsi = -2;
            this.scheme = Uri.NOT_CACHED;
            if (str == null) {
                throw new NullPointerException("uriString");
            }
            this.uriString = str;
        }

        private int findFragmentSeparator() {
            if (this.cachedFsi == -2) {
                int indexOf = this.uriString.indexOf(35, findSchemeSeparator());
                this.cachedFsi = indexOf;
                return indexOf;
            }
            return this.cachedFsi;
        }

        private int findSchemeSeparator() {
            if (this.cachedSsi == -2) {
                int indexOf = this.uriString.indexOf(58);
                this.cachedSsi = indexOf;
                return indexOf;
            }
            return this.cachedSsi;
        }

        private Part getAuthorityPart() {
            if (this.authority == null) {
                Part fromEncoded = Part.fromEncoded(parseAuthority(this.uriString, findSchemeSeparator()));
                this.authority = fromEncoded;
                return fromEncoded;
            }
            return this.authority;
        }

        private Part getFragmentPart() {
            if (this.fragment == null) {
                Part fromEncoded = Part.fromEncoded(parseFragment());
                this.fragment = fromEncoded;
                return fromEncoded;
            }
            return this.fragment;
        }

        private PathPart getPathPart() {
            if (this.path == null) {
                PathPart fromEncoded = PathPart.fromEncoded(parsePath());
                this.path = fromEncoded;
                return fromEncoded;
            }
            return this.path;
        }

        private Part getQueryPart() {
            if (this.query == null) {
                Part fromEncoded = Part.fromEncoded(parseQuery());
                this.query = fromEncoded;
                return fromEncoded;
            }
            return this.query;
        }

        private Part getSsp() {
            if (this.ssp == null) {
                Part fromEncoded = Part.fromEncoded(parseSsp());
                this.ssp = fromEncoded;
                return fromEncoded;
            }
            return this.ssp;
        }

        static String parseAuthority(String str, int i) {
            int i2;
            int length = str.length();
            if (length > i + 2 && str.charAt(i + 1) == '/' && str.charAt(i + 2) == '/') {
                int i3 = i;
                int i4 = 3;
                while (true) {
                    i2 = i3 + i4;
                    if (i2 < length) {
                        switch (str.charAt(i2)) {
                            case '#':
                            case '/':
                            case '?':
                                break;
                            default:
                                i3 = i2;
                                i4 = 1;
                        }
                    }
                }
                return str.substring(i + 3, i2);
            }
            return null;
        }

        private String parseFragment() {
            int findFragmentSeparator = findFragmentSeparator();
            if (findFragmentSeparator == -1) {
                return null;
            }
            return this.uriString.substring(findFragmentSeparator + 1);
        }

        private String parsePath() {
            String str = this.uriString;
            int findSchemeSeparator = findSchemeSeparator();
            if (findSchemeSeparator > -1) {
                if ((findSchemeSeparator + 1 == str.length()) || str.charAt(findSchemeSeparator + 1) != '/') {
                    return null;
                }
            }
            return parsePath(str, findSchemeSeparator);
        }

        static String parsePath(String str, int i) {
            int i2;
            int i3;
            int length = str.length();
            if (length > i + 2 && str.charAt(i + 1) == '/' && str.charAt(i + 2) == '/') {
                int i4 = i;
                int i5 = 3;
                while (true) {
                    int i6 = i4 + i5;
                    i2 = i6;
                    if (i6 < length) {
                        i2 = i6;
                        switch (str.charAt(i6)) {
                            case '#':
                            case '?':
                                return "";
                            case '/':
                                break;
                            default:
                                i4 = i6;
                                i5 = 1;
                        }
                    }
                }
            } else {
                i2 = i + 1;
            }
            int i7 = i2;
            while (true) {
                i3 = i7;
                if (i3 < length) {
                    switch (str.charAt(i3)) {
                        case '#':
                        case '?':
                            break;
                        default:
                            i7 = i3 + 1;
                    }
                }
            }
            return str.substring(i2, i3);
        }

        private String parseQuery() {
            int indexOf = this.uriString.indexOf(63, findSchemeSeparator());
            if (indexOf == -1) {
                return null;
            }
            int findFragmentSeparator = findFragmentSeparator();
            if (findFragmentSeparator == -1) {
                return this.uriString.substring(indexOf + 1);
            }
            if (findFragmentSeparator >= indexOf) {
                return this.uriString.substring(indexOf + 1, findFragmentSeparator);
            }
            return null;
        }

        private String parseScheme() {
            int findSchemeSeparator = findSchemeSeparator();
            if (findSchemeSeparator == -1) {
                return null;
            }
            return this.uriString.substring(0, findSchemeSeparator);
        }

        private String parseSsp() {
            int findSchemeSeparator = findSchemeSeparator();
            int findFragmentSeparator = findFragmentSeparator();
            return findFragmentSeparator == -1 ? this.uriString.substring(findSchemeSeparator + 1) : this.uriString.substring(findSchemeSeparator + 1, findFragmentSeparator);
        }

        static Uri readFrom(Parcel parcel) {
            return new StringUri(parcel.readString());
        }

        @Override // android.net.Uri
        public Builder buildUpon() {
            return isHierarchical() ? new Builder().scheme(getScheme()).authority(getAuthorityPart()).path(getPathPart()).query(getQueryPart()).fragment(getFragmentPart()) : new Builder().scheme(getScheme()).opaquePart(getSsp()).fragment(getFragmentPart());
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.net.Uri
        public String getAuthority() {
            return getAuthorityPart().getDecoded();
        }

        @Override // android.net.Uri
        public String getEncodedAuthority() {
            return getAuthorityPart().getEncoded();
        }

        @Override // android.net.Uri
        public String getEncodedFragment() {
            return getFragmentPart().getEncoded();
        }

        @Override // android.net.Uri
        public String getEncodedPath() {
            return getPathPart().getEncoded();
        }

        @Override // android.net.Uri
        public String getEncodedQuery() {
            return getQueryPart().getEncoded();
        }

        @Override // android.net.Uri
        public String getEncodedSchemeSpecificPart() {
            return getSsp().getEncoded();
        }

        @Override // android.net.Uri
        public String getFragment() {
            return getFragmentPart().getDecoded();
        }

        @Override // android.net.Uri
        public String getPath() {
            return getPathPart().getDecoded();
        }

        @Override // android.net.Uri
        public List<String> getPathSegments() {
            return getPathPart().getPathSegments();
        }

        @Override // android.net.Uri
        public String getQuery() {
            return getQueryPart().getDecoded();
        }

        @Override // android.net.Uri
        public String getScheme() {
            if (this.scheme != Uri.NOT_CACHED) {
                return this.scheme;
            }
            String parseScheme = parseScheme();
            this.scheme = parseScheme;
            return parseScheme;
        }

        @Override // android.net.Uri
        public String getSchemeSpecificPart() {
            return getSsp().getDecoded();
        }

        @Override // android.net.Uri
        public boolean isHierarchical() {
            int findSchemeSeparator = findSchemeSeparator();
            if (findSchemeSeparator == -1) {
                return true;
            }
            return this.uriString.length() != findSchemeSeparator + 1 && this.uriString.charAt(findSchemeSeparator + 1) == '/';
        }

        @Override // android.net.Uri
        public boolean isRelative() {
            return findSchemeSeparator() == -1;
        }

        @Override // android.net.Uri
        public String toString() {
            return this.uriString;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(1);
            parcel.writeString(this.uriString);
        }
    }

    private Uri() {
    }

    public static String decode(String str) {
        if (str == null) {
            return null;
        }
        return UriCodec.decode(str, false, StandardCharsets.UTF_8, false);
    }

    public static String encode(String str) {
        return encode(str, null);
    }

    public static String encode(String str, String str2) {
        String str3;
        int i;
        if (str == null) {
            str3 = null;
        } else {
            StringBuilder sb = null;
            int length = str.length();
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    int i3 = i2;
                    while (true) {
                        i = i3;
                        if (i >= length || !isAllowed(str.charAt(i), str2)) {
                            break;
                        }
                        i3 = i + 1;
                    }
                    if (i == length) {
                        str3 = str;
                        if (i2 != 0) {
                            sb.append((CharSequence) str, i2, length);
                            return sb.toString();
                        }
                    } else {
                        StringBuilder sb2 = sb;
                        if (sb == null) {
                            sb2 = new StringBuilder();
                        }
                        if (i > i2) {
                            sb2.append((CharSequence) str, i2, i);
                        }
                        int i4 = i;
                        while (true) {
                            i2 = i4 + 1;
                            if (i2 >= length || isAllowed(str.charAt(i2), str2)) {
                                break;
                            }
                            i4 = i2;
                        }
                        try {
                            byte[] bytes = str.substring(i, i2).getBytes("UTF-8");
                            int length2 = bytes.length;
                            int i5 = 0;
                            while (true) {
                                int i6 = i5;
                                if (i6 < length2) {
                                    sb2.append('%');
                                    sb2.append(HEX_DIGITS[(bytes[i6] & 240) >> 4]);
                                    sb2.append(HEX_DIGITS[bytes[i6] & 15]);
                                    i5 = i6 + 1;
                                }
                            }
                            sb = sb2;
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                } else {
                    str3 = str;
                    if (sb != null) {
                        return sb.toString();
                    }
                }
            }
        }
        return str3;
    }

    public static Uri fromFile(File file) {
        if (file == null) {
            throw new NullPointerException(ContentResolver.SCHEME_FILE);
        }
        return new HierarchicalUri(ContentResolver.SCHEME_FILE, Part.EMPTY, PathPart.fromDecoded(file.getAbsolutePath()), Part.NULL, Part.NULL);
    }

    public static Uri fromParts(String str, String str2, String str3) {
        if (str == null) {
            throw new NullPointerException("scheme");
        }
        if (str2 == null) {
            throw new NullPointerException("ssp");
        }
        return new OpaqueUri(str, Part.fromDecoded(str2), Part.fromDecoded(str3));
    }

    private static boolean isAllowed(char c2, String str) {
        if (c2 < 'A' || c2 > 'Z') {
            if (c2 < 'a' || c2 > 'z') {
                if ((c2 < '0' || c2 > '9') && "_-!.~'()*".indexOf(c2) == -1) {
                    return (str == null || str.indexOf(c2) == -1) ? false : true;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    public static Uri parse(String str) {
        return new StringUri(str);
    }

    public static Uri withAppendedPath(Uri uri, String str) {
        return uri.buildUpon().appendEncodedPath(str).build();
    }

    public static void writeToParcel(Parcel parcel, Uri uri) {
        if (uri == null) {
            parcel.writeInt(0);
        } else {
            uri.writeToParcel(parcel, 0);
        }
    }

    public abstract Builder buildUpon();

    public void checkFileUriExposed(String str) {
        if (ContentResolver.SCHEME_FILE.equals(getScheme())) {
            StrictMode.onFileUriExposed(str);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Uri uri) {
        return toString().compareTo(uri.toString());
    }

    public boolean equals(Object obj) {
        if (obj instanceof Uri) {
            return toString().equals(((Uri) obj).toString());
        }
        return false;
    }

    public abstract String getAuthority();

    public boolean getBooleanQueryParameter(String str, boolean z) {
        String queryParameter = getQueryParameter(str);
        if (queryParameter == null) {
            return z;
        }
        String lowerCase = queryParameter.toLowerCase(Locale.ROOT);
        return ("false".equals(lowerCase) || "0".equals(lowerCase)) ? false : true;
    }

    public Uri getCanonicalUri() {
        Uri uri = this;
        if (ContentResolver.SCHEME_FILE.equals(getScheme())) {
            try {
                String canonicalPath = new File(getPath()).getCanonicalPath();
                if (Environment.isExternalStorageEmulated()) {
                    String file = Environment.getLegacyExternalStorageDirectory().toString();
                    if (canonicalPath.startsWith(file)) {
                        uri = fromFile(new File(Environment.getExternalStorageDirectory().toString(), canonicalPath.substring(file.length() + 1)));
                    }
                }
                return fromFile(new File(canonicalPath));
            } catch (IOException e) {
                return this;
            }
        }
        return uri;
    }

    public abstract String getEncodedAuthority();

    public abstract String getEncodedFragment();

    public abstract String getEncodedPath();

    public abstract String getEncodedQuery();

    public abstract String getEncodedSchemeSpecificPart();

    public abstract String getEncodedUserInfo();

    public abstract String getFragment();

    public abstract String getHost();

    public abstract String getLastPathSegment();

    public abstract String getPath();

    public abstract List<String> getPathSegments();

    public abstract int getPort();

    public abstract String getQuery();

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:
        if (r0 == (-1)) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getQueryParameter(java.lang.String r7) {
        /*
            r6 = this;
            r0 = r6
            boolean r0 = r0.isOpaque()
            if (r0 == 0) goto L11
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            r1 = r0
            java.lang.String r2 = "This isn't a hierarchical URI."
            r1.<init>(r2)
            throw r0
        L11:
            r0 = r7
            if (r0 != 0) goto L20
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r1 = r0
            java.lang.String r2 = "key"
            r1.<init>(r2)
            throw r0
        L20:
            r0 = r6
            java.lang.String r0 = r0.getEncodedQuery()
            r14 = r0
            r0 = r14
            if (r0 != 0) goto L2d
        L2b:
            r0 = 0
            return r0
        L2d:
            r0 = r7
            r1 = 0
            java.lang.String r0 = encode(r0, r1)
            r7 = r0
            r0 = r14
            int r0 = r0.length()
            r11 = r0
            r0 = 0
            r9 = r0
        L3c:
            r0 = r14
            r1 = 38
            r2 = r9
            int r0 = r0.indexOf(r1, r2)
            r12 = r0
            r0 = r12
            r1 = -1
            if (r0 == r1) goto L90
            r0 = r12
            r8 = r0
        L4f:
            r0 = r14
            r1 = 61
            r2 = r9
            int r0 = r0.indexOf(r1, r2)
            r13 = r0
            r0 = r13
            r1 = r8
            if (r0 > r1) goto L69
            r0 = r13
            r10 = r0
            r0 = r13
            r1 = -1
            if (r0 != r1) goto L6c
        L69:
            r0 = r8
            r10 = r0
        L6c:
            r0 = r10
            r1 = r9
            int r0 = r0 - r1
            r1 = r7
            int r1 = r1.length()
            if (r0 != r1) goto La9
            r0 = r14
            r1 = r9
            r2 = r7
            r3 = 0
            r4 = r7
            int r4 = r4.length()
            boolean r0 = r0.regionMatches(r1, r2, r3, r4)
            if (r0 == 0) goto La9
            r0 = r10
            r1 = r8
            if (r0 != r1) goto L96
            java.lang.String r0 = ""
            return r0
        L90:
            r0 = r11
            r8 = r0
            goto L4f
        L96:
            r0 = r14
            r1 = r10
            r2 = 1
            int r1 = r1 + r2
            r2 = r8
            java.lang.String r0 = r0.substring(r1, r2)
            r1 = 1
            java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.UTF_8
            r3 = 0
            java.lang.String r0 = libcore.net.UriCodec.decode(r0, r1, r2, r3)
            return r0
        La9:
            r0 = r12
            r1 = -1
            if (r0 == r1) goto L2b
            r0 = r12
            r1 = 1
            int r0 = r0 + r1
            r9 = r0
            goto L3c
        */
        throw new UnsupportedOperationException("Method not decompiled: android.net.Uri.getQueryParameter(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
        if (r0 == (-1)) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Set<java.lang.String> getQueryParameterNames() {
        /*
            r5 = this;
            r0 = r5
            boolean r0 = r0.isOpaque()
            if (r0 == 0) goto L11
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            r1 = r0
            java.lang.String r2 = "This isn't a hierarchical URI."
            r1.<init>(r2)
            throw r0
        L11:
            r0 = r5
            java.lang.String r0 = r0.getEncodedQuery()
            r10 = r0
            r0 = r10
            if (r0 != 0) goto L20
            java.util.Set r0 = java.util.Collections.emptySet()
            return r0
        L20:
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r1 = r0
            r1.<init>()
            r11 = r0
            r0 = 0
            r7 = r0
        L2b:
            r0 = r10
            r1 = 38
            r2 = r7
            int r0 = r0.indexOf(r1, r2)
            r6 = r0
            r0 = r6
            r1 = -1
            if (r0 != r1) goto L81
            r0 = r10
            int r0 = r0.length()
            r6 = r0
        L3f:
            r0 = r10
            r1 = 61
            r2 = r7
            int r0 = r0.indexOf(r1, r2)
            r9 = r0
            r0 = r9
            r1 = r6
            if (r0 > r1) goto L58
            r0 = r9
            r8 = r0
            r0 = r9
            r1 = -1
            if (r0 != r1) goto L5a
        L58:
            r0 = r6
            r8 = r0
        L5a:
            r0 = r11
            r1 = r10
            r2 = r7
            r3 = r8
            java.lang.String r1 = r1.substring(r2, r3)
            java.lang.String r1 = decode(r1)
            boolean r0 = r0.add(r1)
            r0 = r6
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
            r0 = r6
            r7 = r0
            r0 = r6
            r1 = r10
            int r1 = r1.length()
            if (r0 < r1) goto L2b
            r0 = r11
            java.util.Set r0 = java.util.Collections.unmodifiableSet(r0)
            return r0
        L81:
            goto L3f
        */
        throw new UnsupportedOperationException("Method not decompiled: android.net.Uri.getQueryParameterNames():java.util.Set");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
        if (r0 == (-1)) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<java.lang.String> getQueryParameters(java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.net.Uri.getQueryParameters(java.lang.String):java.util.List");
    }

    public abstract String getScheme();

    public abstract String getSchemeSpecificPart();

    public abstract String getUserInfo();

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isAbsolute() {
        return !isRelative();
    }

    public abstract boolean isHierarchical();

    public boolean isOpaque() {
        return !isHierarchical();
    }

    public boolean isPathPrefixMatch(Uri uri) {
        if (!Objects.equals(getScheme(), uri.getScheme()) || !Objects.equals(getAuthority(), uri.getAuthority())) {
            return false;
        }
        List<String> pathSegments = getPathSegments();
        List<String> pathSegments2 = uri.getPathSegments();
        int size = pathSegments2.size();
        if (pathSegments.size() < size) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return true;
            }
            if (!Objects.equals(pathSegments.get(i2), pathSegments2.get(i2))) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public abstract boolean isRelative();

    public Uri normalizeScheme() {
        String scheme = getScheme();
        if (scheme != null) {
            String lowerCase = scheme.toLowerCase(Locale.ROOT);
            if (!scheme.equals(lowerCase)) {
                return buildUpon().scheme(lowerCase).build();
            }
        }
        return this;
    }

    public String toSafeString() {
        String scheme = getScheme();
        String schemeSpecificPart = getSchemeSpecificPart();
        if (scheme == null || !(scheme.equalsIgnoreCase(PhoneAccount.SCHEME_TEL) || scheme.equalsIgnoreCase("sip") || scheme.equalsIgnoreCase("sms") || scheme.equalsIgnoreCase(PhoneAccount.SCHEME_SMSTO) || scheme.equalsIgnoreCase("mailto"))) {
            StringBuilder sb = new StringBuilder(64);
            if (scheme != null) {
                sb.append(scheme);
                sb.append(':');
            }
            if (schemeSpecificPart != null) {
                sb.append(schemeSpecificPart);
            }
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append(scheme);
        sb2.append(':');
        if (schemeSpecificPart != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= schemeSpecificPart.length()) {
                    break;
                }
                char charAt = schemeSpecificPart.charAt(i2);
                if (charAt == '-' || charAt == '@' || charAt == '.') {
                    sb2.append(charAt);
                } else {
                    sb2.append('x');
                }
                i = i2 + 1;
            }
        }
        return sb2.toString();
    }

    public abstract String toString();
}
