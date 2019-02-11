package allen.joy.jpademo.model.member;

import allen.joy.jpademo.model.team.Team;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "member")
public class Member {

    @Id
    @Column(length = 20)
    private String id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "team")
    @JsonView(MemberJsonView.Team.class)
    private Team team;


}
