package spring.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.AppCtx;
import spring.domain.Member;
import spring.repository.MemberDao;

public class MainForMemberDao {

	private static MemberDao MEMBER_DAO;
	private static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("MMddHHmmss");

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
			new AnnotationConfigApplicationContext(AppCtx.class);

		MEMBER_DAO = ctx.getBean(MemberDao.class);

		selectAll();
		updateMember();
		insertMember();

		ctx.close();
	}

	private static void selectAll() {
		System.out.println("----- select All");
		int total = MEMBER_DAO.count();
		System.out.println("전체 데이터(건) : " + total);
		List<Member> members = MEMBER_DAO.selectAll();
		for (Member member : members) {
			System.out
				.println(member.getId() + " : " + member.getEmail() + " : " + member.getName());
		}
	}

	private static void updateMember() {
		System.out.println("----- updateMember");
		Member member = MEMBER_DAO.selectByEmail("madvirus@madvirus.net");
		String oldPw = member.getPassword();
		String newPw = Double.toHexString(Math.random());
		member.changePassword(oldPw, newPw);

		MEMBER_DAO.update(member);
		System.out.println("암호 변경 : " + oldPw + " > " + newPw);
	}

	private static void insertMember() {
		System.out.println("---- insertMember");

		String prefix = FORMATTER.format(LocalDateTime.now());
		Member member = new Member(prefix + "@test.com", prefix, prefix, LocalDateTime.now());
		MEMBER_DAO.insert(member);
		System.out.println(member.getId() + " 데이터 추가");
	}
}
