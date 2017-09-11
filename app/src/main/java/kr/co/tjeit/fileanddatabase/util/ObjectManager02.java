package kr.co.tjeit.fileanddatabase.util;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 * Created by tjoeun on 2017-09-11.
 */

public class ObjectManager02 {


    private static final String FILE_NAME = "memo.obj";
    Context mContext;

    public ObjectManager02(Context context){
        mContext = context;
    }

    public void save(HashMap<String, String> objData){
        try {
            FileOutputStream fos = mContext.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objData);
            oos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, String> load(){

        try {
            FileInputStream fis = mContext.openFileInput(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);

            HashMap<String, String> returnMemoData = (HashMap<String, String>)ois.readObject();
            ois.close();
            fis.close();
            return returnMemoData;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void delete(){
        mContext.deleteFile(FILE_NAME);
    }
}
