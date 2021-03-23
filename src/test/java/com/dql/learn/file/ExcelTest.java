package com.dql.learn.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dengquanliang
 * Created on 2021/3/22
 */
public class ExcelTest {
    public static final List<String> HEADER = Arrays.asList("姓名", "年龄", "性别");
    @Test
    public void writeToExcel() throws IOException {
        String fileName = "/tmp/下载excel测试1.xlsx";
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileName);
            ExcelWriter writer = EasyExcel.write(outputStream).build();
            WriteSheet sheet = EasyExcel.writerSheet("测试").build();
            WriteTable writeTable = EasyExcel.writerTable().build();
            writeTable.setHead(getHeader());
            writer.write(getData(), sheet, writeTable);
            writer.finish();
        } catch (FileNotFoundException e) {
            throw e;
        }finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public static List<WriteModel> getData() {
        List<WriteModel> data = new ArrayList<>();
        data.add(new WriteModel("mai", 23, "男"));
        data.add(new WriteModel("deng", 22, "男"));
        data.add(new WriteModel("lian", 20, "男"));
        return data;
    }

    public static List<List<String>> getHeader() {
        List<List<String>> header = new ArrayList<>();
        HEADER.forEach(head -> {
            header.add(Arrays.asList(head));
        });
        return header;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class WriteModel {
    @ExcelProperty(value = "姓名")
    private String name;
    @ExcelProperty(value = "年龄")
    private int age;
    @ExcelProperty(value = "性别")
    private String sex;
}
