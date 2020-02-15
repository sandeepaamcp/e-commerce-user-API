package com.architecture.assignment.ecommercestore.MobileDevice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileSpecificationRepository extends JpaRepository<MobileSpecification, Long>
{
}
