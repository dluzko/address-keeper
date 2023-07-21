package com.solution;

import com.solution.model.Address;
import com.solution.model.HierarchyLink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AddressSearcher {
    public static void firstMode(List<Address> addresses) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println();
        System.out.println("Enter date in yyyy-mm-dd format:");
        LocalDate date = LocalDate.parse(br.readLine());

        System.out.println();
        System.out.println("Enter ids:");
        System.out.println("Single example: 1418203");
        System.out.println("Multiple example : 1418203,1422396,1447339");
        String objectIds = br.readLine();

        Set<Integer> ids = new HashSet<>();
        for (String s : objectIds.split(",")) {
            ids.add(Integer.parseInt(s));
        }

        addresses.stream().filter(x -> x.getStartDate().isBefore(date))
                .filter(x -> x.getEndDate().isAfter(date))
                .filter(x -> ids.contains(x.getObjectId()))
                .forEach(x -> System.out.println(x.getObjectId() + ": " + x.getTypeName() + " " + x. getName()));
    }

    public static void secondMode(List<Address> addresses, List<HierarchyLink> hierarchyLinks) throws IOException {
        System.out.println();
        System.out.println("Enter type name:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String typeName = br.readLine();

        List<Address> addressesFilteredByTypeName =
                addresses.stream().filter(x -> x.getTypeName().equals(typeName)).toList();

        Map<Integer, String> addressNameByObjectId = addresses.stream().filter(x -> x.getIsActive() == 1)
                .collect(Collectors.toMap(Address::getObjectId, x -> x.getTypeName() + " " + x.getName()));

        Map<Integer, HierarchyLink> hierarchyLinkByParentObjId =
                hierarchyLinks.stream()
                        .filter(x -> x.getIsActive() == 1)
                        .collect(Collectors.toMap(HierarchyLink::getObjectId, Function.identity()));

        addressesFilteredByTypeName
                .forEach(x -> System.out.println(
                        buildAddressName(
                                addressNameByObjectId,
                                hierarchyLinkByParentObjId,
                                x.getObjectId(),
                                x.getTypeName() + " " + x.getName()))
        );
    }

    private static String buildAddressName(Map<Integer, String> addressNameByObjectId,
                                           Map<Integer, HierarchyLink> hierarchyLinkByParentObjId,
                                           int objectId,
                                           String string) {
        if (hierarchyLinkByParentObjId.containsKey(objectId)) {
            int parentId = hierarchyLinkByParentObjId.get(objectId).getParentObjId();
            if (addressNameByObjectId.get(parentId) != null) {
                return buildAddressName(
                        addressNameByObjectId,
                        hierarchyLinkByParentObjId,
                        parentId,
                        addressNameByObjectId.get(parentId) + ", " + string);
            }
        }
        return string;
    }
}