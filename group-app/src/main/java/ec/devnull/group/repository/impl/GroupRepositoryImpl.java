package ec.devnull.group.repository.impl;

import ec.devnull.group.model.Group;
import ec.devnull.group.repository.GroupRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Kleber Ayala
 */
@ApplicationScoped
public class GroupRepositoryImpl implements GroupRepository {


    @PersistenceContext(name = "GroupPU")
    private EntityManager entityManager;


    @Override
    @Transactional
    public Group add(Group group) {
        return entityManager.merge(group);
    }

    @Override
    public List<Group> list() {
        CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
        cq.select(cq.from(Group.class));
        List<Group> groups = entityManager.createQuery(cq).getResultList();
        return groups;
    }
}
