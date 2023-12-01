package com.tencent.cos.xml.model.tag;

import com.alipay.sdk.util.i;
import java.util.Set;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/ListInventoryConfiguration.class */
public class ListInventoryConfiguration {
    public String continuationToken;
    public Set<InventoryConfiguration> inventoryConfigurations;
    public boolean isTruncated = false;
    public String nextContinuationToken;

    public String toString() {
        StringBuilder sb = new StringBuilder("{ListInventoryConfigurationResult\n");
        sb.append("IsTruncated:");
        sb.append(this.isTruncated);
        sb.append("\n");
        if (this.continuationToken != null) {
            sb.append("ContinuationToken:");
            sb.append(this.continuationToken);
            sb.append("\n");
        }
        if (this.nextContinuationToken != null) {
            sb.append("NextContinuationToken:");
            sb.append(this.nextContinuationToken);
            sb.append("\n");
        }
        Set<InventoryConfiguration> set = this.inventoryConfigurations;
        if (set != null) {
            for (InventoryConfiguration inventoryConfiguration : set) {
                if (inventoryConfiguration != null) {
                    sb.append(inventoryConfiguration.toString());
                    sb.append("\n");
                }
            }
        }
        sb.append(i.d);
        return sb.toString();
    }
}
