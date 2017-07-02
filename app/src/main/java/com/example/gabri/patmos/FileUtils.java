package com.example.gabri.patmos;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStream;

/**
 * Created by gabri on 23/05/2017.
 */

public class FileUtils {

    public static File readFile(String fileName){

        File file =  new File(Environment.getExternalStorageDirectory(), fileName);

        return file;
    }

    public static void save(String fileName, String texto){

        File file =  new File(Environment.getExternalStorageDirectory(), fileName);
       // BufferedWriter outputStream = new BufferedWriter(file);

    }

}
