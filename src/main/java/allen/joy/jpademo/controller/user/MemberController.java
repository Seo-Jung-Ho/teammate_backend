package allen.joy.jpademo.controller.user;

import allen.joy.jpademo.model.member.Member;
import allen.joy.jpademo.model.member.MemberJsonView;
import allen.joy.jpademo.service.MainService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("userMemberController")
@RequestMapping("/user/member")
//@PreAuthorize("hasRole('ROLE_USER')")
public class MemberController {

    @Autowired
    private MainService mainService;

    @GetMapping(value = "")
    @JsonView(MemberControllerJsonView.getTeamMate.class)
    public List<Member> getTeamMateList(
            @RequestParam String id // 원래는 세션에서 꺼내야 맞음!! 토큰에서 꺼내든지..
    ) {
        return mainService.getTeamMate(id);
    }

    @GetMapping(value = "/{id}")
    @JsonView(MemberControllerJsonView.getMemberList.class)
    public Member getMemberById(
            @PathVariable String id
    ) {
        return mainService.getMemberById(id);
    }
}

interface MemberControllerJsonView {

    public interface getMemberList extends MemberJsonView.Team {

    }

    public interface getTeamMate{

    }

}
