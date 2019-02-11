package allen.joy.jpademo.service;

import allen.joy.jpademo.model.member.Member;
import allen.joy.jpademo.model.member.MemberBuilder;
import allen.joy.jpademo.model.team.Team;
import allen.joy.jpademo.model.team.TeamBuilder;
import allen.joy.jpademo.repository.MemberRepository;
import allen.joy.jpademo.repository.TeamRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MainService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Transactional(readOnly = true)
    public List<Member> getTeamMate(String id){
        return memberRepository.findByTeam_MemberList_Id(id);
    }

    @Transactional(readOnly = true)
    public List<Team> getTeamList(){
        return teamRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Member getMemberById(String id){
        return memberRepository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Member> getMemberList(int teamSeq, String searchText){
        return memberRepository.getByMemberList(teamSeq, searchText);
    }

    @Transactional
    public void addMember(String id, String name, int teamSeq){
        Member newMember = new MemberBuilder(id, teamRepository.findById(teamSeq).get())
                .setName(name)
                .build();
        memberRepository.save(newMember);
    }

    @Transactional
    public void updateMember(String id, String name, int teamSeq){
        Member existingMember = memberRepository.findById(id).get();
        if(existingMember != null){
            existingMember.setName(name);
            existingMember.setTeam(teamRepository.findById(teamSeq).get());
        }
    }

    @Transactional
    public void removeMember(String id){
        memberRepository.deleteById(id);
    }

    @Transactional
    public void addTeam(String name){
        Team newTeam = new TeamBuilder(name)
                .build();
        teamRepository.save(newTeam);
    }

    @Transactional
    public void updateTeam(int seq, String name){
        Team existingTeam = teamRepository.findById(seq).get();
        existingTeam.setName(name);
    }

    @Transactional
    public void updateMember(String id, String name){
        Member updatingMember = memberRepository.findById(id).get();
        updatingMember.setName(name);
    }
}
