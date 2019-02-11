package allen.joy.jpademo.repository;

import allen.joy.jpademo.model.member.Member;
import allen.joy.jpademo.model.team.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    List<Member> findByTeam_MemberList_Id(String id);

    @Query("select m from Member m " +
            "where 1=1 " +
            "and (:searchText = '' or (m.id like concat('%', :searchText,'%') or m.name like concat('%', :searchText,'%'))) " +
            "and (:teamSeq = 0 or (m.team.seq = :teamSeq))")
    List<Member> getByMemberList(@Param("teamSeq") int teamSeq, @Param("searchText") String searchText);

}
