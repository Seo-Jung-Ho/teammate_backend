package allen.joy.jpademo.model.team;

import allen.joy.jpademo.model.member.Member;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "team")
public class Team {

    @Id @GeneratedValue
    private int seq;
    private String name;

    @OneToMany
    @JoinColumn(name = "team")
    @JsonView(TeamJsonView.MemberList.class)
    private List<Member> memberList;

}
