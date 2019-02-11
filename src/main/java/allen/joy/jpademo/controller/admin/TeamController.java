package allen.joy.jpademo.controller.admin;

import allen.joy.jpademo.model.team.Team;
import allen.joy.jpademo.model.team.TeamJsonView;
import allen.joy.jpademo.service.MainService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/team")
public class TeamController {

    @Autowired
    private MainService mainService;

    @GetMapping(value = "")
    @JsonView(TeamControllerJsonView.getTeamList.class)
    public List<Team> getTeamList() {
        return mainService.getTeamList();
    }

    @PostMapping(value = "")
    public void addTeam(
            @RequestParam String name
    ) {
        mainService.addTeam(name);
    }

    @PatchMapping(value = "/{seq}")
    public void updateTeam(
            @PathVariable int seq,
            @RequestParam String name
    ){
        mainService.updateTeam(seq, name);
    }


}

interface TeamControllerJsonView{
    public interface getTeamList {
    }
}