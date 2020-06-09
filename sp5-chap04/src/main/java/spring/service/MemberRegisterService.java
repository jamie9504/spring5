package spring.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import spring.domain.Member;
import spring.dto.RegisterRequest;
import spring.exception.DuplicateMemberException;
import spring.repository.MemberDao;

public class MemberRegisterService {

	@Autowired
	private MemberDao memberDao;

	public MemberRegisterService() {
	}

	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(
			req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
