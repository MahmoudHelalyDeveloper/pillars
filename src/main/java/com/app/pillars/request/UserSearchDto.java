package com.app.pillars.request;

import com.app.pillars.util.SearchCriteria;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSearchDto {

    private List<SearchCriteria> searchCriteriaList;
    private String dataOption;
}
