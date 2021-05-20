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
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.WriteTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author dengquanliang
 * Created on 2021/3/22
 */
public class ExcelTest {
    public static final List<String> HEADER = Arrays.asList("性别", "年龄");
    public static final List<String> HEADER1 = Arrays.asList("备注", "姓名", "年龄", "性别", "msg");

    @Test
    public void writeToExcel() throws IOException {
        String fileName = "./file/下载excel测试1.xlsx";
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileName);
            ExcelWriter writer = EasyExcel.write(outputStream).build();
            WriteSheet sheet = EasyExcel.writerSheet("测试").build();
            WriteTable writeTable = EasyExcel.writerTable().build();
            writeTable.setHead(getHeader());
            writer.write(getData1(), sheet, writeTable);
            writer.finish();
        } catch (FileNotFoundException e) {
            throw e;
        }finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    private List<WriteModel1> getData1() {
        List<WriteModel1> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            WriteModel1 model1 = new WriteModel1();
            model1.setRemark("备注");
            model1.setName("mai" + i);
            model1.setAge(i);
            model1.setSex("男");
            model1.setMsg("MSG");
            data.add(model1);
        }

        WriteModel1 model1 = new WriteModel1();
        return data;
    }

    public List<WriteModel> getData() {
        List<WriteModel> data = new ArrayList<>();
        data.add(new WriteModel("mai", 23, "男"));
        data.add(new WriteModel("deng", 22, "男"));
        data.add(new WriteModel("lian", 20, null));
        return data;
    }



    public List<List<String>> getHeader() {
        List<List<String>> header = new ArrayList<>();
        HEADER1.forEach(head -> {
            header.add(Arrays.asList(head));
        });
        return header;
    }

    @Test
    public void test01() {
        WriteModel model = new WriteModel("mai", 23, "男");
        WriteModel model1 = new WriteModel("mai", 23, "男");
        System.out.println(model);
        System.out.println(model.equals(model1));
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class WriteModel {
    private String name;
    private int age;
    private String sex;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class WriteModel1 extends WriteModel{
    private String remark;
    private WriteModel model;
    private String msg;
}
