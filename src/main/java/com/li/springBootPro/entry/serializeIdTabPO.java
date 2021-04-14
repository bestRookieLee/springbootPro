package com.li.springBootPro.entry;

public class serializeIdTabPO {
    private Integer id;

    private String code;

    private String parentCode;

    private String serializeId;

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
}