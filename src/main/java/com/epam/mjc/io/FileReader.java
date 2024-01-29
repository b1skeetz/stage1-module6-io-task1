package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder content = new StringBuilder();
        Profile profile = new Profile();
        try(FileInputStream readFromFile = new FileInputStream(file.getAbsolutePath())){
            int ch;
            while((ch = readFromFile.read()) != -1){
                content.append((char)ch);
            }
            Map<String, String> data = new HashMap<>();
            String[] parsedData = String.valueOf(content).split("[:\n]");
            for(int i = 0; i < parsedData.length; i+=2){
                data.put(parsedData[i], parsedData[i+1].trim());
            }
            profile.setName(data.get("Name"));
            profile.setAge(Integer.valueOf(data.get("Age")));
            profile.setEmail(data.get("Email"));
            profile.setPhone(Long.valueOf(data.get("Phone")));
        } catch (FileNotFoundException e){
            System.out.printf("File \"%s\" is not found!%n", file.getName());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return profile;
    }
}