package allen.joy.jpademo.controller.admin;

import allen.joy.jpademo.model.member.Member;
import allen.joy.jpademo.model.member.MemberJsonView;
import allen.joy.jpademo.model.team.TeamJsonView;
import allen.joy.jpademo.service.MainService;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("adminMemberController")
@RequestMapping("/admin/member")
public class MemberController {

    @Autowired
    private MainService mainService;

    @GetMapping(value = "")
    @JsonView(MemberControllerJsonView.getMemberList.class)
    public List<Member> getMemberList(
            @RequestParam(required = false, defaultValue = "0") int teamSeq,
            @RequestParam(required = false, defaultValue = "") String searchText
    ) {
        return mainService.getMemberList(teamSeq, searchText);
    }

    @PostMapping(value = "")
    public void addMember(
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam int teamSeq
    ) {
        mainService.addMember(id, name, teamSeq);
    }

    @GetMapping(value = "/{id}")
    @JsonView(MemberControllerJsonView.getMember.class)
    public Member getMember(
            @PathVariable String id
    ) {
        return mainService.getMemberById(id);
    }

    @PatchMapping(value = "/{id}")
    public void updateMember(
            @PathVariable String id,
            @RequestParam String name,
            @RequestParam int teamSeq
    ){
        mainService.updateMember(id, name, teamSeq);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteMember(@PathVariable String id){
        mainService.removeMember(id);
    }


}

interface MemberControllerJsonView {
    interface getMemberList extends MemberJsonView.Team {

    }

    interface getMember extends MemberJsonView.Team {

    }
}