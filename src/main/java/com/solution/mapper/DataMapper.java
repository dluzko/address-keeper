package com.solution.mapper;

import com.solution.model.Address;
import com.solution.model.HierarchyLink;

import java.time.LocalDate;
import java.util.Map;

public class DataMapper {
    public static Address toAddress(Map<String, String> objectData) {
        Address address = new Address();
        address.setId(Integer.parseInt(objectData.get("ID")));
        address.setObjectId(Integer.parseInt(objectData.get("OBJECTID")));
        address.setObjectGuid(objectData.get("OBJECTGUID"));
        address.setChangeId(objectData.get("CHANGEID"));
        address.setName(objectData.get("NAME"));
        address.setTypeName(objectData.get("TYPENAME"));
        address.setLevel(Integer.parseInt(objectData.get("LEVEL")));
        address.setOperTypeId(Integer.parseInt(objectData.get("OPERTYPEID")));
        address.setPrevId(Integer.parseInt(objectData.get("PREVID")));
        address.setNextId(objectData.get("NEXTID") == null ? 0 : Integer.parseInt(objectData.get("NEXTID")));
        address.setUpdateDate(LocalDate.parse(objectData.get("UPDATEDATE")));
        address.setStartDate(LocalDate.parse(objectData.get("STARTDATE")));
        address.setEndDate(LocalDate.parse(objectData.get("ENDDATE")));
        address.setIsActual(Integer.parseInt(objectData.get("ISACTUAL")));
        address.setIsActive(Integer.parseInt(objectData.get("ISACTIVE")));
        return address;
    }

    public static HierarchyLink toHierarchyLink(Map<String, String> objectData) {
        HierarchyLink hierarchyLink = new HierarchyLink();
        hierarchyLink.setId(Integer.parseInt(objectData.get("ID")));
        hierarchyLink.setObjectId(Integer.parseInt(objectData.get("OBJECTID")));
        hierarchyLink.setParentObjId(Integer.parseInt(objectData.get("PARENTOBJID")));
        hierarchyLink.setChangeId(Integer.parseInt(objectData.get("CHANGEID")));
        hierarchyLink.setPrevId(Integer.parseInt(objectData.get("PREVID")));
        hierarchyLink.setNextId(Integer.parseInt(objectData.get("NEXTID")));
        hierarchyLink.setUpdateDate(LocalDate.parse(objectData.get("UPDATEDATE")));
        hierarchyLink.setStartDate(LocalDate.parse(objectData.get("STARTDATE")));
        hierarchyLink.setEndDate(LocalDate.parse(objectData.get("ENDDATE")));
        hierarchyLink.setIsActive(Integer.parseInt(objectData.get("ISACTIVE")));
        return hierarchyLink;
    }
}
