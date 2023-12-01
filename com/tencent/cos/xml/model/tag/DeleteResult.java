package com.tencent.cos.xml.model.tag;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/DeleteResult.class */
public class DeleteResult {
    public List<Deleted> deletedList;
    public List<Error> errorList;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/DeleteResult$Deleted.class */
    public static class Deleted {
        public boolean deleteMarker;
        public String deleteMarkerVersionId;
        public String key;
        public String versionId;

        public String toString() {
            return "{Deleted:\nKey:" + this.key + "\nVersionId:" + this.versionId + "\nDeleteMarker:" + this.deleteMarker + "\nDeleteMarkerVersionId:" + this.deleteMarkerVersionId + "\n}";
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/DeleteResult$Error.class */
    public static class Error {
        public String code;
        public String key;
        public String message;
        public String versionId;

        public String toString() {
            return "{CosError:\nKey:" + this.key + "\nCode:" + this.code + "\nMessage:" + this.message + "\nVersionId:" + this.versionId + "\n}";
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{DeleteResult:\n");
        List<Deleted> list = this.deletedList;
        if (list != null) {
            for (Deleted deleted : list) {
                if (deleted != null) {
                    sb.append(deleted.toString());
                    sb.append("\n");
                }
            }
        }
        List<Error> list2 = this.errorList;
        if (list2 != null) {
            for (Error error : list2) {
                if (error != null) {
                    sb.append(error.toString());
                    sb.append("\n");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
