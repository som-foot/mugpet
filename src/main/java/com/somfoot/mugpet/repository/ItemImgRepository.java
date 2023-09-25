package com.somfoot.mugpet.repository;

import com.somfoot.mugpet.entity.ItemImg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemImgRepository extends JpaRepository<ItemImg,Long> {
    List<ItemImg> findItemImgsById();
}
