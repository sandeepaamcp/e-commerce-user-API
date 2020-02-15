package com.architecture.assignment.ecommercestore.partnerDealerShop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartnerDealerRepository extends JpaRepository<PartnerDealer, Long>
{
}
