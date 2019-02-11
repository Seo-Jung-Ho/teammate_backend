package allen.joy.jpademo.model.team;

import allen.joy.jpademo.utils.Builder;

public class TeamBuilder extends Builder<Team> {

    public TeamBuilder(String name) {
        super.model = new Team();
        super.model.setName(name);
    }

}
