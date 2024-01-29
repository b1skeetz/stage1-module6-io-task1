package com.epam.mjc.io;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\damir\\IdeaProjects\\stage1-module6-io-task1\\src\\main\\resources\\Profile.txt");
        FileReader fileReader = new FileReader();
        Profile profile = fileReader.getDataFromFile(file);
        System.out.println(profile);
    }
}
