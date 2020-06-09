package spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.AppCtx;
import spring.exception.MemberNotFoundException;
import spring.exception.WrongPasswordException;
import spring.service.ChangePasswordService;

public class MainForCPS {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
			new AnnotationConfigApplicationContext(AppCtx.class);

		ChangePasswordService cps =
			ctx.getBean("changePwdSvc", ChangePasswordService.class);

		try {
			cps.changePassword("madvirus@madvirus.net", "1234", "1111");
			System.out.println("암호를 변경했습니다.");
		} catch (MemberNotFoundException e) {
			System.out.println("회원 데이터가 올바르지 않습니다.");
		} catch (WrongPasswordException e) {
			System.out.println("회원 비밀번호가 올바르지 않습니다.");
		}

		ctx.close();
	}
}
