package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		// -> applicationContext.xml을 로딩하여 Bean 정의를 읽고,
		// -> <bean>에 등록된 SamsungTV 객체를 생성 및 초기화한다.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup)한다.
		// -> 컨테이너에 미리 생성된 SamsungTV 객체를 반환받는다. (싱글톤)
		TV tv = (TV)factory.getBean("tv");
		TV tv2 = (TV)factory.getBean("tv");
		TV tv3 = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. Spring 컨테이너를 종료한다.
		// -> 생성된 Bean 객체들을 종료(destroy) 처리한다.
		factory.close();
	}

}
