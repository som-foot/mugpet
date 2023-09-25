package com.somfoot.mugpet.service.item;

import com.somfoot.mugpet.entity.ItemImg;
import com.somfoot.mugpet.repository.ItemImgRepository;
import com.somfoot.mugpet.service.file.FileService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class ItemImgServiceImpl implements ItemImgService{

    @Value("${itemImgLocation}")
    private String itemImgLocation;

    private ItemImgRepository itemImgRepository;
    private FileService fileService;

    @Override
    public void savedItemImg(ItemImg itemImg, MultipartFile itemImgFile) throws Exception {

        String oriFileName = itemImgFile.getOriginalFilename(); //원본파일명 가져오기
        String imgName = "";
        String imgUrl = "";

        if(!StringUtils.isEmpty(oriFileName)) {
            //사용자가 상품의 이미지를 등록했다면 저장할 경로와 원본 파일 이름,파일의 바이트 배열을 파일 업로드 파라미터로 uploadFile 메소드를 호출한다.
            //호출 결과 로컬에 저장된 파일의 이름을 imgName 변수에 저장한다.
            //저장할 이미지 파일 이름
            imgName = fileService.uploadFile(itemImgLocation, oriFileName, itemImgFile.getBytes());
            // 저장한 상품 이미지를 불러올 경로를 설정한다. 외부 리소스를 불러오는 urlPatterns로 WebMvxConfig 클래스에서 "/images/**"를 설정해줬다.
            // 또한 application.properties에서 설정한 uploadPath
            // 프로퍼티 경로인 "C:/shop//" 아래 item 폴더에 이미지를 저장하므로 상품 이미지를 불러오는 경로로 "/images/item/"를 붙여준다
            imgUrl = "/images/item/" + imgName;
        }

        //변경감지..
        itemImg.updateItemImg(oriFileName,imgName,imgUrl);

        itemImgRepository.save(itemImg);
        //DB 에 저장되고 식별자가 존재. itemImg 는 준영속 엔티티
    }

    @Override
    public void updateItemImg(Long itemImgId, MultipartFile itemImgFile) throws Exception {

        if(!itemImgFile.isEmpty()) {
            ItemImg savedItemImg = itemImgRepository.findById(itemImgId)
                    .orElseThrow(EntityNotFoundException::new);

            if (!StringUtils.isEmpty(savedItemImg.getImgName())) {
                fileService.deleteFile(itemImgLocation + "/images/item/" + savedItemImg.getImgName());
            }

            String oriImgFileName = itemImgFile.getOriginalFilename();
            String imgName = fileService.uploadFile(itemImgLocation,oriImgFileName,itemImgFile.getBytes());
            String imgUrl = "/images/item/" + imgName;

            savedItemImg.updateItemImg(oriImgFileName,imgName,imgUrl);
        }



    }


}
