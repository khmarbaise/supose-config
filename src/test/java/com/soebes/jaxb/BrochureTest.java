package com.soebes.jaxb;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class BrochureTest {
	@XmlRootElement(name = "brochure")
	static class Brochure {
		@XmlJavaTypeAdapter(CourseListAdapter.class)
		@XmlElement(name = "courses")
		Map<String, Course> coursesByIdMap;
	}

	static class Course {
		@XmlAttribute
		String id;

		@XmlElement
		String name;

	}

	static class CourseListAdapter extends
			XmlAdapter<CoursesJaxbCrutch, Map<String, Course>> {
		public CoursesJaxbCrutch marshal(Map<String, Course> value) {
			CoursesJaxbCrutch courses = new CoursesJaxbCrutch();
			courses.courses = value.values().toArray(new Course[value.size()]);
			return courses;
		}

		public Map<String, Course> unmarshal(CoursesJaxbCrutch value) {
			Map<String, Course> r = new HashMap<String, Course>();
			for (Course c : value.courses)
				r.put(c.id, c);
			return r;
		}

	}

	private static class CoursesJaxbCrutch {
		@XmlElement(name = "course")
		private Course[] courses;
	}

	private static <T> String convertObjectToXml(Class<T> clazz, T instance) {
		try {
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Marshaller m = jc.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			StringWriter sw = new StringWriter();
			m.marshal(instance, sw);
			return sw.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private static <T> T convertXmlToObject(Class<T> clazz, String xml) {
		try {
			JAXBContext jc = JAXBContext.newInstance(clazz);
			Unmarshaller m = jc.createUnmarshaller();
			StringReader sr = new StringReader(xml);
			T instance = (T) m.unmarshal(sr);
			return instance;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void baseTest() {

		Brochure b = new Brochure();
		Course c = null;

		// 1st course
		c = new Course();
		c.id = "cs501";
		c.name = "Software Engineering";
		b.coursesByIdMap = new HashMap<String, Course>();
		b.coursesByIdMap.put(c.id, c);

		// 2nd course
		c = new Course();
		c.id = "cs519";
		c.name = "Network Security";
		b.coursesByIdMap.put(c.id, c);

		Brochure source = b;
		String sourceDisplay = getDisplay(source);
		String xml = convertObjectToXml(Brochure.class, b);
		System.out.println(sourceDisplay);
		System.out.println(xml);

		Brochure restored = convertXmlToObject(Brochure.class, xml);
		String restoredDisplay = getDisplay(restored);
		System.out.println(restoredDisplay);

	}

	private static String getDisplay(Brochure b) {
		String nl = System.getProperty("line.separator");
		StringBuilder sb = new StringBuilder();
		sb.append(nl + "Brochure");
		for (Map.Entry<String, Course> entry : b.coursesByIdMap.entrySet()) {
			Course course = entry.getValue();
			sb.append(nl + "  coursesByIdMap.entry");
			sb.append(nl + "    key:   String(" + entry.getKey() + ")");
			sb.append(nl + "    value: Course(id=" + course.id + ", name="
					+ course.name + ")");
		}
		return sb.toString();
	}

}