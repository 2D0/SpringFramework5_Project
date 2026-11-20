package myspring.di.annotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//전략2 (어노테이션 + XML 같이 사용하는 방식)
//Setter Injection
//- 변수 별로 각각 주입 받는 방식

//@Component 는 <bean></bean> 과 같다.
@Component
public class HelloBean {

	// @Value 는 <property name="name" value="어노테이션" />와 같다.
	@Value("${app.setter.name}")
	String name;

	// @Autowired 는 <property name="printer" ref="stringPrinter" /> 와 같다.
	@Autowired
	@Qualifier("stringPrinter")
	PrinterBean printer;
	List<String> names;

	public HelloBean() {
		System.out.println(this.getClass().getName() + " 기본생성자 호출됨!");
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
