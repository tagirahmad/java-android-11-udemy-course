package com.tagirahmad.todoist;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHelper {
    public static final String FILENAME = "listinfo.dat";

    public static void writeData(ArrayList<String> item, Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(item);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> readData(Context context) {
        ArrayList<String> itemList = null;

        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            ObjectInput ois = new ObjectInputStream(fis);

            itemList = (ArrayList<String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            itemList = new ArrayList<>();
            e.printStackTrace();
        }

        return itemList;
    }
}
