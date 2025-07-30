package com.project.zerotrust.service;

import com.project.zerotrust.model.ZeroTrustModel;
import com.project.zerotrust.repository.ZeroTrustRepository;
import com.project.zerotrust.util.ZeroTrustAES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ZeroTrustService {
    @Autowired
    private ZeroTrustRepository zeroTrustRepository;

    public ZeroTrustModel create(ZeroTrustModel zeroTrustModel, String uid){
        try {
            String encrypted = ZeroTrustAES.encrypt(zeroTrustModel.getPassword());
            zeroTrustModel.setPassword(encrypted);
            zeroTrustModel.setUserId(uid); // Set UID from Firebase
            zeroTrustModel.setCreatedAt(System.currentTimeMillis());
            zeroTrustModel.setUpdatedAt(System.currentTimeMillis());
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return zeroTrustRepository.save(zeroTrustModel);
    }

    public ZeroTrustModel getbyId(Long id){
        return zeroTrustRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vault entry not found"));
    }


    public List<ZeroTrustModel> getAll(){
        //return zeroTrustRepository.findAll();
        List<ZeroTrustModel> list = zeroTrustRepository.findAll();
        for (ZeroTrustModel item : list) {
            try {
                String decrypted = ZeroTrustAES.decrypt(item.getPassword());
                item.setPassword(decrypted);
            } catch (Exception e) {
                item.setPassword("ERROR");
            }
        }
        return list;
    }

    public ZeroTrustModel getbyUser(String user){
        return zeroTrustRepository.findByUsername(user);
    }

    public ZeroTrustModel getbyuserandtitle(String user,String title){
        return zeroTrustRepository.findByUsernameAndTitle(user, title);
    }

    public List<ZeroTrustModel> findByuseriId(String userId){
        return zeroTrustRepository.findByUserId(userId);
    }
}

