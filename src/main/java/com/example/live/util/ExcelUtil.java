package com.example.live.util;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.metadata.Sheet;
import com.example.live.entity.Anchor;
import com.google.common.collect.Lists;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

/**
 * 读取excel文件
 *
 * @author baishuailei@zhejianglab.com
 * @date 2022/7/9 16:19
 */
public class ExcelUtil {

    public static void readExcelHandler() throws FileNotFoundException {
        String file1 = "C:\\Users\\htuser8\\Desktop\\用户id.xlsx";
        FileInputStream fis = new FileInputStream(file1);
        InputStream is = new BufferedInputStream(fis);
        ExcelListen<Anchor> readExcel = new ExcelListen<>();
        ExcelReader reader = EasyExcelFactory.getReader(is, readExcel);
        reader.read(new Sheet(1, 1, Anchor.class));
        List<Anchor> anchors = readExcel.list;
        List<String> ids = Lists.newArrayList();
        System.out.println("anchors:"+anchors.size());

    }
}
