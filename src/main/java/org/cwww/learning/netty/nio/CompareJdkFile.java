package org.cwww.learning.netty.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * 比较JDK Nio与 JDK io的区别,
 *
 * @author wei.cai@hand-china.com
 * @date 2022/7/6
 */
@Slf4j
public class CompareJdkFile {


    public static void main(String[] args) throws Exception {
        final URL resource = CompareJdkFile.class.getResource("/Demo.txt");

        if (null == resource) {
            log.warn("resource can not be null");
            return;
        }

        final File file = new File(resource.getFile());

        try (final FileInputStream bis = new FileInputStream(file)) {
            final String result = new String(bis.readAllBytes(), StandardCharsets.UTF_8);
            log.info(result);
        } catch (IOException e) {



        }
    }

}
