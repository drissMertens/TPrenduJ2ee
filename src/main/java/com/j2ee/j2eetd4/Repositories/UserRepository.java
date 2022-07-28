package com.j2ee.j2eetd4.Repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.j2ee.j2eetd4.Model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {}
