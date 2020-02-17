package com.architecture.assignment.ecommercestore.mobileDevice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseMobileRepository extends JpaRepository<BaseMobileModel, Long>
{
	List<BaseMobileModel> getAllByManufacturer( MobileManufacturer manufacturer );

	List<BaseMobileModel> getAllByModelName( String modelName );

	List<BaseMobileModel> findByModelNameStartsWith( String name );
}
