package com.app.pillars.repo;

import com.app.pillars.dto.UserDto;
import com.app.pillars.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUserName(String userName);

    Page<UserDto> findAllBy(Pageable pageable);

    UserDto findProjectionById(int id);

    User findByUserNameAndPassword(String userName,String password);


}
