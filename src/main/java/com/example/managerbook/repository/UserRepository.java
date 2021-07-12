package com.example.managerbook.repository;

import com.example.managerbook.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
   UserEntity findUserByEmail(String email);
   List<UserEntity> findAllByPassword(String password);
   List<UserEntity> findAllByEmail(String email);
/*   List<UserEntity>  findAllByPhone_number(String phoneNumber);*/
   List<UserEntity>  findAllByEmailAndPassword(String email,String password);


}
