package spring1.core.repository;

import spring1.core.domain.member.Member;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);
}
