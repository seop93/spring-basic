package spring1.core.service;

import spring1.core.domain.member.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
