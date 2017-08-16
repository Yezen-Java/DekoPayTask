package com.company;


import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Users users = new Users();
        users.traverseDirectory("data");
        users.generateFiles();

    }
    }

