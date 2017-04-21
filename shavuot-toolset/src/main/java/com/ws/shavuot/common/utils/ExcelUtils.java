package com.ws.shavuot.common.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lisong on 16/11/2.
 */
@SuppressWarnings("unchecked")
public class ExcelUtils<T> {

    public static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtils.class);

    public void exportExcel(String title, String[] headers,
                            List<T> dataset, OutputStream out, String pattern) {


        // 声明一个工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 生成一个表格
        HSSFSheet sheet = workbook.createSheet(title);
        // 设置表格默认列宽度为15个字节
        sheet.setDefaultColumnWidth((short) 15);
        // 生成一个样式
        HSSFCellStyle style = workbook.createCellStyle();
        // 设置这些样式
        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 生成一个字体
        HSSFFont font = workbook.createFont();
        font.setColor(HSSFColor.VIOLET.index);
        font.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式
        style.setFont(font);
        // 生成并设置另一个样式
        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
        style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
        style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 生成另一个字体
        HSSFFont font2 = workbook.createFont();
        font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式
        style2.setFont(font2);
        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0,
                0, 0, 0, (short) 4, 2, (short) 6, 5));
        // 设置注释内容
        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
        comment.setAuthor("leno");
        // 产生表格标题行
        HSSFRow row = sheet.createRow(0);
        for (short i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellStyle(style);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }
        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;//行数
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);

            T t = it.next();
            // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = t.getClass().getDeclaredFields();
            boolean change = false;
            for (short i = 0; i < fields.length; i++) {//列数

                if (i == 0) {
                    change = true;
                }

                HSSFCell cell = row.createCell(i);
                cell.setCellStyle(style2);
                Field field = fields[i];
                String fieldName = field.getName();
                String getMethodName = "get"
                        + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
                try {
                    Class tCls = t.getClass();
                    Method getMethod = tCls.getMethod(getMethodName,
                            new Class[]{});
                    Object value = null;
                    try {
                        value = getMethod.invoke(t, new Object[]{});
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    // 判断值的类型后进行强制类型转换
                    String textValue = null;
                    if (value == null) {
                        value = "";
                    } else if (value instanceof Boolean) {
                        boolean bValue = (Boolean) value;
                        textValue = "是";
                        if (!bValue) {
                            textValue = "不是";
                        }
                    } else if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                        textValue = sdf.format(date);
                    } else {
                        if (value instanceof byte[]) {
                            // 有图片时，设置行高为60px;
                            row.setHeightInPoints(60);
                            // 设置图片所在列宽度为80px,注意这里单位的一个换算
                            sheet.setColumnWidth(i, (short) (35.7 * 80));
                            // sheet.autoSizeColumn(i);
                            byte[] bsValue = (byte[]) value;
                            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0,
                                    1023, 255, (short) 6, index, (short) 6, index);
                            //    anchor.setAnchorType();
                            patriarch.createPicture(anchor, workbook.addPicture(
                                    bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
                        } else {
                            // 其它数据类型都当作字符串简单处理
                            textValue = value.toString();
                        }
                    }
                    // 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {

                        if (textValue.indexOf("toMerge") > -1) {

                            int count = Integer.valueOf(textValue.split("_")[1]) - 1;

                            LOGGER.info("-----count:{}", count);
                            //与上一行对应列的单元格合并
                            sheet.addMergedRegion(new CellRangeAddress(index - 1, index + count, i, i));
                            sheet.addMergedRegion(new CellRangeAddress(index - 1, index + count, i - 1, i - 1));
                            sheet.addMergedRegion(new CellRangeAddress(index - 1, index + count, i + 1, i + 1));
                            sheet.addMergedRegion(new CellRangeAddress(index - 1, index + count, i + 2, i + 2));
                            sheet.addMergedRegion(new CellRangeAddress(index - 1, index + count, i + 3, i + 3));
                            sheet.addMergedRegion(new CellRangeAddress(index - 1, index + count, i + 4, i + 4));
                            sheet.addMergedRegion(new CellRangeAddress(index - 1, index + count, i + 5, i + 5));
                            sheet.addMergedRegion(new CellRangeAddress(index - 1, index + count, i + 6, i + 6));
                            sheet.addMergedRegion(new CellRangeAddress(index - 1, index + count, i + 7, i + 7));
                            sheet.addMergedRegion(new CellRangeAddress(index - 1, index + count, i + 8, i + 8));
                            sheet.addMergedRegion(new CellRangeAddress(index - 1, index + count, i + 9, i + 9));
                            sheet.addMergedRegion(new CellRangeAddress(index - 1, index + count, i + 10, i + 10));
                            sheet.addMergedRegion(new CellRangeAddress(index - 1, index + count, i + 11, i + 11));
                            sheet.addMergedRegion(new CellRangeAddress(index - 1, index + count, i + 12, i + 12));
                            sheet.addMergedRegion(new CellRangeAddress(index - 1, index + count, i + 14, i + 14));
                            sheet.addMergedRegion(new CellRangeAddress(index - 1, index + count, i + 18, i + 18));
                            LOGGER.info("-------合并");
                            continue;
                        }

                        if (textValue.indexOf("colour_") > -1) { // 如果以colour_开始，则只设置该单元格的背景色
                            short backRoundColour = 0;
                            if (textValue.equals("colour_red")) {
                                backRoundColour = IndexedColors.RED.getIndex();
                            }
                            if (textValue.equals("colour_green")) {
                                backRoundColour = IndexedColors.BRIGHT_GREEN.getIndex();
                            }
                            style = workbook.createCellStyle();
                            style.setFillForegroundColor(backRoundColour);
                            style.setFillPattern(CellStyle.SOLID_FOREGROUND);
                            cell.setCellStyle(style);
                            continue;
                        }

                        Pattern p = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = p.matcher(textValue);

                        Boolean isNum = false; //data是否为数值型
                        Boolean isInteger = false; //data是否为整数
                        Boolean isPercent = false; //data是否为百分数
                        if (textValue != null || "".equals(textValue)) {
                            //判断data是否为数值型
                            isNum = textValue.toString().matches("^(-?\\d+)(\\.\\d+)?$");
                            //判断data是否为整数（小数部分是否为0）
                            isInteger = textValue.toString().matches("^[-\\+]?[\\d]*$");
                            //判断data是否为百分数（是否包含“%”）
                            isPercent = textValue.toString().contains("%");
                        }

                        //如果单元格内容是数值类型，涉及到金钱（金额、本、利），则设置cell的类型为数值型，设置data的类型为数值类型
                        if (isNum && !isPercent) {
                            HSSFCellStyle style3 = workbook.createCellStyle();
                            style3.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
                            style3.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                            style3.setBorderBottom(HSSFCellStyle.BORDER_THIN);
                            style3.setBorderLeft(HSSFCellStyle.BORDER_THIN);
                            style3.setBorderRight(HSSFCellStyle.BORDER_THIN);
                            style3.setBorderTop(HSSFCellStyle.BORDER_THIN);
                            style3.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                            style3.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
                            // 生成另一个字体
                            HSSFFont font3 = workbook.createFont();
                            font3.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
                            // 把字体应用到当前的样式
                            style3.setFont(font3);


                            HSSFDataFormat df = workbook.createDataFormat(); // 此处设置数据格式
                            if (isInteger) {
                                style3.setDataFormat(df.getBuiltinFormat("#,#0"));//数据格式只显示整数
                            } else {
                                style3.setDataFormat(df.getBuiltinFormat("#,##0.00"));//保留两位小数点
                            }
                            // 设置单元格格式
                            cell.setCellStyle(style3);
                            // 设置单元格内容为double类型
                            if (isInteger) {
                                cell.setCellValue(Integer.parseInt(textValue));
                            } else if (isNum && !isInteger) {
                                cell.setCellValue(Double.parseDouble(textValue.toString()));
                            }

                        } else {
                            HSSFRichTextString richString = new HSSFRichTextString(
                                    textValue);
                            HSSFFont font3 = workbook.createFont();
                            font3.setColor(HSSFColor.BLUE.index);
                            richString.applyFont(font3);
                            cell.setCellValue(richString);
                        }

                    }

                } catch (SecurityException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } finally {
                    // 清理资源
                }
            }
        }
        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
