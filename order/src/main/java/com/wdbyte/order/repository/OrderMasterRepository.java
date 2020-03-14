package com.wdbyte.order.repository;

import com.wdbyte.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *
 * @author niujinpeng
 * @Date 2020/3/11 8:27
 */
@Repository
public interface OrderMasterRepository  extends JpaRepository<OrderMaster,String> {

}
