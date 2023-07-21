package com.solution;

import com.solution.model.Address;
import com.solution.model.HierarchyLink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("\n\u001B[34mWelcome to AddressKeeper App!\u001B[0m");

        List<Address> addresses = DataFileReader.readAddresses(
                "AS_ADDR_OBJ.XML");
        List<HierarchyLink> hierarchyLinks = DataFileReader.readHierarchyLinks(
                "AS_ADM_HIERARCHY.XML");

        label:
        while (true) {
            System.out.println("\nSelect mode: ");
            System.out.println("1: type name + name BY object ID");
            System.out.println("2: chain of addresses in a hierarchy BY type name");
            System.out.println("0: exit");

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String mode = br.readLine();
            switch (mode) {
                case "1":
                    AddressSearcher.firstMode(addresses);
                    break;
                case "2":
                    AddressSearcher.secondMode(addresses, hierarchyLinks);
                    break;
                case "0":
                    System.out.println("\n\u001B[34mGoodbye\u001B[0m");
                    br.close();
                    break label;
                default:
                    System.out.println("\n\u001B[31mWRONG INPUT\u001B[0m");
                    break;
            }
        }
    }
}