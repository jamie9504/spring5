package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import spring.repository.MemberDao;
import spring.view.MemberPrinter;

@Configuration
@Import(AppCtx2.class)
public class AppCtxImport {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}

	@Bean
	public MemberPrinter memberPrint() {
		return new MemberPrinter();
	}
}
