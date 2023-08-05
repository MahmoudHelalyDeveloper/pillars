package com.app.pillars.spec;

import com.app.pillars.dto.UserDto;
import com.app.pillars.model.User;
import com.app.pillars.request.UserRequest;
import com.app.pillars.util.SearchCriteria;
import com.app.pillars.util.SearchOperation;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class UserSpec implements Specification<User> {


    private final SearchCriteria searchCriteria;

    public UserSpec(final SearchCriteria searchCriteria) {
        super();
        this.searchCriteria = searchCriteria;
    }

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        String strToSearch = searchCriteria.getValue().toString().toLowerCase();

        switch (Objects.requireNonNull(SearchOperation.getSimpleOperation(searchCriteria.getOperation()))) {
            case CONTAINS:

                return cb.like(cb.lower(root.get(searchCriteria.getFilterKey())), "%" + strToSearch + "%");

            case DOES_NOT_CONTAIN:
           
                return cb.notLike(cb.lower(root.get(searchCriteria.getFilterKey())), "%" + strToSearch + "%");

            case BEGINS_WITH:

                return cb.like(cb.lower(root.get(searchCriteria.getFilterKey())), strToSearch + "%");

            case DOES_NOT_BEGIN_WITH:

                return cb.notLike(cb.lower(root.get(searchCriteria.getFilterKey())), strToSearch + "%");

            case ENDS_WITH:

                return cb.like(cb.lower(root.get(searchCriteria.getFilterKey())), "%" + strToSearch);

            case DOES_NOT_END_WITH:

                return cb.notLike(cb.lower(root.get(searchCriteria.getFilterKey())), "%" + strToSearch);

            case EQUAL:

                return cb.equal(root.get(searchCriteria.getFilterKey()), searchCriteria.getValue());

            case NOT_EQUAL:

                return cb.notEqual(root.get(searchCriteria.getFilterKey()), searchCriteria.getValue());

            case NUL:
                return cb.isNull(root.get(searchCriteria.getFilterKey()));

            case NOT_NULL:
                return cb.isNotNull(root.get(searchCriteria.getFilterKey()));

            case GREATER_THAN:
                return cb.greaterThan(root.<String>get(searchCriteria.getFilterKey()), searchCriteria.getValue().toString());

            case GREATER_THAN_EQUAL:
                return cb.greaterThanOrEqualTo(root.<String>get(searchCriteria.getFilterKey()), searchCriteria.getValue().toString());

            case LESS_THAN:
                return cb.lessThan(root.<String>get(searchCriteria.getFilterKey()), searchCriteria.getValue().toString());

            case LESS_THAN_EQUAL:
                return cb.lessThanOrEqualTo(root.<String>get(searchCriteria.getFilterKey()), searchCriteria.getValue().toString());
        }
        return null;
    }
}