package com.test.crack;


import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;
import com.aspose.words.License;
import com.aspose.words.Underline;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.io.FileInputStream;

public class Test {

    public static void main(String[] args) throws Exception {


        FileInputStream fileInputStream = new FileInputStream("..license.xml");
//////
        License license = new License();
        license.setLicense(fileInputStream);
//
//        System.out.println("");
//
////        crack();
        crack22_10_17Word();
//
//        try {
//            long old = System.currentTimeMillis();
//            FileOutputStream os = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\bd\\temp\\sign.docx");
//            com.aspose.pdf.Document doc = new com.aspose.pdf.Document("C:\\Users\\Administrator\\Desktop\\bd\\temp\\sign.pdf");//加载源文件数据
//            doc.save(os, com.aspose.pdf.SaveFormat.DocX);//设置转换文件类型并转换
//            os.close();
//            long now = System.currentTimeMillis();
//            System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");  //转化用时
//            doc.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        Document document = new Document("C:\\Users\\Administrator\\Desktop\\bd\\temp\\demo\\word\\aaa.docx");
//
//        DocumentBuilder builder = new DocumentBuilder(document);
//
//        builder.moveToBookmark("IsLocated");
//        builder.getFont().setUnderline(Underline.SINGLE);
//        builder.write("河南省");
//
//        builder.moveToBookmark("QuestionOneYes");
//        builder.getFont().setName("Wingdings 2");
//        builder.write("\u0052");
//
//
//        builder.moveToBookmark("QuestionOneNo");
//        builder.getFont().setName("Wingdings 2");
//        builder.write("\u00A3");
//
//        document.getRange().getBookmarks().clear();
//        document.save("aaa_1.docx");
    }

    public static void crack() {
        try {
            //这一步是完整的jar包路径,选择自己解压的jar目录
            ClassPool.getDefault().insertClassPath("D:\\resource\\jar\\pdf\\aspose.pdf-22.10.jar");
            //获取指定的class文件对象
            CtClass zzZJJClass = ClassPool.getDefault().getCtClass("com.aspose.pdf.l10n");
            //从class对象中解析获取所有方法
            CtMethod[] methodA = zzZJJClass.getDeclaredMethods();
            for (CtMethod ctMethod : methodA) {
                //获取方法获取参数类型
                CtClass[] ps = ctMethod.getParameterTypes();
                //筛选同名方法，入参是Document
                if (ps.length == 1 && ctMethod.getName().equals("lI") && ps[0].getName().equals("java.io.InputStream")) {
                    System.out.println("ps[0].getName==" + ps[0].getName());
                    //替换指定方法的方法体
                    ctMethod.setBody("{this.l0t = com.aspose.pdf.l10f.lf;com.aspose.pdf.internal.l132j.lf.lI();lI(this);lI = true;}");
                }
            }

            CtClass ctClass = ClassPool.getDefault().getCtClass("com.aspose.pdf.ADocument");
            //从class对象中解析获取所有方法
            CtMethod[] methodB = ctClass.getDeclaredMethods();
            for (CtMethod ctMethod : methodB) {
                //获取方法获取参数类型
                CtClass[] ps = ctMethod.getParameterTypes();
                //筛选同名方法，入参是Document
                if (ps.length == 0 && (ctMethod.getName().equals("lj") || ctMethod.getName().equals("lt")) ) {
                    ctMethod.setBody("{return true;}");
                }
                if (ps.length == 1 && (ctMethod.getName().equals("lI")) && ps[0].getName().equals("com.aspose.pdf.internal.l10h.l0if")) {
                    ctMethod.setBody("{return true;}");
                }
            }

            //这一步就是将破译完的代码放在桌面上
            zzZJJClass.writeFile("D:\\resource\\jar\\pdf\\crack\\");
            ctClass.writeFile("D:\\resource\\jar\\pdf\\crack\\");

        } catch (Exception e) {
            System.out.println("错误==" + e);
        }
    }

    public static void crack22_10_17Word() {
        try {
            //这一步是完整的jar包路径,选择自己解压的jar目录
            ClassPool.getDefault().insertClassPath("D:\\resource\\jar\\word\\aspose-words-22.10.0-jdk17.jar");
            //获取指定的class文件对象
            CtClass zzZJJClass = ClassPool.getDefault().getCtClass("com.aspose.words.zzYgO");
            //从class对象中解析获取指定的方法
            CtMethod[] methodA = zzZJJClass.getDeclaredMethods();
            //遍历重载的方法
            for (CtMethod ctMethod : methodA) {
                CtClass[] ps = ctMethod.getParameterTypes();
                if (ctMethod.getName().equals("zzWAh")) {
                    System.out.println("ps[0].getName==" + ps[0].getName());
                    //替换指定方法的方法体
                    ctMethod.setBody("{this.zzWn1 = new java.util.Date(Long.MAX_VALUE);this.zzWHy = com.aspose.words.zzZy.zzWrO;zzYRG = this;}");
                }
                if (ctMethod.getName().equals("zzWlB")) {
                    ctMethod.setBody("{if (zzW4H == 0L) {zzW4H ^= zzYHu;} return com.aspose.words.zzZy.zzWrO;}");
                }
                if (ctMethod.getName().equals("zzVXg")) {
                    ctMethod.setBody("{return com.aspose.words.zzZy.zzWrO;}");
                }
            }
            //这一步就是将破译完的代码放在桌面上
            zzZJJClass.writeFile("D:\\resource\\jar\\word\\crack\\");

            //获取指定的class文件对象
            CtClass zzZJJClassB = ClassPool.getDefault().getCtClass("com.aspose.words.zzZUi");
            //从class对象中解析获取指定的方法
            CtMethod methodB = zzZJJClassB.getDeclaredMethod("zzmf");
            //替换指定方法的方法体
            methodB.setBody("{return 256;}");
            //这一步就是将破译完的代码放在桌面上
            zzZJJClassB.writeFile("D:\\resource\\jar\\word\\crack\\");




        } catch (Exception e) {
            System.out.println("错误==" + e);
        }
    }
}
