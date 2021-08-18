package tght;

import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import org.dom4j.Document;
import bean.Student;




public class Demo {
	public static void main(String[] args) {
		
		try {
			//创建解析器
			SAXReader reader = new SAXReader();
			//将xml解析成Document对象
			Document document = reader.read("students.xml");
			//通过Document对象获取根元素
			Element rootElement = document.getRootElement();
			//通过根元素，获取所有的子元素
			List<Element> elements = rootElement.elements();
			 for(Element element : elements ) {
				 //通过attributeValue()获取属性值
				 String id = element.attributeValue("id");
				 //通过element Text()获取元素的文本值
				 String name = element.elementText("name");
				 String age = element.elementText("age");
				 System.out.println(id+"name:"+name+"	age:"+age);
				 
				 Student student  = new Student(id,name,age);
				 System.out.println(student);
			 }
		} catch (DocumentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
