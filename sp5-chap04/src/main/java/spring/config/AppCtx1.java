package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.repository.MemberDao;
import spring.view.MemberPrinter;

//@Configuration
public class AppCtx1 {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

	@Bean
	public MemberPrinter memberPrint() {
		return new MemberPrinter();
	}
}
