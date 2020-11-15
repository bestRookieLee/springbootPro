package com.li.springBootPro.entry;

import lombok.Data;

import java.util.Date;

@Data
public class MlisFirstSupplierInfoPO {
    private String id;

    private String enterpriseId;

    private String businessScope;

    private String enterpriseName;

    private String enterpriseCategory;

    private String contactPerson;

    private String contactTel;

    private String email;

    private String accountName;

    private String accountBank;

    private String account;

    private String taxNo;

    private String status;

    private String mrgCategory;

    private String entrustEnterpriseId;

    private String entrustEnterpriseName;

    private String residence;

    private String sort;

    private String inUse;

    private String recordPerson;

    private String expiredFlag;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private String delFlag;

    private String remarks;

    private byte[] supplierNo;
}