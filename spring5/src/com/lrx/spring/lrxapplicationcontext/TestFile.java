package com.lrx.spring.lrxapplicationcontext;

import java.io.File;
import java.io.IOException;

public class TestFile {
    public static void main(String[] args) throws IOException {
        File file = new File("d://new.text");

        boolean newFile = file.createNewFile();
    }
}
