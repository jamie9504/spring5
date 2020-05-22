package chap06;

import chap06.config.AppCtx;
import chap06.spring.Client;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

		Client client = ctx.getBean(Client.class);
		client.send();

		ctx.close();
	}
}
