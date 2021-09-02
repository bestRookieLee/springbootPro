package com.li.springBootPro.util;
 
import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.MergeConstants;
import org.mybatis.generator.config.PropertyRegistry;
 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
 
import static org.mybatis.generator.internal.util.StringUtility.isTrue;
 
/**
 * @Description: 修改注释
 * @Author: 
 * @CreateDate: 2019/1/16 16:38
 */
public class MyCommentGenerator implements CommentGenerator {
 
    /**
     * properties配置文件
     */
    private Properties properties;
    /**
     * properties配置文件
     */
    private Properties systemPro;
    /*
     * 父类时间
     */
    private boolean suppressDate;
    /**
     * 父类所有注释
     */
    private boolean suppressAllComments;
    /**
     * 当前时间
     */
    private String currentDateStr;
 
    public MyCommentGenerator() {
        super();
        properties = new Properties();
        systemPro = System.getProperties();
        suppressDate = false;
        suppressAllComments = false;
        currentDateStr = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date());
    }
 
 
    /**
     * @Description: 此方法返回格式化的日期字符串以包含在Javadoc标记中和XML注释。
     * @Author: 
     * @CreateDate: 2019/1/16 16:58
     */
    protected String getDateString() {
        String result = null;
        if (!suppressDate) {
            result = currentDateStr;
        }
        return result;
    }
 
    /**
     * @Description: 从该配置中的任何属性添加此实例的属性CommentGenerator配置。
     * @Author: 
     * @CreateDate: 2019/1/16 16:55
     */
    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
        suppressDate = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
        suppressAllComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
    }
 
    /**
     * @Description: 为字段添加注释
     * @Author: 
     * @CreateDate: 2019/1/16 17:02
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        field.addJavaDocLine(sb.toString().replace("\n", " "));
        field.addJavaDocLine(" */");
    }
 
    /**
     * @Description: Java属性注释
     * @Author: 
     * @CreateDate: 2019/1/16 17:01
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        field.addJavaDocLine(sb.toString().replace("\n", " "));
        field.addJavaDocLine(" */");
    }
 
    /**
     * @Description: 为模型类添加注释
     * @Author: 
     * @CreateDate: 2019/1/16 17:06
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine("* @Description:");
        topLevelClass.addJavaDocLine("* @Author: lig");
        topLevelClass.addJavaDocLine("* @CreateDate: " + getDateString());
        topLevelClass.addJavaDocLine("*/");
    }
 
    /**
     * @Description: Java类的类注释
     * @Author: 
     * @CreateDate: 2019/1/16 16:52
     */
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        innerClass.addJavaDocLine("/**");
        innerClass.addJavaDocLine("* @Description:");
        innerClass.addJavaDocLine("* @Author: lig");
        innerClass.addJavaDocLine("* @CreateDate: " + getDateString());
        innerClass.addJavaDocLine("*/");
    }

    /**
     * @Description: 为类添加注释
     * @Author: 
     * @CreateDate: 2019/1/16 16:53
     */
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean b) {
        if (suppressAllComments) {
            return;
        }
        innerClass.addJavaDocLine("/**");
        innerClass.addJavaDocLine("* @Description:");
        innerClass.addJavaDocLine("* @Author: lig");
        innerClass.addJavaDocLine("* @CreateDate: " + getDateString());
        innerClass.addJavaDocLine("*/");
    }
 
    /**
     * @Description: 为枚举添加注释
     * @Author: 
     * @CreateDate: 2019/1/16 17:00
     */
    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        innerEnum.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        innerEnum.addJavaDocLine(sb.toString().replace("\n", " "));
        innerEnum.addJavaDocLine(" */");
    }
 
    /**
     * @Description: 给getter方法加注释
     * @Author: 
     * @CreateDate: 2019/1/16 17:04
     */
    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {}
 
    /**
     * @Description: 给setter方法加注释
     * @Author: 
     * @CreateDate: 2019/1/16 17:07
     */
    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {}
 
    /**
     * @Description: 普通方法的注释，这里主要是XXXMapper.java里面的接口方法的注释
     * @Author: 
     * @CreateDate: 2019/1/16 17:03
     */
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        method.addJavaDocLine("/**");
        method.addJavaDocLine(" * @Description: ");
        method.addJavaDocLine(" * @Author: lig");
        method.addJavaDocLine(" * @CreateDate: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        method.addJavaDocLine(" */");
    }
 
    /**
     * @Description: 给Java文件加注释，这个注释是在文件的顶部，也就是package上面。
     * @Author: 
     * @CreateDate: 2019/1/16 17:05
     */
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {}
 
    /**
     * @Description: Mybatis的Mapper.xml文件里面的注释
     * @Author: 
     * @CreateDate: 2019/1/16 16:54
     */
    @Override
    public void addComment(XmlElement xmlElement) {
        if (!this.suppressAllComments) {
            xmlElement.addElement(new TextElement("<!--"));
            StringBuilder sb = new StringBuilder();
            sb.append("description ");
            sb.append(" chf  ");
            String s = this.getDateString();
            if (s != null) {
                sb.append(s);
                xmlElement.addElement(new TextElement(sb.toString()));
            }
            xmlElement.addElement(new TextElement("-->"));
        }
    }
    
    /**
     * @Description: 此方法为其添加了自定义javadoc标签。
     * @Author: 
     * @CreateDate: 2019/1/16 16:59
     */
    protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete) {
        javaElement.addJavaDocLine(" *");
        StringBuilder sb = new StringBuilder();
        sb.append(" * ");
        sb.append(MergeConstants.NEW_ELEMENT_TAG);
        if (markAsDoNotDelete) {
            sb.append(" do_not_delete_during_merge");
        }
        String s = getDateString();
        if (s != null) {
            sb.append(' ');
            sb.append(s);
        }
        javaElement.addJavaDocLine(sb.toString());
    }
 
    /**
     * @Description: 为调用此方法作为根元素的第一个子节点添加注释。
     * @Author: 
     * @CreateDate: 2019/1/16 17:06
     */
    @Override
    public void addRootComment(XmlElement xmlElement) {}
 
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) { }
 
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) { }
 
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) { }
 
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) { }
 
    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) { }
 
}