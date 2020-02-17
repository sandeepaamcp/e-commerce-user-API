package com.architecture.assignment.ecommercestore.mobileDevice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileSpecificationRepository extends JpaRepository<MobileSpecification, Long>
{
}
