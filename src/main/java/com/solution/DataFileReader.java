package com.solution;

import com.solution.mapper.DataMapper;
import com.solution.model.Address;
import com.solution.model.HierarchyLink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFileReader {
    public static List<Address> readAddresses(String path) throws IOException {
        List<Address> addresses = new ArrayList<>();

        ClassLoader classLoader = DataFileReader.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        String string;
        while ((string = br.readLine()) != null) {
            int index = string.indexOf("ID=");
            if (index >= 0) {
                string = string.substring(index, string.length() - 3);
                String[] parts = string.split("\" ");
                Map<String, String> objectData = new HashMap<>();
                for (String s : parts) {
                    String[] keyToValue = s.split("=");
                    objectData.put(keyToValue[0], keyToValue[1].replace("\"", ""));
                }
                addresses.add(DataMapper.toAddress(objectData));
            }
        }
        return addresses;
    }

    public static List<HierarchyLink> readHierarchyLinks(String path) throws IOException {
        List<HierarchyLink> hierarchyLinks = new ArrayList<>();

        ClassLoader classLoader = DataFileReader.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        String string;
        while ((string = br.readLine()) != null) {
            int index = string.indexOf("ID=");
            if (index >= 0) {
                string = string.substring(index, string.length() - 3);
                String[] parts = string.split("\" ");
                Map<String, String> objectData = new HashMap<>();
                for (String s : parts) {
                    String[] keyToValue = s.split("=");
                    objectData.put(keyToValue[0], keyToValue[1].replace("\"", ""));
                }
                hierarchyLinks.add(DataMapper.toHierarchyLink(objectData));
            }
        }
        return hierarchyLinks;
    }
}
