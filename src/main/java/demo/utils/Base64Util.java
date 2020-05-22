package demo.utils;

import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

/**
 * @program: yesfp-demo
 * @description:
 * @author: kw
 * @create: 2020/05/22 10:29
 */
public class Base64Util {

    /**
     * 网络图片转换Base64的方法
     * 单线程处理 若批量可以考虑多线程执行
     *
     * @param netImagePath     
     */
    public static String NetImageToBase64(String netImagePath) {
        final ByteArrayOutputStream data = new ByteArrayOutputStream();
        try {
            // 创建URL
            URL url = new URL(netImagePath);
            final byte[] by = new byte[1024];
            // 创建链接
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            InputStream is = conn.getInputStream();
            // 将内容读取内存中
            int len = -1;
            while ((len = is.read(by)) != -1) {
                data.write(by, 0, len);
            }
            // 对字节数组Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            // 关闭流
            is.close();
            return Base64.getEncoder().encodeToString(data.toByteArray());
            //return encoder.encode(data.toByteArray()).replaceAll("\n", "").replaceAll("\r", "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @description:  本地图片转Base64
     * @author: kw
     * @date: 2020/5/22
     * @param: [imgPath]
     * @return: java.lang.String
     */
    public static String imageToBase64(String imgPath) {
        // 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in = null;
        byte[] data = null;
        // 读取图片字节数组
        try {
            in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 返回Base64编码过的字节数组字符串
        //return new BASE64Encoder().encode(data).replaceAll("\n", "").replaceAll("\r", "");
        return Base64.getEncoder().encodeToString(data);
    }
}
