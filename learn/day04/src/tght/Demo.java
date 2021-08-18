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
			//����������
			SAXReader reader = new SAXReader();
			//��xml������Document����
			Document document = reader.read("students.xml");
			//ͨ��Document�����ȡ��Ԫ��
			Element rootElement = document.getRootElement();
			//ͨ����Ԫ�أ���ȡ���е���Ԫ��
			List<Element> elements = rootElement.elements();
			 for(Element element : elements ) {
				 //ͨ��attributeValue()��ȡ����ֵ
				 String id = element.attributeValue("id");
				 //ͨ��element Text()��ȡԪ�ص��ı�ֵ
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
