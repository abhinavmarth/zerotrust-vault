package com.project.zerotrust.repository;

import com.project.zerotrust.model.ZeroTrustModel;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface ZeroTrustRepository extends JpaRepository<ZeroTrustModel, Long> {

    public ZeroTrustModel save(ZeroTrustModel zeroTrustModel);
    public List<ZeroTrustModel> findAll();
    public Optional<ZeroTrustModel> findById(Long id);
    public ZeroTrustModel findByUsername(String user);
    public ZeroTrustModel findByUsernameAndTitle(String user, String title);
    public Page<ZeroTrustModel> findByUserId(String userId, Pageable page);

}
