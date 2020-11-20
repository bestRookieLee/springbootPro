package com.li.springBootPro.entry;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class serializeIdDTO extends serializeIdTabPO{
    List<detailTabPO> detailTabPOList = new ArrayList<>();
}
