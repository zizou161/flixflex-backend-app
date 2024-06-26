package com.factorydigital.flixflex.userProfile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserProfileRepository extends PagingAndSortingRepository<UserProfile, Long>, CrudRepository<UserProfile, Long> {
}
