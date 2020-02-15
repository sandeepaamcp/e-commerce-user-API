package com.architecture.assignment.ecommercestore.registeredUser;

import com.architecture.assignment.ecommercestore.mobileDevice.MobileSpecification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFavMobilesRepository extends JpaRepository<UserFavMobiles, Long>
{
	List<UserFavMobiles> findAllByUser( User user );

	List<UserFavMobiles> findAllByMobileSpecification( MobileSpecification specification );

	UserFavMobiles findByUserAndMobileSpecification(User user, MobileSpecification specification);
}
