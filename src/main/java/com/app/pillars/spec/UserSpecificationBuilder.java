package com.app.pillars.spec;

import com.app.pillars.model.User;
import com.app.pillars.util.SearchCriteria;
import com.app.pillars.util.SearchOperation;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class UserSpecificationBuilder {


    private final List<SearchCriteria> params;

    public UserSpecificationBuilder(){
        this.params = new ArrayList<>();
    }

    public final UserSpecificationBuilder with(String key, String operation, Object value){
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public final UserSpecificationBuilder with(SearchCriteria searchCriteria){
        params.add(searchCriteria);
        return this;
    }

    public Specification<User> build(){
        if(params.size() == 0){
            return null;
        }

        Specification<User> result = new UserSpec(params.get(0));
        for (int idx = 1; idx < params.size(); idx++){
            SearchCriteria criteria = params.get(idx);
            result = SearchOperation.getDataOption(criteria.getDataOption()) == SearchOperation.ALL
                    ? Specification.where(result).and(new UserSpec(criteria))
                    : Specification.where(result).or(new UserSpec(criteria));
        }

        return result;
    }
}
