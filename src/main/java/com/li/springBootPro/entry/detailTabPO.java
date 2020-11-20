package com.li.springBootPro.entry;

public class detailTabPO {
    private Integer id;

    private String code;

    private String serializeId;

    private String period;

    private String info;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getSerializeId() {
        return serializeId;
    }

    public void setSerializeId(String serializeId) {
        this.serializeId = serializeId == null ? null : serializeId.trim();
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}