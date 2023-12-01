package com.tencent.map.sdk.comps.offlinemap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/map/sdk/comps/offlinemap/OfflineItem.class */
public class OfflineItem {
    private String name;
    private int percentage;
    private String pinyin;
    private long size;
    private boolean upgrade = true;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OfflineItem) {
            OfflineItem offlineItem = (OfflineItem) obj;
            String str = this.name;
            if (str != null) {
                if (!str.equals(offlineItem.name)) {
                    return false;
                }
            } else if (offlineItem.name != null) {
                return false;
            }
            String str2 = this.pinyin;
            String str3 = offlineItem.pinyin;
            return str2 != null ? str2.equals(str3) : str3 == null;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public int getPercentage() {
        return this.percentage;
    }

    public String getPinyin() {
        return this.pinyin;
    }

    public long getSize() {
        return this.size;
    }

    public int hashCode() {
        String str = this.name;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.pinyin;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return (hashCode * 31) + i;
    }

    public boolean isUpgrade() {
        return this.upgrade;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPercentage(int i) {
        this.percentage = i;
    }

    public void setPinyin(String str) {
        this.pinyin = str;
    }

    public void setSize(long j) {
        this.size = j;
    }

    public void setUpgrade(boolean z) {
        this.upgrade = z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("OfflineItem{");
        stringBuffer.append("name='");
        stringBuffer.append(this.name);
        stringBuffer.append('\'');
        stringBuffer.append(", pinyin='");
        stringBuffer.append(this.pinyin);
        stringBuffer.append('\'');
        stringBuffer.append(", size=");
        stringBuffer.append(this.size);
        stringBuffer.append(", upgrade=");
        stringBuffer.append(this.upgrade);
        stringBuffer.append(", percentage=");
        stringBuffer.append(this.percentage);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
