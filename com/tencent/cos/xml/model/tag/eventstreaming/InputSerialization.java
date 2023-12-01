package com.tencent.cos.xml.model.tag.eventstreaming;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cos/xml/model/tag/eventstreaming/InputSerialization.class */
public class InputSerialization {
    private String compressionType;
    private CSVInput csv;
    private JSONInput json;
    private ParquetInput parquet;

    public InputSerialization(CompressionType compressionType, CSVInput cSVInput) {
        this.csv = cSVInput;
        this.compressionType = compressionType.toString();
    }

    public InputSerialization(CompressionType compressionType, JSONInput jSONInput) {
        this.compressionType = compressionType.toString();
        this.json = jSONInput;
    }

    public InputSerialization(String str, CSVInput cSVInput) {
        this.csv = cSVInput;
        this.compressionType = str;
    }

    public InputSerialization(String str, JSONInput jSONInput) {
        this.compressionType = str;
        this.json = jSONInput;
    }

    /* renamed from: clone */
    public InputSerialization m7149clone() {
        try {
            return (InputSerialization) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InputSerialization)) {
            return false;
        }
        InputSerialization inputSerialization = (InputSerialization) obj;
        if ((inputSerialization.getCsv() == null) ^ (getCsv() == null)) {
            return false;
        }
        if (inputSerialization.getCsv() == null || inputSerialization.getCsv().equals(getCsv())) {
            if ((inputSerialization.getJson() == null) ^ (getJson() == null)) {
                return false;
            }
            if (inputSerialization.getJson() == null || inputSerialization.getJson().equals(getJson())) {
                if ((inputSerialization.getCompressionType() == null) ^ (getCompressionType() == null)) {
                    return false;
                }
                return inputSerialization.getCompressionType() == null || inputSerialization.getCompressionType().equals(getCompressionType());
            }
            return false;
        }
        return false;
    }

    public String getCompressionType() {
        return this.compressionType;
    }

    public CSVInput getCsv() {
        return this.csv;
    }

    public JSONInput getJson() {
        return this.json;
    }

    public ParquetInput getParquet() {
        return this.parquet;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = getCsv() == null ? 0 : getCsv().hashCode();
        int hashCode2 = getJson() == null ? 0 : getJson().hashCode();
        if (getCompressionType() != null) {
            i = getCompressionType().hashCode();
        }
        return ((((hashCode + 31) * 31) + hashCode2) * 31) + i;
    }

    public void setCompressionType(CompressionType compressionType) {
        setCompressionType(compressionType == null ? null : compressionType.toString());
    }

    public void setCompressionType(String str) {
        this.compressionType = str;
    }

    public void setCsv(CSVInput cSVInput) {
        this.csv = cSVInput;
    }

    public void setJson(JSONInput jSONInput) {
        this.json = jSONInput;
    }

    public void setParquet(ParquetInput parquetInput) {
        this.parquet = parquetInput;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCsv() != null) {
            sb.append("Csv: ");
            sb.append(getCsv());
        }
        if (getJson() != null) {
            sb.append("Json: ");
            sb.append(getJson());
        }
        if (getCompressionType() != null) {
            sb.append("CompressionType: ");
            sb.append(getCompressionType());
        }
        sb.append("}");
        return sb.toString();
    }

    public InputSerialization withCompressionType(CompressionType compressionType) {
        setCompressionType(compressionType);
        return this;
    }

    public InputSerialization withCompressionType(String str) {
        setCompressionType(str);
        return this;
    }

    public InputSerialization withCsv(CSVInput cSVInput) {
        setCsv(cSVInput);
        return this;
    }

    public InputSerialization withJson(JSONInput jSONInput) {
        setJson(jSONInput);
        return this;
    }

    public InputSerialization withParquet(ParquetInput parquetInput) {
        setParquet(parquetInput);
        return this;
    }
}
