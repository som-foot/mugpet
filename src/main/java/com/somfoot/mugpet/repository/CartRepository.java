package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.Cart;
import com.somfoot.mugpet.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    //insert?

    //update one item depends on user
    @Query("update CartItem c set c.quantity = :qty where c.item_id = :itemId and c.u_id = :uId")
    public void updateItemQuantity(@Param("itemId") long item_id, @Param("uId")long u_id, @Param("qty")int quantity);

    //delete one item depends on user
    @Query("delete CartItem c where c.item_id = :itemId and c.u_id = :uId")
    public void deleteByIdAndUser(@Param("itemId")Long item_id, @Param("uId")long u_id);

    //delete all cartItems depends on user
    @Query("delete CartItem c where c.u_id = :uId")
    public void deleteAllByIdAndUser(@Param("uId")long u_id);

    //delete all cartItems
    @Override
    public void deleteAll();

    //select
    @Query("select * from CartItem where member_id = memberId")
    public Optional<CartItem> findByMemberId(@Param("memberId")long member_id);



}
