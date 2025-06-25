package utilities;

import java.util.Base64;
import java.nio.charset.StandardCharsets;

public class Base64Helper {

    /**
     * 对 Base64 编码的字符串进行解密
     *
     * @param base64String Base64 编码的字符串
     * @return 原始字符串
     */
    public static String decodeString(String base64String) {
        // 使用 Base64 解码器
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);
        // 将字节数组转换为字符串（使用 UTF-8 编码）
        return new String(decodedBytes, StandardCharsets.UTF_8);
    }


}
