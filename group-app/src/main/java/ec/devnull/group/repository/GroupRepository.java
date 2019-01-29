package ec.devnull.group.repository;

import ec.devnull.group.model.Group;

import java.util.List;

/**
 * @author Kleber Ayala
 */

public interface GroupRepository {

    Group add(Group group);

    List<Group> list();
}
