package spring.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import spring.domain.Member;

@Component
public class MemberDao2 extends MemberDao {

	public MemberDao2() {
		super();
		System.out.println("등록2~");
	}

}
