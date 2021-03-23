package com.dql.learn.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author dengquanliang
 * Created on 2020/12/10
 */
public class MultipartFileTest {

    private final String FILE_PATH = "/Users/dengquanliang/PycharmProjects/test_w.xls";

    @Test
    public void test01() throws IOException {
        File file = new File(FILE_PATH);
        FileInputStream fileInputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile("copy_" + file.getName(), file.getName(), ".xls", fileInputStream);
        System.out.println(multipartFile.getOriginalFilename());
        System.out.println(multipartFile.getName());
    }

}
