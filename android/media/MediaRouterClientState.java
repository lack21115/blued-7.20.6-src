package android.media;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaRouterClientState.class */
public final class MediaRouterClientState implements Parcelable {
    public static final Parcelable.Creator<MediaRouterClientState> CREATOR = new Parcelable.Creator<MediaRouterClientState>() { // from class: android.media.MediaRouterClientState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaRouterClientState createFromParcel(Parcel parcel) {
            return new MediaRouterClientState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MediaRouterClientState[] newArray(int i) {
            return new MediaRouterClientState[i];
        }
    };
    public String globallySelectedRouteId;
    public final ArrayList<RouteInfo> routes;

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaRouterClientState$RouteInfo.class */
    public static final class RouteInfo implements Parcelable {
        public static final Parcelable.Creator<RouteInfo> CREATOR = new Parcelable.Creator<RouteInfo>() { // from class: android.media.MediaRouterClientState.RouteInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RouteInfo createFromParcel(Parcel parcel) {
                return new RouteInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public RouteInfo[] newArray(int i) {
                return new RouteInfo[i];
            }
        };
        public String description;
        public boolean enabled;
        public String id;
        public String name;
        public int playbackStream;
        public int playbackType;
        public int presentationDisplayId;
        public int statusCode;
        public int supportedTypes;
        public int volume;
        public int volumeHandling;
        public int volumeMax;

        public RouteInfo(RouteInfo routeInfo) {
            this.id = routeInfo.id;
            this.name = routeInfo.name;
            this.description = routeInfo.description;
            this.supportedTypes = routeInfo.supportedTypes;
            this.enabled = routeInfo.enabled;
            this.statusCode = routeInfo.statusCode;
            this.playbackType = routeInfo.playbackType;
            this.playbackStream = routeInfo.playbackStream;
            this.volume = routeInfo.volume;
            this.volumeMax = routeInfo.volumeMax;
            this.volumeHandling = routeInfo.volumeHandling;
            this.presentationDisplayId = routeInfo.presentationDisplayId;
        }

        RouteInfo(Parcel parcel) {
            this.id = parcel.readString();
            this.name = parcel.readString();
            this.description = parcel.readString();
            this.supportedTypes = parcel.readInt();
            this.enabled = parcel.readInt() != 0;
            this.statusCode = parcel.readInt();
            this.playbackType = parcel.readInt();
            this.playbackStream = parcel.readInt();
            this.volume = parcel.readInt();
            this.volumeMax = parcel.readInt();
            this.volumeHandling = parcel.readInt();
            this.presentationDisplayId = parcel.readInt();
        }

        public RouteInfo(String str) {
            this.id = str;
            this.enabled = true;
            this.statusCode = 0;
            this.playbackType = 1;
            this.playbackStream = -1;
            this.volumeHandling = 0;
            this.presentationDisplayId = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "RouteInfo{ id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", supportedTypes=0x" + Integer.toHexString(this.supportedTypes) + ", enabled=" + this.enabled + ", statusCode=" + this.statusCode + ", playbackType=" + this.playbackType + ", playbackStream=" + this.playbackStream + ", volume=" + this.volume + ", volumeMax=" + this.volumeMax + ", volumeHandling=" + this.volumeHandling + ", presentationDisplayId=" + this.presentationDisplayId + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.id);
            parcel.writeString(this.name);
            parcel.writeString(this.description);
            parcel.writeInt(this.supportedTypes);
            parcel.writeInt(this.enabled ? 1 : 0);
            parcel.writeInt(this.statusCode);
            parcel.writeInt(this.playbackType);
            parcel.writeInt(this.playbackStream);
            parcel.writeInt(this.volume);
            parcel.writeInt(this.volumeMax);
            parcel.writeInt(this.volumeHandling);
            parcel.writeInt(this.presentationDisplayId);
        }
    }

    public MediaRouterClientState() {
        this.routes = new ArrayList<>();
    }

    MediaRouterClientState(Parcel parcel) {
        this.routes = parcel.createTypedArrayList(RouteInfo.CREATOR);
        this.globallySelectedRouteId = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteInfo getRoute(String str) {
        int size = this.routes.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return null;
            }
            RouteInfo routeInfo = this.routes.get(i2);
            if (routeInfo.id.equals(str)) {
                return routeInfo;
            }
            i = i2 + 1;
        }
    }

    public String toString() {
        return "MediaRouterClientState{ globallySelectedRouteId=" + this.globallySelectedRouteId + ", routes=" + this.routes.toString() + " }";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.routes);
        parcel.writeString(this.globallySelectedRouteId);
    }
}
