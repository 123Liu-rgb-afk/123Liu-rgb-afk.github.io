import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * @author 刘瑞玺
 * @version 1.0
 */
public class Dom4j_ {
    //演示如何加载xml文件
    @Test
    public void loadXMl() throws DocumentException {
        //得到一个解析器
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new File("src/student.xml"));
        System.out.println(read);

    }
    //遍历所有的student信息
    @Test
    public void listStus() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new File("src/student.xml"));
        Element rootElement = read.getRootElement();
        List<Element> students = rootElement.elements("student");
        for (Element student : students) {
            Element name = student.element("name");
            System.out.println(name.getText());
        }
    }
    //得到某一个的student信息
    @Test
    public void listStu() throws DocumentException {
        //得到解析器
        SAXReader saxReader = new SAXReader();
        //得到document
        Document read = saxReader.read(new File("src/student.xml"));
        //得到根节点
        Element rootElement = read.getRootElement();
        List<Element> students = rootElement.elements("student");
        Element student1 = students.get(0);
        Element name = student1.element("name");
        System.out.println(name.getText());
        //得到某一个的student属性
        String s = student1.attributeValue("id");
        System.out.println(s);
        //一层一层来获得，直接一步到位可以采用xPath + Dom4J;
    }

    //增加节点
    @Test
    public void addElement() throws DocumentException, IOException {
        //得到解析器
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read(new File("src/student.xml"));
        Element rootElement = read.getRootElement();

        //先创建节点
        Element newStu = DocumentHelper.createElement("student");

        Element name = DocumentHelper.createElement("name");
        Element age = DocumentHelper.createElement("age");
        Element sex = DocumentHelper.createElement("sex");

        //给节点添加属性
        newStu.addAttribute("id","300");
        name.setText("张");
        age.setText("19");
        sex.setText("女");

        //把节点加到newStu下面
        newStu.add(name);
        newStu.add(age);
        newStu.add(sex);

        //把newStu加到根节点上
        rootElement.add(newStu);

        //直接输出会乱码
        OutputFormat prettyPrint = OutputFormat.createPrettyPrint();
        prettyPrint.setEncoding("utf-8");

        //把我们的xml文件更新
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(new File("src/student.xml")));
        xmlWriter.write(rootElement);
        xmlWriter.close();

    }
    //删除某一个的student信息
    @Test
    public void removeStu() throws DocumentException, IOException {
        //得到解析器
        SAXReader saxReader = new SAXReader();
        //得到document
        Document read = saxReader.read(new File("src/student.xml"));
        //得到根节点
        Element rootElement = read.getRootElement();
        List<Element> students = rootElement.elements("student");
        Element student1 = students.get(0);

        //删除节点，先得到其父节点，然后删除，自己不能删除自己
        student1.getParent().remove(student1);

        //直接输出会乱码
        OutputFormat prettyPrint = OutputFormat.createPrettyPrint();
        prettyPrint.setEncoding("utf-8");

        //把我们的xml文件更新
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(new File("src/student.xml")));
        xmlWriter.write(rootElement);
        xmlWriter.close();
    }


}
