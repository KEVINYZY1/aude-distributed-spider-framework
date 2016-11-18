package setting;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
/**
 * Created by lrkin on 2016/11/16.
 * <p>
 * 读取配置文件,返回配置文件对象
 */
public class SettingReader {
    public static SettingObject read(String file) {
        Gson gson = new Gson();
        SettingObject object = gson.fromJson(readFile(file), SettingObject.class);
        return object;
    }

    public static String readFile(String filename) {
        String ret = "";
        File file = new File(filename);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            StringBuffer buffer = new StringBuffer();
            while ((tempString = reader.readLine()) != null) {
                buffer.append(tempString);
            }
            ret = buffer.toString();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }
}
