package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.Cart;
import com.somfoot.mugpet.entity.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface WishRepository extends JpaRepository<Wish, Long> {

    //insert?

    //delete one item depends on user

    public void deleteWishByIdAndUser(@Param("itemId")long item_id, @Param("uId")long u_id);

    //select all item depends on user
    public Optional<Wish> findById(@Param("memberId")long member_id);
}
