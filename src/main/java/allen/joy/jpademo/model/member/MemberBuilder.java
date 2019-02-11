package allen.joy.jpademo.model.member;

import allen.joy.jpademo.model.team.Team;

public class MemberBuilder {

    private Member model;

    public MemberBuilder(String id, Team team) {
        this.model = new Member();
        this.model.setTeam(team);
        this.model.setId(id);
    }

    public MemberBuilder setName(String name){
        this.model.setName(name);
        return this;
    }

    public Member build(){
        return model;
    }

}
